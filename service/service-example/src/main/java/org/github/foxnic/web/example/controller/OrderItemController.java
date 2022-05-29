package org.github.foxnic.web.example.controller;


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


import org.github.foxnic.web.proxy.example.OrderItemServiceProxy;
import org.github.foxnic.web.domain.example.meta.OrderItemVOMeta;
import org.github.foxnic.web.domain.example.OrderItem;
import org.github.foxnic.web.domain.example.OrderItemVO;
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
import org.github.foxnic.web.domain.example.meta.OrderItemMeta;
import org.github.foxnic.web.domain.example.Goods;
import org.github.foxnic.web.domain.example.Address;
import org.github.foxnic.web.domain.example.Order;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.example.service.IOrderItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 *  接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-29 06:30:54
*/

@Api(tags = "example_order_item")
@ApiSort(0)
@RestController("ExampleOrderItemController")
public class OrderItemController extends SuperController {

	@Autowired
	private IOrderItemService orderItemService;


	/**
	 * 添加example_order_item
	*/
	@ApiOperation(value = "添加example_order_item")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = OrderItemVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderItemVOMeta.GOODS_ID , value = "商品ID" , required = false , dataTypeClass=String.class , example = "583020804682289152"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = OrderItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderItemServiceProxy.INSERT)
	public Result insert(OrderItemVO orderItemVO) {
		Result result=orderItemService.insert(orderItemVO,false);
		return result;
	}



	/**
	 * 删除example_order_item
	*/
	@ApiOperation(value = "删除example_order_item")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = OrderItemVOMeta.ID)
	@SentinelResource(value = OrderItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=orderItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除example_order_item <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除example_order_item")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = OrderItemVOMeta.IDS)
	@SentinelResource(value = OrderItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=orderItemService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新example_order_item
	*/
	@ApiOperation(value = "更新example_order_item")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = OrderItemVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderItemVOMeta.GOODS_ID , value = "商品ID" , required = false , dataTypeClass=String.class , example = "583020804682289152"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { OrderItemVOMeta.PAGE_INDEX , OrderItemVOMeta.PAGE_SIZE , OrderItemVOMeta.SEARCH_FIELD , OrderItemVOMeta.FUZZY_FIELD , OrderItemVOMeta.SEARCH_VALUE , OrderItemVOMeta.DIRTY_FIELDS , OrderItemVOMeta.SORT_FIELD , OrderItemVOMeta.SORT_TYPE , OrderItemVOMeta.IDS } )
	@NotNull(name = OrderItemVOMeta.ID)
	@SentinelResource(value = OrderItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderItemServiceProxy.UPDATE)
	public Result update(OrderItemVO orderItemVO) {
		Result result=orderItemService.update(orderItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存example_order_item
	*/
	@ApiOperation(value = "保存example_order_item")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = OrderItemVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderItemVOMeta.GOODS_ID , value = "商品ID" , required = false , dataTypeClass=String.class , example = "583020804682289152"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { OrderItemVOMeta.PAGE_INDEX , OrderItemVOMeta.PAGE_SIZE , OrderItemVOMeta.SEARCH_FIELD , OrderItemVOMeta.FUZZY_FIELD , OrderItemVOMeta.SEARCH_VALUE , OrderItemVOMeta.DIRTY_FIELDS , OrderItemVOMeta.SORT_FIELD , OrderItemVOMeta.SORT_TYPE , OrderItemVOMeta.IDS } )
	@NotNull(name = OrderItemVOMeta.ID)
	@SentinelResource(value = OrderItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderItemServiceProxy.SAVE)
	public Result save(OrderItemVO orderItemVO) {
		Result result=orderItemService.save(orderItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取example_order_item
	*/
	@ApiOperation(value = "获取example_order_item")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = OrderItemVOMeta.ID)
	@SentinelResource(value = OrderItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderItemServiceProxy.GET_BY_ID)
	public Result<OrderItem> getById(String id) {
		Result<OrderItem> result=new Result<>();
		OrderItem orderItem=orderItemService.getById(id);
		result.success(true).data(orderItem);
		return result;
	}


	/**
	 * 批量获取example_order_item <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取example_order_item")
		@ApiImplicitParams({
				@ApiImplicitParam(name = OrderItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = OrderItemVOMeta.IDS)
		@SentinelResource(value = OrderItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderItemServiceProxy.GET_BY_IDS)
	public Result<List<OrderItem>> getByIds(List<String> ids) {
		Result<List<OrderItem>> result=new Result<>();
		List<OrderItem> list=orderItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询example_order_item
	*/
	@ApiOperation(value = "查询example_order_item")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = OrderItemVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderItemVOMeta.GOODS_ID , value = "商品ID" , required = false , dataTypeClass=String.class , example = "583020804682289152"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { OrderItemVOMeta.PAGE_INDEX , OrderItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = OrderItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderItemServiceProxy.QUERY_LIST)
	public Result<List<OrderItem>> queryList(OrderItemVO sample) {
		Result<List<OrderItem>> result=new Result<>();
		List<OrderItem> list=orderItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询example_order_item
	*/
	@ApiOperation(value = "分页查询example_order_item")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = OrderItemVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderItemVOMeta.GOODS_ID , value = "商品ID" , required = false , dataTypeClass=String.class , example = "583020804682289152"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = OrderItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<OrderItem>> queryPagedList(OrderItemVO sample) {
		Result<PagedList<OrderItem>> result=new Result<>();
		PagedList<OrderItem> list=orderItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = OrderItemServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(OrderItemServiceProxy.EXPORT_EXCEL)
	public void exportExcel(OrderItemVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=orderItemService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = OrderItemServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(OrderItemServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=orderItemService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = OrderItemServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(OrderItemServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=orderItemService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}