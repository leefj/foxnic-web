package org.github.foxnic.web.framework.starter;

import org.github.foxnic.web.framework.Meta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.github.foxnic.springboot.starter.FoxnicApplication;


@SpringBootApplication
@EnableFeignClients(basePackages = {Meta.PROXY_PACKAGE})
@ComponentScan(basePackages = {Meta.FRAMEWORK_PACKAGE,Meta.PROXY_PACKAGE})
@EnableDiscoveryClient
public class CloudApplication {
	
	public static ConfigurableApplicationContext run(Class<?> bootType, String... args) {
		ConfigurableApplicationContext context=new SpringApplication(new Class[] {FoxnicApplication.class,CloudApplication.class,bootType}).run(args);
		return context;
    }
	
}
