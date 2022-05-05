package org.github.foxnic.web.framework.bpm;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.github.foxnic.web.proxy.bpm.TaskServiceProxy;
import org.springframework.stereotype.Component;

@Component
public class BPMTaskWorker implements JobExecutor {

    @Override
    public String getName() {
        return "BPMTaskWorker";
    }

    @Override
    public Result execute(Object context, Job job, JSONObject methodParams) {
        TaskServiceProxy.api().syncCamundaTasks(null);
        return ErrorDesc.success();
    }
}
