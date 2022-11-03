package org.github.foxnic.web.system.api.baidu;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;
import org.github.foxnic.web.language.Language;

/**
 * 系统支持的语言
 * */
public enum BaiDuLanguage implements CodeTextEnum {
	//
	zh("中文简体",Language.zh_cn),cht("中文繁体",Language.zh_hk,Language.zh_mo,Language.zh_tw),
	//
	en("English-US",Language.en_us,Language.en_gb),
	//
	kor("韩语",Language.ko_kr),jp("日语",Language.ja_jp);


	private String text;

	private Language[] languages = null;
	private BaiDuLanguage(String text,Language... languages)  {
		this.text=text;
		this.languages=languages;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}


	public Language[] getLanguages() {
		return languages;
	}

	public static BaiDuLanguage parseByCode(String code) {
		return (BaiDuLanguage) EnumUtil.parseByCode(BaiDuLanguage.values(),code);
	}


}
