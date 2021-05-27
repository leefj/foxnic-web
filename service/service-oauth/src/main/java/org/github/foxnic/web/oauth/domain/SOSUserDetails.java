package org.github.foxnic.web.oauth.domain;

import java.util.Collection;

import org.github.foxnic.web.domain.oauth.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SOSUserDetails implements UserDetails {

	
	private User user;
	
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
	}

}
