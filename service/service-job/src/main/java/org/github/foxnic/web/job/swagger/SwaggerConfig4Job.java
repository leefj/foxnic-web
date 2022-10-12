package org.github.foxnic.web.job.swagger;

import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.knife4j.BasicSwaggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * Swagger API 相关配置
 */
@Configuration
public class SwaggerConfig4Job extends BasicSwaggerConfig {

    @Autowired
    public SwaggerConfig4Job(OpenApiExtensionResolver openApiExtensionResolver) {
        super(openApiExtensionResolver,FoxnicWebMeta.SERVICE_JOB_PACKAGE);
    }


    @Bean("JobApiDocket")
    public Docket createRestApi() {
        return super.createRestApi();
    }

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("计划任务")
                .description("用于系统相关定时任务的调度。")
                .version(FoxnicWebMeta.VERSION)
                .build();
    }

}
