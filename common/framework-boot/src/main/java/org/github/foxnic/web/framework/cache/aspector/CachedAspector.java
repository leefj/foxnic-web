package org.github.foxnic.web.framework.cache.aspector;

import com.github.foxnic.api.cache.Cached;
import com.github.foxnic.commons.cache.DoubleCache;
import com.github.foxnic.dao.entity.CacheStrategy;
import com.github.foxnic.dao.entity.SuperService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Collection;


@Aspect
@Component
public class CachedAspector {



	@Pointcut(value = "@annotation(com.github.foxnic.api.cache.Cached)")
	public void pointCut4Cached() {}

	@Around("org.github.foxnic.web.framework.cache.aspector.CachedAspector.pointCut4Cached()")
	public Object processCached(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature ms=(MethodSignature)joinPoint.getSignature();
		Method method=ms.getMethod();
		Cached cached=method.getAnnotation(Cached.class);
		if(joinPoint.getTarget() instanceof SuperService) {
			return processServiceMethod(joinPoint,cached);
		} else {
			return  joinPoint.proceed();
		}
	}

	private Object processServiceMethod(ProceedingJoinPoint joinPoint,Cached cached) throws Throwable {
		SuperService service=(SuperService)joinPoint.getTarget();
		DoubleCache<String,Object> cache=service.cache();
		CacheStrategy strategy=service.getCacheStrategy(cached.strategy());
		if(strategy==null || cache==null) {
			return joinPoint.proceed();
		}
		String key=strategy.makeKey(joinPoint.getArgs()[0]);
		//缓存键为空，通常是不符合精准匹配的缓存注解
		if(key==null) {
			return joinPoint.proceed();
		}
		Object result=cache.get(key);
		if(result==null) {
			result = joinPoint.proceed();
			boolean isEmpty=false;
			if(result==null) {
				isEmpty=true;
			} else {
				if(result instanceof Collection) {
					isEmpty=((Collection)result).isEmpty();
				}
			}
			//如果缓存null以及空集合
			if(strategy.isCacheEmptyResult()) {
				cache.put(key, result, cached.expire());
			} else {
				if(!isEmpty) {
					cache.put(key, result, cached.expire());
				}
			}
		}
		return result;
	}


}
