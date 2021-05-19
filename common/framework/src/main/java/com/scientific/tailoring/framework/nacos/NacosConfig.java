package com.scientific.tailoring.framework.nacos;

import java.io.File;
import java.util.Properties;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.log.Logger;

public class NacosConfig {

	private ConfigService configService;

	public NacosConfig(String serverAddr, String namespace, String userName, String password) {
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
		properties.put(PropertyKeyConst.NAMESPACE, namespace);
		properties.put(PropertyKeyConst.USERNAME, userName);
		properties.put(PropertyKeyConst.PASSWORD, password);

		try {
			configService = NacosFactory.createConfigService(properties);
		} catch (NacosException e) {
			Logger.exception("Nacos 连接异常", e);
		}
	}

	public String getConfig(String dataId, String group) {
		try {
			return configService.getConfig(dataId, group, 5000);
		} catch (NacosException e) {
			Logger.exception("获取 Nacos 配置异常", e);
			return null;
		}
	}
	
	public void saveConfig(String dataId, String group,File file) {
		 String content=this.getConfig(dataId, group);
		 if(content!=null) {
			 FileUtil.writeText(file, content);
		 }
	}
	
	

}
