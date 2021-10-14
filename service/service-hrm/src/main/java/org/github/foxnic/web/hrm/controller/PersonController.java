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


import org.github.foxnic.web.proxy.hrm.PersonServiceProxy;
import org.github.foxnic.web.domain.hrm.meta.PersonVOMeta;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.hrm.PersonVO;
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
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.hrm.service.IPersonService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 人员表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-14 15:44:30
*/

@Api(tags = "人员")
@ApiSort(0)
@RestController("HrmPersonController")
public class PersonController extends SuperController {

	@Autowired
	private IPersonService personService;


	/**
	 * 添加人员
	*/
	@ApiOperation(value = "添加人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "483311859051532288"),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "111"),
		@ApiImplicitParam(name = PersonVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.SOURCE , value = "来源" , required = true , dataTypeClass=String.class , example = "employee"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY , value = "身份证号码" , required = true , dataTypeClass=String.class , example = "330219198444152524"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = PersonVOMeta.SOURCE)
	@NotNull(name = PersonVOMeta.IDENTITY)
	@SentinelResource(value = PersonServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.INSERT)
	public Result insert(PersonVO personVO) {
		Result result=personService.insert(personVO);
		return result;
	}



	/**
	 * 删除人员
	*/
	@ApiOperation(value = "删除人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "483311859051532288")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = PersonVOMeta.ID)
	@SentinelResource(value = PersonServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=personService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除人员 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = PersonVOMeta.IDS)
	@SentinelResource(value = PersonServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=personService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新人员
	*/
	@ApiOperation(value = "更新人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "483311859051532288"),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "111"),
		@ApiImplicitParam(name = PersonVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.SOURCE , value = "来源" , required = true , dataTypeClass=String.class , example = "employee"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY , value = "身份证号码" , required = true , dataTypeClass=String.class , example = "330219198444152524"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { PersonVOMeta.PAGE_INDEX , PersonVOMeta.PAGE_SIZE , PersonVOMeta.SEARCH_FIELD , PersonVOMeta.FUZZY_FIELD , PersonVOMeta.SEARCH_VALUE , PersonVOMeta.SORT_FIELD , PersonVOMeta.SORT_TYPE , PersonVOMeta.IDS } )
	@NotNull(name = PersonVOMeta.ID)
	@NotNull(name = PersonVOMeta.SOURCE)
	@NotNull(name = PersonVOMeta.IDENTITY)
	@SentinelResource(value = PersonServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.UPDATE)
	public Result update(PersonVO personVO) {
		Result result=personService.update(personVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存人员
	*/
	@ApiOperation(value = "保存人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "483311859051532288"),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "111"),
		@ApiImplicitParam(name = PersonVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.SOURCE , value = "来源" , required = true , dataTypeClass=String.class , example = "employee"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY , value = "身份证号码" , required = true , dataTypeClass=String.class , example = "330219198444152524"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonVOMeta.PAGE_INDEX , PersonVOMeta.PAGE_SIZE , PersonVOMeta.SEARCH_FIELD , PersonVOMeta.FUZZY_FIELD , PersonVOMeta.SEARCH_VALUE , PersonVOMeta.SORT_FIELD , PersonVOMeta.SORT_TYPE , PersonVOMeta.IDS } )
	@NotNull(name = PersonVOMeta.ID)
	@NotNull(name = PersonVOMeta.SOURCE)
	@NotNull(name = PersonVOMeta.IDENTITY)
	@SentinelResource(value = PersonServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.SAVE)
	public Result save(PersonVO personVO) {
		Result result=personService.save(personVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取人员
	*/
	@ApiOperation(value = "获取人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = PersonVOMeta.ID)
	@SentinelResource(value = PersonServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.GET_BY_ID)
	public Result<Person> getById(String id) {
		Result<Person> result=new Result<>();
		Person person=personService.getById(id);
		result.success(true).data(person);
		return result;
	}


	/**
	 * 批量获取人员 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取人员")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = PersonVOMeta.IDS)
		@SentinelResource(value = PersonServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.GET_BY_IDS)
	public Result<List<Person>> getByIds(List<String> ids) {
		Result<List<Person>> result=new Result<>();
		List<Person> list=personService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询人员
	*/
	@ApiOperation(value = "查询人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "483311859051532288"),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "111"),
		@ApiImplicitParam(name = PersonVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.SOURCE , value = "来源" , required = true , dataTypeClass=String.class , example = "employee"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY , value = "身份证号码" , required = true , dataTypeClass=String.class , example = "330219198444152524"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonVOMeta.PAGE_INDEX , PersonVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.QUERY_LIST)
	public Result<List<Person>> queryList(PersonVO sample) {
		Result<List<Person>> result=new Result<>();
		List<Person> list=personService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询人员
	*/
	@ApiOperation(value = "分页查询人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "483311859051532288"),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "111"),
		@ApiImplicitParam(name = PersonVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonVOMeta.SOURCE , value = "来源" , required = true , dataTypeClass=String.class , example = "employee"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY , value = "身份证号码" , required = true , dataTypeClass=String.class , example = "330219198444152524"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = PersonServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Person>> queryPagedList(PersonVO sample) {
		Result<PagedList<Person>> result=new Result<>();
		PagedList<Person> list=personService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = PersonServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PersonServiceProxy.EXPORT_EXCEL)
	public void exportExcel(PersonVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=personService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = PersonServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PersonServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=personService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = PersonServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PersonServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=personService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}