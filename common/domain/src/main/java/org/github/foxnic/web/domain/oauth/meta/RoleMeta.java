package org.github.foxnic.web.domain.oauth.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.oauth.Role;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.Menu;
import java.util.List;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 11:05:47
 * @sign 36B23A7F642A6BB9483AEC2EB417A762
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RoleMeta {
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 代码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,CODE, java.lang.String.class, "代码", "代码", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 菜单清单 , 当前角色的所有菜单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Menu
	*/
	public static final String MENUS="menus";
	
	/**
	 * 菜单清单 , 当前角色的所有菜单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Menu
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,org.github.foxnic.web.domain.oauth.Menu> MENUS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,MENUS, java.util.List.class, "菜单清单", "当前角色的所有菜单", org.github.foxnic.web.domain.oauth.Menu.class, null);
	
	/**
	 * 所拥有的菜单ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String MENU_IDS="menuIds";
	
	/**
	 * 所拥有的菜单ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Role,java.lang.String> MENU_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Role.class ,MENU_IDS, java.util.List.class, "所拥有的菜单ID清单", "", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , MENUS , MENU_IDS };
	
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
		 * 设置 菜单清单
		 * @param menus 菜单清单
		 * @return 当前对象
		*/
		public Role setMenus(List<Menu> menus) {
			super.change(MENUS,super.getMenus(),menus);
			super.setMenus(menus);
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