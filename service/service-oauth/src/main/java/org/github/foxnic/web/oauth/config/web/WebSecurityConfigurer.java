package org.github.foxnic.web.oauth.config.web;

import org.github.foxnic.web.oauth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 

/**
 * @author 李方捷
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter  {


    @Autowired
    private IUserService userService;


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //Ignore, public
        web.ignoring().antMatchers("/public/**", "/static/**");
    }


    /**
     * 配置本站点的访问策略
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//默认位置
    	http.csrf().disable();
        //http.csrf().ignoringAntMatchers("/oauth/authorize", "/oauth/token", "/oauth/rest_token");

        http.authorizeRequests()
                // permitAll() 的URL路径属于公开访问，不需要权限
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/module/**").permitAll()
                .antMatchers("/pages/tpl/**").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/security/validate-code/get/**").permitAll()
                .antMatchers("/security/login").permitAll()
                .antMatchers("/login.html").permitAll()
                //
                .antMatchers("/oauth/rest_token*").permitAll()
               
                // /user/ 开头的URL需要 ADMIN 权限
                .antMatchers("/user/**").hasAnyRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/login*").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/security/login")
                .failureUrl("/login?error=1")
                .usernameParameter("identity")
                .passwordParameter("passwd")
                .and()
                .logout()
                .logoutUrl("/security/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling();

        http.authenticationProvider(authenticationProvider());
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
