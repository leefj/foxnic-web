package org.github.foxnic.web.storage.controller;

import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.domain.storage.FileVO;
import org.github.foxnic.web.domain.storage.meta.FileVOMeta;
import org.github.foxnic.web.proxy.storage.FileServiceProxy;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;
import org.github.foxnic.web.storage.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.mvc.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * <p>
 * 系统配置表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-20 04:34:14
*/

@Api(tags = "附件信息")
@ApiSort(0)
@RestController("FileInfoController")
public class FileInfoController {
	
	@Autowired
	private IFileService fileService;
	/**
	 * 获取系统配置
	*/
	@ApiOperation(value = "获取附件详情")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = FileVOMeta.ID)
	@SentinelResource(value = FileServiceProxy.GET_BY_ID)
	@PostMapping(FileServiceProxy.GET_BY_ID)
	public Result<File> getById(String id) {
		Result<File> result=new Result<>();
		File file=fileService.getById(id);
		result.success(true).data(file);
		return result;
	}
	
	
	
	/**
	 * 分页查询系统配置
	*/
	@ApiOperation(value = "分页查询系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.ID , value = "文件ID" , required = true , dataTypeClass=String.class , example = "2152"),
		@ApiImplicitParam(name = FileVOMeta.FILE_NAME , value = "文件名" , required = false , dataTypeClass=String.class , example = "某某方案"),
		@ApiImplicitParam(name = FileVOMeta.FILE_TYPE , value = "文件类型" , required = false , dataTypeClass=String.class , example = ".jpg"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = FileServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(FileServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<File>> queryPagedList(FileVO sample) {
		Result<PagedList<File>> result=new Result<>();
		PagedList<File> list=fileService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}

}
