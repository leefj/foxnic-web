package org.github.foxnic.web.oauth.controller;

 
import java.util.List;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;


import org.github.foxnic.web.proxy.oauth.MenuServiceProxy;
import org.github.foxnic.web.domain.oauth.meta.MenuVOMeta;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.MenuVO;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.oauth.service.IMenuService;
import com.github.foxnic.springboot.api.annotations.NotNull;

/**
 * <p>
 * 菜单表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 10:53:35
*/

@Api(tags = "菜单")
@ApiSort(0)
@RestController("SysMenuController")
public class MenuController {

	@Autowired
	private IMenuService menuService;

	
	/**
	 * 添加菜单
	*/
	@ApiOperation(value = "添加菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.ICON , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.CSS , value = "样式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.TYPE , value = "菜单类型" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MenuVOMeta.PATH , value = "模版路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.URL , value = "路由地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = MenuVOMeta.ID)
	@SentinelResource(value = MenuServiceProxy.INSERT)
	@PostMapping(MenuServiceProxy.INSERT)
	public Result<Menu> insert(MenuVO menuVO) {
		Result<Menu> result=new Result<>();
		boolean suc=menuService.insert(menuVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除菜单
	*/
	@ApiOperation(value = "删除菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MenuVOMeta.ID)
	@SentinelResource(value = MenuServiceProxy.DELETE)
	@PostMapping(MenuServiceProxy.DELETE)
	public Result<Menu> deleteById(String id) {
		Result<Menu> result=new Result<>();
		boolean suc=menuService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除菜单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MenuVOMeta.IDS)
	@SentinelResource(value = MenuServiceProxy.BATCH_DELETE)
	@PostMapping(MenuServiceProxy.BATCH_DELETE)
	public Result<Menu> deleteByIds(List<String> ids) {
		Result<Menu> result=new Result<>();
		boolean suc=menuService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新菜单
	*/
	@ApiOperation(value = "更新菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.ICON , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.CSS , value = "样式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.TYPE , value = "菜单类型" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MenuVOMeta.PATH , value = "模版路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.URL , value = "路由地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MenuVOMeta.PAGE_INDEX , MenuVOMeta.PAGE_SIZE , MenuVOMeta.SEARCH_FIELD , MenuVOMeta.SEARCH_VALUE , MenuVOMeta.IDS } ) 
	@NotNull(name = MenuVOMeta.ID)
	@SentinelResource(value = MenuServiceProxy.UPDATE)
	@PostMapping(MenuServiceProxy.UPDATE)
	public Result<Menu> update(MenuVO menuVO) {
		Result<Menu> result=new Result<>();
		boolean suc=menuService.update(menuVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存菜单
	*/
	@ApiOperation(value = "保存菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.ICON , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.CSS , value = "样式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.TYPE , value = "菜单类型" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MenuVOMeta.PATH , value = "模版路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.URL , value = "路由地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MenuVOMeta.PAGE_INDEX , MenuVOMeta.PAGE_SIZE , MenuVOMeta.SEARCH_FIELD , MenuVOMeta.SEARCH_VALUE , MenuVOMeta.IDS } )
	@NotNull(name = MenuVOMeta.ID)
	@SentinelResource(value = MenuServiceProxy.SAVE)
	@PostMapping(MenuServiceProxy.SAVE)
	public Result<Menu> save(MenuVO menuVO) {
		Result<Menu> result=new Result<>();
		boolean suc=menuService.save(menuVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取菜单
	*/
	@ApiOperation(value = "获取菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MenuVOMeta.ID)
	@SentinelResource(value = MenuServiceProxy.GET_BY_ID)
	@PostMapping(MenuServiceProxy.GET_BY_ID)
	public Result<Menu> getById(String id) {
		Result<Menu> result=new Result<>();
		Menu role=menuService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询菜单
	*/
	@ApiOperation(value = "查询菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.ICON , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.CSS , value = "样式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.TYPE , value = "菜单类型" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MenuVOMeta.PATH , value = "模版路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.URL , value = "路由地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MenuVOMeta.PAGE_INDEX , MenuVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MenuServiceProxy.QUERY_LIST)
	@PostMapping(MenuServiceProxy.QUERY_LIST)
	public Result<List<Menu>> queryList(MenuVO sample) {
		Result<List<Menu>> result=new Result<>();
		List<Menu> list=menuService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询菜单
	*/
	@ApiOperation(value = "分页查询菜单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.ICON , value = "图标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.CSS , value = "样式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.TYPE , value = "菜单类型" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MenuVOMeta.PATH , value = "模版路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.URL , value = "路由地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MenuServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(MenuServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Menu>> queryPagedList(MenuVO sample) {
		Result<PagedList<Menu>> result=new Result<>();
		PagedList<Menu> list=menuService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}