package org.github.foxnic.web.language;

import com.github.foxnic.api.language.SuperLanguageService;

public interface LanguageService extends SuperLanguageService {

	public static final String USER_LANGUAGE = "USER_LANGUAGE";



	/**
	 * 指定语言进行转换
	 * */
	String translate(Language language, String defaults, String code,String context);

	/**
	 *使用默认语言进行转换
	 * */
	String translate(String defaults, String code, String context);

	/**
	 *使用默认语言进行转换
	 * */
	String translate(String defaults);

	Language getUserLanguage();

	Language getAutoLanguage();

}
