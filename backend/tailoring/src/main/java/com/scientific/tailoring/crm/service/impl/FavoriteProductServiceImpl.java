package com.scientific.tailoring.crm.service.impl;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.Where;
import com.scientific.tailoring.crm.service.IFavoriteProductService;
import com.scientific.tailoring.domain.crm.FavoriteProduct;
import com.scientific.tailoring.domain.crm.FavoriteProductModel;
import com.scientific.tailoring.domain.product.ProductImage;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.product.service.IProductImageService;

/**
 * <p>
 * 商品收藏表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:18
*/

@Service("CrmFavoriteProductServiceImpl")
public class FavoriteProductServiceImpl extends SuperService<FavoriteProduct> implements IFavoriteProductService {

	@Autowired
	private IProductImageService productImageService;

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
	 * 按主键删除商品收藏
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , FavoriteProduct对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		FavoriteProduct favoriteProduct = new FavoriteProduct();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		favoriteProduct.setId(id);
		return dao.deleteEntity(favoriteProduct);
	}
	
	/**
	 * 按主键删除商品收藏
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , FavoriteProduct对象
	 */
	public boolean deleteByIdLogical(Long id) {
		FavoriteProduct favoriteProduct = new FavoriteProduct();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		favoriteProduct.setId(id);
		favoriteProduct.setDeleted(true);
		return dao.updateEntity(favoriteProduct,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取商品收藏
	 *
	 * @param id ID
	 * @return 查询结果 , FavoriteProduct对象
	 */
	public FavoriteProduct getById(Long id) {
		FavoriteProduct sample = new FavoriteProduct();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<FavoriteProduct> queryByProductIds(Long userId, List<Long> productIds) {
		In in=new In("product_id",productIds);
		Expr select=new Expr("select * from crm_favorite_product ");
		Where wh=new Where();
		wh.and(in);
		wh.and("deleted=0");
		select.append(wh);
		return dao.query(select).toEntityList(FavoriteProduct.class);
	}


	@Override
	public List<FavoriteProductModel> queryEntities4App(Long userId,Long folderId) {
		Expr select=new Expr("SELECT fp.*,p.name product_name from crm_favorite_product fp , prd_product p where p.id=fp.product_id " +
				"and fp.deleted=0 and p.deleted=0 and fp.user_id=? and folder_id=? order by fp.create_time desc",userId,folderId);
		List<FavoriteProductModel> list=dao.queryEntities(FavoriteProductModel.class,select);

		//获得全部的ProductId
		List<Long> productIds=list.stream().map(FavoriteProductModel::getProductId).collect(Collectors.toList());

		//查询产品图片并分组
		List<ProductImage> images=productImageService.queryByProductIds(productIds);
		Map<Long, List<ProductImage>> imagesGroups = images.stream().collect(Collectors.groupingBy(ProductImage::getProductId));

		list.forEach(fp->{

			List<ProductImage> imgs=imagesGroups.get(fp.getProductId());
			if(imgs!=null && imgs.size()>0) {
				fp.setImageId(imgs.get(0).getFileId());
			}

		});

		return list;

	}

}