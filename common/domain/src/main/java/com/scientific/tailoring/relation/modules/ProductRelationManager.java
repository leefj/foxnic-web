package com.scientific.tailoring.relation.modules;

import com.github.foxnic.dao.relation.PropertyRoute.DynamicValue;
import com.github.foxnic.dao.relation.RelationManager;
import com.scientific.tailoring.constants.db.Tailoring.CRM_FAVORITE_PRODUCT;
import com.scientific.tailoring.constants.db.Tailoring.PRD_FABRIC;
import com.scientific.tailoring.constants.db.Tailoring.PRD_LABEL;
import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT;
import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT_FABRIC;
import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT_IMAGE;
import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT_LABEL;
import com.scientific.tailoring.constants.db.Tailoring.PRD_VIRTUAL_LIBRARY;
import com.scientific.tailoring.domain.crm.FavoriteProduct;
import com.scientific.tailoring.domain.product.Fabric;
import com.scientific.tailoring.domain.product.Label;
import com.scientific.tailoring.domain.product.Product;
import com.scientific.tailoring.domain.product.ProductFabric;
import com.scientific.tailoring.domain.product.ProductImage;
import com.scientific.tailoring.domain.product.VirtualLibrary;

public class ProductRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupRelations();
		this.setupProperties();
	}
 
	@SuppressWarnings("unchecked")
	private void setupProperties() {
		
		//图片清单
		this.property(Product.class, "images",ProductImage.class, "商品图片清单", "")
			.type(ProductImage.class).list()
			.using(PRD_PRODUCT.ID)
			.addOrderBy(PRD_PRODUCT_IMAGE.IS_CHIEF, false, true)
			.addOrderBy( PRD_PRODUCT_IMAGE.CREATE_TIME, false, true)
			.after((s,list)->{
				//主图ID取第一个
				if(list!=null && !list.isEmpty()) {
					s.setImageId(list.get(0).getFileId());
				}
				return list;
			});
		
		//主图ID
		this.property(Product.class, "imageId",ProductImage.class, "主图ID", "")
			.type(Long.class).single()
			.ignoreJoin();
		
		//面料清单
		this.property(Product.class, "fabrics",Fabric.class, "面料清单", "").type(Fabric.class).list()
			.using(PRD_PRODUCT.ID)
			.addRoute(PRD_PRODUCT_FABRIC.$TABLE)
			//
			.addRoute(PRD_VIRTUAL_LIBRARY.$TABLE)
			.addCondition(PRD_VIRTUAL_LIBRARY.$TABLE, "valid=1 and deleted=0")
			//
			.addOrderBy(PRD_PRODUCT_FABRIC.CREATE_TIME, false, true);
		
		//标签ID
		this.property(Product.class, "labels",Label.class, "标签清单", "").type(Label.class).list()
			.using(PRD_PRODUCT.ID)
			.addRoute(PRD_PRODUCT_LABEL.$TABLE)
			.addOrderBy(PRD_PRODUCT_LABEL.CREATE_TIME, false, true);
 
		//是否收藏
		this.property(Product.class, "isFavor",FavoriteProduct.class, "是否收藏", "").type(Boolean.class).single()
			.groupForCount()
			.condition(CRM_FAVORITE_PRODUCT.USER_ID,DynamicValue.LOGIN_USER_ID)
			.after((s,list)->{
				s.setFavor(list.size()>0);
				return list;
			});
 
		//商品面料 - 虚拟试衣
		this.property(ProductFabric.class,"virtual",VirtualLibrary.class,"虚拟试衣信息","")
			.using(PRD_PRODUCT_FABRIC.VIRTUAL_ID)
			.single();
 
		// 关联商品
		this.property(VirtualLibrary.class, "product", Product.class, "商品", "")
			.using(PRD_VIRTUAL_LIBRARY.PRODUCT_ID)
			.single()
			.fork(32);
		
		// 关联面料
		this.property(VirtualLibrary.class, "fabric", Fabric.class, "面料", "")
			.using(PRD_VIRTUAL_LIBRARY.FABRIC_ID)
			.single()
			.fork(32);

		
		
	}

 
	private void setupRelations() {
		
		//商品 - 商品图片
		this.from( PRD_PRODUCT.ID ).join( PRD_PRODUCT_IMAGE.PRODUCT_ID );
		
		//商品 - 面料关系
		this.from( PRD_PRODUCT.ID ).join( PRD_PRODUCT_FABRIC.PRODUCT_ID );
		//面料关系 - 面料
		this.from( PRD_PRODUCT_FABRIC.FABRIC_ID ).join( PRD_FABRIC.ID );
		
		//商品 - 标签关系
		this.from( PRD_PRODUCT.ID ).join( PRD_PRODUCT_LABEL.PRODUCT_ID );
		//标签关系 - 标签
		this.from( PRD_PRODUCT_LABEL.LABEL_ID ).join( PRD_LABEL.ID );
		
		//商品 - 收藏
		this.from( PRD_PRODUCT.ID ).join( CRM_FAVORITE_PRODUCT.PRODUCT_ID );
 
		// 虚拟试用 - 产品
		this.from( PRD_VIRTUAL_LIBRARY.PRODUCT_ID ).join( PRD_PRODUCT.ID );
		// 虚拟试用 - 材料
		this.from( PRD_VIRTUAL_LIBRARY.FABRIC_ID ).join( PRD_FABRIC.ID );
 
		//面料关系 - 面料
		this.from( PRD_PRODUCT_FABRIC.VIRTUAL_ID ).join( PRD_VIRTUAL_LIBRARY.ID );

	}

}
