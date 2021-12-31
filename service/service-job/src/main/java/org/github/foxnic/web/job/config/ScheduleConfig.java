package org.github.foxnic.web.job.config;

import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.sql.meta.DBType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

/**
 * 定时任务配置
 *
 */
@Configuration
public class ScheduleConfig
{

    @Value("${foxnic.job.dao-bean-name}")
    private String daoBeanName;

    private DAO dao;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean()
    {

        dao= SpringUtil.getBean(daoBeanName,DAO.class);

        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setDataSource(dao.getDataSource());

        // quartz参数
        Properties prop = new Properties();
        prop.put("org.quartz.scheduler.instanceName", "FoxnicWebScheduler");
        prop.put("org.quartz.scheduler.threadName", "FoxnicWebScheduler");
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        prop.put("org.quartz.scheduler.wrapJobExecutionInUserTransaction", "false");
        prop.put("org.quartz.scheduler.idleWaitTime", "5000");

        // 非集群时可不写 默认为false，集群时必须设置为true
        prop.put("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread", "true");
        // 一般不写 默认为true
        prop.put("org.quartz.threadPool.threadsInheritGroupOfInitializingThread", "true");
        // 线程池配置
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "20");
        prop.put("org.quartz.threadPool.threadPriority", "5");
        // JobStore配置
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        // 集群配置
        prop.put("org.quartz.jobStore.isClustered", "true");
        // 调度实例失效的检查时间间隔
        prop.put("org.quartz.jobStore.clusterCheckinInterval", "15000");
        // 调度实例失效的检查时间间隔，影响着核查出失败实例的速度
        prop.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "10");
        // 在“LOCKS”表里选择一行并且锁住这行的SQL语句。缺省的语句能够为大部分数据库工作。“{0}”是在运行时你配置的表前缀。 false
        prop.put("org.quartz.jobStore.txIsolationLevelSerializable", "false");

        // sqlserver 启用
        if (dao.getDBType()== DBType.SQLSVR) {
             prop.put("org.quartz.jobStore.selectWithLockSQL", "SELECT * FROM {0}LOCKS UPDLOCK WHERE LOCK_NAME = ?");
        } else if (dao.getDBType()== DBType.ORACLE) {
            prop.put("org.quartz.jobStore.selectWithLockSQL", "SELECT * FROM {0}LOCKS UPDLOCK WHERE LOCK_NAME = ? FOR UPDATE");
        }

        // 容许的最大作业延长时间
        prop.put("org.quartz.jobStore.misfireThreshold", "12000");
        prop.put("org.quartz.jobStore.tablePrefix", "sys_job_");
        factory.setQuartzProperties(prop);


        factory.setSchedulerName("FoxnicWebJobScheduler");
        // 延时启动 n 秒
        factory.setStartupDelay(5);
        // 用于获取 ApplicationContext
        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
        // 可选，QuartzScheduler
        // 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
        factory.setOverwriteExistingJobs(true);
        // 设置自动启动，默认为true
        factory.setAutoStartup(true);

        //
        factory.setApplicationContext(SpringUtil.getSpringContext());

        statJobs();

        return factory;
    }

    private void statJobs() {

//            if(System.currentTimeMillis()>0) {
//                Logger.info("暂不启动JOB");
//                return;
//            }
//
//            List<SysJob> jobList = jobMapper.selectJobAll();
//            for (SysJob job : jobList)
//            {
//                CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, job.getJobId());
//                // 如果不存在，则创建
//                if (cronTrigger == null)
//                {
//                    ScheduleUtils.createScheduleJob(scheduler, job);
//                }
//                else
//                {
//                    ScheduleUtils.updateScheduleJob(scheduler, job);
//                }
//            }
    }

}
