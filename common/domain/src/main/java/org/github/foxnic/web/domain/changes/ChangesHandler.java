package org.github.foxnic.web.domain.changes;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.ReflectUtil;
import org.github.foxnic.web.constants.enums.changes.ChangeStatus;

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
     * @param  dataBefore 变更前的数据
     * @param  dataAfter 变更后的数据
     * @param  delta  变更后的数据差异
     * @param  statusBefore  审批前的状态
     * @param  statusAfter  审批后的状态
     * */
    public abstract Result onStatusChange(ChangeInstance instance, DataUnit dataBefore, DataUnit dataAfter, DataDelta delta, ChangeStatus statusBefore,ChangeStatus statusAfter);

}
