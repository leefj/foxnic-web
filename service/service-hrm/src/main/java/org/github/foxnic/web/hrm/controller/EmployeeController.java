package org.github.foxnic.web.hrm.controller;

 
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.domain.hrm.meta.EmployeeVOMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.EmployeeVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.hrm.Company;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.hrm.service.IEmployeeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 员工表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-26 20:56:41
*/

@Api(tags = "员工")
@ApiSort(0)
@RestController("HrmEmployeeController")
public class EmployeeController extends SuperController {

	@Autowired
	private IEmployeeService employeeService;

	
	/**
	 * 添加员工
	*/
	@ApiOperation(value = "添加员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "483311859227693056"),
		@ApiImplicitParam(name = EmployeeVOMeta.BADGE , value = "工号" , required = false , dataTypeClass=String.class , example = "111"),
		@ApiImplicitParam(name = EmployeeVOMeta.PERSON_ID , value = "人员ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.KEEP_ACCOUNT , value = "对否开通账号" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = EmployeeVOMeta.ID)
	@SentinelResource(value = EmployeeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeeServiceProxy.INSERT)
	public Result insert(EmployeeVO employeeVO) {
		Result result=employeeService.insert(employeeVO);
		return result;
	}

	
	/**
	 * 删除员工
	*/
	@ApiOperation(value = "删除员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "483311859227693056")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = EmployeeVOMeta.ID)
	@SentinelResource(value = EmployeeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=employeeService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除员工 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = EmployeeVOMeta.IDS)
	@SentinelResource(value = EmployeeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=employeeService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新员工
	*/
	@ApiOperation(value = "更新员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "483311859227693056"),
		@ApiImplicitParam(name = EmployeeVOMeta.BADGE , value = "工号" , required = false , dataTypeClass=String.class , example = "111"),
		@ApiImplicitParam(name = EmployeeVOMeta.PERSON_ID , value = "人员ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.KEEP_ACCOUNT , value = "对否开通账号" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { EmployeeVOMeta.PAGE_INDEX , EmployeeVOMeta.PAGE_SIZE , EmployeeVOMeta.SEARCH_FIELD , EmployeeVOMeta.FUZZY_FIELD , EmployeeVOMeta.SEARCH_VALUE , EmployeeVOMeta.SORT_FIELD , EmployeeVOMeta.SORT_TYPE , EmployeeVOMeta.IDS } ) 
	@NotNull(name = EmployeeVOMeta.ID)
	@SentinelResource(value = EmployeeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeeServiceProxy.UPDATE)
	public Result update(EmployeeVO employeeVO) {
		Result result=employeeService.update(employeeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存员工
	*/
	@ApiOperation(value = "保存员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "483311859227693056"),
		@ApiImplicitParam(name = EmployeeVOMeta.BADGE , value = "工号" , required = false , dataTypeClass=String.class , example = "111"),
		@ApiImplicitParam(name = EmployeeVOMeta.PERSON_ID , value = "人员ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.KEEP_ACCOUNT , value = "对否开通账号" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { EmployeeVOMeta.PAGE_INDEX , EmployeeVOMeta.PAGE_SIZE , EmployeeVOMeta.SEARCH_FIELD , EmployeeVOMeta.FUZZY_FIELD , EmployeeVOMeta.SEARCH_VALUE , EmployeeVOMeta.SORT_FIELD , EmployeeVOMeta.SORT_TYPE , EmployeeVOMeta.IDS } )
	@NotNull(name = EmployeeVOMeta.ID)
	@SentinelResource(value = EmployeeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeeServiceProxy.SAVE)
	public Result save(EmployeeVO employeeVO) {
		Result result=employeeService.save(employeeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取员工
	*/
	@ApiOperation(value = "获取员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = EmployeeVOMeta.ID)
	@SentinelResource(value = EmployeeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeeServiceProxy.GET_BY_ID)
	public Result<Employee> getById(String id) {
		Result<Employee> result=new Result<>();
		Employee employee=employeeService.getById(id);
		// 关联出 所属公司 数据
		employeeService.join(employee,EmployeeMeta.COMPANY);
		// 关联出 姓名 数据
		employeeService.join(employee,EmployeeMeta.PERSON);
		result.success(true).data(employee);
		return result;
	}


	/**
	 * 批量删除员工 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除员工")
		@ApiImplicitParams({
				@ApiImplicitParam(name = EmployeeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = EmployeeVOMeta.IDS)
		@SentinelResource(value = EmployeeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeeServiceProxy.GET_BY_IDS)
	public Result<List<Employee>> getByIds(List<String> ids) {
		Result<List<Employee>> result=new Result<>();
		List<Employee> list=employeeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询员工
	*/
	@ApiOperation(value = "查询员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "483311859227693056"),
		@ApiImplicitParam(name = EmployeeVOMeta.BADGE , value = "工号" , required = false , dataTypeClass=String.class , example = "111"),
		@ApiImplicitParam(name = EmployeeVOMeta.PERSON_ID , value = "人员ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.KEEP_ACCOUNT , value = "对否开通账号" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { EmployeeVOMeta.PAGE_INDEX , EmployeeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = EmployeeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeeServiceProxy.QUERY_LIST)
	public Result<List<Employee>> queryList(EmployeeVO sample) {
		Result<List<Employee>> result=new Result<>();
		List<Employee> list=employeeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询员工
	*/
	@ApiOperation(value = "分页查询员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "483311859227693056"),
		@ApiImplicitParam(name = EmployeeVOMeta.BADGE , value = "工号" , required = false , dataTypeClass=String.class , example = "111"),
		@ApiImplicitParam(name = EmployeeVOMeta.PERSON_ID , value = "人员ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.KEEP_ACCOUNT , value = "对否开通账号" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = EmployeeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Employee>> queryPagedList(EmployeeVO sample) {
		Result<PagedList<Employee>> result=new Result<>();
		PagedList<Employee> list=employeeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 所属公司 数据
		employeeService.join(list,EmployeeMeta.COMPANY);
		// 关联出 姓名 数据
		employeeService.join(list,EmployeeMeta.PERSON);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = EmployeeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(EmployeeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(EmployeeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=employeeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = EmployeeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(EmployeeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=employeeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = EmployeeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(EmployeeServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

			//获得上传的文件
			Map<String, MultipartFile> map = request.getFileMap();
			InputStream input=null;
			for (MultipartFile mf : map.values()) {
				input=StreamUtil.bytes2input(mf.getBytes());
				break;
			}

			if(input==null) {
				return ErrorDesc.failure().message("缺少上传的文件");
			}

			List<ValidateResult> errors=employeeService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}