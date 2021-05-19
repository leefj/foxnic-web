package com.scientific.tailoring.domain.system;

import com.github.foxnic.dao.entity.Entity;
import java.util.List;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.SYS_USER;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import com.scientific.tailoring.domain.crm.Employee;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 10:53:40
 * @sign 403F98AA519469231F5E1524442561AE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_user")
public class User extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_USER.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private Long id;
	
	/**
	 * 登录帐号：登录帐号
	*/
	@ApiModelProperty(required = true,value="登录帐号" , notes = "登录帐号")
	private String account;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = true,value="姓名" , notes = "姓名")
	private String name;
	
	/**
	 * 登录密码：登录密码
	*/
	@ApiModelProperty(required = false,value="登录密码" , notes = "登录密码")
	private String password;
	
	/**
	 * 手机号码：手机号码
	*/
	@ApiModelProperty(required = false,value="手机号码" , notes = "手机号码")
	private String mobile;
	
	/**
	 * 头像文件ID：头像文件ID
	*/
	@ApiModelProperty(required = false,value="头像文件ID" , notes = "头像文件ID")
	private Long portraitId;
	
	/**
	 * 最近登录时间：最近登录时间
	*/
	@ApiModelProperty(required = false,value="最近登录时间" , notes = "最近登录时间")
	private Date latestLoginTime;
	
	/**
	 * 是否有效：禁用:0/启用:1
	*/
	@ApiModelProperty(required = true,value="是否有效" , notes = "禁用:0/启用:1")
	private Boolean valid;
	
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
	 * 所有角色清单：拥有当前用户的所有角色清单
	*/
	@ApiModelProperty(required = false,value="所有角色清单" , notes = "拥有当前用户的所有角色清单")
	private List<Role> allRoles;
	
	/**
	 * 可用角色清单：拥有当前用户的可用角色清单
	*/
	@ApiModelProperty(required = false,value="可用角色清单" , notes = "拥有当前用户的可用角色清单")
	private List<Role> validRoles;
	
	/**
	 * 员工：当前账户对应的员工
	*/
	@ApiModelProperty(required = false,value="员工" , notes = "当前账户对应的员工")
	private Employee employee;
	
	/**
	 * 获得 ID<br>
	 * 属性说明 : ID
	 * @return ID
	*/
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public User setId(Long id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 登录帐号<br>
	 * 属性说明 : 登录帐号
	 * @return 登录帐号
	*/
	public String getAccount() {
		return account;
	}
	
	/**
	 * 设置 登录帐号
	 * @param account 登录帐号
	 * @return 当前对象
	*/
	public User setAccount(String account) {
		this.account=account;
		return this;
	}
	
	/**
	 * 获得 姓名<br>
	 * 属性说明 : 姓名
	 * @return 姓名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 姓名
	 * @param name 姓名
	 * @return 当前对象
	*/
	public User setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 登录密码<br>
	 * 属性说明 : 登录密码
	 * @return 登录密码
	*/
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置 登录密码
	 * @param password 登录密码
	 * @return 当前对象
	*/
	public User setPassword(String password) {
		this.password=password;
		return this;
	}
	
	/**
	 * 获得 手机号码<br>
	 * 属性说明 : 手机号码
	 * @return 手机号码
	*/
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置 手机号码
	 * @param mobile 手机号码
	 * @return 当前对象
	*/
	public User setMobile(String mobile) {
		this.mobile=mobile;
		return this;
	}
	
	/**
	 * 获得 头像文件ID<br>
	 * 属性说明 : 头像文件ID
	 * @return 头像文件ID
	*/
	public Long getPortraitId() {
		return portraitId;
	}
	
	/**
	 * 设置 头像文件ID
	 * @param portraitId 头像文件ID
	 * @return 当前对象
	*/
	public User setPortraitId(Long portraitId) {
		this.portraitId=portraitId;
		return this;
	}
	
	/**
	 * 获得 最近登录时间<br>
	 * 属性说明 : 最近登录时间
	 * @return 最近登录时间
	*/
	public Date getLatestLoginTime() {
		return latestLoginTime;
	}
	
	/**
	 * 设置 最近登录时间
	 * @param latestLoginTime 最近登录时间
	 * @return 当前对象
	*/
	public User setLatestLoginTime(Date latestLoginTime) {
		this.latestLoginTime=latestLoginTime;
		return this;
	}
	
	/**
	 * 获得 是否有效<br>
	 * 属性说明 : 禁用:0/启用:1
	 * @return 是否有效
	*/
	public Boolean isValid() {
		return valid;
	}
	
	/**
	 * 获得 是否有效<br>
	 * 等价于 isValid 方法，为兼容 Swagger 需要
	 * 属性说明 : 禁用:0/启用:1
	 * @return 是否有效
	*/
	public Boolean getValid() {
		return this.valid;
	}
	
	/**
	 * 设置 是否有效
	 * @param valid 是否有效
	 * @return 当前对象
	*/
	public User setValid(Boolean valid) {
		this.valid=valid;
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
	public User setCreateBy(Long createBy) {
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
	public User setCreateTime(Date createTime) {
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
	public User setUpdateBy(Long updateBy) {
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
	public User setUpdateTime(Date updateTime) {
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
	public User setDeleted(Boolean deleted) {
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
	public User setDeleteBy(Long deleteBy) {
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
	public User setDeleteTime(Date deleteTime) {
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
	public User setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 所有角色清单<br>
	 * 属性说明 : 拥有当前用户的所有角色清单
	 * @return 所有角色清单
	*/
	public List<Role> getAllRoles() {
		return allRoles;
	}
	
	/**
	 * 设置 所有角色清单
	 * @param allRoles 所有角色清单
	 * @return 当前对象
	*/
	public User setAllRoles(List<Role> allRoles) {
		this.allRoles=allRoles;
		return this;
	}
	
	/**
	 * 获得 可用角色清单<br>
	 * 属性说明 : 拥有当前用户的可用角色清单
	 * @return 可用角色清单
	*/
	public List<Role> getValidRoles() {
		return validRoles;
	}
	
	/**
	 * 设置 可用角色清单
	 * @param validRoles 可用角色清单
	 * @return 当前对象
	*/
	public User setValidRoles(List<Role> validRoles) {
		this.validRoles=validRoles;
		return this;
	}
	
	/**
	 * 获得 员工<br>
	 * 属性说明 : 当前账户对应的员工
	 * @return 员工
	*/
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * 设置 员工
	 * @param employee 员工
	 * @return 当前对象
	*/
	public User setEmployee(Employee employee) {
		this.employee=employee;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return User , 转换好的 User 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return User , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 User
	 * @param userMap 包含实体信息的 Map 对象
	 * @return User , 转换好的的 User 对象
	*/
	@Transient
	public static User createFrom(Map<String,Object> userMap) {
		if(userMap==null) return null;
		User po = EntityContext.create(User.class, userMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 User
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return User , 转换好的的 User 对象
	*/
	@Transient
	public static User createFrom(Object pojo) {
		if(pojo==null) return null;
		User po = EntityContext.create(User.class,pojo);
		return po;
	}

	/**
	 * 创建一个 User，等同于 new
	 * @return User 对象
	*/
	@Transient
	public static User create() {
		return new User();
	}
}