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
import org.github.foxnic.web.domain.oauth.meta.ResourzeVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 系统资源VO类型
 * <p>系统资源 , 数据表 sys_resourze 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 15:10:33
 * @sign B0AD13E1F63579B5BA4FF956A9190A4C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "系统资源VO类型 ; 系统资源 , 数据表 sys_resourze 的通用VO类型" , parent = Resourze.class)
public class ResourzeVO extends Resourze {

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
	public ResourzeVO setPageIndex(Integer pageIndex) {
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
	public ResourzeVO setPageSize(Integer pageSize) {
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
	public ResourzeVO setSearchField(String searchField) {
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
	public ResourzeVO setFuzzyField(String fuzzyField) {
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
	public ResourzeVO setSearchValue(String searchValue) {
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
	public ResourzeVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public ResourzeVO addDirtyField(String... dirtyField) {
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
	public ResourzeVO setSortField(String sortField) {
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
	public ResourzeVO setSortType(String sortType) {
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
	public ResourzeVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public ResourzeVO addId(String... id) {
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
	 * @return ResourzeVO , 转换好的 ResourzeVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ResourzeVO , 转换好的 PoJo 对象
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
	public ResourzeVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ResourzeVO duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.ResourzeVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.ResourzeVOMeta.$$proxy$$();
		inst.setMethod(this.getMethod());
		inst.setModule(this.getModule());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setBatchId(this.getBatchId());
		inst.setVersion(this.getVersion());
		inst.setUrl(this.getUrl());
		inst.setTableName(this.getTableName());
		inst.setAccessType(this.getAccessType());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
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
	public ResourzeVO clone(boolean deep) {
		return EntityContext.clone(ResourzeVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ResourzeVO
	 * @param resourzeMap 包含实体信息的 Map 对象
	 * @return ResourzeVO , 转换好的的 Resourze 对象
	*/
	@Transient
	public static ResourzeVO createFrom(Map<String,Object> resourzeMap) {
		if(resourzeMap==null) return null;
		ResourzeVO vo = create();
		EntityContext.copyProperties(vo,resourzeMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 ResourzeVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ResourzeVO , 转换好的的 Resourze 对象
	*/
	@Transient
	public static ResourzeVO createFrom(Object pojo) {
		if(pojo==null) return null;
		ResourzeVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 ResourzeVO，等同于 new
	 * @return ResourzeVO 对象
	*/
	@Transient
	public static ResourzeVO create() {
		return new org.github.foxnic.web.domain.oauth.meta.ResourzeVOMeta.$$proxy$$();
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
			this.setMethod(DataParser.parse(String.class, map.get(ResourzeVOMeta.METHOD)));
			this.setModule(DataParser.parse(String.class, map.get(ResourzeVOMeta.MODULE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ResourzeVOMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(ResourzeVOMeta.TYPE)));
			this.setBatchId(DataParser.parse(String.class, map.get(ResourzeVOMeta.BATCH_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ResourzeVOMeta.VERSION)));
			this.setUrl(DataParser.parse(String.class, map.get(ResourzeVOMeta.URL)));
			this.setTableName(DataParser.parse(String.class, map.get(ResourzeVOMeta.TABLE_NAME)));
			this.setAccessType(DataParser.parse(String.class, map.get(ResourzeVOMeta.ACCESS_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ResourzeVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ResourzeVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ResourzeVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ResourzeVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ResourzeVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(ResourzeVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ResourzeVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ResourzeVOMeta.ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(ResourzeVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(ResourzeVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(ResourzeVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(ResourzeVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(ResourzeVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(ResourzeVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(ResourzeVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setMethod( (String)map.get(ResourzeVOMeta.METHOD));
				this.setModule( (String)map.get(ResourzeVOMeta.MODULE));
				this.setUpdateTime( (Date)map.get(ResourzeVOMeta.UPDATE_TIME));
				this.setType( (String)map.get(ResourzeVOMeta.TYPE));
				this.setBatchId( (String)map.get(ResourzeVOMeta.BATCH_ID));
				this.setVersion( (Integer)map.get(ResourzeVOMeta.VERSION));
				this.setUrl( (String)map.get(ResourzeVOMeta.URL));
				this.setTableName( (String)map.get(ResourzeVOMeta.TABLE_NAME));
				this.setAccessType( (String)map.get(ResourzeVOMeta.ACCESS_TYPE));
				this.setCreateBy( (String)map.get(ResourzeVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ResourzeVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(ResourzeVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ResourzeVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ResourzeVOMeta.DELETE_TIME));
				this.setName( (String)map.get(ResourzeVOMeta.NAME));
				this.setDeleteBy( (String)map.get(ResourzeVOMeta.DELETE_BY));
				this.setId( (String)map.get(ResourzeVOMeta.ID));
				// others
				this.setSearchField( (String)map.get(ResourzeVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(ResourzeVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(ResourzeVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(ResourzeVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(ResourzeVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(ResourzeVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(ResourzeVOMeta.SEARCH_VALUE));
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
			this.setMethod(DataParser.parse(String.class, r.getValue(ResourzeVOMeta.METHOD)));
			this.setModule(DataParser.parse(String.class, r.getValue(ResourzeVOMeta.MODULE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ResourzeVOMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(ResourzeVOMeta.TYPE)));
			this.setBatchId(DataParser.parse(String.class, r.getValue(ResourzeVOMeta.BATCH_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ResourzeVOMeta.VERSION)));
			this.setUrl(DataParser.parse(String.class, r.getValue(ResourzeVOMeta.URL)));
			this.setTableName(DataParser.parse(String.class, r.getValue(ResourzeVOMeta.TABLE_NAME)));
			this.setAccessType(DataParser.parse(String.class, r.getValue(ResourzeVOMeta.ACCESS_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ResourzeVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ResourzeVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ResourzeVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ResourzeVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ResourzeVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(ResourzeVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ResourzeVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ResourzeVOMeta.ID)));
			return true;
		} else {
			try {
				this.setMethod( (String)r.getValue(ResourzeVOMeta.METHOD));
				this.setModule( (String)r.getValue(ResourzeVOMeta.MODULE));
				this.setUpdateTime( (Date)r.getValue(ResourzeVOMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(ResourzeVOMeta.TYPE));
				this.setBatchId( (String)r.getValue(ResourzeVOMeta.BATCH_ID));
				this.setVersion( (Integer)r.getValue(ResourzeVOMeta.VERSION));
				this.setUrl( (String)r.getValue(ResourzeVOMeta.URL));
				this.setTableName( (String)r.getValue(ResourzeVOMeta.TABLE_NAME));
				this.setAccessType( (String)r.getValue(ResourzeVOMeta.ACCESS_TYPE));
				this.setCreateBy( (String)r.getValue(ResourzeVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ResourzeVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ResourzeVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ResourzeVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ResourzeVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(ResourzeVOMeta.NAME));
				this.setDeleteBy( (String)r.getValue(ResourzeVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(ResourzeVOMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}