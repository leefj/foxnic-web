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


import org.github.foxnic.web.proxy.changes.ChangeInstanceServiceProxy;
import org.github.foxnic.web.domain.changes.meta.ChangeInstanceVOMeta;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.changes.ChangeInstanceVO;
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
import org.github.foxnic.web.domain.changes.meta.ChangeInstanceMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.changes.service.IChangeInstanceService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 变更实例表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-28 09:10:34
*/

@Api(tags = "变更实例")
@ApiSort(0)
@RestController("ChsChangeInstanceController")
public class ChangeInstanceController extends SuperController {

	@Autowired
	private IChangeInstanceService changeInstanceService;

	
	/**
	 * 添加变更实例
	*/
	@ApiOperation(value = "添加变更实例")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeInstanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_TABLE , value = "变更对象的数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_TYPE , value = "变更对象类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_ID , value = "变更对象ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ChangeInstanceServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeInstanceServiceProxy.INSERT)
	public Result insert(ChangeInstanceVO changeInstanceVO) {
		Result result=changeInstanceService.insert(changeInstanceVO);
		return result;
	}

	
	/**
	 * 删除变更实例
	*/
	@ApiOperation(value = "删除变更实例")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeInstanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ChangeInstanceVOMeta.ID)
	@SentinelResource(value = ChangeInstanceServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeInstanceServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=changeInstanceService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除变更实例 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除变更实例")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeInstanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ChangeInstanceVOMeta.IDS)
	@SentinelResource(value = ChangeInstanceServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeInstanceServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=changeInstanceService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新变更实例
	*/
	@ApiOperation(value = "更新变更实例")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeInstanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_TABLE , value = "变更对象的数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_TYPE , value = "变更对象类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_ID , value = "变更对象ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ChangeInstanceVOMeta.PAGE_INDEX , ChangeInstanceVOMeta.PAGE_SIZE , ChangeInstanceVOMeta.SEARCH_FIELD , ChangeInstanceVOMeta.FUZZY_FIELD , ChangeInstanceVOMeta.SEARCH_VALUE , ChangeInstanceVOMeta.SORT_FIELD , ChangeInstanceVOMeta.SORT_TYPE , ChangeInstanceVOMeta.IDS } ) 
	@NotNull(name = ChangeInstanceVOMeta.ID)
	@SentinelResource(value = ChangeInstanceServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeInstanceServiceProxy.UPDATE)
	public Result update(ChangeInstanceVO changeInstanceVO) {
		Result result=changeInstanceService.update(changeInstanceVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存变更实例
	*/
	@ApiOperation(value = "保存变更实例")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeInstanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_TABLE , value = "变更对象的数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_TYPE , value = "变更对象类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_ID , value = "变更对象ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ChangeInstanceVOMeta.PAGE_INDEX , ChangeInstanceVOMeta.PAGE_SIZE , ChangeInstanceVOMeta.SEARCH_FIELD , ChangeInstanceVOMeta.FUZZY_FIELD , ChangeInstanceVOMeta.SEARCH_VALUE , ChangeInstanceVOMeta.SORT_FIELD , ChangeInstanceVOMeta.SORT_TYPE , ChangeInstanceVOMeta.IDS } )
	@NotNull(name = ChangeInstanceVOMeta.ID)
	@SentinelResource(value = ChangeInstanceServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeInstanceServiceProxy.SAVE)
	public Result save(ChangeInstanceVO changeInstanceVO) {
		Result result=changeInstanceService.save(changeInstanceVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取变更实例
	*/
	@ApiOperation(value = "获取变更实例")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeInstanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ChangeInstanceVOMeta.ID)
	@SentinelResource(value = ChangeInstanceServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeInstanceServiceProxy.GET_BY_ID)
	public Result<ChangeInstance> getById(String id) {
		Result<ChangeInstance> result=new Result<>();
		ChangeInstance changeInstance=changeInstanceService.getById(id);
		result.success(true).data(changeInstance);
		return result;
	}


	/**
	 * 批量删除变更实例 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除变更实例")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ChangeInstanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ChangeInstanceVOMeta.IDS)
		@SentinelResource(value = ChangeInstanceServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeInstanceServiceProxy.GET_BY_IDS)
	public Result<List<ChangeInstance>> getByIds(List<String> ids) {
		Result<List<ChangeInstance>> result=new Result<>();
		List<ChangeInstance> list=changeInstanceService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询变更实例
	*/
	@ApiOperation(value = "查询变更实例")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeInstanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_TABLE , value = "变更对象的数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_TYPE , value = "变更对象类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_ID , value = "变更对象ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ChangeInstanceVOMeta.PAGE_INDEX , ChangeInstanceVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ChangeInstanceServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeInstanceServiceProxy.QUERY_LIST)
	public Result<List<ChangeInstance>> queryList(ChangeInstanceVO sample) {
		Result<List<ChangeInstance>> result=new Result<>();
		List<ChangeInstance> list=changeInstanceService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询变更实例
	*/
	@ApiOperation(value = "分页查询变更实例")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ChangeInstanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.DEFINITION_ID , value = "变更定义ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_TABLE , value = "变更对象的数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_TYPE , value = "变更对象类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.TARGET_ID , value = "变更对象ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ChangeInstanceVOMeta.STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ChangeInstanceServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ChangeInstanceServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ChangeInstance>> queryPagedList(ChangeInstanceVO sample) {
		Result<PagedList<ChangeInstance>> result=new Result<>();
		PagedList<ChangeInstance> list=changeInstanceService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ChangeInstanceServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeInstanceServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ChangeInstanceVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=changeInstanceService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ChangeInstanceServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeInstanceServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=changeInstanceService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ChangeInstanceServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ChangeInstanceServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=changeInstanceService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}