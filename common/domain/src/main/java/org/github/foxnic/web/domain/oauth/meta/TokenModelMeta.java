package org.github.foxnic.web.domain.oauth.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-28 14:48:58
 * @sign 23CDE697EC92B4743B0A12B929D8E1AF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TokenModelMeta {
	
	/**
	 * accessToken , 类型: java.lang.String
	*/
	public static final String ACCESS_TOKEN="accessToken";
	
	/**
	 * accessToken , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.TokenModel,java.lang.String> ACCESS_TOKEN_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.TokenModel.class ,ACCESS_TOKEN, java.lang.String.class, "accessToken", "", java.lang.String.class, null);
	
	/**
	 * refreshToken , 类型: java.lang.String
	*/
	public static final String REFRESH_TOKEN="refreshToken";
	
	/**
	 * refreshToken , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.TokenModel,java.lang.String> REFRESH_TOKEN_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.TokenModel.class ,REFRESH_TOKEN, java.lang.String.class, "refreshToken", "", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ACCESS_TOKEN , REFRESH_TOKEN };
}