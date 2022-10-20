package org.github.foxnic.web.oauth.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.ApiResponseSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.swagger.Model;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.constants.enums.system.MenuType;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.MenuVO;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.domain.oauth.meta.MenuVOMeta;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.oauth.service.IMenuService;
import org.github.foxnic.web.oauth.service.IRoleMenuService;
import org.github.foxnic.web.proxy.oauth.MenuServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * <p>
 * 菜单表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:29
 * @version
 */
@InDoc
@Api(tags = "认证服务/菜单接口")
@ApiSort(0)
@RestController("SysMenuController")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IRoleMenuService roleMenuService;

    /**
     * 添加菜单
     */
    @ApiOperation(value = "添加菜单")
    @ApiImplicitParams({ @ApiImplicitParam(name = MenuVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "451739184575545344"), @ApiImplicitParam(name = MenuVOMeta.BATCH_ID, value = "批次号", required = false, dataTypeClass = String.class, example = "451739178166648832"), @ApiImplicitParam(name = MenuVOMeta.AUTHORITY, value = "权限", required = false, dataTypeClass = String.class, example = "sys_user::form::view"), @ApiImplicitParam(name = MenuVOMeta.HIDDEN, value = "是否隐藏", required = true, dataTypeClass = Integer.class, example = "1"), @ApiImplicitParam(name = MenuVOMeta.CSS, value = "样式", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "编辑账户"), @ApiImplicitParam(name = MenuVOMeta.TYPE, value = "菜单类型", required = false, dataTypeClass = String.class, example = "page"), @ApiImplicitParam(name = MenuVOMeta.PATH_RESOURCE_ID, value = "菜单路径的资源", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.URL, value = "路由地址", required = false, dataTypeClass = String.class, example = "#!sys_user_edit"), @ApiImplicitParam(name = MenuVOMeta.PARAMS, value = "页面参数", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class, example = "451739184579739648"), @ApiImplicitParam(name = MenuVOMeta.DYNAMIC_HANDLER, value = "动态控制类", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.HIERARCHY, value = "层级路径", required = false, dataTypeClass = String.class, example = "463397133957988352"), @ApiImplicitParam(name = MenuVOMeta.SORT, value = "显示顺序", required = true, dataTypeClass = Integer.class, example = "1") })
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MenuServiceProxy.INSERT)
    @PostMapping(MenuServiceProxy.INSERT)
    public Result insert(MenuVO menuVO) {
        menuVO.setSort(999999);
        if (StringUtil.isBlank(menuVO.getParentId())) {
            menuVO.setParentId(IMenuService.ROOT_ID);
        }
        menuVO.setType(MenuType.folder.code());
        if (StringUtil.isBlank(menuVO.getType())) {
            menuVO.setType(MenuType.page.code());
        }
        menuVO.setLabel(menuVO.getLabel() + "-" + System.currentTimeMillis());
        Result result = menuService.insert(menuVO);
        if (result.success()) {
            result.data(menuVO);
        }
        return result;
    }

    /**
     * 删除菜单
     */
    @ApiOperation(value = "按主键删除菜单")
    @ApiImplicitParams({ @ApiImplicitParam(name = MenuVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "451739184575545344") })
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MenuServiceProxy.DELETE)
    @PostMapping(MenuServiceProxy.DELETE)
    @ApiResponseSupport({ @Model(name = "MenuForDelete", baseModelType = Menu.class, ignoreDBTreatyProperties = true, ignoredProperties = { MenuMeta.PARENT, MenuMeta.RESOURCES, MenuMeta.PATH_RESOURCE }, includeProperties = { MenuMeta.CREATE_TIME }) })
    public Result<Menu> deleteById(String id) {
        Result<Menu> result = new Result<>();
        List children = menuService.queryChildNodes(id, null);
        if (!children.isEmpty()) {
            result.success(false).message("请先删除下级节点");
            return result;
        }
        return menuService.deleteByIdLogical(id);
    }

    /**
     * 批量删除菜单 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除菜单")
    @ApiImplicitParams({ @ApiImplicitParam(name = MenuVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]") })
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MenuServiceProxy.BATCH_DELETE)
    @PostMapping(MenuServiceProxy.BATCH_DELETE)
    public Result deleteByIds(List<String> ids) {
        Result result = menuService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新菜单
     */
    @ApiOperation(value = "更新菜单")
    @ApiImplicitParams({ @ApiImplicitParam(name = MenuVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "451739184575545344"), @ApiImplicitParam(name = MenuVOMeta.BATCH_ID, value = "批次号", required = false, dataTypeClass = String.class, example = "451739178166648832"), @ApiImplicitParam(name = MenuVOMeta.AUTHORITY, value = "权限", required = false, dataTypeClass = String.class, example = "sys_user::form::view"), @ApiImplicitParam(name = MenuVOMeta.HIDDEN, value = "是否隐藏", required = true, dataTypeClass = Integer.class, example = "1"), @ApiImplicitParam(name = MenuVOMeta.CSS, value = "样式", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "编辑账户"), @ApiImplicitParam(name = MenuVOMeta.TYPE, value = "菜单类型", required = false, dataTypeClass = String.class, example = "page"), @ApiImplicitParam(name = MenuVOMeta.PATH_RESOURCE_ID, value = "菜单路径的资源", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.URL, value = "路由地址", required = false, dataTypeClass = String.class, example = "#!sys_user_edit"), @ApiImplicitParam(name = MenuVOMeta.PARAMS, value = "页面参数", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class, example = "451739184579739648"), @ApiImplicitParam(name = MenuVOMeta.DYNAMIC_HANDLER, value = "动态控制类", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.HIERARCHY, value = "层级路径", required = false, dataTypeClass = String.class, example = "463397133957988352"), @ApiImplicitParam(name = MenuVOMeta.SORT, value = "显示顺序", required = true, dataTypeClass = Integer.class, example = "1") })
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, ignoreParameters = { MenuVOMeta.PAGE_INDEX, MenuVOMeta.PAGE_SIZE, MenuVOMeta.SEARCH_FIELD, MenuVOMeta.SEARCH_VALUE, MenuVOMeta.IDS })
    @SentinelResource(value = MenuServiceProxy.UPDATE)
    @PostMapping(MenuServiceProxy.UPDATE)
    public Result update(MenuVO menuVO) {
        Result result = menuService.update(menuVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 保存菜单
     */
    @ApiOperation(value = "保存菜单")
    @ApiImplicitParams({ @ApiImplicitParam(name = MenuVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "451739184575545344"), @ApiImplicitParam(name = MenuVOMeta.BATCH_ID, value = "批次号", required = false, dataTypeClass = String.class, example = "451739178166648832"), @ApiImplicitParam(name = MenuVOMeta.AUTHORITY, value = "权限", required = false, dataTypeClass = String.class, example = "sys_user::form::view"), @ApiImplicitParam(name = MenuVOMeta.HIDDEN, value = "是否隐藏", required = true, dataTypeClass = Integer.class, example = "1"), @ApiImplicitParam(name = MenuVOMeta.CSS, value = "样式", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "编辑账户"), @ApiImplicitParam(name = MenuVOMeta.TYPE, value = "菜单类型", required = false, dataTypeClass = String.class, example = "page"), @ApiImplicitParam(name = MenuVOMeta.PATH_RESOURCE_ID, value = "菜单路径的资源", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.URL, value = "路由地址", required = false, dataTypeClass = String.class, example = "#!sys_user_edit"), @ApiImplicitParam(name = MenuVOMeta.PARAMS, value = "页面参数", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class, example = "451739184579739648"), @ApiImplicitParam(name = MenuVOMeta.DYNAMIC_HANDLER, value = "动态控制类", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.HIERARCHY, value = "层级路径", required = false, dataTypeClass = String.class, example = "463397133957988352"), @ApiImplicitParam(name = MenuVOMeta.SORT, value = "显示顺序", required = true, dataTypeClass = Integer.class, example = "1") })
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { MenuVOMeta.PAGE_INDEX, MenuVOMeta.PAGE_SIZE, MenuVOMeta.SEARCH_FIELD, MenuVOMeta.SEARCH_VALUE, MenuVOMeta.IDS })
    @SentinelResource(value = MenuServiceProxy.SAVE)
    @PostMapping(MenuServiceProxy.SAVE)
    public Result save(MenuVO menuVO) {
        Result result = menuService.save(menuVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 获取菜单
     */
    @ApiOperation(value = "按主键获取菜单")
    @ApiImplicitParams({ @ApiImplicitParam(name = MenuVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "1") })
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MenuServiceProxy.GET_BY_ID)
    @PostMapping(MenuServiceProxy.GET_BY_ID)
    public Result<Menu> getById(String id) {
        Result<Menu> result = new Result<>();
        Menu menu = menuService.getById(id);
        result.success(true).data(menu);
        return result;
    }

    /**
     * 查询菜单
     */
    @ApiOperation(value = "查询菜单列表")
    @ApiImplicitParams({ @ApiImplicitParam(name = MenuVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "451739184575545344"), @ApiImplicitParam(name = MenuVOMeta.BATCH_ID, value = "批次号", required = false, dataTypeClass = String.class, example = "451739178166648832"), @ApiImplicitParam(name = MenuVOMeta.AUTHORITY, value = "权限", required = false, dataTypeClass = String.class, example = "sys_user::form::view"), @ApiImplicitParam(name = MenuVOMeta.HIDDEN, value = "是否隐藏", required = true, dataTypeClass = Integer.class, example = "1"), @ApiImplicitParam(name = MenuVOMeta.CSS, value = "样式", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "编辑账户"), @ApiImplicitParam(name = MenuVOMeta.TYPE, value = "菜单类型", required = false, dataTypeClass = String.class, example = "page"), @ApiImplicitParam(name = MenuVOMeta.PATH_RESOURCE_ID, value = "菜单路径的资源", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.URL, value = "路由地址", required = false, dataTypeClass = String.class, example = "#!sys_user_edit"), @ApiImplicitParam(name = MenuVOMeta.PARAMS, value = "页面参数", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class, example = "451739184579739648"), @ApiImplicitParam(name = MenuVOMeta.DYNAMIC_HANDLER, value = "动态控制类", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.HIERARCHY, value = "层级路径", required = false, dataTypeClass = String.class, example = "463397133957988352"), @ApiImplicitParam(name = MenuVOMeta.SORT, value = "显示顺序", required = true, dataTypeClass = Integer.class, example = "1") })
    @ApiOperationSupport(order = 5, ignoreParameters = { MenuVOMeta.PAGE_INDEX, MenuVOMeta.PAGE_SIZE })
    @SentinelResource(value = MenuServiceProxy.QUERY_LIST)
    @PostMapping(MenuServiceProxy.QUERY_LIST)
    public Result<List<Menu>> queryList(MenuVO sample) {
        Result<List<Menu>> result = new Result<>();
        List<Menu> list = menuService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询菜单节点
     */
    @ApiOperation(value = "查询菜单节点")
    @ApiImplicitParams({ @ApiImplicitParam(name = MenuVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "451739184575545344"), @ApiImplicitParam(name = MenuVOMeta.BATCH_ID, value = "批次号", required = false, dataTypeClass = String.class, example = "451739178166648832"), @ApiImplicitParam(name = MenuVOMeta.AUTHORITY, value = "权限", required = false, dataTypeClass = String.class, example = "sys_user::form::view"), @ApiImplicitParam(name = MenuVOMeta.HIDDEN, value = "是否隐藏", required = true, dataTypeClass = Integer.class, example = "1"), @ApiImplicitParam(name = MenuVOMeta.CSS, value = "样式", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "编辑账户"), @ApiImplicitParam(name = MenuVOMeta.TYPE, value = "菜单类型", required = false, dataTypeClass = String.class, example = "page"), @ApiImplicitParam(name = MenuVOMeta.PATH, value = "模版路径", required = false, dataTypeClass = String.class, example = "/pages/oauth/user/user_form.html"), @ApiImplicitParam(name = MenuVOMeta.URL, value = "路由地址", required = false, dataTypeClass = String.class, example = "#!sys_user_edit"), @ApiImplicitParam(name = MenuVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class, example = "451739184579739648") })
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { MenuVOMeta.PAGE_INDEX, MenuVOMeta.PAGE_SIZE })
    @SentinelResource(value = MenuServiceProxy.QUERY_NODES)
    @PostMapping(MenuServiceProxy.QUERY_NODES)
    public Result<List<ZTreeNode>> queryNodes(MenuVO sample) {
        Result<List<ZTreeNode>> result = new Result<>();
        List<ZTreeNode> list = null;
        if (sample.getParentId() == null) {
            list = menuService.queryRootNotes(sample.getRoleId());
        } else {
            list = menuService.queryChildNodes(sample.getParentId(), sample.getRoleId());
        }
        // 加载全部子孙节点
        if (sample.getIsLoadAllDescendants() != null && sample.getIsLoadAllDescendants() == 1) {
            list = menuService.buildingHierarchicalRelationships(list, sample.getRoleId());
        }
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询菜单
     */
    @ApiOperation(value = "分页查询菜单")
    @ApiImplicitParams({ @ApiImplicitParam(name = MenuVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "451739184575545344"), @ApiImplicitParam(name = MenuVOMeta.BATCH_ID, value = "批次号", required = false, dataTypeClass = String.class, example = "451739178166648832"), @ApiImplicitParam(name = MenuVOMeta.AUTHORITY, value = "权限", required = false, dataTypeClass = String.class, example = "sys_user::form::view"), @ApiImplicitParam(name = MenuVOMeta.HIDDEN, value = "是否隐藏", required = true, dataTypeClass = Integer.class, example = "1"), @ApiImplicitParam(name = MenuVOMeta.CSS, value = "样式", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "编辑账户"), @ApiImplicitParam(name = MenuVOMeta.TYPE, value = "菜单类型", required = false, dataTypeClass = String.class, example = "page"), @ApiImplicitParam(name = MenuVOMeta.PATH_RESOURCE_ID, value = "菜单路径的资源", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.URL, value = "路由地址", required = false, dataTypeClass = String.class, example = "#!sys_user_edit"), @ApiImplicitParam(name = MenuVOMeta.PARAMS, value = "页面参数", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class, example = "451739184579739648"), @ApiImplicitParam(name = MenuVOMeta.DYNAMIC_HANDLER, value = "动态控制类", required = false, dataTypeClass = String.class), @ApiImplicitParam(name = MenuVOMeta.HIERARCHY, value = "层级路径", required = false, dataTypeClass = String.class, example = "463397133957988352"), @ApiImplicitParam(name = MenuVOMeta.SORT, value = "显示顺序", required = true, dataTypeClass = Integer.class, example = "1") })
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MenuServiceProxy.QUERY_PAGED_LIST)
    @PostMapping(MenuServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Menu>> queryPagedList(MenuVO sample) {
        Result<PagedList<Menu>> result = new Result<>();
        PagedList<Menu> list = menuService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 变更菜单层级关系
     */
    @ApiOperation(value = "变更菜单层级关系")
    @ApiImplicitParams({ @ApiImplicitParam(name = MenuVOMeta.IDS, value = "节点ID数组", required = true, dataTypeClass = String.class, example = "['111','222']"), @ApiImplicitParam(name = MenuVOMeta.PARENT_ID, value = "新的上级节点ID", required = true, dataTypeClass = String.class, example = "451739184575545344") })
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MenuServiceProxy.SAVE_HIERARCHY)
    @PostMapping(MenuServiceProxy.SAVE_HIERARCHY)
    @ApiResponseSupport({ @Model(name = "MenuForChangeParent", baseModelType = Menu.class, ignoreDBTreatyProperties = true, ignoredProperties = { MenuMeta.PARENT, MenuMeta.RESOURCES, MenuMeta.PATH_RESOURCE }, includeProperties = { MenuMeta.CREATE_TIME }) })
    public Result<Menu> changeParent(List<String> ids, String parentId) {
        Result<Menu> result = new Result<>();
        Boolean suc = menuService.saveHierarchy(ids, parentId);
        result.success(suc);
        return result;
    }

    /**
     * 搜索分类层级
     */
    @ApiOperation(value = "搜索分类层级")
    @ApiImplicitParams({ @ApiImplicitParam(name = "keyword", value = "keyword", required = true, dataTypeClass = String.class, example = "橡胶") })
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MenuServiceProxy.SEARCH)
    @PostMapping(MenuServiceProxy.SEARCH)
    public Result<List<String>> search(String keyword) {
        Result<List<String>> result = new Result<>();
        List<String> hierarchyList = menuService.search(keyword);
        result.data(hierarchyList);
        return result;
    }
}
