package org.github.foxnic.web.changes.controller;


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
import org.github.foxnic.web.changes.service.IExampleOrderService;
import org.github.foxnic.web.domain.changes.ExampleOrder;
import org.github.foxnic.web.domain.changes.ExampleOrderVO;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
import org.github.foxnic.web.domain.changes.ProcessStartVO;
import org.github.foxnic.web.domain.changes.meta.ExampleOrderMeta;
import org.github.foxnic.web.domain.changes.meta.ExampleOrderVOMeta;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.changes.ExampleOrderServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 变更示例订单表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-30 11:04:38
 * @version
*/

@Api(tags = "变更示例订单")
@ApiSort(0)
@RestController("ChsExampleOrderController")
public class ExampleOrderController extends SuperController {

	@Autowired
	private IExampleOrderService exampleOrderService;


	/**
	 * 添加变更示例订单
	*/
	@ApiOperation(value = "添加变更示例订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495898323287277568"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "订单-1"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CODE , value = "订单编号" , required = false , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.ORDER_TIME , value = "下单时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ExampleOrderVOMeta.BUYER_ID , value = "买家ID" , required = false , dataTypeClass=String.class , example = "491961971495665664"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "宁波"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class , example = "1110.0000"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class , example = "create"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class , example = "changing"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SOURCE_ID , value = "来源ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ExampleOrderServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.INSERT)
	public Result insert(ExampleOrderVO exampleOrderVO) {
		Result result=exampleOrderService.insert(exampleOrderVO);
		return result;
	}


	/**
	 * 删除变更示例订单
	*/
	@ApiOperation(value = "删除变更示例订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495898323287277568")
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
	 * 批量删除变更示例订单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除变更示例订单")
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
	 * 更新变更示例订单
	*/
	@ApiOperation(value = "更新变更示例订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495898323287277568"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "订单-1"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CODE , value = "订单编号" , required = false , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.ORDER_TIME , value = "下单时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ExampleOrderVOMeta.BUYER_ID , value = "买家ID" , required = false , dataTypeClass=String.class , example = "491961971495665664"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "宁波"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class , example = "1110.0000"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class , example = "create"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class , example = "changing"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SOURCE_ID , value = "来源ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ExampleOrderVOMeta.PAGE_INDEX , ExampleOrderVOMeta.PAGE_SIZE , ExampleOrderVOMeta.SEARCH_FIELD , ExampleOrderVOMeta.FUZZY_FIELD , ExampleOrderVOMeta.SEARCH_VALUE , ExampleOrderVOMeta.SORT_FIELD , ExampleOrderVOMeta.SORT_TYPE , ExampleOrderVOMeta.IDS } )
	@NotNull(name = ExampleOrderVOMeta.ID)
	@SentinelResource(value = ExampleOrderServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.UPDATE)
	public Result update(ExampleOrderVO exampleOrderVO) {
		Result result=exampleOrderService.update(exampleOrderVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存变更示例订单
	*/
	@ApiOperation(value = "保存变更示例订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495898323287277568"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "订单-1"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CODE , value = "订单编号" , required = false , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.ORDER_TIME , value = "下单时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ExampleOrderVOMeta.BUYER_ID , value = "买家ID" , required = false , dataTypeClass=String.class , example = "491961971495665664"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "宁波"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class , example = "1110.0000"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class , example = "create"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class , example = "changing"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SOURCE_ID , value = "来源ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleOrderVOMeta.PAGE_INDEX , ExampleOrderVOMeta.PAGE_SIZE , ExampleOrderVOMeta.SEARCH_FIELD , ExampleOrderVOMeta.FUZZY_FIELD , ExampleOrderVOMeta.SEARCH_VALUE , ExampleOrderVOMeta.SORT_FIELD , ExampleOrderVOMeta.SORT_TYPE , ExampleOrderVOMeta.IDS } )
	@NotNull(name = ExampleOrderVOMeta.ID)
	@SentinelResource(value = ExampleOrderServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.SAVE)
	public Result save(ExampleOrderVO exampleOrderVO) {
		Result result=exampleOrderService.save(exampleOrderVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取变更示例订单
	*/
	@ApiOperation(value = "获取变更示例订单")
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
		result.success(true).data(exampleOrder);
		return result;
	}


	/**
	 * 批量获取变更示例订单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取变更示例订单")
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
	 * 开始审批进入变更流程 <br>
	 */
	@ApiOperation(value = "批量获取变更示例订单")
	@ApiImplicitParams({
			@ApiImplicitParam(name = ExampleOrderVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3)
	@NotNull(name = ExampleOrderVOMeta.IDS)
	@SentinelResource(value = ExampleOrderServiceProxy.START_PROCESS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.START_PROCESS)
	public Result startProcess(ProcessStartVO startVO) {
		if(startVO.getBillIds()==null || startVO.getBillIds().isEmpty()) {
			return ErrorDesc.failure().message("缺少审批单据");
		}
		return exampleOrderService.startProcess(startVO);
	}

	/**
	 * 开始审批进入变更流程 <br>
	 */
	@ApiOperation(value = "批量获取变更示例订单")
	@ApiImplicitParams({
			@ApiImplicitParam(name = ExampleOrderVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3)
	@NotNull(name = ExampleOrderVOMeta.IDS)
	@SentinelResource(value = ExampleOrderServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO) {
		return exampleOrderService.approve(approveVO);
	}

	/**
	 * 查询变更示例订单
	*/
	@ApiOperation(value = "查询变更示例订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495898323287277568"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "订单-1"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CODE , value = "订单编号" , required = false , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.ORDER_TIME , value = "下单时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ExampleOrderVOMeta.BUYER_ID , value = "买家ID" , required = false , dataTypeClass=String.class , example = "491961971495665664"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "宁波"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class , example = "1110.0000"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class , example = "create"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class , example = "changing"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SOURCE_ID , value = "来源ID" , required = false , dataTypeClass=String.class),
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
	 * 分页查询变更示例订单
	*/
	@ApiOperation(value = "分页查询变更示例订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495898323287277568"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "订单-1"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CODE , value = "订单编号" , required = false , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.ORDER_TIME , value = "下单时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ExampleOrderVOMeta.BUYER_ID , value = "买家ID" , required = false , dataTypeClass=String.class , example = "491961971495665664"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "宁波"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class , example = "1110.0000"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class , example = "create"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class , example = "changing"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ExampleOrderVOMeta.SOURCE_ID , value = "来源ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ExampleOrderServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleOrderServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ExampleOrder>> queryPagedList(ExampleOrderVO sample) {
		Result<PagedList<ExampleOrder>> result=new Result<>();
		PagedList<ExampleOrder> list=exampleOrderService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		exampleOrderService.dao().fill(list).with(ExampleOrderMeta.BUYER_EMPLOYEE, EmployeeMeta.PERSON).execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ExampleOrderServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleOrderServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ExampleOrderVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=exampleOrderService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ExampleOrderServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleOrderServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=exampleOrderService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
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
