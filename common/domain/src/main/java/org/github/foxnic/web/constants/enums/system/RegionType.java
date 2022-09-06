package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum RegionType implements CodeTextEnum {
	DOMESTIC("国内","国内"),
	ABROAD("国外","国外");
	private String desc;
	private String text;

	private RegionType(String text, String desc) {
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

	public static RegionType parseByCode(String code) {
		return (RegionType) EnumUtil.parseByCode(RegionType.values(),code);
	}
}
