package org.github.foxnic.web.constants.enums;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2022-12-01 13:56:52
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
	 * 人员档案籍贯
	*/
	HRM_PERSON_NATIVE_PLACE("hrm_person_native_place" , "人员档案籍贯"),
	
	/**
	 * 人员档案婚姻状况
	*/
	HRM_PERSON_MARITAL("hrm_person_marital" , "人员档案婚姻状况"),
	
	/**
	 * 人员档案民族
	*/
	HRM_PERSON_NATION("hrm_person_nation" , "人员档案民族"),
	
	/**
	 * 人员档案学历
	*/
	HRM_PERSON_EDUCATION("hrm_person_education" , "人员档案学历"),
	
	/**
	 * 人员档案人才登记
	*/
	HRM_PERSON_TALENT_LEVEL("hrm_person_talent_level" , "人员档案人才登记"),
	
	/**
	 * 人员档案政治面貌
	*/
	HRM_PERSON_POLITIC("hrm_person_politic" , "人员档案政治面貌"),
	
	/**
	 * 员工工种
	*/
	HRM_PERSON_WORK_KIND("hrm_person_work_kind" , "员工工种"),
	
	/**
	 * 员工职称
	*/
	HRM_PERSON_EMPLOYEE_TITLE("hrm_person_employee_title" , "员工职称"),
	
	/**
	 * 员工类型
	*/
	EMPLOYEE_TYPE("employee_type" , "员工类型"),
	
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