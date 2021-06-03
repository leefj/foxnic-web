package org.github.foxnic.web.oauth.session;
 

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.github.foxnic.web.oauth.config.security.SecurityProperties;
import org.github.foxnic.web.oauth.config.security.SecurityProperties.SecurityMode;
import org.github.foxnic.web.oauth.service.ISessionOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

 
@Component
@EnableConfigurationProperties(SecurityProperties.class)
public class SessionEventListener implements  HttpSessionListener  {
 
	@Autowired
	private ISessionOnlineService onlineService;
	
	@Autowired
	private SecurityProperties securityProperties;
 
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSessionListener.super.sessionCreated(event);
		event.getSession().setAttribute(SessionUser.SESSION_ONLINE_ID_KEY, event.getSession().getId()); 
	}
	 
	
	public void sessionDestroyed(HttpSessionEvent event) {
		//下线记录
		if(securityProperties.getSecurityMode()==SecurityMode.SESSION) {
			onlineService.offline(event.getSession().getId());
		}
	}
 
	

}