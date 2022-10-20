package org.github.foxnic.web.system.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.InDoc;
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
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.domain.system.ConfigVO;
import org.github.foxnic.web.domain.system.meta.ConfigVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;
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
 * @since 2021-12-03 09:07:26
 * @version
*/
@InDoc
@Api(tags = "系统服务/系统配置")
@ApiSort(0)
@RestController("SysConfigController")
public class ConfigController extends SuperController {

	@Autowired
	private IConfigService configService;


	/**
	 * 添加系统配置
	*/
	@ApiOperation(value = "添加系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "资产页面直接更新"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE , value = "数据类型" , required = false , dataTypeClass=String.class , example = "ENUM"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC , value = "类型描述" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.constants.enums.system.YesNo"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ConfigVOMeta.PROFILE_ID , value = "Profile" , required = true , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = ConfigVOMeta.CATALOG_CODE , value = "分类代码" , required = false , dataTypeClass=String.class , example = "system"),
		@ApiImplicitParam(name = ConfigVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "eam.assetDirectUpdateMode"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ConfigVOMeta.CODE)
	@NotNull(name = ConfigVOMeta.VALID)
	@NotNull(name = ConfigVOMeta.PROFILE_ID)
	@SentinelResource(value = ConfigServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ConfigServiceProxy.INSERT)
	public Result insert(ConfigVO configVO) {
		Result result=configService.insert(configVO,false);
		return result;
	}



