package org.github.foxnic.web.domain.oauth;

import java.util.List;
import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-04 15:27:27
 * @sign 6BAB5A7BEA5DA5F33F8BCC13FEE75D73
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
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private String id;
	
	/**
	 * 账户：账户
	*/
	@ApiModelProperty(required = false,value="账户" , notes = "账户")
	private String name;
	
	/**
	 * 密码：密码
	*/
	@ApiModelProperty(required = false,value="密码" , notes = "密码")
	private String passwd;
	
	/**
	 * 盐：盐
	*/
	@ApiModelProperty(required = false,value="盐" , notes = "盐")
	private String salt;
	
	/**
	 * 手机号码：手机号码
	*/
	@ApiModelProperty(required = false,value="手机号码" , notes = "手机号码")
	private String phone;
	
	/**
	 * 人员ID：人员ID
	*/
	@ApiModelProperty(required = false,value="人员ID" , notes = "人员ID")
	private String personId;
	
	/**
	 * 员工ID：员工ID
	*/
	@ApiModelProperty(required = false,value="员工ID" , notes = "员工ID")
	private String employeeId;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = true,value="是否有效" , notes = "是否有效")
	private Integer valid;
	
	/**
	 * 最后登录时间：最后登录时间
	*/
	@ApiModelProperty(required = false,value="最后登录时间" , notes = "最后登录时间")
	private Date lastLoginTime;
	
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
	 * 角色清单：当前用户的所有角色清单
	*/
	@ApiModelProperty(required = false,value="角色清单" , notes = "当前用户的所有角色清单")
	private List<Role> roles;
	
	/**
	 * 菜单清单：当前用户的所有菜单清单
	*/
	@ApiModelProperty(required = false,value="菜单清单" , notes = "当前用户的所有菜单清单")
	private List<Menu> menus;
	
	/**
	 * 角色菜单关系清单：当前用户的所有角色菜单关系清单
	*/
	@ApiModelProperty(required = false,value="角色菜单关系清单" , notes = "当前用户的所有角色菜单关系清单")
	private List<RoleMenu> roleMenus;
	
	/**
	 * 获得 ID<br>
	 * 属性说明 : ID
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
	public User setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 ID
	 * @param id ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 账户<br>
	 * 属性说明 : 账户
	 * @return 账户
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 账户
	 * @param name 账户
	 * @return 当前对象
	*/
	public User setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 添加 账户
	 * @param name 账户
	 * @return 当前对象
	*/
	
	/**
	 * 获得 密码<br>
	 * 属性说明 : 密码
	 * @return 密码
	*/
	public String getPasswd() {
		return passwd;
	}
	
	/**
	 * 设置 密码
	 * @param passwd 密码
	 * @return 当前对象
	*/
	public User setPasswd(String passwd) {
		this.passwd=passwd;
		return this;
	}
	
	/**
	 * 添加 密码
	 * @param passwd 密码
	 * @return 当前对象
	*/
	
	/**
	 * 获得 盐<br>
	 * 属性说明 : 盐
	 * @return 盐
	*/
	public String getSalt() {
		return salt;
	}
	
	/**
	 * 设置 盐
	 * @param salt 盐
	 * @return 当前对象
	*/
	public User setSalt(String salt) {
		this.salt=salt;
		return this;
	}
	
	/**
	 * 添加 盐
	 * @param salt 盐
	 * @return 当前对象
	*/
	
	/**
	 * 获得 手机号码<br>
	 * 属性说明 : 手机号码
	 * @return 手机号码
	*/
	public String getPhone() {
		return phone;
	}
	
	/**
	 * 设置 手机号码
	 * @param phone 手机号码
	 * @return 当前对象
	*/
	public User setPhone(String phone) {
		this.phone=phone;
		return this;
	}
	
	/**
	 * 添加 手机号码
	 * @param phone 手机号码
	 * @return 当前对象
	*/
	
	/**
	 * 获得 人员ID<br>
	 * 属性说明 : 人员ID
	 * @return 人员ID
	*/
	public String getPersonId() {
		return personId;
	}
	
	/**
	 * 设置 人员ID
	 * @param personId 人员ID
	 * @return 当前对象
	*/
	public User setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 添加 人员ID
	 * @param personId 人员ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 员工ID<br>
	 * 属性说明 : 员工ID
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
	public User setEmployeeId(String employeeId) {
		this.employeeId=employeeId;
		return this;
	}
	
	/**
	 * 添加 员工ID
	 * @param employeeId 员工ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否有效<br>
	 * 属性说明 : 是否有效
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
	public User setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 添加 是否有效
	 * @param valid 是否有效
	 * @return 当前对象
	*/
	
	/**
	 * 获得 最后登录时间<br>
	 * 属性说明 : 最后登录时间
	 * @return 最后登录时间
	*/
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	
	/**
	 * 设置 最后登录时间
	 * @param lastLoginTime 最后登录时间
	 * @return 当前对象
	*/
	public User setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime=lastLoginTime;
		return this;
	}
	
	/**
	 * 添加 最后登录时间
	 * @param lastLoginTime 最后登录时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建人ID<br>
	 * 属性说明 : 创建人ID
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
	public User setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 添加 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	
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
	 * 添加 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改人ID<br>
	 * 属性说明 : 修改人ID
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
	public User setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 添加 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	
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
	 * 添加 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否已删除<br>
	 * 属性说明 : 是否已删除
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
	public User setDeleted(Integer deleted) {
		this.deleted=deleted;
		return this;
	}
	
	/**
	 * 添加 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	
	/**
	 * 获得 删除人ID<br>
	 * 属性说明 : 删除人ID
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
	public User setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 添加 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	
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
	 * 添加 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	
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
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	
	/**
	 * 获得 角色清单<br>
	 * 属性说明 : 当前用户的所有角色清单
	 * @return 角色清单
	*/
	public List<Role> getRoles() {
		return roles;
	}
	
	/**
	 * 设置 角色清单
	 * @param roles 角色清单
	 * @return 当前对象
	*/
	public User setRoles(List<Role> roles) {
		this.roles=roles;
		return this;
	}
	
	/**
	 * 添加 角色清单
	 * @param roles 角色清单
	 * @return 当前对象
	*/
	public User addRole(Role role) {
		if(this.roles==null) roles=new ArrayList<>();
		this.roles.add(role);
		return this;
	}
	
	/**
	 * 获得 菜单清单<br>
	 * 属性说明 : 当前用户的所有菜单清单
	 * @return 菜单清单
	*/
	public List<Menu> getMenus() {
		return menus;
	}
	
	/**
	 * 设置 菜单清单
	 * @param menus 菜单清单
	 * @return 当前对象
	*/
	public User setMenus(List<Menu> menus) {
		this.menus=menus;
		return this;
	}
	
	/**
	 * 添加 菜单清单
	 * @param menus 菜单清单
	 * @return 当前对象
	*/
	public User addMenu(Menu menu) {
		if(this.menus==null) menus=new ArrayList<>();
		this.menus.add(menu);
		return this;
	}
	
	/**
	 * 获得 角色菜单关系清单<br>
	 * 属性说明 : 当前用户的所有角色菜单关系清单
	 * @return 角色菜单关系清单
	*/
	public List<RoleMenu> getRoleMenus() {
		return roleMenus;
	}
	
	/**
	 * 设置 角色菜单关系清单
	 * @param roleMenus 角色菜单关系清单
	 * @return 当前对象
	*/
	public User setRoleMenus(List<RoleMenu> roleMenus) {
		this.roleMenus=roleMenus;
		return this;
	}
	
	/**
	 * 添加 角色菜单关系清单
	 * @param roleMenus 角色菜单关系清单
	 * @return 当前对象
	*/
	public User addRoleMenu(RoleMenu roleMenu) {
		if(this.roleMenus==null) roleMenus=new ArrayList<>();
		this.roleMenus.add(roleMenu);
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