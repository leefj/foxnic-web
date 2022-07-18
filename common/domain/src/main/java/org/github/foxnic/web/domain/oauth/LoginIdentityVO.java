package org.github.foxnic.web.domain.oauth;

import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.system.LoginType;
import javax.persistence.Transient;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;



/**
 * 用于App登录接口
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-18 14:46:26
 * @sign F71081E5B7882E4896C8FA7E81255A58
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
	 * 登录方式：登录方式
	*/
	@ApiModelProperty(required = false,value="登录方式" , notes = "登录方式")
	private String loginType;
	@Transient
	private LoginType loginTypeEnum;
	
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
	 * 获得 随机ID<br>
	 * 客户端产生的唯一ID，用于标识一次认证
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
	 * 获得 校验码/验证码<br>
	 * 用户输入的校验码
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
	 * 获得 登录方式<br>
	 * 登录方式
	 * @return 登录方式
	*/
	public String getLoginType() {
		return loginType;
	}
	
	/**
	 * 获得 登录方式 的投影属性<br>
	 * 等价于 getLoginType 方法，获得对应的枚举类型
	 * @return 登录方式
	*/
	@Transient
	public LoginType getLoginTypeEnum() {
		if(this.loginTypeEnum==null) {
			this.loginTypeEnum = (LoginType) EnumUtil.parseByCode(LoginType.values(),loginType);
		}
		return this.loginTypeEnum ;
	}
	
	/**
	 * 设置 登录方式
	 * @param loginType 登录方式
	 * @return 当前对象
	*/
	public LoginIdentityVO setLoginType(String loginType) {
		this.loginType=loginType;
		this.loginTypeEnum= (LoginType) EnumUtil.parseByCode(LoginType.values(),loginType) ;
		if(StringUtil.hasContent(loginType) && this.loginTypeEnum==null) {
			throw new IllegalArgumentException( loginType + " is not one of LoginType");
		}
		return this;
	}
	
	/**
	 * 设置 登录方式的投影属性，等同于设置 登录方式
	 * @param loginTypeEnum 登录方式
	 * @return 当前对象
	*/
	@Transient
	public LoginIdentityVO setLoginTypeEnum(LoginType loginTypeEnum) {
		if(loginTypeEnum==null) {
			this.setLoginType(null);
		} else {
			this.setLoginType(loginTypeEnum.code());
		}
		this.loginTypeEnum=loginTypeEnum;
		return this;
	}
}