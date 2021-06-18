package org.github.foxnic.web.oauth.login;

import static org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY;
import static org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.domain.oauth.LoginIdentityVO;
import org.github.foxnic.web.oauth.service.ICaptchaService;
import org.github.foxnic.web.oauth.utils.ResponseUtil;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.GenericFilterBean;

import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.spring.SpringUtil;

/**
 * 预登录控过滤器，接收JSON参数，并作为后续过滤器的验证参数
 *
 * @author 李方捷
 * @since  2021-06-02
 */
public class PreLoginFilter extends GenericFilterBean {
 
    private RequestMatcher authenticationRequestMatcher;
    
    private ICaptchaService captchaService;

    public PreLoginFilter(String loginProcessingUrl) {
        authenticationRequestMatcher = new AntPathRequestMatcher(loginProcessingUrl, "POST");
        captchaService=SpringUtil.getBean(ICaptchaService.class);
    }
 
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
    	RequestParameter parameter=RequestParameter.get();
    	HttpServletRequestWrapper wrapper = parameter.getRequestWrapper();
 
    	if (authenticationRequestMatcher.matches((HttpServletRequest) request)) {
 
            LoginIdentityVO identity=parameter.toPojo(LoginIdentityVO.class);
            
            //处理图片验证码
            if(identity.getBrowserId()!=null) {
            	String captcha=captchaService.getImageCaptcha(identity.getBrowserId());
            	if(captcha==null) {
            		ResponseUtil.writeOK((HttpServletResponse)response, ErrorDesc.failure(CommonError.CAPTCHA_INVALID).message("验证码已失效"));
            		return;
            	} else {
            		if(identity.getCaptcha()==null) {
//            		if(!captcha.equalsIgnoreCase(identity.getCaptcha())) {
            			ResponseUtil.writeOK((HttpServletResponse)response, ErrorDesc.failure(CommonError.CAPTCHA_INVALID).message("验证码错误"));
            			return;
            		}
            	}
            }
 
            wrapper.setAttribute(SPRING_SECURITY_FORM_USERNAME_KEY, identity.getIdentity());
            wrapper.setAttribute(SPRING_SECURITY_FORM_PASSWORD_KEY, identity.getPasswd());
            
            
        }

        chain.doFilter(wrapper, response);


    }
}
