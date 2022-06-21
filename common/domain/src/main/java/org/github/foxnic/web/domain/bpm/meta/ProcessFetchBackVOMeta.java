package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-21 16:00:48
 * @sign 015EC0CA8E92DF31E30C153A2C4E5134
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessFetchBackVOMeta {
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessFetchBackVO,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessFetchBackVO.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 撤回原因 , 类型: java.lang.String
	*/
	public static final String REASON="reason";
	
	/**
	 * 撤回原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessFetchBackVO,java.lang.String> REASON_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessFetchBackVO.class ,REASON, java.lang.String.class, "撤回原因", "撤回原因", java.lang.String.class, null);
	
	/**
	 * 流程参数 , 集合类型: MAP , 类型: java.lang.Object
	*/
	public static final String VARIABLES="variables";
	
	/**
	 * 流程参数 , 集合类型: MAP , 类型: java.lang.Object
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessFetchBackVO,java.lang.Object> VARIABLES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessFetchBackVO.class ,VARIABLES, java.util.Map.class, "流程参数", "流程参数", java.lang.Object.class, java.lang.String.class);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PROCESS_INSTANCE_ID , REASON , VARIABLES };
}