package org.github.foxnic.web.language;

public interface LanguageService {

	public static final String USER_LANGUAGE = "USER_LANGUAGE";

	/**
	 * 指定语言进行转换
	 * */
	String translate(Language language, String defaults, String key);

	/**
	 *使用默认语言进行转换
	 * */
	String translate(String defaults,String key);

	/**
	 *使用默认语言进行转换
	 * */
	String translate(String defaults);

	Language getUserLanguage();

	Language getAutoLanguage();

}
