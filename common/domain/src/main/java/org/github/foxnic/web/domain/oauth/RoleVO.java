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
import org.github.foxnic.web.domain.oauth.meta.RoleVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 角色VO类型
 * <p>角色 , 数据表 sys_role 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-30 13:48:15
 * @sign 3727294F2857448DC1DA061AA0060988
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "角色VO类型 ; 角色 , 数据表 sys_role 的通用VO类型" , parent = Role.class)
public class RoleVO extends Role {

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
	 * 数据来源：前端指定不同的来源，后端按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
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
	public RoleVO setPageIndex(Integer pageIndex) {
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
	public RoleVO setPageSize(Integer pageSize) {
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
	public RoleVO setSearchField(String searchField) {
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
	public RoleVO setFuzzyField(String fuzzyField) {
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
	public RoleVO setSearchValue(String searchValue) {
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
	public RoleVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public RoleVO addDirtyField(String... dirtyField) {
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
	public RoleVO setSortField(String sortField) {
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
	public RoleVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端按来源执行不同的逻辑
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
	public RoleVO setDataOrigin(String dataOrigin) {
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
	public RoleVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
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
	public RoleVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public RoleVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
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
	 * @return RoleVO , 转换好的 RoleVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RoleVO , 转换好的 PoJo 对象
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
	public RoleVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RoleVO duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.RoleVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.RoleVOMeta.$$proxy$$();
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
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setUsers(this.getUsers());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setMenus(this.getMenus());
			inst.setMenuIds(this.getMenuIds());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RoleVO clone(boolean deep) {
		return EntityContext.clone(RoleVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RoleVO
	 * @param roleMap 包含实体信息的 Map 对象
	 * @return RoleVO , 转换好的的 Role 对象
	*/
	@Transient
	public static RoleVO createFrom(Map<String,Object> roleMap) {
		if(roleMap==null) return null;
		RoleVO vo = create();
		EntityContext.copyProperties(vo,roleMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 RoleVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RoleVO , 转换好的的 Role 对象
	*/
	@Transient
	public static RoleVO createFrom(Object pojo) {
		if(pojo==null) return null;
		RoleVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 RoleVO，等同于 new
	 * @return RoleVO 对象
	*/
	@Transient
	public static RoleVO create() {
		return new org.github.foxnic.web.domain.oauth.meta.RoleVOMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(RoleVOMeta.CREATE_BY)));
			this.setCode(DataParser.parse(String.class, map.get(RoleVOMeta.CODE)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RoleVOMeta.DELETED)));
			this.setNotes(DataParser.parse(String.class, map.get(RoleVOMeta.NOTES)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RoleVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RoleVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RoleVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(RoleVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RoleVOMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RoleVOMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(RoleVOMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RoleVOMeta.VERSION)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(RoleVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(RoleVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(RoleVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(RoleVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(RoleVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(RoleVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(RoleVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(RoleVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(RoleVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(RoleVOMeta.CREATE_BY));
				this.setCode( (String)map.get(RoleVOMeta.CODE));
				this.setDeleted( (Integer)map.get(RoleVOMeta.DELETED));
				this.setNotes( (String)map.get(RoleVOMeta.NOTES));
				this.setCreateTime( (Date)map.get(RoleVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RoleVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RoleVOMeta.DELETE_TIME));
				this.setName( (String)map.get(RoleVOMeta.NAME));
				this.setDeleteBy( (String)map.get(RoleVOMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(RoleVOMeta.UPDATE_TIME));
				this.setId( (String)map.get(RoleVOMeta.ID));
				this.setVersion( (Integer)map.get(RoleVOMeta.VERSION));
				// others
				this.setSearchField( (String)map.get(RoleVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(RoleVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(RoleVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(RoleVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(RoleVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(RoleVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(RoleVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(RoleVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(RoleVOMeta.SEARCH_VALUE));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RoleVOMeta.CREATE_BY)));
			this.setCode(DataParser.parse(String.class, r.getValue(RoleVOMeta.CODE)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RoleVOMeta.DELETED)));
			this.setNotes(DataParser.parse(String.class, r.getValue(RoleVOMeta.NOTES)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RoleVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RoleVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RoleVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(RoleVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RoleVOMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RoleVOMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(RoleVOMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RoleVOMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(RoleVOMeta.CREATE_BY));
				this.setCode( (String)r.getValue(RoleVOMeta.CODE));
				this.setDeleted( (Integer)r.getValue(RoleVOMeta.DELETED));
				this.setNotes( (String)r.getValue(RoleVOMeta.NOTES));
				this.setCreateTime( (Date)r.getValue(RoleVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RoleVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RoleVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(RoleVOMeta.NAME));
				this.setDeleteBy( (String)r.getValue(RoleVOMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(RoleVOMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(RoleVOMeta.ID));
				this.setVersion( (Integer)r.getValue(RoleVOMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}