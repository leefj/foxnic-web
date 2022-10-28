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
import org.github.foxnic.web.domain.hrm.meta.FavouriteGroupItemVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 常用人员分组条目VO类型
 * <p>常用人员分组条目 , 数据表 hrm_favourite_group_item 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:47:57
 * @sign 63281ECDFF8ED3BB50C775A9CEB6A128
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "常用人员分组条目VO类型 ; 常用人员分组条目 , 数据表 hrm_favourite_group_item 的通用VO类型" , parent = FavouriteGroupItem.class)
public class FavouriteGroupItemVO extends FavouriteGroupItem {

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
	 * 初始化的人员清单：初始化的人员清单
	*/
	@ApiModelProperty(required = false,value="初始化的人员清单" , notes = "初始化的人员清单")
	private String initValue;
	
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
	public FavouriteGroupItemVO setPageIndex(Integer pageIndex) {
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
	public FavouriteGroupItemVO setPageSize(Integer pageSize) {
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
	public FavouriteGroupItemVO setSearchField(String searchField) {
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
	public FavouriteGroupItemVO setFuzzyField(String fuzzyField) {
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
	public FavouriteGroupItemVO setSearchValue(String searchValue) {
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
	public FavouriteGroupItemVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public FavouriteGroupItemVO addDirtyField(String... dirtyField) {
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
	public FavouriteGroupItemVO setSortField(String sortField) {
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
	public FavouriteGroupItemVO setSortType(String sortType) {
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
	public FavouriteGroupItemVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public FavouriteGroupItemVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	
	/**
	 * 获得 初始化的人员清单<br>
	 * 初始化的人员清单
	 * @return 初始化的人员清单
	*/
	public String getInitValue() {
		return initValue;
	}
	
	/**
	 * 设置 初始化的人员清单
	 * @param initValue 初始化的人员清单
	 * @return 当前对象
	*/
	public FavouriteGroupItemVO setInitValue(String initValue) {
		this.initValue=initValue;
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
	 * @return FavouriteGroupItemVO , 转换好的 FavouriteGroupItemVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FavouriteGroupItemVO , 转换好的 PoJo 对象
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
	public FavouriteGroupItemVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public FavouriteGroupItemVO duplicate(boolean all) {
		org.github.foxnic.web.domain.hrm.meta.FavouriteGroupItemVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.hrm.meta.FavouriteGroupItemVOMeta.$$proxy$$();
		inst.setTemporary(this.getTemporary());
		inst.setTargetName(this.getTargetName());
		inst.setTargetId(this.getTargetId());
		inst.setGroupId(this.getGroupId());
		inst.setTargetType(this.getTargetType());
		inst.setEmployeeId(this.getEmployeeId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setCompanyId(this.getCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setEmployee(this.getEmployee());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setOrganization(this.getOrganization());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setIds(this.getIds());
			inst.setPosition(this.getPosition());
			inst.setSearchValue(this.getSearchValue());
			inst.setInitValue(this.getInitValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public FavouriteGroupItemVO clone(boolean deep) {
		return EntityContext.clone(FavouriteGroupItemVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 FavouriteGroupItemVO
	 * @param favouriteGroupItemMap 包含实体信息的 Map 对象
	 * @return FavouriteGroupItemVO , 转换好的的 FavouriteGroupItem 对象
	*/
	@Transient
	public static FavouriteGroupItemVO createFrom(Map<String,Object> favouriteGroupItemMap) {
		if(favouriteGroupItemMap==null) return null;
		FavouriteGroupItemVO vo = create();
		EntityContext.copyProperties(vo,favouriteGroupItemMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 FavouriteGroupItemVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FavouriteGroupItemVO , 转换好的的 FavouriteGroupItem 对象
	*/
	@Transient
	public static FavouriteGroupItemVO createFrom(Object pojo) {
		if(pojo==null) return null;
		FavouriteGroupItemVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 FavouriteGroupItemVO，等同于 new
	 * @return FavouriteGroupItemVO 对象
	*/
	@Transient
	public static FavouriteGroupItemVO create() {
		return new org.github.foxnic.web.domain.hrm.meta.FavouriteGroupItemVOMeta.$$proxy$$();
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
			this.setTemporary(DataParser.parse(Integer.class, map.get(FavouriteGroupItemVOMeta.TEMPORARY)));
			this.setTargetName(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.TARGET_NAME)));
			this.setTargetId(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.TARGET_ID)));
			this.setGroupId(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.GROUP_ID)));
			this.setTargetType(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.TARGET_TYPE)));
			this.setEmployeeId(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(FavouriteGroupItemVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(FavouriteGroupItemVOMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(FavouriteGroupItemVOMeta.VERSION)));
			this.setCompanyId(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(FavouriteGroupItemVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(FavouriteGroupItemVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(FavouriteGroupItemVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(FavouriteGroupItemVOMeta.PAGE_SIZE)));
			this.setEmployee(DataParser.parse(Employee.class, map.get(FavouriteGroupItemVOMeta.EMPLOYEE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(FavouriteGroupItemVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.SORT_TYPE)));
			this.setOrganization(DataParser.parse(Employee.class, map.get(FavouriteGroupItemVOMeta.ORGANIZATION)));
			this.setSortField(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.SORT_FIELD)));
			this.setPosition(DataParser.parse(Employee.class, map.get(FavouriteGroupItemVOMeta.POSITION)));
			this.setSearchValue(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.SEARCH_VALUE)));
			this.setInitValue(DataParser.parse(String.class, map.get(FavouriteGroupItemVOMeta.INIT_VALUE)));
			return true;
		} else {
			try {
				this.setTemporary( (Integer)map.get(FavouriteGroupItemVOMeta.TEMPORARY));
				this.setTargetName( (String)map.get(FavouriteGroupItemVOMeta.TARGET_NAME));
				this.setTargetId( (String)map.get(FavouriteGroupItemVOMeta.TARGET_ID));
				this.setGroupId( (String)map.get(FavouriteGroupItemVOMeta.GROUP_ID));
				this.setTargetType( (String)map.get(FavouriteGroupItemVOMeta.TARGET_TYPE));
				this.setEmployeeId( (String)map.get(FavouriteGroupItemVOMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)map.get(FavouriteGroupItemVOMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(FavouriteGroupItemVOMeta.SORT));
				this.setVersion( (Integer)map.get(FavouriteGroupItemVOMeta.VERSION));
				this.setCompanyId( (String)map.get(FavouriteGroupItemVOMeta.COMPANY_ID));
				this.setCreateBy( (String)map.get(FavouriteGroupItemVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(FavouriteGroupItemVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(FavouriteGroupItemVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(FavouriteGroupItemVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(FavouriteGroupItemVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(FavouriteGroupItemVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(FavouriteGroupItemVOMeta.DELETE_BY));
				this.setId( (String)map.get(FavouriteGroupItemVOMeta.ID));
				// others
				this.setSearchField( (String)map.get(FavouriteGroupItemVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(FavouriteGroupItemVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(FavouriteGroupItemVOMeta.PAGE_SIZE));
				this.setEmployee( (Employee)map.get(FavouriteGroupItemVOMeta.EMPLOYEE));
				this.setPageIndex( (Integer)map.get(FavouriteGroupItemVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(FavouriteGroupItemVOMeta.SORT_TYPE));
				this.setOrganization( (Employee)map.get(FavouriteGroupItemVOMeta.ORGANIZATION));
				this.setSortField( (String)map.get(FavouriteGroupItemVOMeta.SORT_FIELD));
				this.setPosition( (Employee)map.get(FavouriteGroupItemVOMeta.POSITION));
				this.setSearchValue( (String)map.get(FavouriteGroupItemVOMeta.SEARCH_VALUE));
				this.setInitValue( (String)map.get(FavouriteGroupItemVOMeta.INIT_VALUE));
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
			this.setTemporary(DataParser.parse(Integer.class, r.getValue(FavouriteGroupItemVOMeta.TEMPORARY)));
			this.setTargetName(DataParser.parse(String.class, r.getValue(FavouriteGroupItemVOMeta.TARGET_NAME)));
			this.setTargetId(DataParser.parse(String.class, r.getValue(FavouriteGroupItemVOMeta.TARGET_ID)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(FavouriteGroupItemVOMeta.GROUP_ID)));
			this.setTargetType(DataParser.parse(String.class, r.getValue(FavouriteGroupItemVOMeta.TARGET_TYPE)));
			this.setEmployeeId(DataParser.parse(String.class, r.getValue(FavouriteGroupItemVOMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(FavouriteGroupItemVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(FavouriteGroupItemVOMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(FavouriteGroupItemVOMeta.VERSION)));
			this.setCompanyId(DataParser.parse(String.class, r.getValue(FavouriteGroupItemVOMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(FavouriteGroupItemVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(FavouriteGroupItemVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(FavouriteGroupItemVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(FavouriteGroupItemVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(FavouriteGroupItemVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(FavouriteGroupItemVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(FavouriteGroupItemVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(FavouriteGroupItemVOMeta.ID)));
			return true;
		} else {
			try {
				this.setTemporary( (Integer)r.getValue(FavouriteGroupItemVOMeta.TEMPORARY));
				this.setTargetName( (String)r.getValue(FavouriteGroupItemVOMeta.TARGET_NAME));
				this.setTargetId( (String)r.getValue(FavouriteGroupItemVOMeta.TARGET_ID));
				this.setGroupId( (String)r.getValue(FavouriteGroupItemVOMeta.GROUP_ID));
				this.setTargetType( (String)r.getValue(FavouriteGroupItemVOMeta.TARGET_TYPE));
				this.setEmployeeId( (String)r.getValue(FavouriteGroupItemVOMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)r.getValue(FavouriteGroupItemVOMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(FavouriteGroupItemVOMeta.SORT));
				this.setVersion( (Integer)r.getValue(FavouriteGroupItemVOMeta.VERSION));
				this.setCompanyId( (String)r.getValue(FavouriteGroupItemVOMeta.COMPANY_ID));
				this.setCreateBy( (String)r.getValue(FavouriteGroupItemVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(FavouriteGroupItemVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(FavouriteGroupItemVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(FavouriteGroupItemVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(FavouriteGroupItemVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(FavouriteGroupItemVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(FavouriteGroupItemVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(FavouriteGroupItemVOMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}