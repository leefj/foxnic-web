package org.github.foxnic.web.domain.changes;

import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.ReflectUtil;

public abstract class ChangesHandler {

    private static LocalCache<String, ChangesHandler> HANDLERS=new LocalCache<>();

    public static ChangesHandler getHandler(String clsName) {

        ChangesHandler handler= HANDLERS.get(clsName);
        if(handler==null) {
            Class clz= ReflectUtil.forName(clsName);
            try {
                handler = (ChangesHandler) clz.newInstance();
                HANDLERS.put(clsName,handler);
            } catch (Exception e) {
                Logger.exception("创建失败",e);
            }
        }
        return handler;
    }

    /**
     * 应用变更
     * @param  instance 变更实例
     * @param  before 变更前的数据
     * @param  after 变更后的数据
     * @param  delta  变更后的数据差异
     * */
    public abstract boolean applyChanges(ChangeInstance instance,DataUnit before,DataUnit after,DataDelta delta);

}
