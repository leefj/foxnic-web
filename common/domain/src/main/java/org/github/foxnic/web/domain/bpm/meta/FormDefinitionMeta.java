package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.FormDefinition;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-01 14:56:30
 * @sign 5082F4A205F0D65CD6017164ADA05C5D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FormDefinitionMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 表单代码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 表单代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,CODE, java.lang.String.class, "表单代码", "表单代码", java.lang.String.class, null);
	
	/**
	 * 表单名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 表单名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,NAME, java.lang.String.class, "表单名称", "表单名称", java.lang.String.class, null);
	
	/**
	 * 表单类型 , 类型: java.lang.String
	*/
	public static final String FORM_TYPE="formType";
	
	/**
	 * 表单类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.String> FORM_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,FORM_TYPE, java.lang.String.class, "表单类型", "表单类型", java.lang.String.class, null);
	
	/**
	 * 起草页地址 , 类型: java.lang.String
	*/
	public static final String DRAFT_PAGE_URL="draftPageUrl";
	
	/**
	 * 起草页地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.String> DRAFT_PAGE_URL_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,DRAFT_PAGE_URL, java.lang.String.class, "起草页地址", "起草页地址", java.lang.String.class, null);
	
	/**
	 * 审批页地址 , 类型: java.lang.String
	*/
	public static final String APPROVAL_PAGE_URL="approvalPageUrl";
	
	/**
	 * 审批页地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.String> APPROVAL_PAGE_URL_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,APPROVAL_PAGE_URL, java.lang.String.class, "审批页地址", "审批页地址", java.lang.String.class, null);
	
	/**
	 * 生效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 生效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,VALID, java.lang.Integer.class, "生效", "生效", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 回调控制器 , 完整类名 , 类型: java.lang.String
	*/
	public static final String CALLBACK_CONTROLLER="callbackController";
	
	/**
	 * 回调控制器 , 完整类名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.String> CALLBACK_CONTROLLER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,CALLBACK_CONTROLLER, java.lang.String.class, "回调控制器", "完整类名", java.lang.String.class, null);
	
	/**
	 * 开启审批 , 是否开启审批 , 类型: java.lang.Integer
	*/
	public static final String ENABLE_PROCESS="enableProcess";
	
	/**
	 * 开启审批 , 是否开启审批 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,java.lang.Integer> ENABLE_PROCESS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,ENABLE_PROCESS, java.lang.Integer.class, "开启审批", "是否开启审批", java.lang.Integer.class, null);
	
	/**
	 * 最后修改人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final String LAST_UPDATE_USER="lastUpdateUser";
	
	/**
	 * 最后修改人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.FormDefinition,org.github.foxnic.web.domain.oauth.User> LAST_UPDATE_USER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.FormDefinition.class ,LAST_UPDATE_USER, org.github.foxnic.web.domain.oauth.User.class, "最后修改人", "最后修改人", org.github.foxnic.web.domain.oauth.User.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , FORM_TYPE , DRAFT_PAGE_URL , APPROVAL_PAGE_URL , VALID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CALLBACK_CONTROLLER , ENABLE_PROCESS , LAST_UPDATE_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.FormDefinition {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public FormDefinition setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 表单代码
		 * @param code 表单代码
		 * @return 当前对象
		*/
		public FormDefinition setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 表单名称
		 * @param name 表单名称
		 * @return 当前对象
		*/
		public FormDefinition setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 表单类型
		 * @param formType 表单类型
		 * @return 当前对象
		*/
		public FormDefinition setFormType(String formType) {
			super.change(FORM_TYPE,super.getFormType(),formType);
			super.setFormType(formType);
			return this;
		}
		
		/**
		 * 设置 起草页地址
		 * @param draftPageUrl 起草页地址
		 * @return 当前对象
		*/
		public FormDefinition setDraftPageUrl(String draftPageUrl) {
			super.change(DRAFT_PAGE_URL,super.getDraftPageUrl(),draftPageUrl);
			super.setDraftPageUrl(draftPageUrl);
			return this;
		}
		
		/**
		 * 设置 审批页地址
		 * @param approvalPageUrl 审批页地址
		 * @return 当前对象
		*/
		public FormDefinition setApprovalPageUrl(String approvalPageUrl) {
			super.change(APPROVAL_PAGE_URL,super.getApprovalPageUrl(),approvalPageUrl);
			super.setApprovalPageUrl(approvalPageUrl);
			return this;
		}
		
		/**
		 * 设置 生效
		 * @param valid 生效
		 * @return 当前对象
		*/
		public FormDefinition setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public FormDefinition setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public FormDefinition setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public FormDefinition setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public FormDefinition setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public FormDefinition setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public FormDefinition setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public FormDefinition setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public FormDefinition setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public FormDefinition setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public FormDefinition setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 回调控制器
		 * @param callbackController 回调控制器
		 * @return 当前对象
		*/
		public FormDefinition setCallbackController(String callbackController) {
			super.change(CALLBACK_CONTROLLER,super.getCallbackController(),callbackController);
			super.setCallbackController(callbackController);
			return this;
		}
		
		/**
		 * 设置 开启审批
		 * @param enableProcess 开启审批
		 * @return 当前对象
		*/
		public FormDefinition setEnableProcess(Integer enableProcess) {
			super.change(ENABLE_PROCESS,super.getEnableProcess(),enableProcess);
			super.setEnableProcess(enableProcess);
			return this;
		}
		
		/**
		 * 设置 最后修改人
		 * @param lastUpdateUser 最后修改人
		 * @return 当前对象
		*/
		public FormDefinition setLastUpdateUser(User lastUpdateUser) {
			super.change(LAST_UPDATE_USER,super.getLastUpdateUser(),lastUpdateUser);
			super.setLastUpdateUser(lastUpdateUser);
			return this;
		}
	}
}