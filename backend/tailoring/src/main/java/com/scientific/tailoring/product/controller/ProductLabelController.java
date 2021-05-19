package com.scientific.tailoring.product.controller;
import com.scientific.tailoring.domain.product.meta.ProductLabelVOMeta;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.domain.product.ProductLabel;
import com.github.foxnic.springboot.mvc.Result;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.domain.product.ProductLabelVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.scientific.tailoring.product.service.IProductLabelService;
import com.scientific.tailoring.proxy.product.ProductLabelServiceProxy;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-22 10:54:31
*/

@Api(tags = "商品标签关系")
@ApiSort(1105)
@RestController("PrdProductLabelController")
public class ProductLabelController extends SuperController {

	@Autowired
	private IProductLabelService productLabelService;

	
	/**
	 * 添加商品标签关系
	*/
	@RequiresPermissions("PrdProductLabel:insert")
	@ApiOperation(value = "添加商品标签关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductLabelVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductLabelVOMeta.LABEL_ID , value = "标签ID" , required = false , dataTypeClass=Integer.class , example = "4"),
	})
	@ApiOperationSupport(ignoreParameters = {ProductLabelVOMeta.PAGE_INDEX , ProductLabelVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = ProductLabelServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductLabelServiceProxy.INSERT)
	public  Result<ProductLabel> insert(ProductLabelVO productLabelVO) {
		Result<ProductLabel> result=new Result<>();
		boolean suc=productLabelService.insert(productLabelVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除商品标签关系
	*/
	@RequiresPermissions("PrdProductLabel:deleteById")
	@ApiOperation(value = "删除商品标签关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductLabelVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = ProductLabelVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = ProductLabelServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductLabelServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=productLabelService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新商品标签关系
	*/
	@RequiresPermissions("PrdProductLabel:update")
	@ApiOperation(value = "更新商品标签关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductLabelVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductLabelVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductLabelVOMeta.LABEL_ID , value = "标签ID" , required = false , dataTypeClass=Integer.class , example = "4"),
	})
	@NotNull(name = ProductLabelVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {ProductLabelVOMeta.PAGE_INDEX , ProductLabelVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = ProductLabelServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductLabelServiceProxy.UPDATE)
	public  Result<ProductLabel> update(ProductLabelVO productLabelVO) {
		Result<ProductLabel> result=new Result<>();
		boolean suc=productLabelService.update(productLabelVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取商品标签关系
	*/
	@RequiresPermissions("PrdProductLabel:getById")
	@ApiOperation(value = "按主键获取商品标签关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductLabelVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = ProductLabelVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = ProductLabelServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductLabelServiceProxy.GET_BY_ID)
	public  Result<ProductLabel> getById(Long id) {
		Result<ProductLabel> result=new Result<>();
		ProductLabel productLabel=productLabelService.getById(id);
		result.success(true).data(productLabel);
		return result;
	}

	
	/**
	 * 查询全部符合条件的商品标签关系
	*/
	@RequiresPermissions("PrdProductLabel:queryList")
	@ApiOperation(value = "查询商品标签关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductLabelVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductLabelVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductLabelVOMeta.LABEL_ID , value = "标签ID" , required = false , dataTypeClass=Integer.class , example = "4"),
	})
	@ApiOperationSupport(ignoreParameters = {ProductLabelVOMeta.PAGE_INDEX , ProductLabelVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = ProductLabelServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductLabelServiceProxy.QUERY_LIST)
	public  Result<List<ProductLabel>> queryList(ProductLabelVO sample) {
		Result<List<ProductLabel>> result=new Result<>();
		List<ProductLabel> list=productLabelService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的商品标签关系
	*/
	@RequiresPermissions("PrdProductLabel:queryPagedList")
	@ApiOperation(value = "分页查询商品标签关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductLabelVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductLabelVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductLabelVOMeta.LABEL_ID , value = "标签ID" , required = false , dataTypeClass=Integer.class , example = "4"),
		@ApiImplicitParam(name = ProductLabelVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductLabelVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = ProductLabelServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductLabelServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<ProductLabel>> queryPagedList(ProductLabelVO sample) {
		Result<PagedList<ProductLabel>> result=new Result<>();
		PagedList<ProductLabel> list=productLabelService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}