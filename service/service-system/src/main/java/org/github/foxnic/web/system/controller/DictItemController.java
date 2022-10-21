package org.github.foxnic.web.system.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
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
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import org.github.foxnic.web.domain.system.meta.DictItemVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import org.github.foxnic.web.system.service.IDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 数据字典条目 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-20 01:06:36
 */
@InDoc
@Api(tags = "系统服务/数据字典条目")
@ApiSort(0)
@RestController("SysDictItemController")
public class DictItemController extends SuperController {

    @Autowired
    private IDictItemService dictItemService;

    /**
     * 添加数据字典条目
     */
    @ApiOperation(value = "添加数据字典条目")
    @ApiImplicitParams({ @ApiImplicitParam(name = DictItemVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.DICT_ID, value = "字典ID", required = false, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.DICT_CODE, value = "字典代码", required = true, dataTypeClass = String.class, example = "sex"), @ApiImplicitParam(name = DictItemVOMeta.PARENT_ID, value = "上级条目ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = DictItemVOMeta.CODE, value = "代码", required = false, dataTypeClass = String.class, example = "F"), @ApiImplicitParam(name = DictItemVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "男"), @ApiImplicitParam(name = DictItemVOMeta.SORT, value = "排序", required = true, dataTypeClass = Integer.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.VALID, value = "有效", required = false, dataTypeClass = Integer.class) })
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = DictItemServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DictItemServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(DictItemVO dictItemVO) {
        Result result = dictItemService.insert(dictItemVO);
        return result;
    }

    /**
     * 删除数据字典条目
     */
    @ApiOperation(value = "删除数据字典条目")
    @ApiImplicitParams({ @ApiImplicitParam(name = DictItemVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "1") })
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = DictItemServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DictItemServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = dictItemService.deleteByIdPhysical(id);
        return result;
    }

    /**
     * 批量删除数据字典条目 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除数据字典条目")
    @ApiImplicitParams({ @ApiImplicitParam(name = DictItemVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]") })
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = DictItemServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DictItemServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = dictItemService.deleteByIdsPhysical(ids);
        return result;
    }

    /**
     * 更新数据字典条目
     */
    @ApiOperation(value = "更新数据字典条目")
    @ApiImplicitParams({ @ApiImplicitParam(name = DictItemVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.DICT_ID, value = "字典ID", required = false, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.DICT_CODE, value = "字典代码", required = true, dataTypeClass = String.class, example = "sex"), @ApiImplicitParam(name = DictItemVOMeta.PARENT_ID, value = "上级条目ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = DictItemVOMeta.CODE, value = "代码", required = false, dataTypeClass = String.class, example = "F"), @ApiImplicitParam(name = DictItemVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "男"), @ApiImplicitParam(name = DictItemVOMeta.SORT, value = "排序", required = true, dataTypeClass = Integer.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.VALID, value = "有效", required = false, dataTypeClass = Integer.class) })
    @ApiOperationSupport(order = 4, ignoreParameters = { DictItemVOMeta.PAGE_INDEX, DictItemVOMeta.PAGE_SIZE, DictItemVOMeta.SEARCH_FIELD, DictItemVOMeta.FUZZY_FIELD, DictItemVOMeta.SEARCH_VALUE, DictItemVOMeta.SORT_FIELD, DictItemVOMeta.SORT_TYPE, DictItemVOMeta.IDS })
    @SentinelResource(value = DictItemServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DictItemServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(DictItemVO dictItemVO) {
        Result result = dictItemService.update(dictItemVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 保存数据字典条目
     */
    @ApiOperation(value = "保存数据字典条目")
    @ApiImplicitParams({ @ApiImplicitParam(name = DictItemVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.DICT_ID, value = "字典ID", required = false, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.DICT_CODE, value = "字典代码", required = true, dataTypeClass = String.class, example = "sex"), @ApiImplicitParam(name = DictItemVOMeta.PARENT_ID, value = "上级条目ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = DictItemVOMeta.CODE, value = "代码", required = false, dataTypeClass = String.class, example = "F"), @ApiImplicitParam(name = DictItemVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "男"), @ApiImplicitParam(name = DictItemVOMeta.SORT, value = "排序", required = true, dataTypeClass = Integer.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.VALID, value = "有效", required = false, dataTypeClass = Integer.class) })
    @ApiOperationSupport(order = 5, ignoreParameters = { DictItemVOMeta.PAGE_INDEX, DictItemVOMeta.PAGE_SIZE, DictItemVOMeta.SEARCH_FIELD, DictItemVOMeta.FUZZY_FIELD, DictItemVOMeta.SEARCH_VALUE, DictItemVOMeta.SORT_FIELD, DictItemVOMeta.SORT_TYPE, DictItemVOMeta.IDS })
    @SentinelResource(value = DictItemServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DictItemServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(DictItemVO dictItemVO) {
        Result result = dictItemService.save(dictItemVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 获取数据字典条目
     */
    @ApiOperation(value = "获取数据字典条目")
    @ApiImplicitParams({ @ApiImplicitParam(name = DictItemVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1") })
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = DictItemServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DictItemServiceProxy.GET_BY_ID)
    public Result<DictItem> getById(String id) {
        Result<DictItem> result = new Result<>();
        DictItem dictItem = dictItemService.getById(id);
        result.success(true).data(dictItem);
        return result;
    }

    /**
     * 批量删除数据字典条目 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除数据字典条目")
    @ApiImplicitParams({ @ApiImplicitParam(name = DictItemVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]") })
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = DictItemServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DictItemServiceProxy.GET_BY_IDS)
    public Result<List<DictItem>> getByIds(List<String> ids) {
        Result<List<DictItem>> result = new Result<>();
        List<DictItem> list = dictItemService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询数据字典条目
     */
    @ApiOperation(value = "查询数据字典条目")
    @ApiImplicitParams({ @ApiImplicitParam(name = DictItemVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.DICT_ID, value = "字典ID", required = false, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.DICT_CODE, value = "字典代码", required = true, dataTypeClass = String.class, example = "sex"), @ApiImplicitParam(name = DictItemVOMeta.PARENT_ID, value = "上级条目ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = DictItemVOMeta.CODE, value = "代码", required = false, dataTypeClass = String.class, example = "F"), @ApiImplicitParam(name = DictItemVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "男"), @ApiImplicitParam(name = DictItemVOMeta.SORT, value = "排序", required = true, dataTypeClass = Integer.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.VALID, value = "有效", required = false, dataTypeClass = Integer.class) })
    @ApiOperationSupport(order = 5, ignoreParameters = { DictItemVOMeta.PAGE_INDEX, DictItemVOMeta.PAGE_SIZE })
    @SentinelResource(value = DictItemServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DictItemServiceProxy.QUERY_LIST)
    public Result<List<DictItem>> queryList(DictItemVO sample) {
        Result<List<DictItem>> result = new Result<>();
        List<DictItem> list = dictItemService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询数据字典条目
     */
    @ApiOperation(value = "分页查询数据字典条目")
    @ApiImplicitParams({ @ApiImplicitParam(name = DictItemVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.DICT_ID, value = "字典ID", required = false, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.DICT_CODE, value = "字典代码", required = true, dataTypeClass = String.class, example = "sex"), @ApiImplicitParam(name = DictItemVOMeta.PARENT_ID, value = "上级条目ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = DictItemVOMeta.CODE, value = "代码", required = false, dataTypeClass = String.class, example = "F"), @ApiImplicitParam(name = DictItemVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "男"), @ApiImplicitParam(name = DictItemVOMeta.SORT, value = "排序", required = true, dataTypeClass = Integer.class, example = "1"), @ApiImplicitParam(name = DictItemVOMeta.VALID, value = "有效", required = false, dataTypeClass = Integer.class) })
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = DictItemServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DictItemServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<DictItem>> queryPagedList(DictItemVO sample) {
        Result<PagedList<DictItem>> result = new Result<>();
        PagedList<DictItem> list = dictItemService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

}
