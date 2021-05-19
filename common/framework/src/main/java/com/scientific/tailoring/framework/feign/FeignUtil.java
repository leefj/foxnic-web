package com.scientific.tailoring.framework.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.foxnic.springboot.spring.SpringUtil;

import feign.Request;

public class FeignUtil {
	
	private static Logger lg=LoggerFactory.getLogger(FeignUtil.class);
	
	public static void logConfigs()
	{
		Request.Options opts=SpringUtil.getBean(Request.Options.class);
//		lg.info("Feign ConnectTimeout : "+opts.connectTimeout()+" "+opts.connectTimeoutUnit().name()); 
//		lg.info("Feign ReadTimeout : "+opts.readTimeout()+" "+opts.readTimeoutUnit().name()); 
	}

}
