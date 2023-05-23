package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2023-05-23 17:01:23
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum BusiRoleCatalog  implements CodeTextEnum {
	
	/**
	 * 默认
	*/
	DEFAULTS("defaults" , "默认"),
	
	/**
	 * 资产
	*/
	EAM("eam" , "资产"),
	
	/**
	 * 系统
	*/
	SYS("sys" , "系统"),
	
	/**
	 * 流程
	*/
	BPM("bpm" , "流程"),
	
	/**
	 * 运维
	*/
	OPS("ops" , "运维"),
	;
	
	private String code;
	private String text;
	private BusiRoleCatalog(String code,String text)  {
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
	public static BusiRoleCatalog parseByCode(String code) {
		return (BusiRoleCatalog) EnumUtil.parseByCode(BusiRoleCatalog.values(),code);
	}
}