package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_USER_STATISTICS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.bpm.meta.UserStatisticsMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 用户流程统计
 * <p>用户流程统计 , 数据表 bpm_user_statistics 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-06 15:12:11
 * @sign 4289C2C07AB7F7E9A502409FDCD63722
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_user_statistics")
@ApiModel(description = "用户流程统计 ; 用户流程统计 , 数据表 bpm_user_statistics 的PO类型")
public class UserStatistics extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_USER_STATISTICS.$TABLE;
	
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
	 * 账户ID：账户ID
	*/
	@ApiModelProperty(required = false,value="账户ID" , notes = "账户ID")
	private String userId;
	
	/**
	 * 使用次数：使用次数
	*/
	@ApiModelProperty(required = true,value="使用次数" , notes = "使用次数")
	private Integer usesNumber;
	
	/**
	 * 最近使用时间：最近使用时间
	*/
	@ApiModelProperty(required = true,value="最近使用时间" , notes = "最近使用时间")
	private Date latestUseTime;
	
	/**
	 * 创建人：创建人
	*/
	@ApiModelProperty(required = false,value="创建人" , notes = "创建人")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 更新人：更新人
	*/
	@ApiModelProperty(required = false,value="更新人" , notes = "更新人")
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
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人：删除人
	*/
	@ApiModelProperty(required = false,value="删除人" , notes = "删除人")
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
	 * tenant_id：tenant_id
	*/
	@ApiModelProperty(required = false,value="tenant_id" , notes = "tenant_id")
	private String tenantId;
	
	/**
	 * 流程类型：流程类型
	*/
	@ApiModelProperty(required = false,value="流程类型" , notes = "流程类型")
	private ProcessDefinition processDefinition;
	
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
	public UserStatistics setId(String id) {
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
	public UserStatistics setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId=processDefinitionId;
		return this;
	}
	
	/**
	 * 获得 账户ID<br>
	 * 账户ID
	 * @return 账户ID
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 账户ID
	 * @param userId 账户ID
	 * @return 当前对象
	*/
	public UserStatistics setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 使用次数<br>
	 * 使用次数
	 * @return 使用次数
	*/
	public Integer getUsesNumber() {
		return usesNumber;
	}
	
	/**
	 * 设置 使用次数
	 * @param usesNumber 使用次数
	 * @return 当前对象
	*/
	public UserStatistics setUsesNumber(Integer usesNumber) {
		this.usesNumber=usesNumber;
		return this;
	}
	
	/**
	 * 获得 最近使用时间<br>
	 * 最近使用时间
	 * @return 最近使用时间
	*/
	public Date getLatestUseTime() {
		return latestUseTime;
	}
	
	/**
	 * 设置 最近使用时间
	 * @param latestUseTime 最近使用时间
	 * @return 当前对象
	*/
	public UserStatistics setLatestUseTime(Date latestUseTime) {
		this.latestUseTime=latestUseTime;
		return this;
	}
	
	/**
	 * 获得 创建人<br>
	 * 创建人
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
	public UserStatistics setCreateBy(String createBy) {
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
	public UserStatistics setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 更新人<br>
	 * 更新人
	 * @return 更新人
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 更新人
	 * @param updateBy 更新人
	 * @return 当前对象
	*/
	public UserStatistics setUpdateBy(String updateBy) {
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
	public UserStatistics setUpdateTime(Date updateTime) {
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
	@JsonProperty("deleted")
	public UserStatistics setDeleted(Integer deleted) {
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
	public UserStatistics setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人<br>
	 * 删除人
	 * @return 删除人
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人
	 * @param deleteBy 删除人
	 * @return 当前对象
	*/
	public UserStatistics setDeleteBy(String deleteBy) {
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
	public UserStatistics setDeleteTime(Date deleteTime) {
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
	public UserStatistics setVersion(Integer version) {
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
	public UserStatistics setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 流程类型<br>
	 * 流程类型
	 * @return 流程类型
	*/
	public ProcessDefinition getProcessDefinition() {
		return processDefinition;
	}
	
	/**
	 * 设置 流程类型
	 * @param processDefinition 流程类型
	 * @return 当前对象
	*/
	public UserStatistics setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition=processDefinition;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return UserStatistics , 转换好的 UserStatistics 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return UserStatistics , 转换好的 PoJo 对象
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
	 * 克隆当前对象
	*/
	@Transient
	public UserStatistics clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public UserStatistics duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.UserStatisticsMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.UserStatisticsMeta.$$proxy$$();
		inst.setProcessDefinitionId(this.getProcessDefinitionId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setLatestUseTime(this.getLatestUseTime());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUsesNumber(this.getUsesNumber());
		inst.setId(this.getId());
		if(all) {
			inst.setProcessDefinition(this.getProcessDefinition());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public UserStatistics clone(boolean deep) {
		return EntityContext.clone(UserStatistics.class,this,deep);
	}

	/**
	 * 将 Map 转换成 UserStatistics
	 * @param userStatisticsMap 包含实体信息的 Map 对象
	 * @return UserStatistics , 转换好的的 UserStatistics 对象
	*/
	@Transient
	public static UserStatistics createFrom(Map<String,Object> userStatisticsMap) {
		if(userStatisticsMap==null) return null;
		UserStatistics po = create();
		EntityContext.copyProperties(po,userStatisticsMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 UserStatistics
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return UserStatistics , 转换好的的 UserStatistics 对象
	*/
	@Transient
	public static UserStatistics createFrom(Object pojo) {
		if(pojo==null) return null;
		UserStatistics po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 UserStatistics，等同于 new
	 * @return UserStatistics 对象
	*/
	@Transient
	public static UserStatistics create() {
		return new org.github.foxnic.web.domain.bpm.meta.UserStatisticsMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setProcessDefinitionId(DataParser.parse(String.class, map.get(UserStatisticsMeta.PROCESS_DEFINITION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(UserStatisticsMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(UserStatisticsMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(UserStatisticsMeta.VERSION)));
			this.setLatestUseTime(DataParser.parse(Date.class, map.get(UserStatisticsMeta.LATEST_USE_TIME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(UserStatisticsMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(UserStatisticsMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(UserStatisticsMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(UserStatisticsMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(UserStatisticsMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(UserStatisticsMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(UserStatisticsMeta.DELETE_BY)));
			this.setUsesNumber(DataParser.parse(Integer.class, map.get(UserStatisticsMeta.USES_NUMBER)));
			this.setId(DataParser.parse(String.class, map.get(UserStatisticsMeta.ID)));
			// others
			this.setProcessDefinition(DataParser.parse(ProcessDefinition.class, map.get(UserStatisticsMeta.PROCESS_DEFINITION)));
			return true;
		} else {
			try {
				this.setProcessDefinitionId( (String)map.get(UserStatisticsMeta.PROCESS_DEFINITION_ID));
				this.setUpdateTime( (Date)map.get(UserStatisticsMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(UserStatisticsMeta.USER_ID));
				this.setVersion( (Integer)map.get(UserStatisticsMeta.VERSION));
				this.setLatestUseTime( (Date)map.get(UserStatisticsMeta.LATEST_USE_TIME));
				this.setCreateBy( (String)map.get(UserStatisticsMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(UserStatisticsMeta.DELETED));
				this.setCreateTime( (Date)map.get(UserStatisticsMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(UserStatisticsMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(UserStatisticsMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(UserStatisticsMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(UserStatisticsMeta.DELETE_BY));
				this.setUsesNumber( (Integer)map.get(UserStatisticsMeta.USES_NUMBER));
				this.setId( (String)map.get(UserStatisticsMeta.ID));
				// others
				this.setProcessDefinition( (ProcessDefinition)map.get(UserStatisticsMeta.PROCESS_DEFINITION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setProcessDefinitionId(DataParser.parse(String.class, r.getValue(UserStatisticsMeta.PROCESS_DEFINITION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(UserStatisticsMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(UserStatisticsMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(UserStatisticsMeta.VERSION)));
			this.setLatestUseTime(DataParser.parse(Date.class, r.getValue(UserStatisticsMeta.LATEST_USE_TIME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(UserStatisticsMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(UserStatisticsMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(UserStatisticsMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(UserStatisticsMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(UserStatisticsMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(UserStatisticsMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(UserStatisticsMeta.DELETE_BY)));
			this.setUsesNumber(DataParser.parse(Integer.class, r.getValue(UserStatisticsMeta.USES_NUMBER)));
			this.setId(DataParser.parse(String.class, r.getValue(UserStatisticsMeta.ID)));
			return true;
		} else {
			try {
				this.setProcessDefinitionId( (String)r.getValue(UserStatisticsMeta.PROCESS_DEFINITION_ID));
				this.setUpdateTime( (Date)r.getValue(UserStatisticsMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(UserStatisticsMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(UserStatisticsMeta.VERSION));
				this.setLatestUseTime( (Date)r.getValue(UserStatisticsMeta.LATEST_USE_TIME));
				this.setCreateBy( (String)r.getValue(UserStatisticsMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(UserStatisticsMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(UserStatisticsMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(UserStatisticsMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(UserStatisticsMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(UserStatisticsMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(UserStatisticsMeta.DELETE_BY));
				this.setUsesNumber( (Integer)r.getValue(UserStatisticsMeta.USES_NUMBER));
				this.setId( (String)r.getValue(UserStatisticsMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}