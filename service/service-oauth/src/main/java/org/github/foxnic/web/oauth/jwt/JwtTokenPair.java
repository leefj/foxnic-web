package org.github.foxnic.web.oauth.jwt;



import java.io.Serializable;

/**
 * JwtTokenPair
 *
 * @author 李方捷
 * @since  2021-06-02
 **/
public class JwtTokenPair implements Serializable {

    private static final long serialVersionUID = -8518897818107784049L;

    private String jti;

	private String sessionId;

    public JwtTokenPair(String jti) {
    	this.jti = jti;
    }

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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
