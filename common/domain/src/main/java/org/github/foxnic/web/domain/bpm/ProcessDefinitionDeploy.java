package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_DEFINITION_DEPLOY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程应用登记
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-04-18 16:17:24
 * @sign 0010501718CBB14DAE6725EB400AA40D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_definition_deploy")
public class ProcessDefinitionDeploy extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_DEFINITION_DEPLOY.$TABLE;
	
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
	private String definitionId;
	
	/**
	 * 流程文件ID：流程文件ID
	*/
	@ApiModelProperty(required = false,value="流程文件ID" , notes = "流程文件ID")
	private String fileId;
	
	/**
	 * 应用请求报文：应用请求报文
	*/
	@ApiModelProperty(required = false,value="应用请求报文" , notes = "应用请求报文")
	private String request;
	
	/**
	 * 应用结果：应用结果
	*/
	@ApiModelProperty(required = false,value="应用结果" , notes = "应用结果")
	private String result;
	
	/**
	 * 应用时间：应用时间
	*/
	@ApiModelProperty(required = false,value="应用时间" , notes = "应用时间")
	private Date applyTime;
	
	/**
	 * 异常信息：异常信息
	*/
	@ApiModelProperty(required = false,value="异常信息" , notes = "异常信息")
	private String exception;
	
	/**
	 * 是否成功：是否成功
	*/
	@ApiModelProperty(required = false,value="是否成功" , notes = "是否成功")
	private Integer success;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = true,value="租户ID" , notes = "租户ID")
	private String tenantId;
	
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
	public ProcessDefinitionDeploy setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 流程定义ID<br>
	 * 流程定义ID
	 * @return 流程定义ID
	*/
	public String getDefinitionId() {
		return definitionId;
	}
	
	/**
	 * 设置 流程定义ID
	 * @param definitionId 流程定义ID
	 * @return 当前对象
	*/
	public ProcessDefinitionDeploy setDefinitionId(String definitionId) {
		this.definitionId=definitionId;
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
	public ProcessDefinitionDeploy setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 应用请求报文<br>
	 * 应用请求报文
	 * @return 应用请求报文
	*/
	public String getRequest() {
		return request;
	}
	
	/**
	 * 设置 应用请求报文
	 * @param request 应用请求报文
	 * @return 当前对象
	*/
	public ProcessDefinitionDeploy setRequest(String request) {
		this.request=request;
		return this;
	}
	
	/**
	 * 获得 应用结果<br>
	 * 应用结果
	 * @return 应用结果
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 设置 应用结果
	 * @param result 应用结果
	 * @return 当前对象
	*/
	public ProcessDefinitionDeploy setResult(String result) {
		this.result=result;
		return this;
	}
	
	/**
	 * 获得 应用时间<br>
	 * 应用时间
	 * @return 应用时间
	*/
	public Date getApplyTime() {
		return applyTime;
	}
	
	/**
	 * 设置 应用时间
	 * @param applyTime 应用时间
	 * @return 当前对象
	*/
	public ProcessDefinitionDeploy setApplyTime(Date applyTime) {
		this.applyTime=applyTime;
		return this;
	}
	
	/**
	 * 获得 异常信息<br>
	 * 异常信息
	 * @return 异常信息
	*/
	public String getException() {
		return exception;
	}
	
	/**
	 * 设置 异常信息
	 * @param exception 异常信息
	 * @return 当前对象
	*/
	public ProcessDefinitionDeploy setException(String exception) {
		this.exception=exception;
		return this;
	}
	
	/**
	 * 获得 是否成功<br>
	 * 是否成功
	 * @return 是否成功
	*/
	public Integer getSuccess() {
		return success;
	}
	
	/**
	 * 设置 是否成功
	 * @param success 是否成功
	 * @return 当前对象
	*/
	public ProcessDefinitionDeploy setSuccess(Integer success) {
		this.success=success;
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
	public ProcessDefinitionDeploy setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProcessDefinitionDeploy , 转换好的 ProcessDefinitionDeploy 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessDefinitionDeploy , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ProcessDefinitionDeploy
	 * @param processDefinitionDeployMap 包含实体信息的 Map 对象
	 * @return ProcessDefinitionDeploy , 转换好的的 ProcessDefinitionDeploy 对象
	*/
	@Transient
	public static ProcessDefinitionDeploy createFrom(Map<String,Object> processDefinitionDeployMap) {
		if(processDefinitionDeployMap==null) return null;
		ProcessDefinitionDeploy po = EntityContext.create(ProcessDefinitionDeploy.class, processDefinitionDeployMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessDefinitionDeploy
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessDefinitionDeploy , 转换好的的 ProcessDefinitionDeploy 对象
	*/
	@Transient
	public static ProcessDefinitionDeploy createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessDefinitionDeploy po = EntityContext.create(ProcessDefinitionDeploy.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ProcessDefinitionDeploy，等同于 new
	 * @return ProcessDefinitionDeploy 对象
	*/
	@Transient
	public static ProcessDefinitionDeploy create() {
		return EntityContext.create(ProcessDefinitionDeploy.class);
	}
}