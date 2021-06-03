package org.github.foxnic.web.oauth.jwt;


 
import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.oauth.config.user.SessionUserDetailsManager;
import org.github.foxnic.web.oauth.exception.UserAuthenticationEntryPoint;
import org.github.foxnic.web.oauth.session.SessionUser;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.springboot.spring.SpringUtil;

/**
 * jwt 认证拦截器 用于拦截 请求 提取 jwt 认证
 *
 * @author dax
 * @since 2019/11/7 23:02
 */
 
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final String AUTHENTICATION_PREFIX = "Bearer ";
    /**
     * 认证如果失败由该端点进行响应
     */
    private AuthenticationEntryPoint authenticationEntryPoint;
    private JwtTokenGenerator jwtTokenGenerator;
    private JwtTokenStorage jwtTokenStorage;
    private SessionUserDetailsManager sessionUserDetailsManager;


    public JwtAuthenticationFilter(JwtTokenGenerator jwtTokenGenerator, JwtTokenStorage jwtTokenStorage) {
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.jwtTokenStorage = jwtTokenStorage;
       
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 如果已经通过认证
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            chain.doFilter(request, response);
            return;
        }
        
        if(authenticationEntryPoint==null) {
        	 this.authenticationEntryPoint=SpringUtil.getBean(UserAuthenticationEntryPoint.class);
        }
        
        if(sessionUserDetailsManager==null) {
            this.sessionUserDetailsManager=SpringUtil.getBean(SessionUserDetailsManager.class);
        }
        // 获取 header 解析出 jwt 并进行认证，若无token 则直接进入下一个过滤器。  因为  SecurityContext 的缘故 如果无权限并不会放行
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(header) && header.startsWith(AUTHENTICATION_PREFIX)) {
            String jwtToken = header.replace(AUTHENTICATION_PREFIX, "");

            if (StringUtils.hasText(jwtToken)) {
                try {
                    authenticationTokenHandle(jwtToken, request);
                } catch (AuthenticationException e) {
                    authenticationEntryPoint.commence(request, response, e);
                }
            } else {
                //带安全头 没有带token
                authenticationEntryPoint.commence(request, response, new AuthenticationCredentialsNotFoundException("token is not found"));
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * 具体的认证方法  匿名访问不要携带token
     * 有些逻辑自己补充 这里只做基本功能的实现
     *
     * @param jwtToken jwt token
     * @param request  request
     */
    private void authenticationTokenHandle(String jwtToken, HttpServletRequest request) throws AuthenticationException {

        // 根据我的实现 有效 token 才会被解析出来
        JSONObject jsonObject = jwtTokenGenerator.decodeAndVerify(jwtToken);
        if(jsonObject==null || jsonObject.isEmpty()) {
        	throw new BadCredentialsException("token 错误");
        }
  
        String userId = jsonObject.getString("uid");
        String jti = jsonObject.getString("jti");
      
        // 从缓存获取 token
        JwtTokenPair jwtTokenPair = jwtTokenStorage.get(jti);
        if (Objects.isNull(jwtTokenPair)) {
            //缓存中不存，失败了
            throw new CredentialsExpiredException("token is not in cache");
        }
        JwtToken accessToken = jwtTokenPair.getAccessToken();
        //比对 Token
        if (jwtToken.equals(accessToken.token())) {
        	UserDetails user=sessionUserDetailsManager.loadUserByUsername(userId);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, null);
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            // 放入安全上下文中
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        } else {
            throw new BadCredentialsException("token is not matched");
        }
 
    }
}

