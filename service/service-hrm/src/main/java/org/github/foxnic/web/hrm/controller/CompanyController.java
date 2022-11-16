package org.github.foxnic.web.hrm.controller;


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
import org.github.foxnic.web.domain.hrm.Company;
import org.github.foxnic.web.domain.hrm.CompanyVO;
import org.github.foxnic.web.domain.hrm.meta.CompanyVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.hrm.service.ICompanyService;
import org.github.foxnic.web.proxy.hrm.CompanyServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 公司接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:51:39
*/

@InDoc
@Api(tags = "公司")
@RestController("HrmCompanyController")
public class CompanyController extends SuperController {

	@Autowired
	private ICompanyService companyService;


	/**
	 * 添加公司
	*/
	@ApiOperation(value = "添加公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "002"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class , example = "租户公司"),
		@ApiImplicitParam(name = CompanyVOMeta.SOCIAL_CREDIT_CODE , value = "社会信用代码" , required = false , dataTypeClass=String.class , example = "00000000000000000"),
		@ApiImplicitParam(name = CompanyVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CompanyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.INSERT)
	public Result insert(CompanyVO companyVO) {
		Result result=companyService.insert(companyVO,false);
		return result;
	}



	/**
	 * 删除公司
	*/
	@ApiOperation(value = "删除公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "002")
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CompanyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  companyService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录:"+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=companyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除公司 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CompanyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap =  companyService.hasRefers(ids);
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
			Result result=companyService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=companyService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新公司
	*/
	@ApiOperation(value = "更新公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "002"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class , example = "租户公司"),
		@ApiImplicitParam(name = CompanyVOMeta.SOCIAL_CREDIT_CODE , value = "社会信用代码" , required = false , dataTypeClass=String.class , example = "00000000000000000"),
		@ApiImplicitParam(name = CompanyVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE , CompanyVOMeta.SEARCH_FIELD , CompanyVOMeta.FUZZY_FIELD , CompanyVOMeta.SEARCH_VALUE , CompanyVOMeta.DIRTY_FIELDS , CompanyVOMeta.SORT_FIELD , CompanyVOMeta.SORT_TYPE , CompanyVOMeta.IDS } )
	@SentinelResource(value = CompanyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.UPDATE)
	public Result update(CompanyVO companyVO) {
		Result result=companyService.update(companyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存公司
	*/
	@ApiOperation(value = "保存公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "002"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class , example = "租户公司"),
		@ApiImplicitParam(name = CompanyVOMeta.SOCIAL_CREDIT_CODE , value = "社会信用代码" , required = false , dataTypeClass=String.class , example = "00000000000000000"),
		@ApiImplicitParam(name = CompanyVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE , CompanyVOMeta.SEARCH_FIELD , CompanyVOMeta.FUZZY_FIELD , CompanyVOMeta.SEARCH_VALUE , CompanyVOMeta.DIRTY_FIELDS , CompanyVOMeta.SORT_FIELD , CompanyVOMeta.SORT_TYPE , CompanyVOMeta.IDS } )
	@SentinelResource(value = CompanyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.SAVE)
	public Result save(CompanyVO companyVO) {
		Result result=companyService.save(companyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取公司
	*/
	@ApiOperation(value = "获取公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CompanyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.GET_BY_ID)
	public Result<Company> getById(String id) {
		Result<Company> result=new Result<>();
		Company company=companyService.getById(id);
		result.success(true).data(company);
		return result;
	}


	/**
	 * 批量获取公司 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取公司")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CompanyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com")
		@SentinelResource(value = CompanyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.GET_BY_IDS)
	public Result<List<Company>> getByIds(List<String> ids) {
		Result<List<Company>> result=new Result<>();
		List<Company> list=companyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询公司
	*/
	@ApiOperation(value = "查询公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "002"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class , example = "租户公司"),
		@ApiImplicitParam(name = CompanyVOMeta.SOCIAL_CREDIT_CODE , value = "社会信用代码" , required = false , dataTypeClass=String.class , example = "00000000000000000"),
		@ApiImplicitParam(name = CompanyVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CompanyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.QUERY_LIST)
	public Result<List<Company>> queryList(CompanyVO sample) {
		Result<List<Company>> result=new Result<>();
		List<Company> list=companyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询公司
	*/
	@ApiOperation(value = "分页查询公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "002"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class , example = "租户公司"),
		@ApiImplicitParam(name = CompanyVOMeta.SOCIAL_CREDIT_CODE , value = "社会信用代码" , required = false , dataTypeClass=String.class , example = "00000000000000000"),
		@ApiImplicitParam(name = CompanyVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CompanyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Company>> queryPagedList(CompanyVO sample) {
		Result<PagedList<Company>> result=new Result<>();
		PagedList<Company> list=companyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}
