package org.github.foxnic.web.job.utils;


import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.constants.enums.job.MisfirePolicy;
import org.github.foxnic.web.constants.enums.job.Status;
import org.github.foxnic.web.job.config.ScheduleConstants;
import org.github.foxnic.web.job.exception.TaskException;
import org.quartz.*;


/**
 * 定时任务工具类
 */
public class ScheduleUtils {

    public static Scheduler getScheduler() {
        return SpringUtil.getBean(Scheduler.class);
    }

    /**
     * 得到quartz任务类
     *
     * @param job 执行计划
     * @return 具体执行任务类
     */
    private static Class<? extends Job> getQuartzJobClass(org.github.foxnic.web.domain.job.Job job) {
        return job.getConcurrent() == 0 ? QuartzDisallowConcurrentExecution.class : QuartzJobExecution.class;
    }

    /**
     * 获取触发器key
     */
    public static TriggerKey getTriggerKey(String jobId) {
        return TriggerKey.triggerKey(ScheduleConstants.TASK_CLASS_NAME + "_" + jobId);
    }

    /**
     * 获取jobKey
     */
    public static JobKey getJobKey(String jobId) {
        return JobKey.jobKey(ScheduleConstants.TASK_CLASS_NAME + "_" + jobId);
    }

    /**
     * 获取表达式触发器
     */
    public static CronTrigger getCronTrigger(String jobId) {
        Scheduler scheduler = getScheduler();
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(jobId));
        } catch (SchedulerException e) {
            Logger.error("getCronTrigger 异常：", e);
        }
        return null;
    }

    /**
     * 创建定时任务
     */
    public static void createScheduleJob(org.github.foxnic.web.domain.job.Job job) throws SchedulerException, TaskException {
        Scheduler scheduler = getScheduler();

        Class<? extends Job> jobClass = getQuartzJobClass(job);
        // 构建job信息
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(getJobKey(job.getId())).build();

        // 表达式调度构建器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpr());
        cronScheduleBuilder = handleCronScheduleMisfirePolicy(job, cronScheduleBuilder);


        // 按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(job.getId()))
                .withSchedule(cronScheduleBuilder).build();

        // 放入参数，运行时的方法可以获取
        jobDetail.getJobDataMap().put(ScheduleConstants.TASK_PROPERTIES, job);
        scheduler.scheduleJob(jobDetail, trigger);

        // 暂停任务
        if (job.getStatusEnum() == Status.PAUSED) {
            pauseJob(job.getId());
        }
    }

    /**
     * 更新定时任务
     */
    public static void updateScheduleJob(org.github.foxnic.web.domain.job.Job job) throws SchedulerException, TaskException {
        Scheduler scheduler = getScheduler();
        JobKey jobKey = getJobKey(job.getId());

        // 判断是否存在
        if (scheduler.checkExists(jobKey)) {
            // 先移除，然后做更新操作
            scheduler.deleteJob(jobKey);
        }
        createScheduleJob(job);
        // 暂停任务
        if (job.getStatusEnum() == Status.PAUSED) {
            pauseJob(job.getId());
        }
    }

    /**
     * 立即执行任务
     */
    public static void run(Scheduler scheduler, org.github.foxnic.web.domain.job.Job job, boolean isManual) throws SchedulerException {
        // 参数
        JobDataMap dataMap = new JobDataMap();
        dataMap.put(ScheduleConstants.TASK_PROPERTIES, job);
        dataMap.put(ScheduleConstants.IS_MANUAL, isManual);

        scheduler.triggerJob(getJobKey(job.getId()), dataMap);
    }

    /**
     * 暂停任务
     */
    public static void pauseJob(String jobId) throws SchedulerException {
        Scheduler scheduler = getScheduler();
        scheduler.pauseJob(getJobKey(jobId));
    }

    /**
     * 恢复任务
     */
    public static void resumeJob(String jobId) throws SchedulerException {
        Scheduler scheduler = getScheduler();
        scheduler.resumeJob(getJobKey(jobId));
    }

    /**
     * 删除定时任务
     */
    public static void deleteScheduleJob(String jobId) throws SchedulerException {
        Scheduler scheduler = getScheduler();
        scheduler.deleteJob(getJobKey(jobId));
    }

    public static CronScheduleBuilder handleCronScheduleMisfirePolicy(org.github.foxnic.web.domain.job.Job job, CronScheduleBuilder cb)
            throws TaskException {

        if (job.getMisfirePolicyEnum() == MisfirePolicy.ONCE_NOW) {
            return cb.withMisfireHandlingInstructionFireAndProceed();
        } else if (job.getMisfirePolicyEnum() == MisfirePolicy.IGNORE_MISFIRES) {
            return cb.withMisfireHandlingInstructionIgnoreMisfires();
        } else if (job.getMisfirePolicyEnum() == MisfirePolicy.DO_NOTHING) {
            return cb.withMisfireHandlingInstructionDoNothing();
        } else {
            return cb;
        }

    }
}
