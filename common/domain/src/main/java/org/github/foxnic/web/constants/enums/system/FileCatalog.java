package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 存储文件分类；可用于做一些特殊处理，如文件不存在是可以根据分类返回默认值
 * */
public enum FileCatalog implements CodeTextEnum {

	FILE("file","文件"),
	IMAGE("image","图片"),
	PORTRAIT("portrait","头像");

	private String desc;
	private String text;

	private FileCatalog(String text, String desc) {
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

	public static FileCatalog parseByCode(String code) {
		return (FileCatalog) EnumUtil.parseByCode(FileCatalog.values(),code);
	}
}
