package org.github.foxnic.web.framework.bpm;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.github.foxnic.web.proxy.bpm.ProcessErrorServiceProxy;
import org.github.foxnic.web.proxy.bpm.ProcessInstanceServiceProxy;
import org.github.foxnic.web.proxy.bpm.TaskServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 流程数据同步任务
 * */
@Component
public class BPMSyncWorker implements JobExecutor {

    @Autowired
    private  BpmConfigs bpmConfigs;

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

        if(bpmConfigs==null) bpmConfigs= SpringUtil.getBean(BpmConfigs.class);
        if(bpmConfigs==null) return ErrorDesc.failure().message("缺少 BPM 配置");
        if(!bpmConfigs.isEnableBpm()) return ErrorDesc.failure().message("未开启 BPM 功能");

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


    public Result doSync4Retry(List<String> processInstanceIds) {

        if(!bpmConfigs.isEnableBpm()) return ErrorDesc.failure().message("未开启 BPM 功能");

        ProcessInstanceServiceProxy.api().syncCamundaProcessInstances(processInstanceIds);
        ProcessErrorServiceProxy.api().syncCamundaErrors(processInstanceIds);

        // 返回失败，迫使执行
        return ErrorDesc.failure();
    }

}
