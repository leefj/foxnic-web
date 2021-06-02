package org.github.foxnic.web.oauth.config.jwt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.github.foxnic.web.oauth.exception.SimpleAuthenticationEntryPoint;
import org.github.foxnic.web.oauth.jwt.JwtTokenCacheStorage;
import org.github.foxnic.web.oauth.jwt.JwtTokenGenerator;
import org.github.foxnic.web.oauth.jwt.JwtTokenPair;
import org.github.foxnic.web.oauth.jwt.JwtTokenStorage;
import org.github.foxnic.web.oauth.session.SessionUser;
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
 
}
