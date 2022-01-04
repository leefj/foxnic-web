package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.job.meta.JobMeta;

public class JobRelationManager extends RelationManager {

	@Override
	protected void config() {

		// Job - Worker 关系
		this.property(JobMeta.WORKER_PROP)
		.using(FoxnicWeb.SYS_JOB.WORKER_ID).join(FoxnicWeb.SYS_JOB_WORKER.ID);

	}




}
