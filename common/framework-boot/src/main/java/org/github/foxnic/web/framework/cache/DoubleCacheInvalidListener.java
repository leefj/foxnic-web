package org.github.foxnic.web.framework.cache;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.lang.StringUtil;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DoubleCacheInvalidListener extends DataChangeHandler implements ApplicationListener<ApplicationStartedEvent> {


    @Override
    public void handle(String key, RedisUtil redis) {
        key = StringUtil.removeFirst(key,DoubleCache.CACHE_INVALID_PREFIX);
        key =StringUtil.removeLast(key,DoubleCache.CACHE_INVALID_SUFFIX);
        key = key.replaceAll("\\\\","");
        JSONObject cmd=JSONObject.parseObject(key);
        FoxnicDataCacheManager.getInstance().remove4Notify(cmd.getString("name"),cmd.getString("key"),cmd.getString("removeType"));
    }

    @Override
    public boolean match(String key) {
        return key.startsWith(DoubleCache.CACHE_INVALID_PREFIX) && key.endsWith(DoubleCache.CACHE_INVALID_SUFFIX);
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        RedisUtil.instance().addDataChangeHandler(this);
    }

}
