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
    
    private String jti;
    
    public JwtTokenPair(String jti) {
    	this.jti = jti;
    }
 
    private JwtToken accessToken;
    private JwtToken refreshToken;
    
	public JwtToken getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(JwtToken accessToken) {
		this.accessToken = accessToken;
	}
	public JwtToken getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(JwtToken refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getJti() {
		return jti;
	}
}
