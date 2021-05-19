package com.scientific.tailoring.system.controller;

 
import java.util.List;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.proxy.system.RoleServiceProxy;
import com.scientific.tailoring.domain.system.meta.RoleVOMeta;
import com.scientific.tailoring.domain.system.Role;
import com.scientific.tailoring.domain.system.RoleVO;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.scientific.tailoring.system.service.IRoleService;
import com.github.foxnic.springboot.api.annotations.NotNull;

/**
 * <p>
 * 角色表 接口控制器
 * </p>
 * @author 李方捷
 * @since 2021-04-29 02:38:17
*/

@Api(tags = "角色")
@ApiSort(0)
@RestController("SysRoleController")
public class RoleController extends SuperController {

	@Autowired
	private IRoleService roleService;

	
	/**
	 * 添加角色
	*/
	@ApiOperation(value = "添加角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "管理员"),
		@ApiImplicitParam(name = RoleVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class , example = "1"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = RoleVOMeta.CODE)
	@SentinelResource(value = RoleServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(RoleServiceProxy.INSERT)
	public Result<Role> insert(RoleVO roleVO) {
		Result<Role> result=new Result<>();
		boolean suc=roleService.insert(roleVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除角色
	*/
	@ApiOperation(value = "删除角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RoleVOMeta.ID)
	@SentinelResource(value = RoleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(RoleServiceProxy.DELETE)
	public Result<Role> deleteById(Integer id) {
		Result<Role> result=new Result<>();
		boolean suc=roleService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除角色 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@NotNull(name = RoleVOMeta.IDS)
	@ApiOperationSupport(order=3)
	@SentinelResource(value = RoleServiceProxy.BATCH_DELETE , blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(RoleServiceProxy.BATCH_DELETE)
	public Result<Role> deleteByIds(List<Integer> ids) {
		Result<Role> result=new Result<>();
		boolean suc=roleService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新角色
	*/
	@ApiOperation(value = "更新角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "管理员"),
		@ApiImplicitParam(name = RoleVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class , example = "1"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RoleVOMeta.PAGE_INDEX , RoleVOMeta.PAGE_SIZE , RoleVOMeta.SEARCH_FIELD , RoleVOMeta.SEARCH_VALUE , RoleVOMeta.IDS } ) 
	@NotNull(name = RoleVOMeta.ID)
	@NotNull(name = RoleVOMeta.CODE)
	@SentinelResource(value = RoleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(RoleServiceProxy.UPDATE)
	public Result<Role> update(RoleVO roleVO) {
		Result<Role> result=new Result<>();
		boolean suc=roleService.update(roleVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存角色
	*/
	@ApiOperation(value = "保存角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "管理员"),
		@ApiImplicitParam(name = RoleVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RoleVOMeta.PAGE_INDEX , RoleVOMeta.PAGE_SIZE , RoleVOMeta.SEARCH_FIELD , RoleVOMeta.SEARCH_VALUE , RoleVOMeta.IDS } )
	@NotNull(name = RoleVOMeta.ID)
	@NotNull(name = RoleVOMeta.CODE)
	@SentinelResource(value = RoleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(RoleServiceProxy.SAVE)
	public Result<Role> save(RoleVO roleVO) {
		Result<Role> result=new Result<>();
		boolean suc=roleService.save(roleVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取角色
	*/
	@ApiOperation(value = "获取角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RoleVOMeta.ID)
	@SentinelResource(value = RoleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(RoleServiceProxy.GET_BY_ID)
	public Result<Role> getById(Integer id) {
		Result<Role> result=new Result<>();
		Role role=roleService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询角色
	*/
	@ApiOperation(value = "查询角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "管理员"),
		@ApiImplicitParam(name = RoleVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RoleVOMeta.PAGE_INDEX , RoleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RoleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(RoleServiceProxy.QUERY_LIST)
	public Result<List<Role>> queryList(RoleVO sample) {
		Result<List<Role>> result=new Result<>();
		List<Role> list=roleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询角色
	*/
	@ApiOperation(value = "分页查询角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "管理员"),
		@ApiImplicitParam(name = RoleVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class , example = "1"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RoleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(RoleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Role>> queryPagedList(RoleVO sample) {
		Result<PagedList<Role>> result=new Result<>();
		PagedList<Role> list=roleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}