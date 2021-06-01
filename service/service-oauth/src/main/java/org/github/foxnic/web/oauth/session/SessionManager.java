package org.github.foxnic.web.oauth.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SESSION_ONLINE;
import org.github.foxnic.web.oauth.config.web.SecurityConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.stereotype.Component;

import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.dao.spec.DAO;

 
//@Component
public class SessionManager implements  HttpSessionListener  {
	
	private static SimpleTaskManager taskMngr=new SimpleTaskManager(2);
	
	@Autowired
	private DAO dao;
	
	@Autowired
	private SecurityConfigs config;
	
	@PostConstruct
	private void start() {
//		taskMngr.doIntervalTask(new Runnable() {
//			@Override
//			public void run() {
//				saveInteracts();
//			}
//		},1000);
	}
	
	
	

	private Map<String,Date> interacts = new ConcurrentHashMap<String, Date>();
	
	public void putInteract(String token, Date time) {
		System.out.println(time.getTime());
		interacts.put(token, time);
	}
	
	
	protected void saveInteracts() {
		//保存交互时间
		if(!interacts.isEmpty())  {
			Map<String,Date> map =interacts;
			interacts = new ConcurrentHashMap<String, Date>();
			List<Object[]> plist=new ArrayList<>();
			for (Entry<String, Date> e : map.entrySet()) {
				plist.add(new Object[] {e.getValue(),e.getKey()});
			}
			
			dao.batchExecute("update "+SYS_SESSION_ONLINE.$NAME+" set "+SYS_SESSION_ONLINE.INTERACT_TIME+" = ? where token=?", plist);
		}
		//下线检查
		dao.execute("update sys_session_online set online=0,logout_time=now() where online=1 and time_to_sec(timediff(now(), interact_time))>?",config.getSessionTime());
	}


	 
	
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSessionDestroyedEvent e = new HttpSessionDestroyedEvent(event.getSession());
	 
		System.out.println();
		 
	}
 
	

}
