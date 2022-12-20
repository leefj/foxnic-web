package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2022-12-20 10:49:44
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum SysConfigCatalog  implements CodeTextEnum {
	
	/**
	 * 系统配置
	*/
	SYSTEM("system" , "系统配置"),
	
	/**
	 * 组织人事
	*/
	HRM("hrm" , "组织人事"),
	
	/**
	 * 固定资产
	*/
	EAM("eam" , "固定资产"),
	
	/**
	 * 运维系统
	*/
	OPS("ops" , "运维系统"),
	;
	
	private String code;
	private String text;
	private SysConfigCatalog(String code,String text)  {
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
	public static SysConfigCatalog parseByCode(String code) {
		return (SysConfigCatalog) EnumUtil.parseByCode(SysConfigCatalog.values(),code);
	}
}