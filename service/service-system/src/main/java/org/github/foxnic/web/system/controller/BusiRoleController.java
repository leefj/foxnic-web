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


import org.github.foxnic.web.proxy.system.BusiRoleServiceProxy;
import org.github.foxnic.web.domain.system.meta.BusiRoleVOMeta;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.system.BusiRoleVO;
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
import org.github.foxnic.web.domain.system.meta.BusiRoleMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.IBusiRoleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 业务角色表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-10 18:56:11
*/

@Api(tags = "业务角色")
@ApiSort(0)
@RestController("SysBusiRoleController")
public class BusiRoleController extends SuperController {

	@Autowired
	private IBusiRoleService busiRoleService;


	/**
	 * 添加业务角色
	*/
	@ApiOperation(value = "添加业务角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "498946989573017600"),
		@ApiImplicitParam(name = BusiRoleVOMeta.ORG_ID , value = "所属组织ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.CODE , value = "角色代码" , required = false , dataTypeClass=String.class , example = "drafter"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NAME , value = "角色名称" , required = false , dataTypeClass=String.class , example = "起草人"),
		@ApiImplicitParam(name = BusiRoleVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = BusiRoleVOMeta.VALID)
	@SentinelResource(value = BusiRoleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleServiceProxy.INSERT)
	public Result insert(BusiRoleVO busiRoleVO) {
		Result result=busiRoleService.insert(busiRoleVO,false);
		return result;
	}



	/**
	 * 删除业务角色
	*/
	@ApiOperation(value = "删除业务角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "498946989573017600")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = BusiRoleVOMeta.ID)
	@SentinelResource(value = BusiRoleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=busiRoleService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除业务角色 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除业务角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = BusiRoleVOMeta.IDS)
	@SentinelResource(value = BusiRoleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=busiRoleService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新业务角色
	*/
	@ApiOperation(value = "更新业务角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "498946989573017600"),
		@ApiImplicitParam(name = BusiRoleVOMeta.ORG_ID , value = "所属组织ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.CODE , value = "角色代码" , required = false , dataTypeClass=String.class , example = "drafter"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NAME , value = "角色名称" , required = false , dataTypeClass=String.class , example = "起草人"),
		@ApiImplicitParam(name = BusiRoleVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { BusiRoleVOMeta.PAGE_INDEX , BusiRoleVOMeta.PAGE_SIZE , BusiRoleVOMeta.SEARCH_FIELD , BusiRoleVOMeta.FUZZY_FIELD , BusiRoleVOMeta.SEARCH_VALUE , BusiRoleVOMeta.SORT_FIELD , BusiRoleVOMeta.SORT_TYPE , BusiRoleVOMeta.IDS } )
	@NotNull(name = BusiRoleVOMeta.ID)
	@NotNull(name = BusiRoleVOMeta.VALID)
	@SentinelResource(value = BusiRoleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleServiceProxy.UPDATE)
	public Result update(BusiRoleVO busiRoleVO) {
		Result result=busiRoleService.update(busiRoleVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存业务角色
	*/
	@ApiOperation(value = "保存业务角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "498946989573017600"),
		@ApiImplicitParam(name = BusiRoleVOMeta.ORG_ID , value = "所属组织ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.CODE , value = "角色代码" , required = false , dataTypeClass=String.class , example = "drafter"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NAME , value = "角色名称" , required = false , dataTypeClass=String.class , example = "起草人"),
		@ApiImplicitParam(name = BusiRoleVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BusiRoleVOMeta.PAGE_INDEX , BusiRoleVOMeta.PAGE_SIZE , BusiRoleVOMeta.SEARCH_FIELD , BusiRoleVOMeta.FUZZY_FIELD , BusiRoleVOMeta.SEARCH_VALUE , BusiRoleVOMeta.SORT_FIELD , BusiRoleVOMeta.SORT_TYPE , BusiRoleVOMeta.IDS } )
	@NotNull(name = BusiRoleVOMeta.ID)
	@NotNull(name = BusiRoleVOMeta.VALID)
	@SentinelResource(value = BusiRoleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleServiceProxy.SAVE)
	public Result save(BusiRoleVO busiRoleVO) {
		Result result=busiRoleService.save(busiRoleVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取业务角色
	*/
	@ApiOperation(value = "获取业务角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = BusiRoleVOMeta.ID)
	@SentinelResource(value = BusiRoleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleServiceProxy.GET_BY_ID)
	public Result<BusiRole> getById(String id) {
		Result<BusiRole> result=new Result<>();
		BusiRole busiRole=busiRoleService.getById(id);

		// join 关联的对象
		busiRoleService.dao().fill(busiRole)
			.execute();

		result.success(true).data(busiRole);
		return result;
	}


	/**
	 * 批量获取业务角色 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取业务角色")
		@ApiImplicitParams({
				@ApiImplicitParam(name = BusiRoleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = BusiRoleVOMeta.IDS)
		@SentinelResource(value = BusiRoleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleServiceProxy.GET_BY_IDS)
	public Result<List<BusiRole>> getByIds(List<String> ids) {
		Result<List<BusiRole>> result=new Result<>();
		List<BusiRole> list=busiRoleService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询业务角色
	*/
	@ApiOperation(value = "查询业务角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "498946989573017600"),
		@ApiImplicitParam(name = BusiRoleVOMeta.ORG_ID , value = "所属组织ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.CODE , value = "角色代码" , required = false , dataTypeClass=String.class , example = "drafter"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NAME , value = "角色名称" , required = false , dataTypeClass=String.class , example = "起草人"),
		@ApiImplicitParam(name = BusiRoleVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BusiRoleVOMeta.PAGE_INDEX , BusiRoleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = BusiRoleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleServiceProxy.QUERY_LIST)
	public Result<List<BusiRole>> queryList(BusiRoleVO sample) {
		Result<List<BusiRole>> result=new Result<>();
		List<BusiRole> list=busiRoleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询业务角色
	*/
	@ApiOperation(value = "分页查询业务角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "498946989573017600"),
		@ApiImplicitParam(name = BusiRoleVOMeta.ORG_ID , value = "所属组织ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.CODE , value = "角色代码" , required = false , dataTypeClass=String.class , example = "drafter"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NAME , value = "角色名称" , required = false , dataTypeClass=String.class , example = "起草人"),
		@ApiImplicitParam(name = BusiRoleVOMeta.VALID , value = "是否有效" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = BusiRoleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<BusiRole>> queryPagedList(BusiRoleVO sample) {
		Result<PagedList<BusiRole>> result=new Result<>();
		PagedList<BusiRole> list=busiRoleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		busiRoleService.dao().fill(list)
			.execute();

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = BusiRoleServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(BusiRoleServiceProxy.EXPORT_EXCEL)
	public void exportExcel(BusiRoleVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=busiRoleService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = BusiRoleServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(BusiRoleServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=busiRoleService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = BusiRoleServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(BusiRoleServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=busiRoleService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}