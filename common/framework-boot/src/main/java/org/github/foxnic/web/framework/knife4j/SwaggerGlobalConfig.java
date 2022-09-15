package org.github.foxnic.web.framework.knife4j;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;


/**
 * Swagger API相关配置
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerGlobalConfig {

	static {
		SwaggerAssistant.inject();
	}

	@Bean
	@Primary
	public ServiceModelToSwagger2Mapper getServiceModelToSwagger2Mapper() {
		return new FoxnicServiceModelToSwagger2MapperImpl();
	}

}
