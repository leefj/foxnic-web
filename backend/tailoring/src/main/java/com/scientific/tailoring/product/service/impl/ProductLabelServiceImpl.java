package com.scientific.tailoring.product.service.impl;
import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.In;
import com.scientific.tailoring.domain.product.Label;
import com.scientific.tailoring.domain.product.ProductLabel;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.product.service.IProductLabelService;

/**
 * <p>
 * 商品标签关系表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:20
*/

@Service("PrdProductLabelServiceImpl")
public class ProductLabelServiceImpl extends SuperService<ProductLabel> implements IProductLabelService {
	
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
	 * 按主键删除商品标签关系
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , ProductLabel对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		ProductLabel productLabel = new ProductLabel();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		productLabel.setId(id);
		return dao.deleteEntity(productLabel);
	}
	
	/**
	 * 按主键删除商品标签关系
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , ProductLabel对象
	 */
	public boolean deleteByIdLogical(Long id) {
		ProductLabel productLabel = new ProductLabel();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		productLabel.setId(id);
		productLabel.setDeleted(true);
		return dao.updateEntity(productLabel,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取商品标签关系
	 *
	 * @param id ID
	 * @return 查询结果 , ProductLabel对象
	 */
	public ProductLabel getById(Long id) {
		ProductLabel sample = new ProductLabel();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Label> queryByProductIds(List<Long> productIds) {
		In in=new In("pl.product_id",productIds);
		Expr select=new Expr("select l.* from prd_product_label pl, prd_label l where l.id=pl.label_id and l.deleted=0 and pl.deleted=0");
		ConditionExpr wh=new ConditionExpr();
		wh.startWithAnd();
		wh.and(in);
		select.append(wh);
		return dao.query(select).toEntityList(Label.class);
	}

}