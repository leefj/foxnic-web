package org.github.foxnic.web.framework.cache.aspector;

import com.github.foxnic.api.cache.Cached;
import com.github.foxnic.commons.cache.DoubleCache;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.cache.CacheStrategy;
import com.github.foxnic.dao.entity.SuperService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.github.foxnic.web.framework.cache.redis.RedisConfig;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.*;


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

		// 提取所有策略
		Set<String> names=new HashSet<>();
		if(StringUtil.hasContent(cached.value())) {
			names.add(cached.value());
		}
		for (String name : cached.strategies()) {
			names.add(name);
		}


		String key = null;
		CacheStrategy strategy = null;
		Object result = null;

		// 匹配策略
		for (String name : names) {

			strategy=service.getCacheStrategy(name);
			if(strategy==null) {
				return joinPoint.proceed();
			}
			key=strategy.makeKey(joinPoint.getArgs()[0]);
			if(key!=null) {
				// 取缓存值
				try {
					result = cache.get(key);
				} catch (Exception e) {
					Logger.exception(e);
				}

				// 如果取到值，返回；否则跳出循环，以当前 key 为准
				if (result != null) {
					return result;
				} else {
					break;
				}
			}
		}

		// 如果未有匹配的 key , 直接调用后返回
		if(key==null){
			return joinPoint.proceed();
		} else {
			result = joinPoint.proceed();
			boolean isEmpty = false;
			if (result == null) {
				isEmpty = true;
			} else {
				if (result instanceof Collection) {
					isEmpty = ((Collection) result).isEmpty();
				}
			}
			//如果缓存null以及空集合
			if (strategy.isCacheEmptyResult()) {
				cache.put(key, result);
			} else {
				if (!isEmpty) {
					cache.put(key, result);
				}
			}
			return result;
		}
	}


}
