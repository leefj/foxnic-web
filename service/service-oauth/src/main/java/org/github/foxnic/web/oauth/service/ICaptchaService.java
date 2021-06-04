package org.github.foxnic.web.oauth.service;

public interface ICaptchaService {
	
	void saveImageCaptcha(String browserId, String imageCode);
	
	String getImageCaptcha(String browserId);
	
}
