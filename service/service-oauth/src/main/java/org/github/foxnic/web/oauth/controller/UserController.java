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
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.UserVO;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.domain.oauth.meta.UserVOMeta;
import org.github.foxnic.web.domain.system.meta.UserTenantMeta;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.oauth.login.SessionCache;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 账户表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:27
 * @version manual
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
		@ApiImplicitParam(name = UserVOMeta.PHONE , value = "手机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "头像ID" , required = false , dataTypeClass=String.class , example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE , value = "语言" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY , value = "缓存键" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "最后登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = UserVOMeta.ID)
	@NotNull(name = UserVOMeta.VALID)
	@SentinelResource(value = UserServiceProxy.INSERT)
	@PostMapping(UserServiceProxy.INSERT)
	public Result insert(UserVO userVO) {
		Result result=userService.insert(userVO);
		return result;
	}


	/**
	 * 删除账户
	*/
	@ApiOperation(value = "删除账户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
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
	public Result deleteByIds(List<String> ids) {
		Result result=userService.deleteByIdsLogical(ids);
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
		@ApiImplicitParam(name = UserVOMeta.PHONE , value = "手机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "头像ID" , required = false , dataTypeClass=String.class , example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE , value = "语言" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY , value = "缓存键" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "最后登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { UserVOMeta.PAGE_INDEX , UserVOMeta.PAGE_SIZE , UserVOMeta.SEARCH_FIELD , UserVOMeta.SEARCH_VALUE , UserVOMeta.IDS } )
	@NotNull(name = UserVOMeta.ID)
	@NotNull(name = UserVOMeta.VALID)
	@SentinelResource(value = UserServiceProxy.UPDATE)
	@PostMapping(UserServiceProxy.UPDATE)
	public Result update(UserVO userVO) {
		Result result=userService.update(userVO,SaveMode.NOT_NULL_FIELDS);
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
		@ApiImplicitParam(name = UserVOMeta.PHONE , value = "手机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "头像ID" , required = false , dataTypeClass=String.class , example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE , value = "语言" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY , value = "缓存键" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "最后登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { UserVOMeta.PAGE_INDEX , UserVOMeta.PAGE_SIZE , UserVOMeta.SEARCH_FIELD , UserVOMeta.SEARCH_VALUE , UserVOMeta.IDS } )
	@NotNull(name = UserVOMeta.ID)
	@NotNull(name = UserVOMeta.VALID)
	@SentinelResource(value = UserServiceProxy.SAVE)
	@PostMapping(UserServiceProxy.SAVE)
	public Result<User> save(UserVO userVO) {
		Result result=userService.save(userVO,SaveMode.NOT_NULL_FIELDS);
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
		@ApiImplicitParam(name = UserVOMeta.PHONE , value = "手机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "头像ID" , required = false , dataTypeClass=String.class , example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE , value = "语言" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY , value = "缓存键" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "最后登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { UserVOMeta.PAGE_INDEX , UserVOMeta.PAGE_SIZE } )
	@SentinelResource(value = UserServiceProxy.QUERY_LIST)
	@PostMapping(UserServiceProxy.QUERY_LIST)
	public Result<List<User>> queryList(UserVO sample) {
		Result<List<User>> result=new Result<>();
		List<User> list=userService.queryList(sample);
		for (User user : list) {
			user.setPasswd("");
		}
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
		@ApiImplicitParam(name = UserVOMeta.PHONE , value = "手机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "头像ID" , required = false , dataTypeClass=String.class , example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE , value = "语言" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY , value = "缓存键" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "最后登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = UserServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(UserServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<User>> queryPagedList(UserVO sample) {
		Result<PagedList<User>> result=new Result<>();
		PagedList<User> list=userService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		for (User user : list) {
			user.setPasswd("");
		}
//		userService.join(list, Role.class);
		//填充账户模型
		userService.dao().fill(list)
//				.with(UserMeta.MENUS)
//				.with(UserMeta.MENUS, MenuMeta.RESOURCES)
//				.with(UserMeta.MENUS, MenuMeta.PATH_RESOURCE)
				.with(UserMeta.ROLES)
//				.with(UserMeta.ROLE_MENUS)
//				.with(UserMeta.JOINED_TENANTS, UserTenantMeta.TENANT, TenantMeta.COMPANY)
				.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.PERSON)
//				.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.POSITIONS)
//				.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.ORGANIZATIONS)
//				.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.BUSI_ROLES)
				.execute();
		result.success(true).data(list);
		return result;
	}

	@ApiOperation(value = "更改当前登录用户密码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.NAME , value = "账户" , required = false , dataTypeClass=String.class , example = "test"),
		@ApiImplicitParam(name = UserVOMeta.PASSWD , value = "密码" , required = false , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.PHONE , value = "手机号码" , required = false , dataTypeClass=String.class , example = "13888584527"),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "头像ID" , required = false , dataTypeClass=String.class , example = "465814936602279936"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE , value = "语言" , required = false , dataTypeClass=String.class , example = "defaults"),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "true"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY , value = "缓存键" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "最后登录时间" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
			@ApiImplicitParam(name = "oldpwd" , value = "原始密码" ,required = true , dataTypeClass=String.class),
			@ApiImplicitParam(name = "newpwd" , value = "新密码" ,required = true , dataTypeClass=String.class),
	})
	@NotNull(name = "oldpwd")
	@NotNull(name = "newpwd")
	@PostMapping(UserServiceProxy.CHANGE_PASSWD)
	@ApiOperationSupport(order=4)
	public  Result changePasswd(String oldpwd,String newpwd) {
		return userService.changePasswd(this.getSessionUserId(),oldpwd,newpwd);
	}





}
