package org.github.foxnic.web.wrapper;

import org.github.foxnic.web.framework.Meta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { Meta.SERVICE_STORAGE_PACKAGE , Meta.SERVICE_SYSTEM_PACKAGE })
@SpringBootApplication
public class WrapperAllServiceApp {
	public static void main(String[] args) {
		BootApplication.run(WrapperAllServiceApp.class, args);
	}
	
	 
}
