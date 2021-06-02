package org.github.foxnic.web.oauth.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SESSION_ONLINE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.dao.spec.DAO;
 
@Component
public class RequestListener  implements ServletRequestListener {

	private SimpleTaskManager taskMngr=new SimpleTaskManager(2);
	
	@Autowired
	private DAO dao;
	
	private static class Interact {
		Date date;
		String url;
	}
	
	
	private Map<String,Interact> interacts = new ConcurrentHashMap<String, Interact>();
	
	@PostConstruct
	private void start() {
		taskMngr.doIntervalTask(new Runnable() {
			@Override
			public void run() {
				saveInteracts();
			}
		},1000);
	}
	
	
	public void putInteract(String sessionId,String url) {
	 
		Interact it=new Interact();
		it.date=new Date();
		it.url=url;
		interacts.put(sessionId, it);
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
			dao.batchExecute("update "+SYS_SESSION_ONLINE.$NAME+" set "+SYS_SESSION_ONLINE.INTERACT_TIME+" = ?,interact_url=? where session_id=?", plist);
		}
		//因为停机而下线的检查
		//dao.execute("update sys_session_online set online=0,logout_time=now() where online=1 and time_to_sec(timediff(now(), interact_time))>?",config.getSessionTime());
	}
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent e) {
		HttpServletRequest request=(HttpServletRequest)e.getServletRequest();
		try {
			this.putInteract(request.getSession().getId(), request.getRequestURL().toString());
		} catch (Exception e1) {}
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
 
	}

}
 