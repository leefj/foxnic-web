package com.tailoring.generator.config;

public class FoxnicWebConstants {

	/**
	 * nacos 配置的 group
	 * */
	public static final String NACOS_GROUP="service";
	/**
	 * nacos 配置的 dataId
	 * */
	public static final String SERVICE_SYSTEM_NACOS_DATA_ID="service-system.yml";
	
	/**
	 * 是否微服务模式
	 * */
	public static final Boolean ENABLE_MICRO_SERVICE = true;
 
	/**
	 * 默认 nacos 配置的 dataId
	 * */
	public static final String DEFAULT_NACOS_DATA_ID=SERVICE_SYSTEM_NACOS_DATA_ID;
	
	/**
	 * domain 项目目录
	 * */
	public static final String DOMAIN_PROJECT_FOLDER_NAME="/common/domain";
	
	/**
	 * agent 项目目录
	 * */
	public static final String AGENT_PROJECT_FOLDER_NAME="/common/proxy";
	
	/**
	 * System Service 项目目录
	 * */
	public static final String SERVICE_SYSTEM_PROJECT_FOLDER_NAME="/backend/service-system";
	
	/**
	 * 主数据源配置键
	 * */
	public static final String PRIMARY_DATASOURCE_CONFIG_KEY="spring.datasource.druid.primary";
	
	/**
	 * domain 项目下常量包
	 * */
	public static final String DOMAIN_CONSTANTS_PACKAGE="org.github.foxnic.web.constants";
 
	/**
	 * 在 MicroServiceNames 类中定义的常量名
	 * */
	public static final String DEFAULT_MICRO_SERVICE_NAME_CONST="TAILORING";
 
	/**
	 * 在 MicroServiceNames 类中定义的常量名
	 * */
	public static final String DAO_NAME_CONST="com.scientific.tailoring.framework.DBConfigs.PRIMARY_DAO";
 
}
