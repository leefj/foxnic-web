package com.scientific.tailoring.product.service;
import java.util.List;

import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.product.Label;
import com.scientific.tailoring.domain.product.LabelNodeModel;
import com.scientific.tailoring.domain.product.meta.LabelMeta;

/**
 * <p>
 * 产品标签表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:19
*/

public interface ILabelService extends ISuperService<Label> {

	/**
	 * 按主键删除产品标签
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , Label对象
	 */
	boolean deleteByIdPhysical(Integer id);
	
	/**
	 * 按主键删除产品标签
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , Label对象
	 */
	boolean deleteByIdLogical(Integer id);
 
	/**
	 * 按主键获取产品标签
	 *
	 * @param id id
	 * @return 查询结果 , Label对象
	 */
	Label getById(Integer id);

	/**
	 * 创建分层结构
	 * */
    List<LabelNodeModel> getLabelTree(Long userId);
}