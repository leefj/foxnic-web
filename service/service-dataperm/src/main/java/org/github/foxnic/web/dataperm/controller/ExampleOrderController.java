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


import org.github.foxnic.web.proxy.dataperm.ExampleOrderServiceProxy;
import org.github.foxnic.web.domain.dataperm.meta.ExampleOrderVOMeta;
import org.github.foxnic.web.domain.dataperm.ExampleOrder;
import org.github.foxnic.web.domain.dataperm.ExampleOrderVO;
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
import org.github.foxnic.web.domain.dataperm.meta.ExampleOrderMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.dataperm.ExampleShop;
import org.github.foxnic.web.domain.dataperm.ExampleProduct;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.dataperm.meta.ExampleProductMeta;
import org.github.foxnic.web.domain.dataperm.meta.ExampleBrandMeta;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.dataperm.service.IExampleOrderService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 销售订单表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-16 14:25:14
*/

@Api(tags = "销售订单")
@ApiSort(0)
@RestController("DpExampleOrderController")
public class ExampleOrderController extends SuperController {

	@Autowired
	private IExampleOrderService exampleOrderService;


	/**
	 * 添加销售订单
	*/
	@ApiOperation(value = "添加销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "501045698477686784"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=String.class , example = "501041838359052288"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.PRICE , value = "售价" , required = false , dataTypeClass=BigDecimal.class , example = "53.19"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.QUANTITY , value = "数量" , required = false , dataTypeClass=Integer.class , example = "93"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.AMOUNT , value = "金额" , required = false , dataTypeClass=BigDecimal.class , example = "4946.67"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SHOP_ID , value = "店铺ID" , required = false , dataTypeClass=String.class , example = "500998069018431488"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SALES_ID , value = "销售人员ID" , required = false , dataTypeClass=String.class , example = "501032360024739840"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ExampleOrderServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.INSERT)
	public Result insert(ExampleOrderVO exampleOrderVO) {
		Result result=exampleOrderService.insert(exampleOrderVO,false);
		return result;
	}



	/**
	 * 删除销售订单
	*/
	@ApiOperation(value = "删除销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "501045698477686784")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ExampleOrderVOMeta.ID)
	@SentinelResource(value = ExampleOrderServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=exampleOrderService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除销售订单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ExampleOrderVOMeta.IDS)
	@SentinelResource(value = ExampleOrderServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=exampleOrderService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新销售订单
	*/
	@ApiOperation(value = "更新销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "501045698477686784"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=String.class , example = "501041838359052288"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.PRICE , value = "售价" , required = false , dataTypeClass=BigDecimal.class , example = "53.19"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.QUANTITY , value = "数量" , required = false , dataTypeClass=Integer.class , example = "93"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.AMOUNT , value = "金额" , required = false , dataTypeClass=BigDecimal.class , example = "4946.67"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SHOP_ID , value = "店铺ID" , required = false , dataTypeClass=String.class , example = "500998069018431488"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SALES_ID , value = "销售人员ID" , required = false , dataTypeClass=String.class , example = "501032360024739840"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ExampleOrderVOMeta.PAGE_INDEX , ExampleOrderVOMeta.PAGE_SIZE , ExampleOrderVOMeta.SEARCH_FIELD , ExampleOrderVOMeta.FUZZY_FIELD , ExampleOrderVOMeta.SEARCH_VALUE , ExampleOrderVOMeta.SORT_FIELD , ExampleOrderVOMeta.SORT_TYPE , ExampleOrderVOMeta.IDS } )
	@NotNull(name = ExampleOrderVOMeta.ID)
	@SentinelResource(value = ExampleOrderServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.UPDATE)
	public Result update(ExampleOrderVO exampleOrderVO) {
		Result result=exampleOrderService.update(exampleOrderVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存销售订单
	*/
	@ApiOperation(value = "保存销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "501045698477686784"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=String.class , example = "501041838359052288"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.PRICE , value = "售价" , required = false , dataTypeClass=BigDecimal.class , example = "53.19"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.QUANTITY , value = "数量" , required = false , dataTypeClass=Integer.class , example = "93"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.AMOUNT , value = "金额" , required = false , dataTypeClass=BigDecimal.class , example = "4946.67"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SHOP_ID , value = "店铺ID" , required = false , dataTypeClass=String.class , example = "500998069018431488"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SALES_ID , value = "销售人员ID" , required = false , dataTypeClass=String.class , example = "501032360024739840"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleOrderVOMeta.PAGE_INDEX , ExampleOrderVOMeta.PAGE_SIZE , ExampleOrderVOMeta.SEARCH_FIELD , ExampleOrderVOMeta.FUZZY_FIELD , ExampleOrderVOMeta.SEARCH_VALUE , ExampleOrderVOMeta.SORT_FIELD , ExampleOrderVOMeta.SORT_TYPE , ExampleOrderVOMeta.IDS } )
	@NotNull(name = ExampleOrderVOMeta.ID)
	@SentinelResource(value = ExampleOrderServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.SAVE)
	public Result save(ExampleOrderVO exampleOrderVO) {
		Result result=exampleOrderService.save(exampleOrderVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取销售订单
	*/
	@ApiOperation(value = "获取销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ExampleOrderVOMeta.ID)
	@SentinelResource(value = ExampleOrderServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.GET_BY_ID)
	public Result<ExampleOrder> getById(String id) {
		Result<ExampleOrder> result=new Result<>();
		ExampleOrder exampleOrder=exampleOrderService.getById(id);
		// join 关联的对象
		exampleOrderService.dao().fill(exampleOrder)
			.with(ExampleOrderMeta.PRODUCT)
			.with(ExampleOrderMeta.PRODUCT,ExampleProductMeta.BRAND)
			.with(ExampleOrderMeta.PRODUCT,ExampleProductMeta.BIG_CATALOG)
			.with(ExampleOrderMeta.SALES,EmployeeMeta.PERSON)
			.with(ExampleOrderMeta.SHOP)
			.execute();
		result.success(true).data(exampleOrder);
		return result;
	}


	/**
	 * 批量获取销售订单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取销售订单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ExampleOrderVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ExampleOrderVOMeta.IDS)
		@SentinelResource(value = ExampleOrderServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.GET_BY_IDS)
	public Result<List<ExampleOrder>> getByIds(List<String> ids) {
		Result<List<ExampleOrder>> result=new Result<>();
		List<ExampleOrder> list=exampleOrderService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询销售订单
	*/
	@ApiOperation(value = "查询销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "501045698477686784"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=String.class , example = "501041838359052288"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.PRICE , value = "售价" , required = false , dataTypeClass=BigDecimal.class , example = "53.19"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.QUANTITY , value = "数量" , required = false , dataTypeClass=Integer.class , example = "93"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.AMOUNT , value = "金额" , required = false , dataTypeClass=BigDecimal.class , example = "4946.67"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SHOP_ID , value = "店铺ID" , required = false , dataTypeClass=String.class , example = "500998069018431488"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SALES_ID , value = "销售人员ID" , required = false , dataTypeClass=String.class , example = "501032360024739840"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleOrderVOMeta.PAGE_INDEX , ExampleOrderVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ExampleOrderServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.QUERY_LIST)
	public Result<List<ExampleOrder>> queryList(ExampleOrderVO sample) {
		Result<List<ExampleOrder>> result=new Result<>();
		List<ExampleOrder> list=exampleOrderService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询销售订单
	*/
	@ApiOperation(value = "分页查询销售订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "501045698477686784"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.PRODUCT_ID , value = "商品ID" , required = false , dataTypeClass=String.class , example = "501041838359052288"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.PRICE , value = "售价" , required = false , dataTypeClass=BigDecimal.class , example = "53.19"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.QUANTITY , value = "数量" , required = false , dataTypeClass=Integer.class , example = "93"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.AMOUNT , value = "金额" , required = false , dataTypeClass=BigDecimal.class , example = "4946.67"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SHOP_ID , value = "店铺ID" , required = false , dataTypeClass=String.class , example = "500998069018431488"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SALES_ID , value = "销售人员ID" , required = false , dataTypeClass=String.class , example = "501032360024739840"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ExampleOrderServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ExampleOrder>> queryPagedList(ExampleOrderVO sample) {
		Result<PagedList<ExampleOrder>> result=new Result<>();
		PagedList<ExampleOrder> list=exampleOrderService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		exampleOrderService.dao().fill(list)
			.with(ExampleOrderMeta.PRODUCT)
			.with(ExampleOrderMeta.PRODUCT,ExampleProductMeta.BRAND)
			.with(ExampleOrderMeta.PRODUCT,ExampleProductMeta.BIG_CATALOG)
			.with(ExampleOrderMeta.SALES,EmployeeMeta.PERSON)
			.with(ExampleOrderMeta.SHOP)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ExampleOrderServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleOrderServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ExampleOrderVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=exampleOrderService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ExampleOrderServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleOrderServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=exampleOrderService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = ExampleOrderServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleOrderServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=exampleOrderService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}