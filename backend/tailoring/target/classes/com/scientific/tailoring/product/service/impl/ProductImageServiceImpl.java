package com.scientific.tailoring.product.service.impl;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.Where;
import com.scientific.tailoring.domain.product.ProductImage;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.product.service.IProductImageService;

/**
 * <p>
 * 商品图片表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:20
*/

@Service("PrdProductImageServiceImpl")
public class ProductImageServiceImpl extends SuperService<ProductImage> implements IProductImageService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 生成主键值
	 * */
	@Override
	public Object generateId(Field field) {
		return null;
	}
	
	/**
	 * 按主键删除商品图片
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , ProductImage对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		ProductImage productImage = new ProductImage();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		productImage.setId(id);
		return dao.deleteEntity(productImage);
	}
	
	/**
	 * 按主键删除商品图片
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , ProductImage对象
	 */
	public boolean deleteByIdLogical(Long id) {
		ProductImage productImage = new ProductImage();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		productImage.setId(id);
		productImage.setDeleted(true);
		return dao.updateEntity(productImage,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取商品图片
	 *
	 * @param id ID
	 * @return 查询结果 , ProductImage对象
	 */
	public ProductImage getById(Long id) {
		ProductImage sample = new ProductImage();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<ProductImage> queryByProductIds(List<Long> productIds) {
		In in=new In("product_id",productIds);
		if(in.isEmpty()) {
			return new ArrayList<ProductImage>();
		}
		Expr select=new Expr("select * from prd_product_image ");
		Where wh=new Where();
		wh.and(in);
		wh.and("deleted=0");
		select.append(wh);
		select.append("order by product_id,is_chief desc");
		return dao.query(select).toEntityList(ProductImage.class);
	}

}