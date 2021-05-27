package org.github.foxnic.web.oauth.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.oauth.utils.ResponseUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.api.error.ErrorDesc;
 

/**
 *  <p> 认证权限入口 - 未登录的情况下访问所有接口都会拦截到此 </p>
 *
 * @description : 前后端分离情况下返回json格式数据
 * @author : zhengqing
 * @date : 2019/10/11 17:32
 */
@Component
public class AdminAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        Logger.error(e.getMessage());
        ResponseUtils.out(response,  ErrorDesc.failureMessage("未登录！！！"));
    }

}
