package org.github.foxnic.web.oauth.permission;

import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.oauth.service.IMenuService;
import org.github.foxnic.web.oauth.session.SessionPermissionImpl;
import org.github.foxnic.web.oauth.session.SessionUserImpl;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 参考 ExpressionBasedFilterInvocationSecurityMetadataSource
 *
 * @author Felordcn
 * @since 14:27 2019/11/27
 **/

public class PermissonFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    
    @Resource
    private IMenuService metaResourceService;
    

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

    	SessionUserImpl user=SessionUserImpl.getCurrent();
    	if(user==null) {
    		throw new AccessDeniedException("非法访问");
    	}

//    	开放全部，调试时使用
//    	if(user!=null) {
//            return SecurityConfig.createList(new String[] {"ROLE_super_admin"});
//     }


 
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        
        SessionPermissionImpl permission=(SessionPermissionImpl)user.permission();
        
        AntPathRequestMatcher matcher=permission.check(request);
        if(matcher==null) {
        	throw new AccessDeniedException("非法访问");
        }
     
        Collection<ConfigAttribute> attrs=permission.getConfigAttributesByMatcher(matcher);
        if(attrs==null) {
    		throw new AccessDeniedException("非法访问");
    	}
        
        return attrs;
        
//        // 这里可以放一个抽象接口来获取  request 配置的 ant pattern
//        Set<RequestMatcher> requestMatchers = convertToRequestMatcher(metaResourceService.queryList(Menu.create()));
//        // 去匹配之中的一个，如果没有，就抛出缺少权限的访问异常
//        RequestMatcher reqMatcher = requestMatchers.stream().filter(requestMatcher -> requestMatcher.matches(request)).findAny().orElseThrow(() -> new AccessDeniedException("非法访问"));
//
//        AntPathRequestMatcher antPathRequestMatcher = (AntPathRequestMatcher) reqMatcher;
//        // 根据pattern 获取该pattern被授权给的角色
//        String pattern = antPathRequestMatcher.getPattern();
//        List<String> roles = Arrays.asList("ROLE_admin") ;//s roleService.queryRoleByPattern(pattern);
//        return CollectionUtils.isEmpty(roles) ? null : SecurityConfig.createList(roles.toArray(new String[0]));
    }

    
    private Set<RequestMatcher> convertToRequestMatcher(List<Menu> menus) {
 
    	Set<RequestMatcher> matchers=new HashSet<RequestMatcher>();
    	for (Menu menu : menus) {
    		if(StringUtil.isBlank(menu.getPath())) continue;
    		AntPathRequestMatcher m=new AntPathRequestMatcher(menu.getPath(),"POST");
    		matchers.add(m);
		}
    	return matchers;
    	
	}

	@Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
		 return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
