package org.github.foxnic.web.system.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
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
import org.github.foxnic.web.constants.enums.system.SystemConfigType;
import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.domain.system.ConfigVO;
import org.github.foxnic.web.domain.system.meta.ConfigVOMeta;
import org.github.foxnic.web.proxy.storage.FileServiceProxy;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;
import org.github.foxnic.web.proxy.utils.CodeTextEnumUtil;
import org.github.foxnic.web.system.service.IConfigService;
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
 * 系统配置表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-20 04:34:14
*/

@Api(tags = "系统配置")
@ApiSort(0)
@RestController("SysConfigController")
public class ConfigController {

	@Autowired
	private IConfigService configService;


	@Autowired
	private CodeTextEnumUtil enumUtil;

	/**
	 * 添加系统配置
	*/
	@ApiOperation(value = "添加系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统默认语言"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE , value = "数据类型" , required = false , dataTypeClass=String.class , example = "STRING"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC , value = "类型描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "defaults"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Boolean.class , example = "true"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ConfigVOMeta.CODE)
	@NotNull(name = ConfigVOMeta.VALID)
	@SentinelResource(value = ConfigServiceProxy.INSERT)
	@PostMapping(ConfigServiceProxy.INSERT)
	public Result insert(ConfigVO configVO) {
		Result result = configService.insert(configVO);
		return result;
	}

	
	/**
	 * 删除系统配置
	*/
	@ApiOperation(value = "删除系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ConfigVOMeta.CODE)
	@SentinelResource(value = ConfigServiceProxy.DELETE)
	@PostMapping(ConfigServiceProxy.DELETE)
	public Result<Config> deleteById(String code) {
		Result<Config> result=new Result<>();
		boolean suc=configService.deleteByIdLogical(code);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除系统配置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODES , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ConfigVOMeta.CODES)
	@SentinelResource(value = ConfigServiceProxy.BATCH_DELETE)
	@PostMapping(ConfigServiceProxy.BATCH_DELETE)
	public Result deleteByIds(List<String> codes) {
		Result result=configService.deleteByIdsLogical(codes);
		return result;
	}
	
	/**
	 * 更新系统配置
	*/
	@ApiOperation(value = "更新系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统默认语言"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE , value = "数据类型" , required = false , dataTypeClass=String.class , example = "STRING"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC , value = "类型描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "defaults"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Boolean.class , example = "true"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ConfigVOMeta.PAGE_INDEX , ConfigVOMeta.PAGE_SIZE , ConfigVOMeta.SEARCH_FIELD , ConfigVOMeta.SEARCH_VALUE , ConfigVOMeta.CODES } ) 
	@NotNull(name = ConfigVOMeta.CODE)
	@NotNull(name = ConfigVOMeta.VALID)
	@SentinelResource(value = ConfigServiceProxy.UPDATE)
	@PostMapping(ConfigServiceProxy.UPDATE)
	public Result update(ConfigVO configVO) {
		Result result=configService.update(configVO,SaveMode.NOT_NULL_FIELDS);
		if (!result.success()) {
			ErrorDesc.fill(result, CommonError.DATA_NOT_EXISTS);
		}
		return result;
	}
	
	
	/**
	 * 保存系统配置
	*/
	@ApiOperation(value = "保存系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统默认语言"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE , value = "数据类型" , required = false , dataTypeClass=String.class , example = "STRING"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC , value = "类型描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "defaults"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Boolean.class , example = "true"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ConfigVOMeta.PAGE_INDEX , ConfigVOMeta.PAGE_SIZE , ConfigVOMeta.SEARCH_FIELD , ConfigVOMeta.SEARCH_VALUE , ConfigVOMeta.CODES } )
	@NotNull(name = ConfigVOMeta.CODE)
	@NotNull(name = ConfigVOMeta.VALID)
	@SentinelResource(value = ConfigServiceProxy.SAVE)
	@PostMapping(ConfigServiceProxy.SAVE)
	public Result save(ConfigVO configVO) {
		Result result=configService.save(configVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取系统配置
	*/
	@ApiOperation(value = "获取系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ConfigVOMeta.CODE)
	@SentinelResource(value = ConfigServiceProxy.GET_BY_ID)
	@PostMapping(ConfigServiceProxy.GET_BY_ID)
	public Result<Config> getById(String code) {
		Result<Config> result=new Result<>();
		Config role=configService.getById(code);
		result.success(true).data(role);
		return result;
	}


	/**
	 * 查询系统配置
	*/
	@ApiOperation(value = "查询系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统默认语言"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE , value = "数据类型" , required = false , dataTypeClass=String.class , example = "STRING"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC , value = "类型描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "defaults"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Boolean.class , example = "true"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ConfigVOMeta.PAGE_INDEX , ConfigVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ConfigServiceProxy.QUERY_LIST)
	@PostMapping(ConfigServiceProxy.QUERY_LIST)
	public Result<List<Config>> queryList(ConfigVO sample) {
		Result<File> r=FileServiceProxy.api().getById("314");
		Result<List<Config>> result=new Result<>();
		List<Config> list=configService.queryList(sample);
		result.success(true).data(list).refer("config", r);
		return result;
	}

	
	/**
	 * 分页查询系统配置
	*/
	@ApiOperation(value = "分页查询系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "system.language"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "系统默认语言"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE , value = "数据类型" , required = false , dataTypeClass=String.class , example = "STRING"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC , value = "类型描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "defaults"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Boolean.class , example = "true"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ConfigServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(ConfigServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Config>> queryPagedList(ConfigVO sample) {
		Result<PagedList<Config>> result=new Result<>();
		PagedList<Config> list=configService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		for (Config config : list) {
			 if(SystemConfigType.ENUM.name().equalsIgnoreCase(config.getType())) {
				try {
					CodeTextEnum type= EnumUtil.parseByCode(config.getTypeDesc(),config.getValue());
					config.setValue(type.text()+"("+type.code()+")");
				} catch (Exception e) {}
			 }
		}
		result.success(true).data(list);
		return result;
	}
	
	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ConfigServiceProxy.EXPORT_EXCEL)
	@RequestMapping(ConfigServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ConfigVO sample,HttpServletResponse response) throws Exception {
 		//生成 Excel 数据
		ExcelWriter ew=configService.exportExcel(sample);
		//下载
		DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());

	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ConfigServiceProxy.EXPORT_EXCEL_TEMPLATE)
	@RequestMapping(ConfigServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		//生成 Excel 模版
		ExcelWriter ew=configService.exportExcelTemplate();
		//下载
		DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}




	@SentinelResource(value = ConfigServiceProxy.IMPORT_EXCEL)
	@RequestMapping(ConfigServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=configService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}