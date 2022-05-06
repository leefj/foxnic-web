package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_FORM_INSTANCE_BILL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程实例表单业务单据
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-06 14:20:12
 * @sign 8E4607308FAE37D56865AA356FA75717
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_form_instance_bill")
public class FormInstanceBill extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_FORM_INSTANCE_BILL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 流程定义ID：流程定义ID
	*/
	@ApiModelProperty(required = false,value="流程定义ID" , notes = "流程定义ID")
	private String processDefinitionId;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID")
	private String processInstanceId;
	
	/**
	 * 表单定义ID：表单定义ID
	*/
	@ApiModelProperty(required = false,value="表单定义ID" , notes = "表单定义ID")
	private Integer formDefinitionId;
	
	/**
	 * 表单实例ID：表单实例ID
	*/
	@ApiModelProperty(required = false,value="表单实例ID" , notes = "表单实例ID")
	private String formInstanceId;
	
	/**
	 * 业务单据号：业务单据号
	*/
	@ApiModelProperty(required = false,value="业务单据号" , notes = "业务单据号")
	private String billId;
	
	/**
	 * 业务单据类型：业务单据类型
	*/
	@ApiModelProperty(required = false,value="业务单据类型" , notes = "业务单据类型")
	private String billType;
	
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
	public FormInstanceBill setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 流程定义ID<br>
	 * 流程定义ID
	 * @return 流程定义ID
	*/
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	
	/**
	 * 设置 流程定义ID
	 * @param processDefinitionId 流程定义ID
	 * @return 当前对象
	*/
	public FormInstanceBill setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId=processDefinitionId;
		return this;
	}
	
	/**
	 * 获得 流程实例ID<br>
	 * 流程实例ID
	 * @return 流程实例ID
	*/
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	
	/**
	 * 设置 流程实例ID
	 * @param processInstanceId 流程实例ID
	 * @return 当前对象
	*/
	public FormInstanceBill setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 表单定义ID<br>
	 * 表单定义ID
	 * @return 表单定义ID
	*/
	public Integer getFormDefinitionId() {
		return formDefinitionId;
	}
	
	/**
	 * 设置 表单定义ID
	 * @param formDefinitionId 表单定义ID
	 * @return 当前对象
	*/
	public FormInstanceBill setFormDefinitionId(Integer formDefinitionId) {
		this.formDefinitionId=formDefinitionId;
		return this;
	}
	
	/**
	 * 获得 表单实例ID<br>
	 * 表单实例ID
	 * @return 表单实例ID
	*/
	public String getFormInstanceId() {
		return formInstanceId;
	}
	
	/**
	 * 设置 表单实例ID
	 * @param formInstanceId 表单实例ID
	 * @return 当前对象
	*/
	public FormInstanceBill setFormInstanceId(String formInstanceId) {
		this.formInstanceId=formInstanceId;
		return this;
	}
	
	/**
	 * 获得 业务单据号<br>
	 * 业务单据号
	 * @return 业务单据号
	*/
	public String getBillId() {
		return billId;
	}
	
	/**
	 * 设置 业务单据号
	 * @param billId 业务单据号
	 * @return 当前对象
	*/
	public FormInstanceBill setBillId(String billId) {
		this.billId=billId;
		return this;
	}
	
	/**
	 * 获得 业务单据类型<br>
	 * 业务单据类型
	 * @return 业务单据类型
	*/
	public String getBillType() {
		return billType;
	}
	
	/**
	 * 设置 业务单据类型
	 * @param billType 业务单据类型
	 * @return 当前对象
	*/
	public FormInstanceBill setBillType(String billType) {
		this.billType=billType;
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
	public FormInstanceBill setCreateBy(String createBy) {
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
	public FormInstanceBill setCreateTime(Date createTime) {
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
	public FormInstanceBill setUpdateBy(String updateBy) {
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
	public FormInstanceBill setUpdateTime(Date updateTime) {
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
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public FormInstanceBill setDeleted(Integer deleted) {
		this.deleted=deleted;
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
	public FormInstanceBill setDeleteBy(String deleteBy) {
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
	public FormInstanceBill setDeleteTime(Date deleteTime) {
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
	public FormInstanceBill setVersion(Integer version) {
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
	public FormInstanceBill setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return FormInstanceBill , 转换好的 FormInstanceBill 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FormInstanceBill , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 FormInstanceBill
	 * @param formInstanceBillMap 包含实体信息的 Map 对象
	 * @return FormInstanceBill , 转换好的的 FormInstanceBill 对象
	*/
	@Transient
	public static FormInstanceBill createFrom(Map<String,Object> formInstanceBillMap) {
		if(formInstanceBillMap==null) return null;
		FormInstanceBill po = EntityContext.create(FormInstanceBill.class, formInstanceBillMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 FormInstanceBill
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FormInstanceBill , 转换好的的 FormInstanceBill 对象
	*/
	@Transient
	public static FormInstanceBill createFrom(Object pojo) {
		if(pojo==null) return null;
		FormInstanceBill po = EntityContext.create(FormInstanceBill.class,pojo);
		return po;
	}

	/**
	 * 创建一个 FormInstanceBill，等同于 new
	 * @return FormInstanceBill 对象
	*/
	@Transient
	public static FormInstanceBill create() {
		return EntityContext.create(FormInstanceBill.class);
	}
}