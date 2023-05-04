package org.github.foxnic.web.oauth.config.security;

import com.github.foxnic.commons.bean.BeanUtil;
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
import org.github.foxnic.web.proxy.system.LangServiceProxy;
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
import java.util.Collections;
import java.util.List;

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

//	@Bean
//	public SessionRegistry sessionRegistry() {
//		return new SessionRegistryImpl();
//	}

	/**
     * 验证码认证过滤器.
     *
     * @return the captcha authentication filter
     */
    @Bean
    public CaptchaAuthenticationFilter captchaAuthenticationFilter(UserDetailsManager userDetailsManager,ICaptchaService captchaService,AuthenticationSuccessHandler authenticationSuccessHandler,AuthenticationFailureHandler authenticationFailureHandler) {
        CaptchaAuthenticationFilter captchaAuthenticationFilter = new CaptchaAuthenticationFilter();

        CaptchaAuthenticationProvider captchaAuthenticationProvider=new CaptchaAuthenticationProvider(userDetailsManager,captchaService);
        // 配置 authenticationManager
        ProviderManager providerManager = new ProviderManager(Collections.singletonList(captchaAuthenticationProvider));
        captchaAuthenticationFilter.setAuthenticationManager(providerManager);
        // 成功处理器
        captchaAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        // 失败处理器
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
			// 放行许可证相关的URL
			Object r=web.ignoring().antMatchers("/business/system/licence/**","/service-system/sys-licence/**");
			// 放行配置的URL
			for (String pattern : securityProperties.getIgnoredUrls()) {
				web.ignoring().antMatchers(pattern);
			}
			web.ignoring().antMatchers(securityProperties.getLoginPage());
			// 语言
			web.ignoring().antMatchers(LangServiceProxy.QUERY_LIST);
			web.ignoring().antMatchers(LangServiceProxy.SWITCH_LANGUAGE);
			// API
			web.ignoring().antMatchers("/v2/api-docs");

			List<RequestMatcher> ignoredRequests=BeanUtil.getFieldValue(web,"ignoredRequests", List.class);

			jwtAuthenticationFilter.setIgnoredRequests(ignoredRequests);

			super.configure(web);
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			SessionUser.configGetInService(()->{

				ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
				String sessionId = null;
				if(attributes!=null) {
					sessionId = attributes.getRequest().getSession().getId();
				}

				SecurityContext context = SecurityContextHolder.getContext();
				Authentication authentication=context.getAuthentication();
				// 经过 SpringSecurity 过滤器的地址
				if(authentication!=null) {
					if (authentication == null || !authentication.isAuthenticated()) return null;
					Object principal = authentication.getPrincipal();
					if (principal instanceof SessionUser) {
						SessionUser user=(SessionUser) principal;
						//将对象放入当前 SESSION
						if(attributes!=null) {
							attributes.getRequest().getSession().setAttribute("$SESSION_USER", user);
						}
						sessionCache.put(sessionId,user);
						return user;
					} else {
						return null;
					}
				}
				// 未经过 SpringSecurity 过滤器的地址
				else {
					SessionUser user = null;
					if(attributes!=null) {
						//优先从当前 SESSION 取 SessionUser
						user = (SessionUser) attributes.getRequest().getSession().getAttribute("$SESSION_USER");
					}
					if(user==null) {
						user=sessionCache.get(sessionId);
					}
					return user;
				}
			});



			//允许iframe嵌入
			http.headers().frameOptions().disable();

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
			//http.authorizeRequests().anyRequest().authenticated();

			http.authorizeRequests().anyRequest().authenticated().withObjectPostProcessor(filterSecurityInterceptorObjectPostProcessor());

			// 登录前置过滤器
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
         * 自定义 FilterSecurityInterceptor  ObjectPostProcessor 以替换默认配置达到动态权限的目的
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
