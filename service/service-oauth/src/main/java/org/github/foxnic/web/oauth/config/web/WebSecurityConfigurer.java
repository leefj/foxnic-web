package org.github.foxnic.web.oauth.config.web;

import org.github.foxnic.web.oauth.authentication.UserAuthenticationProcessingFilter;
import org.github.foxnic.web.oauth.authorization.AuthenticationFilter;

import javax.servlet.http.HttpServletRequest;

import org.github.foxnic.web.oauth.authentication.UserAuthenticationEntryPoint;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.oauth.url.UrlAccessDecisionManager;
import org.github.foxnic.web.oauth.url.UrlAccessDeniedHandler;
import org.github.foxnic.web.oauth.url.UrlFilterInvocationSecurityMetadataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.github.foxnic.springboot.web.WebContext;
 

/**
 * @author 李方捷
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter  {


    @Autowired
    private IUserService userService;
    
    /**
     * 访问鉴权 - 认证token、签名...
     */
    private final AuthenticationFilter myAuthenticationFilter;
    /**
     * 访问权限认证异常处理
     */
    private final UserAuthenticationEntryPoint adminAuthenticationEntryPoint;
    /**
     * 用户密码校验过滤器
     */
    private final UserAuthenticationProcessingFilter adminAuthenticationProcessingFilter;

    // 上面是登录认证相关  下面为url权限相关 - ========================================================================================

    /**
     * 获取访问url所需要的角色信息
     */
    private final UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
    /**
     * 认证权限处理 - 将上面所获得角色权限与当前登录用户的角色做对比，如果包含其中一个角色即可正常访问
     */
    private final UrlAccessDecisionManager urlAccessDecisionManager;
    /**
     * 自定义访问无权限接口时403响应内容
     */
    private final UrlAccessDeniedHandler urlAccessDeniedHandler;
    
    
    public WebSecurityConfigurer(AuthenticationFilter myAuthenticationFilter, UserAuthenticationEntryPoint adminAuthenticationEntryPoint, UserAuthenticationProcessingFilter adminAuthenticationProcessingFilter, UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource, UrlAccessDeniedHandler urlAccessDeniedHandler, UrlAccessDecisionManager urlAccessDecisionManager) {
        this.myAuthenticationFilter = myAuthenticationFilter;
        this.adminAuthenticationEntryPoint = adminAuthenticationEntryPoint;
        this.adminAuthenticationProcessingFilter = adminAuthenticationProcessingFilter;
        this.urlFilterInvocationSecurityMetadataSource = urlFilterInvocationSecurityMetadataSource;
        this.urlAccessDeniedHandler = urlAccessDeniedHandler;
        this.urlAccessDecisionManager = urlAccessDecisionManager;
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    public static String[] IGNORS= {"/assets/**","/pages/tpl/**","/favicon.ico","/module/**","/**/*.css","/**/*.js","/login.html","/security/validate-code/get/**"};
    
    /**
     * 检查是否是忽略的资源
     * */
    public static boolean isIgnoredResource(HttpServletRequest request) {
    	boolean ignored=false;
    	String uri=request.getRequestURI();
    	for (String pattern : IGNORS) {
    		ignored = WebContext.isMatchPattern(pattern,uri);
    		if(ignored) {
    			return true;
    		}
		}
    	return false;
    	
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Spring Security 过滤器忽略以下资源
//        web.ignoring().antMatchers("/assets/**")
//        .antMatchers("/pages/tpl/**")
//        .antMatchers("/favicon.ico")
//        .antMatchers("/module/**")
//        .antMatchers("/**/*.css")
//        .antMatchers("/**/*.js");
        
        for (String pattern : IGNORS) {
        	web.ignoring().antMatchers(pattern);
		}
        
    }


    /**
     * 配置本站点的访问策略
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.antMatcher("/**").authorizeRequests();
    	//禁用csrf，并开启跨域
        http.csrf().disable().cors();
        
        
        // 未登录认证异常
        http.exceptionHandling().authenticationEntryPoint(adminAuthenticationEntryPoint);
        // 登录过后访问无权限的接口时自定义403响应内容
        http.exceptionHandling().accessDeniedHandler(urlAccessDeniedHandler);

        // url权限认证处理
        registry.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
                o.setAccessDecisionManager(urlAccessDecisionManager);
                return o;
            }
        });
 
        
//        http.authorizeRequests()
//                // permitAll() 的URL路径属于公开访问，不需要权限
////                .antMatchers("/assets/**").permitAll()
////                .antMatchers("/module/**").permitAll()
////                .antMatchers("/pages/tpl/**").permitAll()
////                .antMatchers("/favicon.ico").permitAll()
//                .antMatchers("/security/validate-code/get/**").permitAll()
//                .antMatchers("/security/login").permitAll()
//                .antMatchers("/login.html").permitAll()
//                //
//                .antMatchers("/oauth/rest_token*").permitAll()
//               
//                // /user/ 开头的URL需要 ADMIN 权限
//                .antMatchers("/user/**").hasAnyRole("ADMIN")
//
//                .antMatchers(HttpMethod.GET, "/login*").anonymous()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/security/login")
//                .failureUrl("/login?error=1")
//                .usernameParameter("identity")
//                .passwordParameter("passwd")
//                .and()
//                .logout()
//                .logoutUrl("/security/logout")
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessUrl("/")
//                .and()
//                .exceptionHandling();

//        http.authenticationProvider(authenticationProvider());
        
        
        // 标识访问 `/home` 这个接口，需要具备`ADMIN`角色
//      registry.antMatchers("/home").hasRole("ADMIN");
      // 标识只能在 服务器本地ip[127.0.0.1或localhost] 访问 `/home` 这个接口，其他ip地址无法访问
      registry.antMatchers("/home").hasIpAddress("127.0.0.1");
      // 允许匿名的url - 可理解为放行接口 - 多个接口使用,分割
      registry.antMatchers("/login", "/index").permitAll();
//      registry.antMatchers("/**").access("hasAuthority('admin')");
      // OPTIONS(选项)：查找适用于一个特定网址资源的通讯选择。 在不需执行具体的涉及数据传输的动作情况下， 允许客户端来确定与资源相关的选项以及 / 或者要求， 或是一个服务器的性能
      registry.antMatchers(HttpMethod.OPTIONS, "/**").denyAll();
      // 自动登录 - cookie储存方式
      registry.and().rememberMe();
      // 其余所有请求都需要认证
      registry.anyRequest().authenticated();
      // 防止iframe 造成跨域
      registry.and().headers().frameOptions().disable();

      // 自定义过滤器在登录时认证用户名、密码
      http.addFilterAt(adminAuthenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class)
          .addFilterBefore(myAuthenticationFilter, BasicAuthenticationFilter.class);
        
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }


    /**
     * BCrypt  加密
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * SOSContextHolder bean
     *
     * @return SOSContextHolder bean
     * @since 2.0.1
     */
//    @Bean
//    public SOSContextHolder sosContextHolder() {
//        return new SOSContextHolder();
//    }
}
