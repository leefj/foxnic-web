package com.scientific.tailoring.domain.system;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 11:36:04
 * @sign D3345B01EBB779EF5591DC8E57A53353
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MenuNodeModel extends Menu {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 是否隐藏
	*/
	@ApiModelProperty(required = false,value="是否隐藏" , notes = "")
	private Boolean hidden;
	
	/**
	 * 下级菜单节点
	*/
	@ApiModelProperty(required = false,value="下级菜单节点" , notes = "")
	private List<MenuNodeModel> subMenus;
	
	/**
	 * 获得 是否隐藏<br>
	 * @return 是否隐藏
	*/
	public Boolean isHidden() {
		return hidden;
	}
	
	/**
	 * 获得 是否隐藏<br>
	 * 等价于 isHidden 方法，为兼容 Swagger 需要
	 * @return 是否隐藏
	*/
	public Boolean getHidden() {
		return this.hidden;
	}
	
	/**
	 * 设置 是否隐藏
	 * @param hidden 是否隐藏
	 * @return 当前对象
	*/
	public MenuNodeModel setHidden(Boolean hidden) {
		this.hidden=hidden;
		return this;
	}
	
	/**
	 * 添加 是否隐藏
	 * @param hidden 是否隐藏
	 * @return 当前对象
	*/
	
	/**
	 * 获得 下级菜单节点<br>
	 * @return 下级菜单节点
	*/
	public List<MenuNodeModel> getSubMenus() {
		return subMenus;
	}
	
	/**
	 * 设置 下级菜单节点
	 * @param subMenus 下级菜单节点
	 * @return 当前对象
	*/
	public MenuNodeModel setSubMenus(List<MenuNodeModel> subMenus) {
		this.subMenus=subMenus;
		return this;
	}
	
	/**
	 * 添加 下级菜单节点
	 * @param subMenus 下级菜单节点
	 * @return 当前对象
	*/
	public MenuNodeModel addSubMenu(MenuNodeModel subMenu) {
		if(this.subMenus==null) subMenus=new ArrayList<>();
		this.subMenus.add(subMenu);
		return this;
	}
}