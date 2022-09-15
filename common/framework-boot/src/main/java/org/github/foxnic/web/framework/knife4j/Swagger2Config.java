package org.github.foxnic.web.framework.knife4j;

import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import com.google.common.base.Optional;
import javassist.ClassMap;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UrlPathHelper;
import springfox.documentation.RequestHandler;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.json.JsonSerializer;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiResourceController;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.google.common.base.Predicates;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;
import springfox.documentation.swagger2.web.Swagger2ControllerWebMvc;
import springfox.documentation.swagger2.web.WebMvcSwaggerTransformationFilter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.swagger.web.SecurityConfiguration;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


/**
 * Swagger API相关配置
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2Config {

	private static final String PKG_SPLITOR = ";";

	@Value("${knife4j.title}")
	private String title;

	@Value("${knife4j.version}")
	private String version;

	@Value("${knife4j.description}")
	private String description;


	/**
	 * 修复 springfox 3.0.0 存在的 bug
	 * */
	private static String EXAMPLE_EQUALS_IMPL_CODE="{ " +
			"        System.err.println(\"equals xxx\");\n" +
			"        if ($0 == this) {\n" +
			"            return true;\n" +
			"        }\n" +
			"        if ($0 == null || getClass() != $0.getClass()) {\n" +
			"            return false;\n" +
			"        }\n" +
			"        springfox.documentation.schema.Example example = (springfox.documentation.schema.Example) $0;\n" +
			"        return Objects.equals(this.getId(), example.getId()) &&\n" +
			"                Objects.equals(this.getSummary(), example.getSummary()) &&\n" +
			"                Objects.equals(this.getDescription(), example.getDescription()) &&\n" +
			"                this.getValue().equals(example.getValue()) &&\n" +
			"                this.getExternalValue().equals(example.getExternalValue()) &&\n" +
			"                this.getMediaType().equals(example.getMediaType()) &&\n" +
			"                this.getExtensions().equals(example.getExtensions());" +
			"}";


//	@Bean
//    public Docket createRestApi(){
//    	Docket docket=new Docket(DocumentationType.SWAGGER_2)
//    		 	//不使用默认的响应码
//    			.useDefaultResponseMessages(false)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                .paths(PathSelectors.any())
//                .build();
//
//        return docket;
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title(title).description(description).version(version)
//                .build();
//    }


	private OpenApiExtensionResolver openApiExtensionResolver;

	@Autowired
	public Swagger2Config(OpenApiExtensionResolver openApiExtensionResolver) {
		this.openApiExtensionResolver = openApiExtensionResolver;
	}

	@Bean
	public Docket createRestApi() {

		// 修复 springfox 3.0.0 存在的 bug
		try {
			ClassPool pool = ClassPool.getDefault();
			pool.importPackage("java.util.Objects");
			CtClass type = pool.get("springfox.documentation.schema.Example");
			//找到对应的方法
			CtMethod equalsMethod = type.getDeclaredMethod("equals");
			equalsMethod.setBody(EXAMPLE_EQUALS_IMPL_CODE);
			type.toClass();
		} catch (Throwable t) {
			Logger.exception("springfox 3.0.0 bug 修复失败",t);
		}

		String groupName="2.X版本";

		String[] basePackages={"org.github.foxnic.web.example"}; // "org.github.foxnic.web.bpm"


		return new Docket(DocumentationType.SWAGGER_2)
				.enable(true)
				.apiInfo(apiInfo())
				.select()
				//.apis(Predicates.or(RequestHandlerSelectors.basePackage("com.web.controller"),RequestHandlerSelectors.basePackage("com.api.controller")))
//				.apis(basePackage(StringUtil.join(basePackages,",")))
				//.apis(RequestHandlerSelectors.basePackage("org.github.foxnic.web.example;org.github.foxnic.web.bpm"),RequestHandlerSelectors.basePackage("org.github.foxnic.web.example;org.github.foxnic.web.bpm"))
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.apis(RequestHandlerSelectors.withClassAnnotation(InDoc.class))
				.paths(PathSelectors.any())
				.build()
				.extensions(openApiExtensionResolver.buildExtensions(groupName));


	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("XX项目API接口管理")
				.description("XX项目API接口管理")
				.termsOfServiceUrl("127.0.0.1")
				.contact(new Contact("xxx", "http://www.apache.org", "xxx@qq.com"))
				.version("1.0.0").license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.build();
	}


	/**
	 * Predicate that matches RequestHandler with given base package name for the class of the handler method.
	 * This predicate includes all request handlers matching the provided basePackage
	 *
	 * @param basePackage - base package of the classes
	 * @return this
	 */
	public static Predicate<RequestHandler> basePackage(final String basePackage) {
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
	private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
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
	private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
		return Optional.fromNullable(input.declaringClass());
	}


