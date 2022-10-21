package org.github.foxnic.web.system.controller;

import java.util.List;

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
import org.github.foxnic.web.proxy.system.CodeExampleMulitPkServiceProxy;
import org.github.foxnic.web.domain.system.meta.CodeExampleMulitPkVOMeta;
import org.github.foxnic.web.domain.system.CodeExampleMulitPk;
import org.github.foxnic.web.domain.system.CodeExampleMulitPkVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;

import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import org.github.foxnic.web.system.service.ICodeExampleMulitPkService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 主键多字段测试表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-02-11 13:02:52
 */
@Api(tags = "系统服务/主键多字段测试")
@ApiSort(0)
@RestController("SysCodeExampleMulitPkController")
public class CodeExampleMulitPkController extends SuperController {

    @Autowired
    private ICodeExampleMulitPkService codeExampleMulitPkService;

    /**
     * 添加主键多字段测试
     */
    @ApiOperation(value = "添加主键多字段测试")
    @ApiImplicitParams({ @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.NID, value = "主键1", required = true, dataTypeClass = Long.class), @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.DAY, value = "主键2", required = true, dataTypeClass = Date.class), @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class) })
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = CodeExampleMulitPkServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CodeExampleMulitPkServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(CodeExampleMulitPkVO codeExampleMulitPkVO) {
        Result result = codeExampleMulitPkService.insert(codeExampleMulitPkVO, false);
        return result;
    }

    /**
     * 删除主键多字段测试
     */
    @ApiOperation(value = "删除主键多字段测试")
    @ApiImplicitParams({ @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.NID, value = "主键1", required = true, dataTypeClass = Long.class), @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.DAY, value = "主键2", required = true, dataTypeClass = Date.class) })
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = CodeExampleMulitPkServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CodeExampleMulitPkServiceProxy.DELETE)
    public Result deleteById(Long nid, Date day) {
        Result result = codeExampleMulitPkService.deleteByIdPhysical(nid, day);
        return result;
    }

    /**
     * 更新主键多字段测试
     */
    @ApiOperation(value = "更新主键多字段测试")
    @ApiImplicitParams({ @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.NID, value = "主键1", required = true, dataTypeClass = Long.class), @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.DAY, value = "主键2", required = true, dataTypeClass = Date.class), @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class) })
    @ApiOperationSupport(order = 4, ignoreParameters = { CodeExampleMulitPkVOMeta.PAGE_INDEX, CodeExampleMulitPkVOMeta.PAGE_SIZE, CodeExampleMulitPkVOMeta.SEARCH_FIELD, CodeExampleMulitPkVOMeta.FUZZY_FIELD, CodeExampleMulitPkVOMeta.SEARCH_VALUE, CodeExampleMulitPkVOMeta.DIRTY_FIELDS, CodeExampleMulitPkVOMeta.SORT_FIELD, CodeExampleMulitPkVOMeta.SORT_TYPE })
    @SentinelResource(value = CodeExampleMulitPkServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CodeExampleMulitPkServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(CodeExampleMulitPkVO codeExampleMulitPkVO) {
        Result result = codeExampleMulitPkService.update(codeExampleMulitPkVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存主键多字段测试
     */
    @ApiOperation(value = "保存主键多字段测试")
    @ApiImplicitParams({ @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.NID, value = "主键1", required = true, dataTypeClass = Long.class), @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.DAY, value = "主键2", required = true, dataTypeClass = Date.class), @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class) })
    @ApiOperationSupport(order = 5, ignoreParameters = { CodeExampleMulitPkVOMeta.PAGE_INDEX, CodeExampleMulitPkVOMeta.PAGE_SIZE, CodeExampleMulitPkVOMeta.SEARCH_FIELD, CodeExampleMulitPkVOMeta.FUZZY_FIELD, CodeExampleMulitPkVOMeta.SEARCH_VALUE, CodeExampleMulitPkVOMeta.DIRTY_FIELDS, CodeExampleMulitPkVOMeta.SORT_FIELD, CodeExampleMulitPkVOMeta.SORT_TYPE })
    @SentinelResource(value = CodeExampleMulitPkServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CodeExampleMulitPkServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(CodeExampleMulitPkVO codeExampleMulitPkVO) {
        Result result = codeExampleMulitPkService.save(codeExampleMulitPkVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取主键多字段测试
     */
    @ApiOperation(value = "获取主键多字段测试")
    @ApiImplicitParams({ @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.NID, value = "主键", required = true, dataTypeClass = Long.class, example = "1"), @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.DAY, value = "主键", required = true, dataTypeClass = Date.class, example = "1") })
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = CodeExampleMulitPkServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CodeExampleMulitPkServiceProxy.GET_BY_ID)
    public Result<CodeExampleMulitPk> getById(Long nid, Date day) {
        Result<CodeExampleMulitPk> result = new Result<>();
        CodeExampleMulitPk codeExampleMulitPk = codeExampleMulitPkService.getById(nid, day);
        result.success(true).data(codeExampleMulitPk);
        return result;
    }

    /**
     * 查询主键多字段测试
     */
    @ApiOperation(value = "查询主键多字段测试")
    @ApiImplicitParams({ @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.NID, value = "主键1", required = true, dataTypeClass = Long.class), @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.DAY, value = "主键2", required = true, dataTypeClass = Date.class), @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class) })
    @ApiOperationSupport(order = 5, ignoreParameters = { CodeExampleMulitPkVOMeta.PAGE_INDEX, CodeExampleMulitPkVOMeta.PAGE_SIZE })
    @SentinelResource(value = CodeExampleMulitPkServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CodeExampleMulitPkServiceProxy.QUERY_LIST)
    public Result<List<CodeExampleMulitPk>> queryList(CodeExampleMulitPkVO sample) {
        Result<List<CodeExampleMulitPk>> result = new Result<>();
        List<CodeExampleMulitPk> list = codeExampleMulitPkService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询主键多字段测试
     */
    @ApiOperation(value = "分页查询主键多字段测试")
    @ApiImplicitParams({ @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.NID, value = "主键1", required = true, dataTypeClass = Long.class), @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.DAY, value = "主键2", required = true, dataTypeClass = Date.class), @ApiImplicitParam(name = CodeExampleMulitPkVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class) })
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = CodeExampleMulitPkServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CodeExampleMulitPkServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CodeExampleMulitPk>> queryPagedList(CodeExampleMulitPkVO sample) {
        Result<PagedList<CodeExampleMulitPk>> result = new Result<>();
        PagedList<CodeExampleMulitPk> list = codeExampleMulitPkService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = CodeExampleMulitPkServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(CodeExampleMulitPkServiceProxy.EXPORT_EXCEL)
    public void exportExcel(CodeExampleMulitPkVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = codeExampleMulitPkService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = CodeExampleMulitPkServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(CodeExampleMulitPkServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = codeExampleMulitPkService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = CodeExampleMulitPkServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(CodeExampleMulitPkServiceProxy.IMPORT_EXCEL)
    public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获得上传的文件
        Map<String, MultipartFile> map = request.getFileMap();
        InputStream input = null;
        for (MultipartFile mf : map.values()) {
            input = StreamUtil.bytes2input(mf.getBytes());
            break;
        }
        if (input == null) {
            return ErrorDesc.failure().message("缺少上传的文件");
        }
        List<ValidateResult> errors = codeExampleMulitPkService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
