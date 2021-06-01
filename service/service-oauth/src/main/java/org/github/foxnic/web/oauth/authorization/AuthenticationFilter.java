package org.github.foxnic.web.oauth.authorization;



import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.github.foxnic.web.oauth.Constants;
import org.github.foxnic.web.oauth.config.web.SecurityConfigs;
import org.github.foxnic.web.oauth.config.web.WebSecurityConfigurer;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.oauth.session.SessionUser;
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

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.mvc.Result;
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

	@Autowired
	private SecurityConfigs  securityConfigs;
	
    private final IUserService userDetailsService;
    
    @Autowired
    private WebContext webContext;

    protected AuthenticationFilter(IUserService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
 
    	//判断是否需要身份认证
    	boolean ignored=securityConfigs.isIgnoredResource(request);
    	if(ignored) {
    		userDetailsService.updateInteractTime();
    		filterChain.doFilter(request, response);
            return;
    	}
    	
    	 //判定请求性质
        boolean isStaticResorce=WebContext.isStaticResource(request);
        boolean isRestApi=false;
        if(!isStaticResorce) {
        	HandlerMethod handlerMethod = webContext.getHandlerMethod(request);
            if(handlerMethod!=null) {
            	isRestApi=Result.class.isAssignableFrom(handlerMethod.getMethod().getReturnType());
            }
        }
 
    	//获得上下文 SecurityContext
    	SecurityContext context = SecurityContextHolder.getContext();
    	//如果已经登录，去验证权限
        if (context.getAuthentication() != null && context.getAuthentication().isAuthenticated()) {
        	SessionUser user=SessionUser.getCurrent();
        	if(user.isSessionExpire()) {
        		context.setAuthentication(null);
        		request.getSession().invalidate();
        		handleResponse(filterChain, request, response, isStaticResorce, isRestApi);
        		return;
        	}
        	userDetailsService.updateInteractTime();
            filterChain.doFilter(request, response);
            return;
        }
        
       
        
        
        //获取 token
    	RequestParameter parameter=RequestParameter.get();
        String token = parameter.getHeader().get(SessionUser.TOKEN_KEY);
        
        //如果未登录，且无token
        if(StringUtil.isBlank(token)) {
        	handleResponse(filterChain,request,response, isStaticResorce, isRestApi);
        	return;
        }
        // 检查 token 登录情况
    	SessionUser securityUser = userDetailsService.getUserByToken(token);
    	//如果token无效或登录超时
    	if(securityUser==null || securityUser.isSessionExpire()) {
    		handleResponse(filterChain,request,response, isStaticResorce, isRestApi);
    		return;
    	}
 
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(securityUser, null, securityUser.getAuthorities());
        // 全局注入用户基本信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
 
//        //如果未登录，且是静态资源，跳转到登录页
//        
//        if(isStaticResorce) {
//        	 response.sendRedirect(securityConfigs.getLoginPage());
//             return;
//        }
//        
//       
//        HandlerMethod handlerMethod = webContext.getHandlerMethod(request);
//        
//        //如果未登录，无对应的实现方法，跳转到登录页
//        if(handlerMethod==null) {
//        	response.sendRedirect(securityConfigs.getLoginPage());
//        	return;
//        }
//        //如果未登录，且返回值类型不是 Result，跳转到登录页
//        if(!Result.class.isAssignableFrom(handlerMethod.getMethod().getReturnType())) {
//        	response.sendRedirect(securityConfigs.getLoginPage());
//        	return;
//        }
// 
       
        
        filterChain.doFilter(request , response);
    }

	private void handleResponse(FilterChain filterChain,HttpServletRequest request,HttpServletResponse response, boolean isStaticResorce, boolean isRestApi)
			throws IOException, ServletException {
		if(isStaticResorce || !isRestApi) {
			//跳转到登录页
			response.sendRedirect(securityConfigs.getLoginPage());
			return;
		} else {
			//返回JSON提示
			filterChain.doFilter(request, response);
			return;
		}
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
