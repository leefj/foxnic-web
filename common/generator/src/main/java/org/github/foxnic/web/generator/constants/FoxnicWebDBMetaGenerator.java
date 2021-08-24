package org.github.foxnic.web.generator.constants;

import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.builder.constants.DBMetaClassFile;
import org.github.foxnic.web.generator.config.FoxnicWebConfigs;

import java.util.Arrays;
import java.util.List;


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

 	private List<String> hrmTables= Arrays.asList("hrm_person","hrm_employee");
	/**
	 * 生成DBMeta数据
	 * */
	private void buildDBMeta() {
		
		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomianProject(),this.configs.getProjectConfigs().getDomainConstantsPackage(),"FoxnicWeb");
		dbMetaBuilder.setTableFilter(table->{
			table=table.toLowerCase();
			if(table.startsWith("sys_")) return true;
			if(hrmTables.contains(table)) return true;
			return false;
		});
		dbMetaBuilder.save(true);
	}

}
