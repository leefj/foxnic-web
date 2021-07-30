package org.github.foxnic.web.domain.oauth.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.oauth.UserVO;
import java.util.List;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-30 14:20:08
 * @sign 8EB92A4405006DDB4A66D484B08719F4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserVOMeta extends UserMeta {
	
	/**
	 * 页码
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.Integer> PAGE_INDEX_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.Integer> PAGE_SIZE_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> SEARCH_FIELD_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> FUZZY_FIELD_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> SEARCH_VALUE_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 排序字段
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> SORT_FIELD_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> SORT_TYPE_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> IDS_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 角色ID列表
	*/
	public static final String ROLE_IDS="roleIds";
	
	/**
	 * 角色ID列表
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.UserVO,java.lang.String> ROLE_IDS_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.UserVO.class ,ROLE_IDS, java.util.List.class, "角色ID列表", "", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , SORT_FIELD , SORT_TYPE , IDS , ROLE_IDS };
	
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
	}
}