package org.github.foxnic.web.framework.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.foxnic.sql.meta.DBDataType;
import com.github.foxnic.sql.treaty.DBTreaty;

@Configuration
public class DBTreatyConfig {
	
	
 
	@Bean
	public DBTreaty getDBTreaty() {
		
		DBTreaty dbTreaty=new DBTreaty();
		//
		dbTreaty.setAllowDeleteWithoutWhere(false);
		dbTreaty.setAllowUpdateWithoutWhere(false);
		
		//
		dbTreaty.setUserIdDataType(DBDataType.BIGINT);
		//
		dbTreaty.setCreateTimeField("create_time");
		dbTreaty.setCreateUserIdField("create_by");
		//
		dbTreaty.setUpdateTimeField("update_time");
		dbTreaty.setUpdateUserIdField("update_by");
		//
		dbTreaty.setDeletedField("deleted");
		dbTreaty.setDeleteTimeField("delete_time");
		dbTreaty.setDeleteUserIdField("delete_by");
		//
		dbTreaty.setVersionField("version");
		//
		dbTreaty.setAutoCastLogicField(true);
		dbTreaty.addLogicFieldPatten("is_");
		dbTreaty.addLogicField("*", "valid");
		//
		dbTreaty.setFalseValue(0);
		dbTreaty.setTrueValue(1);
		
		//设置获取当前用户的逻辑
//		if(SpringUtil.isReady()) {
//			securityService=SpringUtil.getBean(ISecurityService.class);
//			dbTreaty.setUserIdHandler(()->{
//				securityService=SpringUtil.getBean(ISecurityService.class);
//				if(securityService.getSessionSubject()==null) return null;
//				return securityService.getSessionSubject().getUserId();
//			});
//		}
		
		//
		return dbTreaty;
	}
	
}
