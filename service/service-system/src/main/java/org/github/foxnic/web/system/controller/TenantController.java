package org.github.foxnic.web.system.controller;


import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import org.github.foxnic.web.proxy.system.TenantServiceProxy;
import org.github.foxnic.web.domain.system.meta.TenantVOMeta;
import org.github.foxnic.web.domain.system.Tenant;
import org.github.foxnic.web.domain.system.TenantVO;
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
import org.github.foxnic.web.domain.system.meta.TenantMeta;
import org.github.foxnic.web.domain.hrm.Company;
import org.github.foxnic.web.domain.hrm.meta.CompanyMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.ITenantService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * ????????? ???????????????
 * </p>
 * @author ????????? , leefangjie@qq.com
 * @since 2022-09-02 16:18:43
*/

@Api(tags = "??????")
@ApiSort(0)
@RestController("SysTenantController")
public class TenantController extends SuperController {

	@Autowired
	private ITenantService tenantService;


	/**
	 * ????????????
	*/
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "489310412978790400"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "??????" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "????????????" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "001"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = TenantServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.INSERT)
	public Result insert(TenantVO tenantVO) {
		Result result=tenantService.insert(tenantVO,false);
		return result;
	}



	/**
	 * ????????????
	*/
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "489310412978790400")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = TenantVOMeta.ID)
	@SentinelResource(value = TenantServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("??????id???");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// ????????????
		Boolean hasRefer = tenantService.hasRefers(id);
		// ????????????????????????
		this.validator().asserts(hasRefer).requireEqual("???????????????????????????",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=tenantService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * ?????????????????? <br>
	 * ???????????????????????????????????????
	*/
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = TenantVOMeta.IDS)
	@SentinelResource(value = TenantServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// ????????????
		this.validator().asserts(ids).require("??????ids??????");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// ????????????
		Map<String, Boolean> hasRefersMap = tenantService.hasRefers(ids);
		// ?????????????????????ID???
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, Boolean> e : hasRefersMap.entrySet()) {
			if (!e.getValue()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// ????????????
		if (canDeleteIds.isEmpty()) {
			// ?????????????????????????????????
			return ErrorDesc.failure().message("?????????????????????????????????");
		} else if (canDeleteIds.size() == ids.size()) {
			// ????????????????????????
			Result result=tenantService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// ???????????????????????????
			Result result=tenantService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("????????? " + canDeleteIds.size() + " ??????????????? " + (ids.size() - canDeleteIds.size()) + " ?????????????????????").messageLevel4Confirm();
			}
		} else {
			// ?????????????????????????????????
			return ErrorDesc.success().message("?????????????????????");
		}
	}

	/**
	 * ????????????
	*/
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "489310412978790400"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "??????" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "????????????" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "001"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { TenantVOMeta.PAGE_INDEX , TenantVOMeta.PAGE_SIZE , TenantVOMeta.SEARCH_FIELD , TenantVOMeta.FUZZY_FIELD , TenantVOMeta.SEARCH_VALUE , TenantVOMeta.DIRTY_FIELDS , TenantVOMeta.SORT_FIELD , TenantVOMeta.SORT_TYPE , TenantVOMeta.IDS } )
	@SentinelResource(value = TenantServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.UPDATE)
	public Result update(TenantVO tenantVO) {
		Result result=tenantService.update(tenantVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * ????????????
	*/
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "489310412978790400"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "??????" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "????????????" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "001"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TenantVOMeta.PAGE_INDEX , TenantVOMeta.PAGE_SIZE , TenantVOMeta.SEARCH_FIELD , TenantVOMeta.FUZZY_FIELD , TenantVOMeta.SEARCH_VALUE , TenantVOMeta.DIRTY_FIELDS , TenantVOMeta.SORT_FIELD , TenantVOMeta.SORT_TYPE , TenantVOMeta.IDS } )
	@NotNull(name = TenantVOMeta.ID)
	@SentinelResource(value = TenantServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.SAVE)
	public Result save(TenantVO tenantVO) {
		Result result=tenantService.save(tenantVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * ????????????
	*/
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = TenantVOMeta.ID)
	@SentinelResource(value = TenantServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.GET_BY_ID)
	public Result<Tenant> getById(String id) {
		Result<Tenant> result=new Result<>();
		Tenant tenant=tenantService.getById(id);
		// join ???????????????
		tenantService.dao().fill(tenant)
			.with(TenantMeta.COMPANY)
			.with(TenantMeta.COMPANY)
			.execute();
		result.success(true).data(tenant);
		return result;
	}


	/**
	 * ?????????????????? <br>
	 * ???????????????????????????????????????
	*/
		@ApiOperation(value = "??????????????????")
		@ApiImplicitParams({
				@ApiImplicitParam(name = TenantVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = TenantVOMeta.IDS)
		@SentinelResource(value = TenantServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.GET_BY_IDS)
	public Result<List<Tenant>> getByIds(List<String> ids) {
		Result<List<Tenant>> result=new Result<>();
		List<Tenant> list=tenantService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * ????????????
	*/
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "489310412978790400"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "??????" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "????????????" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "001"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TenantVOMeta.PAGE_INDEX , TenantVOMeta.PAGE_SIZE } )
	@SentinelResource(value = TenantServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.QUERY_LIST)
	public Result<List<Tenant>> queryList(TenantVO sample) {
		Result<List<Tenant>> result=new Result<>();
		List<Tenant> list=tenantService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * ??????????????????
	*/
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "489310412978790400"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "??????" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "????????????" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "001"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = TenantServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Tenant>> queryPagedList(TenantVO sample) {
		Result<PagedList<Tenant>> result=new Result<>();
		PagedList<Tenant> list=tenantService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join ???????????????
		tenantService.dao().fill(list)
			.with(TenantMeta.COMPANY)
			.with(TenantMeta.COMPANY)
			.execute();
		result.success(true).data(list);
		return result;
	}






}