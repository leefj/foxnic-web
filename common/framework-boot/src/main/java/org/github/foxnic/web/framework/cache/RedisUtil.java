package org.github.foxnic.web.framework.cache;

import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.cache.redis.listener.RedisDataChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

 
 
@Component
public class RedisUtil {

    private static  RedisUtil instance = null;

    public static RedisUtil instance() {
        if(instance!=null) return instance;
        instance = SpringUtil.getBean(RedisUtil.class);
        return instance;
    }

	/**
	 * 默认 GenericJackson2JsonRedisSerializer ，值存为json，并支持泛型反序列化
	 * */
	public static RedisSerializer<Object> VALUE_SERIALIZER= new GenericJackson2JsonRedisSerializer();
	
	private  AtomicLong waitings=new AtomicLong();
	
	public long getWaitings()
	{
		return this.waitings.longValue();
	}

	private  final Logger LOG = LoggerFactory.getLogger(RedisUtil.class);
 
    private RedisTemplate<String, Object> redisTemplate;
    
    public RedisConnectionFactory getConnectionFactory()
    {
    	if(redisTemplate==null) return null;
    	return redisTemplate.getConnectionFactory();
    }

    @Resource
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        //设置Key序列化
        this.redisTemplate.setKeySerializer(RedisSerializer.string());
        this.redisTemplate.setHashKeySerializer(RedisSerializer.string());
        if(VALUE_SERIALIZER != null) {
        	this.redisTemplate.setValueSerializer(VALUE_SERIALIZER);
        }
        //启动预判
        SimpleTaskManager.doParallelTask(new Runnable() {
            @Override
            public void run() {
                RedisUtil.this.isValid();
            }
        });
    }


    /**
     * 后期可通过任务轮询 redis 是否OK
     * */
    private Boolean valid=null;
    /**
     * redis 是否可用
     * */
    public boolean isValid() {
        if(valid!=null) return valid;
        if(this.getConnectionFactory()==null) {
            valid=false;
            return valid;
        }
        int t=0;
        try {
            this.getConnectionFactory().getConnection();
            t++;
        } catch (Exception e) {}
        if(t==0) {
            try {
                this.getConnectionFactory().getClusterConnection();
                t++;
            } catch (Exception e) {}
        }
        if(t==0) {
            try {
                this.getConnectionFactory().getSentinelConnection();
                t++;
            } catch (Exception e) {}
        }
        valid=t>0;
        return  valid;
    }
    
    //=============================common============================  

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
            	waitings.incrementAndGet();
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
                waitings.decrementAndGet();
            }
            return true;
        } catch (Exception e) { 
            LOG.error("expire",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire(String key) {
    	waitings.incrementAndGet();
        long expire= redisTemplate.getExpire(key, TimeUnit.SECONDS);
        waitings.decrementAndGet();
        RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        return expire;
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key) {
        try {
        	waitings.incrementAndGet();
            boolean has= redisTemplate.hasKey(key);
            waitings.decrementAndGet();
            return has;
        } catch (Exception e) {
        	LOG.error("hasKey",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
        	waitings.incrementAndGet();
        	if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        	waitings.decrementAndGet();
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    //============================String=============================  

    /**
     * 普通缓存获取
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
    	waitings.incrementAndGet();
        Object obj= key == null ? null : redisTemplate.opsForValue().get(key);
        waitings.decrementAndGet();
        RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        return obj;
    }

    /**
     * 普通缓存放入，建议加入超时时间
     * 请设置超时时间
     * @param key   键
     * @param value 值
     * @return true成功 false失败

     */
    public boolean set(String key, Object value) {
        try {
        	waitings.incrementAndGet();
            redisTemplate.opsForValue().set(key, value);
            waitings.decrementAndGet();
            return true;
        } catch (Exception e) {
        	waitings.decrementAndGet();
        	LOG.error("set",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }



    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(单位:秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
            	waitings.incrementAndGet();
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
                waitings.decrementAndGet();
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
        	LOG.error("set",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 递增
     *
     * @param key 键
     * @param delta  要增加几(大于0)
     * @return
     */
    public long incr(String key, long delta) {
        if (delta <= 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        waitings.incrementAndGet();
        long i= redisTemplate.opsForValue().increment(key, delta);
        waitings.decrementAndGet();
        RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        return i;
    }

    /**
     * 递减
     *
     * @param key 键
     * @param delta  要减少几(小于0)
     * @return
     */
    public long decr(String key, long delta) {
       
     
    	
    	if (delta <= 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        waitings.incrementAndGet();
        long i = redisTemplate.opsForValue().increment(key, -delta);
        waitings.decrementAndGet();
        RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        return i;
    }

    //================================Map=================================  

    /**
     * HashGet
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public Object hget(String key, String item) {
    	waitings.incrementAndGet();
        Object obj= redisTemplate.opsForHash().get(key, item);
        waitings.decrementAndGet();
        RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        return obj;
    }

    /**
     * 获取hashKey对应的所有键值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<Object, Object> hmget(String key) {
    	waitings.incrementAndGet();
    	Map<Object, Object> map= redisTemplate.opsForHash().entries(key);
        waitings.decrementAndGet();
        RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        return map;
    }

    /**
     * HashSet
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
        	waitings.incrementAndGet();
            redisTemplate.opsForHash().putAll(key, map);
            waitings.decrementAndGet();
            return true;
        } catch (Exception e) {
        	LOG.error("hmset",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * HashSet 并设置时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
        	waitings.incrementAndGet();
            redisTemplate.opsForHash().putAll(key, map);
            waitings.decrementAndGet();
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
        	LOG.error("hmset",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return true 成功 false失败
     */
    public boolean hset(String key, String item, Object value) {
        try {
        	waitings.incrementAndGet();
            redisTemplate.opsForHash().put(key, item, value);
            waitings.decrementAndGet();
            return true;
        } catch (Exception e) {
        	LOG.error("hset",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public boolean hset(String key, String item, Object value, long time) {
        try {
        	waitings.incrementAndGet();
            redisTemplate.opsForHash().put(key, item, value);
            waitings.decrementAndGet();
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
        	LOG.error("hset",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key  键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public void hdel(String key, Object... item) {
    	waitings.incrementAndGet();
        redisTemplate.opsForHash().delete(key, item);
        waitings.decrementAndGet();
        RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public boolean hHasKey(String key, String item) {
    	waitings.incrementAndGet();
        boolean b = redisTemplate.opsForHash().hasKey(key, item);
        waitings.decrementAndGet();
        RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        return b;
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    public double hincr(String key, String item, double by) {
    	waitings.incrementAndGet();
        double val = redisTemplate.opsForHash().increment(key, item, by);
        waitings.decrementAndGet();
        RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        return val;
    }

    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    public double hdecr(String key, String item, double by) {
    	waitings.incrementAndGet();
        double d = redisTemplate.opsForHash().increment(key, item, -by);
        waitings.decrementAndGet();
        RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        return d;
    }

    //============================set=============================  

    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    public Set<Object> sGet(String key) {
        try {
        	waitings.incrementAndGet();
        	Set<Object> set= redisTemplate.opsForSet().members(key);
            waitings.decrementAndGet();
            return set;
        } catch (Exception e) {
        	 waitings.decrementAndGet();
        	LOG.error("sGet",e);
            return new HashSet<Object>();
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }
    
    /**
     * 批量设置
     * */
    public Map<String,Object> multiSet(Map<String,Object> map) {
 
    	try {
        	waitings.incrementAndGet();
        	redisTemplate.opsForValue().multiSet(map);
			waitings.decrementAndGet();
			return map;
		} catch (Exception e) {
			 waitings.decrementAndGet();
            LOG.error("loadKey",e);
            return map;
		}
    }
    
    /**
     * 批量设置
     * */
    public long delKeyStartsWith(String keyPrefix) {
    	Set<String> keys=this.searchKeys(keyPrefix+"*");
    	try {
        	waitings.incrementAndGet();
        	long r=redisTemplate.delete(keys);
			waitings.decrementAndGet();
			return r;
		} catch (Exception e) {
			 waitings.decrementAndGet();
            LOG.error("loadKey",e);
            return 0;
		}
    }
    

    /**
     * 批量获取
     * */
    public Map<String,Object> multiGet(Collection<String> keys) {
    	Map<String,Object> map=new HashMap<String, Object>();
    	try {
        	waitings.incrementAndGet();
        	List<Object> values = redisTemplate.opsForValue().multiGet(keys);
        	int i=0;
        	for (String key : keys) {
        		map.put(key, values.get(i));
        		i++;
			}
			waitings.decrementAndGet();
			return map;
		} catch (Exception e) {
			 waitings.decrementAndGet();
            LOG.error("loadKey",e);
            return map;
		}
     }
    

    /**
     * 根据关键字查询所有key
     * gxl
     */
    public Set<String> searchKeys(String keyWordOfkey) {
        try {
        	waitings.incrementAndGet();
        	Set<String> set = redisTemplate.keys(keyWordOfkey);
            waitings.decrementAndGet();
            return set;
        } catch (Exception e) {
        	 waitings.decrementAndGet();
            LOG.error("loadKey",e);
            return new HashSet<String>();
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean sHasKey(String key, Object value) {
        try {
        	waitings.incrementAndGet();
        	boolean b= redisTemplate.opsForSet().isMember(key, value);
            waitings.decrementAndGet();
            return b;
        } catch (Exception e) {
        	 waitings.decrementAndGet();
        	LOG.error("sHasKey",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSet(String key, Object... values) {
        try {
        	waitings.incrementAndGet();
            long val= redisTemplate.opsForSet().add(key, values);
            waitings.decrementAndGet();
            return val;
        } catch (Exception e) {
        	waitings.decrementAndGet();
        	LOG.error("sSet",e);
            return 0;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 将set数据放入缓存
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSetAndTime(String key, long time, Object... values) {
        try {
        	waitings.incrementAndGet();
            Long count = redisTemplate.opsForSet().add(key, values);
            waitings.decrementAndGet();
            if (time > 0) expire(key, time);
            return count;
        } catch (Exception e) {
        	waitings.decrementAndGet();
            LOG.error("sSetAndTime",e);
            return 0;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    public long sGetSetSize(String key) {
        try {
        	waitings.incrementAndGet();
            long ln= redisTemplate.opsForSet().size(key);
            waitings.decrementAndGet();
            return ln;
        } catch (Exception e) {
        	waitings.decrementAndGet();
            LOG.error("sGetSetSize",e);
            return 0;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public long setRemove(String key, Object... values) {
        try {
        	waitings.incrementAndGet();
            Long count = redisTemplate.opsForSet().remove(key, values);
            waitings.decrementAndGet();
            return count;
        } catch (Exception e) {
        	waitings.decrementAndGet();
            LOG.error("setRemove",e);
            return 0;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }
    //===============================list=================================  

    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束  0 到 -1代表所有值
     * @return
     */
    public List<Object> lGet(String key, long start, long end) {
        try {
        	waitings.incrementAndGet();
        	List<Object> list =redisTemplate.opsForList().range(key, start, end);
            waitings.decrementAndGet();
            return list;
        } catch (Exception e) {
            LOG.error("lGet",e);
            waitings.decrementAndGet();
            return new ArrayList<Object>();
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    public long lGetListSize(String key) {
        try {
        	waitings.incrementAndGet();
        	long val = redisTemplate.opsForList().size(key);
            waitings.decrementAndGet();
            return val;
        } catch (Exception e) {
        	 waitings.decrementAndGet();
            LOG.error("lGetListSize",e);
            return 0;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object lGetIndex(String key, long index) {
        try {
        	waitings.incrementAndGet();
        	Object obj = redisTemplate.opsForList().index(key, index);
            waitings.decrementAndGet();
            return obj;
        } catch (Exception e) {
        	waitings.decrementAndGet();
            LOG.error("lGetIndex",e);
            return null;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean lSet(String key, Object value) {
        try {
        	waitings.incrementAndGet();
            redisTemplate.opsForList().rightPush(key, value);
            waitings.decrementAndGet();
            return true;
        } catch (Exception e) {
            LOG.error("lSet",e);
            waitings.decrementAndGet();
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean lSet(String key, Object value, long time) {
        try {
        	waitings.incrementAndGet();
            redisTemplate.opsForList().rightPush(key, value);
            waitings.decrementAndGet();
            if (time > 0) expire(key, time);
            return true;
        } catch (Exception e) {
        	 waitings.decrementAndGet();
            LOG.error("lSet",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean lSet(String key, List<Object> value) {
        try {
        	waitings.incrementAndGet();
            redisTemplate.opsForList().rightPushAll(key, value);
            waitings.decrementAndGet();
            return true;
        } catch (Exception e) {
        	 waitings.decrementAndGet();
            LOG.error("lSet",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean lSet(String key, List<Object> value, long time) {
        try {
        	waitings.incrementAndGet();
            redisTemplate.opsForList().rightPushAll(key, value);
            waitings.decrementAndGet();
            if (time > 0) expire(key, time);
            return true;
        } catch (Exception e) {
        	 waitings.decrementAndGet();
            LOG.error("lSet",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    public boolean lUpdateIndex(String key, long index, Object value) {
        try {
        	waitings.incrementAndGet();
            redisTemplate.opsForList().set(key, index, value);
            waitings.decrementAndGet();
            return true;
        } catch (Exception e) {
        	 waitings.decrementAndGet();
            LOG.error("lUpdateIndex",e);
            return false;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 移除N个值为value
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public long lRemove(String key, long count, Object value) {
        try {
        	waitings.incrementAndGet();
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            waitings.decrementAndGet();
            return remove;
        } catch (Exception e) {
        	waitings.decrementAndGet();
            LOG.error("lRemove",e);
            return 0;
        }finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }
    
    /**
	* 创建锁
    *
    * @param key         锁的Key
    * @param value       值(随便写毫无意义)
    * @param releaseTime 锁过期时间 防止死锁 , 单位：秒
    * @return 是否加锁成功
    */
   public boolean lock(String key, Object value, int releaseTime) {
       // 尝试获取锁
       Boolean flag = redisTemplate.opsForValue().setIfAbsent(key, value, releaseTime, TimeUnit.SECONDS);
       // 判断结果
       return flag != null && flag;
   }
   
   /**
    * 解锁，配合 lock 方法使用
    * @param key the key
    */
   public void unlock(String key) {
	   redisTemplate.delete(key);
   }
   
   /**
    * 通知其它节点，对应的key值已经改变;前提是其它节点连接在同一个redis上
    * */
   public void notifyDataChange(String key) {
	   redisTemplate.convertAndSend(RedisDataChangeListener.DATA_CHANGE_NOTIFY_CHANEL_KEY, "key:"+key);
   }
   

   @Autowired
   private RedisDataChangeListener redisDataChangeListener;

   /**
    * 设置数据变更的通知处理器
    * */
   public void addDataChangeHandler(DataChangeHandler handler) {
       redisDataChangeListener.addHandler(handler);
   }

} 