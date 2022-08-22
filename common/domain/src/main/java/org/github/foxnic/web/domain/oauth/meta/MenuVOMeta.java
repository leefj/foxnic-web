package org.github.foxnic.web.domain.oauth.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.oauth.MenuVO;
import java.util.List;
import org.github.foxnic.web.domain.oauth.Menu;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.Resourze;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-22 09:52:07
 * @sign CE145BF1CA43AFFDB6E417F50CFABB46
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MenuVOMeta extends MenuMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 菜单角色 , 从前端传入，指定勾选指定角色的菜单 , 类型: java.lang.String
	*/
	public static final String ROLE_ID="roleId";
	
	/**
	 * 菜单角色 , 从前端传入，指定勾选指定角色的菜单 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> ROLE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,ROLE_ID, java.lang.String.class, "菜单角色", "从前端传入，指定勾选指定角色的菜单", java.lang.String.class, null);
	
	/**
	 * 是否加载所有子孙节点 , 1：是；0：否 , 类型: java.lang.Integer
	*/
	public static final String IS_LOAD_ALL_DESCENDANTS="isLoadAllDescendants";
	
	/**
	 * 是否加载所有子孙节点 , 1：是；0：否 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.Integer> IS_LOAD_ALL_DESCENDANTS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,IS_LOAD_ALL_DESCENDANTS, java.lang.Integer.class, "是否加载所有子孙节点", "1：是；0：否", java.lang.Integer.class, null);
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 批次号 , 自动生成时的批次号 , 类型: java.lang.String
	*/
	public static final String BATCH_ID="batchId";
	
	/**
	 * 批次号 , 自动生成时的批次号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> BATCH_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,BATCH_ID, java.lang.String.class, "批次号", "自动生成时的批次号", java.lang.String.class, null);
	
	/**
	 * 权限 , 权限标识 , 类型: java.lang.String
	*/
	public static final String AUTHORITY="authority";
	
	/**
	 * 权限 , 权限标识 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> AUTHORITY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,AUTHORITY, java.lang.String.class, "权限", "权限标识", java.lang.String.class, null);
	
	/**
	 * 是否隐藏 , 类型: java.lang.Integer
	*/
	public static final String HIDDEN="hidden";
	
	/**
	 * 是否隐藏 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.Integer> HIDDEN_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,HIDDEN, java.lang.Integer.class, "是否隐藏", "是否隐藏", java.lang.Integer.class, null);
	
	/**
	 * 样式 , 类型: java.lang.String
	*/
	public static final String CSS="css";
	
	/**
	 * 样式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> CSS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,CSS, java.lang.String.class, "样式", "样式", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABEL="label";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> LABEL_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,LABEL, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 菜单类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 菜单类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,TYPE, java.lang.String.class, "菜单类型", "菜单类型", java.lang.String.class, null);
	
	/**
	 * 菜单路径的资源 , 类型: java.lang.String
	*/
	public static final String PATH_RESOURCE_ID="pathResourceId";
	
	/**
	 * 菜单路径的资源 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> PATH_RESOURCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,PATH_RESOURCE_ID, java.lang.String.class, "菜单路径的资源", "菜单路径的资源", java.lang.String.class, null);
	
	/**
	 * 路由地址 , 类型: java.lang.String
	*/
	public static final String URL="url";
	
	/**
	 * 路由地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> URL_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,URL, java.lang.String.class, "路由地址", "路由地址", java.lang.String.class, null);
	
	/**
	 * 页面参数 , 类型: java.lang.String
	*/
	public static final String PARAMS="params";
	
	/**
	 * 页面参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> PARAMS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,PARAMS, java.lang.String.class, "页面参数", "页面参数", java.lang.String.class, null);
	
	/**
	 * 上级ID , 类型: java.lang.String
	*/
	public static final String PARENT_ID="parentId";
	
	/**
	 * 上级ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> PARENT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,PARENT_ID, java.lang.String.class, "上级ID", "上级ID", java.lang.String.class, null);
	
	/**
	 * 动态控制类 , 类型: java.lang.String
	*/
	public static final String DYNAMIC_HANDLER="dynamicHandler";
	
	/**
	 * 动态控制类 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> DYNAMIC_HANDLER_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,DYNAMIC_HANDLER, java.lang.String.class, "动态控制类", "动态控制类", java.lang.String.class, null);
	
	/**
	 * 层级路径 , 类型: java.lang.String
	*/
	public static final String HIERARCHY="hierarchy";
	
	/**
	 * 层级路径 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> HIERARCHY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,HIERARCHY, java.lang.String.class, "层级路径", "层级路径", java.lang.String.class, null);
	
	/**
	 * 显示顺序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 显示顺序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.Integer> SORT_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,SORT, java.lang.Integer.class, "显示顺序", "显示顺序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 路径资源 , 类型: org.github.foxnic.web.domain.oauth.Resourze
	*/
	public static final String PATH_RESOURCE="pathResource";
	
	/**
	 * 路径资源 , 类型: org.github.foxnic.web.domain.oauth.Resourze
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,org.github.foxnic.web.domain.oauth.Resourze> PATH_RESOURCE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,PATH_RESOURCE, org.github.foxnic.web.domain.oauth.Resourze.class, "路径资源", "", org.github.foxnic.web.domain.oauth.Resourze.class, null);
	
	/**
	 * 菜单包含的资源清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Resourze
	*/
	public static final String RESOURCES="resources";
	
	/**
	 * 菜单包含的资源清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Resourze
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,org.github.foxnic.web.domain.oauth.Resourze> RESOURCES_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,RESOURCES, java.util.List.class, "菜单包含的资源清单", "", org.github.foxnic.web.domain.oauth.Resourze.class, null);
	
	/**
	 * 上级菜单 , 类型: org.github.foxnic.web.domain.oauth.Menu
	*/
	public static final String PARENT="parent";
	
	/**
	 * 上级菜单 , 类型: org.github.foxnic.web.domain.oauth.Menu
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,org.github.foxnic.web.domain.oauth.Menu> PARENT_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,PARENT, org.github.foxnic.web.domain.oauth.Menu.class, "上级菜单", "", org.github.foxnic.web.domain.oauth.Menu.class, null);
	
	/**
	 * 页面路径 , 类型: java.lang.String
	*/
	public static final String PATH="path";
	
	/**
	 * 页面路径 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> PATH_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,PATH, java.lang.String.class, "页面路径", "", java.lang.String.class, null);
	
	/**
	 * 资源ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String RESOURCE_IDS="resourceIds";
	
	/**
	 * 资源ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> RESOURCE_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,RESOURCE_IDS, java.util.List.class, "资源ID清单", "", java.lang.String.class, null);
	
	/**
	 * 祖先名称路径 , 用斜杠隔开 , 类型: java.lang.String
	*/
	public static final String ANCESTORS_NAME_PATH="ancestorsNamePath";
	
	/**
	 * 祖先名称路径 , 用斜杠隔开 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.MenuVO,java.lang.String> ANCESTORS_NAME_PATH_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.MenuVO.class ,ANCESTORS_NAME_PATH, java.lang.String.class, "祖先名称路径", "用斜杠隔开", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ROLE_ID , IS_LOAD_ALL_DESCENDANTS , ID , BATCH_ID , AUTHORITY , HIDDEN , CSS , LABEL , TYPE , PATH_RESOURCE_ID , URL , PARAMS , PARENT_ID , DYNAMIC_HANDLER , HIERARCHY , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PATH_RESOURCE , RESOURCES , PARENT , PATH , RESOURCE_IDS , ANCESTORS_NAME_PATH };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.oauth.MenuVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public MenuVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public MenuVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public MenuVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public MenuVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public MenuVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public MenuVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public MenuVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public MenuVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public MenuVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 菜单角色
		 * @param roleId 菜单角色
		 * @return 当前对象
		*/
		public MenuVO setRoleId(String roleId) {
			super.change(ROLE_ID,super.getRoleId(),roleId);
			super.setRoleId(roleId);
			return this;
		}
		
		/**
		 * 设置 是否加载所有子孙节点
		 * @param isLoadAllDescendants 是否加载所有子孙节点
		 * @return 当前对象
		*/
		public MenuVO setIsLoadAllDescendants(Integer isLoadAllDescendants) {
			super.change(IS_LOAD_ALL_DESCENDANTS,super.getIsLoadAllDescendants(),isLoadAllDescendants);
			super.setIsLoadAllDescendants(isLoadAllDescendants);
			return this;
		}
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public Menu setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 批次号
		 * @param batchId 批次号
		 * @return 当前对象
		*/
		public Menu setBatchId(String batchId) {
			super.change(BATCH_ID,super.getBatchId(),batchId);
			super.setBatchId(batchId);
			return this;
		}
		
		/**
		 * 设置 权限
		 * @param authority 权限
		 * @return 当前对象
		*/
		public Menu setAuthority(String authority) {
			super.change(AUTHORITY,super.getAuthority(),authority);
			super.setAuthority(authority);
			return this;
		}
		
		/**
		 * 设置 是否隐藏
		 * @param hidden 是否隐藏
		 * @return 当前对象
		*/
		public Menu setHidden(Integer hidden) {
			super.change(HIDDEN,super.getHidden(),hidden);
			super.setHidden(hidden);
			return this;
		}
		
		/**
		 * 设置 样式
		 * @param css 样式
		 * @return 当前对象
		*/
		public Menu setCss(String css) {
			super.change(CSS,super.getCss(),css);
			super.setCss(css);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param label 标签
		 * @return 当前对象
		*/
		public Menu setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
			return this;
		}
		
		/**
		 * 设置 菜单类型
		 * @param type 菜单类型
		 * @return 当前对象
		*/
		public Menu setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 菜单路径的资源
		 * @param pathResourceId 菜单路径的资源
		 * @return 当前对象
		*/
		public Menu setPathResourceId(String pathResourceId) {
			super.change(PATH_RESOURCE_ID,super.getPathResourceId(),pathResourceId);
			super.setPathResourceId(pathResourceId);
			return this;
		}
		
		/**
		 * 设置 路由地址
		 * @param url 路由地址
		 * @return 当前对象
		*/
		public Menu setUrl(String url) {
			super.change(URL,super.getUrl(),url);
			super.setUrl(url);
			return this;
		}
		
		/**
		 * 设置 页面参数
		 * @param params 页面参数
		 * @return 当前对象
		*/
		public Menu setParams(String params) {
			super.change(PARAMS,super.getParams(),params);
			super.setParams(params);
			return this;
		}
		
		/**
		 * 设置 上级ID
		 * @param parentId 上级ID
		 * @return 当前对象
		*/
		public Menu setParentId(String parentId) {
			super.change(PARENT_ID,super.getParentId(),parentId);
			super.setParentId(parentId);
			return this;
		}
		
		/**
		 * 设置 动态控制类
		 * @param dynamicHandler 动态控制类
		 * @return 当前对象
		*/
		public Menu setDynamicHandler(String dynamicHandler) {
			super.change(DYNAMIC_HANDLER,super.getDynamicHandler(),dynamicHandler);
			super.setDynamicHandler(dynamicHandler);
			return this;
		}
		
		/**
		 * 设置 层级路径
		 * @param hierarchy 层级路径
		 * @return 当前对象
		*/
		public Menu setHierarchy(String hierarchy) {
			super.change(HIERARCHY,super.getHierarchy(),hierarchy);
			super.setHierarchy(hierarchy);
			return this;
		}
		
		/**
		 * 设置 显示顺序
		 * @param sort 显示顺序
		 * @return 当前对象
		*/
		public Menu setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Menu setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Menu setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Menu setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Menu setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Menu setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Menu setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Menu setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Menu setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 路径资源
		 * @param pathResource 路径资源
		 * @return 当前对象
		*/
		public Menu setPathResource(Resourze pathResource) {
			super.change(PATH_RESOURCE,super.getPathResource(),pathResource);
			super.setPathResource(pathResource);
			return this;
		}
		
		/**
		 * 设置 菜单包含的资源清单
		 * @param resources 菜单包含的资源清单
		 * @return 当前对象
		*/
		public Menu setResources(List<Resourze> resources) {
			super.change(RESOURCES,super.getResources(),resources);
			super.setResources(resources);
			return this;
		}
		
		/**
		 * 设置 上级菜单
		 * @param parent 上级菜单
		 * @return 当前对象
		*/
		public Menu setParent(Menu parent) {
			super.change(PARENT,super.getParent(),parent);
			super.setParent(parent);
			return this;
		}
		
		/**
		 * 设置 页面路径
		 * @param path 页面路径
		 * @return 当前对象
		*/
		public Menu setPath(String path) {
			super.change(PATH,super.getPath(),path);
			super.setPath(path);
			return this;
		}
		
		/**
		 * 设置 资源ID清单
		 * @param resourceIds 资源ID清单
		 * @return 当前对象
		*/
		public Menu setResourceIds(List<String> resourceIds) {
			super.change(RESOURCE_IDS,super.getResourceIds(),resourceIds);
			super.setResourceIds(resourceIds);
			return this;
		}
		
		/**
		 * 设置 祖先名称路径
		 * @param ancestorsNamePath 祖先名称路径
		 * @return 当前对象
		*/
		public Menu setAncestorsNamePath(String ancestorsNamePath) {
			super.change(ANCESTORS_NAME_PATH,super.getAncestorsNamePath(),ancestorsNamePath);
			super.setAncestorsNamePath(ancestorsNamePath);
			return this;
		}
	}
}