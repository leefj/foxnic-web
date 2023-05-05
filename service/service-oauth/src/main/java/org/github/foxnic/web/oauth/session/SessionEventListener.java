package org.github.foxnic.web.oauth.session;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import org.github.foxnic.web.oauth.config.security.SecurityProperties;
import org.github.foxnic.web.oauth.service.ISessionOnlineService;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@EnableConfigurationProperties(SecurityProperties.class)
public class SessionEventListener implements  HttpSessionListener , HttpSessionIdListener {

	@Autowired
	private ISessionOnlineService onlineService;

	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSessionListener.super.sessionCreated(event);
		HttpSession session=event.getSession();

		SessionContext.put(session);
		SessionContext.setCurrentOnlineSessionId(session,session.getId());
		SimpleTaskManager.doParallelTask(new Runnable() {
			@Override
			public void run() {
				onlineService.onlineAnon(session);
			}
		},100);

	}


	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session=event.getSession();
		onlineService.offline(null,session);
	}

	@Override
	public void sessionIdChanged(HttpSessionEvent httpSessionEvent, String oldSessionId) {
		HttpSession session=httpSessionEvent.getSession();
		onlineService.changeSessionId(oldSessionId,session);
	}



}
