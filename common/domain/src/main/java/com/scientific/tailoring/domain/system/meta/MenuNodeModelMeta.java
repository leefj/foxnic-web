package com.scientific.tailoring.domain.system.meta;

import com.scientific.tailoring.domain.system.MenuNodeModel;
import java.util.List;



/**
 * @author 李方捷
 * @since 2021-05-17 11:36:04
 * @sign D3345B01EBB779EF5591DC8E57A53353
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MenuNodeModelMeta {
	
	/**
	 * 是否隐藏
	*/
	public static final String HIDDEN="hidden";
	
	/**
	 * 下级菜单节点
	*/
	public static final String SUB_MENUS="subMenus";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ HIDDEN , SUB_MENUS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.system.MenuNodeModel {
		
		/**
		 * 设置 是否隐藏
		 * @param hidden 是否隐藏
		 * @return 当前对象
		*/
		public MenuNodeModel setHidden(Boolean hidden) {
			super.change(HIDDEN,super.isHidden(),hidden);
			super.setHidden(hidden);
				return this;
		}
		
		/**
		 * 设置 下级菜单节点
		 * @param subMenus 下级菜单节点
		 * @return 当前对象
		*/
		public MenuNodeModel setSubMenus(List<MenuNodeModel> subMenus) {
			super.change(SUB_MENUS,super.getSubMenus(),subMenus);
			super.setSubMenus(subMenus);
				return this;
		}
}
}