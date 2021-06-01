package org.github.foxnic.web.oauth.jwt;



import java.io.Serializable;

/**
 * JwtTokenPair
 *
 * @author Felordcn
 * @since 16:09 2019/10/25
 **/
public class JwtTokenPair implements Serializable {
	
    private static final long serialVersionUID = -8518897818107784049L;
    
    private String accessToken;
    private String refreshToken;
    
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}
