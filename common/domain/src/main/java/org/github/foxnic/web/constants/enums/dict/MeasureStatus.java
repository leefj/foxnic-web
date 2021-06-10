package org.github.foxnic.web.constants.enums.dict;




/**
 * @since 2021-06-10 11:58:03
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum MeasureStatus {
	
	/**
	 * 待测量
	*/
	TODO("todo" , "待测量"),
	
	/**
	 * 已测量
	*/
	DONE("done" , "已测量"),
	
	/**
	 * 已废弃
	*/
	ABADON("abadon" , "已废弃"),
	
	/**
	 * 已报告
	*/
	REPORT("report" , "已报告"),
	;
	
	private String code;
	private String text;
	private MeasureStatus(String code,String text)  {
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
	public static MeasureStatus parse(String code) {
		for (MeasureStatus dn : MeasureStatus.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}