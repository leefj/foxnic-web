package org.github.foxnic.web.oauth.controller;

 
import java.util.List;

import org.github.foxnic.web.domain.oauth.Token;
import org.github.foxnic.web.domain.oauth.TokenVO;
import org.github.foxnic.web.domain.oauth.meta.TokenVOMeta;
import org.github.foxnic.web.oauth.service.ITokenService;
import org.github.foxnic.web.proxy.oauth.TokenServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * Token表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-02 14:46:36
*/

@Api(tags = "Token")
@ApiSort(0)
@RestController("SysTokenController")
public class TokenController {

	@Autowired
	private ITokenService tokenService;

	
	/**
	 * 添加Token
	*/
	@ApiOperation(value = "添加Token")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TokenVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = TokenVOMeta.USER_ID , value = "user_id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = TokenVOMeta.JTI , value = "Token标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TokenVOMeta.ACCESS_TOKEN , value = "访问用Token" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TokenVOMeta.REFRESH_TOKEN , value = "刷新用Token" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = TokenVOMeta.ID)
	@NotNull(name = TokenVOMeta.USER_ID)
	@SentinelResource(value = TokenServiceProxy.INSERT)
	@PostMapping(TokenServiceProxy.INSERT)
	public Result<Token> insert(TokenVO tokenVO) {
		Result<Token> result=new Result<>();
		boolean suc=tokenService.insert(tokenVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除Token
	*/
	@ApiOperation(value = "删除Token")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TokenVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = TokenVOMeta.ID)
	@SentinelResource(value = TokenServiceProxy.DELETE)
	@PostMapping(TokenServiceProxy.DELETE)
	public Result<Token> deleteById(String id) {
		Result<Token> result=new Result<>();
		boolean suc=tokenService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除Token <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除Token")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TokenVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = TokenVOMeta.IDS)
	@SentinelResource(value = TokenServiceProxy.BATCH_DELETE)
	@PostMapping(TokenServiceProxy.BATCH_DELETE)
	public Result<Token> deleteByIds(List<Integer> ids) {
		Result<Token> result=new Result<>();
		boolean suc=tokenService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新Token
	*/
	@ApiOperation(value = "更新Token")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TokenVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = TokenVOMeta.USER_ID , value = "user_id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = TokenVOMeta.JTI , value = "Token标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TokenVOMeta.ACCESS_TOKEN , value = "访问用Token" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TokenVOMeta.REFRESH_TOKEN , value = "刷新用Token" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { TokenVOMeta.PAGE_INDEX , TokenVOMeta.PAGE_SIZE , TokenVOMeta.SEARCH_FIELD , TokenVOMeta.SEARCH_VALUE , TokenVOMeta.IDS } ) 
	@NotNull(name = TokenVOMeta.ID)
	@NotNull(name = TokenVOMeta.USER_ID)
	@SentinelResource(value = TokenServiceProxy.UPDATE)
	@PostMapping(TokenServiceProxy.UPDATE)
	public Result<Token> update(TokenVO tokenVO) {
		Result<Token> result=new Result<>();
		boolean suc=tokenService.update(tokenVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存Token
	*/
	@ApiOperation(value = "保存Token")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TokenVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = TokenVOMeta.USER_ID , value = "user_id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = TokenVOMeta.JTI , value = "Token标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TokenVOMeta.ACCESS_TOKEN , value = "访问用Token" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TokenVOMeta.REFRESH_TOKEN , value = "刷新用Token" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TokenVOMeta.PAGE_INDEX , TokenVOMeta.PAGE_SIZE , TokenVOMeta.SEARCH_FIELD , TokenVOMeta.SEARCH_VALUE , TokenVOMeta.IDS } )
	@NotNull(name = TokenVOMeta.ID)
	@NotNull(name = TokenVOMeta.USER_ID)
	@SentinelResource(value = TokenServiceProxy.SAVE)
	@PostMapping(TokenServiceProxy.SAVE)
	public Result<Token> save(TokenVO tokenVO) {
		Result<Token> result=new Result<>();
		boolean suc=tokenService.save(tokenVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取Token
	*/
	@ApiOperation(value = "获取Token")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TokenVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = TokenVOMeta.ID)
	@SentinelResource(value = TokenServiceProxy.GET_BY_ID)
	@PostMapping(TokenServiceProxy.GET_BY_ID)
	public Result<Token> getById(String id) {
		Result<Token> result=new Result<>();
		Token role=tokenService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询Token
	*/
	@ApiOperation(value = "查询Token")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TokenVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = TokenVOMeta.USER_ID , value = "user_id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = TokenVOMeta.JTI , value = "Token标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TokenVOMeta.ACCESS_TOKEN , value = "访问用Token" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TokenVOMeta.REFRESH_TOKEN , value = "刷新用Token" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TokenVOMeta.PAGE_INDEX , TokenVOMeta.PAGE_SIZE } )
	@SentinelResource(value = TokenServiceProxy.QUERY_LIST)
	@PostMapping(TokenServiceProxy.QUERY_LIST)
	public Result<List<Token>> queryList(TokenVO sample) {
		Result<List<Token>> result=new Result<>();
		List<Token> list=tokenService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询Token
	*/
	@ApiOperation(value = "分页查询Token")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TokenVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = TokenVOMeta.USER_ID , value = "user_id" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = TokenVOMeta.JTI , value = "Token标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TokenVOMeta.ACCESS_TOKEN , value = "访问用Token" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TokenVOMeta.REFRESH_TOKEN , value = "刷新用Token" , required = false , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = TokenServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(TokenServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Token>> queryPagedList(TokenVO sample) {
		Result<PagedList<Token>> result=new Result<>();
		PagedList<Token> list=tokenService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}