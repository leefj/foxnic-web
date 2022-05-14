package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-14 11:39:53
 * @sign E2ABF6F32AC7BD1956E3A86F346DAEEC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessAbandonVOMeta {
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessAbandonVO,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessAbandonVO.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 废弃原因 , 流程实例ID , 类型: java.lang.String
	*/
	public static final String REASON="reason";
	
	/**
	 * 废弃原因 , 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessAbandonVO,java.lang.String> REASON_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessAbandonVO.class ,REASON, java.lang.String.class, "废弃原因", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 是否强制删除 , 类型: java.lang.Boolean
	*/
	public static final String FORCE="force";
	
	/**
	 * 是否强制删除 , 类型: java.lang.Boolean
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessAbandonVO,java.lang.Boolean> FORCE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessAbandonVO.class ,FORCE, java.lang.Boolean.class, "是否强制删除", "是否强制删除", java.lang.Boolean.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PROCESS_INSTANCE_ID , REASON , FORCE };
}