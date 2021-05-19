package com.scientific.tailoring.product.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT_FABRIC;
import com.scientific.tailoring.domain.product.Fabric;
import com.scientific.tailoring.domain.product.ProductFabric;
import com.scientific.tailoring.domain.product.ProductFabricModel;
import com.scientific.tailoring.domain.product.ProductFabricVO;
import com.scientific.tailoring.domain.product.meta.FabricVOMeta;
import com.scientific.tailoring.domain.product.meta.ProductFabricVOMeta;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.misc.FormSeletOption;
import com.scientific.tailoring.product.service.IProductFabricService;
import com.scientific.tailoring.proxy.product.FabricServiceProxy;
import com.scientific.tailoring.proxy.product.ProductFabricServiceProxy;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @author 李方捷
 * @since 2021-03-22 11:00:38
*/

@Api(tags = "商品面料关系")
@ApiSort(1103)
@RestController("PrdProductFabricController")
public class ProductFabricController extends SuperController {

	@Autowired
	private IProductFabricService productFabricService;

	
	/**
	 * 添加商品面料关系
	*/
	@RequiresPermissions("PrdProductFabric:insert")
	@ApiOperation(value = "添加商品面料关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFabricVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductFabricVOMeta.FABRIC_ID , value = "标签ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ProductFabricVOMeta.EFFECT_ID , value = "效果图" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductFabricVOMeta.VIRTUAL_ID , value = "虚拟试衣ID" , required = false , dataTypeClass=Long.class),
	})
	@ApiOperationSupport(ignoreParameters = {ProductFabricVOMeta.PAGE_INDEX , ProductFabricVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = ProductFabricServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductFabricServiceProxy.INSERT)
	public  Result<ProductFabric> insert(ProductFabricVO productFabricVO) {
		Result<ProductFabric> result=new Result<>();
		boolean ex=productFabricService.checkExists(productFabricVO, PRD_PRODUCT_FABRIC.PRODUCT_ID,PRD_PRODUCT_FABRIC.FABRIC_ID);
		if(ex) {
			return ErrorDesc.failure(CommonError.DATA_REPETITION);
		}
		boolean suc=productFabricService.insert(productFabricVO);
		if(!suc) {
			result.message(languageService.translate("虚拟试衣库未配置"));
		}
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除商品面料关系
	*/
	@RequiresPermissions("PrdProductFabric:deleteById")
	@ApiOperation(value = "删除商品面料关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFabricVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = ProductFabricVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = ProductFabricServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductFabricServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=productFabricService.deleteByIdPhysical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 按主键批量删除面料
	*/
	@RequiresPermissions("PrdFabric:deleteByIds")
	@ApiOperation(value = "按主键批量删除商品面料")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FabricVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class , example = "1")
	})
	@NotNull(name = FabricVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = FabricServiceProxy.BATCH_DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductFabricServiceProxy.BATCH_DELETE)
	public  Result deleteByIds(List<Integer> id) {
		Result result=new Result();
		boolean suc=productFabricService.deleteByIdsPhysical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新商品面料关系
	*/
	@RequiresPermissions("PrdProductFabric:update")
	@ApiOperation(value = "更新商品面料关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFabricVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductFabricVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductFabricVOMeta.FABRIC_ID , value = "标签ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ProductFabricVOMeta.EFFECT_ID , value = "效果图" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductFabricVOMeta.VIRTUAL_ID , value = "虚拟试衣ID" , required = false , dataTypeClass=Long.class),
	})
	@NotNull(name = ProductFabricVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {ProductFabricVOMeta.PAGE_INDEX , ProductFabricVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = ProductFabricServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductFabricServiceProxy.UPDATE)
	public  Result<ProductFabric> update(ProductFabricVO productFabricVO) {
		Result<ProductFabric> result=new Result<>();
		boolean suc=productFabricService.update(productFabricVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取商品面料关系
	*/
	@RequiresPermissions("PrdProductFabric:getById")
	@ApiOperation(value = "按主键获取商品面料关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFabricVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = ProductFabricVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = ProductFabricServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductFabricServiceProxy.GET_BY_ID)
	public  Result<ProductFabric> getById(Long id) {
		Result<ProductFabric> result=new Result<>();
		ProductFabric productFabric=productFabricService.getById(id);
		result.success(true).data(productFabric);
		return result;
	}

	
	/**
	 * 查询全部符合条件的商品面料关系
	*/
	@RequiresPermissions("PrdProductFabric:queryList")
	@ApiOperation(value = "查询商品面料关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFabricVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductFabricVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductFabricVOMeta.FABRIC_ID , value = "标签ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ProductFabricVOMeta.EFFECT_ID , value = "效果图" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductFabricVOMeta.VIRTUAL_ID , value = "虚拟试衣ID" , required = false , dataTypeClass=Long.class),
	})
	@ApiOperationSupport(ignoreParameters = {ProductFabricVOMeta.PAGE_INDEX , ProductFabricVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = ProductFabricServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductFabricServiceProxy.QUERY_LIST)
	public  Result<List<ProductFabric>> queryList(ProductFabricVO sample) {
		Result<List<ProductFabric>> result=new Result<>();
		List<ProductFabric> list=productFabricService.queryList(sample);
		result.success(true).data(list);
		return result;
	}
	
	
	
	/**
	 * 查询全部符合条件的商品面料关系
	*/
	//@RequiresPermissions("PrdProductFabric:queryList")
	@ApiOperation(value = "查询全部符合条件的商品面料关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFabricVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
	})
	@ApiOperationSupport(ignoreParameters = {ProductFabricVOMeta.PAGE_INDEX , ProductFabricVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = ProductFabricServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@RequestMapping(ProductFabricServiceProxy.QUERY_CHOOSE_LIST)
	public  Result<List<FormSeletOption>> queryChooseList(ProductFabricVO sample) {
		String keyword=this.getParameter().getString("keyword");
		Result<List<FormSeletOption>> result=new Result<>();
		List<Fabric> list=productFabricService.queryUnusedFabrics(sample.getProductId(),keyword);
		List<FormSeletOption> options=FormSeletOption.collect(list, Fabric::getShortName, Fabric::getId);
		result.success(true).data(options);
		return result;
	}

	
	/**
	 * 分页查询符合条件的商品面料关系
	*/
	@RequiresPermissions("PrdProductFabric:queryPagedList")
	@ApiOperation(value = "分页查询商品面料关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFabricVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductFabricVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = ProductFabricVOMeta.FABRIC_ID , value = "标签ID" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ProductFabricVOMeta.EFFECT_ID , value = "效果图" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductFabricVOMeta.VIRTUAL_ID , value = "虚拟试衣ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = ProductFabricVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductFabricVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = ProductFabricServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ProductFabricServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<ProductFabricModel>> queryPagedList(ProductFabricVO sample) {
		Result<PagedList<ProductFabricModel>> result=new Result<>();
		PagedList<ProductFabricModel> list=productFabricService.queryPagedListByProduct(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}