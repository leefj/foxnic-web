package com.scientific.tailoring.product.controller;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.scientific.tailoring.domain.product.LabelNodeModel;
import com.scientific.tailoring.domain.product.LabelVO;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.scientific.tailoring.domain.product.meta.LabelVOMeta;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.product.Label;
import com.scientific.tailoring.domain.system.MenuNodeModel;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.springboot.mvc.Result;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.scientific.tailoring.product.service.ILabelService;
import com.scientific.tailoring.proxy.product.LabelServiceProxy;
import com.scientific.tailoring.proxy.system.MenuServiceProxy;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-19 09:11:39
*/

@Api(tags = "产品标签")
@ApiSort(1108)
@RestController("PrdLabelController")
public class LabelController extends SuperController {

	@Autowired
	private ILabelService labelService;

	
	/**
	 * 添加产品标签
	*/
	@RequiresPermissions("PrdLabel:insert")
	@ApiOperation(value = "添加产品标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LabelVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "化工"),
		@ApiImplicitParam(name = LabelVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = LabelVOMeta.ID , value = "id" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = LabelVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {LabelVOMeta.PAGE_INDEX , LabelVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = LabelServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LabelServiceProxy.INSERT)
	public  Result<Label> insert(LabelVO labelVO) {
		Result<Label> result=new Result<>();
		boolean suc=labelService.insert(labelVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除产品标签
	*/
	@RequiresPermissions("PrdLabel:deleteById")
	@ApiOperation(value = "删除产品标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LabelVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = LabelVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = LabelServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LabelServiceProxy.DELETE)
	public  Result deleteById(Integer id) {
		Result result=new Result();
		boolean suc=labelService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 按主键批量删除产品标签
	*/
	@RequiresPermissions("PrdLabel:deleteByIds")
	@ApiOperation(value = "按主键批量删除产品标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LabelVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class , example = "1")
	})
	@NotNull(name = LabelVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = LabelServiceProxy.BATCH_DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LabelServiceProxy.BATCH_DELETE)
	public  Result deleteByIds(List<Integer> id) {
		Result result=new Result();
		boolean suc=labelService.deleteByIdsLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新产品标签
	*/
	@RequiresPermissions("PrdLabel:update")
	@ApiOperation(value = "更新产品标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LabelVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = LabelVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "化工"),
		@ApiImplicitParam(name = LabelVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
	})
	@NotNull(name = LabelVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {LabelVOMeta.PAGE_INDEX , LabelVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = LabelServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LabelServiceProxy.UPDATE)
	public  Result<Label> update(LabelVO labelVO) {
		Result<Label> result=new Result<>();
		boolean suc=labelService.update(labelVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取产品标签
	*/
	@RequiresPermissions("PrdLabel:getById")
	@ApiOperation(value = "按主键获取产品标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LabelVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class , example = "1"),
	})
	@NotNull(name = LabelVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = LabelServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LabelServiceProxy.GET_BY_ID)
	public  Result<Label> getById(Integer id) {
		Result<Label> result=new Result<>();
		Label label=labelService.getById(id);
		result.success(true).data(label);
		return result;
	}

	
	/**
	 * 查询全部符合条件的产品标签
	*/
	@RequiresPermissions("PrdLabel:queryList")
	@ApiOperation(value = "查询产品标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LabelVOMeta.ID , value = "编号" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = LabelVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "化工"),
		@ApiImplicitParam(name = LabelVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(ignoreParameters = {LabelVOMeta.PAGE_INDEX , LabelVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = LabelServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LabelServiceProxy.QUERY_LIST)
	public  Result<List<Label>> queryList(LabelVO sample) {
		Result<List<Label>> result=new Result<>();
		List<Label> list=labelService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的产品标签
	*/
	@RequiresPermissions("PrdLabel:queryPagedList")
	@ApiOperation(value = "分页查询产品标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LabelVOMeta.ID , value = "编号" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = LabelVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "化工"),
		@ApiImplicitParam(name = LabelVOMeta.PARENT_ID , value = "上级ID" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = LabelVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = LabelVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = LabelServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(LabelServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<Label>> queryPagedList(LabelVO sample) {
		Result<PagedList<Label>> result=new Result<>();
		PagedList<Label> list=labelService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 获取产品标签的分层结构
	 */
	@RequiresPermissions("PrdLabel:getLabelTree")
	@ApiOperation(value = "获取产品标签的分层结构")
	@ApiOperationSupport(order=8)
	@PostMapping(LabelServiceProxy.API_PREFIX+"/get-label-tree")
	public  Result<List<LabelNodeModel>> getMenuTree() {
		Result<List<LabelNodeModel>> result=new Result<>();
		List<LabelNodeModel> roots=labelService.getLabelTree(this.getSessionUserId());
		return ErrorDesc.success(result).data(roots);
	}


}