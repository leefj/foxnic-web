package org.github.foxnic.web.oauth.session;

import java.util.Collection;

import org.github.foxnic.web.domain.oauth.User;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.springboot.mvc.RequestParameter;

public class SessionUser implements UserDetails, CredentialsContainer {
 
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private String token;
	
	private String sessionId;
	
	public SessionUser(User user) {
		this.user=user;
		this.token=IDGenerator.getSUID(true);
		this.sessionId=RequestParameter.get().getSessionId(true);
	}

	@Override
	public void eraseCredentials() {
		this.user.setPasswd("******");
		this.user.setSalt("******");
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
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
		return this.user.getValid()==1 && this.user.getDeleted()==0;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.user.getValid()==1 && this.user.getDeleted()==0;
	}

	/**
	 * 认证是否过期
	 * */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.getValid()==1 && this.user.getDeleted()==0;
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

	public String getSessionId() {
		return sessionId;
	}
	 
	
}
