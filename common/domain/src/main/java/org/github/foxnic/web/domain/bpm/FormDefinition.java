package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_FORM_DEFINITION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.oauth.User;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 表单定义
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-01 14:56:30
 * @sign 5082F4A205F0D65CD6017164ADA05C5D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_form_definition")
public class FormDefinition extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_FORM_DEFINITION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 表单代码：表单代码
	*/
	@ApiModelProperty(required = true,value="表单代码" , notes = "表单代码")
	private String code;
	
	/**
	 * 表单名称：表单名称
	*/
	@ApiModelProperty(required = false,value="表单名称" , notes = "表单名称")
	private String name;
	
	/**
	 * 表单类型：表单类型
	*/
	@ApiModelProperty(required = false,value="表单类型" , notes = "表单类型")
	private String formType;
	
	/**
	 * 起草页地址：起草页地址
	*/
	@ApiModelProperty(required = false,value="起草页地址" , notes = "起草页地址")
	private String draftPageUrl;
	
	/**
	 * 审批页地址：审批页地址
	*/
	@ApiModelProperty(required = false,value="审批页地址" , notes = "审批页地址")
	private String approvalPageUrl;
	
	/**
	 * 生效：生效
	*/
	@ApiModelProperty(required = false,value="生效" , notes = "生效")
	private Integer valid;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = true,value="租户ID" , notes = "租户ID")
	private String tenantId;
	
	/**
	 * 回调控制器：完整类名
	*/
	@ApiModelProperty(required = false,value="回调控制器" , notes = "完整类名")
	private String callbackController;
	
	/**
	 * 开启审批：是否开启审批
	*/
	@ApiModelProperty(required = false,value="开启审批" , notes = "是否开启审批")
	private Integer enableProcess;
	
	/**
	 * 最后修改人：最后修改人
	*/
	@ApiModelProperty(required = false,value="最后修改人" , notes = "最后修改人")
	private User lastUpdateUser;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public FormDefinition setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 表单代码<br>
	 * 表单代码
	 * @return 表单代码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 表单代码
	 * @param code 表单代码
	 * @return 当前对象
	*/
	public FormDefinition setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 表单名称<br>
	 * 表单名称
	 * @return 表单名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 表单名称
	 * @param name 表单名称
	 * @return 当前对象
	*/
	public FormDefinition setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 表单类型<br>
	 * 表单类型
	 * @return 表单类型
	*/
	public String getFormType() {
		return formType;
	}
	
	/**
	 * 设置 表单类型
	 * @param formType 表单类型
	 * @return 当前对象
	*/
	public FormDefinition setFormType(String formType) {
		this.formType=formType;
		return this;
	}
	
	/**
	 * 获得 起草页地址<br>
	 * 起草页地址
	 * @return 起草页地址
	*/
	public String getDraftPageUrl() {
		return draftPageUrl;
	}
	
	/**
	 * 设置 起草页地址
	 * @param draftPageUrl 起草页地址
	 * @return 当前对象
	*/
	public FormDefinition setDraftPageUrl(String draftPageUrl) {
		this.draftPageUrl=draftPageUrl;
		return this;
	}
	
	/**
	 * 获得 审批页地址<br>
	 * 审批页地址
	 * @return 审批页地址
	*/
	public String getApprovalPageUrl() {
		return approvalPageUrl;
	}
	
	/**
	 * 设置 审批页地址
	 * @param approvalPageUrl 审批页地址
	 * @return 当前对象
	*/
	public FormDefinition setApprovalPageUrl(String approvalPageUrl) {
		this.approvalPageUrl=approvalPageUrl;
		return this;
	}
	
	/**
	 * 获得 生效<br>
	 * 生效
	 * @return 生效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 生效
	 * @param valid 生效
	 * @return 当前对象
	*/
	public FormDefinition setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public FormDefinition setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public FormDefinition setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public FormDefinition setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public FormDefinition setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public FormDefinition setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public FormDefinition setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public FormDefinition setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public FormDefinition setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public FormDefinition setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public FormDefinition setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户ID<br>
	 * 租户ID
	 * @return 租户ID
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户ID
	 * @param tenantId 租户ID
	 * @return 当前对象
	*/
	public FormDefinition setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 回调控制器<br>
	 * 完整类名
	 * @return 回调控制器
	*/
	public String getCallbackController() {
		return callbackController;
	}
	
	/**
	 * 设置 回调控制器
	 * @param callbackController 回调控制器
	 * @return 当前对象
	*/
	public FormDefinition setCallbackController(String callbackController) {
		this.callbackController=callbackController;
		return this;
	}
	
	/**
	 * 获得 开启审批<br>
	 * 是否开启审批
	 * @return 开启审批
	*/
	public Integer getEnableProcess() {
		return enableProcess;
	}
	
	/**
	 * 设置 开启审批
	 * @param enableProcess 开启审批
	 * @return 当前对象
	*/
	public FormDefinition setEnableProcess(Integer enableProcess) {
		this.enableProcess=enableProcess;
		return this;
	}
	
	/**
	 * 获得 最后修改人<br>
	 * 最后修改人
	 * @return 最后修改人
	*/
	public User getLastUpdateUser() {
		return lastUpdateUser;
	}
	
	/**
	 * 设置 最后修改人
	 * @param lastUpdateUser 最后修改人
	 * @return 当前对象
	*/
	public FormDefinition setLastUpdateUser(User lastUpdateUser) {
		this.lastUpdateUser=lastUpdateUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return FormDefinition , 转换好的 FormDefinition 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FormDefinition , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将 Map 转换成 FormDefinition
	 * @param formDefinitionMap 包含实体信息的 Map 对象
	 * @return FormDefinition , 转换好的的 FormDefinition 对象
	*/
	@Transient
	public static FormDefinition createFrom(Map<String,Object> formDefinitionMap) {
		if(formDefinitionMap==null) return null;
		FormDefinition po = EntityContext.create(FormDefinition.class, formDefinitionMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 FormDefinition
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FormDefinition , 转换好的的 FormDefinition 对象
	*/
	@Transient
	public static FormDefinition createFrom(Object pojo) {
		if(pojo==null) return null;
		FormDefinition po = EntityContext.create(FormDefinition.class,pojo);
		return po;
	}

	/**
	 * 创建一个 FormDefinition，等同于 new
	 * @return FormDefinition 对象
	*/
	@Transient
	public static FormDefinition create() {
		return EntityContext.create(FormDefinition.class);
	}
}