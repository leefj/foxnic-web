package org.github.foxnic.web.domain.system;

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
import org.github.foxnic.web.domain.system.meta.DbCacheVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库缓存VO类型
 * <p>数据库缓存 , 数据表 sys_db_cache 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:42:52
 * @sign 72833A5F5866DEE38894B2A14C2890F9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "数据库缓存VO类型 ; 数据库缓存 , 数据表 sys_db_cache 的通用VO类型" , parent = DbCache.class)
public class DbCacheVO extends DbCache {

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
	 * 过期秒数
	*/
	@ApiModelProperty(required = false,value="过期秒数" , notes = "")
	private Integer seconds;
	
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
	public DbCacheVO setPageIndex(Integer pageIndex) {
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
	public DbCacheVO setPageSize(Integer pageSize) {
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
	public DbCacheVO setSearchField(String searchField) {
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
	public DbCacheVO setFuzzyField(String fuzzyField) {
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
	public DbCacheVO setSearchValue(String searchValue) {
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
	public DbCacheVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public DbCacheVO addDirtyField(String... dirtyField) {
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
	public DbCacheVO setSortField(String sortField) {
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
	public DbCacheVO setSortType(String sortType) {
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
	public DbCacheVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public DbCacheVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	
	/**
	 * 获得 过期秒数<br>
	 * @return 过期秒数
	*/
	public Integer getSeconds() {
		return seconds;
	}
	
	/**
	 * 设置 过期秒数
	 * @param seconds 过期秒数
	 * @return 当前对象
	*/
	public DbCacheVO setSeconds(Integer seconds) {
		this.seconds=seconds;
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
	 * @return DbCacheVO , 转换好的 DbCacheVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbCacheVO , 转换好的 PoJo 对象
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
	public DbCacheVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbCacheVO duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.DbCacheVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.DbCacheVOMeta.$$proxy$$();
		inst.setArea(this.getArea());
		inst.setOwnerType(this.getOwnerType());
		inst.setCatalog(this.getCatalog());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerId(this.getOwnerId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setExpireTime(this.getExpireTime());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setValue(this.getValue());
		if(all) {
			inst.setSeconds(this.getSeconds());
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setIds(this.getIds());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbCacheVO clone(boolean deep) {
		return EntityContext.clone(DbCacheVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbCacheVO
	 * @param dbCacheMap 包含实体信息的 Map 对象
	 * @return DbCacheVO , 转换好的的 DbCache 对象
	*/
	@Transient
	public static DbCacheVO createFrom(Map<String,Object> dbCacheMap) {
		if(dbCacheMap==null) return null;
		DbCacheVO vo = create();
		EntityContext.copyProperties(vo,dbCacheMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 DbCacheVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbCacheVO , 转换好的的 DbCache 对象
	*/
	@Transient
	public static DbCacheVO createFrom(Object pojo) {
		if(pojo==null) return null;
		DbCacheVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 DbCacheVO，等同于 new
	 * @return DbCacheVO 对象
	*/
	@Transient
	public static DbCacheVO create() {
		return new org.github.foxnic.web.domain.system.meta.DbCacheVOMeta.$$proxy$$();
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
			this.setArea(DataParser.parse(String.class, map.get(DbCacheVOMeta.AREA)));
			this.setOwnerType(DataParser.parse(String.class, map.get(DbCacheVOMeta.OWNER_TYPE)));
			this.setCatalog(DataParser.parse(String.class, map.get(DbCacheVOMeta.CATALOG)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbCacheVOMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, map.get(DbCacheVOMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbCacheVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbCacheVOMeta.CREATE_BY)));
			this.setExpireTime(DataParser.parse(Date.class, map.get(DbCacheVOMeta.EXPIRE_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbCacheVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbCacheVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbCacheVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbCacheVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbCacheVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DbCacheVOMeta.ID)));
			this.setValue(DataParser.parse(String.class, map.get(DbCacheVOMeta.VALUE)));
			// others
			this.setSeconds(DataParser.parse(Integer.class, map.get(DbCacheVOMeta.SECONDS)));
			this.setSearchField(DataParser.parse(String.class, map.get(DbCacheVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(DbCacheVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(DbCacheVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(DbCacheVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(DbCacheVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(DbCacheVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(DbCacheVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setArea( (String)map.get(DbCacheVOMeta.AREA));
				this.setOwnerType( (String)map.get(DbCacheVOMeta.OWNER_TYPE));
				this.setCatalog( (String)map.get(DbCacheVOMeta.CATALOG));
				this.setUpdateTime( (Date)map.get(DbCacheVOMeta.UPDATE_TIME));
				this.setOwnerId( (String)map.get(DbCacheVOMeta.OWNER_ID));
				this.setVersion( (Integer)map.get(DbCacheVOMeta.VERSION));
				this.setCreateBy( (String)map.get(DbCacheVOMeta.CREATE_BY));
				this.setExpireTime( (Date)map.get(DbCacheVOMeta.EXPIRE_TIME));
				this.setDeleted( (Integer)map.get(DbCacheVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(DbCacheVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DbCacheVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DbCacheVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(DbCacheVOMeta.DELETE_BY));
				this.setId( (String)map.get(DbCacheVOMeta.ID));
				this.setValue( (String)map.get(DbCacheVOMeta.VALUE));
				// others
				this.setSeconds( (Integer)map.get(DbCacheVOMeta.SECONDS));
				this.setSearchField( (String)map.get(DbCacheVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(DbCacheVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(DbCacheVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(DbCacheVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(DbCacheVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(DbCacheVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(DbCacheVOMeta.SEARCH_VALUE));
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
			this.setArea(DataParser.parse(String.class, r.getValue(DbCacheVOMeta.AREA)));
			this.setOwnerType(DataParser.parse(String.class, r.getValue(DbCacheVOMeta.OWNER_TYPE)));
			this.setCatalog(DataParser.parse(String.class, r.getValue(DbCacheVOMeta.CATALOG)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbCacheVOMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(DbCacheVOMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbCacheVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbCacheVOMeta.CREATE_BY)));
			this.setExpireTime(DataParser.parse(Date.class, r.getValue(DbCacheVOMeta.EXPIRE_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbCacheVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbCacheVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbCacheVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbCacheVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbCacheVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DbCacheVOMeta.ID)));
			this.setValue(DataParser.parse(String.class, r.getValue(DbCacheVOMeta.VALUE)));
			return true;
		} else {
			try {
				this.setArea( (String)r.getValue(DbCacheVOMeta.AREA));
				this.setOwnerType( (String)r.getValue(DbCacheVOMeta.OWNER_TYPE));
				this.setCatalog( (String)r.getValue(DbCacheVOMeta.CATALOG));
				this.setUpdateTime( (Date)r.getValue(DbCacheVOMeta.UPDATE_TIME));
				this.setOwnerId( (String)r.getValue(DbCacheVOMeta.OWNER_ID));
				this.setVersion( (Integer)r.getValue(DbCacheVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(DbCacheVOMeta.CREATE_BY));
				this.setExpireTime( (Date)r.getValue(DbCacheVOMeta.EXPIRE_TIME));
				this.setDeleted( (Integer)r.getValue(DbCacheVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(DbCacheVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DbCacheVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DbCacheVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(DbCacheVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(DbCacheVOMeta.ID));
				this.setValue( (String)r.getValue(DbCacheVOMeta.VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}