package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.Dict;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import java.util.List;
import org.github.foxnic.web.domain.oauth.Menu;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-22 09:57:51
 * @sign 5D7BBBCC1F54C8563F918409E82934F5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DictMeta {
	
	/**
	 * 字典ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 字典ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,ID, java.lang.String.class, "字典ID", "字典ID", java.lang.String.class, null);
	
	/**
	 * 是否树形结构 , 类型: java.lang.Integer
	*/
	public static final String IS_TREE="isTree";
	
	/**
	 * 是否树形结构 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.lang.Integer> IS_TREE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,IS_TREE, java.lang.Integer.class, "是否树形结构", "是否树形结构", java.lang.Integer.class, null);
	
	/**
	 * 字典名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 字典名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,NAME, java.lang.String.class, "字典名称", "字典名称", java.lang.String.class, null);
	
	/**
	 * 字典代码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 字典代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,CODE, java.lang.String.class, "字典代码", "字典代码", java.lang.String.class, null);
	
	/**
	 * 所属模块 , 类型: java.lang.String
	*/
	public static final String MODULE="module";
	
	/**
	 * 所属模块 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.lang.String> MODULE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,MODULE, java.lang.String.class, "所属模块", "所属模块", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 字典项目 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String ITEMS="items";
	
	/**
	 * 字典项目 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,org.github.foxnic.web.domain.system.DictItem> ITEMS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,ITEMS, java.util.List.class, "字典项目", "", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 关联模块 , 类型: org.github.foxnic.web.domain.oauth.Menu
	*/
	public static final String MODULE_INFO="moduleInfo";
	
	/**
	 * 关联模块 , 类型: org.github.foxnic.web.domain.oauth.Menu
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Dict,org.github.foxnic.web.domain.oauth.Menu> MODULE_INFO_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Dict.class ,MODULE_INFO, org.github.foxnic.web.domain.oauth.Menu.class, "关联模块", "", org.github.foxnic.web.domain.oauth.Menu.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , IS_TREE , NAME , CODE , MODULE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ITEMS , MODULE_INFO };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.Dict {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 字典ID
		 * @param id 字典ID
		 * @return 当前对象
		*/
		public Dict setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 是否树形结构
		 * @param isTree 是否树形结构
		 * @return 当前对象
		*/
		public Dict setIsTree(Integer isTree) {
			super.change(IS_TREE,super.getIsTree(),isTree);
			super.setIsTree(isTree);
			return this;
		}
		
		/**
		 * 设置 字典名称
		 * @param name 字典名称
		 * @return 当前对象
		*/
		public Dict setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 字典代码
		 * @param code 字典代码
		 * @return 当前对象
		*/
		public Dict setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 所属模块
		 * @param module 所属模块
		 * @return 当前对象
		*/
		public Dict setModule(String module) {
			super.change(MODULE,super.getModule(),module);
			super.setModule(module);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Dict setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Dict setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Dict setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Dict setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Dict setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Dict setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Dict setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Dict setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Dict setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 字典项目
		 * @param items 字典项目
		 * @return 当前对象
		*/
		public Dict setItems(List<DictItem> items) {
			super.change(ITEMS,super.getItems(),items);
			super.setItems(items);
			return this;
		}
		
		/**
		 * 设置 关联模块
		 * @param moduleInfo 关联模块
		 * @return 当前对象
		*/
		public Dict setModuleInfo(Menu moduleInfo) {
			super.change(MODULE_INFO,super.getModuleInfo(),moduleInfo);
			super.setModuleInfo(moduleInfo);
			return this;
		}
	}
}