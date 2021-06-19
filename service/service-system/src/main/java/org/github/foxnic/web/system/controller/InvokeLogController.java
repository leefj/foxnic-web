package org.github.foxnic.web.system.controller;

 
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


import org.github.foxnic.web.proxy.system.InvokeLogServiceProxy;
import org.github.foxnic.web.domain.system.meta.InvokeLogVOMeta;
import org.github.foxnic.web.domain.system.InvokeLog;
import org.github.foxnic.web.domain.system.InvokeLogVO;
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
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.IInvokeLogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 调用统计日志 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-19 08:51:16
*/

@Api(tags = "调用统计日志")
@ApiSort(0)
@RestController("SysInvokeLogController")
public class InvokeLogController extends SuperController {

	@Autowired
	private IInvokeLogService invokeLogService;

	
	/**
	 * 添加调用统计日志
	*/
	@ApiOperation(value = "添加调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.HOST_NAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.URI , value = "请求的URI" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_AGENT , value = "UserAgent" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.CLIENT_IP , value = "客户端IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.TOKEN , value = "token值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_NAME , value = "用户姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.PARAMETER , value = "请求参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.RESPONSE , value = "响应数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InvokeLogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.INSERT)
	public Result<InvokeLog> insert(InvokeLogVO invokeLogVO) {
		Result<InvokeLog> result=new Result<>();
		boolean suc=invokeLogService.insert(invokeLogVO);
		result.success(suc);
		if(!suc) result.message("数据插入失败");
		return result;
	}

	
	/**
	 * 删除调用统计日志
	*/
	@ApiOperation(value = "删除调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InvokeLogVOMeta.ID)
	@SentinelResource(value = InvokeLogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.DELETE)
	public Result<InvokeLog> deleteById(Long id) {
		Result<InvokeLog> result=new Result<>();
		boolean suc=invokeLogService.deleteByIdPhysical(id);
		result.success(suc);
		if(!suc) result.message("数据删除失败");
		return result;
	}
	
	
	/**
	 * 批量删除调用统计日志 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InvokeLogVOMeta.IDS)
	@SentinelResource(value = InvokeLogServiceProxy.BATCH_DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.BATCH_DELETE)
	public Result<InvokeLog> deleteByIds(List<Long> ids) {
		Result<InvokeLog> result=new Result<>();
		boolean suc=invokeLogService.deleteByIdsLogical(ids);
		result.success(suc);
		if(!suc) result.message("数据删除失败");
		return result;
	}
	
	/**
	 * 更新调用统计日志
	*/
	@ApiOperation(value = "更新调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.HOST_NAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.URI , value = "请求的URI" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_AGENT , value = "UserAgent" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.CLIENT_IP , value = "客户端IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.TOKEN , value = "token值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_NAME , value = "用户姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.PARAMETER , value = "请求参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.RESPONSE , value = "响应数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InvokeLogVOMeta.PAGE_INDEX , InvokeLogVOMeta.PAGE_SIZE , InvokeLogVOMeta.SEARCH_FIELD , InvokeLogVOMeta.SEARCH_VALUE , InvokeLogVOMeta.SORT_FIELD , InvokeLogVOMeta.SORT_TYPE , InvokeLogVOMeta.IDS } ) 
	@NotNull(name = InvokeLogVOMeta.ID)
	@SentinelResource(value = InvokeLogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.UPDATE)
	public Result<InvokeLog> update(InvokeLogVO invokeLogVO) {
		Result<InvokeLog> result=new Result<>();
		boolean suc=invokeLogService.update(invokeLogVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		if(!suc) result.message("数据更新失败");
		return result;
	}
	
	
	/**
	 * 保存调用统计日志
	*/
	@ApiOperation(value = "保存调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.HOST_NAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.URI , value = "请求的URI" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_AGENT , value = "UserAgent" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.CLIENT_IP , value = "客户端IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.TOKEN , value = "token值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_NAME , value = "用户姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.PARAMETER , value = "请求参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.RESPONSE , value = "响应数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InvokeLogVOMeta.PAGE_INDEX , InvokeLogVOMeta.PAGE_SIZE , InvokeLogVOMeta.SEARCH_FIELD , InvokeLogVOMeta.SEARCH_VALUE , InvokeLogVOMeta.SORT_FIELD , InvokeLogVOMeta.SORT_TYPE , InvokeLogVOMeta.IDS } )
	@NotNull(name = InvokeLogVOMeta.ID)
	@SentinelResource(value = InvokeLogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.SAVE)
	public Result<InvokeLog> save(InvokeLogVO invokeLogVO) {
		Result<InvokeLog> result=new Result<>();
		boolean suc=invokeLogService.save(invokeLogVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		if(!suc) result.message("数据保存失败");
		return result;
	}

	
	/**
	 * 获取调用统计日志
	*/
	@ApiOperation(value = "获取调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InvokeLogVOMeta.ID)
	@SentinelResource(value = InvokeLogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.GET_BY_ID)
	public Result<InvokeLog> getById(Long id) {
		Result<InvokeLog> result=new Result<>();
		InvokeLog role=invokeLogService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询调用统计日志
	*/
	@ApiOperation(value = "查询调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.HOST_NAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.URI , value = "请求的URI" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_AGENT , value = "UserAgent" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.CLIENT_IP , value = "客户端IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.TOKEN , value = "token值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_NAME , value = "用户姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.PARAMETER , value = "请求参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.RESPONSE , value = "响应数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InvokeLogVOMeta.PAGE_INDEX , InvokeLogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InvokeLogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.QUERY_LIST)
	public Result<List<InvokeLog>> queryList(InvokeLogVO sample) {
		Result<List<InvokeLog>> result=new Result<>();
		List<InvokeLog> list=invokeLogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询调用统计日志
	*/
	@ApiOperation(value = "分页查询调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.HOST_NAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.URI , value = "请求的URI" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_AGENT , value = "UserAgent" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.CLIENT_IP , value = "客户端IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.TOKEN , value = "token值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_NAME , value = "用户姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.PARAMETER , value = "请求参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.RESPONSE , value = "响应数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InvokeLogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InvokeLog>> queryPagedList(InvokeLogVO sample) {
		Result<PagedList<InvokeLog>> result=new Result<>();
		PagedList<InvokeLog> list=invokeLogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InvokeLogServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InvokeLogServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InvokeLogVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=invokeLogService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InvokeLogServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InvokeLogServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=invokeLogService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = InvokeLogServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InvokeLogServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=invokeLogService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}