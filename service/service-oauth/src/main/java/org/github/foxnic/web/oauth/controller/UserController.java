package org.github.foxnic.web.oauth.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.foxnic.commons.encrypt.Base64Util;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.log.PerformanceLogger;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.FieldsBuilder;
import com.github.foxnic.dao.entity.QuerySQLBuilder;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.oauth.Role;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * ????????? ???????????????
 * </p>
 * @author ????????? , leefangjie@qq.com
 * @since 2021-06-01 09:27:27
 * @version manual
*/

@Api(tags = "??????")
@ApiSort(0)
@RestController("SysUserController")
public class UserController extends SuperController {

	@Autowired
	private IUserService userService;

	@Autowired
	private SessionCache sessionCache;
	/**
	 * ????????????
	*/
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT , value = "??????" , required = true , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.REAL_NAME , value = "??????" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PASSWD , value = "??????" , required = true , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.PHONE , value = "????????????" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE , value = "??????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "????????????" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY , value = "?????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "??????????????????" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = UserVOMeta.ID)
	@NotNull(name = UserVOMeta.VALID)
	@SentinelResource(value = UserServiceProxy.INSERT)
	@PostMapping(UserServiceProxy.INSERT)
	public Result insert(UserVO userVO) {
		this.validator().asserts(userVO.getRealName()).require();
		if(this.validator().failure()) {
			return this.validator().getMergedResult();
		}

		Result result=userService.insert(userVO);
		return result;
	}


	/**
	 * ????????????
	*/
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = UserVOMeta.ID)
	@SentinelResource(value = UserServiceProxy.DELETE)
	@PostMapping(UserServiceProxy.DELETE)
	public Result<User> deleteById(String id) {
		return userService.deleteByIdLogical(id);
	}


	/**
	 * ?????????????????? <br>
	 * ???????????????????????????????????????
	*/
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
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
	 * ????????????
	*/
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT , value = "??????" , required = true , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.REAL_NAME , value = "??????" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PASSWD , value = "??????" , required = true , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.PHONE , value = "????????????" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE , value = "??????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "????????????" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY , value = "?????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "??????????????????" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
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
	 * ????????????
	 */
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = UserVOMeta.REAL_NAME , value = "??????" , required = true , dataTypeClass=String.class),
			@ApiImplicitParam(name = UserVOMeta.PHONE , value = "????????????" , required = true , dataTypeClass=String.class),
			@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "1110"),
			@ApiImplicitParam(name = UserVOMeta.LANGUAGE , value = "??????" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { UserVOMeta.PAGE_INDEX , UserVOMeta.PAGE_SIZE , UserVOMeta.SEARCH_FIELD , UserVOMeta.SEARCH_VALUE , UserVOMeta.IDS } )
	@SentinelResource(value = UserServiceProxy.UPDATE_PROFILE)
	@PostMapping(UserServiceProxy.UPDATE_PROFILE)
	public Result updateProfile(UserVO userVO) {

		User user=userService.getById(this.getSessionUserId());
		if(user==null) {
			return ErrorDesc.failure().message("???????????????????????????");
		}

		user.setRealName(userVO.getRealName());
		user.setPhone(userVO.getPhone());
		user.setPortraitId(userVO.getPortraitId());
		user.setLanguage(userVO.getLanguage());

		Result result=userService.update(user,SaveMode.DIRTY_FIELDS);
		user.setPasswd("******");
		return result.data(user);
	}


	/**
	 * ????????????
	*/
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT , value = "??????" , required = true , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.REAL_NAME , value = "??????" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PASSWD , value = "??????" , required = true , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.PHONE , value = "????????????" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE , value = "??????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "????????????" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY , value = "?????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "??????????????????" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
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
	 * ????????????
	*/
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "1"),
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
	 * ????????????
	 */
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = UserVOMeta.ACCOUNT , value = "??????" , required = true , dataTypeClass=String.class , example = "leefj"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = UserVOMeta.ACCOUNT)
	@SentinelResource(value = UserServiceProxy.GET_BY_ACCOUNT)
	@PostMapping(UserServiceProxy.GET_BY_ACCOUNT)
	public Result<User> getByAccount(String account) {
		Result<User> result=new Result<>();
		User user=new User();
		user.setAccount(account);
		user=userService.queryEntity(user);
		result.success(true).data(user);
		return result;
	}

	/**
	 * ????????????
	 */
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = UserVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=String.class , example = "['1','2','3']"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = UserVOMeta.IDS)
	@SentinelResource(value = UserServiceProxy.GET_BY_IDS)
	@PostMapping(UserServiceProxy.GET_BY_IDS)
	public Result<List<User>> getByIds(List<String> ids) {
		Result<List<User>> result=new Result<>();
		List<User> users=userService.getByIds(ids);
		result.success(true).data(users);
		return result;
	}


	/**
	 * ????????????
	*/
	@ApiOperation(value = "????????????????????????")
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
	 * ????????????
	*/
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT , value = "??????" , required = true , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.REAL_NAME , value = "??????" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PASSWD , value = "??????" , required = true , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.PHONE , value = "????????????" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE , value = "??????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "????????????" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY , value = "?????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "??????????????????" , required = false , dataTypeClass=Date.class , example = "2021-05-31 03:09:23"),
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
	 * ??????????????????
	*/
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT , value = "??????" , required = true , dataTypeClass=String.class , example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.REAL_NAME , value = "??????" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PASSWD , value = "??????" , required = true , dataTypeClass=String.class , example = "******"),
		@ApiImplicitParam(name = UserVOMeta.PHONE , value = "????????????" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE , value = "??????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID , value = "????????????" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY , value = "?????????" , required = false , dataTypeClass=String.class , example = "443c1"),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME , value = "??????????????????" , required = false , dataTypeClass=Date.class , example = "2022-04-19 02:57:10"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = UserServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(UserServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<User>> queryPagedList(UserVO sample) {

		RequestParameter requestParameter=this.getParameter();
		Logger.info(requestParameter.getRequestTimeString() +","+ requestParameter.getRequestTimestamp());

		Result<PagedList<User>> result=new Result<>();

		PerformanceLogger pl=new PerformanceLogger(true);
		pl.collect("A");

		PagedList<User> list=userService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		pl.collect("B");
		for (User user : list) {
			user.setPasswd("");
		}

		pl.collect("C");
		DAO dao=userService.dao();
		FieldsBuilder roleFields= FieldsBuilder.build(dao, FoxnicWeb.SYS_ROLE.$TABLE).addAll().removeDBTreatyFields();
		FieldsBuilder employeeFields= FieldsBuilder.build(dao, FoxnicWeb.HRM_EMPLOYEE.$TABLE).addAll().removeDBTreatyFields();
		FieldsBuilder personFields= FieldsBuilder.build(dao, FoxnicWeb.HRM_PERSON.$TABLE).addAll().removeDBTreatyFields();
		FieldsBuilder tenantFields= FieldsBuilder.build(dao, FoxnicWeb.SYS_TENANT.$TABLE).addAll().removeDBTreatyFields();
		FieldsBuilder userTenantFields= FieldsBuilder.build(dao, FoxnicWeb.SYS_USER_TENANT.$TABLE).addAll().removeDBTreatyFields();
		pl.collect("D");

		//??????????????????
		userService.dao().fill(list)
				.with(UserMeta.ROLES)
				.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.PERSON)
				.fields(roleFields,employeeFields,personFields,tenantFields,userTenantFields)
				.execute();

