package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.system.UserTenant;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 账户
 * <p>账户 , 数据表 sys_user 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-15 08:23:47
 * @sign F0DB38EEC7CBEA7634A6377A72C0AC33
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_user")
@ApiModel(description = "账户 ; 账户 , 数据表 sys_user 的PO类型")
public class User extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_USER.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "110588348101165911")
	private String id;
	
	/**
	 * 账户：账户
	*/
	@ApiModelProperty(required = true,value="账户" , notes = "账户" , example = "admin")
	private String account;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = true,value="姓名" , notes = "姓名" , example = "超级管理员")
	private String realName;
	
	/**
	 * 密码：密码
	*/
	@ApiModelProperty(required = true,value="密码" , notes = "密码" , example = "******")
	private String passwd;
	
	/**
	 * 手机号码：手机号码
	*/
	@ApiModelProperty(required = true,value="手机号码" , notes = "手机号码" , example = "15700000000")
	private String phone;
	
	/**
	 * 头像ID：头像ID
	*/
	@ApiModelProperty(required = false,value="头像ID" , notes = "头像ID" , example = "696352688228532224")
	private String portraitId;
	
	/**
	 * 语言：语言
	*/
	@ApiModelProperty(required = false,value="语言" , notes = "语言" , example = "zh_cn")
	private String language;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = true,value="是否有效" , notes = "是否有效" , example = "1")
	private Integer valid;
	
	/**
	 * 缓存键：改变这个值，可使浏览器重新请求静态资源
	*/
	@ApiModelProperty(required = false,value="缓存键" , notes = "改变这个值，可使浏览器重新请求静态资源" , example = "443c1")
	private String cacheKey;
	
	/**
	 * 最后登录时间：最后登录时间
	*/
	@ApiModelProperty(required = false,value="最后登录时间" , notes = "最后登录时间" , example = "2023-04-15 08:22:54")
	private Date lastLoginTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2021-06-09 04:52:05")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-04-11 09:32:23")
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
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2022-02-10 10:27:23")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "215")
	private Integer version;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 内置账户：系统内置账户
	*/
	@ApiModelProperty(required = true,value="内置账户" , notes = "系统内置账户" , example = "0")
	private Integer buildIn;
	
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
	 * 菜单ID的集合：当前用户的所有菜单清单
	*/
	@ApiModelProperty(required = false,value="菜单ID的集合" , notes = "当前用户的所有菜单清单")
	private List<String> menuIds;
	
	/**
	 * 角色菜单关系清单：当前用户的所有角色菜单关系清单
	*/
	@ApiModelProperty(required = false,value="角色菜单关系清单" , notes = "当前用户的所有角色菜单关系清单")
	private List<RoleMenu> roleMenus;
	
	/**
	 * 所属租户关系清单：可用且有效的所属租户关系清单
	*/
	@ApiModelProperty(required = false,value="所属租户关系清单" , notes = "可用且有效的所属租户关系清单")
	private List<UserTenant> joinedTenants;
	
	/**
	 * 当前激活的租户：当前激活的租户
	*/
	@ApiModelProperty(required = false,value="当前激活的租户" , notes = "当前激活的租户")
	private UserTenant activatedTenant;
	
	/**
	 * 当前激活的员工ID：当前激活的租户对应的员工ID
	*/
	@ApiModelProperty(required = false,value="当前激活的员工ID" , notes = "当前激活的租户对应的员工ID")
	private String activatedEmployeeId;
	
	/**
	 * 当前激活的员工姓名：当前激活的租户对应的员工姓名
	*/
	@ApiModelProperty(required = false,value="当前激活的员工姓名" , notes = "当前激活的租户对应的员工姓名")
	private String activatedEmployeeName;
	
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
	public User setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 账户<br>
	 * 账户
	 * @return 账户
	*/
	public String getAccount() {
		return account;
	}
	
	/**
	 * 设置 账户
	 * @param account 账户
	 * @return 当前对象
	*/
	public User setAccount(String account) {
		this.account=account;
		return this;
	}
	
	/**
	 * 获得 姓名<br>
	 * 姓名
	 * @return 姓名
	*/
	public String getRealName() {
		return realName;
	}
	
	/**
	 * 设置 姓名
	 * @param realName 姓名
	 * @return 当前对象
	*/
	public User setRealName(String realName) {
		this.realName=realName;
		return this;
	}
	
	/**
	 * 获得 密码<br>
	 * 密码
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
	 * 获得 手机号码<br>
	 * 手机号码
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
	 * 获得 头像ID<br>
	 * 头像ID
	 * @return 头像ID
	*/
	public String getPortraitId() {
		return portraitId;
	}
	
	/**
	 * 设置 头像ID
	 * @param portraitId 头像ID
	 * @return 当前对象
	*/
	public User setPortraitId(String portraitId) {
		this.portraitId=portraitId;
		return this;
	}
	
	/**
	 * 获得 语言<br>
	 * 语言
	 * @return 语言
	*/
	public String getLanguage() {
		return language;
	}
	
	/**
	 * 设置 语言
	 * @param language 语言
	 * @return 当前对象
	*/
	public User setLanguage(String language) {
		this.language=language;
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
	public User setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 缓存键<br>
	 * 改变这个值，可使浏览器重新请求静态资源
	 * @return 缓存键
	*/
	public String getCacheKey() {
		return cacheKey;
	}
	
	/**
	 * 设置 缓存键
	 * @param cacheKey 缓存键
	 * @return 当前对象
	*/
	public User setCacheKey(String cacheKey) {
		this.cacheKey=cacheKey;
		return this;
	}
	
	/**
	 * 获得 最后登录时间<br>
	 * 最后登录时间
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
	public User setCreateBy(String createBy) {
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
	public User setCreateTime(Date createTime) {
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
	public User setUpdateBy(String updateBy) {
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
	public User setUpdateTime(Date updateTime) {
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
	public User setDeleted(Integer deleted) {
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
	public User setDeleted(Boolean deletedBool) {
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
	public User setDeleteBy(String deleteBy) {
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
	public User setDeleteTime(Date deleteTime) {
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
	public User setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public User setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 内置账户<br>
	 * 系统内置账户
	 * @return 内置账户
	*/
	public Integer getBuildIn() {
		return buildIn;
	}
	
	/**
	 * 设置 内置账户
	 * @param buildIn 内置账户
	 * @return 当前对象
	*/
	public User setBuildIn(Integer buildIn) {
		this.buildIn=buildIn;
		return this;
	}
	
	/**
	 * 获得 角色清单<br>
	 * 当前用户的所有角色清单
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
	 * @param role 角色清单
	 * @return 当前对象
	*/
	public User addRole(Role... role) {
		if(this.roles==null) roles=new ArrayList<>();
		this.roles.addAll(Arrays.asList(role));
		return this;
	}
	
	/**
	 * 获得 菜单清单<br>
	 * 当前用户的所有菜单清单
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
	 * @param menu 菜单清单
	 * @return 当前对象
	*/
	public User addMenu(Menu... menu) {
		if(this.menus==null) menus=new ArrayList<>();
		this.menus.addAll(Arrays.asList(menu));
		return this;
	}
	
	/**
	 * 获得 菜单ID的集合<br>
	 * 当前用户的所有菜单清单
	 * @return 菜单ID的集合
	*/
	public List<String> getMenuIds() {
		return menuIds;
	}
	
	/**
	 * 设置 菜单ID的集合
	 * @param menuIds 菜单ID的集合
	 * @return 当前对象
	*/
	public User setMenuIds(List<String> menuIds) {
		this.menuIds=menuIds;
		return this;
	}
	
	/**
	 * 添加 菜单ID的集合
	 * @param menuId 菜单ID的集合
	 * @return 当前对象
	*/
	public User addMenuId(String... menuId) {
		if(this.menuIds==null) menuIds=new ArrayList<>();
		this.menuIds.addAll(Arrays.asList(menuId));
		return this;
	}
	
	/**
	 * 获得 角色菜单关系清单<br>
	 * 当前用户的所有角色菜单关系清单
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
	 * @param roleMenu 角色菜单关系清单
	 * @return 当前对象
	*/
	public User addRoleMenu(RoleMenu... roleMenu) {
		if(this.roleMenus==null) roleMenus=new ArrayList<>();
		this.roleMenus.addAll(Arrays.asList(roleMenu));
		return this;
	}
	
	/**
	 * 获得 所属租户关系清单<br>
	 * 可用且有效的所属租户关系清单
	 * @return 所属租户关系清单
	*/
	public List<UserTenant> getJoinedTenants() {
		return joinedTenants;
	}
	
	/**
	 * 设置 所属租户关系清单
	 * @param joinedTenants 所属租户关系清单
	 * @return 当前对象
	*/
	public User setJoinedTenants(List<UserTenant> joinedTenants) {
		this.joinedTenants=joinedTenants;
		return this;
	}
	
	/**
	 * 添加 所属租户关系清单
	 * @param joinedTenant 所属租户关系清单
	 * @return 当前对象
	*/
	public User addJoinedTenant(UserTenant... joinedTenant) {
		if(this.joinedTenants==null) joinedTenants=new ArrayList<>();
		this.joinedTenants.addAll(Arrays.asList(joinedTenant));
		return this;
	}
	
	/**
	 * 获得 当前激活的租户<br>
	 * 当前激活的租户
	 * @return 当前激活的租户
	*/
	public UserTenant getActivatedTenant() {
		return activatedTenant;
	}
	
	/**
	 * 设置 当前激活的租户
	 * @param activatedTenant 当前激活的租户
	 * @return 当前对象
	*/
	public User setActivatedTenant(UserTenant activatedTenant) {
		this.activatedTenant=activatedTenant;
		return this;
	}
	
	/**
	 * 获得 当前激活的员工ID<br>
	 * 当前激活的租户对应的员工ID
	 * @return 当前激活的员工ID
	*/
	public String getActivatedEmployeeId() {
		return activatedEmployeeId;
	}
	
	/**
	 * 设置 当前激活的员工ID
	 * @param activatedEmployeeId 当前激活的员工ID
	 * @return 当前对象
	*/
	public User setActivatedEmployeeId(String activatedEmployeeId) {
		this.activatedEmployeeId=activatedEmployeeId;
		return this;
	}
	
	/**
	 * 获得 当前激活的员工姓名<br>
	 * 当前激活的租户对应的员工姓名
	 * @return 当前激活的员工姓名
	*/
	public String getActivatedEmployeeName() {
		return activatedEmployeeName;
	}
	
	/**
	 * 设置 当前激活的员工姓名
	 * @param activatedEmployeeName 当前激活的员工姓名
	 * @return 当前对象
	*/
	public User setActivatedEmployeeName(String activatedEmployeeName) {
		this.activatedEmployeeName=activatedEmployeeName;
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
	 * 克隆当前对象
	*/
	@Transient
	public User clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public User duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.UserMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.UserMeta.$$proxy$$();
		inst.setPortraitId(this.getPortraitId());
		inst.setNotes(this.getNotes());
		inst.setLanguage(this.getLanguage());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setValid(this.getValid());
		inst.setBuildIn(this.getBuildIn());
		inst.setRealName(this.getRealName());
		inst.setLastLoginTime(this.getLastLoginTime());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCacheKey(this.getCacheKey());
		inst.setPasswd(this.getPasswd());
		inst.setPhone(this.getPhone());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setAccount(this.getAccount());
		if(all) {
			inst.setRoles(this.getRoles());
			inst.setJoinedTenants(this.getJoinedTenants());
			inst.setActivatedEmployeeId(this.getActivatedEmployeeId());
			inst.setMenus(this.getMenus());
			inst.setMenuIds(this.getMenuIds());
			inst.setRoleMenus(this.getRoleMenus());
			inst.setActivatedTenant(this.getActivatedTenant());
			inst.setActivatedEmployeeName(this.getActivatedEmployeeName());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public User clone(boolean deep) {
		return EntityContext.clone(User.class,this,deep);
	}

	/**
	 * 将 Map 转换成 User
	 * @param userMap 包含实体信息的 Map 对象
	 * @return User , 转换好的的 User 对象
	*/
	@Transient
	public static User createFrom(Map<String,Object> userMap) {
		if(userMap==null) return null;
		User po = create();
		EntityContext.copyProperties(po,userMap);
		po.clearModifies();
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
		User po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 User，等同于 new
	 * @return User 对象
	*/
	@Transient
	public static User create() {
		return new org.github.foxnic.web.domain.oauth.meta.UserMeta.$$proxy$$();
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
			this.setPortraitId(DataParser.parse(String.class, map.get(UserMeta.PORTRAIT_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(UserMeta.NOTES)));
			this.setLanguage(DataParser.parse(String.class, map.get(UserMeta.LANGUAGE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(UserMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(UserMeta.VERSION)));
			this.setValid(DataParser.parse(Integer.class, map.get(UserMeta.VALID)));
			this.setBuildIn(DataParser.parse(Integer.class, map.get(UserMeta.BUILD_IN)));
			this.setRealName(DataParser.parse(String.class, map.get(UserMeta.REAL_NAME)));
			this.setLastLoginTime(DataParser.parse(Date.class, map.get(UserMeta.LAST_LOGIN_TIME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(UserMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(UserMeta.DELETED)));
			this.setCacheKey(DataParser.parse(String.class, map.get(UserMeta.CACHE_KEY)));
			this.setPasswd(DataParser.parse(String.class, map.get(UserMeta.PASSWD)));
			this.setPhone(DataParser.parse(String.class, map.get(UserMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(UserMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(UserMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(UserMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(UserMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(UserMeta.ID)));
			this.setAccount(DataParser.parse(String.class, map.get(UserMeta.ACCOUNT)));
			// others
			this.setActivatedEmployeeId(DataParser.parse(String.class, map.get(UserMeta.ACTIVATED_EMPLOYEE_ID)));
			this.setActivatedTenant(DataParser.parse(UserTenant.class, map.get(UserMeta.ACTIVATED_TENANT)));
			this.setActivatedEmployeeName(DataParser.parse(String.class, map.get(UserMeta.ACTIVATED_EMPLOYEE_NAME)));
			return true;
		} else {
			try {
				this.setPortraitId( (String)map.get(UserMeta.PORTRAIT_ID));
				this.setNotes( (String)map.get(UserMeta.NOTES));
				this.setLanguage( (String)map.get(UserMeta.LANGUAGE));
				this.setUpdateTime( (Date)map.get(UserMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(UserMeta.VERSION));
				this.setValid( (Integer)map.get(UserMeta.VALID));
				this.setBuildIn( (Integer)map.get(UserMeta.BUILD_IN));
				this.setRealName( (String)map.get(UserMeta.REAL_NAME));
				this.setLastLoginTime( (Date)map.get(UserMeta.LAST_LOGIN_TIME));
				this.setCreateBy( (String)map.get(UserMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(UserMeta.DELETED));
				this.setCacheKey( (String)map.get(UserMeta.CACHE_KEY));
				this.setPasswd( (String)map.get(UserMeta.PASSWD));
				this.setPhone( (String)map.get(UserMeta.PHONE));
				this.setCreateTime( (Date)map.get(UserMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(UserMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(UserMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(UserMeta.DELETE_BY));
				this.setId( (String)map.get(UserMeta.ID));
				this.setAccount( (String)map.get(UserMeta.ACCOUNT));
				// others
				this.setActivatedEmployeeId( (String)map.get(UserMeta.ACTIVATED_EMPLOYEE_ID));
				this.setActivatedTenant( (UserTenant)map.get(UserMeta.ACTIVATED_TENANT));
				this.setActivatedEmployeeName( (String)map.get(UserMeta.ACTIVATED_EMPLOYEE_NAME));
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
			this.setPortraitId(DataParser.parse(String.class, r.getValue(UserMeta.PORTRAIT_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(UserMeta.NOTES)));
			this.setLanguage(DataParser.parse(String.class, r.getValue(UserMeta.LANGUAGE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(UserMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(UserMeta.VERSION)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(UserMeta.VALID)));
			this.setBuildIn(DataParser.parse(Integer.class, r.getValue(UserMeta.BUILD_IN)));
			this.setRealName(DataParser.parse(String.class, r.getValue(UserMeta.REAL_NAME)));
			this.setLastLoginTime(DataParser.parse(Date.class, r.getValue(UserMeta.LAST_LOGIN_TIME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(UserMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(UserMeta.DELETED)));
			this.setCacheKey(DataParser.parse(String.class, r.getValue(UserMeta.CACHE_KEY)));
			this.setPasswd(DataParser.parse(String.class, r.getValue(UserMeta.PASSWD)));
			this.setPhone(DataParser.parse(String.class, r.getValue(UserMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(UserMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(UserMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(UserMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(UserMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(UserMeta.ID)));
			this.setAccount(DataParser.parse(String.class, r.getValue(UserMeta.ACCOUNT)));
			return true;
		} else {
			try {
				this.setPortraitId( (String)r.getValue(UserMeta.PORTRAIT_ID));
				this.setNotes( (String)r.getValue(UserMeta.NOTES));
				this.setLanguage( (String)r.getValue(UserMeta.LANGUAGE));
				this.setUpdateTime( (Date)r.getValue(UserMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(UserMeta.VERSION));
				this.setValid( (Integer)r.getValue(UserMeta.VALID));
				this.setBuildIn( (Integer)r.getValue(UserMeta.BUILD_IN));
				this.setRealName( (String)r.getValue(UserMeta.REAL_NAME));
				this.setLastLoginTime( (Date)r.getValue(UserMeta.LAST_LOGIN_TIME));
				this.setCreateBy( (String)r.getValue(UserMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(UserMeta.DELETED));
				this.setCacheKey( (String)r.getValue(UserMeta.CACHE_KEY));
				this.setPasswd( (String)r.getValue(UserMeta.PASSWD));
				this.setPhone( (String)r.getValue(UserMeta.PHONE));
				this.setCreateTime( (Date)r.getValue(UserMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(UserMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(UserMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(UserMeta.DELETE_BY));
				this.setId( (String)r.getValue(UserMeta.ID));
				this.setAccount( (String)r.getValue(UserMeta.ACCOUNT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}