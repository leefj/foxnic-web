package org.github.foxnic.web.oauth.config.security;


import javax.annotation.Resource;

import org.github.foxnic.web.oauth.exception.SimpleAccessDeniedHandler;
import org.github.foxnic.web.oauth.exception.SimpleAuthenticationEntryPoint;
import org.github.foxnic.web.oauth.login.PreLoginFilter;
import org.github.foxnic.web.oauth.logout.CustomLogoutHandler;
import org.github.foxnic.web.oauth.logout.CustomLogoutSuccessHandler;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.github.foxnic.springboot.spring.SpringUtil;

/**
 * CustomSpring
 *
 * @author Felordcn
 * @see org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration
 * @since 14 :58 2019/10/15
 */
@Configuration
@ConditionalOnClass(WebSecurityConfigurerAdapter.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfiguration {
	
    private static final String LOGIN_PROCESSING_URL = UserServiceProxy.LOGIN_URI;


    
    /**
     * Json login post processor json login post processor.
     *
     * @return the json login post processor
     */
//    @Bean
//    public JsonLoginPostProcessor jsonLoginPostProcessor(){
//        return new JsonLoginPostProcessor();
//    }

    /**
     * Pre login filter pre login filter.
     *
     * @param loginPostProcessors the login post processors
     * @return the pre login filter
     */
    @Bean
    public PreLoginFilter preLoginFilter(){
        return new PreLoginFilter(LOGIN_PROCESSING_URL);
    }
    
    
    /**
     * 替换默认的 DaoAuthenticationProvider
     * */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserDetailsManager mngr){
    	DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
    	//当账户不存在时，显示账户不存在
    	provider.setHideUserNotFoundExceptions(false);
    	provider.setUserDetailsService(mngr);
        return provider;
    }

    /**
     * The type Default configurer adapter.
     */
    @Configuration
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    static class DefaultConfigurerAdapter extends WebSecurityConfigurerAdapter {

      @Resource
      private PreLoginFilter preLoginFilter;
      
      @Autowired
      private AuthenticationSuccessHandler authenticationSuccessHandler;
      @Autowired
      private AuthenticationFailureHandler authenticationFailureHandler;
      
      @Autowired
      private SimpleAuthenticationEntryPoint simpleAuthenticationEntryPoint;
      @Autowired
      private SimpleAccessDeniedHandler simpleAccessDeniedHandler;
 
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            super.configure(auth);
        }

        @Override
        public void configure(WebSecurity web) throws Exception  {
            super.configure(web);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .cors()
                    .and()
                    //登录与鉴权异常处理
                    .exceptionHandling().accessDeniedHandler(simpleAccessDeniedHandler).authenticationEntryPoint(simpleAuthenticationEntryPoint)
                    .and()
                    .authorizeRequests().anyRequest().authenticated()
                    .and()
                    .addFilterBefore(preLoginFilter, UsernamePasswordAuthenticationFilter.class)
                    //formLogin
                    .formLogin()
                    .loginProcessingUrl(LOGIN_PROCESSING_URL)
//                    .successForwardUrl(SecurityController.SUCCESS_URL)
//                    .failureForwardUrl(SecurityController.FAILURE_URL)
                    .successHandler(authenticationSuccessHandler)
                    .failureHandler(authenticationFailureHandler)
                    .and()
                    //logout
                    .logout().logoutUrl(UserServiceProxy.LOGOUT_URI)
                    .addLogoutHandler(new CustomLogoutHandler())
                    .logoutSuccessHandler(new CustomLogoutSuccessHandler());

        }
    }
}
