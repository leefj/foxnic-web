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


import org.github.foxnic.web.proxy.dataperm.ExampleProductServiceProxy;
import org.github.foxnic.web.domain.dataperm.meta.ExampleProductVOMeta;
import org.github.foxnic.web.domain.dataperm.ExampleProduct;
import org.github.foxnic.web.domain.dataperm.ExampleProductVO;
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
import org.github.foxnic.web.domain.dataperm.meta.ExampleProductMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.dataperm.ExampleCatalog;
import org.github.foxnic.web.domain.dataperm.ExampleBrand;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.dataperm.service.IExampleProductService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 销售订单表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-28 10:00:48
*/

@Api(tags = "销售订单")
@ApiSort(0)
@RestController("DpExampleProductController")
public class ExampleProductController extends SuperController {

	@Autowired
	private IExampleProductService exampleProductService;


	/**
	 * 添加销售订单
	*/
	@ApiOperation(value = "添加销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "501041838359052288"),
		@ApiImplicitParam(name = ExampleProductVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "苯丙酮-9881"),
		@ApiImplicitParam(name = ExampleProductVOMeta.BRAND_ID , value = "品牌ID" , required = false , dataTypeClass=String.class , example = "NBFD"),
		@ApiImplicitParam(name = ExampleProductVOMeta.BIG_CATA_ID , value = "大类ID" , required = false , dataTypeClass=String.class , example = "TL"),
		@ApiImplicitParam(name = ExampleProductVOMeta.SML_CATA_ID , value = "小类ID" , required = false , dataTypeClass=String.class , example = "BBT"),
		@ApiImplicitParam(name = ExampleProductVOMeta.PRICE , value = "售价" , required = false , dataTypeClass=BigDecimal.class , example = "54.81"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ExampleProductServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleProductServiceProxy.INSERT)
	public Result insert(ExampleProductVO exampleProductVO) {
		Result result=exampleProductService.insert(exampleProductVO,false);
		return result;
	}



	/**
	 * 删除销售订单
	*/
	@ApiOperation(value = "删除销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "501041838359052288")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ExampleProductVOMeta.ID)
	@SentinelResource(value = ExampleProductServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleProductServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=exampleProductService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除销售订单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleProductVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ExampleProductVOMeta.IDS)
	@SentinelResource(value = ExampleProductServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleProductServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=exampleProductService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新销售订单
	*/
	@ApiOperation(value = "更新销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "501041838359052288"),
		@ApiImplicitParam(name = ExampleProductVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "苯丙酮-9881"),
		@ApiImplicitParam(name = ExampleProductVOMeta.BRAND_ID , value = "品牌ID" , required = false , dataTypeClass=String.class , example = "NBFD"),
		@ApiImplicitParam(name = ExampleProductVOMeta.BIG_CATA_ID , value = "大类ID" , required = false , dataTypeClass=String.class , example = "TL"),
		@ApiImplicitParam(name = ExampleProductVOMeta.SML_CATA_ID , value = "小类ID" , required = false , dataTypeClass=String.class , example = "BBT"),
		@ApiImplicitParam(name = ExampleProductVOMeta.PRICE , value = "售价" , required = false , dataTypeClass=BigDecimal.class , example = "54.81"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ExampleProductVOMeta.PAGE_INDEX , ExampleProductVOMeta.PAGE_SIZE , ExampleProductVOMeta.SEARCH_FIELD , ExampleProductVOMeta.FUZZY_FIELD , ExampleProductVOMeta.SEARCH_VALUE , ExampleProductVOMeta.SORT_FIELD , ExampleProductVOMeta.SORT_TYPE , ExampleProductVOMeta.IDS } )
	@NotNull(name = ExampleProductVOMeta.ID)
	@SentinelResource(value = ExampleProductServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleProductServiceProxy.UPDATE)
	public Result update(ExampleProductVO exampleProductVO) {
		Result result=exampleProductService.update(exampleProductVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存销售订单
	*/
	@ApiOperation(value = "保存销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "501041838359052288"),
		@ApiImplicitParam(name = ExampleProductVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "苯丙酮-9881"),
		@ApiImplicitParam(name = ExampleProductVOMeta.BRAND_ID , value = "品牌ID" , required = false , dataTypeClass=String.class , example = "NBFD"),
		@ApiImplicitParam(name = ExampleProductVOMeta.BIG_CATA_ID , value = "大类ID" , required = false , dataTypeClass=String.class , example = "TL"),
		@ApiImplicitParam(name = ExampleProductVOMeta.SML_CATA_ID , value = "小类ID" , required = false , dataTypeClass=String.class , example = "BBT"),
		@ApiImplicitParam(name = ExampleProductVOMeta.PRICE , value = "售价" , required = false , dataTypeClass=BigDecimal.class , example = "54.81"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleProductVOMeta.PAGE_INDEX , ExampleProductVOMeta.PAGE_SIZE , ExampleProductVOMeta.SEARCH_FIELD , ExampleProductVOMeta.FUZZY_FIELD , ExampleProductVOMeta.SEARCH_VALUE , ExampleProductVOMeta.SORT_FIELD , ExampleProductVOMeta.SORT_TYPE , ExampleProductVOMeta.IDS } )
	@NotNull(name = ExampleProductVOMeta.ID)
	@SentinelResource(value = ExampleProductServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleProductServiceProxy.SAVE)
	public Result save(ExampleProductVO exampleProductVO) {
		Result result=exampleProductService.save(exampleProductVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取销售订单
	*/
	@ApiOperation(value = "获取销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ExampleProductVOMeta.ID)
	@SentinelResource(value = ExampleProductServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleProductServiceProxy.GET_BY_ID)
	public Result<ExampleProduct> getById(String id) {
		Result<ExampleProduct> result=new Result<>();
		ExampleProduct exampleProduct=exampleProductService.getById(id);

		// join 关联的对象
		exampleProductService.dao().fill(exampleProduct)
			.execute();

		result.success(true).data(exampleProduct);
		return result;
	}


	/**
	 * 批量获取销售订单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取销售订单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ExampleProductVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ExampleProductVOMeta.IDS)
		@SentinelResource(value = ExampleProductServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleProductServiceProxy.GET_BY_IDS)
	public Result<List<ExampleProduct>> getByIds(List<String> ids) {
		Result<List<ExampleProduct>> result=new Result<>();
		List<ExampleProduct> list=exampleProductService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询销售订单
	*/
	@ApiOperation(value = "查询销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "501041838359052288"),
		@ApiImplicitParam(name = ExampleProductVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "苯丙酮-9881"),
		@ApiImplicitParam(name = ExampleProductVOMeta.BRAND_ID , value = "品牌ID" , required = false , dataTypeClass=String.class , example = "NBFD"),
		@ApiImplicitParam(name = ExampleProductVOMeta.BIG_CATA_ID , value = "大类ID" , required = false , dataTypeClass=String.class , example = "TL"),
		@ApiImplicitParam(name = ExampleProductVOMeta.SML_CATA_ID , value = "小类ID" , required = false , dataTypeClass=String.class , example = "BBT"),
		@ApiImplicitParam(name = ExampleProductVOMeta.PRICE , value = "售价" , required = false , dataTypeClass=BigDecimal.class , example = "54.81"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleProductVOMeta.PAGE_INDEX , ExampleProductVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ExampleProductServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleProductServiceProxy.QUERY_LIST)
	public Result<List<ExampleProduct>> queryList(ExampleProductVO sample) {
		Result<List<ExampleProduct>> result=new Result<>();
		List<ExampleProduct> list=exampleProductService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询销售订单
	*/
	@ApiOperation(value = "分页查询销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "501041838359052288"),
		@ApiImplicitParam(name = ExampleProductVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "苯丙酮-9881"),
		@ApiImplicitParam(name = ExampleProductVOMeta.BRAND_ID , value = "品牌ID" , required = false , dataTypeClass=String.class , example = "NBFD"),
		@ApiImplicitParam(name = ExampleProductVOMeta.BIG_CATA_ID , value = "大类ID" , required = false , dataTypeClass=String.class , example = "TL"),
		@ApiImplicitParam(name = ExampleProductVOMeta.SML_CATA_ID , value = "小类ID" , required = false , dataTypeClass=String.class , example = "BBT"),
		@ApiImplicitParam(name = ExampleProductVOMeta.PRICE , value = "售价" , required = false , dataTypeClass=BigDecimal.class , example = "54.81"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ExampleProductServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleProductServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ExampleProduct>> queryPagedList(ExampleProductVO sample) {
		Result<PagedList<ExampleProduct>> result=new Result<>();
		PagedList<ExampleProduct> list=exampleProductService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		exampleProductService.dao().fill(list)
			.execute();

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ExampleProductServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleProductServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ExampleProductVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=exampleProductService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ExampleProductServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleProductServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=exampleProductService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ExampleProductServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleProductServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=exampleProductService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}