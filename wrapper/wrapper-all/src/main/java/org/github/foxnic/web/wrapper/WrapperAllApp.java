package org.github.foxnic.web.wrapper;

import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {
		FoxnicWebMeta.WRAPPER_SUPPORT_PACKAGE, FoxnicWebMeta.SERVICE_STORAGE_PACKAGE ,FoxnicWebMeta.SERVICE_JOB_PACKAGE,
		FoxnicWebMeta.SERVICE_SYSTEM_PACKAGE , FoxnicWebMeta.SERVICE_OAUTH_PACKAGE,
		FoxnicWebMeta.SERVICE_HRM_PACKAGE,FoxnicWebMeta.SERVICE_PCM_PACKAGE,
		FoxnicWebMeta.SERVICE_CHANGES_PACKAGE,
		FoxnicWebMeta.SERVICE_BPM_PACKAGE,
		FoxnicWebMeta.SERVICE_DATA_PERM_PACKAGE,
		FoxnicWebMeta.SERVICE_EXAMPLE_PACKAGE
})
@SpringBootApplication(exclude = {FeignAutoConfiguration.class})
public class WrapperAllApp {

	public static void main(String[] args) {
		BootApplication.run(WrapperAllApp.class, args);
	}

}
