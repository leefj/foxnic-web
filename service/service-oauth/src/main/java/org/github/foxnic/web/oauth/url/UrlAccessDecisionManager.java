package org.github.foxnic.web.oauth.url;

 
import java.util.Collection;

import org.github.foxnic.web.oauth.Constants;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.github.foxnic.springboot.mvc.RequestParameter;

/**
 * <p> 对访问url进行权限认证处理 </p>
 *
 * @author : zhengqing
 * @description :
 * @date : 2019/10/15 14:21
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {

    /**
     * @param authentication: 当前登录用户的角色信息
     * @param object: 请求url信息
     * @param collection: `UrlFilterInvocationSecurityMetadataSource`中的getAttributes方法传来的，表示当前请求需要的角色（可能有多个）
     * @return: void
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> collection) throws AccessDeniedException, AuthenticationException {
 
    	// 遍历角色
        for (ConfigAttribute ca : collection) {
            //当前url请求需要的权限
            String needRole = ca.getAttribute();
            if (Constants.INVALID_SESSION.equals(needRole)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new BadCredentialsException("未登录");
                } else {
                    throw new AccessDeniedException("URL 未授权 , "+RequestParameter.get().getRequest().getRequestURL());
                }
            } else if (Constants.PERMISSION_REQUIRE.equals(needRole)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new BadCredentialsException("未登录");
                } else {
                    throw new AccessDeniedException("URL 未授权 , "+RequestParameter.get().getRequest().getRequestURL());
                }
            }
//            // ② 当前用户所具有的角色
//            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//            for (GrantedAuthority authority : authorities) {
//                // 只要包含其中一个角色即可访问
//                if (authority.getAuthority().equals(needRole)) {
//                    return;
//                }
//            }
        }
        throw new AccessDeniedException("请联系管理员分配权限！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
