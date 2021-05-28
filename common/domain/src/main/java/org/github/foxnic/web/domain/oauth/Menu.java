package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_MENU;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 10:53:35
 * @sign B353D9815CD74D3F3D99DB3E7FD2D718
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
	 * 图标：图标
	*/
	@ApiModelProperty(required = false,value="图标" , notes = "图标")
	private String icon;
	
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
	@ApiModelProperty(required = false,value="菜单类型" , notes = "菜单类型")
	private Integer type;
	
	/**
	 * 模版路径：模版路径
	*/
	@ApiModelProperty(required = false,value="模版路径" , notes = "模版路径")
	private String path;
	
	/**
	 * 路由地址：路由地址
	*/
	@ApiModelProperty(required = false,value="路由地址" , notes = "路由地址")
	private String url;
	
	/**
	 * 上级ID：上级ID
	*/
	@ApiModelProperty(required = false,value="上级ID" , notes = "上级ID")
	private Integer parentId;
	
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
	private Integer deleted;
	
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
	 * 添加 ID
	 * @param id ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 图标<br>
	 * 属性说明 : 图标
	 * @return 图标
	*/
	public String getIcon() {
		return icon;
	}
	
	/**
	 * 设置 图标
	 * @param icon 图标
	 * @return 当前对象
	*/
	public Menu setIcon(String icon) {
		this.icon=icon;
		return this;
	}
	
	/**
	 * 添加 图标
	 * @param icon 图标
	 * @return 当前对象
	*/
	
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
	 * 添加 样式
	 * @param css 样式
	 * @return 当前对象
	*/
	
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
	 * 添加 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	
	/**
	 * 获得 菜单类型<br>
	 * 属性说明 : 菜单类型
	 * @return 菜单类型
	*/
	public Integer getType() {
		return type;
	}
	
	/**
	 * 设置 菜单类型
	 * @param type 菜单类型
	 * @return 当前对象
	*/
	public Menu setType(Integer type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 添加 菜单类型
	 * @param type 菜单类型
	 * @return 当前对象
	*/
	
	/**
	 * 获得 模版路径<br>
	 * 属性说明 : 模版路径
	 * @return 模版路径
	*/
	public String getPath() {
		return path;
	}
	
	/**
	 * 设置 模版路径
	 * @param path 模版路径
	 * @return 当前对象
	*/
	public Menu setPath(String path) {
		this.path=path;
		return this;
	}
	
	/**
	 * 添加 模版路径
	 * @param path 模版路径
	 * @return 当前对象
	*/
	
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
	 * 添加 路由地址
	 * @param url 路由地址
	 * @return 当前对象
	*/
	
	/**
	 * 获得 上级ID<br>
	 * 属性说明 : 上级ID
	 * @return 上级ID
	*/
	public Integer getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 上级ID
	 * @param parentId 上级ID
	 * @return 当前对象
	*/
	public Menu setParentId(Integer parentId) {
		this.parentId=parentId;
		return this;
	}
	
	/**
	 * 添加 上级ID
	 * @param parentId 上级ID
	 * @return 当前对象
	*/
	
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
	public Menu setCreateBy(Long createBy) {
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
	public Menu setCreateTime(Date createTime) {
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
	public Long getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public Menu setUpdateBy(Long updateBy) {
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
	public Menu setUpdateTime(Date updateTime) {
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
	public Menu setDeleted(Integer deleted) {
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
	public Long getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public Menu setDeleteBy(Long deleteBy) {
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
	public Menu setDeleteTime(Date deleteTime) {
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
	public Menu setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/

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