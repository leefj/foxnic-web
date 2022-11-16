package org.github.foxnic.web.job.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.job.JobLog;
import org.github.foxnic.web.domain.job.JobLogVO;
import org.github.foxnic.web.domain.job.meta.JobLogVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.job.service.IJobLogService;
import org.github.foxnic.web.proxy.job.JobLogServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 定时任务执行日志表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-15 11:39:11
 */
@InDoc
@Api(tags = "定时任务/执行日志")
@RestController("SysJobLogController")
public class JobLogController extends SuperController {

    @Autowired
    private IJobLogService jobLogService;

    /**
     * 添加定时任务执行日志
     */
    @ApiOperation(value = "添加定时任务执行日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "620728304072130561"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID, value = "组别", required = false, dataTypeClass = String.class, example = "532217276871475200"),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE, value = "日志分类", required = false, dataTypeClass = String.class, example = "cron"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME, value = "任务名称", required = false, dataTypeClass = String.class, example = "EAM_用户新建后处理"),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME, value = "本次执行类", required = false, dataTypeClass = String.class, example = "com.dt.platform.job.eam.EamAccountCreateActionExecutor"),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR, value = "本次执行cron表达式", required = false, dataTypeClass = String.class, example = "0/5 * * * * ?"),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER, value = "本次执行参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS, value = "是否成功执行", required = false, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT, value = "执行结果", required = false, dataTypeClass = String.class, example = "{\"code\":\"00\",\"extra\":{\"messageLevel\":\"notify\"},\"message\":\"操作成功\",\"success\":true}"),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME, value = "开始执行的时间", required = false, dataTypeClass = Timestamp.class, example = "2022-09-09 21:12:40.265"),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME, value = "结束执行的时间", required = false, dataTypeClass = Timestamp.class, example = "2022-09-09 21:12:40.393"),
		@ApiImplicitParam(name = JobLogVOMeta.COST, value = "执行耗时", required = false, dataTypeClass = Long.class, example = "128"),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION, value = "异常信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT, value = "日志信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID, value = "账户ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL, value = "是否是手动执行", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE, value = "是否为丢失补充执行", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.CONCURRENT, value = "是否并发执行（0允许", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.MISFIRE_POLICY, value = "遗漏执行的策略", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.TID, value = "日志跟踪ID", required = false, dataTypeClass = String.class, example = "620728304072130560"),
		@ApiImplicitParam(name = JobLogVOMeta.NODE_ID, value = "节点ID", required = false, dataTypeClass = String.class, example = "c4-8793b018a5-8fc4")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = JobLogServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobLogServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(JobLogVO jobLogVO) {
        Result result = jobLogService.insert(jobLogVO, false);
        return result;
    }

    /**
     * 删除定时任务执行日志
     */
    @ApiOperation(value = "删除定时任务执行日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "620728304072130561")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = JobLogServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobLogServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  jobLogService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录:"+cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = jobLogService.deleteByIdPhysical(id);
        return result;
    }

    /**
     * 批量删除定时任务执行日志 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除定时任务执行日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = JobLogServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobLogServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap =  jobLogService.hasRefers(ids);
        // 收集可以删除的ID值
        List<String> canDeleteIds = new ArrayList<>();
        for (Map.Entry<String, ReferCause> e : causeMap.entrySet()) {
            if (!e.getValue().hasRefer()) {
                canDeleteIds.add(e.getKey());
            }
        }
        // 执行删除
        if (canDeleteIds.isEmpty()) {
            // 如果没有一行可以被删除
            return ErrorDesc.failure().message("无法删除您选中的数据行");
        } else if (canDeleteIds.size() == ids.size()) {
            // 如果全部可以删除
            Result result = jobLogService.deleteByIdsPhysical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = jobLogService.deleteByIdsPhysical(canDeleteIds);
            if (result.failure()) {
                return result;
            } else {
                return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").messageLevel4Confirm();
            }
        } else {
            // 理论上，这个分支不存在
            return ErrorDesc.success().message("数据删除未处理");
        }
    }

    /**
     * 更新定时任务执行日志
     */
    @ApiOperation(value = "更新定时任务执行日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "620728304072130561"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID, value = "组别", required = false, dataTypeClass = String.class, example = "532217276871475200"),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE, value = "日志分类", required = false, dataTypeClass = String.class, example = "cron"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME, value = "任务名称", required = false, dataTypeClass = String.class, example = "EAM_用户新建后处理"),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME, value = "本次执行类", required = false, dataTypeClass = String.class, example = "com.dt.platform.job.eam.EamAccountCreateActionExecutor"),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR, value = "本次执行cron表达式", required = false, dataTypeClass = String.class, example = "0/5 * * * * ?"),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER, value = "本次执行参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS, value = "是否成功执行", required = false, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT, value = "执行结果", required = false, dataTypeClass = String.class, example = "{\"code\":\"00\",\"extra\":{\"messageLevel\":\"notify\"},\"message\":\"操作成功\",\"success\":true}"),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME, value = "开始执行的时间", required = false, dataTypeClass = Timestamp.class, example = "2022-09-09 21:12:40.265"),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME, value = "结束执行的时间", required = false, dataTypeClass = Timestamp.class, example = "2022-09-09 21:12:40.393"),
		@ApiImplicitParam(name = JobLogVOMeta.COST, value = "执行耗时", required = false, dataTypeClass = Long.class, example = "128"),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION, value = "异常信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT, value = "日志信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID, value = "账户ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL, value = "是否是手动执行", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE, value = "是否为丢失补充执行", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.CONCURRENT, value = "是否并发执行（0允许", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.MISFIRE_POLICY, value = "遗漏执行的策略", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.TID, value = "日志跟踪ID", required = false, dataTypeClass = String.class, example = "620728304072130560"),
		@ApiImplicitParam(name = JobLogVOMeta.NODE_ID, value = "节点ID", required = false, dataTypeClass = String.class, example = "c4-8793b018a5-8fc4")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { JobLogVOMeta.PAGE_INDEX, JobLogVOMeta.PAGE_SIZE, JobLogVOMeta.SEARCH_FIELD, JobLogVOMeta.FUZZY_FIELD, JobLogVOMeta.SEARCH_VALUE, JobLogVOMeta.DIRTY_FIELDS, JobLogVOMeta.SORT_FIELD, JobLogVOMeta.SORT_TYPE, JobLogVOMeta.IDS })
    @SentinelResource(value = JobLogServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobLogServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(JobLogVO jobLogVO) {
        Result result = jobLogService.update(jobLogVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存定时任务执行日志
     */
    @ApiOperation(value = "保存定时任务执行日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "620728304072130561"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID, value = "组别", required = false, dataTypeClass = String.class, example = "532217276871475200"),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE, value = "日志分类", required = false, dataTypeClass = String.class, example = "cron"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME, value = "任务名称", required = false, dataTypeClass = String.class, example = "EAM_用户新建后处理"),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME, value = "本次执行类", required = false, dataTypeClass = String.class, example = "com.dt.platform.job.eam.EamAccountCreateActionExecutor"),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR, value = "本次执行cron表达式", required = false, dataTypeClass = String.class, example = "0/5 * * * * ?"),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER, value = "本次执行参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS, value = "是否成功执行", required = false, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT, value = "执行结果", required = false, dataTypeClass = String.class, example = "{\"code\":\"00\",\"extra\":{\"messageLevel\":\"notify\"},\"message\":\"操作成功\",\"success\":true}"),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME, value = "开始执行的时间", required = false, dataTypeClass = Timestamp.class, example = "2022-09-09 21:12:40.265"),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME, value = "结束执行的时间", required = false, dataTypeClass = Timestamp.class, example = "2022-09-09 21:12:40.393"),
		@ApiImplicitParam(name = JobLogVOMeta.COST, value = "执行耗时", required = false, dataTypeClass = Long.class, example = "128"),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION, value = "异常信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT, value = "日志信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID, value = "账户ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL, value = "是否是手动执行", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE, value = "是否为丢失补充执行", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.CONCURRENT, value = "是否并发执行（0允许", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.MISFIRE_POLICY, value = "遗漏执行的策略", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.TID, value = "日志跟踪ID", required = false, dataTypeClass = String.class, example = "620728304072130560"),
		@ApiImplicitParam(name = JobLogVOMeta.NODE_ID, value = "节点ID", required = false, dataTypeClass = String.class, example = "c4-8793b018a5-8fc4")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { JobLogVOMeta.PAGE_INDEX, JobLogVOMeta.PAGE_SIZE, JobLogVOMeta.SEARCH_FIELD, JobLogVOMeta.FUZZY_FIELD, JobLogVOMeta.SEARCH_VALUE, JobLogVOMeta.DIRTY_FIELDS, JobLogVOMeta.SORT_FIELD, JobLogVOMeta.SORT_TYPE, JobLogVOMeta.IDS })
    @SentinelResource(value = JobLogServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobLogServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(JobLogVO jobLogVO) {
        Result result = jobLogService.save(jobLogVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取定时任务执行日志
     */
    @ApiOperation(value = "获取定时任务执行日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = JobLogServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobLogServiceProxy.GET_BY_ID)
    public Result<JobLog> getById(String id) {
        Result<JobLog> result = new Result<>();
        JobLog jobLog = jobLogService.getById(id);
        result.success(true).data(jobLog);
        return result;
    }

    /**
     * 批量获取定时任务执行日志 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取定时任务执行日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = JobLogServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobLogServiceProxy.GET_BY_IDS)
    public Result<List<JobLog>> getByIds(List<String> ids) {
        Result<List<JobLog>> result = new Result<>();
        List<JobLog> list = jobLogService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询定时任务执行日志
     */
    @ApiOperation(value = "查询定时任务执行日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "620728304072130561"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID, value = "组别", required = false, dataTypeClass = String.class, example = "532217276871475200"),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE, value = "日志分类", required = false, dataTypeClass = String.class, example = "cron"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME, value = "任务名称", required = false, dataTypeClass = String.class, example = "EAM_用户新建后处理"),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME, value = "本次执行类", required = false, dataTypeClass = String.class, example = "com.dt.platform.job.eam.EamAccountCreateActionExecutor"),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR, value = "本次执行cron表达式", required = false, dataTypeClass = String.class, example = "0/5 * * * * ?"),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER, value = "本次执行参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS, value = "是否成功执行", required = false, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT, value = "执行结果", required = false, dataTypeClass = String.class, example = "{\"code\":\"00\",\"extra\":{\"messageLevel\":\"notify\"},\"message\":\"操作成功\",\"success\":true}"),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME, value = "开始执行的时间", required = false, dataTypeClass = Timestamp.class, example = "2022-09-09 21:12:40.265"),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME, value = "结束执行的时间", required = false, dataTypeClass = Timestamp.class, example = "2022-09-09 21:12:40.393"),
		@ApiImplicitParam(name = JobLogVOMeta.COST, value = "执行耗时", required = false, dataTypeClass = Long.class, example = "128"),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION, value = "异常信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT, value = "日志信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID, value = "账户ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL, value = "是否是手动执行", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE, value = "是否为丢失补充执行", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.CONCURRENT, value = "是否并发执行（0允许", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.MISFIRE_POLICY, value = "遗漏执行的策略", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.TID, value = "日志跟踪ID", required = false, dataTypeClass = String.class, example = "620728304072130560"),
		@ApiImplicitParam(name = JobLogVOMeta.NODE_ID, value = "节点ID", required = false, dataTypeClass = String.class, example = "c4-8793b018a5-8fc4")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { JobLogVOMeta.PAGE_INDEX, JobLogVOMeta.PAGE_SIZE })
    @SentinelResource(value = JobLogServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobLogServiceProxy.QUERY_LIST)
    public Result<List<JobLog>> queryList(JobLogVO sample) {
        Result<List<JobLog>> result = new Result<>();
        List<JobLog> list = jobLogService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询定时任务执行日志
     */
    @ApiOperation(value = "分页查询定时任务执行日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "620728304072130561"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID, value = "组别", required = false, dataTypeClass = String.class, example = "532217276871475200"),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE, value = "日志分类", required = false, dataTypeClass = String.class, example = "cron"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME, value = "任务名称", required = false, dataTypeClass = String.class, example = "EAM_用户新建后处理"),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME, value = "本次执行类", required = false, dataTypeClass = String.class, example = "com.dt.platform.job.eam.EamAccountCreateActionExecutor"),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR, value = "本次执行cron表达式", required = false, dataTypeClass = String.class, example = "0/5 * * * * ?"),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER, value = "本次执行参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS, value = "是否成功执行", required = false, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT, value = "执行结果", required = false, dataTypeClass = String.class, example = "{\"code\":\"00\",\"extra\":{\"messageLevel\":\"notify\"},\"message\":\"操作成功\",\"success\":true}"),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME, value = "开始执行的时间", required = false, dataTypeClass = Timestamp.class, example = "2022-09-09 21:12:40.265"),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME, value = "结束执行的时间", required = false, dataTypeClass = Timestamp.class, example = "2022-09-09 21:12:40.393"),
		@ApiImplicitParam(name = JobLogVOMeta.COST, value = "执行耗时", required = false, dataTypeClass = Long.class, example = "128"),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION, value = "异常信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT, value = "日志信息", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID, value = "账户ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL, value = "是否是手动执行", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE, value = "是否为丢失补充执行", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.CONCURRENT, value = "是否并发执行（0允许", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.MISFIRE_POLICY, value = "遗漏执行的策略", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = JobLogVOMeta.TID, value = "日志跟踪ID", required = false, dataTypeClass = String.class, example = "620728304072130560"),
		@ApiImplicitParam(name = JobLogVOMeta.NODE_ID, value = "节点ID", required = false, dataTypeClass = String.class, example = "c4-8793b018a5-8fc4")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = JobLogServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobLogServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<JobLog>> queryPagedList(JobLogVO sample) {
        Result<PagedList<JobLog>> result = new Result<>();
        PagedList<JobLog> list = jobLogService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
