package com.scientific.tailoring.domain.system.meta;

import com.scientific.tailoring.domain.system.UserVO;
import java.util.List;



/**
 * @author 李方捷
 * @since 2021-05-17 10:53:40
 * @sign 3FA5CF2226CBD6353EDB86F1B0D5A218
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserVOMeta extends UserMeta {
	
	/**
	 * 页码
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 分页大小
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 搜索字段
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索的值
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 主键清单 , 用于接收批量主键参数
	*/
	public static final String IDS="ids";
	
	/**
	 * 角色ID清单
	*/
	public static final String ROLE_IDS="roleIds";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , SEARCH_VALUE , IDS , ROLE_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.system.UserVO {
		
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
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public UserVO setIds(List<Long> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
				return this;
		}
		
		/**
		 * 设置 角色ID清单
		 * @param roleIds 角色ID清单
		 * @return 当前对象
		*/
		public UserVO setRoleIds(List<Integer> roleIds) {
			super.change(ROLE_IDS,super.getRoleIds(),roleIds);
			super.setRoleIds(roleIds);
				return this;
		}
}
}