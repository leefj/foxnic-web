package com.scientific.tailoring.product.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.mvc.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.scientific.tailoring.domain.product.VirtualLibrary;
import com.scientific.tailoring.domain.product.VirtualLibraryModel;
import com.scientific.tailoring.domain.product.VirtualLibraryVO;
import com.scientific.tailoring.domain.product.meta.VirtualLibraryVOMeta;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.product.service.IVirtualLibraryService;
import com.scientific.tailoring.proxy.product.VirtualLibraryServiceProxy;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @author 李方捷
 * @since 2021-04-08 03:46:44
*/

@Api(tags = "虚拟试衣")
@ApiSort(1101)
@RestController("PrdVirtualLibraryController")
public class VirtualLibraryController extends SuperController {

	@Autowired
	private IVirtualLibraryService virtualLibraryService;

	
	/**
	 * 添加虚拟试衣
	*/
	@RequiresPermissions("PrdVirtualLibrary:insert")
	@ApiOperation(value = "添加虚拟试衣")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualLibraryVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.FABRIC_ID , value = "面料ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.EFFECT_FILE_ID , value = "虚拟试衣效果图ID" , required = false , dataTypeClass=Long.class , example = "9"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Boolean.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = VirtualLibraryServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualLibraryServiceProxy.INSERT)
	public  Result<VirtualLibrary> insert(VirtualLibraryVO virtualLibraryVO) {
		Result<VirtualLibrary> result=new Result<>();
		boolean suc=virtualLibraryService.insert(virtualLibraryVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除虚拟试衣
	*/
	@RequiresPermissions("PrdVirtualLibrary:deleteById")
	@ApiOperation(value = "删除虚拟试衣")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualLibraryVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = VirtualLibraryVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = VirtualLibraryServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualLibraryServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=virtualLibraryService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键批量删除虚拟试衣
	*/
	@RequiresPermissions("PrdVirtualLibrary:deleteByIds")
	@ApiOperation(value = "按主键批量删除虚拟试衣")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualLibraryVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1")
	})
	@NotNull(name = VirtualLibraryVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = VirtualLibraryServiceProxy.BATCH_DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualLibraryServiceProxy.BATCH_DELETE)
	public  Result deleteByIds(List<Long> id) {
		Result result=new Result();
		boolean suc=virtualLibraryService.deleteByIdsLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新虚拟试衣
	*/
	@RequiresPermissions("PrdVirtualLibrary:update")
	@ApiOperation(value = "更新虚拟试衣")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualLibraryVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.FABRIC_ID , value = "面料ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.EFFECT_FILE_ID , value = "虚拟试衣效果图ID" , required = false , dataTypeClass=Long.class , example = "9"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Boolean.class),
	})
	@NotNull(name = VirtualLibraryVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {VirtualLibraryVOMeta.PAGE_INDEX , VirtualLibraryVOMeta.PAGE_SIZE , VirtualLibraryVOMeta.SEARCH_FIELD , VirtualLibraryVOMeta.SEARCH_VALUE},order=3)
	@SentinelResource(value = VirtualLibraryServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualLibraryServiceProxy.UPDATE)
	public  Result<VirtualLibrary> update(VirtualLibraryVO virtualLibraryVO) {
		Result<VirtualLibrary> result=new Result<>();
		boolean suc=virtualLibraryService.update(virtualLibraryVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 添加虚拟试衣
	*/
	@RequiresPermissions("PrdVirtualLibrary:save")
	@ApiOperation(value = "保存虚拟试衣")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualLibraryVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "136"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.FABRIC_ID , value = "面料ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.EFFECT_FILE_ID , value = "虚拟试衣效果图ID" , required = false , dataTypeClass=Long.class , example = "9"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Boolean.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = VirtualLibraryServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualLibraryServiceProxy.SAVE)
	public  Result<VirtualLibrary> save(VirtualLibraryVO virtualLibraryVO) {
		Result<VirtualLibrary> result=new Result<>();
		boolean suc=virtualLibraryService.save(virtualLibraryVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取虚拟试衣
	*/
	@RequiresPermissions("PrdVirtualLibrary:getById")
	@ApiOperation(value = "按主键获取虚拟试衣")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualLibraryVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = VirtualLibraryVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = VirtualLibraryServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualLibraryServiceProxy.GET_BY_ID)
	public  Result<VirtualLibrary> getById(Long id) {
		Result<VirtualLibrary> result=new Result<>();
		VirtualLibrary virtualLibrary=virtualLibraryService.getById(id);
		result.success(true).data(virtualLibrary);
		return result;
	}

	
	/**
	 * 查询全部符合条件的虚拟试衣
	*/
	@RequiresPermissions("PrdVirtualLibrary:queryList")
	@ApiOperation(value = "查询虚拟试衣")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualLibraryVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.FABRIC_ID , value = "面料ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.EFFECT_FILE_ID , value = "虚拟试衣效果图ID" , required = false , dataTypeClass=Long.class , example = "9"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class),
	})
	@ApiOperationSupport(ignoreParameters = {VirtualLibraryVOMeta.PAGE_INDEX , VirtualLibraryVOMeta.PAGE_SIZE , VirtualLibraryVOMeta.SEARCH_FIELD , VirtualLibraryVOMeta.SEARCH_VALUE},order=5)
	@SentinelResource(value = VirtualLibraryServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualLibraryServiceProxy.QUERY_LIST)
	public  Result<List<VirtualLibrary>> queryList(VirtualLibraryVO sample) {
		Result<List<VirtualLibrary>> result=new Result<>();
		List<VirtualLibrary> list=virtualLibraryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的虚拟试衣
	*/
	@RequiresPermissions("PrdVirtualLibrary:queryPagedList")
	@ApiOperation(value = "分页查询虚拟试衣")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualLibraryVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.FABRIC_ID , value = "面料ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.EFFECT_FILE_ID , value = "虚拟试衣效果图ID" , required = false , dataTypeClass=Long.class , example = "9"),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.SEARCH_FIELD , value = "搜索的字段" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtualLibraryVOMeta.SEARCH_VALUE , value = "搜索的值" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = VirtualLibraryServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualLibraryServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<VirtualLibraryModel>> queryPagedList(VirtualLibraryVO sample) {
		
		if("valid".equals(sample.getSearchField())) {
			Boolean valid=null;
			if("有效".equals(sample.getSearchValue())) {
				valid=true;
			}
			if("无效".equals(sample.getSearchValue())) {
				valid=false;
			}
			if(valid==null) {
				valid=DataParser.parseBoolean(sample.getSearchValue());
			}
			sample.setValid(valid);
			sample.setSearchField(null).setSearchValue(null);
		}
		
		Result<PagedList<VirtualLibraryModel>> result=new Result<>();
		PagedList<VirtualLibraryModel> list=virtualLibraryService.queryPagedListModel(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



}