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


import org.github.foxnic.web.proxy.job.JobLogServiceProxy;
import org.github.foxnic.web.domain.job.meta.JobLogVOMeta;
import org.github.foxnic.web.domain.job.JobLog;
import org.github.foxnic.web.domain.job.JobLogVO;
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
import org.github.foxnic.web.domain.job.meta.JobLogMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.job.service.IJobLogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 定时任务执行日志表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-05 16:56:11
*/

@Api(tags = "定时任务执行日志")
@ApiSort(0)
@RestController("SysJobLogController")
public class JobLogController extends SuperController {

	@Autowired
	private IJobLogService jobLogService;


	/**
	 * 添加定时任务执行日志
	*/
	@ApiOperation(value = "添加定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID , value = "组别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE , value = "日志分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME , value = "任务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME , value = "本次执行类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR , value = "本次执行cron表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER , value = "本次执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS , value = "是否成功执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT , value = "执行结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME , value = "开始执行的时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME , value = "结束执行的时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT , value = "日志信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL , value = "是否是手动执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE , value = "是否为丢失补充执行" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = JobLogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.INSERT)
	public Result insert(JobLogVO jobLogVO) {
		Result result=jobLogService.insert(jobLogVO,false);
		return result;
	}



	/**
	 * 删除定时任务执行日志
	*/
	@ApiOperation(value = "删除定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = JobLogVOMeta.ID)
	@SentinelResource(value = JobLogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=jobLogService.deleteByIdPhysical(id);
		return result;
	}


	/**
	 * 批量删除定时任务执行日志 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = JobLogVOMeta.IDS)
	@SentinelResource(value = JobLogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=jobLogService.deleteByIdsPhysical(ids);
		return result;
	}

	/**
	 * 更新定时任务执行日志
	*/
	@ApiOperation(value = "更新定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID , value = "组别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE , value = "日志分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME , value = "任务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME , value = "本次执行类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR , value = "本次执行cron表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER , value = "本次执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS , value = "是否成功执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT , value = "执行结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME , value = "开始执行的时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME , value = "结束执行的时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT , value = "日志信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL , value = "是否是手动执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE , value = "是否为丢失补充执行" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { JobLogVOMeta.PAGE_INDEX , JobLogVOMeta.PAGE_SIZE , JobLogVOMeta.SEARCH_FIELD , JobLogVOMeta.FUZZY_FIELD , JobLogVOMeta.SEARCH_VALUE , JobLogVOMeta.DIRTY_FIELDS , JobLogVOMeta.SORT_FIELD , JobLogVOMeta.SORT_TYPE , JobLogVOMeta.IDS } )
	@NotNull(name = JobLogVOMeta.ID)
	@SentinelResource(value = JobLogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.UPDATE)
	public Result update(JobLogVO jobLogVO) {
		Result result=jobLogService.update(jobLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存定时任务执行日志
	*/
	@ApiOperation(value = "保存定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID , value = "组别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE , value = "日志分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME , value = "任务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME , value = "本次执行类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR , value = "本次执行cron表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER , value = "本次执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS , value = "是否成功执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT , value = "执行结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME , value = "开始执行的时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME , value = "结束执行的时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT , value = "日志信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL , value = "是否是手动执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE , value = "是否为丢失补充执行" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { JobLogVOMeta.PAGE_INDEX , JobLogVOMeta.PAGE_SIZE , JobLogVOMeta.SEARCH_FIELD , JobLogVOMeta.FUZZY_FIELD , JobLogVOMeta.SEARCH_VALUE , JobLogVOMeta.DIRTY_FIELDS , JobLogVOMeta.SORT_FIELD , JobLogVOMeta.SORT_TYPE , JobLogVOMeta.IDS } )
	@NotNull(name = JobLogVOMeta.ID)
	@SentinelResource(value = JobLogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.SAVE)
	public Result save(JobLogVO jobLogVO) {
		Result result=jobLogService.save(jobLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取定时任务执行日志
	*/
	@ApiOperation(value = "获取定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = JobLogVOMeta.ID)
	@SentinelResource(value = JobLogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.GET_BY_ID)
	public Result<JobLog> getById(String id) {
		Result<JobLog> result=new Result<>();
		JobLog jobLog=jobLogService.getById(id);
		result.success(true).data(jobLog);
		return result;
	}


	/**
	 * 批量获取定时任务执行日志 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取定时任务执行日志")
		@ApiImplicitParams({
				@ApiImplicitParam(name = JobLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = JobLogVOMeta.IDS)
		@SentinelResource(value = JobLogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.GET_BY_IDS)
	public Result<List<JobLog>> getByIds(List<String> ids) {
		Result<List<JobLog>> result=new Result<>();
		List<JobLog> list=jobLogService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询定时任务执行日志
	*/
	@ApiOperation(value = "查询定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID , value = "组别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE , value = "日志分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME , value = "任务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME , value = "本次执行类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR , value = "本次执行cron表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER , value = "本次执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS , value = "是否成功执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT , value = "执行结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME , value = "开始执行的时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME , value = "结束执行的时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT , value = "日志信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL , value = "是否是手动执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE , value = "是否为丢失补充执行" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { JobLogVOMeta.PAGE_INDEX , JobLogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = JobLogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.QUERY_LIST)
	public Result<List<JobLog>> queryList(JobLogVO sample) {
		Result<List<JobLog>> result=new Result<>();
		List<JobLog> list=jobLogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询定时任务执行日志
	*/
	@ApiOperation(value = "分页查询定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID , value = "组别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE , value = "日志分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME , value = "任务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME , value = "本次执行类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR , value = "本次执行cron表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER , value = "本次执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS , value = "是否成功执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT , value = "执行结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME , value = "开始执行的时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME , value = "结束执行的时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT , value = "日志信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL , value = "是否是手动执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE , value = "是否为丢失补充执行" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = JobLogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<JobLog>> queryPagedList(JobLogVO sample) {
		Result<PagedList<JobLog>> result=new Result<>();
		PagedList<JobLog> list=jobLogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = JobLogServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(JobLogServiceProxy.EXPORT_EXCEL)
	public void exportExcel(JobLogVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=jobLogService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = JobLogServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(JobLogServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=jobLogService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = JobLogServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(JobLogServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

		//获得上传的文件
		Map<String, MultipartFile> map = request.getFileMap();
		InputStream input=null;
		for (MultipartFile mf : map.values()) {
			input=StreamUtil.bytes2input(mf.getBytes());
			break;
		}

		if(input==null) {
			return ErrorDesc.failure().message("缺少上传的文件");
		}

		List<ValidateResult> errors=jobLogService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}