package org.github.foxnic.web.framework.view.controller;

import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.proxy.spring.AwareHandler;
import org.github.foxnic.web.proxy.utils.ImplConfigUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.RequestMatchResult;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ViewController {

    private static final String DEFAULT_IMPL="default";

    private static RequestMappingHandlerMapping mapping;

    private static LocalCache<String,HandlerMethod> HANDLER_METHOD_CACHE=new LocalCache<>();

    public static HandlerMethod getHandlerMethod(HttpServletRequest request) {
        String url=getRequestPath(request);
        String m=request.getMethod();
        String key=m+"@"+url;
        HandlerMethod method=HANDLER_METHOD_CACHE.get(key);
        if(method!=null) return method;
        method=getHandlerMethod(url,m);
        HANDLER_METHOD_CACHE.put(key,method);
        return method;
    }


    public static HandlerMethod getHandlerMethod(final String url,final String method) {
        if(mapping==null) {
            mapping = AwareHandler.getBean(RequestMappingHandlerMapping.class);
        }
        AntPathMatcher urlMatcher = new AntPathMatcher();
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        RequestMappingInfo info = null;
        for (Map.Entry<RequestMappingInfo, HandlerMethod> e:map.entrySet()) {
            info=e.getKey();
            Set<String> patterns=info.getPatternsCondition().getPatterns();
            Set<RequestMethod> methods=info.getMethodsCondition().getMethods();
            for (String pattern : patterns) {
                for (RequestMethod rm : methods) {
                    AntPathRequestMatcher matcher = new AntPathRequestMatcher(pattern, rm.name());
                    if (matcher.matches(url, method) ) {
                        return e.getValue();
                    }
                }
                if (urlMatcher.match(pattern,url) ) {
                    return e.getValue();
                }
            }
        }

        return null;
    }

    public static String getRequestPath(HttpServletRequest request) {
        String url = request.getServletPath();
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            url = StringUtils.hasLength(url) ? url + pathInfo : pathInfo;
        }
        return url;
    }

    /**
     * 获得当前登录 SessionUser
     * */
    public SessionUser getCurrentUer() {
        return SessionUser.getCurrent();
    }

    public String getImplDir() {
        HttpServletRequest request=this.getRequest();
        if(request==null) return null;
        String impl=request.getParameter("impl");
        if(DEFAULT_IMPL.equals(impl)) {
            return null;
        }
        // 优先使用外部参数，未指定外部参数时，查询系统参数
        if(StringUtil.isBlank(impl)) {
            HandlerMethod method = getHandlerMethod(request);
            String implConfig = ImplConfigUtil.getViewImpl(method,getCurrentUer());
            if(StringUtil.hasContent(implConfig)) {
                impl=implConfig;
            }
        }
        return impl;
    }

    public String getTemplatePath(String prefix,String suffix) {
        String forkDir= getImplDir();
        prefix= StringUtil.trim(prefix,"/");
        suffix= StringUtil.trim(suffix,"/");
        if(StringUtil.isBlank(forkDir)) {
            return prefix+"/"+suffix;
        } else {
            return prefix+"/"+forkDir+"/"+suffix;
        }
    }


    public HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes!=null) {
            return attributes.getRequest();
        } else {
            return null;
        }
    }

}
