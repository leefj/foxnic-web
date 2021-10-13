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


import org.github.foxnic.web.proxy.dataperm.RuleConditionServiceProxy;
import org.github.foxnic.web.domain.dataperm.meta.RuleConditionVOMeta;
import org.github.foxnic.web.domain.dataperm.RuleCondition;
import org.github.foxnic.web.domain.dataperm.RuleConditionVO;
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
import org.github.foxnic.web.domain.dataperm.meta.RuleConditionMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.dataperm.service.IRuleConditionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据权限规则范围条件表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-13 15:51:46
*/

@Api(tags = "数据权限规则范围条件")
@ApiSort(0)
@RestController("DpRuleConditionController")
public class RuleConditionController extends SuperController {

	@Autowired
	private IRuleConditionService ruleConditionService;


	/**
	 * 添加数据权限规则范围条件
	*/
	@ApiOperation(value = "添加数据权限规则范围条件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleConditionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.RANGE_ID , value = "range" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.DATA_TABLE , value = "数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.EXPR_TYPE , value = "表达式类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.LOGIC , value = "逻辑关系可选值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RuleConditionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleConditionServiceProxy.INSERT)
	public Result insert(RuleConditionVO ruleConditionVO) {
		Result result=ruleConditionService.insert(ruleConditionVO);
		return result;
	}



	/**
	 * 删除数据权限规则范围条件
	*/
	@ApiOperation(value = "删除数据权限规则范围条件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleConditionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RuleConditionVOMeta.ID)
	@SentinelResource(value = RuleConditionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleConditionServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=ruleConditionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据权限规则范围条件 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据权限规则范围条件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleConditionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RuleConditionVOMeta.IDS)
	@SentinelResource(value = RuleConditionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleConditionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=ruleConditionService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新数据权限规则范围条件
	*/
	@ApiOperation(value = "更新数据权限规则范围条件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleConditionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.RANGE_ID , value = "range" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.DATA_TABLE , value = "数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.EXPR_TYPE , value = "表达式类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.LOGIC , value = "逻辑关系可选值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RuleConditionVOMeta.PAGE_INDEX , RuleConditionVOMeta.PAGE_SIZE , RuleConditionVOMeta.SEARCH_FIELD , RuleConditionVOMeta.FUZZY_FIELD , RuleConditionVOMeta.SEARCH_VALUE , RuleConditionVOMeta.SORT_FIELD , RuleConditionVOMeta.SORT_TYPE , RuleConditionVOMeta.IDS } )
	@NotNull(name = RuleConditionVOMeta.ID)
	@SentinelResource(value = RuleConditionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleConditionServiceProxy.UPDATE)
	public Result update(RuleConditionVO ruleConditionVO) {
		Result result=ruleConditionService.update(ruleConditionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存数据权限规则范围条件
	*/
	@ApiOperation(value = "保存数据权限规则范围条件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleConditionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.RANGE_ID , value = "range" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.DATA_TABLE , value = "数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.EXPR_TYPE , value = "表达式类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.LOGIC , value = "逻辑关系可选值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RuleConditionVOMeta.PAGE_INDEX , RuleConditionVOMeta.PAGE_SIZE , RuleConditionVOMeta.SEARCH_FIELD , RuleConditionVOMeta.FUZZY_FIELD , RuleConditionVOMeta.SEARCH_VALUE , RuleConditionVOMeta.SORT_FIELD , RuleConditionVOMeta.SORT_TYPE , RuleConditionVOMeta.IDS } )
	@NotNull(name = RuleConditionVOMeta.ID)
	@SentinelResource(value = RuleConditionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleConditionServiceProxy.SAVE)
	public Result save(RuleConditionVO ruleConditionVO) {
		Result result=ruleConditionService.save(ruleConditionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取数据权限规则范围条件
	*/
	@ApiOperation(value = "获取数据权限规则范围条件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleConditionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RuleConditionVOMeta.ID)
	@SentinelResource(value = RuleConditionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleConditionServiceProxy.GET_BY_ID)
	public Result<RuleCondition> getById(String id) {
		Result<RuleCondition> result=new Result<>();
		RuleCondition ruleCondition=ruleConditionService.getById(id);
		result.success(true).data(ruleCondition);
		return result;
	}


	/**
	 * 批量获取数据权限规则范围条件 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据权限规则范围条件")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RuleConditionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RuleConditionVOMeta.IDS)
		@SentinelResource(value = RuleConditionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleConditionServiceProxy.GET_BY_IDS)
	public Result<List<RuleCondition>> getByIds(List<String> ids) {
		Result<List<RuleCondition>> result=new Result<>();
		List<RuleCondition> list=ruleConditionService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据权限规则范围条件
	*/
	@ApiOperation(value = "查询数据权限规则范围条件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleConditionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.RANGE_ID , value = "range" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.DATA_TABLE , value = "数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.EXPR_TYPE , value = "表达式类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.LOGIC , value = "逻辑关系可选值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RuleConditionVOMeta.PAGE_INDEX , RuleConditionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RuleConditionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleConditionServiceProxy.QUERY_LIST)
	public Result<List<RuleCondition>> queryList(RuleConditionVO sample) {
		Result<List<RuleCondition>> result=new Result<>();
		List<RuleCondition> list=ruleConditionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据权限规则范围条件
	*/
	@ApiOperation(value = "分页查询数据权限规则范围条件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RuleConditionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.RANGE_ID , value = "range" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.DATA_TABLE , value = "数据表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.EXPR_TYPE , value = "表达式类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.LOGIC , value = "逻辑关系可选值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RuleConditionVOMeta.VALID , value = "是否生效" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RuleConditionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RuleConditionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RuleCondition>> queryPagedList(RuleConditionVO sample) {
		Result<PagedList<RuleCondition>> result=new Result<>();
		PagedList<RuleCondition> list=ruleConditionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RuleConditionServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RuleConditionServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RuleConditionVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=ruleConditionService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RuleConditionServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RuleConditionServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=ruleConditionService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = RuleConditionServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RuleConditionServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=ruleConditionService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}