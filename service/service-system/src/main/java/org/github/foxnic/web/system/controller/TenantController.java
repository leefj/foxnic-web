package org.github.foxnic.web.system.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.system.Tenant;
import org.github.foxnic.web.domain.system.TenantVO;
import org.github.foxnic.web.domain.system.meta.TenantMeta;
import org.github.foxnic.web.domain.system.meta.TenantVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.system.TenantServiceProxy;
import org.github.foxnic.web.system.service.ITenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 租户接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:52
*/

@InDoc
@Api(tags = "租户")
@RestController("SysTenantController")
public class TenantController extends SuperController {

	@Autowired
	private ITenantService tenantService;


	/**
	 * 添加租户
	*/
	@ApiOperation(value = "添加租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "T001"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "默认租户公司"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class , example = "002"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = TenantServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.INSERT)
	public Result insert(TenantVO tenantVO) {
		Result result=tenantService.insert(tenantVO,false);
		return result;
	}



	/**
	 * 删除租户
	*/
	@ApiOperation(value = "删除租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "T001")
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = TenantServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  tenantService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录:"+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=tenantService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除租户 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = TenantServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap =  tenantService.hasRefers(ids);
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
			return ErrorDesc.failure().message("无法删除您选中的数据行");
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=tenantService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=tenantService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新租户
	*/
	@ApiOperation(value = "更新租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "T001"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "默认租户公司"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class , example = "002"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { TenantVOMeta.PAGE_INDEX , TenantVOMeta.PAGE_SIZE , TenantVOMeta.SEARCH_FIELD , TenantVOMeta.FUZZY_FIELD , TenantVOMeta.SEARCH_VALUE , TenantVOMeta.DIRTY_FIELDS , TenantVOMeta.SORT_FIELD , TenantVOMeta.SORT_TYPE , TenantVOMeta.IDS } )
	@SentinelResource(value = TenantServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.UPDATE)
	public Result update(TenantVO tenantVO) {
		Result result=tenantService.update(tenantVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存租户
	*/
	@ApiOperation(value = "保存租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "T001"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "默认租户公司"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class , example = "002"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TenantVOMeta.PAGE_INDEX , TenantVOMeta.PAGE_SIZE , TenantVOMeta.SEARCH_FIELD , TenantVOMeta.FUZZY_FIELD , TenantVOMeta.SEARCH_VALUE , TenantVOMeta.DIRTY_FIELDS , TenantVOMeta.SORT_FIELD , TenantVOMeta.SORT_TYPE , TenantVOMeta.IDS } )
	@SentinelResource(value = TenantServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.SAVE)
	public Result save(TenantVO tenantVO) {
		Result result=tenantService.save(tenantVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取租户
	*/
	@ApiOperation(value = "获取租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = TenantServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.GET_BY_ID)
	public Result<Tenant> getById(String id) {
		Result<Tenant> result=new Result<>();
		Tenant tenant=tenantService.getById(id);
		// join 关联的对象
		tenantService.dao().fill(tenant)
			.with(TenantMeta.COMPANY)
			.with(TenantMeta.COMPANY)
			.execute();
		result.success(true).data(tenant);
		return result;
	}


	/**
	 * 批量获取租户 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取租户")
		@ApiImplicitParams({
				@ApiImplicitParam(name = TenantVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com")
		@SentinelResource(value = TenantServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.GET_BY_IDS)
	public Result<List<Tenant>> getByIds(List<String> ids) {
		Result<List<Tenant>> result=new Result<>();
		List<Tenant> list=tenantService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询租户
	*/
	@ApiOperation(value = "查询租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "T001"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "默认租户公司"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class , example = "002"),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { TenantVOMeta.PAGE_INDEX , TenantVOMeta.PAGE_SIZE } )
	@SentinelResource(value = TenantServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.QUERY_LIST)
	public Result<List<Tenant>> queryList(TenantVO sample) {
		Result<List<Tenant>> result=new Result<>();
		List<Tenant> list=tenantService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询租户
	*/
	@ApiOperation(value = "分页查询租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "T001"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "默认租户公司"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class , example = "002"),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = TenantServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Tenant>> queryPagedList(TenantVO sample) {
		Result<PagedList<Tenant>> result=new Result<>();
		PagedList<Tenant> list=tenantService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		tenantService.dao().fill(list)
			.with(TenantMeta.COMPANY)
			.with(TenantMeta.COMPANY)
			.execute();
		result.success(true).data(list);
		return result;
	}






}
