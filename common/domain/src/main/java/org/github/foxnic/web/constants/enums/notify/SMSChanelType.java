package org.github.foxnic.web.constants.enums.notify;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum SMSChanelType implements CodeTextEnum {
	ALI("阿里短信通道"),
	HUAWEI("华为短信通道");
	private String text;

	private SMSChanelType(String text) {
		this.text=text;
	}

	public String code() {
		return this.name().toLowerCase();
	}

	public String text() {
		return this.text;
	}

	public static SMSChanelType parseByCode(String code) {
		return (SMSChanelType) EnumUtil.parseByCode(SMSChanelType.values(),code);
	}
}
