package org.github.foxnic.web.changes.handler;

import org.github.foxnic.web.changes.service.IChangeEventService;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.framework.cache.DataChangeHandler;
import org.github.foxnic.web.framework.cache.RedisUtil;
import org.github.foxnic.web.framework.change.ChangesAssistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ChangesResponseListener extends DataChangeHandler implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private IChangeEventService eventService;

    @Override
    public void handle(String key, RedisUtil redis) {
        String eventId=key.substring(key.lastIndexOf(":")+1);
        key= ChangesAssistant.CHANGES_RESPONSE_PREFIX+eventId;
        ChangeEvent event=(ChangeEvent)redis.get(key);
        eventService.updateNotNullFields(event);
    }

    @Override
    public boolean match(String key) {
        return key.startsWith(ChangesAssistant.CHANGES_CHANNEL_RESPONSE_PREFIX);
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        RedisUtil.instance().addDataChangeHandler(this);
    }

}
