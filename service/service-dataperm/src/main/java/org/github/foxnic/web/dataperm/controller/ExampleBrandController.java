package org.github.foxnic.web.dataperm.controller;


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


import org.github.foxnic.web.proxy.dataperm.ExampleBrandServiceProxy;
import org.github.foxnic.web.domain.dataperm.meta.ExampleBrandVOMeta;
import org.github.foxnic.web.domain.dataperm.ExampleBrand;
import org.github.foxnic.web.domain.dataperm.ExampleBrandVO;
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
import org.github.foxnic.web.domain.dataperm.meta.ExampleBrandMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.dataperm.service.IExampleBrandService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 商品品牌表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-14 16:24:46
*/

@Api(tags = "商品品牌")
@ApiSort(0)
@RestController("DpExampleBrandController")
public class ExampleBrandController extends SuperController {

	@Autowired
	private IExampleBrandService exampleBrandService;


	/**
	 * 添加商品品牌
	*/
	@ApiOperation(value = "添加商品品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleBrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "NBFD"),
		@ApiImplicitParam(name = ExampleBrandVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "宁波富德"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ExampleBrandServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleBrandServiceProxy.INSERT)
	public Result insert(ExampleBrandVO exampleBrandVO) {
		Result result=exampleBrandService.insert(exampleBrandVO);
		return result;
	}



	/**
	 * 删除商品品牌
	*/
	@ApiOperation(value = "删除商品品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleBrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "NBFD")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ExampleBrandVOMeta.ID)
	@SentinelResource(value = ExampleBrandServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleBrandServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=exampleBrandService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除商品品牌 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除商品品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleBrandVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ExampleBrandVOMeta.IDS)
	@SentinelResource(value = ExampleBrandServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleBrandServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=exampleBrandService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新商品品牌
	*/
	@ApiOperation(value = "更新商品品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleBrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "NBFD"),
		@ApiImplicitParam(name = ExampleBrandVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "宁波富德"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ExampleBrandVOMeta.PAGE_INDEX , ExampleBrandVOMeta.PAGE_SIZE , ExampleBrandVOMeta.SEARCH_FIELD , ExampleBrandVOMeta.FUZZY_FIELD , ExampleBrandVOMeta.SEARCH_VALUE , ExampleBrandVOMeta.SORT_FIELD , ExampleBrandVOMeta.SORT_TYPE , ExampleBrandVOMeta.IDS } )
	@NotNull(name = ExampleBrandVOMeta.ID)
	@SentinelResource(value = ExampleBrandServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleBrandServiceProxy.UPDATE)
	public Result update(ExampleBrandVO exampleBrandVO) {
		Result result=exampleBrandService.update(exampleBrandVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存商品品牌
	*/
	@ApiOperation(value = "保存商品品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleBrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "NBFD"),
		@ApiImplicitParam(name = ExampleBrandVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "宁波富德"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleBrandVOMeta.PAGE_INDEX , ExampleBrandVOMeta.PAGE_SIZE , ExampleBrandVOMeta.SEARCH_FIELD , ExampleBrandVOMeta.FUZZY_FIELD , ExampleBrandVOMeta.SEARCH_VALUE , ExampleBrandVOMeta.SORT_FIELD , ExampleBrandVOMeta.SORT_TYPE , ExampleBrandVOMeta.IDS } )
	@NotNull(name = ExampleBrandVOMeta.ID)
	@SentinelResource(value = ExampleBrandServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleBrandServiceProxy.SAVE)
	public Result save(ExampleBrandVO exampleBrandVO) {
		Result result=exampleBrandService.save(exampleBrandVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取商品品牌
	*/
	@ApiOperation(value = "获取商品品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleBrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ExampleBrandVOMeta.ID)
	@SentinelResource(value = ExampleBrandServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleBrandServiceProxy.GET_BY_ID)
	public Result<ExampleBrand> getById(String id) {
		Result<ExampleBrand> result=new Result<>();
		ExampleBrand exampleBrand=exampleBrandService.getById(id);
		result.success(true).data(exampleBrand);
		return result;
	}


	/**
	 * 批量获取商品品牌 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取商品品牌")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ExampleBrandVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ExampleBrandVOMeta.IDS)
		@SentinelResource(value = ExampleBrandServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleBrandServiceProxy.GET_BY_IDS)
	public Result<List<ExampleBrand>> getByIds(List<String> ids) {
		Result<List<ExampleBrand>> result=new Result<>();
		List<ExampleBrand> list=exampleBrandService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询商品品牌
	*/
	@ApiOperation(value = "查询商品品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleBrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "NBFD"),
		@ApiImplicitParam(name = ExampleBrandVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "宁波富德"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleBrandVOMeta.PAGE_INDEX , ExampleBrandVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ExampleBrandServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleBrandServiceProxy.QUERY_LIST)
	public Result<List<ExampleBrand>> queryList(ExampleBrandVO sample) {
		Result<List<ExampleBrand>> result=new Result<>();
		List<ExampleBrand> list=exampleBrandService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询商品品牌
	*/
	@ApiOperation(value = "分页查询商品品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleBrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "NBFD"),
		@ApiImplicitParam(name = ExampleBrandVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "宁波富德"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ExampleBrandServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleBrandServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ExampleBrand>> queryPagedList(ExampleBrandVO sample) {
		Result<PagedList<ExampleBrand>> result=new Result<>();
		PagedList<ExampleBrand> list=exampleBrandService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ExampleBrandServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleBrandServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ExampleBrandVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=exampleBrandService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ExampleBrandServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleBrandServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=exampleBrandService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ExampleBrandServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleBrandServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=exampleBrandService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}