package org.github.foxnic.web.oauth.session;
 

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.github.foxnic.web.oauth.service.ISessionOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 
@Component
public class SessionEventListener implements  HttpSessionListener  {
 
	@Autowired
	private ISessionOnlineService onlineService;
 

	
	
	

	private Map<String,Date> interacts = new ConcurrentHashMap<String, Date>();
	
	public void putInteract(String token, Date time) {
		System.out.println(time.getTime());
		interacts.put(token, time);
	}
	
	
//	protected void saveInteracts() {
//		//保存交互时间
//		if(!interacts.isEmpty())  {
//			Map<String,Date> map =interacts;
//			interacts = new ConcurrentHashMap<String, Date>();
//			List<Object[]> plist=new ArrayList<>();
//			for (Entry<String, Date> e : map.entrySet()) {
//				plist.add(new Object[] {e.getValue(),e.getKey()});
//			}
//			
//			dao.batchExecute("update "+SYS_SESSION_ONLINE.$NAME+" set "+SYS_SESSION_ONLINE.INTERACT_TIME+" = ? where token=?", plist);
//		}
//		//下线检查
//		dao.execute("update sys_session_online set online=0,logout_time=now() where online=1 and time_to_sec(timediff(now(), interact_time))>?",config.getSessionTime());
//	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSessionListener.super.sessionCreated(se);
	}
	 
	
	public void sessionDestroyed(HttpSessionEvent event) {
		onlineService.offline(event.getSession().getId());
	}
 
	

}