package org.github.foxnic.web.framework.security.service;

public interface IValidateCodeService {
	
	void saveValidateCode(String deviceId, String imageCode);
	
	String getValidateCode(String deviceId);
	
}
