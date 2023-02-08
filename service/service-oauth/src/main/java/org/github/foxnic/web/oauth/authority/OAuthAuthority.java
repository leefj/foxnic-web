package org.github.foxnic.web.oauth.authority;

import org.github.foxnic.web.framework.module.ModuleAuthority;
import org.springframework.stereotype.Component;

@Component
public class OAuthAuthority extends ModuleAuthority {
    @Override
    public String[] getAuthorities() {
        return new String[] {
                // 权限管理
                "oauth"
        };
    }
}
