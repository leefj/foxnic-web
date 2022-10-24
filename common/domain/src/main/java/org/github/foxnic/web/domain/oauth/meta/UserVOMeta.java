package org.github.foxnic.web.domain.oauth.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.oauth.UserVO;
import java.util.List;
import org.github.foxnic.web.domain.oauth.User;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.RoleMenu;
import org.github.foxnic.web.domain.system.UserTenant;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-24 13:52:09
 * @sign BC26DD37961AE5867192245D8EFEA04C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserVOMeta extends UserMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 角色ID列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ROLE_IDS="roleIds";
	
	/**
	 * 角色ID列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> ROLE_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,ROLE_IDS, java.util.List.class, "角色ID列表", "", java.lang.String.class, null);
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final String ACCOUNT="account";
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> ACCOUNT_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,ACCOUNT, java.lang.String.class, "账户", "账户", java.lang.String.class, null);
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final String REAL_NAME="realName";
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> REAL_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,REAL_NAME, java.lang.String.class, "姓名", "姓名", java.lang.String.class, null);
	
	/**
	 * 密码 , 类型: java.lang.String
	*/
	public static final String PASSWD="passwd";
	
	/**
	 * 密码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> PASSWD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,PASSWD, java.lang.String.class, "密码", "密码", java.lang.String.class, null);
	
	/**
	 * 手机号码 , 类型: java.lang.String
	*/
	public static final String PHONE="phone";
	
	/**
	 * 手机号码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> PHONE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,PHONE, java.lang.String.class, "手机号码", "手机号码", java.lang.String.class, null);
	
	/**
	 * 头像ID , 类型: java.lang.String
	*/
	public static final String PORTRAIT_ID="portraitId";
	
	/**
	 * 头像ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> PORTRAIT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,PORTRAIT_ID, java.lang.String.class, "头像ID", "头像ID", java.lang.String.class, null);
	
	/**
	 * 语言 , 类型: java.lang.String
	*/
	public static final String LANGUAGE="language";
	
	/**
	 * 语言 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> LANGUAGE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,LANGUAGE, java.lang.String.class, "语言", "语言", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 缓存键 , 改变这个值，可使浏览器重新请求静态资源 , 类型: java.lang.String
	*/
	public static final String CACHE_KEY="cacheKey";
	
	/**
	 * 缓存键 , 改变这个值，可使浏览器重新请求静态资源 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> CACHE_KEY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,CACHE_KEY, java.lang.String.class, "缓存键", "改变这个值，可使浏览器重新请求静态资源", java.lang.String.class, null);
	
	/**
	 * 最后登录时间 , 类型: java.util.Date
	*/
	public static final String LAST_LOGIN_TIME="lastLoginTime";
	
	/**
	 * 最后登录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.util.Date> LAST_LOGIN_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,LAST_LOGIN_TIME, java.util.Date.class, "最后登录时间", "最后登录时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 角色清单 , 当前用户的所有角色清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Role
	*/
	public static final String ROLES="roles";
	
	/**
	 * 角色清单 , 当前用户的所有角色清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Role
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,org.github.foxnic.web.domain.oauth.Role> ROLES_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,ROLES, java.util.List.class, "角色清单", "当前用户的所有角色清单", org.github.foxnic.web.domain.oauth.Role.class, null);
	
	/**
	 * 菜单清单 , 当前用户的所有菜单清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Menu
	*/
	public static final String MENUS="menus";
	
	/**
	 * 菜单清单 , 当前用户的所有菜单清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Menu
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,org.github.foxnic.web.domain.oauth.Menu> MENUS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,MENUS, java.util.List.class, "菜单清单", "当前用户的所有菜单清单", org.github.foxnic.web.domain.oauth.Menu.class, null);
	
	/**
	 * 角色菜单关系清单 , 当前用户的所有角色菜单关系清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.RoleMenu
	*/
	public static final String ROLE_MENUS="roleMenus";
	
	/**
	 * 角色菜单关系清单 , 当前用户的所有角色菜单关系清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.RoleMenu
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,org.github.foxnic.web.domain.oauth.RoleMenu> ROLE_MENUS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,ROLE_MENUS, java.util.List.class, "角色菜单关系清单", "当前用户的所有角色菜单关系清单", org.github.foxnic.web.domain.oauth.RoleMenu.class, null);
	
	/**
	 * 所属租户关系清单 , 可用且有效的所属租户关系清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.UserTenant
	*/
	public static final String JOINED_TENANTS="joinedTenants";
	
	/**
	 * 所属租户关系清单 , 可用且有效的所属租户关系清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.UserTenant
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,org.github.foxnic.web.domain.system.UserTenant> JOINED_TENANTS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,JOINED_TENANTS, java.util.List.class, "所属租户关系清单", "可用且有效的所属租户关系清单", org.github.foxnic.web.domain.system.UserTenant.class, null);
	
	/**
	 * 当前激活的租户 , 类型: org.github.foxnic.web.domain.system.UserTenant
	*/
	public static final String ACTIVATED_TENANT="activatedTenant";
	
	/**
	 * 当前激活的租户 , 类型: org.github.foxnic.web.domain.system.UserTenant
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,org.github.foxnic.web.domain.system.UserTenant> ACTIVATED_TENANT_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,ACTIVATED_TENANT, org.github.foxnic.web.domain.system.UserTenant.class, "当前激活的租户", "当前激活的租户", org.github.foxnic.web.domain.system.UserTenant.class, null);
	
	/**
	 * 当前激活的员工ID , 当前激活的租户对应的员工ID , 类型: java.lang.String
	*/
	public static final String ACTIVATED_EMPLOYEE_ID="activatedEmployeeId";
	
	/**
	 * 当前激活的员工ID , 当前激活的租户对应的员工ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> ACTIVATED_EMPLOYEE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,ACTIVATED_EMPLOYEE_ID, java.lang.String.class, "当前激活的员工ID", "当前激活的租户对应的员工ID", java.lang.String.class, null);
	
	/**
	 * 当前激活的员工姓名 , 当前激活的租户对应的员工姓名 , 类型: java.lang.String
	*/
	public static final String ACTIVATED_EMPLOYEE_NAME="activatedEmployeeName";
	
	/**
	 * 当前激活的员工姓名 , 当前激活的租户对应的员工姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> ACTIVATED_EMPLOYEE_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,ACTIVATED_EMPLOYEE_NAME, java.lang.String.class, "当前激活的员工姓名", "当前激活的租户对应的员工姓名", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ROLE_IDS , ID , ACCOUNT , REAL_NAME , PASSWD , PHONE , PORTRAIT_ID , LANGUAGE , VALID , CACHE_KEY , LAST_LOGIN_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ROLES , MENUS , ROLE_MENUS , JOINED_TENANTS , ACTIVATED_TENANT , ACTIVATED_EMPLOYEE_ID , ACTIVATED_EMPLOYEE_NAME };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.oauth.UserVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public UserVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public UserVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public UserVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public UserVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public UserVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public UserVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public UserVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public UserVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public UserVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 角色ID列表
		 * @param roleIds 角色ID列表
		 * @return 当前对象
		*/
		public UserVO setRoleIds(List<String> roleIds) {
			super.change(ROLE_IDS,super.getRoleIds(),roleIds);
			super.setRoleIds(roleIds);
			return this;
		}
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public User setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 账户
		 * @param account 账户
		 * @return 当前对象
		*/
		public User setAccount(String account) {
			super.change(ACCOUNT,super.getAccount(),account);
			super.setAccount(account);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param realName 姓名
		 * @return 当前对象
		*/
		public User setRealName(String realName) {
			super.change(REAL_NAME,super.getRealName(),realName);
			super.setRealName(realName);
			return this;
		}
		
		/**
		 * 设置 密码
		 * @param passwd 密码
		 * @return 当前对象
		*/
		public User setPasswd(String passwd) {
			super.change(PASSWD,super.getPasswd(),passwd);
			super.setPasswd(passwd);
			return this;
		}
		
		/**
		 * 设置 手机号码
		 * @param phone 手机号码
		 * @return 当前对象
		*/
		public User setPhone(String phone) {
			super.change(PHONE,super.getPhone(),phone);
			super.setPhone(phone);
			return this;
		}
		
		/**
		 * 设置 头像ID
		 * @param portraitId 头像ID
		 * @return 当前对象
		*/
		public User setPortraitId(String portraitId) {
			super.change(PORTRAIT_ID,super.getPortraitId(),portraitId);
			super.setPortraitId(portraitId);
			return this;
		}
		
		/**
		 * 设置 语言
		 * @param language 语言
		 * @return 当前对象
		*/
		public User setLanguage(String language) {
			super.change(LANGUAGE,super.getLanguage(),language);
			super.setLanguage(language);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public User setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 缓存键
		 * @param cacheKey 缓存键
		 * @return 当前对象
		*/
		public User setCacheKey(String cacheKey) {
			super.change(CACHE_KEY,super.getCacheKey(),cacheKey);
			super.setCacheKey(cacheKey);
			return this;
		}
		
		/**
		 * 设置 最后登录时间
		 * @param lastLoginTime 最后登录时间
		 * @return 当前对象
		*/
		public User setLastLoginTime(Date lastLoginTime) {
			super.change(LAST_LOGIN_TIME,super.getLastLoginTime(),lastLoginTime);
			super.setLastLoginTime(lastLoginTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public User setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public User setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public User setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public User setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public User setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public User setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public User setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public User setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 角色清单
		 * @param roles 角色清单
		 * @return 当前对象
		*/
		public User setRoles(List<Role> roles) {
			super.change(ROLES,super.getRoles(),roles);
			super.setRoles(roles);
			return this;
		}
		
		/**
		 * 设置 菜单清单
		 * @param menus 菜单清单
		 * @return 当前对象
		*/
		public User setMenus(List<Menu> menus) {
			super.change(MENUS,super.getMenus(),menus);
			super.setMenus(menus);
			return this;
		}
		
		/**
		 * 设置 角色菜单关系清单
		 * @param roleMenus 角色菜单关系清单
		 * @return 当前对象
		*/
		public User setRoleMenus(List<RoleMenu> roleMenus) {
			super.change(ROLE_MENUS,super.getRoleMenus(),roleMenus);
			super.setRoleMenus(roleMenus);
			return this;
		}
		
		/**
		 * 设置 所属租户关系清单
		 * @param joinedTenants 所属租户关系清单
		 * @return 当前对象
		*/
		public User setJoinedTenants(List<UserTenant> joinedTenants) {
			super.change(JOINED_TENANTS,super.getJoinedTenants(),joinedTenants);
			super.setJoinedTenants(joinedTenants);
			return this;
		}
		
		/**
		 * 设置 当前激活的租户
		 * @param activatedTenant 当前激活的租户
		 * @return 当前对象
		*/
		public User setActivatedTenant(UserTenant activatedTenant) {
			super.change(ACTIVATED_TENANT,super.getActivatedTenant(),activatedTenant);
			super.setActivatedTenant(activatedTenant);
			return this;
		}
		
		/**
		 * 设置 当前激活的员工ID
		 * @param activatedEmployeeId 当前激活的员工ID
		 * @return 当前对象
		*/
		public User setActivatedEmployeeId(String activatedEmployeeId) {
			super.change(ACTIVATED_EMPLOYEE_ID,super.getActivatedEmployeeId(),activatedEmployeeId);
			super.setActivatedEmployeeId(activatedEmployeeId);
			return this;
		}
		
		/**
		 * 设置 当前激活的员工姓名
		 * @param activatedEmployeeName 当前激活的员工姓名
		 * @return 当前对象
		*/
		public User setActivatedEmployeeName(String activatedEmployeeName) {
			super.change(ACTIVATED_EMPLOYEE_NAME,super.getActivatedEmployeeName(),activatedEmployeeName);
			super.setActivatedEmployeeName(activatedEmployeeName);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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
				inst.setFuzzyField(this.getFuzzyField());
				inst.setRoles(this.getRoles());
				inst.setPageSize(this.getPageSize());
				inst.setActivatedEmployeeId(this.getActivatedEmployeeId());
				inst.setActivatedEmployeeName(this.getActivatedEmployeeName());
				inst.setRoleIds(this.getRoleIds());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setIds(this.getIds());
				inst.setJoinedTenants(this.getJoinedTenants());
				inst.setMenus(this.getMenus());
				inst.setSearchValue(this.getSearchValue());
				inst.setRoleMenus(this.getRoleMenus());
				inst.setActivatedTenant(this.getActivatedTenant());
			}
			inst.clearModifies();
			return inst;
		}

	}
}