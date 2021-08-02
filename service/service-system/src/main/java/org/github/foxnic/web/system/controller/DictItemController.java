package org.github.foxnic.web.system.controller;

 
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


import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import org.github.foxnic.web.domain.system.meta.DictItemVOMeta;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
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
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.IDictItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据字典条目 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-02 14:50:54
*/

@Api(tags = "数据字典条目")
@ApiSort(0)
@RestController("SysDictItemController")
public class DictItemController extends SuperController {

	@Autowired
	private IDictItemService dictItemService;

	
	/**
	 * 添加数据字典条目
	*/
	@ApiOperation(value = "添加数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_CODE , value = "字典代码" , required = true , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictItemVOMeta.PARENT_ID , value = "上级条目ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DictItemVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = DictItemVOMeta.LABEL , value = "标签" , required = true , dataTypeClass=String.class , example = "男"),
		@ApiImplicitParam(name = DictItemVOMeta.SORT , value = "排序" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = DictItemVOMeta.ID)
	@NotNull(name = DictItemVOMeta.DICT_ID)
	@NotNull(name = DictItemVOMeta.DICT_CODE)
	@NotNull(name = DictItemVOMeta.CODE)
	@NotNull(name = DictItemVOMeta.LABEL)
	@NotNull(name = DictItemVOMeta.SORT)
	@SentinelResource(value = DictItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictItemServiceProxy.INSERT)
	public Result insert(DictItemVO dictItemVO) {
		Result result=dictItemService.insert(dictItemVO);
		return result;
	}

	
	/**
	 * 删除数据字典条目
	*/
	@ApiOperation(value = "删除数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = DictItemVOMeta.ID)
	@SentinelResource(value = DictItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=dictItemService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除数据字典条目 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = DictItemVOMeta.IDS)
	@SentinelResource(value = DictItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=dictItemService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新数据字典条目
	*/
	@ApiOperation(value = "更新数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_CODE , value = "字典代码" , required = true , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictItemVOMeta.PARENT_ID , value = "上级条目ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DictItemVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = DictItemVOMeta.LABEL , value = "标签" , required = true , dataTypeClass=String.class , example = "男"),
		@ApiImplicitParam(name = DictItemVOMeta.SORT , value = "排序" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { DictItemVOMeta.PAGE_INDEX , DictItemVOMeta.PAGE_SIZE , DictItemVOMeta.SEARCH_FIELD , DictItemVOMeta.FUZZY_FIELD , DictItemVOMeta.SEARCH_VALUE , DictItemVOMeta.SORT_FIELD , DictItemVOMeta.SORT_TYPE , DictItemVOMeta.IDS } ) 
	@NotNull(name = DictItemVOMeta.ID)
	@NotNull(name = DictItemVOMeta.DICT_ID)
	@NotNull(name = DictItemVOMeta.DICT_CODE)
	@NotNull(name = DictItemVOMeta.CODE)
	@NotNull(name = DictItemVOMeta.LABEL)
	@NotNull(name = DictItemVOMeta.SORT)
	@SentinelResource(value = DictItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictItemServiceProxy.UPDATE)
	public Result update(DictItemVO dictItemVO) {
		Result result=dictItemService.update(dictItemVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存数据字典条目
	*/
	@ApiOperation(value = "保存数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_CODE , value = "字典代码" , required = true , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictItemVOMeta.PARENT_ID , value = "上级条目ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DictItemVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = DictItemVOMeta.LABEL , value = "标签" , required = true , dataTypeClass=String.class , example = "男"),
		@ApiImplicitParam(name = DictItemVOMeta.SORT , value = "排序" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DictItemVOMeta.PAGE_INDEX , DictItemVOMeta.PAGE_SIZE , DictItemVOMeta.SEARCH_FIELD , DictItemVOMeta.FUZZY_FIELD , DictItemVOMeta.SEARCH_VALUE , DictItemVOMeta.SORT_FIELD , DictItemVOMeta.SORT_TYPE , DictItemVOMeta.IDS } )
	@NotNull(name = DictItemVOMeta.ID)
	@NotNull(name = DictItemVOMeta.DICT_ID)
	@NotNull(name = DictItemVOMeta.DICT_CODE)
	@NotNull(name = DictItemVOMeta.CODE)
	@NotNull(name = DictItemVOMeta.LABEL)
	@NotNull(name = DictItemVOMeta.SORT)
	@SentinelResource(value = DictItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictItemServiceProxy.SAVE)
	public Result save(DictItemVO dictItemVO) {
		Result result=dictItemService.save(dictItemVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取数据字典条目
	*/
	@ApiOperation(value = "获取数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = DictItemVOMeta.ID)
	@SentinelResource(value = DictItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictItemServiceProxy.GET_BY_ID)
	public Result<DictItem> getById(String id) {
		Result<DictItem> result=new Result<>();
		DictItem dictItem=dictItemService.getById(id);
		result.success(true).data(dictItem);
		return result;
	}


	/**
	 * 批量删除数据字典条目 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除数据字典条目")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DictItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = DictItemVOMeta.IDS)
		@SentinelResource(value = DictItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictItemServiceProxy.GET_BY_IDS)
	public Result<List<DictItem>> getByIds(List<String> ids) {
		Result<List<DictItem>> result=new Result<>();
		List<DictItem> list=dictItemService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询数据字典条目
	*/
	@ApiOperation(value = "查询数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_CODE , value = "字典代码" , required = true , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictItemVOMeta.PARENT_ID , value = "上级条目ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DictItemVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = DictItemVOMeta.LABEL , value = "标签" , required = true , dataTypeClass=String.class , example = "男"),
		@ApiImplicitParam(name = DictItemVOMeta.SORT , value = "排序" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DictItemVOMeta.PAGE_INDEX , DictItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DictItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictItemServiceProxy.QUERY_LIST)
	public Result<List<DictItem>> queryList(DictItemVO sample) {
		Result<List<DictItem>> result=new Result<>();
		List<DictItem> list=dictItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询数据字典条目
	*/
	@ApiOperation(value = "分页查询数据字典条目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictItemVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictItemVOMeta.DICT_CODE , value = "字典代码" , required = true , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictItemVOMeta.PARENT_ID , value = "上级条目ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DictItemVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = DictItemVOMeta.LABEL , value = "标签" , required = true , dataTypeClass=String.class , example = "男"),
		@ApiImplicitParam(name = DictItemVOMeta.SORT , value = "排序" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = DictItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DictItem>> queryPagedList(DictItemVO sample) {
		Result<PagedList<DictItem>> result=new Result<>();
		PagedList<DictItem> list=dictItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = DictItemServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(DictItemServiceProxy.EXPORT_EXCEL)
	public void exportExcel(DictItemVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=dictItemService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = DictItemServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(DictItemServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=dictItemService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = DictItemServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(DictItemServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=dictItemService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}