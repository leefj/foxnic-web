package org.github.foxnic.web.wrapper;

import org.github.foxnic.web.framework.Meta;
import org.github.foxnic.web.framework.starter.CloudApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { Meta.SERVICE_SYSTEM_PACKAGE })
@SpringBootApplication
public class SystemApp {
	public static void main(String[] args) {
		CloudApplication.run(SystemApp.class, args);
	}
	
	 
}
