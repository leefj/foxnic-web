package org.github.foxnic.web.system.controller;

 
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.mvc.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.domain.system.ConfigVO;
import org.github.foxnic.web.domain.system.meta.ConfigVOMeta;
import org.github.foxnic.web.proxy.storage.FileServiceProxy;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;
import org.github.foxnic.web.system.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 系统配置表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-20 04:34:14
*/

@Api(tags = "系统配置")
@ApiSort(0)
@RestController("SysConfigController")
public class ConfigController {

	@Autowired
	private IConfigService configService;

	
	/**
	 * 添加系统配置
	*/
	@ApiOperation(value = "添加系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统默认语言"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "defaults"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Boolean.class , example = "true"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ConfigVOMeta.CODE)
	@NotNull(name = ConfigVOMeta.VALID)
	@SentinelResource(value = ConfigServiceProxy.INSERT)
	@PostMapping(ConfigServiceProxy.INSERT)
	public Result<Config> insert(ConfigVO configVO) {
		Result<Config> result=new Result<>();
		boolean suc=configService.insert(configVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除系统配置
	*/
	@ApiOperation(value = "删除系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ConfigVOMeta.CODE)
	@SentinelResource(value = ConfigServiceProxy.DELETE)
	@PostMapping(ConfigServiceProxy.DELETE)
	public Result<Config> deleteById(String code) {
		Result<Config> result=new Result<>();
		boolean suc=configService.deleteByIdLogical(code);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除系统配置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODES , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ConfigVOMeta.CODES)
	@SentinelResource(value = ConfigServiceProxy.BATCH_DELETE)
	@PostMapping(ConfigServiceProxy.BATCH_DELETE)
	public Result<Config> deleteByIds(List<String> codes) {
		Result<Config> result=new Result<>();
		boolean suc=configService.deleteByIdsLogical(codes);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新系统配置
	*/
	@ApiOperation(value = "更新系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统默认语言"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "defaults"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Boolean.class , example = "true"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ConfigVOMeta.PAGE_INDEX , ConfigVOMeta.PAGE_SIZE , ConfigVOMeta.SEARCH_FIELD , ConfigVOMeta.SEARCH_VALUE , ConfigVOMeta.CODES } ) 
	@NotNull(name = ConfigVOMeta.CODE)
	@NotNull(name = ConfigVOMeta.VALID)
	@SentinelResource(value = ConfigServiceProxy.UPDATE)
	@PostMapping(ConfigServiceProxy.UPDATE)
	public Result<Config> update(ConfigVO configVO) {
		Result<Config> result=new Result<>();
		boolean suc=configService.update(configVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存系统配置
	*/
	@ApiOperation(value = "保存系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统默认语言"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "defaults"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Boolean.class , example = "true"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ConfigVOMeta.PAGE_INDEX , ConfigVOMeta.PAGE_SIZE , ConfigVOMeta.SEARCH_FIELD , ConfigVOMeta.SEARCH_VALUE , ConfigVOMeta.CODES } )
	@NotNull(name = ConfigVOMeta.CODE)
	@NotNull(name = ConfigVOMeta.VALID)
	@SentinelResource(value = ConfigServiceProxy.SAVE)
	@PostMapping(ConfigServiceProxy.SAVE)
	public Result<Config> save(ConfigVO configVO) {
		Result<Config> result=new Result<>();
		boolean suc=configService.save(configVO,SaveMode.NOT_NULL_FIELDS);
		
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取系统配置
	*/
	@ApiOperation(value = "获取系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ConfigVOMeta.CODE)
	@SentinelResource(value = ConfigServiceProxy.GET_BY_ID)
	@PostMapping(ConfigServiceProxy.GET_BY_ID)
	public Result<Config> getById(String code) {
		Result<Config> result=new Result<>();
		Config role=configService.getById(code);
		result.success(true).data(role);
		return result;
	}


	/**
	 * 查询系统配置
	*/
	@ApiOperation(value = "查询系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统默认语言"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "defaults"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Boolean.class , example = "true"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ConfigVOMeta.PAGE_INDEX , ConfigVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ConfigServiceProxy.QUERY_LIST)
	@PostMapping(ConfigServiceProxy.QUERY_LIST)
	public Result<List<Config>> queryList(ConfigVO sample) {
		Result<File> r=FileServiceProxy.api().getById("314");
		Result<List<Config>> result=new Result<>();
		List<Config> list=configService.queryList(sample);
		result.success(true).data(list).refer("config", r);
		return result;
	}

	
	/**
	 * 分页查询系统配置
	*/
	@ApiOperation(value = "分页查询系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统默认语言"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "defaults"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Boolean.class , example = "true"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ConfigServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(ConfigServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Config>> queryPagedList(ConfigVO sample) {
		Result<PagedList<Config>> result=new Result<>();
		PagedList<Config> list=configService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}