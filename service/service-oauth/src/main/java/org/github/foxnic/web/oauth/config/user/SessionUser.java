package org.github.foxnic.web.oauth.config.user;

import java.util.Collection;

import org.github.foxnic.web.domain.oauth.User;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SessionUser implements UserDetails, CredentialsContainer {
 
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public SessionUser(User user) {
		this.user=user;
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
	
	 
	
}
