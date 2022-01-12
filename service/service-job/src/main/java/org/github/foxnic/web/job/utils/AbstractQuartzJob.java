package org.github.foxnic.web.job.utils;


import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.job.config.ScheduleConstants;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * 抽象quartz调用
 */
public abstract class AbstractQuartzJob implements Job {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractQuartzJob.class);

    private Boolean enable;
    private Set<String> runJobIds;

    private  boolean  willRunJob( org.github.foxnic.web.domain.job.Job job) {
        if(enable==null) enable = SpringUtil.getBooleanEnvProperty("foxnic.job.enable");
        if(runJobIds==null) {
            String ids=SpringUtil.getEnvProperty("foxnic.job.force-run-job-ids");
            if(StringUtil.hasContent(ids)) {
                String[] idArr=ids.split(",");
                runJobIds=new HashSet<>();
                for (String s : idArr) {
                    runJobIds.add(s.trim());
                }
            }
        }

        if(runJobIds!=null) {
            if (runJobIds.contains(job.getId())) {
                return true;
            }
        }

        return enable;



    }

    /**
     * 线程本地变量
     */
    private static ThreadLocal<Timestamp> threadLocal = new ThreadLocal<>();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        Object o = context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES);
        org.github.foxnic.web.domain.job.Job sysJob = org.github.foxnic.web.domain.job.Job.createFrom(o);

        if(!willRunJob(sysJob)) {
            return;
        }


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
