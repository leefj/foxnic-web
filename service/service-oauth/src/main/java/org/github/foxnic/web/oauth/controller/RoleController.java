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
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.RoleVO;
import org.github.foxnic.web.domain.oauth.meta.RoleVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.oauth.service.IRoleService;
import org.github.foxnic.web.proxy.oauth.RoleServiceProxy;
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
 * 角色表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-06 16:53:31
*/

@Api(tags = "角色")
@ApiSort(0)
@RestController("SysRoleController")
public class RoleController extends SuperController {

	@Autowired
	private IRoleService roleService;

	
	/**
	 * 添加角色
	*/
	@ApiOperation(value = "添加角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110352463290923000"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "business_man"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "业务员"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = RoleVOMeta.ID)
	@SentinelResource(value = RoleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleServiceProxy.INSERT)
	public Result insert(RoleVO roleVO) {
		Result result=roleService.insert(roleVO);
		return result;
	}

	
	/**
	 * 删除角色
	*/
	@ApiOperation(value = "删除角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110352463290923000"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RoleVOMeta.ID)
	@SentinelResource(value = RoleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=roleService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除角色 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RoleVOMeta.IDS)
	@SentinelResource(value = RoleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=roleService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新角色
	*/
	@ApiOperation(value = "更新角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110352463290923000"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "business_man"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "业务员"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RoleVOMeta.PAGE_INDEX , RoleVOMeta.PAGE_SIZE , RoleVOMeta.SEARCH_FIELD , RoleVOMeta.SEARCH_VALUE , RoleVOMeta.SORT_FIELD , RoleVOMeta.SORT_TYPE , RoleVOMeta.IDS } ) 
	@NotNull(name = RoleVOMeta.ID)
	@SentinelResource(value = RoleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleServiceProxy.UPDATE)
	public Result update(RoleVO roleVO) {
		Result result=roleService.update(roleVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存角色
	*/
	@ApiOperation(value = "保存角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110352463290923000"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "business_man"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "业务员"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RoleVOMeta.PAGE_INDEX , RoleVOMeta.PAGE_SIZE , RoleVOMeta.SEARCH_FIELD , RoleVOMeta.SEARCH_VALUE , RoleVOMeta.SORT_FIELD , RoleVOMeta.SORT_TYPE , RoleVOMeta.IDS } )
	@NotNull(name = RoleVOMeta.ID)
	@SentinelResource(value = RoleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleServiceProxy.SAVE)
	public Result save(RoleVO roleVO) {
		Result result=roleService.save(roleVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取角色
	*/
	@ApiOperation(value = "获取角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RoleVOMeta.ID)
	@SentinelResource(value = RoleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleServiceProxy.GET_BY_ID)
	public Result<Role> getById(String id) {
		Result<Role> result=new Result<>();
		Role role=roleService.getById(id);
		result.success(true).data(role);
		return result;
	}


	/**
	 * 批量删除角色 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除角色")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RoleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RoleVOMeta.IDS)
		@SentinelResource(value = RoleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleServiceProxy.GET_BY_IDS)
	public Result<List<Role>> getByIds(List<String> ids) {
		Result<List<Role>> result=new Result<>();
		List<Role> list=roleService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询角色
	*/
	@ApiOperation(value = "查询角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110352463290923000"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "business_man"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "业务员"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RoleVOMeta.PAGE_INDEX , RoleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RoleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleServiceProxy.QUERY_LIST)
	public Result<List<Role>> queryList(RoleVO sample) {
		Result<List<Role>> result=new Result<>();
		List<Role> list=roleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询角色
	*/
	@ApiOperation(value = "分页查询角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RoleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "110352463290923000"),
		@ApiImplicitParam(name = RoleVOMeta.CODE , value = "代码" , required = false , dataTypeClass=String.class , example = "business_man"),
		@ApiImplicitParam(name = RoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "业务员"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RoleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RoleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Role>> queryPagedList(RoleVO sample) {
		Result<PagedList<Role>> result=new Result<>();
		PagedList<Role> list=roleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RoleServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RoleServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RoleVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=roleService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RoleServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RoleServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=roleService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = RoleServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RoleServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=roleService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}