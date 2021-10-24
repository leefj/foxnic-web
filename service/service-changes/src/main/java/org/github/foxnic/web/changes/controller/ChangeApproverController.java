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


import org.github.foxnic.web.proxy.changes.ChangeApproverServiceProxy;
import org.github.foxnic.web.domain.changes.meta.ChangeApproverVOMeta;
import org.github.foxnic.web.domain.changes.ChangeApprover;
import org.github.foxnic.web.domain.changes.ChangeApproverVO;
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
import org.github.foxnic.web.domain.changes.meta.ChangeApproverMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.changes.service.IChangeApproverService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 变更单据关系表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-23 14:31:43
*/

@Api(tags = "变更单据关系")
@ApiSort(0)
@RestController("ChsChangeApproverController")
public class ChangeApproverController extends SuperController {

	@Autowired
	private IChangeApproverService changeApproverService;


	/**
	 * 添加变更单据关系
	*/
	@ApiOperation(value = "添加变更单据关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeApproverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "496781195195977728"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeApproverVOMeta.INSTANCE_ID , value = "变更实例ID" , required = false , dataTypeClass=String.class , example = "496781195003039744"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.APPROVER_ID , value = "审批人ID" , required = false , dataTypeClass=String.class , example = "496781163940024321"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.APPROVER_TYPE , value = "审批人类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeApproverVOMeta.NODE_ID , value = "节点ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ChangeApproverServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeApproverServiceProxy.INSERT)
	public Result insert(ChangeApproverVO changeApproverVO) {
		Result result=changeApproverService.insert(changeApproverVO);
		return result;
	}



	/**
	 * 删除变更单据关系
	*/
	@ApiOperation(value = "删除变更单据关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeApproverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "496781195195977728")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ChangeApproverVOMeta.ID)
	@SentinelResource(value = ChangeApproverServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeApproverServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=changeApproverService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除变更单据关系 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除变更单据关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeApproverVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ChangeApproverVOMeta.IDS)
	@SentinelResource(value = ChangeApproverServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeApproverServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=changeApproverService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新变更单据关系
	*/
	@ApiOperation(value = "更新变更单据关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeApproverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "496781195195977728"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeApproverVOMeta.INSTANCE_ID , value = "变更实例ID" , required = false , dataTypeClass=String.class , example = "496781195003039744"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.APPROVER_ID , value = "审批人ID" , required = false , dataTypeClass=String.class , example = "496781163940024321"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.APPROVER_TYPE , value = "审批人类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeApproverVOMeta.NODE_ID , value = "节点ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ChangeApproverVOMeta.PAGE_INDEX , ChangeApproverVOMeta.PAGE_SIZE , ChangeApproverVOMeta.SEARCH_FIELD , ChangeApproverVOMeta.FUZZY_FIELD , ChangeApproverVOMeta.SEARCH_VALUE , ChangeApproverVOMeta.SORT_FIELD , ChangeApproverVOMeta.SORT_TYPE , ChangeApproverVOMeta.IDS } )
	@NotNull(name = ChangeApproverVOMeta.ID)
	@SentinelResource(value = ChangeApproverServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeApproverServiceProxy.UPDATE)
	public Result update(ChangeApproverVO changeApproverVO) {
		Result result=changeApproverService.update(changeApproverVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存变更单据关系
	*/
	@ApiOperation(value = "保存变更单据关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeApproverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "496781195195977728"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeApproverVOMeta.INSTANCE_ID , value = "变更实例ID" , required = false , dataTypeClass=String.class , example = "496781195003039744"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.APPROVER_ID , value = "审批人ID" , required = false , dataTypeClass=String.class , example = "496781163940024321"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.APPROVER_TYPE , value = "审批人类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeApproverVOMeta.NODE_ID , value = "节点ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ChangeApproverVOMeta.PAGE_INDEX , ChangeApproverVOMeta.PAGE_SIZE , ChangeApproverVOMeta.SEARCH_FIELD , ChangeApproverVOMeta.FUZZY_FIELD , ChangeApproverVOMeta.SEARCH_VALUE , ChangeApproverVOMeta.SORT_FIELD , ChangeApproverVOMeta.SORT_TYPE , ChangeApproverVOMeta.IDS } )
	@NotNull(name = ChangeApproverVOMeta.ID)
	@SentinelResource(value = ChangeApproverServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeApproverServiceProxy.SAVE)
	public Result save(ChangeApproverVO changeApproverVO) {
		Result result=changeApproverService.save(changeApproverVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取变更单据关系
	*/
	@ApiOperation(value = "获取变更单据关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeApproverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ChangeApproverVOMeta.ID)
	@SentinelResource(value = ChangeApproverServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeApproverServiceProxy.GET_BY_ID)
	public Result<ChangeApprover> getById(String id) {
		Result<ChangeApprover> result=new Result<>();
		ChangeApprover changeApprover=changeApproverService.getById(id);

		// join 关联的对象
		changeApproverService.dao().fill(changeApprover)
			.execute();

		result.success(true).data(changeApprover);
		return result;
	}


	/**
	 * 批量获取变更单据关系 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取变更单据关系")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ChangeApproverVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ChangeApproverVOMeta.IDS)
		@SentinelResource(value = ChangeApproverServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeApproverServiceProxy.GET_BY_IDS)
	public Result<List<ChangeApprover>> getByIds(List<String> ids) {
		Result<List<ChangeApprover>> result=new Result<>();
		List<ChangeApprover> list=changeApproverService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询变更单据关系
	*/
	@ApiOperation(value = "查询变更单据关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeApproverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "496781195195977728"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeApproverVOMeta.INSTANCE_ID , value = "变更实例ID" , required = false , dataTypeClass=String.class , example = "496781195003039744"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.APPROVER_ID , value = "审批人ID" , required = false , dataTypeClass=String.class , example = "496781163940024321"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.APPROVER_TYPE , value = "审批人类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeApproverVOMeta.NODE_ID , value = "节点ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ChangeApproverVOMeta.PAGE_INDEX , ChangeApproverVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ChangeApproverServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeApproverServiceProxy.QUERY_LIST)
	public Result<List<ChangeApprover>> queryList(ChangeApproverVO sample) {
		Result<List<ChangeApprover>> result=new Result<>();
		List<ChangeApprover> list=changeApproverService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询变更单据关系
	*/
	@ApiOperation(value = "分页查询变更单据关系")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeApproverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "496781195195977728"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeApproverVOMeta.INSTANCE_ID , value = "变更实例ID" , required = false , dataTypeClass=String.class , example = "496781195003039744"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.APPROVER_ID , value = "审批人ID" , required = false , dataTypeClass=String.class , example = "496781163940024321"),
		@ApiImplicitParam(name = ChangeApproverVOMeta.APPROVER_TYPE , value = "审批人类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeApproverVOMeta.NODE_ID , value = "节点ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ChangeApproverServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeApproverServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ChangeApprover>> queryPagedList(ChangeApproverVO sample) {
		Result<PagedList<ChangeApprover>> result=new Result<>();
		PagedList<ChangeApprover> list=changeApproverService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		changeApproverService.dao().fill(list)
			.execute();

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ChangeApproverServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeApproverServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ChangeApproverVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=changeApproverService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ChangeApproverServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeApproverServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=changeApproverService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ChangeApproverServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeApproverServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=changeApproverService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}