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
import org.github.foxnic.web.domain.hrm.meta.PositionVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 岗位VO类型
 * <p>岗位 , 数据表 hrm_position 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:47:52
 * @sign 57B4E87C769EDE2B2E63B3010FE13C38
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "岗位VO类型 ; 岗位 , 数据表 hrm_position 的通用VO类型" , parent = Position.class)
public class PositionVO extends Position {

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
	public PositionVO setPageIndex(Integer pageIndex) {
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
	public PositionVO setPageSize(Integer pageSize) {
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
	public PositionVO setSearchField(String searchField) {
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
	public PositionVO setFuzzyField(String fuzzyField) {
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
	public PositionVO setSearchValue(String searchValue) {
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
	public PositionVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PositionVO addDirtyField(String... dirtyField) {
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
	public PositionVO setSortField(String sortField) {
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
	public PositionVO setSortType(String sortType) {
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
	public PositionVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PositionVO addId(String... id) {
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
	 * @return PositionVO , 转换好的 PositionVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PositionVO , 转换好的 PoJo 对象
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
	public PositionVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PositionVO duplicate(boolean all) {
		org.github.foxnic.web.domain.hrm.meta.PositionVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.hrm.meta.PositionVOMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setFullName(this.getFullName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setOrgId(this.getOrgId());
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
			inst.setOrganization(this.getOrganization());
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
	public PositionVO clone(boolean deep) {
		return EntityContext.clone(PositionVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PositionVO
	 * @param positionMap 包含实体信息的 Map 对象
	 * @return PositionVO , 转换好的的 Position 对象
	*/
	@Transient
	public static PositionVO createFrom(Map<String,Object> positionMap) {
		if(positionMap==null) return null;
		PositionVO vo = create();
		EntityContext.copyProperties(vo,positionMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PositionVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PositionVO , 转换好的的 Position 对象
	*/
	@Transient
	public static PositionVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PositionVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PositionVO，等同于 new
	 * @return PositionVO 对象
	*/
	@Transient
	public static PositionVO create() {
		return new org.github.foxnic.web.domain.hrm.meta.PositionVOMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(PositionVOMeta.CODE)));
			this.setFullName(DataParser.parse(String.class, map.get(PositionVOMeta.FULL_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PositionVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(PositionVOMeta.SORT)));
			this.setType(DataParser.parse(String.class, map.get(PositionVOMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PositionVOMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, map.get(PositionVOMeta.ORG_ID)));
			this.setValid(DataParser.parse(Integer.class, map.get(PositionVOMeta.VALID)));
			this.setCompanyId(DataParser.parse(String.class, map.get(PositionVOMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PositionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PositionVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PositionVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PositionVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PositionVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PositionVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PositionVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PositionVOMeta.ID)));
			this.setShortName(DataParser.parse(String.class, map.get(PositionVOMeta.SHORT_NAME)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(PositionVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(PositionVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(PositionVOMeta.SORT_TYPE)));
			this.setOrganization(DataParser.parse(Organization.class, map.get(PositionVOMeta.ORGANIZATION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(PositionVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(PositionVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(PositionVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(PositionVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(PositionVOMeta.CODE));
				this.setFullName( (String)map.get(PositionVOMeta.FULL_NAME));
				this.setUpdateTime( (Date)map.get(PositionVOMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(PositionVOMeta.SORT));
				this.setType( (String)map.get(PositionVOMeta.TYPE));
				this.setVersion( (Integer)map.get(PositionVOMeta.VERSION));
				this.setOrgId( (String)map.get(PositionVOMeta.ORG_ID));
				this.setValid( (Integer)map.get(PositionVOMeta.VALID));
				this.setCompanyId( (String)map.get(PositionVOMeta.COMPANY_ID));
				this.setCreateBy( (String)map.get(PositionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PositionVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(PositionVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PositionVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PositionVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PositionVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PositionVOMeta.DELETE_BY));
				this.setId( (String)map.get(PositionVOMeta.ID));
				this.setShortName( (String)map.get(PositionVOMeta.SHORT_NAME));
				// others
				this.setSearchField( (String)map.get(PositionVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(PositionVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(PositionVOMeta.SORT_TYPE));
				this.setOrganization( (Organization)map.get(PositionVOMeta.ORGANIZATION));
				this.setFuzzyField( (String)map.get(PositionVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(PositionVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(PositionVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(PositionVOMeta.SEARCH_VALUE));
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
			this.setCode(DataParser.parse(String.class, r.getValue(PositionVOMeta.CODE)));
			this.setFullName(DataParser.parse(String.class, r.getValue(PositionVOMeta.FULL_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PositionVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(PositionVOMeta.SORT)));
			this.setType(DataParser.parse(String.class, r.getValue(PositionVOMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PositionVOMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(PositionVOMeta.ORG_ID)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(PositionVOMeta.VALID)));
			this.setCompanyId(DataParser.parse(String.class, r.getValue(PositionVOMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PositionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PositionVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PositionVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PositionVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PositionVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PositionVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PositionVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PositionVOMeta.ID)));
			this.setShortName(DataParser.parse(String.class, r.getValue(PositionVOMeta.SHORT_NAME)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(PositionVOMeta.CODE));
				this.setFullName( (String)r.getValue(PositionVOMeta.FULL_NAME));
				this.setUpdateTime( (Date)r.getValue(PositionVOMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(PositionVOMeta.SORT));
				this.setType( (String)r.getValue(PositionVOMeta.TYPE));
				this.setVersion( (Integer)r.getValue(PositionVOMeta.VERSION));
				this.setOrgId( (String)r.getValue(PositionVOMeta.ORG_ID));
				this.setValid( (Integer)r.getValue(PositionVOMeta.VALID));
				this.setCompanyId( (String)r.getValue(PositionVOMeta.COMPANY_ID));
				this.setCreateBy( (String)r.getValue(PositionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PositionVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PositionVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PositionVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PositionVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PositionVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PositionVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(PositionVOMeta.ID));
				this.setShortName( (String)r.getValue(PositionVOMeta.SHORT_NAME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}