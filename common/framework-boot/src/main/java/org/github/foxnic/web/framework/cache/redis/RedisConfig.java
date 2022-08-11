package org.github.foxnic.web.framework.cache.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.foxnic.commons.lang.StringUtil;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Redis配置类
 */
@Configuration
public class RedisConfig {

    /**
     * 默认 GenericJackson2JsonRedisSerializer ，值存为json，并支持泛型反序列化
     * */
    public final static RedisSerializer<Object> JACKSON_VALUE_SERIALIZER = new GenericJackson2JsonRedisSerializer();

    /**
     * 默认 FastJsonRedisSerializer ，值存为json，并支持泛型反序列化
     * */
    public final static RedisSerializer<Object> FASTJSON_VALUE_SERIALIZER = new FastJsonRedisSerializer(Object.class);


    /**
     * 默认 JdkSerializationRedisSerializer ，
     * */
    public final static RedisSerializer<Object>  JDK_VALUE_SERIALIZER = new JdkSerializationRedisSerializer();


    public static RedisSerializer<Object> VALUE_SERIALIZER = JACKSON_VALUE_SERIALIZER;



    @Value("${spring.redis.enable:false}")
    private Boolean standaloneEnable=null;
    @Value("${spring.redis.sentinel.enable:false}")
    private Boolean sentinelEnable=null;
    @Value("${spring.redis.cluster.enable:false}")
    private Boolean clusterEnable=null;


    @Bean(name = "JedisConnectionFactory")
    public JedisConnectionFactory createJedisConnectionFactory( @Autowired(required = false) RedisProperties redisProperties,JedisPoolConfig poolConfig) {
        JedisConnectionFactory factory;

        if(clusterEnable) {
            RedisClusterConfiguration clusterConfiguration = getClusterConfiguration(redisProperties);
            factory = new JedisConnectionFactory(clusterConfiguration, poolConfig);
        } else if(sentinelEnable) {
            RedisSentinelConfiguration sentinelConfig = getSentinelConfiguration(redisProperties);
            factory = new JedisConnectionFactory(sentinelConfig, poolConfig);
        } else {
            RedisStandaloneConfiguration standaloneConfiguration=getRedisStandaloneConfiguration(redisProperties);
            StandaloneJedisClientConfiguration clientConfiguration=new StandaloneJedisClientConfiguration();
            clientConfiguration.setPoolConfig(poolConfig);
            if(!standaloneEnable) {
                standaloneConfiguration.setHostName("");
                standaloneConfiguration.setPort(-1);
            }
            factory = new JedisConnectionFactory(standaloneConfiguration,clientConfiguration);
        }

        return factory;
    }


    private static RedisStandaloneConfiguration getRedisStandaloneConfiguration(RedisProperties properties) {
        RedisStandaloneConfiguration configuration=new RedisStandaloneConfiguration(properties.getHost(),properties.getPort());
        if(StringUtil.hasContent(properties.getPassword())){
            configuration.setPassword(properties.getPassword());
        }
        configuration.setDatabase(properties.getDatabase());
        return configuration;
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
            if(StringUtil.hasContent(properties.getPassword())){
                config.setPassword(properties.getPassword());
            }
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
            if(StringUtil.hasContent(properties.getPassword())){
                config.setPassword(properties.getPassword());
            }
            return config;
        }
        return null;
    }


    @Bean
    @Autowired
    public RedisTemplate<String, Object> redisTemplate(@Qualifier("JedisConnectionFactory") RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        template.setValueSerializer(VALUE_SERIALIZER);
        //使用 StringRedisSerializer 来序列化和反序列化 redis 的 key 值
        template.setKeySerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.string());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate( @Qualifier("JedisConnectionFactory") RedisConnectionFactory factory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(factory);
        return stringRedisTemplate;
    }

    /**
     * jedisCluster
     */
    @Bean
    @Autowired
    public JedisCluster jedisCluster(@Qualifier("spring.redis.pool.config") JedisPoolConfig config,
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

    @Bean(name = "spring.redis.pool.config")
    public JedisPoolConfig jedisPoolConfig(@Value("${spring.redis.pool.config.maxTotal:100}") int maxTotal,
                                           @Value("${spring.redis.pool.config.maxWaitMillis:5000}") int maxWaitMillis,
                                           @Value("${spring.redis.pool.config.maxIdle:10}") int maxIdle) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        return config;
    }
}



class StandaloneJedisClientConfiguration implements JedisClientConfiguration {
    private boolean useSsl;
    @Nullable
    private SSLSocketFactory sslSocketFactory;
    @Nullable
    private SSLParameters sslParameters;
    @Nullable
    private HostnameVerifier hostnameVerifier;
    private boolean usePooling = true;
    private GenericObjectPoolConfig poolConfig = new JedisPoolConfig();
    @Nullable
    private String clientName;
    private Duration readTimeout = Duration.ofMillis(2000L);
    private Duration connectTimeout = Duration.ofMillis(2000L);

    StandaloneJedisClientConfiguration() {
    }

    public static JedisClientConfiguration create(JedisShardInfo shardInfo) {
        StandaloneJedisClientConfiguration configuration = new StandaloneJedisClientConfiguration();
        configuration.setShardInfo(shardInfo);
        return configuration;
    }

    public static JedisClientConfiguration create(GenericObjectPoolConfig jedisPoolConfig) {
        StandaloneJedisClientConfiguration configuration = new StandaloneJedisClientConfiguration();
        configuration.setPoolConfig(jedisPoolConfig);
        return configuration;
    }

    public boolean isUseSsl() {
        return this.useSsl;
    }

    public void setUseSsl(boolean useSsl) {
        this.useSsl = useSsl;
    }

    public Optional<SSLSocketFactory> getSslSocketFactory() {
        return Optional.ofNullable(this.sslSocketFactory);
    }

    public void setSslSocketFactory(SSLSocketFactory sslSocketFactory) {
        this.sslSocketFactory = sslSocketFactory;
    }

    public Optional<SSLParameters> getSslParameters() {
        return Optional.ofNullable(this.sslParameters);
    }

    public void setSslParameters(SSLParameters sslParameters) {
        this.sslParameters = sslParameters;
    }

    public Optional<HostnameVerifier> getHostnameVerifier() {
        return Optional.ofNullable(this.hostnameVerifier);
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
    }

    public boolean isUsePooling() {
        return this.usePooling;
    }

    public void setUsePooling(boolean usePooling) {
        this.usePooling = usePooling;
    }

    public Optional<GenericObjectPoolConfig> getPoolConfig() {
        return Optional.ofNullable(this.poolConfig);
    }

    public void setPoolConfig(GenericObjectPoolConfig poolConfig) {
        this.poolConfig = poolConfig;
    }

    public Optional<String> getClientName() {
        return Optional.ofNullable(this.clientName);
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Duration getReadTimeout() {
        return this.readTimeout;
    }

    public void setReadTimeout(Duration readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Duration getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setConnectTimeout(Duration connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setShardInfo(JedisShardInfo shardInfo) {
        this.setSslSocketFactory(shardInfo.getSslSocketFactory());
        this.setSslParameters(shardInfo.getSslParameters());
        this.setHostnameVerifier(shardInfo.getHostnameVerifier());
        this.setUseSsl(shardInfo.getSsl());
        this.setConnectTimeout(Duration.ofMillis((long)shardInfo.getConnectionTimeout()));
        this.setReadTimeout(Duration.ofMillis((long)shardInfo.getSoTimeout()));
    }
}

class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private Class<T> clazz;

    public FastJsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (null == t) {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (null == bytes || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        return (T) JSON.parseObject(str, clazz);
    }
}
