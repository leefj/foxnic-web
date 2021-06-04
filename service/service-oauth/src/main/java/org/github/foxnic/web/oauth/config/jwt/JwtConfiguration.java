package org.github.foxnic.web.oauth.config.jwt;

import org.github.foxnic.web.oauth.config.security.SecurityProperties;
import org.github.foxnic.web.oauth.jwt.JwtAuthenticationFilter;
import org.github.foxnic.web.oauth.jwt.JwtTokenCacheStorage;
import org.github.foxnic.web.oauth.jwt.JwtTokenGenerator;
import org.github.foxnic.web.oauth.jwt.JwtTokenStorage;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * JwtConfiguration
 *
 * @author 李方捷
 * @since  2021-06-02
 */
@EnableConfigurationProperties(value= {JwtProperties.class,SecurityProperties.class})
@Configuration
public class JwtConfiguration {


    /**
     * Jwt token storage .
     *
     * @return the jwt token storage
     */
    @Bean
    public JwtTokenStorage jwtTokenStorage() {
        return new JwtTokenCacheStorage();
    }
 
    /**
     * Jwt token generator.
     *
     * @param jwtTokenStorage the jwt token storage
     * @param jwtProperties   the jwt properties
     * @return the jwt token generator
     */
    @Bean
    public JwtTokenGenerator jwtTokenGenerator(JwtTokenStorage jwtTokenStorage,SecurityProperties securityProperties, JwtProperties jwtProperties) {
        return new JwtTokenGenerator(jwtTokenStorage,securityProperties, jwtProperties);
    }
    
    /**
     * Jwt 认证过滤器.
     *
     * @param jwtTokenGenerator jwt 工具类 负责 生成 验证 解析
     * @param jwtTokenStorage   jwt 缓存存储接口
     * @return the jwt authentication filter
     */
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(JwtTokenGenerator jwtTokenGenerator, JwtTokenStorage jwtTokenStorage) {
        return new JwtAuthenticationFilter(jwtTokenGenerator, jwtTokenStorage);
    }
 
}
