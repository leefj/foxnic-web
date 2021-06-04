package org.github.foxnic.web.oauth.service.impl;

import org.github.foxnic.web.oauth.service.ICaptchaService;
import org.springframework.stereotype.Service;

import com.github.foxnic.commons.cache.LocalCache;


@Service
public class CaptchaServiceImpl implements ICaptchaService {

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
