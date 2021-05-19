package com.scientific.tailoring.framework.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.naming.NamingService;

public class NacosApplication implements CommandLineRunner {

	@Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private Integer serverPort;
    
    @Value("${local.ip}")
    private String localIp;
	
	@NacosInjected
    protected NamingService namingService;
	
	@Override
    public void run(String... args) throws Exception {
 
        // 通过Naming服务注册实例到注册中心
		System.out.println("regist self as "+localIp+":"+serverPort);
        namingService.registerInstance(applicationName, localIp, serverPort);
    }
}
