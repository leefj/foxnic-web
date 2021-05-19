package com.scientific.tailoring.crm.service;
import java.util.List;

import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.crm.FavoriteProduct;
import com.scientific.tailoring.domain.crm.FavoriteProductModel;
import com.scientific.tailoring.domain.crm.meta.FavoriteProductMeta;

/**
 * <p>
 * 商品收藏表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:18
*/

public interface IFavoriteProductService extends ISuperService<FavoriteProduct> {
	
	/**
	 * 按主键删除商品收藏
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , FavoriteProduct对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除商品收藏
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , FavoriteProduct对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取商品收藏
	 *
	 * @param id ID
	 * @return 查询结果 , FavoriteProduct对象
	 */
	FavoriteProduct getById(Long id);

    List<FavoriteProduct> queryByProductIds(Long userId, List<Long> productIds);


	List<FavoriteProductModel> queryEntities4App(Long userId,Long folderId);
}