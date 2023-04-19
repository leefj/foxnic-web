package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.Assignee;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-20 04:53:05
 * @sign 2473A8EA6C4D73F0CB15C16E8DC46465
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessInstanceRemindReceiverMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String REMIND_ID="remindId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.lang.String> REMIND_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,REMIND_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 需要提醒的接收人ID , 类型: java.lang.String
	*/
	public static final String RECEIVER_ID="receiverId";
	
	/**
	 * 需要提醒的接收人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.lang.String> RECEIVER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,RECEIVER_ID, java.lang.String.class, "需要提醒的接收人ID", "需要提醒的接收人ID", java.lang.String.class, null);
	
	/**
	 * 接收人类型 , 类型: java.lang.String
	*/
	public static final String RECEIVER_TYPE="receiverType";
	
	/**
	 * 接收人类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.lang.String> RECEIVER_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,RECEIVER_TYPE, java.lang.String.class, "接收人类型", "接收人类型", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 关联员工 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EMPLOYEE="employee";
	
	/**
	 * 关联员工 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,org.github.foxnic.web.domain.hrm.Employee> EMPLOYEE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,EMPLOYEE, org.github.foxnic.web.domain.hrm.Employee.class, "关联员工", "关联员工", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 关联代理人 , 类型: org.github.foxnic.web.domain.bpm.Assignee
	*/
	public static final String ASIGNEE="asignee";
	
	/**
	 * 关联代理人 , 类型: org.github.foxnic.web.domain.bpm.Assignee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,org.github.foxnic.web.domain.bpm.Assignee> ASIGNEE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,ASIGNEE, org.github.foxnic.web.domain.bpm.Assignee.class, "关联代理人", "关联代理人", org.github.foxnic.web.domain.bpm.Assignee.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , REMIND_ID , RECEIVER_ID , RECEIVER_TYPE , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , EMPLOYEE , ASIGNEE , NAME };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程实例ID
		 * @param remindId 流程实例ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setRemindId(String remindId) {
			super.change(REMIND_ID,super.getRemindId(),remindId);
			super.setRemindId(remindId);
			return this;
		}
		
		/**
		 * 设置 需要提醒的接收人ID
		 * @param receiverId 需要提醒的接收人ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setReceiverId(String receiverId) {
			super.change(RECEIVER_ID,super.getReceiverId(),receiverId);
			super.setReceiverId(receiverId);
			return this;
		}
		
		/**
		 * 设置 接收人类型
		 * @param receiverType 接收人类型
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setReceiverType(String receiverType) {
			super.change(RECEIVER_TYPE,super.getReceiverType(),receiverType);
			super.setReceiverType(receiverType);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 关联员工
		 * @param employee 关联员工
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setEmployee(Employee employee) {
			super.change(EMPLOYEE,super.getEmployee(),employee);
			super.setEmployee(employee);
			return this;
		}
		
		/**
		 * 设置 关联代理人
		 * @param asignee 关联代理人
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setAsignee(Assignee asignee) {
			super.change(ASIGNEE,super.getAsignee(),asignee);
			super.setAsignee(asignee);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ProcessInstanceRemindReceiver setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ProcessInstanceRemindReceiver clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ProcessInstanceRemindReceiver duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setReceiverId(this.getReceiverId());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setRemindId(this.getRemindId());
			inst.setReceiverType(this.getReceiverType());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setName(this.getName());
				inst.setEmployee(this.getEmployee());
				inst.setAsignee(this.getAsignee());
			}
			inst.clearModifies();
			return inst;
		}

	}
}