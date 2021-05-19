package com.scientific.tailoring.product.service;
import java.util.List;

import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.product.Fabric;
import com.scientific.tailoring.domain.product.ProductFabric;
import com.scientific.tailoring.domain.product.ProductFabricModel;
import com.scientific.tailoring.domain.product.meta.ProductFabricMeta;

/**
 * <p>
 * 商品面料关系表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:19
*/

public interface IProductFabricService extends ISuperService<ProductFabric> {

	/**
	 * 按主键删除商品面料关系
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , ProductFabric对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除商品面料关系
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , ProductFabric对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取商品面料关系
	 *
	 * @param id ID
	 * @return 查询结果 , ProductFabric对象
	 */
	ProductFabric getById(Long id);

    List<Fabric> queryByProductIds(List<Long> productIds);

    /**
     * 查询未被商品使用过的面料清单
     * */
	List<Fabric> queryUnusedFabrics(Long productId,String searchkey);
	
	PagedList<ProductFabricModel> queryPagedListByProduct(ProductFabric sample, int pageSize, int pageIndex);
}