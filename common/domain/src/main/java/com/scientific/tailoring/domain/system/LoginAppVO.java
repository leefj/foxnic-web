package com.scientific.tailoring.domain.system;

import io.swagger.annotations.ApiModelProperty;



/**
 * 用于PC登录接口
 * @author 李方捷
 * @since 2021-05-17 10:56:38
 * @sign 3E5748202EF4B18748B386F50794B963
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LoginAppVO extends User {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 帐号或手机号
	*/
	@ApiModelProperty(required = false,value="帐号或手机号" , notes = "")
	private String identity;
	
	/**
	 * 密码
	*/
	@ApiModelProperty(required = false,value="密码" , notes = "")
	private String passwd;
	
	/**
	 * 获得 帐号或手机号<br>
	 * @return 帐号或手机号
	*/
	public String getIdentity() {
		return identity;
	}
	
	/**
	 * 设置 帐号或手机号
	 * @param identity 帐号或手机号
	 * @return 当前对象
	*/
	public LoginAppVO setIdentity(String identity) {
		this.identity=identity;
		return this;
	}
	
	/**
	 * 获得 密码<br>
	 * @return 密码
	*/
	public String getPasswd() {
		return passwd;
	}
	
	/**
	 * 设置 密码
	 * @param passwd 密码
	 * @return 当前对象
	*/
	public LoginAppVO setPasswd(String passwd) {
		this.passwd=passwd;
		return this;
	}
}