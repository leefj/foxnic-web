package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_DEFINITION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.bpm.RejectOption;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.Date;
import org.github.foxnic.web.constants.enums.bpm.DrafterRangeType;
import org.github.foxnic.web.domain.oauth.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程定义
 * <p>流程定义 , 数据表 bpm_process_definition 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-16 13:08:07
 * @sign 9601CA45D4785719EB3D752286AA00BD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_definition")
@ApiModel(description = "流程定义 ; 流程定义 , 数据表 bpm_process_definition 的PO类型")
public class ProcessDefinition extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_DEFINITION.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "566268245485551616")
	private String id;
	
	/**
	 * 流程代码：流程代码
	*/
	@ApiModelProperty(required = true,value="流程代码" , notes = "流程代码" , example = "foxnic-leave")
	private String code;
	
	/**
	 * 关联表单：表单定义ID
	*/
	@ApiModelProperty(required = false,value="关联表单" , notes = "表单定义ID" , example = "568457112443682816")
	private String formDefinitionId;
	
	/**
	 * 驳回配置：流程在驳回时的表现
	*/
	@ApiModelProperty(required = false,value="驳回配置" , notes = "流程在驳回时的表现" , example = "abandon_process")
	private String rejectOption;
	@Transient
	@EnumFor("rejectOption")
	private RejectOption rejectOptionEnum;
	
	/**
	 * 审批人身份范围：审批人身份类型的范围
	*/
	@ApiModelProperty(required = false,value="审批人身份范围" , notes = "审批人身份类型的范围" , example = "user,sys_role,employee,position,busi_role")
	private String assigneeTypeRange;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "请假流程")
	private String name;
	
	/**
	 * 生效：生效
	*/
	@ApiModelProperty(required = false,value="生效" , notes = "生效" , example = "1")
	private Integer valid;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "或签测试+流程变量")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-04-12 02:27:50")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-05-15 05:47:17")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID" , example = "110588348101165911")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2022-06-07 03:59:38")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "82")
	private Integer version;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = true,value="租户ID" , notes = "租户ID" , example = "T001")
	private String tenantId;
	
	/**
	 * 流程ID：在 camunda 中的流程定义ID
	*/
	@ApiModelProperty(required = false,value="流程ID" , notes = "在 camunda 中的流程定义ID" , example = "foxnic-leave:2:foxnic-leave:2:7a4261b1-f305-11ed-af76-1268e6e59107")
	private String camundaDefinitionId;
	
	/**
	 * 流程Key：在 camunda 中的流程定义KEY
	*/
	@ApiModelProperty(required = false,value="流程Key" , notes = "在 camunda 中的流程定义KEY" , example = "foxnic-leave")
	private String camundaDefinitionKey;
	
	/**
	 * PC端图标：PC端图标
	*/
	@ApiModelProperty(required = false,value="PC端图标" , notes = "PC端图标" , example = "697821094022742016")
	private String iconFilePc;
	
	/**
	 * 移动端图标：移动端图标
	*/
	@ApiModelProperty(required = false,value="移动端图标" , notes = "移动端图标" , example = "697821105645158400")
	private String iconFileMobile;
	
	/**
	 * 序号：序号
	*/
	@ApiModelProperty(required = false,value="序号" , notes = "序号" , example = "0")
	private Integer sort;
	
	/**
	 * 分类ID：分类ID
	*/
	@ApiModelProperty(required = false,value="分类ID" , notes = "分类ID" , example = "691301431835099136")
	private String catalogId;
	
	/**
	 * 是否允许撤回：是否允许撤回
	*/
	@ApiModelProperty(required = false,value="是否允许撤回" , notes = "是否允许撤回" , example = "1")
	private Integer allowFetchBack;
	
	/**
	 * 是否允许有条件同意：是否允许有条件同意
	*/
	@ApiModelProperty(required = false,value="是否允许有条件同意" , notes = "是否允许有条件同意" , example = "0")
	private Integer allowAgreeWithCondition;
	
	/**
	 * 是否允许驳回：是否允许驳回
	*/
	@ApiModelProperty(required = false,value="是否允许驳回" , notes = "是否允许驳回" , example = "1")
	private Integer allowReject;
	
	/**
	 * 是否允许跳过：是否允许跳过
	*/
	@ApiModelProperty(required = false,value="是否允许跳过" , notes = "是否允许跳过" , example = "1")
	private Integer allowSkip;
	
	/**
	 * 是否允许废弃：是否允许废弃
	*/
	@ApiModelProperty(required = false,value="是否允许废弃" , notes = "是否允许废弃" , example = "1")
	private Integer allowAbandon;
	
	/**
	 * 是否允许起草意见：是否允许起草意见
	*/
	@ApiModelProperty(required = false,value="是否允许起草意见" , notes = "是否允许起草意见" , example = "1")
	private Integer allowDraftingComment;
	
	/**
	 * 是否允许审批意见：是否允许审批意见
	*/
	@ApiModelProperty(required = false,value="是否允许审批意见" , notes = "是否允许审批意见" , example = "1")
	private Integer allowApproveComment;
	
	/**
	 * 是否允许起草附件：是否允许起草附件
	*/
	@ApiModelProperty(required = false,value="是否允许起草附件" , notes = "是否允许起草附件" , example = "1")
	private Integer allowDraftingAttachment;
	
	/**
	 * 是否允许审批附件：是否允许审批附件
	*/
	@ApiModelProperty(required = false,value="是否允许审批附件" , notes = "是否允许审批附件" , example = "1")
	private Integer allowApproveAttachment;
	
	/**
	 * 起草人范围：起草人范围
	*/
	@ApiModelProperty(required = false,value="起草人范围" , notes = "起草人范围" , example = "any")
	private String drafterRange;
	@Transient
	@EnumFor("drafterRange")
	private DrafterRangeType drafterRangeEnum;
	
	/**
	 * 是否允许流程标题：是否允许流程标题
	*/
	@ApiModelProperty(required = false,value="是否允许流程标题" , notes = "是否允许流程标题" , example = "1")
	private Integer allowTitle;
	
	/**
	 * 是否允许流程优先级：是否允许流程优先级
	*/
	@ApiModelProperty(required = false,value="是否允许流程优先级" , notes = "是否允许流程优先级" , example = "1")
	private Integer allowPriority;
	
	/**
	 * 相邻节点同一审批人跳过：相邻节点同一审批人跳过
	*/
	@ApiModelProperty(required = false,value="相邻节点同一审批人跳过" , notes = "相邻节点同一审批人跳过" , example = "0")
	private Integer skipForSameApprover;
	
	/**
	 * 是否允许流程转办：是否允许流程转办
	*/
	@ApiModelProperty(required = false,value="是否允许流程转办" , notes = "是否允许流程转办" , example = "1")
	private Integer allowTransfer;
	
	/**
	 * 最后修改人：最后修改人
	*/
	@ApiModelProperty(required = false,value="最后修改人" , notes = "最后修改人")
	private User lastUpdateUser;
	
	/**
	 * 流程模型定义：流程模型文件
	*/
	@ApiModelProperty(required = false,value="流程模型定义" , notes = "流程模型文件")
	private ProcessDefinitionFile definitionFile;
	
	/**
	 * 表单定义：表单定义
	*/
	@ApiModelProperty(required = false,value="表单定义" , notes = "表单定义")
	private FormDefinition formDefinition;
	
	/**
	 * 分类对象：分类对象
	*/
	@ApiModelProperty(required = false,value="分类对象" , notes = "分类对象")
	private Catalog catalog;
	
	/**
	 * 获得 ID<br>
	 * ID
	 * @return ID
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public ProcessDefinition setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 流程代码<br>
	 * 流程代码
	 * @return 流程代码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 流程代码
	 * @param code 流程代码
	 * @return 当前对象
	*/
	public ProcessDefinition setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 关联表单<br>
	 * 表单定义ID
	 * @return 关联表单
	*/
	public String getFormDefinitionId() {
		return formDefinitionId;
	}
	
	/**
	 * 设置 关联表单
	 * @param formDefinitionId 关联表单
	 * @return 当前对象
	*/
	public ProcessDefinition setFormDefinitionId(String formDefinitionId) {
		this.formDefinitionId=formDefinitionId;
		return this;
	}
	
	/**
	 * 获得 驳回配置<br>
	 * 流程在驳回时的表现
	 * @return 驳回配置
	*/
	public String getRejectOption() {
		return rejectOption;
	}
	
	/**
	 * 获得 驳回配置 的投影属性<br>
	 * 等价于 getRejectOption 方法，获得对应的枚举类型
	 * @return 驳回配置
	*/
	@Transient
	public RejectOption getRejectOptionEnum() {
		if(this.rejectOptionEnum==null) {
			this.rejectOptionEnum = (RejectOption) EnumUtil.parseByCode(RejectOption.values(),rejectOption);
		}
		return this.rejectOptionEnum ;
	}
	
	/**
	 * 设置 驳回配置
	 * @param rejectOption 驳回配置
	 * @return 当前对象
	*/
	@JsonProperty("rejectOption")
	public ProcessDefinition setRejectOption(String rejectOption) {
		this.rejectOption=rejectOption;
		this.rejectOptionEnum= (RejectOption) EnumUtil.parseByCode(RejectOption.values(),rejectOption) ;
		if(StringUtil.hasContent(rejectOption) && this.rejectOptionEnum==null) {
			throw new IllegalArgumentException( rejectOption + " is not one of RejectOption");
		}
		return this;
	}
	
	/**
	 * 设置 驳回配置的投影属性，等同于设置 驳回配置
	 * @param rejectOptionEnum 驳回配置
	 * @return 当前对象
	*/
	@Transient
	public ProcessDefinition setRejectOptionEnum(RejectOption rejectOptionEnum) {
		if(rejectOptionEnum==null) {
			this.setRejectOption(null);
		} else {
			this.setRejectOption(rejectOptionEnum.code());
		}
		this.rejectOptionEnum=rejectOptionEnum;
		return this;
	}
	
	/**
	 * 获得 审批人身份范围<br>
	 * 审批人身份类型的范围
	 * @return 审批人身份范围
	*/
	public String getAssigneeTypeRange() {
		return assigneeTypeRange;
	}
	
	/**
	 * 设置 审批人身份范围
	 * @param assigneeTypeRange 审批人身份范围
	 * @return 当前对象
	*/
	public ProcessDefinition setAssigneeTypeRange(String assigneeTypeRange) {
		this.assigneeTypeRange=assigneeTypeRange;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public ProcessDefinition setName(String name) {
		this.name=name;
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
	public ProcessDefinition setValid(Integer valid) {
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
	public ProcessDefinition setNotes(String notes) {
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
	public ProcessDefinition setCreateBy(String createBy) {
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
	public ProcessDefinition setCreateTime(Date createTime) {
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
	public ProcessDefinition setUpdateBy(String updateBy) {
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
	public ProcessDefinition setUpdateTime(Date updateTime) {
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
	@JsonProperty("deleted")
	public ProcessDefinition setDeleted(Integer deleted) {
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
	public ProcessDefinition setDeleted(Boolean deletedBool) {
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
	public ProcessDefinition setDeleteBy(String deleteBy) {
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
	public ProcessDefinition setDeleteTime(Date deleteTime) {
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
	public ProcessDefinition setVersion(Integer version) {
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
	public ProcessDefinition setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 流程ID<br>
	 * 在 camunda 中的流程定义ID
	 * @return 流程ID
	*/
	public String getCamundaDefinitionId() {
		return camundaDefinitionId;
	}
	
	/**
	 * 设置 流程ID
	 * @param camundaDefinitionId 流程ID
	 * @return 当前对象
	*/
	public ProcessDefinition setCamundaDefinitionId(String camundaDefinitionId) {
		this.camundaDefinitionId=camundaDefinitionId;
		return this;
	}
	
	/**
	 * 获得 流程Key<br>
	 * 在 camunda 中的流程定义KEY
	 * @return 流程Key
	*/
	public String getCamundaDefinitionKey() {
		return camundaDefinitionKey;
	}
	
	/**
	 * 设置 流程Key
	 * @param camundaDefinitionKey 流程Key
	 * @return 当前对象
	*/
	public ProcessDefinition setCamundaDefinitionKey(String camundaDefinitionKey) {
		this.camundaDefinitionKey=camundaDefinitionKey;
		return this;
	}
	
	/**
	 * 获得 PC端图标<br>
	 * PC端图标
	 * @return PC端图标
	*/
	public String getIconFilePc() {
		return iconFilePc;
	}
	
	/**
	 * 设置 PC端图标
	 * @param iconFilePc PC端图标
	 * @return 当前对象
	*/
	public ProcessDefinition setIconFilePc(String iconFilePc) {
		this.iconFilePc=iconFilePc;
		return this;
	}
	
	/**
	 * 获得 移动端图标<br>
	 * 移动端图标
	 * @return 移动端图标
	*/
	public String getIconFileMobile() {
		return iconFileMobile;
	}
	
	/**
	 * 设置 移动端图标
	 * @param iconFileMobile 移动端图标
	 * @return 当前对象
	*/
	public ProcessDefinition setIconFileMobile(String iconFileMobile) {
		this.iconFileMobile=iconFileMobile;
		return this;
	}
	
	/**
	 * 获得 序号<br>
	 * 序号
	 * @return 序号
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 序号
	 * @param sort 序号
	 * @return 当前对象
	*/
	public ProcessDefinition setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 分类ID<br>
	 * 分类ID
	 * @return 分类ID
	*/
	public String getCatalogId() {
		return catalogId;
	}
	
	/**
	 * 设置 分类ID
	 * @param catalogId 分类ID
	 * @return 当前对象
	*/
	public ProcessDefinition setCatalogId(String catalogId) {
		this.catalogId=catalogId;
		return this;
	}
	
	/**
	 * 获得 是否允许撤回<br>
	 * 是否允许撤回
	 * @return 是否允许撤回
	*/
	public Integer getAllowFetchBack() {
		return allowFetchBack;
	}
	
	/**
	 * 设置 是否允许撤回
	 * @param allowFetchBack 是否允许撤回
	 * @return 当前对象
	*/
	public ProcessDefinition setAllowFetchBack(Integer allowFetchBack) {
		this.allowFetchBack=allowFetchBack;
		return this;
	}
	
	/**
	 * 获得 是否允许有条件同意<br>
	 * 是否允许有条件同意
	 * @return 是否允许有条件同意
	*/
	public Integer getAllowAgreeWithCondition() {
		return allowAgreeWithCondition;
	}
	
	/**
	 * 设置 是否允许有条件同意
	 * @param allowAgreeWithCondition 是否允许有条件同意
	 * @return 当前对象
	*/
	public ProcessDefinition setAllowAgreeWithCondition(Integer allowAgreeWithCondition) {
		this.allowAgreeWithCondition=allowAgreeWithCondition;
		return this;
	}
	
	/**
	 * 获得 是否允许驳回<br>
	 * 是否允许驳回
	 * @return 是否允许驳回
	*/
	public Integer getAllowReject() {
		return allowReject;
	}
	
	/**
	 * 设置 是否允许驳回
	 * @param allowReject 是否允许驳回
	 * @return 当前对象
	*/
	public ProcessDefinition setAllowReject(Integer allowReject) {
		this.allowReject=allowReject;
		return this;
	}
	
	/**
	 * 获得 是否允许跳过<br>
	 * 是否允许跳过
	 * @return 是否允许跳过
	*/
	public Integer getAllowSkip() {
		return allowSkip;
	}
	
	/**
	 * 设置 是否允许跳过
	 * @param allowSkip 是否允许跳过
	 * @return 当前对象
	*/
	public ProcessDefinition setAllowSkip(Integer allowSkip) {
		this.allowSkip=allowSkip;
		return this;
	}
	
	/**
	 * 获得 是否允许废弃<br>
	 * 是否允许废弃
	 * @return 是否允许废弃
	*/
	public Integer getAllowAbandon() {
		return allowAbandon;
	}
	
	/**
	 * 设置 是否允许废弃
	 * @param allowAbandon 是否允许废弃
	 * @return 当前对象
	*/
	public ProcessDefinition setAllowAbandon(Integer allowAbandon) {
		this.allowAbandon=allowAbandon;
		return this;
	}
	
	/**
	 * 获得 是否允许起草意见<br>
	 * 是否允许起草意见
	 * @return 是否允许起草意见
	*/
	public Integer getAllowDraftingComment() {
		return allowDraftingComment;
	}
	
	/**
	 * 设置 是否允许起草意见
	 * @param allowDraftingComment 是否允许起草意见
	 * @return 当前对象
	*/
	public ProcessDefinition setAllowDraftingComment(Integer allowDraftingComment) {
		this.allowDraftingComment=allowDraftingComment;
		return this;
	}
	
	/**
	 * 获得 是否允许审批意见<br>
	 * 是否允许审批意见
	 * @return 是否允许审批意见
	*/
	public Integer getAllowApproveComment() {
		return allowApproveComment;
	}
	
	/**
	 * 设置 是否允许审批意见
	 * @param allowApproveComment 是否允许审批意见
	 * @return 当前对象
	*/
	public ProcessDefinition setAllowApproveComment(Integer allowApproveComment) {
		this.allowApproveComment=allowApproveComment;
		return this;
	}
	
	/**
	 * 获得 是否允许起草附件<br>
	 * 是否允许起草附件
	 * @return 是否允许起草附件
	*/
	public Integer getAllowDraftingAttachment() {
		return allowDraftingAttachment;
	}
	
	/**
	 * 设置 是否允许起草附件
	 * @param allowDraftingAttachment 是否允许起草附件
	 * @return 当前对象
	*/
	public ProcessDefinition setAllowDraftingAttachment(Integer allowDraftingAttachment) {
		this.allowDraftingAttachment=allowDraftingAttachment;
		return this;
	}
	
	/**
	 * 获得 是否允许审批附件<br>
	 * 是否允许审批附件
	 * @return 是否允许审批附件
	*/
	public Integer getAllowApproveAttachment() {
		return allowApproveAttachment;
	}
	
	/**
	 * 设置 是否允许审批附件
	 * @param allowApproveAttachment 是否允许审批附件
	 * @return 当前对象
	*/
	public ProcessDefinition setAllowApproveAttachment(Integer allowApproveAttachment) {
		this.allowApproveAttachment=allowApproveAttachment;
		return this;
	}
	
	/**
	 * 获得 起草人范围<br>
	 * 起草人范围
	 * @return 起草人范围
	*/
	public String getDrafterRange() {
		return drafterRange;
	}
	
	/**
	 * 获得 起草人范围 的投影属性<br>
	 * 等价于 getDrafterRange 方法，获得对应的枚举类型
	 * @return 起草人范围
	*/
	@Transient
	public DrafterRangeType getDrafterRangeEnum() {
		if(this.drafterRangeEnum==null) {
			this.drafterRangeEnum = (DrafterRangeType) EnumUtil.parseByCode(DrafterRangeType.values(),drafterRange);
		}
		return this.drafterRangeEnum ;
	}
	
	/**
	 * 设置 起草人范围
	 * @param drafterRange 起草人范围
	 * @return 当前对象
	*/
	@JsonProperty("drafterRange")
	public ProcessDefinition setDrafterRange(String drafterRange) {
		this.drafterRange=drafterRange;
		this.drafterRangeEnum= (DrafterRangeType) EnumUtil.parseByCode(DrafterRangeType.values(),drafterRange) ;
		if(StringUtil.hasContent(drafterRange) && this.drafterRangeEnum==null) {
			throw new IllegalArgumentException( drafterRange + " is not one of DrafterRangeType");
		}
		return this;
	}
	
	/**
	 * 设置 起草人范围的投影属性，等同于设置 起草人范围
	 * @param drafterRangeEnum 起草人范围
	 * @return 当前对象
	*/
	@Transient
	public ProcessDefinition setDrafterRangeEnum(DrafterRangeType drafterRangeEnum) {
		if(drafterRangeEnum==null) {
			this.setDrafterRange(null);
		} else {
			this.setDrafterRange(drafterRangeEnum.code());
		}
		this.drafterRangeEnum=drafterRangeEnum;
		return this;
	}
	
	/**
	 * 获得 是否允许流程标题<br>
	 * 是否允许流程标题
	 * @return 是否允许流程标题
	*/
	public Integer getAllowTitle() {
		return allowTitle;
	}
	
	/**
	 * 设置 是否允许流程标题
	 * @param allowTitle 是否允许流程标题
	 * @return 当前对象
	*/
	public ProcessDefinition setAllowTitle(Integer allowTitle) {
		this.allowTitle=allowTitle;
		return this;
	}
	
	/**
	 * 获得 是否允许流程优先级<br>
	 * 是否允许流程优先级
	 * @return 是否允许流程优先级
	*/
	public Integer getAllowPriority() {
		return allowPriority;
	}
	
	/**
	 * 设置 是否允许流程优先级
	 * @param allowPriority 是否允许流程优先级
	 * @return 当前对象
	*/
	public ProcessDefinition setAllowPriority(Integer allowPriority) {
		this.allowPriority=allowPriority;
		return this;
	}
	
	/**
	 * 获得 相邻节点同一审批人跳过<br>
	 * 相邻节点同一审批人跳过
	 * @return 相邻节点同一审批人跳过
	*/
	public Integer getSkipForSameApprover() {
		return skipForSameApprover;
	}
	
	/**
	 * 设置 相邻节点同一审批人跳过
	 * @param skipForSameApprover 相邻节点同一审批人跳过
	 * @return 当前对象
	*/
	public ProcessDefinition setSkipForSameApprover(Integer skipForSameApprover) {
		this.skipForSameApprover=skipForSameApprover;
		return this;
	}
	
	/**
	 * 获得 是否允许流程转办<br>
	 * 是否允许流程转办
	 * @return 是否允许流程转办
	*/
	public Integer getAllowTransfer() {
		return allowTransfer;
	}
	
	/**
	 * 设置 是否允许流程转办
	 * @param allowTransfer 是否允许流程转办
	 * @return 当前对象
	*/
	public ProcessDefinition setAllowTransfer(Integer allowTransfer) {
		this.allowTransfer=allowTransfer;
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
	public ProcessDefinition setLastUpdateUser(User lastUpdateUser) {
		this.lastUpdateUser=lastUpdateUser;
		return this;
	}
	
	/**
	 * 获得 流程模型定义<br>
	 * 流程模型文件
	 * @return 流程模型定义
	*/
	public ProcessDefinitionFile getDefinitionFile() {
		return definitionFile;
	}
	
	/**
	 * 设置 流程模型定义
	 * @param definitionFile 流程模型定义
	 * @return 当前对象
	*/
	public ProcessDefinition setDefinitionFile(ProcessDefinitionFile definitionFile) {
		this.definitionFile=definitionFile;
		return this;
	}
	
	/**
	 * 获得 表单定义<br>
	 * 表单定义
	 * @return 表单定义
	*/
	public FormDefinition getFormDefinition() {
		return formDefinition;
	}
	
	/**
	 * 设置 表单定义
	 * @param formDefinition 表单定义
	 * @return 当前对象
	*/
	public ProcessDefinition setFormDefinition(FormDefinition formDefinition) {
		this.formDefinition=formDefinition;
		return this;
	}
	
	/**
	 * 获得 分类对象<br>
	 * 分类对象
	 * @return 分类对象
	*/
	public Catalog getCatalog() {
		return catalog;
	}
	
	/**
	 * 设置 分类对象
	 * @param catalog 分类对象
	 * @return 当前对象
	*/
	public ProcessDefinition setCatalog(Catalog catalog) {
		this.catalog=catalog;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProcessDefinition , 转换好的 ProcessDefinition 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessDefinition , 转换好的 PoJo 对象
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
		org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionMeta.$$proxy$$();
		inst.setAssigneeTypeRange(this.getAssigneeTypeRange());
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setAllowSkip(this.getAllowSkip());
		inst.setCamundaDefinitionId(this.getCamundaDefinitionId());
		inst.setIconFileMobile(this.getIconFileMobile());
		inst.setAllowFetchBack(this.getAllowFetchBack());
		inst.setValid(this.getValid());
		inst.setAllowReject(this.getAllowReject());
		inst.setAllowPriority(this.getAllowPriority());
		inst.setCatalogId(this.getCatalogId());
		inst.setAllowApproveAttachment(this.getAllowApproveAttachment());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setFormDefinitionId(this.getFormDefinitionId());
		inst.setId(this.getId());
		inst.setAllowDraftingAttachment(this.getAllowDraftingAttachment());
		inst.setRejectOption(this.getRejectOption());
		inst.setCamundaDefinitionKey(this.getCamundaDefinitionKey());
		inst.setDrafterRange(this.getDrafterRange());
		inst.setAllowTitle(this.getAllowTitle());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setAllowAgreeWithCondition(this.getAllowAgreeWithCondition());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAllowAbandon(this.getAllowAbandon());
		inst.setAllowApproveComment(this.getAllowApproveComment());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setAllowDraftingComment(this.getAllowDraftingComment());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setAllowTransfer(this.getAllowTransfer());
		inst.setIconFilePc(this.getIconFilePc());
		inst.setSkipForSameApprover(this.getSkipForSameApprover());
		if(all) {
			inst.setFormDefinition(this.getFormDefinition());
			inst.setDefinitionFile(this.getDefinitionFile());
			inst.setCatalog(this.getCatalog());
			inst.setLastUpdateUser(this.getLastUpdateUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessDefinition clone(boolean deep) {
		return EntityContext.clone(ProcessDefinition.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ProcessDefinition
	 * @param processDefinitionMap 包含实体信息的 Map 对象
	 * @return ProcessDefinition , 转换好的的 ProcessDefinition 对象
	*/
	@Transient
	public static ProcessDefinition createFrom(Map<String,Object> processDefinitionMap) {
		if(processDefinitionMap==null) return null;
		ProcessDefinition po = create();
		EntityContext.copyProperties(po,processDefinitionMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessDefinition
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessDefinition , 转换好的的 ProcessDefinition 对象
	*/
	@Transient
	public static ProcessDefinition createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessDefinition po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ProcessDefinition，等同于 new
	 * @return ProcessDefinition 对象
	*/
	@Transient
	public static ProcessDefinition create() {
		return new org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setAssigneeTypeRange(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.ASSIGNEE_TYPE_RANGE)));
			this.setCode(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.NOTES)));
			this.setAllowSkip(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.ALLOW_SKIP)));
			this.setCamundaDefinitionId(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.CAMUNDA_DEFINITION_ID)));
			this.setIconFileMobile(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.ICON_FILE_MOBILE)));
			this.setAllowFetchBack(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.ALLOW_FETCH_BACK)));
			this.setValid(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.VALID)));
			this.setAllowReject(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.ALLOW_REJECT)));
			this.setAllowPriority(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.ALLOW_PRIORITY)));
			this.setCatalogId(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.CATALOG_ID)));
			this.setAllowApproveAttachment(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.ALLOW_APPROVE_ATTACHMENT)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.UPDATE_BY)));
			this.setFormDefinitionId(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.FORM_DEFINITION_ID)));
			this.setId(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.ID)));
			this.setAllowDraftingAttachment(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.ALLOW_DRAFTING_ATTACHMENT)));
			this.setRejectOption(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.REJECT_OPTION)));
			this.setCamundaDefinitionKey(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.CAMUNDA_DEFINITION_KEY)));
			this.setDrafterRange(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.DRAFTER_RANGE)));
			this.setAllowTitle(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.ALLOW_TITLE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProcessDefinitionMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.VERSION)));
			this.setAllowAgreeWithCondition(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.ALLOW_AGREE_WITH_CONDITION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProcessDefinitionMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProcessDefinitionMeta.DELETE_TIME)));
			this.setAllowAbandon(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.ALLOW_ABANDON)));
			this.setAllowApproveComment(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.ALLOW_APPROVE_COMMENT)));
			this.setName(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.TENANT_ID)));
			this.setAllowDraftingComment(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.ALLOW_DRAFTING_COMMENT)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.DELETE_BY)));
			this.setAllowTransfer(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.ALLOW_TRANSFER)));
			this.setIconFilePc(DataParser.parse(String.class, map.get(ProcessDefinitionMeta.ICON_FILE_PC)));
			this.setSkipForSameApprover(DataParser.parse(Integer.class, map.get(ProcessDefinitionMeta.SKIP_FOR_SAME_APPROVER)));
			// others
			this.setFormDefinition(DataParser.parse(FormDefinition.class, map.get(ProcessDefinitionMeta.FORM_DEFINITION)));
			this.setDefinitionFile(DataParser.parse(ProcessDefinitionFile.class, map.get(ProcessDefinitionMeta.DEFINITION_FILE)));
			this.setCatalog(DataParser.parse(Catalog.class, map.get(ProcessDefinitionMeta.CATALOG)));
			this.setLastUpdateUser(DataParser.parse(User.class, map.get(ProcessDefinitionMeta.LAST_UPDATE_USER)));
			return true;
		} else {
			try {
				this.setAssigneeTypeRange( (String)map.get(ProcessDefinitionMeta.ASSIGNEE_TYPE_RANGE));
				this.setCode( (String)map.get(ProcessDefinitionMeta.CODE));
				this.setNotes( (String)map.get(ProcessDefinitionMeta.NOTES));
				this.setAllowSkip( (Integer)map.get(ProcessDefinitionMeta.ALLOW_SKIP));
				this.setCamundaDefinitionId( (String)map.get(ProcessDefinitionMeta.CAMUNDA_DEFINITION_ID));
				this.setIconFileMobile( (String)map.get(ProcessDefinitionMeta.ICON_FILE_MOBILE));
				this.setAllowFetchBack( (Integer)map.get(ProcessDefinitionMeta.ALLOW_FETCH_BACK));
				this.setValid( (Integer)map.get(ProcessDefinitionMeta.VALID));
				this.setAllowReject( (Integer)map.get(ProcessDefinitionMeta.ALLOW_REJECT));
				this.setAllowPriority( (Integer)map.get(ProcessDefinitionMeta.ALLOW_PRIORITY));
				this.setCatalogId( (String)map.get(ProcessDefinitionMeta.CATALOG_ID));
				this.setAllowApproveAttachment( (Integer)map.get(ProcessDefinitionMeta.ALLOW_APPROVE_ATTACHMENT));
				this.setUpdateBy( (String)map.get(ProcessDefinitionMeta.UPDATE_BY));
				this.setFormDefinitionId( (String)map.get(ProcessDefinitionMeta.FORM_DEFINITION_ID));
				this.setId( (String)map.get(ProcessDefinitionMeta.ID));
				this.setAllowDraftingAttachment( (Integer)map.get(ProcessDefinitionMeta.ALLOW_DRAFTING_ATTACHMENT));
				this.setRejectOption( (String)map.get(ProcessDefinitionMeta.REJECT_OPTION));
				this.setCamundaDefinitionKey( (String)map.get(ProcessDefinitionMeta.CAMUNDA_DEFINITION_KEY));
				this.setDrafterRange( (String)map.get(ProcessDefinitionMeta.DRAFTER_RANGE));
				this.setAllowTitle( (Integer)map.get(ProcessDefinitionMeta.ALLOW_TITLE));
				this.setUpdateTime( (Date)map.get(ProcessDefinitionMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(ProcessDefinitionMeta.SORT));
				this.setVersion( (Integer)map.get(ProcessDefinitionMeta.VERSION));
				this.setAllowAgreeWithCondition( (Integer)map.get(ProcessDefinitionMeta.ALLOW_AGREE_WITH_CONDITION));
				this.setCreateBy( (String)map.get(ProcessDefinitionMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProcessDefinitionMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProcessDefinitionMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(ProcessDefinitionMeta.DELETE_TIME));
				this.setAllowAbandon( (Integer)map.get(ProcessDefinitionMeta.ALLOW_ABANDON));
				this.setAllowApproveComment( (Integer)map.get(ProcessDefinitionMeta.ALLOW_APPROVE_COMMENT));
				this.setName( (String)map.get(ProcessDefinitionMeta.NAME));
				this.setTenantId( (String)map.get(ProcessDefinitionMeta.TENANT_ID));
				this.setAllowDraftingComment( (Integer)map.get(ProcessDefinitionMeta.ALLOW_DRAFTING_COMMENT));
				this.setDeleteBy( (String)map.get(ProcessDefinitionMeta.DELETE_BY));
				this.setAllowTransfer( (Integer)map.get(ProcessDefinitionMeta.ALLOW_TRANSFER));
				this.setIconFilePc( (String)map.get(ProcessDefinitionMeta.ICON_FILE_PC));
				this.setSkipForSameApprover( (Integer)map.get(ProcessDefinitionMeta.SKIP_FOR_SAME_APPROVER));
				// others
				this.setFormDefinition( (FormDefinition)map.get(ProcessDefinitionMeta.FORM_DEFINITION));
				this.setDefinitionFile( (ProcessDefinitionFile)map.get(ProcessDefinitionMeta.DEFINITION_FILE));
				this.setCatalog( (Catalog)map.get(ProcessDefinitionMeta.CATALOG));
				this.setLastUpdateUser( (User)map.get(ProcessDefinitionMeta.LAST_UPDATE_USER));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setAssigneeTypeRange(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.ASSIGNEE_TYPE_RANGE)));
			this.setCode(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.NOTES)));
			this.setAllowSkip(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.ALLOW_SKIP)));
			this.setCamundaDefinitionId(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.CAMUNDA_DEFINITION_ID)));
			this.setIconFileMobile(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.ICON_FILE_MOBILE)));
			this.setAllowFetchBack(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.ALLOW_FETCH_BACK)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.VALID)));
			this.setAllowReject(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.ALLOW_REJECT)));
			this.setAllowPriority(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.ALLOW_PRIORITY)));
			this.setCatalogId(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.CATALOG_ID)));
			this.setAllowApproveAttachment(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.ALLOW_APPROVE_ATTACHMENT)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.UPDATE_BY)));
			this.setFormDefinitionId(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.FORM_DEFINITION_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.ID)));
			this.setAllowDraftingAttachment(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.ALLOW_DRAFTING_ATTACHMENT)));
			this.setRejectOption(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.REJECT_OPTION)));
			this.setCamundaDefinitionKey(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.CAMUNDA_DEFINITION_KEY)));
			this.setDrafterRange(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.DRAFTER_RANGE)));
			this.setAllowTitle(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.ALLOW_TITLE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProcessDefinitionMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.VERSION)));
			this.setAllowAgreeWithCondition(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.ALLOW_AGREE_WITH_CONDITION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProcessDefinitionMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProcessDefinitionMeta.DELETE_TIME)));
			this.setAllowAbandon(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.ALLOW_ABANDON)));
			this.setAllowApproveComment(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.ALLOW_APPROVE_COMMENT)));
			this.setName(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.TENANT_ID)));
			this.setAllowDraftingComment(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.ALLOW_DRAFTING_COMMENT)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.DELETE_BY)));
			this.setAllowTransfer(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.ALLOW_TRANSFER)));
			this.setIconFilePc(DataParser.parse(String.class, r.getValue(ProcessDefinitionMeta.ICON_FILE_PC)));
			this.setSkipForSameApprover(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionMeta.SKIP_FOR_SAME_APPROVER)));
			return true;
		} else {
			try {
				this.setAssigneeTypeRange( (String)r.getValue(ProcessDefinitionMeta.ASSIGNEE_TYPE_RANGE));
				this.setCode( (String)r.getValue(ProcessDefinitionMeta.CODE));
				this.setNotes( (String)r.getValue(ProcessDefinitionMeta.NOTES));
				this.setAllowSkip( (Integer)r.getValue(ProcessDefinitionMeta.ALLOW_SKIP));
				this.setCamundaDefinitionId( (String)r.getValue(ProcessDefinitionMeta.CAMUNDA_DEFINITION_ID));
				this.setIconFileMobile( (String)r.getValue(ProcessDefinitionMeta.ICON_FILE_MOBILE));
				this.setAllowFetchBack( (Integer)r.getValue(ProcessDefinitionMeta.ALLOW_FETCH_BACK));
				this.setValid( (Integer)r.getValue(ProcessDefinitionMeta.VALID));
				this.setAllowReject( (Integer)r.getValue(ProcessDefinitionMeta.ALLOW_REJECT));
				this.setAllowPriority( (Integer)r.getValue(ProcessDefinitionMeta.ALLOW_PRIORITY));
				this.setCatalogId( (String)r.getValue(ProcessDefinitionMeta.CATALOG_ID));
				this.setAllowApproveAttachment( (Integer)r.getValue(ProcessDefinitionMeta.ALLOW_APPROVE_ATTACHMENT));
				this.setUpdateBy( (String)r.getValue(ProcessDefinitionMeta.UPDATE_BY));
				this.setFormDefinitionId( (String)r.getValue(ProcessDefinitionMeta.FORM_DEFINITION_ID));
				this.setId( (String)r.getValue(ProcessDefinitionMeta.ID));
				this.setAllowDraftingAttachment( (Integer)r.getValue(ProcessDefinitionMeta.ALLOW_DRAFTING_ATTACHMENT));
				this.setRejectOption( (String)r.getValue(ProcessDefinitionMeta.REJECT_OPTION));
				this.setCamundaDefinitionKey( (String)r.getValue(ProcessDefinitionMeta.CAMUNDA_DEFINITION_KEY));
				this.setDrafterRange( (String)r.getValue(ProcessDefinitionMeta.DRAFTER_RANGE));
				this.setAllowTitle( (Integer)r.getValue(ProcessDefinitionMeta.ALLOW_TITLE));
				this.setUpdateTime( (Date)r.getValue(ProcessDefinitionMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(ProcessDefinitionMeta.SORT));
				this.setVersion( (Integer)r.getValue(ProcessDefinitionMeta.VERSION));
				this.setAllowAgreeWithCondition( (Integer)r.getValue(ProcessDefinitionMeta.ALLOW_AGREE_WITH_CONDITION));
				this.setCreateBy( (String)r.getValue(ProcessDefinitionMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProcessDefinitionMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProcessDefinitionMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(ProcessDefinitionMeta.DELETE_TIME));
				this.setAllowAbandon( (Integer)r.getValue(ProcessDefinitionMeta.ALLOW_ABANDON));
				this.setAllowApproveComment( (Integer)r.getValue(ProcessDefinitionMeta.ALLOW_APPROVE_COMMENT));
				this.setName( (String)r.getValue(ProcessDefinitionMeta.NAME));
				this.setTenantId( (String)r.getValue(ProcessDefinitionMeta.TENANT_ID));
				this.setAllowDraftingComment( (Integer)r.getValue(ProcessDefinitionMeta.ALLOW_DRAFTING_COMMENT));
				this.setDeleteBy( (String)r.getValue(ProcessDefinitionMeta.DELETE_BY));
				this.setAllowTransfer( (Integer)r.getValue(ProcessDefinitionMeta.ALLOW_TRANSFER));
				this.setIconFilePc( (String)r.getValue(ProcessDefinitionMeta.ICON_FILE_PC));
				this.setSkipForSameApprover( (Integer)r.getValue(ProcessDefinitionMeta.SKIP_FOR_SAME_APPROVER));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}