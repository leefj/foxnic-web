package org.github.foxnic.web.oauth.controller;

 
import java.util.List;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.data.PagedList;

import com.github.foxnic.api.transter.Result;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;


import org.github.foxnic.web.proxy.oauth.RoleUserServiceProxy;
import org.github.foxnic.web.domain.oauth.meta.RoleUserVOMeta;
import org.github.foxnic.web.domain.oauth.RoleUser;
import org.github.foxnic.web.domain.oauth.RoleUserVO;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.oauth.service.IRoleUserService;
import com.github.foxnic.springboot.api.annotations.NotNull;

/**
 * <p>
 * 角色账户关系表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:29
*/

@Api(tags = "角色账户关系")
@ApiSort(0)
@RestController("SysRoleUserController")
public class RoleUserController {

	@Autowired
	private IRoleUserService roleUserService;

	
	/**
	 * 添加角色账户关系
	*/
	@ApiOperation(value = "添加角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleUserVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "450603006358978560"),
		@ApiImplicitParam(name = RoleUserVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = RoleUserVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = RoleUserVOMeta.ID)
	@SentinelResource(value = RoleUserServiceProxy.INSERT)
	@PostMapping(RoleUserServiceProxy.INSERT)
	public Result<RoleUser> insert(RoleUserVO roleUserVO) {
		Result<RoleUser> result=new Result<>();
		boolean suc=roleUserService.insert(roleUserVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除角色账户关系
	*/
	@ApiOperation(value = "删除角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleUserVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "450603006358978560")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RoleUserVOMeta.ID)
	@SentinelResource(value = RoleUserServiceProxy.DELETE)
	@PostMapping(RoleUserServiceProxy.DELETE)
	public Result<RoleUser> deleteById(String id) {
		Result<RoleUser> result=new Result<>();
		boolean suc=roleUserService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除角色账户关系 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RoleUserVOMeta.IDS)
	@SentinelResource(value = RoleUserServiceProxy.BATCH_DELETE)
	@PostMapping(RoleUserServiceProxy.BATCH_DELETE)
	public Result<RoleUser> deleteByIds(List<String> ids) {
		Result<RoleUser> result=new Result<>();
		boolean suc=roleUserService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新角色账户关系
	*/
	@ApiOperation(value = "更新角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleUserVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "450603006358978560"),
		@ApiImplicitParam(name = RoleUserVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = RoleUserVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RoleUserVOMeta.PAGE_INDEX , RoleUserVOMeta.PAGE_SIZE , RoleUserVOMeta.SEARCH_FIELD , RoleUserVOMeta.SEARCH_VALUE , RoleUserVOMeta.IDS } ) 
	@NotNull(name = RoleUserVOMeta.ID)
	@SentinelResource(value = RoleUserServiceProxy.UPDATE)
	@PostMapping(RoleUserServiceProxy.UPDATE)
	public Result<RoleUser> update(RoleUserVO roleUserVO) {
		Result<RoleUser> result=new Result<>();
		boolean suc=roleUserService.update(roleUserVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存角色账户关系
	*/
	@ApiOperation(value = "保存角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleUserVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "450603006358978560"),
		@ApiImplicitParam(name = RoleUserVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = RoleUserVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RoleUserVOMeta.PAGE_INDEX , RoleUserVOMeta.PAGE_SIZE , RoleUserVOMeta.SEARCH_FIELD , RoleUserVOMeta.SEARCH_VALUE , RoleUserVOMeta.IDS } )
	@NotNull(name = RoleUserVOMeta.ID)
	@SentinelResource(value = RoleUserServiceProxy.SAVE)
	@PostMapping(RoleUserServiceProxy.SAVE)
	public Result<RoleUser> save(RoleUserVO roleUserVO) {
		Result<RoleUser> result=new Result<>();
		boolean suc=roleUserService.save(roleUserVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取角色账户关系
	*/
	@ApiOperation(value = "获取角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RoleUserVOMeta.ID)
	@SentinelResource(value = RoleUserServiceProxy.GET_BY_ID)
	@PostMapping(RoleUserServiceProxy.GET_BY_ID)
	public Result<RoleUser> getById(String id) {
		Result<RoleUser> result=new Result<>();
		RoleUser role=roleUserService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询角色账户关系
	*/
	@ApiOperation(value = "查询角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleUserVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "450603006358978560"),
		@ApiImplicitParam(name = RoleUserVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = RoleUserVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RoleUserVOMeta.PAGE_INDEX , RoleUserVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RoleUserServiceProxy.QUERY_LIST)
	@PostMapping(RoleUserServiceProxy.QUERY_LIST)
	public Result<List<RoleUser>> queryList(RoleUserVO sample) {
		Result<List<RoleUser>> result=new Result<>();
		List<RoleUser> list=roleUserService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询角色账户关系
	*/
	@ApiOperation(value = "分页查询角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleUserVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "450603006358978560"),
		@ApiImplicitParam(name = RoleUserVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = RoleUserVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RoleUserServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(RoleUserServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RoleUser>> queryPagedList(RoleUserVO sample) {
		Result<PagedList<RoleUser>> result=new Result<>();
		PagedList<RoleUser> list=roleUserService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}