package org.github.foxnic.web.constants.enums.dict;




/**
 * @since 2021-06-10 11:58:03
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum MeasureFileType {
	
	/**
	 * 视频量体
	*/
	VIDEO("video" , "视频量体"),
	
	/**
	 * 照片量体
	*/
	IMAGE("image" , "照片量体"),
	
	/**
	 * 手动量体
	*/
	MANUAL("manual" , "手动量体"),
	;
	
	private String code;
	private String text;
	private MeasureFileType(String code,String text)  {
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
	public static MeasureFileType parse(String code) {
		for (MeasureFileType dn : MeasureFileType.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}