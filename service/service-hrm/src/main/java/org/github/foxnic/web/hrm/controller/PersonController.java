package org.github.foxnic.web.hrm.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.hrm.PersonVO;
import org.github.foxnic.web.domain.hrm.meta.PersonVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.hrm.service.IPersonService;
import org.github.foxnic.web.proxy.hrm.PersonServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 人员接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:47:57
*/

@InDoc
@Api(tags = "人员")
@RestController("HrmPersonController")
public class PersonController extends SuperController {

	@Autowired
	private IPersonService personService;


	/**
	 * 添加人员
	*/
	@ApiOperation(value = "添加人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571627450212024320"),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "张猛1"),
		@ApiImplicitParam(name = PersonVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = PersonVOMeta.SOURCE , value = "来源" , required = true , dataTypeClass=String.class , example = "employee"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY , value = "身份证号码" , required = true , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = PersonServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.INSERT)
	public Result insert(PersonVO personVO) {
		Result result=personService.insert(personVO,false);
		return result;
	}



	/**
	 * 删除人员
	*/
	@ApiOperation(value = "删除人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571627450212024320")
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = PersonServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录:"+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=personService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除人员 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = PersonServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap =  personService.hasRefers(ids);
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
			return ErrorDesc.failure().message("无法删除您选中的数据行");
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=personService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新人员
	*/
	@ApiOperation(value = "更新人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571627450212024320"),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "张猛1"),
		@ApiImplicitParam(name = PersonVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = PersonVOMeta.SOURCE , value = "来源" , required = true , dataTypeClass=String.class , example = "employee"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY , value = "身份证号码" , required = true , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { PersonVOMeta.PAGE_INDEX , PersonVOMeta.PAGE_SIZE , PersonVOMeta.SEARCH_FIELD , PersonVOMeta.FUZZY_FIELD , PersonVOMeta.SEARCH_VALUE , PersonVOMeta.DIRTY_FIELDS , PersonVOMeta.SORT_FIELD , PersonVOMeta.SORT_TYPE , PersonVOMeta.IDS } )
	@SentinelResource(value = PersonServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.UPDATE)
	public Result update(PersonVO personVO) {
		Result result=personService.update(personVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存人员
	*/
	@ApiOperation(value = "保存人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571627450212024320"),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "张猛1"),
		@ApiImplicitParam(name = PersonVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = PersonVOMeta.SOURCE , value = "来源" , required = true , dataTypeClass=String.class , example = "employee"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY , value = "身份证号码" , required = true , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonVOMeta.PAGE_INDEX , PersonVOMeta.PAGE_SIZE , PersonVOMeta.SEARCH_FIELD , PersonVOMeta.FUZZY_FIELD , PersonVOMeta.SEARCH_VALUE , PersonVOMeta.DIRTY_FIELDS , PersonVOMeta.SORT_FIELD , PersonVOMeta.SORT_TYPE , PersonVOMeta.IDS } )
	@SentinelResource(value = PersonServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.SAVE)
	public Result save(PersonVO personVO) {
		Result result=personService.save(personVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取人员
	*/
	@ApiOperation(value = "获取人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = PersonServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.GET_BY_ID)
	public Result<Person> getById(String id) {
		Result<Person> result=new Result<>();
		Person person=personService.getById(id);
		result.success(true).data(person);
		return result;
	}


	/**
	 * 批量获取人员 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取人员")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com")
		@SentinelResource(value = PersonServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.GET_BY_IDS)
	public Result<List<Person>> getByIds(List<String> ids) {
		Result<List<Person>> result=new Result<>();
		List<Person> list=personService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询人员
	*/
	@ApiOperation(value = "查询人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571627450212024320"),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "张猛1"),
		@ApiImplicitParam(name = PersonVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = PersonVOMeta.SOURCE , value = "来源" , required = true , dataTypeClass=String.class , example = "employee"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY , value = "身份证号码" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { PersonVOMeta.PAGE_INDEX , PersonVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.QUERY_LIST)
	public Result<List<Person>> queryList(PersonVO sample) {
		Result<List<Person>> result=new Result<>();
		List<Person> list=personService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询人员
	*/
	@ApiOperation(value = "分页查询人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571627450212024320"),
		@ApiImplicitParam(name = PersonVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "张猛1"),
		@ApiImplicitParam(name = PersonVOMeta.SEX , value = "性别" , required = false , dataTypeClass=String.class , example = "F"),
		@ApiImplicitParam(name = PersonVOMeta.SOURCE , value = "来源" , required = true , dataTypeClass=String.class , example = "employee"),
		@ApiImplicitParam(name = PersonVOMeta.IDENTITY , value = "身份证号码" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = PersonServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Person>> queryPagedList(PersonVO sample) {
		Result<PagedList<Person>> result=new Result<>();
		PagedList<Person> list=personService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}
