package org.github.foxnic.web.oauth.login;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;
import org.github.foxnic.web.domain.oauth.SessionOnline;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.oauth.config.security.SecurityProperties;
import org.github.foxnic.web.oauth.config.security.SecurityProperties.SecurityMode;
import org.github.foxnic.web.oauth.jwt.JwtTokenGenerator;
import org.github.foxnic.web.oauth.jwt.JwtTokenPair;
import org.github.foxnic.web.oauth.service.ISessionOnlineService;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.oauth.session.SessionUser;
import org.github.foxnic.web.oauth.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.springboot.web.ResponseUtils;

/**
 * 处理登录成功的逻辑
 */
@Component
@EnableConfigurationProperties(SecurityProperties.class)
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private SecurityProperties securityProperties;
	
	@Autowired
	private JwtTokenGenerator jwtTokenGenerator;
	
	@Autowired
    IUserService userDetailsService;
    
    @Autowired
    ISessionOnlineService onlineService;
 

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		if(securityProperties.getSecurityMode()==SecurityMode.JWT) {
			handleTokenMode(response, authentication);
		} else if(securityProperties.getSecurityMode()==SecurityMode.SESSION) {
			handleSessionMode(request,response, authentication);
		} 

	}

	private void handleSessionMode(HttpServletRequest request,HttpServletResponse response, Authentication authentication) {
	 
		SessionUser securityUser = ((SessionUser) authentication.getPrincipal());
        
        JSONObject ret=new JSONObject();
        User user=securityUser.getUser().toPojo(User.class);
        ret.put("user", user);
        ret.put("token", securityUser.getToken());
        
        
        
        
        userDetailsService.update(SYS_USER.LAST_LOGIN_TIME, new Date(), securityUser.getUser().getId());
        //
        String initId=(String)request.getAttribute(SessionUser.SESSION_ONLINE_ID_KEY);
        
        
        
        SessionOnline online=onlineService.getById(initId);
        if(online==null) {
        	online=new SessionOnline();
	        online.setId(initId);
	        online.setUserId(securityUser.getUser().getId());
	        online.setToken(securityUser.getToken());
	        online.setOnline(1);
	        online.setLoginTime(new Date());
	        online.setInteractTime(new Date());
	        online.setSessionId(request.getSession().getId());
	        online.setSessionTime(request.getSession().getMaxInactiveInterval());
	        onlineService.insert(online);
        }

        Result r=ErrorDesc.success().message("登录成功").data(ret);
 
 
        ResponseUtils.out(response, r);
		
	}
	
	
	

	private void handleTokenMode(HttpServletResponse response, Authentication authentication) throws IOException {
		
		Map<String, Object> map = new HashMap<>(5);
		SessionUser principal = (SessionUser) authentication.getPrincipal();

		String username = principal.getUsername();
		Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
		Set<String> roles = new HashSet<>();
		if (authorities != null && !authorities.isEmpty()) {
			for (GrantedAuthority authority : authorities) {
				String roleName = authority.getAuthority();
				roles.add(roleName);
			}
		}

		JwtTokenPair jwtTokenPair = jwtTokenGenerator.jwtTokenPair(principal.getUser().getId(), username);

		map.put("accessToken", jwtTokenPair.getAccessToken().token());
		map.put("refreshToken", jwtTokenPair.getRefreshToken().token());

		ResponseUtil.writeOK(response, ErrorDesc.success().message("登录成功").data(map));
	}

}
