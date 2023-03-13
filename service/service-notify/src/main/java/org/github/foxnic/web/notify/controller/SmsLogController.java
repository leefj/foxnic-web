package org.github.foxnic.web.notify.controller;

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


import org.github.foxnic.web.proxy.notify.SmsLogServiceProxy;
import org.github.foxnic.web.domain.notify.meta.SmsLogVOMeta;
import org.github.foxnic.web.domain.notify.SmsLog;
import org.github.foxnic.web.domain.notify.SmsLogVO;
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
import org.github.foxnic.web.domain.notify.meta.SmsLogMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.notify.service.ISmsLogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 短信日志接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:31:33
*/

@InDoc
@Api(tags = "短信日志")
@RestController("SysSmsLogController")
public class SmsLogController extends SuperController {

	@Autowired
	private ISmsLogService smsLogService;

	/**
	 * 添加短信日志
	*/
	@ApiOperation(value = "添加短信日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsLogVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SmsLogVOMeta.TEMPLATE_ID , value = "模版ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.CHANEL , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.USER_ID , value = "账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.PARAMS , value = "参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.PHONE , value = "手机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.CONTENT , value = "短信内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.SUCCESS , value = "是否成功" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SmsLogVOMeta.RESPONSE , value = "相应" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.ERROR , value = "异常" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = SmsLogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsLogServiceProxy.INSERT)
	public Result insert(SmsLogVO smsLogVO) {
		
		Result result=smsLogService.insert(smsLogVO,false);
		return result;
	}



	/**
	 * 删除短信日志
	*/
	@ApiOperation(value = "删除短信日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsLogVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = SmsLogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsLogServiceProxy.DELETE)
	public Result deleteById(Integer id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  smsLogService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=smsLogService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除短信日志 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除短信日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
	@SentinelResource(value = SmsLogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsLogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<Integer> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<Integer, ReferCause> causeMap = smsLogService.hasRefers(ids);
		// 收集可以删除的ID值
		List<Integer> canDeleteIds = new ArrayList<>();
		for (Map.Entry<Integer, ReferCause> e : causeMap.entrySet()) {
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
			Result result=smsLogService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=smsLogService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新短信日志
	*/
	@ApiOperation(value = "更新短信日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsLogVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SmsLogVOMeta.TEMPLATE_ID , value = "模版ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.CHANEL , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.USER_ID , value = "账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.PARAMS , value = "参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.PHONE , value = "手机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.CONTENT , value = "短信内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.SUCCESS , value = "是否成功" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SmsLogVOMeta.RESPONSE , value = "相应" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.ERROR , value = "异常" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { SmsLogVOMeta.PAGE_INDEX , SmsLogVOMeta.PAGE_SIZE , SmsLogVOMeta.SEARCH_FIELD , SmsLogVOMeta.FUZZY_FIELD , SmsLogVOMeta.SEARCH_VALUE , SmsLogVOMeta.DIRTY_FIELDS , SmsLogVOMeta.SORT_FIELD , SmsLogVOMeta.SORT_TYPE , SmsLogVOMeta.DATA_ORIGIN , SmsLogVOMeta.QUERY_LOGIC , SmsLogVOMeta.REQUEST_ACTION , SmsLogVOMeta.IDS } )
	@SentinelResource(value = SmsLogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsLogServiceProxy.UPDATE)
	public Result update(SmsLogVO smsLogVO) {
		
		Result result=smsLogService.update(smsLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存短信日志
	*/
	@ApiOperation(value = "保存短信日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsLogVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SmsLogVOMeta.TEMPLATE_ID , value = "模版ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.CHANEL , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.USER_ID , value = "账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.PARAMS , value = "参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.PHONE , value = "手机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.CONTENT , value = "短信内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.SUCCESS , value = "是否成功" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SmsLogVOMeta.RESPONSE , value = "相应" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.ERROR , value = "异常" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SmsLogVOMeta.PAGE_INDEX , SmsLogVOMeta.PAGE_SIZE , SmsLogVOMeta.SEARCH_FIELD , SmsLogVOMeta.FUZZY_FIELD , SmsLogVOMeta.SEARCH_VALUE , SmsLogVOMeta.DIRTY_FIELDS , SmsLogVOMeta.SORT_FIELD , SmsLogVOMeta.SORT_TYPE , SmsLogVOMeta.DATA_ORIGIN , SmsLogVOMeta.QUERY_LOGIC , SmsLogVOMeta.REQUEST_ACTION , SmsLogVOMeta.IDS } )
	@SentinelResource(value = SmsLogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsLogServiceProxy.SAVE)
	public Result save(SmsLogVO smsLogVO) {
		
		Result result=smsLogService.save(smsLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取短信日志
	*/
	@ApiOperation(value = "获取短信日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = SmsLogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsLogServiceProxy.GET_BY_ID)
	public Result<SmsLog> getById(Integer id) {
		
		Result<SmsLog> result=new Result<>();
		SmsLog smsLog=smsLogService.getById(id);
		result.success(true).data(smsLog);
		return result;
	}


	/**
	 * 批量获取短信日志 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取短信日志")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SmsLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
		@SentinelResource(value = SmsLogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsLogServiceProxy.GET_BY_IDS)
	public Result<List<SmsLog>> getByIds(List<Integer> ids) {
		
		Result<List<SmsLog>> result=new Result<>();
		List<SmsLog> list=smsLogService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询短信日志
	*/
	@ApiOperation(value = "查询短信日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsLogVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SmsLogVOMeta.TEMPLATE_ID , value = "模版ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.CHANEL , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.USER_ID , value = "账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.PARAMS , value = "参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.PHONE , value = "手机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.CONTENT , value = "短信内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.SUCCESS , value = "是否成功" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SmsLogVOMeta.RESPONSE , value = "相应" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.ERROR , value = "异常" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { SmsLogVOMeta.PAGE_INDEX , SmsLogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SmsLogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsLogServiceProxy.QUERY_LIST)
	public Result<List<SmsLog>> queryList(SmsLogVO sample) {
		
		Result<List<SmsLog>> result=new Result<>();
		List<SmsLog> list=smsLogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询短信日志
	*/
	@ApiOperation(value = "分页查询短信日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsLogVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SmsLogVOMeta.TEMPLATE_ID , value = "模版ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.CHANEL , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.USER_ID , value = "账户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.PARAMS , value = "参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.PHONE , value = "手机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.CONTENT , value = "短信内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.SUCCESS , value = "是否成功" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = SmsLogVOMeta.RESPONSE , value = "相应" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsLogVOMeta.ERROR , value = "异常" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = SmsLogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsLogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SmsLog>> queryPagedList(SmsLogVO sample) {
		
		Result<PagedList<SmsLog>> result=new Result<>();
		PagedList<SmsLog> list=smsLogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}