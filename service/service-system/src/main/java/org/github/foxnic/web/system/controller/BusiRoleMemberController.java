package org.github.foxnic.web.system.controller;


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


import org.github.foxnic.web.proxy.system.BusiRoleMemberServiceProxy;
import org.github.foxnic.web.domain.system.meta.BusiRoleMemberVOMeta;
import org.github.foxnic.web.domain.system.BusiRoleMember;
import org.github.foxnic.web.domain.system.BusiRoleMemberVO;
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
import org.github.foxnic.web.domain.system.meta.BusiRoleMemberMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.domain.hrm.meta.PositionMeta;
import org.github.foxnic.web.domain.hrm.meta.OrganizationMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.IBusiRoleMemberService;
import com.github.foxnic.api.validate.annotations.NotNull;
import java.util.ArrayList;

/**
 * <p>
 * ??????????????????????????? ???????????????
 * </p>
 * @author ????????? , leefangjie@qq.com
 * @since 2022-09-02 16:18:40
*/

@Api(tags = "????????????????????????")
@ApiSort(0)
@RestController("SysBusiRoleMemberController")
public class BusiRoleMemberController extends SuperController {

	@Autowired
	private IBusiRoleMemberService busiRoleMemberService;


	/**
	 * ??????????????????????????????
	*/
	@ApiOperation(value = "??????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "27684550612090880"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ROLE_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "524224688444936192"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "544487545157713920"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_TYPE , value = "????????????" , required = false , dataTypeClass=String.class , example = "employee"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = BusiRoleMemberServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.INSERT)
	public Result insert(BusiRoleMemberVO busiRoleMemberVO) {
		Result result=busiRoleMemberService.insert(busiRoleMemberVO,false);
		return result;
	}

	/**
	 * ????????????????????????????????????
	*/
	@ApiOperation(value = "??????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "27684550612090880"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ROLE_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "524224688444936192"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "544487545157713920"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_TYPE , value = "????????????" , required = false , dataTypeClass=String.class , example = "employee"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = BusiRoleMemberServiceProxy.INSERTS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.INSERTS)
	public Result inserts(List<BusiRoleMemberVO> busiRoleMemberVOs) {
		Result result=busiRoleMemberService.insertList(new ArrayList<>(busiRoleMemberVOs));
		return result;
	}


	/**
	 * ??????????????????????????????
	*/
	@ApiOperation(value = "??????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "27684550612090880")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = BusiRoleMemberVOMeta.ID)
	@SentinelResource(value = BusiRoleMemberServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("??????id???");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// ????????????
		Boolean hasRefer = busiRoleMemberService.hasRefers(id);
		// ????????????????????????
		this.validator().asserts(hasRefer).requireEqual("???????????????????????????",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=busiRoleMemberService.deleteByIdPhysical(id);
		return result;
	}


	/**
	 * ???????????????????????????????????? <br>
	 * ???????????????????????????????????????
	*/
	@ApiOperation(value = "????????????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = BusiRoleMemberVOMeta.IDS)
	@SentinelResource(value = BusiRoleMemberServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// ????????????
		this.validator().asserts(ids).require("??????ids??????");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// ????????????
		Map<String, Boolean> hasRefersMap = busiRoleMemberService.hasRefers(ids);
		// ?????????????????????ID???
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, Boolean> e : hasRefersMap.entrySet()) {
			if (!e.getValue()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// ????????????
		if (canDeleteIds.isEmpty()) {
			// ?????????????????????????????????
			return ErrorDesc.failure().message("?????????????????????????????????");
		} else if (canDeleteIds.size() == ids.size()) {
			// ????????????????????????
			Result result=busiRoleMemberService.deleteByIdsPhysical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// ???????????????????????????
			Result result=busiRoleMemberService.deleteByIdsPhysical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("????????? " + canDeleteIds.size() + " ??????????????? " + (ids.size() - canDeleteIds.size()) + " ?????????????????????").messageLevel4Confirm();
			}
		} else {
			// ?????????????????????????????????
			return ErrorDesc.success().message("?????????????????????");
		}
	}

	/**
	 * ??????????????????????????????
	*/
	@ApiOperation(value = "??????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "27684550612090880"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ROLE_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "524224688444936192"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "544487545157713920"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_TYPE , value = "????????????" , required = false , dataTypeClass=String.class , example = "employee"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { BusiRoleMemberVOMeta.PAGE_INDEX , BusiRoleMemberVOMeta.PAGE_SIZE , BusiRoleMemberVOMeta.SEARCH_FIELD , BusiRoleMemberVOMeta.FUZZY_FIELD , BusiRoleMemberVOMeta.SEARCH_VALUE , BusiRoleMemberVOMeta.DIRTY_FIELDS , BusiRoleMemberVOMeta.SORT_FIELD , BusiRoleMemberVOMeta.SORT_TYPE , BusiRoleMemberVOMeta.IDS } )
	@SentinelResource(value = BusiRoleMemberServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.UPDATE)
	public Result update(BusiRoleMemberVO busiRoleMemberVO) {
		Result result=busiRoleMemberService.update(busiRoleMemberVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * ??????????????????????????????
	*/
	@ApiOperation(value = "??????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "27684550612090880"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ROLE_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "524224688444936192"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "544487545157713920"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_TYPE , value = "????????????" , required = false , dataTypeClass=String.class , example = "employee"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BusiRoleMemberVOMeta.PAGE_INDEX , BusiRoleMemberVOMeta.PAGE_SIZE , BusiRoleMemberVOMeta.SEARCH_FIELD , BusiRoleMemberVOMeta.FUZZY_FIELD , BusiRoleMemberVOMeta.SEARCH_VALUE , BusiRoleMemberVOMeta.DIRTY_FIELDS , BusiRoleMemberVOMeta.SORT_FIELD , BusiRoleMemberVOMeta.SORT_TYPE , BusiRoleMemberVOMeta.IDS } )
	@NotNull(name = BusiRoleMemberVOMeta.ID)
	@SentinelResource(value = BusiRoleMemberServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.SAVE)
	public Result save(BusiRoleMemberVO busiRoleMemberVO) {
		Result result=busiRoleMemberService.save(busiRoleMemberVO,SaveMode.NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * ??????????????????????????????
	*/
	@ApiOperation(value = "??????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = BusiRoleMemberVOMeta.ID)
	@SentinelResource(value = BusiRoleMemberServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.GET_BY_ID)
	public Result<BusiRoleMember> getById(String id) {
		Result<BusiRoleMember> result=new Result<>();
		BusiRoleMember busiRoleMember=busiRoleMemberService.getById(id);
		// join ???????????????
		busiRoleMemberService.dao().fill(busiRoleMember)
			.with(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.PERSON)
			.with(BusiRoleMemberMeta.EMPLOYEE)
			.with(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.POSITIONS)
			.with(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.ORGANIZATIONS)
			.execute();
		result.success(true).data(busiRoleMember);
		return result;
	}


	/**
	 * ???????????????????????????????????? <br>
	 * ???????????????????????????????????????
	*/
		@ApiOperation(value = "????????????????????????????????????")
		@ApiImplicitParams({
				@ApiImplicitParam(name = BusiRoleMemberVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = BusiRoleMemberVOMeta.IDS)
		@SentinelResource(value = BusiRoleMemberServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.GET_BY_IDS)
	public Result<List<BusiRoleMember>> getByIds(List<String> ids) {
		Result<List<BusiRoleMember>> result=new Result<>();
		List<BusiRoleMember> list=busiRoleMemberService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * ??????????????????????????????
	*/
	@ApiOperation(value = "??????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "27684550612090880"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ROLE_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "524224688444936192"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "544487545157713920"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_TYPE , value = "????????????" , required = false , dataTypeClass=String.class , example = "employee"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BusiRoleMemberVOMeta.PAGE_INDEX , BusiRoleMemberVOMeta.PAGE_SIZE } )
	@SentinelResource(value = BusiRoleMemberServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.QUERY_LIST)
	public Result<List<BusiRoleMember>> queryList(BusiRoleMemberVO sample) {
		Result<List<BusiRoleMember>> result=new Result<>();
		List<BusiRoleMember> list=busiRoleMemberService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * ????????????????????????????????????
	*/
	@ApiOperation(value = "????????????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "27684550612090880"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.ROLE_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "524224688444936192"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_ID , value = "??????ID" , required = false , dataTypeClass=String.class , example = "544487545157713920"),
		@ApiImplicitParam(name = BusiRoleMemberVOMeta.MEMBER_TYPE , value = "????????????" , required = false , dataTypeClass=String.class , example = "employee"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = BusiRoleMemberServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusiRoleMemberServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<BusiRoleMember>> queryPagedList(BusiRoleMemberVO sample) {
		Result<PagedList<BusiRoleMember>> result=new Result<>();
		PagedList<BusiRoleMember> list=busiRoleMemberService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join ???????????????
		busiRoleMemberService.dao().fill(list)
			.with(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.PERSON)
			.with(BusiRoleMemberMeta.EMPLOYEE)
			.with(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.POSITIONS)
			.with(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.ORGANIZATIONS)
			.execute();
		result.success(true).data(list);
		return result;
	}






}