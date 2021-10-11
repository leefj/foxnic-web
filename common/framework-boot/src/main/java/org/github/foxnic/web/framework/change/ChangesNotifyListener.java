package org.github.foxnic.web.framework.change;

import com.alibaba.fastjson.JSON;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.framework.cache.DataChangeHandler;
import org.github.foxnic.web.framework.cache.RedisUtil;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import java.sql.Timestamp;

//@Component
public class ChangesNotifyListener extends DataChangeHandler implements ApplicationListener<ApplicationStartedEvent> {



    @Override
    public void handle(String key, RedisUtil redis) {
        String eventId=key.substring(key.lastIndexOf(":")+1);
        key=ChangesAssistant.CHANGES_NOTIFY_PREFIX+eventId;
        ChangeEvent event=(ChangeEvent)redis.get(key);
        String handler=null; //event.getDefinition().getSimpleHandler();
        Class<? extends ChangesHandler> handlerType= ReflectUtil.forName(handler);
        if(handler==null) {
            throw new IllegalArgumentException( handler +" 未定义");
        }
        if(handlerType==null) {
            throw new IllegalArgumentException( handler +" 未定义");
        }
        ChangesHandler handlerBean = SpringUtil.getBean(handlerType);
        if(handlerBean==null) {
            throw new IllegalArgumentException( handler +" 不是 Spring Bean");
        }
        Result result = null ;
        try {
            result = handlerBean.onEvent(event);
        }catch (Exception e) {
            Logger.exception("审批回调异常",e);
            result= ErrorDesc.exception(e);
        }
        ChangeEvent response=new ChangeEvent();
        response.setId(event.getId());
        response.setResponseTime(new Timestamp(System.currentTimeMillis()));
        response.setSuccess(result.success()?1:0);
        response.setResponseData(JSON.toJSONString(result));
        //结果反馈
        boolean suc=redis.set(ChangesAssistant.CHANGES_RESPONSE_PREFIX+response.getId(),response,ChangesAssistant.EXPIRE_SECONDS);
        if(suc) {
            redis.notifyDataChange(ChangesAssistant.CHANGES_CHANNEL_RESPONSE_PREFIX + response.getId());
        } else {
            throw new RuntimeException("data response error");
        }
    }

    @Override
    public boolean match(String key) {
        return key.startsWith(ChangesAssistant.CHANGES_CHANNEL_EVENT_PREFIX);
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        RedisUtil.instance().addDataChangeHandler(this);
    }

}
