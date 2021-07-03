package org.github.foxnic.web.oauth.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.oauth.SessionOnline;
import org.github.foxnic.web.domain.oauth.SessionOnlineVO;
import org.github.foxnic.web.domain.oauth.meta.SessionOnlineVOMeta;
import org.github.foxnic.web.oauth.service.ISessionOnlineService;
import org.github.foxnic.web.proxy.oauth.SessionOnlineServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 在线会话表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:28
*/

@Api(tags = "在线会话")
@ApiSort(0)
@RestController("SysSessionOnlineController")
public class SessionOnlineController {

	@Autowired
	private ISessionOnlineService sessionOnlineService;

	
	/**
	 * 添加在线会话
	*/
	@ApiOperation(value = "添加在线会话")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SessionOnlineVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "450690969709314048"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.SESSION_ID , value = "会话ID" , required = false , dataTypeClass=String.class , example = "zkLB6t_aH5mAGHAeahclypHk7eUK6GXJrpFf0sk9"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.LOGIN_TIME , value = "登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-28 04:05:01"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.INTERACT_TIME , value = "最近一次交互时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.INTERACT_URL , value = "最后访问的地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.LOGOUT_TIME , value = "登出时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.SESSION_TIME , value = "会话时长" , required = false , dataTypeClass=Integer.class , example = "1200"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.ONLINE , value = "是否在线" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = SessionOnlineVOMeta.ID)
	@SentinelResource(value = SessionOnlineServiceProxy.INSERT)
	@PostMapping(SessionOnlineServiceProxy.INSERT)
	public Result insert(SessionOnlineVO sessionOnlineVO) {
		Result result=sessionOnlineService.insert(sessionOnlineVO);
		return result;
	}

	
	/**
	 * 删除在线会话
	*/
	@ApiOperation(value = "删除在线会话")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SessionOnlineVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "450690969709314048"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = SessionOnlineVOMeta.ID)
	@SentinelResource(value = SessionOnlineServiceProxy.DELETE)
	@PostMapping(SessionOnlineServiceProxy.DELETE)
	public Result<SessionOnline> deleteById(String id) {
		Result<SessionOnline> result=new Result<>();
		boolean suc=sessionOnlineService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除在线会话 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除在线会话")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SessionOnlineVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = SessionOnlineVOMeta.IDS)
	@SentinelResource(value = SessionOnlineServiceProxy.BATCH_DELETE)
	@PostMapping(SessionOnlineServiceProxy.BATCH_DELETE)
	public Result deleteByIds(List<String> ids) {
		Result result=sessionOnlineService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新在线会话
	*/
	@ApiOperation(value = "更新在线会话")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SessionOnlineVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "450690969709314048"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.SESSION_ID , value = "会话ID" , required = false , dataTypeClass=String.class , example = "zkLB6t_aH5mAGHAeahclypHk7eUK6GXJrpFf0sk9"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.LOGIN_TIME , value = "登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-28 04:05:01"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.INTERACT_TIME , value = "最近一次交互时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.INTERACT_URL , value = "最后访问的地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.LOGOUT_TIME , value = "登出时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.SESSION_TIME , value = "会话时长" , required = false , dataTypeClass=Integer.class , example = "1200"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.ONLINE , value = "是否在线" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { SessionOnlineVOMeta.PAGE_INDEX , SessionOnlineVOMeta.PAGE_SIZE , SessionOnlineVOMeta.SEARCH_FIELD , SessionOnlineVOMeta.SEARCH_VALUE , SessionOnlineVOMeta.IDS } ) 
	@NotNull(name = SessionOnlineVOMeta.ID)
	@SentinelResource(value = SessionOnlineServiceProxy.UPDATE)
	@PostMapping(SessionOnlineServiceProxy.UPDATE)
	public Result update(SessionOnlineVO sessionOnlineVO) {
		Result result=sessionOnlineService.update(sessionOnlineVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存在线会话
	*/
	@ApiOperation(value = "保存在线会话")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SessionOnlineVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "450690969709314048"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.SESSION_ID , value = "会话ID" , required = false , dataTypeClass=String.class , example = "zkLB6t_aH5mAGHAeahclypHk7eUK6GXJrpFf0sk9"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.LOGIN_TIME , value = "登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-28 04:05:01"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.INTERACT_TIME , value = "最近一次交互时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.INTERACT_URL , value = "最后访问的地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.LOGOUT_TIME , value = "登出时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.SESSION_TIME , value = "会话时长" , required = false , dataTypeClass=Integer.class , example = "1200"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.ONLINE , value = "是否在线" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SessionOnlineVOMeta.PAGE_INDEX , SessionOnlineVOMeta.PAGE_SIZE , SessionOnlineVOMeta.SEARCH_FIELD , SessionOnlineVOMeta.SEARCH_VALUE , SessionOnlineVOMeta.IDS } )
	@NotNull(name = SessionOnlineVOMeta.ID)
	@SentinelResource(value = SessionOnlineServiceProxy.SAVE)
	@PostMapping(SessionOnlineServiceProxy.SAVE)
	public Result save(SessionOnlineVO sessionOnlineVO) {
		Result result=sessionOnlineService.save(sessionOnlineVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取在线会话
	*/
	@ApiOperation(value = "获取在线会话")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SessionOnlineVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = SessionOnlineVOMeta.ID)
	@SentinelResource(value = SessionOnlineServiceProxy.GET_BY_ID)
	@PostMapping(SessionOnlineServiceProxy.GET_BY_ID)
	public Result<SessionOnline> getById(String id) {
		Result<SessionOnline> result=new Result<>();
		SessionOnline role=sessionOnlineService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询在线会话
	*/
	@ApiOperation(value = "查询在线会话")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SessionOnlineVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "450690969709314048"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.SESSION_ID , value = "会话ID" , required = false , dataTypeClass=String.class , example = "zkLB6t_aH5mAGHAeahclypHk7eUK6GXJrpFf0sk9"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.LOGIN_TIME , value = "登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-28 04:05:01"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.INTERACT_TIME , value = "最近一次交互时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.INTERACT_URL , value = "最后访问的地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.LOGOUT_TIME , value = "登出时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.SESSION_TIME , value = "会话时长" , required = false , dataTypeClass=Integer.class , example = "1200"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.ONLINE , value = "是否在线" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SessionOnlineVOMeta.PAGE_INDEX , SessionOnlineVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SessionOnlineServiceProxy.QUERY_LIST)
	@PostMapping(SessionOnlineServiceProxy.QUERY_LIST)
	public Result<List<SessionOnline>> queryList(SessionOnlineVO sample) {
		Result<List<SessionOnline>> result=new Result<>();
		List<SessionOnline> list=sessionOnlineService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询在线会话
	*/
	@ApiOperation(value = "分页查询在线会话")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SessionOnlineVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "450690969709314048"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.SESSION_ID , value = "会话ID" , required = false , dataTypeClass=String.class , example = "zkLB6t_aH5mAGHAeahclypHk7eUK6GXJrpFf0sk9"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.LOGIN_TIME , value = "登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-28 04:05:01"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.INTERACT_TIME , value = "最近一次交互时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.INTERACT_URL , value = "最后访问的地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.LOGOUT_TIME , value = "登出时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = SessionOnlineVOMeta.SESSION_TIME , value = "会话时长" , required = false , dataTypeClass=Integer.class , example = "1200"),
		@ApiImplicitParam(name = SessionOnlineVOMeta.ONLINE , value = "是否在线" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = SessionOnlineServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(SessionOnlineServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SessionOnline>> queryPagedList(SessionOnlineVO sample) {
		Result<PagedList<SessionOnline>> result=new Result<>();
		PagedList<SessionOnline> list=sessionOnlineService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}