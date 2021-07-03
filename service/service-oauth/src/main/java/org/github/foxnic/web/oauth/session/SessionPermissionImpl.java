package org.github.foxnic.web.oauth.session;

import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.RoleMenu;
import org.github.foxnic.web.session.SessionPermission;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class SessionPermissionImpl implements SessionPermission {
	
	public static final String ROLE_PREFIX="ROLE_";
	
	private SessionUserImpl sessionUser;
	
	private Set<AntPathRequestMatcher> requestMatchers;
	
	private List<SimpleGrantedAuthority> authorities;
	
	private Map<String,String> menuRoleRelation;
	
	private Map<String,Role> roleIdCache;
	private Map<String,Menu> menuPathCache;
	
	public SessionPermissionImpl(SessionUserImpl sessionUser) {
		this.sessionUser=sessionUser;
		
		initRequestMatchers();
		initAuthorities();
		initMenuRoleRelation();
	}

	
	private void initMenuRoleRelation() {
		menuRoleRelation=new HashMap<String, String>();
		for (RoleMenu rm : this.sessionUser.getUser().getRoleMenus()) {
			//此处会覆盖拥有相同菜单的角色，在对SpringSecurity进行深度定制时建议考虑
			menuRoleRelation.put(rm.getMenuId(), rm.getRoleId());
		}
	}

	/**
	 * 初始化菜单中的权限清单
	 * */
	private void initAuthorities() {
	
		authorities=new ArrayList<SimpleGrantedAuthority>();

		//设置角色
		roleIdCache=new HashMap<String, Role>();
		for (Role role : sessionUser.getUser().getRoles()) {
			if(StringUtil.isBlank(role.getCode())) continue;
			SimpleGrantedAuthority auth=new SimpleGrantedAuthority(ROLE_PREFIX+role.getCode());
			authorities.add(auth);
			roleIdCache.put(role.getId(), role);
		}

		//设置菜单权限
		menuPathCache=new HashMap<String, Menu>();
		for (Menu menu : sessionUser.getUser().getMenus()) {
			if(StringUtil.isBlank(menu.getAuthority())) continue;
			SimpleGrantedAuthority auth=new SimpleGrantedAuthority(menu.getAuthority());
			authorities.add(auth);
			menuPathCache.put(menu.getPath(), menu);
		}
		
	}

	/**
	 * 初始化可以访问的请求列表
	 * */
	private void initRequestMatchers() {
		requestMatchers=new HashSet<AntPathRequestMatcher>();
		for (Menu menu : this.sessionUser.getUser().getMenus()) {
			Resourze resourze=menu.getPathResource();
			if(resourze!=null) {
				requestMatchers.add(new AntPathRequestMatcher(resourze.getUrl(),resourze.getMethod(),true));
			}
			if(menu.getResources()!=null) {
				for (Resourze resource : menu.getResources()) {
					requestMatchers.add(new AntPathRequestMatcher(resource.getUrl(),resource.getMethod(),true));
				}
			}
		}
	}
	
	public AntPathRequestMatcher check(HttpServletRequest request) {
		for (AntPathRequestMatcher m : requestMatchers) {
//			 if(m.getPattern().equals("/business/system/lang/lang_list.html")) {
//				 System.out.println();
//			 }
			 if(m.matches(request)) {
				 return m;
			 }
		}
		return null;
	}


	public SessionUserImpl getSessionUser() {
		return sessionUser;
	}


	public Set<AntPathRequestMatcher> getRequestMatchers() {
		return requestMatchers;
	}


	public List<SimpleGrantedAuthority> getAuthorities() {
		return authorities;
	}


	public Map<String, String> getMenuRoleRelation() {
		return menuRoleRelation;
	}


	public Role getRoleByMatcher(AntPathRequestMatcher matcher) {
		Menu menu=menuPathCache.get(matcher.getPattern());
		if(menu==null) return null;
		String roleId=this.menuRoleRelation.get(menu.getId());
		Role role=roleIdCache.get(roleId);
		return role;
	}
	
	public Collection<ConfigAttribute> getConfigAttributesByMatcher(AntPathRequestMatcher matcher) {
		Role role=this.getRoleByMatcher(matcher);
		if(role==null) {
			return null;
		}
		//此处得到其中一个即可，也不会得到多个，原因请看  initMenuRoleRelation 方法
		return SecurityConfig.createList(new String[] {ROLE_PREFIX+role.getCode()});
	}
	
	
	
	

}
