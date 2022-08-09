package org.github.foxnic.web.generator.module.example;

import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.FieldsBuilder;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.ExampleTables.EXAMPLE_ADDRESS;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class ExampleAddressConfig extends BaseCodeConfig<EXAMPLE_ADDRESS> {



	/**
	 * 配置模型，为 po 和 vo 添加 额外的属性等
	 * */
	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {

//		poType.addListProperty(Goods.class,"goodsList","订单明细商品","订单明细商品");
//		poType.addListProperty(OrderItem.class,"itemList","订单明细","订单明细");
//		poType.addListProperty(Order.class,"orderList","订单","订单");


		PojoClassFile addressModel=context.createPojo("AddressModel");
		addressModel.setSuperType(Entity.class);
		FieldsBuilder fields=this.createFieldsBuilder();
		fields.addAll().removeDBTreatyFields();
		addressModel.addSimpleProperties(fields);


		PojoClassFile addressSubModel=context.createPojo("AddressSubModel");
		addressSubModel.setSuperTypeFile(addressModel);
		addressSubModel.addSimpleProperty(String.class,"postCode","邮编","邮编");
		addressSubModel.addSimpleProperty(String.class,"postCode2","邮编","邮编");

//		AddressModel model=new AddressModel();
//		model.set

		PojoClassFile addressPureModel=context.createPojo("AddressPureModel");
		addressPureModel.noSuperType();
		fields=this.createFieldsBuilder();
		fields.addAll().removeDBTreatyFields();
		addressPureModel.addSimpleProperties(fields);

	}

	/**
	 * 配置字段
	 * */
	@Override
	public void configFields(ViewOptions view) {

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

		list.sort(EXAMPLE_ADDRESS.PHONE_NUMBER,true);

	}

	/**
	 * 配置表单
	 * */
	@Override
	public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {

//		form.

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


	public ExampleAddressConfig() {
		super("service-example", EXAMPLE_ADDRESS.$TABLE,"example_", 3);
	}




}
