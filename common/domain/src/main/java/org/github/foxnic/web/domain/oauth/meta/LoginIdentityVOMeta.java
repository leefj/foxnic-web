package org.github.foxnic.web.domain.oauth.meta;




/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-27 04:42:00
 * @sign 43957C3099E703A28DAA984C8B965ECE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LoginIdentityVOMeta {
	
	/**
	 * 帐号或手机号
	*/
	public static final String IDENTITY="identity";
	
	/**
	 * 密码
	*/
	public static final String PASSWD="passwd";
	
	/**
	 * 随机ID , 客户端产生的唯一ID，用于标识一次认证
	*/
	public static final String RANDOM_ID="randomId";
	
	/**
	 * 校验码 , 用户输入的校验码
	*/
	public static final String VCODE="vcode";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ IDENTITY , PASSWD , RANDOM_ID , VCODE };
}