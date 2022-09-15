package org.github.foxnic.web.example.swagger;

import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.knife4j.BasicSwaggerConfig;
import org.github.foxnic.web.framework.knife4j.FoxnicServiceModelToSwagger2MapperImpl;
import org.github.foxnic.web.framework.knife4j.SwaggerAssistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;


/**
 * Swagger API 相关配置
 */
@Configuration
public class SwaggerConfig4Example extends BasicSwaggerConfig {

    @Autowired
    public SwaggerConfig4Example(OpenApiExtensionResolver openApiExtensionResolver) {
        super(openApiExtensionResolver,FoxnicWebMeta.SERVICE_EXAMPLE_PACKAGE);
    }


    @Bean("ExampleApiDocket")
    public Docket createRestApi() {
        return super.createRestApi();
    }

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("示例模块")
                .description("用于系统开发演示的示例模块。")
                .version("1.0.0")
                // .termsOfServiceUrl("127.0.0.1")
                //.contact(new Contact("xxx", "http://www.apache.org", "xxx@qq.com"))
                //.license("Apache 2.0")
                //.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

}
