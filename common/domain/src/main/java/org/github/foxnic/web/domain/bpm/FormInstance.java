package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_FORM_INSTANCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程实例表单
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:56
 * @sign F82BAB8909EF5411389F2A1D0DA28A72
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_form_instance")
public class FormInstance extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_FORM_INSTANCE.$TABLE;
	
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
	private String formDefinitionId;
	
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
	 * 表单定义：表单定义
	*/
	@ApiModelProperty(required = false,value="表单定义" , notes = "表单定义")
	private FormDefinition formDefinition;
	
	/**
	 * 业务单据清单：表单实例关联的业务单据清单
	*/
	@ApiModelProperty(required = false,value="业务单据清单" , notes = "表单实例关联的业务单据清单")
	private List<FormInstanceBill> bills;
	
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
	public FormInstance setId(String id) {
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
	public FormInstance setProcessDefinitionId(String processDefinitionId) {
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
	public FormInstance setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 表单定义ID<br>
	 * 表单定义ID
	 * @return 表单定义ID
	*/
	public String getFormDefinitionId() {
		return formDefinitionId;
	}
	
	/**
	 * 设置 表单定义ID
	 * @param formDefinitionId 表单定义ID
	 * @return 当前对象
	*/
	public FormInstance setFormDefinitionId(String formDefinitionId) {
		this.formDefinitionId=formDefinitionId;
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
	public FormInstance setCreateBy(String createBy) {
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
	public FormInstance setCreateTime(Date createTime) {
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
	public FormInstance setUpdateBy(String updateBy) {
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
	public FormInstance setUpdateTime(Date updateTime) {
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
	public FormInstance setDeleted(Integer deleted) {
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
	public FormInstance setDeleted(Boolean deletedBool) {
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
	public FormInstance setDeleteBy(String deleteBy) {
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
	public FormInstance setDeleteTime(Date deleteTime) {
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
	public FormInstance setVersion(Integer version) {
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
	public FormInstance setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public FormInstance setFormDefinition(FormDefinition formDefinition) {
		this.formDefinition=formDefinition;
		return this;
	}
	
	/**
	 * 获得 业务单据清单<br>
	 * 表单实例关联的业务单据清单
	 * @return 业务单据清单
	*/
	public List<FormInstanceBill> getBills() {
		return bills;
	}
	
	/**
	 * 设置 业务单据清单
	 * @param bills 业务单据清单
	 * @return 当前对象
	*/
	public FormInstance setBills(List<FormInstanceBill> bills) {
		this.bills=bills;
		return this;
	}
	
	/**
	 * 添加 业务单据清单
	 * @param bill 业务单据清单
	 * @return 当前对象
	*/
	public FormInstance addBill(FormInstanceBill... bill) {
		if(this.bills==null) bills=new ArrayList<>();
		this.bills.addAll(Arrays.asList(bill));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return FormInstance , 转换好的 FormInstance 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FormInstance , 转换好的 PoJo 对象
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
	public FormInstance clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public FormInstance duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.FormInstanceMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.FormInstanceMeta.$$proxy$$();
		inst.setProcessDefinitionId(this.getProcessDefinitionId());
		inst.setProcessInstanceId(this.getProcessInstanceId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setFormDefinitionId(this.getFormDefinitionId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setFormDefinition(this.getFormDefinition());
			inst.setBills(this.getBills());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public FormInstance clone(boolean deep) {
		return EntityContext.clone(FormInstance.class,this,deep);
	}

	/**
	 * 将 Map 转换成 FormInstance
	 * @param formInstanceMap 包含实体信息的 Map 对象
	 * @return FormInstance , 转换好的的 FormInstance 对象
	*/
	@Transient
	public static FormInstance createFrom(Map<String,Object> formInstanceMap) {
		if(formInstanceMap==null) return null;
		FormInstance po = EntityContext.create(FormInstance.class, formInstanceMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 FormInstance
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FormInstance , 转换好的的 FormInstance 对象
	*/
	@Transient
	public static FormInstance createFrom(Object pojo) {
		if(pojo==null) return null;
		FormInstance po = EntityContext.create(FormInstance.class,pojo);
		return po;
	}

	/**
	 * 创建一个 FormInstance，等同于 new
	 * @return FormInstance 对象
	*/
	@Transient
	public static FormInstance create() {
		return EntityContext.create(FormInstance.class);
	}
}