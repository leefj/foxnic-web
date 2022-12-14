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
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.OrganizationMeta;
import org.github.foxnic.web.domain.hrm.meta.PositionMeta;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
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
 * ??????????????????????????? ???????????????
 * </p>
 * @author ????????? , leefangjie@qq.com
 * @since 2022-02-07 09:03:10
*/

@Api(tags = "???????????????????????????")
@ApiSort(0)
@RestController("SysCodeExampleCarController")
public class CodeExampleCarController extends SuperController {

	@Autowired
	private ICodeExampleCarService codeExampleCarService;


	/**
	 * ?????????????????????????????????
	*/
	@ApiOperation(value = "?????????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "?????????" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "??????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "????????????" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CodeExampleCarServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.INSERT)
	public Result insert(CodeExampleCarVO codeExampleCarVO) {
		Result result=codeExampleCarService.insert(codeExampleCarVO,false);
		return result;
	}



	/**
	 * ?????????????????????????????????
	*/
	@ApiOperation(value = "?????????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "476464971060871168")
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
	 * ??????????????????????????????????????? <br>
	 * ???????????????????????????????????????
	*/
	@ApiOperation(value = "???????????????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
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
	 * ?????????????????????????????????
	*/
	@ApiOperation(value = "?????????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "?????????" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "??????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "????????????" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CodeExampleCarVOMeta.PAGE_INDEX , CodeExampleCarVOMeta.PAGE_SIZE , CodeExampleCarVOMeta.SEARCH_FIELD , CodeExampleCarVOMeta.FUZZY_FIELD , CodeExampleCarVOMeta.SEARCH_VALUE , CodeExampleCarVOMeta.DIRTY_FIELDS , CodeExampleCarVOMeta.SORT_FIELD , CodeExampleCarVOMeta.SORT_TYPE , CodeExampleCarVOMeta.IDS } )
	@NotNull(name = CodeExampleCarVOMeta.ID)
	@SentinelResource(value = CodeExampleCarServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.UPDATE)
	public Result update(CodeExampleCarVO codeExampleCarVO) {
		Result result=codeExampleCarService.update(codeExampleCarVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * ?????????????????????????????????
	*/
	@ApiOperation(value = "?????????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "?????????" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "??????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "????????????" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeExampleCarVOMeta.PAGE_INDEX , CodeExampleCarVOMeta.PAGE_SIZE , CodeExampleCarVOMeta.SEARCH_FIELD , CodeExampleCarVOMeta.FUZZY_FIELD , CodeExampleCarVOMeta.SEARCH_VALUE , CodeExampleCarVOMeta.DIRTY_FIELDS , CodeExampleCarVOMeta.SORT_FIELD , CodeExampleCarVOMeta.SORT_TYPE , CodeExampleCarVOMeta.IDS } )
	@NotNull(name = CodeExampleCarVOMeta.ID)
	@SentinelResource(value = CodeExampleCarServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.SAVE)
	public Result save(CodeExampleCarVO codeExampleCarVO) {
		Result result=codeExampleCarService.save(codeExampleCarVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * ?????????????????????????????????
	*/
	@ApiOperation(value = "?????????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CodeExampleCarVOMeta.ID)
	@SentinelResource(value = CodeExampleCarServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.GET_BY_ID)
	public Result<CodeExampleCar> getById(String id) {
		Result<CodeExampleCar> result=new Result<>();
		CodeExampleCar codeExampleCar=codeExampleCarService.getById(id);
		// join ???????????????
		codeExampleCarService.dao().fill(codeExampleCar)
			.with(CodeExampleCarMeta.ORGANIZATION)
			.with(CodeExampleCarMeta.SUB_ORGANIZATION)
			.with(CodeExampleCarMeta.COMPANY)
			.with(CodeExampleCarMeta.POSITION)
			.with(CodeExampleCarMeta.EMPLOYEE,EmployeeMeta.PERSON)
			.execute();
		result.success(true).data(codeExampleCar);
		return result;
	}


	/**
	 * ??????????????????????????????????????? <br>
	 * ???????????????????????????????????????
	*/
		@ApiOperation(value = "???????????????????????????????????????")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CodeExampleCarVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
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
	 * ?????????????????????????????????
	*/
	@ApiOperation(value = "?????????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "?????????" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "??????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "????????????" , required = false , dataTypeClass=String.class),
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
	 * ???????????????????????????????????????
	*/
	@ApiOperation(value = "???????????????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "?????????" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "??????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "????????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "????????????" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CodeExampleCarServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CodeExampleCar>> queryPagedList(CodeExampleCarVO sample) {
		Result<PagedList<CodeExampleCar>> result=new Result<>();
		PagedList<CodeExampleCar> list=codeExampleCarService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join ???????????????
		codeExampleCarService.dao().fill(list)
			.with(CodeExampleCarMeta.ORGANIZATION)
			.with(CodeExampleCarMeta.SUB_ORGANIZATION)
			.with(CodeExampleCarMeta.COMPANY)
			.with(CodeExampleCarMeta.POSITION)
			.with(CodeExampleCarMeta.EMPLOYEE,EmployeeMeta.PERSON)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * ?????? Excel
	 * */
	@SentinelResource(value = CodeExampleCarServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeExampleCarServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CodeExampleCarVO  sample,HttpServletResponse response) throws Exception {
		try{
			//?????? Excel ??????
			ExcelWriter ew=codeExampleCarService.exportExcel(sample);
			//??????
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * ?????? Excel ??????
	 * */
	@SentinelResource(value = CodeExampleCarServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeExampleCarServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//?????? Excel ??????
			ExcelWriter ew=codeExampleCarService.exportExcelTemplate();
			//??????
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = CodeExampleCarServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeExampleCarServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

		//?????????????????????
		Map<String, MultipartFile> map = request.getFileMap();
		InputStream input=null;
		for (MultipartFile mf : map.values()) {
			input=StreamUtil.bytes2input(mf.getBytes());
			break;
		}

		if(input==null) {
			return ErrorDesc.failure().message("?????????????????????");
		}

		List<ValidateResult> errors=codeExampleCarService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("????????????").data(errors);
		}
	}


}