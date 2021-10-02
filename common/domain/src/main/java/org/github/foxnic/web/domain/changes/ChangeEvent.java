package org.github.foxnic.web.domain.changes;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_CHANGE_EVENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.changes.ApprovalEventType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import org.github.foxnic.web.constants.enums.changes.ApprovalAction;
import java.util.Date;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 变更事件
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-02 20:13:19
 * @sign ED8F1BFCD67A9A6A0F3CEAF96B646A60
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "chs_change_event")
public class ChangeEvent extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CHS_CHANGE_EVENT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 变更ID：变更ID
	*/
	@ApiModelProperty(required = false,value="变更ID" , notes = "变更ID")
	private String instanceId;
	
	/**
	 * 事件类型：事件类型
	*/
	@ApiModelProperty(required = false,value="事件类型" , notes = "事件类型")
	private String eventType;
	@Transient
	private ApprovalEventType eventTypeEnum;
	
	/**
	 * 请求的数据：请求的数据
	*/
	@ApiModelProperty(required = false,value="请求的数据" , notes = "请求的数据")
	private String requestData;
	
	/**
	 * 通知发送时间：通知发送时间
	*/
	@ApiModelProperty(required = false,value="通知发送时间" , notes = "通知发送时间")
	private Timestamp notifyTime;
	
	/**
	 * 数据：通知到消费方的数据，JSON格式
	*/
	@ApiModelProperty(required = false,value="数据" , notes = "通知到消费方的数据，JSON格式")
	private String notifyData;
	
	/**
	 * 响应的数据：响应的数据
	*/
	@ApiModelProperty(required = false,value="响应的数据" , notes = "响应的数据")
	private String responseData;
	
	/**
	 * 回调接收时间：回调接收时间
	*/
	@ApiModelProperty(required = false,value="回调接收时间" , notes = "回调接收时间")
	private Timestamp responseTime;
	
	/**
	 * 审批人账户ID：执行操作的账户ID
	*/
	@ApiModelProperty(required = false,value="审批人账户ID" , notes = "执行操作的账户ID")
	private String approverId;
	
	/**
	 * 审批人姓名：执行操作的人的姓名
	*/
	@ApiModelProperty(required = false,value="审批人姓名" , notes = "执行操作的人的姓名")
	private String approverName;
	
	/**
	 * 审批意见：审批意见
	*/
	@ApiModelProperty(required = false,value="审批意见" , notes = "审批意见")
	private String opinion;
	
	/**
	 * 审批动作：审批动作
	*/
	@ApiModelProperty(required = false,value="审批动作" , notes = "审批动作")
	private String approveAction;
	@Transient
	private ApprovalAction approveActionEnum;
	
	/**
	 * 下一个审批节点审批人账户ID：用逗号隔开
	*/
	@ApiModelProperty(required = false,value="下一个审批节点审批人账户ID" , notes = "用逗号隔开")
	private String simpleNextApproverIds;
	
	/**
	 * 下一个审批节点审批人姓名：用逗号隔开
	*/
	@ApiModelProperty(required = false,value="下一个审批节点审批人姓名" , notes = "用逗号隔开")
	private String simpleNextApproverNames;
	
	/**
	 * 是否成功：失败时查看 response_data
	*/
	@ApiModelProperty(required = false,value="是否成功" , notes = "失败时查看 response_data")
	private Integer success;
	
	/**
	 * 错误信息：错误信息
	*/
	@ApiModelProperty(required = false,value="错误信息" , notes = "错误信息")
	private String errors;
	
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
	 * 简单模式的节点ID：简单模式的节点ID
	*/
	@ApiModelProperty(required = false,value="简单模式的节点ID" , notes = "简单模式的节点ID")
	private String simpleNodeId;
	
	/**
	 * 变更定义
	*/
	@ApiModelProperty(required = false,value="变更定义" , notes = "")
	private ChangeDefinition definition;
	
	/**
	 * 变更实例
	*/
	@ApiModelProperty(required = false,value="变更实例" , notes = "")
	private ChangeInstance instance;
	
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
	public ChangeEvent setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 变更ID<br>
	 * 变更ID
	 * @return 变更ID
	*/
	public String getInstanceId() {
		return instanceId;
	}
	
	/**
	 * 设置 变更ID
	 * @param instanceId 变更ID
	 * @return 当前对象
	*/
	public ChangeEvent setInstanceId(String instanceId) {
		this.instanceId=instanceId;
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
	public ApprovalEventType getEventTypeEnum() {
		if(this.eventTypeEnum==null) {
			this.eventTypeEnum = (ApprovalEventType) EnumUtil.parseByCode(ApprovalEventType.values(),eventType);
		}
		return this.eventTypeEnum ;
	}
	
	/**
	 * 设置 事件类型
	 * @param eventType 事件类型
	 * @return 当前对象
	*/
	public ChangeEvent setEventType(String eventType) {
		this.eventType=eventType;
		this.eventTypeEnum= (ApprovalEventType) EnumUtil.parseByCode(ApprovalEventType.values(),eventType) ;
		if(StringUtil.hasContent(eventType) && this.eventTypeEnum==null) {
			throw new IllegalArgumentException( eventType + " is not one of ApprovalEventType");
		}
		return this;
	}
	
	/**
	 * 设置 事件类型的投影属性，等同于设置 事件类型
	 * @param eventTypeEnum 事件类型
	 * @return 当前对象
	*/
	@Transient
	public ChangeEvent setEventTypeEnum(ApprovalEventType eventTypeEnum) {
		if(eventTypeEnum==null) {
			this.setEventType(null);
		} else {
			this.setEventType(eventTypeEnum.code());
		}
		this.eventTypeEnum=eventTypeEnum;
		return this;
	}
	
	/**
	 * 获得 请求的数据<br>
	 * 请求的数据
	 * @return 请求的数据
	*/
	public String getRequestData() {
		return requestData;
	}
	
	/**
	 * 设置 请求的数据
	 * @param requestData 请求的数据
	 * @return 当前对象
	*/
	public ChangeEvent setRequestData(String requestData) {
		this.requestData=requestData;
		return this;
	}
	
	/**
	 * 获得 通知发送时间<br>
	 * 通知发送时间
	 * @return 通知发送时间
	*/
	public Timestamp getNotifyTime() {
		return notifyTime;
	}
	
	/**
	 * 设置 通知发送时间
	 * @param notifyTime 通知发送时间
	 * @return 当前对象
	*/
	public ChangeEvent setNotifyTime(Timestamp notifyTime) {
		this.notifyTime=notifyTime;
		return this;
	}
	
	/**
	 * 获得 数据<br>
	 * 通知到消费方的数据，JSON格式
	 * @return 数据
	*/
	public String getNotifyData() {
		return notifyData;
	}
	
	/**
	 * 设置 数据
	 * @param notifyData 数据
	 * @return 当前对象
	*/
	public ChangeEvent setNotifyData(String notifyData) {
		this.notifyData=notifyData;
		return this;
	}
	
	/**
	 * 获得 响应的数据<br>
	 * 响应的数据
	 * @return 响应的数据
	*/
	public String getResponseData() {
		return responseData;
	}
	
	/**
	 * 设置 响应的数据
	 * @param responseData 响应的数据
	 * @return 当前对象
	*/
	public ChangeEvent setResponseData(String responseData) {
		this.responseData=responseData;
		return this;
	}
	
	/**
	 * 获得 回调接收时间<br>
	 * 回调接收时间
	 * @return 回调接收时间
	*/
	public Timestamp getResponseTime() {
		return responseTime;
	}
	
	/**
	 * 设置 回调接收时间
	 * @param responseTime 回调接收时间
	 * @return 当前对象
	*/
	public ChangeEvent setResponseTime(Timestamp responseTime) {
		this.responseTime=responseTime;
		return this;
	}
	
	/**
	 * 获得 审批人账户ID<br>
	 * 执行操作的账户ID
	 * @return 审批人账户ID
	*/
	public String getApproverId() {
		return approverId;
	}
	
	/**
	 * 设置 审批人账户ID
	 * @param approverId 审批人账户ID
	 * @return 当前对象
	*/
	public ChangeEvent setApproverId(String approverId) {
		this.approverId=approverId;
		return this;
	}
	
	/**
	 * 获得 审批人姓名<br>
	 * 执行操作的人的姓名
	 * @return 审批人姓名
	*/
	public String getApproverName() {
		return approverName;
	}
	
	/**
	 * 设置 审批人姓名
	 * @param approverName 审批人姓名
	 * @return 当前对象
	*/
	public ChangeEvent setApproverName(String approverName) {
		this.approverName=approverName;
		return this;
	}
	
	/**
	 * 获得 审批意见<br>
	 * 审批意见
	 * @return 审批意见
	*/
	public String getOpinion() {
		return opinion;
	}
	
	/**
	 * 设置 审批意见
	 * @param opinion 审批意见
	 * @return 当前对象
	*/
	public ChangeEvent setOpinion(String opinion) {
		this.opinion=opinion;
		return this;
	}
	
	/**
	 * 获得 审批动作<br>
	 * 审批动作
	 * @return 审批动作
	*/
	public String getApproveAction() {
		return approveAction;
	}
	
	/**
	 * 获得 审批动作 的投影属性<br>
	 * 等价于 getApproveAction 方法，获得对应的枚举类型
	 * @return 审批动作
	*/
	@Transient
	public ApprovalAction getApproveActionEnum() {
		if(this.approveActionEnum==null) {
			this.approveActionEnum = (ApprovalAction) EnumUtil.parseByCode(ApprovalAction.values(),approveAction);
		}
		return this.approveActionEnum ;
	}
	
	/**
	 * 设置 审批动作
	 * @param approveAction 审批动作
	 * @return 当前对象
	*/
	public ChangeEvent setApproveAction(String approveAction) {
		this.approveAction=approveAction;
		this.approveActionEnum= (ApprovalAction) EnumUtil.parseByCode(ApprovalAction.values(),approveAction) ;
		if(StringUtil.hasContent(approveAction) && this.approveActionEnum==null) {
			throw new IllegalArgumentException( approveAction + " is not one of ApprovalAction");
		}
		return this;
	}
	
	/**
	 * 设置 审批动作的投影属性，等同于设置 审批动作
	 * @param approveActionEnum 审批动作
	 * @return 当前对象
	*/
	@Transient
	public ChangeEvent setApproveActionEnum(ApprovalAction approveActionEnum) {
		if(approveActionEnum==null) {
			this.setApproveAction(null);
		} else {
			this.setApproveAction(approveActionEnum.code());
		}
		this.approveActionEnum=approveActionEnum;
		return this;
	}
	
	/**
	 * 获得 下一个审批节点审批人账户ID<br>
	 * 用逗号隔开
	 * @return 下一个审批节点审批人账户ID
	*/
	public String getSimpleNextApproverIds() {
		return simpleNextApproverIds;
	}
	
	/**
	 * 设置 下一个审批节点审批人账户ID
	 * @param simpleNextApproverIds 下一个审批节点审批人账户ID
	 * @return 当前对象
	*/
	public ChangeEvent setSimpleNextApproverIds(String simpleNextApproverIds) {
		this.simpleNextApproverIds=simpleNextApproverIds;
		return this;
	}
	
	/**
	 * 获得 下一个审批节点审批人姓名<br>
	 * 用逗号隔开
	 * @return 下一个审批节点审批人姓名
	*/
	public String getSimpleNextApproverNames() {
		return simpleNextApproverNames;
	}
	
	/**
	 * 设置 下一个审批节点审批人姓名
	 * @param simpleNextApproverNames 下一个审批节点审批人姓名
	 * @return 当前对象
	*/
	public ChangeEvent setSimpleNextApproverNames(String simpleNextApproverNames) {
		this.simpleNextApproverNames=simpleNextApproverNames;
		return this;
	}
	
	/**
	 * 获得 是否成功<br>
	 * 失败时查看 response_data
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
	public ChangeEvent setSuccess(Integer success) {
		this.success=success;
		return this;
	}
	
	/**
	 * 获得 错误信息<br>
	 * 错误信息
	 * @return 错误信息
	*/
	public String getErrors() {
		return errors;
	}
	
	/**
	 * 设置 错误信息
	 * @param errors 错误信息
	 * @return 当前对象
	*/
	public ChangeEvent setErrors(String errors) {
		this.errors=errors;
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
	public ChangeEvent setCreateBy(String createBy) {
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
	public ChangeEvent setCreateTime(Date createTime) {
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
	public ChangeEvent setUpdateBy(String updateBy) {
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
	public ChangeEvent setUpdateTime(Date updateTime) {
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
	public ChangeEvent setDeleted(Integer deleted) {
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
	public ChangeEvent setDeleteBy(String deleteBy) {
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
	public ChangeEvent setDeleteTime(Date deleteTime) {
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
	public ChangeEvent setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 简单模式的节点ID<br>
	 * 简单模式的节点ID
	 * @return 简单模式的节点ID
	*/
	public String getSimpleNodeId() {
		return simpleNodeId;
	}
	
	/**
	 * 设置 简单模式的节点ID
	 * @param simpleNodeId 简单模式的节点ID
	 * @return 当前对象
	*/
	public ChangeEvent setSimpleNodeId(String simpleNodeId) {
		this.simpleNodeId=simpleNodeId;
		return this;
	}
	
	/**
	 * 获得 变更定义<br>
	 * @return 变更定义
	*/
	public ChangeDefinition getDefinition() {
		return definition;
	}
	
	/**
	 * 设置 变更定义
	 * @param definition 变更定义
	 * @return 当前对象
	*/
	public ChangeEvent setDefinition(ChangeDefinition definition) {
		this.definition=definition;
		return this;
	}
	
	/**
	 * 获得 变更实例<br>
	 * @return 变更实例
	*/
	public ChangeInstance getInstance() {
		return instance;
	}
	
	/**
	 * 设置 变更实例
	 * @param instance 变更实例
	 * @return 当前对象
	*/
	public ChangeEvent setInstance(ChangeInstance instance) {
		this.instance=instance;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ChangeEvent , 转换好的 ChangeEvent 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ChangeEvent , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ChangeEvent
	 * @param changeEventMap 包含实体信息的 Map 对象
	 * @return ChangeEvent , 转换好的的 ChangeEvent 对象
	*/
	@Transient
	public static ChangeEvent createFrom(Map<String,Object> changeEventMap) {
		if(changeEventMap==null) return null;
		ChangeEvent po = EntityContext.create(ChangeEvent.class, changeEventMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ChangeEvent
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ChangeEvent , 转换好的的 ChangeEvent 对象
	*/
	@Transient
	public static ChangeEvent createFrom(Object pojo) {
		if(pojo==null) return null;
		ChangeEvent po = EntityContext.create(ChangeEvent.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ChangeEvent，等同于 new
	 * @return ChangeEvent 对象
	*/
	@Transient
	public static ChangeEvent create() {
		return EntityContext.create(ChangeEvent.class);
	}
}