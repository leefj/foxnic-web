package org.github.foxnic.web.framework.cache.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.foxnic.commons.lang.StringUtil;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Redis配置类
 */
@Configuration
public class RedisConfig {

    @Value("${jedis.enable:false}")
    private Boolean redisEnable=null;
    @Value("${jedis.sentinel.enable:false}")
    private Boolean sentinelEnable=null;
    @Value("${jedis.cluster.enable:false}")
    private Boolean clusterEnable=null;


    @Bean(name = "JedisConnectionFactory")
    public JedisConnectionFactory createJedisConnectionFactory(RedisProperties redisProperties,JedisPoolConfig poolConfig) {
        JedisConnectionFactory factory;

        if(clusterEnable) {
            RedisClusterConfiguration clusterConfiguration = getClusterConfiguration(redisProperties);
            factory = new JedisConnectionFactory(clusterConfiguration, poolConfig);
        } else if(sentinelEnable) {
            RedisSentinelConfiguration sentinelConfig = getSentinelConfiguration(redisProperties);
            factory = new JedisConnectionFactory(sentinelConfig, poolConfig);
        } else {
            factory = new JedisConnectionFactory(poolConfig);
            factory.setHostName(redisProperties.getHost());
            factory.setPort(redisProperties.getPort());
            factory.setDatabase(redisProperties.getDatabase());
        }

        // 设置密码
        if (!StringUtil.isBlank(redisProperties.getPassword())) {
            factory.setPassword(redisProperties.getPassword());
        }

        return factory;
    }



    @Bean(name = "RedisConnectionFactory")
    @Autowired
    public RedisConnectionFactory createRedisConnectionFactory(
            @Qualifier("JedisConnectionFactory") JedisConnectionFactory
                    factory) {
        return factory;
    }

    private static List<RedisNode> createSentinels(RedisProperties.Sentinel sentinel) {
        List<RedisNode> nodes = new ArrayList<>();
        for (String node : sentinel.getNodes()) {
            String[] parts = StringUtils.split(node, ":");
            Assert.state(parts.length == 2, "redis哨兵地址配置不合法！");
            nodes.add(new RedisNode(parts[0], Integer.valueOf(parts[1])));
        }
        return nodes;
    }

    private static RedisSentinelConfiguration getSentinelConfiguration(RedisProperties properties) {
        RedisProperties.Sentinel sentinel = properties.getSentinel();
        if (sentinel != null) {
            RedisSentinelConfiguration config = new RedisSentinelConfiguration();
            config.master(sentinel.getMaster());
            config.setSentinels(createSentinels(sentinel));
            return config;
        }
        return null;
    }


    private static RedisClusterConfiguration getClusterConfiguration(RedisProperties properties) {
        RedisProperties.Cluster cluster = properties.getCluster();
        if (cluster != null) {
            RedisClusterConfiguration config = new RedisClusterConfiguration(cluster.getNodes());
            if (cluster.getMaxRedirects() != null) {
                config.setMaxRedirects(cluster.getMaxRedirects());
            }
            return config;
        }
        return null;
    }

    @Bean
    @Autowired
    public RedisTemplate<String, Object> redisTemplate(@Qualifier("RedisConnectionFactory") RedisConnectionFactory
                                                               connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);

        template.setValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(
            @Qualifier("RedisConnectionFactory") RedisConnectionFactory factory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(factory);
        return stringRedisTemplate;
    }

    /**
     * jedisCluster
     */
    @Bean
    @Autowired
    public JedisCluster jedisCluster(@Qualifier("jedis.pool.config") JedisPoolConfig config,
                                     @Value("${spring.redis.cluster.nodes}") String hostAndPort,
                                     @Value("${spring.redis.password}") String password) {
        /**
         * 1 先检查redis集群是否已经配置
         */
        if (StringUtils.isEmpty(hostAndPort)) {
            throw new RuntimeException("Redis 集群初始化异常。请检查配置redis.host.address配置项");
        }

        /**
         * 2 根据配置构建hostAndPorts
         */
        Set<HostAndPort> hostAndPorts = Arrays.asList(hostAndPort.split(",")).stream().map(s -> {
            String[] split = s.split(":");
            return new HostAndPort(split[0], Integer.valueOf(split[1]));
        }).collect(Collectors.toSet());

        return new JedisCluster(hostAndPorts, 1000, 1000, 1, password, config);
    }

    @Bean(name = "jedis.pool.config")
    public JedisPoolConfig jedisPoolConfig(@Value("${jedis.pool.config.maxTotal:100}") int maxTotal,
                                           @Value("${jedis.pool.config.maxWaitMillis:5000}") int maxWaitMillis,
                                           @Value("${jedis.pool.config.maxIdle:10}") int maxIdle) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        return config;
    }
}
