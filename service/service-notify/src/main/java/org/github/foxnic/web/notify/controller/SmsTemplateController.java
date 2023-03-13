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


import org.github.foxnic.web.proxy.notify.SmsTemplateServiceProxy;
import org.github.foxnic.web.domain.notify.meta.SmsTemplateVOMeta;
import org.github.foxnic.web.domain.notify.SmsTemplate;
import org.github.foxnic.web.domain.notify.SmsTemplateVO;
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
import org.github.foxnic.web.domain.notify.meta.SmsTemplateMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.notify.service.ISmsTemplateService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 短信模版接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:54:09
*/

@InDoc
@Api(tags = "短信模版")
@RestController("SysSmsTemplateController")
public class SmsTemplateController extends SuperController {

	@Autowired
	private ISmsTemplateService smsTemplateService;

	/**
	 * 添加短信模版
	*/
	@ApiOperation(value = "添加短信模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsTemplateVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CODE , value = "模版代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.NAME , value = "模版名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CHANEL_TYPE , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CHANEL_CODE , value = "通道代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.TEMPLATE , value = "模版内容" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = SmsTemplateServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsTemplateServiceProxy.INSERT)
	public Result insert(SmsTemplateVO smsTemplateVO) {
		
		Result result=smsTemplateService.insert(smsTemplateVO,false);
		return result;
	}



	/**
	 * 删除短信模版
	*/
	@ApiOperation(value = "删除短信模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsTemplateVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = SmsTemplateServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsTemplateServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  smsTemplateService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=smsTemplateService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除短信模版 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除短信模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsTemplateVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
	@SentinelResource(value = SmsTemplateServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsTemplateServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = smsTemplateService.hasRefers(ids);
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
			Result result=smsTemplateService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=smsTemplateService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新短信模版
	*/
	@ApiOperation(value = "更新短信模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsTemplateVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CODE , value = "模版代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.NAME , value = "模版名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CHANEL_TYPE , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CHANEL_CODE , value = "通道代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.TEMPLATE , value = "模版内容" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { SmsTemplateVOMeta.PAGE_INDEX , SmsTemplateVOMeta.PAGE_SIZE , SmsTemplateVOMeta.SEARCH_FIELD , SmsTemplateVOMeta.FUZZY_FIELD , SmsTemplateVOMeta.SEARCH_VALUE , SmsTemplateVOMeta.DIRTY_FIELDS , SmsTemplateVOMeta.SORT_FIELD , SmsTemplateVOMeta.SORT_TYPE , SmsTemplateVOMeta.DATA_ORIGIN , SmsTemplateVOMeta.QUERY_LOGIC , SmsTemplateVOMeta.REQUEST_ACTION , SmsTemplateVOMeta.IDS } )
	@SentinelResource(value = SmsTemplateServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsTemplateServiceProxy.UPDATE)
	public Result update(SmsTemplateVO smsTemplateVO) {
		
		Result result=smsTemplateService.update(smsTemplateVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存短信模版
	*/
	@ApiOperation(value = "保存短信模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsTemplateVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CODE , value = "模版代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.NAME , value = "模版名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CHANEL_TYPE , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CHANEL_CODE , value = "通道代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.TEMPLATE , value = "模版内容" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SmsTemplateVOMeta.PAGE_INDEX , SmsTemplateVOMeta.PAGE_SIZE , SmsTemplateVOMeta.SEARCH_FIELD , SmsTemplateVOMeta.FUZZY_FIELD , SmsTemplateVOMeta.SEARCH_VALUE , SmsTemplateVOMeta.DIRTY_FIELDS , SmsTemplateVOMeta.SORT_FIELD , SmsTemplateVOMeta.SORT_TYPE , SmsTemplateVOMeta.DATA_ORIGIN , SmsTemplateVOMeta.QUERY_LOGIC , SmsTemplateVOMeta.REQUEST_ACTION , SmsTemplateVOMeta.IDS } )
	@SentinelResource(value = SmsTemplateServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsTemplateServiceProxy.SAVE)
	public Result save(SmsTemplateVO smsTemplateVO) {
		
		Result result=smsTemplateService.save(smsTemplateVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取短信模版
	*/
	@ApiOperation(value = "获取短信模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsTemplateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = SmsTemplateServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsTemplateServiceProxy.GET_BY_ID)
	public Result<SmsTemplate> getById(String id) {
		
		Result<SmsTemplate> result=new Result<>();
		SmsTemplate smsTemplate=smsTemplateService.getById(id);
		result.success(true).data(smsTemplate);
		return result;
	}


	/**
	 * 批量获取短信模版 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取短信模版")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SmsTemplateVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
		@SentinelResource(value = SmsTemplateServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsTemplateServiceProxy.GET_BY_IDS)
	public Result<List<SmsTemplate>> getByIds(List<String> ids) {
		
		Result<List<SmsTemplate>> result=new Result<>();
		List<SmsTemplate> list=smsTemplateService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询短信模版
	*/
	@ApiOperation(value = "查询短信模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsTemplateVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CODE , value = "模版代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.NAME , value = "模版名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CHANEL_TYPE , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CHANEL_CODE , value = "通道代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.TEMPLATE , value = "模版内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { SmsTemplateVOMeta.PAGE_INDEX , SmsTemplateVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SmsTemplateServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsTemplateServiceProxy.QUERY_LIST)
	public Result<List<SmsTemplate>> queryList(SmsTemplateVO sample) {
		
		Result<List<SmsTemplate>> result=new Result<>();
		List<SmsTemplate> list=smsTemplateService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询短信模版
	*/
	@ApiOperation(value = "分页查询短信模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SmsTemplateVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CODE , value = "模版代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.NAME , value = "模版名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CHANEL_TYPE , value = "短信通道" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.CHANEL_CODE , value = "通道代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SmsTemplateVOMeta.TEMPLATE , value = "模版内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = SmsTemplateServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SmsTemplateServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SmsTemplate>> queryPagedList(SmsTemplateVO sample) {
		
		Result<PagedList<SmsTemplate>> result=new Result<>();
		PagedList<SmsTemplate> list=smsTemplateService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}