package com.scientific.tailoring.domain.system.meta;

import com.scientific.tailoring.domain.system.LoginAppVO;



/**
 * @author 李方捷
 * @since 2021-05-17 10:56:38
 * @sign 3E5748202EF4B18748B386F50794B963
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LoginAppVOMeta {
	
	/**
	 * 帐号或手机号
	*/
	public static final String IDENTITY="identity";
	
	/**
	 * 密码
	*/
	public static final String PASSWD="passwd";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ IDENTITY , PASSWD };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.system.LoginAppVO {
		
		/**
		 * 设置 帐号或手机号
		 * @param identity 帐号或手机号
		 * @return 当前对象
		*/
		public LoginAppVO setIdentity(String identity) {
			super.change(IDENTITY,super.getIdentity(),identity);
			super.setIdentity(identity);
				return this;
		}
		
		/**
		 * 设置 密码
		 * @param passwd 密码
		 * @return 当前对象
		*/
		public LoginAppVO setPasswd(String passwd) {
			super.change(PASSWD,super.getPasswd(),passwd);
			super.setPasswd(passwd);
				return this;
		}
}
}