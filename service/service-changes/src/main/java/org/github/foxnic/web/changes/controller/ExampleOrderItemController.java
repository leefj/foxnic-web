package org.github.foxnic.web.changes.controller;

 
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


import org.github.foxnic.web.proxy.changes.ExampleOrderItemServiceProxy;
import org.github.foxnic.web.domain.changes.meta.ExampleOrderItemVOMeta;
import org.github.foxnic.web.domain.changes.ExampleOrderItem;
import org.github.foxnic.web.domain.changes.ExampleOrderItemVO;
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
import org.github.foxnic.web.domain.changes.meta.ExampleOrderItemMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.changes.service.IExampleOrderItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 变更示例订单明细表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-30 09:31:31
*/

@Api(tags = "变更示例订单明细")
@ApiSort(0)
@RestController("ChsExampleOrderItemController")
public class ExampleOrderItemController extends SuperController {

	@Autowired
	private IExampleOrderItemService exampleOrderItemService;

	
	/**
	 * 添加变更示例订单明细
	*/
	@ApiOperation(value = "添加变更示例订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.PRODUCT_NAME , value = "商品名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.SKU_NAME , value = "规格名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.QUANTITY , value = "数量" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ExampleOrderItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderItemServiceProxy.INSERT)
	public Result insert(ExampleOrderItemVO exampleOrderItemVO) {
		Result result=exampleOrderItemService.insert(exampleOrderItemVO);
		return result;
	}

	
	/**
	 * 删除变更示例订单明细
	*/
	@ApiOperation(value = "删除变更示例订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ExampleOrderItemVOMeta.ID)
	@SentinelResource(value = ExampleOrderItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=exampleOrderItemService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除变更示例订单明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除变更示例订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ExampleOrderItemVOMeta.IDS)
	@SentinelResource(value = ExampleOrderItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=exampleOrderItemService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新变更示例订单明细
	*/
	@ApiOperation(value = "更新变更示例订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.PRODUCT_NAME , value = "商品名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.SKU_NAME , value = "规格名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.QUANTITY , value = "数量" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ExampleOrderItemVOMeta.PAGE_INDEX , ExampleOrderItemVOMeta.PAGE_SIZE , ExampleOrderItemVOMeta.SEARCH_FIELD , ExampleOrderItemVOMeta.FUZZY_FIELD , ExampleOrderItemVOMeta.SEARCH_VALUE , ExampleOrderItemVOMeta.SORT_FIELD , ExampleOrderItemVOMeta.SORT_TYPE , ExampleOrderItemVOMeta.IDS } ) 
	@NotNull(name = ExampleOrderItemVOMeta.ID)
	@SentinelResource(value = ExampleOrderItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderItemServiceProxy.UPDATE)
	public Result update(ExampleOrderItemVO exampleOrderItemVO) {
		Result result=exampleOrderItemService.update(exampleOrderItemVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存变更示例订单明细
	*/
	@ApiOperation(value = "保存变更示例订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.PRODUCT_NAME , value = "商品名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.SKU_NAME , value = "规格名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.QUANTITY , value = "数量" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleOrderItemVOMeta.PAGE_INDEX , ExampleOrderItemVOMeta.PAGE_SIZE , ExampleOrderItemVOMeta.SEARCH_FIELD , ExampleOrderItemVOMeta.FUZZY_FIELD , ExampleOrderItemVOMeta.SEARCH_VALUE , ExampleOrderItemVOMeta.SORT_FIELD , ExampleOrderItemVOMeta.SORT_TYPE , ExampleOrderItemVOMeta.IDS } )
	@NotNull(name = ExampleOrderItemVOMeta.ID)
	@SentinelResource(value = ExampleOrderItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderItemServiceProxy.SAVE)
	public Result save(ExampleOrderItemVO exampleOrderItemVO) {
		Result result=exampleOrderItemService.save(exampleOrderItemVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取变更示例订单明细
	*/
	@ApiOperation(value = "获取变更示例订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ExampleOrderItemVOMeta.ID)
	@SentinelResource(value = ExampleOrderItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderItemServiceProxy.GET_BY_ID)
	public Result<ExampleOrderItem> getById(String id) {
		Result<ExampleOrderItem> result=new Result<>();
		ExampleOrderItem exampleOrderItem=exampleOrderItemService.getById(id);
		result.success(true).data(exampleOrderItem);
		return result;
	}


	/**
	 * 批量获取变更示例订单明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取变更示例订单明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ExampleOrderItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ExampleOrderItemVOMeta.IDS)
		@SentinelResource(value = ExampleOrderItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderItemServiceProxy.GET_BY_IDS)
	public Result<List<ExampleOrderItem>> getByIds(List<String> ids) {
		Result<List<ExampleOrderItem>> result=new Result<>();
		List<ExampleOrderItem> list=exampleOrderItemService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询变更示例订单明细
	*/
	@ApiOperation(value = "查询变更示例订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.PRODUCT_NAME , value = "商品名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.SKU_NAME , value = "规格名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.QUANTITY , value = "数量" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleOrderItemVOMeta.PAGE_INDEX , ExampleOrderItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ExampleOrderItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderItemServiceProxy.QUERY_LIST)
	public Result<List<ExampleOrderItem>> queryList(ExampleOrderItemVO sample) {
		Result<List<ExampleOrderItem>> result=new Result<>();
		List<ExampleOrderItem> list=exampleOrderItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询变更示例订单明细
	*/
	@ApiOperation(value = "分页查询变更示例订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.PRODUCT_NAME , value = "商品名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.SKU_NAME , value = "规格名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.PRICE , value = "单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ExampleOrderItemVOMeta.QUANTITY , value = "数量" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ExampleOrderItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ExampleOrderItem>> queryPagedList(ExampleOrderItemVO sample) {
		Result<PagedList<ExampleOrderItem>> result=new Result<>();
		PagedList<ExampleOrderItem> list=exampleOrderItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ExampleOrderItemServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleOrderItemServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ExampleOrderItemVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=exampleOrderItemService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ExampleOrderItemServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleOrderItemServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=exampleOrderItemService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ExampleOrderItemServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleOrderItemServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=exampleOrderItemService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}