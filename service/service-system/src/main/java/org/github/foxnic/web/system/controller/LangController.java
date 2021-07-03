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
import org.github.foxnic.web.domain.system.Lang;
import org.github.foxnic.web.domain.system.LangVO;
import org.github.foxnic.web.domain.system.meta.LangVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.system.LangServiceProxy;
import org.github.foxnic.web.system.service.ILangService;
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
 * 语言条目表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-17 11:58:03
*/

@Api(tags = "语言条目")
@ApiSort(0)
@RestController("SysLangController")
public class LangController extends SuperController {

	@Autowired
	private ILangService langService;

	
	/**
	 * 添加语言条目
	*/
	@ApiOperation(value = "添加语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "编码键" , required = true , dataTypeClass=String.class , example = "01-b0ed30300c-7d2e"),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS , value = "默认" , required = false , dataTypeClass=String.class , example = "批次号"),
		@ApiImplicitParam(name = LangVOMeta.ZH_CH , value = "简体中文(大陆)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW , value = "繁体中文(台湾)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US , value = "英文美国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_UK , value = "英文英国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE , value = "混淆专用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "true"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = LangVOMeta.CODE)
	@SentinelResource(value = LangServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LangServiceProxy.INSERT)
	public Result insert(LangVO langVO) {
		Result result=langService.insert(langVO);
		return result;
	}

	
	/**
	 * 删除语言条目
	*/
	@ApiOperation(value = "删除语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "编码键" , required = true , dataTypeClass=String.class , example = "01-b0ed30300c-7d2e"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = LangVOMeta.CODE)
	@SentinelResource(value = LangServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LangServiceProxy.DELETE)
	public Result<Lang> deleteById(String code) {
		Result<Lang> result=new Result<>();
		boolean suc=langService.deleteByIdLogical(code);
		result.success(suc);
		if(!suc) result.message("数据删除失败");
		return result;
	}
	
	
	/**
	 * 批量删除语言条目 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODES , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = LangVOMeta.CODES)
	@SentinelResource(value = LangServiceProxy.BATCH_DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LangServiceProxy.BATCH_DELETE)
	public Result deleteByIds(List<String> codes) {
		Result result=langService.deleteByIdsLogical(codes);
		return result;
	}
	
	/**
	 * 更新语言条目
	*/
	@ApiOperation(value = "更新语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "编码键" , required = true , dataTypeClass=String.class , example = "01-b0ed30300c-7d2e"),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS , value = "默认" , required = false , dataTypeClass=String.class , example = "批次号"),
		@ApiImplicitParam(name = LangVOMeta.ZH_CH , value = "简体中文(大陆)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW , value = "繁体中文(台湾)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US , value = "英文美国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_UK , value = "英文英国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE , value = "混淆专用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "true"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { LangVOMeta.PAGE_INDEX , LangVOMeta.PAGE_SIZE , LangVOMeta.SEARCH_FIELD , LangVOMeta.SEARCH_VALUE , LangVOMeta.SORT_FIELD , LangVOMeta.SORT_TYPE , LangVOMeta.CODES } ) 
	@NotNull(name = LangVOMeta.CODE)
	@SentinelResource(value = LangServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LangServiceProxy.UPDATE)
	public Result update(LangVO langVO) {
		Result result=langService.update(langVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存语言条目
	*/
	@ApiOperation(value = "保存语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "编码键" , required = true , dataTypeClass=String.class , example = "01-b0ed30300c-7d2e"),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS , value = "默认" , required = false , dataTypeClass=String.class , example = "批次号"),
		@ApiImplicitParam(name = LangVOMeta.ZH_CH , value = "简体中文(大陆)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW , value = "繁体中文(台湾)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US , value = "英文美国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_UK , value = "英文英国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE , value = "混淆专用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "true"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { LangVOMeta.PAGE_INDEX , LangVOMeta.PAGE_SIZE , LangVOMeta.SEARCH_FIELD , LangVOMeta.SEARCH_VALUE , LangVOMeta.SORT_FIELD , LangVOMeta.SORT_TYPE , LangVOMeta.CODES } )
	@NotNull(name = LangVOMeta.CODE)
	@SentinelResource(value = LangServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LangServiceProxy.SAVE)
	public Result save(LangVO langVO) {
		Result result=langService.save(langVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取语言条目
	*/
	@ApiOperation(value = "获取语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = LangVOMeta.CODE)
	@SentinelResource(value = LangServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LangServiceProxy.GET_BY_ID)
	public Result<Lang> getById(String code) {
		Result<Lang> result=new Result<>();
		Lang role=langService.getById(code);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询语言条目
	*/
	@ApiOperation(value = "查询语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "编码键" , required = true , dataTypeClass=String.class , example = "01-b0ed30300c-7d2e"),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS , value = "默认" , required = false , dataTypeClass=String.class , example = "批次号"),
		@ApiImplicitParam(name = LangVOMeta.ZH_CH , value = "简体中文(大陆)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW , value = "繁体中文(台湾)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US , value = "英文美国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_UK , value = "英文英国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE , value = "混淆专用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "true"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { LangVOMeta.PAGE_INDEX , LangVOMeta.PAGE_SIZE } )
	@SentinelResource(value = LangServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LangServiceProxy.QUERY_LIST)
	public Result<List<Lang>> queryList(LangVO sample) {
		Result<List<Lang>> result=new Result<>();
		List<Lang> list=langService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询语言条目
	*/
	@ApiOperation(value = "分页查询语言条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE , value = "编码键" , required = true , dataTypeClass=String.class , example = "01-b0ed30300c-7d2e"),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS , value = "默认" , required = false , dataTypeClass=String.class , example = "批次号"),
		@ApiImplicitParam(name = LangVOMeta.ZH_CH , value = "简体中文(大陆)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW , value = "繁体中文(台湾)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US , value = "英文美国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_UK , value = "英文英国" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE , value = "混淆专用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class , example = "true"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = LangServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LangServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Lang>> queryPagedList(LangVO sample) {
		Result<PagedList<Lang>> result=new Result<>();
		PagedList<Lang> list=langService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = LangServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(LangServiceProxy.EXPORT_EXCEL)
	public void exportExcel(LangVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=langService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = LangServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(LangServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=langService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = LangServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(LangServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=langService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}