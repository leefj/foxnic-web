package org.github.foxnic.web.generator.module.dataperm;

import com.github.foxnic.generator.builder.business.option.ControllerOptions;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_EXAMPLE_ORDER;
import org.github.foxnic.web.domain.dataperm.ExampleProduct;
import org.github.foxnic.web.domain.dataperm.ExampleShop;
import org.github.foxnic.web.domain.dataperm.meta.*;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.dataperm.ExampleBrandServiceProxy;
import org.github.foxnic.web.proxy.dataperm.ExampleCatalogServiceProxy;
import org.github.foxnic.web.proxy.dataperm.ExampleShopServiceProxy;


public class DPExampleOrderConfig extends BaseCodeConfig<DP_EXAMPLE_ORDER> {

	public DPExampleOrderConfig() {
		super(PREFIX_DATA_PERM,DP_EXAMPLE_ORDER.$TABLE,"dp_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
 		poType.addSimpleProperty(ExampleShop.class,"shop","店铺","店铺");
		poType.addSimpleProperty(ExampleProduct.class,"product","商品","商品");
		poType.addSimpleProperty(Employee.class,"sales","导购","导购");
	}

	@Override
	public void configService(ServiceOptions service) {

	}

	@Override
	public void configController(ControllerOptions controller) {

//		// 为 queryPagedList 加入 join (覆盖默认)
//		controller.fillQueryPagedList()
//				.with(ExampleOrderMeta.SALES,EmployeeMeta.PERSON)
//				.with(ExampleOrderMeta.PRODUCT)
//				.with(ExampleOrderMeta.SHOP)
//		;
//
//		// 为 queryList 加入 join
//		controller.fillQueryList()
//				.with(ExampleOrderMeta.SALES,EmployeeMeta.PERSON)
//				.with(ExampleOrderMeta.PRODUCT)
//				.with(ExampleOrderMeta.SHOP)
//		;
//
//		// 为 getById 加入 join (覆盖默认)
//		controller.fillGetById()
//				.with(ExampleOrderMeta.SALES,EmployeeMeta.PERSON)
//				.with(ExampleOrderMeta.PRODUCT)
//				.with(ExampleOrderMeta.SHOP)
//		;
//
//		// 为 getByIds 加入 join
//		controller.fillGetByIds()
//				.with(ExampleOrderMeta.SALES,EmployeeMeta.PERSON)
//				.with(ExampleOrderMeta.PRODUCT)
//				.with(ExampleOrderMeta.SHOP)
//		;
	}

	@Override
	public void configFields(ViewOptions view) {

		view.field(DP_EXAMPLE_ORDER.ID).basic().hidden();
		view.field(DP_EXAMPLE_ORDER.PRICE).search().hidden();
		view.field(DP_EXAMPLE_ORDER.QUANTITY).search().hidden();
		view.field(DP_EXAMPLE_ORDER.AMOUNT).search().hidden();

		view.field(DP_EXAMPLE_ORDER.PRODUCT_ID).basic().label("品名")
				.search().fuzzySearch().on(FoxnicWeb.DP_EXAMPLE_PRODUCT.NAME)
				.table().fillBy(ExampleOrderMeta.PRODUCT, ExampleProductMeta.NAME);

		view.field(DP_EXAMPLE_ORDER.SHOP_ID).basic().label("店铺")
				.search().on(DP_EXAMPLE_ORDER.SHOP_ID)
				.form().selectBox().queryApi(ExampleShopServiceProxy.QUERY_LIST).paging(false)
				.textField(ExampleShopMeta.NAME).valueField(ExampleShopMeta.ORG_ID).toolbar(false).filter(false).muliti(false,false)
				.fillWith(ExampleOrderMeta.SHOP);

		view.field(FoxnicWeb.DP_EXAMPLE_PRODUCT.BRAND_ID).basic().label("品牌")
				.search().on(FoxnicWeb.DP_EXAMPLE_PRODUCT.BRAND_ID)
				.table().fillBy(ExampleOrderMeta.PRODUCT,ExampleProductMeta.BRAND, ExampleBrandMeta.NAME)
				.form().selectBox().queryApi(ExampleBrandServiceProxy.QUERY_LIST).paging(false).textField(ExampleBrandMeta.NAME).valueField(ExampleBrandMeta.ID)
				.toolbar(false).filter(false).muliti(false,false);


		view.field(FoxnicWeb.DP_EXAMPLE_PRODUCT.BIG_CATA_ID).basic().label("大类")
				.search().on(FoxnicWeb.DP_EXAMPLE_PRODUCT.BIG_CATA_ID)
				.table().fillBy(ExampleOrderMeta.PRODUCT,ExampleProductMeta.BIG_CATALOG,ExampleBrandMeta.NAME)
				.form().selectBox().queryApi(ExampleCatalogServiceProxy.QUERY_LIST+"?parentId=0").paging(false).textField(ExampleCatalogMeta.NAME).valueField(ExampleCatalogMeta.ID)
				.toolbar(false).filter(false);



		view.field(DP_EXAMPLE_ORDER.SALES_ID).basic().label("导购")
				.form().button().chooseEmployee(true)
				.table().fillBy(ExampleOrderMeta.SALES,
						EmployeeMeta.PERSON, PersonMeta.NAME);

	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {
		list.disableFormView().disableModify().disableCreateNew().disableBatchDelete().disableSingleDelete().disableSpaceColumn();
	}

	@Override
	public void configOverrides() {

		//文件生成覆盖模式
		context.overrides()
			.setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
			.setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
			.setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
			.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
			.setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
			.setExtendJsFile(WriteMode.COVER_EXISTS_FILE);

	}

}
