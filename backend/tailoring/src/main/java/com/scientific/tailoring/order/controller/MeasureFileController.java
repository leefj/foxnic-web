package com.scientific.tailoring.order.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.mvc.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.scientific.tailoring.domain.order.MeasureFile;
import com.scientific.tailoring.domain.order.MeasureFileVO;
import com.scientific.tailoring.domain.order.meta.MeasureFileVOMeta;
import com.scientific.tailoring.domain.order.meta.MeasureFilesVOMeta;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.order.service.IMeasureFileService;
import com.scientific.tailoring.proxy.order.MeasureFileServiceProxy;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @author 李方捷
 * @since 2021-03-25 08:57:39
*/

@Api(tags = "测量文件采集")
@ApiSort(1154)
@RestController("OdrMeasureFileController")
public class MeasureFileController extends SuperController {

	@Autowired
	private IMeasureFileService measureFileService;

	
	/**
	 * 添加测量文件采集
	*/
	@RequiresPermissions("OdrMeasureFile:insert")
	@ApiOperation(value = "添加测量文件采集")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureFileVOMeta.MEASURE_ID , value = "订单测量ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.FILE_ID , value = "文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.TYPE , value = "测量类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.PROCESSED , value = "数据是否已经处理" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.PROCESS_TIME , value = "处理时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(ignoreParameters = {MeasureFileVOMeta.PAGE_INDEX , MeasureFileVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = MeasureFileServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureFileServiceProxy.INSERT)
	public  Result<MeasureFile> insert(MeasureFileVO measureFileVO) {
		Result<MeasureFile> result=new Result<>();
		boolean suc=measureFileService.insert(measureFileVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除测量文件采集
	*/
	@RequiresPermissions("OdrMeasureFile:deleteById")
	@ApiOperation(value = "按主键删除测量文件采集")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureFileVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
	})
	@NotNull(name = MeasureFileVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = MeasureFileServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureFileServiceProxy.DELETE)
	public  Result deleteById(Integer id) {
		Result result=new Result();
		boolean suc=measureFileService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新测量文件采集
	*/
	@RequiresPermissions("OdrMeasureFile:update")
	@ApiOperation(value = "更新测量文件采集")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureFileVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.MEASURE_ID , value = "订单测量ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.FILE_ID , value = "文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.TYPE , value = "测量类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.PROCESSED , value = "数据是否已经处理" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.PROCESS_TIME , value = "处理时间" , required = false , dataTypeClass=Date.class),
	})
	@NotNull(name = MeasureFileVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {MeasureFileVOMeta.PAGE_INDEX , MeasureFileVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = MeasureFileServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureFileServiceProxy.UPDATE)
	public  Result<MeasureFile> update(MeasureFileVO measureFileVO) {
		Result<MeasureFile> result=new Result<>();
		boolean suc=measureFileService.update(measureFileVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取测量文件采集
	*/
	@RequiresPermissions("OdrMeasureFile:getById")
	@ApiOperation(value = "按主键获取测量文件采集")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureFileVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
	})
	@NotNull(name = MeasureFileVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = MeasureFileServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureFileServiceProxy.GET_BY_ID)
	public  Result<MeasureFile> getById(Integer id) {
		Result<MeasureFile> result=new Result<>();
		MeasureFile measureFile=measureFileService.getById(id);
		result.success(true).data(measureFile);
		return result;
	}

	
	/**
	 * 查询全部符合条件的测量文件采集
	*/
	@RequiresPermissions("OdrMeasureFile:queryList")
	@ApiOperation(value = "查询全部符合条件的测量文件采集")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureFileVOMeta.ID , value = "id" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.MEASURE_ID , value = "订单测量ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.FILE_ID , value = "文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.TYPE , value = "测量类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.PROCESSED , value = "数据是否已经处理" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.PROCESS_TIME , value = "处理时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(ignoreParameters = {MeasureFileVOMeta.PAGE_INDEX , MeasureFileVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = MeasureFileServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureFileServiceProxy.QUERY_LIST)
	public  Result<List<MeasureFile>> queryList(MeasureFileVO sample) {
		Result<List<MeasureFile>> result=new Result<>();
		List<MeasureFile> list=measureFileService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的测量文件采集
	*/
	@RequiresPermissions("OdrMeasureFile:queryPagedList")
	@ApiOperation(value = "分页查询符合条件的测量文件采集")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureFileVOMeta.ID , value = "id" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.MEASURE_ID , value = "订单测量ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.FILE_ID , value = "文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.TYPE , value = "测量类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.PROCESSED , value = "数据是否已经处理" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.PROCESS_TIME , value = "处理时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeasureFileVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = MeasureFileServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureFileServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<MeasureFile>> queryPagedList(MeasureFileVO sample) {
		Result<PagedList<MeasureFile>> result=new Result<>();
		PagedList<MeasureFile> list=measureFileService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


	/**
	 * 添加测量文件采集
	 */
	@RequiresPermissions("OdrMeasureFile:updateMeasureFiles")
	@ApiOperation(value = "添加测量文件采集")
	@ApiImplicitParams({
			@ApiImplicitParam(name = MeasureFilesVOMeta.MEASURE_ID , value = "订单测量ID" , required = true , dataTypeClass=String.class),
			@ApiImplicitParam(name = MeasureFilesVOMeta.MEASURE_FILES , value = "文件清单" , required = true , dataTypeClass=List.class),
	})
	@ApiOperationSupport(ignoreParameters = {},order=1)
	@SentinelResource(value = MeasureFileServiceProxy.INSERT_FILES, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureFileServiceProxy.INSERT_FILES)

	public  Result<MeasureFile> updateMeasureFiles(MeasureFileVO measureFileVO, List<MeasureFile> measureFiles) {
		Result<MeasureFile> result=new Result<>();
		boolean suc=measureFileService.insertFiles(measureFileVO.getBodyId(),(List)measureFileVO.getMeasureFiles());
		result.success(suc);
		return result;
	}


}