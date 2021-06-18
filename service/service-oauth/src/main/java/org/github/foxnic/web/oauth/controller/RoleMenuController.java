package org.github.foxnic.web.oauth.controller;

 
import java.util.List;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.data.PagedList;

import com.github.foxnic.springboot.mvc.Result;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;


import org.github.foxnic.web.proxy.oauth.RoleMenuServiceProxy;
import org.github.foxnic.web.domain.oauth.meta.RoleMenuVOMeta;
import org.github.foxnic.web.domain.oauth.RoleMenu;
import org.github.foxnic.web.domain.oauth.RoleMenuVO;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.oauth.service.IRoleMenuService;
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
@RestController("SysRoleMenuController")
public class RoleMenuController {

	@Autowired
	private IRoleMenuService roleMenuService;

	
	/**
	 * 添加角色账户关系
	*/
	@ApiOperation(value = "添加角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleMenuVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "451739190648897536"),
		@ApiImplicitParam(name = RoleMenuVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = RoleMenuVOMeta.MENU_ID , value = "菜单ID" , required = false , dataTypeClass=String.class , example = "451739184575545344"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = RoleMenuVOMeta.ID)
	@SentinelResource(value = RoleMenuServiceProxy.INSERT)
	@PostMapping(RoleMenuServiceProxy.INSERT)
	public Result<RoleMenu> insert(RoleMenuVO roleMenuVO) {
		Result<RoleMenu> result=new Result<>();
		boolean suc=roleMenuService.insert(roleMenuVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除角色账户关系
	*/
	@ApiOperation(value = "删除角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleMenuVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "451739190648897536")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RoleMenuVOMeta.ID)
	@SentinelResource(value = RoleMenuServiceProxy.DELETE)
	@PostMapping(RoleMenuServiceProxy.DELETE)
	public Result<RoleMenu> deleteById(String id) {
		Result<RoleMenu> result=new Result<>();
		boolean suc=roleMenuService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除角色账户关系 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleMenuVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RoleMenuVOMeta.IDS)
	@SentinelResource(value = RoleMenuServiceProxy.BATCH_DELETE)
	@PostMapping(RoleMenuServiceProxy.BATCH_DELETE)
	public Result<RoleMenu> deleteByIds(List<String> ids) {
		Result<RoleMenu> result=new Result<>();
		boolean suc=roleMenuService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新角色账户关系
	*/
	@ApiOperation(value = "更新角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleMenuVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "451739190648897536"),
		@ApiImplicitParam(name = RoleMenuVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = RoleMenuVOMeta.MENU_ID , value = "菜单ID" , required = false , dataTypeClass=String.class , example = "451739184575545344"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RoleMenuVOMeta.PAGE_INDEX , RoleMenuVOMeta.PAGE_SIZE , RoleMenuVOMeta.SEARCH_FIELD , RoleMenuVOMeta.SEARCH_VALUE , RoleMenuVOMeta.IDS } ) 
	@NotNull(name = RoleMenuVOMeta.ID)
	@SentinelResource(value = RoleMenuServiceProxy.UPDATE)
	@PostMapping(RoleMenuServiceProxy.UPDATE)
	public Result<RoleMenu> update(RoleMenuVO roleMenuVO) {
		Result<RoleMenu> result=new Result<>();
		boolean suc=roleMenuService.update(roleMenuVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存角色账户关系
	*/
	@ApiOperation(value = "保存角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleMenuVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "451739190648897536"),
		@ApiImplicitParam(name = RoleMenuVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = RoleMenuVOMeta.MENU_ID , value = "菜单ID" , required = false , dataTypeClass=String.class , example = "451739184575545344"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RoleMenuVOMeta.PAGE_INDEX , RoleMenuVOMeta.PAGE_SIZE , RoleMenuVOMeta.SEARCH_FIELD , RoleMenuVOMeta.SEARCH_VALUE , RoleMenuVOMeta.IDS } )
	@NotNull(name = RoleMenuVOMeta.ID)
	@SentinelResource(value = RoleMenuServiceProxy.SAVE)
	@PostMapping(RoleMenuServiceProxy.SAVE)
	public Result<RoleMenu> save(RoleMenuVO roleMenuVO) {
		Result<RoleMenu> result=new Result<>();
		boolean suc=roleMenuService.save(roleMenuVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取角色账户关系
	*/
	@ApiOperation(value = "获取角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleMenuVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RoleMenuVOMeta.ID)
	@SentinelResource(value = RoleMenuServiceProxy.GET_BY_ID)
	@PostMapping(RoleMenuServiceProxy.GET_BY_ID)
	public Result<RoleMenu> getById(String id) {
		Result<RoleMenu> result=new Result<>();
		RoleMenu role=roleMenuService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询角色账户关系
	*/
	@ApiOperation(value = "查询角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleMenuVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "451739190648897536"),
		@ApiImplicitParam(name = RoleMenuVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = RoleMenuVOMeta.MENU_ID , value = "菜单ID" , required = false , dataTypeClass=String.class , example = "451739184575545344"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RoleMenuVOMeta.PAGE_INDEX , RoleMenuVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RoleMenuServiceProxy.QUERY_LIST)
	@PostMapping(RoleMenuServiceProxy.QUERY_LIST)
	public Result<List<RoleMenu>> queryList(RoleMenuVO sample) {
		Result<List<RoleMenu>> result=new Result<>();
		List<RoleMenu> list=roleMenuService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询角色账户关系
	*/
	@ApiOperation(value = "分页查询角色账户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleMenuVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class , example = "451739190648897536"),
		@ApiImplicitParam(name = RoleMenuVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = RoleMenuVOMeta.MENU_ID , value = "菜单ID" , required = false , dataTypeClass=String.class , example = "451739184575545344"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RoleMenuServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(RoleMenuServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RoleMenu>> queryPagedList(RoleMenuVO sample) {
		Result<PagedList<RoleMenu>> result=new Result<>();
		PagedList<RoleMenu> list=roleMenuService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}