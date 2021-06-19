package org.github.foxnic.web.language;

import org.github.foxnic.web.constants.enums.Language;

public interface LanguageService {
	

	/**
	 * 指定语言进行转换
	 * */
	public String translate(Language language, String defaults, String key);
	
	/**
	 *使用默认语言进行转换
	 * */
	public String translate(String defaults,String key);
	
	/**
	 *使用默认语言进行转换
	 * */
	public String translate(String defaults);

}
