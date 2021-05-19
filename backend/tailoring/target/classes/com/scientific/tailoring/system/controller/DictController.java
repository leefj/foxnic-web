package com.scientific.tailoring.system.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.CollectorUtil;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.mvc.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.scientific.tailoring.domain.system.Dict;
import com.scientific.tailoring.domain.system.DictItem;
import com.scientific.tailoring.domain.system.DictVO;
import com.scientific.tailoring.domain.system.meta.DictVOMeta;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.proxy.system.DictServiceProxy;
import com.scientific.tailoring.system.service.IDictItemService;
import com.scientific.tailoring.system.service.IDictService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @author 李方捷
 * @since 2021-03-22 01:32:50
*/

@Api(tags = "数据字典")
@ApiSort(1002)
@RestController("SysDictController")
public class DictController extends SuperController {

	@Autowired
	private IDictService dictService;
	
	@Autowired
	private IDictItemService dictItemService;

	
	/**
	 * 添加数据字典
	*/
	@RequiresPermissions("SysDict:insert")
	@ApiOperation(value = "添加数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "字典名称" , required = true , dataTypeClass=String.class , example = "性别"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "字典代码" , required = true , dataTypeClass=String.class , example = "sex"),
	})
	@NotNull(name = DictVOMeta.NAME)
	@NotNull(name = DictVOMeta.CODE)
	@ApiOperationSupport(ignoreParameters = {DictVOMeta.PAGE_INDEX , DictVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = DictServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictServiceProxy.INSERT)
	public  Result<Dict> insert(DictVO dictVO) {
		Result<Dict> result=new Result<>();
		boolean suc=dictService.insert(dictVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除数据字典
	*/
	@RequiresPermissions("SysDict:deleteById")
	@ApiOperation(value = "删除数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "字典ID" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = DictVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = DictServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictServiceProxy.DELETE)
	public  Result deleteById(Integer id) {
		Result result=new Result();
		boolean suc=dictService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新数据字典
	*/
	@RequiresPermissions("SysDict:update")
	@ApiOperation(value = "更新数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "字典ID" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "字典名称" , required = true , dataTypeClass=String.class , example = "性别"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "字典代码" , required = true , dataTypeClass=String.class , example = "sex"),
	})
	@NotNull(name = DictVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {DictVOMeta.PAGE_INDEX , DictVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = DictServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictServiceProxy.UPDATE)
	public  Result<Dict> update(DictVO dictVO) {
		Result<Dict> result=new Result<>();
		boolean suc=dictService.update(dictVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取数据字典
	*/
	@RequiresPermissions("SysDict:getById")
	@ApiOperation(value = "按主键获取数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "字典ID" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = DictVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = DictServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictServiceProxy.GET_BY_ID)
	public  Result<Dict> getById(Integer id) {
		Result<Dict> result=new Result<>();
		Dict dict=dictService.getById(id);
		result.success(true).data(dict);
		return result;
	}

	
	/**
	 * 查询全部符合条件的数据字典
	*/
	@RequiresPermissions("SysDict:queryList")
	@ApiOperation(value = "查询数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "字典ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "字典名称" , required = false , dataTypeClass=String.class , example = "性别"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "字典代码" , required = false , dataTypeClass=String.class , example = "sex"),
	})
	@ApiOperationSupport(ignoreParameters = {DictVOMeta.PAGE_INDEX , DictVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = DictServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictServiceProxy.QUERY_LIST)
	public  Result<List<Dict>> queryList(DictVO sample) {
		Result<List<Dict>> result=new Result<>();
		List<Dict> list=dictService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的数据字典
	*/
	@RequiresPermissions("SysDict:queryPagedList")
	@ApiOperation(value = "分页查询数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "字典ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "字典名称" , required = false , dataTypeClass=String.class , example = "性别"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "字典代码" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DictVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = DictServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<Dict>> queryPagedList(DictVO sample) {
		Result<PagedList<Dict>> result=new Result<>();
		PagedList<Dict> list=dictService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}
	
	
	/**
	 * 分页查询符合条件的数据字典
	*/
	@RequiresPermissions("SysDict:queryAll")
	@ApiOperation(value = "获取全部字典数据")
	@ApiOperationSupport(order=7)
	@SentinelResource(value = DictServiceProxy.QUERY_ALL, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictServiceProxy.QUERY_ALL)
	public  Result<JSONObject> queryAll(DictVO sample) {
		Result<JSONObject> result=new Result<>();
		JSONObject json=dictService.queryAll4JsDict();
		return result.data(json);
	}


}