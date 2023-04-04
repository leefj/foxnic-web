package org.github.foxnic.web.framework.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.foxnic.springboot.spring.SpringUtil;
import com.netflix.loadbalancer.IRule;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.Decoder;

@Configuration
public class FeignConfigs implements RequestInterceptor {

	Logger log=LoggerFactory.getLogger(FeignConfigs.class);

	@Value("${feign.client.config.default.rule:}")
	private String rule=null;

	@Value("${ribbon.ConnectTimeout:5000}")
	private Integer connectTimeout=null;

	@Value("${ribbon.ReadTimeout:30000}")
	private Integer readTimeout=null;

	/**
	 * 响应解码器
	 * */
	@Bean
    public Decoder feignDecoder() {
        return new FeignResultDecoder();
    }

	/**
	 *  请求拦截器
	 * */
    @Override
    public void apply(RequestTemplate requestTemplate) {
    	requestTemplate.header("is-feign","1");
        requestTemplate.header(com.github.foxnic.commons.log.Logger.TRACE_ID_KEY, com.github.foxnic.commons.log.Logger.getTID());
        requestTemplate.header("invoke-from", SpringUtil.getEnvProperty("spring.application.name"));
    }



//	 @Bean
//	 public Request.Options options() {
//		 return new Request.Options(connectTimeout,TimeUnit.SECONDS,readTimeout,TimeUnit.SECONDS,true);
//	 }

	/**
	 * 配置 ribbon 负责均衡策略
	 * */
	@Bean
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IRule rule() {
		FeignLoadBalanceRule rule=FeignLoadBalanceRule.parse(this.rule);
		log.info("user rule "+rule.name()+","+rule.getRule().getClass().getName());
        return rule.getRule();
    }




}
