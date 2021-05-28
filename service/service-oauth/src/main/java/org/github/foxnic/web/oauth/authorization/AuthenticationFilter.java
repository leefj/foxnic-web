package org.github.foxnic.web.oauth.authorization;



import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.github.foxnic.web.oauth.Constants;
import org.github.foxnic.web.oauth.config.web.WebSecurityConfigurer;
import org.github.foxnic.web.oauth.domain.SOSUserDetails;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.oauth.utils.MultiReadHttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.web.WebContext;

/**
 *  <p> 访问鉴权 - 每次访问接口都会经过此过滤器 </p>
 *
 * @description :
 * @author : zhengqing
 * @date : 2019/10/12 16:17
 */
 
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	
    private final IUserService userDetailsService;
    
    @Autowired
    private WebContext webContent;

    protected AuthenticationFilter(IUserService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
 
    	//是否是一个被忽略的资源
    	boolean ignored=WebSecurityConfigurer.isIgnoredResource(request);
    	if(ignored) {
    		filterChain.doFilter(request, response);
            return;
    	}
 
    	//获得上下文 SecurityContext
    	SecurityContext context = SecurityContextHolder.getContext();
    	//如果已经登录
        if (context.getAuthentication() != null && context.getAuthentication().isAuthenticated()) {
            filterChain.doFilter(request, response);
            return;
        }
        
        //如果是静态资源
        boolean isStaticResorce=WebContext.isStaticResource(request);
        if(isStaticResorce) {
        	 filterChain.doFilter(request, response);
             return;
        }
    	
    	MultiReadHttpServletResponse wrappedResponse = new MultiReadHttpServletResponse(response);
    	RequestParameter parameter=RequestParameter.get();

//        if ((request.getContentType() == null && request.getContentLength() > 0) || (request.getContentType() != null && !request.getContentType().contains(Constants.REQUEST_HEADERS_CONTENT_TYPE))) {
//            filterChain.doFilter(request, response);
//            return;
//        }
 
    	
 
        String token = parameter.getHeader().get(SOSUserDetails.TOKEN_KEY);
          
        if (StringUtils.isNotBlank(token)) {
                // 检查token
            	SOSUserDetails securityUser = userDetailsService.getUserByToken(token);
                if (securityUser == null || securityUser.getUser() == null) {
                    throw new AccessDeniedException("TOKEN已过期，请重新登录！");
                }
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(securityUser, null, securityUser.getAuthorities());
                // 全局注入角色权限信息和登录用户基本信息
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter( request , wrappedResponse);
//        } finally {
////            stopWatch.stop();
////            long usedTimes = stopWatch.getTotalTimeMillis();
//            // 记录响应的消息体
////            logResponseBody(wrappedRequest, wrappedResponse, usedTimes);
//        }

    }

//    private String logRequestBody(HttpServletRequestWrapper request) {
//    	HttpServletRequestWrapper wrapper = request;
//        if (wrapper != null) {
//            try {
//                String bodyJson =   wrapper.getBodyJsonStrByJson(request);
//                String url = wrapper.getRequestURI().replace("//", "/");
//                System.out.println("-------------------------------- 请求url: " + url + " --------------------------------");
//                Constants.URL_MAPPING_MAP.put(url, url);
//                Logger.info("`{}` 接收到的参数: {}",url , bodyJson);
//                return bodyJson;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    private void logResponseBody(MultiReadHttpServletRequest request, MultiReadHttpServletResponse response, long useTime) {
//        MultiReadHttpServletResponse wrapper = response;
//        if (wrapper != null) {
//            byte[] buf = wrapper.getBody();
//            if (buf.length > 0) {
//                String payload;
//                try {
//                    payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
//                } catch (UnsupportedEncodingException ex) {
//                    payload = "[unknown]";
//                }
//                Logger.info("`{}`  耗时:{}ms  返回的参数: {}", Constants.URL_MAPPING_MAP.get(request.getRequestURI()), useTime, payload);
//            }
//        }
//    }

}
