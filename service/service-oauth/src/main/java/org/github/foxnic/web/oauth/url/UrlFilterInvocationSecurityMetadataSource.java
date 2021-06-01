package org.github.foxnic.web.oauth.url;

import java.util.Collection;

import org.github.foxnic.web.oauth.Constants;
import org.github.foxnic.web.oauth.authorization.PermissionAuthority;
import org.github.foxnic.web.oauth.config.web.SecurityConfigs;
import org.github.foxnic.web.oauth.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.web.WebContext;

/**
 * <p> 获取访问该url所需要的用户角色权限信息 </p>
 *
 * @author : zhengqing
 * @description : 执行完之后到 `UrlAccessDecisionManager` 中认证权限
 * @date : 2019/10/15 14:36
 */
@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

//    @Autowired
//    PermissionMapper permissionMapper;
//    @Autowired
//    RolePermissionMapper rolePermissionMapper;
//    @Autowired
//    RoleMapper roleMapper;
	
	@Autowired
	private SecurityConfigs  securityConfigs;

    /***
     * 返回该url所需要的用户权限信息
     *
     * @param object: 储存请求url信息
     * @return: null：标识不需要任何权限都可以访问
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 请求的url
        String url = ((FilterInvocation)object).getRequestUrl();
        // 忽略url请放在此处进行过滤放行
        if(securityConfigs.isIgnoredResource(RequestParameter.get().getRequest())) {
        	return null;
        }
        
     	//获得上下文 SecurityContext
        SecurityContext context = SecurityContextHolder.getContext();
        if(context==null || context.getAuthentication()==null || !context.getAuthentication().isAuthenticated()) {
        	 return SecurityConfig.createList(Constants.INVALID_SESSION);
        }
        Object principal=context.getAuthentication().getPrincipal();
        if(principal==null || !(principal instanceof SessionUser)) {
        	return SecurityConfig.createList(Constants.INVALID_SESSION);
        }
        SessionUser userDetail=(SessionUser)principal;
        //校验权限
        boolean hasPermission=userDetail.checkURLPermission(url);
        
        //如果有权限
        if(hasPermission) return null;
        else {
        	//缺少权限
        	return SecurityConfig.createList(Constants.PERMISSION_REQUIRE);
        }
 
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
