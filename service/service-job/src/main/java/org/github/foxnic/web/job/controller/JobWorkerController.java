package org.github.foxnic.web.job.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.proxy.job.JobWorkerServiceProxy;
import org.github.foxnic.web.domain.job.meta.JobWorkerVOMeta;
import org.github.foxnic.web.domain.job.JobWorker;
import org.github.foxnic.web.domain.job.JobWorkerVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import org.github.foxnic.web.domain.job.meta.JobWorkerMeta;
import org.github.foxnic.web.domain.job.JobExecutor;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.job.service.IJobWorkerService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 任务执行器 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-07 12:00:15
 */
@Api(tags = "任务执行器")
@ApiSort(0)
@RestController("SysJobWorkerController")
public class JobWorkerController extends SuperController {

    @Autowired
    private IJobWorkerService jobWorkerService;

    /**
     * 添加任务执行器
     */
    @ApiOperation(value = "添加任务执行器")
    @ApiImplicitParams({ @ApiImplicitParam(name = JobWorkerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "530777750395420672"), @ApiImplicitParam(name = JobWorkerVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "示例-1"), @ApiImplicitParam(name = JobWorkerVOMeta.CLASS_NAME, value = "类名", required = false, dataTypeClass = String.class, example = "org.github.foxnic.web.job.worker.DemoWorker1"), @ApiImplicitParam(name = JobWorkerVOMeta.VALID, value = "有效", required = false, dataTypeClass = Integer.class, example = "1") })
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = JobWorkerServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobWorkerServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(JobWorkerVO jobWorkerVO) {
        Result result = jobWorkerService.insert(jobWorkerVO, false);
        return result;
    }

