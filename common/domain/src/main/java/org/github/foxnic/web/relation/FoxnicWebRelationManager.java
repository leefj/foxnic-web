package org.github.foxnic.web.relation;

import org.github.foxnic.web.relation.modules.SystemRelationManager;

import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.dao.relation.RelationManager;
import com.github.foxnic.springboot.spring.SpringUtil;

public class TailoringRelationManager extends RelationManager {

	public TailoringRelationManager() {
		super(
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
		//TailoringRelationManager.this.reconfig(); 
		//TailoringRelationManager.this.validate();
		//Logger.info("TailoringRelationManager Reconfig");
	}

	
	@Override
	protected void config() {}

	 

 
	 

}
