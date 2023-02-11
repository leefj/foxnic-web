package org.github.foxnic.web.hrm.authority;

import org.github.foxnic.web.framework.module.ModuleAuthority;
import org.springframework.stereotype.Component;

@Component
public class HrmAuthority extends ModuleAuthority {

    /**
     * 返回最顶层菜单的权限Key
     * */
    @Override
    public String[] getAuthorities() {
        return new String[] {
                // 组织管理
                "hrm_organization:mngr",
                // 员工管理
                "hrm_employee:mngr",
                // 岗位管理
                "hrm_position:mngr",
                // 人员管理
                "hrm_person:mngr"
        };
    }
}
