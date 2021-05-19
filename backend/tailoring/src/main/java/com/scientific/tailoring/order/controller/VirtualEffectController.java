package com.scientific.tailoring.order.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.springboot.mvc.Result;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.scientific.tailoring.domain.order.VirtualEffectVO;
import com.scientific.tailoring.domain.order.VirtualEffect;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.order.service.IVirtualEffectService;
import com.scientific.tailoring.proxy.order.VirtualEffectServiceProxy;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.scientific.tailoring.domain.order.meta.VirtualEffectVOMeta;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-25 08:57:39
*/

@Api(tags = "虚拟效果视频展示")
@ApiSort(1156)
@RestController("OdrVirtualEffectController")
public class VirtualEffectController extends SuperController {

	@Autowired
	private IVirtualEffectService virtualEffectService;

	
	/**
	 * 添加虚拟效果视频展示
	*/
	@RequiresPermissions("OdrVirtualEffect:insert")
	@ApiOperation(value = "添加虚拟效果视频展示")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualEffectVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.MEASURE_ID , value = "测量ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.VIDEO_LOCATION , value = "视频地址" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(ignoreParameters = {VirtualEffectVOMeta.PAGE_INDEX , VirtualEffectVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = VirtualEffectServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualEffectServiceProxy.INSERT)
	public  Result<VirtualEffect> insert(VirtualEffectVO virtualEffectVO) {
		Result<VirtualEffect> result=new Result<>();
		boolean suc=virtualEffectService.insert(virtualEffectVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除虚拟效果视频展示
	*/
	@RequiresPermissions("OdrVirtualEffect:deleteById")
	@ApiOperation(value = "删除虚拟效果视频展示")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualEffectVOMeta.ID , value = "ID" , required = true , dataTypeClass=Integer.class),
	})
	@NotNull(name = VirtualEffectVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = VirtualEffectServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualEffectServiceProxy.DELETE)
	public  Result deleteById(Integer id) {
		Result result=new Result();
		boolean suc=virtualEffectService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新虚拟效果视频展示
	*/
	@RequiresPermissions("OdrVirtualEffect:update")
	@ApiOperation(value = "更新虚拟效果视频展示")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualEffectVOMeta.ID , value = "ID" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.MEASURE_ID , value = "测量ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.VIDEO_LOCATION , value = "视频地址" , required = false , dataTypeClass=String.class),
	})
	@NotNull(name = VirtualEffectVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {VirtualEffectVOMeta.PAGE_INDEX , VirtualEffectVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = VirtualEffectServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualEffectServiceProxy.UPDATE)
	public  Result<VirtualEffect> update(VirtualEffectVO virtualEffectVO) {
		Result<VirtualEffect> result=new Result<>();
		boolean suc=virtualEffectService.update(virtualEffectVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取虚拟效果视频展示
	*/
	@RequiresPermissions("OdrVirtualEffect:getById")
	@ApiOperation(value = "按主键获取虚拟效果视频展示")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualEffectVOMeta.ID , value = "ID" , required = true , dataTypeClass=Integer.class),
	})
	@NotNull(name = VirtualEffectVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = VirtualEffectServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualEffectServiceProxy.GET_BY_ID)
	public  Result<VirtualEffect> getById(Integer id) {
		Result<VirtualEffect> result=new Result<>();
		VirtualEffect virtualEffect=virtualEffectService.getById(id);
		result.success(true).data(virtualEffect);
		return result;
	}

	
	/**
	 * 查询全部符合条件的虚拟效果视频展示
	*/
	@RequiresPermissions("OdrVirtualEffect:queryList")
	@ApiOperation(value = "查询虚拟效果视频展示")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualEffectVOMeta.ID , value = "ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.MEASURE_ID , value = "测量ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.VIDEO_LOCATION , value = "视频地址" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(ignoreParameters = {VirtualEffectVOMeta.PAGE_INDEX , VirtualEffectVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = VirtualEffectServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualEffectServiceProxy.QUERY_LIST)
	public  Result<List<VirtualEffect>> queryList(VirtualEffectVO sample) {
		Result<List<VirtualEffect>> result=new Result<>();
		List<VirtualEffect> list=virtualEffectService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的虚拟效果视频展示
	*/
	@RequiresPermissions("OdrVirtualEffect:queryPagedList")
	@ApiOperation(value = "分页查询虚拟效果视频展示")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VirtualEffectVOMeta.ID , value = "ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.MEASURE_ID , value = "测量ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.VIDEO_LOCATION , value = "视频地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = VirtualEffectVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = VirtualEffectServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(VirtualEffectServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<VirtualEffect>> queryPagedList(VirtualEffectVO sample) {
		Result<PagedList<VirtualEffect>> result=new Result<>();
		PagedList<VirtualEffect> list=virtualEffectService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}