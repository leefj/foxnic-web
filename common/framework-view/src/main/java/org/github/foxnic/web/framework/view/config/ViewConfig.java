package org.github.foxnic.web.framework.view.config;

import org.github.foxnic.web.framework.view.filter.ViewFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ViewConfig {

    @Bean
    public FilterRegistrationBean clusterFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new ViewFilter());
        registration.addUrlPatterns("*.html");
        registration.addUrlPatterns("*.htm");
        registration.setName("ViewFilter");
        return registration;
    }

}
