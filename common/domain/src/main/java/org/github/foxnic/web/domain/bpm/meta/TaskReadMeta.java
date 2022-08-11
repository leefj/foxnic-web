package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.TaskRead;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-11 13:30:21
 * @sign EC3FDB9324210215D94E5EDC3E9B402B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskReadMeta {
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskRead,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskRead.class ,ID, java.lang.String.class, "id", "id", java.lang.String.class, null);
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskRead,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskRead.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 任务ID , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskRead,java.lang.String> TASK_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskRead.class ,TASK_ID, java.lang.String.class, "任务ID", "任务ID", java.lang.String.class, null);
	
	/**
	 * 确认时间 , 已阅确认时间 , 类型: java.util.Date
	*/
	public static final String CONFIRM_TIME="confirmTime";
	
	/**
	 * 确认时间 , 已阅确认时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskRead,java.util.Date> CONFIRM_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskRead.class ,CONFIRM_TIME, java.util.Date.class, "确认时间", "已阅确认时间", java.util.Date.class, null);
	
	/**
	 * 评论 , 类型: java.lang.String
	*/
	public static final String COMMENT="comment";
	
	/**
	 * 评论 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskRead,java.lang.String> COMMENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskRead.class ,COMMENT, java.lang.String.class, "评论", "评论", java.lang.String.class, null);
	
	/**
	 * 阅读状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 阅读状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskRead,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskRead.class ,STATUS, java.lang.String.class, "阅读状态", "阅读状态", java.lang.String.class, null);
	
	/**
	 * 创建人 , 阅读人 , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人 , 阅读人 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskRead,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskRead.class ,CREATE_BY, java.lang.String.class, "创建人", "阅读人", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskRead,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskRead.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskRead,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskRead.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * tenant_id , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * tenant_id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskRead,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskRead.class ,TENANT_ID, java.lang.String.class, "tenant_id", "tenant_id", java.lang.String.class, null);
	
	/**
	 * 持续阅读时间 , 类型: java.util.Date
	*/
	public static final String LATEST_TIME="latestTime";
	
	/**
	 * 持续阅读时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskRead,java.util.Date> LATEST_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskRead.class ,LATEST_TIME, java.util.Date.class, "持续阅读时间", "持续阅读时间", java.util.Date.class, null);
	
	/**
	 * 阅读人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final String READER="reader";
	
	/**
	 * 阅读人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskRead,org.github.foxnic.web.domain.oauth.User> READER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskRead.class ,READER, org.github.foxnic.web.domain.oauth.User.class, "阅读人", "阅读人", org.github.foxnic.web.domain.oauth.User.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PROCESS_INSTANCE_ID , TASK_ID , CONFIRM_TIME , COMMENT , STATUS , CREATE_BY , CREATE_TIME , VERSION , TENANT_ID , LATEST_TIME , READER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.TaskRead {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 id
		 * @param id id
		 * @return 当前对象
		*/
		public TaskRead setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程实例ID
		 * @param processInstanceId 流程实例ID
		 * @return 当前对象
		*/
		public TaskRead setProcessInstanceId(String processInstanceId) {
			super.change(PROCESS_INSTANCE_ID,super.getProcessInstanceId(),processInstanceId);
			super.setProcessInstanceId(processInstanceId);
			return this;
		}
		
		/**
		 * 设置 任务ID
		 * @param taskId 任务ID
		 * @return 当前对象
		*/
		public TaskRead setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 确认时间
		 * @param confirmTime 确认时间
		 * @return 当前对象
		*/
		public TaskRead setConfirmTime(Date confirmTime) {
			super.change(CONFIRM_TIME,super.getConfirmTime(),confirmTime);
			super.setConfirmTime(confirmTime);
			return this;
		}
		
		/**
		 * 设置 评论
		 * @param comment 评论
		 * @return 当前对象
		*/
		public TaskRead setComment(String comment) {
			super.change(COMMENT,super.getComment(),comment);
			super.setComment(comment);
			return this;
		}
		
		/**
		 * 设置 阅读状态
		 * @param status 阅读状态
		 * @return 当前对象
		*/
		public TaskRead setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 创建人
		 * @param createBy 创建人
		 * @return 当前对象
		*/
		public TaskRead setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public TaskRead setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public TaskRead setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 tenant_id
		 * @param tenantId tenant_id
		 * @return 当前对象
		*/
		public TaskRead setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 持续阅读时间
		 * @param latestTime 持续阅读时间
		 * @return 当前对象
		*/
		public TaskRead setLatestTime(Date latestTime) {
			super.change(LATEST_TIME,super.getLatestTime(),latestTime);
			super.setLatestTime(latestTime);
			return this;
		}
		
		/**
		 * 设置 阅读人
		 * @param reader 阅读人
		 * @return 当前对象
		*/
		public TaskRead setReader(User reader) {
			super.change(READER,super.getReader(),reader);
			super.setReader(reader);
			return this;
		}
	}
}