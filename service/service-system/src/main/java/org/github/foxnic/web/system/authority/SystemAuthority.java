package org.github.foxnic.web.system.authority;

import org.github.foxnic.web.framework.module.ModuleAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SystemAuthority extends ModuleAuthority {
    @Override
    public String[] getAuthorities() {
        return new String[] {
                // 基础权限
                "basic_permissions",
                // 系统管理->系统配置
                "system_config",
                // 系统管理->系统运维
                "system_ops",
                // 系统管理->开发工具
                "develop_tool",
                // 系统管理->公共资源
                "public_resource"
        };
    }
}
