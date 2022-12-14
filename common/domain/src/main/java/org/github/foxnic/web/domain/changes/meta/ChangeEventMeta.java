package org.github.foxnic.web.domain.changes.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import java.sql.Timestamp;
import java.util.Date;
import org.github.foxnic.web.domain.changes.ChangeDefinition;
import org.github.foxnic.web.domain.changes.ChangeInstance;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-02 20:13:19
 * @sign ED8F1BFCD67A9A6A0F3CEAF96B646A60
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ChangeEventMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final String INSTANCE_ID="instanceId";
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,INSTANCE_ID, java.lang.String.class, "变更ID", "变更ID", java.lang.String.class, null);
	
	/**
	 * 事件类型 , 类型: java.lang.String
	*/
	public static final String EVENT_TYPE="eventType";
	
	/**
	 * 事件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> EVENT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,EVENT_TYPE, java.lang.String.class, "事件类型", "事件类型", java.lang.String.class, null);
	
	/**
	 * 请求的数据 , 类型: java.lang.String
	*/
	public static final String REQUEST_DATA="requestData";
	
	/**
	 * 请求的数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> REQUEST_DATA_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,REQUEST_DATA, java.lang.String.class, "请求的数据", "请求的数据", java.lang.String.class, null);
	
	/**
	 * 通知发送时间 , 类型: java.sql.Timestamp
	*/
	public static final String NOTIFY_TIME="notifyTime";
	
	/**
	 * 通知发送时间 , 类型: java.sql.Timestamp
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.sql.Timestamp> NOTIFY_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,NOTIFY_TIME, java.sql.Timestamp.class, "通知发送时间", "通知发送时间", java.sql.Timestamp.class, null);
	
	/**
	 * 数据 , 通知到消费方的数据，JSON格式 , 类型: java.lang.String
	*/
	public static final String NOTIFY_DATA="notifyData";
	
	/**
	 * 数据 , 通知到消费方的数据，JSON格式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> NOTIFY_DATA_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,NOTIFY_DATA, java.lang.String.class, "数据", "通知到消费方的数据，JSON格式", java.lang.String.class, null);
	
	/**
	 * 响应的数据 , 类型: java.lang.String
	*/
	public static final String RESPONSE_DATA="responseData";
	
	/**
	 * 响应的数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> RESPONSE_DATA_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,RESPONSE_DATA, java.lang.String.class, "响应的数据", "响应的数据", java.lang.String.class, null);
	
	/**
	 * 回调接收时间 , 类型: java.sql.Timestamp
	*/
	public static final String RESPONSE_TIME="responseTime";
	
	/**
	 * 回调接收时间 , 类型: java.sql.Timestamp
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.sql.Timestamp> RESPONSE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,RESPONSE_TIME, java.sql.Timestamp.class, "回调接收时间", "回调接收时间", java.sql.Timestamp.class, null);
	
	/**
	 * 审批人账户ID , 执行操作的账户ID , 类型: java.lang.String
	*/
	public static final String APPROVER_ID="approverId";
	
	/**
	 * 审批人账户ID , 执行操作的账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> APPROVER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,APPROVER_ID, java.lang.String.class, "审批人账户ID", "执行操作的账户ID", java.lang.String.class, null);
	
	/**
	 * 审批人姓名 , 执行操作的人的姓名 , 类型: java.lang.String
	*/
	public static final String APPROVER_NAME="approverName";
	
	/**
	 * 审批人姓名 , 执行操作的人的姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> APPROVER_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,APPROVER_NAME, java.lang.String.class, "审批人姓名", "执行操作的人的姓名", java.lang.String.class, null);
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final String OPINION="opinion";
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> OPINION_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,OPINION, java.lang.String.class, "审批意见", "审批意见", java.lang.String.class, null);
	
	/**
	 * 审批动作 , 类型: java.lang.String
	*/
	public static final String APPROVE_ACTION="approveAction";
	
	/**
	 * 审批动作 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> APPROVE_ACTION_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,APPROVE_ACTION, java.lang.String.class, "审批动作", "审批动作", java.lang.String.class, null);
	
	/**
	 * 下一个审批节点审批人账户ID , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final String SIMPLE_NEXT_APPROVER_IDS="simpleNextApproverIds";
	
	/**
	 * 下一个审批节点审批人账户ID , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> SIMPLE_NEXT_APPROVER_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,SIMPLE_NEXT_APPROVER_IDS, java.lang.String.class, "下一个审批节点审批人账户ID", "用逗号隔开", java.lang.String.class, null);
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final String SIMPLE_NEXT_APPROVER_NAMES="simpleNextApproverNames";
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> SIMPLE_NEXT_APPROVER_NAMES_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,SIMPLE_NEXT_APPROVER_NAMES, java.lang.String.class, "下一个审批节点审批人姓名", "用逗号隔开", java.lang.String.class, null);
	
	/**
	 * 是否成功 , 失败时查看 response_data , 类型: java.lang.Integer
	*/
	public static final String SUCCESS="success";
	
	/**
	 * 是否成功 , 失败时查看 response_data , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.Integer> SUCCESS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,SUCCESS, java.lang.Integer.class, "是否成功", "失败时查看 response_data", java.lang.Integer.class, null);
	
	/**
	 * 错误信息 , 类型: java.lang.String
	*/
	public static final String ERRORS="errors";
	
	/**
	 * 错误信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> ERRORS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,ERRORS, java.lang.String.class, "错误信息", "错误信息", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 简单模式的节点ID , 类型: java.lang.String
	*/
	public static final String SIMPLE_NODE_ID="simpleNodeId";
	
	/**
	 * 简单模式的节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> SIMPLE_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,SIMPLE_NODE_ID, java.lang.String.class, "简单模式的节点ID", "简单模式的节点ID", java.lang.String.class, null);
	
	/**
	 * 变更定义 , 类型: org.github.foxnic.web.domain.changes.ChangeDefinition
	*/
	public static final String DEFINITION="definition";
	
	/**
	 * 变更定义 , 类型: org.github.foxnic.web.domain.changes.ChangeDefinition
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,org.github.foxnic.web.domain.changes.ChangeDefinition> DEFINITION_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,DEFINITION, org.github.foxnic.web.domain.changes.ChangeDefinition.class, "变更定义", "", org.github.foxnic.web.domain.changes.ChangeDefinition.class, null);
	
	/**
	 * 变更实例 , 类型: org.github.foxnic.web.domain.changes.ChangeInstance
	*/
	public static final String INSTANCE="instance";
	
	/**
	 * 变更实例 , 类型: org.github.foxnic.web.domain.changes.ChangeInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,org.github.foxnic.web.domain.changes.ChangeInstance> INSTANCE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,INSTANCE, org.github.foxnic.web.domain.changes.ChangeInstance.class, "变更实例", "", org.github.foxnic.web.domain.changes.ChangeInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , INSTANCE_ID , EVENT_TYPE , REQUEST_DATA , NOTIFY_TIME , NOTIFY_DATA , RESPONSE_DATA , RESPONSE_TIME , APPROVER_ID , APPROVER_NAME , OPINION , APPROVE_ACTION , SIMPLE_NEXT_APPROVER_IDS , SIMPLE_NEXT_APPROVER_NAMES , SUCCESS , ERRORS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , SIMPLE_NODE_ID , DEFINITION , INSTANCE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.changes.ChangeEvent {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ChangeEvent setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 变更ID
		 * @param instanceId 变更ID
		 * @return 当前对象
		*/
		public ChangeEvent setInstanceId(String instanceId) {
			super.change(INSTANCE_ID,super.getInstanceId(),instanceId);
			super.setInstanceId(instanceId);
			return this;
		}
		
		/**
		 * 设置 事件类型
		 * @param eventType 事件类型
		 * @return 当前对象
		*/
		public ChangeEvent setEventType(String eventType) {
			super.change(EVENT_TYPE,super.getEventType(),eventType);
			super.setEventType(eventType);
			return this;
		}
		
		/**
		 * 设置 请求的数据
		 * @param requestData 请求的数据
		 * @return 当前对象
		*/
		public ChangeEvent setRequestData(String requestData) {
			super.change(REQUEST_DATA,super.getRequestData(),requestData);
			super.setRequestData(requestData);
			return this;
		}
		
		/**
		 * 设置 通知发送时间
		 * @param notifyTime 通知发送时间
		 * @return 当前对象
		*/
		public ChangeEvent setNotifyTime(Timestamp notifyTime) {
			super.change(NOTIFY_TIME,super.getNotifyTime(),notifyTime);
			super.setNotifyTime(notifyTime);
			return this;
		}
		
		/**
		 * 设置 数据
		 * @param notifyData 数据
		 * @return 当前对象
		*/
		public ChangeEvent setNotifyData(String notifyData) {
			super.change(NOTIFY_DATA,super.getNotifyData(),notifyData);
			super.setNotifyData(notifyData);
			return this;
		}
		
		/**
		 * 设置 响应的数据
		 * @param responseData 响应的数据
		 * @return 当前对象
		*/
		public ChangeEvent setResponseData(String responseData) {
			super.change(RESPONSE_DATA,super.getResponseData(),responseData);
			super.setResponseData(responseData);
			return this;
		}
		
		/**
		 * 设置 回调接收时间
		 * @param responseTime 回调接收时间
		 * @return 当前对象
		*/
		public ChangeEvent setResponseTime(Timestamp responseTime) {
			super.change(RESPONSE_TIME,super.getResponseTime(),responseTime);
			super.setResponseTime(responseTime);
			return this;
		}
		
		/**
		 * 设置 审批人账户ID
		 * @param approverId 审批人账户ID
		 * @return 当前对象
		*/
		public ChangeEvent setApproverId(String approverId) {
			super.change(APPROVER_ID,super.getApproverId(),approverId);
			super.setApproverId(approverId);
			return this;
		}
		
		/**
		 * 设置 审批人姓名
		 * @param approverName 审批人姓名
		 * @return 当前对象
		*/
		public ChangeEvent setApproverName(String approverName) {
			super.change(APPROVER_NAME,super.getApproverName(),approverName);
			super.setApproverName(approverName);
			return this;
		}
		
		/**
		 * 设置 审批意见
		 * @param opinion 审批意见
		 * @return 当前对象
		*/
		public ChangeEvent setOpinion(String opinion) {
			super.change(OPINION,super.getOpinion(),opinion);
			super.setOpinion(opinion);
			return this;
		}
		
		/**
		 * 设置 审批动作
		 * @param approveAction 审批动作
		 * @return 当前对象
		*/
		public ChangeEvent setApproveAction(String approveAction) {
			super.change(APPROVE_ACTION,super.getApproveAction(),approveAction);
			super.setApproveAction(approveAction);
			return this;
		}
		
		/**
		 * 设置 下一个审批节点审批人账户ID
		 * @param simpleNextApproverIds 下一个审批节点审批人账户ID
		 * @return 当前对象
		*/
		public ChangeEvent setSimpleNextApproverIds(String simpleNextApproverIds) {
			super.change(SIMPLE_NEXT_APPROVER_IDS,super.getSimpleNextApproverIds(),simpleNextApproverIds);
			super.setSimpleNextApproverIds(simpleNextApproverIds);
			return this;
		}
		
		/**
		 * 设置 下一个审批节点审批人姓名
		 * @param simpleNextApproverNames 下一个审批节点审批人姓名
		 * @return 当前对象
		*/
		public ChangeEvent setSimpleNextApproverNames(String simpleNextApproverNames) {
			super.change(SIMPLE_NEXT_APPROVER_NAMES,super.getSimpleNextApproverNames(),simpleNextApproverNames);
			super.setSimpleNextApproverNames(simpleNextApproverNames);
			return this;
		}
		
		/**
		 * 设置 是否成功
		 * @param success 是否成功
		 * @return 当前对象
		*/
		public ChangeEvent setSuccess(Integer success) {
			super.change(SUCCESS,super.getSuccess(),success);
			super.setSuccess(success);
			return this;
		}
		
		/**
		 * 设置 错误信息
		 * @param errors 错误信息
		 * @return 当前对象
		*/
		public ChangeEvent setErrors(String errors) {
			super.change(ERRORS,super.getErrors(),errors);
			super.setErrors(errors);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ChangeEvent setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ChangeEvent setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ChangeEvent setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ChangeEvent setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ChangeEvent setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ChangeEvent setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ChangeEvent setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ChangeEvent setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 简单模式的节点ID
		 * @param simpleNodeId 简单模式的节点ID
		 * @return 当前对象
		*/
		public ChangeEvent setSimpleNodeId(String simpleNodeId) {
			super.change(SIMPLE_NODE_ID,super.getSimpleNodeId(),simpleNodeId);
			super.setSimpleNodeId(simpleNodeId);
			return this;
		}
		
		/**
		 * 设置 变更定义
		 * @param definition 变更定义
		 * @return 当前对象
		*/
		public ChangeEvent setDefinition(ChangeDefinition definition) {
			super.change(DEFINITION,super.getDefinition(),definition);
			super.setDefinition(definition);
			return this;
		}
		
		/**
		 * 设置 变更实例
		 * @param instance 变更实例
		 * @return 当前对象
		*/
		public ChangeEvent setInstance(ChangeInstance instance) {
			super.change(INSTANCE,super.getInstance(),instance);
			super.setInstance(instance);
			return this;
		}
	}
}