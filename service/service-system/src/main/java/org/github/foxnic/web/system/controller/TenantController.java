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


import org.github.foxnic.web.proxy.system.TenantServiceProxy;
import org.github.foxnic.web.domain.system.meta.TenantVOMeta;
import org.github.foxnic.web.domain.system.Tenant;
import org.github.foxnic.web.domain.system.TenantVO;
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
import org.github.foxnic.web.domain.system.meta.TenantMeta;
import org.github.foxnic.web.domain.hrm.Company;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.ITenantService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 租户表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-26 15:35:43
*/

@Api(tags = "租户")
@ApiSort(0)
@RestController("SysTenantController")
public class TenantController extends SuperController {

	@Autowired
	private ITenantService tenantService;

	
	/**
	 * 添加租户
	*/
	@ApiOperation(value = "添加租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "T001"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "国烨能源集团"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class , example = "002"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = TenantVOMeta.ID)
	@SentinelResource(value = TenantServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.INSERT)
	public Result insert(TenantVO tenantVO) {
		Result result=tenantService.insert(tenantVO);
		return result;
	}

	
	/**
	 * 删除租户
	*/
	@ApiOperation(value = "删除租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "T001")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = TenantVOMeta.ID)
	@SentinelResource(value = TenantServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=tenantService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除租户 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = TenantVOMeta.IDS)
	@SentinelResource(value = TenantServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=tenantService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新租户
	*/
	@ApiOperation(value = "更新租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "T001"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "国烨能源集团"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class , example = "002"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { TenantVOMeta.PAGE_INDEX , TenantVOMeta.PAGE_SIZE , TenantVOMeta.SEARCH_FIELD , TenantVOMeta.FUZZY_FIELD , TenantVOMeta.SEARCH_VALUE , TenantVOMeta.SORT_FIELD , TenantVOMeta.SORT_TYPE , TenantVOMeta.IDS } ) 
	@NotNull(name = TenantVOMeta.ID)
	@SentinelResource(value = TenantServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.UPDATE)
	public Result update(TenantVO tenantVO) {
		Result result=tenantService.update(tenantVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存租户
	*/
	@ApiOperation(value = "保存租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "T001"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "国烨能源集团"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class , example = "002"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TenantVOMeta.PAGE_INDEX , TenantVOMeta.PAGE_SIZE , TenantVOMeta.SEARCH_FIELD , TenantVOMeta.FUZZY_FIELD , TenantVOMeta.SEARCH_VALUE , TenantVOMeta.SORT_FIELD , TenantVOMeta.SORT_TYPE , TenantVOMeta.IDS } )
	@NotNull(name = TenantVOMeta.ID)
	@SentinelResource(value = TenantServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.SAVE)
	public Result save(TenantVO tenantVO) {
		Result result=tenantService.save(tenantVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取租户
	*/
	@ApiOperation(value = "获取租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = TenantVOMeta.ID)
	@SentinelResource(value = TenantServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.GET_BY_ID)
	public Result<Tenant> getById(String id) {
		Result<Tenant> result=new Result<>();
		Tenant tenant=tenantService.getById(id);
		// 关联出 公司 数据
		tenantService.join(tenant,TenantMeta.COMPANY);
		result.success(true).data(tenant);
		return result;
	}


	/**
	 * 批量删除租户 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除租户")
		@ApiImplicitParams({
				@ApiImplicitParam(name = TenantVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = TenantVOMeta.IDS)
		@SentinelResource(value = TenantServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.GET_BY_IDS)
	public Result<List<Tenant>> getByIds(List<String> ids) {
		Result<List<Tenant>> result=new Result<>();
		List<Tenant> list=tenantService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询租户
	*/
	@ApiOperation(value = "查询租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "T001"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "国烨能源集团"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class , example = "002"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TenantVOMeta.PAGE_INDEX , TenantVOMeta.PAGE_SIZE } )
	@SentinelResource(value = TenantServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.QUERY_LIST)
	public Result<List<Tenant>> queryList(TenantVO sample) {
		Result<List<Tenant>> result=new Result<>();
		List<Tenant> list=tenantService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询租户
	*/
	@ApiOperation(value = "分页查询租户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TenantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "T001"),
		@ApiImplicitParam(name = TenantVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class , example = "国烨能源集团"),
		@ApiImplicitParam(name = TenantVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = TenantVOMeta.COMPANY_ID , value = "公司ID" , required = false , dataTypeClass=String.class , example = "002"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = TenantServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TenantServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Tenant>> queryPagedList(TenantVO sample) {
		Result<PagedList<Tenant>> result=new Result<>();
		PagedList<Tenant> list=tenantService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 公司 数据
		tenantService.join(list,TenantMeta.COMPANY);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = TenantServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(TenantServiceProxy.EXPORT_EXCEL)
	public void exportExcel(TenantVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=tenantService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = TenantServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(TenantServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=tenantService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = TenantServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(TenantServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=tenantService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}