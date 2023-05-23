package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2023-05-23 17:01:23
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum HrContractDuration  implements CodeTextEnum {
	
	/**
	 * 3年
	*/
	_3YEAR("3year" , "3年"),
	
	/**
	 * 5年
	*/
	_5YEAR("5year" , "5年"),
	
	/**
	 * 永久
	*/
	PERMANENT("permanent" , "永久"),
	;
	
	private String code;
	private String text;
	private HrContractDuration(String code,String text)  {
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
	public static HrContractDuration parseByCode(String code) {
		return (HrContractDuration) EnumUtil.parseByCode(HrContractDuration.values(),code);
	}
}