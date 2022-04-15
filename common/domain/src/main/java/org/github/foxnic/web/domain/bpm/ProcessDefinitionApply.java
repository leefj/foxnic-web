package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_DEFINITION_APPLY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程应用登记
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-04-15 13:49:54
 * @sign 7453F01980B27C953ECB07B683738A1E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_definition_apply")
public class ProcessDefinitionApply extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_DEFINITION_APPLY.$TABLE;
	
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
	private String definitionFileId;
	
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
	public ProcessDefinitionApply setId(String id) {
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
	public ProcessDefinitionApply setDefinitionId(String definitionId) {
		this.definitionId=definitionId;
		return this;
	}
	
	/**
	 * 获得 流程文件ID<br>
	 * 流程文件ID
	 * @return 流程文件ID
	*/
	public String getDefinitionFileId() {
		return definitionFileId;
	}
	
	/**
	 * 设置 流程文件ID
	 * @param definitionFileId 流程文件ID
	 * @return 当前对象
	*/
	public ProcessDefinitionApply setDefinitionFileId(String definitionFileId) {
		this.definitionFileId=definitionFileId;
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
	public ProcessDefinitionApply setRequest(String request) {
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
	public ProcessDefinitionApply setResult(String result) {
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
	public ProcessDefinitionApply setApplyTime(Date applyTime) {
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
	public ProcessDefinitionApply setException(String exception) {
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
	public ProcessDefinitionApply setSuccess(Integer success) {
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
	public ProcessDefinitionApply setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProcessDefinitionApply , 转换好的 ProcessDefinitionApply 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessDefinitionApply , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ProcessDefinitionApply
	 * @param processDefinitionApplyMap 包含实体信息的 Map 对象
	 * @return ProcessDefinitionApply , 转换好的的 ProcessDefinitionApply 对象
	*/
	@Transient
	public static ProcessDefinitionApply createFrom(Map<String,Object> processDefinitionApplyMap) {
		if(processDefinitionApplyMap==null) return null;
		ProcessDefinitionApply po = EntityContext.create(ProcessDefinitionApply.class, processDefinitionApplyMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessDefinitionApply
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessDefinitionApply , 转换好的的 ProcessDefinitionApply 对象
	*/
	@Transient
	public static ProcessDefinitionApply createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessDefinitionApply po = EntityContext.create(ProcessDefinitionApply.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ProcessDefinitionApply，等同于 new
	 * @return ProcessDefinitionApply 对象
	*/
	@Transient
	public static ProcessDefinitionApply create() {
		return EntityContext.create(ProcessDefinitionApply.class);
	}
}