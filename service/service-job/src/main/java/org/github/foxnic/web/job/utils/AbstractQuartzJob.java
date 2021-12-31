package org.github.foxnic.web.job.utils;


import org.github.foxnic.web.domain.job.JobLog;
import org.github.foxnic.web.job.config.ScheduleConstants;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;


/**
 * 抽象quartz调用
 *

 */
public abstract class AbstractQuartzJob implements Job
{

	public boolean isJobEnabled()
	{
//		Boolean job=BootArgs.getBooleanNonOptionArg("job");
//		if(job==null) job=true;
//		return job;
        return true;
	}

    private static final Logger LOG = LoggerFactory.getLogger(AbstractQuartzJob.class);

    /**
     * 线程本地变量
     */
    private static ThreadLocal<Timestamp> threadLocal = new ThreadLocal<>();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException
    {


        org.github.foxnic.web.domain.job.Job sysJob = new org.github.foxnic.web.domain.job.Job();
        BeanUtils.copyProperties(sysJob, context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES));
        Boolean isManual=(Boolean)context.getMergedJobDataMap().get(ScheduleConstants.IS_MANUAL);
        //启动参数 job=no 禁用 job
        if(!isJobEnabled() && (isManual==null || isManual==false))  {
        	LOG.info("Job已经禁用，跳过 Job : "+sysJob.getName()+"");
    		return;
    	}

        if(isManual!=null && isManual==true)  {
        	LOG.info("手动执行 Job : "+sysJob.getName()+"");
        }



        try
        {
            before(context, sysJob);
            if (sysJob != null)
            {
                doExecute(context, sysJob);
            }
            after(context, sysJob, null);
        }
        catch (Exception e)
        {
            LOG.error("任务执行异常  - ：", e);
            after(context, sysJob, e);
        }
    }

    /**
     * 执行前
     *
     * @param context 工作执行上下文对象
     * @param sysJob 系统计划任务
     */
    protected void before(JobExecutionContext context, org.github.foxnic.web.domain.job.Job sysJob) {
        threadLocal.set(new Timestamp(System.currentTimeMillis()));
    }

    /**
     * 执行后
     *
     * @param context 工作执行上下文对象
     * @param sysJob 系统计划任务
     */
    protected void after(JobExecutionContext context, org.github.foxnic.web.domain.job.Job sysJob, Exception e)
    {
        Timestamp startTime = threadLocal.get();
        threadLocal.remove();

        final JobLog sysJobLog = new JobLog();
        sysJobLog.setJobName(sysJob.getName());
//        sysJobLog.set  (sysJob.getJobGroup());
//        sysJobLog.setMethodName(sysJob.getMethodName());
//        sysJobLog.setMethodParams(sysJob.getMethodParams());
        sysJobLog.setBeginTime(startTime);
        sysJobLog.setEndTime(new Timestamp(System.currentTimeMillis()));
        long runMs = sysJobLog.getEndTime().getTime() - sysJobLog.getBeginTime().getTime();
//        sysJobLog.setJobMessage(sysJobLog.getJobName() + " 总共耗时：" + runMs + "毫秒");
        if (e != null)
        {
            //sysJobLog.setStatus(Constants.FAIL);
            //String errorMsg = StringUtils.substring(ExceptionUtil.getExceptionMessage(e), 0, 2000);
            //sysJobLog.setExceptionInfo(errorMsg);
        } else {
            //sysJobLog.setStatus(Constants.SUCCESS);
        }

        // 写入数据库当中
        //SpringUtil.getBean(ISysJobLogService.class).addJobLog(sysJobLog);
    }

    /**
     * 执行方法，由子类重载
     *
     * @param context 工作执行上下文对象
     * @param sysJob 系统计划任务
     * @throws Exception 执行过程中的异常
     */
    protected abstract void doExecute(JobExecutionContext context, org.github.foxnic.web.domain.job.Job sysJob) throws Exception;
}
