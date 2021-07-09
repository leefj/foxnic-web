package org.github.foxnic.web.domain.oauth.meta;

import org.github.foxnic.web.domain.oauth.Role;
import java.util.Date;
import java.util.List;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-09 14:41:36
 * @sign 1F90BD51C3FC6E1A48BF87186F8886A3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RoleMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 代码
	*/
	public static final String CODE="code";
	
	/**
	 * 名称
	*/
	public static final String NAME="name";
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 数据版本号
	*/
	public static final String VERSION="version";
	
	/**
	 * 所拥有的菜单ID清单
	*/
	public static final String MENU_IDS="menuIds";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , MENU_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.oauth.Role {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public Role setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 代码
		 * @param code 代码
		 * @return 当前对象
		*/
		public Role setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Role setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Role setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Role setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Role setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Role setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Role setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Role setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Role setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Role setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 所拥有的菜单ID清单
		 * @param menuIds 所拥有的菜单ID清单
		 * @return 当前对象
		*/
		public Role setMenuIds(List<String> menuIds) {
			super.change(MENU_IDS,super.getMenuIds(),menuIds);
			super.setMenuIds(menuIds);
			return this;
		}
	}
}