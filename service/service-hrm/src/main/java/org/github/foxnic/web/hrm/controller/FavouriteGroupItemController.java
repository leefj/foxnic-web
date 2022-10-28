package org.github.foxnic.web.hrm.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.hrm.FavouriteGroupItem;
import org.github.foxnic.web.domain.hrm.FavouriteGroupItemVO;
import org.github.foxnic.web.domain.hrm.meta.FavouriteGroupItemVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.hrm.service.IFavouriteGroupItemService;
import org.github.foxnic.web.proxy.hrm.FavouriteGroupItemServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 常用人员分组条目表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-20 06:14:04
 * @version
 */
@InDoc
@Api(tags = "人事服务/常用人员分组条目")
@ApiSort(0)
@RestController("HrmFavouriteGroupItemController")
public class FavouriteGroupItemController extends SuperController {

    @Autowired
    private IFavouriteGroupItemService favouriteGroupItemService;

    /**
     * 添加常用人员分组条目
     */
    @ApiOperation(value = "添加常用人员分组条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_ID, value = "对象ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_TYPE, value = "对象类型", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_NAME, value = "对象名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.GROUP_ID, value = "层级路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.EMPLOYEE_ID, value = "所有者ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TEMPORARY, value = "是否临时", required = true, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.COMPANY_ID, value = "总公司ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = FavouriteGroupItemServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FavouriteGroupItemServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(FavouriteGroupItemVO favouriteGroupItemVO) {
        Result result = favouriteGroupItemService.insert(favouriteGroupItemVO);
        return result;
    }

    /**
     * 添加常用人员分组条目
     */
    @ApiOperation(value = "添加常用人员分组条目")
    @ApiImplicitParams({})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = FavouriteGroupItemServiceProxy.INSERTS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FavouriteGroupItemServiceProxy.INSERTS)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result batchInsert(List<FavouriteGroupItemVO> list) {
        Result result = favouriteGroupItemService.inserts(list);
        return result;
    }

    /**
     * 添加常用人员分组条目
     */
    @ApiOperation(value = "添加常用人员分组条目")
    @ApiImplicitParams({})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = FavouriteGroupItemServiceProxy.REMOVE_ALL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FavouriteGroupItemServiceProxy.REMOVE_ALL)
    public Result removeAll(FavouriteGroupItemVO vo) {
        Result result = favouriteGroupItemService.removeAll(vo);
        return result;
    }

    /**
     * 删除常用人员分组条目
     */
    @ApiOperation(value = "删除常用人员分组条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = FavouriteGroupItemServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FavouriteGroupItemServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = favouriteGroupItemService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除常用人员分组条目 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除常用人员分组条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = FavouriteGroupItemServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FavouriteGroupItemServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = favouriteGroupItemService.deleteByIdsPhysical(ids);
        return result;
    }

    /**
     * 更新常用人员分组条目
     */
    @ApiOperation(value = "更新常用人员分组条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_ID, value = "对象ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_TYPE, value = "对象类型", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_NAME, value = "对象名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.GROUP_ID, value = "层级路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.EMPLOYEE_ID, value = "所有者ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TEMPORARY, value = "是否临时", required = true, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.COMPANY_ID, value = "总公司ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { FavouriteGroupItemVOMeta.PAGE_INDEX, FavouriteGroupItemVOMeta.PAGE_SIZE, FavouriteGroupItemVOMeta.SEARCH_FIELD, FavouriteGroupItemVOMeta.FUZZY_FIELD, FavouriteGroupItemVOMeta.SEARCH_VALUE, FavouriteGroupItemVOMeta.SORT_FIELD, FavouriteGroupItemVOMeta.SORT_TYPE, FavouriteGroupItemVOMeta.IDS })
    @SentinelResource(value = FavouriteGroupItemServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FavouriteGroupItemServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(FavouriteGroupItemVO favouriteGroupItemVO) {
        Result result = favouriteGroupItemService.update(favouriteGroupItemVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 保存常用人员分组条目
     */
    @ApiOperation(value = "保存常用人员分组条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_ID, value = "对象ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_TYPE, value = "对象类型", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_NAME, value = "对象名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.GROUP_ID, value = "层级路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.EMPLOYEE_ID, value = "所有者ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TEMPORARY, value = "是否临时", required = true, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.COMPANY_ID, value = "总公司ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { FavouriteGroupItemVOMeta.PAGE_INDEX, FavouriteGroupItemVOMeta.PAGE_SIZE, FavouriteGroupItemVOMeta.SEARCH_FIELD, FavouriteGroupItemVOMeta.FUZZY_FIELD, FavouriteGroupItemVOMeta.SEARCH_VALUE, FavouriteGroupItemVOMeta.SORT_FIELD, FavouriteGroupItemVOMeta.SORT_TYPE, FavouriteGroupItemVOMeta.IDS })
    @SentinelResource(value = FavouriteGroupItemServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FavouriteGroupItemServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(FavouriteGroupItemVO favouriteGroupItemVO) {
        Result result = favouriteGroupItemService.save(favouriteGroupItemVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 获取常用人员分组条目
     */
    @ApiOperation(value = "获取常用人员分组条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = FavouriteGroupItemServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FavouriteGroupItemServiceProxy.GET_BY_ID)
    public Result getById(String id) {
        Result result = new Result<>();
        JSONObject r = favouriteGroupItemService.translate(id);
        result.success(true).data(r);
        return result;
    }

    /**
     * 批量删除常用人员分组条目 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除常用人员分组条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = FavouriteGroupItemServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FavouriteGroupItemServiceProxy.GET_BY_IDS)
    public Result<List<FavouriteGroupItem>> getByIds(List<String> ids) {
        Result<List<FavouriteGroupItem>> result = new Result<>();
        List<FavouriteGroupItem> list = favouriteGroupItemService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询常用人员分组条目
     */
    @ApiOperation(value = "查询常用人员分组条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_ID, value = "对象ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_TYPE, value = "对象类型", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_NAME, value = "对象名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.GROUP_ID, value = "层级路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.EMPLOYEE_ID, value = "所有者ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TEMPORARY, value = "是否临时", required = true, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.COMPANY_ID, value = "总公司ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { FavouriteGroupItemVOMeta.PAGE_INDEX, FavouriteGroupItemVOMeta.PAGE_SIZE })
    @SentinelResource(value = FavouriteGroupItemServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FavouriteGroupItemServiceProxy.QUERY_LIST)
    public Result<List<FavouriteGroupItem>> queryList(FavouriteGroupItemVO sample) {
        Result<List<FavouriteGroupItem>> result = new Result<>();
        List<FavouriteGroupItem> list = favouriteGroupItemService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询常用人员分组条目
     */
    @ApiOperation(value = "分页查询常用人员分组条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_ID, value = "对象ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_TYPE, value = "对象类型", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TARGET_NAME, value = "对象名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.GROUP_ID, value = "层级路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.EMPLOYEE_ID, value = "所有者ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.TEMPORARY, value = "是否临时", required = true, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = FavouriteGroupItemVOMeta.COMPANY_ID, value = "总公司ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = FavouriteGroupItemServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(FavouriteGroupItemServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<FavouriteGroupItem>> queryPagedList(FavouriteGroupItemVO sample) {
        favouriteGroupItemService.initEmployees(sample.getInitValue());
        Result<PagedList<FavouriteGroupItem>> result = new Result<>();
        PagedList<FavouriteGroupItem> list = favouriteGroupItemService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

}
