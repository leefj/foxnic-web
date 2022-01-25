package org.github.foxnic.web.framework.cache;

import com.github.foxnic.commons.cache.Cache;
import com.github.foxnic.commons.cache.ExpireType;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.cache.CacheProperties;
import com.github.foxnic.dao.cache.DataCacheManager;

import java.util.HashMap;
import java.util.Map;

public class FoxnicDataCacheManager extends DataCacheManager {

    private static FoxnicDataCacheManager instance;

    public static FoxnicDataCacheManager getInstance() {
        return instance;
    }

    private Map<Class,com.github.foxnic.commons.cache.DoubleCache> caches=new HashMap<>();

    public  FoxnicDataCacheManager() {
        instance = this;
    }

    void  remove4Notify(String cacheName,String key,String removeType) {

        for (com.github.foxnic.commons.cache.DoubleCache cache : caches.values()) {
            if(!cache.getName().equals(cacheName)) continue;
            Cache local=cache.getLocalCache();
            if(local==null) continue;
            if(removeType.equals("starts")) {
                local.removeKeysStartWith(key);
                System.err.println("remove >>> starts "+key+" @ "+cacheName);
            } else if(removeType.equals("all")) {
                Logger.error("暂不支持 all 模式");
                // throw new RuntimeException("暂不支持 all 模式");
            } else if(removeType.equals("clear")) {
                local.clear();
                System.err.println("removeAll >>> "+key+" @ "+cacheName);
            } else {
                local.remove(key);
                System.err.println("remove >>> "+key+" @ "+cacheName);
            }

        }

    }

    private   com.github.foxnic.commons.cache.DoubleCache<String, Object> metaCache;

    @Override
    public com.github.foxnic.commons.cache.DoubleCache<String, Object> getMetaCache() {
        //
        if(metaCache!=null) return metaCache;
        //
        String cacheName="foxnic:meta";
        RemoteCache<Object> remote = new RemoteCache<Object>(cacheName, -1);
        LocalCache<String,Object> local = new LocalCache<>(-1, ExpireType.LIVE);
        metaCache=new DoubleCache<Object>(cacheName, local, remote);
        return metaCache;
    }

    @Override
    public com.github.foxnic.commons.cache.DoubleCache<String, Object> getEntityCache( Class type) {
        if(this.getCacheProperties()==null) return null;
        CacheProperties.PoCacheProperty property=this.getCacheProperties().getPoCacheProperty(type);

        if(property==null || property.getMode()==null ||property.getMode()==JoinCacheMode.none) return null;
        com.github.foxnic.commons.cache.DoubleCache<String, Object> dc=caches.get(type);
        if(dc==null) {
            String[] ns=type.getName().split("\\.");
            String cacheName="foxnic:data:"+ns[ns.length-2]+":"+ns[ns.length-1];
            RemoteCache<Object> remote = null;
            LocalCache<String,Object> local = null;
            if(property.getMode()==JoinCacheMode.remote) {
                remote=new RemoteCache<Object>(cacheName, property.getRemoteExpire());
            }
            else if(property.getMode()==JoinCacheMode.both) {
                remote=new RemoteCache<Object>(cacheName, property.getRemoteExpire());
                local=new LocalCache<>(property.getLocalExpire(), ExpireType.LIVE,property.getLocalLimit());
            }
            else if(property.getMode()==JoinCacheMode.local) {
                local=new LocalCache<>(property.getLocalExpire(), ExpireType.LIVE,property.getLocalLimit());
            }
            dc=new DoubleCache<Object>(cacheName, local, remote);
            caches.put(type,dc);
            return dc;
        }
        return dc;
    }

}
