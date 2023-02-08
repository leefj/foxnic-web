package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2023-02-08 13:58:45
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum HrContractYear  implements CodeTextEnum {
	
	/**
	 * 2021年
	*/
	_2021("2021" , "2021年"),
	
	/**
	 * 2022年
	*/
	_2022("2022" , "2022年"),
	
	/**
	 * 2023年
	*/
	_2023("2023" , "2023年"),
	
	/**
	 * 2024年
	*/
	_2024("2024" , "2024年"),
	
	/**
	 * 2025年
	*/
	_2025("2025" , "2025年"),
	
	/**
	 * 2026年
	*/
	_2026("2026" , "2026年"),
	
	/**
	 * 2027年
	*/
	_2027("2027" , "2027年"),
	
	/**
	 * 2028年
	*/
	_2028("2028" , "2028年"),
	
	/**
	 * 2029年
	*/
	_2029("2029" , "2029年"),
	
	/**
	 * 2030年
	*/
	_2030("2030" , "2030年"),
	
	/**
	 * 2018年
	*/
	_2018("2018" , "2018年"),
	
	/**
	 * 2019年
	*/
	_2019("2019" , "2019年"),
	
	/**
	 * 2020年
	*/
	_2020("2020" , "2020年"),
	;
	
	private String code;
	private String text;
	private HrContractYear(String code,String text)  {
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
	public static HrContractYear parseByCode(String code) {
		return (HrContractYear) EnumUtil.parseByCode(HrContractYear.values(),code);
	}
}