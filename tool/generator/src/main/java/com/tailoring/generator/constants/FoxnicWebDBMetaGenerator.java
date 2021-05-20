package com.tailoring.generator.constants;

import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generatorV2.builder.constants.DBMetaClassFile;
import com.tailoring.generator.config.FoxnicWebConfigs;
import com.tailoring.generator.config.FoxnicWebConstants;

/**
 * 为以usr_开头的表生成代码
 */
public class FoxnicWebDBMetaGenerator  {
 
 
	
	public static void main(String[] args) throws Exception {
 
		FoxnicWebDBMetaGenerator g = new FoxnicWebDBMetaGenerator();
	 
		g.buildDBMeta();

		//
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
		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomianProject(),FoxnicWebConstants.DOMAIN_CONSTANTS_PACKAGE,"FoxnicWeb");
		dbMetaBuilder.save(true);
	}

}
