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


import org.github.foxnic.web.proxy.dataperm.RuleRangeServiceProxy;
import org.github.foxnic.web.domain.dataperm.meta.RuleRangeVOMeta;
import org.github.foxnic.web.domain.dataperm.RuleRange;
import org.github.foxnic.web.domain.dataperm.RuleRangeVO;
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
import org.github.foxnic.web.domain.dataperm.meta.RuleRangeMeta;
import org.github.foxnic.web.domain.dataperm.RuleCondition;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.dataperm.service.IRuleRangeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据权限规则范围表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-14 16:24:45
*/

@Api(tags = "数据权限规则范围")
@ApiSort(0)
@RestController("DpRuleRangeController")
public class RuleRangeController extends SuperController {

	@Autowired
	private IRuleRangeService ruleRangeService;


	/**
	 * 添加数据权限规则范围
	*/
	@ApiOperation(value = "添加数据权限规则范围")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleRangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.RULE_ID , value = "规则ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RuleRangeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleRangeServiceProxy.INSERT)
	public Result insert(RuleRangeVO ruleRangeVO) {
		Result result=ruleRangeService.insert(ruleRangeVO);
		return result;
	}



	/**
	 * 删除数据权限规则范围
	*/
	@ApiOperation(value = "删除数据权限规则范围")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleRangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RuleRangeVOMeta.ID)
	@SentinelResource(value = RuleRangeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleRangeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=ruleRangeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据权限规则范围 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据权限规则范围")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleRangeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RuleRangeVOMeta.IDS)
	@SentinelResource(value = RuleRangeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleRangeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=ruleRangeService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新数据权限规则范围
	*/
	@ApiOperation(value = "更新数据权限规则范围")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleRangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.RULE_ID , value = "规则ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RuleRangeVOMeta.PAGE_INDEX , RuleRangeVOMeta.PAGE_SIZE , RuleRangeVOMeta.SEARCH_FIELD , RuleRangeVOMeta.FUZZY_FIELD , RuleRangeVOMeta.SEARCH_VALUE , RuleRangeVOMeta.SORT_FIELD , RuleRangeVOMeta.SORT_TYPE , RuleRangeVOMeta.IDS } )
	@NotNull(name = RuleRangeVOMeta.ID)
	@SentinelResource(value = RuleRangeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleRangeServiceProxy.UPDATE)
	public Result update(RuleRangeVO ruleRangeVO) {
		Result result=ruleRangeService.update(ruleRangeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存数据权限规则范围
	*/
	@ApiOperation(value = "保存数据权限规则范围")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleRangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.RULE_ID , value = "规则ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RuleRangeVOMeta.PAGE_INDEX , RuleRangeVOMeta.PAGE_SIZE , RuleRangeVOMeta.SEARCH_FIELD , RuleRangeVOMeta.FUZZY_FIELD , RuleRangeVOMeta.SEARCH_VALUE , RuleRangeVOMeta.SORT_FIELD , RuleRangeVOMeta.SORT_TYPE , RuleRangeVOMeta.IDS } )
	@NotNull(name = RuleRangeVOMeta.ID)
	@SentinelResource(value = RuleRangeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleRangeServiceProxy.SAVE)
	public Result save(RuleRangeVO ruleRangeVO) {
		Result result=ruleRangeService.save(ruleRangeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取数据权限规则范围
	*/
	@ApiOperation(value = "获取数据权限规则范围")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleRangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RuleRangeVOMeta.ID)
	@SentinelResource(value = RuleRangeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleRangeServiceProxy.GET_BY_ID)
	public Result<RuleRange> getById(String id) {
		Result<RuleRange> result=new Result<>();
		RuleRange ruleRange=ruleRangeService.getById(id);
		result.success(true).data(ruleRange);
		return result;
	}


	/**
	 * 批量获取数据权限规则范围 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据权限规则范围")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RuleRangeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RuleRangeVOMeta.IDS)
		@SentinelResource(value = RuleRangeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleRangeServiceProxy.GET_BY_IDS)
	public Result<List<RuleRange>> getByIds(List<String> ids) {
		Result<List<RuleRange>> result=new Result<>();
		List<RuleRange> list=ruleRangeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据权限规则范围
	*/
	@ApiOperation(value = "查询数据权限规则范围")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleRangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.RULE_ID , value = "规则ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RuleRangeVOMeta.PAGE_INDEX , RuleRangeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RuleRangeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleRangeServiceProxy.QUERY_LIST)
	public Result<List<RuleRange>> queryList(RuleRangeVO sample) {
		Result<List<RuleRange>> result=new Result<>();
		List<RuleRange> list=ruleRangeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据权限规则范围
	*/
	@ApiOperation(value = "分页查询数据权限规则范围")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleRangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.RULE_ID , value = "规则ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleRangeVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RuleRangeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleRangeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RuleRange>> queryPagedList(RuleRangeVO sample) {
		Result<PagedList<RuleRange>> result=new Result<>();
		PagedList<RuleRange> list=ruleRangeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RuleRangeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RuleRangeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RuleRangeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=ruleRangeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RuleRangeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RuleRangeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=ruleRangeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = RuleRangeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RuleRangeServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=ruleRangeService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}