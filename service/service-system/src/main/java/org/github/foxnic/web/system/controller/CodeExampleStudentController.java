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


import org.github.foxnic.web.proxy.system.CodeExampleStudentServiceProxy;
import org.github.foxnic.web.domain.system.meta.CodeExampleStudentVOMeta;
import org.github.foxnic.web.domain.system.CodeExampleStudent;
import org.github.foxnic.web.domain.system.CodeExampleStudentVO;
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
import org.github.foxnic.web.domain.system.meta.CodeExampleStudentMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.ICodeExampleStudentService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 代码生成主表学生 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-22 21:30:45
*/

@Api(tags = "代码生成主表学生")
@ApiSort(0)
@RestController("SysCodeExampleStudentController")
public class CodeExampleStudentController extends SuperController {

	@Autowired
	private ICodeExampleStudentService codeExampleStudentService;


	/**
	 * 添加代码生成主表学生
	*/
	@ApiOperation(value = "添加代码生成主表学生")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.NAME , value = "学生姓名" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.AGE , value = "年龄" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CodeExampleStudentServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleStudentServiceProxy.INSERT)
	public Result insert(CodeExampleStudentVO codeExampleStudentVO) {
		Result result=codeExampleStudentService.insert(codeExampleStudentVO);
		return result;
	}



	/**
	 * 删除代码生成主表学生
	*/
	@ApiOperation(value = "删除代码生成主表学生")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CodeExampleStudentVOMeta.ID)
	@SentinelResource(value = CodeExampleStudentServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleStudentServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=codeExampleStudentService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除代码生成主表学生 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除代码生成主表学生")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CodeExampleStudentVOMeta.IDS)
	@SentinelResource(value = CodeExampleStudentServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleStudentServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=codeExampleStudentService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新代码生成主表学生
	*/
	@ApiOperation(value = "更新代码生成主表学生")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.NAME , value = "学生姓名" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.AGE , value = "年龄" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CodeExampleStudentVOMeta.PAGE_INDEX , CodeExampleStudentVOMeta.PAGE_SIZE , CodeExampleStudentVOMeta.SEARCH_FIELD , CodeExampleStudentVOMeta.FUZZY_FIELD , CodeExampleStudentVOMeta.SEARCH_VALUE , CodeExampleStudentVOMeta.SORT_FIELD , CodeExampleStudentVOMeta.SORT_TYPE , CodeExampleStudentVOMeta.IDS } )
	@NotNull(name = CodeExampleStudentVOMeta.ID)
	@SentinelResource(value = CodeExampleStudentServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleStudentServiceProxy.UPDATE)
	public Result update(CodeExampleStudentVO codeExampleStudentVO) {
		Result result=codeExampleStudentService.update(codeExampleStudentVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存代码生成主表学生
	*/
	@ApiOperation(value = "保存代码生成主表学生")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.NAME , value = "学生姓名" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.AGE , value = "年龄" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeExampleStudentVOMeta.PAGE_INDEX , CodeExampleStudentVOMeta.PAGE_SIZE , CodeExampleStudentVOMeta.SEARCH_FIELD , CodeExampleStudentVOMeta.FUZZY_FIELD , CodeExampleStudentVOMeta.SEARCH_VALUE , CodeExampleStudentVOMeta.SORT_FIELD , CodeExampleStudentVOMeta.SORT_TYPE , CodeExampleStudentVOMeta.IDS } )
	@NotNull(name = CodeExampleStudentVOMeta.ID)
	@SentinelResource(value = CodeExampleStudentServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleStudentServiceProxy.SAVE)
	public Result save(CodeExampleStudentVO codeExampleStudentVO) {
		Result result=codeExampleStudentService.save(codeExampleStudentVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取代码生成主表学生
	*/
	@ApiOperation(value = "获取代码生成主表学生")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CodeExampleStudentVOMeta.ID)
	@SentinelResource(value = CodeExampleStudentServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleStudentServiceProxy.GET_BY_ID)
	public Result<CodeExampleStudent> getById(String id) {
		Result<CodeExampleStudent> result=new Result<>();
		CodeExampleStudent codeExampleStudent=codeExampleStudentService.getById(id);

		// join 关联的对象
		codeExampleStudentService.dao().fill(codeExampleStudent)
			.execute();

		result.success(true).data(codeExampleStudent);
		return result;
	}


	/**
	 * 批量获取代码生成主表学生 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取代码生成主表学生")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CodeExampleStudentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CodeExampleStudentVOMeta.IDS)
		@SentinelResource(value = CodeExampleStudentServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleStudentServiceProxy.GET_BY_IDS)
	public Result<List<CodeExampleStudent>> getByIds(List<String> ids) {
		Result<List<CodeExampleStudent>> result=new Result<>();
		List<CodeExampleStudent> list=codeExampleStudentService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询代码生成主表学生
	*/
	@ApiOperation(value = "查询代码生成主表学生")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.NAME , value = "学生姓名" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.AGE , value = "年龄" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeExampleStudentVOMeta.PAGE_INDEX , CodeExampleStudentVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CodeExampleStudentServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleStudentServiceProxy.QUERY_LIST)
	public Result<List<CodeExampleStudent>> queryList(CodeExampleStudentVO sample) {
		Result<List<CodeExampleStudent>> result=new Result<>();
		List<CodeExampleStudent> list=codeExampleStudentService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询代码生成主表学生
	*/
	@ApiOperation(value = "分页查询代码生成主表学生")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.NAME , value = "学生姓名" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleStudentVOMeta.AGE , value = "年龄" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CodeExampleStudentServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleStudentServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CodeExampleStudent>> queryPagedList(CodeExampleStudentVO sample) {
		Result<PagedList<CodeExampleStudent>> result=new Result<>();
		PagedList<CodeExampleStudent> list=codeExampleStudentService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		codeExampleStudentService.dao().fill(list)
			.execute();

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CodeExampleStudentServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeExampleStudentServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CodeExampleStudentVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=codeExampleStudentService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CodeExampleStudentServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeExampleStudentServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=codeExampleStudentService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = CodeExampleStudentServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeExampleStudentServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=codeExampleStudentService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}