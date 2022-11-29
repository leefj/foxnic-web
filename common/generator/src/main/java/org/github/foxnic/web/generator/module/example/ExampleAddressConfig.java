package org.github.foxnic.web.generator.module.example;

import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.FieldsBuilder;
import com.github.foxnic.generator.builder.business.option.ControllerOptions;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.ExampleTables.EXAMPLE_ADDRESS;
import org.github.foxnic.web.domain.example.*;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.springframework.web.bind.annotation.RequestMethod;


public class ExampleAddressConfig extends BaseCodeConfig<EXAMPLE_ADDRESS> {



	/**
	 * 配置模型，为 po 和 vo 添加 额外的属性等
	 * */
	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {

//		poType.addListProperty(Goods.class,"goodsList","订单明细商品","订单明细商品");
//		poType.addListProperty(OrderItem.class,"itemList","订单明细","订单明细");
//		poType.addListProperty(Order.class,"orderList","订单","订单");

		poType.addSimpleProperty(AddressModel.class,"model","引用1","引用1");


		PojoClassFile addressModel=context.createPojo("AddressModel");
		addressModel.setTitle("AddressModel 模型");
		addressModel.setDesc("用于 AddressModel 的保存");
		addressModel.setSuperType(Entity.class);
		FieldsBuilder fields=this.createFieldsBuilder();
		fields.addAll().removeDBTreatyFields();
		addressModel.addSimpleProperties(fields);
		addressModel.addSimpleProperty(String.class,"other","其它","其它");
		addressModel.addSimpleProperty(Address.class,"addressX","引用2","引用2");


		PojoClassFile addressSubModel=context.createPojo("AddressSubModel");
		addressSubModel.setTitle("AddressModel 模型");
		addressSubModel.setDesc("用于 AddressModel 的保存");
		addressSubModel.setSuperTypeFile(addressModel);
		addressSubModel.addSimpleProperty(String.class,"postCode","邮编","邮编");
		addressSubModel.addSimpleProperty(String.class,"postCode2","邮编","邮编");

//		AddressModel model=new AddressModel();
//		model.set

		PojoClassFile addressPureModel=context.createPojo("AddressPureModel");
		addressPureModel.setTitle("AddressModel 模型");
		addressPureModel.setDesc("用于 AddressModel 的保存");
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

		view.field(EXAMPLE_ADDRESS.CREATE_TIME).search().hidden(false);

	}

	@Override
	public void configView(ViewOptions view, ListOptions list, FormOptions form) {
		view.language().enableContext();
		//或
		view.language().enableContext("my-context");
		list.excel(true,true);
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


	@Override
	public void configController(ControllerOptions controller) {


		controller.topic("订单地址");
		controller.restApiTagDir("功能示例");

		controller.inDoc(true);



		controller
				// 方法头
				.restApi("Get-示例","newApiName1","new-api-name-1", RequestMethod.GET,"方法描述")
				// 参数
				.addSimpleParameter(String.class,"name","姓名",true,"LeeFJ","所有者的姓名")
				.addListParameter(String.class,"memberIds","成员ID集合",false,"[1,2,3]","指定成员的ID清单")
				.addMapParameter(String.class,Integer.class,"ageMap","年龄表",false,"{\"LeeFJ\":28}","成员年龄表")
				// 返回值
				.simpleResult(AddressSubModel.class,"结果")
		;


		controller
				// 方法头
				.restApi("Post-示例","newApiName2","new-api-name-2", RequestMethod.POST,"方法描述")
				// 参数
				.addSimpleParameter(AddressVO.class,"address","地址对象",true,"{}","地址基本信息")
				.addListParameter(AddressModel.class,"model","地址模型",false,"[]","地址的扩展信息")
				.addMapParameter(String.class, User.class,"userMap","账户对象Map",false,"{}","账户对象Map")
				// 返回值
				.listResult(AddressPureModel.class,"地址列表")
		;



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

//		list.excel(true,true);

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
