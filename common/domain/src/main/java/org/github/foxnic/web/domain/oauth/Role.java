package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_ROLE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.oauth.meta.RoleMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 角色
 * <p>角色 , 数据表 sys_role 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-30 13:48:15
 * @sign 01CAB3CFE5B7174249963D38831FB368
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_role")
@ApiModel(description = "角色 ; 角色 , 数据表 sys_role 的PO类型")
public class Role extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_ROLE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "110352963290923110")
	private String id;
	
	/**
	 * 代码：代码
	*/
	@ApiModelProperty(required = false,value="代码" , notes = "代码" , example = "super_admin")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "超级管理员")
	private String name;
	
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
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "89623837")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-02-10 10:27:35")
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
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2022-02-10 10:27:21")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "148")
	private Integer version;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 授权的账户清单：授权的账户清单
	*/
	@ApiModelProperty(required = false,value="授权的账户清单" , notes = "授权的账户清单")
	private List<User> users;
	
	/**
	 * 菜单清单：当前角色的所有菜单
	*/
	@ApiModelProperty(required = false,value="菜单清单" , notes = "当前角色的所有菜单")
	private List<Menu> menus;
	
	/**
	 * 所拥有的菜单ID清单
	*/
	@ApiModelProperty(required = false,value="所拥有的菜单ID清单" , notes = "")
	private List<String> menuIds;
	
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
	public Role setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 代码<br>
	 * 代码
	 * @return 代码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 代码
	 * @param code 代码
	 * @return 当前对象
	*/
	public Role setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public Role setName(String name) {
		this.name=name;
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
	public Role setCreateBy(String createBy) {
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
	public Role setCreateTime(Date createTime) {
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
	public Role setUpdateBy(String updateBy) {
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
	public Role setUpdateTime(Date updateTime) {
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
	public Role setDeleted(Integer deleted) {
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
	public Role setDeleted(Boolean deletedBool) {
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
	public Role setDeleteBy(String deleteBy) {
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
	public Role setDeleteTime(Date deleteTime) {
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
	public Role setVersion(Integer version) {
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
	public Role setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 授权的账户清单<br>
	 * 授权的账户清单
	 * @return 授权的账户清单
	*/
	public List<User> getUsers() {
		return users;
	}
	
	/**
	 * 设置 授权的账户清单
	 * @param users 授权的账户清单
	 * @return 当前对象
	*/
	public Role setUsers(List<User> users) {
		this.users=users;
		return this;
	}
	
	/**
	 * 添加 授权的账户清单
	 * @param user 授权的账户清单
	 * @return 当前对象
	*/
	public Role addUser(User... user) {
		if(this.users==null) users=new ArrayList<>();
		this.users.addAll(Arrays.asList(user));
		return this;
	}
	
	/**
	 * 获得 菜单清单<br>
	 * 当前角色的所有菜单
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
	public Role setMenus(List<Menu> menus) {
		this.menus=menus;
		return this;
	}
	
	/**
	 * 添加 菜单清单
	 * @param menu 菜单清单
	 * @return 当前对象
	*/
	public Role addMenu(Menu... menu) {
		if(this.menus==null) menus=new ArrayList<>();
		this.menus.addAll(Arrays.asList(menu));
		return this;
	}
	
	/**
	 * 获得 所拥有的菜单ID清单<br>
	 * @return 所拥有的菜单ID清单
	*/
	public List<String> getMenuIds() {
		return menuIds;
	}
	
	/**
	 * 设置 所拥有的菜单ID清单
	 * @param menuIds 所拥有的菜单ID清单
	 * @return 当前对象
	*/
	public Role setMenuIds(List<String> menuIds) {
		this.menuIds=menuIds;
		return this;
	}
	
	/**
	 * 添加 所拥有的菜单ID清单
	 * @param menuId 所拥有的菜单ID清单
	 * @return 当前对象
	*/
	public Role addMenuId(String... menuId) {
		if(this.menuIds==null) menuIds=new ArrayList<>();
		this.menuIds.addAll(Arrays.asList(menuId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Role , 转换好的 Role 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Role , 转换好的 PoJo 对象
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
	public Role clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Role duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.RoleMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.RoleMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setCode(this.getCode());
		inst.setDeleted(this.getDeleted());
		inst.setNotes(this.getNotes());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		if(all) {
			inst.setMenus(this.getMenus());
			inst.setMenuIds(this.getMenuIds());
			inst.setUsers(this.getUsers());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Role clone(boolean deep) {
		return EntityContext.clone(Role.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Role
	 * @param roleMap 包含实体信息的 Map 对象
	 * @return Role , 转换好的的 Role 对象
	*/
	@Transient
	public static Role createFrom(Map<String,Object> roleMap) {
		if(roleMap==null) return null;
		Role po = create();
		EntityContext.copyProperties(po,roleMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Role
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Role , 转换好的的 Role 对象
	*/
	@Transient
	public static Role createFrom(Object pojo) {
		if(pojo==null) return null;
		Role po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Role，等同于 new
	 * @return Role 对象
	*/
	@Transient
	public static Role create() {
		return new org.github.foxnic.web.domain.oauth.meta.RoleMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(RoleMeta.CREATE_BY)));
			this.setCode(DataParser.parse(String.class, map.get(RoleMeta.CODE)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RoleMeta.DELETED)));
			this.setNotes(DataParser.parse(String.class, map.get(RoleMeta.NOTES)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RoleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RoleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RoleMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(RoleMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RoleMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RoleMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(RoleMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RoleMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(RoleMeta.CREATE_BY));
				this.setCode( (String)map.get(RoleMeta.CODE));
				this.setDeleted( (Integer)map.get(RoleMeta.DELETED));
				this.setNotes( (String)map.get(RoleMeta.NOTES));
				this.setCreateTime( (Date)map.get(RoleMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RoleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RoleMeta.DELETE_TIME));
				this.setName( (String)map.get(RoleMeta.NAME));
				this.setDeleteBy( (String)map.get(RoleMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(RoleMeta.UPDATE_TIME));
				this.setId( (String)map.get(RoleMeta.ID));
				this.setVersion( (Integer)map.get(RoleMeta.VERSION));
				// others
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RoleMeta.CREATE_BY)));
			this.setCode(DataParser.parse(String.class, r.getValue(RoleMeta.CODE)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RoleMeta.DELETED)));
			this.setNotes(DataParser.parse(String.class, r.getValue(RoleMeta.NOTES)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RoleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RoleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RoleMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(RoleMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RoleMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RoleMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(RoleMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RoleMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(RoleMeta.CREATE_BY));
				this.setCode( (String)r.getValue(RoleMeta.CODE));
				this.setDeleted( (Integer)r.getValue(RoleMeta.DELETED));
				this.setNotes( (String)r.getValue(RoleMeta.NOTES));
				this.setCreateTime( (Date)r.getValue(RoleMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RoleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RoleMeta.DELETE_TIME));
				this.setName( (String)r.getValue(RoleMeta.NAME));
				this.setDeleteBy( (String)r.getValue(RoleMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(RoleMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(RoleMeta.ID));
				this.setVersion( (Integer)r.getValue(RoleMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}