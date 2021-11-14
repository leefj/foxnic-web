package org.github.foxnic.web.oauth.controller;


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
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.ResourzeVO;
import org.github.foxnic.web.domain.oauth.meta.ResourzeVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.oauth.service.IMenuService;
import org.github.foxnic.web.oauth.service.IResourzeService;
import org.github.foxnic.web.proxy.oauth.ResourzeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统资源 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-03 18:46:21
*/

@Api(tags = "系统资源")
@ApiSort(0)
@RestController("SysResourzeController")
public class ResourzeController extends SuperController {

	@Autowired
	private IResourzeService resourzeService;

	@Autowired
	private IMenuService menuService;


	/**
	 * 添加系统资源
	*/
	@ApiOperation(value = "添加系统资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResourzeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "463397728609632256"),
		@ApiImplicitParam(name = ResourzeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "表单页面"),
		@ApiImplicitParam(name = ResourzeVOMeta.TYPE , value = "类型" , required = true , dataTypeClass=String.class , example = "page"),
		@ApiImplicitParam(name = ResourzeVOMeta.ACCESS_TYPE , value = "访问控制类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ResourzeVOMeta.URL , value = "地址" , required = true , dataTypeClass=String.class , example = "/business/oauth/resourze/resourze_form.html"),
		@ApiImplicitParam(name = ResourzeVOMeta.METHOD , value = "HttpMethod" , required = true , dataTypeClass=String.class , example = "GET"),
		@ApiImplicitParam(name = ResourzeVOMeta.BATCH_ID , value = "批次号" , required = false , dataTypeClass=String.class , example = "463397723765211136"),
		@ApiImplicitParam(name = ResourzeVOMeta.TABLE_NAME , value = "来源表" , required = false , dataTypeClass=String.class , example = "sys_resourze"),
		@ApiImplicitParam(name = ResourzeVOMeta.MODULE , value = "来源模块" , required = false , dataTypeClass=String.class , example = "系统资源"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ResourzeVOMeta.ID)
	@SentinelResource(value = ResourzeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResourzeServiceProxy.INSERT)
	public Result insert(ResourzeVO resourzeVO) {
		Result result=resourzeService.insert(resourzeVO);
		return result;
	}


	/**
	 * 删除系统资源
	*/
	@ApiOperation(value = "删除系统资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResourzeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "463397728609632256"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ResourzeVOMeta.ID)
	@SentinelResource(value = ResourzeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResourzeServiceProxy.DELETE)
	public Result deleteById(String id) {
		List<Menu> menus=menuService.getRelatedMenus(Arrays.asList(id));
		Result result = null;
		if(menus.size()==0) {
			result = resourzeService.deleteByIdPhysical(id);
		} else {
			result = ErrorDesc.failure().message("资源已经被使用，不允许删除！");
			for (Menu menu : menus) {
				result.addSolution(menu.getAncestorsNamePath());
			}
		}
		return result;
	}


	/**
	 * 批量删除系统资源 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除系统资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResourzeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3)
	@NotNull(name = ResourzeVOMeta.IDS)
	@SentinelResource(value = ResourzeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResourzeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		List<Menu> menus=menuService.getRelatedMenus(ids);
		Result result = null;
		if(menus.size()==0) {
			result = resourzeService.deleteByIdsLogical(ids);
		} else {
			result = ErrorDesc.failure().message("资源已经被使用，不允许删除！");
			for (Menu menu : menus) {
				result.addSolution(menu.getAncestorsNamePath());
			}
		}
		return result;
	}

	/**
	 * 更新系统资源
	*/
	@ApiOperation(value = "更新系统资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResourzeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "463397728609632256"),
		@ApiImplicitParam(name = ResourzeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "表单页面"),
		@ApiImplicitParam(name = ResourzeVOMeta.TYPE , value = "类型" , required = true , dataTypeClass=String.class , example = "page"),
		@ApiImplicitParam(name = ResourzeVOMeta.ACCESS_TYPE , value = "访问控制类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ResourzeVOMeta.URL , value = "地址" , required = true , dataTypeClass=String.class , example = "/business/oauth/resourze/resourze_form.html"),
		@ApiImplicitParam(name = ResourzeVOMeta.METHOD , value = "HttpMethod" , required = true , dataTypeClass=String.class , example = "GET"),
		@ApiImplicitParam(name = ResourzeVOMeta.BATCH_ID , value = "批次号" , required = false , dataTypeClass=String.class , example = "463397723765211136"),
		@ApiImplicitParam(name = ResourzeVOMeta.TABLE_NAME , value = "来源表" , required = false , dataTypeClass=String.class , example = "sys_resourze"),
		@ApiImplicitParam(name = ResourzeVOMeta.MODULE , value = "来源模块" , required = false , dataTypeClass=String.class , example = "系统资源"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ResourzeVOMeta.PAGE_INDEX , ResourzeVOMeta.PAGE_SIZE , ResourzeVOMeta.SEARCH_FIELD , ResourzeVOMeta.SEARCH_VALUE , ResourzeVOMeta.SORT_FIELD , ResourzeVOMeta.SORT_TYPE , ResourzeVOMeta.IDS } )
	@NotNull(name = ResourzeVOMeta.ID)
	@SentinelResource(value = ResourzeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResourzeServiceProxy.UPDATE)
	public Result update(ResourzeVO resourzeVO) {
		Result result=resourzeService.update(resourzeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存系统资源
	*/
	@ApiOperation(value = "保存系统资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResourzeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "463397728609632256"),
		@ApiImplicitParam(name = ResourzeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "表单页面"),
		@ApiImplicitParam(name = ResourzeVOMeta.TYPE , value = "类型" , required = true , dataTypeClass=String.class , example = "page"),
		@ApiImplicitParam(name = ResourzeVOMeta.ACCESS_TYPE , value = "访问控制类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ResourzeVOMeta.URL , value = "地址" , required = true , dataTypeClass=String.class , example = "/business/oauth/resourze/resourze_form.html"),
		@ApiImplicitParam(name = ResourzeVOMeta.METHOD , value = "HttpMethod" , required = true , dataTypeClass=String.class , example = "GET"),
		@ApiImplicitParam(name = ResourzeVOMeta.BATCH_ID , value = "批次号" , required = false , dataTypeClass=String.class , example = "463397723765211136"),
		@ApiImplicitParam(name = ResourzeVOMeta.TABLE_NAME , value = "来源表" , required = false , dataTypeClass=String.class , example = "sys_resourze"),
		@ApiImplicitParam(name = ResourzeVOMeta.MODULE , value = "来源模块" , required = false , dataTypeClass=String.class , example = "系统资源"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ResourzeVOMeta.PAGE_INDEX , ResourzeVOMeta.PAGE_SIZE , ResourzeVOMeta.SEARCH_FIELD , ResourzeVOMeta.SEARCH_VALUE , ResourzeVOMeta.SORT_FIELD , ResourzeVOMeta.SORT_TYPE , ResourzeVOMeta.IDS } )
	@NotNull(name = ResourzeVOMeta.ID)
	@SentinelResource(value = ResourzeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResourzeServiceProxy.SAVE)
	public Result save(ResourzeVO resourzeVO) {
		Result result=resourzeService.save(resourzeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取系统资源
	*/
	@ApiOperation(value = "获取系统资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResourzeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ResourzeVOMeta.ID)
	@SentinelResource(value = ResourzeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResourzeServiceProxy.GET_BY_ID)
	public Result<Resourze> getById(String id) {
		Result<Resourze> result=new Result<>();
		Resourze role=resourzeService.getById(id);
		result.success(true).data(role);
		return result;
	}


	/**
	 * 批量删除系统资源 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除系统资源")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ResourzeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3)
		@NotNull(name = ResourzeVOMeta.IDS)
		@SentinelResource(value = ResourzeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResourzeServiceProxy.GET_BY_IDS)
	public Result<List<Resourze>> getByIds(List<String> ids) {
		Result<List<Resourze>> result=new Result<>();
		List<Resourze> list=resourzeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询系统资源
	*/
	@ApiOperation(value = "查询系统资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResourzeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "463397728609632256"),
		@ApiImplicitParam(name = ResourzeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "表单页面"),
		@ApiImplicitParam(name = ResourzeVOMeta.TYPE , value = "类型" , required = true , dataTypeClass=String.class , example = "page"),
		@ApiImplicitParam(name = ResourzeVOMeta.ACCESS_TYPE , value = "访问控制类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ResourzeVOMeta.URL , value = "地址" , required = true , dataTypeClass=String.class , example = "/business/oauth/resourze/resourze_form.html"),
		@ApiImplicitParam(name = ResourzeVOMeta.METHOD , value = "HttpMethod" , required = true , dataTypeClass=String.class , example = "GET"),
		@ApiImplicitParam(name = ResourzeVOMeta.BATCH_ID , value = "批次号" , required = false , dataTypeClass=String.class , example = "463397723765211136"),
		@ApiImplicitParam(name = ResourzeVOMeta.TABLE_NAME , value = "来源表" , required = false , dataTypeClass=String.class , example = "sys_resourze"),
		@ApiImplicitParam(name = ResourzeVOMeta.MODULE , value = "来源模块" , required = false , dataTypeClass=String.class , example = "系统资源"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ResourzeVOMeta.PAGE_INDEX , ResourzeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ResourzeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResourzeServiceProxy.QUERY_LIST)
	public Result<List<Resourze>> queryList(ResourzeVO sample) {
		Result<List<Resourze>> result=new Result<>();
		List<Resourze> list=resourzeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询系统资源
	*/
	@ApiOperation(value = "分页查询系统资源")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResourzeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "463397728609632256"),
		@ApiImplicitParam(name = ResourzeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "表单页面"),
		@ApiImplicitParam(name = ResourzeVOMeta.TYPE , value = "类型" , required = true , dataTypeClass=String.class , example = "page"),
		@ApiImplicitParam(name = ResourzeVOMeta.ACCESS_TYPE , value = "访问控制类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ResourzeVOMeta.URL , value = "地址" , required = true , dataTypeClass=String.class , example = "/business/oauth/resourze/resourze_form.html"),
		@ApiImplicitParam(name = ResourzeVOMeta.METHOD , value = "HttpMethod" , required = true , dataTypeClass=String.class , example = "GET"),
		@ApiImplicitParam(name = ResourzeVOMeta.BATCH_ID , value = "批次号" , required = false , dataTypeClass=String.class , example = "463397723765211136"),
		@ApiImplicitParam(name = ResourzeVOMeta.TABLE_NAME , value = "来源表" , required = false , dataTypeClass=String.class , example = "sys_resourze"),
		@ApiImplicitParam(name = ResourzeVOMeta.MODULE , value = "来源模块" , required = false , dataTypeClass=String.class , example = "系统资源"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ResourzeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResourzeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Resourze>> queryPagedList(ResourzeVO sample) {
		Result<PagedList<Resourze>> result=new Result<>();
		PagedList<Resourze> list=resourzeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ResourzeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ResourzeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ResourzeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=resourzeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ResourzeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ResourzeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=resourzeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = ResourzeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ResourzeServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=resourzeService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}