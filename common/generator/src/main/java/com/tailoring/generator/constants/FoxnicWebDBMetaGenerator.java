package com.tailoring.generator.constants;

import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.builder.constants.DBMetaClassFile;
import com.tailoring.generator.config.FoxnicWebConfigs;


public class FoxnicWebDBMetaGenerator  {
 
 
	/**
	 * 运行main函数生成代码
	 * */
	public static void main(String[] args) throws Exception {
		FoxnicWebDBMetaGenerator g = new FoxnicWebDBMetaGenerator();
		g.buildDBMeta();
	}
	
	private FoxnicWebConfigs configs;
	private DAO dao;
	
	public FoxnicWebDBMetaGenerator() {
		this.configs=new FoxnicWebConfigs("service-system");
		this.dao=this.configs.getDAO();
	}

 
	/**
	 * 生成DBMeta数据
	 * */
	private void buildDBMeta() {
		
		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomianProject(),this.configs.getProjectConfigs().getDomainConstantsPackage(),"FoxnicWeb");
		dbMetaBuilder.save(true);
	}

}
