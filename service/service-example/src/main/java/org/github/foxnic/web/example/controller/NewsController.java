package org.github.foxnic.web.example.controller;


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


import org.github.foxnic.web.proxy.example.NewsServiceProxy;
import org.github.foxnic.web.domain.example.meta.NewsVOMeta;
import org.github.foxnic.web.domain.example.News;
import org.github.foxnic.web.domain.example.NewsVO;
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
import org.github.foxnic.web.domain.example.meta.NewsMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.example.service.INewsService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 示例新闻 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-03-09 21:02:43
*/

@Api(tags = "示例新闻")
@ApiSort(0)
@RestController("ExampleNewsController")
public class NewsController extends SuperController {

	@Autowired
	private INewsService newsService;


	/**
	 * 添加示例新闻
	*/
	@ApiOperation(value = "添加示例新闻")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NewsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.AUTHOR , value = "作者" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.EXPIRE_DATE , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = NewsServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NewsServiceProxy.INSERT)
	public Result insert(NewsVO newsVO) {
		Result result=newsService.insert(newsVO,false);
		return result;
	}



	/**
	 * 删除示例新闻
	*/
	@ApiOperation(value = "删除示例新闻")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NewsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = NewsVOMeta.ID)
	@SentinelResource(value = NewsServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NewsServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=newsService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除示例新闻 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除示例新闻")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NewsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = NewsVOMeta.IDS)
	@SentinelResource(value = NewsServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NewsServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=newsService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新示例新闻
	*/
	@ApiOperation(value = "更新示例新闻")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NewsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.AUTHOR , value = "作者" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.EXPIRE_DATE , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { NewsVOMeta.PAGE_INDEX , NewsVOMeta.PAGE_SIZE , NewsVOMeta.SEARCH_FIELD , NewsVOMeta.FUZZY_FIELD , NewsVOMeta.SEARCH_VALUE , NewsVOMeta.DIRTY_FIELDS , NewsVOMeta.SORT_FIELD , NewsVOMeta.SORT_TYPE , NewsVOMeta.IDS } )
	@NotNull(name = NewsVOMeta.ID)
	@SentinelResource(value = NewsServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NewsServiceProxy.UPDATE)
	public Result update(NewsVO newsVO) {
		Result result=newsService.update(newsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存示例新闻
	*/
	@ApiOperation(value = "保存示例新闻")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NewsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.AUTHOR , value = "作者" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.EXPIRE_DATE , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { NewsVOMeta.PAGE_INDEX , NewsVOMeta.PAGE_SIZE , NewsVOMeta.SEARCH_FIELD , NewsVOMeta.FUZZY_FIELD , NewsVOMeta.SEARCH_VALUE , NewsVOMeta.DIRTY_FIELDS , NewsVOMeta.SORT_FIELD , NewsVOMeta.SORT_TYPE , NewsVOMeta.IDS } )
	@NotNull(name = NewsVOMeta.ID)
	@SentinelResource(value = NewsServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NewsServiceProxy.SAVE)
	public Result save(NewsVO newsVO) {
		Result result=newsService.save(newsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取示例新闻
	*/
	@ApiOperation(value = "获取示例新闻")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NewsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = NewsVOMeta.ID)
	@SentinelResource(value = NewsServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NewsServiceProxy.GET_BY_ID)
	public Result<News> getById(String id) {
		Result<News> result=new Result<>();
		News news=newsService.getById(id);
		result.success(true).data(news);
		return result;
	}


	/**
	 * 批量获取示例新闻 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取示例新闻")
		@ApiImplicitParams({
				@ApiImplicitParam(name = NewsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = NewsVOMeta.IDS)
		@SentinelResource(value = NewsServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NewsServiceProxy.GET_BY_IDS)
	public Result<List<News>> getByIds(List<String> ids) {
		Result<List<News>> result=new Result<>();
		List<News> list=newsService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询示例新闻
	*/
	@ApiOperation(value = "查询示例新闻")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NewsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.AUTHOR , value = "作者" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.EXPIRE_DATE , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { NewsVOMeta.PAGE_INDEX , NewsVOMeta.PAGE_SIZE } )
	@SentinelResource(value = NewsServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NewsServiceProxy.QUERY_LIST)
	public Result<List<News>> queryList(NewsVO sample) {
		Result<List<News>> result=new Result<>();
		List<News> list=newsService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询示例新闻
	*/
	@ApiOperation(value = "分页查询示例新闻")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NewsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.AUTHOR , value = "作者" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NewsVOMeta.EXPIRE_DATE , value = "过期时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = NewsServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NewsServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<News>> queryPagedList(NewsVO sample) {
		Result<PagedList<News>> result=new Result<>();
		PagedList<News> list=newsService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = NewsServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(NewsServiceProxy.EXPORT_EXCEL)
	public void exportExcel(NewsVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=newsService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = NewsServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(NewsServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=newsService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = NewsServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(NewsServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=newsService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}