package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.ProcessDefinition;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionFile;
import org.github.foxnic.web.domain.bpm.FormDefinition;
import org.github.foxnic.web.domain.bpm.Catalog;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-14 07:41:46
 * @sign DA9043003CE247052661BFDE95B07CE6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessDefinitionMeta {
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 流程代码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 流程代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,CODE, java.lang.String.class, "流程代码", "流程代码", java.lang.String.class, null);
	
	/**
	 * 关联表单 , 表单定义ID , 类型: java.lang.String
	*/
	public static final String FORM_DEFINITION_ID="formDefinitionId";
	
	/**
	 * 关联表单 , 表单定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> FORM_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,FORM_DEFINITION_ID, java.lang.String.class, "关联表单", "表单定义ID", java.lang.String.class, null);
	
	/**
	 * 驳回配置 , 流程在驳回时的表现 , 类型: java.lang.String
	*/
	public static final String REJECT_OPTION="rejectOption";
	
	/**
	 * 驳回配置 , 流程在驳回时的表现 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> REJECT_OPTION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,REJECT_OPTION, java.lang.String.class, "驳回配置", "流程在驳回时的表现", java.lang.String.class, null);
	
	/**
	 * 审批人身份范围 , 审批人身份类型的范围 , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_TYPE_RANGE="assigneeTypeRange";
	
	/**
	 * 审批人身份范围 , 审批人身份类型的范围 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> ASSIGNEE_TYPE_RANGE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,ASSIGNEE_TYPE_RANGE, java.lang.String.class, "审批人身份范围", "审批人身份类型的范围", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 生效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 生效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,VALID, java.lang.Integer.class, "生效", "生效", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 流程ID , 在 camunda 中的流程定义ID , 类型: java.lang.String
	*/
	public static final String CAMUNDA_DEFINITION_ID="camundaDefinitionId";
	
	/**
	 * 流程ID , 在 camunda 中的流程定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> CAMUNDA_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,CAMUNDA_DEFINITION_ID, java.lang.String.class, "流程ID", "在 camunda 中的流程定义ID", java.lang.String.class, null);
	
	/**
	 * 流程Key , 在 camunda 中的流程定义KEY , 类型: java.lang.String
	*/
	public static final String CAMUNDA_DEFINITION_KEY="camundaDefinitionKey";
	
	/**
	 * 流程Key , 在 camunda 中的流程定义KEY , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> CAMUNDA_DEFINITION_KEY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,CAMUNDA_DEFINITION_KEY, java.lang.String.class, "流程Key", "在 camunda 中的流程定义KEY", java.lang.String.class, null);
	
	/**
	 * PC端图标 , 类型: java.lang.String
	*/
	public static final String ICON_FILE_PC="iconFilePc";
	
	/**
	 * PC端图标 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> ICON_FILE_PC_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,ICON_FILE_PC, java.lang.String.class, "PC端图标", "PC端图标", java.lang.String.class, null);
	
	/**
	 * 移动端图标 , 类型: java.lang.String
	*/
	public static final String ICON_FILE_MOBILE="iconFileMobile";
	
	/**
	 * 移动端图标 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> ICON_FILE_MOBILE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,ICON_FILE_MOBILE, java.lang.String.class, "移动端图标", "移动端图标", java.lang.String.class, null);
	
	/**
	 * 序号 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 序号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.Integer> SORT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,SORT, java.lang.Integer.class, "序号", "序号", java.lang.Integer.class, null);
	
	/**
	 * 分类ID , 类型: java.lang.String
	*/
	public static final String CATALOG_ID="catalogId";
	
	/**
	 * 分类ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,java.lang.String> CATALOG_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,CATALOG_ID, java.lang.String.class, "分类ID", "分类ID", java.lang.String.class, null);
	
	/**
	 * 最后修改人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final String LAST_UPDATE_USER="lastUpdateUser";
	
	/**
	 * 最后修改人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,org.github.foxnic.web.domain.oauth.User> LAST_UPDATE_USER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,LAST_UPDATE_USER, org.github.foxnic.web.domain.oauth.User.class, "最后修改人", "最后修改人", org.github.foxnic.web.domain.oauth.User.class, null);
	
	/**
	 * 流程模型定义 , 流程模型文件 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionFile
	*/
	public static final String DEFINITION_FILE="definitionFile";
	
	/**
	 * 流程模型定义 , 流程模型文件 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionFile
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,org.github.foxnic.web.domain.bpm.ProcessDefinitionFile> DEFINITION_FILE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,DEFINITION_FILE, org.github.foxnic.web.domain.bpm.ProcessDefinitionFile.class, "流程模型定义", "流程模型文件", org.github.foxnic.web.domain.bpm.ProcessDefinitionFile.class, null);
	
	/**
	 * 表单定义 , 类型: org.github.foxnic.web.domain.bpm.FormDefinition
	*/
	public static final String FORM_DEFINITION="formDefinition";
	
	/**
	 * 表单定义 , 类型: org.github.foxnic.web.domain.bpm.FormDefinition
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,org.github.foxnic.web.domain.bpm.FormDefinition> FORM_DEFINITION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,FORM_DEFINITION, org.github.foxnic.web.domain.bpm.FormDefinition.class, "表单定义", "表单定义", org.github.foxnic.web.domain.bpm.FormDefinition.class, null);
	
	/**
	 * 分类对象 , 类型: org.github.foxnic.web.domain.bpm.Catalog
	*/
	public static final String CATALOG="catalog";
	
	/**
	 * 分类对象 , 类型: org.github.foxnic.web.domain.bpm.Catalog
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinition,org.github.foxnic.web.domain.bpm.Catalog> CATALOG_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinition.class ,CATALOG, org.github.foxnic.web.domain.bpm.Catalog.class, "分类对象", "分类对象", org.github.foxnic.web.domain.bpm.Catalog.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , FORM_DEFINITION_ID , REJECT_OPTION , ASSIGNEE_TYPE_RANGE , NAME , VALID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CAMUNDA_DEFINITION_ID , CAMUNDA_DEFINITION_KEY , ICON_FILE_PC , ICON_FILE_MOBILE , SORT , CATALOG_ID , LAST_UPDATE_USER , DEFINITION_FILE , FORM_DEFINITION , CATALOG };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.ProcessDefinition {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public ProcessDefinition setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程代码
		 * @param code 流程代码
		 * @return 当前对象
		*/
		public ProcessDefinition setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 关联表单
		 * @param formDefinitionId 关联表单
		 * @return 当前对象
		*/
		public ProcessDefinition setFormDefinitionId(String formDefinitionId) {
			super.change(FORM_DEFINITION_ID,super.getFormDefinitionId(),formDefinitionId);
			super.setFormDefinitionId(formDefinitionId);
			return this;
		}
		
		/**
		 * 设置 驳回配置
		 * @param rejectOption 驳回配置
		 * @return 当前对象
		*/
		public ProcessDefinition setRejectOption(String rejectOption) {
			super.change(REJECT_OPTION,super.getRejectOption(),rejectOption);
			super.setRejectOption(rejectOption);
			return this;
		}
		
		/**
		 * 设置 审批人身份范围
		 * @param assigneeTypeRange 审批人身份范围
		 * @return 当前对象
		*/
		public ProcessDefinition setAssigneeTypeRange(String assigneeTypeRange) {
			super.change(ASSIGNEE_TYPE_RANGE,super.getAssigneeTypeRange(),assigneeTypeRange);
			super.setAssigneeTypeRange(assigneeTypeRange);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ProcessDefinition setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 生效
		 * @param valid 生效
		 * @return 当前对象
		*/
		public ProcessDefinition setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ProcessDefinition setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ProcessDefinition setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ProcessDefinition setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ProcessDefinition setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ProcessDefinition setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ProcessDefinition setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ProcessDefinition setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ProcessDefinition setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ProcessDefinition setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ProcessDefinition setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 流程ID
		 * @param camundaDefinitionId 流程ID
		 * @return 当前对象
		*/
		public ProcessDefinition setCamundaDefinitionId(String camundaDefinitionId) {
			super.change(CAMUNDA_DEFINITION_ID,super.getCamundaDefinitionId(),camundaDefinitionId);
			super.setCamundaDefinitionId(camundaDefinitionId);
			return this;
		}
		
		/**
		 * 设置 流程Key
		 * @param camundaDefinitionKey 流程Key
		 * @return 当前对象
		*/
		public ProcessDefinition setCamundaDefinitionKey(String camundaDefinitionKey) {
			super.change(CAMUNDA_DEFINITION_KEY,super.getCamundaDefinitionKey(),camundaDefinitionKey);
			super.setCamundaDefinitionKey(camundaDefinitionKey);
			return this;
		}
		
		/**
		 * 设置 PC端图标
		 * @param iconFilePc PC端图标
		 * @return 当前对象
		*/
		public ProcessDefinition setIconFilePc(String iconFilePc) {
			super.change(ICON_FILE_PC,super.getIconFilePc(),iconFilePc);
			super.setIconFilePc(iconFilePc);
			return this;
		}
		
		/**
		 * 设置 移动端图标
		 * @param iconFileMobile 移动端图标
		 * @return 当前对象
		*/
		public ProcessDefinition setIconFileMobile(String iconFileMobile) {
			super.change(ICON_FILE_MOBILE,super.getIconFileMobile(),iconFileMobile);
			super.setIconFileMobile(iconFileMobile);
			return this;
		}
		
		/**
		 * 设置 序号
		 * @param sort 序号
		 * @return 当前对象
		*/
		public ProcessDefinition setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 分类ID
		 * @param catalogId 分类ID
		 * @return 当前对象
		*/
		public ProcessDefinition setCatalogId(String catalogId) {
			super.change(CATALOG_ID,super.getCatalogId(),catalogId);
			super.setCatalogId(catalogId);
			return this;
		}
		
		/**
		 * 设置 最后修改人
		 * @param lastUpdateUser 最后修改人
		 * @return 当前对象
		*/
		public ProcessDefinition setLastUpdateUser(User lastUpdateUser) {
			super.change(LAST_UPDATE_USER,super.getLastUpdateUser(),lastUpdateUser);
			super.setLastUpdateUser(lastUpdateUser);
			return this;
		}
		
		/**
		 * 设置 流程模型定义
		 * @param definitionFile 流程模型定义
		 * @return 当前对象
		*/
		public ProcessDefinition setDefinitionFile(ProcessDefinitionFile definitionFile) {
			super.change(DEFINITION_FILE,super.getDefinitionFile(),definitionFile);
			super.setDefinitionFile(definitionFile);
			return this;
		}
		
		/**
		 * 设置 表单定义
		 * @param formDefinition 表单定义
		 * @return 当前对象
		*/
		public ProcessDefinition setFormDefinition(FormDefinition formDefinition) {
			super.change(FORM_DEFINITION,super.getFormDefinition(),formDefinition);
			super.setFormDefinition(formDefinition);
			return this;
		}
		
		/**
		 * 设置 分类对象
		 * @param catalog 分类对象
		 * @return 当前对象
		*/
		public ProcessDefinition setCatalog(Catalog catalog) {
			super.change(CATALOG,super.getCatalog(),catalog);
			super.setCatalog(catalog);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ProcessDefinition clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ProcessDefinition duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setAssigneeTypeRange(this.getAssigneeTypeRange());
			inst.setRejectOption(this.getRejectOption());
			inst.setCamundaDefinitionKey(this.getCamundaDefinitionKey());
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setCamundaDefinitionId(this.getCamundaDefinitionId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSort(this.getSort());
			inst.setVersion(this.getVersion());
			inst.setIconFileMobile(this.getIconFileMobile());
			inst.setValid(this.getValid());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCatalogId(this.getCatalogId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setFormDefinitionId(this.getFormDefinitionId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setIconFilePc(this.getIconFilePc());
			if(all) {
				inst.setFormDefinition(this.getFormDefinition());
				inst.setDefinitionFile(this.getDefinitionFile());
				inst.setCatalog(this.getCatalog());
				inst.setLastUpdateUser(this.getLastUpdateUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}