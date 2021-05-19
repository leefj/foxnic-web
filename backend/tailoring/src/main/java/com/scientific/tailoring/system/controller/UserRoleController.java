package com.scientific.tailoring.system.controller;
import com.scientific.tailoring.system.service.IUserRoleService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.scientific.tailoring.domain.system.UserRole;
import com.github.foxnic.dao.data.PagedList;

import io.swagger.annotations.Api;
import com.scientific.tailoring.domain.system.UserRoleVO;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.springboot.mvc.Result;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.scientific.tailoring.domain.system.meta.UserRoleVOMeta;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.proxy.system.UserRoleServiceProxy;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-30 01:30:12
*/

@Api(tags = "用户角色关系")
@ApiSort(1001)
@RestController("SysUserRoleController")
public class UserRoleController extends SuperController {

	@Autowired
	private IUserRoleService userRoleService;

	
	/**
	 * 添加用户角色关系
	*/
	@RequiresPermissions("SysUserRole:insert")
	@ApiOperation(value = "添加用户角色关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserRoleVOMeta.USER_ID , value = "用户ID" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = UserRoleVOMeta.ROLE_ID , value = "角色ID" , required = true , dataTypeClass=Integer.class),
	})
	@NotNull(name = UserRoleVOMeta.USER_ID)
	@NotNull(name = UserRoleVOMeta.ROLE_ID)
	@ApiOperationSupport(order=1)
	@SentinelResource(value = UserRoleServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserRoleServiceProxy.INSERT)
	public  Result<UserRole> insert(UserRoleVO userRoleVO) {
		Result<UserRole> result=new Result<>();
		boolean suc=userRoleService.insert(userRoleVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除用户角色关系
	*/
	@RequiresPermissions("SysUserRole:deleteById")
	@ApiOperation(value = "删除用户角色关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserRoleVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class),
	})
	@NotNull(name = UserRoleVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = UserRoleServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserRoleServiceProxy.DELETE)
	public  Result deleteById(Integer id) {
		Result result=new Result();
		boolean suc=userRoleService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新用户角色关系
	*/
	@RequiresPermissions("SysUserRole:update")
	@ApiOperation(value = "更新用户角色关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserRoleVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = UserRoleVOMeta.USER_ID , value = "用户ID" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = UserRoleVOMeta.ROLE_ID , value = "角色ID" , required = true , dataTypeClass=Integer.class),
	})
	@NotNull(name = UserRoleVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {UserRoleVOMeta.PAGE_INDEX , UserRoleVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = UserRoleServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserRoleServiceProxy.UPDATE)
	public  Result<UserRole> update(UserRoleVO userRoleVO) {
		Result<UserRole> result=new Result<>();
		boolean suc=userRoleService.update(userRoleVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取用户角色关系
	*/
	@RequiresPermissions("SysUserRole:getById")
	@ApiOperation(value = "按主键获取用户角色关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserRoleVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class),
	})
	@NotNull(name = UserRoleVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = UserRoleServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserRoleServiceProxy.GET_BY_ID)
	public  Result<UserRole> getById(Integer id) {
		Result<UserRole> result=new Result<>();
		UserRole userRole=userRoleService.getById(id);
		result.success(true).data(userRole);
		return result;
	}

	
	/**
	 * 查询全部符合条件的用户角色关系
	*/
	@RequiresPermissions("SysUserRole:queryList")
	@ApiOperation(value = "查询用户角色关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserRoleVOMeta.ID , value = "编号" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = UserRoleVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = UserRoleVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(ignoreParameters = {UserRoleVOMeta.PAGE_INDEX , UserRoleVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = UserRoleServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserRoleServiceProxy.QUERY_LIST)
	public  Result<List<UserRole>> queryList(UserRoleVO sample) {
		Result<List<UserRole>> result=new Result<>();
		List<UserRole> list=userRoleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的用户角色关系
	*/
	@RequiresPermissions("SysUserRole:queryPagedList")
	@ApiOperation(value = "分页查询用户角色关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserRoleVOMeta.ID , value = "编号" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = UserRoleVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = UserRoleVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = UserRoleVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = UserRoleVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = UserRoleServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserRoleServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<UserRole>> queryPagedList(UserRoleVO sample) {
		Result<PagedList<UserRole>> result=new Result<>();
		PagedList<UserRole> list=userRoleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}