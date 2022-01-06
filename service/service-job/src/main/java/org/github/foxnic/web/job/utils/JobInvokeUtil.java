package org.github.foxnic.web.job.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.constants.enums.job.LogType;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.github.foxnic.web.domain.job.JobLog;
import org.github.foxnic.web.job.service.IJobLogService;
import org.quartz.JobExecutionContext;
import org.slf4j.MDC;

import java.sql.Timestamp;

/**
 * 任务执行工具
 *

 */
public class JobInvokeUtil
{

	private final static String TID = "tid";
	private final static String JOB = "job_name";
	private final static String METHOD = "job_method";
    private  static IJobLogService logService;
    /**
     * 执行方法
     *
     * @param job 系统任务
     */
    public static void invokeMethod(JobExecutionContext context,Job job) throws Exception
    {
        // 设置 MDC
        String tid= IDGenerator.getSnowflakeIdString();
        MDC.put(TID,tid);
        MDC.put(JOB, job.getName());

        Result result = null;
        if(logService==null) {
            logService=SpringUtil.getBean(IJobLogService.class);
        }
        JobLog log=logService.startLog(job,tid, LogType.CRON);
        // 检查 Worker
        if(job.getWorker()==null) {
            result = ErrorDesc.failure().message("任务未关联执行器");
            log.setSuccess(0).setResult(JSON.toJSONString(result));
            logService.updateLog(log);
            clearMDCVars();
            return;
        }
        // 检查执行的类型
        Class<? extends JobExecutor> type= ReflectUtil.forName(job.getWorker().getClassName());
        if(type==null) {
            result = ErrorDesc.failure().message("任务关联的执行器 "+job.getWorker().getClassName()+" 错误");
            log.setSuccess(0).setResult(JSON.toJSONString(result));
            logService.updateLog(log);
            clearMDCVars();
            return;
        }

        // 获取执行的 Bean
        JobExecutor executor = null;
        try {
            executor = SpringUtil.getBean(type);
        } catch (Exception e) {
            log.setException(StringUtil.toString(e));
        }

        // 检查执行器
        if(executor==null) {
            result = ErrorDesc.failure().message("执行器 "+job.getWorker().getClassName()+" 不是一个 SpringBean 或未实现 JobExecutor 接口");
            log.setSuccess(0).setResult(JSON.toJSONString(result));
            logService.updateLog(log);
            clearMDCVars();
            return;
        }

        // 参数转换并校验
        JSONObject methodParams = null;
        if(StringUtil.hasContent(job.getParameter())) {
            try {
                methodParams=JSONObject.parseObject(job.getParameter());
            } catch (Exception e) {
                log.setException(StringUtil.toString(e));
                Logger.exception("job "+job.getName()+" 参数转换错误",e);
                result = ErrorDesc.failure().message("参数转换错误，要求 JSONObject 格式");
                log.setSuccess(0).setResult(JSON.toJSONString(result));
                logService.updateLog(log);
                clearMDCVars();
                return;
            }
        }


        // 执行具体的任务
        try {
            result = executor.execute(context,job,methodParams);
            log.setSuccess(1).setResult(JSON.toJSONString(result)).setEndTime(new Timestamp(System.currentTimeMillis()));
        } catch (Exception e) {
            log.setException(StringUtil.toString(e));
            Logger.exception("job "+job.getName()+" 执行错误",e);
            result = ErrorDesc.failure().message("执行错误，请查看异常记录");
            log.setSuccess(0).setResult(JSON.toJSONString(result));
        }
        logService.updateLog(log);
        //
        clearMDCVars();
    }

    private static void clearMDCVars() {
        MDC.remove(TID);
        MDC.remove(JOB);
    }


}
