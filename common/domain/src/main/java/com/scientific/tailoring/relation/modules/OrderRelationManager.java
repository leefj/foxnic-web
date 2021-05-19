package com.scientific.tailoring.relation.modules;

import com.github.foxnic.dao.relation.Catalog;
import com.github.foxnic.dao.relation.RelationManager;
import com.scientific.tailoring.constants.db.Tailoring.CRM_COMPANY;
import com.scientific.tailoring.constants.db.Tailoring.ODR_MEASURE;
import com.scientific.tailoring.constants.db.Tailoring.ODR_ORDER;
import com.scientific.tailoring.constants.db.Tailoring.ODR_PRODUCT;
import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT;
import com.scientific.tailoring.constants.db.Tailoring.SYS_DICT_ITEM;
import com.scientific.tailoring.constants.enums.DictEnum;
import com.scientific.tailoring.domain.crm.Company;
import com.scientific.tailoring.domain.order.Measure;
import com.scientific.tailoring.domain.order.Order;
import com.scientific.tailoring.domain.order.meta.MeasureMeta;
import com.scientific.tailoring.domain.system.DictItem;

public class OrderRelationManager extends RelationManager {
 
	@Override
	protected void config() {
		this.setupRelations();
		this.setupProperties();
	}
	
	private void setupProperties() {
		// 统计测量总量
		this.property(Order.class, "measureCount", Measure.class, "测量总量", "").type(Integer.class)
			.using(ODR_ORDER.ID)
			.addConditionEquals(ODR_MEASURE.DELETED, 0)
			.groupForCount().single();
		
		// 分状态统计测量总量
		this.property(Order.class, "measureStatusCount", Measure.class, "测量总量", "").type(Catalog.class)
			.addConditionEquals(ODR_MEASURE.DELETED, 0)
			.using(ODR_ORDER.ID)
			.groupForCount(MeasureMeta.STATUS).single();
		
		// 公司信息
		this.property(Order.class, "company", Company.class, "公司信息", "")
		.using(ODR_ORDER.COMPANY_ID).single();
		
		// 订单状态信息
		this.property(Order.class, "statusDictItem", DictItem.class, "状态信息", "")
		.addConditionEquals(SYS_DICT_ITEM.DICT_CODE, DictEnum.ORDER_STATUS.code())
		.using(ODR_ORDER.STATUS).single();
		
 
		// 测量状态信息
		this.property(Measure.class, "statusDictItem", DictItem.class, "状态信息", "")
		.addConditionEquals(SYS_DICT_ITEM.DICT_CODE, DictEnum.MEASURE_STATUS.code())
		.using(ODR_MEASURE.STATUS).single();
		
	}

 
	
	private void setupRelations() {
		//订单 - 测量
		this.from( ODR_ORDER.ID ).join( ODR_MEASURE.ORDER_ID );
		// 订单 - 订单商品关系
		this.from( ODR_ORDER.ID ).join( ODR_PRODUCT.ORDER_ID );
		//订单商品关系 - 商品
		this.from( ODR_PRODUCT.PRODUCT_ID ).join( PRD_PRODUCT.ID );
		//订单 - 公司
		this.from( ODR_ORDER.COMPANY_ID ).join( CRM_COMPANY.ID );
		//订单 - 状态
		this.from( ODR_ORDER.STATUS ).join( SYS_DICT_ITEM.CODE );
		//测量 - 状态
		this.from( ODR_MEASURE.STATUS ).join( SYS_DICT_ITEM.CODE );
	}

	

}
