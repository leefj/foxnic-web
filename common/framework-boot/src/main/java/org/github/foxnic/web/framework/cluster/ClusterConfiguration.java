package org.github.foxnic.web.framework.cluster;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClusterConfiguration {

    @Bean
    public FilterRegistrationBean clusterFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new ClusterFilter());
        registration.addUrlPatterns("*");
        registration.setName("ClusterFilter");
        return registration;
    }

    @Bean
    public FilterRegistrationBean clusterAdvanceFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new ClusterAdvanceFilter());
        registration.addUrlPatterns("*");
        registration.setName("ClusterAdvanceFilter");
        return registration;
    }

}
