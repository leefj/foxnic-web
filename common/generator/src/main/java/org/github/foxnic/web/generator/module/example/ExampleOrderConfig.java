package org.github.foxnic.web.generator.module.example;

import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
//import org.github.foxnic.web.constants.db.ExampleTables;
//import org.github.foxnic.web.constants.db.ExampleTables.EXAMPLE_ORDER;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class ExampleOrderConfig extends BaseCodeConfig<FoxnicWeb.SYS_USER> {



	/**
	 * 配置模型，为 po 和 vo 添加 额外的属性等
	 * */
	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
//		poType.addListProperty(Goods.class,"goodsList","订单明细商品","订单明细商品");
//		poType.addSimpleProperty(Address.class,"address","收件地址","收件地址，包括收件人以及手机号码");
//		poType.addListProperty(OrderItem.class,"itemList","订单明细","订单明细");
	}

	/**
	 * 配置字段
	 * */
	@Override
	public void configFields(ViewOptions view) {

//		view.field(EXAMPLE_ORDER.ID).basic().hidden();
//
//		view.field(EXAMPLE_ORDER.ADDRESS_ID).basic().label("收件地址")
//				.table().fillBy(OrderMeta.ADDRESS, AddressMeta.ADDRESS)
//				.form().selectBox().queryApi(AddressServiceProxy.QUERY_LIST)
//				.valueField("id").textField("address").muliti(false,false);
//
//		view.field("receiverName").basic().label("收件人").table().fillBy(OrderMeta.ADDRESS, AddressMeta.NAME)
//				.form().hidden();
//
//		view.field("goodsNames").basic().label("商品").table().fillBy(OrderMeta.GOODS_LIST, GoodsMeta.NAME)
//				.search().on(ExampleTables.EXAMPLE_ORDER_ITEM.GOODS_ID)
//		.form().selectBox().queryApi(GoodsServiceProxy.QUERY_LIST)
//				.valueField("id").textField("name").muliti(true,false);
//
//		view.field("byGoodsName").basic().label("品名").table().hidden()
//				.fillBy(OrderMeta.GOODS_LIST, GoodsMeta.NAME)
//				.search().on(ExampleTables.EXAMPLE_GOODS.NAME).fuzzySearch()
//				.form().hidden();
//
//		view.field(EXAMPLE_ORDER.AMOUNT).search().range();

	}

	/**
	 * 配置搜索
	 * */
	@Override
	public void configSearch(ViewOptions view,SearchAreaOptions search) {

//		search.inputLayout(
//				new Object[]{
//						EXAMPLE_ORDER.ORDER_NO,"goodsNames",EXAMPLE_ORDER.AMOUNT
//
//				},
//				new Object[]{
//						EXAMPLE_ORDER.ADDRESS_ID,"receiverName","byGoodsName"
//				});

		search.labelWidth(1,80);
		search.labelWidth(2,80);
		search.labelWidth(3,80);
	}


	/**
	 * 配置源码覆盖
	 * */
	@Override
	public void configOverrides() {
		//文件生成覆盖模式
		context.overrides()
			.setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
			.setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
			.setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
			.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
			.setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
			.setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS);
	}

	/**
	 * 配置服务代码
	 * */
	@Override
	public void configService(ServiceOptions service) {

	}


	/**
	 * 配置 List 表格
	 * */
	@Override
	public void configList(ViewOptions view,ListOptions list) {
		list.operationColumn().addActionButton("明细","openOrderDetail");
	}

	/**
	 * 配置表单
	 * */
	@Override
	public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
//		form.columnLayout(new Object[]{
//				EXAMPLE_NEWS.TITLE,
//				EXAMPLE_NEWS.EXPIRE_DATE,
//				EXAMPLE_NEWS.CONTENT,
//				EXAMPLE_NEWS.AUTHOR
//		});
	}



	public ExampleOrderConfig() {
		super("service-example", FoxnicWeb.SYS_USER.$TABLE,"example_", 3);
	}




}
