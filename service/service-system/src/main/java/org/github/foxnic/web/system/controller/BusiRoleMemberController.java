package org.github.foxnic.web.system.controller;

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


import org.github.foxnic.web.proxy.system.BusiRoleMemberServiceProxy;
import org.github.foxnic.web.domain.system.meta.BusiRoleMemberVOMeta;
import org.github.foxnic.web.domain.system.BusiRoleMember;
import org.github.foxnic.web.domain.system.BusiRoleMemberVO;
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
import org.github.foxnic.web.domain.system.meta.BusiRoleMemberMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.domain.hrm.meta.PositionMeta;
import org.github.foxnic.web.domain.hrm.meta.OrganizationMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.IBusiRoleMemberService;
import com.github.foxnic.api.validate.annotations.NotNull;
import java.util.ArrayList;

/**
 * <p>
 * 业务角色成员关系接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-18 09:51:55
*/

@InDoc
@Api(tags = "业务角色成员关系")
@RestController("SysBusiRoleMemberController")
public class BusiRoleMemberController extends SuperController {

	@Autowired
	private IBusiRoleMemberService busiRoleMemberService;

	/**
	 * 添加业务角色成员关系
	*/
	@ApiOperation(value = "添加业务角色成员关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "686501321490038784"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "599716089596743680"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_ID , value = "成员ID" , required = false , dataTypeClass=String.class , example = "617107520095256576"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_TYPE , value = "成员类型" , required = false , dataTypeClass=String.class , example = "employee"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = BusiRoleMemberServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.INSERT)
	public Result insert(BusiRoleMemberVO busiRoleMemberVO) {
		
		Result result=busiRoleMemberService.insert(busiRoleMemberVO,false);
		return result;
	}

	/**
	 * 批量添加业务角色成员关系
	*/
	@ApiOperation(value = "添加业务角色成员关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "686501321490038784"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "599716089596743680"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_ID , value = "成员ID" , required = false , dataTypeClass=String.class , example = "617107520095256576"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_TYPE , value = "成员类型" , required = false , dataTypeClass=String.class , example = "employee"),
	})
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = BusiRoleMemberServiceProxy.INSERTS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.INSERTS)
	public Result inserts(List<BusiRoleMemberVO> busiRoleMemberVOs) {
		
		Result result=busiRoleMemberService.insertList(new ArrayList<>(busiRoleMemberVOs));
		return result;
	}


	/**
	 * 删除业务角色成员关系
	*/
	@ApiOperation(value = "删除业务角色成员关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "686501321490038784")
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = BusiRoleMemberServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  busiRoleMemberService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=busiRoleMemberService.deleteByIdPhysical(id);
		return result;
	}


	/**
	 * 批量删除业务角色成员关系 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除业务角色成员关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
	@SentinelResource(value = BusiRoleMemberServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = busiRoleMemberService.hasRefers(ids);
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
			Result result=busiRoleMemberService.deleteByIdsPhysical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=busiRoleMemberService.deleteByIdsPhysical(canDeleteIds);
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
	 * 更新业务角色成员关系
	*/
	@ApiOperation(value = "更新业务角色成员关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "686501321490038784"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "599716089596743680"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_ID , value = "成员ID" , required = false , dataTypeClass=String.class , example = "617107520095256576"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_TYPE , value = "成员类型" , required = false , dataTypeClass=String.class , example = "employee"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { BusiRoleMemberVOMeta.PAGE_INDEX , BusiRoleMemberVOMeta.PAGE_SIZE , BusiRoleMemberVOMeta.SEARCH_FIELD , BusiRoleMemberVOMeta.FUZZY_FIELD , BusiRoleMemberVOMeta.SEARCH_VALUE , BusiRoleMemberVOMeta.DIRTY_FIELDS , BusiRoleMemberVOMeta.SORT_FIELD , BusiRoleMemberVOMeta.SORT_TYPE , BusiRoleMemberVOMeta.DATA_ORIGIN , BusiRoleMemberVOMeta.QUERY_LOGIC , BusiRoleMemberVOMeta.REQUEST_ACTION , BusiRoleMemberVOMeta.IDS } )
	@SentinelResource(value = BusiRoleMemberServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.UPDATE)
	public Result update(BusiRoleMemberVO busiRoleMemberVO) {
		
		Result result=busiRoleMemberService.update(busiRoleMemberVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存业务角色成员关系
	*/
	@ApiOperation(value = "保存业务角色成员关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "686501321490038784"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "599716089596743680"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_ID , value = "成员ID" , required = false , dataTypeClass=String.class , example = "617107520095256576"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_TYPE , value = "成员类型" , required = false , dataTypeClass=String.class , example = "employee"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BusiRoleMemberVOMeta.PAGE_INDEX , BusiRoleMemberVOMeta.PAGE_SIZE , BusiRoleMemberVOMeta.SEARCH_FIELD , BusiRoleMemberVOMeta.FUZZY_FIELD , BusiRoleMemberVOMeta.SEARCH_VALUE , BusiRoleMemberVOMeta.DIRTY_FIELDS , BusiRoleMemberVOMeta.SORT_FIELD , BusiRoleMemberVOMeta.SORT_TYPE , BusiRoleMemberVOMeta.DATA_ORIGIN , BusiRoleMemberVOMeta.QUERY_LOGIC , BusiRoleMemberVOMeta.REQUEST_ACTION , BusiRoleMemberVOMeta.IDS } )
	@SentinelResource(value = BusiRoleMemberServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.SAVE)
	public Result save(BusiRoleMemberVO busiRoleMemberVO) {
		
		Result result=busiRoleMemberService.save(busiRoleMemberVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取业务角色成员关系
	*/
	@ApiOperation(value = "获取业务角色成员关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = BusiRoleMemberServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.GET_BY_ID)
	public Result<BusiRoleMember> getById(String id) {
		
		Result<BusiRoleMember> result=new Result<>();
		BusiRoleMember busiRoleMember=busiRoleMemberService.getById(id);
		// join 关联的对象
		busiRoleMemberService.dao().fill(busiRoleMember)
			.with(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.PERSON)
			.with(BusiRoleMemberMeta.EMPLOYEE)
			.with(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.POSITIONS)
			.with(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.ORGANIZATIONS)
			.execute();
		result.success(true).data(busiRoleMember);
		return result;
	}


	/**
	 * 批量获取业务角色成员关系 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取业务角色成员关系")
		@ApiImplicitParams({
				@ApiImplicitParam(name = BusiRoleMemberVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
		@SentinelResource(value = BusiRoleMemberServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.GET_BY_IDS)
	public Result<List<BusiRoleMember>> getByIds(List<String> ids) {
		
		Result<List<BusiRoleMember>> result=new Result<>();
		List<BusiRoleMember> list=busiRoleMemberService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询业务角色成员关系
	*/
	@ApiOperation(value = "查询业务角色成员关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "686501321490038784"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "599716089596743680"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_ID , value = "成员ID" , required = false , dataTypeClass=String.class , example = "617107520095256576"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_TYPE , value = "成员类型" , required = false , dataTypeClass=String.class , example = "employee"),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { BusiRoleMemberVOMeta.PAGE_INDEX , BusiRoleMemberVOMeta.PAGE_SIZE } )
	@SentinelResource(value = BusiRoleMemberServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.QUERY_LIST)
	public Result<List<BusiRoleMember>> queryList(BusiRoleMemberVO sample) {
		
		Result<List<BusiRoleMember>> result=new Result<>();
		List<BusiRoleMember> list=busiRoleMemberService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询业务角色成员关系
	*/
	@ApiOperation(value = "分页查询业务角色成员关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "686501321490038784"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class , example = "599716089596743680"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_ID , value = "成员ID" , required = false , dataTypeClass=String.class , example = "617107520095256576"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_TYPE , value = "成员类型" , required = false , dataTypeClass=String.class , example = "employee"),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = BusiRoleMemberServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<BusiRoleMember>> queryPagedList(BusiRoleMemberVO sample) {
		
		Result<PagedList<BusiRoleMember>> result=new Result<>();
		PagedList<BusiRoleMember> list=busiRoleMemberService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		busiRoleMemberService.dao().fill(list)
			.with(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.PERSON)
			.with(BusiRoleMemberMeta.EMPLOYEE)
			.with(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.POSITIONS)
			.with(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.ORGANIZATIONS)
			.execute();
		result.success(true).data(list);
		return result;
	}





}