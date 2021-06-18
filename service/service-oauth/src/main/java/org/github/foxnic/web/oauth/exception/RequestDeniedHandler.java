package org.github.foxnic.web.oauth.exception;

import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;

import org.github.foxnic.web.oauth.utils.ResponseUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求访问被拒绝时的处理逻辑
 * @author 李方捷
 * @since  2021-06-02
 */
@Component
public class RequestDeniedHandler implements AccessDeniedHandler {
    
	@Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		ResponseUtil.writeOK(response, ErrorDesc.failure(CommonError.PERMISSION_REQUIRED));
    }
	
}
