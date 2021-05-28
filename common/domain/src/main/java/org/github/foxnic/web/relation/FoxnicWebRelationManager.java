package org.github.foxnic.web.relation;

import org.github.foxnic.web.relation.modules.OAuthRelationManager;
import org.github.foxnic.web.relation.modules.SystemRelationManager;

import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.relation.RelationManager;
import com.github.foxnic.springboot.spring.SpringUtil;

public class FoxnicWebRelationManager extends RelationManager {

	public FoxnicWebRelationManager() {
		super(
				new OAuthRelationManager(),
				new SystemRelationManager()
		);
		//启动动态刷入
		startMonitor();
	}

	private void startMonitor() {
		if(SpringUtil.isReady()) {
			SimpleTaskManager tm=new SimpleTaskManager();
			tm.doIntervalTask(new Runnable() {
				@Override
				public void run() {
					doReConfigAndValidate();
				}
			}, 3000);
		}
	}

	
	protected void doReConfigAndValidate() {
		FoxnicWebRelationManager.this.reconfig(); 
		FoxnicWebRelationManager.this.validate();
//		Logger.info("FoxnicWebRelationManager Reconfig");
	}

	
	@Override
	protected void config() {}

	 

 
	 

}
