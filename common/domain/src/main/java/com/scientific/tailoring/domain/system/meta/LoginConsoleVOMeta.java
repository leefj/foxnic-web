package com.scientific.tailoring.domain.system.meta;

import com.scientific.tailoring.domain.system.LoginConsoleVO;



/**
 * @author 李方捷
 * @since 2021-05-17 11:36:46
 * @sign BB0D730BF581D28E0D83EEA96A1757E7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LoginConsoleVOMeta {
	
	/**
	 * 帐号或手机号
	*/
	public static final String IDENTITY="identity";
	
	/**
	 * 密码
	*/
	public static final String PASSWD="passwd";
	
	/**
	 * 设备ID , 客户端产生的UUID
	*/
	public static final String DEVICE_ID="deviceId";
	
	/**
	 * 校验码 , 用户输入的校验码
	*/
	public static final String CODE="code";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ IDENTITY , PASSWD , DEVICE_ID , CODE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.system.LoginConsoleVO {
		
		/**
		 * 设置 帐号或手机号
		 * @param identity 帐号或手机号
		 * @return 当前对象
		*/
		public LoginConsoleVO setIdentity(String identity) {
			super.change(IDENTITY,super.getIdentity(),identity);
			super.setIdentity(identity);
				return this;
		}
		
		/**
		 * 设置 密码
		 * @param passwd 密码
		 * @return 当前对象
		*/
		public LoginConsoleVO setPasswd(String passwd) {
			super.change(PASSWD,super.getPasswd(),passwd);
			super.setPasswd(passwd);
				return this;
		}
		
		/**
		 * 设置 设备ID
		 * @param deviceId 设备ID
		 * @return 当前对象
		*/
		public LoginConsoleVO setDeviceId(String deviceId) {
			super.change(DEVICE_ID,super.getDeviceId(),deviceId);
			super.setDeviceId(deviceId);
				return this;
		}
		
		/**
		 * 设置 校验码
		 * @param code 校验码
		 * @return 当前对象
		*/
		public LoginConsoleVO setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
				return this;
		}
}
}