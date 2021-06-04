package org.github.foxnic.web.domain.oauth.meta;




/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-04 15:27:27
 * @sign 74FF4B889002F5CC161ACC7581CF6E6A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LoginIdentityVOMeta {
	
	/**
	 * 帐号或手机号等用于识别身份的标识
	*/
	public static final String IDENTITY="identity";
	
	/**
	 * 密码
	*/
	public static final String PASSWD="passwd";
	
	/**
	 * 随机ID , 客户端产生的唯一ID，用于标识一次认证
	*/
	public static final String BROWSER_ID="browserId";
	
	/**
	 * 校验码/验证码 , 用户输入的校验码
	*/
	public static final String CAPTCHA="captcha";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ IDENTITY , PASSWD , BROWSER_ID , CAPTCHA };
}