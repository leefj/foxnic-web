package org.github.foxnic.web.job.worker;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.meta.DBType;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JobLogCleaner implements JobExecutor {

    @Value("${foxnic.job.log-keep-days}")
    private Integer logKeepDays = 30;

    @Autowired
    private DAO dao;

    @Override
    public String getName() {
        return "Job日志清理";
    }

    @Override
    public Result execute(Object context, Job job, JSONObject ps) {
        // 删除过期的日志
        if(dao.getDBType()== DBType.MYSQL) {
            dao.execute("delete from sys_job_log where date_sub(current_date, interval ? day) > begin_time",logKeepDays);
        }
        return ErrorDesc.success();
    }
}
