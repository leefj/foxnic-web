package org.github.foxnic.web.constants.enums.hrm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum FavouriteItemType implements CodeTextEnum {
	employee("员工"),organization("组织"),position("岗位"),bpm_role("流程角色");

	private String text;
	private FavouriteItemType(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}

	public static FavouriteItemType parseByCode(String code) {
		return (FavouriteItemType)EnumUtil.parseByCode(FavouriteItemType.values(),code);
	}

}
