package org.github.foxnic.web.session;

public interface SessionPermission {

    /**
     * 校验是否有菜单权限，当有参数列表中所有权限时，返回 true
     * */
    boolean checkAuth(String... menuAuthority);

    /**
     * 校验是否有角色权限，当有参数列表中所有权限时，返回 true
     * */
    boolean checkRole(String... roleCode);

    /**
     * 校验是否有菜单权限，当有参数列表中任意一个权限时，返回 true
     * */
    boolean checkAnyAuth(String... menuAuthority);

    /**
     * 校验是否有角色权限，当有参数列表中任意权限时，返回 true
     * */
    boolean checkAnyRole(String... roleCode);

    String[] getAuthoritieRoles();

	
	
}
