package org.github.foxnic.web.domain.oauth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;
import org.github.foxnic.web.domain.oauth.meta.MenuVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 菜单VO类型
 * <p>菜单 , 数据表 sys_menu 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-02-08 09:44:31
 * @sign DAE21D06C3DD21FD5D831DD1D01962FB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "菜单VO类型 ; 菜单 , 数据表 sys_menu 的通用VO类型" , parent = Menu.class)
public class MenuVO extends Menu {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页码
	*/
	@ApiModelProperty(required = false,value="页码" , notes = "")
	private Integer pageIndex;
	
	/**
	 * 分页大小
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "")
	private Integer pageSize;
	
	/**
	 * 搜索字段
	*/
	@ApiModelProperty(required = false,value="搜索字段" , notes = "")
	private String searchField;
	
	/**
	 * 模糊搜索字段
	*/
	@ApiModelProperty(required = false,value="模糊搜索字段" , notes = "")
	private String fuzzyField;
	
	/**
	 * 搜索的值
	*/
	@ApiModelProperty(required = false,value="搜索的值" , notes = "")
	private String searchValue;
	
	/**
	 * 已修改字段
	*/
	@ApiModelProperty(required = false,value="已修改字段" , notes = "")
	private List<String> dirtyFields;
	
	/**
	 * 排序字段
	*/
	@ApiModelProperty(required = false,value="排序字段" , notes = "")
	private String sortField;
	
	/**
	 * 排序方式
	*/
	@ApiModelProperty(required = false,value="排序方式" , notes = "")
	private String sortType;
	
	/**
	 * 数据来源：前端指定不同的来源，后端可按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端可按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
	/**
	 * 请求动作：前端指定不同的Action，后端可Action执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="请求动作" , notes = "前端指定不同的Action，后端可Action执行不同的逻辑")
	private String requestAction;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 菜单角色：从前端传入，指定勾选指定角色的菜单
	*/
	@ApiModelProperty(required = false,value="菜单角色" , notes = "从前端传入，指定勾选指定角色的菜单")
	private String roleId;
	
	/**
	 * 是否加载所有子孙节点：1：是；0：否
	*/
	@ApiModelProperty(required = false,value="是否加载所有子孙节点" , notes = "1：是；0：否")
	private Integer isLoadAllDescendants;
	
	/**
	 * 获得 页码<br>
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public MenuVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public MenuVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 搜索字段<br>
	 * @return 搜索字段
	*/
	public String getSearchField() {
		return searchField;
	}
	
	/**
	 * 设置 搜索字段
	 * @param searchField 搜索字段
	 * @return 当前对象
	*/
	public MenuVO setSearchField(String searchField) {
		this.searchField=searchField;
		return this;
	}
	
	/**
	 * 获得 模糊搜索字段<br>
	 * @return 模糊搜索字段
	*/
	public String getFuzzyField() {
		return fuzzyField;
	}
	
	/**
	 * 设置 模糊搜索字段
	 * @param fuzzyField 模糊搜索字段
	 * @return 当前对象
	*/
	public MenuVO setFuzzyField(String fuzzyField) {
		this.fuzzyField=fuzzyField;
		return this;
	}
	
	/**
	 * 获得 搜索的值<br>
	 * @return 搜索的值
	*/
	public String getSearchValue() {
		return searchValue;
	}
	
	/**
	 * 设置 搜索的值
	 * @param searchValue 搜索的值
	 * @return 当前对象
	*/
	public MenuVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
	/**
	 * 获得 已修改字段<br>
	 * @return 已修改字段
	*/
	public List<String> getDirtyFields() {
		return dirtyFields;
	}
	
	/**
	 * 设置 已修改字段
	 * @param dirtyFields 已修改字段
	 * @return 当前对象
	*/
	public MenuVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public MenuVO addDirtyField(String... dirtyField) {
		if(this.dirtyFields==null) dirtyFields=new ArrayList<>();
		this.dirtyFields.addAll(Arrays.asList(dirtyField));
		return this;
	}
	
