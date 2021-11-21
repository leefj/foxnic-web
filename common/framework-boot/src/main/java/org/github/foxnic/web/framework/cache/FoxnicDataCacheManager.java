package org.github.foxnic.web.framework.cache;

import com.github.foxnic.commons.cache.ExpireType;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.dao.cache.DataCacheManager;

import java.util.HashMap;
import java.util.Map;

public class FoxnicDataCacheManager extends DataCacheManager {


    private Map<Class,com.github.foxnic.commons.cache.DoubleCache> caches=new HashMap<>();

    @Override
    public com.github.foxnic.commons.cache.DoubleCache<String, Object> defineEntityCache( Class type,JoinCacheMode cacheMode,int localLimit, int expire) {
        if(cacheMode==null ||cacheMode==JoinCacheMode.none) return null;
        com.github.foxnic.commons.cache.DoubleCache<String, Object> dc=caches.get(type);
        if(dc==null) {
            String[] ns=type.getName().split("\\.");
            String cacheName="foxnic:data:"+ns[ns.length-2]+":"+ns[ns.length-1];
            RemoteCache<Object> remote = null;
            LocalCache<String,Object> local = null;
            if(cacheMode==JoinCacheMode.remote) {
                remote=new RemoteCache<Object>(cacheName, expire);
            }
            else if(cacheMode==JoinCacheMode.both) {
                remote=new RemoteCache<Object>(cacheName, expire);
                local=new LocalCache<>(2000, ExpireType.LIVE,localLimit);
            }
            else if(cacheMode==JoinCacheMode.local) {
                local=new LocalCache<>(-1, ExpireType.LIVE,localLimit);
            }
            dc=new DoubleCache<Object>(cacheName, local, remote);
            caches.put(type,dc);
            return dc;
        }
        return dc;
    }

    @Override
    public com.github.foxnic.commons.cache.DoubleCache<String, Object> getEntityCache(Class type) {
        return caches.get(type);
    }
}
