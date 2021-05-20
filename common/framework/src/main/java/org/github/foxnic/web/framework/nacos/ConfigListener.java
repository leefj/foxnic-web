package org.github.foxnic.web.framework.nacos;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executor;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;


/**
 * startup.cmd -m standalone
 * https://zhuanlan.zhihu.com/p/101479065
 * */
public class ConfigListener {

	public ConfigListener(String serverAddr, String namespace, String group, String dataId) {

		Properties properties = new Properties();
		properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
		properties.put(PropertyKeyConst.NAMESPACE, namespace);
		properties.put(PropertyKeyConst.USERNAME, "nacos");
		properties.put(PropertyKeyConst.PASSWORD, "nacos");
		try {
			ConfigService configService = NacosFactory.createConfigService(properties);
			 
		//	String content = configService.getConfig(dataId, group, 5000);
//			System.out.println(content);/
			configService.addListener(dataId, group, new Listener() {
				@Override
				public void receiveConfigInfo(String configInfo) {
					System.out.println("recieve:" + configInfo);
					for (ConfigHandler handler : handlers) {
						handler.handleConfig(configInfo);
					}
				}

				@Override
				public Executor getExecutor() {
					return null;
				}
			});

		} catch (NacosException e) {
			throw new RuntimeException(e);
		}

	}
	
	private Set<ConfigHandler>  handlers=new HashSet<>();
	
	public void addHnadler(ConfigHandler handler) {
		handlers.add(handler);
	}
	
	public static interface  ConfigHandler {
		void handleConfig(String config);
	}

}
