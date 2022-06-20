package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.ProcessError;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-20 15:53:42
 * @sign DD3F0DD5AB1B32E06AE21D34CE6AB473
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessErrorMeta {
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessError,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessError.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 流程ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessError,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessError.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程ID", "流程ID", java.lang.String.class, null);
	
	/**
	 * 审批节点 , 类型: java.lang.String
	*/
	public static final String APPROVAL_NODE_ID="approvalNodeId";
	
	/**
	 * 审批节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessError,java.lang.String> APPROVAL_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessError.class ,APPROVAL_NODE_ID, java.lang.String.class, "审批节点", "审批节点", java.lang.String.class, null);
	
	/**
	 * 错误节点 , 类型: java.lang.String
	*/
	public static final String ERROR_NODE_ID="errorNodeId";
	
	/**
	 * 错误节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessError,java.lang.String> ERROR_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessError.class ,ERROR_NODE_ID, java.lang.String.class, "错误节点", "错误节点", java.lang.String.class, null);
	
	/**
	 * 错误消息 , 类型: java.lang.String
	*/
	public static final String ERROR_MESSAGE="errorMessage";
	
	/**
	 * 错误消息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessError,java.lang.String> ERROR_MESSAGE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessError.class ,ERROR_MESSAGE, java.lang.String.class, "错误消息", "错误消息", java.lang.String.class, null);
	
	/**
	 * 错误时间 , 类型: java.util.Date
	*/
	public static final String ERROR_TIME="errorTime";
	
	/**
	 * 错误时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessError,java.util.Date> ERROR_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessError.class ,ERROR_TIME, java.util.Date.class, "错误时间", "错误时间", java.util.Date.class, null);
	
	/**
	 * 原始 , incident id , 类型: java.lang.String
	*/
	public static final String CAMUNDA_INCIDENT_ID="camundaIncidentId";
	
	/**
	 * 原始 , incident id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessError,java.lang.String> CAMUNDA_INCIDENT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessError.class ,CAMUNDA_INCIDENT_ID, java.lang.String.class, "原始", "incident id", java.lang.String.class, null);
	
	/**
	 * 错误类型 , 类型: java.lang.String
	*/
	public static final String ERROR_TYPE="errorType";
	
	/**
	 * 错误类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessError,java.lang.String> ERROR_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessError.class ,ERROR_TYPE, java.lang.String.class, "错误类型", "错误类型", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PROCESS_INSTANCE_ID , APPROVAL_NODE_ID , ERROR_NODE_ID , ERROR_MESSAGE , ERROR_TIME , CAMUNDA_INCIDENT_ID , ERROR_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.ProcessError {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public ProcessError setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程ID
		 * @param processInstanceId 流程ID
		 * @return 当前对象
		*/
		public ProcessError setProcessInstanceId(String processInstanceId) {
			super.change(PROCESS_INSTANCE_ID,super.getProcessInstanceId(),processInstanceId);
			super.setProcessInstanceId(processInstanceId);
			return this;
		}
		
		/**
		 * 设置 审批节点
		 * @param approvalNodeId 审批节点
		 * @return 当前对象
		*/
		public ProcessError setApprovalNodeId(String approvalNodeId) {
			super.change(APPROVAL_NODE_ID,super.getApprovalNodeId(),approvalNodeId);
			super.setApprovalNodeId(approvalNodeId);
			return this;
		}
		
		/**
		 * 设置 错误节点
		 * @param errorNodeId 错误节点
		 * @return 当前对象
		*/
		public ProcessError setErrorNodeId(String errorNodeId) {
			super.change(ERROR_NODE_ID,super.getErrorNodeId(),errorNodeId);
			super.setErrorNodeId(errorNodeId);
			return this;
		}
		
		/**
		 * 设置 错误消息
		 * @param errorMessage 错误消息
		 * @return 当前对象
		*/
		public ProcessError setErrorMessage(String errorMessage) {
			super.change(ERROR_MESSAGE,super.getErrorMessage(),errorMessage);
			super.setErrorMessage(errorMessage);
			return this;
		}
		
		/**
		 * 设置 错误时间
		 * @param errorTime 错误时间
		 * @return 当前对象
		*/
		public ProcessError setErrorTime(Date errorTime) {
			super.change(ERROR_TIME,super.getErrorTime(),errorTime);
			super.setErrorTime(errorTime);
			return this;
		}
		
		/**
		 * 设置 原始
		 * @param camundaIncidentId 原始
		 * @return 当前对象
		*/
		public ProcessError setCamundaIncidentId(String camundaIncidentId) {
			super.change(CAMUNDA_INCIDENT_ID,super.getCamundaIncidentId(),camundaIncidentId);
			super.setCamundaIncidentId(camundaIncidentId);
			return this;
		}
		
		/**
		 * 设置 错误类型
		 * @param errorType 错误类型
		 * @return 当前对象
		*/
		public ProcessError setErrorType(String errorType) {
			super.change(ERROR_TYPE,super.getErrorType(),errorType);
			super.setErrorType(errorType);
			return this;
		}
	}
}