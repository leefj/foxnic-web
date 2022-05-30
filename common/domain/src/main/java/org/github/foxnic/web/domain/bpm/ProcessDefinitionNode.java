package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_DEFINITION_NODE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.bpm.CamundaNodeType;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程定义节点
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-11 11:17:25
 * @sign 28A5F3A05F45A8C3A0ACA76389A948E4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_definition_node")
public class ProcessDefinitionNode extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_DEFINITION_NODE.$TABLE;
	
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
	private String processDefinitionFileId;
	
	/**
	 * 节点ID：节点ID
	*/
	@ApiModelProperty(required = false,value="节点ID" , notes = "节点ID")
	private String camundaNodeId;
	
	/**
	 * 节点类型：节点类型
	*/
	@ApiModelProperty(required = false,value="节点类型" , notes = "节点类型")
	private String nodeType;
	@Transient
	private CamundaNodeType nodeTypeEnum;
	
	/**
	 * 节点名称：节点名称
	*/
	@ApiModelProperty(required = false,value="节点名称" , notes = "节点名称")
	private String nodeName;
	
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
	 * 序号：序号
	*/
	@ApiModelProperty(required = false,value="序号" , notes = "序号")
	private Integer sort;
	
	/**
	 * 审批人清单：审批人清单
	*/
	@ApiModelProperty(required = false,value="审批人清单" , notes = "审批人清单")
	private List<ProcessDefinitionNodeAssignee> assignees;
	
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
	public ProcessDefinitionNode setId(String id) {
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
	public ProcessDefinitionNode setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId=processDefinitionId;
		return this;
	}
	
	/**
	 * 获得 流程文件ID<br>
	 * 流程文件ID
	 * @return 流程文件ID
	*/
	public String getProcessDefinitionFileId() {
		return processDefinitionFileId;
	}
	
	/**
	 * 设置 流程文件ID
	 * @param processDefinitionFileId 流程文件ID
	 * @return 当前对象
	*/
	public ProcessDefinitionNode setProcessDefinitionFileId(String processDefinitionFileId) {
		this.processDefinitionFileId=processDefinitionFileId;
		return this;
	}
	
	/**
	 * 获得 节点ID<br>
	 * 节点ID
	 * @return 节点ID
	*/
	public String getCamundaNodeId() {
		return camundaNodeId;
	}
	
	/**
	 * 设置 节点ID
	 * @param camundaNodeId 节点ID
	 * @return 当前对象
	*/
	public ProcessDefinitionNode setCamundaNodeId(String camundaNodeId) {
		this.camundaNodeId=camundaNodeId;
		return this;
	}
	
	/**
	 * 获得 节点类型<br>
	 * 节点类型
	 * @return 节点类型
	*/
	public String getNodeType() {
		return nodeType;
	}
	
	/**
	 * 获得 节点类型 的投影属性<br>
	 * 等价于 getNodeType 方法，获得对应的枚举类型
	 * @return 节点类型
	*/
	@Transient
	public CamundaNodeType getNodeTypeEnum() {
		if(this.nodeTypeEnum==null) {
			this.nodeTypeEnum = (CamundaNodeType) EnumUtil.parseByCode(CamundaNodeType.values(),nodeType);
		}
		return this.nodeTypeEnum ;
	}
	
	/**
	 * 设置 节点类型
	 * @param nodeType 节点类型
	 * @return 当前对象
	*/
	public ProcessDefinitionNode setNodeType(String nodeType) {
		this.nodeType=nodeType;
		this.nodeTypeEnum= (CamundaNodeType) EnumUtil.parseByCode(CamundaNodeType.values(),nodeType) ;
		if(StringUtil.hasContent(nodeType) && this.nodeTypeEnum==null) {
			throw new IllegalArgumentException( nodeType + " is not one of CamundaNodeType");
		}
		return this;
	}
	
	/**
	 * 设置 节点类型的投影属性，等同于设置 节点类型
	 * @param nodeTypeEnum 节点类型
	 * @return 当前对象
	*/
	@Transient
	public ProcessDefinitionNode setNodeTypeEnum(CamundaNodeType nodeTypeEnum) {
		if(nodeTypeEnum==null) {
			this.setNodeType(null);
		} else {
			this.setNodeType(nodeTypeEnum.code());
		}
		this.nodeTypeEnum=nodeTypeEnum;
		return this;
	}
	
	/**
	 * 获得 节点名称<br>
	 * 节点名称
	 * @return 节点名称
	*/
	public String getNodeName() {
		return nodeName;
	}
	
	/**
	 * 设置 节点名称
	 * @param nodeName 节点名称
	 * @return 当前对象
	*/
	public ProcessDefinitionNode setNodeName(String nodeName) {
		this.nodeName=nodeName;
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
	public ProcessDefinitionNode setNotes(String notes) {
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
	public ProcessDefinitionNode setCreateBy(String createBy) {
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
	public ProcessDefinitionNode setCreateTime(Date createTime) {
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
	public ProcessDefinitionNode setUpdateBy(String updateBy) {
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
	public ProcessDefinitionNode setUpdateTime(Date updateTime) {
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
	public ProcessDefinitionNode setDeleted(Integer deleted) {
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
	public ProcessDefinitionNode setDeleted(Boolean deletedBool) {
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
	public ProcessDefinitionNode setDeleteBy(String deleteBy) {
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
	public ProcessDefinitionNode setDeleteTime(Date deleteTime) {
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
	public ProcessDefinitionNode setVersion(Integer version) {
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
	public ProcessDefinitionNode setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public ProcessDefinitionNode setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 审批人清单<br>
	 * 审批人清单
	 * @return 审批人清单
	*/
	public List<ProcessDefinitionNodeAssignee> getAssignees() {
		return assignees;
	}
	
	/**
	 * 设置 审批人清单
	 * @param assignees 审批人清单
	 * @return 当前对象
	*/
	public ProcessDefinitionNode setAssignees(List<ProcessDefinitionNodeAssignee> assignees) {
		this.assignees=assignees;
		return this;
	}
	
	/**
	 * 添加 审批人清单
	 * @param assignee 审批人清单
	 * @return 当前对象
	*/
	public ProcessDefinitionNode addAssignee(ProcessDefinitionNodeAssignee assignee) {
		if(this.assignees==null) assignees=new ArrayList<>();
		this.assignees.add(assignee);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProcessDefinitionNode , 转换好的 ProcessDefinitionNode 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessDefinitionNode , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ProcessDefinitionNode
	 * @param processDefinitionNodeMap 包含实体信息的 Map 对象
	 * @return ProcessDefinitionNode , 转换好的的 ProcessDefinitionNode 对象
	*/
	@Transient
	public static ProcessDefinitionNode createFrom(Map<String,Object> processDefinitionNodeMap) {
		if(processDefinitionNodeMap==null) return null;
		ProcessDefinitionNode po = EntityContext.create(ProcessDefinitionNode.class, processDefinitionNodeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessDefinitionNode
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessDefinitionNode , 转换好的的 ProcessDefinitionNode 对象
	*/
	@Transient
	public static ProcessDefinitionNode createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessDefinitionNode po = EntityContext.create(ProcessDefinitionNode.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ProcessDefinitionNode，等同于 new
	 * @return ProcessDefinitionNode 对象
	*/
	@Transient
	public static ProcessDefinitionNode create() {
		return EntityContext.create(ProcessDefinitionNode.class);
	}
}