package org.github.foxnic.web.oauth.jwt.reader;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.language.Language;
import org.github.foxnic.web.language.LanguageService;
import org.github.foxnic.web.oauth.jwt.JwtToken;
import org.github.foxnic.web.oauth.jwt.JwtTokenGenerator;
import org.github.foxnic.web.oauth.jwt.JwtTokenPair;
import org.github.foxnic.web.oauth.jwt.JwtTokenStorage;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
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
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(StringUtil.isBlank(header)) {
            Cookie[] cookies = request.getCookies();
            if(cookies!=null) {
                for (Cookie cookie : cookies) {
                    if(cookie.getName().equals("accessToken")) {
                        header=AUTHENTICATION_PREFIX+cookie.getValue();
                        break;
                    }
                }
            }
        }

        if(StringUtil.isBlank(header)) return null;
        if(!header.startsWith(AUTHENTICATION_PREFIX)) return null;

        String jwtToken = header.replace(AUTHENTICATION_PREFIX, "");
        if (StringUtil.isBlank(jwtToken)) {
            //带安全头 没有带 token
            throw new AuthenticationCredentialsNotFoundException("token is not found");
        }


        // 根据我的实现 有效 token 才会被解析出来
        JSONObject jsonObject = jwtTokenGenerator.decodeAndVerify(jwtToken);
        if(jsonObject==null || jsonObject.isEmpty()) {
            throw new BadCredentialsException("token error");
        }

        String userId = jsonObject.getString("uid");
        String jti = jsonObject.getString("jti");

        // 从缓存获取 token
        JwtTokenPair jwtTokenPair = jwtTokenStorage.get(jti);
        if (Objects.isNull(jwtTokenPair)) {
            //缓存中不存，失败了
            throw new CredentialsExpiredException("token is not in cache");
        }
        JwtToken accessToken = jwtTokenPair.getAccessToken();
        //比对 Token
        if (jwtToken.equals(accessToken.token())) {
            return userId;
        } else {
            throw new BadCredentialsException("token is not matched");
        }
    }

    @Override
    public Language readLanguage(HttpServletRequest request) {
        return languageService.getAutoLanguage();
    }
}
