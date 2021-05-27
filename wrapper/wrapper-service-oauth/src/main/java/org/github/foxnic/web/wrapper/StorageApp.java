package org.github.foxnic.web.wrapper;

import org.github.foxnic.web.framework.Meta;
import org.github.foxnic.web.framework.starter.CloudApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { Meta.SERVICE_OAUTH_PACKAGE })
@SpringBootApplication
public class StorageApp {
	public static void main(String[] args) {
		CloudApplication.run(StorageApp.class, args);
	}
	
	 
}
