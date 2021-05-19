package com.scientific.tailoring.system.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.scientific.tailoring.constants.db.Tailoring.SYS_USER;
import com.scientific.tailoring.domain.system.User;
import com.scientific.tailoring.domain.system.UserEditModel;
import com.scientific.tailoring.domain.system.UserVO;
import com.scientific.tailoring.domain.system.meta.UserVOMeta;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.proxy.system.UserServiceProxy;
import com.scientific.tailoring.system.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @author 李方捷
 * @since 2021-03-25 07:49:43
*/

@Api(tags = "用户")
@ApiSort(1004)
@RestController("SysUserController")
public class UserController extends SuperController {

	@Autowired
	private IUserService userService;

	
	/**
	 * 添加用户
	*/
	@RequiresPermissions("SysUser:insert")
	@ApiOperation(value = "添加用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT , value = "登录帐号" , required = true , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.NAME , value = "姓名" , required = true , dataTypeClass=String.class , example = "管理员"),
		@ApiImplicitParam(name = UserVOMeta.PASSWORD , value = "登录密码" , required = false , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.MOBILE , value = "手机号码" , required = false , dataTypeClass=String.class , example = "13777028943"),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "头像文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = UserVOMeta.LATEST_LOGIN_TIME , value = "最近登录时间" , required = false , dataTypeClass=Date.class , example = "2021-03-25 10:07:59"),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Boolean.class , example = "true"),
	})
	@NotNull(name = UserVOMeta.ACCOUNT)
	@ApiOperationSupport(order=1)
	@SentinelResource(value = UserServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserServiceProxy.INSERT)
	public  Result<User> insert(UserVO userVO) {
		Result<User> result=userService.isUserExists(userVO);
		if(result.failure()) {
			return result;
		}
		boolean suc=userService.insertEntityAndRole(userVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除用户
	*/
	@RequiresPermissions("SysUser:deleteById")
	@ApiOperation(value = "删除用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = UserVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = UserServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=userService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新用户
	*/
	@RequiresPermissions("SysUser:update")
	@ApiOperation(value = "更新用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT , value = "登录帐号" , required = true , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.NAME , value = "姓名" , required = true , dataTypeClass=String.class , example = "管理员"),
		@ApiImplicitParam(name = UserVOMeta.PASSWORD , value = "登录密码" , required = true , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.MOBILE , value = "手机号码" , required = false , dataTypeClass=String.class , example = "13777028943"),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "头像文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Boolean.class , example = "true"),
	})
	@NotNull(name = UserVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {UserVOMeta.LATEST_LOGIN_TIME,UserVOMeta.PAGE_INDEX , UserVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = UserServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserServiceProxy.UPDATE)
	public  Result<User> update(UserVO userVO) {
		Result<User> result=userService.isUserExists(userVO);
		if(result.failure()) {
			return result;
		}
		boolean suc=userService.updateEntity(userVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取用户
	*/
	@RequiresPermissions("SysUser:getById")
	@ApiOperation(value = "按主键获取用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@NotNull(name = UserVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = UserServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserServiceProxy.GET_BY_ID)
	public  Result<UserEditModel> getById(Long id) {
		Result<UserEditModel> result=new Result<>();
		UserEditModel user=userService.getUserEditModel(id);
		result.success(true).data(user);
		return result;
	}
	
	
	/**
	 * 重置用户密码
	*/
	@RequiresPermissions("SysUser:resetPasswd")
	@ApiOperation(value = "重置用户密码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1")
	})
	@NotNull(name = UserVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = UserServiceProxy.RESET_PASSWD, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserServiceProxy.RESET_PASSWD)
	public  Result<User> resetPasswd(Long id) {
		userService.resetPasswd(id);
		return ErrorDesc.success();
	}

	
	/**
	 * 查询全部符合条件的用户
	*/
	@RequiresPermissions("SysUser:queryList")
	@ApiOperation(value = "查询用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT , value = "登录帐号" , required = false , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "管理员"),
		@ApiImplicitParam(name = UserVOMeta.PASSWORD , value = "登录密码" , required = false , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.MOBILE , value = "手机号码" , required = false , dataTypeClass=String.class , example = "13777028943"),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "头像文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = UserVOMeta.LATEST_LOGIN_TIME , value = "最近登录时间" , required = false , dataTypeClass=Date.class , example = "2021-03-25 10:07:59"),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class , example = "true"),
	})
	@ApiOperationSupport(ignoreParameters = {UserVOMeta.PAGE_INDEX , UserVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = UserServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserServiceProxy.QUERY_LIST)
	public  Result<List<User>> queryList(UserVO sample) {
		Result<List<User>> result=new Result<>();
		List<User> list=userService.queryList(sample);
		list.forEach(usr->{usr.setPassword("******");});
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的用户
	*/
	@RequiresPermissions("SysUser:queryPagedList")
	@ApiOperation(value = "分页查询用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT , value = "登录帐号" , required = false , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "管理员"),
		@ApiImplicitParam(name = UserVOMeta.PASSWORD , value = "登录密码" , required = false , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.MOBILE , value = "手机号码" , required = false , dataTypeClass=String.class , example = "13777028943"),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "头像文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = UserVOMeta.LATEST_LOGIN_TIME , value = "最近登录时间" , required = false , dataTypeClass=Date.class , example = "2021-03-25 10:07:59"),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Boolean.class , example = "true"),
		@ApiImplicitParam(name = UserVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = UserVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = UserServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(UserServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<User>> queryPagedList(UserVO sample) { 
		Result<PagedList<User>> result=new Result<>(); 
		PagedList<User> list=userService.queryPagedList(sample,OrderBy.byDesc(SYS_USER.CREATE_TIME),sample.getPageSize(),sample.getPageIndex());
		list.forEach(usr->{usr.setPassword("******");});
		result.success(true).data(list);
		return result;
	}


}