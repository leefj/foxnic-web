package org.github.foxnic.web.oauth.session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.SessionOnline;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.oauth.Constants;
import org.github.foxnic.web.oauth.authorization.PermissionAuthority;
import org.github.foxnic.web.oauth.config.web.SecurityConfigs;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.springboot.web.WebContext;

public class SessionUser implements UserDetails {

	public static final String TOKEN_KEY = "x-token";
	
	private User user;
	private SessionOnline online;
	
	private List<GrantedAuthority> authorities;
	
	private String token;
	
	private SecurityConfigs configs;
	
	/**
	 * 用于 URL 判断的快速缓存
	 * */
	private Set<String> permittedURLs;
	
	/**
	 * 用于 URL 判断的快速缓存
	 * */
	private Set<String> notPermittedURLs;
 
	public SessionUser(String token,User user,SessionOnline online) {
		this.token=token;
		this.user=user;
		this.online=online;
		//
		this.authorities=new ArrayList<GrantedAuthority>();
		if(this.getUser()!=null) {
			List<Menu> menus=this.getUser().getMenus();
			if(menus!=null) {
				for (Menu menu : menus) {
					this.authorities.add(new PermissionAuthority(menu));
				}
			}
		}
		
		this.permittedURLs=new HashSet<>();
		this.notPermittedURLs=new HashSet<>();
		
		this.configs = SpringUtil.getBean(SecurityConfigs.class);
	}
	
	public boolean checkURLPermission(String url) {
		
		if(permittedURLs.contains(url)) return true;
		if(notPermittedURLs.contains(url)) return false;
		
		PermissionAuthority permission=null;
		for (GrantedAuthority authority : authorities) {
			permission=(PermissionAuthority)authority;
        	if(StringUtil.isBlank(permission.getMenu().getPath())) continue;
			if(WebContext.isMatchPattern(permission.getMenu().getPath(), url)) {
				if(permittedURLs.size()<1024) {
					permittedURLs.add(url);
				}
				return true;
			}
		}
		
		if(notPermittedURLs.size()<1024) {
			notPermittedURLs.add(url);
		}
		
		return false;
	}
	
	/**
	 * 返回用户权限
	 * */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPasswd();
	}

	@Override
	public String getUsername() {
		return this.user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.user.getValid()==null ||  this.user.getValid()==0;
	}

	/**
	 * 账户是否锁定
	 * */
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	/**
	 * 账户授权或密码是否过期
	 * */
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	
	public Date interact() {
		if(online!=null) {
			Date d=new Date();
			online.setInteractTime(d);
			return d;
		}
		return null;
	}
 
	public boolean isSessionExpire() {
		if(online==null) return false;
		if(online.getInteractTime()==null) {
			return true;
		}
		long t=(System.currentTimeMillis()-online.getInteractTime().getTime())/1000;
		return t>this.configs.getSessionTime();
	}

	/**
	 * 账户是否可用
	 * */
	@Override
	public boolean isEnabled() {
		return false;
	}

	public User getUser() {
		return user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * 获得当前登录的账户
	 * */
	public static SessionUser getCurrent() {
		SecurityContext context = SecurityContextHolder.getContext();
        if(context==null || context.getAuthentication()==null || !context.getAuthentication().isAuthenticated()) {
        	 return null;
        }
        Object principal=context.getAuthentication().getPrincipal();
        if(principal==null || !(principal instanceof SessionUser)) {
        	return null;
        }
        SessionUser userDetail=(SessionUser)principal;
        return userDetail;
	}
	

}
