package org.github.foxnic.web.oauth.config.security;

import javax.servlet.http.HttpServletRequest;

import org.github.foxnic.web.framework.security.controller.ValidateCodeController;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.github.foxnic.commons.lang.ArrayUtil;
import com.github.foxnic.springboot.web.WebContext;

@ConfigurationProperties(prefix="security")
public class SecurityProperties {
	
	public static enum SessionCacheType {
		local,remote,both;
	}
	
	public static final String VCODE_URI_PATTERN=ValidateCodeController.VCODE_URI+"/**";
 
	private String loginPage;
 
	private String ignoredUrls;
	private String[] ignored;
 
	private String sessionCacheType;
	
	private SessionCacheType sessionCacheTypeEnum=null;
	
	
	

	public String getLoginPage() {
		return loginPage;
	}

	public String[] getIgnoredUrls() {
		if(ignored==null && ignoredUrls!=null) {
			ignored=ignoredUrls.split(",");
			for (int i = 0; i < ignored.length; i++) {
				ignored[i]=ignored[i].trim();
			}
			ignored=ArrayUtil.append(ignored,VCODE_URI_PATTERN,this.getLoginPage(),UserServiceProxy.LOGIN_URI,UserServiceProxy.LOGOUT_URI);
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
		if(sessionCacheTypeEnum==null) sessionCacheTypeEnum=SessionCacheType.valueOf(sessionCacheType);
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
	
}
