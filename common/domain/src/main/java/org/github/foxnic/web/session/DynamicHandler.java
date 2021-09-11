package org.github.foxnic.web.session;

import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.ReflectUtil;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.User;

public abstract class DynamicHandler {

    private static LocalCache<String,DynamicHandler> HANDLERS=new LocalCache<>();

    public static DynamicHandler getHandler(String clsName) {

        DynamicHandler handler= HANDLERS.get(clsName);
        if(handler==null) {
            Class clz= ReflectUtil.forName(clsName);
            try {
                handler = (DynamicHandler) clz.newInstance();
                HANDLERS.put(clsName,handler);
            }catch (Exception e){
                Logger.exception("创建失败",e);
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
}
