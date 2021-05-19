package com.scientific.tailoring.system.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.scientific.tailoring.system.service.ILangService;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.system.LangVO;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.system.Lang;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.proxy.system.LangServiceProxy;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import com.scientific.tailoring.domain.system.meta.LangVOMeta;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-31 10:11:37
*/

@Api(tags = "语言条目")
@ApiSort(1001)
@RestController("SysLangController")
public class LangController extends SuperController {

	@Autowired
	private ILangService langService;

	
	/**
	 * 添加语言条目
	*/
	@RequiresPermissions("SysLang:insert")
	@ApiOperation(value = "添加语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "编码键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS , value = "默认" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_CH , value = "简体中文(大陆)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW , value = "繁体中文(台湾)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US , value = "英文美国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_UK , value = "英文英国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE , value = "混淆专用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = LangServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LangServiceProxy.INSERT)
	public  Result<Lang> insert(LangVO langVO) {
		Result<Lang> result=langService.checkExists(langVO);
		if(result.failure()) return result;
		
		langVO.setValid(true);
		boolean suc=langService.insert(langVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除语言条目
	*/
	@RequiresPermissions("SysLang:deleteById")
	@ApiOperation(value = "删除语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "编码键" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=2)
	@SentinelResource(value = LangServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LangServiceProxy.DELETE)
	public  Result deleteById(String key) {
		Result result=new Result();
		boolean suc=langService.deleteByIdPhysical(key);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新语言条目
	*/
	@RequiresPermissions("SysLang:update")
	@ApiOperation(value = "更新语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "编码键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS , value = "默认" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_CH , value = "简体中文(大陆)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW , value = "繁体中文(台湾)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US , value = "英文美国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_UK , value = "英文英国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE , value = "混淆专用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class),
	})
	@ApiOperationSupport(ignoreParameters = {LangVOMeta.PAGE_INDEX , LangVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = LangServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LangServiceProxy.UPDATE)
	public  Result<Lang> update(LangVO langVO) {
		Result<Lang> result=new Result<>();
		boolean suc=langService.update(langVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取语言条目
	*/
	@RequiresPermissions("SysLang:getById")
	@ApiOperation(value = "按主键获取语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "编码键" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=4)
	@SentinelResource(value = LangServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LangServiceProxy.GET_BY_ID)
	public  Result<Lang> getById(String key) {
		Result<Lang> result=new Result<>();
		Lang lang=langService.getById(key);
		result.success(true).data(lang);
		return result;
	}

	
	/**
	 * 查询全部符合条件的语言条目
	*/
	@RequiresPermissions("SysLang:queryList")
	@ApiOperation(value = "查询语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "编码键" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS , value = "默认" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_CH , value = "简体中文(大陆)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW , value = "繁体中文(台湾)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US , value = "英文美国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_UK , value = "英文英国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE , value = "混淆专用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class),
	})
	@ApiOperationSupport(ignoreParameters = {LangVOMeta.PAGE_INDEX , LangVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = LangServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LangServiceProxy.QUERY_LIST)
	public  Result<List<Lang>> queryList(LangVO sample) {
		Result<List<Lang>> result=new Result<>();
		List<Lang> list=langService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的语言条目
	*/
	@RequiresPermissions("SysLang:queryPagedList")
	@ApiOperation(value = "分页查询语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "编码键" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS , value = "默认" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_CH , value = "简体中文(大陆)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW , value = "繁体中文(台湾)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US , value = "英文美国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_UK , value = "英文英国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE , value = "混淆专用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class),
		@ApiImplicitParam(name = LangVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = LangVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = LangServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LangServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<Lang>> queryPagedList(LangVO sample) {
		Result<PagedList<Lang>> result=new Result<>();
		PagedList<Lang> list=langService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



}