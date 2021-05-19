package com.scientific.tailoring.domain.system.meta;

import com.scientific.tailoring.domain.system.UserEditModel;
import java.util.List;



/**
 * @author 李方捷
 * @since 2021-05-17 10:53:40
 * @sign F9460BC70824A83C1479BB1EA5D78664
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserEditModelMeta {
	
	/**
	 * 角色ID清单
	*/
	public static final String ROLE_IDS="roleIds";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ROLE_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.system.UserEditModel {
		
		/**
		 * 设置 角色ID清单
		 * @param roleIds 角色ID清单
		 * @return 当前对象
		*/
		public UserEditModel setRoleIds(List<Integer> roleIds) {
			super.change(ROLE_IDS,super.getRoleIds(),roleIds);
			super.setRoleIds(roleIds);
				return this;
		}
}
}