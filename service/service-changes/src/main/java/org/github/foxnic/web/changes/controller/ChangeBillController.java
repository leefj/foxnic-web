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


import org.github.foxnic.web.proxy.changes.ChangeBillServiceProxy;
import org.github.foxnic.web.domain.changes.meta.ChangeBillVOMeta;
import org.github.foxnic.web.domain.changes.ChangeBill;
import org.github.foxnic.web.domain.changes.ChangeBillVO;
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
import org.github.foxnic.web.domain.changes.meta.ChangeBillMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.changes.service.IChangeBillService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 *  接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-02 20:13:19
*/

@Api(tags = "chs_change_bill")
@ApiSort(0)
@RestController("ChsChangeBillController")
public class ChangeBillController extends SuperController {

	@Autowired
	private IChangeBillService changeBillService;

	
	/**
	 * 添加chs_change_bill
	*/
	@ApiOperation(value = "添加chs_change_bill")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeBillVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "496732400835887104"),
		@ApiImplicitParam(name = ChangeBillVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeBillVOMeta.INSTANCE_ID , value = "变更实例ID" , required = false , dataTypeClass=String.class , example = "496732400290627584"),
		@ApiImplicitParam(name = ChangeBillVOMeta.BILL_ID , value = "变更单据ID" , required = false , dataTypeClass=String.class , example = "496732383110758400")
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ChangeBillServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeBillServiceProxy.INSERT)
	public Result insert(ChangeBillVO changeBillVO) {
		Result result=changeBillService.insert(changeBillVO);
		return result;
	}

	
	/**
	 * 删除chs_change_bill
	*/
	@ApiOperation(value = "删除chs_change_bill")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeBillVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "496732400835887104")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ChangeBillVOMeta.ID)
	@SentinelResource(value = ChangeBillServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeBillServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=changeBillService.deleteByIdPhysical(id);
		return result;
	}
	
	
	/**
	 * 批量删除chs_change_bill <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除chs_change_bill")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeBillVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ChangeBillVOMeta.IDS)
	@SentinelResource(value = ChangeBillServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeBillServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=changeBillService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新chs_change_bill
	*/
	@ApiOperation(value = "更新chs_change_bill")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeBillVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "496732400835887104"),
		@ApiImplicitParam(name = ChangeBillVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeBillVOMeta.INSTANCE_ID , value = "变更实例ID" , required = false , dataTypeClass=String.class , example = "496732400290627584"),
		@ApiImplicitParam(name = ChangeBillVOMeta.BILL_ID , value = "变更单据ID" , required = false , dataTypeClass=String.class , example = "496732383110758400")
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ChangeBillVOMeta.PAGE_INDEX , ChangeBillVOMeta.PAGE_SIZE , ChangeBillVOMeta.SEARCH_FIELD , ChangeBillVOMeta.FUZZY_FIELD , ChangeBillVOMeta.SEARCH_VALUE , ChangeBillVOMeta.SORT_FIELD , ChangeBillVOMeta.SORT_TYPE , ChangeBillVOMeta.IDS } ) 
	@NotNull(name = ChangeBillVOMeta.ID)
	@SentinelResource(value = ChangeBillServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeBillServiceProxy.UPDATE)
	public Result update(ChangeBillVO changeBillVO) {
		Result result=changeBillService.update(changeBillVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存chs_change_bill
	*/
	@ApiOperation(value = "保存chs_change_bill")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeBillVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "496732400835887104"),
		@ApiImplicitParam(name = ChangeBillVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeBillVOMeta.INSTANCE_ID , value = "变更实例ID" , required = false , dataTypeClass=String.class , example = "496732400290627584"),
		@ApiImplicitParam(name = ChangeBillVOMeta.BILL_ID , value = "变更单据ID" , required = false , dataTypeClass=String.class , example = "496732383110758400")
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ChangeBillVOMeta.PAGE_INDEX , ChangeBillVOMeta.PAGE_SIZE , ChangeBillVOMeta.SEARCH_FIELD , ChangeBillVOMeta.FUZZY_FIELD , ChangeBillVOMeta.SEARCH_VALUE , ChangeBillVOMeta.SORT_FIELD , ChangeBillVOMeta.SORT_TYPE , ChangeBillVOMeta.IDS } )
	@NotNull(name = ChangeBillVOMeta.ID)
	@SentinelResource(value = ChangeBillServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeBillServiceProxy.SAVE)
	public Result save(ChangeBillVO changeBillVO) {
		Result result=changeBillService.save(changeBillVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取chs_change_bill
	*/
	@ApiOperation(value = "获取chs_change_bill")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeBillVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ChangeBillVOMeta.ID)
	@SentinelResource(value = ChangeBillServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeBillServiceProxy.GET_BY_ID)
	public Result<ChangeBill> getById(String id) {
		Result<ChangeBill> result=new Result<>();
		ChangeBill changeBill=changeBillService.getById(id);
		result.success(true).data(changeBill);
		return result;
	}


	/**
	 * 批量获取chs_change_bill <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取chs_change_bill")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ChangeBillVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ChangeBillVOMeta.IDS)
		@SentinelResource(value = ChangeBillServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeBillServiceProxy.GET_BY_IDS)
	public Result<List<ChangeBill>> getByIds(List<String> ids) {
		Result<List<ChangeBill>> result=new Result<>();
		List<ChangeBill> list=changeBillService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询chs_change_bill
	*/
	@ApiOperation(value = "查询chs_change_bill")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeBillVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "496732400835887104"),
		@ApiImplicitParam(name = ChangeBillVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeBillVOMeta.INSTANCE_ID , value = "变更实例ID" , required = false , dataTypeClass=String.class , example = "496732400290627584"),
		@ApiImplicitParam(name = ChangeBillVOMeta.BILL_ID , value = "变更单据ID" , required = false , dataTypeClass=String.class , example = "496732383110758400")
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ChangeBillVOMeta.PAGE_INDEX , ChangeBillVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ChangeBillServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeBillServiceProxy.QUERY_LIST)
	public Result<List<ChangeBill>> queryList(ChangeBillVO sample) {
		Result<List<ChangeBill>> result=new Result<>();
		List<ChangeBill> list=changeBillService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询chs_change_bill
	*/
	@ApiOperation(value = "分页查询chs_change_bill")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeBillVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "496732400835887104"),
		@ApiImplicitParam(name = ChangeBillVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeBillVOMeta.INSTANCE_ID , value = "变更实例ID" , required = false , dataTypeClass=String.class , example = "496732400290627584"),
		@ApiImplicitParam(name = ChangeBillVOMeta.BILL_ID , value = "变更单据ID" , required = false , dataTypeClass=String.class , example = "496732383110758400")
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ChangeBillServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeBillServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ChangeBill>> queryPagedList(ChangeBillVO sample) {
		Result<PagedList<ChangeBill>> result=new Result<>();
		PagedList<ChangeBill> list=changeBillService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ChangeBillServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeBillServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ChangeBillVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=changeBillService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ChangeBillServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeBillServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=changeBillService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ChangeBillServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeBillServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=changeBillService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}