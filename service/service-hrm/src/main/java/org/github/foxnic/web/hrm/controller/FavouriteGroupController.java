package org.github.foxnic.web.hrm.controller;


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


import org.github.foxnic.web.proxy.hrm.FavouriteGroupServiceProxy;
import org.github.foxnic.web.domain.hrm.meta.FavouriteGroupVOMeta;
import org.github.foxnic.web.domain.hrm.FavouriteGroup;
import org.github.foxnic.web.domain.hrm.FavouriteGroupVO;
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
import org.github.foxnic.web.domain.hrm.meta.FavouriteGroupMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.hrm.service.IFavouriteGroupService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 常用人员分组表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:24:59
*/

@Api(tags = "常用人员分组")
@ApiSort(0)
@RestController("HrmFavouriteGroupController")
public class FavouriteGroupController extends SuperController {

	@Autowired
	private IFavouriteGroupService favouriteGroupService;


	/**
	 * 添加常用人员分组
	*/
	@ApiOperation(value = "添加常用人员分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.NAME , value = "组名" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.PARENT_ID , value = "上级ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.EMPLOYEE_ID , value = "所有者ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.HIERARCHY , value = "层级路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = FavouriteGroupServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FavouriteGroupServiceProxy.INSERT)
	public Result insert(FavouriteGroupVO favouriteGroupVO) {
		Result result=favouriteGroupService.insert(favouriteGroupVO,false);
		return result;
	}



	/**
	 * 删除常用人员分组
	*/
	@ApiOperation(value = "删除常用人员分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = FavouriteGroupVOMeta.ID)
	@SentinelResource(value = FavouriteGroupServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FavouriteGroupServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		Boolean hasRefer = favouriteGroupService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(hasRefer).requireEqual("不允许删除当前记录",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=favouriteGroupService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除常用人员分组 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除常用人员分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = FavouriteGroupVOMeta.IDS)
	@SentinelResource(value = FavouriteGroupServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FavouriteGroupServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, Boolean> hasRefersMap = favouriteGroupService.hasRefers(ids);
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
			Result result=favouriteGroupService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=favouriteGroupService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新常用人员分组
	*/
	@ApiOperation(value = "更新常用人员分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.NAME , value = "组名" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.PARENT_ID , value = "上级ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.EMPLOYEE_ID , value = "所有者ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.HIERARCHY , value = "层级路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { FavouriteGroupVOMeta.PAGE_INDEX , FavouriteGroupVOMeta.PAGE_SIZE , FavouriteGroupVOMeta.SEARCH_FIELD , FavouriteGroupVOMeta.FUZZY_FIELD , FavouriteGroupVOMeta.SEARCH_VALUE , FavouriteGroupVOMeta.DIRTY_FIELDS , FavouriteGroupVOMeta.SORT_FIELD , FavouriteGroupVOMeta.SORT_TYPE , FavouriteGroupVOMeta.IDS } )
	@SentinelResource(value = FavouriteGroupServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FavouriteGroupServiceProxy.UPDATE)
	public Result update(FavouriteGroupVO favouriteGroupVO) {
		Result result=favouriteGroupService.update(favouriteGroupVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存常用人员分组
	*/
	@ApiOperation(value = "保存常用人员分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.NAME , value = "组名" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.PARENT_ID , value = "上级ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.EMPLOYEE_ID , value = "所有者ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.HIERARCHY , value = "层级路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { FavouriteGroupVOMeta.PAGE_INDEX , FavouriteGroupVOMeta.PAGE_SIZE , FavouriteGroupVOMeta.SEARCH_FIELD , FavouriteGroupVOMeta.FUZZY_FIELD , FavouriteGroupVOMeta.SEARCH_VALUE , FavouriteGroupVOMeta.DIRTY_FIELDS , FavouriteGroupVOMeta.SORT_FIELD , FavouriteGroupVOMeta.SORT_TYPE , FavouriteGroupVOMeta.IDS } )
	@NotNull(name = FavouriteGroupVOMeta.ID)
	@NotNull(name = FavouriteGroupVOMeta.NAME)
	@NotNull(name = FavouriteGroupVOMeta.PARENT_ID)
	@NotNull(name = FavouriteGroupVOMeta.EMPLOYEE_ID)
	@SentinelResource(value = FavouriteGroupServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FavouriteGroupServiceProxy.SAVE)
	public Result save(FavouriteGroupVO favouriteGroupVO) {
		Result result=favouriteGroupService.save(favouriteGroupVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取常用人员分组
	*/
	@ApiOperation(value = "获取常用人员分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = FavouriteGroupVOMeta.ID)
	@SentinelResource(value = FavouriteGroupServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FavouriteGroupServiceProxy.GET_BY_ID)
	public Result<FavouriteGroup> getById(String id) {
		Result<FavouriteGroup> result=new Result<>();
		FavouriteGroup favouriteGroup=favouriteGroupService.getById(id);
		result.success(true).data(favouriteGroup);
		return result;
	}


	/**
	 * 批量获取常用人员分组 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取常用人员分组")
		@ApiImplicitParams({
				@ApiImplicitParam(name = FavouriteGroupVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = FavouriteGroupVOMeta.IDS)
		@SentinelResource(value = FavouriteGroupServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FavouriteGroupServiceProxy.GET_BY_IDS)
	public Result<List<FavouriteGroup>> getByIds(List<String> ids) {
		Result<List<FavouriteGroup>> result=new Result<>();
		List<FavouriteGroup> list=favouriteGroupService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询常用人员分组
	*/
	@ApiOperation(value = "查询常用人员分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.NAME , value = "组名" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.PARENT_ID , value = "上级ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.EMPLOYEE_ID , value = "所有者ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.HIERARCHY , value = "层级路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { FavouriteGroupVOMeta.PAGE_INDEX , FavouriteGroupVOMeta.PAGE_SIZE } )
	@SentinelResource(value = FavouriteGroupServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FavouriteGroupServiceProxy.QUERY_LIST)
	public Result<List<FavouriteGroup>> queryList(FavouriteGroupVO sample) {
		Result<List<FavouriteGroup>> result=new Result<>();
		List<FavouriteGroup> list=favouriteGroupService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询常用人员分组
	*/
	@ApiOperation(value = "分页查询常用人员分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.NAME , value = "组名" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.PARENT_ID , value = "上级ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.EMPLOYEE_ID , value = "所有者ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.HIERARCHY , value = "层级路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = FavouriteGroupVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = FavouriteGroupServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FavouriteGroupServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<FavouriteGroup>> queryPagedList(FavouriteGroupVO sample) {
		Result<PagedList<FavouriteGroup>> result=new Result<>();
		PagedList<FavouriteGroup> list=favouriteGroupService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}