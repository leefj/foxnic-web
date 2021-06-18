package org.github.foxnic.web.oauth.controller;

 
import java.util.Date;
import java.util.List;

import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.UserVO;
import org.github.foxnic.web.domain.oauth.meta.UserVOMeta;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.oauth.login.SessionCache;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.session.SessionUser;
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
 * 账户表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:27
*/

@Api(tags = "账户")
@ApiSort(0)
@RestController("SysUserController")
public class UserController extends SuperController {

	@Autowired
	private IUserService userService;

	@Autowired
	private SessionCache sessionCache;
	/**
	 * 添加账户
	*/
	@ApiOperation(value = "添加账户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.NAME , value = "账户" , required = false , dataTypeClass=String.class , example = "test"),
		@ApiImplicitParam(name = UserVOMeta.PASSWD , value = "密码" , required = false , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.SALT , value = "盐" , required = false , dataTypeClass=String.class , example = "admin999"),
		@ApiImplicitParam(name = UserVOMeta.PERSON_ID , value = "人员ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "最后登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = UserVOMeta.ID)
	@NotNull(name = UserVOMeta.VALID)
	@SentinelResource(value = UserServiceProxy.INSERT)
	@PostMapping(UserServiceProxy.INSERT)
	public Result<User> insert(UserVO userVO) {
		Result<User> result=new Result<>();
		boolean suc=userService.insert(userVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除账户
	*/
	@ApiOperation(value = "删除账户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = UserVOMeta.ID)
	@SentinelResource(value = UserServiceProxy.DELETE)
	@PostMapping(UserServiceProxy.DELETE)
	public Result<User> deleteById(String id) {
		Result<User> result=new Result<>();
		boolean suc=userService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除账户 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除账户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = UserVOMeta.IDS)
	@SentinelResource(value = UserServiceProxy.BATCH_DELETE)
	@PostMapping(UserServiceProxy.BATCH_DELETE)
	public Result<User> deleteByIds(List<String> ids) {
		Result<User> result=new Result<>();
		boolean suc=userService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新账户
	*/
	@ApiOperation(value = "更新账户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.NAME , value = "账户" , required = false , dataTypeClass=String.class , example = "test"),
		@ApiImplicitParam(name = UserVOMeta.PASSWD , value = "密码" , required = false , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.SALT , value = "盐" , required = false , dataTypeClass=String.class , example = "admin999"),
		@ApiImplicitParam(name = UserVOMeta.PERSON_ID , value = "人员ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "最后登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { UserVOMeta.PAGE_INDEX , UserVOMeta.PAGE_SIZE , UserVOMeta.SEARCH_FIELD , UserVOMeta.SEARCH_VALUE , UserVOMeta.IDS } ) 
	@NotNull(name = UserVOMeta.ID)
	@NotNull(name = UserVOMeta.VALID)
	@SentinelResource(value = UserServiceProxy.UPDATE)
	@PostMapping(UserServiceProxy.UPDATE)
	public Result<User> update(UserVO userVO) {
		Result<User> result=new Result<>();
		boolean suc=userService.update(userVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存账户
	*/
	@ApiOperation(value = "保存账户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.NAME , value = "账户" , required = false , dataTypeClass=String.class , example = "test"),
		@ApiImplicitParam(name = UserVOMeta.PASSWD , value = "密码" , required = false , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.SALT , value = "盐" , required = false , dataTypeClass=String.class , example = "admin999"),
		@ApiImplicitParam(name = UserVOMeta.PERSON_ID , value = "人员ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "最后登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { UserVOMeta.PAGE_INDEX , UserVOMeta.PAGE_SIZE , UserVOMeta.SEARCH_FIELD , UserVOMeta.SEARCH_VALUE , UserVOMeta.IDS } )
	@NotNull(name = UserVOMeta.ID)
	@NotNull(name = UserVOMeta.VALID)
	@SentinelResource(value = UserServiceProxy.SAVE)
	@PostMapping(UserServiceProxy.SAVE)
	public Result<User> save(UserVO userVO) {
		Result<User> result=new Result<>();
		boolean suc=userService.save(userVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取账户
	*/
	@ApiOperation(value = "获取账户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = UserVOMeta.ID)
	@SentinelResource(value = UserServiceProxy.GET_BY_ID)
	@PostMapping(UserServiceProxy.GET_BY_ID)
	public Result<User> getById(String id) {
		Result<User> result=new Result<>();
		User role=userService.getById(id);
		result.success(true).data(role);
		return result;
	}
	
	
	/**
	 * 获取账户
	*/
	@ApiOperation(value = "获取当前登录账户")
	@ApiOperationSupport(order=6)
	@SentinelResource(value = UserServiceProxy.GET_SESSION_USER_URI)
	@PostMapping(UserServiceProxy.GET_SESSION_USER_URI)
	public Result<SessionUser> getSessionUser(String sessionId) {
		Result<SessionUser> result=new Result<>();
		SessionUser user=sessionCache.get(sessionId);
		result.data(user);
		return result;
	}

	
	/**
	 * 查询账户
	*/
	@ApiOperation(value = "查询账户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.NAME , value = "账户" , required = false , dataTypeClass=String.class , example = "test"),
		@ApiImplicitParam(name = UserVOMeta.PASSWD , value = "密码" , required = false , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.SALT , value = "盐" , required = false , dataTypeClass=String.class , example = "admin999"),
		@ApiImplicitParam(name = UserVOMeta.PERSON_ID , value = "人员ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "最后登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { UserVOMeta.PAGE_INDEX , UserVOMeta.PAGE_SIZE } )
	@SentinelResource(value = UserServiceProxy.QUERY_LIST)
	@PostMapping(UserServiceProxy.QUERY_LIST)
	public Result<List<User>> queryList(UserVO sample) {
		Result<List<User>> result=new Result<>();
		List<User> list=userService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询账户
	*/
	@ApiOperation(value = "分页查询账户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.NAME , value = "账户" , required = false , dataTypeClass=String.class , example = "test"),
		@ApiImplicitParam(name = UserVOMeta.PASSWD , value = "密码" , required = false , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.SALT , value = "盐" , required = false , dataTypeClass=String.class , example = "admin999"),
		@ApiImplicitParam(name = UserVOMeta.PERSON_ID , value = "人员ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "最后登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = UserServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(UserServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<User>> queryPagedList(UserVO sample) {
		Result<PagedList<User>> result=new Result<>();
		PagedList<User> list=userService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


	


}