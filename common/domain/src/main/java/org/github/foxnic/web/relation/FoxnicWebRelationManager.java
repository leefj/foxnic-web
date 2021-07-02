package org.github.foxnic.web.relation;

import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.relation.modules.OAuthRelationManager;
import org.github.foxnic.web.relation.modules.SystemRelationManager;

import com.github.foxnic.dao.relation.RelationManager;

public class FoxnicWebRelationManager extends RelationManager {

	public FoxnicWebRelationManager() {
		super(
				new OAuthRelationManager(),
				new SystemRelationManager()
		);
	}

	public void startMonitor() {
			SimpleTaskManager tm=new SimpleTaskManager();
			tm.doIntervalTask(new Runnable() {
				@Override
				public void run() {
					doReConfigAndValidate();
				}
			}, 5000);
	}

	
	protected void doReConfigAndValidate() {
		FoxnicWebRelationManager.this.reconfig();
		Logger.info("FoxnicWebRelationManager Reconfig");
	}

	
	@Override
	protected void config() {}

	 

 
	 

}
