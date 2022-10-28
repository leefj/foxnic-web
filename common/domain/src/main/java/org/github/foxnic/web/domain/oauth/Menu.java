package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_MENU;
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
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 菜单
 * <p>菜单 , 数据表 sys_menu 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 15:18:33
 * @sign 02BAA553C35E43DA7B5DEDBFBD921A85
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_menu")
@ApiModel(description = "菜单 ; 菜单 , 数据表 sys_menu 的PO类型")
public class Menu extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_MENU.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "463397133957988352")
	private String id;
	
	/**
	 * 批次号：自动生成时的批次号
	*/
	@ApiModelProperty(required = false,value="批次号" , notes = "自动生成时的批次号")
	private String batchId;
	
	/**
	 * 权限：权限标识
	*/
	@ApiModelProperty(required = false,value="权限" , notes = "权限标识" , example = "f5-2746f65498-2739")
	private String authority;
	
	/**
	 * 是否隐藏：是否隐藏
	*/
	@ApiModelProperty(required = true,value="是否隐藏" , notes = "是否隐藏" , example = "0")
	private Integer hidden;
	
	/**
	 * 样式：样式
	*/
	@ApiModelProperty(required = false,value="样式" , notes = "样式" , example = "mdi mdi-account-box")
	private String css;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签" , example = "系统管理")
	private String label;
	
	/**
	 * 菜单类型：菜单类型
	*/
	@ApiModelProperty(required = false,value="菜单类型" , notes = "菜单类型" , example = "page")
	private String type;
	
	/**
	 * 菜单路径的资源：菜单路径的资源
	*/
	@ApiModelProperty(required = false,value="菜单路径的资源" , notes = "菜单路径的资源")
	private String pathResourceId;
	
	/**
	 * 路由地址：路由地址
	*/
	@ApiModelProperty(required = false,value="路由地址" , notes = "路由地址")
	private String url;
	
	/**
	 * 页面参数：页面参数
	*/
	@ApiModelProperty(required = false,value="页面参数" , notes = "页面参数")
	private String params;
	
	/**
	 * 上级ID：上级ID
	*/
	@ApiModelProperty(required = false,value="上级ID" , notes = "上级ID" , example = "0")
	private String parentId;
	
	/**
	 * 动态控制类：动态控制类
	*/
	@ApiModelProperty(required = false,value="动态控制类" , notes = "动态控制类")
	private String dynamicHandler;
	
	/**
	 * 层级路径：层级路径
	*/
	@ApiModelProperty(required = false,value="层级路径" , notes = "层级路径" , example = "463397133957988352")
	private String hierarchy;
	
	/**
	 * 显示顺序：显示顺序
	*/
	@ApiModelProperty(required = true,value="显示顺序" , notes = "显示顺序" , example = "1")
	private Integer sort;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2021-07-02 05:34:46")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-03-14 02:58:46")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "60")
	private Integer version;
	
	/**
	 * 路径资源
	*/
	@ApiModelProperty(required = false,value="路径资源" , notes = "")
	private Resourze pathResource;
	
	/**
	 * 菜单包含的资源清单
	*/
	@ApiModelProperty(required = false,value="菜单包含的资源清单" , notes = "")
	private List<Resourze> resources;
	
	/**
	 * 上级菜单
	*/
	@ApiModelProperty(required = false,value="上级菜单" , notes = "")
	private Menu parent;
	
	/**
	 * 页面路径
	*/
	@ApiModelProperty(required = false,value="页面路径" , notes = "")
	private String path;
	
	/**
	 * 资源ID清单
	*/
	@ApiModelProperty(required = false,value="资源ID清单" , notes = "")
	private List<String> resourceIds;
	
	/**
	 * 祖先名称路径：用斜杠隔开
	*/
	@ApiModelProperty(required = false,value="祖先名称路径" , notes = "用斜杠隔开")
	private String ancestorsNamePath;
	
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
	public Menu setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 批次号<br>
	 * 自动生成时的批次号
	 * @return 批次号
	*/
	public String getBatchId() {
		return batchId;
	}
	
	/**
	 * 设置 批次号
	 * @param batchId 批次号
	 * @return 当前对象
	*/
	public Menu setBatchId(String batchId) {
		this.batchId=batchId;
		return this;
	}
	
	/**
	 * 获得 权限<br>
	 * 权限标识
	 * @return 权限
	*/
	public String getAuthority() {
		return authority;
	}
	
	/**
	 * 设置 权限
	 * @param authority 权限
	 * @return 当前对象
	*/
	public Menu setAuthority(String authority) {
		this.authority=authority;
		return this;
	}
	
	/**
	 * 获得 是否隐藏<br>
	 * 是否隐藏
	 * @return 是否隐藏
	*/
	public Integer getHidden() {
		return hidden;
	}
	
	/**
	 * 设置 是否隐藏
	 * @param hidden 是否隐藏
	 * @return 当前对象
	*/
	public Menu setHidden(Integer hidden) {
		this.hidden=hidden;
		return this;
	}
	
	/**
	 * 获得 样式<br>
	 * 样式
	 * @return 样式
	*/
	public String getCss() {
		return css;
	}
	
	/**
	 * 设置 样式
	 * @param css 样式
	 * @return 当前对象
	*/
	public Menu setCss(String css) {
		this.css=css;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public Menu setLabel(String label) {
		this.label=label;
		return this;
	}
	
	/**
	 * 获得 菜单类型<br>
	 * 菜单类型
	 * @return 菜单类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 菜单类型
	 * @param type 菜单类型
	 * @return 当前对象
	*/
	public Menu setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 菜单路径的资源<br>
	 * 菜单路径的资源
	 * @return 菜单路径的资源
	*/
	public String getPathResourceId() {
		return pathResourceId;
	}
	
	/**
	 * 设置 菜单路径的资源
	 * @param pathResourceId 菜单路径的资源
	 * @return 当前对象
	*/
	public Menu setPathResourceId(String pathResourceId) {
		this.pathResourceId=pathResourceId;
		return this;
	}
	
	/**
	 * 获得 路由地址<br>
	 * 路由地址
	 * @return 路由地址
	*/
	public String getUrl() {
		return url;
	}
	
	/**
	 * 设置 路由地址
	 * @param url 路由地址
	 * @return 当前对象
	*/
	public Menu setUrl(String url) {
		this.url=url;
		return this;
	}
	
	/**
	 * 获得 页面参数<br>
	 * 页面参数
	 * @return 页面参数
	*/
	public String getParams() {
		return params;
	}
	
	/**
	 * 设置 页面参数
	 * @param params 页面参数
	 * @return 当前对象
	*/
	public Menu setParams(String params) {
		this.params=params;
		return this;
	}
	
	/**
	 * 获得 上级ID<br>
	 * 上级ID
	 * @return 上级ID
	*/
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 上级ID
	 * @param parentId 上级ID
	 * @return 当前对象
	*/
	public Menu setParentId(String parentId) {
		this.parentId=parentId;
		return this;
	}
	
	/**
	 * 获得 动态控制类<br>
	 * 动态控制类
	 * @return 动态控制类
	*/
	public String getDynamicHandler() {
		return dynamicHandler;
	}
	
	/**
	 * 设置 动态控制类
	 * @param dynamicHandler 动态控制类
	 * @return 当前对象
	*/
	public Menu setDynamicHandler(String dynamicHandler) {
		this.dynamicHandler=dynamicHandler;
		return this;
	}
	
	/**
	 * 获得 层级路径<br>
	 * 层级路径
	 * @return 层级路径
	*/
	public String getHierarchy() {
		return hierarchy;
	}
	
	/**
	 * 设置 层级路径
	 * @param hierarchy 层级路径
	 * @return 当前对象
	*/
	public Menu setHierarchy(String hierarchy) {
		this.hierarchy=hierarchy;
		return this;
	}
	
	/**
	 * 获得 显示顺序<br>
	 * 显示顺序
	 * @return 显示顺序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 显示顺序
	 * @param sort 显示顺序
	 * @return 当前对象
	*/
	public Menu setSort(Integer sort) {
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
	public Menu setCreateBy(String createBy) {
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
	public Menu setCreateTime(Date createTime) {
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
	public Menu setUpdateBy(String updateBy) {
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
	public Menu setUpdateTime(Date updateTime) {
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
	public Menu setDeleted(Integer deleted) {
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
	public Menu setDeleted(Boolean deletedBool) {
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
	public Menu setDeleteBy(String deleteBy) {
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
	public Menu setDeleteTime(Date deleteTime) {
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
	public Menu setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 路径资源<br>
	 * @return 路径资源
	*/
	public Resourze getPathResource() {
		return pathResource;
	}
	
	/**
	 * 设置 路径资源
	 * @param pathResource 路径资源
	 * @return 当前对象
	*/
	public Menu setPathResource(Resourze pathResource) {
		this.pathResource=pathResource;
		return this;
	}
	
	/**
	 * 获得 菜单包含的资源清单<br>
	 * @return 菜单包含的资源清单
	*/
	public List<Resourze> getResources() {
		return resources;
	}
	
	/**
	 * 设置 菜单包含的资源清单
	 * @param resources 菜单包含的资源清单
	 * @return 当前对象
	*/
	public Menu setResources(List<Resourze> resources) {
		this.resources=resources;
		return this;
	}
	
	/**
	 * 添加 菜单包含的资源清单
	 * @param resource 菜单包含的资源清单
	 * @return 当前对象
	*/
	public Menu addResource(Resourze... resource) {
		if(this.resources==null) resources=new ArrayList<>();
		this.resources.addAll(Arrays.asList(resource));
		return this;
	}
	
	/**
	 * 获得 上级菜单<br>
	 * @return 上级菜单
	*/
	public Menu getParent() {
		return parent;
	}
	
	/**
	 * 设置 上级菜单
	 * @param parent 上级菜单
	 * @return 当前对象
	*/
	public Menu setParent(Menu parent) {
		this.parent=parent;
		return this;
	}
	
	/**
	 * 获得 页面路径<br>
	 * @return 页面路径
	*/
	public String getPath() {
		return path;
	}
	
	/**
	 * 设置 页面路径
	 * @param path 页面路径
	 * @return 当前对象
	*/
	public Menu setPath(String path) {
		this.path=path;
		return this;
	}
	
	/**
	 * 获得 资源ID清单<br>
	 * @return 资源ID清单
	*/
	public List<String> getResourceIds() {
		return resourceIds;
	}
	
	/**
	 * 设置 资源ID清单
	 * @param resourceIds 资源ID清单
	 * @return 当前对象
	*/
	public Menu setResourceIds(List<String> resourceIds) {
		this.resourceIds=resourceIds;
		return this;
	}
	
	/**
	 * 添加 资源ID清单
	 * @param resourceId 资源ID清单
	 * @return 当前对象
	*/
	public Menu addResourceId(String... resourceId) {
		if(this.resourceIds==null) resourceIds=new ArrayList<>();
		this.resourceIds.addAll(Arrays.asList(resourceId));
		return this;
	}
	
	/**
	 * 获得 祖先名称路径<br>
	 * 用斜杠隔开
	 * @return 祖先名称路径
	*/
	public String getAncestorsNamePath() {
		return ancestorsNamePath;
	}
	
	/**
	 * 设置 祖先名称路径
	 * @param ancestorsNamePath 祖先名称路径
	 * @return 当前对象
	*/
	public Menu setAncestorsNamePath(String ancestorsNamePath) {
		this.ancestorsNamePath=ancestorsNamePath;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Menu , 转换好的 Menu 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Menu , 转换好的 PoJo 对象
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
	public Menu clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Menu duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.MenuMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.MenuMeta.$$proxy$$();
		inst.setCss(this.getCss());
		inst.setHidden(this.getHidden());
		inst.setHierarchy(this.getHierarchy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setSort(this.getSort());
		inst.setBatchId(this.getBatchId());
		inst.setType(this.getType());
		inst.setParams(this.getParams());
		inst.setVersion(this.getVersion());
		inst.setUrl(this.getUrl());
		inst.setParentId(this.getParentId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAuthority(this.getAuthority());
		inst.setDynamicHandler(this.getDynamicHandler());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setPathResourceId(this.getPathResourceId());
		if(all) {
			inst.setParent(this.getParent());
			inst.setPath(this.getPath());
			inst.setPathResource(this.getPathResource());
			inst.setResources(this.getResources());
			inst.setAncestorsNamePath(this.getAncestorsNamePath());
			inst.setResourceIds(this.getResourceIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Menu clone(boolean deep) {
		return EntityContext.clone(Menu.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Menu
	 * @param menuMap 包含实体信息的 Map 对象
	 * @return Menu , 转换好的的 Menu 对象
	*/
	@Transient
	public static Menu createFrom(Map<String,Object> menuMap) {
		if(menuMap==null) return null;
		Menu po = create();
		EntityContext.copyProperties(po,menuMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Menu
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Menu , 转换好的的 Menu 对象
	*/
	@Transient
	public static Menu createFrom(Object pojo) {
		if(pojo==null) return null;
		Menu po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Menu，等同于 new
	 * @return Menu 对象
	*/
	@Transient
	public static Menu create() {
		return new org.github.foxnic.web.domain.oauth.meta.MenuMeta.$$proxy$$();
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
			this.setCss(DataParser.parse(String.class, map.get(MenuMeta.CSS)));
			this.setHidden(DataParser.parse(Integer.class, map.get(MenuMeta.HIDDEN)));
			this.setHierarchy(DataParser.parse(String.class, map.get(MenuMeta.HIERARCHY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MenuMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(MenuMeta.LABEL)));
			this.setSort(DataParser.parse(Integer.class, map.get(MenuMeta.SORT)));
			this.setBatchId(DataParser.parse(String.class, map.get(MenuMeta.BATCH_ID)));
			this.setType(DataParser.parse(String.class, map.get(MenuMeta.TYPE)));
			this.setParams(DataParser.parse(String.class, map.get(MenuMeta.PARAMS)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MenuMeta.VERSION)));
			this.setUrl(DataParser.parse(String.class, map.get(MenuMeta.URL)));
			this.setParentId(DataParser.parse(String.class, map.get(MenuMeta.PARENT_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MenuMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MenuMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MenuMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MenuMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MenuMeta.DELETE_TIME)));
			this.setAuthority(DataParser.parse(String.class, map.get(MenuMeta.AUTHORITY)));
			this.setDynamicHandler(DataParser.parse(String.class, map.get(MenuMeta.DYNAMIC_HANDLER)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MenuMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MenuMeta.ID)));
			this.setPathResourceId(DataParser.parse(String.class, map.get(MenuMeta.PATH_RESOURCE_ID)));
			// others
			this.setParent(DataParser.parse(Menu.class, map.get(MenuMeta.PARENT)));
			this.setPath(DataParser.parse(String.class, map.get(MenuMeta.PATH)));
			this.setPathResource(DataParser.parse(Resourze.class, map.get(MenuMeta.PATH_RESOURCE)));
			this.setAncestorsNamePath(DataParser.parse(String.class, map.get(MenuMeta.ANCESTORS_NAME_PATH)));
			return true;
		} else {
			try {
				this.setCss( (String)map.get(MenuMeta.CSS));
				this.setHidden( (Integer)map.get(MenuMeta.HIDDEN));
				this.setHierarchy( (String)map.get(MenuMeta.HIERARCHY));
				this.setUpdateTime( (Date)map.get(MenuMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(MenuMeta.LABEL));
				this.setSort( (Integer)map.get(MenuMeta.SORT));
				this.setBatchId( (String)map.get(MenuMeta.BATCH_ID));
				this.setType( (String)map.get(MenuMeta.TYPE));
				this.setParams( (String)map.get(MenuMeta.PARAMS));
				this.setVersion( (Integer)map.get(MenuMeta.VERSION));
				this.setUrl( (String)map.get(MenuMeta.URL));
				this.setParentId( (String)map.get(MenuMeta.PARENT_ID));
				this.setCreateBy( (String)map.get(MenuMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MenuMeta.DELETED));
				this.setCreateTime( (Date)map.get(MenuMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MenuMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MenuMeta.DELETE_TIME));
				this.setAuthority( (String)map.get(MenuMeta.AUTHORITY));
				this.setDynamicHandler( (String)map.get(MenuMeta.DYNAMIC_HANDLER));
				this.setDeleteBy( (String)map.get(MenuMeta.DELETE_BY));
				this.setId( (String)map.get(MenuMeta.ID));
				this.setPathResourceId( (String)map.get(MenuMeta.PATH_RESOURCE_ID));
				// others
				this.setParent( (Menu)map.get(MenuMeta.PARENT));
				this.setPath( (String)map.get(MenuMeta.PATH));
				this.setPathResource( (Resourze)map.get(MenuMeta.PATH_RESOURCE));
				this.setAncestorsNamePath( (String)map.get(MenuMeta.ANCESTORS_NAME_PATH));
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
			this.setCss(DataParser.parse(String.class, r.getValue(MenuMeta.CSS)));
			this.setHidden(DataParser.parse(Integer.class, r.getValue(MenuMeta.HIDDEN)));
			this.setHierarchy(DataParser.parse(String.class, r.getValue(MenuMeta.HIERARCHY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MenuMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(MenuMeta.LABEL)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(MenuMeta.SORT)));
			this.setBatchId(DataParser.parse(String.class, r.getValue(MenuMeta.BATCH_ID)));
			this.setType(DataParser.parse(String.class, r.getValue(MenuMeta.TYPE)));
			this.setParams(DataParser.parse(String.class, r.getValue(MenuMeta.PARAMS)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MenuMeta.VERSION)));
			this.setUrl(DataParser.parse(String.class, r.getValue(MenuMeta.URL)));
			this.setParentId(DataParser.parse(String.class, r.getValue(MenuMeta.PARENT_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MenuMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MenuMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MenuMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MenuMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MenuMeta.DELETE_TIME)));
			this.setAuthority(DataParser.parse(String.class, r.getValue(MenuMeta.AUTHORITY)));
			this.setDynamicHandler(DataParser.parse(String.class, r.getValue(MenuMeta.DYNAMIC_HANDLER)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MenuMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MenuMeta.ID)));
			this.setPathResourceId(DataParser.parse(String.class, r.getValue(MenuMeta.PATH_RESOURCE_ID)));
			return true;
		} else {
			try {
				this.setCss( (String)r.getValue(MenuMeta.CSS));
				this.setHidden( (Integer)r.getValue(MenuMeta.HIDDEN));
				this.setHierarchy( (String)r.getValue(MenuMeta.HIERARCHY));
				this.setUpdateTime( (Date)r.getValue(MenuMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(MenuMeta.LABEL));
				this.setSort( (Integer)r.getValue(MenuMeta.SORT));
				this.setBatchId( (String)r.getValue(MenuMeta.BATCH_ID));
				this.setType( (String)r.getValue(MenuMeta.TYPE));
				this.setParams( (String)r.getValue(MenuMeta.PARAMS));
				this.setVersion( (Integer)r.getValue(MenuMeta.VERSION));
				this.setUrl( (String)r.getValue(MenuMeta.URL));
				this.setParentId( (String)r.getValue(MenuMeta.PARENT_ID));
				this.setCreateBy( (String)r.getValue(MenuMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MenuMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MenuMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MenuMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MenuMeta.DELETE_TIME));
				this.setAuthority( (String)r.getValue(MenuMeta.AUTHORITY));
				this.setDynamicHandler( (String)r.getValue(MenuMeta.DYNAMIC_HANDLER));
				this.setDeleteBy( (String)r.getValue(MenuMeta.DELETE_BY));
				this.setId( (String)r.getValue(MenuMeta.ID));
				this.setPathResourceId( (String)r.getValue(MenuMeta.PATH_RESOURCE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}