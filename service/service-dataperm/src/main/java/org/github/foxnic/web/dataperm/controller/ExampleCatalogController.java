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


import org.github.foxnic.web.proxy.dataperm.ExampleCatalogServiceProxy;
import org.github.foxnic.web.domain.dataperm.meta.ExampleCatalogVOMeta;
import org.github.foxnic.web.domain.dataperm.ExampleCatalog;
import org.github.foxnic.web.domain.dataperm.ExampleCatalogVO;
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
import org.github.foxnic.web.domain.dataperm.meta.ExampleCatalogMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.dataperm.service.IExampleCatalogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 商品分类表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-14 16:24:46
*/

@Api(tags = "商品分类")
@ApiSort(0)
@RestController("DpExampleCatalogController")
public class ExampleCatalogController extends SuperController {

	@Autowired
	private IExampleCatalogService exampleCatalogService;


	/**
	 * 添加商品分类
	*/
	@ApiOperation(value = "添加商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "BBT"),
		@ApiImplicitParam(name = ExampleCatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class , example = "TL"),
		@ApiImplicitParam(name = ExampleCatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "苯丙酮"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ExampleCatalogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleCatalogServiceProxy.INSERT)
	public Result insert(ExampleCatalogVO exampleCatalogVO) {
		Result result=exampleCatalogService.insert(exampleCatalogVO);
		return result;
	}



	/**
	 * 删除商品分类
	*/
	@ApiOperation(value = "删除商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "BBT")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ExampleCatalogVOMeta.ID)
	@SentinelResource(value = ExampleCatalogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleCatalogServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=exampleCatalogService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除商品分类 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleCatalogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ExampleCatalogVOMeta.IDS)
	@SentinelResource(value = ExampleCatalogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleCatalogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=exampleCatalogService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新商品分类
	*/
	@ApiOperation(value = "更新商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "BBT"),
		@ApiImplicitParam(name = ExampleCatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class , example = "TL"),
		@ApiImplicitParam(name = ExampleCatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "苯丙酮"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ExampleCatalogVOMeta.PAGE_INDEX , ExampleCatalogVOMeta.PAGE_SIZE , ExampleCatalogVOMeta.SEARCH_FIELD , ExampleCatalogVOMeta.FUZZY_FIELD , ExampleCatalogVOMeta.SEARCH_VALUE , ExampleCatalogVOMeta.SORT_FIELD , ExampleCatalogVOMeta.SORT_TYPE , ExampleCatalogVOMeta.IDS } )
	@NotNull(name = ExampleCatalogVOMeta.ID)
	@SentinelResource(value = ExampleCatalogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleCatalogServiceProxy.UPDATE)
	public Result update(ExampleCatalogVO exampleCatalogVO) {
		Result result=exampleCatalogService.update(exampleCatalogVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存商品分类
	*/
	@ApiOperation(value = "保存商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "BBT"),
		@ApiImplicitParam(name = ExampleCatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class , example = "TL"),
		@ApiImplicitParam(name = ExampleCatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "苯丙酮"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleCatalogVOMeta.PAGE_INDEX , ExampleCatalogVOMeta.PAGE_SIZE , ExampleCatalogVOMeta.SEARCH_FIELD , ExampleCatalogVOMeta.FUZZY_FIELD , ExampleCatalogVOMeta.SEARCH_VALUE , ExampleCatalogVOMeta.SORT_FIELD , ExampleCatalogVOMeta.SORT_TYPE , ExampleCatalogVOMeta.IDS } )
	@NotNull(name = ExampleCatalogVOMeta.ID)
	@SentinelResource(value = ExampleCatalogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleCatalogServiceProxy.SAVE)
	public Result save(ExampleCatalogVO exampleCatalogVO) {
		Result result=exampleCatalogService.save(exampleCatalogVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取商品分类
	*/
	@ApiOperation(value = "获取商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ExampleCatalogVOMeta.ID)
	@SentinelResource(value = ExampleCatalogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleCatalogServiceProxy.GET_BY_ID)
	public Result<ExampleCatalog> getById(String id) {
		Result<ExampleCatalog> result=new Result<>();
		ExampleCatalog exampleCatalog=exampleCatalogService.getById(id);
		result.success(true).data(exampleCatalog);
		return result;
	}


	/**
	 * 批量获取商品分类 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取商品分类")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ExampleCatalogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ExampleCatalogVOMeta.IDS)
		@SentinelResource(value = ExampleCatalogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleCatalogServiceProxy.GET_BY_IDS)
	public Result<List<ExampleCatalog>> getByIds(List<String> ids) {
		Result<List<ExampleCatalog>> result=new Result<>();
		List<ExampleCatalog> list=exampleCatalogService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询商品分类
	*/
	@ApiOperation(value = "查询商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "BBT"),
		@ApiImplicitParam(name = ExampleCatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class , example = "TL"),
		@ApiImplicitParam(name = ExampleCatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "苯丙酮"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleCatalogVOMeta.PAGE_INDEX , ExampleCatalogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ExampleCatalogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleCatalogServiceProxy.QUERY_LIST)
	public Result<List<ExampleCatalog>> queryList(ExampleCatalogVO sample) {
		Result<List<ExampleCatalog>> result=new Result<>();
		List<ExampleCatalog> list=exampleCatalogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询商品分类
	*/
	@ApiOperation(value = "分页查询商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "BBT"),
		@ApiImplicitParam(name = ExampleCatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class , example = "TL"),
		@ApiImplicitParam(name = ExampleCatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "苯丙酮"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ExampleCatalogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleCatalogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ExampleCatalog>> queryPagedList(ExampleCatalogVO sample) {
		Result<PagedList<ExampleCatalog>> result=new Result<>();
		PagedList<ExampleCatalog> list=exampleCatalogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ExampleCatalogServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleCatalogServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ExampleCatalogVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=exampleCatalogService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ExampleCatalogServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleCatalogServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=exampleCatalogService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ExampleCatalogServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleCatalogServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=exampleCatalogService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}