package com.scientific.tailoring.system.controller;
import com.scientific.tailoring.system.service.IAreaService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.dao.data.SaveMode;
import com.scientific.tailoring.domain.crm.Company;
import com.scientific.tailoring.domain.crm.CompanyVO;
import com.scientific.tailoring.domain.crm.meta.CompanyVOMeta;
import com.scientific.tailoring.domain.product.Fabric;
import com.scientific.tailoring.domain.system.Area;
import com.scientific.tailoring.domain.system.AreaVO;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.sql.expr.OrderBy;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.misc.FormSeletOption;
import com.scientific.tailoring.proxy.crm.CompanyServiceProxy;
import com.scientific.tailoring.proxy.system.AreaServiceProxy;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.constants.db.Tailoring.SYS_AREA;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import com.scientific.tailoring.domain.system.meta.AreaVOMeta;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-21 11:22:08
*/

@Api(tags = "区域")
@ApiSort(1007)
@RestController("SysAreaController")
public class AreaController extends SuperController {

	@Autowired
	private IAreaService areaService;



	
	/**
	 * 按主键获取区域
	*/
	@RequiresPermissions("SysArea:getById")
	@ApiOperation(value = "按主键获取区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "区域ID" , required = true , dataTypeClass=Integer.class , example = "110000"),
	})
	@NotNull(name = AreaVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = AreaServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(AreaServiceProxy.GET_BY_ID)
	public  Result<Area> getById(Integer id) {
		Result<Area> result=new Result<>();
		Area area=areaService.getById(id);
		result.success(true).data(area);
		return result;
	}

	
	/**
	 * 查询全部符合条件的区域
	*/
	@RequiresPermissions("SysArea:queryList")
	@ApiOperation(value = "查询区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "区域ID" , required = false , dataTypeClass=Integer.class , example = "110000"),
		@ApiImplicitParam(name = AreaVOMeta.PARENT_ID , value = "父级ID" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AreaVOMeta.NAME , value = "区域名称" , required = false , dataTypeClass=String.class , example = "北京市"),
		@ApiImplicitParam(name = AreaVOMeta.DEPTH , value = "等级（深度）" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AreaVOMeta.CREATED_BY , value = "创建人id" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = AreaVOMeta.UPDATED_BY , value = "修改人id" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = AreaVOMeta.CREATE_DATE , value = "创建时间" , required = false , dataTypeClass=Timestamp.class , example = "2018-07-16 19:12:38.000"),
		@ApiImplicitParam(name = AreaVOMeta.UPDATE_DATE , value = "修改时间" , required = false , dataTypeClass=Timestamp.class , example = "2018-07-16 19:12:38.000"),
		@ApiImplicitParam(name = AreaVOMeta.VALID , value = "数据是否有效" , required = false , dataTypeClass=Boolean.class , example = "1"),
	})
	@ApiOperationSupport(ignoreParameters = {AreaVOMeta.PAGE_INDEX , AreaVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = AreaServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(AreaServiceProxy.QUERY_LIST)
	public  Result<List<Area>> queryList(AreaVO sample) {
		Result<List<Area>> result=new Result<>();
		List<Area> list=areaService.queryList(sample);
		result.success(true).data(list);
		return result;
	}
	
	
	/**
	 * 查询全部符合条件的客户公司
	*/
//	@RequiresPermissions("CrmCompany:queryList4Select")
	@ApiOperation(value = "查询公司(下拉数据)")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.PARENT_ID , value = "父级ID" , required = false , dataTypeClass=Integer.class , example = "0")
	})
	@ApiOperationSupport(ignoreParameters = {CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = AreaServiceProxy.QUERY_LIST_FOR_SELECT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@RequestMapping(AreaServiceProxy.QUERY_LIST_FOR_SELECT)
	public  Result<List<FormSeletOption>> queryList4Select(AreaVO sample) {
		if(sample.getParentId()==null) sample.setParentId(0);
		sample.setValid(true);
		Result<List<FormSeletOption>> result=new Result<>();
		List<Area> list=areaService.queryList(sample,OrderBy.byAsc(SYS_AREA.ID));
		List<FormSeletOption> options=FormSeletOption.collect(list, Area::getName, Area::getId);
		result.success(true).data(options);
		return result;
	}

	



}