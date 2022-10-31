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
import org.github.foxnic.web.domain.oauth.meta.UserVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.system.UserTenant;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 账户VO类型
 * <p>账户 , 数据表 sys_user 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-31 17:02:38
 * @sign BC26DD37961AE5867192245D8EFEA04C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "账户VO类型 ; 账户 , 数据表 sys_user 的通用VO类型" , parent = User.class)
public class UserVO extends User {

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
	 * 角色ID列表
	*/
	@ApiModelProperty(required = false,value="角色ID列表" , notes = "")
	private List<String> roleIds;
	
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
	public UserVO setPageIndex(Integer pageIndex) {
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
	public UserVO setPageSize(Integer pageSize) {
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
	public UserVO setSearchField(String searchField) {
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
	public UserVO setFuzzyField(String fuzzyField) {
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
	public UserVO setSearchValue(String searchValue) {
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
	public UserVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public UserVO addDirtyField(String... dirtyField) {
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
	public UserVO setSortField(String sortField) {
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
	public UserVO setSortType(String sortType) {
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
	public UserVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public UserVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	
	/**
	 * 获得 角色ID列表<br>
	 * @return 角色ID列表
	*/
	public List<String> getRoleIds() {
		return roleIds;
	}
	
	/**
	 * 设置 角色ID列表
	 * @param roleIds 角色ID列表
	 * @return 当前对象
	*/
	public UserVO setRoleIds(List<String> roleIds) {
		this.roleIds=roleIds;
		return this;
	}
	
	/**
	 * 添加 角色ID列表
	 * @param roleId 角色ID列表
	 * @return 当前对象
	*/
	public UserVO addRoleId(String... roleId) {
		if(this.roleIds==null) roleIds=new ArrayList<>();
		this.roleIds.addAll(Arrays.asList(roleId));
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
	 * @return UserVO , 转换好的 UserVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return UserVO , 转换好的 PoJo 对象
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
	public UserVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public UserVO duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.UserVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.UserVOMeta.$$proxy$$();
		inst.setPortraitId(this.getPortraitId());
		inst.setLanguage(this.getLanguage());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setValid(this.getValid());
		inst.setRealName(this.getRealName());
		inst.setLastLoginTime(this.getLastLoginTime());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCacheKey(this.getCacheKey());
		inst.setPasswd(this.getPasswd());
		inst.setPhone(this.getPhone());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setAccount(this.getAccount());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRoles(this.getRoles());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setActivatedEmployeeId(this.getActivatedEmployeeId());
			inst.setPageSize(this.getPageSize());
			inst.setActivatedEmployeeName(this.getActivatedEmployeeName());
			inst.setRoleIds(this.getRoleIds());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setJoinedTenants(this.getJoinedTenants());
			inst.setIds(this.getIds());
			inst.setMenus(this.getMenus());
			inst.setMenuIds(this.getMenuIds());
			inst.setRoleMenus(this.getRoleMenus());
			inst.setSearchValue(this.getSearchValue());
			inst.setActivatedTenant(this.getActivatedTenant());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public UserVO clone(boolean deep) {
		return EntityContext.clone(UserVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 UserVO
	 * @param userMap 包含实体信息的 Map 对象
	 * @return UserVO , 转换好的的 User 对象
	*/
	@Transient
	public static UserVO createFrom(Map<String,Object> userMap) {
		if(userMap==null) return null;
		UserVO vo = create();
		EntityContext.copyProperties(vo,userMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 UserVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return UserVO , 转换好的的 User 对象
	*/
	@Transient
	public static UserVO createFrom(Object pojo) {
		if(pojo==null) return null;
		UserVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 UserVO，等同于 new
	 * @return UserVO 对象
	*/
	@Transient
	public static UserVO create() {
		return new org.github.foxnic.web.domain.oauth.meta.UserVOMeta.$$proxy$$();
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
			this.setPortraitId(DataParser.parse(String.class, map.get(UserVOMeta.PORTRAIT_ID)));
			this.setLanguage(DataParser.parse(String.class, map.get(UserVOMeta.LANGUAGE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(UserVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(UserVOMeta.VERSION)));
			this.setValid(DataParser.parse(Integer.class, map.get(UserVOMeta.VALID)));
			this.setRealName(DataParser.parse(String.class, map.get(UserVOMeta.REAL_NAME)));
			this.setLastLoginTime(DataParser.parse(Date.class, map.get(UserVOMeta.LAST_LOGIN_TIME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(UserVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(UserVOMeta.DELETED)));
			this.setCacheKey(DataParser.parse(String.class, map.get(UserVOMeta.CACHE_KEY)));
			this.setPasswd(DataParser.parse(String.class, map.get(UserVOMeta.PASSWD)));
			this.setPhone(DataParser.parse(String.class, map.get(UserVOMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(UserVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(UserVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(UserVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(UserVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(UserVOMeta.ID)));
			this.setAccount(DataParser.parse(String.class, map.get(UserVOMeta.ACCOUNT)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(UserVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(UserVOMeta.FUZZY_FIELD)));
			this.setActivatedEmployeeId(DataParser.parse(String.class, map.get(UserVOMeta.ACTIVATED_EMPLOYEE_ID)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(UserVOMeta.PAGE_SIZE)));
			this.setActivatedEmployeeName(DataParser.parse(String.class, map.get(UserVOMeta.ACTIVATED_EMPLOYEE_NAME)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(UserVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(UserVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(UserVOMeta.SORT_FIELD)));
			this.setSearchValue(DataParser.parse(String.class, map.get(UserVOMeta.SEARCH_VALUE)));
			this.setActivatedTenant(DataParser.parse(UserTenant.class, map.get(UserVOMeta.ACTIVATED_TENANT)));
			return true;
		} else {
			try {
				this.setPortraitId( (String)map.get(UserVOMeta.PORTRAIT_ID));
				this.setLanguage( (String)map.get(UserVOMeta.LANGUAGE));
				this.setUpdateTime( (Date)map.get(UserVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(UserVOMeta.VERSION));
				this.setValid( (Integer)map.get(UserVOMeta.VALID));
				this.setRealName( (String)map.get(UserVOMeta.REAL_NAME));
				this.setLastLoginTime( (Date)map.get(UserVOMeta.LAST_LOGIN_TIME));
				this.setCreateBy( (String)map.get(UserVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(UserVOMeta.DELETED));
				this.setCacheKey( (String)map.get(UserVOMeta.CACHE_KEY));
				this.setPasswd( (String)map.get(UserVOMeta.PASSWD));
				this.setPhone( (String)map.get(UserVOMeta.PHONE));
				this.setCreateTime( (Date)map.get(UserVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(UserVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(UserVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(UserVOMeta.DELETE_BY));
				this.setId( (String)map.get(UserVOMeta.ID));
				this.setAccount( (String)map.get(UserVOMeta.ACCOUNT));
				// others
				this.setSearchField( (String)map.get(UserVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(UserVOMeta.FUZZY_FIELD));
				this.setActivatedEmployeeId( (String)map.get(UserVOMeta.ACTIVATED_EMPLOYEE_ID));
				this.setPageSize( (Integer)map.get(UserVOMeta.PAGE_SIZE));
				this.setActivatedEmployeeName( (String)map.get(UserVOMeta.ACTIVATED_EMPLOYEE_NAME));
				this.setPageIndex( (Integer)map.get(UserVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(UserVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(UserVOMeta.SORT_FIELD));
				this.setSearchValue( (String)map.get(UserVOMeta.SEARCH_VALUE));
				this.setActivatedTenant( (UserTenant)map.get(UserVOMeta.ACTIVATED_TENANT));
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
			this.setPortraitId(DataParser.parse(String.class, r.getValue(UserVOMeta.PORTRAIT_ID)));
			this.setLanguage(DataParser.parse(String.class, r.getValue(UserVOMeta.LANGUAGE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(UserVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(UserVOMeta.VERSION)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(UserVOMeta.VALID)));
			this.setRealName(DataParser.parse(String.class, r.getValue(UserVOMeta.REAL_NAME)));
			this.setLastLoginTime(DataParser.parse(Date.class, r.getValue(UserVOMeta.LAST_LOGIN_TIME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(UserVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(UserVOMeta.DELETED)));
			this.setCacheKey(DataParser.parse(String.class, r.getValue(UserVOMeta.CACHE_KEY)));
			this.setPasswd(DataParser.parse(String.class, r.getValue(UserVOMeta.PASSWD)));
			this.setPhone(DataParser.parse(String.class, r.getValue(UserVOMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(UserVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(UserVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(UserVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(UserVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(UserVOMeta.ID)));
			this.setAccount(DataParser.parse(String.class, r.getValue(UserVOMeta.ACCOUNT)));
			return true;
		} else {
			try {
				this.setPortraitId( (String)r.getValue(UserVOMeta.PORTRAIT_ID));
				this.setLanguage( (String)r.getValue(UserVOMeta.LANGUAGE));
				this.setUpdateTime( (Date)r.getValue(UserVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(UserVOMeta.VERSION));
				this.setValid( (Integer)r.getValue(UserVOMeta.VALID));
				this.setRealName( (String)r.getValue(UserVOMeta.REAL_NAME));
				this.setLastLoginTime( (Date)r.getValue(UserVOMeta.LAST_LOGIN_TIME));
				this.setCreateBy( (String)r.getValue(UserVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(UserVOMeta.DELETED));
				this.setCacheKey( (String)r.getValue(UserVOMeta.CACHE_KEY));
				this.setPasswd( (String)r.getValue(UserVOMeta.PASSWD));
				this.setPhone( (String)r.getValue(UserVOMeta.PHONE));
				this.setCreateTime( (Date)r.getValue(UserVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(UserVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(UserVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(UserVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(UserVOMeta.ID));
				this.setAccount( (String)r.getValue(UserVOMeta.ACCOUNT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}