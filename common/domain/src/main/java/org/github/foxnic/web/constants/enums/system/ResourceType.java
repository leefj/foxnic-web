package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum ResourceType implements CodeTextEnum {
	page("页面"),api("接口"),other("其它");
	private String text;
	private ResourceType(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static ResourceType parseByCode(String code) {
		return (ResourceType) EnumUtil.parseByCode(ResourceType.values(),code);
	}

}
