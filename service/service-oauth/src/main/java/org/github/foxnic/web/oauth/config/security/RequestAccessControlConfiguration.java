package org.github.foxnic.web.oauth.config.security;

 
import java.util.List;

import org.github.foxnic.web.oauth.permission.PermissonFilterInvocationSecurityMetadataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * 动态权限组件配置
 *
 * @author Felordcn
 */
@Configuration
public class RequestAccessControlConfiguration {
 
    /**
     * 元数据加载器
     *
     * @return dynamicFilterInvocationSecurityMetadataSource
     */
    @Bean
    public FilterInvocationSecurityMetadataSource dynamicFilterInvocationSecurityMetadataSource() {
        return new PermissonFilterInvocationSecurityMetadataSource();
    }

    /**
     * 角色投票器
     *
     * @return roleVoter
     */
    @Bean
    public RoleVoter roleVoter() {
        return new RoleVoter();
    }

    /**
     * 基于肯定的访问决策器
     *
     * @param decisionVoters AccessDecisionVoter类型的 Bean 会自动注入到 decisionVoters
     * @return affirmativeBased
     */
    @Bean
    public AccessDecisionManager affirmativeBased(List<AccessDecisionVoter<?>> decisionVoters) {
        return new AffirmativeBased(decisionVoters);
    }

}
