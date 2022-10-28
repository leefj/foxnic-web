package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER_TENANT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.system.meta.UserTenantMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 账户租户关系
 * <p>账户租户关系 , 数据表 sys_user_tenant 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:52
 * @sign D43E57CFF208F360D565D38B0CE49BAF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_user_tenant")
@ApiModel(description = "账户租户关系 ; 账户租户关系 , 数据表 sys_user_tenant 的PO类型")
public class UserTenant extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_USER_TENANT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "482928963765678080")
	private String id;
	
	/**
	 * 用户ID：用户ID
	*/
	@ApiModelProperty(required = false,value="用户ID" , notes = "用户ID" , example = "480790327339261952")
	private String userId;
	
	/**
	 * 所属的租户ID：所属的租户ID
	*/
	@ApiModelProperty(required = false,value="所属的租户ID" , notes = "所属的租户ID" , example = "T002")
	private String ownerTenantId;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = false,value="是否有效" , notes = "是否有效" , example = "1")
	private Integer valid;
	
	/**
	 * 是否激活：激活时为当前默认租户
	*/
	@ApiModelProperty(required = false,value="是否激活" , notes = "激活时为当前默认租户" , example = "0")
	private Integer activated;
	
	/**
	 * 员工ID：账户在指定租户下的员工ID
	*/
	@ApiModelProperty(required = false,value="员工ID" , notes = "账户在指定租户下的员工ID" , example = "E001")
	private String employeeId;
	
	/**
	 * 顺序：顺序
	*/
	@ApiModelProperty(required = false,value="顺序" , notes = "顺序" , example = "1")
	private Integer sort;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2021-08-25 03:07:17")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2021-08-26 07:45:38")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "30")
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
		UserTenant po = create();
		EntityContext.copyProperties(po,userTenantMap);
		po.clearModifies();
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
		UserTenant po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 UserTenant，等同于 new
	 * @return UserTenant 对象
	*/
	@Transient
	public static UserTenant create() {
		return new org.github.foxnic.web.domain.system.meta.UserTenantMeta.$$proxy$$();
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
			this.setEmployeeId(DataParser.parse(String.class, map.get(UserTenantMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(UserTenantMeta.UPDATE_TIME)));
			this.setOwnerTenantId(DataParser.parse(String.class, map.get(UserTenantMeta.OWNER_TENANT_ID)));
			this.setSort(DataParser.parse(Integer.class, map.get(UserTenantMeta.SORT)));
			this.setUserId(DataParser.parse(String.class, map.get(UserTenantMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(UserTenantMeta.VERSION)));
			this.setValid(DataParser.parse(Integer.class, map.get(UserTenantMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(UserTenantMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(UserTenantMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(UserTenantMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(UserTenantMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(UserTenantMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(UserTenantMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(UserTenantMeta.ID)));
			this.setActivated(DataParser.parse(Integer.class, map.get(UserTenantMeta.ACTIVATED)));
			// others
			this.setEmployee(DataParser.parse(Employee.class, map.get(UserTenantMeta.EMPLOYEE)));
			this.setTenant(DataParser.parse(Tenant.class, map.get(UserTenantMeta.TENANT)));
			return true;
		} else {
			try {
				this.setEmployeeId( (String)map.get(UserTenantMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)map.get(UserTenantMeta.UPDATE_TIME));
				this.setOwnerTenantId( (String)map.get(UserTenantMeta.OWNER_TENANT_ID));
				this.setSort( (Integer)map.get(UserTenantMeta.SORT));
				this.setUserId( (String)map.get(UserTenantMeta.USER_ID));
				this.setVersion( (Integer)map.get(UserTenantMeta.VERSION));
				this.setValid( (Integer)map.get(UserTenantMeta.VALID));
				this.setCreateBy( (String)map.get(UserTenantMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(UserTenantMeta.DELETED));
				this.setCreateTime( (Date)map.get(UserTenantMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(UserTenantMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(UserTenantMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(UserTenantMeta.DELETE_BY));
				this.setId( (String)map.get(UserTenantMeta.ID));
				this.setActivated( (Integer)map.get(UserTenantMeta.ACTIVATED));
				// others
				this.setEmployee( (Employee)map.get(UserTenantMeta.EMPLOYEE));
				this.setTenant( (Tenant)map.get(UserTenantMeta.TENANT));
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
			this.setEmployeeId(DataParser.parse(String.class, r.getValue(UserTenantMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(UserTenantMeta.UPDATE_TIME)));
			this.setOwnerTenantId(DataParser.parse(String.class, r.getValue(UserTenantMeta.OWNER_TENANT_ID)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(UserTenantMeta.SORT)));
			this.setUserId(DataParser.parse(String.class, r.getValue(UserTenantMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(UserTenantMeta.VERSION)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(UserTenantMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(UserTenantMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(UserTenantMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(UserTenantMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(UserTenantMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(UserTenantMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(UserTenantMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(UserTenantMeta.ID)));
			this.setActivated(DataParser.parse(Integer.class, r.getValue(UserTenantMeta.ACTIVATED)));
			return true;
		} else {
			try {
				this.setEmployeeId( (String)r.getValue(UserTenantMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)r.getValue(UserTenantMeta.UPDATE_TIME));
				this.setOwnerTenantId( (String)r.getValue(UserTenantMeta.OWNER_TENANT_ID));
				this.setSort( (Integer)r.getValue(UserTenantMeta.SORT));
				this.setUserId( (String)r.getValue(UserTenantMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(UserTenantMeta.VERSION));
				this.setValid( (Integer)r.getValue(UserTenantMeta.VALID));
				this.setCreateBy( (String)r.getValue(UserTenantMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(UserTenantMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(UserTenantMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(UserTenantMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(UserTenantMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(UserTenantMeta.DELETE_BY));
				this.setId( (String)r.getValue(UserTenantMeta.ID));
				this.setActivated( (Integer)r.getValue(UserTenantMeta.ACTIVATED));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}