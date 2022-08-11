package org.github.foxnic.web.oauth.captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.constants.enums.system.LoginType;
import org.github.foxnic.web.domain.oauth.LoginIdentityVO;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.github.foxnic.springboot.mvc.RequestParameter;

public class CaptchaAuthenticationFilter extends AbstractAuthenticationProcessingFilter {



    public CaptchaAuthenticationFilter() {
        super(new AntPathRequestMatcher(UserServiceProxy.LOGIN_BY_CAPTCHA_URI, "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        RequestParameter parameter=RequestParameter.get();
        LoginIdentityVO identity=parameter.toPojo(LoginIdentityVO.class);
        if(identity.getLoginTypeEnum()==null) {
            identity.setLoginTypeEnum(LoginType.IDENTITY_TEXT_CAPTCHA);
        }

        CaptchaAuthenticationToken authRequest = new CaptchaAuthenticationToken(identity.getIdentity(), identity.getCaptcha());
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);

    }


    protected void setDetails(HttpServletRequest request, CaptchaAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

}
