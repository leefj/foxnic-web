package org.github.foxnic.web.generator.module.example;

import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.ExampleTables;
import org.github.foxnic.web.constants.db.ExampleTables.EXAMPLE_ORDER;
import org.github.foxnic.web.domain.example.Address;
import org.github.foxnic.web.domain.example.Goods;
import org.github.foxnic.web.domain.example.OrderItem;
import org.github.foxnic.web.domain.example.meta.AddressMeta;
import org.github.foxnic.web.domain.example.meta.GoodsMeta;
import org.github.foxnic.web.domain.example.meta.OrderMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.example.AddressServiceProxy;
import org.github.foxnic.web.proxy.example.GoodsServiceProxy;


public class ExampleOrderConfig extends BaseCodeConfig<EXAMPLE_ORDER> {



	/**
	 * 配置模型，为 po 和 vo 添加 额外的属性等
	 * */
	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.addListProperty(Goods.class,"goodsList","订单明细商品","订单明细商品");
		poType.addSimpleProperty(Address.class,"address","收件地址","收件地址，包括收件人以及手机号码");
		poType.addListProperty(OrderItem.class,"itemList","订单明细","订单明细");
	}

	/**
	 * 配置字段
	 * */
	@Override
	public void configFields(ViewOptions view) {

		view.field(EXAMPLE_ORDER.ADDRESS_ID)
				.table().fillBy(OrderMeta.ADDRESS, AddressMeta.ADDRESS)
				.form().selectBox().queryApi(AddressServiceProxy.QUERY_LIST)
				.valueField("id").textField("address").muliti(false,false);

		view.field("receiverName").table().fillBy(OrderMeta.ADDRESS, AddressMeta.NAME)
				.form().hidden();

		view.field("goodsNames").table().fillBy(OrderMeta.GOODS_LIST, GoodsMeta.NAME)
				.search().on(ExampleTables.EXAMPLE_ORDER_ITEM.GOODS_ID)
		.form().selectBox().queryApi(GoodsServiceProxy.QUERY_LIST)
				.valueField("id").textField("name").muliti(true,false);

		view.field("byGoodsName").table().hidden()
				.fillBy(OrderMeta.GOODS_LIST, GoodsMeta.NAME)
				.search().on(ExampleTables.EXAMPLE_GOODS.NAME).fuzzySearch()
				.form().hidden();

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

	}

	/**
	 * 配置表单
	 * */
	@Override
	public void configForm(ViewOptions view,FormOptions form) {
//		form.columnLayout(new Object[]{
//				EXAMPLE_NEWS.TITLE,
//				EXAMPLE_NEWS.EXPIRE_DATE,
//				EXAMPLE_NEWS.CONTENT,
//				EXAMPLE_NEWS.AUTHOR
//		});
	}

	/**
	 * 配置搜索
	 * */
	@Override
	public void configSearch(ViewOptions view,SearchAreaOptions search) {

	}


	public ExampleOrderConfig() {
		super("service-example",EXAMPLE_ORDER.$TABLE,"example_", 3);
	}




}