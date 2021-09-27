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


import org.github.foxnic.web.proxy.changes.ChangeDataServiceProxy;
import org.github.foxnic.web.domain.changes.meta.ChangeDataVOMeta;
import org.github.foxnic.web.domain.changes.ChangeData;
import org.github.foxnic.web.domain.changes.ChangeDataVO;
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
import org.github.foxnic.web.domain.changes.meta.ChangeDataMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.changes.service.IChangeDataService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 *  接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-27 16:04:55
*/

@Api(tags = "chs_change_data")
@ApiSort(0)
@RestController("ChsChangeDataController")
public class ChangeDataController extends SuperController {

	@Autowired
	private IChangeDataService changeDataService;

	
	/**
	 * 添加chs_change_data
	*/
	@ApiOperation(value = "添加chs_change_data")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.DATA_TYPE , value = "实体类名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.TIME_POINT , value = "变更时间点" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.DATA , value = "数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ChangeDataServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDataServiceProxy.INSERT)
	public Result insert(ChangeDataVO changeDataVO) {
		Result result=changeDataService.insert(changeDataVO);
		return result;
	}

	
	/**
	 * 删除chs_change_data
	*/
	@ApiOperation(value = "删除chs_change_data")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ChangeDataVOMeta.ID)
	@SentinelResource(value = ChangeDataServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDataServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=changeDataService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除chs_change_data <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除chs_change_data")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ChangeDataVOMeta.IDS)
	@SentinelResource(value = ChangeDataServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDataServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=changeDataService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新chs_change_data
	*/
	@ApiOperation(value = "更新chs_change_data")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.DATA_TYPE , value = "实体类名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.TIME_POINT , value = "变更时间点" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.DATA , value = "数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ChangeDataVOMeta.PAGE_INDEX , ChangeDataVOMeta.PAGE_SIZE , ChangeDataVOMeta.SEARCH_FIELD , ChangeDataVOMeta.FUZZY_FIELD , ChangeDataVOMeta.SEARCH_VALUE , ChangeDataVOMeta.SORT_FIELD , ChangeDataVOMeta.SORT_TYPE , ChangeDataVOMeta.IDS } ) 
	@NotNull(name = ChangeDataVOMeta.ID)
	@SentinelResource(value = ChangeDataServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDataServiceProxy.UPDATE)
	public Result update(ChangeDataVO changeDataVO) {
		Result result=changeDataService.update(changeDataVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存chs_change_data
	*/
	@ApiOperation(value = "保存chs_change_data")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.DATA_TYPE , value = "实体类名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.TIME_POINT , value = "变更时间点" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.DATA , value = "数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ChangeDataVOMeta.PAGE_INDEX , ChangeDataVOMeta.PAGE_SIZE , ChangeDataVOMeta.SEARCH_FIELD , ChangeDataVOMeta.FUZZY_FIELD , ChangeDataVOMeta.SEARCH_VALUE , ChangeDataVOMeta.SORT_FIELD , ChangeDataVOMeta.SORT_TYPE , ChangeDataVOMeta.IDS } )
	@NotNull(name = ChangeDataVOMeta.ID)
	@SentinelResource(value = ChangeDataServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDataServiceProxy.SAVE)
	public Result save(ChangeDataVO changeDataVO) {
		Result result=changeDataService.save(changeDataVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取chs_change_data
	*/
	@ApiOperation(value = "获取chs_change_data")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ChangeDataVOMeta.ID)
	@SentinelResource(value = ChangeDataServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDataServiceProxy.GET_BY_ID)
	public Result<ChangeData> getById(String id) {
		Result<ChangeData> result=new Result<>();
		ChangeData changeData=changeDataService.getById(id);
		result.success(true).data(changeData);
		return result;
	}


	/**
	 * 批量删除chs_change_data <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除chs_change_data")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ChangeDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ChangeDataVOMeta.IDS)
		@SentinelResource(value = ChangeDataServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDataServiceProxy.GET_BY_IDS)
	public Result<List<ChangeData>> getByIds(List<String> ids) {
		Result<List<ChangeData>> result=new Result<>();
		List<ChangeData> list=changeDataService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询chs_change_data
	*/
	@ApiOperation(value = "查询chs_change_data")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.DATA_TYPE , value = "实体类名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.TIME_POINT , value = "变更时间点" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.DATA , value = "数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ChangeDataVOMeta.PAGE_INDEX , ChangeDataVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ChangeDataServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDataServiceProxy.QUERY_LIST)
	public Result<List<ChangeData>> queryList(ChangeDataVO sample) {
		Result<List<ChangeData>> result=new Result<>();
		List<ChangeData> list=changeDataService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询chs_change_data
	*/
	@ApiOperation(value = "分页查询chs_change_data")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.DATA_TYPE , value = "实体类名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.TIME_POINT , value = "变更时间点" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ChangeDataVOMeta.DATA , value = "数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ChangeDataServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeDataServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ChangeData>> queryPagedList(ChangeDataVO sample) {
		Result<PagedList<ChangeData>> result=new Result<>();
		PagedList<ChangeData> list=changeDataService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ChangeDataServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeDataServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ChangeDataVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=changeDataService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ChangeDataServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeDataServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=changeDataService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ChangeDataServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeDataServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=changeDataService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}