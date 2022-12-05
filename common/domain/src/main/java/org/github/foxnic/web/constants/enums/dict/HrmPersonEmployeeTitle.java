package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2022-12-05 14:59:32
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum HrmPersonEmployeeTitle  implements CodeTextEnum {
	
	/**
	 * 工程师
	*/
	H01("h01" , "工程师"),
	;
	
	private String code;
	private String text;
	private HrmPersonEmployeeTitle(String code,String text)  {
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
	public static HrmPersonEmployeeTitle parseByCode(String code) {
		return (HrmPersonEmployeeTitle) EnumUtil.parseByCode(HrmPersonEmployeeTitle.values(),code);
	}
}