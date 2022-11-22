package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum SSOResponseFormat implements CodeTextEnum {
	JSON("响应JSON格式的数据"),
	HTML("响应HTML后，JS重定向");
	private String desc;

	private SSOResponseFormat(String desc) {
		this.desc=desc;
	}

	public String code() {
		return this.name().toLowerCase();
	}

	public String text() {
		return this.name();
	}

	@Override
	public String description() {
		return this.desc;
	}

	public static SSOResponseFormat parseByCode(String code) {
		SSOResponseFormat format=(SSOResponseFormat) EnumUtil.parseByCode(SSOResponseFormat.values(),code);
		if(format==null) {
			format=HTML;
		}
		return format;
	}
}
