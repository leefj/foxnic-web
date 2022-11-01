package org.github.foxnic.web.oauth.session;

import com.github.foxnic.springboot.web.AntPathRequestMatcher;

public class FoxnicPathRequestMatcher extends AntPathRequestMatcher {

    private String menuId;
    private String roleId;
    private String roleCode;

    public FoxnicPathRequestMatcher(String roleId, String roleCode, String menuId, String pattern, String httpMethod, boolean caseSensitive) {
        super(pattern, httpMethod, caseSensitive);
        this.menuId=menuId;
        this.roleId=roleId;
        this.roleCode=roleCode;
    }


    public String getMenuId() {
        return menuId;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

}
