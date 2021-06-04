package org.github.foxnic.web.oauth.service.impl;

import org.github.foxnic.web.oauth.service.ICaptchaService;
import org.springframework.stereotype.Service;

import com.github.foxnic.commons.cache.LocalCache;


@Service
public class CaptchaServiceImpl implements ICaptchaService {

	private LocalCache<String, String> CODE_CACHE=new LocalCache<>(1000*60*2);
	
	@Override
	public void saveImageCaptcha(String browserId, String imageCode) {
		CODE_CACHE.put(browserId,imageCode);
	}

	@Override
	public String getImageCaptcha(String browserId) {
		return CODE_CACHE.get(browserId);
	}

}
