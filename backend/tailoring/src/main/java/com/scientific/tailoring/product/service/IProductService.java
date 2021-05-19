package com.scientific.tailoring.product.service;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.product.AppProductModel;
import com.scientific.tailoring.domain.product.Product;
import com.scientific.tailoring.domain.product.ProductVO;
import com.scientific.tailoring.domain.product.meta.ProductMeta;

/**
 * <p>
 * 商品表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:19
*/

public interface IProductService extends ISuperService<Product> {

	/**
	 * 按主键删除商品
	 *
	 * @param id 商品编号 , 详情 : 商品编号
	 * @return 查询结果 , Product对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除商品
	 *
	 * @param id 商品编号 , 详情 : 商品编号
	 * @return 查询结果 , Product对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取商品
	 *
	 * @param id 商品编号
	 * @return 查询结果 , Product对象
	 */
	Product getById(Long id);

    PagedList<AppProductModel> queryPagedEntities4App(Long userId,ProductVO sample, Integer pageSize, Integer pageIndex);

	AppProductModel getById4App(Long sessionUserId, Long id);
	
	boolean insert(ProductVO product);
	
	 
	boolean update(ProductVO product);
}