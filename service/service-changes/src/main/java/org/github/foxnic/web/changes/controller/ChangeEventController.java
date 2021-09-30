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


import org.github.foxnic.web.proxy.changes.ChangeEventServiceProxy;
import org.github.foxnic.web.domain.changes.meta.ChangeEventVOMeta;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.domain.changes.ChangeEventVO;
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
import org.github.foxnic.web.domain.changes.meta.ChangeEventMeta;
import org.github.foxnic.web.domain.changes.ChangeDefinition;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.changes.service.IChangeEventService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 变更事件表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-01 02:53:28
*/

@Api(tags = "变更事件")
@ApiSort(0)
@RestController("ChsChangeEventController")
public class ChangeEventController extends SuperController {

	@Autowired
	private IChangeEventService changeEventService;

	
	/**
	 * 添加变更事件
	*/
	@ApiOperation(value = "添加变更事件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeEventVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495885237524365312"),
		@ApiImplicitParam(name = ChangeEventVOMeta.INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class , example = "495885237344010240"),
		@ApiImplicitParam(name = ChangeEventVOMeta.EVENT_TYPE , value = "实体类名" , required = false , dataTypeClass=String.class , example = "create_success"),
		@ApiImplicitParam(name = ChangeEventVOMeta.NOTIFY_TIME , value = "通知发送时间" , required = false , dataTypeClass=Timestamp.class , example = "2021-09-30 09:10:53.727"),
		@ApiImplicitParam(name = ChangeEventVOMeta.NOTIFY_DATA , value = "数据" , required = false , dataTypeClass=String.class , example = "{\"definition\":{\"code\":\"EXAMPLE_ORDER_CHANGE\",\"createBy\":\"110588348101165911\",\"createTime\":1632816520000,\"deleted\":0,\"handler\":\"org.github.foxnic.web.changes.service.handler.ExampleOrderChangesHandler\",\"id\":\"495265596145934336\",\"name\":\"订单变更(测试)\",\"valid\":1,\"version\":1},\"eventType\":\"create_success\",\"eventTypeEnum\":\"create_success\",\"instance\":{\"dataIdAfter\":\"495885236844888064\",\"dataTable\":\"chs_example_order\",\"dataType\":\"org.github.foxnic.web.domain.changes.ExampleOrder\",\"definitionId\":\"495265596145934336\",\"id\":\"495885237344010240\",\"startTime\":1632964253607,\"status\":\"changing\",\"statusEnum\":\"changing\",\"type\":\"create\",\"typeEnum\":\"create\"},\"instanceId\":\"495885237344010240\",\"notifyTime\":1632964253727}"),
		@ApiImplicitParam(name = ChangeEventVOMeta.RESPONSE_DATA , value = "相应的数据" , required = false , dataTypeClass=String.class , example = "{\"code\":\"00\",\"message\":\"操作成功\",\"success\":true}"),
		@ApiImplicitParam(name = ChangeEventVOMeta.RESPONSE_TIME , value = "回调接收时间" , required = false , dataTypeClass=Timestamp.class , example = "2021-09-30 09:10:53.777"),
		@ApiImplicitParam(name = ChangeEventVOMeta.APPROVER_ID , value = "审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.APPROVER_NAME , value = "审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_ID , value = "下一个审批节点ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_APPROVER_IDS , value = "下一个审批节点审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.SUCCESS , value = "是否成功" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ChangeEventServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeEventServiceProxy.INSERT)
	public Result insert(ChangeEventVO changeEventVO) {
		Result result=changeEventService.insert(changeEventVO);
		return result;
	}

	
	/**
	 * 删除变更事件
	*/
	@ApiOperation(value = "删除变更事件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeEventVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495885237524365312")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ChangeEventVOMeta.ID)
	@SentinelResource(value = ChangeEventServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeEventServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=changeEventService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除变更事件 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除变更事件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeEventVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ChangeEventVOMeta.IDS)
	@SentinelResource(value = ChangeEventServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeEventServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=changeEventService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新变更事件
	*/
	@ApiOperation(value = "更新变更事件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeEventVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495885237524365312"),
		@ApiImplicitParam(name = ChangeEventVOMeta.INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class , example = "495885237344010240"),
		@ApiImplicitParam(name = ChangeEventVOMeta.EVENT_TYPE , value = "实体类名" , required = false , dataTypeClass=String.class , example = "create_success"),
		@ApiImplicitParam(name = ChangeEventVOMeta.NOTIFY_TIME , value = "通知发送时间" , required = false , dataTypeClass=Timestamp.class , example = "2021-09-30 09:10:53.727"),
		@ApiImplicitParam(name = ChangeEventVOMeta.NOTIFY_DATA , value = "数据" , required = false , dataTypeClass=String.class , example = "{\"definition\":{\"code\":\"EXAMPLE_ORDER_CHANGE\",\"createBy\":\"110588348101165911\",\"createTime\":1632816520000,\"deleted\":0,\"handler\":\"org.github.foxnic.web.changes.service.handler.ExampleOrderChangesHandler\",\"id\":\"495265596145934336\",\"name\":\"订单变更(测试)\",\"valid\":1,\"version\":1},\"eventType\":\"create_success\",\"eventTypeEnum\":\"create_success\",\"instance\":{\"dataIdAfter\":\"495885236844888064\",\"dataTable\":\"chs_example_order\",\"dataType\":\"org.github.foxnic.web.domain.changes.ExampleOrder\",\"definitionId\":\"495265596145934336\",\"id\":\"495885237344010240\",\"startTime\":1632964253607,\"status\":\"changing\",\"statusEnum\":\"changing\",\"type\":\"create\",\"typeEnum\":\"create\"},\"instanceId\":\"495885237344010240\",\"notifyTime\":1632964253727}"),
		@ApiImplicitParam(name = ChangeEventVOMeta.RESPONSE_DATA , value = "相应的数据" , required = false , dataTypeClass=String.class , example = "{\"code\":\"00\",\"message\":\"操作成功\",\"success\":true}"),
		@ApiImplicitParam(name = ChangeEventVOMeta.RESPONSE_TIME , value = "回调接收时间" , required = false , dataTypeClass=Timestamp.class , example = "2021-09-30 09:10:53.777"),
		@ApiImplicitParam(name = ChangeEventVOMeta.APPROVER_ID , value = "审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.APPROVER_NAME , value = "审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_ID , value = "下一个审批节点ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_APPROVER_IDS , value = "下一个审批节点审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.SUCCESS , value = "是否成功" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ChangeEventVOMeta.PAGE_INDEX , ChangeEventVOMeta.PAGE_SIZE , ChangeEventVOMeta.SEARCH_FIELD , ChangeEventVOMeta.FUZZY_FIELD , ChangeEventVOMeta.SEARCH_VALUE , ChangeEventVOMeta.SORT_FIELD , ChangeEventVOMeta.SORT_TYPE , ChangeEventVOMeta.IDS } ) 
	@NotNull(name = ChangeEventVOMeta.ID)
	@SentinelResource(value = ChangeEventServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeEventServiceProxy.UPDATE)
	public Result update(ChangeEventVO changeEventVO) {
		Result result=changeEventService.update(changeEventVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存变更事件
	*/
	@ApiOperation(value = "保存变更事件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeEventVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495885237524365312"),
		@ApiImplicitParam(name = ChangeEventVOMeta.INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class , example = "495885237344010240"),
		@ApiImplicitParam(name = ChangeEventVOMeta.EVENT_TYPE , value = "实体类名" , required = false , dataTypeClass=String.class , example = "create_success"),
		@ApiImplicitParam(name = ChangeEventVOMeta.NOTIFY_TIME , value = "通知发送时间" , required = false , dataTypeClass=Timestamp.class , example = "2021-09-30 09:10:53.727"),
		@ApiImplicitParam(name = ChangeEventVOMeta.NOTIFY_DATA , value = "数据" , required = false , dataTypeClass=String.class , example = "{\"definition\":{\"code\":\"EXAMPLE_ORDER_CHANGE\",\"createBy\":\"110588348101165911\",\"createTime\":1632816520000,\"deleted\":0,\"handler\":\"org.github.foxnic.web.changes.service.handler.ExampleOrderChangesHandler\",\"id\":\"495265596145934336\",\"name\":\"订单变更(测试)\",\"valid\":1,\"version\":1},\"eventType\":\"create_success\",\"eventTypeEnum\":\"create_success\",\"instance\":{\"dataIdAfter\":\"495885236844888064\",\"dataTable\":\"chs_example_order\",\"dataType\":\"org.github.foxnic.web.domain.changes.ExampleOrder\",\"definitionId\":\"495265596145934336\",\"id\":\"495885237344010240\",\"startTime\":1632964253607,\"status\":\"changing\",\"statusEnum\":\"changing\",\"type\":\"create\",\"typeEnum\":\"create\"},\"instanceId\":\"495885237344010240\",\"notifyTime\":1632964253727}"),
		@ApiImplicitParam(name = ChangeEventVOMeta.RESPONSE_DATA , value = "相应的数据" , required = false , dataTypeClass=String.class , example = "{\"code\":\"00\",\"message\":\"操作成功\",\"success\":true}"),
		@ApiImplicitParam(name = ChangeEventVOMeta.RESPONSE_TIME , value = "回调接收时间" , required = false , dataTypeClass=Timestamp.class , example = "2021-09-30 09:10:53.777"),
		@ApiImplicitParam(name = ChangeEventVOMeta.APPROVER_ID , value = "审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.APPROVER_NAME , value = "审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_ID , value = "下一个审批节点ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_APPROVER_IDS , value = "下一个审批节点审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.SUCCESS , value = "是否成功" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ChangeEventVOMeta.PAGE_INDEX , ChangeEventVOMeta.PAGE_SIZE , ChangeEventVOMeta.SEARCH_FIELD , ChangeEventVOMeta.FUZZY_FIELD , ChangeEventVOMeta.SEARCH_VALUE , ChangeEventVOMeta.SORT_FIELD , ChangeEventVOMeta.SORT_TYPE , ChangeEventVOMeta.IDS } )
	@NotNull(name = ChangeEventVOMeta.ID)
	@SentinelResource(value = ChangeEventServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeEventServiceProxy.SAVE)
	public Result save(ChangeEventVO changeEventVO) {
		Result result=changeEventService.save(changeEventVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取变更事件
	*/
	@ApiOperation(value = "获取变更事件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeEventVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ChangeEventVOMeta.ID)
	@SentinelResource(value = ChangeEventServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeEventServiceProxy.GET_BY_ID)
	public Result<ChangeEvent> getById(String id) {
		Result<ChangeEvent> result=new Result<>();
		ChangeEvent changeEvent=changeEventService.getById(id);
		result.success(true).data(changeEvent);
		return result;
	}


	/**
	 * 批量获取变更事件 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取变更事件")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ChangeEventVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ChangeEventVOMeta.IDS)
		@SentinelResource(value = ChangeEventServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeEventServiceProxy.GET_BY_IDS)
	public Result<List<ChangeEvent>> getByIds(List<String> ids) {
		Result<List<ChangeEvent>> result=new Result<>();
		List<ChangeEvent> list=changeEventService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询变更事件
	*/
	@ApiOperation(value = "查询变更事件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeEventVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495885237524365312"),
		@ApiImplicitParam(name = ChangeEventVOMeta.INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class , example = "495885237344010240"),
		@ApiImplicitParam(name = ChangeEventVOMeta.EVENT_TYPE , value = "实体类名" , required = false , dataTypeClass=String.class , example = "create_success"),
		@ApiImplicitParam(name = ChangeEventVOMeta.NOTIFY_TIME , value = "通知发送时间" , required = false , dataTypeClass=Timestamp.class , example = "2021-09-30 09:10:53.727"),
		@ApiImplicitParam(name = ChangeEventVOMeta.NOTIFY_DATA , value = "数据" , required = false , dataTypeClass=String.class , example = "{\"definition\":{\"code\":\"EXAMPLE_ORDER_CHANGE\",\"createBy\":\"110588348101165911\",\"createTime\":1632816520000,\"deleted\":0,\"handler\":\"org.github.foxnic.web.changes.service.handler.ExampleOrderChangesHandler\",\"id\":\"495265596145934336\",\"name\":\"订单变更(测试)\",\"valid\":1,\"version\":1},\"eventType\":\"create_success\",\"eventTypeEnum\":\"create_success\",\"instance\":{\"dataIdAfter\":\"495885236844888064\",\"dataTable\":\"chs_example_order\",\"dataType\":\"org.github.foxnic.web.domain.changes.ExampleOrder\",\"definitionId\":\"495265596145934336\",\"id\":\"495885237344010240\",\"startTime\":1632964253607,\"status\":\"changing\",\"statusEnum\":\"changing\",\"type\":\"create\",\"typeEnum\":\"create\"},\"instanceId\":\"495885237344010240\",\"notifyTime\":1632964253727}"),
		@ApiImplicitParam(name = ChangeEventVOMeta.RESPONSE_DATA , value = "相应的数据" , required = false , dataTypeClass=String.class , example = "{\"code\":\"00\",\"message\":\"操作成功\",\"success\":true}"),
		@ApiImplicitParam(name = ChangeEventVOMeta.RESPONSE_TIME , value = "回调接收时间" , required = false , dataTypeClass=Timestamp.class , example = "2021-09-30 09:10:53.777"),
		@ApiImplicitParam(name = ChangeEventVOMeta.APPROVER_ID , value = "审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.APPROVER_NAME , value = "审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_ID , value = "下一个审批节点ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_APPROVER_IDS , value = "下一个审批节点审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.SUCCESS , value = "是否成功" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ChangeEventVOMeta.PAGE_INDEX , ChangeEventVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ChangeEventServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeEventServiceProxy.QUERY_LIST)
	public Result<List<ChangeEvent>> queryList(ChangeEventVO sample) {
		Result<List<ChangeEvent>> result=new Result<>();
		List<ChangeEvent> list=changeEventService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询变更事件
	*/
	@ApiOperation(value = "分页查询变更事件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeEventVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495885237524365312"),
		@ApiImplicitParam(name = ChangeEventVOMeta.INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class , example = "495885237344010240"),
		@ApiImplicitParam(name = ChangeEventVOMeta.EVENT_TYPE , value = "实体类名" , required = false , dataTypeClass=String.class , example = "create_success"),
		@ApiImplicitParam(name = ChangeEventVOMeta.NOTIFY_TIME , value = "通知发送时间" , required = false , dataTypeClass=Timestamp.class , example = "2021-09-30 09:10:53.727"),
		@ApiImplicitParam(name = ChangeEventVOMeta.NOTIFY_DATA , value = "数据" , required = false , dataTypeClass=String.class , example = "{\"definition\":{\"code\":\"EXAMPLE_ORDER_CHANGE\",\"createBy\":\"110588348101165911\",\"createTime\":1632816520000,\"deleted\":0,\"handler\":\"org.github.foxnic.web.changes.service.handler.ExampleOrderChangesHandler\",\"id\":\"495265596145934336\",\"name\":\"订单变更(测试)\",\"valid\":1,\"version\":1},\"eventType\":\"create_success\",\"eventTypeEnum\":\"create_success\",\"instance\":{\"dataIdAfter\":\"495885236844888064\",\"dataTable\":\"chs_example_order\",\"dataType\":\"org.github.foxnic.web.domain.changes.ExampleOrder\",\"definitionId\":\"495265596145934336\",\"id\":\"495885237344010240\",\"startTime\":1632964253607,\"status\":\"changing\",\"statusEnum\":\"changing\",\"type\":\"create\",\"typeEnum\":\"create\"},\"instanceId\":\"495885237344010240\",\"notifyTime\":1632964253727}"),
		@ApiImplicitParam(name = ChangeEventVOMeta.RESPONSE_DATA , value = "相应的数据" , required = false , dataTypeClass=String.class , example = "{\"code\":\"00\",\"message\":\"操作成功\",\"success\":true}"),
		@ApiImplicitParam(name = ChangeEventVOMeta.RESPONSE_TIME , value = "回调接收时间" , required = false , dataTypeClass=Timestamp.class , example = "2021-09-30 09:10:53.777"),
		@ApiImplicitParam(name = ChangeEventVOMeta.APPROVER_ID , value = "审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.APPROVER_NAME , value = "审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_ID , value = "下一个审批节点ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_APPROVER_IDS , value = "下一个审批节点审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.NEXT_NODE_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeEventVOMeta.SUCCESS , value = "是否成功" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ChangeEventServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeEventServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ChangeEvent>> queryPagedList(ChangeEventVO sample) {
		Result<PagedList<ChangeEvent>> result=new Result<>();
		PagedList<ChangeEvent> list=changeEventService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ChangeEventServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeEventServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ChangeEventVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=changeEventService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ChangeEventServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeEventServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=changeEventService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ChangeEventServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeEventServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=changeEventService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}