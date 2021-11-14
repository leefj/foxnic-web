package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum AccessType implements CodeTextEnum {
	LOGIN("登录","登录后即可访问"),
	GRANT("授权","需要有相应的权限才可访问");
	private String desc;
	private String text;

	private AccessType(String text,String desc) {
		this.desc=desc;
		this.text=text;
	}

	public String code() {
		return this.name();
	}
	
	public String text() {
		return this.text;
	}

	@Override
	public String description() {
		return this.desc;
	}

	public static AccessType parseByCode(String code) {
		return (AccessType) EnumUtil.parseByCode(AccessType.values(),code);
	}
}
