package org.github.foxnic.web.system.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.system.UserTenant;
import org.github.foxnic.web.domain.system.UserTenantVO;
import org.github.foxnic.web.domain.system.meta.UserTenantMeta;
import org.github.foxnic.web.domain.system.meta.UserTenantVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.system.UserTenantServiceProxy;
import org.github.foxnic.web.system.service.IUserTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账户租户关系表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-26 15:18:47
 * @version
*/
@InDoc
@Api(tags = "系统服务/账户租户关系")
@ApiSort(0)
@RestController("SysUserTenantController")
public class UserTenantController extends SuperController {

	@Autowired
	private IUserTenantService userTenantService;


	/**
	 * 添加账户租户关系
	*/
	@ApiOperation(value = "添加账户租户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserTenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "482928963765678080"),
		@ApiImplicitParam(name = UserTenantVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=String.class , example = "480790327339261952"),
		@ApiImplicitParam(name = UserTenantVOMeta.OWNER_TENANT_ID , value = "所属的租户ID" , required = false , dataTypeClass=String.class , example = "T002"),
		@ApiImplicitParam(name = UserTenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserTenantVOMeta.ACTIVATED , value = "是否激活" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = UserTenantVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = UserTenantVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = UserTenantVOMeta.ID)
	@SentinelResource(value = UserTenantServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UserTenantServiceProxy.INSERT)
	public Result insert(UserTenantVO userTenantVO) {
		Result result=userTenantService.insert(userTenantVO);
		return result;
	}


	/**
	 * 删除账户租户关系
	*/
	@ApiOperation(value = "删除账户租户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserTenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "482928963765678080")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = UserTenantVOMeta.ID)
	@SentinelResource(value = UserTenantServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UserTenantServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=userTenantService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除账户租户关系 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除账户租户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserTenantVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3)
	@NotNull(name = UserTenantVOMeta.IDS)
	@SentinelResource(value = UserTenantServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UserTenantServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=userTenantService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新账户租户关系
	*/
	@ApiOperation(value = "更新账户租户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserTenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "482928963765678080"),
		@ApiImplicitParam(name = UserTenantVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=String.class , example = "480790327339261952"),
		@ApiImplicitParam(name = UserTenantVOMeta.OWNER_TENANT_ID , value = "所属的租户ID" , required = false , dataTypeClass=String.class , example = "T002"),
		@ApiImplicitParam(name = UserTenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserTenantVOMeta.ACTIVATED , value = "是否激活" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = UserTenantVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = UserTenantVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { UserTenantVOMeta.PAGE_INDEX , UserTenantVOMeta.PAGE_SIZE , UserTenantVOMeta.SEARCH_FIELD , UserTenantVOMeta.FUZZY_FIELD , UserTenantVOMeta.SEARCH_VALUE , UserTenantVOMeta.SORT_FIELD , UserTenantVOMeta.SORT_TYPE , UserTenantVOMeta.IDS } )
	@NotNull(name = UserTenantVOMeta.ID)
	@SentinelResource(value = UserTenantServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UserTenantServiceProxy.UPDATE)
	public Result update(UserTenantVO userTenantVO) {
		Result result=userTenantService.update(userTenantVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存账户租户关系
	*/
	@ApiOperation(value = "保存账户租户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserTenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "482928963765678080"),
		@ApiImplicitParam(name = UserTenantVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=String.class , example = "480790327339261952"),
		@ApiImplicitParam(name = UserTenantVOMeta.OWNER_TENANT_ID , value = "所属的租户ID" , required = false , dataTypeClass=String.class , example = "T002"),
		@ApiImplicitParam(name = UserTenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserTenantVOMeta.ACTIVATED , value = "是否激活" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = UserTenantVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = UserTenantVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { UserTenantVOMeta.PAGE_INDEX , UserTenantVOMeta.PAGE_SIZE , UserTenantVOMeta.SEARCH_FIELD , UserTenantVOMeta.FUZZY_FIELD , UserTenantVOMeta.SEARCH_VALUE , UserTenantVOMeta.SORT_FIELD , UserTenantVOMeta.SORT_TYPE , UserTenantVOMeta.IDS } )
	@NotNull(name = UserTenantVOMeta.ID)
	@SentinelResource(value = UserTenantServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UserTenantServiceProxy.SAVE)
	public Result save(UserTenantVO userTenantVO) {
		Result result=userTenantService.save(userTenantVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取账户租户关系
	*/
	@ApiOperation(value = "获取账户租户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserTenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = UserTenantVOMeta.ID)
	@SentinelResource(value = UserTenantServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UserTenantServiceProxy.GET_BY_ID)
	public Result<UserTenant> getById(String id) {
		Result<UserTenant> result=new Result<>();
		UserTenant userTenant=userTenantService.getById(id);
		// 关联出 所属租户 数据
		userTenantService.join(userTenant,UserTenantMeta.TENANT);
		// 关联出 工号 数据
		userTenantService.join(userTenant,UserTenantMeta.EMPLOYEE);
		//关联出 人员 数据
		userTenantService.dao().join(userTenant.getEmployee(), Person.class);
		result.success(true).data(userTenant);
		return result;
	}


	/**
	 * 批量删除账户租户关系 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除账户租户关系")
		@ApiImplicitParams({
				@ApiImplicitParam(name = UserTenantVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3)
		@NotNull(name = UserTenantVOMeta.IDS)
		@SentinelResource(value = UserTenantServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UserTenantServiceProxy.GET_BY_IDS)
	public Result<List<UserTenant>> getByIds(List<String> ids) {
		Result<List<UserTenant>> result=new Result<>();
		List<UserTenant> list=userTenantService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询账户租户关系
	*/
	@ApiOperation(value = "查询账户租户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserTenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "482928963765678080"),
		@ApiImplicitParam(name = UserTenantVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=String.class , example = "480790327339261952"),
		@ApiImplicitParam(name = UserTenantVOMeta.OWNER_TENANT_ID , value = "所属的租户ID" , required = false , dataTypeClass=String.class , example = "T002"),
		@ApiImplicitParam(name = UserTenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserTenantVOMeta.ACTIVATED , value = "是否激活" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = UserTenantVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = UserTenantVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { UserTenantVOMeta.PAGE_INDEX , UserTenantVOMeta.PAGE_SIZE } )
	@SentinelResource(value = UserTenantServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UserTenantServiceProxy.QUERY_LIST)
	public Result<List<UserTenant>> queryList(UserTenantVO sample) {
		Result<List<UserTenant>> result=new Result<>();
		List<UserTenant> list=userTenantService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询账户租户关系
	*/
	@ApiOperation(value = "分页查询账户租户关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UserTenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "482928963765678080"),
		@ApiImplicitParam(name = UserTenantVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=String.class , example = "480790327339261952"),
		@ApiImplicitParam(name = UserTenantVOMeta.OWNER_TENANT_ID , value = "所属的租户ID" , required = false , dataTypeClass=String.class , example = "T002"),
		@ApiImplicitParam(name = UserTenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = UserTenantVOMeta.ACTIVATED , value = "是否激活" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = UserTenantVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = UserTenantVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = UserTenantServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UserTenantServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<UserTenant>> queryPagedList(UserTenantVO sample) {
		Result<PagedList<UserTenant>> result=new Result<>();
		PagedList<UserTenant> list=userTenantService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 所属租户 数据
		userTenantService.join(list,UserTenantMeta.TENANT);
		// 关联出 工号 数据
		userTenantService.join(list,UserTenantMeta.EMPLOYEE);
		//
		List<Employee> employees= CollectorUtil.collectList(list, UserTenant::getEmployee);
		userTenantService.dao().join(employees,Person.class);

		result.success(true).data(list);
		return result;
	}



}
