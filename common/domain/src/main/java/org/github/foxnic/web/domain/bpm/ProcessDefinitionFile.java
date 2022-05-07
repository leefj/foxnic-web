package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_DEFINITION_FILE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;
import java.util.List;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程定义文件
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-08 07:12:48
 * @sign 3B51293AC3330D43825FF7DE1DFB2992
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_definition_file")
public class ProcessDefinitionFile extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_DEFINITION_FILE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private String id;
	
	/**
	 * 流程定义ID：流程定义ID
	*/
	@ApiModelProperty(required = false,value="流程定义ID" , notes = "流程定义ID")
	private String processDefinitionId;
	
	/**
	 * 流程文件ID：流程文件ID
	*/
	@ApiModelProperty(required = false,value="流程文件ID" , notes = "流程文件ID")
	private String fileId;
	
	/**
	 * 版本号：版本号
	*/
	@ApiModelProperty(required = false,value="版本号" , notes = "版本号")
	private String versionNo;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 是否激活：只能有一个版本是激活的
	*/
	@ApiModelProperty(required = false,value="是否激活" , notes = "只能有一个版本是激活的")
	private Integer activated;
	@Transient
	private Boolean activatedBool;
	
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
	 * 部署结果：部署结果
	*/
	@ApiModelProperty(required = false,value="部署结果" , notes = "部署结果")
	private String deployResult;
	
	/**
	 * 部署成功：逻辑值
	*/
	@ApiModelProperty(required = false,value="部署成功" , notes = "逻辑值")
	private Integer deploySuccess;
	
	/**
	 * 提示信息：提示信息
	*/
	@ApiModelProperty(required = false,value="提示信息" , notes = "提示信息")
	private String deployError;
	
	/**
	 * 最后修改人：最后修改人
	*/
	@ApiModelProperty(required = false,value="最后修改人" , notes = "最后修改人")
	private User lastUpdateUser;
	
	/**
	 * 审批节点清单：审批节点清单
	*/
	@ApiModelProperty(required = false,value="审批节点清单" , notes = "审批节点清单")
	private List<ProcessDefinitionNode> nodes;
	
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
	public ProcessDefinitionFile setId(String id) {
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
	public ProcessDefinitionFile setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId=processDefinitionId;
		return this;
	}
	
	/**
	 * 获得 流程文件ID<br>
	 * 流程文件ID
	 * @return 流程文件ID
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 流程文件ID
	 * @param fileId 流程文件ID
	 * @return 当前对象
	*/
	public ProcessDefinitionFile setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 版本号<br>
	 * 版本号
	 * @return 版本号
	*/
	public String getVersionNo() {
		return versionNo;
	}
	
	/**
	 * 设置 版本号
	 * @param versionNo 版本号
	 * @return 当前对象
	*/
	public ProcessDefinitionFile setVersionNo(String versionNo) {
		this.versionNo=versionNo;
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
	public ProcessDefinitionFile setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 是否激活<br>
	 * 只能有一个版本是激活的
	 * @return 是否激活
	*/
	public Integer getActivated() {
		return activated;
	}
	
	/**
	 * 获得 是否激活 的投影属性<br>
	 * 等价于 getActivated 方法，获得对应的枚举类型
	 * @return 是否激活
	*/
	@Transient
	public Boolean isActivated() {
		if(this.activatedBool==null) {
			this.activatedBool=DataParser.parseBoolean(activated);
		}
		return this.activatedBool ;
	}
	
	/**
	 * 设置 是否激活
	 * @param activated 是否激活
	 * @return 当前对象
	*/
	public ProcessDefinitionFile setActivated(Integer activated) {
		this.activated=activated;
		this.activatedBool=DataParser.parseBoolean(activated);
		return this;
	}
	
	/**
	 * 设置 是否激活的投影属性，等同于设置 是否激活
	 * @param activatedBool 是否激活
	 * @return 当前对象
	*/
	@Transient
	public ProcessDefinitionFile setActivated(Boolean activatedBool) {
		if(activatedBool==null) {
			this.activated=null;
		} else {
			this.activated=activatedBool?1:0;
		}
		this.activatedBool=activatedBool;
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
	public ProcessDefinitionFile setNotes(String notes) {
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
	public ProcessDefinitionFile setCreateBy(String createBy) {
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
	public ProcessDefinitionFile setCreateTime(Date createTime) {
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
	public ProcessDefinitionFile setUpdateBy(String updateBy) {
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
	public ProcessDefinitionFile setUpdateTime(Date updateTime) {
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
	public ProcessDefinitionFile setDeleted(Integer deleted) {
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
	public ProcessDefinitionFile setDeleteBy(String deleteBy) {
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
	public ProcessDefinitionFile setDeleteTime(Date deleteTime) {
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
	public ProcessDefinitionFile setVersion(Integer version) {
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
	public ProcessDefinitionFile setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 部署结果<br>
	 * 部署结果
	 * @return 部署结果
	*/
	public String getDeployResult() {
		return deployResult;
	}
	
	/**
	 * 设置 部署结果
	 * @param deployResult 部署结果
	 * @return 当前对象
	*/
	public ProcessDefinitionFile setDeployResult(String deployResult) {
		this.deployResult=deployResult;
		return this;
	}
	
	/**
	 * 获得 部署成功<br>
	 * 逻辑值
	 * @return 部署成功
	*/
	public Integer getDeploySuccess() {
		return deploySuccess;
	}
	
	/**
	 * 设置 部署成功
	 * @param deploySuccess 部署成功
	 * @return 当前对象
	*/
	public ProcessDefinitionFile setDeploySuccess(Integer deploySuccess) {
		this.deploySuccess=deploySuccess;
		return this;
	}
	
	/**
	 * 获得 提示信息<br>
	 * 提示信息
	 * @return 提示信息
	*/
	public String getDeployError() {
		return deployError;
	}
	
	/**
	 * 设置 提示信息
	 * @param deployError 提示信息
	 * @return 当前对象
	*/
	public ProcessDefinitionFile setDeployError(String deployError) {
		this.deployError=deployError;
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
	public ProcessDefinitionFile setLastUpdateUser(User lastUpdateUser) {
		this.lastUpdateUser=lastUpdateUser;
		return this;
	}
	
	/**
	 * 获得 审批节点清单<br>
	 * 审批节点清单
	 * @return 审批节点清单
	*/
	public List<ProcessDefinitionNode> getNodes() {
		return nodes;
	}
	
	/**
	 * 设置 审批节点清单
	 * @param nodes 审批节点清单
	 * @return 当前对象
	*/
	public ProcessDefinitionFile setNodes(List<ProcessDefinitionNode> nodes) {
		this.nodes=nodes;
		return this;
	}
	
	/**
	 * 添加 审批节点清单
	 * @param node 审批节点清单
	 * @return 当前对象
	*/
	public ProcessDefinitionFile addNode(ProcessDefinitionNode node) {
		if(this.nodes==null) nodes=new ArrayList<>();
		this.nodes.add(node);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProcessDefinitionFile , 转换好的 ProcessDefinitionFile 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessDefinitionFile , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ProcessDefinitionFile
	 * @param processDefinitionFileMap 包含实体信息的 Map 对象
	 * @return ProcessDefinitionFile , 转换好的的 ProcessDefinitionFile 对象
	*/
	@Transient
	public static ProcessDefinitionFile createFrom(Map<String,Object> processDefinitionFileMap) {
		if(processDefinitionFileMap==null) return null;
		ProcessDefinitionFile po = EntityContext.create(ProcessDefinitionFile.class, processDefinitionFileMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessDefinitionFile
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessDefinitionFile , 转换好的的 ProcessDefinitionFile 对象
	*/
	@Transient
	public static ProcessDefinitionFile createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessDefinitionFile po = EntityContext.create(ProcessDefinitionFile.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ProcessDefinitionFile，等同于 new
	 * @return ProcessDefinitionFile 对象
	*/
	@Transient
	public static ProcessDefinitionFile create() {
		return EntityContext.create(ProcessDefinitionFile.class);
	}
}