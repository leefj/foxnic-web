package org.github.foxnic.web.framework.cache;


import com.github.foxnic.commons.cache.Cache;
import com.github.foxnic.commons.cache.ExpireType;
import com.github.foxnic.commons.cache.LocalCache;

/**
 * 二级缓存，本地缓存与远程缓存结合
 * */
public class DoubleCache<V> extends com.github.foxnic.commons.cache.DoubleCache<String, V> {

	/**
	 * 超时时间均为毫秒(ms)
	 */
	public static <T> DoubleCache<T> create(String name, int localExpire, int localLimit, int remoteExpire) {
		LocalCache<String, T> local = new LocalCache<String, T>(localExpire, ExpireType.LIVE, localLimit);
		RemoteCache<T> remote = new RemoteCache<T>(name, remoteExpire);
		return new DoubleCache<T>(name, local, remote);
	}

	/**
	 * 根据远程缓存是否可以创建二级缓存
	 * 超时时间均为毫秒(ms)
	 */
	public static <T> DoubleCache<T> createAuto(String name, int localLimit, int expire) {
		RemoteCache<T> remote = new RemoteCache<T>(name, expire);
		LocalCache<String, T> local = new LocalCache<String, T>(remote.isValid()?2*1000:expire, ExpireType.LIVE, localLimit);
		return new DoubleCache<T>(name, local, remote);
	}
	
	public DoubleCache(String name, Cache<String,V> local, Cache<String,V> remote) {
		super(name, local, remote);
	}
 
}