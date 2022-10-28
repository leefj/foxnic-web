package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_MENU_RESOURCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.oauth.meta.MenuResourceMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 菜单资源关系
 * <p>菜单资源关系 , 数据表 sys_menu_resource 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 15:18:26
 * @sign 16DF333D0885522287E343B89154CD4A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_menu_resource")
@ApiModel(description = "菜单资源关系 ; 菜单资源关系 , 数据表 sys_menu_resource 的PO类型")
public class MenuResource extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_MENU_RESOURCE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "463397736838856704")
	private String id;
	
	/**
	 * 菜单ID：菜单ID
	*/
	@ApiModelProperty(required = false,value="菜单ID" , notes = "菜单ID" , example = "463397736541061120")
	private String menuId;
	
	/**
	 * 资源ID：资源ID
	*/
	@ApiModelProperty(required = false,value="资源ID" , notes = "资源ID" , example = "463397732921376768")
	private String resourceId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2021-07-02 05:37:10")
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
	public MenuResource setId(String id) {
		this.id=id;
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
	public MenuResource setMenuId(String menuId) {
		this.menuId=menuId;
		return this;
	}
	
	/**
	 * 获得 资源ID<br>
	 * 资源ID
	 * @return 资源ID
	*/
	public String getResourceId() {
		return resourceId;
	}
	
	/**
	 * 设置 资源ID
	 * @param resourceId 资源ID
	 * @return 当前对象
	*/
	public MenuResource setResourceId(String resourceId) {
		this.resourceId=resourceId;
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
	public MenuResource setCreateBy(String createBy) {
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
	public MenuResource setCreateTime(Date createTime) {
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
	public MenuResource setUpdateBy(String updateBy) {
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
	public MenuResource setUpdateTime(Date updateTime) {
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
	public MenuResource setDeleted(Integer deleted) {
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
	public MenuResource setDeleted(Boolean deletedBool) {
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
	public MenuResource setDeleteBy(String deleteBy) {
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
	public MenuResource setDeleteTime(Date deleteTime) {
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
	public MenuResource setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MenuResource , 转换好的 MenuResource 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MenuResource , 转换好的 PoJo 对象
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
	public MenuResource clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MenuResource duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.MenuResourceMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.MenuResourceMeta.$$proxy$$();
		inst.setResourceId(this.getResourceId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
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
	public MenuResource clone(boolean deep) {
		return EntityContext.clone(MenuResource.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MenuResource
	 * @param menuResourceMap 包含实体信息的 Map 对象
	 * @return MenuResource , 转换好的的 MenuResource 对象
	*/
	@Transient
	public static MenuResource createFrom(Map<String,Object> menuResourceMap) {
		if(menuResourceMap==null) return null;
		MenuResource po = create();
		EntityContext.copyProperties(po,menuResourceMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MenuResource
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MenuResource , 转换好的的 MenuResource 对象
	*/
	@Transient
	public static MenuResource createFrom(Object pojo) {
		if(pojo==null) return null;
		MenuResource po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MenuResource，等同于 new
	 * @return MenuResource 对象
	*/
	@Transient
	public static MenuResource create() {
		return new org.github.foxnic.web.domain.oauth.meta.MenuResourceMeta.$$proxy$$();
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
			this.setResourceId(DataParser.parse(String.class, map.get(MenuResourceMeta.RESOURCE_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MenuResourceMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MenuResourceMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MenuResourceMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MenuResourceMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MenuResourceMeta.DELETE_TIME)));
			this.setMenuId(DataParser.parse(String.class, map.get(MenuResourceMeta.MENU_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MenuResourceMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MenuResourceMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(MenuResourceMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MenuResourceMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setResourceId( (String)map.get(MenuResourceMeta.RESOURCE_ID));
				this.setCreateBy( (String)map.get(MenuResourceMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MenuResourceMeta.DELETED));
				this.setCreateTime( (Date)map.get(MenuResourceMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MenuResourceMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MenuResourceMeta.DELETE_TIME));
				this.setMenuId( (String)map.get(MenuResourceMeta.MENU_ID));
				this.setDeleteBy( (String)map.get(MenuResourceMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(MenuResourceMeta.UPDATE_TIME));
				this.setId( (String)map.get(MenuResourceMeta.ID));
				this.setVersion( (Integer)map.get(MenuResourceMeta.VERSION));
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
			this.setResourceId(DataParser.parse(String.class, r.getValue(MenuResourceMeta.RESOURCE_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MenuResourceMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MenuResourceMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MenuResourceMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MenuResourceMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MenuResourceMeta.DELETE_TIME)));
			this.setMenuId(DataParser.parse(String.class, r.getValue(MenuResourceMeta.MENU_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MenuResourceMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MenuResourceMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(MenuResourceMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MenuResourceMeta.VERSION)));
			return true;
		} else {
			try {
				this.setResourceId( (String)r.getValue(MenuResourceMeta.RESOURCE_ID));
				this.setCreateBy( (String)r.getValue(MenuResourceMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MenuResourceMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MenuResourceMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MenuResourceMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MenuResourceMeta.DELETE_TIME));
				this.setMenuId( (String)r.getValue(MenuResourceMeta.MENU_ID));
				this.setDeleteBy( (String)r.getValue(MenuResourceMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(MenuResourceMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(MenuResourceMeta.ID));
				this.setVersion( (Integer)r.getValue(MenuResourceMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}