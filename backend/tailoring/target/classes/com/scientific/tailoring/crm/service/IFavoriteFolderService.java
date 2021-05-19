package com.scientific.tailoring.crm.service;
import java.util.Map;

import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.crm.FavoriteFolder;
import com.scientific.tailoring.domain.crm.meta.FavoriteFolderMeta;

/**
 * <p>
 * 商品收藏分类表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:18
*/

public interface IFavoriteFolderService extends ISuperService<FavoriteFolder> {

	/**
	 * 按主键删除商品收藏分类
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , FavoriteFolder对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除商品收藏分类
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , FavoriteFolder对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取商品收藏分类
	 *
	 * @param id ID
	 * @return 查询结果 , FavoriteFolder对象
	 */
	FavoriteFolder getById(Long id);

	/**
	 * 统计目录下收藏的商品数量
	 * */
    Map<Long, Integer> queryProductCountMap(Long sessionUserId);
}