    /**
     * 删除任务执行器
     */
    @ApiOperation(value = "删除任务执行器")
    @ApiImplicitParams({ @ApiImplicitParam(name = JobWorkerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "530777750395420672") })
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = JobWorkerServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobWorkerServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = jobWorkerService.deleteByIdPhysical(id);
        return result;
    }

    /**
     * 批量删除任务执行器 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除任务执行器")
    @ApiImplicitParams({ @ApiImplicitParam(name = JobWorkerVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]") })
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = JobWorkerServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobWorkerServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = jobWorkerService.deleteByIdsPhysical(ids);
        return result;
    }

    /**
     * 更新任务执行器
     */
    @ApiOperation(value = "更新任务执行器")
    @ApiImplicitParams({ @ApiImplicitParam(name = JobWorkerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "530777750395420672"), @ApiImplicitParam(name = JobWorkerVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "示例-1"), @ApiImplicitParam(name = JobWorkerVOMeta.CLASS_NAME, value = "类名", required = false, dataTypeClass = String.class, example = "org.github.foxnic.web.job.worker.DemoWorker1"), @ApiImplicitParam(name = JobWorkerVOMeta.VALID, value = "有效", required = false, dataTypeClass = Integer.class, example = "1") })
    @ApiOperationSupport(order = 4, ignoreParameters = { JobWorkerVOMeta.PAGE_INDEX, JobWorkerVOMeta.PAGE_SIZE, JobWorkerVOMeta.SEARCH_FIELD, JobWorkerVOMeta.FUZZY_FIELD, JobWorkerVOMeta.SEARCH_VALUE, JobWorkerVOMeta.DIRTY_FIELDS, JobWorkerVOMeta.SORT_FIELD, JobWorkerVOMeta.SORT_TYPE, JobWorkerVOMeta.IDS })
    @SentinelResource(value = JobWorkerServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobWorkerServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(JobWorkerVO jobWorkerVO) {
        Result result = jobWorkerService.update(jobWorkerVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存任务执行器
     */
    @ApiOperation(value = "保存任务执行器")
    @ApiImplicitParams({ @ApiImplicitParam(name = JobWorkerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "530777750395420672"), @ApiImplicitParam(name = JobWorkerVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "示例-1"), @ApiImplicitParam(name = JobWorkerVOMeta.CLASS_NAME, value = "类名", required = false, dataTypeClass = String.class, example = "org.github.foxnic.web.job.worker.DemoWorker1"), @ApiImplicitParam(name = JobWorkerVOMeta.VALID, value = "有效", required = false, dataTypeClass = Integer.class, example = "1") })
    @ApiOperationSupport(order = 5, ignoreParameters = { JobWorkerVOMeta.PAGE_INDEX, JobWorkerVOMeta.PAGE_SIZE, JobWorkerVOMeta.SEARCH_FIELD, JobWorkerVOMeta.FUZZY_FIELD, JobWorkerVOMeta.SEARCH_VALUE, JobWorkerVOMeta.DIRTY_FIELDS, JobWorkerVOMeta.SORT_FIELD, JobWorkerVOMeta.SORT_TYPE, JobWorkerVOMeta.IDS })
    @SentinelResource(value = JobWorkerServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobWorkerServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(JobWorkerVO jobWorkerVO) {
        Result result = jobWorkerService.save(jobWorkerVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取任务执行器
     */
    @ApiOperation(value = "获取任务执行器")
    @ApiImplicitParams({ @ApiImplicitParam(name = JobWorkerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1") })
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = JobWorkerServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobWorkerServiceProxy.GET_BY_ID)
    public Result<JobWorker> getById(String id) {
        Result<JobWorker> result = new Result<>();
        JobWorker jobWorker = jobWorkerService.getById(id);
        result.success(true).data(jobWorker);
        return result;
    }

    /**
     * 批量获取任务执行器 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取任务执行器")
    @ApiImplicitParams({ @ApiImplicitParam(name = JobWorkerVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]") })
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = JobWorkerServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobWorkerServiceProxy.GET_BY_IDS)
    public Result<List<JobWorker>> getByIds(List<String> ids) {
        Result<List<JobWorker>> result = new Result<>();
        List<JobWorker> list = jobWorkerService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询任务执行器
     */
    @ApiOperation(value = "查询任务执行器")
    @ApiImplicitParams({ @ApiImplicitParam(name = JobWorkerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "530777750395420672"), @ApiImplicitParam(name = JobWorkerVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "示例-1"), @ApiImplicitParam(name = JobWorkerVOMeta.CLASS_NAME, value = "类名", required = false, dataTypeClass = String.class, example = "org.github.foxnic.web.job.worker.DemoWorker1"), @ApiImplicitParam(name = JobWorkerVOMeta.VALID, value = "有效", required = false, dataTypeClass = Integer.class, example = "1") })
    @ApiOperationSupport(order = 5, ignoreParameters = { JobWorkerVOMeta.PAGE_INDEX, JobWorkerVOMeta.PAGE_SIZE })
    @SentinelResource(value = JobWorkerServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobWorkerServiceProxy.QUERY_LIST)
    public Result<List<JobWorker>> queryList(JobWorkerVO sample) {
        Result<List<JobWorker>> result = new Result<>();
        List<JobWorker> list = jobWorkerService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询任务执行器
     */
    @ApiOperation(value = "分页查询任务执行器")
    @ApiImplicitParams({ @ApiImplicitParam(name = JobWorkerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "530777750395420672"), @ApiImplicitParam(name = JobWorkerVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "示例-1"), @ApiImplicitParam(name = JobWorkerVOMeta.CLASS_NAME, value = "类名", required = false, dataTypeClass = String.class, example = "org.github.foxnic.web.job.worker.DemoWorker1"), @ApiImplicitParam(name = JobWorkerVOMeta.VALID, value = "有效", required = false, dataTypeClass = Integer.class, example = "1") })
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = JobWorkerServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(JobWorkerServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<JobWorker>> queryPagedList(JobWorkerVO sample) {
        Result<PagedList<JobWorker>> result = new Result<>();
        PagedList<JobWorker> list = jobWorkerService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = JobWorkerServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(JobWorkerServiceProxy.EXPORT_EXCEL)
    public void exportExcel(JobWorkerVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = jobWorkerService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = JobWorkerServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(JobWorkerServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = jobWorkerService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = JobWorkerServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(JobWorkerServiceProxy.IMPORT_EXCEL)
    public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获得上传的文件
        Map<String, MultipartFile> map = request.getFileMap();
        InputStream input = null;
        for (MultipartFile mf : map.values()) {
            input = StreamUtil.bytes2input(mf.getBytes());
            break;
        }
        if (input == null) {
            return ErrorDesc.failure().message("缺少上传的文件");
        }
        List<ValidateResult> errors = jobWorkerService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
