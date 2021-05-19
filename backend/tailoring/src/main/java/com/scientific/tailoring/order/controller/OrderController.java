package com.scientific.tailoring.order.controller;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.scientific.tailoring.system.service.IDictService;
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
import com.scientific.tailoring.domain.order.AppOrderModel;
import com.scientific.tailoring.domain.order.Order;
import com.scientific.tailoring.domain.order.OrderVO;
import com.scientific.tailoring.domain.order.meta.OrderVOMeta;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.order.service.IOrderService;
import com.scientific.tailoring.proxy.order.OrderServiceProxy;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @author 李方捷
 * @since 2021-03-22 01:32:54
*/

@Api(tags = "订单")
@ApiSort(1151)
@RestController("OdrOrderController")
public class OrderController extends SuperController {

	@Autowired
	private IOrderService orderService;

	@Autowired
	private IDictService dictService;
	
	/**
	 * 添加订单
	*/
	@RequiresPermissions("OdrOrder:insert")
	@ApiOperation(value = "添加订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrderVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = OrderVOMeta.APPOINTMENT_TIME , value = "预约时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = OrderVOMeta.STATUS , value = "订单状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrderVOMeta.CITY_ID , value = "城市ID" , required = false , dataTypeClass=Integer.class , example = "110111"),
		@ApiImplicitParam(name = OrderVOMeta.PROVINCE_ID , value = "省份ID" , required = false , dataTypeClass=Integer.class , example = "110000"),
		@ApiImplicitParam(name = OrderVOMeta.AREA_ID , value = "区县ID" , required = false , dataTypeClass=Integer.class , example = "110108"),
		@ApiImplicitParam(name = OrderVOMeta.TOWN_ID , value = "镇ID" , required = false , dataTypeClass=Integer.class , example = "131128"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_DETAIL , value = "详细地址" , required = false , dataTypeClass=String.class , example = "88弄11号"),
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class),
	})
	@NotNull(name = OrderVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {OrderVOMeta.PAGE_INDEX , OrderVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = OrderServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(OrderServiceProxy.INSERT)
	public  Result<Order> insert(OrderVO orderVO) {
		Result<Order> result=new Result<>();
		boolean suc=orderService.insert(orderVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除订单
	*/
	@RequiresPermissions("OdrOrder:deleteById")
	@ApiOperation(value = "删除订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class),
	})
	@NotNull(name = OrderVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = OrderServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(OrderServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=orderService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新订单
	*/
	@RequiresPermissions("OdrOrder:update")
	@ApiOperation(value = "更新订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrderVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = OrderVOMeta.APPOINTMENT_TIME , value = "预约时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = OrderVOMeta.STATUS , value = "订单状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrderVOMeta.CITY_ID , value = "城市ID" , required = false , dataTypeClass=Integer.class , example = "110111"),
		@ApiImplicitParam(name = OrderVOMeta.PROVINCE_ID , value = "省份ID" , required = false , dataTypeClass=Integer.class , example = "110000"),
		@ApiImplicitParam(name = OrderVOMeta.AREA_ID , value = "区县ID" , required = false , dataTypeClass=Integer.class , example = "110108"),
		@ApiImplicitParam(name = OrderVOMeta.TOWN_ID , value = "镇ID" , required = false , dataTypeClass=Integer.class , example = "131128"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_DETAIL , value = "详细地址" , required = false , dataTypeClass=String.class , example = "88弄11号"),
	})
	@NotNull(name = OrderVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {OrderVOMeta.PAGE_INDEX , OrderVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = OrderServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(OrderServiceProxy.UPDATE)
	public  Result<Order> update(OrderVO orderVO) {
		Result<Order> result=new Result<>();
		boolean suc=orderService.update(orderVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取订单
	*/
	@RequiresPermissions("OdrOrder:getById")
	@ApiOperation(value = "按主键获取订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class),
	})
	@NotNull(name = OrderVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = OrderServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(OrderServiceProxy.GET_BY_ID)
	public  Result<Order> getById(Long id) {
		Result<Order> result=new Result<>();
		Order order=orderService.getById(id);
		result.success(true).data(order);
		return result;
	}

	
	/**
	 * 查询全部符合条件的订单
	*/
	@RequiresPermissions("OdrOrder:queryList")
	@ApiOperation(value = "查询订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrderVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = OrderVOMeta.APPOINTMENT_TIME , value = "预约时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = OrderVOMeta.STATUS , value = "订单状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrderVOMeta.CITY_ID , value = "城市ID" , required = false , dataTypeClass=Integer.class , example = "110111"),
		@ApiImplicitParam(name = OrderVOMeta.PROVINCE_ID , value = "省份ID" , required = false , dataTypeClass=Integer.class , example = "110000"),
		@ApiImplicitParam(name = OrderVOMeta.AREA_ID , value = "区县ID" , required = false , dataTypeClass=Integer.class , example = "110108"),
		@ApiImplicitParam(name = OrderVOMeta.TOWN_ID , value = "镇ID" , required = false , dataTypeClass=Integer.class , example = "131128"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_DETAIL , value = "详细地址" , required = false , dataTypeClass=String.class , example = "88弄11号"),
	})
	@ApiOperationSupport(ignoreParameters = {OrderVOMeta.PAGE_INDEX , OrderVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = OrderServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(OrderServiceProxy.QUERY_LIST)
	public  Result<List<Order>> queryList(OrderVO sample) {
		Result<List<Order>> result=new Result<>();
		List<Order> list=orderService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的订单
	*/
	@RequiresPermissions("OdrOrder:queryPagedList")
	@ApiOperation(value = "分页查询订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrderVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = OrderVOMeta.APPOINTMENT_TIME , value = "预约时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = OrderVOMeta.STATUS , value = "订单状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrderVOMeta.CITY_ID , value = "城市ID" , required = false , dataTypeClass=Integer.class , example = "110111"),
		@ApiImplicitParam(name = OrderVOMeta.PROVINCE_ID , value = "省份ID" , required = false , dataTypeClass=Integer.class , example = "110000"),
		@ApiImplicitParam(name = OrderVOMeta.AREA_ID , value = "区县ID" , required = false , dataTypeClass=Integer.class , example = "110108"),
		@ApiImplicitParam(name = OrderVOMeta.TOWN_ID , value = "镇ID" , required = false , dataTypeClass=Integer.class , example = "131128"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_DETAIL , value = "详细地址" , required = false , dataTypeClass=String.class , example = "88弄11号"),
		@ApiImplicitParam(name = OrderVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OrderVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = OrderServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(OrderServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<Order>> queryPagedList(OrderVO sample) {
		Result<PagedList<Order>> result=new Result<>();
		PagedList<Order> list=orderService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}
	
	
	/**
	 * 分页查询符合条件的订单
	*/
	@RequiresPermissions("OdrOrder:queryPagedList4App")
	@ApiOperation(value = "分页查询符合条件的订单(App)")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.APPOINTMENT_TIME , value = "预约时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = OrderVOMeta.STATUS , value = "订单状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrderVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OrderVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = OrderServiceProxy.QUERY_PAGED_LIST_4_APP, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(OrderServiceProxy.QUERY_PAGED_LIST_4_APP)
	public  Result<PagedList<AppOrderModel>> queryPagedList4App(OrderVO sample) { 
		Result<PagedList<AppOrderModel>> result=new Result<>();
		PagedList<AppOrderModel> list=orderService.queryPagedEntities4App(this.getSessionSubject().getCompany().getId(),sample,sample.getPageSize(),sample.getPageIndex());
		Map<String,String> measureStatusDict=dictService.getDictItems("measure_status");
		result.refer("measure_status",measureStatusDict);
		result.success(true).data(list);
		return result;
	}


}