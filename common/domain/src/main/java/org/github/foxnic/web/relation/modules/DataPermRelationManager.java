package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.dataperm.meta.*;

public class DataPermRelationManager extends RelationManager {

	@Override
	protected void config() {
		setupDataPerm();
		setupExample();
	}

	private void setupExample() {

		//订单 - 商品
		this.property(ExampleOrderMeta.PRODUCT_PROP)
				.using(FoxnicWeb.DP_EXAMPLE_ORDER.PRODUCT_ID).join(FoxnicWeb.DP_EXAMPLE_PRODUCT.ID)
		;

		//订单 - 店铺
		this.property(ExampleOrderMeta.SHOP_PROP)
				.using(FoxnicWeb.DP_EXAMPLE_ORDER.SHOP_ID).join(FoxnicWeb.DP_EXAMPLE_SHOP.ID)
		;

		//订单 - 导购
		this.property(ExampleOrderMeta.SALES_PROP)
				.using(FoxnicWeb.DP_EXAMPLE_ORDER.SALES_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID)
		;

		//商品 - 品牌
		this.property(ExampleProductMeta.BRAND_PROP)
				.using(FoxnicWeb.DP_EXAMPLE_PRODUCT.BRAND_ID).join(FoxnicWeb.DP_EXAMPLE_BRAND.ID)
		;

		//商品 - 大类
		this.property(ExampleProductMeta.BIG_CATALOG_PROP)
				.using(FoxnicWeb.DP_EXAMPLE_PRODUCT.BIG_CATA_ID).join(FoxnicWeb.DP_EXAMPLE_CATALOG.ID)
		;

		//商品 - 小类
		this.property(ExampleProductMeta.SML_CATALOG_PROP)
				.using(FoxnicWeb.DP_EXAMPLE_PRODUCT.SML_CATA_ID).join(FoxnicWeb.DP_EXAMPLE_CATALOG.ID)
		;


	}

	private void setupDataPerm() {

		//主题 - 属性
		this.property(SubjectMeta.PROPERTIES_PROP)
				.using(FoxnicWeb.DP_SUBJECT.ID).join(FoxnicWeb.DP_SUBJECT_PROPERTY.SUBJECT_ID)
		;

		//规则 - 范围
		this.property(RuleMeta.RANGES_PROP)
				.using(FoxnicWeb.DP_RULE.ID).join(FoxnicWeb.DP_RULE_RANGE.RULE_ID)
		;

		//范围 - 条件
		this.property(RuleRangeMeta.CONDITIONS_PROP)
				.using(FoxnicWeb.DP_RULE_RANGE.ID).join(FoxnicWeb.DP_RULE_CONDITION.RANGE_ID);
		;

	}






}
