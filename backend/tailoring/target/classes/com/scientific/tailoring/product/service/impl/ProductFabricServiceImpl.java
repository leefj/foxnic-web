package com.scientific.tailoring.product.service.impl;
import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.SQL;
import com.scientific.tailoring.domain.product.Fabric;
import com.scientific.tailoring.domain.product.ProductFabric;
import com.scientific.tailoring.domain.product.ProductFabricModel;
import com.scientific.tailoring.domain.product.VirtualLibrary;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.product.service.IProductFabricService;
import com.scientific.tailoring.product.service.IVirtualLibraryService;

/**
 * <p>
 * 商品面料关系表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:19
*/

@Service("PrdProductFabricServiceImpl")
public class ProductFabricServiceImpl extends SuperService<ProductFabric> implements IProductFabricService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
 
	@Autowired
	private IVirtualLibraryService virtualLibraryService;
	
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
	
	@Override
	public PagedList<ProductFabricModel> queryPagedListByProduct(ProductFabric sample, int pageSize, int pageIndex) {
		SQL expr=new Expr( dao.getSQL("#productfabric.page-list"),sample.getProductId());
//		Expr expr=new Expr(ProductSQLs.fabric_page_list,sample.getProductId());
		PagedList<ProductFabricModel> list=dao.queryPagedEntities(ProductFabricModel.class,expr, pageSize, pageIndex);
		dao.join(list,VirtualLibrary.class);
		return list;
	}
	
	
	@Override
	public boolean insert(ProductFabric entity) {

		VirtualLibrary vl=new VirtualLibrary();
		vl.setProductId(entity.getProductId());
		vl.setFabricId(entity.getFabricId());
		vl.setValid(true);
		vl.setDeleted(false);
		VirtualLibrary virtualLibrary=dao.queryEntity(vl);
		if(virtualLibrary==null) {
			return false;
		}
		entity.setVirtualId(virtualLibrary.getId());
		super.insert(entity);

		return true;
	}
	
	/**
	 * 按主键删除商品面料关系
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , ProductFabric对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		ProductFabric productFabric = new ProductFabric();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		productFabric.setId(id);
		return dao.deleteEntity(productFabric);
	}
	
	/**
	 * 按主键删除商品面料关系
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , ProductFabric对象
	 */
	public boolean deleteByIdLogical(Long id) {
		ProductFabric productFabric = new ProductFabric();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		productFabric.setId(id);
		productFabric.setDeleted(true);
		return dao.updateEntity(productFabric,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取商品面料关系
	 *
	 * @param id ID
	 * @return 查询结果 , ProductFabric对象
	 */
	public ProductFabric getById(Long id) {
		ProductFabric sample = new ProductFabric();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}


	@Override
	public List<Fabric> queryByProductIds(List<Long> productIds) {
		In in=new In("pf.product_id",productIds);
		Expr select=new Expr("select f.* from prd_product_fabric pf, prd_fabric f where f.id=pf.fabric_id and f.deleted=0 and pf.deleted=0");
		ConditionExpr wh=new ConditionExpr();
		wh.startWithAnd();
		wh.and(in);
		select.append(wh);
		return dao.query(select).toEntityList(Fabric.class);
	}

	@Override
	public List<Fabric> queryUnusedFabrics(Long productId,String searchkey) {
		ConditionExpr ce=new ConditionExpr();
		ce.andLike("short_name", searchkey);
		Expr expr=new Expr("select * from prd_fabric f where not exists(select 1 from prd_product_fabric pf where product_id=? and f.id=pf.fabric_id) and deleted=0",productId);
		expr.appendIf(ce.startWithAnd());
		return dao.queryEntities(Fabric.class,expr);
	}

}