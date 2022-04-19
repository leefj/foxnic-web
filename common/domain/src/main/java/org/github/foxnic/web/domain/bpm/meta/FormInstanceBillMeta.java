package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.FormInstanceBill;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-04-19 11:03:26
 * @sign 64FBCB0C5FE7BF1E348DF52520B855DE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FormInstanceBillMeta {
	
	/**
	 * 主键 , 类型: java.lang.Integer
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.Integer> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,ID, java.lang.Integer.class, "主键", "主键", java.lang.Integer.class, null);
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final String PROCESS_DEFINITION_ID="processDefinitionId";
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.String> PROCESS_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,PROCESS_DEFINITION_ID, java.lang.String.class, "流程定义ID", "流程定义ID", java.lang.String.class, null);
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 表单定义ID , 类型: java.lang.Integer
	*/
	public static final String FORM_DEFINITION_ID="formDefinitionId";
	
	/**
	 * 表单定义ID , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.Integer> FORM_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,FORM_DEFINITION_ID, java.lang.Integer.class, "表单定义ID", "表单定义ID", java.lang.Integer.class, null);
	
	/**
	 * 表单实例ID , 类型: java.lang.String
	*/
	public static final String FORM_INSTANCE_ID="formInstanceId";
	
	/**
	 * 表单实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.String> FORM_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,FORM_INSTANCE_ID, java.lang.String.class, "表单实例ID", "表单实例ID", java.lang.String.class, null);
	
	/**
	 * 业务单据号 , 类型: java.lang.String
	*/
	public static final String BILL_ID="billId";
	
	/**
	 * 业务单据号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.String> BILL_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,BILL_ID, java.lang.String.class, "业务单据号", "业务单据号", java.lang.String.class, null);
	
	/**
	 * 业务单据类型 , 类型: java.lang.String
	*/
	public static final String BILL_TYPE="billType";
	
	/**
	 * 业务单据类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.String> BILL_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,BILL_TYPE, java.lang.String.class, "业务单据类型", "业务单据类型", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormInstanceBill,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormInstanceBill.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PROCESS_DEFINITION_ID , PROCESS_INSTANCE_ID , FORM_DEFINITION_ID , FORM_INSTANCE_ID , BILL_ID , BILL_TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.FormInstanceBill {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public FormInstanceBill setId(Integer id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程定义ID
		 * @param processDefinitionId 流程定义ID
		 * @return 当前对象
		*/
		public FormInstanceBill setProcessDefinitionId(String processDefinitionId) {
			super.change(PROCESS_DEFINITION_ID,super.getProcessDefinitionId(),processDefinitionId);
			super.setProcessDefinitionId(processDefinitionId);
			return this;
		}
		
		/**
		 * 设置 流程实例ID
		 * @param processInstanceId 流程实例ID
		 * @return 当前对象
		*/
		public FormInstanceBill setProcessInstanceId(String processInstanceId) {
			super.change(PROCESS_INSTANCE_ID,super.getProcessInstanceId(),processInstanceId);
			super.setProcessInstanceId(processInstanceId);
			return this;
		}
		
		/**
		 * 设置 表单定义ID
		 * @param formDefinitionId 表单定义ID
		 * @return 当前对象
		*/
		public FormInstanceBill setFormDefinitionId(Integer formDefinitionId) {
			super.change(FORM_DEFINITION_ID,super.getFormDefinitionId(),formDefinitionId);
			super.setFormDefinitionId(formDefinitionId);
			return this;
		}
		
		/**
		 * 设置 表单实例ID
		 * @param formInstanceId 表单实例ID
		 * @return 当前对象
		*/
		public FormInstanceBill setFormInstanceId(String formInstanceId) {
			super.change(FORM_INSTANCE_ID,super.getFormInstanceId(),formInstanceId);
			super.setFormInstanceId(formInstanceId);
			return this;
		}
		
		/**
		 * 设置 业务单据号
		 * @param billId 业务单据号
		 * @return 当前对象
		*/
		public FormInstanceBill setBillId(String billId) {
			super.change(BILL_ID,super.getBillId(),billId);
			super.setBillId(billId);
			return this;
		}
		
		/**
		 * 设置 业务单据类型
		 * @param billType 业务单据类型
		 * @return 当前对象
		*/
		public FormInstanceBill setBillType(String billType) {
			super.change(BILL_TYPE,super.getBillType(),billType);
			super.setBillType(billType);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public FormInstanceBill setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public FormInstanceBill setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public FormInstanceBill setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public FormInstanceBill setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public FormInstanceBill setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public FormInstanceBill setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public FormInstanceBill setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public FormInstanceBill setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public FormInstanceBill setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
	}
}