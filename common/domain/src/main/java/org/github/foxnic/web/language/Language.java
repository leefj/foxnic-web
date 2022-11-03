package org.github.foxnic.web.language;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.language.GlobalLanguage;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 系统支持的语言
 * */
public enum Language implements CodeTextEnum {
	//
	auto("自动识别"),defaults("默认语言"),
	//
	zh_cn("中文简体"),zh_tw("中文(台湾)"),zh_hk("中文(香港)"),zh_mo("中文(澳门)"),
	//
	en_us("English-US"),en_gb("English-UK"),
	//
	ko_kr("韩语"),ja_jp("日语"),
	//
	confuse("混淆");

	private String text;
	private String property;

	private Language(String text)  {
		this.text=text;
		this.property= BeanNameUtil.instance().getPropertyName(this.name());
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public String property() {
		return property;
	}

	public static Language parseByCode(String code) {
		return (Language) EnumUtil.parseByCode(Language.values(),code);
	}



	@Override
	public JSONObject toJSONObject(String languageContext) {
		JSONObject item = new JSONObject();
		item.put("code", this.code());
		item.put("property", this.property());
		item.put("text", LanguageServiceInstance.get().translate(this.text(),null,languageContext));
		return item;
	}

	/**
	 * 把全球语言转换成系统支持的语言体系
	 * */
	public static Language parseByGlobalLanguage(GlobalLanguage globalLanguage) {
		Language language = null;
		try {
			language = Language.valueOf(globalLanguage.name());
		} catch (Exception e) {}
		return language;
	}

}
