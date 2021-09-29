package org.github.foxnic.web.framework.change;

import com.alibaba.fastjson.JSON;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.framework.cache.DataChangeHandler;
import org.github.foxnic.web.framework.cache.RedisUtil;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ChangesNotifyListener extends DataChangeHandler implements ApplicationListener<ApplicationStartedEvent> {



    @Override
    public void handle(String key, RedisUtil redis) {
        String chsId=key.split(":")[1];
        key=ChangesAssistant.CHANGES_NOTIFY_PREFIX+chsId;
        ChangeEvent event=(ChangeEvent)redis.get(key);
        String handler=event.getDefinition().getHandler();
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
        Result result=handlerBean.onEvent(event);
        ChangeEvent response=new ChangeEvent();
        response.setId(event.getId());
        response.setResponseTime(new Timestamp(System.currentTimeMillis()));
        response.setResponseData(JSON.toJSONString(result));
        //结果反馈
        redis.set(ChangesAssistant.CHANGES_RESPONSE_PREFIX+response.getId(),response,30);
        redis.notifyDataChange(ChangesAssistant.CHANGES_CHANNEL_RESPONSE_PREFIX+response.getId());
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
