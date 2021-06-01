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

import org.github.foxnic.web.domain.oauth.LoginIdentityVO;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.GenericFilterBean;

import com.github.foxnic.springboot.mvc.RequestParameter;

/**
 * 预登录控过滤器，接收JSON参数，并作为后续过滤器的验证参数
 *
 * @author Felordcn
 * @since 16 :21 2019/10/17
 */
public class PreLoginFilter extends GenericFilterBean {
 
    private RequestMatcher authenticationRequestMatcher;
    
//    private Map<LoginTypeEnum, LoginPostProcessor> processors = new HashMap<>();


    public PreLoginFilter(String loginProcessingUrl) {
    	//
        authenticationRequestMatcher = new AntPathRequestMatcher(loginProcessingUrl, "POST");
        //
//        LoginPostProcessor loginPostProcessor = defaultLoginPostProcessor();
//        processors.put(loginPostProcessor.getLoginTypeEnum(), loginPostProcessor);

//        if (!CollectionUtils.isEmpty(loginPostProcessors)) {
//            loginPostProcessors.forEach(element -> processors.put(element.getLoginTypeEnum(), element));
//        }

    }


//    private LoginTypeEnum getLoginTypeFromRequest(RequestParameter parameter) {
//        if(parameter.isPostByJson()) {
//        	return LoginTypeEnum.JSON;
//        } else {
//        	return LoginTypeEnum.FORM;
//        }
//    }


//    /**
//     * @return the login post processor
//     */
//    private LoginPostProcessor defaultLoginPostProcessor() {
//        return new LoginPostProcessor() {
//            @Override
//            public LoginTypeEnum getLoginTypeEnum() {
//                return LoginTypeEnum.FORM;
//            }
//
//            @Override
//            public String obtainUsername(ServletRequest request) {
//                return request.getParameter(SPRING_SECURITY_FORM_USERNAME_KEY);
//            }
//
//            @Override
//            public String obtainPassword(ServletRequest request) {
//                return request.getParameter(SPRING_SECURITY_FORM_PASSWORD_KEY);
//            }
//        };
//    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
    	RequestParameter parameter=RequestParameter.get();
    	HttpServletRequestWrapper wrapper = parameter.getRequestWrapper();
 
    	if (authenticationRequestMatcher.matches((HttpServletRequest) request)) {

//            LoginTypeEnum typeFromReq = getLoginTypeFromRequest(parameter);

//            LoginPostProcessor loginPostProcessor = processors.get(typeFromReq);


            LoginIdentityVO identity=parameter.toPojo(LoginIdentityVO.class);
//            String username = loginPostProcessor.obtainUsername(request);

//            String password = loginPostProcessor.obtainPassword(request);


            wrapper.setAttribute(SPRING_SECURITY_FORM_USERNAME_KEY, identity.getIdentity());
            wrapper.setAttribute(SPRING_SECURITY_FORM_PASSWORD_KEY, identity.getPasswd());
            
        }

        chain.doFilter(wrapper, response);


    }
}
