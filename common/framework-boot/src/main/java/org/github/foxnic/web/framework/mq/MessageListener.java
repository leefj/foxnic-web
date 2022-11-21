package org.github.foxnic.web.framework.mq;

import com.alibaba.fastjson.JSON;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;

public abstract class MessageListener {



    abstract public Result processMessage(String message) throws Throwable;

    public void onMessage(String message) {
        MQLogger mqLogger=MQLogger.get();
        mqLogger.start(message);
        try {
            Result r=processMessage(message);
            mqLogger.result(r.success(), JSON.toJSONString(r));
        } catch (Throwable t) {
            mqLogger.exception(t);
            Logger.exception(t);
        }
    }
}
