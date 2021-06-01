package org.github.foxnic.web.oauth.authorization;

import org.github.foxnic.web.domain.oauth.Menu;
import org.springframework.security.core.GrantedAuthority;

public class PermissionAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	private Menu menu;
	
	public PermissionAuthority(Menu menu) {
		this.menu=menu;
	}
	
	@Override
	public String getAuthority() {
		return menu.getAuthority();
	}

	public Menu getMenu() {
		return menu;
	}
	
}
