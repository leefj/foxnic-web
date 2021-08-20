package org.github.foxnic.web.framework.cache;

import com.github.foxnic.commons.cache.ExpireType;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.dao.cache.DataCacheManager;

import java.util.HashMap;
import java.util.Map;

public class FoxnicDataCacheManager extends DataCacheManager {

    private Map<Class,com.github.foxnic.commons.cache.DoubleCache> caches=new HashMap<>();

    @Override
    public com.github.foxnic.commons.cache.DoubleCache<String, Object> defineEntityCache(Class type, int localLimit, int expire) {
        com.github.foxnic.commons.cache.DoubleCache<String, Object> dc=caches.get(type);
//        dc=null;
        if(dc==null) {
            String[] ns=type.getName().split("\\.");
            String cacheName="foxnic:data:"+ns[ns.length-2]+":"+ns[ns.length-1];
            RemoteCache<Object> remote = new RemoteCache<Object>(cacheName, expire);
            LocalCache<String, Object> local = new LocalCache<String, Object>(remote.isValid()?2*1000:expire, ExpireType.LIVE, localLimit);
            dc=new DoubleCache<Object>(cacheName, local, remote);
            caches.put(type,dc);
            return dc;
        }
        return null;
    }

    @Override
    public com.github.foxnic.commons.cache.DoubleCache<String, Object> getEntityCache(Class type) {
        return caches.get(type);
    }
}
