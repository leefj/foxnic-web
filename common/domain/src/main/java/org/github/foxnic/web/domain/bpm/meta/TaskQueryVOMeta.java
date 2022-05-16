package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-16 13:57:38
 * @sign E76C4A6ADDAA1D4A02E56A279CE79AE8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskQueryVOMeta {
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskQueryVO,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskQueryVO.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 委托人、审批人账户ID , 委托人、审批人账户 , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_USER_ID="assigneeUserId";
	
	/**
	 * 委托人、审批人账户ID , 委托人、审批人账户 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskQueryVO,java.lang.String> ASSIGNEE_USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskQueryVO.class ,ASSIGNEE_USER_ID, java.lang.String.class, "委托人、审批人账户ID", "委托人、审批人账户", java.lang.String.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskQueryVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskQueryVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "分页大小", java.lang.Integer.class, null);
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskQueryVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskQueryVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "页码", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PROCESS_INSTANCE_ID , ASSIGNEE_USER_ID , PAGE_SIZE , PAGE_INDEX };
}