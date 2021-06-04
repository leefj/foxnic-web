package org.github.foxnic.web.domain.oauth;

import io.swagger.annotations.ApiModelProperty;



/**
 * 用于App登录接口
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-04 15:27:27
 * @sign 74FF4B889002F5CC161ACC7581CF6E6A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LoginIdentityVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 帐号或手机号等用于识别身份的标识
	*/
	@ApiModelProperty(required = false,value="帐号或手机号等用于识别身份的标识" , notes = "")
	private String identity;
	
	/**
	 * 密码
	*/
	@ApiModelProperty(required = false,value="密码" , notes = "")
	private String passwd;
	
	/**
	 * 随机ID：客户端产生的唯一ID，用于标识一次认证
	*/
	@ApiModelProperty(required = false,value="随机ID" , notes = "客户端产生的唯一ID，用于标识一次认证")
	private String browserId;
	
	/**
	 * 校验码/验证码：用户输入的校验码
	*/
	@ApiModelProperty(required = false,value="校验码/验证码" , notes = "用户输入的校验码")
	private String captcha;
	
	/**
	 * 获得 帐号或手机号等用于识别身份的标识<br>
	 * @return 帐号或手机号等用于识别身份的标识
	*/
	public String getIdentity() {
		return identity;
	}
	
	/**
	 * 设置 帐号或手机号等用于识别身份的标识
	 * @param identity 帐号或手机号等用于识别身份的标识
	 * @return 当前对象
	*/
	public LoginIdentityVO setIdentity(String identity) {
		this.identity=identity;
		return this;
	}
	
	/**
	 * 添加 帐号或手机号等用于识别身份的标识
	 * @param identity 帐号或手机号等用于识别身份的标识
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
	public LoginIdentityVO setPasswd(String passwd) {
		this.passwd=passwd;
		return this;
	}
	
	/**
	 * 添加 密码
	 * @param passwd 密码
	 * @return 当前对象
	*/
	
	/**
	 * 获得 随机ID<br>
	 * 属性说明 : 客户端产生的唯一ID，用于标识一次认证
	 * @return 随机ID
	*/
	public String getBrowserId() {
		return browserId;
	}
	
	/**
	 * 设置 随机ID
	 * @param browserId 随机ID
	 * @return 当前对象
	*/
	public LoginIdentityVO setBrowserId(String browserId) {
		this.browserId=browserId;
		return this;
	}
	
	/**
	 * 添加 随机ID
	 * @param browserId 随机ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 校验码/验证码<br>
	 * 属性说明 : 用户输入的校验码
	 * @return 校验码/验证码
	*/
	public String getCaptcha() {
		return captcha;
	}
	
	/**
	 * 设置 校验码/验证码
	 * @param captcha 校验码/验证码
	 * @return 当前对象
	*/
	public LoginIdentityVO setCaptcha(String captcha) {
		this.captcha=captcha;
		return this;
	}
	
	/**
	 * 添加 校验码/验证码
	 * @param captcha 校验码/验证码
	 * @return 当前对象
	*/
}