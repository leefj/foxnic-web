package com.scientific.tailoring.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.SYS_USER_ROLE;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 10:57:53
 * @sign 9ABBC4B43984B084BD46BE93F0D8F11D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_user_role")
public class UserRole extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_USER_ROLE.$TABLE;
	
	/**
	 * 编号：编号
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="编号" , notes = "编号")
	private Integer id;
	
	/**
	 * 用户ID：用户ID
	*/
	@ApiModelProperty(required = true,value="用户ID" , notes = "用户ID")
	private Long userId;
	
	/**
	 * 角色ID：角色ID
	*/
	@ApiModelProperty(required = true,value="角色ID" , notes = "角色ID")
	private Integer roleId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private Long createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private Long updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Boolean deleted;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private Long deleteBy;
	
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
	 * 获得 编号<br>
	 * 属性说明 : 编号
	 * @return 编号
	*/
	public Integer getId() {
		return id;
	}
	
	/**
	 * 设置 编号
	 * @param id 编号
	 * @return 当前对象
	*/
	public UserRole setId(Integer id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 用户ID<br>
	 * 属性说明 : 用户ID
	 * @return 用户ID
	*/
	public Long getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户ID
	 * @param userId 用户ID
	 * @return 当前对象
	*/
	public UserRole setUserId(Long userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 角色ID<br>
	 * 属性说明 : 角色ID
	 * @return 角色ID
	*/
	public Integer getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置 角色ID
	 * @param roleId 角色ID
	 * @return 当前对象
	*/
	public UserRole setRoleId(Integer roleId) {
		this.roleId=roleId;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 属性说明 : 创建人ID
	 * @return 创建人ID
	*/
	public Long getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public UserRole setCreateBy(Long createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 属性说明 : 创建时间
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
	public UserRole setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 属性说明 : 修改人ID
	 * @return 修改人ID
	*/
	public Long getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public UserRole setUpdateBy(Long updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 属性说明 : 修改时间
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
	public UserRole setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 属性说明 : 是否已删除
	 * @return 是否已删除
	*/
	public Boolean isDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 等价于 isDeleted 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否已删除
	 * @return 是否已删除
	*/
	public Boolean getDeleted() {
		return this.deleted;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public UserRole setDeleted(Boolean deleted) {
		this.deleted=deleted;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 属性说明 : 删除人ID
	 * @return 删除人ID
	*/
	public Long getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public UserRole setDeleteBy(Long deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 属性说明 : 删除时间
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
	public UserRole setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 属性说明 : 数据版本号
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
	public UserRole setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return UserRole , 转换好的 UserRole 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return UserRole , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 UserRole
	 * @param userRoleMap 包含实体信息的 Map 对象
	 * @return UserRole , 转换好的的 UserRole 对象
	*/
	@Transient
	public static UserRole createFrom(Map<String,Object> userRoleMap) {
		if(userRoleMap==null) return null;
		UserRole po = EntityContext.create(UserRole.class, userRoleMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 UserRole
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return UserRole , 转换好的的 UserRole 对象
	*/
	@Transient
	public static UserRole createFrom(Object pojo) {
		if(pojo==null) return null;
		UserRole po = EntityContext.create(UserRole.class,pojo);
		return po;
	}

	/**
	 * 创建一个 UserRole，等同于 new
	 * @return UserRole 对象
	*/
	@Transient
	public static UserRole create() {
		return new UserRole();
	}
}