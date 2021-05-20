package com.tailoring.generator.module;

import org.github.foxnic.web.framework.feign.FeignConfigs;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.MicroServiceNames;

import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.CodeGenerator;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.sql.entity.naming.DefaultNameConvertor;
import com.tailoring.generator.config.FoxnicWebConfigs;
import com.tailoring.generator.config.FoxnicWebConstants;

public class ModuleGenerator {
 
	private FoxnicWebConfigs configs;
 
	protected CodeGenerator generator = null;
 
	public ModuleGenerator(String appConfigPrefix) {

		configs=new FoxnicWebConfigs(appConfigPrefix);
 
		initGenerator();
		
		generator.setSettings(configs.getSettings());
		//
//		generator.setMicroServiceNameConst(MicroServiceNames.class.getName()+"."+microServiceNameConst);
		//
//		generator.setDAONameConst(daoNameConst);
		
		//设置常量包
		generator.setConstsPackage(FoxnicWebConstants.DOMAIN_CONSTANTS_PACKAGE);
 
		final DefaultNameConvertor nc=new DefaultNameConvertor();
		//加入自定义注解
//		generator.addCodeBeforeControllerMethod((ctx,featureBuilder,fileBuilder,code)->{
//			
//			String key=nc.getClassName(ctx.getTableName().toLowerCase(),0)+":"+featureBuilder.getMethodName(ctx);
//			code.ln(1, "@RequiresPermissions(\""+key+"\")");
//			fileBuilder.addImport(RequiresPermissions.class);
//			
//		});
//		
//		generator.addCodeBeforePageControllerMethod((ctx,methodName,fileBuilder,code)->{
//			String key=nc.getClassName(ctx.getTableName().toLowerCase(),0)+":page:"+methodName;
//			code.ln(1, "@RequiresPermissions(\""+key+"\")");
//			fileBuilder.addImport(RequiresPermissions.class);
//		});
		
		//
		generator.setListHTMLTemplate("templates/list.html.vm");
		generator.setListJSTemplate("templates/list.js.vm");
		generator.setFormHTMLTemplate("templates/form.html.vm");
		generator.setFormJSTemplate("templates/form.js.vm");
		
		
		
	}
	
	 
	
	


	private void initGenerator() {
		 
		//创建代码生成器
		generator=new CodeGenerator(configs.getDAO());
		//分散生成代码
//		generator.setMode(Mode.MULTI_PROJECT);
		//设置代码生成的默认位置
		generator.setProject(configs.getGeneratorProject());
		// Swagger 支持
		generator.setEnableSwagger(true);
		// 微服务支持组件
		generator.setEnableMicroService(true);
		//
		generator.setSuperController(SuperController.class.getName());
		generator.setControllerResult(Result.class.getName());
		//
		generator.setSentinelExceptionHandlerClassName(SentinelExceptionUtil.class.getName());
		//
		generator.setFeignConfigClassName(FeignConfigs.class.getName());
		//
		generator.setDomanProject(configs.getDomianProject());
		generator.setServiceProject(configs.getServiceProject());
		generator.setProxyProject(configs.getProxyProject());
	}
	
	public DAO dao() {
		return configs.getDAO();
	}

 
	public Object getFalseValue() {
		return configs.getDAO().getDBTreaty().getFalseValue();
	}
	
	public Object getTrueValue() {
		return configs.getDAO().getDBTreaty().getTrueValue();
	}






	public FoxnicWebConfigs getConfigs() {
		return configs;
	}
	
}
