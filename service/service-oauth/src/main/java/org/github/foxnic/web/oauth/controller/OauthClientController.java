package org.github.foxnic.web.oauth.controller;

 
import java.util.List;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;


import org.github.foxnic.web.proxy.oauth.OauthClientServiceProxy;
import org.github.foxnic.web.domain.oauth.meta.OauthClientVOMeta;
import org.github.foxnic.web.domain.oauth.OauthClient;
import org.github.foxnic.web.domain.oauth.OauthClientVO;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.oauth.service.IOauthClientService;
import com.github.foxnic.springboot.api.annotations.NotNull;

/**
 * <p>
 * 认证客户端 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:28
*/

@Api(tags = "认证客户端")
@ApiSort(0)
@RestController("SysOauthClientController")
public class OauthClientController {

	@Autowired
	private IOauthClientService oauthClientService;

	
	/**
	 * 添加认证客户端
	*/
	@ApiOperation(value = "添加认证客户端")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OauthClientVOMeta.ID , value = "客户端标识" , required = true , dataTypeClass=String.class , example = "credentials-client"),
		@ApiImplicitParam(name = OauthClientVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "证书客户端"),
		@ApiImplicitParam(name = OauthClientVOMeta.RESOURCE_IDS , value = "资源集合" , required = false , dataTypeClass=String.class , example = "sos-resource"),
		@ApiImplicitParam(name = OauthClientVOMeta.CLIENT_SECRET , value = "访问密匙" , required = false , dataTypeClass=String.class , example = "$2a$10$Dl2VwWVv/3h5KzK02gysheH7sy28weESL84DiO/CvUiGKcoXGTVlO"),
		@ApiImplicitParam(name = OauthClientVOMeta.SCOPE , value = "权限范围" , required = false , dataTypeClass=String.class , example = "read,write"),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTHORIZED_GRANT_TYPES , value = "授权类型" , required = false , dataTypeClass=String.class , example = "client_credentials"),
		@ApiImplicitParam(name = OauthClientVOMeta.WEB_SERVER_REDIRECT_URI , value = "重定向URI" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTHORITIES , value = "权限值列表" , required = false , dataTypeClass=String.class , example = "ROLE_UNITY,ROLE_USER"),
		@ApiImplicitParam(name = OauthClientVOMeta.ACCESS_TOKEN_VALIDITY , value = "access" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.REFRESH_TOKEN_VALIDITY , value = "refresh" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.NOTES , value = "备注信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OauthClientVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "false"),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTO_APPROVE , value = "是否自动Approval操作" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.TRUSTED , value = "是否信任" , required = false , dataTypeClass=Integer.class , example = "false"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = OauthClientVOMeta.ID)
	@SentinelResource(value = OauthClientServiceProxy.INSERT)
	@PostMapping(OauthClientServiceProxy.INSERT)
	public Result<OauthClient> insert(OauthClientVO oauthClientVO) {
		Result<OauthClient> result=new Result<>();
		boolean suc=oauthClientService.insert(oauthClientVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除认证客户端
	*/
	@ApiOperation(value = "删除认证客户端")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OauthClientVOMeta.ID , value = "客户端标识" , required = true , dataTypeClass=String.class , example = "credentials-client")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = OauthClientVOMeta.ID)
	@SentinelResource(value = OauthClientServiceProxy.DELETE)
	@PostMapping(OauthClientServiceProxy.DELETE)
	public Result<OauthClient> deleteById(String id) {
		Result<OauthClient> result=new Result<>();
		boolean suc=oauthClientService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除认证客户端 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除认证客户端")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OauthClientVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = OauthClientVOMeta.IDS)
	@SentinelResource(value = OauthClientServiceProxy.BATCH_DELETE)
	@PostMapping(OauthClientServiceProxy.BATCH_DELETE)
	public Result<OauthClient> deleteByIds(List<String> ids) {
		Result<OauthClient> result=new Result<>();
		boolean suc=oauthClientService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新认证客户端
	*/
	@ApiOperation(value = "更新认证客户端")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OauthClientVOMeta.ID , value = "客户端标识" , required = true , dataTypeClass=String.class , example = "credentials-client"),
		@ApiImplicitParam(name = OauthClientVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "证书客户端"),
		@ApiImplicitParam(name = OauthClientVOMeta.RESOURCE_IDS , value = "资源集合" , required = false , dataTypeClass=String.class , example = "sos-resource"),
		@ApiImplicitParam(name = OauthClientVOMeta.CLIENT_SECRET , value = "访问密匙" , required = false , dataTypeClass=String.class , example = "$2a$10$Dl2VwWVv/3h5KzK02gysheH7sy28weESL84DiO/CvUiGKcoXGTVlO"),
		@ApiImplicitParam(name = OauthClientVOMeta.SCOPE , value = "权限范围" , required = false , dataTypeClass=String.class , example = "read,write"),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTHORIZED_GRANT_TYPES , value = "授权类型" , required = false , dataTypeClass=String.class , example = "client_credentials"),
		@ApiImplicitParam(name = OauthClientVOMeta.WEB_SERVER_REDIRECT_URI , value = "重定向URI" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTHORITIES , value = "权限值列表" , required = false , dataTypeClass=String.class , example = "ROLE_UNITY,ROLE_USER"),
		@ApiImplicitParam(name = OauthClientVOMeta.ACCESS_TOKEN_VALIDITY , value = "access" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.REFRESH_TOKEN_VALIDITY , value = "refresh" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.NOTES , value = "备注信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OauthClientVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "false"),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTO_APPROVE , value = "是否自动Approval操作" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.TRUSTED , value = "是否信任" , required = false , dataTypeClass=Integer.class , example = "false"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { OauthClientVOMeta.PAGE_INDEX , OauthClientVOMeta.PAGE_SIZE , OauthClientVOMeta.SEARCH_FIELD , OauthClientVOMeta.SEARCH_VALUE , OauthClientVOMeta.IDS } ) 
	@NotNull(name = OauthClientVOMeta.ID)
	@SentinelResource(value = OauthClientServiceProxy.UPDATE)
	@PostMapping(OauthClientServiceProxy.UPDATE)
	public Result<OauthClient> update(OauthClientVO oauthClientVO) {
		Result<OauthClient> result=new Result<>();
		boolean suc=oauthClientService.update(oauthClientVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存认证客户端
	*/
	@ApiOperation(value = "保存认证客户端")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OauthClientVOMeta.ID , value = "客户端标识" , required = true , dataTypeClass=String.class , example = "credentials-client"),
		@ApiImplicitParam(name = OauthClientVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "证书客户端"),
		@ApiImplicitParam(name = OauthClientVOMeta.RESOURCE_IDS , value = "资源集合" , required = false , dataTypeClass=String.class , example = "sos-resource"),
		@ApiImplicitParam(name = OauthClientVOMeta.CLIENT_SECRET , value = "访问密匙" , required = false , dataTypeClass=String.class , example = "$2a$10$Dl2VwWVv/3h5KzK02gysheH7sy28weESL84DiO/CvUiGKcoXGTVlO"),
		@ApiImplicitParam(name = OauthClientVOMeta.SCOPE , value = "权限范围" , required = false , dataTypeClass=String.class , example = "read,write"),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTHORIZED_GRANT_TYPES , value = "授权类型" , required = false , dataTypeClass=String.class , example = "client_credentials"),
		@ApiImplicitParam(name = OauthClientVOMeta.WEB_SERVER_REDIRECT_URI , value = "重定向URI" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTHORITIES , value = "权限值列表" , required = false , dataTypeClass=String.class , example = "ROLE_UNITY,ROLE_USER"),
		@ApiImplicitParam(name = OauthClientVOMeta.ACCESS_TOKEN_VALIDITY , value = "access" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.REFRESH_TOKEN_VALIDITY , value = "refresh" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.NOTES , value = "备注信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OauthClientVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "false"),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTO_APPROVE , value = "是否自动Approval操作" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.TRUSTED , value = "是否信任" , required = false , dataTypeClass=Integer.class , example = "false"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { OauthClientVOMeta.PAGE_INDEX , OauthClientVOMeta.PAGE_SIZE , OauthClientVOMeta.SEARCH_FIELD , OauthClientVOMeta.SEARCH_VALUE , OauthClientVOMeta.IDS } )
	@NotNull(name = OauthClientVOMeta.ID)
	@SentinelResource(value = OauthClientServiceProxy.SAVE)
	@PostMapping(OauthClientServiceProxy.SAVE)
	public Result<OauthClient> save(OauthClientVO oauthClientVO) {
		Result<OauthClient> result=new Result<>();
		boolean suc=oauthClientService.save(oauthClientVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取认证客户端
	*/
	@ApiOperation(value = "获取认证客户端")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OauthClientVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = OauthClientVOMeta.ID)
	@SentinelResource(value = OauthClientServiceProxy.GET_BY_ID)
	@PostMapping(OauthClientServiceProxy.GET_BY_ID)
	public Result<OauthClient> getById(String id) {
		Result<OauthClient> result=new Result<>();
		OauthClient role=oauthClientService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询认证客户端
	*/
	@ApiOperation(value = "查询认证客户端")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OauthClientVOMeta.ID , value = "客户端标识" , required = true , dataTypeClass=String.class , example = "credentials-client"),
		@ApiImplicitParam(name = OauthClientVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "证书客户端"),
		@ApiImplicitParam(name = OauthClientVOMeta.RESOURCE_IDS , value = "资源集合" , required = false , dataTypeClass=String.class , example = "sos-resource"),
		@ApiImplicitParam(name = OauthClientVOMeta.CLIENT_SECRET , value = "访问密匙" , required = false , dataTypeClass=String.class , example = "$2a$10$Dl2VwWVv/3h5KzK02gysheH7sy28weESL84DiO/CvUiGKcoXGTVlO"),
		@ApiImplicitParam(name = OauthClientVOMeta.SCOPE , value = "权限范围" , required = false , dataTypeClass=String.class , example = "read,write"),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTHORIZED_GRANT_TYPES , value = "授权类型" , required = false , dataTypeClass=String.class , example = "client_credentials"),
		@ApiImplicitParam(name = OauthClientVOMeta.WEB_SERVER_REDIRECT_URI , value = "重定向URI" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTHORITIES , value = "权限值列表" , required = false , dataTypeClass=String.class , example = "ROLE_UNITY,ROLE_USER"),
		@ApiImplicitParam(name = OauthClientVOMeta.ACCESS_TOKEN_VALIDITY , value = "access" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.REFRESH_TOKEN_VALIDITY , value = "refresh" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.NOTES , value = "备注信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OauthClientVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "false"),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTO_APPROVE , value = "是否自动Approval操作" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.TRUSTED , value = "是否信任" , required = false , dataTypeClass=Integer.class , example = "false"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { OauthClientVOMeta.PAGE_INDEX , OauthClientVOMeta.PAGE_SIZE } )
	@SentinelResource(value = OauthClientServiceProxy.QUERY_LIST)
	@PostMapping(OauthClientServiceProxy.QUERY_LIST)
	public Result<List<OauthClient>> queryList(OauthClientVO sample) {
		Result<List<OauthClient>> result=new Result<>();
		List<OauthClient> list=oauthClientService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询认证客户端
	*/
	@ApiOperation(value = "分页查询认证客户端")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OauthClientVOMeta.ID , value = "客户端标识" , required = true , dataTypeClass=String.class , example = "credentials-client"),
		@ApiImplicitParam(name = OauthClientVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "证书客户端"),
		@ApiImplicitParam(name = OauthClientVOMeta.RESOURCE_IDS , value = "资源集合" , required = false , dataTypeClass=String.class , example = "sos-resource"),
		@ApiImplicitParam(name = OauthClientVOMeta.CLIENT_SECRET , value = "访问密匙" , required = false , dataTypeClass=String.class , example = "$2a$10$Dl2VwWVv/3h5KzK02gysheH7sy28weESL84DiO/CvUiGKcoXGTVlO"),
		@ApiImplicitParam(name = OauthClientVOMeta.SCOPE , value = "权限范围" , required = false , dataTypeClass=String.class , example = "read,write"),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTHORIZED_GRANT_TYPES , value = "授权类型" , required = false , dataTypeClass=String.class , example = "client_credentials"),
		@ApiImplicitParam(name = OauthClientVOMeta.WEB_SERVER_REDIRECT_URI , value = "重定向URI" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTHORITIES , value = "权限值列表" , required = false , dataTypeClass=String.class , example = "ROLE_UNITY,ROLE_USER"),
		@ApiImplicitParam(name = OauthClientVOMeta.ACCESS_TOKEN_VALIDITY , value = "access" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.REFRESH_TOKEN_VALIDITY , value = "refresh" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.NOTES , value = "备注信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OauthClientVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "false"),
		@ApiImplicitParam(name = OauthClientVOMeta.AUTO_APPROVE , value = "是否自动Approval操作" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OauthClientVOMeta.TRUSTED , value = "是否信任" , required = false , dataTypeClass=Integer.class , example = "false"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = OauthClientServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(OauthClientServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<OauthClient>> queryPagedList(OauthClientVO sample) {
		Result<PagedList<OauthClient>> result=new Result<>();
		PagedList<OauthClient> list=oauthClientService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}