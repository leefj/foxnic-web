package org.github.foxnic.web.oauth.login;

import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.proxy.InvokeSource;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.springboot.web.WebContext;
import org.apache.commons.lang3.StringUtils;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.system.LoginType;
import org.github.foxnic.web.constants.enums.system.YesNo;
import org.github.foxnic.web.domain.oauth.LoginIdentityVO;
import org.github.foxnic.web.oauth.service.ICaptchaService;
import org.github.foxnic.web.oauth.utils.ResponseUtil;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY;
import static org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;

/**
 * 预登录控过滤器，接收JSON参数，并作为后续过滤器的验证参数
 *
 * @author 李方捷
 * @since  2021-06-02
 */
public class PreLoginFilter extends GenericFilterBean {

    private RequestMatcher authenticationRequestMatcher;

    private ICaptchaService captchaService;

    private WebContext webContext;

    public PreLoginFilter(String loginProcessingUrl) {
        authenticationRequestMatcher = new AntPathRequestMatcher(loginProcessingUrl, "POST");
        captchaService=SpringUtil.getBean(ICaptchaService.class);
        webContext=SpringUtil.getBean(WebContext.class);
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	RequestParameter parameter=RequestParameter.get();
    	HttpServletRequestWrapper wrapper = parameter.getRequestWrapper();

        // 检查接口禁用
        Boolean forbidden=webContext.isForbidden((HttpServletRequest)request);
        if(forbidden) {
            ResponseUtil.writeOK((HttpServletResponse)response, ErrorDesc.failure(CommonError.FUNCTION_FORBIDDEN).message("接口已禁用，请联系开发人员开通接口"));
            return;
        }

        LoginIdentityVO identity=parameter.toPojo(LoginIdentityVO.class);
        if(identity.getLoginTypeEnum()==null) {
            identity.setLoginTypeEnum(LoginType.IDENTITY_PWD_IMG_CAPTCHA);
        }

        // 如果匹配登录地址，那么登录
    	if (authenticationRequestMatcher.matches((HttpServletRequest) request)) {

            // 帐号密码登录
            if (identity.getLoginTypeEnum() == LoginType.IDENTITY_PWD) {
                // 不处理
                wrapper.setAttribute(SPRING_SECURITY_FORM_USERNAME_KEY, identity.getIdentity());
                wrapper.setAttribute(SPRING_SECURITY_FORM_PASSWORD_KEY, identity.getPasswd());
            }
            // 帐号密码+图形验证码的登录方式
            else if (identity.getLoginTypeEnum() == LoginType.IDENTITY_PWD_IMG_CAPTCHA) {

                if(!validateCaptcha(identity,response)) {
                    return;
                }
                wrapper.setAttribute(SPRING_SECURITY_FORM_USERNAME_KEY, identity.getIdentity());
                wrapper.setAttribute(SPRING_SECURITY_FORM_PASSWORD_KEY, identity.getPasswd());
            }



        }

        chain.doFilter(wrapper, response);


    }

    private boolean validateCaptcha(LoginIdentityVO identity,ServletResponse response)  throws IOException {

        if (StringUtil.isBlank(identity.getCaptcha())) {
            ResponseUtil.writeOK((HttpServletResponse) response, ErrorDesc.failure(CommonError.CAPTCHA_INVALID).message("验证码未填写"));
            return false;
        }

        // 增加 browserId 为空判断，防止请求参数中未传该字段导致直接绕过图形验证码验证的问题
        if (StringUtils.isEmpty(identity.getBrowserId())) {
            ResponseUtil.writeOK((HttpServletResponse) response, ErrorDesc.failure(CommonError.CAPTCHA_INVALID).message("缺少 browserId"));
            return false;
        }


        //是否允许任意图形验证码验证码
        YesNo allowAny = SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_LOGIN_CAPTCHA_ANY, YesNo.class);
        // 如果不允许任意验证码 , 则校验验证码
        if (allowAny == YesNo.no) {
            String captcha = captchaService.getImageCaptcha(identity.getBrowserId());
            if (captcha == null) {
                ResponseUtil.writeOK((HttpServletResponse) response, ErrorDesc.failure(CommonError.CAPTCHA_INVALID).message("验证码已失效"));
                return false;
            }
            // 比较验证码
            if (!captcha.equalsIgnoreCase(identity.getCaptcha())) {
                ResponseUtil.writeOK((HttpServletResponse) response, ErrorDesc.failure(CommonError.CAPTCHA_INVALID).message("验证码错误"));
                return false;
            }
        }

        return true;

    }


}
