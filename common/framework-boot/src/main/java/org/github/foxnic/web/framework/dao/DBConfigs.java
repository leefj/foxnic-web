package org.github.foxnic.web.framework.dao;

import javax.sql.DataSource;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SEQUENCE;
import org.github.foxnic.web.relation.FoxnicWebRelationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DAOBuilder;
import com.github.foxnic.dao.sql.loader.SQLoader;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.sql.treaty.DBTreaty;

@Configuration
public class DBConfigs {
	
	public static final String PRIMARY_DATASOURCE_CONFIG_KEY = "spring.datasource.druid.primary";
	public static final String PRIMARY_DATA_SOURCE_NAME = "primaryDataSource";
	public static final String PRIMARY_DAO = "primaryDAO";
 
	@Value("${"+PRIMARY_DATASOURCE_CONFIG_KEY+".printSQL}")
	private Boolean printSQL;
	
	@Autowired
	private DBTreaty dbTreaty;

	@Value("${develop.start-relation-monitor}")
	private  Boolean startRelationMonitor=false;
 
	@Bean(name = PRIMARY_DATA_SOURCE_NAME)
	@ConfigurationProperties(PRIMARY_DATASOURCE_CONFIG_KEY)
	public DruidDataSource primaryDataSource() {
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean
	@Primary
	public DataSourceTransactionManager primaryTransactionManager(
			@Qualifier(PRIMARY_DATA_SOURCE_NAME) DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean(PRIMARY_DAO)
	@Primary
	public DAO primaryDAO (
			@Qualifier(PRIMARY_DATA_SOURCE_NAME) DataSource dataSource) {
		try {
			if(printSQL==null) printSQL=false;
			DAO dao= (new DAOBuilder().datasource(dataSource)).build();
			dao.setPrintSQL(printSQL);
			dao.setPrintSQLSimple(printSQL);
			dao.setDBTreaty(dbTreaty);
			FoxnicWebRelationManager relationManager=new FoxnicWebRelationManager();
			if(startRelationMonitor) {
				relationManager.startMonitor();
			}
			dao.setRelationManager(relationManager);
			
			//设置序列相关的配置
			dao.setSequenceTable(SYS_SEQUENCE.$NAME);
			dao.setSequenceProcedure("NEXT_VAL");
			
			
			//设置SQL扫描
			SQLoader.setTQLScanPackage(dao,SpringUtil.getStartupClass().getPackage().getName());
			
			return dao;
		} catch (Exception e) {
			Logger.error("创建DAO失败",e);
			return null;
		}
	}

}
