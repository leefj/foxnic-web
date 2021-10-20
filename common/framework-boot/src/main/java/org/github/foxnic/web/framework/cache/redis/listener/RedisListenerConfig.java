package org.github.foxnic.web.framework.cache.redis.listener;


import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.cache.RedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.util.TreeMap;

@Configuration
public class RedisListenerConfig {

	@Bean
	public RedisMessageListenerContainer getRedisMessageListenerContainer()
	{

		RedisUtil redis= SpringUtil.getBean(RedisUtil.class);

		if(redis==null || redis.getConnectionFactory()==null || !redis.isValid()) {
			Logger.error("redis 配置错误，无法进行 notify 操作");
			return null;
		}


		TreeMap cfg=SpringUtil.getEnvProperties("spring.redis");
		if(cfg==null || cfg.isEmpty()) {
			Logger.error("redis 配置错误，无法进行 notify 操作");
			return null;
		}
		RedisMessageListenerContainer container=new RedisMessageListenerContainer();
		container.setConnectionFactory(redis.getConnectionFactory());
		RedisDataChangeListener dcl=SpringUtil.getBean(RedisDataChangeListener.class);
		container.addMessageListener(dcl, new ChannelTopic(RedisDataChangeListener.DATA_CHANGE_NOTIFY_CHANEL_KEY));
		return container;
	}



}
