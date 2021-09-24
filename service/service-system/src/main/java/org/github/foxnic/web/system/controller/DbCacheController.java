package org.github.foxnic.web.system.controller;

 
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
import org.github.foxnic.web.domain.system.DbCache;
import org.github.foxnic.web.domain.system.DbCacheVO;
import org.github.foxnic.web.domain.system.meta.DbCacheVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.system.DbCacheServiceProxy;
import org.github.foxnic.web.system.service.IDbCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据库缓存表，内存表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-03 16:01:50
*/

@Api(tags = "数据库缓存")
@ApiSort(0)
@RestController("SysDbCacheController")
public class DbCacheController extends SuperController {

	@Autowired
	private IDbCacheService dbCacheService;

	
	/**
	 * 添加数据库缓存
	*/
	@ApiOperation(value = "添加数据库缓存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCacheVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "/business/oauth/session_online/session_online_list.html#data-table"),
		@ApiImplicitParam(name = DbCacheVOMeta.CATALOG , value = "数据分类" , required = false , dataTypeClass=String.class , example = "layui-table-column-width"),
		@ApiImplicitParam(name = DbCacheVOMeta.AREA , value = "数据分区" , required = false , dataTypeClass=String.class , example = "/business/oauth/session_online/session_online_list.html"),
		@ApiImplicitParam(name = DbCacheVOMeta.OWNER_TYPE , value = "所有者类型" , required = false , dataTypeClass=String.class , example = "user"),
		@ApiImplicitParam(name = DbCacheVOMeta.OWNER_ID , value = "所有者ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
		@ApiImplicitParam(name = DbCacheVOMeta.VALUE , value = "数据" , required = false , dataTypeClass=String.class , example = ""),
		@ApiImplicitParam(name = DbCacheVOMeta.EXPIRE_TIME , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = DbCacheVOMeta.ID)
	@SentinelResource(value = DbCacheServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCacheServiceProxy.INSERT)
	public Result insert(DbCacheVO dbCacheVO) {
		Result result=dbCacheService.insert(dbCacheVO);
		return result;
	}

	
	/**
	 * 删除数据库缓存
	*/
	@ApiOperation(value = "删除数据库缓存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCacheVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "/business/oauth/session_online/session_online_list.html#data-table"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = DbCacheVOMeta.ID)
	@SentinelResource(value = DbCacheServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCacheServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=dbCacheService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除数据库缓存 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据库缓存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCacheVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = DbCacheVOMeta.IDS)
	@SentinelResource(value = DbCacheServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCacheServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=dbCacheService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新数据库缓存
	*/
	@ApiOperation(value = "更新数据库缓存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCacheVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "/business/oauth/session_online/session_online_list.html#data-table"),
		@ApiImplicitParam(name = DbCacheVOMeta.CATALOG , value = "数据分类" , required = false , dataTypeClass=String.class , example = "layui-table-column-width"),
		@ApiImplicitParam(name = DbCacheVOMeta.AREA , value = "数据分区" , required = false , dataTypeClass=String.class , example = "/business/oauth/session_online/session_online_list.html"),
		@ApiImplicitParam(name = DbCacheVOMeta.OWNER_TYPE , value = "所有者类型" , required = false , dataTypeClass=String.class , example = "user"),
		@ApiImplicitParam(name = DbCacheVOMeta.OWNER_ID , value = "所有者ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
		@ApiImplicitParam(name = DbCacheVOMeta.VALUE , value = "数据" , required = false , dataTypeClass=String.class , example = ""),
		@ApiImplicitParam(name = DbCacheVOMeta.EXPIRE_TIME , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { DbCacheVOMeta.PAGE_INDEX , DbCacheVOMeta.PAGE_SIZE , DbCacheVOMeta.SEARCH_FIELD , DbCacheVOMeta.SEARCH_VALUE , DbCacheVOMeta.SORT_FIELD , DbCacheVOMeta.SORT_TYPE , DbCacheVOMeta.IDS , DbCacheVOMeta.SECONDS } ) 
	@NotNull(name = DbCacheVOMeta.ID)
	@SentinelResource(value = DbCacheServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCacheServiceProxy.UPDATE)
	public Result update(DbCacheVO dbCacheVO) {
		Result result=dbCacheService.update(dbCacheVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存数据库缓存
	*/
	@ApiOperation(value = "保存数据库缓存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCacheVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "/business/oauth/session_online/session_online_list.html#data-table"),
		@ApiImplicitParam(name = DbCacheVOMeta.CATALOG , value = "数据分类" , required = false , dataTypeClass=String.class , example = "layui-table-column-width"),
		@ApiImplicitParam(name = DbCacheVOMeta.AREA , value = "数据分区" , required = false , dataTypeClass=String.class , example = "/business/oauth/session_online/session_online_list.html"),
		@ApiImplicitParam(name = DbCacheVOMeta.OWNER_TYPE , value = "所有者类型" , required = false , dataTypeClass=String.class , example = "user"),
		@ApiImplicitParam(name = DbCacheVOMeta.OWNER_ID , value = "所有者ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
		@ApiImplicitParam(name = DbCacheVOMeta.VALUE , value = "数据" , required = false , dataTypeClass=String.class , example = ""),
		@ApiImplicitParam(name = DbCacheVOMeta.EXPIRE_TIME , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbCacheVOMeta.PAGE_INDEX , DbCacheVOMeta.PAGE_SIZE , DbCacheVOMeta.SEARCH_FIELD , DbCacheVOMeta.SEARCH_VALUE , DbCacheVOMeta.SORT_FIELD , DbCacheVOMeta.SORT_TYPE , DbCacheVOMeta.IDS , DbCacheVOMeta.SECONDS } )
	@NotNull(name = DbCacheVOMeta.ID)
	@SentinelResource(value = DbCacheServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCacheServiceProxy.SAVE)
	public Result save(DbCacheVO dbCacheVO) {
		Result result=dbCacheService.save(dbCacheVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取数据库缓存
	*/
	@ApiOperation(value = "获取数据库缓存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCacheVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = DbCacheVOMeta.ID)
	@SentinelResource(value = DbCacheServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCacheServiceProxy.GET_BY_ID)
	public Result<DbCache> getById(String id) {
		Result<DbCache> result=new Result<>();
		DbCache role=dbCacheService.getById(id);
		result.success(true).data(role);
		return result;
	}




	
	/**
	 * 查询数据库缓存
	*/
	@ApiOperation(value = "查询数据库缓存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCacheVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "/business/oauth/session_online/session_online_list.html#data-table"),
		@ApiImplicitParam(name = DbCacheVOMeta.CATALOG , value = "数据分类" , required = false , dataTypeClass=String.class , example = "layui-table-column-width"),
		@ApiImplicitParam(name = DbCacheVOMeta.AREA , value = "数据分区" , required = false , dataTypeClass=String.class , example = "/business/oauth/session_online/session_online_list.html"),
		@ApiImplicitParam(name = DbCacheVOMeta.OWNER_TYPE , value = "所有者类型" , required = false , dataTypeClass=String.class , example = "user"),
		@ApiImplicitParam(name = DbCacheVOMeta.OWNER_ID , value = "所有者ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
		@ApiImplicitParam(name = DbCacheVOMeta.VALUE , value = "数据" , required = false , dataTypeClass=String.class , example = ""),
		@ApiImplicitParam(name = DbCacheVOMeta.EXPIRE_TIME , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbCacheVOMeta.PAGE_INDEX , DbCacheVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbCacheServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCacheServiceProxy.QUERY_LIST)
	public Result<List<DbCache>> queryList(DbCacheVO sample) {
		Result<List<DbCache>> result=new Result<>();
		List<DbCache> list=dbCacheService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询数据库缓存
	*/
	@ApiOperation(value = "分页查询数据库缓存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCacheVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "/business/oauth/session_online/session_online_list.html#data-table"),
		@ApiImplicitParam(name = DbCacheVOMeta.CATALOG , value = "数据分类" , required = false , dataTypeClass=String.class , example = "layui-table-column-width"),
		@ApiImplicitParam(name = DbCacheVOMeta.AREA , value = "数据分区" , required = false , dataTypeClass=String.class , example = "/business/oauth/session_online/session_online_list.html"),
		@ApiImplicitParam(name = DbCacheVOMeta.OWNER_TYPE , value = "所有者类型" , required = false , dataTypeClass=String.class , example = "user"),
		@ApiImplicitParam(name = DbCacheVOMeta.OWNER_ID , value = "所有者ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
		@ApiImplicitParam(name = DbCacheVOMeta.VALUE , value = "数据" , required = false , dataTypeClass=String.class , example = ""),
		@ApiImplicitParam(name = DbCacheVOMeta.EXPIRE_TIME , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = DbCacheServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCacheServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbCache>> queryPagedList(DbCacheVO sample) {
		Result<PagedList<DbCache>> result=new Result<>();
		PagedList<DbCache> list=dbCacheService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = DbCacheServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(DbCacheServiceProxy.EXPORT_EXCEL)
	public void exportExcel(DbCacheVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=dbCacheService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = DbCacheServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(DbCacheServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=dbCacheService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = DbCacheServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(DbCacheServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=dbCacheService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}