package org.github.foxnic.web.framework.cache;

import com.github.foxnic.api.cache.Cached;
import com.github.foxnic.commons.cache.DoubleCache;
import com.github.foxnic.dao.entity.CacheHelper;
import com.github.foxnic.dao.entity.SuperService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class CachedAspector {



	@Pointcut(value = "@annotation(com.github.foxnic.api.cache.Cached)")
	public void pointCut4Cached() {}

	@Around("org.github.foxnic.web.framework.cache.CachedAspector.pointCut4Cached()")
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
		DoubleCache<String,Object> cache=service.getCache();
		CacheHelper cacheHelper=service.getCacheHelper(cached.helper());
		if(cacheHelper==null || cache==null) {
			return joinPoint.proceed();
		}
		String key=cacheHelper.makeKey(joinPoint.getArgs()[0]);
		Object result=cache.get(key);
		if(result==null) {
			result = joinPoint.proceed();
			cache.put(key,result);
		}
		return result;
	}


}
