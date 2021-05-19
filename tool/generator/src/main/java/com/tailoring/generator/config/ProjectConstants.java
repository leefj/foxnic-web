package com.tailoring.generator.config;

public class ProjectConstants {

	/**
	 * nacos 配置的 group
	 * */
	public static final String NACOS_GROUP="service";
	/**
	 * nacos 配置的 dataId
	 * */
	public static final String NACOS_DATA_ID="service-tailoring.yml";
	
	/**
	 * 是否微服务模式
	 * */
	public static final Boolean ENABLE_MICRO_SERVICE = true;
 
	/**
	 * 默认 nacos 配置的 dataId
	 * */
	public static final String DEFAULT_NACOS_DATA_ID=NACOS_DATA_ID;
	
	/**
	 * domain 项目目录
	 * */
	public static final String DOMAIN_PROJECT_FOLDER_NAME="tailoring-domain";
	
	/**
	 * agent 项目目录
	 * */
	public static final String AGENT_PROJECT_FOLDER_NAME="tailoring-proxy";
	
	/**
	 * agent 项目目录
	 * */
	public static final String SERVICE_TAILORING_PROJECT_FOLDER_NAME="service-tailoring";
	
	/**
	 * 主数据源配置键
	 * */
	public static final String PRIMARY_DATASOURCE_CONFIG_KEY="spring.datasource.druid.primary";
	
	/**
	 * domain 项目下常量包
	 * */
	public static final String DOMAIN_CONSTANTS_PACKAGE="com.scientific.tailoring.constants";
 
	/**
	 * 在 MicroServiceNames 类中定义的常量名
	 * */
	public static final String DEFAULT_MICRO_SERVICE_NAME_CONST="TAILORING";
 
	/**
	 * 在 MicroServiceNames 类中定义的常量名
	 * */
	public static final String DAO_NAME_CONST="com.scientific.tailoring.framework.DBConfigs.PRIMARY_DAO";
 
}
