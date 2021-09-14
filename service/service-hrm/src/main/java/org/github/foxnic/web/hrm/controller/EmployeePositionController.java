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


import org.github.foxnic.web.proxy.hrm.EmployeePositionServiceProxy;
import org.github.foxnic.web.domain.hrm.meta.EmployeePositionVOMeta;
import org.github.foxnic.web.domain.hrm.EmployeePosition;
import org.github.foxnic.web.domain.hrm.EmployeePositionVO;
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
import org.github.foxnic.web.domain.hrm.meta.EmployeePositionMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.hrm.service.IEmployeePositionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 *  接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-14 21:43:33
*/

@Api(tags = "hrm_employee_position")
@ApiSort(0)
@RestController("HrmEmployeePositionController")
public class EmployeePositionController extends SuperController {

	@Autowired
	private IEmployeePositionService employeePositionService;

	
	/**
	 * 添加hrm_employee_position
	*/
	@ApiOperation(value = "添加hrm_employee_position")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.EMPLOYEE_ID , value = "员工ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.POSITION_ID , value = "岗位ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.PRIMARY , value = "是否主刚" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = EmployeePositionVOMeta.ID)
	@NotNull(name = EmployeePositionVOMeta.EMPLOYEE_ID)
	@NotNull(name = EmployeePositionVOMeta.POSITION_ID)
	@SentinelResource(value = EmployeePositionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeePositionServiceProxy.INSERT)
	public Result insert(EmployeePositionVO employeePositionVO) {
		Result result=employeePositionService.insert(employeePositionVO);
		return result;
	}

	
	/**
	 * 删除hrm_employee_position
	*/
	@ApiOperation(value = "删除hrm_employee_position")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = EmployeePositionVOMeta.ID)
	@SentinelResource(value = EmployeePositionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeePositionServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=employeePositionService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除hrm_employee_position <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除hrm_employee_position")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeePositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = EmployeePositionVOMeta.IDS)
	@SentinelResource(value = EmployeePositionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeePositionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=employeePositionService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新hrm_employee_position
	*/
	@ApiOperation(value = "更新hrm_employee_position")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.EMPLOYEE_ID , value = "员工ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.POSITION_ID , value = "岗位ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.PRIMARY , value = "是否主刚" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { EmployeePositionVOMeta.PAGE_INDEX , EmployeePositionVOMeta.PAGE_SIZE , EmployeePositionVOMeta.SEARCH_FIELD , EmployeePositionVOMeta.FUZZY_FIELD , EmployeePositionVOMeta.SEARCH_VALUE , EmployeePositionVOMeta.SORT_FIELD , EmployeePositionVOMeta.SORT_TYPE , EmployeePositionVOMeta.IDS } ) 
	@NotNull(name = EmployeePositionVOMeta.ID)
	@NotNull(name = EmployeePositionVOMeta.EMPLOYEE_ID)
	@NotNull(name = EmployeePositionVOMeta.POSITION_ID)
	@SentinelResource(value = EmployeePositionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeePositionServiceProxy.UPDATE)
	public Result update(EmployeePositionVO employeePositionVO) {
		Result result=employeePositionService.update(employeePositionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存hrm_employee_position
	*/
	@ApiOperation(value = "保存hrm_employee_position")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.EMPLOYEE_ID , value = "员工ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.POSITION_ID , value = "岗位ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.PRIMARY , value = "是否主刚" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { EmployeePositionVOMeta.PAGE_INDEX , EmployeePositionVOMeta.PAGE_SIZE , EmployeePositionVOMeta.SEARCH_FIELD , EmployeePositionVOMeta.FUZZY_FIELD , EmployeePositionVOMeta.SEARCH_VALUE , EmployeePositionVOMeta.SORT_FIELD , EmployeePositionVOMeta.SORT_TYPE , EmployeePositionVOMeta.IDS } )
	@NotNull(name = EmployeePositionVOMeta.ID)
	@NotNull(name = EmployeePositionVOMeta.EMPLOYEE_ID)
	@NotNull(name = EmployeePositionVOMeta.POSITION_ID)
	@SentinelResource(value = EmployeePositionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeePositionServiceProxy.SAVE)
	public Result save(EmployeePositionVO employeePositionVO) {
		Result result=employeePositionService.save(employeePositionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取hrm_employee_position
	*/
	@ApiOperation(value = "获取hrm_employee_position")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = EmployeePositionVOMeta.ID)
	@SentinelResource(value = EmployeePositionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeePositionServiceProxy.GET_BY_ID)
	public Result<EmployeePosition> getById(String id) {
		Result<EmployeePosition> result=new Result<>();
		EmployeePosition employeePosition=employeePositionService.getById(id);
		result.success(true).data(employeePosition);
		return result;
	}


	/**
	 * 批量删除hrm_employee_position <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除hrm_employee_position")
		@ApiImplicitParams({
				@ApiImplicitParam(name = EmployeePositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = EmployeePositionVOMeta.IDS)
		@SentinelResource(value = EmployeePositionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeePositionServiceProxy.GET_BY_IDS)
	public Result<List<EmployeePosition>> getByIds(List<String> ids) {
		Result<List<EmployeePosition>> result=new Result<>();
		List<EmployeePosition> list=employeePositionService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询hrm_employee_position
	*/
	@ApiOperation(value = "查询hrm_employee_position")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.EMPLOYEE_ID , value = "员工ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.POSITION_ID , value = "岗位ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.PRIMARY , value = "是否主刚" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { EmployeePositionVOMeta.PAGE_INDEX , EmployeePositionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = EmployeePositionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeePositionServiceProxy.QUERY_LIST)
	public Result<List<EmployeePosition>> queryList(EmployeePositionVO sample) {
		Result<List<EmployeePosition>> result=new Result<>();
		List<EmployeePosition> list=employeePositionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询hrm_employee_position
	*/
	@ApiOperation(value = "分页查询hrm_employee_position")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.EMPLOYEE_ID , value = "员工ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.POSITION_ID , value = "岗位ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EmployeePositionVOMeta.PRIMARY , value = "是否主刚" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = EmployeePositionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EmployeePositionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<EmployeePosition>> queryPagedList(EmployeePositionVO sample) {
		Result<PagedList<EmployeePosition>> result=new Result<>();
		PagedList<EmployeePosition> list=employeePositionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = EmployeePositionServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(EmployeePositionServiceProxy.EXPORT_EXCEL)
	public void exportExcel(EmployeePositionVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=employeePositionService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = EmployeePositionServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(EmployeePositionServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=employeePositionService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = EmployeePositionServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(EmployeePositionServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=employeePositionService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}