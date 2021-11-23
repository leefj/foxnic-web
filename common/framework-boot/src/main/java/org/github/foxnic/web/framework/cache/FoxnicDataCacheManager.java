package org.github.foxnic.web.framework.cache;

import com.github.foxnic.commons.cache.ExpireType;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.cache.DataCacheManager;
import com.github.foxnic.springboot.spring.SpringUtil;

import java.util.HashMap;
import java.util.Map;

public class FoxnicDataCacheManager extends DataCacheManager {


    private Map<Class,com.github.foxnic.commons.cache.DoubleCache> caches=new HashMap<>();

    public com.github.foxnic.commons.cache.DoubleCache<String,Object> defineOrGetJoinCache(Class type) {
        com.github.foxnic.commons.cache.DoubleCache<String, Object> dc=caches.get(type);
        if(dc!=null) {
            return dc;
        }
        //模式覆盖
        JoinCacheMode mode=this.getJoinCacheMode();
        String modeName= SpringUtil.getEnvProperty(this.getCacheDetailConfigPrefix()+"."+type.getName()+".mode");
        if(StringUtil.hasContent(modeName)) {
            mode=JoinCacheMode.valueOf(modeName);
        }
        //
        Integer localLimit=SpringUtil.getIntegerEnvProperty(this.getCacheDetailConfigPrefix()+"."+type.getName()+".local-limit");
        if(localLimit==null) {
            localLimit=this.getJoinLocalLimit();
        }
        //
        Integer localExpire=SpringUtil.getIntegerEnvProperty(this.getCacheDetailConfigPrefix()+"."+type.getName()+".local-expire");
        if(localExpire==null) {
            localExpire=this.getJoinLocalExpire();
        }
        //
        Integer remoteExpire=SpringUtil.getIntegerEnvProperty(this.getCacheDetailConfigPrefix()+"."+type.getName()+".remote-expire");
        if(remoteExpire==null) {
            remoteExpire=this.getJoinLocalExpire();
        }

        return defineOrGetJoinCache(type,mode,localLimit,localExpire,remoteExpire);
    }


    @Override
    public com.github.foxnic.commons.cache.DoubleCache<String, Object> defineOrGetJoinCache( Class type,JoinCacheMode cacheMode,int localLimit,int localExpire,int remoteExpire) {
        if(cacheMode==null ||cacheMode==JoinCacheMode.none) return null;
        com.github.foxnic.commons.cache.DoubleCache<String, Object> dc=caches.get(type);
        if(dc==null) {
            String[] ns=type.getName().split("\\.");
            String cacheName="foxnic:data:"+ns[ns.length-2]+":"+ns[ns.length-1];
            RemoteCache<Object> remote = null;
            LocalCache<String,Object> local = null;
            if(cacheMode==JoinCacheMode.remote) {
                remote=new RemoteCache<Object>(cacheName, remoteExpire);
            }
            else if(cacheMode==JoinCacheMode.both) {
                remote=new RemoteCache<Object>(cacheName, remoteExpire);
                local=new LocalCache<>(localExpire, ExpireType.LIVE,localLimit);
            }
            else if(cacheMode==JoinCacheMode.local) {
                local=new LocalCache<>(localExpire, ExpireType.LIVE,localLimit);
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
