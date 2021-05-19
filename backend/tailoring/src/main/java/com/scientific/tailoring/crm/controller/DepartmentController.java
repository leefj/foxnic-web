package com.scientific.tailoring.crm.controller;
import com.scientific.tailoring.crm.service.IDepartmentService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.scientific.tailoring.domain.crm.DepartmentVO;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.crm.meta.DepartmentVOMeta;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.scientific.tailoring.domain.crm.Department;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.proxy.crm.DepartmentServiceProxy;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-25 08:57:36
*/

@Api(tags = "客户部门")
@ApiSort(1052)
@RestController("CrmDepartmentController")
public class DepartmentController extends SuperController {

	@Autowired
	private IDepartmentService departmentService;

	
	/**
	 * 添加客户部门
	*/
	@RequiresPermissions("CrmDepartment:insert")
	@ApiOperation(value = "添加客户部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DepartmentVOMeta.NAME , value = "部门名称" , required = false , dataTypeClass=String.class , example = "设计部"),
		@ApiImplicitParam(name = DepartmentVOMeta.COMPANY_ID , value = "所属公司ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = DepartmentVOMeta.PARENT_ID , value = "上级部门ID" , required = false , dataTypeClass=Long.class),
	})
	@ApiOperationSupport(ignoreParameters = {DepartmentVOMeta.PAGE_INDEX , DepartmentVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = DepartmentServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DepartmentServiceProxy.INSERT)
	public  Result<Department> insert(DepartmentVO departmentVO) {
		Result<Department> result=new Result<>();
		boolean suc=departmentService.insert(departmentVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除客户部门
	*/
	@RequiresPermissions("CrmDepartment:deleteById")
	@ApiOperation(value = "删除客户部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DepartmentVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = DepartmentVOMeta.NAME , value = "部门名称" , required = false , dataTypeClass=String.class , example = "设计部"),
		@ApiImplicitParam(name = DepartmentVOMeta.COMPANY_ID , value = "所属公司ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = DepartmentVOMeta.PARENT_ID , value = "上级部门ID" , required = false , dataTypeClass=Long.class),
	})
	@NotNull(name = DepartmentVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = DepartmentServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DepartmentServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=departmentService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新客户部门
	*/
	@RequiresPermissions("CrmDepartment:update")
	@ApiOperation(value = "更新客户部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DepartmentVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = DepartmentVOMeta.NAME , value = "部门名称" , required = false , dataTypeClass=String.class , example = "设计部"),
		@ApiImplicitParam(name = DepartmentVOMeta.COMPANY_ID , value = "所属公司ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = DepartmentVOMeta.PARENT_ID , value = "上级部门ID" , required = false , dataTypeClass=Long.class),
	})
	@NotNull(name = DepartmentVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {DepartmentVOMeta.PAGE_INDEX , DepartmentVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = DepartmentServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DepartmentServiceProxy.UPDATE)
	public  Result<Department> update(DepartmentVO departmentVO) {
		Result<Department> result=new Result<>();
		boolean suc=departmentService.update(departmentVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取客户部门
	*/
	@RequiresPermissions("CrmDepartment:getById")
	@ApiOperation(value = "按主键获取客户部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DepartmentVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = DepartmentVOMeta.NAME , value = "部门名称" , required = false , dataTypeClass=String.class , example = "设计部"),
		@ApiImplicitParam(name = DepartmentVOMeta.COMPANY_ID , value = "所属公司ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = DepartmentVOMeta.PARENT_ID , value = "上级部门ID" , required = false , dataTypeClass=Long.class),
	})
	@NotNull(name = DepartmentVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = DepartmentServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DepartmentServiceProxy.GET_BY_ID)
	public  Result<Department> getById(Long id) {
		Result<Department> result=new Result<>();
		Department department=departmentService.getById(id);
		result.success(true).data(department);
		return result;
	}

	
	/**
	 * 查询全部符合条件的客户部门
	*/
	@RequiresPermissions("CrmDepartment:queryList")
	@ApiOperation(value = "查询客户部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DepartmentVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = DepartmentVOMeta.NAME , value = "部门名称" , required = false , dataTypeClass=String.class , example = "设计部"),
		@ApiImplicitParam(name = DepartmentVOMeta.COMPANY_ID , value = "所属公司ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = DepartmentVOMeta.PARENT_ID , value = "上级部门ID" , required = false , dataTypeClass=Long.class),
	})
	@ApiOperationSupport(ignoreParameters = {DepartmentVOMeta.PAGE_INDEX , DepartmentVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = DepartmentServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DepartmentServiceProxy.QUERY_LIST)
	public  Result<List<Department>> queryList(DepartmentVO sample) {
		Result<List<Department>> result=new Result<>();
		List<Department> list=departmentService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的客户部门
	*/
	@RequiresPermissions("CrmDepartment:queryPagedList")
	@ApiOperation(value = "分页查询客户部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DepartmentVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = DepartmentVOMeta.NAME , value = "部门名称" , required = false , dataTypeClass=String.class , example = "设计部"),
		@ApiImplicitParam(name = DepartmentVOMeta.COMPANY_ID , value = "所属公司ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = DepartmentVOMeta.PARENT_ID , value = "上级部门ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = DepartmentVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DepartmentVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = DepartmentServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(DepartmentServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<Department>> queryPagedList(DepartmentVO sample) {
		Result<PagedList<Department>> result=new Result<>();
		PagedList<Department> list=departmentService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}