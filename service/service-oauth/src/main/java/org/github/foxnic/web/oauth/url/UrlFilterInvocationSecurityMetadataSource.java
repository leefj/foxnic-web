package org.github.foxnic.web.oauth.url;

import java.util.Collection;

import org.github.foxnic.web.oauth.Constants;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

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
        // TODO 忽略url请放在此处进行过滤放行
        if (UserServiceProxy.LOGIN_URI.equals(url) || UserServiceProxy.LOGOUT_URI.equals(url)) {
            return null;
        }

        // 数据库中所有url
//        List<Permission> permissionList = permissionMapper.selectList(null);
//        for (Permission permission : permissionList) {
//            // 获取该url所对应的权限
//            if (requestUrl.equals(permission.getUrl())) {
//                List<RoleMenu> permissions = rolePermissionMapper.selectList(new EntityWrapper<RoleMenu>().eq("permission_id", permission.getId()));
//                List<String> roles = new LinkedList<>();
//                if (!CollectionUtils.isEmpty(permissions)){
//                    Integer roleId = permissions.get(0).getRoleId();
//                    Role role = roleMapper.selectById(roleId);
//                    roles.add(role.getCode());
//                }
//                // 保存该url对应角色权限信息
//                return SecurityConfig.createList(roles.toArray(new String[roles.size()]));
//            }
//        }
        // 如果数据中没有找到相应url资源则为非法访问，要求用户登录再进行操作
        return SecurityConfig.createList(Constants.ROLE_LOGIN);
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
