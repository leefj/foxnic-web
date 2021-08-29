package org.github.foxnic.web.pcm.controller;

 
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


import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.github.foxnic.web.domain.pcm.meta.CatalogVOMeta;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogVO;
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
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.pcm.service.ICatalogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据存储表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-28 15:45:05
*/

@Api(tags = "数据存储")
@ApiSort(0)
@RestController("PcmCatalogController")
public class CatalogController extends SuperController {

	@Autowired
	private ICatalogService catalogService;

	
	/**
	 * 添加数据存储
	*/
	@ApiOperation(value = "添加数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.DATA_TABLE , value = "存储表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.TENANT_ID , value = "租户ID" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = CatalogVOMeta.ID)
	@NotNull(name = CatalogVOMeta.TENANT_ID)
	@SentinelResource(value = CatalogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.INSERT)
	public Result insert(CatalogVO catalogVO) {
		Result result=catalogService.insert(catalogVO);
		return result;
	}

	
	/**
	 * 删除数据存储
	*/
	@ApiOperation(value = "删除数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CatalogVOMeta.ID)
	@SentinelResource(value = CatalogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.DELETE)
	public Result deleteById(Integer id) {
		Result result=catalogService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除数据存储 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CatalogVOMeta.IDS)
	@SentinelResource(value = CatalogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<Integer> ids) {
		Result result=catalogService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新数据存储
	*/
	@ApiOperation(value = "更新数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.DATA_TABLE , value = "存储表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.TENANT_ID , value = "租户ID" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CatalogVOMeta.PAGE_INDEX , CatalogVOMeta.PAGE_SIZE , CatalogVOMeta.SEARCH_FIELD , CatalogVOMeta.FUZZY_FIELD , CatalogVOMeta.SEARCH_VALUE , CatalogVOMeta.SORT_FIELD , CatalogVOMeta.SORT_TYPE , CatalogVOMeta.IDS } ) 
	@NotNull(name = CatalogVOMeta.ID)
	@NotNull(name = CatalogVOMeta.TENANT_ID)
	@SentinelResource(value = CatalogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.UPDATE)
	public Result update(CatalogVO catalogVO) {
		Result result=catalogService.update(catalogVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存数据存储
	*/
	@ApiOperation(value = "保存数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.DATA_TABLE , value = "存储表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.TENANT_ID , value = "租户ID" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CatalogVOMeta.PAGE_INDEX , CatalogVOMeta.PAGE_SIZE , CatalogVOMeta.SEARCH_FIELD , CatalogVOMeta.FUZZY_FIELD , CatalogVOMeta.SEARCH_VALUE , CatalogVOMeta.SORT_FIELD , CatalogVOMeta.SORT_TYPE , CatalogVOMeta.IDS } )
	@NotNull(name = CatalogVOMeta.ID)
	@NotNull(name = CatalogVOMeta.TENANT_ID)
	@SentinelResource(value = CatalogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.SAVE)
	public Result save(CatalogVO catalogVO) {
		Result result=catalogService.save(catalogVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取数据存储
	*/
	@ApiOperation(value = "获取数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CatalogVOMeta.ID)
	@SentinelResource(value = CatalogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.GET_BY_ID)
	public Result<Catalog> getById(Integer id) {
		Result<Catalog> result=new Result<>();
		Catalog catalog=catalogService.getById(id);
		result.success(true).data(catalog);
		return result;
	}


	/**
	 * 批量删除数据存储 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除数据存储")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CatalogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CatalogVOMeta.IDS)
		@SentinelResource(value = CatalogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.GET_BY_IDS)
	public Result<List<Catalog>> getByIds(List<Integer> ids) {
		Result<List<Catalog>> result=new Result<>();
		List<Catalog> list=catalogService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询数据存储
	*/
	@ApiOperation(value = "查询数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.DATA_TABLE , value = "存储表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.TENANT_ID , value = "租户ID" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CatalogVOMeta.PAGE_INDEX , CatalogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CatalogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.QUERY_LIST)
	public Result<List<Catalog>> queryList(CatalogVO sample) {
		Result<List<Catalog>> result=new Result<>();
		List<Catalog> list=catalogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询数据存储
	*/
	@ApiOperation(value = "分页查询数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.DATA_TABLE , value = "存储表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.TENANT_ID , value = "租户ID" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CatalogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Catalog>> queryPagedList(CatalogVO sample) {
		Result<PagedList<Catalog>> result=new Result<>();
		PagedList<Catalog> list=catalogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CatalogServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CatalogServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CatalogVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=catalogService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CatalogServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CatalogServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=catalogService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = CatalogServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CatalogServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=catalogService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}