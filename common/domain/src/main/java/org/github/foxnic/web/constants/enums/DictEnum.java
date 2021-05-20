package org.github.foxnic.web.constants.enums;




/**
 * @since 2021-05-20 03:37:46
 * @author 李方捷 , leefangjie@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum DictEnum {
	
	/**
	 * 性别
	*/
	SEX("sex" , "性别"),
	
	/**
	 * 公司类型
	*/
	COMPANY_TYPE("company_type" , "公司类型"),
	
	/**
	 * 订单状态
	*/
	ORDER_STATUS("order_status" , "订单状态"),
	
	/**
	 * 测量状态
	*/
	MEASURE_STATUS("measure_status" , "测量状态"),
	
	/**
	 * 测量文件类型
	*/
	MEASURE_FILE_TYPE("measure_file_type" , "测量文件类型"),
	
	/**
	 * 测量结果类型
	*/
	MEASURE_RESULT_TYPE("measure_result_type" , "测量结果类型"),
	
	/**
	 * 测量方法
	*/
	MEASURE_METHOD("measure_method" , "测量方法"),
	;
	
	private String code;
	private String text;
	private DictEnum(String code,String text)  {
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
	 * 从字符串转换成当前枚举类型，使用 valueOf 方法可能导致偏差，建议不要使用
	*/
	public static DictEnum parse(String code) {
		for (DictEnum dn : DictEnum.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}