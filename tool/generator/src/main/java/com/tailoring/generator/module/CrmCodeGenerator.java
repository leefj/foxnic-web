package com.tailoring.generator.module;

import com.github.foxnic.generator.ModuleConfig;
import com.github.foxnic.generatorV2.builder.model.PojoClassFile;
import com.github.foxnic.generatorV2.builder.model.PojoProperty;
import com.github.foxnic.generatorV2.config.MduCtx;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.CRM_COMPANY;
import com.scientific.tailoring.constants.db.Tailoring.CRM_DEPARTMENT;
import com.scientific.tailoring.constants.db.Tailoring.CRM_EMPLOYEE;
import com.scientific.tailoring.constants.db.Tailoring.CRM_FAVORITE_FOLDER;
import com.scientific.tailoring.constants.db.Tailoring.CRM_FAVORITE_PRODUCT;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.tailoring.generator.config.ProjectConstants;


/**
 * 为以usr_开头的表生成代码
 */
public class CrmCodeGenerator extends ModuleGenerator {
 
	public static void main(String[] args) throws Exception {
		CrmCodeGenerator g=new CrmCodeGenerator();
		//按调用顺序呈现
		// 
		g.generateCrmCompany();
//		//
		g.generateCrmDepartment();
//		//
		g.generateCrmEmployee();
//		//
		g.generateCrmFavoriteFolder();
		//
		g.generateCrmFavoriteProduct();
		//
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
	private static final String UI_PATH_PREFIX="public/pages/crm";
 
	public CrmCodeGenerator() {
		//
		super(NACOS_GROUP, NACOS_DATA_ID,SERVICE_PROJECT_FOLDER,MICRO_SERVICE_NAME_CONST,DATASOURCE_CONFIG_KEY);
		//设置开发人员
		generator.setAuthor("李方捷");
	}
	
	
	public MduCtx createModuleConfig(DBTable table,int apiSort) {
		//前缀
		String tablePrefix="crm_";
 
		MduCtx mdu=new MduCtx(this.getConfigs().getSettings(),table,tablePrefix,"com.scientific.tailoring.crm");
		mdu.setBaseUriPrefix4Ui("/pages/crm");
		
		mdu.setDAO(this.getConfigs().getDAO());
		mdu.setDomainProject(this.getConfigs().getDomianProject());
		mdu.setProxyProject(this.getConfigs().getProxyProject());
		mdu.setServiceProject(this.getConfigs().getServiceProject());
		mdu.setDAONameConsts(ProjectConstants.DAO_NAME_CONST);
		mdu.setMicroServiceNameConst(MicroServiceNames.class.getName()+"."+ProjectConstants.DEFAULT_MICRO_SERVICE_NAME_CONST);
		
		return mdu;
 
	}
	
	
	public void generateCrmCompany() throws Exception {
		//创建配置
		MduCtx mducfg=createModuleConfig(CRM_COMPANY.$TABLE, 51);
		//生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	}

	public void generateCrmDepartment() throws Exception {
		//创建配置
		MduCtx mducfg=createModuleConfig(CRM_DEPARTMENT.$TABLE, 52);
		//生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	}
 
	
	public void generateCrmEmployee() throws Exception {
		//创建配置
		MduCtx mducfg=createModuleConfig(CRM_EMPLOYEE.$TABLE, 53);
		//生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	}
	
	public void generateCrmFavoriteFolder() throws Exception {
		//创建模块配置对象
		MduCtx mducfg=createModuleConfig(CRM_FAVORITE_FOLDER.$TABLE, 54);
		
//		Pojo favoriteFolderModel=new Pojo();
//		favoriteFolderModel.setDoc("收藏夹目录(聚合产品信息)");
//		favoriteFolderModel.setName("FavoriteFolderModel");
//		favoriteFolderModel.addProperty("product_count",Integer.class,"目录内收藏的商品数量","");
//		mducfg.addPojo(favoriteFolderModel);
		
//		MduCtx ctx=mducfg.getMductx();
		PojoClassFile pojo = mducfg.createPojo("FavoriteFolderModel");
		pojo.setDoc("收藏夹目录(聚合产品信息)");
		pojo.addProperty(PojoProperty.simple(Integer.class, "product_count", "目录内收藏的商品数量", ""));
		 

		// 生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	
	}
	
	
	
	public void generateCrmFavoriteProduct() throws Exception {

		//创建模块配置
		MduCtx mducfg=createModuleConfig(CRM_FAVORITE_PRODUCT.$TABLE, 55);
		//
//		Pojo favoriteProductModel=new Pojo();
//		favoriteProductModel.setDoc("收藏夹内的收藏信息(聚合产品信息)");
//		favoriteProductModel.setName("FavoriteProductModel");
//		favoriteProductModel.addProperty("imageId",Long.class,"商品主图ID","");
//		favoriteProductModel.addProperty("product_name",String.class,"商品名称","");
//		mducfg.addPojo(favoriteProductModel);
		
		
//		MduCtx ctx=mducfg.getMductx();
		PojoClassFile pojo = mducfg.createPojo("FavoriteProductModel");
		pojo.setDoc("收藏夹内的收藏信息(聚合产品信息)");
		pojo.addSimpleProperty(Long.class, "imageId", "商品主图ID", "");
		pojo.addSimpleProperty(Long.class, "productName", "商品名称", "");
		
		// 生成代码
//		generator.build(mducfg);
		mducfg.buildAll();
	
	}
	 
	 
	
	 

}
