package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-17 17:16:54
 * @sign AD4E2E92D5F108E3E7A0F1F7C4C487A9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskAssigneeUserMeta {
	
	/**
	 * 任务ID , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskAssigneeUser,java.lang.String> TASK_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskAssigneeUser.class ,TASK_ID, java.lang.String.class, "任务ID", "任务ID", java.lang.String.class, null);
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskAssigneeUser,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskAssigneeUser.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final String TASK_STATUS="taskStatus";
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskAssigneeUser,java.lang.String> TASK_STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskAssigneeUser.class ,TASK_STATUS, java.lang.String.class, "任务状态", "任务状态", java.lang.String.class, null);
	
	/**
	 * 账户ID , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskAssigneeUser,java.lang.String> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskAssigneeUser.class ,USER_ID, java.lang.String.class, "账户ID", "账户ID", java.lang.String.class, null);
	
	/**
	 * 账户 , 集合类型: MAP , 类型: java.lang.Object
	*/
	public static final String ACCOUNT="account";
	
	/**
	 * 账户 , 集合类型: MAP , 类型: java.lang.Object
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskAssigneeUser,java.lang.Object> ACCOUNT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskAssigneeUser.class ,ACCOUNT, java.util.Map.class, "账户", "账户", java.lang.Object.class, java.lang.String.class);
	
	/**
	 * 账户名 , 类型: java.lang.String
	*/
	public static final String REAL_NAME="realName";
	
	/**
	 * 账户名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskAssigneeUser,java.lang.String> REAL_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskAssigneeUser.class ,REAL_NAME, java.lang.String.class, "账户名", "账户名", java.lang.String.class, null);
	
	/**
	 * 审批人类型 , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_TYPE="assigneeType";
	
	/**
	 * 审批人类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskAssigneeUser,java.lang.String> ASSIGNEE_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskAssigneeUser.class ,ASSIGNEE_TYPE, java.lang.String.class, "审批人类型", "审批人类型", java.lang.String.class, null);
	
	/**
	 * 审批人ID , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_ID="assigneeId";
	
	/**
	 * 审批人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskAssigneeUser,java.lang.String> ASSIGNEE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskAssigneeUser.class ,ASSIGNEE_ID, java.lang.String.class, "审批人ID", "审批人ID", java.lang.String.class, null);
	
	/**
	 * 审批人名称 , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_NAME="assigneeName";
	
	/**
	 * 审批人名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskAssigneeUser,java.lang.String> ASSIGNEE_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskAssigneeUser.class ,ASSIGNEE_NAME, java.lang.String.class, "审批人名称", "审批人名称", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ TASK_ID , PROCESS_INSTANCE_ID , TASK_STATUS , USER_ID , ACCOUNT , REAL_NAME , ASSIGNEE_TYPE , ASSIGNEE_ID , ASSIGNEE_NAME };
}