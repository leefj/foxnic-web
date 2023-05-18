package org.github.foxnic.web.system.controller;

import java.util.*;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import org.github.foxnic.web.proxy.system.CodeExampleCarServiceProxy;
import org.github.foxnic.web.domain.system.meta.CodeExampleCarVOMeta;
import org.github.foxnic.web.domain.system.CodeExampleCar;
import org.github.foxnic.web.domain.system.CodeExampleCarVO;
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
import org.github.foxnic.web.domain.system.meta.CodeExampleCarMeta;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.OrganizationMeta;
import org.github.foxnic.web.domain.hrm.meta.PositionMeta;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.ICodeExampleCarService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 代码生成拥有的车辆接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-18 16:40:48
*/

@InDoc
@Api(tags = "代码生成拥有的车辆")
@RestController("SysCodeExampleCarController")
public class CodeExampleCarController extends SuperController {

	@Autowired
	private ICodeExampleCarService codeExampleCarService;

	/**
	 * 添加代码生成拥有的车辆
	*/
	@ApiOperation(value = "添加代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "车牌号" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "岗位单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "组织单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "员工单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "岗位多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "组织多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "员工多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "员工下拉" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "公司单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "部门多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "限定上级" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CodeExampleCarServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.INSERT)
	public Result insert(CodeExampleCarVO codeExampleCarVO) {
		
		Result result=codeExampleCarService.insert(codeExampleCarVO,false);
		return result;
	}



	/**
	 * 删除代码生成拥有的车辆
	*/
	@ApiOperation(value = "删除代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168")
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CodeExampleCarServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  codeExampleCarService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=codeExampleCarService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除代码生成拥有的车辆 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
	@SentinelResource(value = CodeExampleCarServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = codeExampleCarService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, ReferCause> e : causeMap.entrySet()) {
			if (!e.getValue().hasRefer()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0)
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=codeExampleCarService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=codeExampleCarService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size())
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新代码生成拥有的车辆
	*/
	@ApiOperation(value = "更新代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "车牌号" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "岗位单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "组织单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "员工单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "岗位多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "组织多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "员工多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "员工下拉" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "公司单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "部门多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "限定上级" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { CodeExampleCarVOMeta.PAGE_INDEX , CodeExampleCarVOMeta.PAGE_SIZE , CodeExampleCarVOMeta.SEARCH_FIELD , CodeExampleCarVOMeta.FUZZY_FIELD , CodeExampleCarVOMeta.SEARCH_VALUE , CodeExampleCarVOMeta.DIRTY_FIELDS , CodeExampleCarVOMeta.SORT_FIELD , CodeExampleCarVOMeta.SORT_TYPE , CodeExampleCarVOMeta.DATA_ORIGIN , CodeExampleCarVOMeta.QUERY_LOGIC , CodeExampleCarVOMeta.REQUEST_ACTION , CodeExampleCarVOMeta.IDS } )
	@SentinelResource(value = CodeExampleCarServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.UPDATE)
	public Result update(CodeExampleCarVO codeExampleCarVO) {
		
		Result result=codeExampleCarService.update(codeExampleCarVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存代码生成拥有的车辆
	*/
	@ApiOperation(value = "保存代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "车牌号" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "岗位单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "组织单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "员工单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "岗位多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "组织多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "员工多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "员工下拉" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "公司单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "部门多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "限定上级" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeExampleCarVOMeta.PAGE_INDEX , CodeExampleCarVOMeta.PAGE_SIZE , CodeExampleCarVOMeta.SEARCH_FIELD , CodeExampleCarVOMeta.FUZZY_FIELD , CodeExampleCarVOMeta.SEARCH_VALUE , CodeExampleCarVOMeta.DIRTY_FIELDS , CodeExampleCarVOMeta.SORT_FIELD , CodeExampleCarVOMeta.SORT_TYPE , CodeExampleCarVOMeta.DATA_ORIGIN , CodeExampleCarVOMeta.QUERY_LOGIC , CodeExampleCarVOMeta.REQUEST_ACTION , CodeExampleCarVOMeta.IDS } )
	@SentinelResource(value = CodeExampleCarServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.SAVE)
	public Result save(CodeExampleCarVO codeExampleCarVO) {
		
		Result result=codeExampleCarService.save(codeExampleCarVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取代码生成拥有的车辆
	*/
	@ApiOperation(value = "获取代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CodeExampleCarServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.GET_BY_ID)
	public Result<CodeExampleCar> getById(String id) {
		
		Result<CodeExampleCar> result=new Result<>();
		CodeExampleCar codeExampleCar=codeExampleCarService.getById(id);
		// join 关联的对象
		codeExampleCarService.dao().fill(codeExampleCar)
			.with(CodeExampleCarMeta.ORGANIZATION)
			.with(CodeExampleCarMeta.SUB_ORGANIZATION)
			.with(CodeExampleCarMeta.COMPANY)
			.with(CodeExampleCarMeta.POSITION)
			.with(CodeExampleCarMeta.EMPLOYEE,EmployeeMeta.PERSON)
			.execute();
		result.success(true).data(codeExampleCar);
		return result;
	}


	/**
	 * 批量获取代码生成拥有的车辆 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取代码生成拥有的车辆")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CodeExampleCarVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
		@SentinelResource(value = CodeExampleCarServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.GET_BY_IDS)
	public Result<List<CodeExampleCar>> getByIds(List<String> ids) {
		
		Result<List<CodeExampleCar>> result=new Result<>();
		List<CodeExampleCar> list=codeExampleCarService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询代码生成拥有的车辆
	*/
	@ApiOperation(value = "查询代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "车牌号" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "岗位单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "组织单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "员工单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "岗位多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "组织多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "员工多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "员工下拉" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "公司单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "部门多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "限定上级" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { CodeExampleCarVOMeta.PAGE_INDEX , CodeExampleCarVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CodeExampleCarServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.QUERY_LIST)
	public Result<List<CodeExampleCar>> queryList(CodeExampleCarVO sample) {
		
		Result<List<CodeExampleCar>> result=new Result<>();
		List<CodeExampleCar> list=codeExampleCarService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询代码生成拥有的车辆
	*/
	@ApiOperation(value = "分页查询代码生成拥有的车辆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476464971060871168"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EXAMPLE_ID , value = "属主ID" , required = false , dataTypeClass=String.class , example = "476069797533057024"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.PLATE_NUMBER , value = "车牌号" , required = false , dataTypeClass=String.class , example = "110352963290923110"),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_ID , value = "岗位单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_ID , value = "组织单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_ID , value = "员工单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.POSITION_IDS , value = "岗位多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.ORG_IDS , value = "组织多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.EMP_IDS , value = "员工多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SELECT_EMP_ID , value = "员工下拉" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.COM_ID , value = "公司单选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.DEPT_IDS , value = "部门多选" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleCarVOMeta.SUB_ORG_ID , value = "限定上级" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CodeExampleCarServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleCarServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CodeExampleCar>> queryPagedList(CodeExampleCarVO sample) {
		
		Result<PagedList<CodeExampleCar>> result=new Result<>();
		PagedList<CodeExampleCar> list=codeExampleCarService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		codeExampleCarService.dao().fill(list)
			.with(CodeExampleCarMeta.ORGANIZATION)
			.with(CodeExampleCarMeta.SUB_ORGANIZATION)
			.with(CodeExampleCarMeta.COMPANY)
			.with(CodeExampleCarMeta.POSITION)
			.with(CodeExampleCarMeta.EMPLOYEE,EmployeeMeta.PERSON)
			.execute();
		result.success(true).data(list);
		return result;
	}





}