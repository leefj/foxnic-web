package org.github.foxnic.web.framework.dao;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidMonitorConfig {


    @Bean
    public ServletRegistrationBean druidServlet() {

        String prefix="spring.datasource.monitor.";
        String urlprefix= SpringUtil.getEnvProperty(prefix+"url-prefix");
        String username= SpringUtil.getEnvProperty(prefix+"username");
        String password= SpringUtil.getEnvProperty(prefix+"password");

        String allow= SpringUtil.getEnvProperty(prefix+"allow");
        String deny= SpringUtil.getEnvProperty(prefix+"deny");
        String resetEnable= SpringUtil.getEnvProperty(prefix+"resetEnable");

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/"+urlprefix+"/*");
        //下面这个allow属性你填写你允许的登录的ip地址
        servletRegistrationBean.addInitParameter("allow", allow);
        //IP地址黑名单 根据官方配置信息 deny会优于allow
        servletRegistrationBean.addInitParameter("deny", deny);
        //登录druid后台监控的账号密码
        servletRegistrationBean.addInitParameter("loginUsername", username);
        servletRegistrationBean.addInitParameter("loginPassword", password);
        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable", resetEnable);
        return servletRegistrationBean;

    }

    /**
     * 配置监控拦截器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        String prefix="auxcloud.saas.database.monitor.";
        String urlprefix= SpringUtil.getEnvProperty(prefix+"url-prefix");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        //拦截的路径
        filterRegistrationBean.addUrlPatterns("/*");
        //不需要拦截的信息
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/"+prefix+"/*");
        return filterRegistrationBean;
    }

}
