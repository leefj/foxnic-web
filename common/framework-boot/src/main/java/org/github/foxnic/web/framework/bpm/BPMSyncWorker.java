package org.github.foxnic.web.framework.bpm;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.github.foxnic.web.proxy.bpm.ProcessErrorServiceProxy;
import org.github.foxnic.web.proxy.bpm.ProcessInstanceServiceProxy;
import org.github.foxnic.web.proxy.bpm.TaskServiceProxy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 流程数据同步任务
 * */
@Component
public class BPMSyncWorker implements JobExecutor {

    @Override
    public String getName() {
        return "BPMTaskWorker";
    }

    @Override
    public Result execute(Object context, Job job, JSONObject methodParams) {
        return doSync(new ArrayList<>(),0);
    }

    public Result doSync(String... processInstanceId) {
        return doSync(Arrays.asList(processInstanceId),0);
    }

    public Result doSync(List<String> processInstanceIds,Integer delayMs) {

        // 同步任务
        SimpleTaskManager.doParallelTask(new Runnable() {
            @Override
            public void run() {
                TaskServiceProxy.api().syncCamundaTasks(null);
            }
        },delayMs);

        // 同步流程实例
        SimpleTaskManager.doParallelTask(new Runnable() {
            @Override
            public void run() {
                ProcessInstanceServiceProxy.api().syncCamundaProcessInstances(null);
            }
        },delayMs);

        // 同步流程实例
        SimpleTaskManager.doParallelTask(new Runnable() {
            @Override
            public void run() {
                ProcessErrorServiceProxy.api().syncCamundaErrors(null);
            }
        },delayMs);

        return ErrorDesc.success();
    }

}
