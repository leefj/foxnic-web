package org.github.foxnic.web.oauth.login;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.network.Machine;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.SessionOnline;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.language.LanguageService;
import org.github.foxnic.web.oauth.config.security.SecurityProperties;
import org.github.foxnic.web.oauth.config.security.SecurityProperties.SecurityMode;
import org.github.foxnic.web.oauth.jwt.JwtTokenGenerator;
import org.github.foxnic.web.oauth.jwt.JwtTokenPair;
import org.github.foxnic.web.oauth.service.ISessionOnlineService;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.oauth.session.SessionUserImpl;
import org.github.foxnic.web.oauth.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 处理登录成功的逻辑
 * 
 * @author 李方捷
 * @since  2021-06-02
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
    
    @Autowired
	private LanguageService languageService;

	@Autowired
	private SessionCache sessionCache;
 

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

//		if(securityProperties.getSecurityMode()==SecurityMode.JWT) {
//			handleTokenMode(response, authentication);
//		} else if(securityProperties.getSecurityMode()==SecurityMode.SESSION) {
//			handleSessionMode(request,response, authentication);
//		} else if(securityProperties.getSecurityMode()==SecurityMode.BOTH) {
//			System.out.println();
//		} 
		
		SessionUserImpl securityUser = ((SessionUserImpl) authentication.getPrincipal());
        
        JSONObject ret=new JSONObject();
        User user=securityUser.getUser().toPojo(User.class);
        ret.put("user", user);
        
        userDetailsService.update(SYS_USER.LAST_LOGIN_TIME, new Date(), securityUser.getUser().getId());
        //
        String initId=(String)request.getAttribute(SessionUserImpl.SESSION_ONLINE_ID_KEY);
        securityUser.setSessionOnlineId(initId);
        
        ret.put("sessionId", securityUser.getSessionOnlineId());
   
        SessionOnline online=onlineService.getById(initId);
        if(online==null) {
        	online=new SessionOnline();
	        online.setId(initId);
	        online.setUserId(securityUser.getUser().getId());
	        online.setOnline(1);
	        online.setLoginTime(new Date());
	        online.setInteractTime(new Date());
	        online.setSessionId(request.getSession().getId());
	        online.setSessionTime(request.getSession().getMaxInactiveInterval());
			online.setHostId(Machine.getIdentity());
			online.setNodeId(SpringUtil.getNodeInstanceId());
	        List<Menu> menus=user.getMenus();

	        //登录成功后翻译菜单标签
//	        for (Menu menu : menus) {
//	        	if(StringUtil.isBlank(menu.getType())) continue;
//	        	if(menu.getType().equalsIgnoreCase(MenuType.api.name())) continue;
//	        	if(menu.getType().equalsIgnoreCase(MenuType.function.name())) continue;
//	        	menu.setLabel(languageService.translate(menu.getLabel()));
//			}
	        
	        onlineService.insert(online);
        }
        
        if( securityProperties.getSecurityMode()==SecurityMode.BOTH || securityProperties.getSecurityMode()==SecurityMode.JWT ) {
        	Map<String, Object> token = getToken(authentication);
        	ret.put("token", token);
        }
 
        Result r=ErrorDesc.success().message("登录成功").data(ret);

        //放入缓存
		sessionCache.put(online.getSessionId(),securityUser);
 
        ResponseUtil.writeOK(response, r);

	}
	
 
	private Map<String, Object> getToken(Authentication authentication)  {
		
		Map<String, Object> map = new HashMap<>(5);
		SessionUserImpl principal = (SessionUserImpl) authentication.getPrincipal();

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
		
		return map;

//		ResponseUtil.writeOK(response, ErrorDesc.success().message("登录成功").data(map));
	}

}
