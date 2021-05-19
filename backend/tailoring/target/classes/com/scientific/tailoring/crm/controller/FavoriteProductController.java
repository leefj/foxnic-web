package com.scientific.tailoring.crm.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotBlank;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.crm.FavoriteProduct;
import com.scientific.tailoring.domain.crm.FavoriteProductModel;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.domain.crm.FavoriteProductVO;
import com.scientific.tailoring.domain.crm.meta.FavoriteProductVOMeta;
import com.github.foxnic.springboot.mvc.Result;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;

import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.proxy.crm.FavoriteProductServiceProxy;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.crm.service.IFavoriteProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-21 04:56:38
*/

@Api(tags = "商品收藏")
@ApiSort(1055)
@RestController("CrmFavoriteProductController")
public class FavoriteProductController extends SuperController {

	@Autowired
	private IFavoriteProductService favoriteProductService;

	
	/**
	 * 添加商品收藏
	*/
	@RequiresPermissions("CrmFavoriteProduct:insert")
	@ApiOperation(value = "添加商品收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavoriteProductVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.PRODUCT_ID , value = "商品ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.FABRIC_ID , value = "材料ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.FOLDER_ID , value = "目录ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@ApiOperationSupport(ignoreParameters = {FavoriteProductVOMeta.PAGE_INDEX , FavoriteProductVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = FavoriteProductServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteProductServiceProxy.INSERT)
	public  Result<FavoriteProduct> insert(FavoriteProductVO favoriteProductVO) {
		Result<FavoriteProduct> result=new Result<>();
		favoriteProductVO.setUserId(this.getSessionUserId());
		boolean suc=favoriteProductService.insert(favoriteProductVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除商品收藏
	*/
	@RequiresPermissions("CrmFavoriteProduct:deleteById")
	@ApiOperation(value = "删除商品收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavoriteProductVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.USER_ID , value = "用户ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.PRODUCT_ID , value = "商品ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.FABRIC_ID , value = "材料ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.FOLDER_ID , value = "目录ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = FavoriteProductVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = FavoriteProductServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteProductServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=favoriteProductService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新商品收藏
	*/
	@RequiresPermissions("CrmFavoriteProduct:update")
	@ApiOperation(value = "更新商品收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavoriteProductVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.FABRIC_ID , value = "材料ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.FOLDER_ID , value = "目录ID" , required = false , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = FavoriteProductVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {FavoriteProductVOMeta.PAGE_INDEX , FavoriteProductVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = FavoriteProductServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteProductServiceProxy.UPDATE)
	public  Result<FavoriteProduct> update(FavoriteProductVO favoriteProductVO) {
		Result<FavoriteProduct> result=new Result<>();
		boolean suc=favoriteProductService.update(favoriteProductVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取商品收藏
	*/
	@RequiresPermissions("CrmFavoriteProduct:getById")
	@ApiOperation(value = "按主键获取商品收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavoriteProductVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.FABRIC_ID , value = "材料ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.FOLDER_ID , value = "目录ID" , required = false , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = FavoriteProductVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = FavoriteProductServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteProductServiceProxy.GET_BY_ID)
	public  Result<FavoriteProduct> getById(Long id) {
		Result<FavoriteProduct> result=new Result<>();
		FavoriteProduct favoriteProduct=favoriteProductService.getById(id);
		result.success(true).data(favoriteProduct);
		return result;
	}

	
	/**
	 * 查询全部符合条件的商品收藏
	*/
	@RequiresPermissions("CrmFavoriteProduct:queryList")
	@ApiOperation(value = "查询商品收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavoriteProductVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.FABRIC_ID , value = "材料ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.FOLDER_ID , value = "目录ID" , required = false , dataTypeClass=Long.class , example = "1"),
	})
	@ApiOperationSupport(ignoreParameters = {FavoriteProductVOMeta.PAGE_INDEX , FavoriteProductVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = FavoriteProductServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteProductServiceProxy.QUERY_LIST)
	public  Result<List<FavoriteProduct>> queryList(FavoriteProductVO sample) {
		Result<List<FavoriteProduct>> result=new Result<>();
		List<FavoriteProduct> list=favoriteProductService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的商品收藏
	*/
	@RequiresPermissions("CrmFavoriteProduct:queryPagedList")
	@ApiOperation(value = "分页查询商品收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavoriteProductVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.FABRIC_ID , value = "材料ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.FOLDER_ID , value = "目录ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteProductVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FavoriteProductVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = FavoriteProductServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteProductServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<FavoriteProduct>> queryPagedList(FavoriteProductVO sample) {
		Result<PagedList<FavoriteProduct>> result=new Result<>();
		PagedList<FavoriteProduct> list=favoriteProductService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 查询全部符合条件的商品收藏(关联产品信息)
	 */
	@RequiresPermissions("CrmFavoriteProduct:queryList4App")
	@ApiOperation(value = "查询全部符合条件的商品收藏")
	@ApiImplicitParams({
			@ApiImplicitParam(name = FavoriteProductVOMeta.FOLDER_ID , value = "目录ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotBlank(name = FavoriteProductVOMeta.FOLDER_ID)
	@ApiOperationSupport(ignoreParameters = {FavoriteProductVOMeta.PAGE_INDEX , FavoriteProductVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = FavoriteProductServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteProductServiceProxy.QUERY_LIST_4_APP)
	public  Result<List<FavoriteProductModel>> queryList4App(FavoriteProductVO sample) {
		Result<List<FavoriteProductModel>> result=new Result<>();
		List<FavoriteProductModel> list=favoriteProductService.queryEntities4App(this.getSessionUserId(),sample.getFolderId());
		result.success(true).data(list);
		return result;
	}


}