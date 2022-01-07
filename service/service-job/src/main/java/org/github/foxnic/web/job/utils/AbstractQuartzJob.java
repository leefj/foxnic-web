package org.github.foxnic.web.job.utils;


import org.github.foxnic.web.job.config.ScheduleConstants;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;


/**
 * 抽象quartz调用
 */
public abstract class AbstractQuartzJob implements Job {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractQuartzJob.class);

    /**
     * 线程本地变量
     */
    private static ThreadLocal<Timestamp> threadLocal = new ThreadLocal<>();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        Object o = context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES);
        org.github.foxnic.web.domain.job.Job sysJob = org.github.foxnic.web.domain.job.Job.createFrom(o);

        try {
            if (sysJob != null) {
                doExecute(context, sysJob);
            }
        } catch (Exception e) {
            LOG.error("任务执行异常  - ：", e);
        }
    }

    /**
     * 执行方法，由子类重载
     *
     * @param context 工作执行上下文对象
     * @param sysJob  系统计划任务
     * @throws Exception 执行过程中的异常
     */
    protected abstract void doExecute(JobExecutionContext context, org.github.foxnic.web.domain.job.Job sysJob) throws Exception;
}
