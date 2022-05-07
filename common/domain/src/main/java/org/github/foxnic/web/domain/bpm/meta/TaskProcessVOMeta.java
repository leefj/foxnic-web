package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-07 09:27:44
 * @sign D6B2FFFB7725EFD35CDA1C4CED1722AA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskProcessVOMeta {
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,java.lang.String> TASK_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,TASK_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 审批人账户ID , 审批人账户 , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_USER_ID="assigneeUserId";
	
	/**
	 * 审批人账户ID , 审批人账户 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,java.lang.String> ASSIGNEE_USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,ASSIGNEE_USER_ID, java.lang.String.class, "审批人账户ID", "审批人账户", java.lang.String.class, null);
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final String COMMENT="comment";
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,java.lang.String> COMMENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,COMMENT, java.lang.String.class, "审批意见", "审批意见", java.lang.String.class, null);
	
	/**
	 * 流程参数 , 集合类型: MAP , 类型: java.lang.Object
	*/
	public static final String VARIABLES="variables";
	
	/**
	 * 流程参数 , 集合类型: MAP , 类型: java.lang.Object
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,java.lang.Object> VARIABLES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,VARIABLES, java.util.Map.class, "流程参数", "流程参数", java.lang.Object.class, java.lang.String.class);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ TASK_ID , ASSIGNEE_USER_ID , COMMENT , VARIABLES };
}