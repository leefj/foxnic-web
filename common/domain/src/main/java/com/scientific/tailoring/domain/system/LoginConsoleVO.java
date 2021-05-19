package com.scientific.tailoring.domain.system;

import io.swagger.annotations.ApiModelProperty;



/**
 * 用于App登录接口
 * @author 李方捷
 * @since 2021-05-17 11:36:46
 * @sign BB0D730BF581D28E0D83EEA96A1757E7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LoginConsoleVO extends User {

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
	 * 设备ID：客户端产生的UUID
	*/
	@ApiModelProperty(required = false,value="设备ID" , notes = "客户端产生的UUID")
	private String deviceId;
	
	/**
	 * 校验码：用户输入的校验码
	*/
	@ApiModelProperty(required = false,value="校验码" , notes = "用户输入的校验码")
	private String code;
	
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
	public LoginConsoleVO setIdentity(String identity) {
		this.identity=identity;
		return this;
	}
	
	/**
	 * 添加 帐号或手机号
	 * @param identity 帐号或手机号
	 * @return 当前对象
	*/
	
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
	public LoginConsoleVO setPasswd(String passwd) {
		this.passwd=passwd;
		return this;
	}
	
	/**
	 * 添加 密码
	 * @param passwd 密码
	 * @return 当前对象
	*/
	
	/**
	 * 获得 设备ID<br>
	 * 属性说明 : 客户端产生的UUID
	 * @return 设备ID
	*/
	public String getDeviceId() {
		return deviceId;
	}
	
	/**
	 * 设置 设备ID
	 * @param deviceId 设备ID
	 * @return 当前对象
	*/
	public LoginConsoleVO setDeviceId(String deviceId) {
		this.deviceId=deviceId;
		return this;
	}
	
	/**
	 * 添加 设备ID
	 * @param deviceId 设备ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 校验码<br>
	 * 属性说明 : 用户输入的校验码
	 * @return 校验码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 校验码
	 * @param code 校验码
	 * @return 当前对象
	*/
	public LoginConsoleVO setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 添加 校验码
	 * @param code 校验码
	 * @return 当前对象
	*/
}