package org.github.foxnic.web.system.swagger;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.knife4j.BasicSwaggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * Swagger API 相关配置
 */
@Configuration
public class SwaggerConfig4System extends BasicSwaggerConfig {

    @Autowired
    public SwaggerConfig4System(OpenApiExtensionResolver openApiExtensionResolver) {
        super(openApiExtensionResolver,FoxnicWebMeta.SERVICE_SYSTEM_PACKAGE);
    }


    @Bean("SystemApiDocket")
    public Docket createRestApi() {
        return super.createRestApi();
    }

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("系统管理")
                .description("系统相关的基础接口。")
                .version(FoxnicWebMeta.VERSION)
                .build();
    }

}