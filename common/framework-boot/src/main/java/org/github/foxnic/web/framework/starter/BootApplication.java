package org.github.foxnic.web.framework.starter;

import org.github.foxnic.web.framework.Meta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.github.foxnic.springboot.starter.FoxnicApplication;


@SpringBootApplication(excludeName = {"org.springframework.cloud.openfeign.FeignAutoConfiguration"})
@ComponentScan(basePackages = {Meta.FRAMEWORK_PACKAGE,Meta.PROXY_PACKAGE})
public class BootApplication {
	
	public static ConfigurableApplicationContext run(Class<?> bootType, String... args) {
		ConfigurableApplicationContext context=new SpringApplication(new Class[] {FoxnicApplication.class,BootApplication.class,bootType}).run(args);
		return context;
    }
	
}
