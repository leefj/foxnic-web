package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_ROLE_MENU;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.oauth.meta.RoleMenuMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 角色账户关系
 * <p>角色账户关系 , 数据表 sys_role_menu 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 15:18:34
 * @sign 593389CE94857B0DF46D9A0209D57C3A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_role_menu")
@ApiModel(description = "角色账户关系 ; 角色账户关系 , 数据表 sys_role_menu 的PO类型")
public class RoleMenu extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_ROLE_MENU.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id" , example = "463779099165327360")
	private String id;
	
	/**
	 * 角色ID：角色ID
	*/
	@ApiModelProperty(required = false,value="角色ID" , notes = "角色ID" , example = "110352963290923110")
	private String roleId;
	
	/**
	 * 菜单ID：菜单ID
	*/
	@ApiModelProperty(required = false,value="菜单ID" , notes = "菜单ID" , example = "463779099165327360")
	private String menuId;
	
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * 获得 id<br>
	 * id
	 * @return id
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 id
	 * @param id id
	 * @return 当前对象
	*/
	public RoleMenu setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 角色ID<br>
	 * 角色ID
	 * @return 角色ID
	*/
	public String getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置 角色ID
	 * @param roleId 角色ID
	 * @return 当前对象
	*/
	public RoleMenu setRoleId(String roleId) {
		this.roleId=roleId;
		return this;
	}
	
	/**
	 * 获得 菜单ID<br>
	 * 菜单ID
	 * @return 菜单ID
	*/
	public String getMenuId() {
		return menuId;
	}
	
	/**
	 * 设置 菜单ID
	 * @param menuId 菜单ID
	 * @return 当前对象
	*/
	public RoleMenu setMenuId(String menuId) {
		this.menuId=menuId;
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
	public RoleMenu setCreateBy(String createBy) {
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
	public RoleMenu setCreateTime(Date createTime) {
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
	public RoleMenu setUpdateBy(String updateBy) {
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
	public RoleMenu setUpdateTime(Date updateTime) {
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
	public RoleMenu setDeleted(Integer deleted) {
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
	public RoleMenu setDeleted(Boolean deletedBool) {
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
	public RoleMenu setDeleteBy(String deleteBy) {
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
	public RoleMenu setDeleteTime(Date deleteTime) {
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
	public RoleMenu setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RoleMenu , 转换好的 RoleMenu 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RoleMenu , 转换好的 PoJo 对象
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
	public RoleMenu clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RoleMenu duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.RoleMenuMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.RoleMenuMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setRoleId(this.getRoleId());
		inst.setMenuId(this.getMenuId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RoleMenu clone(boolean deep) {
		return EntityContext.clone(RoleMenu.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RoleMenu
	 * @param roleMenuMap 包含实体信息的 Map 对象
	 * @return RoleMenu , 转换好的的 RoleMenu 对象
	*/
	@Transient
	public static RoleMenu createFrom(Map<String,Object> roleMenuMap) {
		if(roleMenuMap==null) return null;
		RoleMenu po = create();
		EntityContext.copyProperties(po,roleMenuMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 RoleMenu
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RoleMenu , 转换好的的 RoleMenu 对象
	*/
	@Transient
	public static RoleMenu createFrom(Object pojo) {
		if(pojo==null) return null;
		RoleMenu po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 RoleMenu，等同于 new
	 * @return RoleMenu 对象
	*/
	@Transient
	public static RoleMenu create() {
		return new org.github.foxnic.web.domain.oauth.meta.RoleMenuMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(RoleMenuMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RoleMenuMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RoleMenuMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RoleMenuMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RoleMenuMeta.DELETE_TIME)));
			this.setRoleId(DataParser.parse(String.class, map.get(RoleMenuMeta.ROLE_ID)));
			this.setMenuId(DataParser.parse(String.class, map.get(RoleMenuMeta.MENU_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RoleMenuMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RoleMenuMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(RoleMenuMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RoleMenuMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(RoleMenuMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RoleMenuMeta.DELETED));
				this.setCreateTime( (Date)map.get(RoleMenuMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RoleMenuMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RoleMenuMeta.DELETE_TIME));
				this.setRoleId( (String)map.get(RoleMenuMeta.ROLE_ID));
				this.setMenuId( (String)map.get(RoleMenuMeta.MENU_ID));
				this.setDeleteBy( (String)map.get(RoleMenuMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(RoleMenuMeta.UPDATE_TIME));
				this.setId( (String)map.get(RoleMenuMeta.ID));
				this.setVersion( (Integer)map.get(RoleMenuMeta.VERSION));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RoleMenuMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RoleMenuMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RoleMenuMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RoleMenuMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RoleMenuMeta.DELETE_TIME)));
			this.setRoleId(DataParser.parse(String.class, r.getValue(RoleMenuMeta.ROLE_ID)));
			this.setMenuId(DataParser.parse(String.class, r.getValue(RoleMenuMeta.MENU_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RoleMenuMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RoleMenuMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(RoleMenuMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RoleMenuMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(RoleMenuMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RoleMenuMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(RoleMenuMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RoleMenuMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RoleMenuMeta.DELETE_TIME));
				this.setRoleId( (String)r.getValue(RoleMenuMeta.ROLE_ID));
				this.setMenuId( (String)r.getValue(RoleMenuMeta.MENU_ID));
				this.setDeleteBy( (String)r.getValue(RoleMenuMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(RoleMenuMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(RoleMenuMeta.ID));
				this.setVersion( (Integer)r.getValue(RoleMenuMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}