package org.github.foxnic.web.oauth.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.domain.oauth.LoginIdentityVO;
import org.github.foxnic.web.oauth.login.AdminAuthenticationFailureHandler;
import org.github.foxnic.web.oauth.login.AdminAuthenticationSuccessHandler;
import org.github.foxnic.web.oauth.login.CusAuthenticationManager;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.github.foxnic.springboot.mvc.RequestParameter;
 

/**
 * <p> 自定义用户密码校验过滤器 </p>
 *
 * @author : zhengqing
 * @description :
 * @date : 2019/10/12 15:32
 */
@Component
public class AdminAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * @param authenticationManager:             认证管理器
     * @param adminAuthenticationSuccessHandler: 认证成功处理
     * @param adminAuthenticationFailureHandler: 认证失败处理
     */
    public AdminAuthenticationProcessingFilter(CusAuthenticationManager authenticationManager, AdminAuthenticationSuccessHandler adminAuthenticationSuccessHandler, AdminAuthenticationFailureHandler adminAuthenticationFailureHandler) {
        super(new AntPathRequestMatcher(UserServiceProxy.LOGIN_URI, "POST"));
        this.setAuthenticationManager(authenticationManager);
        this.setAuthenticationSuccessHandler(adminAuthenticationSuccessHandler);
        this.setAuthenticationFailureHandler(adminAuthenticationFailureHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    	//获得请求参数
    	RequestParameter param=RequestParameter.get();
    	//转VO
    	LoginIdentityVO loginIdentity = param.toPojo(LoginIdentityVO.class);
        UsernamePasswordAuthenticationToken authRequest;
        try {
        	//设置验证信息
            authRequest = new UsernamePasswordAuthenticationToken(loginIdentity.getIdentity(), loginIdentity.getPasswd(), null);
            authRequest.setDetails(authenticationDetailsSource.buildDetails(param.getRequestWrapper()));
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage());
        }
        //
        Authentication auth = null;
		try {
			auth = this.getAuthenticationManager().authenticate(authRequest);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
        return auth;
    }

}
