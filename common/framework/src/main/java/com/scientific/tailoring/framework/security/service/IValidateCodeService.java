package com.scientific.tailoring.framework.security.service;

public interface IValidateCodeService {
	
	void saveValidateCode(String deviceId, String imageCode);
	
	String getValidateCode(String deviceId);
	
}
