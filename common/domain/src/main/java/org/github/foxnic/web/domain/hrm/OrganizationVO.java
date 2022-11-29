package org.github.foxnic.web.domain.hrm;

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
import org.github.foxnic.web.domain.hrm.meta.OrganizationVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 组织层级VO类型
 * <p>组织层级 , 数据表 hrm_organization 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-11-29 16:26:34
 * @sign 40F9CC5E1E30A130DF35A45E1A0D5F1C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "组织层级VO类型 ; 组织层级 , 数据表 hrm_organization 的通用VO类型" , parent = Organization.class)
public class OrganizationVO extends Organization {

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
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 是否加载所有子孙节点：1：是；0：否
	*/
	@ApiModelProperty(required = false,value="是否加载所有子孙节点" , notes = "1：是；0：否")
	private Integer isLoadAllDescendants;
	
	/**
	 * 根节点id或code：根节点id
	*/
	@ApiModelProperty(required = false,value="根节点id或code" , notes = "根节点id")
	private String root;
	
	/**
	 * 呈现模式：呈现模式:pos,org,com,dept
	*/
	@ApiModelProperty(required = false,value="呈现模式" , notes = "呈现模式:pos,org,com,dept")
	private String targetType;
	
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
	public OrganizationVO setPageIndex(Integer pageIndex) {
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
	public OrganizationVO setPageSize(Integer pageSize) {
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
	public OrganizationVO setSearchField(String searchField) {
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
	public OrganizationVO setFuzzyField(String fuzzyField) {
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
	public OrganizationVO setSearchValue(String searchValue) {
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
	public OrganizationVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public OrganizationVO addDirtyField(String... dirtyField) {
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
	public OrganizationVO setSortField(String sortField) {
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
	public OrganizationVO setSortType(String sortType) {
		this.sortType=sortType;
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
	public OrganizationVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public OrganizationVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
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
	public OrganizationVO setIsLoadAllDescendants(Integer isLoadAllDescendants) {
		this.isLoadAllDescendants=isLoadAllDescendants;
		return this;
	}
	
	/**
	 * 获得 根节点id或code<br>
	 * 根节点id
	 * @return 根节点id或code
	*/
	public String getRoot() {
		return root;
	}
	
	/**
	 * 设置 根节点id或code
	 * @param root 根节点id或code
	 * @return 当前对象
	*/
	public OrganizationVO setRoot(String root) {
		this.root=root;
		return this;
	}
	
	/**
	 * 获得 呈现模式<br>
	 * 呈现模式:pos,org,com,dept
	 * @return 呈现模式
	*/
	public String getTargetType() {
		return targetType;
	}
	
	/**
	 * 设置 呈现模式
	 * @param targetType 呈现模式
	 * @return 当前对象
	*/
	public OrganizationVO setTargetType(String targetType) {
		this.targetType=targetType;
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
	 * @return OrganizationVO , 转换好的 OrganizationVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return OrganizationVO , 转换好的 PoJo 对象
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
	public OrganizationVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public OrganizationVO duplicate(boolean all) {
		org.github.foxnic.web.domain.hrm.meta.OrganizationVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.hrm.meta.OrganizationVOMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setHierarchy(this.getHierarchy());
		inst.setFullName(this.getFullName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setParentId(this.getParentId());
		inst.setValid(this.getValid());
		inst.setCompanyId(this.getCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setShortName(this.getShortName());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setRoot(this.getRoot());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setIds(this.getIds());
			inst.setTargetType(this.getTargetType());
			inst.setIsLoadAllDescendants(this.getIsLoadAllDescendants());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public OrganizationVO clone(boolean deep) {
		return EntityContext.clone(OrganizationVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 OrganizationVO
	 * @param organizationMap 包含实体信息的 Map 对象
	 * @return OrganizationVO , 转换好的的 Organization 对象
	*/
	@Transient
	public static OrganizationVO createFrom(Map<String,Object> organizationMap) {
		if(organizationMap==null) return null;
		OrganizationVO vo = create();
		EntityContext.copyProperties(vo,organizationMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 OrganizationVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return OrganizationVO , 转换好的的 Organization 对象
	*/
	@Transient
	public static OrganizationVO createFrom(Object pojo) {
		if(pojo==null) return null;
		OrganizationVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 OrganizationVO，等同于 new
	 * @return OrganizationVO 对象
	*/
	@Transient
	public static OrganizationVO create() {
		return new org.github.foxnic.web.domain.hrm.meta.OrganizationVOMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(OrganizationVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(OrganizationVOMeta.NOTES)));
			this.setHierarchy(DataParser.parse(String.class, map.get(OrganizationVOMeta.HIERARCHY)));
			this.setFullName(DataParser.parse(String.class, map.get(OrganizationVOMeta.FULL_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(OrganizationVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(OrganizationVOMeta.SORT)));
			this.setType(DataParser.parse(String.class, map.get(OrganizationVOMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(OrganizationVOMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, map.get(OrganizationVOMeta.PARENT_ID)));
			this.setValid(DataParser.parse(Integer.class, map.get(OrganizationVOMeta.VALID)));
			this.setCompanyId(DataParser.parse(String.class, map.get(OrganizationVOMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(OrganizationVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(OrganizationVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(OrganizationVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(OrganizationVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(OrganizationVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(OrganizationVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(OrganizationVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(OrganizationVOMeta.ID)));
			this.setShortName(DataParser.parse(String.class, map.get(OrganizationVOMeta.SHORT_NAME)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(OrganizationVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(OrganizationVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(OrganizationVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(OrganizationVOMeta.FUZZY_FIELD)));
			this.setRoot(DataParser.parse(String.class, map.get(OrganizationVOMeta.ROOT)));
			this.setSortField(DataParser.parse(String.class, map.get(OrganizationVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(OrganizationVOMeta.PAGE_SIZE)));
			this.setTargetType(DataParser.parse(String.class, map.get(OrganizationVOMeta.TARGET_TYPE)));
			this.setIsLoadAllDescendants(DataParser.parse(Integer.class, map.get(OrganizationVOMeta.IS_LOAD_ALL_DESCENDANTS)));
			this.setSearchValue(DataParser.parse(String.class, map.get(OrganizationVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(OrganizationVOMeta.CODE));
				this.setNotes( (String)map.get(OrganizationVOMeta.NOTES));
				this.setHierarchy( (String)map.get(OrganizationVOMeta.HIERARCHY));
				this.setFullName( (String)map.get(OrganizationVOMeta.FULL_NAME));
				this.setUpdateTime( (Date)map.get(OrganizationVOMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(OrganizationVOMeta.SORT));
				this.setType( (String)map.get(OrganizationVOMeta.TYPE));
				this.setVersion( (Integer)map.get(OrganizationVOMeta.VERSION));
				this.setParentId( (String)map.get(OrganizationVOMeta.PARENT_ID));
				this.setValid( (Integer)map.get(OrganizationVOMeta.VALID));
				this.setCompanyId( (String)map.get(OrganizationVOMeta.COMPANY_ID));
				this.setCreateBy( (String)map.get(OrganizationVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(OrganizationVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(OrganizationVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(OrganizationVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(OrganizationVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(OrganizationVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(OrganizationVOMeta.DELETE_BY));
				this.setId( (String)map.get(OrganizationVOMeta.ID));
				this.setShortName( (String)map.get(OrganizationVOMeta.SHORT_NAME));
				// others
				this.setSearchField( (String)map.get(OrganizationVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(OrganizationVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(OrganizationVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(OrganizationVOMeta.FUZZY_FIELD));
				this.setRoot( (String)map.get(OrganizationVOMeta.ROOT));
				this.setSortField( (String)map.get(OrganizationVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(OrganizationVOMeta.PAGE_SIZE));
				this.setTargetType( (String)map.get(OrganizationVOMeta.TARGET_TYPE));
				this.setIsLoadAllDescendants( (Integer)map.get(OrganizationVOMeta.IS_LOAD_ALL_DESCENDANTS));
				this.setSearchValue( (String)map.get(OrganizationVOMeta.SEARCH_VALUE));
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
			this.setCode(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.NOTES)));
			this.setHierarchy(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.HIERARCHY)));
			this.setFullName(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.FULL_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(OrganizationVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(OrganizationVOMeta.SORT)));
			this.setType(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(OrganizationVOMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.PARENT_ID)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(OrganizationVOMeta.VALID)));
			this.setCompanyId(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(OrganizationVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(OrganizationVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(OrganizationVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.ID)));
			this.setShortName(DataParser.parse(String.class, r.getValue(OrganizationVOMeta.SHORT_NAME)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(OrganizationVOMeta.CODE));
				this.setNotes( (String)r.getValue(OrganizationVOMeta.NOTES));
				this.setHierarchy( (String)r.getValue(OrganizationVOMeta.HIERARCHY));
				this.setFullName( (String)r.getValue(OrganizationVOMeta.FULL_NAME));
				this.setUpdateTime( (Date)r.getValue(OrganizationVOMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(OrganizationVOMeta.SORT));
				this.setType( (String)r.getValue(OrganizationVOMeta.TYPE));
				this.setVersion( (Integer)r.getValue(OrganizationVOMeta.VERSION));
				this.setParentId( (String)r.getValue(OrganizationVOMeta.PARENT_ID));
				this.setValid( (Integer)r.getValue(OrganizationVOMeta.VALID));
				this.setCompanyId( (String)r.getValue(OrganizationVOMeta.COMPANY_ID));
				this.setCreateBy( (String)r.getValue(OrganizationVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(OrganizationVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(OrganizationVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(OrganizationVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(OrganizationVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(OrganizationVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(OrganizationVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(OrganizationVOMeta.ID));
				this.setShortName( (String)r.getValue(OrganizationVOMeta.SHORT_NAME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}