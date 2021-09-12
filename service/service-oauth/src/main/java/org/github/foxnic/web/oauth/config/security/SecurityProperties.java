package org.github.foxnic.web.oauth.config.security;

import com.github.foxnic.commons.lang.ArrayUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.springboot.web.WebContext;
import org.github.foxnic.web.oauth.controller.CaptchaController;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.servlet.http.HttpServletRequest;

/**
 * 外部配置
 * @author 李方捷
 * @since  2021-06-02
 * */
@ConfigurationProperties(prefix="security")
public class SecurityProperties {
	
	public static enum SecurityMode {
		SESSION,JWT,BOTH;
	}
	
	public static enum SessionCacheType {
		LOCAL,REMOTE,BOTH;
	}
	
	public static final String VCODE_URI_PATTERN=CaptchaController.CAPTCHA_URI+"/**";
 
	private String loginPage;
 
	private String ignoredUrls;
	private String[] ignored;
 
	private String sessionCacheType;
	private SessionCacheType sessionCacheTypeEnum=null;
	
	private String securityMode;
	private SecurityMode securityModeEnum=null;
 

	public String getLoginPage() {
		return loginPage;
	}

	public String[] getIgnoredUrls() {
		if(ignored==null && ignoredUrls!=null) {
			ignored=ignoredUrls.split(",");
			for (int i = 0; i < ignored.length; i++) {
				ignored[i]=ignored[i].trim();
			}
			ignored=ArrayUtil.append(ignored,VCODE_URI_PATTERN);
		}
		return ignored;
	}
 
	 /**
     * 检查是否是忽略的资源
     * */
    public boolean isIgnoredResource(HttpServletRequest request) {
    	String uri=request.getRequestURI();
    	boolean ignored =  false;
    	for (String pattern : this.getIgnoredUrls()) {
    		ignored = WebContext.isMatchPattern(pattern,uri);
    		if(ignored) {
    			break;
    		}
		}
    	return ignored;
    }
 
	public SessionCacheType getSessionCacheType() {
		if(sessionCacheTypeEnum==null) sessionCacheTypeEnum=SessionCacheType.valueOf(sessionCacheType.toUpperCase());
		return sessionCacheTypeEnum;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public void setIgnoredUrls(String ignoredUrls) {
		this.ignoredUrls = ignoredUrls;
	}

	public void setSessionCacheType(String sessionCacheType) {
		this.sessionCacheType = sessionCacheType;
	}

	public SecurityMode getSecurityMode() {
    	if(securityMode==null) {
			securityMode= SpringUtil.getEnvProperty("security.mode");
		}
		if(securityModeEnum==null) securityModeEnum=SecurityMode.valueOf(securityMode.toUpperCase());
		return securityModeEnum;
	}

	public void setMode(String securityMode) {
		this.securityMode = securityMode;
	}
	
}
