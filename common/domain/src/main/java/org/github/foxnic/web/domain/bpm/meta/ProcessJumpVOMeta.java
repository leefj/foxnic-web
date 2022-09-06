package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:56
 * @sign AE731B1B6094140F17A3062CDA8E9D95
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessJumpVOMeta {
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessJumpVO,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessJumpVO.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 目标节点ID , 目标节点ID,CamundaNodeId , 类型: java.lang.String
	*/
	public static final String JUMP_TO_NODE_ID="jumpToNodeId";
	
	/**
	 * 目标节点ID , 目标节点ID,CamundaNodeId , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessJumpVO,java.lang.String> JUMP_TO_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessJumpVO.class ,JUMP_TO_NODE_ID, java.lang.String.class, "目标节点ID", "目标节点ID,CamundaNodeId", java.lang.String.class, null);
	
	/**
	 * 跳转原因 , 类型: java.lang.String
	*/
	public static final String REASON="reason";
	
	/**
	 * 跳转原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessJumpVO,java.lang.String> REASON_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessJumpVO.class ,REASON, java.lang.String.class, "跳转原因", "跳转原因", java.lang.String.class, null);
	
	/**
	 * 流程参数 , 集合类型: MAP , 类型: java.lang.Object
	*/
	public static final String VARIABLES="variables";
	
	/**
	 * 流程参数 , 集合类型: MAP , 类型: java.lang.Object
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessJumpVO,java.lang.Object> VARIABLES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessJumpVO.class ,VARIABLES, java.util.Map.class, "流程参数", "流程参数", java.lang.Object.class, java.lang.String.class);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PROCESS_INSTANCE_ID , JUMP_TO_NODE_ID , REASON , VARIABLES };
}