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


import org.github.foxnic.web.proxy.system.CodeExampleServiceProxy;
import org.github.foxnic.web.domain.system.meta.CodeExampleVOMeta;
import org.github.foxnic.web.domain.system.CodeExample;
import org.github.foxnic.web.domain.system.CodeExampleVO;
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
import org.github.foxnic.web.domain.system.meta.CodeExampleMeta;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.meta.ResourzeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.ICodeExampleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * ???????????????????????? ???????????????
 * </p>
 * @author ????????? , leefangjie@qq.com
 * @since 2022-08-22 13:39:22
*/

@Api(tags = "?????????????????????")
@ApiSort(0)
@RestController("SysCodeExampleController")
public class CodeExampleController extends SuperController {

	@Autowired
	private ICodeExampleService codeExampleService;


	/**
	 * ???????????????????????????
	*/
	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NAME , value = "????????????" , required = false , dataTypeClass=String.class , example = "ZZ"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NOTES , value = "????????????" , required = false , dataTypeClass=String.class , example = "XXX"),
		@ApiImplicitParam(name = CodeExampleVOMeta.IMAGE_ID , value = "????????????" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.FILE_IDS , value = "???????????????" , required = false , dataTypeClass=String.class , example = "CC"),
		@ApiImplicitParam(name = CodeExampleVOMeta.AREA , value = "????????????" , required = false , dataTypeClass=Integer.class , example = "10"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WEIGHT , value = "????????????" , required = false , dataTypeClass=Double.class , example = "12.0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.VALID , value = "?????????" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.BUTTON_INPUT , value = "?????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RESOURCE_ID , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.BIRTHDAY , value = "??????" , required = false , dataTypeClass=Date.class , example = "2021-08-23 12:00:00"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WORK_TIME , value = "????????????" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CodeExampleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.INSERT)
	public Result insert(CodeExampleVO codeExampleVO) {
		Result result=codeExampleService.insert(codeExampleVO,false);
		return result;
	}



	/**
	 * ???????????????????????????
	*/
	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CodeExampleVOMeta.ID)
	@SentinelResource(value = CodeExampleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("??????id???");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// ????????????
		Boolean hasRefer = codeExampleService.hasRefers(id);
		// ????????????????????????
		this.validator().asserts(hasRefer).requireEqual("???????????????????????????",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=codeExampleService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * ????????????????????????????????? <br>
	 * ???????????????????????????????????????
	*/
	@ApiOperation(value = "?????????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CodeExampleVOMeta.IDS)
	@SentinelResource(value = CodeExampleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// ????????????
		this.validator().asserts(ids).require("??????ids??????");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// ????????????
		Map<String, Boolean> hasRefersMap = codeExampleService.hasRefers(ids);
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
			Result result=codeExampleService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// ???????????????????????????
			Result result=codeExampleService.deleteByIdsLogical(canDeleteIds);
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
	 * ???????????????????????????
	*/
	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NAME , value = "????????????" , required = false , dataTypeClass=String.class , example = "ZZ"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NOTES , value = "????????????" , required = false , dataTypeClass=String.class , example = "XXX"),
		@ApiImplicitParam(name = CodeExampleVOMeta.IMAGE_ID , value = "????????????" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.FILE_IDS , value = "???????????????" , required = false , dataTypeClass=String.class , example = "CC"),
		@ApiImplicitParam(name = CodeExampleVOMeta.AREA , value = "????????????" , required = false , dataTypeClass=Integer.class , example = "10"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WEIGHT , value = "????????????" , required = false , dataTypeClass=Double.class , example = "12.0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.VALID , value = "?????????" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.BUTTON_INPUT , value = "?????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RESOURCE_ID , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.BIRTHDAY , value = "??????" , required = false , dataTypeClass=Date.class , example = "2021-08-23 12:00:00"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WORK_TIME , value = "????????????" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CodeExampleVOMeta.PAGE_INDEX , CodeExampleVOMeta.PAGE_SIZE , CodeExampleVOMeta.SEARCH_FIELD , CodeExampleVOMeta.FUZZY_FIELD , CodeExampleVOMeta.SEARCH_VALUE , CodeExampleVOMeta.DIRTY_FIELDS , CodeExampleVOMeta.SORT_FIELD , CodeExampleVOMeta.SORT_TYPE , CodeExampleVOMeta.IDS } )
	@SentinelResource(value = CodeExampleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.UPDATE)
	public Result update(CodeExampleVO codeExampleVO) {
		Result result=codeExampleService.update(codeExampleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * ???????????????????????????
	*/
	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NAME , value = "????????????" , required = false , dataTypeClass=String.class , example = "ZZ"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NOTES , value = "????????????" , required = false , dataTypeClass=String.class , example = "XXX"),
		@ApiImplicitParam(name = CodeExampleVOMeta.IMAGE_ID , value = "????????????" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.FILE_IDS , value = "???????????????" , required = false , dataTypeClass=String.class , example = "CC"),
		@ApiImplicitParam(name = CodeExampleVOMeta.AREA , value = "????????????" , required = false , dataTypeClass=Integer.class , example = "10"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WEIGHT , value = "????????????" , required = false , dataTypeClass=Double.class , example = "12.0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.VALID , value = "?????????" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.BUTTON_INPUT , value = "?????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RESOURCE_ID , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.BIRTHDAY , value = "??????" , required = false , dataTypeClass=Date.class , example = "2021-08-23 12:00:00"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WORK_TIME , value = "????????????" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeExampleVOMeta.PAGE_INDEX , CodeExampleVOMeta.PAGE_SIZE , CodeExampleVOMeta.SEARCH_FIELD , CodeExampleVOMeta.FUZZY_FIELD , CodeExampleVOMeta.SEARCH_VALUE , CodeExampleVOMeta.DIRTY_FIELDS , CodeExampleVOMeta.SORT_FIELD , CodeExampleVOMeta.SORT_TYPE , CodeExampleVOMeta.IDS } )
	@NotNull(name = CodeExampleVOMeta.ID)
	@SentinelResource(value = CodeExampleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.SAVE)
	public Result save(CodeExampleVO codeExampleVO) {
		Result result=codeExampleService.save(codeExampleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * ???????????????????????????
	*/
	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CodeExampleVOMeta.ID)
	@SentinelResource(value = CodeExampleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.GET_BY_ID)
	public Result<CodeExample> getById(String id) {
		Result<CodeExample> result=new Result<>();
		CodeExample codeExample=codeExampleService.getById(id);
		// join ???????????????
		codeExampleService.dao().fill(codeExample)
			.with(CodeExampleMeta.RESOURZE)
			.with(CodeExampleMeta.ROLES)
			.execute();
		result.success(true).data(codeExample);
		return result;
	}


	/**
	 * ????????????????????????????????? <br>
	 * ???????????????????????????????????????
	*/
		@ApiOperation(value = "?????????????????????????????????")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CodeExampleVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CodeExampleVOMeta.IDS)
		@SentinelResource(value = CodeExampleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.GET_BY_IDS)
	public Result<List<CodeExample>> getByIds(List<String> ids) {
		Result<List<CodeExample>> result=new Result<>();
		List<CodeExample> list=codeExampleService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * ???????????????????????????
	*/
	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NAME , value = "????????????" , required = false , dataTypeClass=String.class , example = "ZZ"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NOTES , value = "????????????" , required = false , dataTypeClass=String.class , example = "XXX"),
		@ApiImplicitParam(name = CodeExampleVOMeta.IMAGE_ID , value = "????????????" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.FILE_IDS , value = "???????????????" , required = false , dataTypeClass=String.class , example = "CC"),
		@ApiImplicitParam(name = CodeExampleVOMeta.AREA , value = "????????????" , required = false , dataTypeClass=Integer.class , example = "10"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WEIGHT , value = "????????????" , required = false , dataTypeClass=Double.class , example = "12.0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.VALID , value = "?????????" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.BUTTON_INPUT , value = "?????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RESOURCE_ID , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.BIRTHDAY , value = "??????" , required = false , dataTypeClass=Date.class , example = "2021-08-23 12:00:00"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WORK_TIME , value = "????????????" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeExampleVOMeta.PAGE_INDEX , CodeExampleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CodeExampleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.QUERY_LIST)
	public Result<List<CodeExample>> queryList(CodeExampleVO sample) {
		Result<List<CodeExample>> result=new Result<>();
		List<CodeExample> list=codeExampleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * ?????????????????????????????????
	*/
	@ApiOperation(value = "?????????????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeExampleVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NAME , value = "????????????" , required = false , dataTypeClass=String.class , example = "ZZ"),
		@ApiImplicitParam(name = CodeExampleVOMeta.NOTES , value = "????????????" , required = false , dataTypeClass=String.class , example = "XXX"),
		@ApiImplicitParam(name = CodeExampleVOMeta.IMAGE_ID , value = "????????????" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeExampleVOMeta.FILE_IDS , value = "???????????????" , required = false , dataTypeClass=String.class , example = "CC"),
		@ApiImplicitParam(name = CodeExampleVOMeta.AREA , value = "????????????" , required = false , dataTypeClass=Integer.class , example = "10"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WEIGHT , value = "????????????" , required = false , dataTypeClass=Double.class , example = "12.0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.VALID , value = "?????????" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = CodeExampleVOMeta.BUTTON_INPUT , value = "?????????" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RADIO_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.CHECK_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_ENUM , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.SELECT_DICT , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.RESOURCE_ID , value = "?????????(??????)" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeExampleVOMeta.BIRTHDAY , value = "??????" , required = false , dataTypeClass=Date.class , example = "2021-08-23 12:00:00"),
		@ApiImplicitParam(name = CodeExampleVOMeta.WORK_TIME , value = "????????????" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CodeExampleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeExampleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CodeExample>> queryPagedList(CodeExampleVO sample) {
		Result<PagedList<CodeExample>> result=new Result<>();
		PagedList<CodeExample> list=codeExampleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join ???????????????
		codeExampleService.dao().fill(list)
			.with(CodeExampleMeta.RESOURZE)
			.with(CodeExampleMeta.ROLES)
			.execute();
		result.success(true).data(list);
		return result;
	}






}