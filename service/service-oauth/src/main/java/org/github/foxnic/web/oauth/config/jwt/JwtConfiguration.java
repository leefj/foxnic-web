package org.github.foxnic.web.oauth.config.jwt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.github.foxnic.web.oauth.config.user.SessionUser;
import org.github.foxnic.web.oauth.exception.SimpleAuthenticationEntryPoint;
import org.github.foxnic.web.oauth.jwt.JwtProperties;
import org.github.foxnic.web.oauth.jwt.JwtTokenCacheStorage;
import org.github.foxnic.web.oauth.jwt.JwtTokenGenerator;
import org.github.foxnic.web.oauth.jwt.JwtTokenPair;
import org.github.foxnic.web.oauth.jwt.JwtTokenStorage;
import org.github.foxnic.web.oauth.utils.ResponseUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.springboot.web.ResponseUtils;

/**
 * JwtConfiguration
 *
 * @author Felordcn
 * @since 16 :54 2019/10/25
 */
@EnableConfigurationProperties(JwtProperties.class)
@ConditionalOnProperty(prefix = "jwt.config",name = "enabled")
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
    public JwtTokenGenerator jwtTokenGenerator(JwtTokenStorage jwtTokenStorage, JwtProperties jwtProperties) {
        return new JwtTokenGenerator(jwtTokenStorage, jwtProperties);
    }

    /**
     * 处理登录成功后返回 JWT Token 对.
     *
     * @param jwtTokenGenerator the jwt token generator
     * @return the authentication success handler
     */
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(JwtTokenGenerator jwtTokenGenerator) {
        return (request, response, authentication) -> {
            if (response.isCommitted()) {
                Logger.debug("Response has already been committed");
                return;
            }
            Map<String, Object> map = new HashMap<>(5);
            map.put("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            //map.put("flag", "success_login");
            SessionUser principal = (SessionUser) authentication.getPrincipal();

            String username = principal.getUsername();
            Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
            Set<String> roles = new HashSet<>();
            if (authorities!=null && !authorities.isEmpty()) {
                for (GrantedAuthority authority : authorities) {
                    String roleName = authority.getAuthority();
                    roles.add(roleName);
                }
            }

            JwtTokenPair jwtTokenPair = jwtTokenGenerator.jwtTokenPair(username, roles, null);

            map.put("access_token", jwtTokenPair.getAccessToken());
            map.put("refresh_token", jwtTokenPair.getRefreshToken());

            ResponseUtil.writeOK(response, ErrorDesc.success().message("登录成功").data(map));
        };
    }

    /**
     * 失败登录处理器 处理登录失败后的逻辑 登录失败返回信息 以此为依据跳转
     *
     * @return the authentication failure handler
     */
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return (request, response, e) -> {
        	SimpleAuthenticationEntryPoint.handleException(response, e);
        };
    }

}
