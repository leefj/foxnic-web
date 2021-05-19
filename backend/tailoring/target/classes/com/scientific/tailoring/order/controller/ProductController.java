package com.scientific.tailoring.order.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.product.ProductOrderModel;
import com.scientific.tailoring.domain.product.meta.LabelVOMeta;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.springboot.mvc.Result;
import java.util.List;
import com.scientific.tailoring.domain.order.meta.ProductVOMeta;
import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.misc.FormSeletOption;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.order.service.IProductService;
import com.scientific.tailoring.proxy.order.ProductServiceProxy;
import com.scientific.tailoring.proxy.product.LabelServiceProxy;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import com.scientific.tailoring.domain.order.Product;
import com.scientific.tailoring.domain.order.ProductVO;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-25 08:57:38
*/

@Api(tags = "订单商品关系")
@ApiSort(1152)
@RestController("OdrProductController")
public class ProductController extends SuperController {

	@Autowired
	private IProductService productService;

	
	/**
	 * 添加订单商品关系
	*/
	@RequiresPermissions("OdrProduct:insert")
	@ApiOperation(value = "添加订单商品关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ORDER_ID , value = "订单ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_ID , value = "商品ID" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = ProductVOMeta.ORDER_ID)
	@ApiOperationSupport(ignoreParameters = {ProductVOMeta.PAGE_INDEX , ProductVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = ProductServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.INSERT)
	public  Result<Product> insert(ProductVO productVO) {
		Result<Product> result=new Result<>();
		boolean suc=productService.insert(productVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除订单商品关系
	*/
	@RequiresPermissions("OdrProduct:deleteById")
	@ApiOperation(value = "删除订单商品关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = ProductVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = ProductServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=productService.deleteByIdPhysical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新订单商品关系
	*/
	@RequiresPermissions("OdrProduct:update")
	@ApiOperation(value = "更新订单商品关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.ORDER_ID , value = "订单ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_ID , value = "商品ID" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = ProductVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {ProductVOMeta.PAGE_INDEX , ProductVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = ProductServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.UPDATE)
	public  Result<Product> update(ProductVO productVO) {
		Result<Product> result=new Result<>();
		boolean suc=productService.update(productVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取订单商品关系
	*/
	@RequiresPermissions("OdrProduct:getById")
	@ApiOperation(value = "按主键获取订单商品关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = ProductVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = ProductServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.GET_BY_ID)
	public  Result<Product> getById(Long id) {
		Result<Product> result=new Result<>();
		Product product=productService.getById(id);
		result.success(true).data(product);
		return result;
	}

	/**
	 * 按主键批量删除产品标签
	 */
	@RequiresPermissions("OdrProduct:deleteByIds")
	@ApiOperation(value = "按主键批量删除产品")
	@ApiImplicitParams({
			@ApiImplicitParam(name = ProductVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class , example = "1")
	})
	@NotNull(name = ProductVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = ProductServiceProxy.BATCH_DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.BATCH_DELETE)
	public  Result deleteByIds(List<Integer> id) {
		Result result=new Result();
		boolean suc=productService.deleteByIdsPhysical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 查询全部符合条件的订单商品关系
	*/
	@RequiresPermissions("OdrProduct:queryList")
	@ApiOperation(value = "查询订单商品关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(ignoreParameters = {ProductVOMeta.PAGE_INDEX , ProductVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = ProductServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.QUERY_LIST)
	public  Result<List<Product>> queryList(ProductVO sample) {
		Result<List<Product>> result=new Result<>();
		List<Product> list=productService.queryList(sample);
		result.success(true).data(list);
		return result;
	}
	
	
	/**
	 * 查询全部符合条件的订单商品关系
	*/
//	@RequiresPermissions("OdrProduct:queryList")
	@ApiOperation(value = "查询订单未使用的商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(ignoreParameters = {ProductVOMeta.PAGE_INDEX , ProductVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = ProductServiceProxy.QUERY_UNUSED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.QUERY_UNUSED_LIST)
	public  Result<List<FormSeletOption>> queryUnusedList(ProductVO sample) {
		Result<List<FormSeletOption>> result=new Result<>();
		List<com.scientific.tailoring.domain.product.Product> list=productService.queryUnusedProducts(sample.getOrderId(),sample.getSearchValue());
		List<FormSeletOption> options=FormSeletOption.collect(list, com.scientific.tailoring.domain.product.Product::getName, com.scientific.tailoring.domain.product.Product::getId);
		result.success(true).data(options);
		return result;
	}

	
	/**
	 * 分页查询符合条件的订单商品关系
	*/
	@RequiresPermissions("OdrProduct:queryPagedList")
	@ApiOperation(value = "分页查询订单商品关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = ProductServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<ProductOrderModel>> queryPagedList(ProductVO sample) {
		Result<PagedList<ProductOrderModel>> result=new Result<>();
		PagedList<ProductOrderModel> list=productService.queryPagedList(sample.getOrderId(),sample.getPageSize(),sample.getPageIndex());
		
		result.success(true).data(list);
		return result;
	}


}