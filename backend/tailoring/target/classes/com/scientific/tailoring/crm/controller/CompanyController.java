package com.scientific.tailoring.crm.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.mvc.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.scientific.tailoring.crm.service.ICompanyService;
import com.scientific.tailoring.domain.crm.Company;
import com.scientific.tailoring.domain.crm.CompanyVO;
import com.scientific.tailoring.domain.crm.meta.CompanyVOMeta;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.proxy.crm.CompanyServiceProxy;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @author 李方捷
 * @since 2021-03-25 08:57:36
*/

@Api(tags = "客户公司")
@ApiSort(1051)
@RestController("CrmCompanyController")
public class CompanyController extends SuperController {

	@Autowired
	private ICompanyService companyService;

	
	/**
	 * 添加客户公司
	*/
	@RequiresPermissions("CrmCompany:insert")
	@ApiOperation(value = "添加客户公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class , example = "乔治白"),
		@ApiImplicitParam(name = CompanyVOMeta.UNIFY_SOCIAL_CODE , value = "统一社会信用代码" , required = false , dataTypeClass=String.class , example = "0091122389"),
		@ApiImplicitParam(name = CompanyVOMeta.LICENSE_PHOTO , value = "营业执照图片地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.BUSINESS_RANGE , value = "经营范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TERM_START_DATE , value = "营业期限开始日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TERM_END_DATE , value = "营业期限结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTRACT_START_DATE , value = "合同生效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTRACT_STATUS , value = "合同状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TYPE , value = "公司类型" , required = false , dataTypeClass=String.class , example = "supplier"),
	})
	@ApiOperationSupport(ignoreParameters = {CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = CompanyServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(CompanyServiceProxy.INSERT)
	public  Result<Company> insert(CompanyVO companyVO) {
		Result<Company> result=new Result<>();
		boolean suc=companyService.insert(companyVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除客户公司
	*/
	@RequiresPermissions("CrmCompany:deleteById")
	@ApiOperation(value = "删除客户公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class , example = "乔治白"),
		@ApiImplicitParam(name = CompanyVOMeta.UNIFY_SOCIAL_CODE , value = "统一社会信用代码" , required = false , dataTypeClass=String.class , example = "0091122389"),
		@ApiImplicitParam(name = CompanyVOMeta.LICENSE_PHOTO , value = "营业执照图片地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.BUSINESS_RANGE , value = "经营范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TERM_START_DATE , value = "营业期限开始日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TERM_END_DATE , value = "营业期限结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTRACT_START_DATE , value = "合同生效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTRACT_STATUS , value = "合同状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TYPE , value = "公司类型" , required = false , dataTypeClass=String.class , example = "supplier"),
	})
	@NotNull(name = CompanyVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = CompanyServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(CompanyServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=companyService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新客户公司
	*/
	@RequiresPermissions("CrmCompany:update")
	@ApiOperation(value = "更新客户公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class , example = "乔治白"),
		@ApiImplicitParam(name = CompanyVOMeta.UNIFY_SOCIAL_CODE , value = "统一社会信用代码" , required = false , dataTypeClass=String.class , example = "0091122389"),
		@ApiImplicitParam(name = CompanyVOMeta.LICENSE_PHOTO , value = "营业执照图片地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.BUSINESS_RANGE , value = "经营范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TERM_START_DATE , value = "营业期限开始日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TERM_END_DATE , value = "营业期限结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTRACT_START_DATE , value = "合同生效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTRACT_STATUS , value = "合同状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TYPE , value = "公司类型" , required = false , dataTypeClass=String.class , example = "supplier"),
	})
	@NotNull(name = CompanyVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = CompanyServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(CompanyServiceProxy.UPDATE)
	public  Result<Company> update(CompanyVO companyVO) {
		Result<Company> result=new Result<>();
		boolean suc=companyService.update(companyVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取客户公司
	*/
	@RequiresPermissions("CrmCompany:getById")
	@ApiOperation(value = "按主键获取客户公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class , example = "乔治白"),
		@ApiImplicitParam(name = CompanyVOMeta.UNIFY_SOCIAL_CODE , value = "统一社会信用代码" , required = false , dataTypeClass=String.class , example = "0091122389"),
		@ApiImplicitParam(name = CompanyVOMeta.LICENSE_PHOTO , value = "营业执照图片地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.BUSINESS_RANGE , value = "经营范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TERM_START_DATE , value = "营业期限开始日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TERM_END_DATE , value = "营业期限结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTRACT_START_DATE , value = "合同生效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTRACT_STATUS , value = "合同状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TYPE , value = "公司类型" , required = false , dataTypeClass=String.class , example = "supplier"),
	})
	@NotNull(name = CompanyVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = CompanyServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(CompanyServiceProxy.GET_BY_ID)
	public  Result<Company> getById(Long id) {
		Result<Company> result=new Result<>();
		Company company=companyService.getById(id);
		result.success(true).data(company);
		return result;
	}

	
	/**
	 * 查询全部符合条件的客户公司
	*/
	@RequiresPermissions("CrmCompany:queryList")
	@ApiOperation(value = "查询客户公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class , example = "乔治白"),
		@ApiImplicitParam(name = CompanyVOMeta.UNIFY_SOCIAL_CODE , value = "统一社会信用代码" , required = false , dataTypeClass=String.class , example = "0091122389"),
		@ApiImplicitParam(name = CompanyVOMeta.LICENSE_PHOTO , value = "营业执照图片地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.BUSINESS_RANGE , value = "经营范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TERM_START_DATE , value = "营业期限开始日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TERM_END_DATE , value = "营业期限结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTRACT_START_DATE , value = "合同生效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTRACT_STATUS , value = "合同状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TYPE , value = "公司类型" , required = false , dataTypeClass=String.class , example = "supplier"),
	})
	@ApiOperationSupport(ignoreParameters = {CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = CompanyServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(CompanyServiceProxy.QUERY_LIST)
	public  Result<List<Company>> queryList(CompanyVO sample) {
		Result<List<Company>> result=new Result<>();
		List<Company> list=companyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}
	
	
	
	/**
	 * 查询全部符合条件的客户公司
	*/
//	@RequiresPermissions("CrmCompany:queryList4Select")
	@ApiOperation(value = "查询公司(下拉数据)")
	@ApiImplicitParams({})
	@ApiOperationSupport(ignoreParameters = {CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = CompanyServiceProxy.QUERY_LIST_FOR_SELECT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@RequestMapping(CompanyServiceProxy.QUERY_LIST_FOR_SELECT)
	public  Result<JSONArray> queryList4Select(CompanyVO sample) {
		Result<JSONArray> result=new Result<>();
		List<Company> list=companyService.queryList(sample);
		JSONArray array=new JSONArray();
		for (Company com : list) {
			JSONObject item=new JSONObject();
			item.put("name", com.getName());
			item.put("value", com.getId());
			array.add(item);
		}
		result.success(true).data(array);
		return result;
	}

	
	/**
	 * 分页查询符合条件的客户公司
	*/
	@RequiresPermissions("CrmCompany:queryPagedList")
	@ApiOperation(value = "分页查询客户公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class , example = "乔治白"),
		@ApiImplicitParam(name = CompanyVOMeta.UNIFY_SOCIAL_CODE , value = "统一社会信用代码" , required = false , dataTypeClass=String.class , example = "0091122389"),
		@ApiImplicitParam(name = CompanyVOMeta.LICENSE_PHOTO , value = "营业执照图片地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.BUSINESS_RANGE , value = "经营范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TERM_START_DATE , value = "营业期限开始日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TERM_END_DATE , value = "营业期限结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTRACT_START_DATE , value = "合同生效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTRACT_STATUS , value = "合同状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.TYPE , value = "公司类型" , required = false , dataTypeClass=String.class , example = "supplier"),
		@ApiImplicitParam(name = CompanyVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CompanyVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = CompanyServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(CompanyServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<Company>> queryPagedList(CompanyVO sample) {
		Result<PagedList<Company>> result=new Result<>();
		PagedList<Company> list=companyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}