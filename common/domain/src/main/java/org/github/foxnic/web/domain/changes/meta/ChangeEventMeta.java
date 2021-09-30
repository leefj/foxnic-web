package org.github.foxnic.web.domain.changes.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import java.sql.Timestamp;
import java.util.Date;
import org.github.foxnic.web.domain.changes.ChangeDefinition;
import org.github.foxnic.web.domain.changes.ChangeInstance;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-01 02:53:28
 * @sign 4E4C6B68202F809CC0F4F107C9AF7F84
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
	 * 实体类名 , 类型: java.lang.String
	*/
	public static final String EVENT_TYPE="eventType";
	
	/**
	 * 实体类名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> EVENT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,EVENT_TYPE, java.lang.String.class, "实体类名", "实体类名", java.lang.String.class, null);
	
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
	 * 相应的数据 , 类型: java.lang.String
	*/
	public static final String RESPONSE_DATA="responseData";
	
	/**
	 * 相应的数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> RESPONSE_DATA_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,RESPONSE_DATA, java.lang.String.class, "相应的数据", "相应的数据", java.lang.String.class, null);
	
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
	 * 下一个审批节点ID , 类型: java.lang.String
	*/
	public static final String NEXT_NODE_ID="nextNodeId";
	
	/**
	 * 下一个审批节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> NEXT_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,NEXT_NODE_ID, java.lang.String.class, "下一个审批节点ID", "下一个审批节点ID", java.lang.String.class, null);
	
	/**
	 * 下一个审批节点审批人账户ID , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final String NEXT_NODE_APPROVER_IDS="nextNodeApproverIds";
	
	/**
	 * 下一个审批节点审批人账户ID , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> NEXT_NODE_APPROVER_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,NEXT_NODE_APPROVER_IDS, java.lang.String.class, "下一个审批节点审批人账户ID", "用逗号隔开", java.lang.String.class, null);
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final String NEXT_NODE_APPROVER_NAMES="nextNodeApproverNames";
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.String> NEXT_NODE_APPROVER_NAMES_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,NEXT_NODE_APPROVER_NAMES, java.lang.String.class, "下一个审批节点审批人姓名", "用逗号隔开", java.lang.String.class, null);
	
	/**
	 * 是否成功 , 失败时查看 response_data , 类型: java.lang.Integer
	*/
	public static final String SUCCESS="success";
	
	/**
	 * 是否成功 , 失败时查看 response_data , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeEvent,java.lang.Integer> SUCCESS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeEvent.class ,SUCCESS, java.lang.Integer.class, "是否成功", "失败时查看 response_data", java.lang.Integer.class, null);
	
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
	public static final String[] $PROPS={ ID , INSTANCE_ID , EVENT_TYPE , NOTIFY_TIME , NOTIFY_DATA , RESPONSE_DATA , RESPONSE_TIME , APPROVER_ID , APPROVER_NAME , NEXT_NODE_ID , NEXT_NODE_APPROVER_IDS , NEXT_NODE_APPROVER_NAMES , SUCCESS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , DEFINITION , INSTANCE };
	
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
		 * 设置 实体类名
		 * @param eventType 实体类名
		 * @return 当前对象
		*/
		public ChangeEvent setEventType(String eventType) {
			super.change(EVENT_TYPE,super.getEventType(),eventType);
			super.setEventType(eventType);
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
		 * 设置 相应的数据
		 * @param responseData 相应的数据
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
		 * 设置 下一个审批节点ID
		 * @param nextNodeId 下一个审批节点ID
		 * @return 当前对象
		*/
		public ChangeEvent setNextNodeId(String nextNodeId) {
			super.change(NEXT_NODE_ID,super.getNextNodeId(),nextNodeId);
			super.setNextNodeId(nextNodeId);
			return this;
		}
		
		/**
		 * 设置 下一个审批节点审批人账户ID
		 * @param nextNodeApproverIds 下一个审批节点审批人账户ID
		 * @return 当前对象
		*/
		public ChangeEvent setNextNodeApproverIds(String nextNodeApproverIds) {
			super.change(NEXT_NODE_APPROVER_IDS,super.getNextNodeApproverIds(),nextNodeApproverIds);
			super.setNextNodeApproverIds(nextNodeApproverIds);
			return this;
		}
		
		/**
		 * 设置 下一个审批节点审批人姓名
		 * @param nextNodeApproverNames 下一个审批节点审批人姓名
		 * @return 当前对象
		*/
		public ChangeEvent setNextNodeApproverNames(String nextNodeApproverNames) {
			super.change(NEXT_NODE_APPROVER_NAMES,super.getNextNodeApproverNames(),nextNodeApproverNames);
			super.setNextNodeApproverNames(nextNodeApproverNames);
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