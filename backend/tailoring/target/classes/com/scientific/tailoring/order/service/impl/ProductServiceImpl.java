package com.scientific.tailoring.order.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.scientific.tailoring.domain.product.ProductImage;
import com.scientific.tailoring.domain.product.ProductOrderModel;
import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.Expr;
import com.scientific.tailoring.domain.order.Product;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.order.service.IProductService;

/**
 * <p>
 * 订单商品关系表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:38
*/

@Service("OdrProductServiceImpl")
public class ProductServiceImpl extends SuperService<Product> implements IProductService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除订单商品关系
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Product对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		Product product = new Product();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		product.setId(id);
		return dao.deleteEntity(product);
	}
	
	/**
	 * 按主键删除订单商品关系
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Product对象
	 */
	public boolean deleteByIdLogical(Long id) {
		Product product = new Product();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		product.setId(id);
		product.setDeleted(true);
		product.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		product.setDeleteTime(new Date());
		return dao.updateEntity(product,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取订单商品关系
	 *
	 * @param id ID
	 * @return 查询结果 , Product对象
	 */
	public Product getById(Long id) {
		Product sample = new Product();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}
	
	@Override
	public PagedList<ProductOrderModel> queryPagedList(Long orderId, int pageSize, int pageIndex) {
		Expr select=new Expr("SELECT p.*,op.id order_product_rel_id from prd_product p,odr_product op where p.id=op.product_id and op.order_id=? and p.deleted=0",orderId);
		PagedList<ProductOrderModel> list=dao.queryPagedEntities(ProductOrderModel.class,select, pageSize, pageIndex);
		dao.join(list, ProductImage.class);
		return list;
	}

	@Override
	public List<com.scientific.tailoring.domain.product.Product> queryUnusedProducts(Long orderId, String keyword) {
		Expr select=new Expr("SELECT * from prd_product p where not exists (select 1 from odr_product op where p.id=op.product_id and op.order_id=? and deleted=0 )",orderId);
		List<com.scientific.tailoring.domain.product.Product> list=dao.queryEntities(com.scientific.tailoring.domain.product.Product.class,select);
		return list;
	}

}