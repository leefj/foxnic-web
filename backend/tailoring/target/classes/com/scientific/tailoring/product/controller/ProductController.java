package com.scientific.tailoring.product.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.product.AppProductModel;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.sql.expr.OrderBy;

import java.util.List;
import com.scientific.tailoring.product.service.IProductService;
import com.scientific.tailoring.proxy.product.ProductServiceProxy;

import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.domain.product.Product;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import io.swagger.annotations.ApiOperation;

import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT;

import org.springframework.web.bind.annotation.PostMapping;
import com.scientific.tailoring.domain.product.meta.ProductVOMeta;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.scientific.tailoring.domain.product.ProductVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-20 07:37:36
*/

@Api(tags = "商品")
@ApiSort(1106)
@RestController("PrdProductController")
public class ProductController extends SuperController {

	@Autowired
	private IProductService productService;

	
	/**
	 * 添加商品
	*/
	@RequiresPermissions("PrdProduct:insert")
	@ApiOperation(value = "添加商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "商品名称" , required = true , dataTypeClass=String.class , example = "商品-1"),
		@ApiImplicitParam(name = ProductVOMeta.IS_ON_SHELF , value = "是否上架" , required = true , dataTypeClass=Boolean.class , example = "true"),
		@ApiImplicitParam(name = ProductVOMeta.DETAIL , value = "商品详情" , required = false , dataTypeClass=String.class , example = "这是商品详情"),
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "商品编号" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = ProductVOMeta.ID)
	@NotNull(name = ProductVOMeta.IS_ON_SHELF)
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
	 * 按主键删除商品
	*/
	@RequiresPermissions("PrdProduct:deleteById")
	@ApiOperation(value = "删除商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "商品编号" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = ProductVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = ProductServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=productService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}





	
	/**
	 * 更新商品
	*/
	@RequiresPermissions("PrdProduct:update")
	@ApiOperation(value = "更新商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "商品编号" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "商品名称" , required = true , dataTypeClass=String.class , example = "商品-1"),
		@ApiImplicitParam(name = ProductVOMeta.IS_ON_SHELF , value = "是否上架" , required = true , dataTypeClass=Boolean.class , example = "true"),
		@ApiImplicitParam(name = ProductVOMeta.DETAIL , value = "商品详情" , required = false , dataTypeClass=String.class , example = "这是商品详情"),
	})
	@NotNull(name = ProductVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {ProductVOMeta.PAGE_INDEX , ProductVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = ProductServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.UPDATE)
	public  Result<Product> update(ProductVO productVO) {
		Result<Product> result=new Result<>();
		boolean suc=productService.update(productVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取商品
	*/
	@RequiresPermissions("PrdProduct:getById")
	@ApiOperation(value = "按主键获取商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "商品编号" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = ProductVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = ProductServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.GET_BY_ID)
	public  Result<AppProductModel> getById(Long id) {
		return this.getById4App(id);
	}


	/**
	 * 按主键获取商品
	 */
	@RequiresPermissions("PrdProduct:getById4App")
	@ApiOperation(value = "按主键获取商品")
	@ApiImplicitParams({
			@ApiImplicitParam(name = ProductVOMeta.ID , value = "商品编号" , required = true , dataTypeClass=Long.class , example = "1")
	})
	@NotNull(name = ProductVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = ProductServiceProxy.GET_BY_ID_4_APP, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.GET_BY_ID_4_APP)
	public  Result<AppProductModel> getById4App(Long id) {
		Result<AppProductModel> result=new Result<>();
		AppProductModel product=productService.getById4App(this.getSessionUserId(),id);
		result.success(true).data(product);
		return result;
	}

	
	/**
	 * 查询全部符合条件的商品
	*/
	@RequiresPermissions("PrdProduct:queryList")
	@ApiOperation(value = "查询商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "商品编号" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "商品名称" , required = false , dataTypeClass=String.class , example = "商品-1"),
		@ApiImplicitParam(name = ProductVOMeta.IS_ON_SHELF , value = "是否上架" , required = false , dataTypeClass=Boolean.class , example = "true"),
		@ApiImplicitParam(name = ProductVOMeta.DETAIL , value = "商品详情" , required = false , dataTypeClass=String.class , example = "这是商品详情"),
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
	 * 分页查询符合条件的商品
	*/
	@RequiresPermissions("PrdProduct:queryPagedList")
	@ApiOperation(value = "分页查询商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "商品编号" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "商品名称" , required = false , dataTypeClass=String.class , example = "商品-1"),
		@ApiImplicitParam(name = ProductVOMeta.IS_ON_SHELF , value = "是否上架" , required = false , dataTypeClass=Boolean.class , example = "true"),
		@ApiImplicitParam(name = ProductVOMeta.DETAIL , value = "商品详情" , required = false , dataTypeClass=String.class , example = "这是商品详情"),
		@ApiImplicitParam(name = ProductVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = ProductServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<Product>> queryPagedList(ProductVO sample) {
		
		if("isOnShelf".equals(sample.getSearchField())) {
			Boolean onShelf=null;
			if("上架".equals(sample.getSearchValue())) {
				onShelf=true;
			}
			if("下架".equals(sample.getSearchValue())) {
				onShelf=false;
			}
			if(onShelf==null) {
				onShelf=DataParser.parseBoolean(sample.getSearchValue());
			}
			sample.setOnShelf(onShelf);
			sample.setSearchField(null).setSearchValue(null);
		}
		
		Result<PagedList<Product>> result=new Result<>();
		PagedList<Product> list=productService.queryPagedList(sample,OrderBy.byDesc(PRD_PRODUCT.CREATE_TIME),sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询符合条件的商品
	 */
	@RequiresPermissions("PrdProduct:queryPagedList4App")
	@ApiOperation(value = "(App)分页查询符合条件的商品")
	@ApiImplicitParams({
			@ApiImplicitParam(name = ProductVOMeta.NAME , value = "商品名称" , required = false , dataTypeClass=String.class , example = "商品-1"),
			@ApiImplicitParam(name = ProductVOMeta.LABEL_IDS , value = "标签ID列表" , required = false , dataTypeClass=List.class , example = "[1,2,4]"),
			@ApiImplicitParam(name = ProductVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
			@ApiImplicitParam(name = ProductVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=7)
	@SentinelResource(value = ProductServiceProxy.QUERY_PAGED_LIST_4_APP, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductServiceProxy.QUERY_PAGED_LIST_4_APP)
	public  Result<PagedList<AppProductModel>> queryPagedList4App(ProductVO sample) {
		Result<PagedList<AppProductModel>> result=new Result<>();
		PagedList<AppProductModel> list=productService.queryPagedEntities4App(this.getSessionUserId(),sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}