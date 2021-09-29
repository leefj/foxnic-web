package org.github.foxnic.web.domain.changes;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_CHANGE_EVENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.changes.ChangeEventType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.Date;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * chs_change_event
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-29 16:28:18
 * @sign 63A7F26E7A9AF55CEA3C1409036EB185
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
	 * 实体类名：实体类名
	*/
	@ApiModelProperty(required = false,value="实体类名" , notes = "实体类名")
	private String eventType;
	@Transient
	private ChangeEventType eventTypeEnum;
	
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
	 * 相应的数据：相应的数据
	*/
	@ApiModelProperty(required = false,value="相应的数据" , notes = "相应的数据")
	private String responseData;
	
	/**
	 * 回调接收时间：回调接收时间
	*/
	@ApiModelProperty(required = false,value="回调接收时间" , notes = "回调接收时间")
	private Timestamp responseTime;
	
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
	 * 获得 实体类名<br>
	 * 实体类名
	 * @return 实体类名
	*/
	public String getEventType() {
		return eventType;
	}
	
	/**
	 * 获得 实体类名 的投影属性<br>
	 * 等价于 getEventType 方法，获得对应的枚举类型
	 * @return 实体类名
	*/
	@Transient
	public ChangeEventType getEventTypeEnum() {
		return eventTypeEnum ;
	}
	
	/**
	 * 设置 实体类名
	 * @param eventType 实体类名
	 * @return 当前对象
	*/
	public ChangeEvent setEventType(String eventType) {
		this.eventType=eventType;
		this.eventTypeEnum= (ChangeEventType) EnumUtil.parseByCode(ChangeEventType.values(),eventType) ;
		if(StringUtil.hasContent(eventType) && this.eventTypeEnum==null) {
			throw new IllegalArgumentException( eventType + " is not one of ChangeEventType");
		}
		return this;
	}
	
	/**
	 * 设置 实体类名的投影属性，等同于设置 实体类名
	 * @param eventTypeEnum 实体类名
	 * @return 当前对象
	*/
	@Transient
	public ChangeEvent setEventTypeEnum(ChangeEventType eventTypeEnum) {
		if(eventTypeEnum==null) {
			this.eventType=null;
		} else {
			this.eventType=eventTypeEnum.code();
		}
		this.eventTypeEnum=eventTypeEnum;
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
	 * 获得 相应的数据<br>
	 * 相应的数据
	 * @return 相应的数据
	*/
	public String getResponseData() {
		return responseData;
	}
	
	/**
	 * 设置 相应的数据
	 * @param responseData 相应的数据
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