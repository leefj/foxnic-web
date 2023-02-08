package org.github.foxnic.web.framework.module;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Primary
@Component("ModuleAuthority")
public class ModuleAuthority {
    public String[] getAuthorities() {
        return new String[] {};
    }
}
