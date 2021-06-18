package org.github.foxnic.web.oauth.controller;

 
import java.util.List;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.data.PagedList;

import com.github.foxnic.springboot.mvc.Result;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;


import org.github.foxnic.web.proxy.oauth.RoleServiceProxy;
import org.github.foxnic.web.domain.oauth.meta.RoleVOMeta;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.RoleVO;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.oauth.service.IRoleService;
import com.github.foxnic.springboot.api.annotations.NotNull;

/**
 * <p>
 * 角色表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:28
*/

@Api(tags = "角色")
@ApiSort(0)
@RestController("SysRoleController")
public class RoleController {

	@Autowired
	private IRoleService roleService;

	
	/**
	 * 添加角色
	*/
	@ApiOperation(value = "添加角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110352463290923000"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "business_man"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "业务员"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = RoleVOMeta.ID)
	@SentinelResource(value = RoleServiceProxy.INSERT)
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
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110352463290923000")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RoleVOMeta.ID)
	@SentinelResource(value = RoleServiceProxy.DELETE)
	@PostMapping(RoleServiceProxy.DELETE)
	public Result<Role> deleteById(String id) {
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
	@ApiOperationSupport(order=3) 
	@NotNull(name = RoleVOMeta.IDS)
	@SentinelResource(value = RoleServiceProxy.BATCH_DELETE)
	@PostMapping(RoleServiceProxy.BATCH_DELETE)
	public Result<Role> deleteByIds(List<String> ids) {
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
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110352463290923000"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "business_man"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "业务员"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RoleVOMeta.PAGE_INDEX , RoleVOMeta.PAGE_SIZE , RoleVOMeta.SEARCH_FIELD , RoleVOMeta.SEARCH_VALUE , RoleVOMeta.IDS } ) 
	@NotNull(name = RoleVOMeta.ID)
	@SentinelResource(value = RoleServiceProxy.UPDATE)
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
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110352463290923000"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "business_man"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "业务员"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RoleVOMeta.PAGE_INDEX , RoleVOMeta.PAGE_SIZE , RoleVOMeta.SEARCH_FIELD , RoleVOMeta.SEARCH_VALUE , RoleVOMeta.IDS } )
	@NotNull(name = RoleVOMeta.ID)
	@SentinelResource(value = RoleServiceProxy.SAVE)
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
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RoleVOMeta.ID)
	@SentinelResource(value = RoleServiceProxy.GET_BY_ID)
	@PostMapping(RoleServiceProxy.GET_BY_ID)
	public Result<Role> getById(String id) {
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
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110352463290923000"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "business_man"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "业务员"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RoleVOMeta.PAGE_INDEX , RoleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RoleServiceProxy.QUERY_LIST)
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
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110352463290923000"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "business_man"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "业务员"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RoleServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(RoleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Role>> queryPagedList(RoleVO sample) {
		Result<PagedList<Role>> result=new Result<>();
		PagedList<Role> list=roleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}