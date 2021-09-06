package org.github.foxnic.web.pcm.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.commons.lang.StringUtil;
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
import org.github.foxnic.web.domain.oauth.meta.MenuVOMeta;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogData;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import org.github.foxnic.web.domain.pcm.DataQueryVo;
import org.github.foxnic.web.domain.pcm.meta.CatalogVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.misc.xmselect.SelectItem;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.pcm.service.ICatalogService;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据存储表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-28 15:45:05
 * @version 20210830
*/

@Api(tags = "数据存储")
@ApiSort(0)
@RestController("PcmCatalogController")
public class CatalogController extends SuperController {

	@Autowired
	private ICatalogService catalogService;

	
	/**
	 * 添加数据存储
	*/
	@ApiOperation(value = "添加数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.DATA_TABLE , value = "存储表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.TENANT_ID , value = "租户ID" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = CatalogVOMeta.ID)
	@NotNull(name = CatalogVOMeta.TENANT_ID)
	@SentinelResource(value = CatalogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.INSERT)
	public Result insert(CatalogVO catalogVO) {

		catalogVO.setSort(999999);
		if(StringUtil.isBlank(catalogVO.getParentId())) {
			catalogVO.setParentId(ICatalogService.ROOT_ID);
		}
		Result result=catalogService.insert(catalogVO);
		if(result.success()) {
			result.data(catalogVO);
		}
		return result;
	}

	
	/**
	 * 删除数据存储
	*/
	@ApiOperation(value = "删除数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CatalogVOMeta.ID)
	@SentinelResource(value = CatalogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result = new Result();
		List children=catalogService.queryChildNodes(id);
		if(!children.isEmpty()) {
			result.success(false).message("请先删除下级节点");
			return result;
		}
		int dataCount=catalogService.getDataCount(id);
		if(dataCount>0) {
			result.success(false).message("请先删除分类数据");
			return result;
		}
		result=catalogService.deleteByIdLogical(id);
		return result;
	}

	/**
	 * 更新数据存储
	*/
	@ApiOperation(value = "更新数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.DATA_TABLE , value = "存储表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.TENANT_ID , value = "租户ID" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CatalogVOMeta.PAGE_INDEX , CatalogVOMeta.PAGE_SIZE , CatalogVOMeta.SEARCH_FIELD , CatalogVOMeta.FUZZY_FIELD , CatalogVOMeta.SEARCH_VALUE , CatalogVOMeta.SORT_FIELD , CatalogVOMeta.SORT_TYPE , CatalogVOMeta.IDS } ) 
	@NotNull(name = CatalogVOMeta.ID)
	@NotNull(name = CatalogVOMeta.TENANT_ID)
	@SentinelResource(value = CatalogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.UPDATE)
	public Result update(CatalogVO catalogVO) {
		Result result=catalogService.update(catalogVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存数据存储
	*/
	@ApiOperation(value = "保存数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.DATA_TABLE , value = "存储表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.TENANT_ID , value = "租户ID" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CatalogVOMeta.PAGE_INDEX , CatalogVOMeta.PAGE_SIZE , CatalogVOMeta.SEARCH_FIELD , CatalogVOMeta.FUZZY_FIELD , CatalogVOMeta.SEARCH_VALUE , CatalogVOMeta.SORT_FIELD , CatalogVOMeta.SORT_TYPE , CatalogVOMeta.IDS } )
	@NotNull(name = CatalogVOMeta.ID)
	@NotNull(name = CatalogVOMeta.TENANT_ID)
	@SentinelResource(value = CatalogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.SAVE)
	public Result save(CatalogVO catalogVO) {
		Result result=catalogService.save(catalogVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取数据存储
	*/
	@ApiOperation(value = "获取数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CatalogVOMeta.ID)
	@SentinelResource(value = CatalogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.GET_BY_ID)
	public Result<Catalog> getById(String id) {
		Result<Catalog> result=new Result<>();
		Catalog catalog=catalogService.getById(id);
		result.success(true).data(catalog);
		return result;
	}


	/**
	 * 批量删除数据存储 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除数据存储")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CatalogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CatalogVOMeta.IDS)
		@SentinelResource(value = CatalogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.GET_BY_IDS)
	public Result<List<Catalog>> getByIds(List<String> ids) {
		Result<List<Catalog>> result=new Result<>();
		List<Catalog> list=catalogService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询数据存储
	*/
	@ApiOperation(value = "查询数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.DATA_TABLE , value = "存储表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.TENANT_ID , value = "租户ID" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CatalogVOMeta.PAGE_INDEX , CatalogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CatalogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.QUERY_LIST)
	public Result<List<Catalog>> queryList(CatalogVO sample) {
		Result<List<Catalog>> result=new Result<>();
		List<Catalog> list=catalogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据存储
	 */
	@ApiOperation(value = "查询数据存储")
	@ApiImplicitParams({
			@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class),
			@ApiImplicitParam(name = CatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = CatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
			@ApiImplicitParam(name = CatalogVOMeta.DATA_TABLE , value = "存储表" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = CatalogVOMeta.TENANT_ID , value = "租户ID" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CatalogVOMeta.PAGE_INDEX , CatalogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CatalogServiceProxy.QUERY_NODES , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.QUERY_NODES)
	public Result<List<ZTreeNode>> queryNodes(CatalogVO sample) {

		Result<List<ZTreeNode>> result=new Result<>();
		List<ZTreeNode> list=null;
		if(sample.getParentId()==null) {
			list=catalogService.queryRootNotes();
		} else {
			list=catalogService.queryChildNodes(sample.getParentId());
		}

		//加载全部子孙节点
		if(sample.getIsLoadAllDescendants()!=null && sample.getIsLoadAllDescendants()==1) {
			list = catalogService.buildingHierarchicalRelationships(list);
		}
		result.success(true).data(list);
		return result;

	}


	/**
	 * 变更分类层级关系
	 */
	@ApiOperation(value = "变更分类层级关系")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ids" , value = "ID" , required = true , dataTypeClass=String.class , example = "451739184575545344"),
			@ApiImplicitParam(name = MenuVOMeta.PARENT_ID , value = "新的上级节点ID" , required = true , dataTypeClass=String.class , example = "451739184575545344")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = "ids")
	@SentinelResource(value = CatalogServiceProxy.SAVE_HIERARCHY)
	@PostMapping(CatalogServiceProxy.SAVE_HIERARCHY)
	public Result<Catalog> changeParent(List<String> ids, String parentId) {
		Result<Catalog> result=new Result<>();
		Boolean suc=catalogService.saveHierarchy(ids,parentId);
		result.success(suc);
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
	@SentinelResource(value = CatalogServiceProxy.SEARCH)
	@PostMapping(CatalogServiceProxy.SEARCH)
	public Result<List<String>> search(String keyword) {
		Result<List<String>> result=new Result<>();
		List<String> hierarchyList=catalogService.search(keyword);
		result.data(hierarchyList);
		return result;
	}

	
	/**
	 * 分页查询数据存储
	*/
	@ApiOperation(value = "分页查询数据存储")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CatalogVOMeta.DATA_TABLE , value = "存储表" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CatalogVOMeta.TENANT_ID , value = "租户ID" , required = true , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CatalogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CatalogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Catalog>> queryPagedList(CatalogVO sample) {
		Result<PagedList<Catalog>> result=new Result<>();
		PagedList<Catalog> list=catalogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CatalogServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CatalogServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CatalogVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=catalogService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CatalogServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CatalogServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=catalogService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = CatalogServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CatalogServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=catalogService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}



	/**
	 * 返回数据表清单
	 */
	@ApiOperation(value = "返回数据表清单")
	@ApiOperationSupport(order=2)
	@SentinelResource(value = CatalogServiceProxy.STORAGE_TABLES)
	@PostMapping(CatalogServiceProxy.STORAGE_TABLES)
	public Result<List<String>> storageTables() {
		Result<List<String>> result=new Result<>();
		List<String> tables=catalogService.getStorageTables();
		result.data(tables);
		return result;
	}

	/**
	 * 查询分类下的版本
	 */
	@ApiOperation(value = "查询分类下的版本")
	@ApiOperationSupport(order=2)
	@SentinelResource(value = CatalogServiceProxy.VERSIONS)
	@PostMapping(CatalogServiceProxy.VERSIONS)
	public Result<List<SelectItem>> versions(CatalogVO sample) {
		Result<List<SelectItem>> result=new Result<>();
		List<String> versions=catalogService.getVersions(sample.getId());
		//如果没有版本，默认为编辑版本
		if(versions.isEmpty()){
			versions.add(ICatalogService.VERSION_EDITING);
		}
		List<SelectItem> items=new ArrayList<>();
		for (String version : versions) {
			SelectItem item=new SelectItem();
			item.setValue(version);
			if(ICatalogService.VERSION_EDITING.equals(version)) {
				item.setName("编辑版");
			} else if(ICatalogService.VERSION_ACTIVATED.equals(version)) {
				item.setName("生效版");
			} else {
				item.setName(version);
			}
			items.add(item);
		}

		result.data(items);
		return result;
	}


	/**
	 * 创建一个编辑的版本
	 */
	@ApiOperation(value = "创建一个编辑的版本")
	@ApiOperationSupport(order=2)
	@SentinelResource(value = CatalogServiceProxy.CREATE_VERSION)
	@PostMapping(CatalogServiceProxy.CREATE_VERSION)
	public Result createVersion(CatalogVO sample) {
		return catalogService.createVersion(sample.getId());
	}

	/**
	 * 生效一个编辑中的版本
	 */
	@ApiOperation(value = "生效一个编辑中的版本")
	@ApiOperationSupport(order=2)
	@SentinelResource(value = CatalogServiceProxy.APPLY_VERSION)
	@PostMapping(CatalogServiceProxy.APPLY_VERSION)
	public Result applyVersion(CatalogVO sample) {
		return catalogService.applyVersion(sample.getId());
	}


	/**
	 * 查询分类数据
	 */
	@ApiOperation(value = "查询分类数据")
	@ApiOperationSupport(order=2)
	@SentinelResource(value = CatalogServiceProxy.QUERY_DATA)
	@PostMapping(CatalogServiceProxy.QUERY_DATA)
	public Result queryData(DataQueryVo dataQueryVo) {
		if(StringUtil.isBlank(dataQueryVo.getTenantId())){
			return ErrorDesc.failure(CommonError.PARAM_INVALID).message("缺少租户参数");
		}
		if(StringUtil.isBlank(dataQueryVo.getCatalogId())){
			return ErrorDesc.failure(CommonError.PARAM_INVALID).message("缺少类目ID");
		}
		if(dataQueryVo.getOwnerIds()==null || dataQueryVo.getOwnerIds().isEmpty()){
			return ErrorDesc.failure(CommonError.PARAM_INVALID).message("缺少所有者ID");
		}

		if(dataQueryVo.getOwnerIds()!=null && !dataQueryVo.getOwnerIds().isEmpty()
		&& dataQueryVo.getIds()!=null && !dataQueryVo.getIds().isEmpty()){
			return ErrorDesc.failure(CommonError.PARAM_INVALID).message("不能同时指定 ids 和 ownerIds 参数");
		}

		return catalogService.queryData(dataQueryVo);
	}



	/**
	 * 保存多个分类数据
	 */
	@ApiOperation(value = "保存多个分类数据")
	@ApiOperationSupport(order=2)
	@SentinelResource(value = CatalogServiceProxy.SAVE_DATA_LIST)
	@PostMapping(CatalogServiceProxy.SAVE_DATA_LIST)
	public Result saveDataList(List<CatalogData> catalogDataList) {
		Result result=new Result();
		int i=0;
		for (CatalogData dataQueryVo : catalogDataList) {
			if(StringUtil.isBlank(dataQueryVo.getTenantId())){
				result.addError(ErrorDesc.failure(CommonError.PARAM_INVALID).message("第"+i+"行，缺少租户参数"));
			}
			if(StringUtil.isBlank(dataQueryVo.getCatalogId())){
				result.addError(ErrorDesc.failure(CommonError.PARAM_INVALID).message("第"+i+"行，缺少类目ID"));
			}
			if(StringUtil.isBlank(dataQueryVo.getOwnerId())){
				result.addError(ErrorDesc.failure(CommonError.PARAM_INVALID).message("第"+i+"行，缺少所有者ID"));
			}
		}
		if(result.hasSubError()){
			return result;
		}

		return catalogService.saveDataList(catalogDataList);
	}

	/**
	 * 保存单个分类数据
	 */
	@ApiOperation(value = "保存单个分类数据")
	@ApiOperationSupport(order=2)
	@SentinelResource(value = CatalogServiceProxy.SAVE_DATA)
	@PostMapping(CatalogServiceProxy.SAVE_DATA)
	public Result saveData(CatalogData catalogData) {
		Result result=new Result();
		if(StringUtil.isBlank(catalogData.getTenantId())){
			result.addError(ErrorDesc.failure(CommonError.PARAM_INVALID).message("缺少租户参数"));
		}
		if(StringUtil.isBlank(catalogData.getCatalogId())){
			result.addError(ErrorDesc.failure(CommonError.PARAM_INVALID).message("缺少类目ID"));
		}
		if(StringUtil.isBlank(catalogData.getOwnerId())){
			result.addError(ErrorDesc.failure(CommonError.PARAM_INVALID).message("缺少所有者ID"));
		}
		if(result.hasSubError()){
			return result;
		}
		return catalogService.saveDataList(Arrays.asList(catalogData));
	}


	/**
	 * 删除分类数据
	 */
	@ApiOperation(value = "删除分类数据")
	@ApiOperationSupport(order=2)
	@SentinelResource(value = CatalogServiceProxy.DELETE_DATA)
	@PostMapping(CatalogServiceProxy.DELETE_DATA)
	public Result deleteData(DataQueryVo dataQueryVo) {
		if(dataQueryVo.getIds()==null || dataQueryVo.getIds().isEmpty()) {
			return ErrorDesc.failure(CommonError.PARAM_INVALID).message("至少指定一个id值");
		}
		if(StringUtil.isBlank(dataQueryVo.getCatalogId())){
			return ErrorDesc.failure(CommonError.PARAM_INVALID).message("缺少类目ID");
		}
		return catalogService.deleteData(dataQueryVo);
	}


}