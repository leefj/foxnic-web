package org.github.foxnic.web.job.worker;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.springframework.stereotype.Component;

@Component
public class DemoWorker2 implements JobExecutor {

    @Override
    public String getName() {
        return "示例-2";
    }

    @Override
    public Result execute(Object context, Job job, JSONObject methodParams) {
        Logger.info("demo worker do the job @"+ DateUtil.getFormattedTime(false));
        return ErrorDesc.success();
    }
}
