package org.github.foxnic.web.oauth.jwt;

import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.domain.oauth.Token;
import org.github.foxnic.web.oauth.config.security.SecurityProperties;
import org.github.foxnic.web.oauth.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

/**
 * The type Jwt token cache storage.
 *
 * @author 李方捷
 * @since  2021-06-02
 */
@EnableConfigurationProperties(SecurityProperties.class)
public class JwtTokenCacheStorage implements JwtTokenStorage {

	@Autowired
	private SecurityProperties props;
	

	private ITokenService tokeService;

	private LocalCache<String, JwtTokenPair> cache = null;

	public JwtTokenCacheStorage() {
		cache = new LocalCache<String, JwtTokenPair>();
		//从磁盘恢复有效的 Token
		SimpleTaskManager.doParallelTask(new Runnable() {
			@Override
			public void run() {
				 
				tokeService=SpringUtil.getBean(ITokenService.class);
				tokeService.dao().setPrintThreadSQL(false);
				List<Token> tokens=tokeService.queryValidTokens();
				tokeService.dao().setPrintThreadSQL(true);
				for (Token token : tokens) {
					JwtTokenPair jwtTokenPair=new JwtTokenPair(token.getJti());
					//
					JwtToken accessToken=new JwtToken();
					accessToken.token(token.getAccessToken());
					jwtTokenPair.setAccessToken(accessToken);
					//
					JwtToken refreshToken=new JwtToken();
					refreshToken.token(token.getRefreshToken());
					jwtTokenPair.setAccessToken(refreshToken);
					
					JwtTokenCacheStorage.this.cache.put(jwtTokenPair.getJti(), jwtTokenPair);
				}
				
			}
		});
		
	}

	@Override
	public JwtTokenPair put(JwtTokenPair jwtTokenPair) {
		cache.put(jwtTokenPair.getJti(), jwtTokenPair);
		
		Token token=new Token();
		
		token.setAccessToken(jwtTokenPair.getAccessToken().token());
		token.setAccessTokenExpireTime( DateUtil.toDate(jwtTokenPair.getAccessToken().exp()));
		token.setAccessTokenExpired(0);
		
		token.setRefreshToken(jwtTokenPair.getRefreshToken().token());
		token.setRefreshTokenExpireTime( DateUtil.toDate(jwtTokenPair.getRefreshToken().exp()));
		token.setRefreshTokenExpired(0);
		
		token.setUserId(jwtTokenPair.getAccessToken().uid());

		token.setJti(jwtTokenPair.getJti());
		tokeService.insert(token);
 
		return jwtTokenPair;
	}

//	@Override
//	public void expire(String userId) {
//		cache.remove(userId);
//	}
//
	@Override
	public JwtTokenPair get(String userId) {
		return cache.get(userId);
	}
}
