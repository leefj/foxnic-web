package com.scientific.tailoring.product.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.scientific.tailoring.domain.product.meta.ProductImageVOMeta;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.product.ProductImage;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.product.service.IProductImageService;
import com.scientific.tailoring.proxy.product.ProductImageServiceProxy;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.scientific.tailoring.domain.product.ProductImageVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-22 10:54:31
*/

@Api(tags = "商品图片")
@ApiSort(1104)
@RestController("PrdProductImageController")
public class ProductImageController extends SuperController {

	@Autowired
	private IProductImageService productImageService;

	
	/**
	 * 添加商品图片
	*/
	@RequiresPermissions("PrdProductImage:insert")
	@ApiOperation(value = "添加商品图片")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductImageVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductImageVOMeta.FILE_ID , value = "图片地址" , required = false , dataTypeClass=Long.class , example = "9"),
		@ApiImplicitParam(name = ProductImageVOMeta.IS_CHIEF , value = "是否主图" , required = false , dataTypeClass=Boolean.class , example = "true"),
	})
	@ApiOperationSupport(ignoreParameters = {ProductImageVOMeta.PAGE_INDEX , ProductImageVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = ProductImageServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductImageServiceProxy.INSERT)
	public  Result<ProductImage> insert(ProductImageVO productImageVO) {
		Result<ProductImage> result=new Result<>();
		boolean suc=productImageService.insert(productImageVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除商品图片
	*/
	@RequiresPermissions("PrdProductImage:deleteById")
	@ApiOperation(value = "删除商品图片")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductImageVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = ProductImageVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = ProductImageServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductImageServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=productImageService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新商品图片
	*/
	@RequiresPermissions("PrdProductImage:update")
	@ApiOperation(value = "更新商品图片")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductImageVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductImageVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductImageVOMeta.FILE_ID , value = "图片地址" , required = false , dataTypeClass=Long.class , example = "9"),
		@ApiImplicitParam(name = ProductImageVOMeta.IS_CHIEF , value = "是否主图" , required = false , dataTypeClass=Boolean.class , example = "true"),
	})
	@NotNull(name = ProductImageVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {ProductImageVOMeta.PAGE_INDEX , ProductImageVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = ProductImageServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductImageServiceProxy.UPDATE)
	public  Result<ProductImage> update(ProductImageVO productImageVO) {
		Result<ProductImage> result=new Result<>();
		boolean suc=productImageService.update(productImageVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取商品图片
	*/
	@RequiresPermissions("PrdProductImage:getById")
	@ApiOperation(value = "按主键获取商品图片")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductImageVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = ProductImageVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = ProductImageServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductImageServiceProxy.GET_BY_ID)
	public  Result<ProductImage> getById(Long id) {
		Result<ProductImage> result=new Result<>();
		ProductImage productImage=productImageService.getById(id);
		result.success(true).data(productImage);
		return result;
	}

	
	/**
	 * 查询全部符合条件的商品图片
	*/
	@RequiresPermissions("PrdProductImage:queryList")
	@ApiOperation(value = "查询商品图片")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductImageVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductImageVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductImageVOMeta.FILE_ID , value = "图片地址" , required = false , dataTypeClass=Long.class , example = "9"),
		@ApiImplicitParam(name = ProductImageVOMeta.IS_CHIEF , value = "是否主图" , required = false , dataTypeClass=Boolean.class , example = "true"),
	})
	@ApiOperationSupport(ignoreParameters = {ProductImageVOMeta.PAGE_INDEX , ProductImageVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = ProductImageServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductImageServiceProxy.QUERY_LIST)
	public  Result<List<ProductImage>> queryList(ProductImageVO sample) {
		Result<List<ProductImage>> result=new Result<>();
		List<ProductImage> list=productImageService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的商品图片
	*/
	@RequiresPermissions("PrdProductImage:queryPagedList")
	@ApiOperation(value = "分页查询商品图片")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductImageVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductImageVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductImageVOMeta.FILE_ID , value = "图片地址" , required = false , dataTypeClass=Long.class , example = "9"),
		@ApiImplicitParam(name = ProductImageVOMeta.IS_CHIEF , value = "是否主图" , required = false , dataTypeClass=Boolean.class , example = "true"),
		@ApiImplicitParam(name = ProductImageVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductImageVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = ProductImageServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductImageServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<ProductImage>> queryPagedList(ProductImageVO sample) {
		Result<PagedList<ProductImage>> result=new Result<>();
		PagedList<ProductImage> list=productImageService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}