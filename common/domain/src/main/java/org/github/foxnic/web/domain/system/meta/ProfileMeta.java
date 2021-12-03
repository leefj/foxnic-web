package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.Profile;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-03 13:54:38
 * @sign 3738C86354761F63AA720F5DFE2ECC00
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProfileMeta {
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Profile,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Profile.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Profile,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Profile.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Profile,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Profile.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 加载的顺序 , 类型: java.lang.Integer
	*/
	public static final String LOAD_ORDER="loadOrder";
	
	/**
	 * 加载的顺序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Profile,java.lang.Integer> LOAD_ORDER_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Profile.class ,LOAD_ORDER, java.lang.Integer.class, "加载的顺序", "加载的顺序", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , NOTES , LOAD_ORDER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.Profile {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public Profile setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Profile setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Profile setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 加载的顺序
		 * @param loadOrder 加载的顺序
		 * @return 当前对象
		*/
		public Profile setLoadOrder(Integer loadOrder) {
			super.change(LOAD_ORDER,super.getLoadOrder(),loadOrder);
			super.setLoadOrder(loadOrder);
			return this;
		}
	}
}