//
//	@Bean
//	public SimpleUrlHandlerMapping swaggerUrlHandlerMapping(ServletContext servletContext,
//															@Value("${swagger.mapping.order:10}") int order) throws Exception {
//		SimpleUrlHandlerMapping urlHandlerMapping = new SimpleUrlHandlerMapping();
//		Map<String, ResourceHttpRequestHandler> urlMap = new HashMap<>();
//		{
//			PathResourceResolver pathResourceResolver = new PathResourceResolver();
//			pathResourceResolver.setAllowedLocations(new ClassPathResource("META-INF/resources/webjars/"));
//			pathResourceResolver.setUrlPathHelper(new UrlPathHelper());
//
//			ResourceHttpRequestHandler resourceHttpRequestHandler = new ResourceHttpRequestHandler();
//			resourceHttpRequestHandler.setLocations(Arrays.asList(new ClassPathResource("META-INF/resources/webjars/")));
//			resourceHttpRequestHandler.setResourceResolvers(Arrays.asList(pathResourceResolver));
//			resourceHttpRequestHandler.setServletContext(servletContext);
//			resourceHttpRequestHandler.afterPropertiesSet();
//			//设置新的路径
//			urlMap.put(DEFAULT_PATH + "/webjars/**", resourceHttpRequestHandler);
//		}
//		{
//			PathResourceResolver pathResourceResolver = new PathResourceResolver();
//			pathResourceResolver.setAllowedLocations(new ClassPathResource("META-INF/resources/"));
//			pathResourceResolver.setUrlPathHelper(new UrlPathHelper());
//
//			ResourceHttpRequestHandler resourceHttpRequestHandler = new ResourceHttpRequestHandler();
//			resourceHttpRequestHandler.setLocations(Arrays.asList(new ClassPathResource("META-INF/resources/")));
//			resourceHttpRequestHandler.setResourceResolvers(Arrays.asList(pathResourceResolver));
//			resourceHttpRequestHandler.setServletContext(servletContext);
//			resourceHttpRequestHandler.afterPropertiesSet();
//			//设置新的路径
//			urlMap.put(DEFAULT_PATH + "/**", resourceHttpRequestHandler);
//		}
//		urlHandlerMapping.setUrlMap(urlMap);
//		//调整DispatcherServlet关于SimpleUrlHandlerMapping的排序
//		urlHandlerMapping.setOrder(order);
//		return urlHandlerMapping;
//	}
//
//	/**
//	 * SwaggerUI接口访问
//	 */
//	@Controller
//	@ApiIgnore
//	@RequestMapping(DEFAULT_PATH)
//	public static class SwaggerResourceController implements InitializingBean {
//		private final ApiResourceController apiResourceController;
//		private final DocumentationCache documentationCache;
//		private final ServiceModelToSwagger2Mapper mapper;
//		private final JsonSerializer jsonSerializer;
//		private final PluginRegistry<WebMvcSwaggerTransformationFilter, DocumentationType> transformations;
//		private static final String HAL_MEDIA_TYPE = "application/hal+json";
//		private Swagger2ControllerWebMvc swagger2ControllerWebMvc;
//
//		public SwaggerResourceController(ApiResourceController apiResourceController, DocumentationCache documentationCache, ServiceModelToSwagger2Mapper mapper, JsonSerializer jsonSerializer, PluginRegistry<WebMvcSwaggerTransformationFilter, DocumentationType> transformations) {
//			this.apiResourceController = apiResourceController;
//			this.documentationCache = documentationCache;
//			this.mapper = mapper;
//			this.jsonSerializer = jsonSerializer;
//			this.transformations = transformations;
//		}
//
//		@Override
//		public void afterPropertiesSet() throws Exception {
//			swagger2ControllerWebMvc = new Swagger2ControllerWebMvc(documentationCache, mapper, jsonSerializer, transformations);
//		}
//		/**
//		 * Swagger API首页地址
//		 *
//		 * @return 首页地址
//		 */
//		@RequestMapping
//		public ModelAndView index() {
//			return new ModelAndView("redirect:" + DEFAULT_PATH + "/doc.html");
//		}
//
//		@RequestMapping("/swagger-resources/configuration/security")
//		@ResponseBody
//		public ResponseEntity<SecurityConfiguration> securityConfiguration() {
//			return apiResourceController.securityConfiguration();
//		}
//
//		@RequestMapping("/swagger-resources/configuration/ui")
//		@ResponseBody
//		public ResponseEntity<UiConfiguration> uiConfiguration() {
//			return apiResourceController.uiConfiguration();
//		}
//
//		@RequestMapping("/swagger-resources")
//		@ResponseBody
//		public ResponseEntity<List<SwaggerResource>> swaggerResources() {
//			return apiResourceController.swaggerResources();
//		}
//
//		@RequestMapping(value = "/v2/api-docs", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE, HAL_MEDIA_TYPE})
//		@ResponseBody
//		public ResponseEntity<Json> getDocumentation(
//				@RequestParam(value = "group", required = false) String swaggerGroup,
//				HttpServletRequest servletRequest) {
//			return swagger2ControllerWebMvc.getDocumentation(swaggerGroup, servletRequest);
//		}
//	}


}
