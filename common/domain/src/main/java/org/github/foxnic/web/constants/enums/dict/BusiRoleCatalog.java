package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2023-04-18 09:15:58
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum BusiRoleCatalog  implements CodeTextEnum {
	
	/**
	 * 默认
	*/
	DEFAULTS("defaults" , "默认"),
	
	/**
	 * EAM
	*/
	EAM("eam" , "EAM"),
	;
	
	private String code;
	private String text;
	private BusiRoleCatalog(String code,String text)  {
		this.code=code;
		this.text=text;
	}
	
	public String code() {
		return code;
	}
	
	public String text() {
		return text;
	}
	
	/**
	 * 从字符串转换成当前枚举类型
	*/
	public static BusiRoleCatalog parseByCode(String code) {
		return (BusiRoleCatalog) EnumUtil.parseByCode(BusiRoleCatalog.values(),code);
	}
}