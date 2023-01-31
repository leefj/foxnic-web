package org.github.foxnic.web.oauth.jwt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.json.JSONUtil;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.domain.oauth.Token;
import org.github.foxnic.web.domain.oauth.TokenVO;
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
				tokeService.dao().pausePrintThreadSQL();
				List<Token> tokens=tokeService.queryValidTokens();
				tokeService.dao().resumePrintThreadSQL();
				for (Token token : tokens) {
					JwtTokenPair jwtTokenPair=new JwtTokenPair(token.getJti());
					JSONObject json= JSONUtil.toJSONObject(token);
					jwtTokenPair.setSessionId(token.getSessionId());
					//
					JwtToken accessToken=new JwtToken(json);
					accessToken.token(token.getAccessToken());
					accessToken.type(TokenType.access);
					accessToken.uid(token.getUserId());
					accessToken.exp(token.getAccessTokenExpireTime());
					jwtTokenPair.setAccessToken(accessToken);
					//
					JwtToken refreshToken=new JwtToken(json);
					refreshToken.token(token.getRefreshToken());
					refreshToken.type(TokenType.refresh);
					refreshToken.uid(token.getUserId());
					refreshToken.exp(token.getRefreshTokenExpireTime());
					jwtTokenPair.setRefreshToken(refreshToken);

					JwtTokenCacheStorage.this.cache.put(jwtTokenPair.getJti(), jwtTokenPair);
				}

			}
		});

	}

	@Override
	public JwtTokenPair put(JwtTokenPair jwtTokenPair) {

		cache.put(jwtTokenPair.getJti(), jwtTokenPair);

		Token token = new Token();
		token.setJti(jwtTokenPair.getJti());
		token = tokeService.queryEntity(token);
		boolean update=true;
		if(token==null) {
			token=new Token();
			update=false;
		}
		//
		token.setAccessToken(jwtTokenPair.getAccessToken().token());
		token.setAccessTokenExpireTime( DateUtil.toDate(jwtTokenPair.getAccessToken().exp()));
		token.setAccessTokenExpired(0);
		//
		token.setRefreshToken(jwtTokenPair.getRefreshToken().token());
		token.setRefreshTokenExpireTime( DateUtil.toDate(jwtTokenPair.getRefreshToken().exp()));
		token.setRefreshTokenExpired(0);
		//
		token.setUserId(jwtTokenPair.getAccessToken().uid());
		token.setSessionId(RequestParameter.getSession(true).getId());
		token.setJti(jwtTokenPair.getJti());

		if(update) {
			tokeService.update(token, SaveMode.DIRTY_FIELDS);
		} else {
			tokeService.insert(token);
		}

		return jwtTokenPair;
	}

	@Override
	public JwtTokenPair get(String jti) {
		return cache.get(jti);
	}
}
