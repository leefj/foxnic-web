package com.scientific.tailoring.product.service;
import java.util.List;

import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.product.Label;
import com.scientific.tailoring.domain.product.ProductLabel;
import com.scientific.tailoring.domain.product.meta.ProductLabelMeta;

/**
 * <p>
 * 商品标签关系表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:20
*/

public interface IProductLabelService extends ISuperService<ProductLabel> {

	/**
	 * 按主键删除商品标签关系
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , ProductLabel对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除商品标签关系
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , ProductLabel对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取商品标签关系
	 *
	 * @param id ID
	 * @return 查询结果 , ProductLabel对象
	 */
	ProductLabel getById(Long id);

    List<Label> queryByProductIds(List<Long> productIds);
}