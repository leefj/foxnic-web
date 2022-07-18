package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum LoginType implements CodeTextEnum {
	IDENTITY_PWD("帐号密码登录"),
	IDENTITY_PWD_IMG_CAPTCHA("帐号密码图形验证码登录"),
	IDENTITY_TEXT_CAPTCHA("帐号与文本验证码登录");

	private String text;

	private LoginType(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static LoginType parseByCode(String code) {
		return (LoginType) EnumUtil.parseByCode(LoginType.values(),code);
	}

}
