package org.github.foxnic.web.framework.cache;


import com.github.foxnic.commons.cache.Cache;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.springboot.spring.SpringUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;


@SuppressWarnings("unchecked")
public class RemoteCache<V> extends Cache<String, V> {

	private RedisUtil cache=null;

	private int expire=0;

	/**
	 * @param name 缓存名称
	 * @param expire 超时时间，单位毫秒
	 * */
	public RemoteCache(String name,int expire)
	{
		name= StringUtil.removeFirst(name, ":");
		name=StringUtil.removeLast(name, ":");
		this.setName(name);
		//毫秒转为秒
		this.expire=expire/1000;
		this.cache= SpringUtil.getBean(RedisUtil.class);

	}

	/**
	 * 是否可用
	 * */
	public  boolean isValid() {
		if(this.cache==null) return false;
		return this.cache.isValid();
	}

	private String getRedisKey(String key)
	{
		return this.getName()+":"+key;
	}

	@Override
	public boolean exists(String key) {
		key=getRedisKey(key);
		return this.cache.hasKey(key);
	}

	@Override
	public V get(String key) {
		key=getRedisKey(key);
		return (V)this.cache.get(key);
	}

	@Override
	public Map<String, V> get(Set<String> keys) {
		return null;
	}

	@Override
	public V get(String key, Function<String, V> generator) {
		key=getRedisKey(key);
		Object value=this.cache.get(key);
		if(value!=null) return (V)value;
		value=generator.apply(key);
		this.cache.set(key, value,this.expire);
		return (V)value;
	}


	public Set<String> getKeys()
	{
		return this.cache.searchKeys(this.getName()+":*");
	}

	@Override
	public Map<String, V> getAll(Set<? extends String> arg0) {
		Set<String> keys=new HashSet<>();
		for (String string : arg0) {
			keys.add(this.getRedisKey(string));
		}
		return (Map<String, V>)this.cache.multiGet(keys);
	}

	@Override
	public void put(String key, V value) {
		key=getRedisKey(key);
		this.cache.set(key,value);
	}

	@Override
	public void put(Map<String, V> kvs) {

	}

	@Override
	public void put(String key, V value,int expire) {
		key=getRedisKey(key);
		if(expire>0) {
			this.cache.set(key, value, expire);
		} else {
			this.cache.set(key,value);
		}
	}

	@Override
	public void putAll(Map<? extends String, ? extends V> arg0) {
		Map<String,Object> map=new HashMap<String, Object>();
		for (Map.Entry<? extends String, ? extends V> e : arg0.entrySet()) {
			map.put(this.getRedisKey(e.getKey()), e.getValue());
		}
		this.cache.multiSet(map);
	}

	/**
	 *
	 * */
	public void removeKeyStarts(String keyPrefix) {
		this.cache.delKeyStartsWith(this.getRedisKey(keyPrefix));
	}

	@Override
	public V remove(String key) {
		Object value=this.get(key);
		key=getRedisKey(key);
		this.cache.del(key);
		return (V)value;
	}

	@Override
	public void removeAll(Set<? extends String> keys) {
		for (String key : keys) {
			//无name前缀的key
			this.cache.del(key);
			key=getRedisKey(key);
			//有name前缀的key
			this.cache.del(key);
		}
	}

	@Override
	public void clear() {
		Set<String> keys=this.cache.searchKeys(this.getName()+":*");
		this.removeAll(keys);
	}

	@Override
	public Set<String> keys() {
		Set<String> keys=this.cache.searchKeys("*");
		return keys;
	}

	@Override
	public Set<String> keys(String prefix) {
		Set<String> keys=this.cache.searchKeys(prefix+":*");
		return keys;
	}

	@Override
	public Map<String, V> values() {
		return null;
	}



}
