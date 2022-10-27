package org.github.foxnic.web.example.swagger;

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
public class SwaggerConfig4Example extends BasicSwaggerConfig {

    @Autowired
    public SwaggerConfig4Example(OpenApiExtensionResolver openApiExtensionResolver) {
        // 指定扫描的包范围
        super(openApiExtensionResolver,FoxnicWebMeta.SERVICE_EXAMPLE_PACKAGE);
    }


    /**
     * 返回 docket Bean , 注意调整 @Bean 注解的 value 值
     * */
    @Bean("ExampleApiDocket")
    public Docket createRestApi() {
        return super.createRestApi();
    }

    /**
     * 返回 ApiInfo , 描述信息
     * */
    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("示例服务")
                .description("用于系统开发演示的示例模块。")
                .version(FoxnicWebMeta.VERSION)
                .build();
    }

}
