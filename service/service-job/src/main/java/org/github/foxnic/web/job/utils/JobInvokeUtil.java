package org.github.foxnic.web.job.utils;


import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecuter;
import org.quartz.JobExecutionContext;
import org.slf4j.MDC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 任务执行工具
 *

 */
public class JobInvokeUtil
{

	private final static String TID = "tid";
	private final static String JOB = "job_name";
	private final static String METHOD = "job_method";
    /**
     * 执行方法
     *
     * @param sysJob 系统任务
     */
    public static void invokeMethod(JobExecutionContext context,Job sysJob) throws Exception
    {
         Class<? extends JobExecuter> type= ReflectUtil.forName(sysJob.getWorker().getClassName());
        JobExecuter executor = SpringUtil.getBean(type);
        JSONObject methodParams = null;
        if(StringUtil.hasContent(sysJob.getParameter())) {
            try {
                methodParams=JSONObject.parseObject(sysJob.getParameter());
            } catch (Exception e) {
                Logger.exception("job "+sysJob.getName()+" 参数转换错误",e);
            }
        }

        MDC.put(TID, IDGenerator.getSnowflakeIdString());
        MDC.put(JOB, sysJob.getName());
        executor.execute(context,sysJob,methodParams);
        MDC.remove(TID);
        MDC.remove(JOB);
    }

    /**
     * 调用任务方法
     *
     * @param bean 目标对象
     * @param methodName 方法名称
     * @param methodParams 方法参数
     */
    private static void invokeSpringBean(Object bean, String methodName, String methodParams)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException
    {
        if (StringUtils.isNotEmpty(methodParams))
        {
            Method method = bean.getClass().getDeclaredMethod(methodName, String.class);
            method.invoke(bean, methodParams);
        }
        else
        {
            Method method = bean.getClass().getDeclaredMethod(methodName);
            method.invoke(bean);
        }
    }
}