//		pl.collect("Start Clone");
//		int z=0;
//		List<User> users=new ArrayList<>();
//		for (User user : list) {
//			for (int i = 0; i < 1000; i++) {
////				User user1=new User();
//				User u=user.duplicate(false);
//				users.add(u);
//				z++;
//			}
//		}
//		pl.collect("End Clone ?????? "+z+" ???");

//		// ????????????????????????
//		for (User user : list) {
//			user.setActivatedTenant(null);
//			user.setCompositeParameter(null);
//			if(user.getRoles()!=null) {
//				for (Role role : user.getRoles()) {
//					role.setMenus(null);
//				}
//			}
//		}

		pl.collect("E");

		result.success(true).data(list);
		pl.collect("F");
		pl.info("queryPagedList");
		return result;
	}

	@ApiOperation(value = "??????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "oldpwd" , value = "????????????" ,required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = "newpwd" , value = "?????????" ,required = true , dataTypeClass=String.class)
	})
	@NotNull(name = "oldpwd")
	@NotNull(name = "newpwd")
	@PostMapping(UserServiceProxy.CHANGE_PASSWD)
	@ApiOperationSupport(order=4)
	public  Result changePasswd(String oldpwd,String newpwd) {
		return userService.changePasswd(this.getSessionUserId(),oldpwd,newpwd);
	}


	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId" , value = "??????ID" ,required = true , dataTypeClass=String.class),
			@ApiImplicitParam(name = "adminPwd" , value = "???????????????" ,required = true , dataTypeClass=String.class),
			@ApiImplicitParam(name = "pwd" , value = "?????????" ,required = true , dataTypeClass=String.class),
	})
	@NotNull(name = "adminPwd")
	@NotNull(name = "pwd")
	@NotNull(name = "userId")
	@PostMapping(UserServiceProxy.RESET_PASSWD)
	@ApiOperationSupport(order=4)
	public  Result resetPasswd(String userId,String adminPwd,String pwd) {
		for (int i = 0; i < 4; i++) {
			adminPwd= Base64Util.decode(adminPwd);
			pwd= Base64Util.decode(pwd);
		}
		return userService.resetPasswd(userId,adminPwd,pwd);
	}





}