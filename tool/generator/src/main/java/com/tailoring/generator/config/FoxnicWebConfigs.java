package com.tailoring.generator.config;

import java.io.File;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.commons.property.YMLProperties;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DAOBuilder;
import com.github.foxnic.generatorV2.config.GlobalSettings;
import com.github.foxnic.sql.treaty.DBTreaty;
import com.scientific.tailoring.framework.dao.DBTreatyConfig;
import com.scientific.tailoring.framework.nacos.NacosConfig;

public class FoxnicWebConfigs {
	
	private GlobalSettings settings=null;
	
	//
	private MavenProject  generatorProject=null;
	private MavenProject  domianProject=null;
	private MavenProject serviceProject;
	private MavenProject proxyProject;
	
	//
	private String nacosGroup;
	private String nacosDataId;
	
	//
	private String nacosServerAddr = null;
	private String nacosNamespace=null;
	private String nacosUserName=null;
	private String nacosPassword=null;
	//
	private String datasourceConfigKey=null;
	//
	private YMLProperties properties;
	private DAO dao;
	
	
	public FoxnicWebConfigs() {
		this(FoxnicWebConstants.SERVICE_SYSTEM_PROJECT_FOLDER_NAME, FoxnicWebConstants.PRIMARY_DATASOURCE_CONFIG_KEY, FoxnicWebConstants.NACOS_GROUP, FoxnicWebConstants.DEFAULT_NACOS_DATA_ID);
	}
	
	public FoxnicWebConfigs(String serviceProjectFolderName) {
		this(serviceProjectFolderName, FoxnicWebConstants.PRIMARY_DATASOURCE_CONFIG_KEY, FoxnicWebConstants.NACOS_GROUP, FoxnicWebConstants.DEFAULT_NACOS_DATA_ID);
	}
	
	public FoxnicWebConfigs(String serviceProjectFolderName,String datasourceConfigKey,String nacosGroup,String nacosDataId) {
		
		initGlobalSettings();
 
		//
		generatorProject=new MavenProject(FoxnicWebConfigs.class);
		
		File baseDir=generatorProject.getProjectDir().getParentFile().getParentFile();
		
		//
		File domainProjectFolder=FileUtil.resolveByPath(baseDir, FoxnicWebConstants.DOMAIN_PROJECT_FOLDER_NAME);
		domianProject=new MavenProject(domainProjectFolder); 
		
		File serviceProjectFolder=FileUtil.resolveByPath(baseDir, FoxnicWebConstants.SERVICE_SYSTEM_PROJECT_FOLDER_NAME);
		serviceProject=new MavenProject(serviceProjectFolder);
		
		File proxyProjectFolder=FileUtil.resolveByPath(baseDir, FoxnicWebConstants.AGENT_PROJECT_FOLDER_NAME);
		proxyProject=new MavenProject(proxyProjectFolder);
		
		//读取配置
		File bootstrap=FileUtil.resolveByPath(this.getServiceProject().getMainResourceDir(), "bootstrap.yml");
		YMLProperties bootstrapProperties=new YMLProperties(bootstrap);
		nacosServerAddr=bootstrapProperties.getProperty("application.nacos.ip").stringValue();
		nacosUserName=bootstrapProperties.getProperty("application.nacos.username").stringValue();
		nacosPassword=bootstrapProperties.getProperty("application.nacos.password").stringValue();
		nacosNamespace=bootstrapProperties.getProperty("application.nacos.namespace").stringValue();
		//
		this.nacosDataId=nacosDataId;
		this.nacosGroup=nacosGroup;
		this.datasourceConfigKey=datasourceConfigKey;
		
		//
		File file= this.saveRemoteConfig();
		
		//配置文件
		properties=new YMLProperties(file);
 
		try {
			initDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	private void initGlobalSettings() {
		this.settings=new GlobalSettings();
		//
		this.settings.setAuthor("李方捷");
		this.settings.setEnableSwagger(true);
		this.settings.setEnableMicroService(FoxnicWebConstants.ENABLE_MICRO_SERVICE);
		
	}

	private void initDAO() throws Exception {
		
		if(dao!=null) return;
		
		// 读取数据库配置
		
		String prefix=this.getDatasourceConfigKey()+".";
		//
		String driver=properties.getProperty(prefix+"driver-class-name").stringValue();
		String url=properties.getProperty(prefix+"url").stringValue();
		String username=properties.getProperty(prefix+"username").stringValue();
		String password=properties.getProperty(prefix+"password").stringValue();
		
		// 创建数据源
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl(url);
		ds.setDriverClassName(driver);
		ds.setUsername(username);
		ds.setPassword(password);
		dao = (new DAOBuilder()).datasource(ds).build();
		
		// 设置数据库规约
		DBTreaty dbTreaty = (new DBTreatyConfig()).getDBTreaty();
		dao.setDBTreaty(dbTreaty);
//		dao.setRelationManager(new TailoringRelationManager());
		
 
	}

	private File saveRemoteConfig() {
		NacosConfig nacosConfig=new NacosConfig(this.getNacosServerAddr(), this.getNacosNamespace(), this.getNacosUserName(), this.getNacosPassword());
		File file=FileUtil.resolveByPath(this.getGeneratorProject().getMainResourceDir(), "remote",this.getNacosNamespace()+"."+this.nacosGroup+"."+this.nacosDataId);
		nacosConfig.saveConfig(this.nacosDataId, this.nacosGroup, file);
		return file;
	}
	
	public MavenProject getGeneratorProject() {
		return generatorProject;
	}



	public MavenProject getDomianProject() {
		return domianProject;
	}



	public MavenProject getServiceProject() {
		return serviceProject;
	}



	public MavenProject getProxyProject() {
		return proxyProject;
	}
 
	public String getNacosServerAddr() {
		return nacosServerAddr;
	}
 
	public String getNacosNamespace() {
		return nacosNamespace;
	}
 
	public String getNacosUserName() {
		return nacosUserName;
	}
 
	public String getNacosPassword() {
		return nacosPassword;
	}
 
	public String getDatasourceConfigKey() {
		return datasourceConfigKey;
	}
 
	public DAO getDAO() {
		return dao;
	}

	public GlobalSettings getSettings() {
		return settings;
	}
 
}
