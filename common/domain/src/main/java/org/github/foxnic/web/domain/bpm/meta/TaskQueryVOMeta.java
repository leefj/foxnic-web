package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-17 15:49:11
 * @sign 052F627F26D38DEA8D5AE123D156E614
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskQueryVOMeta {
	
	/**
	 * 账户ID , 用于查询指定账户可处理的待办 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 账户ID , 用于查询指定账户可处理的待办 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskQueryVO,java.lang.String> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskQueryVO.class ,USER_ID, java.lang.String.class, "账户ID", "用于查询指定账户可处理的待办", java.lang.String.class, null);
	
	/**
	 * 是否使用会话账户 , userId 当 uerseId 未指定时是否使用会话账户 , 类型: java.lang.Boolean
	*/
	public static final String USE_USER_ID_IN_SESSION="useUserIdInSession";
	
	/**
	 * 是否使用会话账户 , userId 当 uerseId 未指定时是否使用会话账户 , 类型: java.lang.Boolean
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskQueryVO,java.lang.Boolean> USE_USER_ID_IN_SESSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskQueryVO.class ,USE_USER_ID_IN_SESSION, java.lang.Boolean.class, "是否使用会话账户", "userId 当 uerseId 未指定时是否使用会话账户", java.lang.Boolean.class, null);
	
	/**
	 * 流程实例ID , 用于查询指定账户可处理的待办 , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 用于查询指定账户可处理的待办 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskQueryVO,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskQueryVO.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "用于查询指定账户可处理的待办", java.lang.String.class, null);
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskQueryVO,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskQueryVO.class ,STATUS, java.lang.String.class, "任务状态", "任务状态", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ USER_ID , USE_USER_ID_IN_SESSION , PROCESS_INSTANCE_ID , STATUS };
}