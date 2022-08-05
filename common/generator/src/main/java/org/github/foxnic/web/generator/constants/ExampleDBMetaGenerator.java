package org.github.foxnic.web.generator.constants;

import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.builder.constants.DBMetaClassFile;
import org.github.foxnic.web.generator.config.FoxnicWebConfigs;


public class ExampleDBMetaGenerator {

	/**
	 * 运行main函数生成代码
	 * */
	public static void main(String[] args) throws Exception {
		ExampleDBMetaGenerator g = new ExampleDBMetaGenerator();
		g.buildDBMeta();
	}

	private FoxnicWebConfigs configs;
	private DAO dao;

	public ExampleDBMetaGenerator() {
		// 这里无所谓，service-system 可以不修改
		this.configs=new FoxnicWebConfigs("service-system");
		this.dao=this.configs.getDAO();
	}

	/**
	 * 生成DBMeta数据
	 * */
	private void buildDBMeta() {
		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomainProject(),this.configs.getProjectConfigs().getDomainConstantsPackage(),"ExampleTables");
		dbMetaBuilder.setTableFilter(table->{
			table=table.toLowerCase();
			// 仅生成以 example_ 开头的表
			if(table.startsWith("example_")) return true;
			return false;
		});
		dbMetaBuilder.save(true);
	}
}
