package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_INSTANCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程实例
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-04-18 16:27:57
 * @sign DD40DB96F54469B5A349341038353034
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_instance")
public class ProcessInstance extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_INSTANCE.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private Integer id;
	
	/**
	 * 起草人ID：起草人ID
	*/
	@ApiModelProperty(required = false,value="起草人ID" , notes = "起草人ID")
	private String drafterId;
	
	/**
	 * 起草人类型：起草人类型
	*/
	@ApiModelProperty(required = false,value="起草人类型" , notes = "起草人类型")
	private String drafterType;
	
	/**
	 * 流程定义ID：流程定义ID
	*/
	@ApiModelProperty(required = false,value="流程定义ID" , notes = "流程定义ID")
	private String processDefinitionId;
	
	/**
	 * 流程标题：流程标题
	*/
	@ApiModelProperty(required = false,value="流程标题" , notes = "流程标题")
	private String title;
	
	/**
	 * 审批状态：审批状态
	*/
	@ApiModelProperty(required = false,value="审批状态" , notes = "审批状态")
	private String approvalStatus;
	
	/**
	 * camunda流程实例ID：camunda流程实例ID
	*/
	@ApiModelProperty(required = false,value="camunda流程实例ID" , notes = "camunda流程实例ID")
	private Integer camundaInstanceId;
	
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
	 * 最后修改人：最后修改人
	*/
	@ApiModelProperty(required = false,value="最后修改人" , notes = "最后修改人")
	private User lastUpdateUser;
	
	/**
	 * 流程定义：流程定义文件
	*/
	@ApiModelProperty(required = false,value="流程定义" , notes = "流程定义文件")
	private ProcessDefinitionFile definitionFile;
	
	/**
	 * 获得 id<br>
	 * id
	 * @return id
	*/
	public Integer getId() {
		return id;
	}
	
	/**
	 * 设置 id
	 * @param id id
	 * @return 当前对象
	*/
	public ProcessInstance setId(Integer id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 起草人ID<br>
	 * 起草人ID
	 * @return 起草人ID
	*/
	public String getDrafterId() {
		return drafterId;
	}
	
	/**
	 * 设置 起草人ID
	 * @param drafterId 起草人ID
	 * @return 当前对象
	*/
	public ProcessInstance setDrafterId(String drafterId) {
		this.drafterId=drafterId;
		return this;
	}
	
	/**
	 * 获得 起草人类型<br>
	 * 起草人类型
	 * @return 起草人类型
	*/
	public String getDrafterType() {
		return drafterType;
	}
	
	/**
	 * 设置 起草人类型
	 * @param drafterType 起草人类型
	 * @return 当前对象
	*/
	public ProcessInstance setDrafterType(String drafterType) {
		this.drafterType=drafterType;
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
	public ProcessInstance setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId=processDefinitionId;
		return this;
	}
	
	/**
	 * 获得 流程标题<br>
	 * 流程标题
	 * @return 流程标题
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 流程标题
	 * @param title 流程标题
	 * @return 当前对象
	*/
	public ProcessInstance setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 审批状态<br>
	 * 审批状态
	 * @return 审批状态
	*/
	public String getApprovalStatus() {
		return approvalStatus;
	}
	
	/**
	 * 设置 审批状态
	 * @param approvalStatus 审批状态
	 * @return 当前对象
	*/
	public ProcessInstance setApprovalStatus(String approvalStatus) {
		this.approvalStatus=approvalStatus;
		return this;
	}
	
	/**
	 * 获得 camunda流程实例ID<br>
	 * camunda流程实例ID
	 * @return camunda流程实例ID
	*/
	public Integer getCamundaInstanceId() {
		return camundaInstanceId;
	}
	
	/**
	 * 设置 camunda流程实例ID
	 * @param camundaInstanceId camunda流程实例ID
	 * @return 当前对象
	*/
	public ProcessInstance setCamundaInstanceId(Integer camundaInstanceId) {
		this.camundaInstanceId=camundaInstanceId;
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
	public ProcessInstance setCreateBy(String createBy) {
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
	public ProcessInstance setCreateTime(Date createTime) {
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
	public ProcessInstance setUpdateBy(String updateBy) {
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
	public ProcessInstance setUpdateTime(Date updateTime) {
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
	public ProcessInstance setDeleted(Integer deleted) {
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
	public ProcessInstance setDeleteBy(String deleteBy) {
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
	public ProcessInstance setDeleteTime(Date deleteTime) {
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
	public ProcessInstance setVersion(Integer version) {
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
	public ProcessInstance setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public ProcessInstance setLastUpdateUser(User lastUpdateUser) {
		this.lastUpdateUser=lastUpdateUser;
		return this;
	}
	
	/**
	 * 获得 流程定义<br>
	 * 流程定义文件
	 * @return 流程定义
	*/
	public ProcessDefinitionFile getDefinitionFile() {
		return definitionFile;
	}
	
	/**
	 * 设置 流程定义
	 * @param definitionFile 流程定义
	 * @return 当前对象
	*/
	public ProcessInstance setDefinitionFile(ProcessDefinitionFile definitionFile) {
		this.definitionFile=definitionFile;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProcessInstance , 转换好的 ProcessInstance 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessInstance , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ProcessInstance
	 * @param processInstanceMap 包含实体信息的 Map 对象
	 * @return ProcessInstance , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessInstance createFrom(Map<String,Object> processInstanceMap) {
		if(processInstanceMap==null) return null;
		ProcessInstance po = EntityContext.create(ProcessInstance.class, processInstanceMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessInstance
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessInstance , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessInstance createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessInstance po = EntityContext.create(ProcessInstance.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ProcessInstance，等同于 new
	 * @return ProcessInstance 对象
	*/
	@Transient
	public static ProcessInstance create() {
		return EntityContext.create(ProcessInstance.class);
	}
}