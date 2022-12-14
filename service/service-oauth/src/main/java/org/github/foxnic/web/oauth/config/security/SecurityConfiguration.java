package org.github.foxnic.web.oauth.config.security;

import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.springboot.mvc.RequestParameter;
import org.github.foxnic.web.oauth.captcha.CaptchaAuthenticationFilter;
import org.github.foxnic.web.oauth.captcha.CaptchaAuthenticationProvider;
import org.github.foxnic.web.oauth.config.security.SecurityProperties.SecurityMode;
import org.github.foxnic.web.oauth.exception.RequestDeniedHandler;
import org.github.foxnic.web.oauth.exception.UserAuthenticationEntryPoint;
import org.github.foxnic.web.oauth.jwt.JwtAuthenticationFilter;
import org.github.foxnic.web.oauth.login.PreLoginFilter;
import org.github.foxnic.web.oauth.login.SessionCache;
import org.github.foxnic.web.oauth.logout.UserLogoutHandler;
import org.github.foxnic.web.oauth.logout.UserLogoutSuccessHandler;
import org.github.foxnic.web.oauth.service.ICaptchaService;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * CustomSpring
 *
 * @see org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration
 * @author ?????????
 * @since  2021-06-02
 */
@Configuration
@ConditionalOnClass(WebSecurityConfigurerAdapter.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfiguration {

	/**
	 * ?????????????????????????????????
	 *
	 * @return the pre login filter
	 */
	@Bean
	public PreLoginFilter preLoginFilter() {
		return new PreLoginFilter(UserServiceProxy.LOGIN_URI);
	}

	/**
	 * ??????????????? DaoAuthenticationProvider
	 */
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(UserDetailsManager mngr) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		// ?????????????????????????????????????????????
		provider.setHideUserNotFoundExceptions(false);
		provider.setUserDetailsService(mngr);
		return provider;
	}

//	@Bean
//	public SessionRegistry sessionRegistry() {
//		return new SessionRegistryImpl();
//	}

	/**
     * ????????????????????????.
     *
     * @return the captcha authentication filter
     */
    @Bean
    public CaptchaAuthenticationFilter captchaAuthenticationFilter(UserDetailsManager userDetailsManager,ICaptchaService captchaService,AuthenticationSuccessHandler authenticationSuccessHandler,AuthenticationFailureHandler authenticationFailureHandler) {
        CaptchaAuthenticationFilter captchaAuthenticationFilter = new CaptchaAuthenticationFilter();

        CaptchaAuthenticationProvider captchaAuthenticationProvider=new CaptchaAuthenticationProvider(userDetailsManager,captchaService);
        // ?????? authenticationManager
        ProviderManager providerManager = new ProviderManager(Collections.singletonList(captchaAuthenticationProvider));
        captchaAuthenticationFilter.setAuthenticationManager(providerManager);
        // ???????????????
        captchaAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        // ???????????????
        captchaAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);

        return captchaAuthenticationFilter;
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

		 @Autowired
        private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

        @Autowired
        private AccessDecisionManager accessDecisionManager;

        @Autowired
        private CaptchaAuthenticationFilter captchaAuthenticationFilter;

		@Autowired
		private SessionCache sessionCache;


		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			super.configure(auth);
		}

		@Override
		public void configure(WebSecurity web) throws Exception {
			// ????????????????????????URL
			Object r=web.ignoring().antMatchers("/business/system/licence/**","/service-system/sys-licence/**");
			// ???????????????URL
			for (String pattern : securityProperties.getIgnoredUrls()) {
				web.ignoring().antMatchers(pattern);
			}
			web.ignoring().antMatchers(securityProperties.getLoginPage());
			// ??????
			web.ignoring().antMatchers("/service-system/sys-lang/query-list");

			List<RequestMatcher> ignoredRequests=BeanUtil.getFieldValue(web,"ignoredRequests", List.class);

			jwtAuthenticationFilter.setIgnoredRequests(ignoredRequests);

			super.configure(web);
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			SessionUser.configGetInService(()->{
				SecurityContext context = SecurityContextHolder.getContext();
				Authentication authentication=context.getAuthentication();
				// ?????? SpringSecurity ??????????????????
				if(authentication!=null) {
					if (authentication == null || !authentication.isAuthenticated()) return null;
					Object principal = authentication.getPrincipal();
					if (principal instanceof SessionUser) {
						return (SessionUser) principal;
					} else {
						return null;
					}
				}
				// ????????? SpringSecurity ??????????????????
				else {
					ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
					if(attributes==null)  return null;
					String sessionId = attributes.getRequest().getSession().getId();
					return sessionCache.get(sessionId);
				}
			});



			//??????iframe??????
			http.headers().frameOptions().disable();

			// ????????? token ???????????????Session
			if(securityProperties.getSecurityMode()==SecurityMode.JWT) {
				http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			}
			// ?????????Session???????????????????????????
			if(securityProperties.getSecurityMode()==SecurityMode.SESSION) {
				for (String pattern : securityProperties.getIgnoredUrls()) {
					http.authorizeRequests().antMatchers(pattern).permitAll();
				}
				http.authorizeRequests().antMatchers(securityProperties.getLoginPage()).permitAll();
			}
			// ?????? csrf
			http.csrf().disable();
			// ????????????
			http.cors();
			// ???????????????????????????
			http.exceptionHandling().accessDeniedHandler(simpleAccessDeniedHandler)
					.authenticationEntryPoint(simpleAuthenticationEntryPoint);
			//
			//http.authorizeRequests().anyRequest().authenticated();

			http.authorizeRequests().anyRequest().authenticated().withObjectPostProcessor(filterSecurityInterceptorObjectPostProcessor());

			// ?????????????????????
			http.addFilterBefore(preLoginFilter, UsernamePasswordAuthenticationFilter.class);
			http.addFilterBefore(captchaAuthenticationFilter,PreLoginFilter.class);
			http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
			// formLogin
			http.formLogin().loginProcessingUrl(UserServiceProxy.LOGIN_URI).loginPage(securityProperties.getLoginPage())
					.successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler);
			// logout
			http.logout().logoutUrl(UserServiceProxy.LOGOUT_URI).addLogoutHandler(new UserLogoutHandler())
					.logoutSuccessHandler(new UserLogoutSuccessHandler());

		}

		 /**
         * ????????? FilterSecurityInterceptor  ObjectPostProcessor ????????????????????????????????????????????????
         *
         * @return ObjectPostProcessor
         */
        private ObjectPostProcessor<FilterSecurityInterceptor> filterSecurityInterceptorObjectPostProcessor() {
            return new ObjectPostProcessor<FilterSecurityInterceptor>() {
                @Override
                public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                    object.setAccessDecisionManager(accessDecisionManager);
                    object.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                    return object;
                }
            };
        }


	}
}
