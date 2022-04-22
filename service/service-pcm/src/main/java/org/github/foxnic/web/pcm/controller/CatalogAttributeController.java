package org.github.foxnic.web.pcm.controller;


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
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.CatalogAttributeVO;
import org.github.foxnic.web.domain.pcm.meta.CatalogAttributeVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.pcm.service.ICatalogAttributeService;
import org.github.foxnic.web.proxy.pcm.CatalogAttributeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 分类属性表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-02 20:15:33
 * @version
*/

@Api(tags = "分类属性")
@ApiSort(0)
@RestController("PcmCatalogAttributeController")
public class CatalogAttributeController extends SuperController {

	@Autowired
	private ICatalogAttributeService catalogAttributeService;

	
	/**
	 * 添加分类属性
	*/
	@ApiOperation(value = "添加分类属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485774276973043712"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.CATALOG_ID , value = "存储ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.FIELD , value = "字段名" , required = true , dataTypeClass=String.class , example = "serial_number"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.VERSION_NO , value = "配置版本号" , required = false , dataTypeClass=String.class , example = "activated"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.DATA_TYPE , value = "数据类型" , required = true , dataTypeClass=String.class , example = "STRING"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.LENGTH , value = "数据长度" , required = false , dataTypeClass=Integer.class , example = "64"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.ACCURACY , value = "数据精度" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SCALE , value = "小数位数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SHORT_NAME , value = "简称" , required = true , dataTypeClass=String.class , example = "SN"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.FULL_NAME , value = "全称" , required = true , dataTypeClass=String.class , example = "序列号"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.HINT , value = "提示信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.DETAIL , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SOURCE_ID , value = "原属性ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = CatalogAttributeVOMeta.ID)
	@NotNull(name = CatalogAttributeVOMeta.CATALOG_ID)
	@NotNull(name = CatalogAttributeVOMeta.FIELD)
	@NotNull(name = CatalogAttributeVOMeta.DATA_TYPE)
	@NotNull(name = CatalogAttributeVOMeta.SHORT_NAME)
	@NotNull(name = CatalogAttributeVOMeta.FULL_NAME)
	@NotNull(name = CatalogAttributeVOMeta.VALID)
	@SentinelResource(value = CatalogAttributeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogAttributeServiceProxy.INSERT)
	public Result insert(CatalogAttributeVO catalogAttributeVO) {
		Result result=catalogAttributeService.insert(catalogAttributeVO);
		return result;
	}

	
	/**
	 * 删除分类属性
	*/
	@ApiOperation(value = "删除分类属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485774276973043712")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CatalogAttributeVOMeta.ID)
	@SentinelResource(value = CatalogAttributeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogAttributeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=catalogAttributeService.deleteByIdPhysical(id);
		return result;
	}
	
	
	/**
	 * 批量删除分类属性 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除分类属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogAttributeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CatalogAttributeVOMeta.IDS)
	@SentinelResource(value = CatalogAttributeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogAttributeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=catalogAttributeService.deleteByIdsPhysical(ids);
		return result;
	}
	
	/**
	 * 更新分类属性
	*/
	@ApiOperation(value = "更新分类属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485774276973043712"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.CATALOG_ID , value = "存储ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.FIELD , value = "字段名" , required = true , dataTypeClass=String.class , example = "serial_number"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.VERSION_NO , value = "配置版本号" , required = false , dataTypeClass=String.class , example = "activated"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.DATA_TYPE , value = "数据类型" , required = true , dataTypeClass=String.class , example = "STRING"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.LENGTH , value = "数据长度" , required = false , dataTypeClass=Integer.class , example = "64"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.ACCURACY , value = "数据精度" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SCALE , value = "小数位数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SHORT_NAME , value = "简称" , required = true , dataTypeClass=String.class , example = "SN"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.FULL_NAME , value = "全称" , required = true , dataTypeClass=String.class , example = "序列号"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.HINT , value = "提示信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.DETAIL , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SOURCE_ID , value = "原属性ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CatalogAttributeVOMeta.PAGE_INDEX , CatalogAttributeVOMeta.PAGE_SIZE , CatalogAttributeVOMeta.SEARCH_FIELD , CatalogAttributeVOMeta.FUZZY_FIELD , CatalogAttributeVOMeta.SEARCH_VALUE , CatalogAttributeVOMeta.SORT_FIELD , CatalogAttributeVOMeta.SORT_TYPE , CatalogAttributeVOMeta.IDS } ) 
	@NotNull(name = CatalogAttributeVOMeta.ID)
	@NotNull(name = CatalogAttributeVOMeta.CATALOG_ID)
	@NotNull(name = CatalogAttributeVOMeta.FIELD)
	@NotNull(name = CatalogAttributeVOMeta.DATA_TYPE)
	@NotNull(name = CatalogAttributeVOMeta.SHORT_NAME)
	@NotNull(name = CatalogAttributeVOMeta.FULL_NAME)
	@NotNull(name = CatalogAttributeVOMeta.VALID)
	@SentinelResource(value = CatalogAttributeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogAttributeServiceProxy.UPDATE)
	public Result update(CatalogAttributeVO catalogAttributeVO) {
		Result result=catalogAttributeService.update(catalogAttributeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存分类属性
	*/
	@ApiOperation(value = "保存分类属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485774276973043712"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.CATALOG_ID , value = "存储ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.FIELD , value = "字段名" , required = true , dataTypeClass=String.class , example = "serial_number"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.VERSION_NO , value = "配置版本号" , required = false , dataTypeClass=String.class , example = "activated"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.DATA_TYPE , value = "数据类型" , required = true , dataTypeClass=String.class , example = "STRING"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.LENGTH , value = "数据长度" , required = false , dataTypeClass=Integer.class , example = "64"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.ACCURACY , value = "数据精度" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SCALE , value = "小数位数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SHORT_NAME , value = "简称" , required = true , dataTypeClass=String.class , example = "SN"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.FULL_NAME , value = "全称" , required = true , dataTypeClass=String.class , example = "序列号"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.HINT , value = "提示信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.DETAIL , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SOURCE_ID , value = "原属性ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CatalogAttributeVOMeta.PAGE_INDEX , CatalogAttributeVOMeta.PAGE_SIZE , CatalogAttributeVOMeta.SEARCH_FIELD , CatalogAttributeVOMeta.FUZZY_FIELD , CatalogAttributeVOMeta.SEARCH_VALUE , CatalogAttributeVOMeta.SORT_FIELD , CatalogAttributeVOMeta.SORT_TYPE , CatalogAttributeVOMeta.IDS } )
	@NotNull(name = CatalogAttributeVOMeta.ID)
	@NotNull(name = CatalogAttributeVOMeta.CATALOG_ID)
	@NotNull(name = CatalogAttributeVOMeta.FIELD)
	@NotNull(name = CatalogAttributeVOMeta.DATA_TYPE)
	@NotNull(name = CatalogAttributeVOMeta.SHORT_NAME)
	@NotNull(name = CatalogAttributeVOMeta.FULL_NAME)
	@NotNull(name = CatalogAttributeVOMeta.VALID)
	@SentinelResource(value = CatalogAttributeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogAttributeServiceProxy.SAVE)
	public Result save(CatalogAttributeVO catalogAttributeVO) {
		Result result=catalogAttributeService.save(catalogAttributeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取分类属性
	*/
	@ApiOperation(value = "获取分类属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CatalogAttributeVOMeta.ID)
	@SentinelResource(value = CatalogAttributeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogAttributeServiceProxy.GET_BY_ID)
	public Result<CatalogAttribute> getById(String id) {
		Result<CatalogAttribute> result=new Result<>();
		CatalogAttribute catalogAttribute=catalogAttributeService.getById(id);
		result.success(true).data(catalogAttribute);
		return result;
	}


	/**
	 * 批量删除分类属性 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除分类属性")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CatalogAttributeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CatalogAttributeVOMeta.IDS)
		@SentinelResource(value = CatalogAttributeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogAttributeServiceProxy.GET_BY_IDS)
	public Result<List<CatalogAttribute>> getByIds(List<String> ids) {
		Result<List<CatalogAttribute>> result=new Result<>();
		List<CatalogAttribute> list=catalogAttributeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询分类属性
	*/
	@ApiOperation(value = "查询分类属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485774276973043712"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.CATALOG_ID , value = "存储ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.FIELD , value = "字段名" , required = true , dataTypeClass=String.class , example = "serial_number"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.VERSION_NO , value = "配置版本号" , required = false , dataTypeClass=String.class , example = "activated"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.DATA_TYPE , value = "数据类型" , required = true , dataTypeClass=String.class , example = "STRING"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.LENGTH , value = "数据长度" , required = false , dataTypeClass=Integer.class , example = "64"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.ACCURACY , value = "数据精度" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SCALE , value = "小数位数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SHORT_NAME , value = "简称" , required = true , dataTypeClass=String.class , example = "SN"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.FULL_NAME , value = "全称" , required = true , dataTypeClass=String.class , example = "序列号"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.HINT , value = "提示信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.DETAIL , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SOURCE_ID , value = "原属性ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CatalogAttributeVOMeta.PAGE_INDEX , CatalogAttributeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CatalogAttributeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogAttributeServiceProxy.QUERY_LIST)
	public Result<List<CatalogAttribute>> queryList(CatalogAttributeVO sample) {
		Result<List<CatalogAttribute>> result=new Result<>();
		List<CatalogAttribute> list=catalogAttributeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询分类属性
	*/
	@ApiOperation(value = "分页查询分类属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485774276973043712"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.CATALOG_ID , value = "存储ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.FIELD , value = "字段名" , required = true , dataTypeClass=String.class , example = "serial_number"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.VERSION_NO , value = "配置版本号" , required = false , dataTypeClass=String.class , example = "activated"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.DATA_TYPE , value = "数据类型" , required = true , dataTypeClass=String.class , example = "STRING"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.LENGTH , value = "数据长度" , required = false , dataTypeClass=Integer.class , example = "64"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.ACCURACY , value = "数据精度" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SCALE , value = "小数位数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SHORT_NAME , value = "简称" , required = true , dataTypeClass=String.class , example = "SN"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.FULL_NAME , value = "全称" , required = true , dataTypeClass=String.class , example = "序列号"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.HINT , value = "提示信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.DETAIL , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = CatalogAttributeVOMeta.SOURCE_ID , value = "原属性ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CatalogAttributeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogAttributeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CatalogAttribute>> queryPagedList(CatalogAttributeVO sample) {
		Result<PagedList<CatalogAttribute>> result=new Result<>();
		PagedList<CatalogAttribute> list=catalogAttributeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		catalogAttributeService.join(list, Catalog.class);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CatalogAttributeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CatalogAttributeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CatalogAttributeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=catalogAttributeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CatalogAttributeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CatalogAttributeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=catalogAttributeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = CatalogAttributeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CatalogAttributeServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=catalogAttributeService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}