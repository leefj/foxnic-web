package org.github.foxnic.web.domain.changes;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_CHANGE_DATA;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * chs_change_data
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-27 16:04:55
 * @sign 2D48FD94F0B616A99819B24974E5102C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "chs_change_data")
public class ChangeData extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CHS_CHANGE_DATA.$TABLE;
	
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
	private String dataType;
	
	/**
	 * 变更时间点：0，变更前；1，变更后
	*/
	@ApiModelProperty(required = false,value="变更时间点" , notes = "0，变更前；1，变更后")
	private Integer timePoint;
	
	/**
	 * 数据：JSON格式
	*/
	@ApiModelProperty(required = false,value="数据" , notes = "JSON格式")
	private String data;
	
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
	public ChangeData setId(String id) {
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
	public ChangeData setInstanceId(String instanceId) {
		this.instanceId=instanceId;
		return this;
	}
	
	/**
	 * 获得 实体类名<br>
	 * 实体类名
	 * @return 实体类名
	*/
	public String getDataType() {
		return dataType;
	}
	
	/**
	 * 设置 实体类名
	 * @param dataType 实体类名
	 * @return 当前对象
	*/
	public ChangeData setDataType(String dataType) {
		this.dataType=dataType;
		return this;
	}
	
	/**
	 * 获得 变更时间点<br>
	 * 0，变更前；1，变更后
	 * @return 变更时间点
	*/
	public Integer getTimePoint() {
		return timePoint;
	}
	
	/**
	 * 设置 变更时间点
	 * @param timePoint 变更时间点
	 * @return 当前对象
	*/
	public ChangeData setTimePoint(Integer timePoint) {
		this.timePoint=timePoint;
		return this;
	}
	
	/**
	 * 获得 数据<br>
	 * JSON格式
	 * @return 数据
	*/
	public String getData() {
		return data;
	}
	
	/**
	 * 设置 数据
	 * @param data 数据
	 * @return 当前对象
	*/
	public ChangeData setData(String data) {
		this.data=data;
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
	public ChangeData setCreateBy(String createBy) {
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
	public ChangeData setCreateTime(Date createTime) {
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
	public ChangeData setUpdateBy(String updateBy) {
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
	public ChangeData setUpdateTime(Date updateTime) {
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
	public ChangeData setDeleted(Integer deleted) {
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
	public ChangeData setDeleteBy(String deleteBy) {
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
	public ChangeData setDeleteTime(Date deleteTime) {
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
	public ChangeData setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ChangeData , 转换好的 ChangeData 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ChangeData , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ChangeData
	 * @param changeDataMap 包含实体信息的 Map 对象
	 * @return ChangeData , 转换好的的 ChangeData 对象
	*/
	@Transient
	public static ChangeData createFrom(Map<String,Object> changeDataMap) {
		if(changeDataMap==null) return null;
		ChangeData po = EntityContext.create(ChangeData.class, changeDataMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ChangeData
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ChangeData , 转换好的的 ChangeData 对象
	*/
	@Transient
	public static ChangeData createFrom(Object pojo) {
		if(pojo==null) return null;
		ChangeData po = EntityContext.create(ChangeData.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ChangeData，等同于 new
	 * @return ChangeData 对象
	*/
	@Transient
	public static ChangeData create() {
		return EntityContext.create(ChangeData.class);
	}
}