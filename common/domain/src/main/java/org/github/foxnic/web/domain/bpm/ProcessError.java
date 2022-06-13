package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_ERROR;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程错误信息
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-13 16:36:09
 * @sign DD3F0DD5AB1B32E06AE21D34CE6AB473
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_error")
public class ProcessError extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_ERROR.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private String id;
	
	/**
	 * 流程ID：流程ID
	*/
	@ApiModelProperty(required = false,value="流程ID" , notes = "流程ID")
	private String processInstanceId;
	
	/**
	 * 审批节点：审批节点
	*/
	@ApiModelProperty(required = false,value="审批节点" , notes = "审批节点")
	private String approvalNodeId;
	
	/**
	 * 错误节点：错误节点
	*/
	@ApiModelProperty(required = false,value="错误节点" , notes = "错误节点")
	private String errorNodeId;
	
	/**
	 * 错误消息：错误消息
	*/
	@ApiModelProperty(required = false,value="错误消息" , notes = "错误消息")
	private String errorMessage;
	
	/**
	 * 错误时间：错误时间
	*/
	@ApiModelProperty(required = false,value="错误时间" , notes = "错误时间")
	private Date errorTime;
	
	/**
	 * 原始：incident id
	*/
	@ApiModelProperty(required = false,value="原始" , notes = "incident id")
	private String camundaIncidentId;
	
	/**
	 * 错误类型：错误类型
	*/
	@ApiModelProperty(required = false,value="错误类型" , notes = "错误类型")
	private String errorType;
	
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
	public ProcessError setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 流程ID<br>
	 * 流程ID
	 * @return 流程ID
	*/
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	
	/**
	 * 设置 流程ID
	 * @param processInstanceId 流程ID
	 * @return 当前对象
	*/
	public ProcessError setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 审批节点<br>
	 * 审批节点
	 * @return 审批节点
	*/
	public String getApprovalNodeId() {
		return approvalNodeId;
	}
	
	/**
	 * 设置 审批节点
	 * @param approvalNodeId 审批节点
	 * @return 当前对象
	*/
	public ProcessError setApprovalNodeId(String approvalNodeId) {
		this.approvalNodeId=approvalNodeId;
		return this;
	}
	
	/**
	 * 获得 错误节点<br>
	 * 错误节点
	 * @return 错误节点
	*/
	public String getErrorNodeId() {
		return errorNodeId;
	}
	
	/**
	 * 设置 错误节点
	 * @param errorNodeId 错误节点
	 * @return 当前对象
	*/
	public ProcessError setErrorNodeId(String errorNodeId) {
		this.errorNodeId=errorNodeId;
		return this;
	}
	
	/**
	 * 获得 错误消息<br>
	 * 错误消息
	 * @return 错误消息
	*/
	public String getErrorMessage() {
		return errorMessage;
	}
	
	/**
	 * 设置 错误消息
	 * @param errorMessage 错误消息
	 * @return 当前对象
	*/
	public ProcessError setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
		return this;
	}
	
	/**
	 * 获得 错误时间<br>
	 * 错误时间
	 * @return 错误时间
	*/
	public Date getErrorTime() {
		return errorTime;
	}
	
	/**
	 * 设置 错误时间
	 * @param errorTime 错误时间
	 * @return 当前对象
	*/
	public ProcessError setErrorTime(Date errorTime) {
		this.errorTime=errorTime;
		return this;
	}
	
	/**
	 * 获得 原始<br>
	 * incident id
	 * @return 原始
	*/
	public String getCamundaIncidentId() {
		return camundaIncidentId;
	}
	
	/**
	 * 设置 原始
	 * @param camundaIncidentId 原始
	 * @return 当前对象
	*/
	public ProcessError setCamundaIncidentId(String camundaIncidentId) {
		this.camundaIncidentId=camundaIncidentId;
		return this;
	}
	
	/**
	 * 获得 错误类型<br>
	 * 错误类型
	 * @return 错误类型
	*/
	public String getErrorType() {
		return errorType;
	}
	
	/**
	 * 设置 错误类型
	 * @param errorType 错误类型
	 * @return 当前对象
	*/
	public ProcessError setErrorType(String errorType) {
		this.errorType=errorType;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProcessError , 转换好的 ProcessError 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessError , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ProcessError
	 * @param processErrorMap 包含实体信息的 Map 对象
	 * @return ProcessError , 转换好的的 ProcessError 对象
	*/
	@Transient
	public static ProcessError createFrom(Map<String,Object> processErrorMap) {
		if(processErrorMap==null) return null;
		ProcessError po = EntityContext.create(ProcessError.class, processErrorMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessError
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessError , 转换好的的 ProcessError 对象
	*/
	@Transient
	public static ProcessError createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessError po = EntityContext.create(ProcessError.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ProcessError，等同于 new
	 * @return ProcessError 对象
	*/
	@Transient
	public static ProcessError create() {
		return EntityContext.create(ProcessError.class);
	}
}