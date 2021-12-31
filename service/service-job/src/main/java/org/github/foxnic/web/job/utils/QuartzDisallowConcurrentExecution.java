package org.github.foxnic.web.job.utils;

import org.github.foxnic.web.domain.job.Job;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;

/**
 * 定时任务处理（禁止并发执行）
 *
 */
@DisallowConcurrentExecution
public class QuartzDisallowConcurrentExecution extends AbstractQuartzJob
{
    @Override
    protected void doExecute(JobExecutionContext context, Job sysJob) throws Exception
    {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
