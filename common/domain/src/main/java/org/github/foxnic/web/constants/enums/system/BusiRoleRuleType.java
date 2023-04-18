package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum BusiRoleRuleType implements CodeTextEnum {

	MEMBER("静态成员优先"),
	ROUTER("动态路由优先"),
	UNION("成员合并");

	private String text;

	private BusiRoleRuleType(String text) {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return this.text;
	}

	public static BusiRoleRuleType parseByCode(String code) {
		return (BusiRoleRuleType) EnumUtil.parseByCode(BusiRoleRuleType.values(),code);
	}
}
