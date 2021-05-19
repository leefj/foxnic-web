package com.scientific.tailoring.order.controller;

 
import java.util.List;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.framework.web.SuperController;


import com.scientific.tailoring.proxy.order.BodyServiceProxy;
import com.scientific.tailoring.domain.order.meta.BodyVOMeta;
import com.scientific.tailoring.domain.order.Body;
import com.scientific.tailoring.domain.order.BodyVO;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.scientific.tailoring.order.service.IBodyService;
import com.github.foxnic.springboot.api.annotations.NotNull;

/**
 * <p>
 * 订单测量人员表 接口控制器
 * </p>
 * @author 李方捷
 * @since 2021-05-12 10:23:18
*/

@Api(tags = "订单测量人员")
@ApiSort(0)
@RestController("OdrBodyController")
public class BodyController {

	@Autowired
	private IBodyService bodyService;

	
	/**
	 * 添加订单测量人员
	*/
	@ApiOperation(value = "添加订单测量人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BodyVOMeta.ORDER_ID , value = "订单ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_NAME , value = "被测量人姓名" , required = false , dataTypeClass=String.class , example = "李小龙"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_DEPT , value = "被测量人部门" , required = false , dataTypeClass=String.class , example = "财务部"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_SEX , value = "被测量人性别" , required = false , dataTypeClass=String.class , example = "M"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_HEIGHT , value = "被测量人身高" , required = true , dataTypeClass=Integer.class , example = "172"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = BodyVOMeta.ORDER_ID)
	@NotNull(name = BodyVOMeta.BODY_HEIGHT)
	@SentinelResource(value = BodyServiceProxy.INSERT)
	@PostMapping(BodyServiceProxy.INSERT)
	public Result<Body> insert(BodyVO bodyVO) {
		Result<Body> result=new Result<>();
		boolean suc=bodyService.insert(bodyVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除订单测量人员
	*/
	@ApiOperation(value = "删除订单测量人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BodyVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "47"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = BodyVOMeta.ID)
	@SentinelResource(value = BodyServiceProxy.DELETE)
	@PostMapping(BodyServiceProxy.DELETE)
	public Result<Body> deleteById(Long id) {
		Result<Body> result=new Result<>();
		boolean suc=bodyService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除订单测量人员 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除订单测量人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BodyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = BodyVOMeta.IDS)
	@SentinelResource(value = BodyServiceProxy.BATCH_DELETE)
	@PostMapping(BodyServiceProxy.BATCH_DELETE)
	public Result<Body> deleteByIds(List<Long> ids) {
		Result<Body> result=new Result<>();
		boolean suc=bodyService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新订单测量人员
	*/
	@ApiOperation(value = "更新订单测量人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BodyVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "47"),
		@ApiImplicitParam(name = BodyVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_NAME , value = "被测量人姓名" , required = false , dataTypeClass=String.class , example = "李小龙"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_DEPT , value = "被测量人部门" , required = false , dataTypeClass=String.class , example = "财务部"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_SEX , value = "被测量人性别" , required = false , dataTypeClass=String.class , example = "M"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_HEIGHT , value = "被测量人身高" , required = false , dataTypeClass=Integer.class , example = "172"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { BodyVOMeta.PAGE_INDEX , BodyVOMeta.PAGE_SIZE , BodyVOMeta.SEARCH_FIELD , BodyVOMeta.SEARCH_VALUE , BodyVOMeta.IDS } ) 
	@NotNull(name = BodyVOMeta.ID)
	@SentinelResource(value = BodyServiceProxy.UPDATE)
	@PostMapping(BodyServiceProxy.UPDATE)
	public Result<Body> update(BodyVO bodyVO) {
		Result<Body> result=new Result<>();
		boolean suc=bodyService.update(bodyVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存订单测量人员
	*/
	@ApiOperation(value = "保存订单测量人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BodyVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "47"),
		@ApiImplicitParam(name = BodyVOMeta.ORDER_ID , value = "订单ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_NAME , value = "被测量人姓名" , required = false , dataTypeClass=String.class , example = "李小龙"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_DEPT , value = "被测量人部门" , required = false , dataTypeClass=String.class , example = "财务部"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_SEX , value = "被测量人性别" , required = false , dataTypeClass=String.class , example = "M"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_HEIGHT , value = "被测量人身高" , required = true , dataTypeClass=Integer.class , example = "172"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BodyVOMeta.PAGE_INDEX , BodyVOMeta.PAGE_SIZE , BodyVOMeta.SEARCH_FIELD , BodyVOMeta.SEARCH_VALUE , BodyVOMeta.IDS } )
	@NotNull(name = BodyVOMeta.ID)
	@NotNull(name = BodyVOMeta.ORDER_ID)
	@NotNull(name = BodyVOMeta.BODY_HEIGHT)
	@SentinelResource(value = BodyServiceProxy.SAVE)
	@PostMapping(BodyServiceProxy.SAVE)
	public Result<Body> save(BodyVO bodyVO) {
		Result<Body> result=new Result<>();
		boolean suc=bodyService.save(bodyVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取订单测量人员
	*/
	@ApiOperation(value = "获取订单测量人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BodyVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = BodyVOMeta.ID)
	@SentinelResource(value = BodyServiceProxy.GET_BY_ID)
	@PostMapping(BodyServiceProxy.GET_BY_ID)
	public Result<Body> getById(Long id) {
		Result<Body> result=new Result<>();
		Body role=bodyService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询订单测量人员
	*/
	@ApiOperation(value = "查询订单测量人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BodyVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "47"),
		@ApiImplicitParam(name = BodyVOMeta.ORDER_ID , value = "订单ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_NAME , value = "被测量人姓名" , required = false , dataTypeClass=String.class , example = "李小龙"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_DEPT , value = "被测量人部门" , required = false , dataTypeClass=String.class , example = "财务部"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_SEX , value = "被测量人性别" , required = false , dataTypeClass=String.class , example = "M"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_HEIGHT , value = "被测量人身高" , required = true , dataTypeClass=Integer.class , example = "172"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BodyVOMeta.PAGE_INDEX , BodyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = BodyServiceProxy.QUERY_LIST)
	@PostMapping(BodyServiceProxy.QUERY_LIST)
	public Result<List<Body>> queryList(BodyVO sample) {
		Result<List<Body>> result=new Result<>();
		List<Body> list=bodyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询订单测量人员
	*/
	@ApiOperation(value = "分页查询订单测量人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BodyVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "47"),
		@ApiImplicitParam(name = BodyVOMeta.ORDER_ID , value = "订单ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_NAME , value = "被测量人姓名" , required = false , dataTypeClass=String.class , example = "李小龙"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_DEPT , value = "被测量人部门" , required = false , dataTypeClass=String.class , example = "财务部"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_SEX , value = "被测量人性别" , required = false , dataTypeClass=String.class , example = "M"),
		@ApiImplicitParam(name = BodyVOMeta.BODY_HEIGHT , value = "被测量人身高" , required = true , dataTypeClass=Integer.class , example = "172"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = BodyServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(BodyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Body>> queryPagedList(BodyVO sample) {
		Result<PagedList<Body>> result=new Result<>();
		PagedList<Body> list=bodyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}