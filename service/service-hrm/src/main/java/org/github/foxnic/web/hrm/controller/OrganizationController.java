package org.github.foxnic.web.hrm.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.web.Forbidden;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.hrm.meta.OrganizationVOMeta;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.hrm.service.IOrganizationService;
import org.github.foxnic.web.hrm.service.IPositionService;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 组织层级表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-13 15:09:51
 * @version 20210903
 */
@InDoc
@Api(tags = "人事服务/组织层级")
@ApiSort(0)
@RestController("HrmOrganizationController")
public class OrganizationController extends SuperController {

    @Autowired
    private IOrganizationService organizationService;

    @Autowired
    private IPositionService positionService;

    /**
     * 添加组织层级
     */
    @ApiOperation(value = "添加组织层级")
    @ApiImplicitParams({ @ApiImplicitParam(name = OrganizationVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.SHORT_NAME, value = "简称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.TYPE, value = "组织类型", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.VALID, value = "是否有效", required = false, dataTypeClass = Integer.class), @ApiImplicitParam(name = OrganizationVOMeta.HIERARCHY, value = "层级路径", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.COMPANY_ID, value = "总公司ID", required = false, dataTypeClass = String.class) })
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = OrganizationServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OrganizationServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(OrganizationVO organizationVO) {
        Result result = organizationService.insert(organizationVO);
        if (result.success()) {
            result.data(organizationVO);
        }
        return result;
    }

    /**
     * 删除组织层级
     */
    @ApiOperation(value = "删除组织层级")
    @ApiImplicitParams({ @ApiImplicitParam(name = OrganizationVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class) })
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = OrganizationServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OrganizationServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = new Result();
        Organization organization = organizationService.getById(id);
        List<Organization> children = organizationService.queryList(Organization.create().setParentId(organization.getId()));
        if (!children.isEmpty()) {
            result.success(false).message("请先删除子节点");
            return result;
        }
        List<Position> positions = positionService.queryPositions(organization.getId());
        if (!positions.isEmpty()) {
            result.success(false).message("请先删除子节点");
            return result;
        }
        result = organizationService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除组织层级 <br>
     * 联合主键时，请自行调整实现
     */
    @Forbidden
    @ApiOperation(value = "批量删除组织层级")
    @ApiImplicitParams({ @ApiImplicitParam(name = OrganizationVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]") })
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = OrganizationServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OrganizationServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = organizationService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新组织层级
     */
    @ApiOperation(value = "更新组织层级")
    @ApiImplicitParams({ @ApiImplicitParam(name = OrganizationVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.SHORT_NAME, value = "简称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.TYPE, value = "组织类型", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.VALID, value = "是否有效", required = false, dataTypeClass = Integer.class), @ApiImplicitParam(name = OrganizationVOMeta.HIERARCHY, value = "层级路径", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.COMPANY_ID, value = "总公司ID", required = false, dataTypeClass = String.class) })
    @ApiOperationSupport(order = 4, ignoreParameters = { OrganizationVOMeta.PAGE_INDEX, OrganizationVOMeta.PAGE_SIZE, OrganizationVOMeta.SEARCH_FIELD, OrganizationVOMeta.FUZZY_FIELD, OrganizationVOMeta.SEARCH_VALUE, OrganizationVOMeta.SORT_FIELD, OrganizationVOMeta.SORT_TYPE, OrganizationVOMeta.IDS })
    @SentinelResource(value = OrganizationServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OrganizationServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(OrganizationVO organizationVO) {
        Result result = organizationService.update(organizationVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 保存组织层级
     */
    @ApiOperation(value = "保存组织层级")
    @ApiImplicitParams({ @ApiImplicitParam(name = OrganizationVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.SHORT_NAME, value = "简称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.TYPE, value = "组织类型", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.VALID, value = "是否有效", required = false, dataTypeClass = Integer.class), @ApiImplicitParam(name = OrganizationVOMeta.HIERARCHY, value = "层级路径", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.COMPANY_ID, value = "总公司ID", required = false, dataTypeClass = String.class) })
    @ApiOperationSupport(order = 5, ignoreParameters = { OrganizationVOMeta.PAGE_INDEX, OrganizationVOMeta.PAGE_SIZE, OrganizationVOMeta.SEARCH_FIELD, OrganizationVOMeta.FUZZY_FIELD, OrganizationVOMeta.SEARCH_VALUE, OrganizationVOMeta.SORT_FIELD, OrganizationVOMeta.SORT_TYPE, OrganizationVOMeta.IDS })
    @SentinelResource(value = OrganizationServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OrganizationServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(OrganizationVO organizationVO) {
        Result result = organizationService.save(organizationVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 获取组织层级
     */
    @ApiOperation(value = "获取组织层级")
    @ApiImplicitParams({ @ApiImplicitParam(name = OrganizationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1") })
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = OrganizationServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OrganizationServiceProxy.GET_BY_ID)
    public Result<Organization> getById(String id) {
        Result<Organization> result = new Result<>();
        Organization organization = organizationService.getById(id);
        result.success(true).data(organization);
        return result;
    }

    /**
     * 批量删除组织层级 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除组织层级")
    @ApiImplicitParams({ @ApiImplicitParam(name = OrganizationVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]") })
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = OrganizationServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OrganizationServiceProxy.GET_BY_IDS)
    public Result<List<Organization>> getByIds(List<String> ids) {
        Result<List<Organization>> result = new Result<>();
        List<Organization> list = organizationService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询组织层级
     */
    @ApiOperation(value = "查询组织层级")
    @ApiImplicitParams({ @ApiImplicitParam(name = OrganizationVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.SHORT_NAME, value = "简称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.TYPE, value = "组织类型", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.VALID, value = "是否有效", required = false, dataTypeClass = Integer.class), @ApiImplicitParam(name = OrganizationVOMeta.HIERARCHY, value = "层级路径", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.COMPANY_ID, value = "总公司ID", required = false, dataTypeClass = String.class) })
    @ApiOperationSupport(order = 5, ignoreParameters = { OrganizationVOMeta.PAGE_INDEX, OrganizationVOMeta.PAGE_SIZE })
    @SentinelResource(value = OrganizationServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OrganizationServiceProxy.QUERY_LIST)
    public Result<List<Organization>> queryList(OrganizationVO sample) {
        Result<List<Organization>> result = new Result<>();
        List<Organization> list = organizationService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询组织层级
     */
    @ApiOperation(value = "分页查询组织层级")
    @ApiImplicitParams({ @ApiImplicitParam(name = OrganizationVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.SHORT_NAME, value = "简称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.TYPE, value = "组织类型", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.VALID, value = "是否有效", required = false, dataTypeClass = Integer.class), @ApiImplicitParam(name = OrganizationVOMeta.HIERARCHY, value = "层级路径", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = OrganizationVOMeta.COMPANY_ID, value = "总公司ID", required = false, dataTypeClass = String.class) })
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = OrganizationServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OrganizationServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Organization>> queryPagedList(OrganizationVO sample) {
        Result<PagedList<Organization>> result = new Result<>();
        PagedList<Organization> list = organizationService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询组织节点(展平)
     */
    @ApiOperation(value = "查询组织节点(展平)")
    @ApiOperationSupport(order = 5, ignoreParameters = { OrganizationVOMeta.PAGE_INDEX, OrganizationVOMeta.PAGE_SIZE })
    @SentinelResource(value = OrganizationServiceProxy.QUERY_NODES_FLATTEN, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OrganizationServiceProxy.QUERY_NODES_FLATTEN)
    public Result<List<ZTreeNode>> queryNodesFlatten(OrganizationVO sample) {
        Result<List<ZTreeNode>> result = new Result<>();
        List<ZTreeNode> list = organizationService.queryNodesFlatten(sample);
        result.data(list);
        result.success(true);
        return result;
    }

    /**
     * 查询组织节点(带层级)
     */
    @ApiOperation(value = "查询组织节点(带层级)")
    @ApiImplicitParams({ @ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = Integer.class) })
    @ApiOperationSupport(order = 5, ignoreParameters = { OrganizationVOMeta.PAGE_INDEX, OrganizationVOMeta.PAGE_SIZE })
    @SentinelResource(value = OrganizationServiceProxy.QUERY_NODES, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OrganizationServiceProxy.QUERY_NODES)
    public Result<List<ZTreeNode>> queryNodes(OrganizationVO sample) {
        Result<List<ZTreeNode>> result = new Result<>();
        List<ZTreeNode> list = null;
        if (sample.getParentId() == null) {
            list = organizationService.queryRootNotes(sample.getRoot(), sample.getTargetType());
        } else {
            list = organizationService.queryChildNodes(sample.getParentId(), sample.getTargetType());
        }
        // 加载全部子孙节点
        if (sample.getIsLoadAllDescendants() != null && sample.getIsLoadAllDescendants() == 1) {
            list = organizationService.buildingHierarchicalRelationships(list, sample.getTargetType());
        }
        result.success(true).data(list);
        return result;
    }

    /**
     * 搜索分类层级
     */
    @ApiOperation(value = "搜索分类层级")
    @ApiImplicitParams({ @ApiImplicitParam(name = "keyword", value = "keyword", required = true, dataTypeClass = String.class, example = "橡胶") })
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = OrganizationServiceProxy.SEARCH)
    @PostMapping(OrganizationServiceProxy.SEARCH)
    public Result<List<String>> search(String keyword) {
        Result<List<String>> result = new Result<>();
        List<String> hierarchyList = organizationService.search(keyword);
        result.data(hierarchyList);
        return result;
    }

    /**
     * 变更分类层级关系
     */
    @ApiOperation(value = "变更分类层级关系")
    @ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ID", required = true, dataTypeClass = String.class, example = "451739184575545344"), @ApiImplicitParam(name = OrganizationVOMeta.PARENT_ID, value = "新的上级节点ID", required = true, dataTypeClass = String.class, example = "451739184575545344") })
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = OrganizationServiceProxy.SAVE_HIERARCHY)
    @PostMapping(OrganizationServiceProxy.SAVE_HIERARCHY)
    public Result<Catalog> changeParent(List<String> ids, String parentId) {
        Result<Catalog> result = new Result<>();
        Boolean suc = organizationService.saveHierarchy(ids, parentId);
        result.success(suc);
        return result;
    }

}
