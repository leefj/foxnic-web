package org.github.foxnic.web.framework.cache;

public abstract class DataChangeHandler {

	/**
	 * 处理回调
	 * */
	public abstract void handle(String key,RedisUtil redis);

}
