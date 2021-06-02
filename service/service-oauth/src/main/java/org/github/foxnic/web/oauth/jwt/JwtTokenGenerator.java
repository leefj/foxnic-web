package org.github.foxnic.web.oauth.jwt;

 
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;

import org.github.foxnic.web.oauth.config.jwt.JwtProperties;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.jwt.crypto.sign.SignatureVerifier;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.busi.id.IDGenerator;

/**
 * JwtTokenGenerator
 *
 * @author Felordcn
 * @since 15 :26 2019/10/25
 */
public class JwtTokenGenerator {
    private static final String JWT_EXP_KEY = "exp";
 
    private JwtProperties jwtProperties;

    private JwtTokenStorage jwtTokenStorage;
    private KeyPair keyPair;

    /**
     * Instantiates a new Jwt token generator.
     *
     * @param jwtTokenStorage the jwt token storage
     * @param jwtProperties   the jwt properties
     */
    public JwtTokenGenerator(JwtTokenStorage jwtTokenStorage, JwtProperties jwtProperties) {
        this.jwtTokenStorage = jwtTokenStorage;
        this.jwtProperties = jwtProperties;

        KeyPairFactory keyPairFactory = new KeyPairFactory();
        this.keyPair = keyPairFactory.create(jwtProperties.getKeyLocation(), jwtProperties.getKeyAlias(), jwtProperties.getKeyPass());
    }


    /**
     * Jwt token pair jwt token pair.
     *
     * @param aud        the aud
     * @param roles      the roles
     * @param additional the additional
     * @return the jwt token pair
     */
    public JwtTokenPair jwtTokenPair(String uid,String aud) {
    	
    	String jti=IDGenerator.getUUID();
    	
    	JwtToken accessToken = jwtToken(jti,"access", aud,uid, jwtProperties.getAccessExpireSeconds());
    	JwtToken refreshToken = jwtToken(jti,"refresh",aud,uid, jwtProperties.getRefreshExpireSeconds());

        JwtTokenPair jwtTokenPair = new JwtTokenPair(jti);
        jwtTokenPair.setAccessToken(accessToken);
        jwtTokenPair.setRefreshToken(refreshToken);
        // 存储
        jwtTokenStorage.put(jwtTokenPair);
        return jwtTokenPair;
    }


    /**
     * Jwt token string.
     *
     * @param aud        the aud
     * @param exp        the exp
     * @param roles      the roles
     * @param additional the additional
     * @return the string
     */
	private JwtToken jwtToken(String jti,String type,String aud, String uid,int exp) {
		
		JwtToken builder = new JwtToken();
		
		String payload = builder
				.jti(jti)
				.uid(uid)
                .iss(jwtProperties.getIss())
                .sub(jwtProperties.getSub())
                .aud(aud)
                .type(type)
                .expireSeconds(exp)
                .builder();
		
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		RsaSigner signer = new RsaSigner(privateKey);
		String token=JwtHelper.encode(payload, signer).getEncoded();
		builder.token(token);
        return builder;
    }


    /**
     * 解码 并校验签名 过期不予解析
     *
     * @param jwtToken the jwt token
     * @return the jwt claims
     */
    public JSONObject decodeAndVerify(String jwtToken) {
        Assert.hasText(jwtToken, "jwt token must not be bank");
        RSAPublicKey rsaPublicKey = (RSAPublicKey) this.keyPair.getPublic();
        SignatureVerifier rsaVerifier = new RsaVerifier(rsaPublicKey);
        Jwt jwt = JwtHelper.decodeAndVerify(jwtToken, rsaVerifier);
        String claims = jwt.getClaims();
        JSONObject jsonObject = JSONObject.parseObject(claims);
        String exp = jsonObject.getString(JWT_EXP_KEY);

        if (isExpired(exp)) {
            throw new IllegalStateException("jwt token is expired");
        }
        return jsonObject;
    }

    /**
     * 判断jwt token是否过期.
     *
     * @param exp the jwt token exp
     * @return the boolean
     */
    private boolean isExpired(String exp) {

        return LocalDateTime.now().isAfter(LocalDateTime.parse(exp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
    
  
}
