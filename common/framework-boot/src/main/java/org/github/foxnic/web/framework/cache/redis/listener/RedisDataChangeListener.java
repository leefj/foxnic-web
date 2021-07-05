package org.github.foxnic.web.framework.cache.redis.listener;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.cache.DataChangeHandler;
import org.github.foxnic.web.framework.cache.RedisUtil;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@Component
public class RedisDataChangeListener implements MessageListener {

	public static final String DATA_CHANGE_NOTIFY_CHANEL_KEY="chanel:data-change";
	
	private HashMap<String, DataChangeHandler> handlers=new HashMap<>();
	
	public void setHandler(String key, DataChangeHandler handler) {
		handlers.put(key, handler);
	}
	
	@Override
	public void onMessage(Message message, byte[] pattern) {
		String key=message.toString();
		key= StringUtil.removeFirst(key, "\"");
		key=StringUtil.removeLast(key, "\"");
		List<String> parts=new ArrayList<String>();
		parts.addAll(Arrays.asList(key.split(":")));
		parts.remove(0);
		key=StringUtil.join(parts,":");
		DataChangeHandler handler=handlers.get(key);
		if(handler==null) {
			Logger.error("Handler 未设置 , key="+key);
			return;
		}
		try {
			handler.handle(key, SpringUtil.getBean(RedisUtil.class));
		} catch (Exception e) {
			Logger.error("Handler 处理错误 , key="+key,e);
		}
	}

	public boolean hasHandler(String key) {
		DataChangeHandler handler=handlers.get(key);
		return handler!=null;
	}

	

	
}
