package org.github.foxnic.web.system.controller;


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
import org.github.foxnic.web.domain.system.Dict;
import org.github.foxnic.web.domain.system.DictVO;
import org.github.foxnic.web.domain.system.meta.DictMeta;
import org.github.foxnic.web.domain.system.meta.DictVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.system.DictServiceProxy;
import org.github.foxnic.web.system.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据字典接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:48
*/

@InDoc
@Api(tags = "数据字典")
@RestController("SysDictController")
public class DictController extends SuperController {

	@Autowired
	private IDictService dictService;


	/**
	 * 添加数据字典
	*/
	@ApiOperation(value = "添加数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.IS_TREE , value = "是否树形结构" , required = true , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "字典名称" , required = false , dataTypeClass=String.class , example = "性别"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "字典代码" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictVOMeta.MODULE , value = "所属模块" , required = false , dataTypeClass=String.class , example = "463397133957988352"),
		@ApiImplicitParam(name = DictVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = DictServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.INSERT)
	public Result insert(DictVO dictVO) {
		Result result=dictService.insert(dictVO,false);
		return result;
	}



	/**
	 * 删除数据字典
	*/
	@ApiOperation(value = "删除数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = DictServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dictService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录:"+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=dictService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据字典 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = DictServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap =  dictService.hasRefers(ids);
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
			Result result=dictService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dictService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据字典
	*/
	@ApiOperation(value = "更新数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.IS_TREE , value = "是否树形结构" , required = true , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "字典名称" , required = false , dataTypeClass=String.class , example = "性别"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "字典代码" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictVOMeta.MODULE , value = "所属模块" , required = false , dataTypeClass=String.class , example = "463397133957988352"),
		@ApiImplicitParam(name = DictVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { DictVOMeta.PAGE_INDEX , DictVOMeta.PAGE_SIZE , DictVOMeta.SEARCH_FIELD , DictVOMeta.FUZZY_FIELD , DictVOMeta.SEARCH_VALUE , DictVOMeta.DIRTY_FIELDS , DictVOMeta.SORT_FIELD , DictVOMeta.SORT_TYPE , DictVOMeta.IDS } )
	@SentinelResource(value = DictServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.UPDATE)
	public Result update(DictVO dictVO) {
		Result result=dictService.update(dictVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据字典
	*/
	@ApiOperation(value = "保存数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.IS_TREE , value = "是否树形结构" , required = true , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "字典名称" , required = false , dataTypeClass=String.class , example = "性别"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "字典代码" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictVOMeta.MODULE , value = "所属模块" , required = false , dataTypeClass=String.class , example = "463397133957988352"),
		@ApiImplicitParam(name = DictVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DictVOMeta.PAGE_INDEX , DictVOMeta.PAGE_SIZE , DictVOMeta.SEARCH_FIELD , DictVOMeta.FUZZY_FIELD , DictVOMeta.SEARCH_VALUE , DictVOMeta.DIRTY_FIELDS , DictVOMeta.SORT_FIELD , DictVOMeta.SORT_TYPE , DictVOMeta.IDS } )
	@SentinelResource(value = DictServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.SAVE)
	public Result save(DictVO dictVO) {
		Result result=dictService.save(dictVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据字典
	*/
	@ApiOperation(value = "获取数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = DictServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.GET_BY_ID)
	public Result<Dict> getById(String id) {
		Result<Dict> result=new Result<>();
		Dict dict=dictService.getById(id);
		// join 关联的对象
		dictService.dao().fill(dict)
			.with(DictMeta.MODULE_INFO)
			.execute();
		result.success(true).data(dict);
		return result;
	}


	/**
	 * 批量获取数据字典 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据字典")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DictVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com")
		@SentinelResource(value = DictServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.GET_BY_IDS)
	public Result<List<Dict>> getByIds(List<String> ids) {
		Result<List<Dict>> result=new Result<>();
		List<Dict> list=dictService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据字典
	*/
	@ApiOperation(value = "查询数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.IS_TREE , value = "是否树形结构" , required = true , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "字典名称" , required = false , dataTypeClass=String.class , example = "性别"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "字典代码" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictVOMeta.MODULE , value = "所属模块" , required = false , dataTypeClass=String.class , example = "463397133957988352"),
		@ApiImplicitParam(name = DictVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { DictVOMeta.PAGE_INDEX , DictVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DictServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.QUERY_LIST)
	public Result<List<Dict>> queryList(DictVO sample) {
		Result<List<Dict>> result=new Result<>();
		List<Dict> list=dictService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据字典
	*/
	@ApiOperation(value = "分页查询数据字典")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "字典ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.IS_TREE , value = "是否树形结构" , required = true , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "字典名称" , required = false , dataTypeClass=String.class , example = "性别"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "字典代码" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictVOMeta.MODULE , value = "所属模块" , required = false , dataTypeClass=String.class , example = "463397133957988352"),
		@ApiImplicitParam(name = DictVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = DictServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Dict>> queryPagedList(DictVO sample) {
		Result<PagedList<Dict>> result=new Result<>();
		PagedList<Dict> list=dictService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		dictService.dao().fill(list)
			.with(DictMeta.MODULE_INFO)
			.execute();
		result.success(true).data(list);
		return result;
	}






}
