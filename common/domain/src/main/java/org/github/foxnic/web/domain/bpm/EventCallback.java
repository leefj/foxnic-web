package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.bpm.BpmEventType;
import javax.persistence.Transient;
import com.github.foxnic.api.queue.QueueStatus;
import java.sql.Timestamp;
import java.util.Date;
import org.github.foxnic.web.constants.enums.bpm.CamundaNodeType;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * bpm_event_callback
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-20 15:57:40
 * @sign 87F9D4611C01BF53624A98CBF11E2C1B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "act_ru_event_callback")
public class EventCallback extends Entity {

	private static final long serialVersionUID = 1L;


	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;

	/**
	 * BPM流程ID：BPM流程ID
	*/
	@ApiModelProperty(required = false,value="BPM流程ID" , notes = "BPM流程ID")
	private String bpmProcessInstanceId;

	/**
	 * 变量：变量
	*/
	@ApiModelProperty(required = false,value="变量" , notes = "变量")
	private String variables;

	/**
	 * camunda流程ID：camunda流程ID
	*/
	@ApiModelProperty(required = false,value="camunda流程ID" , notes = "camunda流程ID")
	private String camundaProcessInstanceId;

	/**
	 * 事件类型：事件类型
	*/
	@ApiModelProperty(required = false,value="事件类型" , notes = "事件类型")
	private String eventType;
	@Transient
	private BpmEventType eventTypeEnum;

	/**
	 * 节点ID：节点ID
	*/
	@ApiModelProperty(required = false,value="节点ID" , notes = "节点ID")
	private String nodeId;

	/**
	 * 节点名称：节点名称
	*/
	@ApiModelProperty(required = false,value="节点名称" , notes = "节点名称")
	private String nodeName;

	/**
	 * 异常信息：异常信息
	*/
	@ApiModelProperty(required = false,value="异常信息" , notes = "异常信息")
	private String error;

	/**
	 * 处理结果：处理结果
	*/
	@ApiModelProperty(required = false,value="处理结果" , notes = "处理结果")
	private String result;

	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	@Transient
	private QueueStatus statusEnum;

	@ApiModelProperty(required = false,value="队列ID" , notes = "队列ID")
	private String queueId;

	/**
	 * 调用时间：调用时间
	*/
	@ApiModelProperty(required = false,value="调用时间" , notes = "调用时间")
	private Timestamp invokeTime;

	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;

	/**
	 * 失败重试次数：失败重试次数
	*/
	@ApiModelProperty(required = true,value="失败重试次数" , notes = "失败重试次数")
	private Integer retrys;

	/**
	 * 节点类型：节点类型
	*/
	@ApiModelProperty(required = false,value="节点类型" , notes = "节点类型")
	private String nodeType;
	@Transient
	private CamundaNodeType nodeTypeEnum;


	public String getQueueId() {
		return queueId;
	}

	public void setQueueId(String queueId) {
		this.queueId = queueId;
	}

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
	public EventCallback setId(String id) {
		this.id=id;
		return this;
	}

	/**
	 * 获得 BPM流程ID<br>
	 * BPM流程ID
	 * @return BPM流程ID
	*/
	public String getBpmProcessInstanceId() {
		return bpmProcessInstanceId;
	}

	/**
	 * 设置 BPM流程ID
	 * @param bpmProcessInstanceId BPM流程ID
	 * @return 当前对象
	*/
	public EventCallback setBpmProcessInstanceId(String bpmProcessInstanceId) {
		this.bpmProcessInstanceId=bpmProcessInstanceId;
		return this;
	}

	/**
	 * 获得 变量<br>
	 * 变量
	 * @return 变量
	*/
	public String getVariables() {
		return variables;
	}

	/**
	 * 设置 变量
	 * @param variables 变量
	 * @return 当前对象
	*/
	public EventCallback setVariables(String variables) {
		this.variables=variables;
		return this;
	}

	/**
	 * 获得 camunda流程ID<br>
	 * camunda流程ID
	 * @return camunda流程ID
	*/
	public String getCamundaProcessInstanceId() {
		return camundaProcessInstanceId;
	}

	/**
	 * 设置 camunda流程ID
	 * @param camundaProcessInstanceId camunda流程ID
	 * @return 当前对象
	*/
	public EventCallback setCamundaProcessInstanceId(String camundaProcessInstanceId) {
		this.camundaProcessInstanceId=camundaProcessInstanceId;
		return this;
	}

	/**
	 * 获得 事件类型<br>
	 * 事件类型
	 * @return 事件类型
	*/
	public String getEventType() {
		return eventType;
	}

