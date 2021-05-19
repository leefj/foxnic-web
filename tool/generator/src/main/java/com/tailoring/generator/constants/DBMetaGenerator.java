package com.tailoring.generator.constants;

import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generatorV2.builder.constants.DBMetaClassFile;
import com.scientific.tailoring.constants.db.Tailoring.SYS_USER;
import com.tailoring.generator.config.Configs;
import com.tailoring.generator.config.ProjectConstants;

/**
 * 为以usr_开头的表生成代码
 */
public class DBMetaGenerator  {
 
 
	
	public static void main(String[] args) throws Exception {
 
		DBMetaGenerator g = new DBMetaGenerator();
	 
		g.buildDBMeta();

		//
	}
	
	private Configs configs;
	private DAO dao;
	
	public DBMetaGenerator() {
		this.configs=new Configs();
		this.dao=this.configs.getDAO();
	}

 
	/**
	 * 生成DBMeta数据
	 * */
	private void buildDBMeta() {
		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomianProject(),ProjectConstants.DOMAIN_CONSTANTS_PACKAGE,"Tailoring");
		dbMetaBuilder.save(true);
	}

}
