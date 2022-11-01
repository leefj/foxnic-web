package org.github.foxnic.web.oauth.session;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class ResourceTable implements Serializable {

    private List<String> methods=new ArrayList<>();
    private List<String> menuIds=new ArrayList<>();

    private List<String> menuAuthorityKeys=new ArrayList<>();
    private List<String> roleIds=new ArrayList<>();

    private List<String> roleCodes =new ArrayList<>();
    private List<String> urls=new ArrayList<>();


    // Table Resource

    private List<Integer> tableResourceUrlIndexes =new ArrayList<>();
    private List<Integer> tableResourceMethodIndexes =new ArrayList<>();
    private List<Integer> tableResourceMenuIdIndexes =new ArrayList<>();

    //Table Menu

    private List<Integer> tableMenuIdIndexes =new ArrayList<>();
    private List<Integer> tableMenuAuthorityKeyIndexes=new ArrayList<>();
    private List<Integer> tableMenuRoleIdIndexes=new ArrayList<>();
    private List<Integer> tableMenuRoleCodeIndexes =new ArrayList<>();

    public void addResource(String url, String method, String menuId) {

//        if("/service-bpm/bpm-form-definition/query-paged-list".equals(url)) {
//            System.out.println();
//        }

        if(!urls.contains(url)) {
            this.urls.add(url);
        }
        if(!this.methods.contains(method)) {
            this.methods.add(method);
        }
        if(!this.menuIds.contains(menuId)) {
            this.menuIds.add(menuId);
        }

        tableResourceUrlIndexes.add(this.urls.indexOf(url));
        tableResourceMethodIndexes.add(this.methods.indexOf(method));
        tableResourceMenuIdIndexes.add(this.menuIds.indexOf(menuId));

    }

    public void addMenu(String roleId,String roleCode,String menuId,String menuAuthorityKey) {
        if(!this.roleIds.contains(roleId)) {
            this.roleIds.add(roleId);
        }
        if(!this.roleCodes.contains(roleCode)) {
            this.roleCodes.add(roleCode);
        }
        if(!this.menuIds.contains(menuId)) {
            this.menuIds.add(menuId);
        }
        if(!this.menuAuthorityKeys.contains(menuAuthorityKey)) {
            this.menuAuthorityKeys.add(menuAuthorityKey);
        }
        //
        tableMenuRoleIdIndexes.add(this.roleIds.indexOf(roleId));
        tableMenuRoleCodeIndexes.add(this.roleCodes.indexOf(roleCode));

        tableMenuIdIndexes.add(this.menuIds.indexOf(menuId));
        tableMenuAuthorityKeyIndexes.add(this.menuAuthorityKeys.indexOf(menuAuthorityKey));


    }

    public int size() {
        return this.urls.size();
    }

    public FoxnicPathRequestMatcher find(HttpServletRequest request) {
        FoxnicPathRequestMatcher matcher = null;
        String url;
        String method;
        String menuId;
        String[] role;

//        if(this.urls.contains("/service-bpm/bpm-form-definition/query-paged-list")) {
//            System.out.println();
//        }

        for (int i = 0; i < this.tableResourceUrlIndexes.size(); i++) {

            url=this.urls.get(this.tableResourceUrlIndexes.get(i));
//            if("/service-bpm/bpm-form-definition/query-paged-list".equals(url)) {
//                System.out.println();
//            }
            method=this.methods.get(this.tableResourceMethodIndexes.get(i));
            menuId=this.menuIds.get(this.tableResourceMenuIdIndexes.get(i));
            role=this.getRole(menuId);

            matcher = new FoxnicPathRequestMatcher(role[0],role[1],menuId,url,method,true);
            if(matcher.matches(request)) {
                return matcher;
            }
        }
        return null;
    }

    private String[] getRole(String menuId) {
         int i=tableMenuIdIndexes.indexOf(menuId.indexOf(menuId));
         return new String[] {this.roleIds.get(this.tableMenuRoleIdIndexes.get(i)),this.roleCodes.get(this.tableMenuRoleCodeIndexes.get(i))};
    }

    public boolean containsRoleCode(String roleCode) {
        return this.roleCodes.contains(roleCode);
    }

    public boolean containsMenuAuthorityKeys(String auth) {
        return this.menuAuthorityKeys.contains(auth);
    }
}
