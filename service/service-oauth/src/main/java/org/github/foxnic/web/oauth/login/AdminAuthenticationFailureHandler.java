package org.github.foxnic.web.oauth.login;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.oauth.utils.ResponseUtils;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;

/**
 *  <p> 认证失败处理 - 前后端分离情况下返回json数据格式 </p>
 *
 * @description :
 * @author : zhengqing
 * @date : 2019/10/12 15:33
 */
@Component
public class AdminAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        Result result;
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            result = ErrorDesc.failureMessage(e.getMessage());
        } else if (e instanceof LockedException) {
            result = ErrorDesc.failureMessage("账户被锁定，请联系管理员!");
        } else if (e instanceof CredentialsExpiredException) {
            result = ErrorDesc.failureMessage("证书过期，请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            result = ErrorDesc.failureMessage("账户过期，请联系管理员!");
        } else if (e instanceof DisabledException) {
            result = ErrorDesc.failureMessage("账户被禁用，请联系管理员!");
        } else {
            Logger.error("登录失败：", e);
            result = ErrorDesc.failureMessage("登录失败!");
        }
        ResponseUtils.out(response, result);
    }

}
