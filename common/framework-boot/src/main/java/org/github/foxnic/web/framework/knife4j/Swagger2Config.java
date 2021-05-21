package org.github.foxnic.web.framework.knife4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API相关配置
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2Config {
    
	@Value("${knife4j.title}")
	private String title;
	
	@Value("${knife4j.version}")	
	private String version;
	
	@Value("${knife4j.description}")	
	private String description;
	
	@Bean
    public Docket createRestApi(){
		springfox.documentation.swagger2.web.Swagger2ControllerWebMvc s;
		springfox.documentation.swagger2.mappers.ServiceModelToSwagger2MapperImpl m;
    	Docket docket=new Docket(DocumentationType.SWAGGER_2)
    		 	//不使用默认的响应码
    			.useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
 
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title).description(description).version(version)
                .build();
    }
}
