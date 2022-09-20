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
import org.github.foxnic.web.domain.hrm.EmployeePosition;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.hrm.PositionVO;
import org.github.foxnic.web.domain.hrm.meta.PositionVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.hrm.service.IEmployeePositionService;
import org.github.foxnic.web.hrm.service.IPositionService;
import org.github.foxnic.web.proxy.hrm.PositionServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 岗位表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-13 19:48:15
 * @version
*/

@Api(tags = "岗位")
@ApiSort(0)
@RestController("HrmPositionController")
public class PositionController extends SuperController {

	@Autowired
	private IPositionService positionService;

	@Autowired
	private IEmployeePositionService employeePositionService;


	/**
	 * 添加岗位
	*/
	@ApiOperation(value = "添加岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.ORG_ID , value = "所属组织ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.CODE , value = "岗位代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.FULL_NAME , value = "全称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.SHORT_NAME , value = "简称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = PositionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.INSERT)
	public Result insert(PositionVO positionVO) {
		Result result=positionService.insert(positionVO);
		return result;
	}


	/**
	 * 删除岗位
	*/
	@ApiOperation(value = "删除岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = PositionVOMeta.ID)
	@SentinelResource(value = PositionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		Boolean hasRefer = positionService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(hasRefer).requireEqual("不允许删除当前岗位",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		Result result=positionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除岗位 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3)
	@NotNull(name = PositionVOMeta.IDS)
	@SentinelResource(value = PositionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, Boolean> hasRefersMap = positionService.hasRefers(ids);
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
			Result result=positionService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=positionService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新岗位
	*/
	@ApiOperation(value = "更新岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.ORG_ID , value = "所属组织ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.CODE , value = "岗位代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.FULL_NAME , value = "全称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.SHORT_NAME , value = "简称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { PositionVOMeta.PAGE_INDEX , PositionVOMeta.PAGE_SIZE , PositionVOMeta.SEARCH_FIELD , PositionVOMeta.FUZZY_FIELD , PositionVOMeta.SEARCH_VALUE , PositionVOMeta.SORT_FIELD , PositionVOMeta.SORT_TYPE , PositionVOMeta.IDS } )
	@NotNull(name = PositionVOMeta.ID)
	@NotNull(name = PositionVOMeta.FULL_NAME)
	@NotNull(name = PositionVOMeta.SHORT_NAME)
	@SentinelResource(value = PositionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.UPDATE)
	public Result update(PositionVO positionVO) {
		Result result=positionService.update(positionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存岗位
	*/
	@ApiOperation(value = "保存岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.ORG_ID , value = "所属组织ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.CODE , value = "岗位代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.FULL_NAME , value = "全称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.SHORT_NAME , value = "简称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PositionVOMeta.PAGE_INDEX , PositionVOMeta.PAGE_SIZE , PositionVOMeta.SEARCH_FIELD , PositionVOMeta.FUZZY_FIELD , PositionVOMeta.SEARCH_VALUE , PositionVOMeta.SORT_FIELD , PositionVOMeta.SORT_TYPE , PositionVOMeta.IDS } )
	@NotNull(name = PositionVOMeta.ID)
	@NotNull(name = PositionVOMeta.FULL_NAME)
	@NotNull(name = PositionVOMeta.SHORT_NAME)
	@SentinelResource(value = PositionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.SAVE)
	public Result save(PositionVO positionVO) {
		Result result=positionService.save(positionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取岗位
	*/
	@ApiOperation(value = "获取岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = PositionVOMeta.ID)
	@SentinelResource(value = PositionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.GET_BY_ID)
	public Result<Position> getById(String id) {
		Result<Position> result=new Result<>();
		Position position=positionService.getById(id);
		result.success(true).data(position);
		return result;
	}


	/**
	 * 批量删除岗位 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除岗位")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3)
		@NotNull(name = PositionVOMeta.IDS)
		@SentinelResource(value = PositionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.GET_BY_IDS)
	public Result<List<Position>> getByIds(List<String> ids) {
		Result<List<Position>> result=new Result<>();
		List<Position> list=positionService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询岗位
	*/
	@ApiOperation(value = "查询岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.ORG_ID , value = "所属组织ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.CODE , value = "岗位代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.FULL_NAME , value = "全称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.SHORT_NAME , value = "简称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PositionVOMeta.PAGE_INDEX , PositionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PositionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.QUERY_LIST)
	public Result<List<Position>> queryList(PositionVO sample) {
		Result<List<Position>> result=new Result<>();
		List<Position> list=positionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询岗位
	*/
	@ApiOperation(value = "分页查询岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.ORG_ID , value = "所属组织ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.CODE , value = "岗位代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.FULL_NAME , value = "全称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.SHORT_NAME , value = "简称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PositionVOMeta.VALID , value = "是否有效" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.COMPANY_ID , value = "总公司ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = PositionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Position>> queryPagedList(PositionVO sample) {
		Result<PagedList<Position>> result=new Result<>();
		PagedList<Position> list=positionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}
