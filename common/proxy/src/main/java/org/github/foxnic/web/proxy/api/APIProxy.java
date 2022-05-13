package org.github.foxnic.web.proxy.api;

import com.github.foxnic.api.proxy.InvokeSource;
import com.github.foxnic.api.proxy.InvokeSourceVar;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.reflect.ReflectUtil;
import org.github.foxnic.web.proxy.spring.AwareHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 用于无差别在单体应用和微服务应用间的调用
 * */
public class APIProxy {



	 @SuppressWarnings("unchecked")
    private static LocalCache<Class,Object> PROXY_CACHE=new LocalCache<>();

	public static <T> T get(Class<T> intfType,String controllerName){

        //缓存获取
        Object inst=PROXY_CACHE.get(intfType);
//        if (inst!=null && inst.toString().contains("UndeclaredThrowableException")) {
//            inst = null;
//        }
        if(inst!=null) return (T)inst;

        //首先尝试微服务模式下的Feign实现调用
        inst=getBean(intfType);
        if(inst!=null) {
            PROXY_CACHE.put(intfType,inst);
            return (T)inst;
        }

        //使用单体模式下的 JDK 动态代理实现调用
        inst=getInstance(intfType,controllerName);
        if(inst!=null) {
            PROXY_CACHE.put(intfType,inst);
            return (T)inst;
        }
        throw new RuntimeException("调用错误，"+intfType.getName()+" 实现异常");
    }


	static <T> T getBean(Class<T> clazz) {
		return AwareHandler.getBean(clazz);
	}




	public static <T> T getInstance(Class<T> intfType,String controllerName){
        Class ctrlClass = ReflectUtil.forName(controllerName);
        InvocationHandler invocationHandler=null;
        if(ctrlClass==null) {
            //throw new IllegalArgumentException("控制器 "+controllerName+" 不存在");
            invocationHandler = new RemoteMethodProxy();
        } else {
            invocationHandler = new MethodProxy(ctrlClass);
        }
        Object newProxyInstance = Proxy.newProxyInstance(
                intfType.getClassLoader(),
                new Class[]{intfType},
                invocationHandler);
        return (T) newProxyInstance;
    }

}

class RemoteMethodProxy implements InvocationHandler {

    private static final String CLUSTER_PROXY_NAME="org.github.foxnic.web.framework.cluster.ClusterProxy";
    private static Object proxyBus;
    private static Method proxyMethod;

    public RemoteMethodProxy(){
        if(proxyBus==null) {
            Class type = ReflectUtil.forName(CLUSTER_PROXY_NAME);
            proxyBus = (Object) APIProxy.getBean(type);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)  throws Throwable {
        InvokeSourceVar.set(InvokeSource.PROXY_EXTERNAL);
        if(proxyMethod==null) {
            proxyMethod = proxyBus.getClass().getMethod("invoke", Object.class, Method.class, Object[].class);
        }
        try {
            return proxyMethod.invoke(proxyBus,proxy,method,args);
        } catch (Exception e) {
            throw e.getCause();
        }

    }
}

class MethodProxy implements InvocationHandler {

    private Object controller;

    public MethodProxy(Class ctrlType){
        this.controller=(Object)APIProxy.getBean(ctrlType);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)  throws Throwable {
        InvokeSourceVar.set(InvokeSource.PROXY_INTERNAL);
        Method m=controller.getClass().getDeclaredMethod(method.getName(),method.getParameterTypes());
        try {
            Object r=m.invoke(controller,args);
            return r;
        } catch (Exception e) {
            throw e.getCause();
        }
    }
}
