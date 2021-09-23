package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum YesNo implements CodeTextEnum {
	yes("1","是"),no("0","否");

	private String text;
	private String code;

	private YesNo(String code,String text)  {
		this.code=code;
		this.text=text;
	}
	
	public String code() {
		return this.code;
	}
	
	public String text() {
		return text;
	}

	public static YesNo parseByCode(String code) {
		return (YesNo) EnumUtil.parseByCode(YesNo.values(),code);
	}

}
