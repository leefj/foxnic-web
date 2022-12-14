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


import org.github.foxnic.web.proxy.system.DictServiceProxy;
import org.github.foxnic.web.domain.system.meta.DictVOMeta;
import org.github.foxnic.web.domain.system.Dict;
import org.github.foxnic.web.domain.system.DictVO;
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
import org.github.foxnic.web.domain.system.meta.DictMeta;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.oauth.Menu;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.IDictService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * ???????????? ???????????????
 * </p>
 * @author ????????? , leefangjie@qq.com
 * @since 2022-09-02 16:18:40
*/

@Api(tags = "????????????")
@ApiSort(0)
@RestController("SysDictController")
public class DictController extends SuperController {

	@Autowired
	private IDictService dictService;


	/**
	 * ??????????????????
	*/
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "??????ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.IS_TREE , value = "??????????????????" , required = true , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "????????????" , required = false , dataTypeClass=String.class , example = "??????"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "????????????" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictVOMeta.MODULE , value = "????????????" , required = false , dataTypeClass=String.class , example = "463397133957988352"),
		@ApiImplicitParam(name = DictVOMeta.NOTES , value = "??????" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = DictServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.INSERT)
	public Result insert(DictVO dictVO) {
		Result result=dictService.insert(dictVO,false);
		return result;
	}



	/**
	 * ??????????????????
	*/
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "??????ID" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = DictVOMeta.ID)
	@SentinelResource(value = DictServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("??????id???");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// ????????????
		Boolean hasRefer = dictService.hasRefers(id);
		// ????????????????????????
		this.validator().asserts(hasRefer).requireEqual("???????????????????????????",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=dictService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * ???????????????????????? <br>
	 * ???????????????????????????????????????
	*/
	@ApiOperation(value = "????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = DictVOMeta.IDS)
	@SentinelResource(value = DictServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// ????????????
		this.validator().asserts(ids).require("??????ids??????");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// ????????????
		Map<String, Boolean> hasRefersMap = dictService.hasRefers(ids);
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
			Result result=dictService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// ???????????????????????????
			Result result=dictService.deleteByIdsLogical(canDeleteIds);
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
	 * ??????????????????
	*/
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "??????ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.IS_TREE , value = "??????????????????" , required = true , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "????????????" , required = false , dataTypeClass=String.class , example = "??????"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "????????????" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictVOMeta.MODULE , value = "????????????" , required = false , dataTypeClass=String.class , example = "463397133957988352"),
		@ApiImplicitParam(name = DictVOMeta.NOTES , value = "??????" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { DictVOMeta.PAGE_INDEX , DictVOMeta.PAGE_SIZE , DictVOMeta.SEARCH_FIELD , DictVOMeta.FUZZY_FIELD , DictVOMeta.SEARCH_VALUE , DictVOMeta.DIRTY_FIELDS , DictVOMeta.SORT_FIELD , DictVOMeta.SORT_TYPE , DictVOMeta.IDS } )
	@SentinelResource(value = DictServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.UPDATE)
	public Result update(DictVO dictVO) {
		Result result=dictService.update(dictVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * ??????????????????
	*/
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "??????ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.IS_TREE , value = "??????????????????" , required = true , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "????????????" , required = false , dataTypeClass=String.class , example = "??????"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "????????????" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictVOMeta.MODULE , value = "????????????" , required = false , dataTypeClass=String.class , example = "463397133957988352"),
		@ApiImplicitParam(name = DictVOMeta.NOTES , value = "??????" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DictVOMeta.PAGE_INDEX , DictVOMeta.PAGE_SIZE , DictVOMeta.SEARCH_FIELD , DictVOMeta.FUZZY_FIELD , DictVOMeta.SEARCH_VALUE , DictVOMeta.DIRTY_FIELDS , DictVOMeta.SORT_FIELD , DictVOMeta.SORT_TYPE , DictVOMeta.IDS } )
	@NotNull(name = DictVOMeta.ID)
	@NotNull(name = DictVOMeta.IS_TREE)
	@SentinelResource(value = DictServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.SAVE)
	public Result save(DictVO dictVO) {
		Result result=dictService.save(dictVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * ??????????????????
	*/
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "??????" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = DictVOMeta.ID)
	@SentinelResource(value = DictServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.GET_BY_ID)
	public Result<Dict> getById(String id) {
		Result<Dict> result=new Result<>();
		Dict dict=dictService.getById(id);
		// join ???????????????
		dictService.dao().fill(dict)
			.with(DictMeta.MODULE_INFO)
			.execute();
		result.success(true).data(dict);
		return result;
	}


	/**
	 * ???????????????????????? <br>
	 * ???????????????????????????????????????
	*/
		@ApiOperation(value = "????????????????????????")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DictVOMeta.IDS , value = "????????????" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = DictVOMeta.IDS)
		@SentinelResource(value = DictServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.GET_BY_IDS)
	public Result<List<Dict>> getByIds(List<String> ids) {
		Result<List<Dict>> result=new Result<>();
		List<Dict> list=dictService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * ??????????????????
	*/
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "??????ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.IS_TREE , value = "??????????????????" , required = true , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "????????????" , required = false , dataTypeClass=String.class , example = "??????"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "????????????" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictVOMeta.MODULE , value = "????????????" , required = false , dataTypeClass=String.class , example = "463397133957988352"),
		@ApiImplicitParam(name = DictVOMeta.NOTES , value = "??????" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DictVOMeta.PAGE_INDEX , DictVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DictServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.QUERY_LIST)
	public Result<List<Dict>> queryList(DictVO sample) {
		Result<List<Dict>> result=new Result<>();
		List<Dict> list=dictService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * ????????????????????????
	*/
	@ApiOperation(value = "????????????????????????")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DictVOMeta.ID , value = "??????ID" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = DictVOMeta.IS_TREE , value = "??????????????????" , required = true , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DictVOMeta.NAME , value = "????????????" , required = false , dataTypeClass=String.class , example = "??????"),
		@ApiImplicitParam(name = DictVOMeta.CODE , value = "????????????" , required = false , dataTypeClass=String.class , example = "sex"),
		@ApiImplicitParam(name = DictVOMeta.MODULE , value = "????????????" , required = false , dataTypeClass=String.class , example = "463397133957988352"),
		@ApiImplicitParam(name = DictVOMeta.NOTES , value = "??????" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = DictServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DictServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Dict>> queryPagedList(DictVO sample) {
		Result<PagedList<Dict>> result=new Result<>();
		PagedList<Dict> list=dictService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join ???????????????
		dictService.dao().fill(list)
			.with(DictMeta.MODULE_INFO)
			.execute();
		result.success(true).data(list);
		return result;
	}






}