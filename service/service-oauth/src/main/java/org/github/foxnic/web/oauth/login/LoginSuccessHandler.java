package org.github.foxnic.web.oauth.login;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.json.JSONUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.network.Machine;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.SessionOnline;
import org.github.foxnic.web.domain.oauth.TokenModel;
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
import org.github.foxnic.web.session.SessionUser;
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



	public SessionUser setupAuthentication(HttpServletRequest request, HttpServletResponse response,
										   Authentication authentication) throws IOException, ServletException {


//		if(securityProperties.getSecurityMode()==SecurityMode.JWT) {
//			handleTokenMode(response, authentication);
//		} else if(securityProperties.getSecurityMode()==SecurityMode.SESSION) {
//			handleSessionMode(request,response, authentication);
//		} else if(securityProperties.getSecurityMode()==SecurityMode.BOTH) {
//			System.out.println();
//		}

		SessionUserImpl securityUser = ((SessionUserImpl) authentication.getPrincipal());
		//初始化权限
		securityUser.permission();


		User user=securityUser.getUser().toPojo(User.class);

		userDetailsService.update(SYS_USER.LAST_LOGIN_TIME, new Date(), securityUser.getUser().getId());
		//
		String initId=(String)request.getAttribute(SessionUserImpl.SESSION_ONLINE_ID_KEY);
		securityUser.setSessionOnlineId(initId);



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

		//放入缓存
		sessionCache.put(online.getSessionId(),securityUser);
		return  securityUser;

	}

	public JSONObject makeLoginResponseJSON(HttpServletRequest request, HttpServletResponse response,
											Authentication authentication) throws IOException, ServletException {

		SessionUser sessionUser=setupAuthentication(request,response,authentication);

		JSONObject ret=new JSONObject();

		// 瘦身
		List<Menu> menus =IUserService.LOGIN_USER_MENUS.get();
		User user=sessionUser.getUser().clone();
		user.setMenus(menus);
		JSONObject userJson=slimming(user);

		IUserService.LOGIN_USER_MENUS.remove();

		ret.put("user", userJson);
		ret.put("sessionId", sessionUser.getSessionOnlineId());

		if( securityProperties.getSecurityMode()==SecurityMode.BOTH || securityProperties.getSecurityMode()==SecurityMode.JWT ) {
			TokenModel token = getToken(authentication);
			ret.put("token", token);
			Map<String,Object> tokenMap= BeanUtil.toMap(token);
			for (Map.Entry<String, Object> entry : tokenMap.entrySet()) {
				response.addHeader("Set-Cookie", entry.getKey()+"="+entry.getValue()+"; path=/");
			}
		}

		return ret;

	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		JSONObject ret=makeLoginResponseJSON(request,response,authentication);
        Result r=ErrorDesc.success().message("登录成功").data(ret);
        ResponseUtil.writeOK(response, r);
	}

	private JSONObject slimming(User user) {
		JSONObject jsonUser= JSONUtil.toJSONObject(user);
		jsonUser=slimmingCommonFields(jsonUser);
		JSONArray menus=jsonUser.getJSONArray("menus");
		if(menus==null) return jsonUser;
		for (int i = 0; i < menus.size(); i++) {
			JSONObject menu=menus.getJSONObject(i);
			if(menu==null) continue;
			menu.remove("resourceIds");
			menu.remove("resources");
			menu.remove("dynamicHandler");
			menu.remove("pathResourceId");
			menu.remove("batchId");
			menu.remove("hierarchy");
			menu.remove("pathResource");
			if(StringUtil.isBlank(menu.getString("url"))) {
				menu.remove("url");
			}
			if(StringUtil.isBlank(menu.getString("css"))) {
				menu.remove("css");
			}
			if(StringUtil.isBlank(menu.getString("params"))) {
				menu.remove("params");
			}
		}
		return jsonUser;
	}

	private JSONObject slimmingCommonFields(JSONObject jsonUser) {
		jsonUser.remove("deleted");
		jsonUser.remove("version");
		jsonUser.remove("deleteTime");
		jsonUser.remove("deleteBy");
		jsonUser.remove("createTime");
		jsonUser.remove("createBy");
		jsonUser.remove("updateTime");
		jsonUser.remove("updateBy");
		jsonUser.remove("valid");
		jsonUser.remove("tenantId");
		for (Map.Entry<String, Object> entry : jsonUser.entrySet()) {
			if(entry.getValue() instanceof JSONObject) {
				slimmingCommonFields((JSONObject)entry.getValue());
			} else if(entry.getValue() instanceof JSONArray) {
				JSONArray array=(JSONArray) entry.getValue();
				for (int i = 0; i < array.size(); i++) {
					if(array.get(i) instanceof JSONObject) {
						slimmingCommonFields((JSONObject) array.get(i));
					}
				}
			}
		}

		return jsonUser;
	}


	private TokenModel getToken(Authentication authentication)  {

		TokenModel tokenModel=new TokenModel();
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

		tokenModel.setAccessToken( jwtTokenPair.getAccessToken().token());
		tokenModel.setRefreshToken(jwtTokenPair.getRefreshToken().token());

		return tokenModel;

	}

}
