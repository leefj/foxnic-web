package com.scientific.tailoring.product.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.product.FabricVO;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.domain.product.meta.FabricVOMeta;
import com.github.foxnic.springboot.mvc.Result;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.scientific.tailoring.domain.product.Fabric;
import com.scientific.tailoring.product.service.IFabricService;
import com.scientific.tailoring.proxy.product.FabricServiceProxy;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-04-08 03:23:07
*/

@Api(tags = "面料")
@ApiSort(1107)
@RestController("PrdFabricController")
public class FabricController extends SuperController {

	@Autowired
	private IFabricService fabricService;

	
	/**
	 * 添加面料
	*/
	@RequiresPermissions("PrdFabric:insert")
	@ApiOperation(value = "添加面料")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FabricVOMeta.CODE , value = "编码" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = FabricVOMeta.FULL_NAME , value = "名称" , required = true , dataTypeClass=String.class , example = "保暖摇粒绒"),
		@ApiImplicitParam(name = FabricVOMeta.SHORT_NAME , value = "简称" , required = false , dataTypeClass=String.class , example = "摇粒绒"),
		@ApiImplicitParam(name = FabricVOMeta.FILE_ID , value = "图片ID" , required = false , dataTypeClass=Integer.class , example = "13"),
	})
	@NotNull(name = FabricVOMeta.CODE)
	@NotNull(name = FabricVOMeta.FULL_NAME)
	@ApiOperationSupport(order=1)
	@SentinelResource(value = FabricServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FabricServiceProxy.INSERT)
	public  Result<Fabric> insert(FabricVO fabricVO) {
		Result<Fabric> result=new Result<>();
		boolean suc=fabricService.insert(fabricVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除面料
	*/
	@RequiresPermissions("PrdFabric:deleteById")
	@ApiOperation(value = "删除面料")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FabricVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = FabricVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = FabricServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FabricServiceProxy.DELETE)
	public  Result deleteById(Integer id) {
		Result result=new Result();
		boolean suc=fabricService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键批量删除面料
	*/
	@RequiresPermissions("PrdFabric:deleteByIds")
	@ApiOperation(value = "按主键批量删除面料")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FabricVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class , example = "1")
	})
	@NotNull(name = FabricVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = FabricServiceProxy.BATCH_DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FabricServiceProxy.BATCH_DELETE)
	public  Result deleteByIds(List<Integer> id) {
		Result result=new Result();
		boolean suc=fabricService.deleteByIdsLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新面料
	*/
	@RequiresPermissions("PrdFabric:update")
	@ApiOperation(value = "更新面料")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FabricVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = FabricVOMeta.CODE , value = "编码" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = FabricVOMeta.FULL_NAME , value = "名称" , required = true , dataTypeClass=String.class , example = "保暖摇粒绒"),
		@ApiImplicitParam(name = FabricVOMeta.SHORT_NAME , value = "简称" , required = false , dataTypeClass=String.class , example = "摇粒绒"),
		@ApiImplicitParam(name = FabricVOMeta.FILE_ID , value = "图片ID" , required = false , dataTypeClass=Integer.class , example = "13"),
	})
	@NotNull(name = FabricVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {FabricVOMeta.PAGE_INDEX , FabricVOMeta.PAGE_SIZE , FabricVOMeta.SEARCH_FIELD , FabricVOMeta.SEARCH_VALUE},order=3)
	@SentinelResource(value = FabricServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FabricServiceProxy.UPDATE)
	public  Result<Fabric> update(FabricVO fabricVO) {
		Result<Fabric> result=new Result<>();
		boolean suc=fabricService.update(fabricVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 添加面料
	*/
	@RequiresPermissions("PrdFabric:save")
	@ApiOperation(value = "保存面料")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FabricVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = FabricVOMeta.CODE , value = "编码" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = FabricVOMeta.FULL_NAME , value = "名称" , required = true , dataTypeClass=String.class , example = "保暖摇粒绒"),
		@ApiImplicitParam(name = FabricVOMeta.SHORT_NAME , value = "简称" , required = false , dataTypeClass=String.class , example = "摇粒绒"),
		@ApiImplicitParam(name = FabricVOMeta.FILE_ID , value = "图片ID" , required = false , dataTypeClass=Integer.class , example = "13"),
	})
	@NotNull(name = FabricVOMeta.CODE)
	@NotNull(name = FabricVOMeta.FULL_NAME)
	@ApiOperationSupport(order=1)
	@SentinelResource(value = FabricServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FabricServiceProxy.SAVE)
	public  Result<Fabric> save(FabricVO fabricVO) {
		Result<Fabric> result=new Result<>();
		boolean suc=fabricService.save(fabricVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取面料
	*/
	@RequiresPermissions("PrdFabric:getById")
	@ApiOperation(value = "按主键获取面料")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FabricVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = FabricVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = FabricServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FabricServiceProxy.GET_BY_ID)
	public  Result<Fabric> getById(Integer id) {
		Result<Fabric> result=new Result<>();
		Fabric fabric=fabricService.getById(id);
		result.success(true).data(fabric);
		return result;
	}

	
	/**
	 * 查询全部符合条件的面料
	*/
	@RequiresPermissions("PrdFabric:queryList")
	@ApiOperation(value = "查询面料")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FabricVOMeta.ID , value = "id" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = FabricVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = FabricVOMeta.FULL_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "保暖摇粒绒"),
		@ApiImplicitParam(name = FabricVOMeta.SHORT_NAME , value = "简称" , required = false , dataTypeClass=String.class , example = "摇粒绒"),
		@ApiImplicitParam(name = FabricVOMeta.FILE_ID , value = "图片ID" , required = false , dataTypeClass=Integer.class , example = "13"),
	})
	@ApiOperationSupport(ignoreParameters = {FabricVOMeta.PAGE_INDEX , FabricVOMeta.PAGE_SIZE , FabricVOMeta.SEARCH_FIELD , FabricVOMeta.SEARCH_VALUE},order=5)
	@SentinelResource(value = FabricServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FabricServiceProxy.QUERY_LIST)
	public  Result<List<Fabric>> queryList(FabricVO sample) {
		Result<List<Fabric>> result=new Result<>();
		List<Fabric> list=fabricService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的面料
	*/
	@RequiresPermissions("PrdFabric:queryPagedList")
	@ApiOperation(value = "分页查询面料")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FabricVOMeta.ID , value = "id" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = FabricVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = FabricVOMeta.FULL_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "保暖摇粒绒"),
		@ApiImplicitParam(name = FabricVOMeta.SHORT_NAME , value = "简称" , required = false , dataTypeClass=String.class , example = "摇粒绒"),
		@ApiImplicitParam(name = FabricVOMeta.FILE_ID , value = "图片ID" , required = false , dataTypeClass=Integer.class , example = "13"),
		@ApiImplicitParam(name = FabricVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FabricVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FabricVOMeta.SEARCH_FIELD , value = "搜索的字段" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FabricVOMeta.SEARCH_VALUE , value = "搜索的值" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = FabricServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FabricServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<Fabric>> queryPagedList(FabricVO sample) {
		Result<PagedList<Fabric>> result=new Result<>();
		PagedList<Fabric> list=fabricService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



}