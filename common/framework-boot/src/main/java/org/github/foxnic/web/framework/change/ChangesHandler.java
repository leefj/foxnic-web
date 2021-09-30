package org.github.foxnic.web.framework.change;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.reflect.ReflectUtil;
import org.github.foxnic.web.domain.changes.ChangeData;
import org.github.foxnic.web.domain.changes.ChangeEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class ChangesHandler {

    public <T> List<T> cast(ChangeData data) {
        Class<T> type= ReflectUtil.forName(data.getDataType());
        if(type==null) {
            throw new IllegalArgumentException(data.getDataType()+" 未定义");
        }
        JSONArray array = null;
        try {
            array=JSONArray.parseArray(data.getData());
        } catch (Exception e) {
            throw new IllegalArgumentException("JSON解析失败",e);
        }
        List<T> list=new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            try {
                T bean= JSONObject.toJavaObject(array.getJSONObject(i),type);
                list.add(bean);
            } catch (Exception e) {
                throw new IllegalArgumentException("JSON 转 JAVA 对象失败",e);
            }
        }
        return list;
    }

    /**
     * 如果返回成功，调用后续步骤
     * */
    public abstract Result onEvent(ChangeEvent event);

}
