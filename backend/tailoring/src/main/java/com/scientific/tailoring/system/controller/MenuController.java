package com.scientific.tailoring.system.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONArray;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.scientific.tailoring.domain.system.Menu;
import com.scientific.tailoring.domain.system.MenuNodeModel;
import com.scientific.tailoring.domain.system.MenuVO;
import com.scientific.tailoring.domain.system.meta.MenuVOMeta;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.proxy.system.MenuServiceProxy;
import com.scientific.tailoring.system.service.IMenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @author 李方捷
 * @since 2021-03-18 11:06:17
*/

@Api(tags = "功能菜单")
@ApiSort(1005)
@RestController("SysMenuController")
public class MenuController extends SuperController {

	@Autowired
	private IMenuService menuService;

	
	/**
	 * 添加功能菜单
	*/
	@RequiresPermissions("SysMenu:insert")
	@ApiOperation(value = "添加功能菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ICON , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.CSS , value = "样式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "系统管理"),
		@ApiImplicitParam(name = MenuVOMeta.TYPE , value = "菜单类型" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MenuVOMeta.PATH , value = "模版路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.URL , value = "路由地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = MenuVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {MenuVOMeta.PAGE_INDEX , MenuVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = MenuServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MenuServiceProxy.INSERT)
	public  Result<Menu> insert(MenuVO menuVO) {
		Result<Menu> result=new Result<>();
		boolean suc=menuService.insert(menuVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除功能菜单
	*/
	@RequiresPermissions("SysMenu:deleteById")
	@ApiOperation(value = "删除功能菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = MenuVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = MenuServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MenuServiceProxy.DELETE)
	public  Result deleteById(Integer id) {
		Result result=new Result();
		boolean suc=menuService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新功能菜单
	*/
	@RequiresPermissions("SysMenu:update")
	@ApiOperation(value = "更新功能菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = MenuVOMeta.ICON , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.CSS , value = "样式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "系统管理"),
		@ApiImplicitParam(name = MenuVOMeta.TYPE , value = "菜单类型" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MenuVOMeta.PATH , value = "模版路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.URL , value = "路由地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
	})
	@NotNull(name = MenuVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {MenuVOMeta.PAGE_INDEX , MenuVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = MenuServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MenuServiceProxy.UPDATE)
	public  Result<Menu> update(MenuVO menuVO) {
		Result<Menu> result=new Result<>();
		boolean suc=menuService.update(menuVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取功能菜单
	*/
	@RequiresPermissions("SysMenu:getById")
	@ApiOperation(value = "按主键获取功能菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = MenuVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = MenuServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MenuServiceProxy.GET_BY_ID)
	public  Result<Menu> getById(Integer id) {
		Result<Menu> result=new Result<>();
		Menu menu=menuService.getById(id);
		result.success(true).data(menu);
		return result;
	}

	
	/**
	 * 查询全部符合条件的功能菜单
	*/
	@RequiresPermissions("SysMenu:queryList")
	@ApiOperation(value = "查询功能菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "id" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = MenuVOMeta.ICON , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.CSS , value = "样式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "系统管理"),
		@ApiImplicitParam(name = MenuVOMeta.TYPE , value = "菜单类型" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MenuVOMeta.PATH , value = "模版路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.URL , value = "路由地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(ignoreParameters = {MenuVOMeta.PAGE_INDEX , MenuVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = MenuServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MenuServiceProxy.QUERY_LIST)
	public  Result<List<Menu>> queryList(MenuVO sample) {
		Result<List<Menu>> result=new Result<>();
		List<Menu> list=menuService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的功能菜单
	*/
	@RequiresPermissions("SysMenu:queryPagedList")
	@ApiOperation(value = "分页查询功能菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "id" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = MenuVOMeta.ICON , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.CSS , value = "样式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "系统管理"),
		@ApiImplicitParam(name = MenuVOMeta.TYPE , value = "菜单类型" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MenuVOMeta.PATH , value = "模版路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.URL , value = "路由地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MenuVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MenuVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = MenuServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MenuServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<Menu>> queryPagedList(MenuVO sample) {
		Result<PagedList<Menu>> result=new Result<>();
		PagedList<Menu> list=menuService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 获取菜单树形结构
	 */
	@RequiresPermissions("SysMenu:getMenuTree")
	@ApiOperation(value = "获取菜单树形结构")
	@ApiOperationSupport(order=7)
	@PostMapping(MenuServiceProxy.API_PREFIX+"/get-menu-tree")
	public  Result<List<MenuNodeModel>> getMenuTree() {
		Result<List<MenuNodeModel>> result=new Result<>();
		List<MenuNodeModel> roots=menuService.getMenuTree(this.getSessionUserId());
		return ErrorDesc.success(result).data(roots);
	}




}