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
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.system.BusiRoleVO;
import org.github.foxnic.web.domain.system.meta.BusiRoleVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.system.BusiRoleServiceProxy;
import org.github.foxnic.web.system.service.IBusiRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 业务角色表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-16 11:22:37
 * @version
 */
@InDoc
@Api(tags = "系统服务/业务角色")
@ApiSort(0)
@RestController("SysBusiRoleController")
public class BusiRoleController extends SuperController {

    @Autowired
    private IBusiRoleService busiRoleService;

    /**
     * 添加业务角色
     */
    @ApiOperation(value = "添加业务角色")
    @ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "498946989573017600"),
		@ApiImplicitParam(name = BusiRoleVOMeta.ORG_ID, value = "所属组织ID", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.CODE, value = "角色代码", required = false, dataTypeClass = String.class, example = "drafter"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NAME, value = "角色名称", required = false, dataTypeClass = String.class, example = "起草人"),
		@ApiImplicitParam(name = BusiRoleVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = BusiRoleServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BusiRoleServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(BusiRoleVO busiRoleVO) {
        Result result = busiRoleService.insert(busiRoleVO, false);
        return result;
    }

    /**
     * 删除业务角色
     */
    @ApiOperation(value = "删除业务角色")
    @ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "498946989573017600")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = BusiRoleServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BusiRoleServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = busiRoleService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除业务角色 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除业务角色")
    @ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = BusiRoleServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BusiRoleServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = busiRoleService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新业务角色
     */
    @ApiOperation(value = "更新业务角色")
    @ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "498946989573017600"),
		@ApiImplicitParam(name = BusiRoleVOMeta.ORG_ID, value = "所属组织ID", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.CODE, value = "角色代码", required = false, dataTypeClass = String.class, example = "drafter"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NAME, value = "角色名称", required = false, dataTypeClass = String.class, example = "起草人"),
		@ApiImplicitParam(name = BusiRoleVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { BusiRoleVOMeta.PAGE_INDEX, BusiRoleVOMeta.PAGE_SIZE, BusiRoleVOMeta.SEARCH_FIELD, BusiRoleVOMeta.FUZZY_FIELD, BusiRoleVOMeta.SEARCH_VALUE, BusiRoleVOMeta.SORT_FIELD, BusiRoleVOMeta.SORT_TYPE, BusiRoleVOMeta.IDS })
    @SentinelResource(value = BusiRoleServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BusiRoleServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(BusiRoleVO busiRoleVO) {
        Result result = busiRoleService.update(busiRoleVO, SaveMode.NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存业务角色
     */
    @ApiOperation(value = "保存业务角色")
    @ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "498946989573017600"),
		@ApiImplicitParam(name = BusiRoleVOMeta.ORG_ID, value = "所属组织ID", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.CODE, value = "角色代码", required = false, dataTypeClass = String.class, example = "drafter"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NAME, value = "角色名称", required = false, dataTypeClass = String.class, example = "起草人"),
		@ApiImplicitParam(name = BusiRoleVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { BusiRoleVOMeta.PAGE_INDEX, BusiRoleVOMeta.PAGE_SIZE, BusiRoleVOMeta.SEARCH_FIELD, BusiRoleVOMeta.FUZZY_FIELD, BusiRoleVOMeta.SEARCH_VALUE, BusiRoleVOMeta.SORT_FIELD, BusiRoleVOMeta.SORT_TYPE, BusiRoleVOMeta.IDS })
    @SentinelResource(value = BusiRoleServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BusiRoleServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(BusiRoleVO busiRoleVO) {
        Result result = busiRoleService.save(busiRoleVO, SaveMode.NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取业务角色
     */
    @ApiOperation(value = "获取业务角色")
    @ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = BusiRoleServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BusiRoleServiceProxy.GET_BY_ID)
    public Result<BusiRole> getById(String id) {
        Result<BusiRole> result = new Result<>();
        BusiRole busiRole = busiRoleService.getById(id);
        result.success(true).data(busiRole);
        return result;
    }

    /**
     * 获取员工对应的业务角色
     */
    @ApiOperation(value = "获取员工对应的业务角色")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "employeeId", value = "员工ID", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = BusiRoleServiceProxy.GET_EMPLOYEE_ROLES, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BusiRoleServiceProxy.GET_EMPLOYEE_ROLES)
    public Result<List<BusiRole>> getEmployeeRoles(String employeeId) {
        Result<List<BusiRole>> result = new Result<>();
        List<BusiRole> busiRole = busiRoleService.getEmployeeRoles(employeeId);
        result.success(true).data(busiRole);
        return result;
    }

    /**
     * 获取业务角色
     */
    @ApiOperation(value = "获取业务角色")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "codes", value = "代码", required = true, dataTypeClass = String.class, example = "001")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = BusiRoleServiceProxy.GET_BY_CODES, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BusiRoleServiceProxy.GET_BY_CODES)
    public Result<List<BusiRole>> getByCodes(List<String> codes) {
        Result<List<BusiRole>> result = new Result<>();
        List<BusiRole> busiRole = busiRoleService.getByCodes(codes);
        result.success(true).data(busiRole);
        return result;
    }

    /**
     * 批量获取业务角色 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取业务角色")
    @ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = BusiRoleServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BusiRoleServiceProxy.GET_BY_IDS)
    public Result<List<BusiRole>> getByIds(List<String> ids) {
        Result<List<BusiRole>> result = new Result<>();
        List<BusiRole> list = busiRoleService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询业务角色
     */
    @ApiOperation(value = "查询业务角色")
    @ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "498946989573017600"),
		@ApiImplicitParam(name = BusiRoleVOMeta.ORG_ID, value = "所属组织ID", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.CODE, value = "角色代码", required = false, dataTypeClass = String.class, example = "drafter"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NAME, value = "角色名称", required = false, dataTypeClass = String.class, example = "起草人"),
		@ApiImplicitParam(name = BusiRoleVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { BusiRoleVOMeta.PAGE_INDEX, BusiRoleVOMeta.PAGE_SIZE })
    @SentinelResource(value = BusiRoleServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BusiRoleServiceProxy.QUERY_LIST)
    public Result<List<BusiRole>> queryList(BusiRoleVO sample) {
        Result<List<BusiRole>> result = new Result<>();
        List<BusiRole> list = busiRoleService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询业务角色
     */
    @ApiOperation(value = "分页查询业务角色")
    @ApiImplicitParams({
		@ApiImplicitParam(name = BusiRoleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "498946989573017600"),
		@ApiImplicitParam(name = BusiRoleVOMeta.ORG_ID, value = "所属组织ID", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.CODE, value = "角色代码", required = false, dataTypeClass = String.class, example = "drafter"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NAME, value = "角色名称", required = false, dataTypeClass = String.class, example = "起草人"),
		@ApiImplicitParam(name = BusiRoleVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BusiRoleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = BusiRoleServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BusiRoleServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<BusiRole>> queryPagedList(BusiRoleVO sample) {
        Result<PagedList<BusiRole>> result = new Result<>();
        PagedList<BusiRole> list = busiRoleService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
