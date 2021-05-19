package com.scientific.tailoring.system.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.mvc.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.scientific.tailoring.domain.system.Area;
import com.scientific.tailoring.domain.system.DictItem;
import com.scientific.tailoring.domain.system.DictItemVO;
import com.scientific.tailoring.domain.system.meta.DictItemVOMeta;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.misc.FormSeletOption;
import com.scientific.tailoring.proxy.system.DictItemServiceProxy;
import com.scientific.tailoring.system.service.IDictItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @author 李方捷
 * @since 2021-03-22 01:32:50
*/

@Api(tags = "数据字典条目")
@ApiSort(1003)
@RestController("SysDictItemController")
public class DictItemController extends SuperController {

	@Autowired
	private IDictItemService dictItemService;

	
	/**
	 * 添加数据字典条目
	*/
	@RequiresPermissions("SysDictItem:insert")
	@ApiOperation(value = "添加数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.DICT_ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_CODE , value = "字典代码" , required = true , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictItemVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = DictItemVOMeta.LABEL , value = "标签" , required = true , dataTypeClass=String.class , example = "男"),
		@ApiImplicitParam(name = DictItemVOMeta.SORT , value = "排序" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = DictItemVOMeta.DICT_ID)
	@NotNull(name = DictItemVOMeta.DICT_CODE)
	@NotNull(name = DictItemVOMeta.CODE)
	@NotNull(name = DictItemVOMeta.LABEL)
	@NotNull(name = DictItemVOMeta.SORT)
	@ApiOperationSupport(ignoreParameters = {DictItemVOMeta.PAGE_INDEX , DictItemVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = DictItemServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictItemServiceProxy.INSERT)
	public  Result<DictItem> insert(DictItemVO dictItemVO) {
		Result<DictItem> result=new Result<>();
		boolean suc=dictItemService.insert(dictItemVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除数据字典条目
	*/
	@RequiresPermissions("SysDictItem:deleteById")
	@ApiOperation(value = "删除数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "ID" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = DictItemVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = DictItemServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictItemServiceProxy.DELETE)
	public  Result deleteById(Integer id) {
		Result result=new Result();
		boolean suc=dictItemService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新数据字典条目
	*/
	@RequiresPermissions("SysDictItem:update")
	@ApiOperation(value = "更新数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "ID" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_CODE , value = "字典代码" , required = true , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictItemVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = DictItemVOMeta.LABEL , value = "标签" , required = true , dataTypeClass=String.class , example = "男"),
		@ApiImplicitParam(name = DictItemVOMeta.SORT , value = "排序" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = DictItemVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {DictItemVOMeta.PAGE_INDEX , DictItemVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = DictItemServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictItemServiceProxy.UPDATE)
	public  Result<DictItem> update(DictItemVO dictItemVO) {
		Result<DictItem> result=new Result<>();
		boolean suc=dictItemService.update(dictItemVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取数据字典条目
	*/
	@RequiresPermissions("SysDictItem:getById")
	@ApiOperation(value = "按主键获取数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "ID" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = DictItemVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = DictItemServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictItemServiceProxy.GET_BY_ID)
	public  Result<DictItem> getById(Integer id) {
		Result<DictItem> result=new Result<>();
		DictItem dictItem=dictItemService.getById(id);
		result.success(true).data(dictItem);
		return result;
	}

	
	/**
	 * 查询全部符合条件的数据字典条目
	*/
//	@RequiresPermissions("SysDictItem:queryList")
	@ApiOperation(value = "查询全部符合条件的数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_ID , value = "字典ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_CODE , value = "字典代码" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictItemVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = DictItemVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "男"),
		@ApiImplicitParam(name = DictItemVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(ignoreParameters = {DictItemVOMeta.PAGE_INDEX , DictItemVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = DictItemServiceProxy.QUERY_DICT_ITEMS, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@RequestMapping(DictItemServiceProxy.QUERY_DICT_ITEMS)
	public  Result<List<FormSeletOption>> queryItemList(DictItemVO sample) {
		Result<List<FormSeletOption>> result=new Result<>();
		List<DictItem> list=dictItemService.queryList(sample);
		List<FormSeletOption> options=FormSeletOption.collect(list, DictItem::getLabel, DictItem::getCode);
		result.success(true).data(options);
		return result;
	}
	
	
	/**
	 * 查询全部符合条件的数据字典条目
	*/
	@RequiresPermissions("SysDictItem:queryList")
	@ApiOperation(value = "查询数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_ID , value = "字典ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_CODE , value = "字典代码" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictItemVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = DictItemVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "男"),
		@ApiImplicitParam(name = DictItemVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(ignoreParameters = {DictItemVOMeta.PAGE_INDEX , DictItemVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = DictItemServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictItemServiceProxy.QUERY_LIST)
	public  Result<List<DictItem>> queryList(DictItemVO sample) {
		Result<List<DictItem>> result=new Result<>();
		List<DictItem> list=dictItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的数据字典条目
	*/
	@RequiresPermissions("SysDictItem:queryPagedList")
	@ApiOperation(value = "分页查询数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_ID , value = "字典ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_CODE , value = "字典代码" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictItemVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = DictItemVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "男"),
		@ApiImplicitParam(name = DictItemVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DictItemVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = DictItemServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DictItemServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<DictItem>> queryPagedList(DictItemVO sample) {
		Result<PagedList<DictItem>> result=new Result<>();
		PagedList<DictItem> list=dictItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}