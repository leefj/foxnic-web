package org.github.foxnic.web.oauth.config.web;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 2018/1/30
 * <p>
 * Spring MVC 扩展配置
 * <p>
 *
 * @author Shengzhao Li
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {


//    /**
//     * 扩展拦截器
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        WebMvcConfigurer.super.addInterceptors(registry);
//    }


//    /**
//     * 解决乱码问题
//     * For UTF-8
//     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        WebMvcConfigurer.super.configureMessageConverters(converters);
//        converters.add(new StringHttpMessageConverter(MessageConverter.UTF_8));
//    }


//    /**
//     * 字符编码配置 UTF-8
//     */
//    @Bean
//    public FilterRegistrationBean encodingFilter() {
//        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new CharacterEncodingIPFilter());
//        registrationBean.addUrlPatterns("/*");
//        //值越小越靠前
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }


//    /**
//     * sitemesh filter
//     */
//    @Bean
//    public FilterRegistrationBean sitemesh() {
//        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new SOSSiteMeshFilter());
//        registrationBean.addUrlPatterns("/*");
//        //必须在 spring security filter之后
//        registrationBean.setOrder(9090);
//        return registrationBean;
//    }


}
