package org.github.foxnic.web.oauth.service;

public interface ICaptchaService {
	
	void saveValidateCode(String deviceId, String imageCode);
	
	String getValidateCode(String deviceId);
	
}
