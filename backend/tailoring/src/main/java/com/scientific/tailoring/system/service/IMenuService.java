package com.scientific.tailoring.system.service;
import java.util.List;

import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.system.Menu;
import com.scientific.tailoring.domain.system.MenuNodeModel;
import com.scientific.tailoring.domain.system.meta.MenuMeta;
/**
 * <p>
 * 功能菜单表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:17
*/

public interface IMenuService extends ISuperService<Menu> {

	/**
	 * 按主键删除功能菜单
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , Menu对象
	 */
	boolean deleteByIdPhysical(Integer id);
	
	/**
	 * 按主键删除功能菜单
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , Menu对象
	 */
	boolean deleteByIdLogical(Integer id);
	
	/**
	 * 按主键获取功能菜单
	 *
	 * @param id id
	 * @return 查询结果 , Menu对象
	 */
	Menu getById(Integer id);

	List<MenuNodeModel> getMenuTree(Long userId);
}