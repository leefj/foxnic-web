package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_TASK_READ;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程任务已阅
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-11 13:30:21
 * @sign EC3FDB9324210215D94E5EDC3E9B402B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_task_read")
public class TaskRead extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_TASK_READ.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private String id;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID")
	private String processInstanceId;
	
	/**
	 * 任务ID：任务ID
	*/
	@ApiModelProperty(required = false,value="任务ID" , notes = "任务ID")
	private String taskId;
	
	/**
	 * 确认时间：已阅确认时间
	*/
	@ApiModelProperty(required = false,value="确认时间" , notes = "已阅确认时间")
	private Date confirmTime;
	
	/**
	 * 评论：评论
	*/
	@ApiModelProperty(required = false,value="评论" , notes = "评论")
	private String comment;
	
	/**
	 * 阅读状态：阅读状态
	*/
	@ApiModelProperty(required = false,value="阅读状态" , notes = "阅读状态")
	private String status;
	
	/**
	 * 创建人：阅读人
	*/
	@ApiModelProperty(required = false,value="创建人" , notes = "阅读人")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * tenant_id：tenant_id
	*/
	@ApiModelProperty(required = false,value="tenant_id" , notes = "tenant_id")
	private String tenantId;
	
	/**
	 * 持续阅读时间：持续阅读时间
	*/
	@ApiModelProperty(required = false,value="持续阅读时间" , notes = "持续阅读时间")
	private Date latestTime;
	
	/**
	 * 阅读人：阅读人
	*/
	@ApiModelProperty(required = false,value="阅读人" , notes = "阅读人")
	private User reader;
	
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
	public TaskRead setId(String id) {
		this.id=id;
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
	public TaskRead setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 任务ID<br>
	 * 任务ID
	 * @return 任务ID
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 任务ID
	 * @param taskId 任务ID
	 * @return 当前对象
	*/
	public TaskRead setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}
	
	/**
	 * 获得 确认时间<br>
	 * 已阅确认时间
	 * @return 确认时间
	*/
	public Date getConfirmTime() {
		return confirmTime;
	}
	
	/**
	 * 设置 确认时间
	 * @param confirmTime 确认时间
	 * @return 当前对象
	*/
	public TaskRead setConfirmTime(Date confirmTime) {
		this.confirmTime=confirmTime;
		return this;
	}
	
	/**
	 * 获得 评论<br>
	 * 评论
	 * @return 评论
	*/
	public String getComment() {
		return comment;
	}
	
	/**
	 * 设置 评论
	 * @param comment 评论
	 * @return 当前对象
	*/
	public TaskRead setComment(String comment) {
		this.comment=comment;
		return this;
	}
	
	/**
	 * 获得 阅读状态<br>
	 * 阅读状态
	 * @return 阅读状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 阅读状态
	 * @param status 阅读状态
	 * @return 当前对象
	*/
	public TaskRead setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 创建人<br>
	 * 阅读人
	 * @return 创建人
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人
	 * @param createBy 创建人
	 * @return 当前对象
	*/
	public TaskRead setCreateBy(String createBy) {
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
	public TaskRead setCreateTime(Date createTime) {
		this.createTime=createTime;
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
	public TaskRead setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 tenant_id<br>
	 * tenant_id
	 * @return tenant_id
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 tenant_id
	 * @param tenantId tenant_id
	 * @return 当前对象
	*/
	public TaskRead setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 持续阅读时间<br>
	 * 持续阅读时间
	 * @return 持续阅读时间
	*/
	public Date getLatestTime() {
		return latestTime;
	}
	
	/**
	 * 设置 持续阅读时间
	 * @param latestTime 持续阅读时间
	 * @return 当前对象
	*/
	public TaskRead setLatestTime(Date latestTime) {
		this.latestTime=latestTime;
		return this;
	}
	
	/**
	 * 获得 阅读人<br>
	 * 阅读人
	 * @return 阅读人
	*/
	public User getReader() {
		return reader;
	}
	
	/**
	 * 设置 阅读人
	 * @param reader 阅读人
	 * @return 当前对象
	*/
	public TaskRead setReader(User reader) {
		this.reader=reader;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return TaskRead , 转换好的 TaskRead 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TaskRead , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 TaskRead
	 * @param taskReadMap 包含实体信息的 Map 对象
	 * @return TaskRead , 转换好的的 TaskRead 对象
	*/
	@Transient
	public static TaskRead createFrom(Map<String,Object> taskReadMap) {
		if(taskReadMap==null) return null;
		TaskRead po = EntityContext.create(TaskRead.class, taskReadMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 TaskRead
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TaskRead , 转换好的的 TaskRead 对象
	*/
	@Transient
	public static TaskRead createFrom(Object pojo) {
		if(pojo==null) return null;
		TaskRead po = EntityContext.create(TaskRead.class,pojo);
		return po;
	}

	/**
	 * 创建一个 TaskRead，等同于 new
	 * @return TaskRead 对象
	*/
	@Transient
	public static TaskRead create() {
		return EntityContext.create(TaskRead.class);
	}
}