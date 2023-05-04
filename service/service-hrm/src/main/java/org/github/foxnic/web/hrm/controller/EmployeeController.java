package org.github.foxnic.web.hrm.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.EmployeeVO;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.EmployeeVOMeta;
import org.github.foxnic.web.domain.hrm.meta.PositionMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.hrm.service.IEmployeeService;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-15 16:24:05
 * @version
 */
@InDoc
@Api(tags = "人事服务/员工")
@ApiSort(0)
@RestController("HrmEmployeeController")
public class EmployeeController extends SuperController {

    @Autowired
    private IEmployeeService employeeService;

    /**
     * 添加员工
     */
    @ApiOperation(value = "添加员工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "483311859227693056"),
		@ApiImplicitParam(name = EmployeeVOMeta.BADGE, value = "工号", required = false, dataTypeClass = String.class, example = "111"),
		@ApiImplicitParam(name = EmployeeVOMeta.PHONE, value = "手机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.PERSON_ID, value = "人员ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID, value = "公司ID", required = false, dataTypeClass = String.class, example = "482962368444239872"),
		@ApiImplicitParam(name = EmployeeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.DIRECT_LEADER_ID, value = "直属领导ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = EmployeeServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(EmployeeServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(EmployeeVO employeeVO) {
        Result result = employeeService.insert(employeeVO);
        return result;
    }

    /**
     * 删除员工
     */
    @ApiOperation(value = "删除员工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "483311859227693056")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = EmployeeServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(EmployeeServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = employeeService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前员工:" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = employeeService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除员工 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除员工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = EmployeeServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(EmployeeServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> hasRefersMap = employeeService.hasRefers(ids);
        // 收集可以删除的ID值
        List<String> canDeleteIds = new ArrayList<>();
        for (Map.Entry<String, ReferCause> e : hasRefersMap.entrySet()) {
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
            Result result = employeeService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = employeeService.deleteByIdsLogical(canDeleteIds);
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
     * 更新员工
     */
    @ApiOperation(value = "更新员工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "483311859227693056"),
		@ApiImplicitParam(name = EmployeeVOMeta.BADGE, value = "工号", required = false, dataTypeClass = String.class, example = "111"),
		@ApiImplicitParam(name = EmployeeVOMeta.PHONE, value = "手机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.PERSON_ID, value = "人员ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID, value = "公司ID", required = false, dataTypeClass = String.class, example = "482962368444239872"),
		@ApiImplicitParam(name = EmployeeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.DIRECT_LEADER_ID, value = "直属领导ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { EmployeeVOMeta.PAGE_INDEX, EmployeeVOMeta.PAGE_SIZE, EmployeeVOMeta.SEARCH_FIELD, EmployeeVOMeta.FUZZY_FIELD, EmployeeVOMeta.SEARCH_VALUE, EmployeeVOMeta.SORT_FIELD, EmployeeVOMeta.SORT_TYPE, EmployeeVOMeta.IDS, EmployeeVOMeta.ORG_ID, EmployeeVOMeta.POSITION_ID })
    @SentinelResource(value = EmployeeServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(EmployeeServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(EmployeeVO employeeVO) {
        Result result = employeeService.update(employeeVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 保存员工
     */
    @ApiOperation(value = "保存员工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "483311859227693056"),
		@ApiImplicitParam(name = EmployeeVOMeta.BADGE, value = "工号", required = false, dataTypeClass = String.class, example = "111"),
		@ApiImplicitParam(name = EmployeeVOMeta.PHONE, value = "手机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.PERSON_ID, value = "人员ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID, value = "公司ID", required = false, dataTypeClass = String.class, example = "482962368444239872"),
		@ApiImplicitParam(name = EmployeeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.DIRECT_LEADER_ID, value = "直属领导ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { EmployeeVOMeta.PAGE_INDEX, EmployeeVOMeta.PAGE_SIZE, EmployeeVOMeta.SEARCH_FIELD, EmployeeVOMeta.FUZZY_FIELD, EmployeeVOMeta.SEARCH_VALUE, EmployeeVOMeta.SORT_FIELD, EmployeeVOMeta.SORT_TYPE, EmployeeVOMeta.IDS, EmployeeVOMeta.ORG_ID, EmployeeVOMeta.POSITION_ID })
    @SentinelResource(value = EmployeeServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(EmployeeServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(EmployeeVO employeeVO) {
        Result result = employeeService.save(employeeVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 获取员工
     */
    @ApiOperation(value = "获取员工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = EmployeeServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(EmployeeServiceProxy.GET_BY_ID)
    public Result<Employee> getById(String id) {
        Result<Employee> result = new Result<>();
        Employee employee = employeeService.getById(id);
        // 关联出 姓名 数据
        employeeService.dao().fill(employee).with(EmployeeMeta.PERSON).with(EmployeeMeta.POSITIONS, PositionMeta.ORGANIZATION).with(EmployeeMeta.DIRECT_LEADER,EmployeeMeta.PERSON).execute();
        // 按主岗设置主部门
        if (employee.getPrimaryPosition() != null) {
            employee.setPrimaryOrganization(employee.getPrimaryPosition().getOrganization());
        }
        result.success(true).data(employee);
        return result;
    }

    /**
     * 批量删除员工 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除员工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = EmployeeServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(EmployeeServiceProxy.GET_BY_IDS)
    public Result<List<Employee>> getByIds(List<String> ids) {
        Result<List<Employee>> result = new Result<>();
        List<Employee> list = employeeService.getByIds(ids);
        // 关联出 姓名 数据
        employeeService.join(list, EmployeeMeta.PERSON);
        result.success(true).data(list);
        return result;
    }

    /**
     * 按工号获取员工
     */
    @ApiOperation(value = "按工号获取员工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.BADGE, value = "工号", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = EmployeeServiceProxy.GET_BY_BADGE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(EmployeeServiceProxy.GET_BY_BADGE)
    public Result<Employee> getByBadge(String badge) {
        Result<Employee> result = new Result<>();
        Employee employee = employeeService.getByBadge(badge);
        // 关联出 姓名 数据
        employeeService.join(employee, EmployeeMeta.PERSON);
        result.success(true).data(employee);
        return result;
    }

    /**
     * 批量按工号获取员工 <br>
     */
    @ApiOperation(value = "批量按工号获取员工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "badges", value = "工号清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = EmployeeServiceProxy.GET_BY_BADGES, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(EmployeeServiceProxy.GET_BY_BADGES)
    public Result<List<Employee>> getByBadges(List<String> badges) {
        Result<List<Employee>> result = new Result<>();
        List<Employee> list = employeeService.getByBadges(badges);
        // 关联出 姓名 数据
        employeeService.join(list, EmployeeMeta.PERSON);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询员工
     */
    @ApiOperation(value = "查询员工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "483311859227693056"),
		@ApiImplicitParam(name = EmployeeVOMeta.BADGE, value = "工号", required = false, dataTypeClass = String.class, example = "111"),
		@ApiImplicitParam(name = EmployeeVOMeta.PHONE, value = "手机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.PERSON_ID, value = "人员ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID, value = "公司ID", required = false, dataTypeClass = String.class, example = "482962368444239872"),
		@ApiImplicitParam(name = EmployeeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.DIRECT_LEADER_ID, value = "直属领导ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { EmployeeVOMeta.PAGE_INDEX, EmployeeVOMeta.PAGE_SIZE })
    @SentinelResource(value = EmployeeServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(EmployeeServiceProxy.QUERY_LIST)
    public Result<List<Employee>> queryList(EmployeeVO sample) {
        Result<List<Employee>> result = new Result<>();
        List<Employee> list = employeeService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询员工
     */
    @ApiOperation(value = "分页查询员工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "483311859227693056"),
		@ApiImplicitParam(name = EmployeeVOMeta.BADGE, value = "工号", required = false, dataTypeClass = String.class, example = "111"),
		@ApiImplicitParam(name = EmployeeVOMeta.PHONE, value = "手机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.PERSON_ID, value = "人员ID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.COMPANY_ID, value = "公司ID", required = false, dataTypeClass = String.class, example = "482962368444239872"),
		@ApiImplicitParam(name = EmployeeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = EmployeeVOMeta.DIRECT_LEADER_ID, value = "直属领导ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = EmployeeServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(EmployeeServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Employee>> queryPagedList(EmployeeVO sample) {
        Result<PagedList<Employee>> result = new Result<>();
        PagedList<Employee> list = employeeService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // 关联出 姓名 数据
        employeeService.dao().fill(list).with(EmployeeMeta.PERSON).with(EmployeeMeta.POSITIONS, PositionMeta.ORGANIZATION).with(EmployeeMeta.DIRECT_LEADER,EmployeeMeta.PERSON).execute();
        // 按主岗设置主部门
        for (Employee employee : list) {
            if (employee.getPrimaryPosition() != null) {
                employee.setPrimaryOrganization(employee.getPrimaryPosition().getOrganization());
            }
        }
        result.success(true).data(list);
        return result;
    }
}
