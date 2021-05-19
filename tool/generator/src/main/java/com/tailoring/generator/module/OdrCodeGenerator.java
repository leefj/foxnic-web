package com.tailoring.generator.module;

import java.math.BigDecimal;

import com.github.foxnic.generatorV2.builder.model.PojoClassFile;
import com.github.foxnic.generatorV2.config.MduCtx;
import com.github.foxnic.generatorV2.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.ODR_BODY;
import com.scientific.tailoring.constants.db.Tailoring.ODR_MEASURE;
import com.scientific.tailoring.constants.db.Tailoring.ODR_MEASURE_DATA;
import com.scientific.tailoring.constants.db.Tailoring.ODR_MEASURE_FILE;
import com.scientific.tailoring.constants.db.Tailoring.ODR_ORDER;
import com.scientific.tailoring.constants.db.Tailoring.ODR_PRODUCT;
import com.scientific.tailoring.constants.db.Tailoring.ODR_VIRTUAL_EFFECT;
import com.scientific.tailoring.domain.order.MeasureFile;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.tailoring.generator.config.ProjectConstants;
 
 

/**
 * 为以usr_开头的表生成代码
 */
public class OdrCodeGenerator extends ModuleGenerator {
 
	public static void main(String[] args) throws Exception {
		OdrCodeGenerator g=new OdrCodeGenerator();
		//按调用顺序呈现
		// 
		g.generateOdrOrder();
		//
		g.generateOdrProduct();
		//
		g.generateOdrMeasure();
		//
		g.generateOdrBody();
//		//
		g.generateOdrMeasureFile();
//		//
		g.generateOdrMeasureData();
//		//
		g.generateOdrVirtualEffect();
	}
	
	/**
	 * nacos 配置的 group
	 * */
	private static final String NACOS_GROUP="service";
	
	/**
	 * nacos 配置的 dataId
	 * */
	private static final String NACOS_DATA_ID="service-tailoring.yml";
	
	/**
	 * 代码生成的微服务项目所在的目录
	 * */
	private static final String SERVICE_PROJECT_FOLDER="service-tailoring";
	/**
	 * 基础包名
	 * */
//	private static final String BASE_PACKAGE="com.scientific.tailoring.order";
 
	/**
	 * 在 MicroServiceNames 类中定义的常量名
	 * */
	private static final String MICRO_SERVICE_NAME_CONST="TAILORING";
	 
	/**
	 * 在配置中使用的数据源配置键
	 * */
	private static final String DATASOURCE_CONFIG_KEY="spring.datasource.druid.primary";
	
	/**
	 * 界面基础路径
	 * */
	private static final String UI_PATH_PREFIX="public/pages/order";
	
 
	public OdrCodeGenerator() {
		//
		super(NACOS_GROUP, NACOS_DATA_ID,SERVICE_PROJECT_FOLDER,MICRO_SERVICE_NAME_CONST,DATASOURCE_CONFIG_KEY);
		//设置开发人员
		generator.setAuthor("李方捷");
	}
	
	
	public MduCtx createModuleConfig(DBTable table,int apiSort) {
		//前缀
		String tablePrefix="odr_";
 
		MduCtx mdu=new MduCtx(this.getConfigs().getSettings(),table,tablePrefix,"com.scientific.tailoring.order");
		mdu.setDAO(this.getConfigs().getDAO());
		mdu.setDomainProject(this.getConfigs().getDomianProject());
		mdu.setProxyProject(this.getConfigs().getProxyProject());
		mdu.setServiceProject(this.getConfigs().getServiceProject());
		mdu.setDAONameConsts(ProjectConstants.DAO_NAME_CONST);
		mdu.setMicroServiceNameConst(MicroServiceNames.class.getName()+"."+ProjectConstants.DEFAULT_MICRO_SERVICE_NAME_CONST);
		mdu.setBaseUriPrefix4Ui("/pages/order");
		
		return mdu;
 
	}
	
