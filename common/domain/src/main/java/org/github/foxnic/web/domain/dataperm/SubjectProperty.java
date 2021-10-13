package org.github.foxnic.web.domain.dataperm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_SUBJECT_PROPERTY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 数据权限主体属性
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-13 15:46:37
 * @sign 215C37DE9A88E60F9A6963A69DC9C290
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "dp_subject_property")
public class SubjectProperty extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =DP_SUBJECT_PROPERTY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 主题ID：主题ID
	*/
	@ApiModelProperty(required = false,value="主题ID" , notes = "主题ID")
	private String subjectId;
	
	/**
	 * 属性名称：属性名称
	*/
	@ApiModelProperty(required = false,value="属性名称" , notes = "属性名称")
	private String name;
	
	/**
	 * 属性：层级用点号隔开
	*/
	@ApiModelProperty(required = false,value="属性" , notes = "层级用点号隔开")
	private String property;
	
	/**
	 * 是否生效：是否生效
	*/
	@ApiModelProperty(required = false,value="是否生效" , notes = "是否生效")
	private Integer valid;
	
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
	public SubjectProperty setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 主题ID<br>
	 * 主题ID
	 * @return 主题ID
	*/
	public String getSubjectId() {
		return subjectId;
	}
	
	/**
	 * 设置 主题ID
	 * @param subjectId 主题ID
	 * @return 当前对象
	*/
	public SubjectProperty setSubjectId(String subjectId) {
		this.subjectId=subjectId;
		return this;
	}
	
	/**
	 * 获得 属性名称<br>
	 * 属性名称
	 * @return 属性名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 属性名称
	 * @param name 属性名称
	 * @return 当前对象
	*/
	public SubjectProperty setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 属性<br>
	 * 层级用点号隔开
	 * @return 属性
	*/
	public String getProperty() {
		return property;
	}
	
	/**
	 * 设置 属性
	 * @param property 属性
	 * @return 当前对象
	*/
	public SubjectProperty setProperty(String property) {
		this.property=property;
		return this;
	}
	
	/**
	 * 获得 是否生效<br>
	 * 是否生效
	 * @return 是否生效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 是否生效
	 * @param valid 是否生效
	 * @return 当前对象
	*/
	public SubjectProperty setValid(Integer valid) {
		this.valid=valid;
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
	public SubjectProperty setCreateBy(String createBy) {
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
	public SubjectProperty setCreateTime(Date createTime) {
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
	public SubjectProperty setUpdateBy(String updateBy) {
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
	public SubjectProperty setUpdateTime(Date updateTime) {
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
	public SubjectProperty setDeleted(Integer deleted) {
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
	public SubjectProperty setDeleteBy(String deleteBy) {
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
	public SubjectProperty setDeleteTime(Date deleteTime) {
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
	public SubjectProperty setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SubjectProperty , 转换好的 SubjectProperty 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SubjectProperty , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 SubjectProperty
	 * @param subjectPropertyMap 包含实体信息的 Map 对象
	 * @return SubjectProperty , 转换好的的 SubjectProperty 对象
	*/
	@Transient
	public static SubjectProperty createFrom(Map<String,Object> subjectPropertyMap) {
		if(subjectPropertyMap==null) return null;
		SubjectProperty po = EntityContext.create(SubjectProperty.class, subjectPropertyMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 SubjectProperty
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SubjectProperty , 转换好的的 SubjectProperty 对象
	*/
	@Transient
	public static SubjectProperty createFrom(Object pojo) {
		if(pojo==null) return null;
		SubjectProperty po = EntityContext.create(SubjectProperty.class,pojo);
		return po;
	}

	/**
	 * 创建一个 SubjectProperty，等同于 new
	 * @return SubjectProperty 对象
	*/
	@Transient
	public static SubjectProperty create() {
		return EntityContext.create(SubjectProperty.class);
	}
}