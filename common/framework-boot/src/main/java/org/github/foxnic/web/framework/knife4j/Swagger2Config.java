package org.github.foxnic.web.framework.knife4j;

import org.springframework.beans.factory.InitializingBean;
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
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;
import springfox.documentation.swagger2.web.Swagger2ControllerWebMvc;
import springfox.documentation.swagger2.web.WebMvcSwaggerTransformationFilter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Value("${knife4j.title}")
	private String title;

	@Value("${knife4j.version}")
	private String version;

	@Value("${knife4j.description}")
	private String description;

	private static final String DEFAULT_PATH = "/swagger";

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


	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(true)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.github.foxnic.web.example"))
//				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build();
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
