package org.github.foxnic.web.oauth.jwt.reader;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.sso.TokenReader;
import org.github.foxnic.web.language.Language;
import org.github.foxnic.web.language.LanguageService;
import org.github.foxnic.web.oauth.jwt.*;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component
public class JwtTokenTokenReader extends TokenReader {

    private static final String AUTHENTICATION_PREFIX = "Bearer ";

    @Resource
    private JwtTokenGenerator jwtTokenGenerator;

    @Resource
    private JwtTokenStorage jwtTokenStorage;


    @Resource
    private LanguageService languageService;

    @Override
    public String readUserId(HttpServletRequest request) {

        // 获取 header 解析出 jwt 并进行认证，若无 token 则直接进入下一个过滤器。  因为  SecurityContext 的缘故 如果无权限并不会放行
        String accessTokenRaw = request.getHeader(HttpHeaders.AUTHORIZATION);
        String refreshTokenRaw = null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(TokenType.access.keyName())) {
                    if(StringUtil.isBlank(accessTokenRaw)) {
                        accessTokenRaw = AUTHENTICATION_PREFIX + cookie.getValue();
                    }
                }
                if(cookie.getName().equals(TokenType.refresh.keyName())) {
                    refreshTokenRaw = AUTHENTICATION_PREFIX + cookie.getValue();
                }
            }
        }

        if(StringUtil.isBlank(accessTokenRaw) && StringUtil.isBlank(refreshTokenRaw)) return null;

        if(!accessTokenRaw.startsWith(AUTHENTICATION_PREFIX)) return null;

        accessTokenRaw = accessTokenRaw.replace(AUTHENTICATION_PREFIX, "");
        if (StringUtil.isBlank(accessTokenRaw)) {
            throw new AuthenticationCredentialsNotFoundException("access token is not found");
        }

        if(!StringUtil.isBlank(refreshTokenRaw)) {
            refreshTokenRaw = refreshTokenRaw.replace(AUTHENTICATION_PREFIX, "");
            if (StringUtil.isBlank(refreshTokenRaw)) {
                throw new AuthenticationCredentialsNotFoundException("refresh token is not found");
            }
        }

        // token 解析
        Result<JwtToken> accessTokenResult = jwtTokenGenerator.decode(accessTokenRaw);

        JwtToken accessToken=accessTokenResult.data();

        JwtTokenPair jwtTokenPair = null;
        // 如果 accessToken 无效 ，并且有 refreshTokenRaw ， 校验 refreshToken
        if(!StringUtil.isBlank(refreshTokenRaw)  && ( accessTokenResult.failure() || accessToken==null || accessToken.isExpire())) {
            // token 解析
            Result<JwtToken> refreshTokenResult = jwtTokenGenerator.decode(refreshTokenRaw);
            JwtToken refreshToken = refreshTokenResult.data();
            if (refreshTokenResult.failure() || refreshToken == null || refreshToken.isExpire()) {
                throw new IllegalStateException("invalid access token and  refresh token is expired");
            }
            // 从缓存获取 token
            jwtTokenPair = jwtTokenStorage.get(refreshToken.jti());
            if (Objects.isNull(jwtTokenPair)) {
                //缓存中不存在，抛出异常
                throw new CredentialsExpiredException("token is not in cache");
            }

            // 生成新的 accessToken
            this.setRenewJTI(jwtTokenPair.getJti());
            JwtTokenPair newJwtTokenPair = jwtTokenGenerator.jwtTokenPair(refreshToken.uid(),refreshToken.aud());
            accessToken=newJwtTokenPair.getAccessToken();
            jwtTokenPair.setAccessToken(accessToken);
            jwtTokenStorage.put(jwtTokenPair);

        }

        // 从缓存获取 token
        if(jwtTokenPair==null) {
            jwtTokenPair = jwtTokenStorage.get(accessToken.jti());
        }
        if (Objects.isNull(jwtTokenPair)) {
            //缓存中不存在，抛出异常
            throw new CredentialsExpiredException("token is not in cache");
        }
        accessToken = jwtTokenPair.getAccessToken();
        // 使 Token 在同一 JTI 续租
        this.setRenewJTI(jwtTokenPair.getJti());
        // 保持 RefreshToken 不变
        this.setKeepRefreshToken(jwtTokenPair.getRefreshToken().toJSON());
        return accessToken.uid();

    }

    @Override
    public Language readLanguage(HttpServletRequest request) {
        return languageService.getAutoLanguage();
    }
}
