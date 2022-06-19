package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_EVENT_CALLBACK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * bpm_event_callback
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-19 18:51:22
 * @sign 736776BD91F431FD2F43C43C3B5497C4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_event_callback")
public class EventCallback extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_EVENT_CALLBACK.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private String id;
	
	/**
	 * camunda_process_id：camunda_process_id
	*/
	@ApiModelProperty(required = false,value="camunda_process_id" , notes = "camunda_process_id")
	private String camundaProcessId;
	
	/**
	 * event_type：event_type
	*/
	@ApiModelProperty(required = false,value="event_type" , notes = "event_type")
	private String eventType;
	
	/**
	 * camunda_node_id：camunda_node_id
	*/
	@ApiModelProperty(required = false,value="camunda_node_id" , notes = "camunda_node_id")
	private Integer camundaNodeId;
	
	/**
	 * camunda_node_name：camunda_node_name
	*/
	@ApiModelProperty(required = false,value="camunda_node_name" , notes = "camunda_node_name")
	private String camundaNodeName;
	
	/**
	 * error：error
	*/
	@ApiModelProperty(required = false,value="error" , notes = "error")
	private String error;
	
	/**
	 * result：result
	*/
	@ApiModelProperty(required = false,value="result" , notes = "result")
	private String result;
	
	/**
	 * queue_status：queue_status
	*/
	@ApiModelProperty(required = false,value="queue_status" , notes = "queue_status")
	private String queueStatus;
	
	/**
	 * queue_time：queue_time
	*/
	@ApiModelProperty(required = false,value="queue_time" , notes = "queue_time")
	private Timestamp queueTime;
	
	/**
	 * create_time：create_time
	*/
	@ApiModelProperty(required = false,value="create_time" , notes = "create_time")
	private Date createTime;
	
	/**
	 * 失败重试次数：失败重试次数
	*/
	@ApiModelProperty(required = true,value="失败重试次数" , notes = "失败重试次数")
	private Integer queueRetrys;
	
	/**
	 * 获得 id<br>
	 * id
	 * @return id
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 id
	 * @param id id
	 * @return 当前对象
	*/
	public EventCallback setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 camunda_process_id<br>
	 * camunda_process_id
	 * @return camunda_process_id
	*/
	public String getCamundaProcessId() {
		return camundaProcessId;
	}
	
	/**
	 * 设置 camunda_process_id
	 * @param camundaProcessId camunda_process_id
	 * @return 当前对象
	*/
	public EventCallback setCamundaProcessId(String camundaProcessId) {
		this.camundaProcessId=camundaProcessId;
		return this;
	}
	
	/**
	 * 获得 event_type<br>
	 * event_type
	 * @return event_type
	*/
	public String getEventType() {
		return eventType;
	}
	
	/**
	 * 设置 event_type
	 * @param eventType event_type
	 * @return 当前对象
	*/
	public EventCallback setEventType(String eventType) {
		this.eventType=eventType;
		return this;
	}
	
	/**
	 * 获得 camunda_node_id<br>
	 * camunda_node_id
	 * @return camunda_node_id
	*/
	public Integer getCamundaNodeId() {
		return camundaNodeId;
	}
	
	/**
	 * 设置 camunda_node_id
	 * @param camundaNodeId camunda_node_id
	 * @return 当前对象
	*/
	public EventCallback setCamundaNodeId(Integer camundaNodeId) {
		this.camundaNodeId=camundaNodeId;
		return this;
	}
	
	/**
	 * 获得 camunda_node_name<br>
	 * camunda_node_name
	 * @return camunda_node_name
	*/
	public String getCamundaNodeName() {
		return camundaNodeName;
	}
	
	/**
	 * 设置 camunda_node_name
	 * @param camundaNodeName camunda_node_name
	 * @return 当前对象
	*/
	public EventCallback setCamundaNodeName(String camundaNodeName) {
		this.camundaNodeName=camundaNodeName;
		return this;
	}
	
	/**
	 * 获得 error<br>
	 * error
	 * @return error
	*/
	public String getError() {
		return error;
	}
	
	/**
	 * 设置 error
	 * @param error error
	 * @return 当前对象
	*/
	public EventCallback setError(String error) {
		this.error=error;
		return this;
	}
	
	/**
	 * 获得 result<br>
	 * result
	 * @return result
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 设置 result
	 * @param result result
	 * @return 当前对象
	*/
	public EventCallback setResult(String result) {
		this.result=result;
		return this;
	}
	
	/**
	 * 获得 queue_status<br>
	 * queue_status
	 * @return queue_status
	*/
	public String getQueueStatus() {
		return queueStatus;
	}
	
	/**
	 * 设置 queue_status
	 * @param queueStatus queue_status
	 * @return 当前对象
	*/
	public EventCallback setQueueStatus(String queueStatus) {
		this.queueStatus=queueStatus;
		return this;
	}
	
	/**
	 * 获得 queue_time<br>
	 * queue_time
	 * @return queue_time
	*/
	public Timestamp getQueueTime() {
		return queueTime;
	}
	
	/**
	 * 设置 queue_time
	 * @param queueTime queue_time
	 * @return 当前对象
	*/
	public EventCallback setQueueTime(Timestamp queueTime) {
		this.queueTime=queueTime;
		return this;
	}
	
	/**
	 * 获得 create_time<br>
	 * create_time
	 * @return create_time
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 create_time
	 * @param createTime create_time
	 * @return 当前对象
	*/
	public EventCallback setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 失败重试次数<br>
	 * 失败重试次数
	 * @return 失败重试次数
	*/
	public Integer getQueueRetrys() {
		return queueRetrys;
	}
	
	/**
	 * 设置 失败重试次数
	 * @param queueRetrys 失败重试次数
	 * @return 当前对象
	*/
	public EventCallback setQueueRetrys(Integer queueRetrys) {
		this.queueRetrys=queueRetrys;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return EventCallback , 转换好的 EventCallback 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return EventCallback , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 EventCallback
	 * @param eventCallbackMap 包含实体信息的 Map 对象
	 * @return EventCallback , 转换好的的 EventCallback 对象
	*/
	@Transient
	public static EventCallback createFrom(Map<String,Object> eventCallbackMap) {
		if(eventCallbackMap==null) return null;
		EventCallback po = EntityContext.create(EventCallback.class, eventCallbackMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 EventCallback
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return EventCallback , 转换好的的 EventCallback 对象
	*/
	@Transient
	public static EventCallback createFrom(Object pojo) {
		if(pojo==null) return null;
		EventCallback po = EntityContext.create(EventCallback.class,pojo);
		return po;
	}

	/**
	 * 创建一个 EventCallback，等同于 new
	 * @return EventCallback 对象
	*/
	@Transient
	public static EventCallback create() {
		return EntityContext.create(EventCallback.class);
	}
}