	/**
	 * 删除系统配置
	*/
	@ApiOperation(value = "删除系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "eam.assetDirectUpdateMode")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ConfigVOMeta.ID)
	@SentinelResource(value = ConfigServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ConfigServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=configService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除系统配置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3)
	@NotNull(name = ConfigVOMeta.IDS)
	@SentinelResource(value = ConfigServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ConfigServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=configService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新系统配置
	*/
	@ApiOperation(value = "更新系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "资产页面直接更新"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE , value = "数据类型" , required = false , dataTypeClass=String.class , example = "ENUM"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC , value = "类型描述" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.constants.enums.system.YesNo"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ConfigVOMeta.PROFILE_ID , value = "Profile" , required = true , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = ConfigVOMeta.CATALOG_CODE , value = "分类代码" , required = false , dataTypeClass=String.class , example = "system"),
		@ApiImplicitParam(name = ConfigVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "eam.assetDirectUpdateMode"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ConfigVOMeta.PAGE_INDEX , ConfigVOMeta.PAGE_SIZE , ConfigVOMeta.SEARCH_FIELD , ConfigVOMeta.FUZZY_FIELD , ConfigVOMeta.SEARCH_VALUE , ConfigVOMeta.DIRTY_FIELDS , ConfigVOMeta.SORT_FIELD , ConfigVOMeta.SORT_TYPE , ConfigVOMeta.IDS } )
	@NotNull(name = ConfigVOMeta.CODE)
	@NotNull(name = ConfigVOMeta.VALID)
	@NotNull(name = ConfigVOMeta.PROFILE_ID)
	@NotNull(name = ConfigVOMeta.ID)
	@SentinelResource(value = ConfigServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ConfigServiceProxy.UPDATE)
	public Result update(ConfigVO configVO) {
		Result result=configService.update(configVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存系统配置
	*/
	@ApiOperation(value = "保存系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "资产页面直接更新"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE , value = "数据类型" , required = false , dataTypeClass=String.class , example = "ENUM"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC , value = "类型描述" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.constants.enums.system.YesNo"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ConfigVOMeta.PROFILE_ID , value = "Profile" , required = true , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = ConfigVOMeta.CATALOG_CODE , value = "分类代码" , required = false , dataTypeClass=String.class , example = "system"),
		@ApiImplicitParam(name = ConfigVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "eam.assetDirectUpdateMode"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ConfigVOMeta.PAGE_INDEX , ConfigVOMeta.PAGE_SIZE , ConfigVOMeta.SEARCH_FIELD , ConfigVOMeta.FUZZY_FIELD , ConfigVOMeta.SEARCH_VALUE , ConfigVOMeta.DIRTY_FIELDS , ConfigVOMeta.SORT_FIELD , ConfigVOMeta.SORT_TYPE , ConfigVOMeta.IDS } )
	@NotNull(name = ConfigVOMeta.CODE)
	@NotNull(name = ConfigVOMeta.VALID)
	@NotNull(name = ConfigVOMeta.PROFILE_ID)
	@NotNull(name = ConfigVOMeta.ID)
	@SentinelResource(value = ConfigServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ConfigServiceProxy.SAVE)
	public Result save(ConfigVO configVO) {
		Result result=configService.save(configVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取系统配置
	*/
	@ApiOperation(value = "获取系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ConfigVOMeta.ID)
	@SentinelResource(value = ConfigServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ConfigServiceProxy.GET_BY_ID)
	public Result<Config> getById(String id) {
		Result<Config> result=new Result<>();
		Config config=configService.getById(id);
		result.success(true).data(config);
		return result;
	}

	/**
	 * 获取系统配置
	 */
	@ApiOperation(value = "获取系统配置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "代码" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ConfigVOMeta.CODE)
	@SentinelResource(value = ConfigServiceProxy.GET_BY_CODE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ConfigServiceProxy.GET_BY_CODE)
	public Result<Config> getByCode(String code) {
		Result<Config> result=new Result<>();
		Config config=configService.getByCode(code);
		result.success(true).data(config);
		return result;
	}


	/**
	 * 获取系统配置
	 */
	@ApiOperation(value = "获取系统配置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "codes" , value = "代码" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = "codes")
	@SentinelResource(value = ConfigServiceProxy.GET_BY_CODES , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ConfigServiceProxy.GET_BY_CODES)
	public Result<List<Config>> getByCodes(List<String> codes) {
		Result<List<Config>> result=new Result<>();
		List<Config> configs=configService.getByCodes(codes);
		result.success(true).data(configs);
		return result;
	}


	/**
	 * 批量获取系统配置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取系统配置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ConfigVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3)
		@NotNull(name = ConfigVOMeta.IDS)
		@SentinelResource(value = ConfigServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ConfigServiceProxy.GET_BY_IDS)
	public Result<List<Config>> getByIds(List<String> ids) {
		Result<List<Config>> result=new Result<>();
		List<Config> list=configService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询系统配置
	*/
	@ApiOperation(value = "查询系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "资产页面直接更新"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE , value = "数据类型" , required = false , dataTypeClass=String.class , example = "ENUM"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC , value = "类型描述" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.constants.enums.system.YesNo"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ConfigVOMeta.PROFILE_ID , value = "Profile" , required = true , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = ConfigVOMeta.CATALOG_CODE , value = "分类代码" , required = false , dataTypeClass=String.class , example = "system"),
		@ApiImplicitParam(name = ConfigVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "eam.assetDirectUpdateMode"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ConfigVOMeta.PAGE_INDEX , ConfigVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ConfigServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ConfigServiceProxy.QUERY_LIST)
	public Result<List<Config>> queryList(ConfigVO sample) {
		Result<List<Config>> result=new Result<>();
		List<Config> list=configService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询系统配置
	*/
	@ApiOperation(value = "分页查询系统配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE , value = "配置键" , required = true , dataTypeClass=String.class , example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME , value = "配置名" , required = false , dataTypeClass=String.class , example = "资产页面直接更新"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE , value = "数据类型" , required = false , dataTypeClass=String.class , example = "ENUM"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC , value = "类型描述" , required = false , dataTypeClass=String.class , example = "org.github.foxnic.web.constants.enums.system.YesNo"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE , value = "配置值" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID , value = "是否生效" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ConfigVOMeta.PROFILE_ID , value = "Profile" , required = true , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = ConfigVOMeta.CATALOG_CODE , value = "分类代码" , required = false , dataTypeClass=String.class , example = "system"),
		@ApiImplicitParam(name = ConfigVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "eam.assetDirectUpdateMode"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ConfigServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ConfigServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Config>> queryPagedList(ConfigVO sample) {
		Result<PagedList<Config>> result=new Result<>();
		PagedList<Config> list=configService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ConfigServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ConfigServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ConfigVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=configService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ConfigServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ConfigServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=configService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = ConfigServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
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
