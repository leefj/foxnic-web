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


import org.github.foxnic.web.proxy.job.JobServiceProxy;
import org.github.foxnic.web.domain.job.meta.JobVOMeta;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobVO;
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
import org.github.foxnic.web.domain.job.meta.JobMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.job.service.IJobService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 定时任务配置表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-31 11:54:54
*/

@Api(tags = "定时任务配置")
@ApiSort(0)
@RestController("SysJobController")
public class JobController extends SuperController {

	@Autowired
	private IJobService jobService;


	/**
	 * 添加定时任务配置
	*/
	@ApiOperation(value = "添加定时任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.NAME , value = "任务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.GROUP_TAG , value = "组别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CLASS_NAME , value = "执行类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CRON_EXPR , value = "cron表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.ERROR_POLICY , value = "计划执行错误策略" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.PARAMETER , value = "执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CONCURRENT , value = "是否并发执行（0允许" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.ERRORS , value = "执行错误次数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = JobServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobServiceProxy.INSERT)
	public Result insert(JobVO jobVO) {
		Result result=jobService.insert(jobVO,false);
		return result;
	}



	/**
	 * 删除定时任务配置
	*/
	@ApiOperation(value = "删除定时任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = JobVOMeta.ID)
	@SentinelResource(value = JobServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=jobService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除定时任务配置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除定时任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = JobVOMeta.IDS)
	@SentinelResource(value = JobServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=jobService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新定时任务配置
	*/
	@ApiOperation(value = "更新定时任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.NAME , value = "任务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.GROUP_TAG , value = "组别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CLASS_NAME , value = "执行类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CRON_EXPR , value = "cron表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.ERROR_POLICY , value = "计划执行错误策略" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.PARAMETER , value = "执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CONCURRENT , value = "是否并发执行（0允许" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.ERRORS , value = "执行错误次数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { JobVOMeta.PAGE_INDEX , JobVOMeta.PAGE_SIZE , JobVOMeta.SEARCH_FIELD , JobVOMeta.FUZZY_FIELD , JobVOMeta.SEARCH_VALUE , JobVOMeta.DIRTY_FIELDS , JobVOMeta.SORT_FIELD , JobVOMeta.SORT_TYPE , JobVOMeta.IDS } )
	@NotNull(name = JobVOMeta.ID)
	@SentinelResource(value = JobServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobServiceProxy.UPDATE)
	public Result update(JobVO jobVO) {
		Result result=jobService.update(jobVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存定时任务配置
	*/
	@ApiOperation(value = "保存定时任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.NAME , value = "任务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.GROUP_TAG , value = "组别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CLASS_NAME , value = "执行类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CRON_EXPR , value = "cron表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.ERROR_POLICY , value = "计划执行错误策略" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.PARAMETER , value = "执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CONCURRENT , value = "是否并发执行（0允许" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.ERRORS , value = "执行错误次数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { JobVOMeta.PAGE_INDEX , JobVOMeta.PAGE_SIZE , JobVOMeta.SEARCH_FIELD , JobVOMeta.FUZZY_FIELD , JobVOMeta.SEARCH_VALUE , JobVOMeta.DIRTY_FIELDS , JobVOMeta.SORT_FIELD , JobVOMeta.SORT_TYPE , JobVOMeta.IDS } )
	@NotNull(name = JobVOMeta.ID)
	@SentinelResource(value = JobServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobServiceProxy.SAVE)
	public Result save(JobVO jobVO) {
		Result result=jobService.save(jobVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取定时任务配置
	*/
	@ApiOperation(value = "获取定时任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = JobVOMeta.ID)
	@SentinelResource(value = JobServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobServiceProxy.GET_BY_ID)
	public Result<Job> getById(String id) {
		Result<Job> result=new Result<>();
		Job job=jobService.getById(id);
		result.success(true).data(job);
		return result;
	}


	/**
	 * 批量获取定时任务配置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取定时任务配置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = JobVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = JobVOMeta.IDS)
		@SentinelResource(value = JobServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobServiceProxy.GET_BY_IDS)
	public Result<List<Job>> getByIds(List<String> ids) {
		Result<List<Job>> result=new Result<>();
		List<Job> list=jobService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询定时任务配置
	*/
	@ApiOperation(value = "查询定时任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.NAME , value = "任务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.GROUP_TAG , value = "组别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CLASS_NAME , value = "执行类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CRON_EXPR , value = "cron表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.ERROR_POLICY , value = "计划执行错误策略" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.PARAMETER , value = "执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CONCURRENT , value = "是否并发执行（0允许" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.ERRORS , value = "执行错误次数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { JobVOMeta.PAGE_INDEX , JobVOMeta.PAGE_SIZE } )
	@SentinelResource(value = JobServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobServiceProxy.QUERY_LIST)
	public Result<List<Job>> queryList(JobVO sample) {
		Result<List<Job>> result=new Result<>();
		List<Job> list=jobService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询定时任务配置
	*/
	@ApiOperation(value = "分页查询定时任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.NAME , value = "任务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.GROUP_TAG , value = "组别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CLASS_NAME , value = "执行类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CRON_EXPR , value = "cron表达式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.ERROR_POLICY , value = "计划执行错误策略" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.PARAMETER , value = "执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.CONCURRENT , value = "是否并发执行（0允许" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobVOMeta.ERRORS , value = "执行错误次数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = JobServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Job>> queryPagedList(JobVO sample) {
		Result<PagedList<Job>> result=new Result<>();
		PagedList<Job> list=jobService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = JobServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(JobServiceProxy.EXPORT_EXCEL)
	public void exportExcel(JobVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=jobService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = JobServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(JobServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=jobService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = JobServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(JobServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=jobService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}