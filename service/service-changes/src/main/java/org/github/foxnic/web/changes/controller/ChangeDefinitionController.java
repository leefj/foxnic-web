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


import org.github.foxnic.web.proxy.changes.ChangeDefinitionServiceProxy;
import org.github.foxnic.web.domain.changes.meta.ChangeDefinitionVOMeta;
import org.github.foxnic.web.domain.changes.ChangeDefinition;
import org.github.foxnic.web.domain.changes.ChangeDefinitionVO;
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
import org.github.foxnic.web.domain.changes.meta.ChangeDefinitionMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.changes.service.IChangeDefinitionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 变更定义表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-30 09:23:37
*/

@Api(tags = "变更定义")
@ApiSort(0)
@RestController("ChsChangeDefinitionController")
public class ChangeDefinitionController extends SuperController {

	@Autowired
	private IChangeDefinitionService changeDefinitionService;

	
	/**
	 * 添加变更定义
	*/
	@ApiOperation(value = "添加变更定义")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495265596145934336"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "订单变更(测试)"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "EXAMPLE_ORDER_CHANGE"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.HANDLER , value = "处理类" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.changes.service.handler.ExampleOrderChangesHandler"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ChangeDefinitionVOMeta.VALID)
	@SentinelResource(value = ChangeDefinitionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDefinitionServiceProxy.INSERT)
	public Result insert(ChangeDefinitionVO changeDefinitionVO) {
		Result result=changeDefinitionService.insert(changeDefinitionVO);
		return result;
	}

	
	/**
	 * 删除变更定义
	*/
	@ApiOperation(value = "删除变更定义")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495265596145934336")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ChangeDefinitionVOMeta.ID)
	@SentinelResource(value = ChangeDefinitionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDefinitionServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=changeDefinitionService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除变更定义 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除变更定义")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ChangeDefinitionVOMeta.IDS)
	@SentinelResource(value = ChangeDefinitionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDefinitionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=changeDefinitionService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新变更定义
	*/
	@ApiOperation(value = "更新变更定义")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495265596145934336"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "订单变更(测试)"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "EXAMPLE_ORDER_CHANGE"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.HANDLER , value = "处理类" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.changes.service.handler.ExampleOrderChangesHandler"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ChangeDefinitionVOMeta.PAGE_INDEX , ChangeDefinitionVOMeta.PAGE_SIZE , ChangeDefinitionVOMeta.SEARCH_FIELD , ChangeDefinitionVOMeta.FUZZY_FIELD , ChangeDefinitionVOMeta.SEARCH_VALUE , ChangeDefinitionVOMeta.SORT_FIELD , ChangeDefinitionVOMeta.SORT_TYPE , ChangeDefinitionVOMeta.IDS } ) 
	@NotNull(name = ChangeDefinitionVOMeta.ID)
	@NotNull(name = ChangeDefinitionVOMeta.VALID)
	@SentinelResource(value = ChangeDefinitionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDefinitionServiceProxy.UPDATE)
	public Result update(ChangeDefinitionVO changeDefinitionVO) {
		Result result=changeDefinitionService.update(changeDefinitionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存变更定义
	*/
	@ApiOperation(value = "保存变更定义")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495265596145934336"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "订单变更(测试)"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "EXAMPLE_ORDER_CHANGE"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.HANDLER , value = "处理类" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.changes.service.handler.ExampleOrderChangesHandler"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ChangeDefinitionVOMeta.PAGE_INDEX , ChangeDefinitionVOMeta.PAGE_SIZE , ChangeDefinitionVOMeta.SEARCH_FIELD , ChangeDefinitionVOMeta.FUZZY_FIELD , ChangeDefinitionVOMeta.SEARCH_VALUE , ChangeDefinitionVOMeta.SORT_FIELD , ChangeDefinitionVOMeta.SORT_TYPE , ChangeDefinitionVOMeta.IDS } )
	@NotNull(name = ChangeDefinitionVOMeta.ID)
	@NotNull(name = ChangeDefinitionVOMeta.VALID)
	@SentinelResource(value = ChangeDefinitionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDefinitionServiceProxy.SAVE)
	public Result save(ChangeDefinitionVO changeDefinitionVO) {
		Result result=changeDefinitionService.save(changeDefinitionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取变更定义
	*/
	@ApiOperation(value = "获取变更定义")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ChangeDefinitionVOMeta.ID)
	@SentinelResource(value = ChangeDefinitionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDefinitionServiceProxy.GET_BY_ID)
	public Result<ChangeDefinition> getById(String id) {
		Result<ChangeDefinition> result=new Result<>();
		ChangeDefinition changeDefinition=changeDefinitionService.getById(id);
		result.success(true).data(changeDefinition);
		return result;
	}


	/**
	 * 批量获取变更定义 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取变更定义")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ChangeDefinitionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ChangeDefinitionVOMeta.IDS)
		@SentinelResource(value = ChangeDefinitionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDefinitionServiceProxy.GET_BY_IDS)
	public Result<List<ChangeDefinition>> getByIds(List<String> ids) {
		Result<List<ChangeDefinition>> result=new Result<>();
		List<ChangeDefinition> list=changeDefinitionService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询变更定义
	*/
	@ApiOperation(value = "查询变更定义")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495265596145934336"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "订单变更(测试)"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "EXAMPLE_ORDER_CHANGE"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.HANDLER , value = "处理类" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.changes.service.handler.ExampleOrderChangesHandler"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ChangeDefinitionVOMeta.PAGE_INDEX , ChangeDefinitionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ChangeDefinitionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDefinitionServiceProxy.QUERY_LIST)
	public Result<List<ChangeDefinition>> queryList(ChangeDefinitionVO sample) {
		Result<List<ChangeDefinition>> result=new Result<>();
		List<ChangeDefinition> list=changeDefinitionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询变更定义
	*/
	@ApiOperation(value = "分页查询变更定义")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "495265596145934336"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "订单变更(测试)"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "EXAMPLE_ORDER_CHANGE"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.HANDLER , value = "处理类" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.changes.service.handler.ExampleOrderChangesHandler"),
		@ApiImplicitParam(name = ChangeDefinitionVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ChangeDefinitionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDefinitionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ChangeDefinition>> queryPagedList(ChangeDefinitionVO sample) {
		Result<PagedList<ChangeDefinition>> result=new Result<>();
		PagedList<ChangeDefinition> list=changeDefinitionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ChangeDefinitionServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeDefinitionServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ChangeDefinitionVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=changeDefinitionService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ChangeDefinitionServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeDefinitionServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=changeDefinitionService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ChangeDefinitionServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeDefinitionServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=changeDefinitionService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}