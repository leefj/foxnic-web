package org.github.foxnic.web.domain.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER_TENANT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 账户租户关系
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:18:43
 * @sign D43E57CFF208F360D565D38B0CE49BAF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_user_tenant")
public class UserTenant extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_USER_TENANT.$TABLE;

	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;

	/**
	 * 用户ID：用户ID
	*/
	@ApiModelProperty(required = false,value="用户ID" , notes = "用户ID")
	private String userId;

	/**
	 * 所属的租户ID：所属的租户ID
	*/
	@ApiModelProperty(required = false,value="所属的租户ID" , notes = "所属的租户ID")
	private String ownerTenantId;

	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = false,value="是否有效" , notes = "是否有效")
	private Integer valid;

	/**
	 * 是否激活：激活时为当前默认租户
	*/
	@ApiModelProperty(required = false,value="是否激活" , notes = "激活时为当前默认租户")
	private Integer activated;

	/**
	 * 员工ID：账户在指定租户下的员工ID
	*/
	@ApiModelProperty(required = false,value="员工ID" , notes = "账户在指定租户下的员工ID")
	private String employeeId;

	/**
	 * 顺序：顺序
	*/
	@ApiModelProperty(required = false,value="顺序" , notes = "顺序")
	private Integer sort;

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
	@Transient
	private Boolean deletedBool;

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
	 * 租户对象：租户对象
	*/
	@ApiModelProperty(required = false,value="租户对象" , notes = "租户对象")
	private Tenant tenant;

	/**
	 * 当前激活的租户对应的员工：当前激活的租户对应的员工
	*/
	@ApiModelProperty(required = false,value="当前激活的租户对应的员工" , notes = "当前激活的租户对应的员工")
	private Employee employee;

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
	public UserTenant setId(String id) {
		this.id=id;
		return this;
	}

	/**
	 * 获得 用户ID<br>
	 * 用户ID
	 * @return 用户ID
	*/
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置 用户ID
	 * @param userId 用户ID
	 * @return 当前对象
	*/
	public UserTenant setUserId(String userId) {
		this.userId=userId;
		return this;
	}

	/**
	 * 获得 所属的租户ID<br>
	 * 所属的租户ID
	 * @return 所属的租户ID
	*/
	public String getOwnerTenantId() {
		return ownerTenantId;
	}

	/**
	 * 设置 所属的租户ID
	 * @param ownerTenantId 所属的租户ID
	 * @return 当前对象
	*/
	public UserTenant setOwnerTenantId(String ownerTenantId) {
		this.ownerTenantId=ownerTenantId;
		return this;
	}

	/**
	 * 获得 是否有效<br>
	 * 是否有效
	 * @return 是否有效
	*/
	public Integer getValid() {
		return valid;
	}

	/**
	 * 设置 是否有效
	 * @param valid 是否有效
	 * @return 当前对象
	*/
	public UserTenant setValid(Integer valid) {
		this.valid=valid;
		return this;
	}

	/**
	 * 获得 是否激活<br>
	 * 激活时为当前默认租户
	 * @return 是否激活
	*/
	public Integer getActivated() {
		return activated;
	}

	/**
	 * 设置 是否激活
	 * @param activated 是否激活
	 * @return 当前对象
	*/
	public UserTenant setActivated(Integer activated) {
		this.activated=activated;
		return this;
	}

	/**
	 * 获得 员工ID<br>
	 * 账户在指定租户下的员工ID
	 * @return 员工ID
	*/
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * 设置 员工ID
	 * @param employeeId 员工ID
	 * @return 当前对象
	*/
	public UserTenant setEmployeeId(String employeeId) {
		this.employeeId=employeeId;
		return this;
	}

	/**
	 * 获得 顺序<br>
	 * 顺序
	 * @return 顺序
	*/
	public Integer getSort() {
		return sort;
	}

	/**
	 * 设置 顺序
	 * @param sort 顺序
	 * @return 当前对象
	*/
	public UserTenant setSort(Integer sort) {
		this.sort=sort;
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
	public UserTenant setCreateBy(String createBy) {
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
	public UserTenant setCreateTime(Date createTime) {
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
	public UserTenant setUpdateBy(String updateBy) {
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
	public UserTenant setUpdateTime(Date updateTime) {
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
	public UserTenant setDeleted(Integer deleted) {
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
	public UserTenant setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
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
	public UserTenant setDeleteBy(String deleteBy) {
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
	public UserTenant setDeleteTime(Date deleteTime) {
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
	public UserTenant setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 获得 租户对象<br>
	 * 租户对象
	 * @return 租户对象
	*/
	public Tenant getTenant() {
		return tenant;
	}

	/**
	 * 设置 租户对象
	 * @param tenant 租户对象
	 * @return 当前对象
	*/
	public UserTenant setTenant(Tenant tenant) {
		this.tenant=tenant;
		return this;
	}

	/**
	 * 获得 当前激活的租户对应的员工<br>
	 * 当前激活的租户对应的员工
	 * @return 当前激活的租户对应的员工
	*/
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * 设置 当前激活的租户对应的员工
	 * @param employee 当前激活的租户对应的员工
	 * @return 当前对象
	*/
	public UserTenant setEmployee(Employee employee) {
		this.employee=employee;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return UserTenant , 转换好的 UserTenant 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return UserTenant , 转换好的 PoJo 对象
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
	public UserTenant clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public UserTenant duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.UserTenantMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.UserTenantMeta.$$proxy$$();
		inst.setEmployeeId(this.getEmployeeId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerTenantId(this.getOwnerTenantId());
		inst.setSort(this.getSort());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setValid(this.getValid());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setActivated(this.getActivated());
		if(all) {
			inst.setEmployee(this.getEmployee());
			inst.setTenant(this.getTenant());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public UserTenant clone(boolean deep) {
		return EntityContext.clone(UserTenant.class,this,deep);
	}

	/**
	 * 将 Map 转换成 UserTenant
	 * @param userTenantMap 包含实体信息的 Map 对象
	 * @return UserTenant , 转换好的的 UserTenant 对象
	*/
	@Transient
	public static UserTenant createFrom(Map<String,Object> userTenantMap) {
		if(userTenantMap==null) return null;
		UserTenant po = EntityContext.create(UserTenant.class, userTenantMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 UserTenant
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return UserTenant , 转换好的的 UserTenant 对象
	*/
	@Transient
	public static UserTenant createFrom(Object pojo) {
		if(pojo==null) return null;
		UserTenant po = EntityContext.create(UserTenant.class,pojo);
		return po;
	}

	/**
	 * 创建一个 UserTenant，等同于 new
	 * @return UserTenant 对象
	*/
	@Transient
	public static UserTenant create() {
		return EntityContext.create(UserTenant.class);
	}
}
