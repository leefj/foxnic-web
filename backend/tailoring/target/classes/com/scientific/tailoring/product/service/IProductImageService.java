package com.scientific.tailoring.product.service;
import java.util.List;

import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.product.ProductImage;
import com.scientific.tailoring.domain.product.meta.ProductImageMeta;

/**
 * <p>
 * 商品图片表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:20
*/

public interface IProductImageService extends ISuperService<ProductImage> {

	/**
	 * 按主键删除商品图片
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , ProductImage对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除商品图片
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , ProductImage对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取商品图片
	 *
	 * @param id ID
	 * @return 查询结果 , ProductImage对象
	 */
	ProductImage getById(Long id);

    List<ProductImage> queryByProductIds(List<Long> productIds);
}