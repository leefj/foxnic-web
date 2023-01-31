package org.github.foxnic.web.oauth.jwt;


import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.sso.TokenReader;
import org.github.foxnic.web.oauth.config.jwt.JwtProperties;
import org.github.foxnic.web.oauth.config.security.SecurityProperties;
import org.github.foxnic.web.oauth.config.security.SecurityProperties.SecurityMode;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.jwt.crypto.sign.SignatureVerifier;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * JwtTokenGenerator
 *
 * @author 李方捷
 * @since  2021-06-02
 */
public class JwtTokenGenerator {

    private JwtProperties jwtProperties;

    private JwtTokenStorage jwtTokenStorage;
    private KeyPair keyPair;

    /**
     * Instantiates a new Jwt token generator.
     *
     * @param jwtTokenStorage the jwt token storage
     * @param jwtProperties   the jwt properties
     */
    public JwtTokenGenerator(JwtTokenStorage jwtTokenStorage, SecurityProperties securityProperties,JwtProperties jwtProperties) {
        this.jwtTokenStorage = jwtTokenStorage;
        this.jwtProperties = jwtProperties;
        if(securityProperties.getSecurityMode()==SecurityMode.JWT  || securityProperties.getSecurityMode()==SecurityMode.BOTH) {
	        KeyPairFactory keyPairFactory = new KeyPairFactory();
	        this.keyPair = keyPairFactory.create(jwtProperties.getKeyLocation(), jwtProperties.getKeyAlias(), jwtProperties.getKeyPass());
        }
    }

    /**
     * Jwt token pair jwt token pair.
     *
     * @param aud        the aud
     * @param uid      the roles
     * @param aud the additional
     * @return the jwt token pair
     */
    public JwtTokenPair jwtTokenPair(String uid,String aud) {

        String jti=TokenReader.getRenewJTI();
        if(StringUtil.isBlank(jti)) {
            jti = IDGenerator.getUUID();
        }

    	JwtToken accessToken = jwtToken(jti,TokenType.access, aud,uid, jwtProperties.getAccessExpireSeconds());
        JSONObject refreshTokenJson=TokenReader.getKeepRefreshToken();
        JwtToken refreshToken = null;
        if(refreshTokenJson!=null) {
            refreshToken = new JwtToken(refreshTokenJson);
        } else {
            refreshToken= jwtToken(jti, TokenType.refresh, aud, uid, jwtProperties.getRefreshExpireSeconds());
        }

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
     * @param type      the roles
     * @param jti the additional
     * @return the string
     */
	private JwtToken jwtToken(String jti,TokenType type,String aud, String uid,int exp) {

		JwtToken builder = new JwtToken(null);

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
     * 解码
     *
     * @param jwtToken the jwt token
     * @return the jwt claims
     */
    public Result<JwtToken> decode(String jwtToken) {
        Result<JwtToken> result = new Result<>();
        if(StringUtil.isBlank(jwtToken)) {
            ErrorDesc.fill(result,CommonError.TOKEN_INVALID);
            return result;
        }
        try {
            RSAPublicKey rsaPublicKey = (RSAPublicKey) this.keyPair.getPublic();
            SignatureVerifier rsaVerifier = new RsaVerifier(rsaPublicKey);
            Jwt jwt = JwtHelper.decodeAndVerify(jwtToken, rsaVerifier);
            String claims = jwt.getClaims();
            JSONObject json = JSONObject.parseObject(claims);
            JwtToken token = new JwtToken(json);
            ErrorDesc.success(result).data(token);
            return result;
        } catch (Exception e) {
            ErrorDesc.fill(result,CommonError.TOKEN_INVALID);
            return result;
        }

    }




}
