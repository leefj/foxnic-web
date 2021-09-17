package org.github.foxnic.web.hrm.controller;


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
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.hrm.meta.OrganizationVOMeta;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.hrm.service.IOrganizationService;
import org.github.foxnic.web.hrm.service.IPositionService;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
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
 * 组织层级表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-13 15:09:51
 * @version 20210903
*/

@Api(tags = "组织层级")
@ApiSort(0)
@RestController("HrmOrganizationController")
public class OrganizationController extends SuperController {

	@Autowired
	private IOrganizationService organizationService;

	@Autowired
	private IPositionService positionService;

	
	/**
	 * 添加组织层级
	*/
	@ApiOperation(value = "添加组织层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrganizationVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.SHORT_NAME , value = "简称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.FULL_NAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.TYPE , value = "组织类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OrganizationVOMeta.HIERARCHY , value = "层级路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = OrganizationVOMeta.ID)
	@SentinelResource(value = OrganizationServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrganizationServiceProxy.INSERT)
	public Result insert(OrganizationVO organizationVO) {
		Result result=organizationService.insert(organizationVO);
		if(result.success()) {
			result.data(organizationVO);
		}
		return result;
	}

	
	/**
	 * 删除组织层级
	*/
	@ApiOperation(value = "删除组织层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrganizationVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = OrganizationVOMeta.ID)
	@SentinelResource(value = OrganizationServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrganizationServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=new Result();
		Organization organization=organizationService.getById(id);
		List<Organization> children=organizationService.queryList(Organization.create().setParentId(organization.getId()));
		if(!children.isEmpty()) {
			result.success(false).message("请先删除子节点");
			return result;
		}
		List<Position> positions=positionService.queryPositions(organization.getId());
		if(!positions.isEmpty()) {
			result.success(false).message("请先删除子节点");
			return result;
		}

		result=organizationService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除组织层级 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除组织层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrganizationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = OrganizationVOMeta.IDS)
	@SentinelResource(value = OrganizationServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrganizationServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=organizationService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新组织层级
	*/
	@ApiOperation(value = "更新组织层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrganizationVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.SHORT_NAME , value = "简称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.FULL_NAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.TYPE , value = "组织类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OrganizationVOMeta.HIERARCHY , value = "层级路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { OrganizationVOMeta.PAGE_INDEX , OrganizationVOMeta.PAGE_SIZE , OrganizationVOMeta.SEARCH_FIELD , OrganizationVOMeta.FUZZY_FIELD , OrganizationVOMeta.SEARCH_VALUE , OrganizationVOMeta.SORT_FIELD , OrganizationVOMeta.SORT_TYPE , OrganizationVOMeta.IDS } ) 
	@NotNull(name = OrganizationVOMeta.ID)
	@SentinelResource(value = OrganizationServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrganizationServiceProxy.UPDATE)
	public Result update(OrganizationVO organizationVO) {
		Result result=organizationService.update(organizationVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存组织层级
	*/
	@ApiOperation(value = "保存组织层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrganizationVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.SHORT_NAME , value = "简称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.FULL_NAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.TYPE , value = "组织类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OrganizationVOMeta.HIERARCHY , value = "层级路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { OrganizationVOMeta.PAGE_INDEX , OrganizationVOMeta.PAGE_SIZE , OrganizationVOMeta.SEARCH_FIELD , OrganizationVOMeta.FUZZY_FIELD , OrganizationVOMeta.SEARCH_VALUE , OrganizationVOMeta.SORT_FIELD , OrganizationVOMeta.SORT_TYPE , OrganizationVOMeta.IDS } )
	@NotNull(name = OrganizationVOMeta.ID)
	@SentinelResource(value = OrganizationServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrganizationServiceProxy.SAVE)
	public Result save(OrganizationVO organizationVO) {
		Result result=organizationService.save(organizationVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取组织层级
	*/
	@ApiOperation(value = "获取组织层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrganizationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = OrganizationVOMeta.ID)
	@SentinelResource(value = OrganizationServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrganizationServiceProxy.GET_BY_ID)
	public Result<Organization> getById(String id) {
		Result<Organization> result=new Result<>();
		Organization organization=organizationService.getById(id);
		result.success(true).data(organization);
		return result;
	}


	/**
	 * 批量删除组织层级 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除组织层级")
		@ApiImplicitParams({
				@ApiImplicitParam(name = OrganizationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = OrganizationVOMeta.IDS)
		@SentinelResource(value = OrganizationServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrganizationServiceProxy.GET_BY_IDS)
	public Result<List<Organization>> getByIds(List<String> ids) {
		Result<List<Organization>> result=new Result<>();
		List<Organization> list=organizationService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询组织层级
	*/
	@ApiOperation(value = "查询组织层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrganizationVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.SHORT_NAME , value = "简称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.FULL_NAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.TYPE , value = "组织类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OrganizationVOMeta.HIERARCHY , value = "层级路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { OrganizationVOMeta.PAGE_INDEX , OrganizationVOMeta.PAGE_SIZE } )
	@SentinelResource(value = OrganizationServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrganizationServiceProxy.QUERY_LIST)
	public Result<List<Organization>> queryList(OrganizationVO sample) {
		Result<List<Organization>> result=new Result<>();
		List<Organization> list=organizationService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询组织层级
	*/
	@ApiOperation(value = "分页查询组织层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OrganizationVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.SHORT_NAME , value = "简称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.FULL_NAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.TYPE , value = "组织类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = OrganizationVOMeta.HIERARCHY , value = "层级路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OrganizationVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = OrganizationServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrganizationServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Organization>> queryPagedList(OrganizationVO sample) {
		Result<PagedList<Organization>> result=new Result<>();
		PagedList<Organization> list=organizationService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据存储
	 */
	@ApiOperation(value = "查询组织节点")
	@ApiImplicitParams({
			@ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { OrganizationVOMeta.PAGE_INDEX , OrganizationVOMeta.PAGE_SIZE } )
	@SentinelResource(value = OrganizationServiceProxy.QUERY_NODES , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OrganizationServiceProxy.QUERY_NODES)
	public Result<List<ZTreeNode>> queryNodes(OrganizationVO sample) {

		Result<List<ZTreeNode>> result=new Result<>();
		List<ZTreeNode> list=null;
		if(sample.getParentId()==null) {
			list=organizationService.queryRootNotes(sample.getRoot(),sample.getTargetType());
		} else {
			list=organizationService.queryChildNodes(sample.getParentId(),sample.getTargetType());
		}

		//加载全部子孙节点
		if(sample.getIsLoadAllDescendants()!=null && sample.getIsLoadAllDescendants()==1) {
			list = organizationService.buildingHierarchicalRelationships(list,sample.getTargetType());
		}
		result.success(true).data(list);
		return result;

	}

	/**
	 * 搜索分类层级
	 */
	@ApiOperation(value = "搜索分类层级")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "keyword" , value = "keyword" , required = true , dataTypeClass=String.class , example = "橡胶")
	})
	@ApiOperationSupport(order=2)
	@SentinelResource(value = OrganizationServiceProxy.SEARCH)
	@PostMapping(OrganizationServiceProxy.SEARCH)
	public Result<List<String>> search(String keyword) {
		Result<List<String>> result=new Result<>();
		List<String> hierarchyList=organizationService.search(keyword);
		result.data(hierarchyList);
		return result;
	}

	/**
	 * 变更分类层级关系
	 */
	@ApiOperation(value = "变更分类层级关系")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ids" , value = "ID" , required = true , dataTypeClass=String.class , example = "451739184575545344"),
			@ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID , value = "新的上级节点ID" , required = true , dataTypeClass=String.class , example = "451739184575545344")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = "ids")
	@SentinelResource(value = OrganizationServiceProxy.SAVE_HIERARCHY)
	@PostMapping(OrganizationServiceProxy.SAVE_HIERARCHY)
	public Result<Catalog> changeParent(List<String> ids, String parentId) {
		Result<Catalog> result=new Result<>();
		Boolean suc=organizationService.saveHierarchy(ids,parentId);
		result.success(suc);
		return result;
	}

	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = OrganizationServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(OrganizationServiceProxy.EXPORT_EXCEL)
	public void exportExcel(OrganizationVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=organizationService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = OrganizationServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(OrganizationServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=organizationService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = OrganizationServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(OrganizationServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=organizationService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}