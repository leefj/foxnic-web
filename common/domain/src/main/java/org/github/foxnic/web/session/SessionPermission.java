package org.github.foxnic.web.session;

import java.io.Serializable;

public interface SessionPermission extends Serializable {

    public static final String ROLE_PREFIX="ROLE_";
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

    /**
     * 获得功能角色代码
     * */
    String[] getAuthedRoles();

    boolean checkBusiRoleId(String... roleId);

    boolean checkAnyBusiRoleId(String... roleId);

    boolean checkBusiRoleCode(String... roleCode);

    boolean checkAnyBusiRoleCode(String... roleCode);

    String[] getBusiRoleIds();
    String[] getBusiRoleCodes();



}
