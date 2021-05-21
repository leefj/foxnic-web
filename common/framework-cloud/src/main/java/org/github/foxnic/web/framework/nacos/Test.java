package org.github.foxnic.web.framework.nacos;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.listener.NamingEvent;
import com.github.foxnic.springboot.spring.SpringUtil;

@Component
public class Test {

	@Autowired
	private NacosConfigProperties nacosConfigProperties;
	
	@Autowired
	private Environment env;
	
	
	private NamingService namingService;
	
	
	@PostConstruct
	private void startup() {

		String[] profiles= env.getActiveProfiles();
		String dataId =  StringUtils.isBlank(nacosConfigProperties.getPrefix())? serviceName : nacosConfigProperties.getPrefix();
		if(profiles!=null && profiles.length>0) {
			dataId=dataId+"-"+profiles[0];
		}
		dataId+="."+nacosConfigProperties.getFileExtension();
		 
		//启动配置监听
		
		ConfigListener cl=new ConfigListener(nacosConfigProperties.getServerAddr(), nacosConfigProperties.getNamespace(), nacosConfigProperties.getGroup(), dataId);
		cl.addHnadler((String cfg) -> {
			System.out.println(cfg);
		});
		
		
		NacosConfigProperties p=SpringUtil.getBean(NacosConfigProperties.class);
		
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.SERVER_ADDR, nacosConfigProperties.getServerAddr());
		properties.put(PropertyKeyConst.NAMESPACE, nacosConfigProperties.getNamespace());
		properties.put(PropertyKeyConst.USERNAME, nacosConfigProperties.getUsername());
		properties.put(PropertyKeyConst.PASSWORD, nacosConfigProperties.getPassword());
		try {
			namingService = NamingFactory.createNamingService(properties);
			
			//服务订阅
			namingService.subscribe(serviceName, new EventListener() {
	            @Override
	            public void onEvent(Event event) {
	                System.out.println(((NamingEvent)event).getServiceName());
	                System.out.println(((NamingEvent)event).getInstances());
	            }
	        });
			
		} catch (NacosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}
	
	
 
	@Value("${server.port}")
	private int port;
	
	@Value("${spring.application.name}")
	private String serviceName;

}
