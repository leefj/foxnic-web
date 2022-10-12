package org.github.foxnic.web.framework.knife4j;

import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public abstract class BasicSwaggerConfig {

    private OpenApiExtensionResolver openApiExtensionResolver;
    private String basicPackage;
    private String groupName;

    public OpenApiExtensionResolver getOpenApiExtensionResolver() {
        return openApiExtensionResolver;
    }

    public String getBasicPackage() {
        return basicPackage;
    }

    public String getGroupName() {
        return groupName;
    }

    public BasicSwaggerConfig(OpenApiExtensionResolver openApiExtensionResolver, String basicPackage) {
        this(openApiExtensionResolver,basicPackage,null);
    }

    public BasicSwaggerConfig(OpenApiExtensionResolver openApiExtensionResolver,String basicPackage,String groupName) {
        this.openApiExtensionResolver = openApiExtensionResolver;
        this.basicPackage=basicPackage;
        if(groupName==null) {
            String[] parts = basicPackage.split("\\.");
            this.groupName = parts[parts.length - 1];
        }

    }

    public Docket createRestApi() {

        String[] basePackages = { getBasicPackage() };

        Logger.info("rest api doc for "+this.getBasicPackage()+" is ok , group="+this.getGroupName());

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .groupName(this.getGroupName())
                .select()
                .apis(basePackage(StringUtil.join(basePackages, ",")))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.withClassAnnotation(InDoc.class))
                .paths(PathSelectors.any())
                .build()
                .extensions(getOpenApiExtensionResolver().buildExtensions(this.getGroupName()));


    }

    protected abstract ApiInfo apiInfo();

    /**
     * Predicate that matches RequestHandler with given base package name for the class of the handler method.
     * This predicate includes all request handlers matching the provided basePackage
     *
     * @param basePackage - base package of the classes
     * @return this
     */
    public Predicate<RequestHandler> basePackage(final String basePackage) {
        return new Predicate<RequestHandler>() {

            @Override
            public boolean apply(RequestHandler input) {
                return declaringClass(input).transform(handlerPackage(basePackage)).or(true);
            }
        };
    }

    /**
     * 处理包路径配置规则,支持多路径扫描匹配以逗号隔开
     *
     * @param basePackage 扫描包路径
     * @return Function
     */
    private Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return new Function<Class<?>, Boolean>() {

            @Override
            public Boolean apply(Class<?> input) {
                for (String strPackage : basePackage.split(",")) {
                    boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                    if (isMatch) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    /**
     * @param input RequestHandler
     * @return Optional
     */
    private Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }



}
