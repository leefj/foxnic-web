package org.github.foxnic.web.constants.enums.job;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum MisfirePolicy implements CodeTextEnum {
	LOGIN("登录","登录后即可访问"),
	GRANT("授权","需要有相应的权限才可访问");
	private String desc;
	private String text;

	private MisfirePolicy(String text, String desc) {
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

	public static MisfirePolicy parseByCode(String code) {
		return (MisfirePolicy) EnumUtil.parseByCode(MisfirePolicy.values(),code);
	}
}
