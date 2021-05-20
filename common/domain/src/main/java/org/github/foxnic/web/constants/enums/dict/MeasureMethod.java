package org.github.foxnic.web.constants.enums.dict;




/**
 * @since 2021-05-20 03:37:46
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum MeasureMethod {
	
	/**
	 * 图片
	*/
	IMAGE("image" , "图片"),
	
	/**
	 * 视频
	*/
	VIDEO("video" , "视频"),
	;
	
	private String code;
	private String text;
	private MeasureMethod(String code,String text)  {
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
	public static MeasureMethod parse(String code) {
		for (MeasureMethod dn : MeasureMethod.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}