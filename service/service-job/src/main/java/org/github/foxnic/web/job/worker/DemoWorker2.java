package org.github.foxnic.web.job.worker;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecuter;
import org.springframework.stereotype.Component;

@Component
public class DemoWorker2 implements JobExecuter {

    @Override
    public String getName() {
        return "示例-2";
    }

    @Override
    public Result execute(Job job) {
        Logger.info("demo worker do the job @"+ DateUtil.getFormattedTime(false));
        return ErrorDesc.success();
    }
}
