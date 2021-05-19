package com.scientific.tailoring.product.service.impl;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.CollectorUtil;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.expr.SQL;
import com.scientific.tailoring.crm.service.IFavoriteProductService;
import com.scientific.tailoring.domain.crm.FavoriteProduct;
import com.scientific.tailoring.domain.product.AppProductModel;
import com.scientific.tailoring.domain.product.Fabric;
import com.scientific.tailoring.domain.product.Label;
import com.scientific.tailoring.domain.product.Product;
import com.scientific.tailoring.domain.product.ProductImage;
import com.scientific.tailoring.domain.product.ProductLabel;
import com.scientific.tailoring.domain.product.ProductVO;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.product.service.IProductFabricService;
import com.scientific.tailoring.product.service.IProductImageService;
import com.scientific.tailoring.product.service.IProductLabelService;
import com.scientific.tailoring.product.service.IProductService;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:19
*/

@Service("PrdProductServiceImpl")
public class ProductServiceImpl extends SuperService<Product> implements IProductService {


	@Autowired
	private IProductImageService productImageService;

	@Autowired
	private IFavoriteProductService favoriteProductService;

	@Autowired
	private IProductLabelService productLabelService;

	@Autowired
	private IProductFabricService productFabricService;


	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除商品
	 *
	 * @param id 商品编号 , 详情 : 商品编号
	 * @return 查询结果 , Product对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		Product product = new Product();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		product.setId(id);
		return dao.deleteEntity(product);
	}
	
	/**
	 * 按主键删除商品
	 *
	 * @param id 商品编号 , 详情 : 商品编号
	 * @return 查询结果 , Product对象
	 */
	public boolean deleteByIdLogical(Long id) {
		Product product = new Product();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		product.setId(id);
		product.setDeleted(true);
		return dao.updateEntity(product,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取商品
	 *
	 * @param id 商品编号
	 * @return 查询结果 , Product对象
	 */
	public Product getById(Long id) {
		Product sample = new Product();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public PagedList<AppProductModel> queryPagedEntities4App(Long userId,ProductVO sample, Integer pageSize, Integer pageIndex) {
 
		Expr expr=new Expr("SELECT p.* from prd_product p where  p.deleted=0");
		In in=new In("pl.label_id",sample.getLabelIds());
		ConditionExpr ce=new ConditionExpr();
		ce.andIf("EXISTS ( select 1 from prd_product_label pl where p.id=pl.product_id and pl.deleted=0 "+in.getListParameterSQL()+" )",in.getListParameters());
		ce.andLike("p.name",sample.getName());
		expr.appendIf(ce.startWithAnd());
		expr.append(OrderBy.byDesc("create_time"));

		PagedList<AppProductModel> pList=dao.queryPagedEntities(AppProductModel.class,expr,pageSize,pageIndex);
		dao.join(pList, ProductImage.class,Label.class,Fabric.class,FavoriteProduct.class);
	 
		return pList;
	}

	@Override
	public AppProductModel getById4App(Long userId, Long id) {
		AppProductModel product=this.getById(id).toPojo(AppProductModel.class);
		dao.join(product, ProductImage.class);
		dao.join(product, Label.class);
		dao.join(product, Fabric.class);
		dao.join(product, FavoriteProduct.class);
//		List<Long> productIds=Arrays.asList(product.getId());
//		List<ProductImage> images=productImageService.queryByProductIds(productIds);
//		List<FavoriteProduct> favors=favoriteProductService.queryByProductIds(userId,productIds);
//		List<Label> labels=productLabelService.queryByProductIds(productIds);
//		List<Fabric> fabrics=productFabricService.queryByProductIds(productIds);
//
//		product.setFavor(favors!=null && !favors.isEmpty());
//		product.setImages(images);
//		product.setLabels(labels);
//		product.setFabrics(fabrics);
//		if(images!=null && images.size()>0) {
//			product.setImageId(images.get(0).getFileId());
//		}
		
		return product;
	}
	
 
	public boolean insert(ProductVO product) {
		super.insert(product);
		//保存标签
		saveLabels(product);
		//保存图片
		saveImages(product);
		return true;
	}
 
	public boolean update(ProductVO product) {
		super.update(product,SaveMode.NOT_NULL_FIELDS);
		//保存标签
		saveLabels(product);
		//保存图片
		saveImages(product);
		return true;
	}
	
	
	private void saveImages(ProductVO product) {
		dao.execute("delete from "+productImageService.table()+" where product_id=?",product.getId());
		if(product.getImageIds()!=null) {
			int i=0;
			for (Long imageId : product.getImageIds()) {
				ProductImage pi=new ProductImage();
				pi.setProductId(product.getId()).setFileId(imageId).setChief(i==0);
				productImageService.insert(pi);
				i++;
			}
		}
	}

	private void saveLabels(ProductVO product) {
		dao.execute("delete from "+productLabelService.table()+" where product_id=?",product.getId());
		if(product.getLabelIds()!=null) {
			for (Integer labelId : product.getLabelIds()) {
				ProductLabel pl=new ProductLabel();
				pl.setProductId(product.getId()).setLabelId(labelId);
				productLabelService.insert(pl);
			}
		}
	}
	

}