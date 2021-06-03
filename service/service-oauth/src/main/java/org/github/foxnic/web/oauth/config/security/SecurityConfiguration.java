package org.github.foxnic.web.oauth.config.security;

import javax.annotation.Resource;

import org.github.foxnic.web.oauth.config.security.SecurityProperties.SecurityMode;
import org.github.foxnic.web.oauth.exception.RequestDeniedHandler;
import org.github.foxnic.web.oauth.exception.UserAuthenticationEntryPoint;
import org.github.foxnic.web.oauth.jwt.JwtAuthenticationFilter;
import org.github.foxnic.web.oauth.login.PreLoginFilter;
import org.github.foxnic.web.oauth.logout.UserLogoutHandler;
import org.github.foxnic.web.oauth.logout.UserLogoutSuccessHandler;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * CustomSpring
 *
 * @see org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration
 * @author 李方捷
 * @since  2021-06-02
 */
@Configuration
@ConditionalOnClass(WebSecurityConfigurerAdapter.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfiguration {

	/**
	 * 登录前的参数转换过滤器
	 *
	 * @param loginPostProcessors the login post processors
	 * @return the pre login filter
	 */
	@Bean
	public PreLoginFilter preLoginFilter() {
		return new PreLoginFilter(UserServiceProxy.LOGIN_URI);
	}

	/**
	 * 替换默认的 DaoAuthenticationProvider
	 */
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(UserDetailsManager mngr) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		// 当账户不存在时，显示账户不存在
		provider.setHideUserNotFoundExceptions(false);
		provider.setUserDetailsService(mngr);
		return provider;
	}

	/**
	 * The type Default configurer adapter.
	 */
	@Configuration
	@Order(SecurityProperties.BASIC_AUTH_ORDER)
	@EnableConfigurationProperties(org.github.foxnic.web.oauth.config.security.SecurityProperties.class)
	static class DefaultConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Autowired
		private org.github.foxnic.web.oauth.config.security.SecurityProperties securityProperties;

		@Resource
		private PreLoginFilter preLoginFilter;

		@Autowired
		private AuthenticationSuccessHandler authenticationSuccessHandler;
		@Autowired
		private AuthenticationFailureHandler authenticationFailureHandler;

		@Autowired
		private UserAuthenticationEntryPoint simpleAuthenticationEntryPoint;
		@Autowired
		private RequestDeniedHandler simpleAccessDeniedHandler;
		
		@Autowired
        private JwtAuthenticationFilter jwtAuthenticationFilter;

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			super.configure(auth);
		}

		@Override
		public void configure(WebSecurity web) throws Exception {

			for (String pattern : securityProperties.getIgnoredUrls()) {
				web.ignoring().antMatchers(pattern);
			}
			web.ignoring().antMatchers(securityProperties.getLoginPage());
			super.configure(web);
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			// 如果是 token 模式，禁用Session
			if(securityProperties.getSecurityMode()==SecurityMode.JWT) {
				http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			}
			// 如果是Session模式，指定访问页面
			if(securityProperties.getSecurityMode()==SecurityMode.SESSION) {
				for (String pattern : securityProperties.getIgnoredUrls()) {
					http.authorizeRequests().antMatchers(pattern).permitAll();
				}
				http.authorizeRequests().antMatchers(securityProperties.getLoginPage()).permitAll();
			}
			// 禁用 csrf
			http.csrf().disable();
			// 启用跨域
			http.cors();
			// 登录与鉴权异常处理
			http.exceptionHandling().accessDeniedHandler(simpleAccessDeniedHandler)
					.authenticationEntryPoint(simpleAuthenticationEntryPoint);
			//
			http.authorizeRequests().anyRequest().authenticated();
			// 登录前置过滤器
			http.addFilterBefore(preLoginFilter, UsernamePasswordAuthenticationFilter.class);
			http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
			// formLogin
			http.formLogin().loginProcessingUrl(UserServiceProxy.LOGIN_URI).loginPage(securityProperties.getLoginPage())
					.successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler);
			// logout
			http.logout().logoutUrl(UserServiceProxy.LOGOUT_URI).addLogoutHandler(new UserLogoutHandler())
					.logoutSuccessHandler(new UserLogoutSuccessHandler());

		}
	}
}
