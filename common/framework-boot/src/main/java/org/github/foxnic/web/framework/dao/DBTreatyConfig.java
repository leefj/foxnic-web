package org.github.foxnic.web.framework.dao;

import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.session.SessionUser;
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
		dbTreaty.setUserIdDataType(DBDataType.STRING);
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
		dbTreaty.setAutoCastLogicField(false);
		//
		dbTreaty.setFalseValue(0);
		dbTreaty.setTrueValue(1);
		
		//设置获取当前用户的逻辑
		if(SpringUtil.isReady()) {
			dbTreaty.setUserIdHandler(()->{
				SessionUser user=SessionUser.getCurrent();
				if(user==null) return null;
				return  user.getUserId();
			});
		}
		
		//
		return dbTreaty;
	}
	
}
