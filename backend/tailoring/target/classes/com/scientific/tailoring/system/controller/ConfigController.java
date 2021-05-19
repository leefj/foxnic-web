package com.scientific.tailoring.system.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.springboot.mvc.Result;
import java.util.List;
import com.scientific.tailoring.domain.system.meta.ConfigVOMeta;
import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.proxy.system.ConfigServiceProxy;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.scientific.tailoring.domain.system.ConfigVO;
import com.scientific.tailoring.system.service.IConfigService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;

import com.scientific.tailoring.domain.system.Config;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-25 02:26:35
*/

@Api(tags = "系统配置")
@ApiSort(1001)
@RestController("SysConfigController")
public class ConfigController extends SuperController {

	@Autowired
	private IConfigService configService;

	
	/**
	 * 添加系统配置
	*/
	@RequiresPermissions("SysConfig:insert")
	@ApiOperation(value = "添加系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统名称"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "XXX系统"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Boolean.class , example = "true"),
		
	})
	@NotNull(name = ConfigVOMeta.VALID)
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ConfigServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ConfigServiceProxy.INSERT)
	public  Result<Config> insert(ConfigVO configVO) {
		Result<Config> result=new Result<>();
		boolean suc=configService.insert(configVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除系统配置
	*/
	@RequiresPermissions("SysConfig:deleteById")
	@ApiOperation(value = "删除系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
	})
	@ApiOperationSupport(order=2)
	@SentinelResource(value = ConfigServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ConfigServiceProxy.DELETE)
	public  Result deleteById(String key) {
		Result result=new Result();
		boolean suc=configService.deleteByIdLogical(key);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新系统配置
	*/
	@RequiresPermissions("SysConfig:update")
	@ApiOperation(value = "更新系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统名称"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "XXX系统"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Boolean.class , example = "true"),
	})
	@ApiOperationSupport(ignoreParameters = {ConfigVOMeta.PAGE_INDEX , ConfigVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = ConfigServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ConfigServiceProxy.UPDATE)
	public  Result<Config> update(ConfigVO configVO) {
		Result<Config> result=new Result<>();
		boolean suc=configService.update(configVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取系统配置
	*/
	@RequiresPermissions("SysConfig:getById")
	@ApiOperation(value = "按主键获取系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
	})
	@ApiOperationSupport(order=4)
	@SentinelResource(value = ConfigServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ConfigServiceProxy.GET_BY_ID)
	public  Result<Config> getById(String key) {
		Result<Config> result=new Result<>();
		Config config=configService.getById(key);
		result.success(true).data(config);
		return result;
	}

	
	/**
	 * 查询全部符合条件的系统配置
	*/
	@RequiresPermissions("SysConfig:queryList")
	@ApiOperation(value = "查询系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = false , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统名称"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "XXX系统"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Boolean.class , example = "true"),
	})
	@ApiOperationSupport(ignoreParameters = {ConfigVOMeta.PAGE_INDEX , ConfigVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = ConfigServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ConfigServiceProxy.QUERY_LIST)
	public  Result<List<Config>> queryList(ConfigVO sample) {
		Result<List<Config>> result=new Result<>();
		List<Config> list=configService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的系统配置
	*/
	@RequiresPermissions("SysConfig:queryPagedList")
	@ApiOperation(value = "分页查询系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = false , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统名称"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "XXX系统"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Boolean.class , example = "true"),
		@ApiImplicitParam(name = ConfigVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ConfigVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = ConfigServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(ConfigServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<Config>> queryPagedList(ConfigVO sample) {
		Result<PagedList<Config>> result=new Result<>();
		PagedList<Config> list=configService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}