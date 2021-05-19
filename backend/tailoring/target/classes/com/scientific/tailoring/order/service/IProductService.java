package com.scientific.tailoring.order.service;
import java.util.List;

import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.order.Product;
import com.scientific.tailoring.domain.product.ProductOrderModel;

public interface IProductService extends ISuperService<Product> {

	/**
	 * 按主键删除订单商品关系
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Product对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除订单商品关系
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Product对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取订单商品关系
	 *
	 * @param id ID
	 * @return 查询结果 , Product对象
	 */
	Product getById(Long id);
	
	PagedList<ProductOrderModel> queryPagedList(Long orderId, int pageSize, int pageIndex);
	
	List<com.scientific.tailoring.domain.product.Product> queryUnusedProducts(Long orderId,String keyword);

}