package com.scientific.tailoring.framework.security.service.impl;

import org.springframework.stereotype.Service;

import com.github.foxnic.commons.cache.LocalCache;
import com.scientific.tailoring.framework.security.service.IValidateCodeService;


@Service
public class ValidateCodeServiceImpl implements IValidateCodeService {

	private LocalCache<String, String> CODE_CACHE=new LocalCache<>(1000*60*15);
	
	@Override
	public void saveValidateCode(String deviceId, String imageCode) {
		CODE_CACHE.put(deviceId,imageCode);
	}

	@Override
	public String getValidateCode(String deviceId) {
		return CODE_CACHE.get(deviceId);
	}

}
