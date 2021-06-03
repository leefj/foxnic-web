package org.github.foxnic.web.oauth.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SESSION_ONLINE;
import org.github.foxnic.web.oauth.config.security.SecurityProperties;
import org.github.foxnic.web.oauth.config.security.SecurityProperties.SecurityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.dao.spec.DAO;
 
@Component
@EnableConfigurationProperties(SecurityProperties.class)
public class RequestListener  implements ServletRequestListener {
 
	private static ThreadLocal<String> sessionOnlineId=new ThreadLocal<String>();

	private SimpleTaskManager taskMngr=null;
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Autowired
	private DAO dao;
	
	private static class Interact {
		Date date;
		String url;
	}
	
	
	private Map<String,Interact> interacts = new ConcurrentHashMap<String, Interact>();
	
	@PostConstruct
	private void start() {
		if(securityProperties.getSecurityMode()==SecurityMode.SESSION) {
			
			//因为停机而下线的检查
			dao.execute("update sys_session_online set online=0,logout_time=now() where online=1 and time_to_sec(timediff(now(), interact_time))>session_time");
			
			taskMngr=new SimpleTaskManager(2);
			taskMngr.doIntervalTask(new Runnable() {
				@Override
				public void run() {
					saveInteracts();
				}
			},3000);
		}
	}
	
	
	private void putInteract(String url) {
		String sid=sessionOnlineId.get();
		if(sid==null) return;
		Interact it=new Interact();
		it.date=new Date();
		it.url=url;
		interacts.put(sid, it);
	}
	
	
	protected void saveInteracts() {
		//保存交互时间
		dao.setPrintThreadSQL(false);
		if(!interacts.isEmpty())  {
			Map<String,Interact> map =interacts;
			interacts = new ConcurrentHashMap<String, Interact>();
			List<Object[]> plist=new ArrayList<>();
			for (Entry<String, Interact> e : map.entrySet()) {
				plist.add(new Object[] {e.getValue().date,e.getValue().url,e.getKey()});
			}
			dao.batchExecute("update "+SYS_SESSION_ONLINE.$NAME+" set "+SYS_SESSION_ONLINE.INTERACT_TIME+" = ?,interact_url=? where id=?", plist);
		}
		
	}
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent e) {
		HttpServletRequest request=(HttpServletRequest)e.getServletRequest();
		if(securityProperties.getSecurityMode()==SecurityMode.SESSION) {
			try {
				this.putInteract(request.getRequestURI());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void requestInitialized(ServletRequestEvent e) {
		HttpServletRequest request=(HttpServletRequest)e.getServletRequest();
		HttpSession session=request.getSession();
		if(session==null) {
			session=request.getSession(true);
		}
		String initId=(String)session.getAttribute(SessionUser.SESSION_ONLINE_ID_KEY);
		request.setAttribute(SessionUser.SESSION_ONLINE_ID_KEY, initId);
		sessionOnlineId.set(initId);
	}

}
 