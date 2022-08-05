package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
//import org.github.foxnic.web.constants.db.ExampleTables;


public class ExampleRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupOrder();
	}

	public void setupOrder() {

		// Order
//		this.property(OrderMeta.ADDRESS_PROP)
//				.using(ExampleTables.EXAMPLE_ORDER.ADDRESS_ID).join(ExampleTables.EXAMPLE_ADDRESS.ID)
//				.cache(true);
//
//		this.property(OrderMeta.GOODS_LIST_PROP)
//				.using(ExampleTables.EXAMPLE_ORDER.ID).join(ExampleTables.EXAMPLE_ORDER_ITEM.ORDER_ID)
//				.using(ExampleTables.EXAMPLE_ORDER_ITEM.GOODS_ID).join(ExampleTables.EXAMPLE_GOODS.ID)
//				.cache(true);
//
//
//		this.property(OrderMeta.ITEM_LIST_PROP)
//				.using(ExampleTables.EXAMPLE_ORDER.ID).join(ExampleTables.EXAMPLE_ORDER_ITEM.ORDER_ID)
//				.cache(true);
//
//
//		// order item
//
//		this.property(OrderItemMeta.ORDER_PROP)
//				.using(ExampleTables.EXAMPLE_ORDER_ITEM.ORDER_ID).join(ExampleTables.EXAMPLE_ORDER.ID)
//				.cache(true);
//
//		this.property(OrderItemMeta.GOODS_PROP)
//				.using(ExampleTables.EXAMPLE_ORDER_ITEM.GOODS_ID).join(ExampleTables.EXAMPLE_GOODS.ID)
//				.cache(true);
//
//
//		// Goods
//
//		this.property(GoodsMeta.ORDER_LIST_PROP)
//				.using(ExampleTables.EXAMPLE_GOODS.ID).join(ExampleTables.EXAMPLE_ORDER_ITEM.GOODS_ID)
//				.using(ExampleTables.EXAMPLE_ORDER_ITEM.ORDER_ID).join(ExampleTables.EXAMPLE_ORDER.ID)
//				.cache(true);
//
//		this.property(GoodsMeta.ADDRESS_LIST_PROP)
//				.using(ExampleTables.EXAMPLE_GOODS.ID).join(ExampleTables.EXAMPLE_ORDER_ITEM.GOODS_ID)
//				.using(ExampleTables.EXAMPLE_ORDER_ITEM.ORDER_ID).join(ExampleTables.EXAMPLE_ORDER.ID)
//				.using(ExampleTables.EXAMPLE_ORDER.ADDRESS_ID).join(ExampleTables.EXAMPLE_ADDRESS.ID)
//				.cache(true);
//
//		this.property(GoodsMeta.ITEM_LIST_PROP)
//				.using(ExampleTables.EXAMPLE_GOODS.ID).join(ExampleTables.EXAMPLE_ORDER_ITEM.GOODS_ID)
//				.cache(true);
//
//
//		// Address
//
//		this.property(AddressMeta.ORDER_LIST_PROP)
//				.using(ExampleTables.EXAMPLE_ADDRESS.ID).join(ExampleTables.EXAMPLE_ORDER.ADDRESS_ID)
//				.cache(true);
//
//
//		this.property(AddressMeta.ITEM_LIST_PROP)
//				.using(ExampleTables.EXAMPLE_ADDRESS.ID).join(ExampleTables.EXAMPLE_ORDER.ADDRESS_ID)
//				.using(ExampleTables.EXAMPLE_ORDER.ID).join(ExampleTables.EXAMPLE_ORDER_ITEM.ORDER_ID)
//				.cache(true);
//
//		this.property(AddressMeta.GOODS_LIST_PROP)
//				.using(ExampleTables.EXAMPLE_ADDRESS.ID).join(ExampleTables.EXAMPLE_ORDER.ADDRESS_ID)
//				.using(ExampleTables.EXAMPLE_ORDER.ID).join(ExampleTables.EXAMPLE_ORDER_ITEM.ORDER_ID)
//				.using(ExampleTables.EXAMPLE_ORDER_ITEM.GOODS_ID).join(ExampleTables.EXAMPLE_GOODS.ID)
//				.cache(true);



	}


}
