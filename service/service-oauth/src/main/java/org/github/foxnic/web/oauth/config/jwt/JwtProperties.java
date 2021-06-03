package org.github.foxnic.web.oauth.config.jwt;

 
import org.springframework.boot.context.properties.ConfigurationProperties;

 

/**
 * Jwt 在 springboot application.yml 中的配置文件
 *
 * @author 李方捷
 * @since  2021-06-02
 */
@ConfigurationProperties(prefix="security.jwt")
public class JwtProperties {
   
    /**
     * jks 路径
     */
    private String keyLocation;
    /**
     * key alias
     */
    private String keyAlias;
    /**
     * key store pass
     */
    private String keyPass;
    /**
     * jwt签发者
     **/
    private String iss;
    /**
     * jwt所面向的用户
     **/
    private String sub;
    /**
     * access jwt token 有效天数
     */
    private int accessExpireSeconds;
    /**
     * refresh jwt token 有效天数
     */
    private int refreshExpireSeconds;
	 
	public String getKeyLocation() {
		return keyLocation;
	}
	public void setKeyLocation(String keyLocation) {
		this.keyLocation = keyLocation;
	}
	public String getKeyAlias() {
		return keyAlias;
	}
	public void setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
	}
	public String getKeyPass() {
		return keyPass;
	}
	public void setKeyPass(String keyPass) {
		this.keyPass = keyPass;
	}
	public String getIss() {
		return iss;
	}
	public void setIss(String iss) {
		this.iss = iss;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public int getAccessExpireSeconds() {
		return accessExpireSeconds;
	}
	public void setAccessExpireSeconds(int accessExpireSeconds) {
		this.accessExpireSeconds = accessExpireSeconds;
	}
	public int getRefreshExpireSeconds() {
		return refreshExpireSeconds;
	}
	public void setRefreshExpireSeconds(int refreshExpireSeconds) {
		this.refreshExpireSeconds = refreshExpireSeconds;
	}
	 
}
