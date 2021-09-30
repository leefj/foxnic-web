package org.github.foxnic.web.framework.change;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.reflect.ReflectUtil;
import org.github.foxnic.web.domain.changes.ChangeData;
import org.github.foxnic.web.domain.changes.ChangeEvent;

public abstract class ChangesHandler {

    public <T> T cast(ChangeData data) {
        Class<T> type= ReflectUtil.forName(data.getDataType());
        if(type==null) {
            throw new IllegalArgumentException(data.getDataType()+" 未定义");
        }
        JSONObject json=JSONObject.parseObject(data.getData());
        T bean= JSONObject.toJavaObject(json,type);
        return bean;
    }

    /**
     * 如果返回成功，调用后续步骤
     * */
    public abstract Result onEvent(ChangeEvent event);

}
