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


import org.github.foxnic.web.proxy.dataperm.ExampleShopServiceProxy;
import org.github.foxnic.web.domain.dataperm.meta.ExampleShopVOMeta;
import org.github.foxnic.web.domain.dataperm.ExampleShop;
import org.github.foxnic.web.domain.dataperm.ExampleShopVO;
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
import org.github.foxnic.web.domain.dataperm.meta.ExampleShopMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.dataperm.service.IExampleShopService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 销售门店表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-28 10:00:48
*/

@Api(tags = "销售门店")
@ApiSort(0)
@RestController("DpExampleShopController")
public class ExampleShopController extends SuperController {

	@Autowired
	private IExampleShopService exampleShopService;


	/**
	 * 添加销售门店
	*/
	@ApiOperation(value = "添加销售门店")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleShopVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "HF1D"),
		@ApiImplicitParam(name = ExampleShopVOMeta.ORG_ID , value = "上级ID" , required = false , dataTypeClass=String.class , example = "500997394683400193"),
		@ApiImplicitParam(name = ExampleShopVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "合肥一店"),
		@ApiImplicitParam(name = ExampleShopVOMeta.FLAG , value = "是否旗舰店" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ExampleShopServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleShopServiceProxy.INSERT)
	public Result insert(ExampleShopVO exampleShopVO) {
		Result result=exampleShopService.insert(exampleShopVO,false);
		return result;
	}



	/**
	 * 删除销售门店
	*/
	@ApiOperation(value = "删除销售门店")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleShopVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "HF1D")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ExampleShopVOMeta.ID)
	@SentinelResource(value = ExampleShopServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleShopServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=exampleShopService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除销售门店 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除销售门店")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleShopVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ExampleShopVOMeta.IDS)
	@SentinelResource(value = ExampleShopServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleShopServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=exampleShopService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新销售门店
	*/
	@ApiOperation(value = "更新销售门店")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleShopVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "HF1D"),
		@ApiImplicitParam(name = ExampleShopVOMeta.ORG_ID , value = "上级ID" , required = false , dataTypeClass=String.class , example = "500997394683400193"),
		@ApiImplicitParam(name = ExampleShopVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "合肥一店"),
		@ApiImplicitParam(name = ExampleShopVOMeta.FLAG , value = "是否旗舰店" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ExampleShopVOMeta.PAGE_INDEX , ExampleShopVOMeta.PAGE_SIZE , ExampleShopVOMeta.SEARCH_FIELD , ExampleShopVOMeta.FUZZY_FIELD , ExampleShopVOMeta.SEARCH_VALUE , ExampleShopVOMeta.SORT_FIELD , ExampleShopVOMeta.SORT_TYPE , ExampleShopVOMeta.IDS } )
	@NotNull(name = ExampleShopVOMeta.ID)
	@SentinelResource(value = ExampleShopServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleShopServiceProxy.UPDATE)
	public Result update(ExampleShopVO exampleShopVO) {
		Result result=exampleShopService.update(exampleShopVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存销售门店
	*/
	@ApiOperation(value = "保存销售门店")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleShopVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "HF1D"),
		@ApiImplicitParam(name = ExampleShopVOMeta.ORG_ID , value = "上级ID" , required = false , dataTypeClass=String.class , example = "500997394683400193"),
		@ApiImplicitParam(name = ExampleShopVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "合肥一店"),
		@ApiImplicitParam(name = ExampleShopVOMeta.FLAG , value = "是否旗舰店" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleShopVOMeta.PAGE_INDEX , ExampleShopVOMeta.PAGE_SIZE , ExampleShopVOMeta.SEARCH_FIELD , ExampleShopVOMeta.FUZZY_FIELD , ExampleShopVOMeta.SEARCH_VALUE , ExampleShopVOMeta.SORT_FIELD , ExampleShopVOMeta.SORT_TYPE , ExampleShopVOMeta.IDS } )
	@NotNull(name = ExampleShopVOMeta.ID)
	@SentinelResource(value = ExampleShopServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleShopServiceProxy.SAVE)
	public Result save(ExampleShopVO exampleShopVO) {
		Result result=exampleShopService.save(exampleShopVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取销售门店
	*/
	@ApiOperation(value = "获取销售门店")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleShopVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ExampleShopVOMeta.ID)
	@SentinelResource(value = ExampleShopServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleShopServiceProxy.GET_BY_ID)
	public Result<ExampleShop> getById(String id) {
		Result<ExampleShop> result=new Result<>();
		ExampleShop exampleShop=exampleShopService.getById(id);

		// join 关联的对象
		exampleShopService.dao().fill(exampleShop)
			.execute();

		result.success(true).data(exampleShop);
		return result;
	}


	/**
	 * 批量获取销售门店 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取销售门店")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ExampleShopVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ExampleShopVOMeta.IDS)
		@SentinelResource(value = ExampleShopServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleShopServiceProxy.GET_BY_IDS)
	public Result<List<ExampleShop>> getByIds(List<String> ids) {
		Result<List<ExampleShop>> result=new Result<>();
		List<ExampleShop> list=exampleShopService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询销售门店
	*/
	@ApiOperation(value = "查询销售门店")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleShopVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "HF1D"),
		@ApiImplicitParam(name = ExampleShopVOMeta.ORG_ID , value = "上级ID" , required = false , dataTypeClass=String.class , example = "500997394683400193"),
		@ApiImplicitParam(name = ExampleShopVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "合肥一店"),
		@ApiImplicitParam(name = ExampleShopVOMeta.FLAG , value = "是否旗舰店" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ExampleShopVOMeta.PAGE_INDEX , ExampleShopVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ExampleShopServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleShopServiceProxy.QUERY_LIST)
	public Result<List<ExampleShop>> queryList(ExampleShopVO sample) {
		Result<List<ExampleShop>> result=new Result<>();
		List<ExampleShop> list=exampleShopService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询销售门店
	*/
	@ApiOperation(value = "分页查询销售门店")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ExampleShopVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "HF1D"),
		@ApiImplicitParam(name = ExampleShopVOMeta.ORG_ID , value = "上级ID" , required = false , dataTypeClass=String.class , example = "500997394683400193"),
		@ApiImplicitParam(name = ExampleShopVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "合肥一店"),
		@ApiImplicitParam(name = ExampleShopVOMeta.FLAG , value = "是否旗舰店" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ExampleShopServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ExampleShopServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ExampleShop>> queryPagedList(ExampleShopVO sample) {
		Result<PagedList<ExampleShop>> result=new Result<>();
		PagedList<ExampleShop> list=exampleShopService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		exampleShopService.dao().fill(list)
			.execute();

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ExampleShopServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleShopServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ExampleShopVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=exampleShopService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ExampleShopServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleShopServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=exampleShopService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ExampleShopServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ExampleShopServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=exampleShopService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}