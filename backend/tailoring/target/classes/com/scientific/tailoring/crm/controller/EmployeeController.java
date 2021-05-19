package com.scientific.tailoring.crm.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.domain.crm.EmployeeVO;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.crm.Employee;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.proxy.crm.EmployeeServiceProxy;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.domain.crm.meta.EmployeeVOMeta;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;

import com.scientific.tailoring.crm.service.IEmployeeService;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-25 08:57:36
*/

@Api(tags = "公司员工关系")
@ApiSort(1053)
@RestController("CrmEmployeeController")
public class EmployeeController extends SuperController {

	@Autowired
	private IEmployeeService employeeService;

	
	/**
	 * 添加公司员工关系
	*/
	@RequiresPermissions("CrmEmployee:insert")
	@ApiOperation(value = "添加公司员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.DEPARTMENT_ID , value = "所属部门ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.NAME , value = "员工姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = EmployeeVOMeta.SEX , value = "员工性别" , required = false , dataTypeClass=String.class , example = "F"),
	})
	@ApiOperationSupport(ignoreParameters = {EmployeeVOMeta.PAGE_INDEX , EmployeeVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = EmployeeServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(EmployeeServiceProxy.INSERT)
	public  Result<Employee> insert(EmployeeVO employeeVO) {
		Result<Employee> result=new Result<>();
		boolean suc=employeeService.insert(employeeVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除公司员工关系
	*/
	@RequiresPermissions("CrmEmployee:deleteById")
	@ApiOperation(value = "删除公司员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.DEPARTMENT_ID , value = "所属部门ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.NAME , value = "员工姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = EmployeeVOMeta.SEX , value = "员工性别" , required = false , dataTypeClass=String.class , example = "F"),
	})
	@NotNull(name = EmployeeVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = EmployeeServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(EmployeeServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=employeeService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新公司员工关系
	*/
	@RequiresPermissions("CrmEmployee:update")
	@ApiOperation(value = "更新公司员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.DEPARTMENT_ID , value = "所属部门ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.NAME , value = "员工姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = EmployeeVOMeta.SEX , value = "员工性别" , required = false , dataTypeClass=String.class , example = "F"),
	})
	@NotNull(name = EmployeeVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {EmployeeVOMeta.PAGE_INDEX , EmployeeVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = EmployeeServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(EmployeeServiceProxy.UPDATE)
	public  Result<Employee> update(EmployeeVO employeeVO) {
		Result<Employee> result=new Result<>();
		boolean suc=employeeService.update(employeeVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取公司员工关系
	*/
	@RequiresPermissions("CrmEmployee:getById")
	@ApiOperation(value = "按主键获取公司员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.DEPARTMENT_ID , value = "所属部门ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.NAME , value = "员工姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = EmployeeVOMeta.SEX , value = "员工性别" , required = false , dataTypeClass=String.class , example = "F"),
	})
	@NotNull(name = EmployeeVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = EmployeeServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(EmployeeServiceProxy.GET_BY_ID)
	public  Result<Employee> getById(Long id) {
		Result<Employee> result=new Result<>();
		Employee employee=employeeService.getById(id);
		result.success(true).data(employee);
		return result;
	}

	
	/**
	 * 查询全部符合条件的公司员工关系
	*/
	@RequiresPermissions("CrmEmployee:queryList")
	@ApiOperation(value = "查询公司员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.DEPARTMENT_ID , value = "所属部门ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.NAME , value = "员工姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = EmployeeVOMeta.SEX , value = "员工性别" , required = false , dataTypeClass=String.class , example = "F"),
	})
	@ApiOperationSupport(ignoreParameters = {EmployeeVOMeta.PAGE_INDEX , EmployeeVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = EmployeeServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(EmployeeServiceProxy.QUERY_LIST)
	public  Result<List<Employee>> queryList(EmployeeVO sample) {
		Result<List<Employee>> result=new Result<>();
		List<Employee> list=employeeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的公司员工关系
	*/
	@RequiresPermissions("CrmEmployee:queryPagedList")
	@ApiOperation(value = "分页查询公司员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.DEPARTMENT_ID , value = "所属部门ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.USER_ID , value = "用户ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = EmployeeVOMeta.NAME , value = "员工姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = EmployeeVOMeta.SEX , value = "员工性别" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = EmployeeVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = EmployeeVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = EmployeeServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(EmployeeServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<Employee>> queryPagedList(EmployeeVO sample) {
		Result<PagedList<Employee>> result=new Result<>();
		PagedList<Employee> list=employeeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}