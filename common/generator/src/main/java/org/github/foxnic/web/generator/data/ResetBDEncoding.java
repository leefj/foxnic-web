package org.github.foxnic.web.generator.data;

import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.meta.DBDataType;
import org.github.foxnic.web.generator.config.FoxnicWebConfigs;

import java.util.List;

/**
 * 重置数据表以及字段的编码
 */
public class ResetBDEncoding {



	public static void main(String[] args) throws Exception {
		ResetBDEncoding g = new ResetBDEncoding();
//		g.reset();
		g.resetTable("sys_sequence_test");

	}

	private void reset() {

		dao.beginTransaction();
		dao.execute("SET FOREIGN_KEY_CHECKS = 0");
		String[] tables=dao.getTableNames();
		for (String table : tables) {
			table=table.toLowerCase();
			//if(!table.equalsIgnoreCase("bpm_demo_leave")) continue;
			if(!table.startsWith("sys_job_")) continue;
			if(table.startsWith("act_")) continue;
			resetTable(table);
		}
		dao.execute("SET FOREIGN_KEY_CHECKS = 1");
		dao.commit();

	}

	private void resetTable(String table) {
		dao.execute("alter table `"+table+"` collate = utf8mb4_general_ci");
		DBTableMeta tm=dao.getTableMeta(table);
		List<DBColumnMeta> cms=tm.getColumns();
		for (DBColumnMeta cm : cms) {
			if(cm.getDBDataType()== DBDataType.STRING) {
				String type=cm.getLocalDataType();
				if(type.equalsIgnoreCase("varchar")) {
					type+="("+cm.getCharLength()+")";
				}
				String nul="null";
				if(!cm.isNullable()) {
					nul="not null";
				}

				String def="";
				if(cm.isPK()) {
					def="";
				} else {
					if(cm.getDefaultValue()!=null) {
						def="DEFAULT "+cm.getDefaultValue();
					}
				}

				dao.execute("alter table `"+table+"` modify column `"+cm.getColumn()+"` "+type+" character set utf8mb4 collate utf8mb4_general_ci "+nul+" "+def+" COMMENT '"+cm.getComment()+"'");
			}
		}
	}

	private FoxnicWebConfigs configs;
	private DAO dao;

	public ResetBDEncoding() {
		this.configs=new FoxnicWebConfigs("service-system");
		this.dao=this.configs.getDAO();
	}


}
