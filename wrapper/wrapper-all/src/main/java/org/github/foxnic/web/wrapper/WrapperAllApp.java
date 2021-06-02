package org.github.foxnic.web.wrapper;

import org.github.foxnic.web.framework.Meta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { Meta.SERVICE_STORAGE_PACKAGE , Meta.SERVICE_SYSTEM_PACKAGE , Meta.SERVICE_OAUTH_PACKAGE })
@SpringBootApplication(exclude = {FeignAutoConfiguration.class})
public class WrapperAllApp {

	public static void main(String[] args) {
		BootApplication.run(WrapperAllApp.class, args);
	}

}
