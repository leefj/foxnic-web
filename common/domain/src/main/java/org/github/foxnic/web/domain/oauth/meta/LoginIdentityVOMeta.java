package org.github.foxnic.web.domain.oauth.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-30 14:20:08
 * @sign 74FF4B889002F5CC161ACC7581CF6E6A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LoginIdentityVOMeta {
	
	/**
	 * 帐号或手机号等用于识别身份的标识
	*/
	public static final String IDENTITY="identity";
	
	/**
	 * 帐号或手机号等用于识别身份的标识
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.LoginIdentityVO,java.lang.String> IDENTITY_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.LoginIdentityVO.class ,IDENTITY, java.lang.String.class, "帐号或手机号等用于识别身份的标识", "", java.lang.String.class, null);
	
	/**
	 * 密码
	*/
	public static final String PASSWD="passwd";
	
	/**
	 * 密码
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.LoginIdentityVO,java.lang.String> PASSWD_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.LoginIdentityVO.class ,PASSWD, java.lang.String.class, "密码", "", java.lang.String.class, null);
	
	/**
	 * 随机ID , 客户端产生的唯一ID，用于标识一次认证
	*/
	public static final String BROWSER_ID="browserId";
	
	/**
	 * 随机ID , 客户端产生的唯一ID，用于标识一次认证
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.LoginIdentityVO,java.lang.String> BROWSER_ID_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.LoginIdentityVO.class ,BROWSER_ID, java.lang.String.class, "随机ID", "客户端产生的唯一ID，用于标识一次认证", java.lang.String.class, null);
	
	/**
	 * 校验码/验证码 , 用户输入的校验码
	*/
	public static final String CAPTCHA="captcha";
	
	/**
	 * 校验码/验证码 , 用户输入的校验码
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.LoginIdentityVO,java.lang.String> CAPTCHA_PROP=new BeanProperty(org.github.foxnic.web.domain.oauth.LoginIdentityVO.class ,CAPTCHA, java.lang.String.class, "校验码/验证码", "用户输入的校验码", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ IDENTITY , PASSWD , BROWSER_ID , CAPTCHA };
}