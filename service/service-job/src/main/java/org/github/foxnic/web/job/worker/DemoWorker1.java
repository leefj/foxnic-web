package org.github.foxnic.web.job.worker;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecuter;
import org.springframework.stereotype.Component;

@Component
public class DemoWorker1 implements JobExecuter {

    @Override
    public String getName() {
        return "示例-1";
    }

    @Override
    public Result execute(Object context, Job job, JSONObject methodParams) {
        Logger.info("demo worker do the job @"+ DateUtil.getFormattedTime(false));
        return ErrorDesc.success();
    }
}