	public void generateOdrOrder() throws Exception {

		//创建模块配置对象
		MduCtx mducfg=createModuleConfig(ODR_ORDER.$TABLE, 151);
		
		//设置覆盖模式
		mducfg.overrides()
		.setListPage(WriteMode.DO_NOTHING)
		.setFormPage(WriteMode.WRITE_TEMP_FILE)
		.setPageController(WriteMode.DO_NOTHING)
		.setControllerAndAgent(WriteMode.DO_NOTHING)
		.setServiceIntfAnfImpl(WriteMode.DO_NOTHING);

//		Pojo appOrderModel=new Pojo();
//		appOrderModel.setDoc("订单模型(聚合产品、地址、结果汇总等信息)");
//		appOrderModel.setName("AppOrderModel");
//		appOrderModel.addProperty("statusName",String.class,"订单状态(描述)","");
//		appOrderModel.addProperty("imageId",Long.class,"产品图ID","");
//		appOrderModel.addProperty("companyName",String.class,"公司名称","");
//		appOrderModel.addProperty("provinceName",String.class,"省份名称","");
//		appOrderModel.addProperty("cityName",String.class,"城市名称","");
//		appOrderModel.addProperty("areaName",String.class,"区县名称","");
//		appOrderModel.addProperty("townName",String.class,"镇名称","");
//		appOrderModel.addProperty("fullAddress",String.class,"量体地址","");
//		appOrderModel.addMapProperty("status_summary", String.class,Integer.class,"测量状态的汇总统计","");
//		mducfg.addPojo(appOrderModel);
		
		
//		MduCtx ctx=mducfg.getMductx();
		PojoClassFile pojo = mducfg.createPojo("AppOrderModel");
		pojo.setDoc("订单模型(聚合产品、地址、结果汇总等信息)");
		pojo.addSimpleProperty(String.class, "statusName", "订单", "");
		pojo.addSimpleProperty(Long.class, "imageId", "产品图ID", "");
		pojo.addSimpleProperty(String.class, "companyName", "公司名称", "");
		pojo.addSimpleProperty(String.class, "provinceName", "省份名称", "");
		pojo.addSimpleProperty(String.class, "cityName", "城市名称", "");
		pojo.addSimpleProperty(String.class, "areaName", "区县名称", "");
		pojo.addSimpleProperty(String.class, "townName", "镇名称", "");
		pojo.addSimpleProperty(String.class, "fullAddress", "量体地址", "");
		pojo.addMapProperty(String.class, Integer.class,"statusSummary", "测量状态的汇总统计", "");
		
		// 生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	
	}
 
	
	public void generateOdrProduct() throws Exception {
		//创建配置
		MduCtx mducfg=createModuleConfig(ODR_PRODUCT.$TABLE, 152);
		
		//设置覆盖模式
		mducfg.overrides()
		.setListPage(WriteMode.DO_NOTHING)
		.setFormPage(WriteMode.DO_NOTHING)
		.setPageController(WriteMode.DO_NOTHING)
		.setControllerAndAgent(WriteMode.DO_NOTHING)
		.setServiceIntfAnfImpl(WriteMode.DO_NOTHING);
		
		//生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	
	}
	
	public void generateOdrBody() throws Exception {

		//创建模块配置对象
		MduCtx mducfg=createModuleConfig(ODR_BODY.$TABLE, 152);
		
		//设置覆盖模式
		mducfg.overrides()
		.setListPage(WriteMode.IGNORE)
		.setFormPage(WriteMode.IGNORE)
		.setPageController(WriteMode.IGNORE)
		.setControllerAndAgent(WriteMode.DO_NOTHING)
		.setServiceIntfAnfImpl(WriteMode.DO_NOTHING);
		
		mducfg.buildAll();
		
	}
	
