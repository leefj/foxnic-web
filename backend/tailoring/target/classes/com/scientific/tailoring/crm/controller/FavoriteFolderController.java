package com.scientific.tailoring.crm.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.crm.FavoriteFolderModel;
import com.scientific.tailoring.domain.crm.FavoriteFolderVO;
import com.scientific.tailoring.domain.crm.FavoriteFolder;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.springboot.mvc.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.proxy.crm.FavoriteFolderServiceProxy;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.scientific.tailoring.domain.crm.meta.FavoriteFolderVOMeta;
import io.swagger.annotations.ApiImplicitParam;

import com.scientific.tailoring.crm.service.IFavoriteFolderService;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-20 03:28:27
*/

@Api(tags = "商品收藏分类")
@ApiSort(1054)
@RestController("CrmFavoriteFolderController")
public class FavoriteFolderController extends SuperController {

	@Autowired
	private IFavoriteFolderService favoriteFolderService;


	/**
	 * 添加商品收藏分类
	 */
	@RequiresPermissions("CrmFavoriteFolder:insert")
	@ApiOperation(value = "添加商品收藏分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavoriteFolderVOMeta.PARENT_ID , value = "上级目录ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.NAME , value = "目录名称" , required = true , dataTypeClass=String.class , example = "春夏款"),
	})
	@ApiOperationSupport(ignoreParameters = {FavoriteFolderVOMeta.PAGE_INDEX , FavoriteFolderVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = FavoriteFolderServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteFolderServiceProxy.INSERT)
	public  Result<FavoriteFolder> insert(FavoriteFolderVO favoriteFolderVO) {
		Result<FavoriteFolder> result=new Result<>();
		favoriteFolderVO.setUserId(this.getSessionUserId());
		boolean suc=favoriteFolderService.insert(favoriteFolderVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除商品收藏分类
	*/
	@RequiresPermissions("CrmFavoriteFolder:deleteById")
	@ApiOperation(value = "删除商品收藏分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavoriteFolderVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = FavoriteFolderVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = FavoriteFolderServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteFolderServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		FavoriteFolder folder=favoriteFolderService.getById(id);
		if(folder==null) {
			return ErrorDesc.failure(CommonError.DATA_NOT_EXISTS);
		}
		Map<Long,Integer> counts=favoriteFolderService.queryProductCountMap(this.getSessionUserId());
		Integer c=counts.get(id);
		if(c!=null && c>0) {
			return ErrorDesc.failure(CommonError.DELETE_NOT_ALLOWED);
		}
		boolean suc=favoriteFolderService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新商品收藏分类
	*/
	@RequiresPermissions("CrmFavoriteFolder:update")
	@ApiOperation(value = "更新商品收藏分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavoriteFolderVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.PARENT_ID , value = "上级目录ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.NAME , value = "目录名称" , required = false , dataTypeClass=String.class , example = "春夏款"),
	})
	@NotNull(name = FavoriteFolderVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {FavoriteFolderVOMeta.PAGE_INDEX , FavoriteFolderVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = FavoriteFolderServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteFolderServiceProxy.UPDATE)
	public  Result<FavoriteFolder> update(FavoriteFolderVO favoriteFolderVO) {
		Result<FavoriteFolder> result=new Result<>();
		boolean suc=favoriteFolderService.update(favoriteFolderVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取商品收藏分类
	*/
	@RequiresPermissions("CrmFavoriteFolder:getById")
	@ApiOperation(value = "按主键获取商品收藏分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavoriteFolderVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.PARENT_ID , value = "上级目录ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.NAME , value = "目录名称" , required = false , dataTypeClass=String.class , example = "春夏款"),
	})
	@NotNull(name = FavoriteFolderVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = FavoriteFolderServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteFolderServiceProxy.GET_BY_ID)
	public  Result<FavoriteFolder> getById(Long id) {
		Result<FavoriteFolder> result=new Result<>();
		FavoriteFolder favoriteFolder=favoriteFolderService.getById(id);
		result.success(true).data(favoriteFolder);
		return result;
	}

	
	/**
	 * 查询全部符合条件的商品收藏分类
	*/
	@RequiresPermissions("CrmFavoriteFolder:queryList")
	@ApiOperation(value = "查询商品收藏分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavoriteFolderVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.PARENT_ID , value = "上级目录ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.NAME , value = "目录名称" , required = false , dataTypeClass=String.class , example = "春夏款"),
	})
	@ApiOperationSupport(ignoreParameters = {FavoriteFolderVOMeta.PAGE_INDEX , FavoriteFolderVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = FavoriteFolderServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteFolderServiceProxy.QUERY_LIST)
	public  Result<List<FavoriteFolder>> queryList(FavoriteFolderVO sample) {
		Result<List<FavoriteFolder>> result=new Result<>();
		sample.setUserId(this.getSessionUserId());
		List<FavoriteFolder> list=favoriteFolderService.queryList(sample);
		Map<Long,Integer> counts=favoriteFolderService.queryProductCountMap(this.getSessionUserId());
		for (int i = 0; i <list.size(); i++) {
			FavoriteFolder f=list.get(i);
			FavoriteFolderModel ffm=f.toPojo(FavoriteFolderModel.class);
			Integer count=counts.get(f.getId());
			ffm.setProductCount(count==null?0:count);
			list.set(i,ffm);
		}
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的商品收藏分类
	*/
	@RequiresPermissions("CrmFavoriteFolder:queryPagedList")
	@ApiOperation(value = "分页查询商品收藏分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavoriteFolderVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.PARENT_ID , value = "上级目录ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.NAME , value = "目录名称" , required = false , dataTypeClass=String.class , example = "春夏款"),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FavoriteFolderVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = FavoriteFolderServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(FavoriteFolderServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<FavoriteFolder>> queryPagedList(FavoriteFolderVO sample) {
		Result<PagedList<FavoriteFolder>> result=new Result<>();
		PagedList<FavoriteFolder> list=favoriteFolderService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}