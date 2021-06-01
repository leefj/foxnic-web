package org.github.foxnic.web.oauth.controller;

 
import javax.annotation.Resource;

import org.github.foxnic.web.oauth.config.user.SessionUser;
import org.github.foxnic.web.oauth.service.IUserService;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.springboot.web.ResponseUtils;

/**
 * LoginController
 *
 * @author Felordcn
 * @since 10 :05 2019/10/17
 */
 
@RestController
@RequestMapping
public class SecurityController {
 
	
	public static final String SUCCESS_URL="/security/login/success";
	
	public static final String FAILURE_URL="/security/login/failure";
    /**
     * 登录失败返回 401 以及提示信息.
     *
     * @return the rest
     */
    @PostMapping(FAILURE_URL)
    public Result loginFailure() {
    	Result result = ErrorDesc.failure(CommonError.USER_BLOCKED);
//        if (e instanceof UsernameNotFoundException) {
//        	 result = ErrorDesc.failure(CommonError.USER_NOT_EXISTS);
//        } else if (e instanceof BadCredentialsException) {
//        	 result = ErrorDesc.failure(CommonError.PASSWORD_INVALID);
//        } else if (e instanceof LockedException) {
//            result = ErrorDesc.failure(CommonError.USER_BLOCKED);
//        } else if (e instanceof CredentialsExpiredException) {
//            result = ErrorDesc.failure(CommonError.CREDENTIALS_EXPIRED);
//        } else if (e instanceof AccountExpiredException) {
//            result = ErrorDesc.failure(CommonError.USER_EXPIRED);
//        } else if (e instanceof DisabledException) {
//        	result = ErrorDesc.failure(CommonError.USER_DISABLED);
//        } else {
//            Logger.error("登录失败：", e);
//            result = ErrorDesc.failureMessage("登录失败!");
//        }
        return result;
    }

    /**
     * 登录成功后拿到个人信息.
     *
     * @return the rest
     */
    @PostMapping(SUCCESS_URL)
    public Result loginSuccess() {
        SessionUser principal = (SessionUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return  ErrorDesc.success().data(principal.getUser());
    }
}
