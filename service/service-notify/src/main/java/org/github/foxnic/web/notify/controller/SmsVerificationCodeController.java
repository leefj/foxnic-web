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


import org.github.foxnic.web.proxy.notify.SmsVerificationCodeServiceProxy;
import org.github.foxnic.web.domain.notify.meta.SmsVerificationCodeVOMeta;
import org.github.foxnic.web.domain.notify.SmsVerificationCode;
import org.github.foxnic.web.domain.notify.SmsVerificationCodeVO;
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
import org.github.foxnic.web.domain.notify.meta.SmsVerificationCodeMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.notify.service.ISmsVerificationCodeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 短信验证码接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:31:34
*/

@InDoc
@Api(tags = "短信验证码")
@RestController("SysSmsVerificationCodeController")
public class SmsVerificationCodeController extends SuperController {

	@Autowired
	private ISmsVerificationCodeService smsVerificationCodeService;

	/**
	 * 添加短信验证码
	*/
	@ApiOperation(value = "添加短信验证码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.TOPIC , value = "验证主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.USER_ID , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.PHONE , value = "手机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.CODE , value = "短信内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.EXPIRE_TIME , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = SmsVerificationCodeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsVerificationCodeServiceProxy.INSERT)
	public Result insert(SmsVerificationCodeVO smsVerificationCodeVO) {
		
		Result result=smsVerificationCodeService.insert(smsVerificationCodeVO,false);
		return result;
	}



	/**
	 * 删除短信验证码
	*/
	@ApiOperation(value = "删除短信验证码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = SmsVerificationCodeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsVerificationCodeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  smsVerificationCodeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=smsVerificationCodeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除短信验证码 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除短信验证码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
	@SentinelResource(value = SmsVerificationCodeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsVerificationCodeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = smsVerificationCodeService.hasRefers(ids);
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
			Result result=smsVerificationCodeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=smsVerificationCodeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新短信验证码
	*/
	@ApiOperation(value = "更新短信验证码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.TOPIC , value = "验证主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.USER_ID , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.PHONE , value = "手机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.CODE , value = "短信内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.EXPIRE_TIME , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { SmsVerificationCodeVOMeta.PAGE_INDEX , SmsVerificationCodeVOMeta.PAGE_SIZE , SmsVerificationCodeVOMeta.SEARCH_FIELD , SmsVerificationCodeVOMeta.FUZZY_FIELD , SmsVerificationCodeVOMeta.SEARCH_VALUE , SmsVerificationCodeVOMeta.DIRTY_FIELDS , SmsVerificationCodeVOMeta.SORT_FIELD , SmsVerificationCodeVOMeta.SORT_TYPE , SmsVerificationCodeVOMeta.DATA_ORIGIN , SmsVerificationCodeVOMeta.QUERY_LOGIC , SmsVerificationCodeVOMeta.REQUEST_ACTION , SmsVerificationCodeVOMeta.IDS } )
	@SentinelResource(value = SmsVerificationCodeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsVerificationCodeServiceProxy.UPDATE)
	public Result update(SmsVerificationCodeVO smsVerificationCodeVO) {
		
		Result result=smsVerificationCodeService.update(smsVerificationCodeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存短信验证码
	*/
	@ApiOperation(value = "保存短信验证码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.TOPIC , value = "验证主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.USER_ID , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.PHONE , value = "手机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.CODE , value = "短信内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.EXPIRE_TIME , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SmsVerificationCodeVOMeta.PAGE_INDEX , SmsVerificationCodeVOMeta.PAGE_SIZE , SmsVerificationCodeVOMeta.SEARCH_FIELD , SmsVerificationCodeVOMeta.FUZZY_FIELD , SmsVerificationCodeVOMeta.SEARCH_VALUE , SmsVerificationCodeVOMeta.DIRTY_FIELDS , SmsVerificationCodeVOMeta.SORT_FIELD , SmsVerificationCodeVOMeta.SORT_TYPE , SmsVerificationCodeVOMeta.DATA_ORIGIN , SmsVerificationCodeVOMeta.QUERY_LOGIC , SmsVerificationCodeVOMeta.REQUEST_ACTION , SmsVerificationCodeVOMeta.IDS } )
	@SentinelResource(value = SmsVerificationCodeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsVerificationCodeServiceProxy.SAVE)
	public Result save(SmsVerificationCodeVO smsVerificationCodeVO) {
		
		Result result=smsVerificationCodeService.save(smsVerificationCodeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取短信验证码
	*/
	@ApiOperation(value = "获取短信验证码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = SmsVerificationCodeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsVerificationCodeServiceProxy.GET_BY_ID)
	public Result<SmsVerificationCode> getById(String id) {
		
		Result<SmsVerificationCode> result=new Result<>();
		SmsVerificationCode smsVerificationCode=smsVerificationCodeService.getById(id);
		result.success(true).data(smsVerificationCode);
		return result;
	}


	/**
	 * 批量获取短信验证码 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取短信验证码")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SmsVerificationCodeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
		@SentinelResource(value = SmsVerificationCodeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsVerificationCodeServiceProxy.GET_BY_IDS)
	public Result<List<SmsVerificationCode>> getByIds(List<String> ids) {
		
		Result<List<SmsVerificationCode>> result=new Result<>();
		List<SmsVerificationCode> list=smsVerificationCodeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询短信验证码
	*/
	@ApiOperation(value = "查询短信验证码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.TOPIC , value = "验证主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.USER_ID , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.PHONE , value = "手机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.CODE , value = "短信内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.EXPIRE_TIME , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { SmsVerificationCodeVOMeta.PAGE_INDEX , SmsVerificationCodeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SmsVerificationCodeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsVerificationCodeServiceProxy.QUERY_LIST)
	public Result<List<SmsVerificationCode>> queryList(SmsVerificationCodeVO sample) {
		
		Result<List<SmsVerificationCode>> result=new Result<>();
		List<SmsVerificationCode> list=smsVerificationCodeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询短信验证码
	*/
	@ApiOperation(value = "分页查询短信验证码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.TOPIC , value = "验证主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.USER_ID , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.PHONE , value = "手机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.CODE , value = "短信内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsVerificationCodeVOMeta.EXPIRE_TIME , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = SmsVerificationCodeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsVerificationCodeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SmsVerificationCode>> queryPagedList(SmsVerificationCodeVO sample) {
		
		Result<PagedList<SmsVerificationCode>> result=new Result<>();
		PagedList<SmsVerificationCode> list=smsVerificationCodeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}