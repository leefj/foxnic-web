package org.github.foxnic.web.oauth.config.web;

import javax.servlet.http.HttpServletRequest;

import org.github.foxnic.web.framework.security.controller.ValidateCodeController;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.foxnic.commons.lang.ArrayUtil;
import com.github.foxnic.springboot.web.WebContext;

@Component
public class SecurityConfigs {
	
	public static enum SessionCacheType {
		local,remote,both;
	}
	
	public static final String VCODE_URI_PATTERN=ValidateCodeController.VCODE_URI+"/**";

	@Value("${server.session.timeout:1200}")
	private Integer sessionTime = 1200;
	
	@Value("${security.loginPage}")
	private String loginPage;
	
	@Value("${security.ignored}")
	private String ignoredstr;
	
	@Value("${security.sessionCacheType}")
	private String sessionCacheTypeStr;
	
	private SessionCacheType sessionCacheType=null;
	
	
	private String[] ignored;

	public String getLoginPage() {
		return loginPage;
	}

	public String[] getIgnored() {
		if(ignored==null && ignoredstr!=null) {
			ignored=ignoredstr.split(",");
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
    	for (String pattern : this.getIgnored()) {
    		ignored = WebContext.isMatchPattern(pattern,uri);
    		if(ignored) {
    			break;
    		}
		}
    	return ignored;
    }

	public Integer getSessionTime() {
		return sessionTime;
	}
	
	public SessionCacheType getSessionCacheType() {
		if(sessionCacheType==null) sessionCacheType=SessionCacheType.valueOf(sessionCacheTypeStr);
		return sessionCacheType;
	}
	
}
