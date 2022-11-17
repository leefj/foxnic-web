package org.github.foxnic.web.oauth.jwt;


import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.cluster.ClusterConfig;
import org.github.foxnic.web.framework.cluster.ClusterProxy;
import org.github.foxnic.web.framework.cluster.ClusterToken;
import org.github.foxnic.web.language.LanguageService;
import org.github.foxnic.web.oauth.config.user.SessionUserDetailsManager;
import org.github.foxnic.web.oauth.exception.UserAuthenticationEntryPoint;
import org.github.foxnic.web.oauth.jwt.reader.TokenReader;
import org.github.foxnic.web.oauth.login.LoginSuccessHandler;
import org.github.foxnic.web.oauth.session.SessionUserImpl;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * jwt 认证拦截器 用于拦截 请求 提取 jwt 认证
 *
 * @author dax
 * @since 2019/11/7 23:02
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {



    /**
     * 认证如果失败由该端点进行响应
     */
    private AuthenticationEntryPoint authenticationEntryPoint;
    private SessionUserDetailsManager sessionUserDetailsManager;
    private LoginSuccessHandler loginSuccessHandler;
    private ClusterConfig configs=null;
    private List<RequestMatcher> ignoredRequests=null;
    public List<RequestMatcher> getIgnoredRequests() {
        return ignoredRequests;
    }

    @Resource
    private LanguageService languageService;

    public void setIgnoredRequests(List<RequestMatcher> ignoredRequests) {
        this.ignoredRequests = ignoredRequests;
    }

    @PostConstruct
    void init() {
        configs=new ClusterConfig();
    }


    public JwtAuthenticationFilter(JwtTokenGenerator jwtTokenGenerator, JwtTokenStorage jwtTokenStorage) {
        TokenReader.initReaders();
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {



        // 如果是放行的资源
        for (RequestMatcher ignoredRequest : ignoredRequests) {
            if(ignoredRequest.matches(request)) {
                chain.doFilter(request, response);
                return;
            }
        }

        // 如果是登录登出的资源
        if(UserServiceProxy.LOGIN_URI.equals(request.getRequestURI())
                || UserServiceProxy.LOGIN_BY_CAPTCHA_URI.equals(request.getRequestURI())
                || UserServiceProxy.LOGOUT_URI.equals(request.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        TokenReader.UserId userId = null;
        try {
            userId=TokenReader.getUserId(request,true);
        } catch (Exception e) {}

        // 如果已经通过认证
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            SessionUser user=SessionUser.getCurrent();
            // 如果是SSO 登录地址
            if(UserServiceProxy.SSO_LOGIN_URI.equals(request.getRequestURI())) {
                // 如果不是同一个账户
                if(user.getUserId().equals(userId)) {
                    response.sendRedirect("/index.html");
                    return;
                } else {
                    // 继续处理 SSO 逻辑
                }
            } else {
                chain.doFilter(request, response);
                return;
            }
        }

        if(authenticationEntryPoint==null) {
            this.authenticationEntryPoint=SpringUtil.getBean(UserAuthenticationEntryPoint.class);
        }

        if(sessionUserDetailsManager==null) {
            this.sessionUserDetailsManager=SpringUtil.getBean(SessionUserDetailsManager.class);
        }

        // 判断内部集群的情况
        String clusterKey = request.getHeader(ClusterProxy.CLUSTER_KEY);
        if(clusterKey!=null) {
            // 集群 key 一致
            if (clusterKey.equals(configs.getKey())) {
                String clusterToken = request.getHeader(ClusterProxy.CLUSTER_TOKEN);
                if(StringUtils.hasText(clusterToken)) {
                    ClusterToken token=ClusterToken.fromToken(clusterToken);
                    authenticationClusterTokenHandler(token, chain, request,response);
                } else {
                    authenticationEntryPoint.commence(request, response, new AuthenticationCredentialsNotFoundException("调用时带 cluster_key 但缺少 cluster_token"));
                }
            } else {
                authenticationEntryPoint.commence(request, response, new AuthenticationCredentialsNotFoundException("调用时带 cluster_key 但与当前配置不匹配"));
            }
        }

        try {
            userId=TokenReader.getUserId(request,false);
        } catch (Exception e) {
            authenticationEntryPoint.commence(request, response, new BadCredentialsException("token read error",e));
            chain.doFilter(request, response);
            return;
        }

        if (StringUtil.isBlank(userId)) {
            authenticationEntryPoint.commence(request, response, new AuthenticationCredentialsNotFoundException("token is not found"));
            chain.doFilter(request, response);
            return;
        }

        try {
            authenticationJwtTokenHandler(userId, request,response);
        } catch (AuthenticationException e1) {
            authenticationEntryPoint.commence(request, response, e1);
        } catch (IllegalStateException e2) {
            authenticationEntryPoint.commence(request, response,new BadCredentialsException(e2.getMessage()));
        } catch (Exception e9) {
            authenticationEntryPoint.commence(request, response,new BadCredentialsException(e9.getMessage()));
        }

        chain.doFilter(request, response);
    }


    /**
     * 具体的认证方法  匿名访问不要携带token
     * 有些逻辑自己补充 这里只做基本功能的实现
     *
     * @param userId userId
     * @param request  request
     */
    private void authenticationJwtTokenHandler(TokenReader.UserId userId, HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        UserDetails user=sessionUserDetailsManager.loadUserByUsername(userId.value());
        SessionUserImpl sessionUser=(SessionUserImpl)user;
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, sessionUser.getAuthorities());
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        if(loginSuccessHandler==null) {
            loginSuccessHandler = SpringUtil.getBean(LoginSuccessHandler.class);
        }

        try {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            loginSuccessHandler.setupAuthentication(request,response,SecurityContextHolder.getContext().getAuthentication());
            // 放入安全上下文中
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            if(userId.sso()) {
                JSONObject json = loginSuccessHandler.makeLoginResponseJSON(request,response,SecurityContextHolder.getContext().getAuthentication());
                request.setAttribute(SessionUser.USER_LOGIN_JSON,json);
                languageService.setUserLanguage(userId.language());
            }
        } catch (Exception e) {
            Logger.error("Jwt Token 认证失败",e);
        }



    }

    /**
     * 具体的认证方法  匿名访问不要携带token
     * 有些逻辑自己补充 这里只做基本功能的实现
     *
     * @param token jwt token
     * @param request  request
     */
    private void authenticationClusterTokenHandler(ClusterToken token, FilterChain chain, HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

            UserDetails user=sessionUserDetailsManager.loadUserByUsername(token.getAccount());
            SessionUserImpl sessionUser=(SessionUserImpl)user;
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, sessionUser.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            if(loginSuccessHandler==null) {
                loginSuccessHandler = SpringUtil.getBean(LoginSuccessHandler.class);
            }

            try {
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                loginSuccessHandler.setupAuthentication(request,response,SecurityContextHolder.getContext().getAuthentication());
                // 放入安全上下文中
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }  catch (Exception e) {
                Logger.error("Cluster Token 认证失败",e);
            }

    }
}

