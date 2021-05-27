package org.github.foxnic.web.oauth.domain;

import java.util.Collection;

import org.github.foxnic.web.domain.oauth.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SOSUserDetails implements UserDetails {

	
	private User user;
	
	private String token;
 
	public SOSUserDetails(User user) {
		this.user=user;
	}
	
	/**
	 * 返回用户权限
	 * */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
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

}
