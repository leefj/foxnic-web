package org.github.foxnic.web.bpm.controller;

 
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
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
import org.github.foxnic.web.bpm.service.IRoleEmployeeService;
import org.github.foxnic.web.domain.bpm.RoleEmployee;
import org.github.foxnic.web.domain.bpm.RoleEmployeeVO;
import org.github.foxnic.web.domain.bpm.meta.RoleEmployeeVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.bpm.RoleEmployeeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 流程角色员工关系表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-08 20:22:21
 * @version
*/

@Api(tags = "流程角色员工关系")
@ApiSort(0)
@RestController("BpmRoleEmployeeController")
public class RoleEmployeeController extends SuperController {

	@Autowired
	private IRoleEmployeeService roleEmployeeService;

	
	/**
	 * 添加流程角色员工关系
	*/
	@ApiOperation(value = "添加流程角色员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleEmployeeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RoleEmployeeVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RoleEmployeeVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RoleEmployeeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleEmployeeServiceProxy.INSERT)
	public Result insert(RoleEmployeeVO roleEmployeeVO) {
		Result result=roleEmployeeService.insert(roleEmployeeVO);
		return result;
	}

	/**
	 * 批量添加流程角色员工关系
	 */
	@ApiOperation(value = "批量添加流程角色员工关系")
	@ApiImplicitParams({})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RoleEmployeeServiceProxy.INSERTS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleEmployeeServiceProxy.INSERTS)
	public Result insertList(List<RoleEmployeeVO> roleEmployeeVOs) {
		List<RoleEmployee> emps=new ArrayList<>();
		for (RoleEmployeeVO roleEmployeeVO : roleEmployeeVOs) {
			emps.add(roleEmployeeVO.toPO(RoleEmployee.class));
		}
		Result result=roleEmployeeService.insertList(emps);
		return result;
	}

	
	/**
	 * 删除流程角色员工关系
	*/
	@ApiOperation(value = "删除流程角色员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleEmployeeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RoleEmployeeVOMeta.ID)
	@SentinelResource(value = RoleEmployeeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleEmployeeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=roleEmployeeService.deleteByIdPhysical(id);
		return result;
	}
	
	
	/**
	 * 批量删除流程角色员工关系 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除流程角色员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleEmployeeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RoleEmployeeVOMeta.IDS)
	@SentinelResource(value = RoleEmployeeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleEmployeeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=roleEmployeeService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新流程角色员工关系
	*/
	@ApiOperation(value = "更新流程角色员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleEmployeeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RoleEmployeeVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RoleEmployeeVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RoleEmployeeVOMeta.PAGE_INDEX , RoleEmployeeVOMeta.PAGE_SIZE , RoleEmployeeVOMeta.SEARCH_FIELD , RoleEmployeeVOMeta.FUZZY_FIELD , RoleEmployeeVOMeta.SEARCH_VALUE , RoleEmployeeVOMeta.SORT_FIELD , RoleEmployeeVOMeta.SORT_TYPE , RoleEmployeeVOMeta.IDS } ) 
	@NotNull(name = RoleEmployeeVOMeta.ID)
	@SentinelResource(value = RoleEmployeeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleEmployeeServiceProxy.UPDATE)
	public Result update(RoleEmployeeVO roleEmployeeVO) {
		Result result=roleEmployeeService.update(roleEmployeeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存流程角色员工关系
	*/
	@ApiOperation(value = "保存流程角色员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleEmployeeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RoleEmployeeVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RoleEmployeeVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RoleEmployeeVOMeta.PAGE_INDEX , RoleEmployeeVOMeta.PAGE_SIZE , RoleEmployeeVOMeta.SEARCH_FIELD , RoleEmployeeVOMeta.FUZZY_FIELD , RoleEmployeeVOMeta.SEARCH_VALUE , RoleEmployeeVOMeta.SORT_FIELD , RoleEmployeeVOMeta.SORT_TYPE , RoleEmployeeVOMeta.IDS } )
	@NotNull(name = RoleEmployeeVOMeta.ID)
	@SentinelResource(value = RoleEmployeeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleEmployeeServiceProxy.SAVE)
	public Result save(RoleEmployeeVO roleEmployeeVO) {
		Result result=roleEmployeeService.save(roleEmployeeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取流程角色员工关系
	*/
	@ApiOperation(value = "获取流程角色员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleEmployeeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RoleEmployeeVOMeta.ID)
	@SentinelResource(value = RoleEmployeeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleEmployeeServiceProxy.GET_BY_ID)
	public Result<RoleEmployee> getById(String id) {
		Result<RoleEmployee> result=new Result<>();
		RoleEmployee roleEmployee=roleEmployeeService.getById(id);
		result.success(true).data(roleEmployee);
		return result;
	}


	/**
	 * 批量获取流程角色员工关系 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取流程角色员工关系")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RoleEmployeeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RoleEmployeeVOMeta.IDS)
		@SentinelResource(value = RoleEmployeeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleEmployeeServiceProxy.GET_BY_IDS)
	public Result<List<RoleEmployee>> getByIds(List<String> ids) {
		Result<List<RoleEmployee>> result=new Result<>();
		List<RoleEmployee> list=roleEmployeeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询流程角色员工关系
	*/
	@ApiOperation(value = "查询流程角色员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleEmployeeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RoleEmployeeVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RoleEmployeeVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RoleEmployeeVOMeta.PAGE_INDEX , RoleEmployeeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RoleEmployeeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleEmployeeServiceProxy.QUERY_LIST)
	public Result<List<RoleEmployee>> queryList(RoleEmployeeVO sample) {
		Result<List<RoleEmployee>> result=new Result<>();
		List<RoleEmployee> list=roleEmployeeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询流程角色员工关系
	*/
	@ApiOperation(value = "分页查询流程角色员工关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleEmployeeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RoleEmployeeVOMeta.ROLE_ID , value = "角色ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RoleEmployeeVOMeta.EMPLOYEE_ID , value = "员工ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RoleEmployeeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleEmployeeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RoleEmployee>> queryPagedList(RoleEmployeeVO sample) {
		Result<PagedList<RoleEmployee>> result=new Result<>();
		PagedList<RoleEmployee> list=roleEmployeeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RoleEmployeeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RoleEmployeeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RoleEmployeeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=roleEmployeeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RoleEmployeeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RoleEmployeeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=roleEmployeeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = RoleEmployeeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RoleEmployeeServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=roleEmployeeService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}