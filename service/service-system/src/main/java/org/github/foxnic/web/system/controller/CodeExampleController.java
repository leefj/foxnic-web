package org.github.foxnic.web.system.controller;


import java.util.List;
import java.util.ArrayList;

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


import org.github.foxnic.web.proxy.system.CodeExampleServiceProxy;
import org.github.foxnic.web.domain.system.meta.CodeExampleVOMeta;
import org.github.foxnic.web.domain.system.CodeExample;
import org.github.foxnic.web.domain.system.CodeExampleVO;
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
import org.github.foxnic.web.domain.system.meta.CodeExampleMeta;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.meta.ResourzeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.ICodeExampleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 代码生成示例主表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-22 13:39:22
*/

@Api(tags = "代码生成示例主")
@ApiSort(0)
@RestController("SysCodeExampleController")
public class CodeExampleController extends SuperController {

	@Autowired
	private ICodeExampleService codeExampleService;


	/**
	 * 添加代码生成示例主
	*/
	@ApiOperation(value = "添加代码生成示例主")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NAME , value = "单行文本" , required = false , dataTypeClass=String.class , example = "ZZ"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NOTES , value = "多行文本" , required = false , dataTypeClass=String.class , example = "XXX"),
		@ApiImplicitParam(name = CodeExampleVOMeta.IMAGE_ID , value = "图片上传" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.FILE_IDS , value = "多文件上传" , required = false , dataTypeClass=String.class , example = "CC"),
		@ApiImplicitParam(name = CodeExampleVOMeta.AREA , value = "整数输入" , required = false , dataTypeClass=Integer.class , example = "10"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WEIGHT , value = "小数输入" , required = false , dataTypeClass=Double.class , example = "12.0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.VALID , value = "逻辑值" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.BUTTON_INPUT , value = "对话框" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_ENUM , value = "单选框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_DICT , value = "单选框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_ENUM , value = "复选框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_DICT , value = "复选框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_ENUM , value = "选择框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_DICT , value = "选择框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RESOURCE_ID , value = "选择框(查询)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.BIRTHDAY , value = "日期" , required = false , dataTypeClass=Date.class , example = "2021-08-23 12:00:00"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WORK_TIME , value = "工作时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CodeExampleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.INSERT)
	public Result insert(CodeExampleVO codeExampleVO) {
		Result result=codeExampleService.insert(codeExampleVO,false);
		return result;
	}



	/**
	 * 删除代码生成示例主
	*/
	@ApiOperation(value = "删除代码生成示例主")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CodeExampleVOMeta.ID)
	@SentinelResource(value = CodeExampleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		Boolean hasRefer = codeExampleService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(hasRefer).requireEqual("不允许删除当前记录",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=codeExampleService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除代码生成示例主 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除代码生成示例主")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CodeExampleVOMeta.IDS)
	@SentinelResource(value = CodeExampleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, Boolean> hasRefersMap = codeExampleService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, Boolean> e : hasRefersMap.entrySet()) {
			if (!e.getValue()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行");
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=codeExampleService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=codeExampleService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新代码生成示例主
	*/
	@ApiOperation(value = "更新代码生成示例主")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NAME , value = "单行文本" , required = false , dataTypeClass=String.class , example = "ZZ"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NOTES , value = "多行文本" , required = false , dataTypeClass=String.class , example = "XXX"),
		@ApiImplicitParam(name = CodeExampleVOMeta.IMAGE_ID , value = "图片上传" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.FILE_IDS , value = "多文件上传" , required = false , dataTypeClass=String.class , example = "CC"),
		@ApiImplicitParam(name = CodeExampleVOMeta.AREA , value = "整数输入" , required = false , dataTypeClass=Integer.class , example = "10"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WEIGHT , value = "小数输入" , required = false , dataTypeClass=Double.class , example = "12.0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.VALID , value = "逻辑值" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.BUTTON_INPUT , value = "对话框" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_ENUM , value = "单选框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_DICT , value = "单选框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_ENUM , value = "复选框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_DICT , value = "复选框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_ENUM , value = "选择框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_DICT , value = "选择框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RESOURCE_ID , value = "选择框(查询)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.BIRTHDAY , value = "日期" , required = false , dataTypeClass=Date.class , example = "2021-08-23 12:00:00"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WORK_TIME , value = "工作时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CodeExampleVOMeta.PAGE_INDEX , CodeExampleVOMeta.PAGE_SIZE , CodeExampleVOMeta.SEARCH_FIELD , CodeExampleVOMeta.FUZZY_FIELD , CodeExampleVOMeta.SEARCH_VALUE , CodeExampleVOMeta.DIRTY_FIELDS , CodeExampleVOMeta.SORT_FIELD , CodeExampleVOMeta.SORT_TYPE , CodeExampleVOMeta.IDS } )
	@SentinelResource(value = CodeExampleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.UPDATE)
	public Result update(CodeExampleVO codeExampleVO) {
		Result result=codeExampleService.update(codeExampleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存代码生成示例主
	*/
	@ApiOperation(value = "保存代码生成示例主")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NAME , value = "单行文本" , required = false , dataTypeClass=String.class , example = "ZZ"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NOTES , value = "多行文本" , required = false , dataTypeClass=String.class , example = "XXX"),
		@ApiImplicitParam(name = CodeExampleVOMeta.IMAGE_ID , value = "图片上传" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.FILE_IDS , value = "多文件上传" , required = false , dataTypeClass=String.class , example = "CC"),
		@ApiImplicitParam(name = CodeExampleVOMeta.AREA , value = "整数输入" , required = false , dataTypeClass=Integer.class , example = "10"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WEIGHT , value = "小数输入" , required = false , dataTypeClass=Double.class , example = "12.0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.VALID , value = "逻辑值" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.BUTTON_INPUT , value = "对话框" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_ENUM , value = "单选框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_DICT , value = "单选框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_ENUM , value = "复选框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_DICT , value = "复选框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_ENUM , value = "选择框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_DICT , value = "选择框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RESOURCE_ID , value = "选择框(查询)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.BIRTHDAY , value = "日期" , required = false , dataTypeClass=Date.class , example = "2021-08-23 12:00:00"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WORK_TIME , value = "工作时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeExampleVOMeta.PAGE_INDEX , CodeExampleVOMeta.PAGE_SIZE , CodeExampleVOMeta.SEARCH_FIELD , CodeExampleVOMeta.FUZZY_FIELD , CodeExampleVOMeta.SEARCH_VALUE , CodeExampleVOMeta.DIRTY_FIELDS , CodeExampleVOMeta.SORT_FIELD , CodeExampleVOMeta.SORT_TYPE , CodeExampleVOMeta.IDS } )
	@NotNull(name = CodeExampleVOMeta.ID)
	@SentinelResource(value = CodeExampleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.SAVE)
	public Result save(CodeExampleVO codeExampleVO) {
		Result result=codeExampleService.save(codeExampleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取代码生成示例主
	*/
	@ApiOperation(value = "获取代码生成示例主")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CodeExampleVOMeta.ID)
	@SentinelResource(value = CodeExampleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.GET_BY_ID)
	public Result<CodeExample> getById(String id) {
		Result<CodeExample> result=new Result<>();
		CodeExample codeExample=codeExampleService.getById(id);
		// join 关联的对象
		codeExampleService.dao().fill(codeExample)
			.with(CodeExampleMeta.RESOURZE)
			.with(CodeExampleMeta.ROLES)
			.execute();
		result.success(true).data(codeExample);
		return result;
	}


	/**
	 * 批量获取代码生成示例主 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取代码生成示例主")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CodeExampleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CodeExampleVOMeta.IDS)
		@SentinelResource(value = CodeExampleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.GET_BY_IDS)
	public Result<List<CodeExample>> getByIds(List<String> ids) {
		Result<List<CodeExample>> result=new Result<>();
		List<CodeExample> list=codeExampleService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询代码生成示例主
	*/
	@ApiOperation(value = "查询代码生成示例主")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NAME , value = "单行文本" , required = false , dataTypeClass=String.class , example = "ZZ"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NOTES , value = "多行文本" , required = false , dataTypeClass=String.class , example = "XXX"),
		@ApiImplicitParam(name = CodeExampleVOMeta.IMAGE_ID , value = "图片上传" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.FILE_IDS , value = "多文件上传" , required = false , dataTypeClass=String.class , example = "CC"),
		@ApiImplicitParam(name = CodeExampleVOMeta.AREA , value = "整数输入" , required = false , dataTypeClass=Integer.class , example = "10"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WEIGHT , value = "小数输入" , required = false , dataTypeClass=Double.class , example = "12.0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.VALID , value = "逻辑值" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.BUTTON_INPUT , value = "对话框" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_ENUM , value = "单选框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_DICT , value = "单选框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_ENUM , value = "复选框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_DICT , value = "复选框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_ENUM , value = "选择框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_DICT , value = "选择框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RESOURCE_ID , value = "选择框(查询)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.BIRTHDAY , value = "日期" , required = false , dataTypeClass=Date.class , example = "2021-08-23 12:00:00"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WORK_TIME , value = "工作时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeExampleVOMeta.PAGE_INDEX , CodeExampleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CodeExampleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.QUERY_LIST)
	public Result<List<CodeExample>> queryList(CodeExampleVO sample) {
		Result<List<CodeExample>> result=new Result<>();
		List<CodeExample> list=codeExampleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询代码生成示例主
	*/
	@ApiOperation(value = "分页查询代码生成示例主")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NAME , value = "单行文本" , required = false , dataTypeClass=String.class , example = "ZZ"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NOTES , value = "多行文本" , required = false , dataTypeClass=String.class , example = "XXX"),
		@ApiImplicitParam(name = CodeExampleVOMeta.IMAGE_ID , value = "图片上传" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.FILE_IDS , value = "多文件上传" , required = false , dataTypeClass=String.class , example = "CC"),
		@ApiImplicitParam(name = CodeExampleVOMeta.AREA , value = "整数输入" , required = false , dataTypeClass=Integer.class , example = "10"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WEIGHT , value = "小数输入" , required = false , dataTypeClass=Double.class , example = "12.0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.VALID , value = "逻辑值" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.BUTTON_INPUT , value = "对话框" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_ENUM , value = "单选框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_DICT , value = "单选框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_ENUM , value = "复选框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_DICT , value = "复选框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_ENUM , value = "选择框(枚举)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_DICT , value = "选择框(字典)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RESOURCE_ID , value = "选择框(查询)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.BIRTHDAY , value = "日期" , required = false , dataTypeClass=Date.class , example = "2021-08-23 12:00:00"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WORK_TIME , value = "工作时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CodeExampleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CodeExample>> queryPagedList(CodeExampleVO sample) {
		Result<PagedList<CodeExample>> result=new Result<>();
		PagedList<CodeExample> list=codeExampleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		codeExampleService.dao().fill(list)
			.with(CodeExampleMeta.RESOURZE)
			.with(CodeExampleMeta.ROLES)
			.execute();
		result.success(true).data(list);
		return result;
	}






}