package org.github.foxnic.web.system.controller;

 
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


import org.github.foxnic.web.proxy.system.CodeExampleCarServiceProxy;
import org.github.foxnic.web.domain.system.meta.CodeExampleCarVOMeta;
import org.github.foxnic.web.domain.system.CodeExampleCar;
import org.github.foxnic.web.domain.system.CodeExampleCarVO;
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
import org.github.foxnic.web.domain.system.meta.CodeExampleCarMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.ICodeExampleCarService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 代码生成拥有的车辆 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-17 14:54:48
*/

@Api(tags = "代码生成拥有的车辆")
@ApiSort(0)
@RestController("SysCodeExampleCarController")
public class CodeExampleCarController extends SuperController {

	@Autowired
	private ICodeExampleCarService codeExampleCarService;

	
	/**
	 * 添加代码生成拥有的车辆
	*/
	@ApiOperation(value = "添加代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "车牌号" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "职位单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "组织单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "员工单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "职位多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "组织多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "员工多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "员工下拉" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "公司单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "部门多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "限定上级" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CodeExampleCarServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.INSERT)
	public Result insert(CodeExampleCarVO codeExampleCarVO) {
		Result result=codeExampleCarService.insert(codeExampleCarVO);
		return result;
	}

	
	/**
	 * 删除代码生成拥有的车辆
	*/
	@ApiOperation(value = "删除代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CodeExampleCarVOMeta.ID)
	@SentinelResource(value = CodeExampleCarServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=codeExampleCarService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除代码生成拥有的车辆 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CodeExampleCarVOMeta.IDS)
	@SentinelResource(value = CodeExampleCarServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=codeExampleCarService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新代码生成拥有的车辆
	*/
	@ApiOperation(value = "更新代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "车牌号" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "职位单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "组织单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "员工单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "职位多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "组织多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "员工多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "员工下拉" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "公司单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "部门多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "限定上级" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CodeExampleCarVOMeta.PAGE_INDEX , CodeExampleCarVOMeta.PAGE_SIZE , CodeExampleCarVOMeta.SEARCH_FIELD , CodeExampleCarVOMeta.FUZZY_FIELD , CodeExampleCarVOMeta.SEARCH_VALUE , CodeExampleCarVOMeta.SORT_FIELD , CodeExampleCarVOMeta.SORT_TYPE , CodeExampleCarVOMeta.IDS } ) 
	@NotNull(name = CodeExampleCarVOMeta.ID)
	@SentinelResource(value = CodeExampleCarServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.UPDATE)
	public Result update(CodeExampleCarVO codeExampleCarVO) {
		Result result=codeExampleCarService.update(codeExampleCarVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存代码生成拥有的车辆
	*/
	@ApiOperation(value = "保存代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "车牌号" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "职位单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "组织单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "员工单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "职位多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "组织多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "员工多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "员工下拉" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "公司单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "部门多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "限定上级" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeExampleCarVOMeta.PAGE_INDEX , CodeExampleCarVOMeta.PAGE_SIZE , CodeExampleCarVOMeta.SEARCH_FIELD , CodeExampleCarVOMeta.FUZZY_FIELD , CodeExampleCarVOMeta.SEARCH_VALUE , CodeExampleCarVOMeta.SORT_FIELD , CodeExampleCarVOMeta.SORT_TYPE , CodeExampleCarVOMeta.IDS } )
	@NotNull(name = CodeExampleCarVOMeta.ID)
	@SentinelResource(value = CodeExampleCarServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.SAVE)
	public Result save(CodeExampleCarVO codeExampleCarVO) {
		Result result=codeExampleCarService.save(codeExampleCarVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取代码生成拥有的车辆
	*/
	@ApiOperation(value = "获取代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CodeExampleCarVOMeta.ID)
	@SentinelResource(value = CodeExampleCarServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.GET_BY_ID)
	public Result<CodeExampleCar> getById(String id) {
		Result<CodeExampleCar> result=new Result<>();
		CodeExampleCar codeExampleCar=codeExampleCarService.getById(id);
		result.success(true).data(codeExampleCar);
		return result;
	}


	/**
	 * 批量删除代码生成拥有的车辆 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除代码生成拥有的车辆")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CodeExampleCarVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CodeExampleCarVOMeta.IDS)
		@SentinelResource(value = CodeExampleCarServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.GET_BY_IDS)
	public Result<List<CodeExampleCar>> getByIds(List<String> ids) {
		Result<List<CodeExampleCar>> result=new Result<>();
		List<CodeExampleCar> list=codeExampleCarService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询代码生成拥有的车辆
	*/
	@ApiOperation(value = "查询代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "车牌号" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "职位单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "组织单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "员工单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "职位多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "组织多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "员工多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "员工下拉" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "公司单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "部门多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "限定上级" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeExampleCarVOMeta.PAGE_INDEX , CodeExampleCarVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CodeExampleCarServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.QUERY_LIST)
	public Result<List<CodeExampleCar>> queryList(CodeExampleCarVO sample) {
		Result<List<CodeExampleCar>> result=new Result<>();
		List<CodeExampleCar> list=codeExampleCarService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询代码生成拥有的车辆
	*/
	@ApiOperation(value = "分页查询代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "车牌号" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "职位单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "组织单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "员工单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "职位多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "组织多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "员工多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "员工下拉" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "公司单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "部门多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "限定上级" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CodeExampleCarServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CodeExampleCar>> queryPagedList(CodeExampleCarVO sample) {
		Result<PagedList<CodeExampleCar>> result=new Result<>();
		PagedList<CodeExampleCar> list=codeExampleCarService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CodeExampleCarServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeExampleCarServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CodeExampleCarVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=codeExampleCarService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CodeExampleCarServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeExampleCarServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=codeExampleCarService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = CodeExampleCarServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeExampleCarServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=codeExampleCarService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}