package org.github.foxnic.web.oauth.controller;

import java.util.*;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import org.github.foxnic.web.proxy.oauth.MenuForkServiceProxy;
import org.github.foxnic.web.domain.oauth.meta.MenuForkVOMeta;
import org.github.foxnic.web.domain.oauth.MenuFork;
import org.github.foxnic.web.domain.oauth.MenuForkVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import org.github.foxnic.web.domain.oauth.meta.MenuForkMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.oauth.service.IMenuForkService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 菜单功能分版本实现配置接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-31 13:11:21
*/

@InDoc
@Api(tags = "认证服务/菜单功能分版本实现配置")
@RestController("SysMenuForkController")
public class MenuForkController extends SuperController {

	@Autowired
	private IMenuForkService menuForkService;


	/**
	 * 添加菜单功能分版本实现配置
	*/
	@ApiOperation(value = "添加菜单功能分版本实现配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuForkVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.MENU_ID , value = "菜单ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.DIR , value = "目录名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.SORT , value = "显示顺序" , required = true , dataTypeClass=Integer.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = MenuForkServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MenuForkServiceProxy.INSERT)
	public Result insert(MenuForkVO menuForkVO) {
		Result result=menuForkService.insert(menuForkVO,false);
		return result;
	}



	/**
	 * 删除菜单功能分版本实现配置
	*/
	@ApiOperation(value = "删除菜单功能分版本实现配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuForkVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = MenuForkServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MenuForkServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  menuForkService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=menuForkService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除菜单功能分版本实现配置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除菜单功能分版本实现配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuForkVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
	@SentinelResource(value = MenuForkServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MenuForkServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = menuForkService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, ReferCause> e : causeMap.entrySet()) {
			if (!e.getValue().hasRefer()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0)
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=menuForkService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=menuForkService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size())
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新菜单功能分版本实现配置
	*/
	@ApiOperation(value = "更新菜单功能分版本实现配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuForkVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.MENU_ID , value = "菜单ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.DIR , value = "目录名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.SORT , value = "显示顺序" , required = true , dataTypeClass=Integer.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { MenuForkVOMeta.PAGE_INDEX , MenuForkVOMeta.PAGE_SIZE , MenuForkVOMeta.SEARCH_FIELD , MenuForkVOMeta.FUZZY_FIELD , MenuForkVOMeta.SEARCH_VALUE , MenuForkVOMeta.DIRTY_FIELDS , MenuForkVOMeta.SORT_FIELD , MenuForkVOMeta.SORT_TYPE , MenuForkVOMeta.DATA_ORIGIN , MenuForkVOMeta.QUERY_LOGIC , MenuForkVOMeta.IDS } )
	@SentinelResource(value = MenuForkServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MenuForkServiceProxy.UPDATE)
	public Result update(MenuForkVO menuForkVO) {
		Result result=menuForkService.update(menuForkVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存菜单功能分版本实现配置
	*/
	@ApiOperation(value = "保存菜单功能分版本实现配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuForkVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.MENU_ID , value = "菜单ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.DIR , value = "目录名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.SORT , value = "显示顺序" , required = true , dataTypeClass=Integer.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MenuForkVOMeta.PAGE_INDEX , MenuForkVOMeta.PAGE_SIZE , MenuForkVOMeta.SEARCH_FIELD , MenuForkVOMeta.FUZZY_FIELD , MenuForkVOMeta.SEARCH_VALUE , MenuForkVOMeta.DIRTY_FIELDS , MenuForkVOMeta.SORT_FIELD , MenuForkVOMeta.SORT_TYPE , MenuForkVOMeta.DATA_ORIGIN , MenuForkVOMeta.QUERY_LOGIC , MenuForkVOMeta.IDS } )
	@SentinelResource(value = MenuForkServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MenuForkServiceProxy.SAVE)
	public Result save(MenuForkVO menuForkVO) {
		Result result=menuForkService.save(menuForkVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取菜单功能分版本实现配置
	*/
	@ApiOperation(value = "获取菜单功能分版本实现配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuForkVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = MenuForkServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MenuForkServiceProxy.GET_BY_ID)
	public Result<MenuFork> getById(String id) {
		Result<MenuFork> result=new Result<>();
		MenuFork menuFork=menuForkService.getById(id);
		result.success(true).data(menuFork);
		return result;
	}


	/**
	 * 批量获取菜单功能分版本实现配置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取菜单功能分版本实现配置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MenuForkVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
		@SentinelResource(value = MenuForkServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MenuForkServiceProxy.GET_BY_IDS)
	public Result<List<MenuFork>> getByIds(List<String> ids) {
		Result<List<MenuFork>> result=new Result<>();
		List<MenuFork> list=menuForkService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询菜单功能分版本实现配置
	*/
	@ApiOperation(value = "查询菜单功能分版本实现配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuForkVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.MENU_ID , value = "菜单ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.DIR , value = "目录名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.SORT , value = "显示顺序" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { MenuForkVOMeta.PAGE_INDEX , MenuForkVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MenuForkServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MenuForkServiceProxy.QUERY_LIST)
	public Result<List<MenuFork>> queryList(MenuForkVO sample) {
		Result<List<MenuFork>> result=new Result<>();
		List<MenuFork> list=menuForkService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询菜单功能分版本实现配置
	*/
	@ApiOperation(value = "分页查询菜单功能分版本实现配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MenuForkVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.MENU_ID , value = "菜单ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.DIR , value = "目录名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MenuForkVOMeta.SORT , value = "显示顺序" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = MenuForkServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MenuForkServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MenuFork>> queryPagedList(MenuForkVO sample) {
		Result<PagedList<MenuFork>> result=new Result<>();
		PagedList<MenuFork> list=menuForkService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}