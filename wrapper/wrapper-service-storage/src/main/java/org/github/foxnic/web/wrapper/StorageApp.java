package org.github.foxnic.web.wrapper;

import org.github.foxnic.web.framework.Meta;
import org.github.foxnic.web.framework.starter.CloudApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.client.security.SecurityProxy;

@ComponentScan(basePackages = { Meta.SERVICE_STORAGE_PACKAGE })
@SpringBootApplication
public class StorageApp {
	public static void main(String[] args) {
		NacosConfigProperties m;
		SecurityProxy p;
		CloudApplication.run(StorageApp.class, args);
	}
	
	 
}
