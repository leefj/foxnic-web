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
import org.github.foxnic.web.domain.system.Sequence;
import org.github.foxnic.web.domain.system.SequenceVO;
import org.github.foxnic.web.domain.system.meta.SequenceVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.system.SequenceServiceProxy;
import org.github.foxnic.web.system.service.ISequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 序列表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-11 15:59:19
 * @version
 */
@InDoc
@Api(tags = "系统服务/序列")
@ApiSort(0)
@RestController("SysSequenceController")
public class SequenceController extends SuperController {

    @Autowired
    private ISequenceService sequenceService;

    /**
     * 添加序列
     */
    @ApiOperation(value = "添加序列")
    @ApiImplicitParams({ @ApiImplicitParam(name = SequenceVOMeta.PK, value = "主键", required = true, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = SequenceVOMeta.ID, value = "序列ID", required = true, dataTypeClass = String.class, example = "asset"), @ApiImplicitParam(name = SequenceVOMeta.NAME, value = "序列名称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.LENGTH, value = "编码长度", required = false, dataTypeClass = Integer.class, example = "5"), @ApiImplicitParam(name = SequenceVOMeta.CATALOG, value = "编码分类", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.VALUE, value = "当前数值", required = false, dataTypeClass = Long.class, example = "12"), @ApiImplicitParam(name = SequenceVOMeta.MEMO, value = "备注", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.TYPE, value = "编码类型", required = false, dataTypeClass = String.class, example = "AI"), @ApiImplicitParam(name = SequenceVOMeta.FETCH_SIZE, value = "每次取数的个数", required = true, dataTypeClass = Integer.class, example = "4") })
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = SequenceServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SequenceServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(SequenceVO sequenceVO) {
        Result result = sequenceService.insert(sequenceVO);
        return result;
    }

    /**
     * 删除序列
     */
    @ApiOperation(value = "删除序列")
    @ApiImplicitParams({ @ApiImplicitParam(name = SequenceVOMeta.PK, value = "主键", required = true, dataTypeClass = String.class, example = "1") })
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = SequenceServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SequenceServiceProxy.DELETE)
    public Result deleteById(String pk) {
        Result result = sequenceService.deleteByIdPhysical(pk);
        return result;
    }

    /**
     * 批量删除序列 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除序列")
    @ApiImplicitParams({ @ApiImplicitParam(name = SequenceVOMeta.PKS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]") })
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = SequenceServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SequenceServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> pks) {
        Result result = sequenceService.deleteByIdsLogical(pks);
        return result;
    }

    /**
     * 更新序列
     */
    @ApiOperation(value = "更新序列")
    @ApiImplicitParams({ @ApiImplicitParam(name = SequenceVOMeta.PK, value = "主键", required = true, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = SequenceVOMeta.ID, value = "序列ID", required = true, dataTypeClass = String.class, example = "asset"), @ApiImplicitParam(name = SequenceVOMeta.NAME, value = "序列名称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.LENGTH, value = "编码长度", required = false, dataTypeClass = Integer.class, example = "5"), @ApiImplicitParam(name = SequenceVOMeta.CATALOG, value = "编码分类", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.VALUE, value = "当前数值", required = false, dataTypeClass = Long.class, example = "12"), @ApiImplicitParam(name = SequenceVOMeta.MEMO, value = "备注", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.TYPE, value = "编码类型", required = false, dataTypeClass = String.class, example = "AI"), @ApiImplicitParam(name = SequenceVOMeta.FETCH_SIZE, value = "每次取数的个数", required = true, dataTypeClass = Integer.class, example = "4") })
    @ApiOperationSupport(order = 4, ignoreParameters = { SequenceVOMeta.PAGE_INDEX, SequenceVOMeta.PAGE_SIZE, SequenceVOMeta.SEARCH_FIELD, SequenceVOMeta.FUZZY_FIELD, SequenceVOMeta.SEARCH_VALUE, SequenceVOMeta.SORT_FIELD, SequenceVOMeta.SORT_TYPE, SequenceVOMeta.PKS })
    @SentinelResource(value = SequenceServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SequenceServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(SequenceVO sequenceVO) {
        Result result = sequenceService.update(sequenceVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 保存序列
     */
    @ApiOperation(value = "保存序列")
    @ApiImplicitParams({ @ApiImplicitParam(name = SequenceVOMeta.PK, value = "主键", required = true, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = SequenceVOMeta.ID, value = "序列ID", required = true, dataTypeClass = String.class, example = "asset"), @ApiImplicitParam(name = SequenceVOMeta.NAME, value = "序列名称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.LENGTH, value = "编码长度", required = false, dataTypeClass = Integer.class, example = "5"), @ApiImplicitParam(name = SequenceVOMeta.CATALOG, value = "编码分类", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.VALUE, value = "当前数值", required = false, dataTypeClass = Long.class, example = "12"), @ApiImplicitParam(name = SequenceVOMeta.MEMO, value = "备注", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.TYPE, value = "编码类型", required = false, dataTypeClass = String.class, example = "AI"), @ApiImplicitParam(name = SequenceVOMeta.FETCH_SIZE, value = "每次取数的个数", required = true, dataTypeClass = Integer.class, example = "4") })
    @ApiOperationSupport(order = 5, ignoreParameters = { SequenceVOMeta.PAGE_INDEX, SequenceVOMeta.PAGE_SIZE, SequenceVOMeta.SEARCH_FIELD, SequenceVOMeta.FUZZY_FIELD, SequenceVOMeta.SEARCH_VALUE, SequenceVOMeta.SORT_FIELD, SequenceVOMeta.SORT_TYPE, SequenceVOMeta.PKS })
    @SentinelResource(value = SequenceServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SequenceServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(SequenceVO sequenceVO) {
        Result result = sequenceService.save(sequenceVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 获取序列
     */
    @ApiOperation(value = "获取序列")
    @ApiImplicitParams({ @ApiImplicitParam(name = SequenceVOMeta.PK, value = "主键", required = true, dataTypeClass = String.class, example = "1") })
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = SequenceServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SequenceServiceProxy.GET_BY_ID)
    public Result<Sequence> getById(String pk) {
        Result<Sequence> result = new Result<>();
        Sequence sequence = sequenceService.getById(pk);
        result.success(true).data(sequence);
        return result;
    }

    /**
     * 批量删除序列 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除序列")
    @ApiImplicitParams({ @ApiImplicitParam(name = SequenceVOMeta.PKS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]") })
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = SequenceServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SequenceServiceProxy.GET_BY_IDS)
    public Result<List<Sequence>> getByIds(List<String> pks) {
        Result<List<Sequence>> result = new Result<>();
        List<Sequence> list = sequenceService.getByIds(pks);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询序列
     */
    @ApiOperation(value = "查询序列")
    @ApiImplicitParams({ @ApiImplicitParam(name = SequenceVOMeta.PK, value = "主键", required = true, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = SequenceVOMeta.ID, value = "序列ID", required = true, dataTypeClass = String.class, example = "asset"), @ApiImplicitParam(name = SequenceVOMeta.NAME, value = "序列名称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.LENGTH, value = "编码长度", required = false, dataTypeClass = Integer.class, example = "5"), @ApiImplicitParam(name = SequenceVOMeta.CATALOG, value = "编码分类", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.VALUE, value = "当前数值", required = false, dataTypeClass = Long.class, example = "12"), @ApiImplicitParam(name = SequenceVOMeta.MEMO, value = "备注", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.TYPE, value = "编码类型", required = false, dataTypeClass = String.class, example = "AI"), @ApiImplicitParam(name = SequenceVOMeta.FETCH_SIZE, value = "每次取数的个数", required = true, dataTypeClass = Integer.class, example = "4") })
    @ApiOperationSupport(order = 5, ignoreParameters = { SequenceVOMeta.PAGE_INDEX, SequenceVOMeta.PAGE_SIZE })
    @SentinelResource(value = SequenceServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SequenceServiceProxy.QUERY_LIST)
    public Result<List<Sequence>> queryList(SequenceVO sample) {
        Result<List<Sequence>> result = new Result<>();
        List<Sequence> list = sequenceService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询序列
     */
    @ApiOperation(value = "分页查询序列")
    @ApiImplicitParams({ @ApiImplicitParam(name = SequenceVOMeta.PK, value = "主键", required = true, dataTypeClass = String.class, example = "1"), @ApiImplicitParam(name = SequenceVOMeta.ID, value = "序列ID", required = true, dataTypeClass = String.class, example = "asset"), @ApiImplicitParam(name = SequenceVOMeta.NAME, value = "序列名称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.LENGTH, value = "编码长度", required = false, dataTypeClass = Integer.class, example = "5"), @ApiImplicitParam(name = SequenceVOMeta.CATALOG, value = "编码分类", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.VALUE, value = "当前数值", required = false, dataTypeClass = Long.class, example = "12"), @ApiImplicitParam(name = SequenceVOMeta.MEMO, value = "备注", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = SequenceVOMeta.TYPE, value = "编码类型", required = false, dataTypeClass = String.class, example = "AI"), @ApiImplicitParam(name = SequenceVOMeta.FETCH_SIZE, value = "每次取数的个数", required = true, dataTypeClass = Integer.class, example = "4") })
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = SequenceServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SequenceServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Sequence>> queryPagedList(SequenceVO sample) {
        String val = sequenceService.dao().getSequence("pcm-catalog-version-no").next();
        System.err.println(val);
        Result<PagedList<Sequence>> result = new Result<>();
        PagedList<Sequence> list = sequenceService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
