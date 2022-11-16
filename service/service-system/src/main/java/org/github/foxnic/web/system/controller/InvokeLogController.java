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
import org.github.foxnic.web.domain.system.InvokeLog;
import org.github.foxnic.web.domain.system.InvokeLogVO;
import org.github.foxnic.web.domain.system.meta.InvokeLogVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.system.InvokeLogServiceProxy;
import org.github.foxnic.web.system.service.IInvokeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 调用统计日志接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:42:52
*/

@InDoc
@Api(tags = "调用统计日志")
@RestController("SysInvokeLogController")
public class InvokeLogController extends SuperController {

	@Autowired
	private IInvokeLogService invokeLogService;


	/**
	 * 添加调用统计日志
	*/
	@ApiOperation(value = "添加调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.APPLICATION , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.HOST_NAME , value = "主机名称" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.URI , value = "请求的URI" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_AGENT , value = "UserAgent" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.CLIENT_IP , value = "客户端IP" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.TOKEN , value = "token值" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.SESSION_ID , value = "会话ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_NAME , value = "用户姓名" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.TID , value = "日志跟踪ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.PARAMETER , value = "请求参数" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.RESPONSE , value = "响应数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = InvokeLogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.INSERT)
	public Result insert(InvokeLogVO invokeLogVO) {
		Result result=invokeLogService.insert(invokeLogVO,false);
		return result;
	}



	/**
	 * 删除调用统计日志
	*/
	@ApiOperation(value = "删除调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1")
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = InvokeLogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.DELETE)
	public Result deleteById(Long id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  invokeLogService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录:"+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=invokeLogService.deleteByIdPhysical(id);
		return result;
	}


	/**
	 * 批量删除调用统计日志 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = InvokeLogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<Long> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<Long, ReferCause> hasRefersMap = invokeLogService.hasRefers(ids);
		// 收集可以删除的ID值
		List<Long> canDeleteIds = new ArrayList<>();
		for (Map.Entry<Long, ReferCause> e : hasRefersMap.entrySet()) {
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
			Result result=invokeLogService.deleteByIdsPhysical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=invokeLogService.deleteByIdsPhysical(canDeleteIds);
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
	 * 更新调用统计日志
	*/
	@ApiOperation(value = "更新调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.APPLICATION , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.HOST_NAME , value = "主机名称" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.URI , value = "请求的URI" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_AGENT , value = "UserAgent" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.CLIENT_IP , value = "客户端IP" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.TOKEN , value = "token值" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.SESSION_ID , value = "会话ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_NAME , value = "用户姓名" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.TID , value = "日志跟踪ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.PARAMETER , value = "请求参数" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.RESPONSE , value = "响应数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class)
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { InvokeLogVOMeta.PAGE_INDEX , InvokeLogVOMeta.PAGE_SIZE , InvokeLogVOMeta.SEARCH_FIELD , InvokeLogVOMeta.FUZZY_FIELD , InvokeLogVOMeta.SEARCH_VALUE , InvokeLogVOMeta.DIRTY_FIELDS , InvokeLogVOMeta.SORT_FIELD , InvokeLogVOMeta.SORT_TYPE , InvokeLogVOMeta.IDS } )
	@SentinelResource(value = InvokeLogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.UPDATE)
	public Result update(InvokeLogVO invokeLogVO) {
		Result result=invokeLogService.update(invokeLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存调用统计日志
	*/
	@ApiOperation(value = "保存调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.APPLICATION , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.HOST_NAME , value = "主机名称" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.URI , value = "请求的URI" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_AGENT , value = "UserAgent" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.CLIENT_IP , value = "客户端IP" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.TOKEN , value = "token值" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.SESSION_ID , value = "会话ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_NAME , value = "用户姓名" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.TID , value = "日志跟踪ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.PARAMETER , value = "请求参数" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.RESPONSE , value = "响应数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class)
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InvokeLogVOMeta.PAGE_INDEX , InvokeLogVOMeta.PAGE_SIZE , InvokeLogVOMeta.SEARCH_FIELD , InvokeLogVOMeta.FUZZY_FIELD , InvokeLogVOMeta.SEARCH_VALUE , InvokeLogVOMeta.DIRTY_FIELDS , InvokeLogVOMeta.SORT_FIELD , InvokeLogVOMeta.SORT_TYPE , InvokeLogVOMeta.IDS } )
	@SentinelResource(value = InvokeLogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.SAVE)
	public Result save(InvokeLogVO invokeLogVO) {
		Result result=invokeLogService.save(invokeLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取调用统计日志
	*/
	@ApiOperation(value = "获取调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = InvokeLogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.GET_BY_ID)
	public Result<InvokeLog> getById(Long id) {
		Result<InvokeLog> result=new Result<>();
		InvokeLog invokeLog=invokeLogService.getById(id);
		result.success(true).data(invokeLog);
		return result;
	}


	/**
	 * 批量获取调用统计日志 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取调用统计日志")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InvokeLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com")
		@SentinelResource(value = InvokeLogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.GET_BY_IDS)
	public Result<List<InvokeLog>> getByIds(List<Long> ids) {
		Result<List<InvokeLog>> result=new Result<>();
		List<InvokeLog> list=invokeLogService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询调用统计日志
	*/
	@ApiOperation(value = "查询调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.APPLICATION , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.HOST_NAME , value = "主机名称" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.URI , value = "请求的URI" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_AGENT , value = "UserAgent" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.CLIENT_IP , value = "客户端IP" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.TOKEN , value = "token值" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.SESSION_ID , value = "会话ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_NAME , value = "用户姓名" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.TID , value = "日志跟踪ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.PARAMETER , value = "请求参数" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.RESPONSE , value = "响应数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { InvokeLogVOMeta.PAGE_INDEX , InvokeLogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InvokeLogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.QUERY_LIST)
	public Result<List<InvokeLog>> queryList(InvokeLogVO sample) {
		Result<List<InvokeLog>> result=new Result<>();
		List<InvokeLog> list=invokeLogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询调用统计日志
	*/
	@ApiOperation(value = "分页查询调用统计日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InvokeLogVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.APPLICATION , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.HOST_NAME , value = "主机名称" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.URI , value = "请求的URI" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_AGENT , value = "UserAgent" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.CLIENT_IP , value = "客户端IP" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.TOKEN , value = "token值" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.SESSION_ID , value = "会话ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.USER_NAME , value = "用户姓名" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.TID , value = "日志跟踪ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.PARAMETER , value = "请求参数" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InvokeLogVOMeta.RESPONSE , value = "响应数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Timestamp.class),
		@ApiImplicitParam(name = InvokeLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = InvokeLogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InvokeLogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InvokeLog>> queryPagedList(InvokeLogVO sample) {
		Result<PagedList<InvokeLog>> result=new Result<>();
		PagedList<InvokeLog> list=invokeLogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}
