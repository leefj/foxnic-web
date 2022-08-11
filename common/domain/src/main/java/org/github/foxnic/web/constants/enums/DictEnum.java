package org.github.foxnic.web.constants.enums;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2022-07-26 15:42:45
 * @author 李方捷 , leefangjie@qq.com
 * 从 select distinct code,name from sys_dict WHERE deleted=0 and module in ('system','hrm','463397133957988352') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum DictEnum implements CodeTextEnum {
	
	/**
	 * 性别
	*/
	SEX("sex" , "性别"),
	
	/**
	 * 订单状态
	*/
	ORDER_STATUS("order_status" , "订单状态"),
	
	/**
	 * 组织节点类型
	*/
	ORG_NODE_TYPE("org_node_type" , "组织节点类型"),
	
	/**
	 * 在职状态
	*/
	EMPLOYEE_STATUS("employee_status" , "在职状态"),
	
	/**
	 * 岗位分类
	*/
	POSITION_TYPE("position_type" , "岗位分类"),
	
	/**
	 * 请假类型
	*/
	LEAVE_TYPE("leave_type" , "请假类型"),
	
	/**
	 * 系统配置分类
	*/
	SYS_CONFIG_CATALOG("sys_config_catalog" , "系统配置分类"),
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
	 * 从字符串转换成当前枚举类型
	*/
	public static DictEnum parseByCode(String code) {
		return (DictEnum) EnumUtil.parseByCode(DictEnum.values(),code);
	}
}