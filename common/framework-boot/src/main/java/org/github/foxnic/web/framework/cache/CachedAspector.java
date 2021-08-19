package org.github.foxnic.web.framework.cache;

import com.github.foxnic.dao.entity.SuperService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CachedAspector {

	@Pointcut(value = "@annotation(com.github.foxnic.api.cache.Cached)")
	public void pointCut4Cached() {}

	@Around("org.github.foxnic.web.framework.cache.CachedAspector.pointCut4Cached()")
	public Object processCached(ProceedingJoinPoint joinPoint) throws Throwable {
		if(joinPoint.getTarget() instanceof SuperService) {
			return processServiceMethod(joinPoint);
		} else {
			return  joinPoint.proceed();
		}
	}

	private Object processServiceMethod(ProceedingJoinPoint joinPoint) {
		return null;
	}


}
