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
import org.github.foxnic.web.domain.system.meta.UserTenantVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 账户租户关系VO类型
 * <p>账户租户关系 , 数据表 sys_user_tenant 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:52
 * @sign E060027581D66BFE10FB6BAB0EA48579
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "账户租户关系VO类型 ; 账户租户关系 , 数据表 sys_user_tenant 的通用VO类型" , parent = UserTenant.class)
public class UserTenantVO extends UserTenant {

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
	public UserTenantVO setPageIndex(Integer pageIndex) {
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
	public UserTenantVO setPageSize(Integer pageSize) {
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
	public UserTenantVO setSearchField(String searchField) {
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
	public UserTenantVO setFuzzyField(String fuzzyField) {
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
	public UserTenantVO setSearchValue(String searchValue) {
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
	public UserTenantVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public UserTenantVO addDirtyField(String... dirtyField) {
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
	public UserTenantVO setSortField(String sortField) {
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
	public UserTenantVO setSortType(String sortType) {
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
	public UserTenantVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public UserTenantVO addId(String... id) {
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
	 * @return UserTenantVO , 转换好的 UserTenantVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return UserTenantVO , 转换好的 PoJo 对象
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
	public UserTenantVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public UserTenantVO duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.UserTenantVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.UserTenantVOMeta.$$proxy$$();
		inst.setEmployeeId(this.getEmployeeId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerTenantId(this.getOwnerTenantId());
		inst.setSort(this.getSort());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setValid(this.getValid());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setActivated(this.getActivated());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setIds(this.getIds());
			inst.setEmployee(this.getEmployee());
			inst.setSearchValue(this.getSearchValue());
			inst.setTenant(this.getTenant());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public UserTenantVO clone(boolean deep) {
		return EntityContext.clone(UserTenantVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 UserTenantVO
	 * @param userTenantMap 包含实体信息的 Map 对象
	 * @return UserTenantVO , 转换好的的 UserTenant 对象
	*/
	@Transient
	public static UserTenantVO createFrom(Map<String,Object> userTenantMap) {
		if(userTenantMap==null) return null;
		UserTenantVO vo = create();
		EntityContext.copyProperties(vo,userTenantMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 UserTenantVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return UserTenantVO , 转换好的的 UserTenant 对象
	*/
	@Transient
	public static UserTenantVO createFrom(Object pojo) {
		if(pojo==null) return null;
		UserTenantVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 UserTenantVO，等同于 new
	 * @return UserTenantVO 对象
	*/
	@Transient
	public static UserTenantVO create() {
		return new org.github.foxnic.web.domain.system.meta.UserTenantVOMeta.$$proxy$$();
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
			this.setEmployeeId(DataParser.parse(String.class, map.get(UserTenantVOMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(UserTenantVOMeta.UPDATE_TIME)));
			this.setOwnerTenantId(DataParser.parse(String.class, map.get(UserTenantVOMeta.OWNER_TENANT_ID)));
			this.setSort(DataParser.parse(Integer.class, map.get(UserTenantVOMeta.SORT)));
			this.setUserId(DataParser.parse(String.class, map.get(UserTenantVOMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(UserTenantVOMeta.VERSION)));
			this.setValid(DataParser.parse(Integer.class, map.get(UserTenantVOMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(UserTenantVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(UserTenantVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(UserTenantVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(UserTenantVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(UserTenantVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(UserTenantVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(UserTenantVOMeta.ID)));
			this.setActivated(DataParser.parse(Integer.class, map.get(UserTenantVOMeta.ACTIVATED)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(UserTenantVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(UserTenantVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(UserTenantVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(UserTenantVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(UserTenantVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(UserTenantVOMeta.PAGE_SIZE)));
			this.setEmployee(DataParser.parse(Employee.class, map.get(UserTenantVOMeta.EMPLOYEE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(UserTenantVOMeta.SEARCH_VALUE)));
			this.setTenant(DataParser.parse(Tenant.class, map.get(UserTenantVOMeta.TENANT)));
			return true;
		} else {
			try {
				this.setEmployeeId( (String)map.get(UserTenantVOMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)map.get(UserTenantVOMeta.UPDATE_TIME));
				this.setOwnerTenantId( (String)map.get(UserTenantVOMeta.OWNER_TENANT_ID));
				this.setSort( (Integer)map.get(UserTenantVOMeta.SORT));
				this.setUserId( (String)map.get(UserTenantVOMeta.USER_ID));
				this.setVersion( (Integer)map.get(UserTenantVOMeta.VERSION));
				this.setValid( (Integer)map.get(UserTenantVOMeta.VALID));
				this.setCreateBy( (String)map.get(UserTenantVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(UserTenantVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(UserTenantVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(UserTenantVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(UserTenantVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(UserTenantVOMeta.DELETE_BY));
				this.setId( (String)map.get(UserTenantVOMeta.ID));
				this.setActivated( (Integer)map.get(UserTenantVOMeta.ACTIVATED));
				// others
				this.setSearchField( (String)map.get(UserTenantVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(UserTenantVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(UserTenantVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(UserTenantVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(UserTenantVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(UserTenantVOMeta.PAGE_SIZE));
				this.setEmployee( (Employee)map.get(UserTenantVOMeta.EMPLOYEE));
				this.setSearchValue( (String)map.get(UserTenantVOMeta.SEARCH_VALUE));
				this.setTenant( (Tenant)map.get(UserTenantVOMeta.TENANT));
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
			this.setEmployeeId(DataParser.parse(String.class, r.getValue(UserTenantVOMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(UserTenantVOMeta.UPDATE_TIME)));
			this.setOwnerTenantId(DataParser.parse(String.class, r.getValue(UserTenantVOMeta.OWNER_TENANT_ID)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(UserTenantVOMeta.SORT)));
			this.setUserId(DataParser.parse(String.class, r.getValue(UserTenantVOMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(UserTenantVOMeta.VERSION)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(UserTenantVOMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(UserTenantVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(UserTenantVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(UserTenantVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(UserTenantVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(UserTenantVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(UserTenantVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(UserTenantVOMeta.ID)));
			this.setActivated(DataParser.parse(Integer.class, r.getValue(UserTenantVOMeta.ACTIVATED)));
			return true;
		} else {
			try {
				this.setEmployeeId( (String)r.getValue(UserTenantVOMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)r.getValue(UserTenantVOMeta.UPDATE_TIME));
				this.setOwnerTenantId( (String)r.getValue(UserTenantVOMeta.OWNER_TENANT_ID));
				this.setSort( (Integer)r.getValue(UserTenantVOMeta.SORT));
				this.setUserId( (String)r.getValue(UserTenantVOMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(UserTenantVOMeta.VERSION));
				this.setValid( (Integer)r.getValue(UserTenantVOMeta.VALID));
				this.setCreateBy( (String)r.getValue(UserTenantVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(UserTenantVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(UserTenantVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(UserTenantVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(UserTenantVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(UserTenantVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(UserTenantVOMeta.ID));
				this.setActivated( (Integer)r.getValue(UserTenantVOMeta.ACTIVATED));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}