package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-16 15:57:41
 * @sign F8E4341433D6AFEAAC598139A999A1FE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskProcessVOMeta {
	
	/**
	 * 任务ID , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,java.lang.String> TASK_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,TASK_ID, java.lang.String.class, "任务ID", "任务ID", java.lang.String.class, null);
	
	/**
	 * 审批人账户ID , 审批人账户 , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_USER_ID="assigneeUserId";
	
	/**
	 * 审批人账户ID , 审批人账户 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,java.lang.String> ASSIGNEE_USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,ASSIGNEE_USER_ID, java.lang.String.class, "审批人账户ID", "审批人账户", java.lang.String.class, null);
	
	/**
	 * 审批人身份类型 , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_TYPE="assigneeType";
	
	/**
	 * 审批人身份类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,java.lang.String> ASSIGNEE_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,ASSIGNEE_TYPE, java.lang.String.class, "审批人身份类型", "审批人身份类型", java.lang.String.class, null);
	
	/**
	 * 审批人身份ID , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_ID="assigneeId";
	
	/**
	 * 审批人身份ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,java.lang.String> ASSIGNEE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,ASSIGNEE_ID, java.lang.String.class, "审批人身份ID", "审批人身份ID", java.lang.String.class, null);
	
	/**
	 * 审批结果 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 审批结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,java.lang.String> RESULT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,RESULT, java.lang.String.class, "审批结果", "审批结果", java.lang.String.class, null);
	
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
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 流程跳转的目标节点ID , 类型: java.lang.String
	*/
	public static final String JUMP_TO_NODE_ID="jumpToNodeId";
	
	/**
	 * 流程跳转的目标节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,java.lang.String> JUMP_TO_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,JUMP_TO_NODE_ID, java.lang.String.class, "流程跳转的目标节点ID", "流程跳转的目标节点ID", java.lang.String.class, null);
	
	/**
	 * 附件ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ATTACHMENT_FILE_IDS="attachmentFileIds";
	
	/**
	 * 附件ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,java.lang.String> ATTACHMENT_FILE_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,ATTACHMENT_FILE_IDS, java.util.List.class, "附件ID清单", "附件ID清单", java.lang.String.class, null);
	
	/**
	 * 转办人清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.Assignee
	*/
	public static final String TRANSFER_TO="transferTo";
	
	/**
	 * 转办人清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.Assignee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskProcessVO,org.github.foxnic.web.domain.bpm.Assignee> TRANSFER_TO_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskProcessVO.class ,TRANSFER_TO, java.util.List.class, "转办人清单", "转办人清单", org.github.foxnic.web.domain.bpm.Assignee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ TASK_ID , ASSIGNEE_USER_ID , ASSIGNEE_TYPE , ASSIGNEE_ID , RESULT , COMMENT , VARIABLES , TENANT_ID , JUMP_TO_NODE_ID , ATTACHMENT_FILE_IDS , TRANSFER_TO };
}