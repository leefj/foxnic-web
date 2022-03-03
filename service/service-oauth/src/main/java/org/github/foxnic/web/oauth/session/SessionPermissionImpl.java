package org.github.foxnic.web.oauth.session;

import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.constants.enums.system.AccessType;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.session.SessionPermission;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class SessionPermissionImpl implements SessionPermission {

	private SessionUserImpl sessionUser;

	private Set<AntPathRequestMatcher> requestMatchers;

	private List<SimpleGrantedAuthority> authorities;

	private String[] authoritieRoles;


	private Set<String> busiRoleIds=new HashSet<>();
	private Set<String> busiRoleCodes=new HashSet<>();

	private Map<String,String> menuRoleRelation ;

	private Map<String,Role> roleIdCache;
	private Map<String,String> urlMenuCache;
	private Set<String> authorityKeys=new HashSet<>();
	private Set<String> roleKeys=new HashSet<>();

	public SessionPermissionImpl(SessionUserImpl sessionUser) {
		this.sessionUser=sessionUser;

		initRequestMatchers();
		initAuthorities();
		initMenuRoleRelation();
	}


	private void initMenuRoleRelation() {
		menuRoleRelation=new HashMap<String, String>();
		//此处会覆盖拥有相同菜单的角色，在对 SpringSecurity 进行深度定制时建议考虑
		for (Role role : sessionUser.getUser().getRoles()) {
			for (Menu m : role.getMenus()) {
				this.menuRoleRelation.put(m.getId(),role.getId());
			}
			// 清空
			role.setMenus(null);
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
			roleKeys.add(role.getCode());
		}
		authoritieRoles=new String[authorities.size()];
		for (int i = 0; i < authorities.size(); i++) {
			authoritieRoles[i]=authorities.get(i).getAuthority();
		}

		//设置菜单权限

		for (Menu menu : sessionUser.getUser().getMenus()) {
			if(StringUtil.isBlank(menu.getAuthority())) continue;
			SimpleGrantedAuthority auth=new SimpleGrantedAuthority(menu.getAuthority());
			authorities.add(auth);
			authorityKeys.add(menu.getAuthority());
		}

		//业务角色
		if(sessionUser.getUser().getActivatedTenant()!=null) {
			Employee employee = sessionUser.getUser().getActivatedTenant().getEmployee();
			if (employee != null) {
				List<BusiRole> bRoles = employee.getBusiRoles();
				if(bRoles!=null) {
					for (int i = 0; i < bRoles.size(); i++) {
						BusiRole r = bRoles.get(i);
						busiRoleIds.add(r.getId());
						busiRoleCodes.add(r.getCode());
					}
				}
			}
		}

	}

	/**
	 * 初始化可以访问的请求列表
	 * */
	private void initRequestMatchers() {
		urlMenuCache =new HashMap<String, String>();
		requestMatchers=new HashSet<AntPathRequestMatcher>();
		for (Menu menu : this.sessionUser.getUser().getMenus()) {
			Resourze resourze=menu.getPathResource();
			if(resourze!=null && resourze.getAccessTypeEnum() == AccessType.GRANT) {
//				if("/service-oauth/sys-user/query-paged-list".equals(resourze.getUrl())){
//					System.out.println("");
//				}
				requestMatchers.add(new AntPathRequestMatcher(resourze.getUrl(),resourze.getMethod(),true));
				urlMenuCache.put(resourze.getUrl(), menu.getId());
			}
			if(menu.getResources()!=null) {
				for (Resourze resource : menu.getResources()) {
//					if("/service-oauth/sys-user/query-paged-list".equals(resource.getUrl())){
//						System.out.println("");
//					}
					if(resource.getAccessTypeEnum() == AccessType.GRANT) {
						requestMatchers.add(new AntPathRequestMatcher(resource.getUrl(), resource.getMethod(), true));
						urlMenuCache.put(resource.getUrl(), menu.getId());
					}
				}
			}
		}
	}


	private Map<String,AntPathRequestMatcher> cachedAntPathRequestMatcher=new HashMap<>();


	/**
	 * 此处可尝试使用缓存
	 * */
	public AntPathRequestMatcher check(HttpServletRequest request) {
		String key=(request.getRequestURI()+request.getMethod()).toLowerCase();
		AntPathRequestMatcher antPathRequestMatcher=cachedAntPathRequestMatcher.get(key);
		if(antPathRequestMatcher!=null) return antPathRequestMatcher;

		for (AntPathRequestMatcher m : requestMatchers) {
//			 if(m.getPattern().equals("/service-oauth/sys-user/query-paged-list")) {
//				 System.out.println();
//			 }
			 if(m.matches(request)) {
				 cachedAntPathRequestMatcher.put(key,m);
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


//	public Map<String, String> getMenuRoleRelation() {
//		return menuRoleRelation;
//	}


	public Role getRoleByMatcher(AntPathRequestMatcher matcher) {
		String menuId= urlMenuCache.get(matcher.getPattern());
		if(menuId==null) return null;

		String roleId = this.menuRoleRelation.get(menuId);
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


	@Override
	public boolean checkAuth(String... menuAuthority) {
		for (String auth : menuAuthority) {
			if(!authorityKeys.contains(auth)) return false;
		}
		return true;
	}

	@Override
	public boolean checkRole(String... roleCode) {
		for (String role : roleCode) {
			if(!roleKeys.contains(role)) return false;
		}
		return true;
	}

	@Override
	public boolean checkAnyAuth(String... menuAuthority) {
		for (String auth : menuAuthority) {
			if(authorityKeys.contains(auth)) return true;
		}
		return false;
	}

	@Override
	public boolean checkAnyRole(String... roleCode) {
		for (String role : roleCode) {
			if(roleKeys.contains(role)) return true;
		}
		return false;
	}

	@Override
	public String[] getAuthoritieRoles() {
		return authoritieRoles;
	}


	@Override
	public boolean checkBusiRoleCode(String... roleCode) {
		for (String role : roleCode) {
			if(!busiRoleCodes.contains(role)) return false;
		}
		return true;
	}

	@Override
	public boolean checkAnyBusiRoleCode(String... roleCode) {
		for (String role : roleCode) {
			if(busiRoleCodes.contains(role)) return true;
		}
		return false;
	}

	@Override
	public String[] getBusiRoleCodes() {
		return busiRoleCodes.toArray(new String[0]);
	}

	@Override
	public boolean checkBusiRoleId(String... roleId) {
		for (String role : roleId) {
			if(!busiRoleIds.contains(role)) return false;
		}
		return true;
	}

	@Override
	public boolean checkAnyBusiRoleId(String... roleId) {
		for (String role : roleId) {
			if(busiRoleIds.contains(role)) return true;
		}
		return false;
	}

	@Override
	public String[] getBusiRoleIds() {
		return busiRoleIds.toArray(new String[0]);
	}




}
