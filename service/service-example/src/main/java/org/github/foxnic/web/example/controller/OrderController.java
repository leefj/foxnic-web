package org.github.foxnic.web.example.controller;


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
import org.github.foxnic.web.domain.example.Order;
import org.github.foxnic.web.domain.example.OrderVO;
import org.github.foxnic.web.domain.example.meta.OrderMeta;
import org.github.foxnic.web.domain.example.meta.OrderVOMeta;
import org.github.foxnic.web.example.service.IOrderService;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.example.OrderServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-17 22:22:18
*/

@Api(tags = "example_order")
@ApiSort(0)
@RestController("ExampleOrderController")
public class OrderController extends SuperController {

	@Autowired
	private IOrderService orderService;


	/**
	 * 添加example_order
	*/
	@ApiOperation(value = "添加example_order")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单编号" , required = false , dataTypeClass=String.class , example = "1123"),
		@ApiImplicitParam(name = OrderVOMeta.AMOUNT , value = "订单金额" , required = false , dataTypeClass=BigDecimal.class , example = "56.00"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_ID , value = "收件地址ID" , required = false , dataTypeClass=String.class , example = "583028267108274176"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = OrderServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.INSERT)
	public Result insert(OrderVO orderVO) {
		Result result=orderService.insert(orderVO,false);
		return result;
	}



	/**
	 * 删除example_order
	*/
	@ApiOperation(value = "删除example_order")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028022102200320")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = OrderVOMeta.ID)
	@SentinelResource(value = OrderServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		Boolean hasRefer = orderService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(hasRefer).mustInList("不允许删除当前记录",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=orderService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除example_order <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除example_order")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = OrderVOMeta.IDS)
	@SentinelResource(value = OrderServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, Boolean> hasRefersMap = orderService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, Boolean> e : hasRefersMap.entrySet()) {
			if (!e.getValue()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行");
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=orderService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=orderService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新example_order
	*/
	@ApiOperation(value = "更新example_order")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单编号" , required = false , dataTypeClass=String.class , example = "1123"),
		@ApiImplicitParam(name = OrderVOMeta.AMOUNT , value = "订单金额" , required = false , dataTypeClass=BigDecimal.class , example = "56.00"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_ID , value = "收件地址ID" , required = false , dataTypeClass=String.class , example = "583028267108274176"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { OrderVOMeta.PAGE_INDEX , OrderVOMeta.PAGE_SIZE , OrderVOMeta.SEARCH_FIELD , OrderVOMeta.FUZZY_FIELD , OrderVOMeta.SEARCH_VALUE , OrderVOMeta.DIRTY_FIELDS , OrderVOMeta.SORT_FIELD , OrderVOMeta.SORT_TYPE , OrderVOMeta.IDS } )
	@NotNull(name = OrderVOMeta.ID)
	@SentinelResource(value = OrderServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.UPDATE)
	public Result update(OrderVO orderVO) {
		Result result=orderService.update(orderVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存example_order
	*/
	@ApiOperation(value = "保存example_order")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单编号" , required = false , dataTypeClass=String.class , example = "1123"),
		@ApiImplicitParam(name = OrderVOMeta.AMOUNT , value = "订单金额" , required = false , dataTypeClass=BigDecimal.class , example = "56.00"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_ID , value = "收件地址ID" , required = false , dataTypeClass=String.class , example = "583028267108274176"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { OrderVOMeta.PAGE_INDEX , OrderVOMeta.PAGE_SIZE , OrderVOMeta.SEARCH_FIELD , OrderVOMeta.FUZZY_FIELD , OrderVOMeta.SEARCH_VALUE , OrderVOMeta.DIRTY_FIELDS , OrderVOMeta.SORT_FIELD , OrderVOMeta.SORT_TYPE , OrderVOMeta.IDS } )
	@NotNull(name = OrderVOMeta.ID)
	@SentinelResource(value = OrderServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.SAVE)
	public Result save(OrderVO orderVO) {
		Result result=orderService.save(orderVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取example_order
	*/
	@ApiOperation(value = "获取example_order")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = OrderVOMeta.ID)
	@SentinelResource(value = OrderServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.GET_BY_ID)
	public Result<Order> getById(String id) {
		Result<Order> result=new Result<>();
		Order order=orderService.getById(id);
		// join 关联的对象
		orderService.dao().fill(order)
			.with(OrderMeta.ADDRESS)
			.with(OrderMeta.GOODS_LIST)
			.execute();
		result.success(true).data(order);
		return result;
	}


	/**
	 * 批量获取example_order <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取example_order")
		@ApiImplicitParams({
				@ApiImplicitParam(name = OrderVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = OrderVOMeta.IDS)
		@SentinelResource(value = OrderServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.GET_BY_IDS)
	public Result<List<Order>> getByIds(List<String> ids) {
		Result<List<Order>> result=new Result<>();
		List<Order> list=orderService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询example_order
	*/
	@ApiOperation(value = "查询example_order")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单编号" , required = false , dataTypeClass=String.class , example = "1123"),
		@ApiImplicitParam(name = OrderVOMeta.AMOUNT , value = "订单金额" , required = false , dataTypeClass=BigDecimal.class , example = "56.00"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_ID , value = "收件地址ID" , required = false , dataTypeClass=String.class , example = "583028267108274176"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { OrderVOMeta.PAGE_INDEX , OrderVOMeta.PAGE_SIZE } )
	@SentinelResource(value = OrderServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.QUERY_LIST)
	public Result<List<Order>> queryList(OrderVO sample) {
		Result<List<Order>> result=new Result<>();
		List<Order> list=orderService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询example_order
	*/
	@ApiOperation(value = "分页查询example_order")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028022102200320"),
		@ApiImplicitParam(name = OrderVOMeta.ORDER_NO , value = "订单编号" , required = false , dataTypeClass=String.class , example = "1123"),
		@ApiImplicitParam(name = OrderVOMeta.AMOUNT , value = "订单金额" , required = false , dataTypeClass=BigDecimal.class , example = "56.00"),
		@ApiImplicitParam(name = OrderVOMeta.ADDRESS_ID , value = "收件地址ID" , required = false , dataTypeClass=String.class , example = "583028267108274176"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = OrderServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrderServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Order>> queryPagedList(OrderVO sample) {
		Result<PagedList<Order>> result=new Result<>();
		PagedList<Order> list=orderService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		orderService.dao().fill(list)
			.with(OrderMeta.ADDRESS)
			.with(OrderMeta.GOODS_LIST)
			.execute();
		result.success(true).data(list);
		return result;
	}





	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = OrderServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(OrderServiceProxy.EXPORT_EXCEL)
	public void exportExcel(OrderVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=orderService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = OrderServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(OrderServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=orderService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = OrderServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(OrderServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=orderService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}