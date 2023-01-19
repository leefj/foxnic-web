package org.github.foxnic.web.framework.web;

import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.apache.poi.ss.formula.functions.T;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.context.annotation.Primary;

import javax.swing.*;
import java.util.List;

public class ServiceHub {

    private static LocalCache<String,Object> SERVICE_CACHE=new LocalCache<>();

    public static void removeCachedService(Class serviceType,String tenantId) {
        String cacheKey= getCacheKey(serviceType,tenantId);
        SERVICE_CACHE.remove(cacheKey);
    }

    public static void removeCachedService(Class serviceType) {
        SessionUser user=SessionUser.getCurrent();
        String tenantId = null;
        if(user!=null) {
            tenantId=user.getActivatedTenantId();
        }
        removeCachedService(serviceType,tenantId);
    }

    /**
     * 按当前登录账户所属租户获取 Service 的实现对象，无租户时获得默认实现
     * */
    public static <T>  T get(Class<T> serviceType) {
        return get(serviceType,true);
    }

    /**
     * 按当前登录账户所属租户获取 Service 的实现对象，无租户时获得默认实现
     * */
    public static <T>  T get(Class<T> serviceType,boolean cache) {
        SessionUser user=SessionUser.getCurrent();
        String tenantId = null;
        if(user!=null) {
            tenantId=user.getActivatedTenantId();
        }
        return get(serviceType,tenantId,cache);
    }

    /**
     * 指定租户ID，获取租户对应的 Service 的实现对象，租户为空，获得默认实现
     * */
    public static <T>  T get(Class<T> serviceType,String tenantId,boolean cache) {
        // 先从缓存获取
        String cacheKey= getCacheKey(serviceType,tenantId);
        T service = null;
        if(cache) {
            service =(T) SERVICE_CACHE.get(cacheKey);
            if (service != null) {
                return service;
            }
        }
        //
        List<T> serviceList = SpringUtil.getBeans(serviceType);
        if(serviceList==null || serviceList.isEmpty()) return null;
        String configKey = null;
        String implTypeName = null;
        if(tenantId!=null) {
            // 优先读取租户配置键
            configKey="system.service." + serviceType.getName() + ".Impl@" + tenantId;
            implTypeName = SystemConfigProxyUtil.getString(configKey);
            if(StringUtil.isBlank(implTypeName)) {
                configKey="system.service." + serviceType.getName() + ".Impl";
                implTypeName = SystemConfigProxyUtil.getString(configKey);
            }
        }

        if(StringUtil.isBlank(implTypeName)) {
            service = getPrimaryService(serviceList);
        } else {
            Class<T> clazz= ReflectUtil.forName(implTypeName,true);
            if(clazz==null) {
                throw new RuntimeException(implTypeName+" 不是一个有效的类型");
            }
            service = getTypedService(serviceList,clazz);
        }
        SERVICE_CACHE.put(cacheKey,service);
        return service;
    }

    private static String getCacheKey(Class serviceType,String tenantId) {
        // 先从缓存获取
        String cacheKey= null;
        if(tenantId!=null) {
            cacheKey= serviceType.getName()+"@"+tenantId;
        } else {
            cacheKey= serviceType.getName();
        }
        return cacheKey;
    }

    private static <T> T getTypedService(List<T> serviceList,Class<T> type) {
        if(serviceList==null || serviceList.isEmpty()) return null;
        try {
            return SpringUtil.getBean(type);
        } catch (Exception e) {
            return null;
        }
    }

    private static <T> T getPrimaryService(List<T> serviceList) {
        if(serviceList==null || serviceList.isEmpty()) return null;
        if(serviceList.size()==1) return serviceList.get(0);
        Primary ann = null;
        for (T service : serviceList) {
            ann=service.getClass().getSuperclass().getAnnotation(Primary.class);
            if(ann!=null) return service;
        }
        return serviceList.get(0);
    }

}
