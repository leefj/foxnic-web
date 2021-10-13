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


import org.github.foxnic.web.proxy.dataperm.RuleServiceProxy;
import org.github.foxnic.web.domain.dataperm.meta.RuleVOMeta;
import org.github.foxnic.web.domain.dataperm.Rule;
import org.github.foxnic.web.domain.dataperm.RuleVO;
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
import org.github.foxnic.web.domain.dataperm.meta.RuleMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.dataperm.service.IRuleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据权限规则表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-13 15:51:45
*/

@Api(tags = "数据权限规则")
@ApiSort(0)
@RestController("DpRuleController")
public class RuleController extends SuperController {

	@Autowired
	private IRuleService ruleService;


	/**
	 * 添加数据权限规则
	*/
	@ApiOperation(value = "添加数据权限规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.DATA_TABLE , value = "数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RuleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleServiceProxy.INSERT)
	public Result insert(RuleVO ruleVO) {
		Result result=ruleService.insert(ruleVO);
		return result;
	}



	/**
	 * 删除数据权限规则
	*/
	@ApiOperation(value = "删除数据权限规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RuleVOMeta.ID)
	@SentinelResource(value = RuleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=ruleService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据权限规则 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据权限规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RuleVOMeta.IDS)
	@SentinelResource(value = RuleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=ruleService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新数据权限规则
	*/
	@ApiOperation(value = "更新数据权限规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.DATA_TABLE , value = "数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RuleVOMeta.PAGE_INDEX , RuleVOMeta.PAGE_SIZE , RuleVOMeta.SEARCH_FIELD , RuleVOMeta.FUZZY_FIELD , RuleVOMeta.SEARCH_VALUE , RuleVOMeta.SORT_FIELD , RuleVOMeta.SORT_TYPE , RuleVOMeta.IDS } )
	@NotNull(name = RuleVOMeta.ID)
	@SentinelResource(value = RuleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleServiceProxy.UPDATE)
	public Result update(RuleVO ruleVO) {
		Result result=ruleService.update(ruleVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存数据权限规则
	*/
	@ApiOperation(value = "保存数据权限规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.DATA_TABLE , value = "数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RuleVOMeta.PAGE_INDEX , RuleVOMeta.PAGE_SIZE , RuleVOMeta.SEARCH_FIELD , RuleVOMeta.FUZZY_FIELD , RuleVOMeta.SEARCH_VALUE , RuleVOMeta.SORT_FIELD , RuleVOMeta.SORT_TYPE , RuleVOMeta.IDS } )
	@NotNull(name = RuleVOMeta.ID)
	@SentinelResource(value = RuleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleServiceProxy.SAVE)
	public Result save(RuleVO ruleVO) {
		Result result=ruleService.save(ruleVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取数据权限规则
	*/
	@ApiOperation(value = "获取数据权限规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RuleVOMeta.ID)
	@SentinelResource(value = RuleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleServiceProxy.GET_BY_ID)
	public Result<Rule> getById(String id) {
		Result<Rule> result=new Result<>();
		Rule rule=ruleService.getById(id);
		result.success(true).data(rule);
		return result;
	}


	/**
	 * 批量获取数据权限规则 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据权限规则")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RuleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RuleVOMeta.IDS)
		@SentinelResource(value = RuleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleServiceProxy.GET_BY_IDS)
	public Result<List<Rule>> getByIds(List<String> ids) {
		Result<List<Rule>> result=new Result<>();
		List<Rule> list=ruleService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据权限规则
	*/
	@ApiOperation(value = "查询数据权限规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.DATA_TABLE , value = "数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RuleVOMeta.PAGE_INDEX , RuleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RuleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleServiceProxy.QUERY_LIST)
	public Result<List<Rule>> queryList(RuleVO sample) {
		Result<List<Rule>> result=new Result<>();
		List<Rule> list=ruleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据权限规则
	*/
	@ApiOperation(value = "分页查询数据权限规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.DATA_TABLE , value = "数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RuleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Rule>> queryPagedList(RuleVO sample) {
		Result<PagedList<Rule>> result=new Result<>();
		PagedList<Rule> list=ruleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RuleServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RuleServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RuleVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=ruleService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RuleServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RuleServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=ruleService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = RuleServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RuleServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=ruleService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}