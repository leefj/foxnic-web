package com.tailoring.generator.module;

import com.github.foxnic.generator.ModuleConfig;
import com.github.foxnic.generator.ModuleConfig.TreeConfig;
import com.github.foxnic.generatorV2.builder.model.PojoClassFile;
import com.github.foxnic.generatorV2.config.MduCtx;
import com.github.foxnic.generatorV2.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.PRD_FABRIC;
import com.scientific.tailoring.constants.db.Tailoring.PRD_LABEL;
import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT;
import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT_FABRIC;
import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT_IMAGE;
import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT_LABEL;
import com.scientific.tailoring.constants.db.Tailoring.PRD_VIRTUAL_LIBRARY;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.tailoring.generator.config.ProjectConstants;


/**
 * 为以usr_开头的表生成代码
 */
public class PrdCodeGenerator extends ModuleGenerator {
 
	public static void main(String[] args) throws Exception {
		
		PrdCodeGenerator g=new PrdCodeGenerator();
		//
		g.generatePrdVirtualLibrary();
		//
		g.generatePrdLabel();
		//
		g.generatePrdFabric();
		//
		g.generatePrdProduct();
		//
		g.generatePrdProductFabric();
		//
		g.generatePrdProductImage();
		//
		g.generatePrdProductLabel();
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
//	private static final String BASE_PACKAGE="com.scientific.tailoring.product";
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
	private static final String UI_PATH_PREFIX="public/pages/product";
 
	public PrdCodeGenerator() {
		//
		super(NACOS_GROUP, NACOS_DATA_ID,SERVICE_PROJECT_FOLDER,MICRO_SERVICE_NAME_CONST,DATASOURCE_CONFIG_KEY);
		//设置开发人员
		generator.setAuthor("李方捷");
	}
	
	
	public MduCtx createModuleConfig(DBTable table,int apiSort) {
		//前缀
		String tablePrefix="prd_";
		
		MduCtx mdu=new MduCtx(this.getConfigs().getSettings(),table,tablePrefix,"com.scientific.tailoring.product");
		mdu.setBaseUriPrefix4Ui("/pages/product");
		
		mdu.setDAO(this.getConfigs().getDAO());
		mdu.setDomainProject(this.getConfigs().getDomianProject());
		mdu.setProxyProject(this.getConfigs().getProxyProject());
		mdu.setServiceProject(this.getConfigs().getServiceProject());
		mdu.setDAONameConsts(ProjectConstants.DAO_NAME_CONST);
		mdu.setMicroServiceNameConst(MicroServiceNames.class.getName()+"."+ProjectConstants.DEFAULT_MICRO_SERVICE_NAME_CONST);
		return mdu;
 
	}
	
	
	public void generatePrdVirtualLibrary() throws Exception {
		//创建配置
		MduCtx mducfg=createModuleConfig(PRD_VIRTUAL_LIBRARY.$TABLE, 101);
		
		//设置覆盖模式
		mducfg.overrides()
		.setListPage(WriteMode.DO_NOTHING)
		.setFormPage(WriteMode.DO_NOTHING)
		.setPageController(WriteMode.DO_NOTHING)
		.setControllerAndAgent(WriteMode.DO_NOTHING)
		.setServiceIntfAnfImpl(WriteMode.DO_NOTHING);
		
		//设置图片字段
//		mducfg.setImageIdFields(PRD_VIRTUAL_LIBRARY.EFFECT_FILE_ID);
		
//		mducfg.addLogicField(PRD_VIRTUAL_LIBRARY.VALID).on("有效", this.getTrueValue()).off("无效", this.getFalseValue());
		
//		Pojo virtualLibraryModel=new Pojo();
//		virtualLibraryModel.setName("VirtualLibraryModel");
//		virtualLibraryModel.addProperty("productName",String.class, "商品名称", "");
//		virtualLibraryModel.addProperty("fabricName",String.class, "面料名称", "");
//		mducfg.addPojo(virtualLibraryModel);
		
//		MduCtx ctx=mducfg.getMductx();
		PojoClassFile pojo = mducfg.createPojo("VirtualLibraryModel");
		pojo.addSimpleProperty(String.class, "productName", "商品名称", "");
		pojo.addSimpleProperty(String.class, "fabricName", "面料名称", "");
		
		//生成代码
//		generator.build(mducfg);
		
		mducfg.buildAll();
	}
 
	public void generatePrdProductFabric() throws Exception {
		//创建配置
		MduCtx mducfg=createModuleConfig(PRD_PRODUCT_FABRIC.$TABLE, 103);
		
		
//		Pojo productFabricModel=new Pojo();
//		productFabricModel.setName("ProductFabricModel");
//		productFabricModel.addProperty("productName",String.class, "商品名称", "");
//		productFabricModel.addProperty("fabricName",String.class, "面料名称", "");
//		productFabricModel.addProperty("effectFileId",String.class, "效果ID", "");
//		mducfg.addPojo(productFabricModel);
		
//		MduCtx ctx=mducfg.getMductx();
		PojoClassFile pojo = mducfg.createPojo("ProductFabricModel");
		pojo.addSimpleProperty(String.class, "productName", "商品名称", "");
		pojo.addSimpleProperty(String.class, "fabricName", "面料名称", "");
		pojo.addSimpleProperty(String.class, "effectFileId", "效果ID", "");
		
		//设置覆盖模式
		mducfg.overrides()
		//前端
		.setListPage(WriteMode.DO_NOTHING)
		.setFormPage(WriteMode.DO_NOTHING)
		//后端
		.setPageController(WriteMode.DO_NOTHING)
		.setControllerAndAgent(WriteMode.DO_NOTHING)
		.setServiceIntfAnfImpl(WriteMode.DO_NOTHING);
		
		//生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	}
	
	
	public void generatePrdProductImage() throws Exception {
		//创建配置
		MduCtx mducfg=createModuleConfig(PRD_PRODUCT_IMAGE.$TABLE, 104);
		//生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	}
	
	
	public void generatePrdProductLabel() throws Exception {
		//创建配置
		MduCtx mducfg=createModuleConfig(PRD_PRODUCT_LABEL.$TABLE, 105);
		
		
		//设置覆盖模式
		mducfg.overrides()
		//前端
		.setListPage(WriteMode.DO_NOTHING)
		.setFormPage(WriteMode.DO_NOTHING)
		//后端
		.setPageController(WriteMode.DO_NOTHING)
		.setControllerAndAgent(WriteMode.DO_NOTHING)
		.setServiceIntfAnfImpl(WriteMode.DO_NOTHING);
		
		//生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	}
	
	
	public void generatePrdProduct() throws Exception {
		 
	 
		//创建模块配置对象
		MduCtx mducfg=createModuleConfig(PRD_PRODUCT.$TABLE, 106);
		 
		
		//设置覆盖模式
		mducfg.overrides()
		//前端
		.setListPage(WriteMode.DO_NOTHING)
		.setFormPage(WriteMode.DO_NOTHING)
		//后端
		.setPageController(WriteMode.DO_NOTHING)
		.setControllerAndAgent(WriteMode.DO_NOTHING)
		.setServiceIntfAnfImpl(WriteMode.DO_NOTHING);

		//
		mducfg.getVoClassFile().addListProperty(Integer.class,"labelIds","标签ID","指定需要传入的标签ID数组");
		mducfg.getVoClassFile().addListProperty(Long.class,"imageIds","图片ID","指定需要传入的图片ID数组，其中第一个为主图");
		mducfg.getVoClassFile().addListProperty(Integer.class,"fabricIds","面料ID","指定需要传入的面料ID数组");

		//
		PojoClassFile pojo = mducfg.createPojo("AppProductModel");
		pojo = mducfg.createPojo("ProductOrderModel");
		pojo.addSimpleProperty(Long.class, "orderId", "订单ID", "");
		pojo.addSimpleProperty(Long.class, "orderProductRelId", "订单与商品的关系ID", "");

		// 生成代码
		mducfg.buildAll();
	
	}
 
	
	


	public void generatePrdFabric() throws Exception {
		//创建配置
		MduCtx mducfg=createModuleConfig(PRD_FABRIC.$TABLE, 107);
		
		//设置覆盖模式
		mducfg.overrides()
		.setListPage(WriteMode.DO_NOTHING)
		.setFormPage(WriteMode.DO_NOTHING)
		.setPageController(WriteMode.DO_NOTHING)
		.setControllerAndAgent(WriteMode.DO_NOTHING)
		.setServiceIntfAnfImpl(WriteMode.DO_NOTHING);
		
		//说明是一个图片字段
//		mducfg.setImageIdFields(PRD_FABRIC.FILE_ID);
		
		//生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	}
	
	public void generatePrdLabel() throws Exception {
		//创建模块配置对象
		MduCtx mducfg=createModuleConfig(PRD_LABEL.$TABLE, 108);
 
		//设置覆盖模式
		mducfg.overrides()
		.setListPage(WriteMode.DO_NOTHING)
		.setFormPage(WriteMode.DO_NOTHING)
		.setPageController(WriteMode.DO_NOTHING)
		.setControllerAndAgent(WriteMode.DO_NOTHING)
		.setServiceIntfAnfImpl(WriteMode.DO_NOTHING);
 
		//设置树形结构相关字段
//		TreeConfig treeConfig=new TreeConfig();
//		treeConfig.setIdField(PRD_LABEL.ID);
//		treeConfig.setNameField(PRD_LABEL.LABEL);
//		treeConfig.setParentIdField(PRD_LABEL.PARENT_ID);
//		treeConfig.setRootId(0);
//		//设置为树形结构
//		mducfg.setTreeConfig(treeConfig);
		
//		MduCtx ctx=mducfg.getMductx();
		
	 
//		Pojo labelNodeModel=new Pojo();
//		labelNodeModel.setName("LabelNodeModel");
//		labelNodeModel.addListProperty("subLabels","LabelNodeModel","下级标签","");
//		mducfg.addPojo(labelNodeModel);
		
		PojoClassFile pojo = mducfg.createPojo("LabelNodeModel");
 
		pojo.addListProperty(pojo, "subLabels", "下级标签", "");
	 

		// 生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	}
	
	
	
	
	
	 
	
	 

}
