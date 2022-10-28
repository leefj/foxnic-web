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
import org.github.foxnic.web.domain.oauth.meta.RoleMenuVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 角色账户关系VO类型
 * <p>角色账户关系 , 数据表 sys_role_menu 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 15:18:34
 * @sign A6F934494C2CEAFE802FEDB39A323640
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "角色账户关系VO类型 ; 角色账户关系 , 数据表 sys_role_menu 的通用VO类型" , parent = RoleMenu.class)
public class RoleMenuVO extends RoleMenu {

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
	public RoleMenuVO setPageIndex(Integer pageIndex) {
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
	public RoleMenuVO setPageSize(Integer pageSize) {
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
	public RoleMenuVO setSearchField(String searchField) {
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
	public RoleMenuVO setFuzzyField(String fuzzyField) {
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
	public RoleMenuVO setSearchValue(String searchValue) {
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
	public RoleMenuVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public RoleMenuVO addDirtyField(String... dirtyField) {
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
	public RoleMenuVO setSortField(String sortField) {
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
	public RoleMenuVO setSortType(String sortType) {
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
	public RoleMenuVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public RoleMenuVO addId(String... id) {
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
	 * @return RoleMenuVO , 转换好的 RoleMenuVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RoleMenuVO , 转换好的 PoJo 对象
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
	public RoleMenuVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RoleMenuVO duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.RoleMenuVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.RoleMenuVOMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setRoleId(this.getRoleId());
		inst.setMenuId(this.getMenuId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
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
	public RoleMenuVO clone(boolean deep) {
		return EntityContext.clone(RoleMenuVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RoleMenuVO
	 * @param roleMenuMap 包含实体信息的 Map 对象
	 * @return RoleMenuVO , 转换好的的 RoleMenu 对象
	*/
	@Transient
	public static RoleMenuVO createFrom(Map<String,Object> roleMenuMap) {
		if(roleMenuMap==null) return null;
		RoleMenuVO vo = create();
		EntityContext.copyProperties(vo,roleMenuMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 RoleMenuVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RoleMenuVO , 转换好的的 RoleMenu 对象
	*/
	@Transient
	public static RoleMenuVO createFrom(Object pojo) {
		if(pojo==null) return null;
		RoleMenuVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 RoleMenuVO，等同于 new
	 * @return RoleMenuVO 对象
	*/
	@Transient
	public static RoleMenuVO create() {
		return new org.github.foxnic.web.domain.oauth.meta.RoleMenuVOMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(RoleMenuVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RoleMenuVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RoleMenuVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RoleMenuVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RoleMenuVOMeta.DELETE_TIME)));
			this.setRoleId(DataParser.parse(String.class, map.get(RoleMenuVOMeta.ROLE_ID)));
			this.setMenuId(DataParser.parse(String.class, map.get(RoleMenuVOMeta.MENU_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RoleMenuVOMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RoleMenuVOMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(RoleMenuVOMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RoleMenuVOMeta.VERSION)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(RoleMenuVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(RoleMenuVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(RoleMenuVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(RoleMenuVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(RoleMenuVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(RoleMenuVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(RoleMenuVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(RoleMenuVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RoleMenuVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(RoleMenuVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RoleMenuVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RoleMenuVOMeta.DELETE_TIME));
				this.setRoleId( (String)map.get(RoleMenuVOMeta.ROLE_ID));
				this.setMenuId( (String)map.get(RoleMenuVOMeta.MENU_ID));
				this.setDeleteBy( (String)map.get(RoleMenuVOMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(RoleMenuVOMeta.UPDATE_TIME));
				this.setId( (String)map.get(RoleMenuVOMeta.ID));
				this.setVersion( (Integer)map.get(RoleMenuVOMeta.VERSION));
				// others
				this.setSearchField( (String)map.get(RoleMenuVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(RoleMenuVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(RoleMenuVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(RoleMenuVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(RoleMenuVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(RoleMenuVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(RoleMenuVOMeta.SEARCH_VALUE));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RoleMenuVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RoleMenuVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RoleMenuVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RoleMenuVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RoleMenuVOMeta.DELETE_TIME)));
			this.setRoleId(DataParser.parse(String.class, r.getValue(RoleMenuVOMeta.ROLE_ID)));
			this.setMenuId(DataParser.parse(String.class, r.getValue(RoleMenuVOMeta.MENU_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RoleMenuVOMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RoleMenuVOMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(RoleMenuVOMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RoleMenuVOMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(RoleMenuVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RoleMenuVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(RoleMenuVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RoleMenuVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RoleMenuVOMeta.DELETE_TIME));
				this.setRoleId( (String)r.getValue(RoleMenuVOMeta.ROLE_ID));
				this.setMenuId( (String)r.getValue(RoleMenuVOMeta.MENU_ID));
				this.setDeleteBy( (String)r.getValue(RoleMenuVOMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(RoleMenuVOMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(RoleMenuVOMeta.ID));
				this.setVersion( (Integer)r.getValue(RoleMenuVOMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}