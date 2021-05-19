package com.scientific.tailoring.framework.security.permission;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.scientific.tailoring.framework.security.service.ISecurityService;

@Component
@WebFilter(filterName = "SecurityFilter",urlPatterns = "*")
public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//String uri=((HttpServletRequest)request).getRequestURI();
		//Logger.info(uri);
		chain.doFilter(request, response);
		
		ISecurityService securityService=SpringUtil.getBean(ISecurityService.class);
		securityService.lifeMore();
	}

}
