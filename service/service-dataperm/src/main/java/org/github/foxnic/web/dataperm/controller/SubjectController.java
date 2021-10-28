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


import org.github.foxnic.web.proxy.dataperm.SubjectServiceProxy;
import org.github.foxnic.web.domain.dataperm.meta.SubjectVOMeta;
import org.github.foxnic.web.domain.dataperm.Subject;
import org.github.foxnic.web.domain.dataperm.SubjectVO;
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
import org.github.foxnic.web.domain.dataperm.meta.SubjectMeta;
import org.github.foxnic.web.domain.dataperm.SubjectProperty;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.dataperm.service.ISubjectService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据权限主体表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-28 10:00:44
*/

@Api(tags = "数据权限主体")
@ApiSort(0)
@RestController("DpSubjectController")
public class SubjectController extends SuperController {

	@Autowired
	private ISubjectService subjectService;


	/**
	 * 添加数据权限主体
	*/
	@ApiOperation(value = "添加数据权限主体")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SubjectVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "SESSION_USER"),
		@ApiImplicitParam(name = SubjectVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "会话账户"),
		@ApiImplicitParam(name = SubjectVOMeta.GETTER , value = "Subject" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SubjectVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.session.SessionUser"),
		@ApiImplicitParam(name = SubjectVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = SubjectServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectServiceProxy.INSERT)
	public Result insert(SubjectVO subjectVO) {
		Result result=subjectService.insert(subjectVO,false);
		return result;
	}



	/**
	 * 删除数据权限主体
	*/
	@ApiOperation(value = "删除数据权限主体")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = SubjectVOMeta.ID)
	@SentinelResource(value = SubjectServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=subjectService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据权限主体 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据权限主体")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = SubjectVOMeta.IDS)
	@SentinelResource(value = SubjectServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=subjectService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新数据权限主体
	*/
	@ApiOperation(value = "更新数据权限主体")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SubjectVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "SESSION_USER"),
		@ApiImplicitParam(name = SubjectVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "会话账户"),
		@ApiImplicitParam(name = SubjectVOMeta.GETTER , value = "Subject" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SubjectVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.session.SessionUser"),
		@ApiImplicitParam(name = SubjectVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { SubjectVOMeta.PAGE_INDEX , SubjectVOMeta.PAGE_SIZE , SubjectVOMeta.SEARCH_FIELD , SubjectVOMeta.FUZZY_FIELD , SubjectVOMeta.SEARCH_VALUE , SubjectVOMeta.SORT_FIELD , SubjectVOMeta.SORT_TYPE , SubjectVOMeta.IDS } )
	@NotNull(name = SubjectVOMeta.ID)
	@SentinelResource(value = SubjectServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectServiceProxy.UPDATE)
	public Result update(SubjectVO subjectVO) {
		Result result=subjectService.update(subjectVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据权限主体
	*/
	@ApiOperation(value = "保存数据权限主体")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SubjectVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "SESSION_USER"),
		@ApiImplicitParam(name = SubjectVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "会话账户"),
		@ApiImplicitParam(name = SubjectVOMeta.GETTER , value = "Subject" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SubjectVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.session.SessionUser"),
		@ApiImplicitParam(name = SubjectVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SubjectVOMeta.PAGE_INDEX , SubjectVOMeta.PAGE_SIZE , SubjectVOMeta.SEARCH_FIELD , SubjectVOMeta.FUZZY_FIELD , SubjectVOMeta.SEARCH_VALUE , SubjectVOMeta.SORT_FIELD , SubjectVOMeta.SORT_TYPE , SubjectVOMeta.IDS } )
	@NotNull(name = SubjectVOMeta.ID)
	@SentinelResource(value = SubjectServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectServiceProxy.SAVE)
	public Result save(SubjectVO subjectVO) {
		Result result=subjectService.save(subjectVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据权限主体
	*/
	@ApiOperation(value = "获取数据权限主体")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = SubjectVOMeta.ID)
	@SentinelResource(value = SubjectServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectServiceProxy.GET_BY_ID)
	public Result<Subject> getById(String id) {
		Result<Subject> result=new Result<>();
		Subject subject=subjectService.getById(id);

		// join 关联的对象
		subjectService.dao().fill(subject)
			.execute();

		result.success(true).data(subject);
		return result;
	}


	/**
	 * 批量获取数据权限主体 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据权限主体")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SubjectVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = SubjectVOMeta.IDS)
		@SentinelResource(value = SubjectServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectServiceProxy.GET_BY_IDS)
	public Result<List<Subject>> getByIds(List<String> ids) {
		Result<List<Subject>> result=new Result<>();
		List<Subject> list=subjectService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据权限主体
	*/
	@ApiOperation(value = "查询数据权限主体")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SubjectVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "SESSION_USER"),
		@ApiImplicitParam(name = SubjectVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "会话账户"),
		@ApiImplicitParam(name = SubjectVOMeta.GETTER , value = "Subject" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SubjectVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.session.SessionUser"),
		@ApiImplicitParam(name = SubjectVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SubjectVOMeta.PAGE_INDEX , SubjectVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SubjectServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectServiceProxy.QUERY_LIST)
	public Result<List<Subject>> queryList(SubjectVO sample) {
		Result<List<Subject>> result=new Result<>();
		List<Subject> list=subjectService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据权限主体
	*/
	@ApiOperation(value = "分页查询数据权限主体")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SubjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SubjectVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "SESSION_USER"),
		@ApiImplicitParam(name = SubjectVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "会话账户"),
		@ApiImplicitParam(name = SubjectVOMeta.GETTER , value = "Subject" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SubjectVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.session.SessionUser"),
		@ApiImplicitParam(name = SubjectVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = SubjectServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SubjectServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Subject>> queryPagedList(SubjectVO sample) {
		Result<PagedList<Subject>> result=new Result<>();
		PagedList<Subject> list=subjectService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		subjectService.dao().fill(list)
			.execute();

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = SubjectServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SubjectServiceProxy.EXPORT_EXCEL)
	public void exportExcel(SubjectVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=subjectService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = SubjectServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SubjectServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=subjectService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = SubjectServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SubjectServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=subjectService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}