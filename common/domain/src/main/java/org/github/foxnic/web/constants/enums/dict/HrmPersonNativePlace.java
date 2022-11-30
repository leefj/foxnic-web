package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2022-11-30 09:46:32
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum HrmPersonNativePlace  implements CodeTextEnum {
	
	/**
	 * 浙江
	*/
	ZJ("zj" , "浙江"),
	
	/**
	 * 上海
	*/
	SH("sh" , "上海"),
	;
	
	private String code;
	private String text;
	private HrmPersonNativePlace(String code,String text)  {
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
	public static HrmPersonNativePlace parseByCode(String code) {
		return (HrmPersonNativePlace) EnumUtil.parseByCode(HrmPersonNativePlace.values(),code);
	}
}