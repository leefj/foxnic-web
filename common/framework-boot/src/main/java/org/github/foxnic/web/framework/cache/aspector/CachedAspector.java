package org.github.foxnic.web.framework.cache.aspector;

import com.github.foxnic.api.cache.Cached;
import com.github.foxnic.commons.cache.DoubleCache;
import com.github.foxnic.dao.cache.CacheStrategy;
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
		if(cache==null) {
			return joinPoint.proceed();
		}

		String name=cached.value();
		String key = null;
		CacheStrategy strategy = null;
		Object result = null;
		strategy=service.getCacheStrategy(name);
		if(strategy==null) {
			return joinPoint.proceed();
		}
		key=strategy.makeKey(joinPoint.getArgs()[0]);
		if(key==null){
			return joinPoint.proceed();
		}
		result=cache.get(key);
//			if(result!=null){
//				break;
//			}
//		}

		if(result!=null) {
			return result;
		}

		result = joinPoint.proceed();

//		for (String name : names) {
//			strategy = service.getCacheStrategy(name);
//			if (strategy == null || cache == null) {
//				continue;
//			}
//			key = strategy.makeKey(joinPoint.getArgs()[0]);
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
				cache.put(key, result);
			} else {
				if(!isEmpty) {
					cache.put(key, result);
				}
			}
//		}


//		CacheStrategy strategy=service.getCacheStrategy();
//		if(strategy==null || cache==null) {
//			return joinPoint.proceed();
//		}
//
//		//缓存键为空，通常是不符合精准匹配的缓存注解
//		if(key==null) {
//			return joinPoint.proceed();
//		}
//		Object result=cache.get(key);
//		if(result==null) {
//			result = joinPoint.proceed();
//			boolean isEmpty=false;
//			if(result==null) {
//				isEmpty=true;
//			} else {
//				if(result instanceof Collection) {
//					isEmpty=((Collection)result).isEmpty();
//				}
//			}
//			//如果缓存null以及空集合
//			if(strategy.isCacheEmptyResult()) {
//				cache.put(key, result);
//			} else {
//				if(!isEmpty) {
//					cache.put(key, result);
//				}
//			}
//		}
		return result;
	}


}
