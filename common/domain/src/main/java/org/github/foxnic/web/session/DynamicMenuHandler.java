package org.github.foxnic.web.session;

import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.ReflectUtil;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.User;

import java.util.List;

public abstract class DynamicMenuHandler {

    private static LocalCache<String, DynamicMenuHandler> HANDLERS=new LocalCache<>();

    public static DynamicMenuHandler getHandler(String clsName) {

        DynamicMenuHandler handler= HANDLERS.get(clsName);
        if(handler==null) {
            Class clz= ReflectUtil.forName(clsName);
            try {
                handler = (DynamicMenuHandler) clz.newInstance();
                HANDLERS.put(clsName,handler);
            } catch (Exception e) {
                Logger.exception("DynamicMenuHandler "+clsName+" 创建失败，请查看 https://gitee.com/lank/eam/issues/I617XI",e);
            }
        }
        return handler;
    }

    /**
     * 动态判断权限
     * */
    public abstract boolean hasPermission(Menu menu, User user);
    /**
     * 动态获得菜单名称
     * */
    public abstract String getLabel(Menu menu,User user);

    /**
     * 获得额外的下级菜单名称
     * */
    public abstract List<Menu> generateExtraChildNodes(Menu menu, User user);

}
