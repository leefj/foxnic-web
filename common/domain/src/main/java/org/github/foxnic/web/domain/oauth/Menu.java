package org.github.foxnic.web.domain.oauth;

import java.util.List;
import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_MENU;
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
 * @since 2021-07-05 16:52:36
 * @sign 743A723F6E05153693E8885F06AE769B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_menu")
public class Menu extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_MENU.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private String id;
	
	/**
	 * 批次号：自动生成时的批次号
	*/
	@ApiModelProperty(required = false,value="批次号" , notes = "自动生成时的批次号")
	private String batchId;
	
	/**
	 * 权限：权限标识
	*/
	@ApiModelProperty(required = true,value="权限" , notes = "权限标识")
	private String authority;
	
	/**
	 * 是否隐藏：是否隐藏
	*/
	@ApiModelProperty(required = true,value="是否隐藏" , notes = "是否隐藏")
	private Integer hidden;
	
	/**
	 * 样式：样式
	*/
	@ApiModelProperty(required = false,value="样式" , notes = "样式")
	private String css;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String label;
	
	/**
	 * 菜单类型：菜单类型
	*/
	@ApiModelProperty(required = true,value="菜单类型" , notes = "菜单类型")
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
	 * 上级ID：上级ID
	*/
	@ApiModelProperty(required = false,value="上级ID" , notes = "上级ID")
	private String parentId;
	
	/**
	 * 显示顺序：显示顺序
	*/
	@ApiModelProperty(required = true,value="显示顺序" , notes = "显示顺序")
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
	public Menu setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 批次号<br>
	 * 属性说明 : 自动生成时的批次号
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
	 * 属性说明 : 权限标识
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
	 * 属性说明 : 是否隐藏
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
	 * 属性说明 : 样式
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
	 * 属性说明 : 标签
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
	 * 属性说明 : 菜单类型
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
	 * 属性说明 : 菜单路径的资源
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
	 * 属性说明 : 路由地址
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
	 * 获得 上级ID<br>
	 * 属性说明 : 上级ID
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
	 * 获得 显示顺序<br>
	 * 属性说明 : 显示顺序
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
	public Menu setCreateBy(String createBy) {
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
	public Menu setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
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
	public Menu setUpdateBy(String updateBy) {
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
	public Menu setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
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
	public Menu setDeleted(Integer deleted) {
		this.deleted=deleted;
		return this;
	}
	
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
	public Menu setDeleteBy(String deleteBy) {
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
	public Menu setDeleteTime(Date deleteTime) {
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
	public Menu addResource(Resourze resource) {
		if(this.resources==null) resources=new ArrayList<>();
		this.resources.add(resource);
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
	public Menu addResourceId(String resourceId) {
		if(this.resourceIds==null) resourceIds=new ArrayList<>();
		this.resourceIds.add(resourceId);
		return this;
	}
	
	/**
	 * 获得 祖先名称路径<br>
	 * 属性说明 : 用斜杠隔开
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
	 * 将 Map 转换成 Menu
	 * @param menuMap 包含实体信息的 Map 对象
	 * @return Menu , 转换好的的 Menu 对象
	*/
	@Transient
	public static Menu createFrom(Map<String,Object> menuMap) {
		if(menuMap==null) return null;
		Menu po = EntityContext.create(Menu.class, menuMap);
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
		Menu po = EntityContext.create(Menu.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Menu，等同于 new
	 * @return Menu 对象
	*/
	@Transient
	public static Menu create() {
		return new Menu();
	}
}