package org.github.foxnic.web.dataperm.controller;


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


import org.github.foxnic.web.proxy.dataperm.SubjectPropertyServiceProxy;
import org.github.foxnic.web.domain.dataperm.meta.SubjectPropertyVOMeta;
import org.github.foxnic.web.domain.dataperm.SubjectProperty;
import org.github.foxnic.web.domain.dataperm.SubjectPropertyVO;
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
import org.github.foxnic.web.domain.dataperm.meta.SubjectPropertyMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.dataperm.service.ISubjectPropertyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据权限主体属性表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-28 10:00:45
*/

@Api(tags = "数据权限主体属性")
@ApiSort(0)
@RestController("DpSubjectPropertyController")
public class SubjectPropertyController extends SuperController {

	@Autowired
	private ISubjectPropertyService subjectPropertyService;


	/**
	 * 添加数据权限主体属性
	*/
	@ApiOperation(value = "添加数据权限主体属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectPropertyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.SUBJECT_ID , value = "主题ID" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.NAME , value = "属性名称" , required = false , dataTypeClass=String.class , example = "启动时间"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.PROPERTY , value = "属性" , required = false , dataTypeClass=String.class , example = "bootTime"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = SubjectPropertyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectPropertyServiceProxy.INSERT)
	public Result insert(SubjectPropertyVO subjectPropertyVO) {
		Result result=subjectPropertyService.insert(subjectPropertyVO,false);
		return result;
	}



	/**
	 * 删除数据权限主体属性
	*/
	@ApiOperation(value = "删除数据权限主体属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectPropertyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "E001")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = SubjectPropertyVOMeta.ID)
	@SentinelResource(value = SubjectPropertyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectPropertyServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=subjectPropertyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据权限主体属性 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据权限主体属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectPropertyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = SubjectPropertyVOMeta.IDS)
	@SentinelResource(value = SubjectPropertyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectPropertyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=subjectPropertyService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新数据权限主体属性
	*/
	@ApiOperation(value = "更新数据权限主体属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectPropertyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.SUBJECT_ID , value = "主题ID" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.NAME , value = "属性名称" , required = false , dataTypeClass=String.class , example = "启动时间"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.PROPERTY , value = "属性" , required = false , dataTypeClass=String.class , example = "bootTime"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { SubjectPropertyVOMeta.PAGE_INDEX , SubjectPropertyVOMeta.PAGE_SIZE , SubjectPropertyVOMeta.SEARCH_FIELD , SubjectPropertyVOMeta.FUZZY_FIELD , SubjectPropertyVOMeta.SEARCH_VALUE , SubjectPropertyVOMeta.SORT_FIELD , SubjectPropertyVOMeta.SORT_TYPE , SubjectPropertyVOMeta.IDS } )
	@NotNull(name = SubjectPropertyVOMeta.ID)
	@SentinelResource(value = SubjectPropertyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectPropertyServiceProxy.UPDATE)
	public Result update(SubjectPropertyVO subjectPropertyVO) {
		Result result=subjectPropertyService.update(subjectPropertyVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据权限主体属性
	*/
	@ApiOperation(value = "保存数据权限主体属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectPropertyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.SUBJECT_ID , value = "主题ID" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.NAME , value = "属性名称" , required = false , dataTypeClass=String.class , example = "启动时间"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.PROPERTY , value = "属性" , required = false , dataTypeClass=String.class , example = "bootTime"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SubjectPropertyVOMeta.PAGE_INDEX , SubjectPropertyVOMeta.PAGE_SIZE , SubjectPropertyVOMeta.SEARCH_FIELD , SubjectPropertyVOMeta.FUZZY_FIELD , SubjectPropertyVOMeta.SEARCH_VALUE , SubjectPropertyVOMeta.SORT_FIELD , SubjectPropertyVOMeta.SORT_TYPE , SubjectPropertyVOMeta.IDS } )
	@NotNull(name = SubjectPropertyVOMeta.ID)
	@SentinelResource(value = SubjectPropertyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectPropertyServiceProxy.SAVE)
	public Result save(SubjectPropertyVO subjectPropertyVO) {
		Result result=subjectPropertyService.save(subjectPropertyVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据权限主体属性
	*/
	@ApiOperation(value = "获取数据权限主体属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectPropertyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = SubjectPropertyVOMeta.ID)
	@SentinelResource(value = SubjectPropertyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectPropertyServiceProxy.GET_BY_ID)
	public Result<SubjectProperty> getById(String id) {
		Result<SubjectProperty> result=new Result<>();
		SubjectProperty subjectProperty=subjectPropertyService.getById(id);

		// join 关联的对象
		subjectPropertyService.dao().fill(subjectProperty)
			.execute();

		result.success(true).data(subjectProperty);
		return result;
	}


	/**
	 * 批量获取数据权限主体属性 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据权限主体属性")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SubjectPropertyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = SubjectPropertyVOMeta.IDS)
		@SentinelResource(value = SubjectPropertyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectPropertyServiceProxy.GET_BY_IDS)
	public Result<List<SubjectProperty>> getByIds(List<String> ids) {
		Result<List<SubjectProperty>> result=new Result<>();
		List<SubjectProperty> list=subjectPropertyService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据权限主体属性
	*/
	@ApiOperation(value = "查询数据权限主体属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectPropertyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.SUBJECT_ID , value = "主题ID" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.NAME , value = "属性名称" , required = false , dataTypeClass=String.class , example = "启动时间"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.PROPERTY , value = "属性" , required = false , dataTypeClass=String.class , example = "bootTime"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SubjectPropertyVOMeta.PAGE_INDEX , SubjectPropertyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SubjectPropertyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectPropertyServiceProxy.QUERY_LIST)
	public Result<List<SubjectProperty>> queryList(SubjectPropertyVO sample) {
		Result<List<SubjectProperty>> result=new Result<>();
		List<SubjectProperty> list=subjectPropertyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据权限主体属性
	*/
	@ApiOperation(value = "分页查询数据权限主体属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectPropertyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.SUBJECT_ID , value = "主题ID" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.NAME , value = "属性名称" , required = false , dataTypeClass=String.class , example = "启动时间"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.PROPERTY , value = "属性" , required = false , dataTypeClass=String.class , example = "bootTime"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = SubjectPropertyVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = SubjectPropertyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectPropertyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SubjectProperty>> queryPagedList(SubjectPropertyVO sample) {
		Result<PagedList<SubjectProperty>> result=new Result<>();
		PagedList<SubjectProperty> list=subjectPropertyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		subjectPropertyService.dao().fill(list)
			.execute();

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = SubjectPropertyServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SubjectPropertyServiceProxy.EXPORT_EXCEL)
	public void exportExcel(SubjectPropertyVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=subjectPropertyService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = SubjectPropertyServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SubjectPropertyServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=subjectPropertyService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = SubjectPropertyServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SubjectPropertyServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=subjectPropertyService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}