	/**
	 * 获得 排序字段<br>
	 * @return 排序字段
	*/
	public String getSortField() {
		return sortField;
	}
	
	/**
	 * 设置 排序字段
	 * @param sortField 排序字段
	 * @return 当前对象
	*/
	public MenuVO setSortField(String sortField) {
		this.sortField=sortField;
		return this;
	}
	
	/**
	 * 获得 排序方式<br>
	 * @return 排序方式
	*/
	public String getSortType() {
		return sortType;
	}
	
	/**
	 * 设置 排序方式
	 * @param sortType 排序方式
	 * @return 当前对象
	*/
	public MenuVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端可按来源执行不同的逻辑
	 * @return 数据来源
	*/
	public String getDataOrigin() {
		return dataOrigin;
	}
	
	/**
	 * 设置 数据来源
	 * @param dataOrigin 数据来源
	 * @return 当前对象
	*/
	public MenuVO setDataOrigin(String dataOrigin) {
		this.dataOrigin=dataOrigin;
		return this;
	}
	
	/**
	 * 获得 查询逻辑<br>
	 * 默认and，可指定 or 
	 * @return 查询逻辑
	*/
	public String getQueryLogic() {
		return queryLogic;
	}
	
	/**
	 * 设置 查询逻辑
	 * @param queryLogic 查询逻辑
	 * @return 当前对象
	*/
	public MenuVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
		return this;
	}
	
	/**
	 * 获得 请求动作<br>
	 * 前端指定不同的Action，后端可Action执行不同的逻辑
	 * @return 请求动作
	*/
	public String getRequestAction() {
		return requestAction;
	}
	
	/**
	 * 设置 请求动作
	 * @param requestAction 请求动作
	 * @return 当前对象
	*/
	public MenuVO setRequestAction(String requestAction) {
		this.requestAction=requestAction;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public MenuVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public MenuVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	
	/**
	 * 获得 菜单角色<br>
	 * 从前端传入，指定勾选指定角色的菜单
	 * @return 菜单角色
	*/
	public String getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置 菜单角色
	 * @param roleId 菜单角色
	 * @return 当前对象
	*/
	public MenuVO setRoleId(String roleId) {
		this.roleId=roleId;
		return this;
	}
	
	/**
	 * 获得 是否加载所有子孙节点<br>
	 * 1：是；0：否
	 * @return 是否加载所有子孙节点
	*/
	public Integer getIsLoadAllDescendants() {
		return isLoadAllDescendants;
	}
	
	/**
	 * 设置 是否加载所有子孙节点
	 * @param isLoadAllDescendants 是否加载所有子孙节点
	 * @return 当前对象
	*/
	public MenuVO setIsLoadAllDescendants(Integer isLoadAllDescendants) {
		this.isLoadAllDescendants=isLoadAllDescendants;
		return this;
	}
	@Transient
	private transient CompositeParameter $compositeParameter;
	/**
	 * 获得解析后的复合查询参数
	 */
	@Transient
	public CompositeParameter getCompositeParameter() {
		if($compositeParameter!=null) return  $compositeParameter;
		$compositeParameter=new CompositeParameter(this.getSearchValue(),BeanUtil.toMap(this));
		return  $compositeParameter;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MenuVO , 转换好的 MenuVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MenuVO , 转换好的 PoJo 对象
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
	public MenuVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MenuVO duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.MenuVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.MenuVOMeta.$$proxy$$();
		inst.setCss(this.getCss());
		inst.setNotes(this.getNotes());
		inst.setHidden(this.getHidden());
		inst.setBatchId(this.getBatchId());
		inst.setType(this.getType());
		inst.setOpenType(this.getOpenType());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setExtraUrl(this.getExtraUrl());
		inst.setId(this.getId());
		inst.setHierarchy(this.getHierarchy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setSort(this.getSort());
		inst.setParams(this.getParams());
		inst.setVersion(this.getVersion());
		inst.setUrl(this.getUrl());
		inst.setParentId(this.getParentId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAuthority(this.getAuthority());
		inst.setDynamicHandler(this.getDynamicHandler());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setLinkType(this.getLinkType());
		inst.setPathResourceId(this.getPathResourceId());
		if(all) {
			inst.setForks(this.getForks());
			inst.setParent(this.getParent());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setInModuleRange(this.isInModuleRange());
			inst.setRoleId(this.getRoleId());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPathResource(this.getPathResource());
			inst.setResources(this.getResources());
			inst.setPageSize(this.getPageSize());
			inst.setIsLoadAllDescendants(this.getIsLoadAllDescendants());
			inst.setPath(this.getPath());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setAncestorsNamePath(this.getAncestorsNamePath());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
			inst.setResourceIds(this.getResourceIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MenuVO clone(boolean deep) {
		return EntityContext.clone(MenuVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MenuVO
	 * @param menuMap 包含实体信息的 Map 对象
	 * @return MenuVO , 转换好的的 Menu 对象
	*/
	@Transient
	public static MenuVO createFrom(Map<String,Object> menuMap) {
		if(menuMap==null) return null;
		MenuVO vo = create();
		EntityContext.copyProperties(vo,menuMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 MenuVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MenuVO , 转换好的的 Menu 对象
	*/
	@Transient
	public static MenuVO createFrom(Object pojo) {
		if(pojo==null) return null;
		MenuVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 MenuVO，等同于 new
	 * @return MenuVO 对象
	*/
	@Transient
	public static MenuVO create() {
		return new org.github.foxnic.web.domain.oauth.meta.MenuVOMeta.$$proxy$$();
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
			this.setCss(DataParser.parse(String.class, map.get(MenuVOMeta.CSS)));
			this.setNotes(DataParser.parse(String.class, map.get(MenuVOMeta.NOTES)));
			this.setHidden(DataParser.parse(Integer.class, map.get(MenuVOMeta.HIDDEN)));
			this.setBatchId(DataParser.parse(String.class, map.get(MenuVOMeta.BATCH_ID)));
			this.setType(DataParser.parse(String.class, map.get(MenuVOMeta.TYPE)));
			this.setOpenType(DataParser.parse(String.class, map.get(MenuVOMeta.OPEN_TYPE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MenuVOMeta.UPDATE_BY)));
			this.setExtraUrl(DataParser.parse(String.class, map.get(MenuVOMeta.EXTRA_URL)));
			this.setId(DataParser.parse(String.class, map.get(MenuVOMeta.ID)));
			this.setHierarchy(DataParser.parse(String.class, map.get(MenuVOMeta.HIERARCHY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MenuVOMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(MenuVOMeta.LABEL)));
			this.setSort(DataParser.parse(Integer.class, map.get(MenuVOMeta.SORT)));
			this.setParams(DataParser.parse(String.class, map.get(MenuVOMeta.PARAMS)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MenuVOMeta.VERSION)));
			this.setUrl(DataParser.parse(String.class, map.get(MenuVOMeta.URL)));
			this.setParentId(DataParser.parse(String.class, map.get(MenuVOMeta.PARENT_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MenuVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MenuVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MenuVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MenuVOMeta.DELETE_TIME)));
			this.setAuthority(DataParser.parse(String.class, map.get(MenuVOMeta.AUTHORITY)));
			this.setDynamicHandler(DataParser.parse(String.class, map.get(MenuVOMeta.DYNAMIC_HANDLER)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MenuVOMeta.DELETE_BY)));
			this.setLinkType(DataParser.parse(String.class, map.get(MenuVOMeta.LINK_TYPE)));
			this.setPathResourceId(DataParser.parse(String.class, map.get(MenuVOMeta.PATH_RESOURCE_ID)));
			// others
			this.setParent(DataParser.parse(Menu.class, map.get(MenuVOMeta.PARENT)));
			this.setSearchField(DataParser.parse(String.class, map.get(MenuVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(MenuVOMeta.REQUEST_ACTION)));
			this.setInModuleRange(DataParser.parse(Boolean.class, map.get(MenuVOMeta.IS_IN_MODULE_RANGE)));
			this.setRoleId(DataParser.parse(String.class, map.get(MenuVOMeta.ROLE_ID)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(MenuVOMeta.FUZZY_FIELD)));
			this.setPathResource(DataParser.parse(Resourze.class, map.get(MenuVOMeta.PATH_RESOURCE)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(MenuVOMeta.PAGE_SIZE)));
			this.setIsLoadAllDescendants(DataParser.parse(Integer.class, map.get(MenuVOMeta.IS_LOAD_ALL_DESCENDANTS)));
			this.setPath(DataParser.parse(String.class, map.get(MenuVOMeta.PATH)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(MenuVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(MenuVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(MenuVOMeta.SORT_FIELD)));
			this.setAncestorsNamePath(DataParser.parse(String.class, map.get(MenuVOMeta.ANCESTORS_NAME_PATH)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(MenuVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(MenuVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(MenuVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setCss( (String)map.get(MenuVOMeta.CSS));
				this.setNotes( (String)map.get(MenuVOMeta.NOTES));
				this.setHidden( (Integer)map.get(MenuVOMeta.HIDDEN));
				this.setBatchId( (String)map.get(MenuVOMeta.BATCH_ID));
				this.setType( (String)map.get(MenuVOMeta.TYPE));
				this.setOpenType( (String)map.get(MenuVOMeta.OPEN_TYPE));
				this.setUpdateBy( (String)map.get(MenuVOMeta.UPDATE_BY));
				this.setExtraUrl( (String)map.get(MenuVOMeta.EXTRA_URL));
				this.setId( (String)map.get(MenuVOMeta.ID));
				this.setHierarchy( (String)map.get(MenuVOMeta.HIERARCHY));
				this.setUpdateTime( (Date)map.get(MenuVOMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(MenuVOMeta.LABEL));
				this.setSort( (Integer)map.get(MenuVOMeta.SORT));
				this.setParams( (String)map.get(MenuVOMeta.PARAMS));
				this.setVersion( (Integer)map.get(MenuVOMeta.VERSION));
				this.setUrl( (String)map.get(MenuVOMeta.URL));
				this.setParentId( (String)map.get(MenuVOMeta.PARENT_ID));
				this.setCreateBy( (String)map.get(MenuVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MenuVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(MenuVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(MenuVOMeta.DELETE_TIME));
				this.setAuthority( (String)map.get(MenuVOMeta.AUTHORITY));
				this.setDynamicHandler( (String)map.get(MenuVOMeta.DYNAMIC_HANDLER));
				this.setDeleteBy( (String)map.get(MenuVOMeta.DELETE_BY));
				this.setLinkType( (String)map.get(MenuVOMeta.LINK_TYPE));
				this.setPathResourceId( (String)map.get(MenuVOMeta.PATH_RESOURCE_ID));
				// others
				this.setParent( (Menu)map.get(MenuVOMeta.PARENT));
				this.setSearchField( (String)map.get(MenuVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(MenuVOMeta.REQUEST_ACTION));
				this.setInModuleRange( (Boolean)map.get(MenuVOMeta.IS_IN_MODULE_RANGE));
				this.setRoleId( (String)map.get(MenuVOMeta.ROLE_ID));
				this.setFuzzyField( (String)map.get(MenuVOMeta.FUZZY_FIELD));
				this.setPathResource( (Resourze)map.get(MenuVOMeta.PATH_RESOURCE));
				this.setPageSize( (Integer)map.get(MenuVOMeta.PAGE_SIZE));
				this.setIsLoadAllDescendants( (Integer)map.get(MenuVOMeta.IS_LOAD_ALL_DESCENDANTS));
				this.setPath( (String)map.get(MenuVOMeta.PATH));
				this.setPageIndex( (Integer)map.get(MenuVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(MenuVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(MenuVOMeta.SORT_FIELD));
				this.setAncestorsNamePath( (String)map.get(MenuVOMeta.ANCESTORS_NAME_PATH));
				this.setDataOrigin( (String)map.get(MenuVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(MenuVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(MenuVOMeta.SEARCH_VALUE));
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
			this.setCss(DataParser.parse(String.class, r.getValue(MenuVOMeta.CSS)));
			this.setNotes(DataParser.parse(String.class, r.getValue(MenuVOMeta.NOTES)));
			this.setHidden(DataParser.parse(Integer.class, r.getValue(MenuVOMeta.HIDDEN)));
			this.setBatchId(DataParser.parse(String.class, r.getValue(MenuVOMeta.BATCH_ID)));
			this.setType(DataParser.parse(String.class, r.getValue(MenuVOMeta.TYPE)));
			this.setOpenType(DataParser.parse(String.class, r.getValue(MenuVOMeta.OPEN_TYPE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MenuVOMeta.UPDATE_BY)));
			this.setExtraUrl(DataParser.parse(String.class, r.getValue(MenuVOMeta.EXTRA_URL)));
			this.setId(DataParser.parse(String.class, r.getValue(MenuVOMeta.ID)));
			this.setHierarchy(DataParser.parse(String.class, r.getValue(MenuVOMeta.HIERARCHY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MenuVOMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(MenuVOMeta.LABEL)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(MenuVOMeta.SORT)));
			this.setParams(DataParser.parse(String.class, r.getValue(MenuVOMeta.PARAMS)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MenuVOMeta.VERSION)));
			this.setUrl(DataParser.parse(String.class, r.getValue(MenuVOMeta.URL)));
			this.setParentId(DataParser.parse(String.class, r.getValue(MenuVOMeta.PARENT_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MenuVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MenuVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MenuVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MenuVOMeta.DELETE_TIME)));
			this.setAuthority(DataParser.parse(String.class, r.getValue(MenuVOMeta.AUTHORITY)));
			this.setDynamicHandler(DataParser.parse(String.class, r.getValue(MenuVOMeta.DYNAMIC_HANDLER)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MenuVOMeta.DELETE_BY)));
			this.setLinkType(DataParser.parse(String.class, r.getValue(MenuVOMeta.LINK_TYPE)));
			this.setPathResourceId(DataParser.parse(String.class, r.getValue(MenuVOMeta.PATH_RESOURCE_ID)));
			return true;
		} else {
			try {
				this.setCss( (String)r.getValue(MenuVOMeta.CSS));
				this.setNotes( (String)r.getValue(MenuVOMeta.NOTES));
				this.setHidden( (Integer)r.getValue(MenuVOMeta.HIDDEN));
				this.setBatchId( (String)r.getValue(MenuVOMeta.BATCH_ID));
				this.setType( (String)r.getValue(MenuVOMeta.TYPE));
				this.setOpenType( (String)r.getValue(MenuVOMeta.OPEN_TYPE));
				this.setUpdateBy( (String)r.getValue(MenuVOMeta.UPDATE_BY));
				this.setExtraUrl( (String)r.getValue(MenuVOMeta.EXTRA_URL));
				this.setId( (String)r.getValue(MenuVOMeta.ID));
				this.setHierarchy( (String)r.getValue(MenuVOMeta.HIERARCHY));
				this.setUpdateTime( (Date)r.getValue(MenuVOMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(MenuVOMeta.LABEL));
				this.setSort( (Integer)r.getValue(MenuVOMeta.SORT));
				this.setParams( (String)r.getValue(MenuVOMeta.PARAMS));
				this.setVersion( (Integer)r.getValue(MenuVOMeta.VERSION));
				this.setUrl( (String)r.getValue(MenuVOMeta.URL));
				this.setParentId( (String)r.getValue(MenuVOMeta.PARENT_ID));
				this.setCreateBy( (String)r.getValue(MenuVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MenuVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MenuVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(MenuVOMeta.DELETE_TIME));
				this.setAuthority( (String)r.getValue(MenuVOMeta.AUTHORITY));
				this.setDynamicHandler( (String)r.getValue(MenuVOMeta.DYNAMIC_HANDLER));
				this.setDeleteBy( (String)r.getValue(MenuVOMeta.DELETE_BY));
				this.setLinkType( (String)r.getValue(MenuVOMeta.LINK_TYPE));
				this.setPathResourceId( (String)r.getValue(MenuVOMeta.PATH_RESOURCE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}