	/**
	 * 获得 事件类型 的投影属性<br>
	 * 等价于 getEventType 方法，获得对应的枚举类型
	 * @return 事件类型
	*/
	@Transient
	public BpmEventType getEventTypeEnum() {
		if(this.eventTypeEnum==null) {
			this.eventTypeEnum = (BpmEventType) EnumUtil.parseByCode(BpmEventType.values(),eventType);
		}
		return this.eventTypeEnum ;
	}

	/**
	 * 设置 事件类型
	 * @param eventType 事件类型
	 * @return 当前对象
	*/
	public EventCallback setEventType(String eventType) {
		this.eventType=eventType;
		this.eventTypeEnum= (BpmEventType) EnumUtil.parseByCode(BpmEventType.values(),eventType) ;
		if(StringUtil.hasContent(eventType) && this.eventTypeEnum==null) {
			throw new IllegalArgumentException( eventType + " is not one of BpmEventType");
		}
		return this;
	}

	/**
	 * 设置 事件类型的投影属性，等同于设置 事件类型
	 * @param eventTypeEnum 事件类型
	 * @return 当前对象
	*/
	@Transient
	public EventCallback setEventTypeEnum(BpmEventType eventTypeEnum) {
		if(eventTypeEnum==null) {
			this.setEventType(null);
		} else {
			this.setEventType(eventTypeEnum.code());
		}
		this.eventTypeEnum=eventTypeEnum;
		return this;
	}

	/**
	 * 获得 节点ID<br>
	 * 节点ID
	 * @return 节点ID
	*/
	public String getNodeId() {
		return nodeId;
	}

	/**
	 * 设置 节点ID
	 * @param nodeId 节点ID
	 * @return 当前对象
	*/
	public EventCallback setNodeId(String nodeId) {
		this.nodeId=nodeId;
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
	public EventCallback setNodeName(String nodeName) {
		this.nodeName=nodeName;
		return this;
	}

	/**
	 * 获得 异常信息<br>
	 * 异常信息
	 * @return 异常信息
	*/
	public String getError() {
		return error;
	}

	/**
	 * 设置 异常信息
	 * @param error 异常信息
	 * @return 当前对象
	*/
	public EventCallback setError(String error) {
		this.error=error;
		return this;
	}

	/**
	 * 获得 处理结果<br>
	 * 处理结果
	 * @return 处理结果
	*/
	public String getResult() {
		return result;
	}

	/**
	 * 设置 处理结果
	 * @param result 处理结果
	 * @return 当前对象
	*/
	public EventCallback setResult(String result) {
		this.result=result;
		return this;
	}

	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}

	/**
	 * 获得 状态 的投影属性<br>
	 * 等价于 getStatus 方法，获得对应的枚举类型
	 * @return 状态
	*/
	@Transient
	public QueueStatus getStatusEnum() {
		if(this.statusEnum==null) {
			this.statusEnum = (QueueStatus) EnumUtil.parseByCode(QueueStatus.values(),status);
		}
		return this.statusEnum ;
	}

	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public EventCallback setStatus(String status) {
		this.status=status;
		this.statusEnum= (QueueStatus) EnumUtil.parseByCode(QueueStatus.values(),status) ;
		if(StringUtil.hasContent(status) && this.statusEnum==null) {
			throw new IllegalArgumentException( status + " is not one of QueueStatus");
		}
		return this;
	}

	/**
	 * 设置 状态的投影属性，等同于设置 状态
	 * @param statusEnum 状态
	 * @return 当前对象
	*/
	@Transient
	public EventCallback setStatusEnum(QueueStatus statusEnum) {
		if(statusEnum==null) {
			this.setStatus(null);
		} else {
			this.setStatus(statusEnum.code());
		}
		this.statusEnum=statusEnum;
		return this;
	}

	/**
	 * 获得 调用时间<br>
	 * 调用时间
	 * @return 调用时间
	*/
	public Timestamp getInvokeTime() {
		return invokeTime;
	}

	/**
	 * 设置 调用时间
	 * @param invokeTime 调用时间
	 * @return 当前对象
	*/
	public EventCallback setInvokeTime(Timestamp invokeTime) {
		this.invokeTime=invokeTime;
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
	public EventCallback setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}

	/**
	 * 获得 失败重试次数<br>
	 * 失败重试次数
	 * @return 失败重试次数
	*/
	public Integer getRetrys() {
		return retrys;
	}

	/**
	 * 设置 失败重试次数
	 * @param retrys 失败重试次数
	 * @return 当前对象
	*/
	public EventCallback setRetrys(Integer retrys) {
		this.retrys=retrys;
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
	public EventCallback setNodeType(String nodeType) {
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
	public EventCallback setNodeTypeEnum(CamundaNodeType nodeTypeEnum) {
		if(nodeTypeEnum==null) {
			this.setNodeType(null);
		} else {
			this.setNodeType(nodeTypeEnum.code());
		}
		this.nodeTypeEnum=nodeTypeEnum;
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
