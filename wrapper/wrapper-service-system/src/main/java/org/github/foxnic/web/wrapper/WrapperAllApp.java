package org.github.foxnic.web.wrapper;

import org.github.foxnic.web.framework.Meta;
import org.github.foxnic.web.framework.starter.CloudApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { Meta.SERVICE_STORAGE_PACKAGE , Meta.SERVICE_SYSTEM_PACKAGE })
@SpringBootApplication
public class WrapperAllApp {
	public static void main(String[] args) {
		CloudApplication.run(WrapperAllApp.class, args);
	}
	
	 
}
