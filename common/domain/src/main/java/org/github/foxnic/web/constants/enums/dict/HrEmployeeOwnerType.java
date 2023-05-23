package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2023-05-23 17:01:23
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum HrEmployeeOwnerType  implements CodeTextEnum {
	
	/**
	 * 合同工
	*/
	CONTRACT_WORKER("contract_worker" , "合同工"),
	
	/**
	 * 派遣工
	*/
	DISPATCHER("dispatcher" , "派遣工"),
	;
	
	private String code;
	private String text;
	private HrEmployeeOwnerType(String code,String text)  {
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
	public static HrEmployeeOwnerType parseByCode(String code) {
		return (HrEmployeeOwnerType) EnumUtil.parseByCode(HrEmployeeOwnerType.values(),code);
	}
}