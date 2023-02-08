package org.github.foxnic.web.framework.module;

import org.github.foxnic.web.domain.oauth.Menu;

import java.util.Collection;
import java.util.List;

public interface ICachedMenuService {
    List<Menu> queryCachedMenus(Collection<String> menuIds,Boolean inRange);
}
