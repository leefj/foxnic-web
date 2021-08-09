package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-08-09 14:52:55
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum MeasureMethod  implements CodeTextEnum {
	
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
}