	public void generateOdrMeasure() throws Exception {
		 
	 
		//创建模块配置对象
		MduCtx mducfg=createModuleConfig(ODR_MEASURE.$TABLE, 152);
		
		//设置覆盖模式
		mducfg.overrides()
		.setListPage(WriteMode.DO_NOTHING)
		.setFormPage(WriteMode.DO_NOTHING)
		.setPageController(WriteMode.DO_NOTHING)
		.setControllerAndAgent(WriteMode.DO_NOTHING)
		.setServiceIntfAnfImpl(WriteMode.DO_NOTHING);
		
		
//		MduCtx ctx=mducfg.getMductx();
		mducfg.getVoClassFile().addSimpleProperty(String.class,"bodyName","姓名","");
		mducfg.getVoClassFile().addSimpleProperty(Long.class,"bid","body表的ID字段","");
		mducfg.getVoClassFile().addSimpleProperty(String.class,"bodyDept","部门","");
		mducfg.getVoClassFile().addSimpleProperty(String.class,"bodySex","性别","");
		mducfg.getVoClassFile().addSimpleProperty(Integer.class,"bodyHeight","身高","");
		mducfg.getVoClassFile().addListProperty(String.class, "statusList", "状态列表", "指定需要过滤的状态类型");
		mducfg.getVoClassFile().addSimpleProperty(String.class,"measureType","测量类型","净体body;着装outfit");
//		mducfg.getDefaultVO().addListProperty("statusList", String.class, "状态列表", "指定需要过滤的状态类型");

//		Pojo appMeasureModel=new Pojo();
//		appMeasureModel.setDoc("测量模型(聚合字典转换等)");
//		appMeasureModel.setName("AppMeasureModel");
//		appMeasureModel.addProperty("bodySexLabel",String.class,"性别(描述)","");
//		appMeasureModel.addProperty("statusLabel",String.class,"状态标签","");
//		mducfg.addPojo(appMeasureModel);
		
		PojoClassFile pojo = mducfg.createPojo("AppMeasureModel");
		pojo.setDoc("测量模型(聚合字典转换等)");
		pojo.addSimpleProperty(String.class, "bodySexLabel", "性别(描述)", "");
		pojo.addSimpleProperty(Long.class,"bid","body表的ID字段","");
		pojo.addSimpleProperty(String.class, "statusLabel", "状态标签", "");
		pojo.addSimpleProperty(String.class,"bodyName","姓名","");
		pojo.addSimpleProperty(String.class,"bodyDept","部门","");
		pojo.addSimpleProperty(String.class,"bodySex","性别","");
		pojo.addSimpleProperty(Integer.class,"bodyHeight","身高","");
		
		
//		Pojo measureDimensionModel=new Pojo();
//		measureDimensionModel.setName("MeasureDimensionModel");
//		measureDimensionModel.setSuperClass("");
//		measureDimensionModel.addProperty("dbField",String.class,"数据库字段名","");
//		measureDimensionModel.addProperty("property",String.class,"实体内的属性名","");
//		measureDimensionModel.addProperty("label",String.class,"标签","");
//		mducfg.addPojo(measureDimensionModel);
		
		pojo = mducfg.createPojo("MeasureDimensionModel");
		pojo.setSuperType(null);
		pojo.addSimpleProperty(String.class, "dbField", "数据库字段名", "");
		pojo.addSimpleProperty(String.class, "property", "实体内的属性名", "");
		pojo.addSimpleProperty(String.class, "label", "标签", "");
		pojo.addSimpleProperty(BigDecimal.class, "value", "值", "");


//		Pojo measureFilesVO=new Pojo();
//		measureFilesVO.setDoc("多个测量文件单次提交的数据");
//		measureFilesVO.setName("MeasureFilesVO");
//		measureFilesVO.addProperty("measureId",Long.class,"测量ID","");
//		measureFilesVO.addListProperty("measureFiles", MeasureFile.class,"文件清单","");
//		mducfg.addPojo(measureFilesVO);
		
		pojo = mducfg.createPojo("MeasureFilesVO");
		pojo.setDoc("多个测量文件单次提交的数据");
		pojo.addSimpleProperty(Long.class, "measureId", "测量ID", "");
		pojo.addSimpleProperty(MeasureFile.class, "measureFiles", "文件清单", "");
	 
 
		// 生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	}
	
	
	
	public void generateOdrMeasureFile() throws Exception {
		//创建配置
		MduCtx mducfg=createModuleConfig(ODR_MEASURE_FILE.$TABLE, 154);
		
		mducfg.getVoClassFile().addListProperty(MeasureFile.class,"measureFiles","测量文件清单","");
		mducfg.getVoClassFile().addSimpleProperty(Long.class, "bodyId", "测量人员ID", "");
		//设置覆盖模式
		mducfg.overrides()
		.setListPage(WriteMode.DO_NOTHING)
		.setFormPage(WriteMode.DO_NOTHING)
		.setPageController(WriteMode.DO_NOTHING)
		.setControllerAndAgent(WriteMode.DO_NOTHING)
		.setServiceIntfAnfImpl(WriteMode.DO_NOTHING);
		
		//生成代码
		mducfg.buildAll();
	
	}
	
	
	public void generateOdrMeasureData() throws Exception {
		//创建配置
		MduCtx mducfg=createModuleConfig(ODR_MEASURE_DATA.$TABLE, 155);
		//生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	
	}
	
	
	public void generateOdrVirtualEffect() throws Exception {
		//创建配置
		MduCtx mducfg=createModuleConfig(ODR_VIRTUAL_EFFECT.$TABLE, 156);
		//生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	}
	
	 
	
	 

}
