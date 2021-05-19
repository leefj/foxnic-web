package com.scientific.tailoring.framework.language;

public interface LanguageService {
	
	public static enum Language {
		defaults,zh_ch,zh_tw,en_us,en_uk,confuse;
	}
	/**
	 * 指定语言进行转换
	 * */
	public String translate(Language language,String defaults,String key);
	
	/**
	 *使用默认语言进行转换
	 * */
	public String translate(String defaults,String key);
	
	/**
	 *使用默认语言进行转换
	 * */
	public String translate(String defaults);

}
