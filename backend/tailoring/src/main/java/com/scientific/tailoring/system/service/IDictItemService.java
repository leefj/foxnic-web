package com.scientific.tailoring.system.service;
import java.util.List;

import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.system.DictItem;
import com.scientific.tailoring.domain.system.meta.DictItemMeta;
/**
 * <p>
 * 数据字典条目 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-22 01:32:50
*/

public interface IDictItemService extends ISuperService<DictItem> {
	
	

	/**
	 * 按主键删除数据字典条目
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , DictItem对象
	 */
	boolean deleteByIdPhysical(Integer id);
	
	/**
	 * 按主键删除数据字典条目
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , DictItem对象
	 */
	boolean deleteByIdLogical(Integer id);
	
	/**
	 * 按主键获取数据字典条目
	 *
	 * @param id ID
	 * @return 查询结果 , DictItem对象
	 */
	DictItem getById(Integer id);

	List<DictItem> queryByDictCode(String dictCode);

}