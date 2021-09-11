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
import org.github.foxnic.web.domain.system.Sequence;
import org.github.foxnic.web.domain.system.SequenceVO;
import org.github.foxnic.web.domain.system.meta.SequenceVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.system.SequenceServiceProxy;
import org.github.foxnic.web.system.service.ISequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 序列表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-11 15:59:19
 * @version
*/

@Api(tags = "序列")
@ApiSort(0)
@RestController("SysSequenceController")
public class SequenceController extends SuperController {

	@Autowired
	private ISequenceService sequenceService;

	
	/**
	 * 添加序列
	*/
	@ApiOperation(value = "添加序列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SequenceVOMeta.PK , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SequenceVOMeta.ID , value = "序列ID" , required = true , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = SequenceVOMeta.NAME , value = "序列名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.LENGTH , value = "编码长度" , required = false , dataTypeClass=Integer.class , example = "5"),
		@ApiImplicitParam(name = SequenceVOMeta.CATALOG , value = "编码分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.VALUE , value = "当前数值" , required = false , dataTypeClass=Long.class , example = "12"),
		@ApiImplicitParam(name = SequenceVOMeta.MEMO , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class , example = "AI"),
		@ApiImplicitParam(name = SequenceVOMeta.FETCH_SIZE , value = "每次取数的个数" , required = true , dataTypeClass=Integer.class , example = "4"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = SequenceVOMeta.PK)
	@NotNull(name = SequenceVOMeta.ID)
	@NotNull(name = SequenceVOMeta.FETCH_SIZE)
	@SentinelResource(value = SequenceServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SequenceServiceProxy.INSERT)
	public Result insert(SequenceVO sequenceVO) {
		Result result=sequenceService.insert(sequenceVO);
		return result;
	}

	
	/**
	 * 删除序列
	*/
	@ApiOperation(value = "删除序列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SequenceVOMeta.PK , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = SequenceVOMeta.PK)
	@SentinelResource(value = SequenceServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SequenceServiceProxy.DELETE)
	public Result deleteById(String pk) {
		Result result=sequenceService.deleteByIdPhysical(pk);
		return result;
	}
	
	
	/**
	 * 批量删除序列 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除序列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SequenceVOMeta.PKS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = SequenceVOMeta.PKS)
	@SentinelResource(value = SequenceServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SequenceServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> pks) {
		Result result=sequenceService.deleteByIdsLogical(pks);
		return result;
	}
	
	/**
	 * 更新序列
	*/
	@ApiOperation(value = "更新序列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SequenceVOMeta.PK , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SequenceVOMeta.ID , value = "序列ID" , required = true , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = SequenceVOMeta.NAME , value = "序列名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.LENGTH , value = "编码长度" , required = false , dataTypeClass=Integer.class , example = "5"),
		@ApiImplicitParam(name = SequenceVOMeta.CATALOG , value = "编码分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.VALUE , value = "当前数值" , required = false , dataTypeClass=Long.class , example = "12"),
		@ApiImplicitParam(name = SequenceVOMeta.MEMO , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class , example = "AI"),
		@ApiImplicitParam(name = SequenceVOMeta.FETCH_SIZE , value = "每次取数的个数" , required = true , dataTypeClass=Integer.class , example = "4"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { SequenceVOMeta.PAGE_INDEX , SequenceVOMeta.PAGE_SIZE , SequenceVOMeta.SEARCH_FIELD , SequenceVOMeta.FUZZY_FIELD , SequenceVOMeta.SEARCH_VALUE , SequenceVOMeta.SORT_FIELD , SequenceVOMeta.SORT_TYPE , SequenceVOMeta.PKS } ) 
	@NotNull(name = SequenceVOMeta.PK)
	@NotNull(name = SequenceVOMeta.ID)
	@NotNull(name = SequenceVOMeta.FETCH_SIZE)
	@SentinelResource(value = SequenceServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SequenceServiceProxy.UPDATE)
	public Result update(SequenceVO sequenceVO) {
		Result result=sequenceService.update(sequenceVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存序列
	*/
	@ApiOperation(value = "保存序列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SequenceVOMeta.PK , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SequenceVOMeta.ID , value = "序列ID" , required = true , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = SequenceVOMeta.NAME , value = "序列名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.LENGTH , value = "编码长度" , required = false , dataTypeClass=Integer.class , example = "5"),
		@ApiImplicitParam(name = SequenceVOMeta.CATALOG , value = "编码分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.VALUE , value = "当前数值" , required = false , dataTypeClass=Long.class , example = "12"),
		@ApiImplicitParam(name = SequenceVOMeta.MEMO , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class , example = "AI"),
		@ApiImplicitParam(name = SequenceVOMeta.FETCH_SIZE , value = "每次取数的个数" , required = true , dataTypeClass=Integer.class , example = "4"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SequenceVOMeta.PAGE_INDEX , SequenceVOMeta.PAGE_SIZE , SequenceVOMeta.SEARCH_FIELD , SequenceVOMeta.FUZZY_FIELD , SequenceVOMeta.SEARCH_VALUE , SequenceVOMeta.SORT_FIELD , SequenceVOMeta.SORT_TYPE , SequenceVOMeta.PKS } )
	@NotNull(name = SequenceVOMeta.PK)
	@NotNull(name = SequenceVOMeta.ID)
	@NotNull(name = SequenceVOMeta.FETCH_SIZE)
	@SentinelResource(value = SequenceServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SequenceServiceProxy.SAVE)
	public Result save(SequenceVO sequenceVO) {
		Result result=sequenceService.save(sequenceVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取序列
	*/
	@ApiOperation(value = "获取序列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SequenceVOMeta.PK , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = SequenceVOMeta.PK)
	@SentinelResource(value = SequenceServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SequenceServiceProxy.GET_BY_ID)
	public Result<Sequence> getById(String pk) {
		Result<Sequence> result=new Result<>();
		Sequence sequence=sequenceService.getById(pk);
		result.success(true).data(sequence);
		return result;
	}


	/**
	 * 批量删除序列 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除序列")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SequenceVOMeta.PKS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = SequenceVOMeta.PKS)
		@SentinelResource(value = SequenceServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SequenceServiceProxy.GET_BY_IDS)
	public Result<List<Sequence>> getByIds(List<String> pks) {
		Result<List<Sequence>> result=new Result<>();
		List<Sequence> list=sequenceService.getByIds(pks);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询序列
	*/
	@ApiOperation(value = "查询序列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SequenceVOMeta.PK , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SequenceVOMeta.ID , value = "序列ID" , required = true , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = SequenceVOMeta.NAME , value = "序列名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.LENGTH , value = "编码长度" , required = false , dataTypeClass=Integer.class , example = "5"),
		@ApiImplicitParam(name = SequenceVOMeta.CATALOG , value = "编码分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.VALUE , value = "当前数值" , required = false , dataTypeClass=Long.class , example = "12"),
		@ApiImplicitParam(name = SequenceVOMeta.MEMO , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class , example = "AI"),
		@ApiImplicitParam(name = SequenceVOMeta.FETCH_SIZE , value = "每次取数的个数" , required = true , dataTypeClass=Integer.class , example = "4"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SequenceVOMeta.PAGE_INDEX , SequenceVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SequenceServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SequenceServiceProxy.QUERY_LIST)
	public Result<List<Sequence>> queryList(SequenceVO sample) {
		Result<List<Sequence>> result=new Result<>();
		List<Sequence> list=sequenceService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询序列
	*/
	@ApiOperation(value = "分页查询序列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SequenceVOMeta.PK , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SequenceVOMeta.ID , value = "序列ID" , required = true , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = SequenceVOMeta.NAME , value = "序列名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.LENGTH , value = "编码长度" , required = false , dataTypeClass=Integer.class , example = "5"),
		@ApiImplicitParam(name = SequenceVOMeta.CATALOG , value = "编码分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.VALUE , value = "当前数值" , required = false , dataTypeClass=Long.class , example = "12"),
		@ApiImplicitParam(name = SequenceVOMeta.MEMO , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SequenceVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class , example = "AI"),
		@ApiImplicitParam(name = SequenceVOMeta.FETCH_SIZE , value = "每次取数的个数" , required = true , dataTypeClass=Integer.class , example = "4"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = SequenceServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SequenceServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Sequence>> queryPagedList(SequenceVO sample) {

		sequenceService.dao().getSequence("test-2").next();

		Result<PagedList<Sequence>> result=new Result<>();
		PagedList<Sequence> list=sequenceService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = SequenceServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SequenceServiceProxy.EXPORT_EXCEL)
	public void exportExcel(SequenceVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=sequenceService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = SequenceServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SequenceServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=sequenceService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = SequenceServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SequenceServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=sequenceService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}