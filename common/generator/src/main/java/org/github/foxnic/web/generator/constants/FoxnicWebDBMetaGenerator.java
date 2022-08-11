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

 	private List<String> hrmTables= Arrays.asList(
 			"hrm_person","hrm_employee","hrm_company",
			"hrm_employee_position","hrm_position","hrm_organization"
	);
	private List<String> pcmTables= Arrays.asList("pcm_catalog","pcm_catalog_attribute","pcm_catalog_allocation","hrm_favourite_group","hrm_favourite_group_item");
	/**
	 * 生成DBMeta数据
	 * */
	private void buildDBMeta() {

		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomainProject(),this.configs.getProjectConfigs().getDomainConstantsPackage(),"FoxnicWeb");
		dbMetaBuilder.setTableFilter(table->{
			table=table.toLowerCase();
			if(table.startsWith("sys_")) return true;
			if(table.startsWith("chs_")) return true;
			if(table.startsWith("bpm_")) return true;
			if(table.startsWith("dp_")) return true;
			if(pcmTables.contains(table)) return true;
			if(hrmTables.contains(table)) return true;
			if(table.startsWith("sys_job_")) {
				if(table.equals("sys_job_log")) return true;
				if(table.equals("sys_job_worker")) return true;
				else return false;
			}
			return false;
		});
		dbMetaBuilder.save(true);
	}

}
