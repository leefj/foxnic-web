package org.github.foxnic.web.system.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.system.SystemConfigType;
import org.github.foxnic.web.domain.oauth.meta.MenuVOMeta;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.domain.system.ConfigVO;
import org.github.foxnic.web.domain.system.meta.ConfigVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;
import org.github.foxnic.web.system.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 系统配置表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-03 09:07:26
 * @version
 */
@InDoc
@Api(tags = "系统服务/系统配置")
@ApiSort(0)
@RestController("SysConfigController")
public class ConfigController extends SuperController implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private IConfigService configService;

    /**
     * 添加系统配置
     */
    @ApiOperation(value = "添加系统配置")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE, value = "配置键", required = true, dataTypeClass = String.class, example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME, value = "配置名", required = false, dataTypeClass = String.class, example = "资产页面直接更新"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE, value = "数据类型", required = false, dataTypeClass = String.class, example = "ENUM"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC, value = "类型描述", required = false, dataTypeClass = String.class, example = "org.github.foxnic.web.constants.enums.system.YesNo"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE, value = "配置值", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID, value = "是否生效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ConfigVOMeta.PROFILE_ID, value = "Profile", required = true, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = ConfigVOMeta.CATALOG_CODE, value = "分类代码", required = false, dataTypeClass = String.class, example = "system"),
		@ApiImplicitParam(name = ConfigVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ConfigServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ConfigServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ConfigVO configVO) {

        if (StringUtil.isBlank(configVO.getParentId())) {
            configVO.setParentId(IConfigService.TOP_CODE);
        }
        if (StringUtil.isBlank(configVO.getType())) {
            configVO.setType(SystemConfigType.STRING.code());
        }
        Config parent=configService.getById(configVO.getParentId());

        if(StringUtil.isBlank(configVO.getCode())) {
            if (parent.getCode().equals(IConfigService.TOP_CODE)) {
                configVO.setCode("C" + System.currentTimeMillis());
            } else {
                configVO.setCode(parent.getCode() + ".C" + System.currentTimeMillis());
            }
        }

        Result result = configService.insert(configVO, false);
        return result;
    }

    /**
     * 删除系统配置
     */
    @ApiOperation(value = "删除系统配置")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "eam.assetDirectUpdateMode")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ConfigServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ConfigServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = configService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除系统配置 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除系统配置")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ConfigServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ConfigServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = configService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新系统配置
     */
    @ApiOperation(value = "更新系统配置")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE, value = "配置键", required = true, dataTypeClass = String.class, example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME, value = "配置名", required = false, dataTypeClass = String.class, example = "资产页面直接更新"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE, value = "数据类型", required = false, dataTypeClass = String.class, example = "ENUM"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC, value = "类型描述", required = false, dataTypeClass = String.class, example = "org.github.foxnic.web.constants.enums.system.YesNo"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE, value = "配置值", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID, value = "是否生效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ConfigVOMeta.PROFILE_ID, value = "Profile", required = true, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = ConfigVOMeta.CATALOG_CODE, value = "分类代码", required = false, dataTypeClass = String.class, example = "system"),
		@ApiImplicitParam(name = ConfigVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ConfigVOMeta.PAGE_INDEX, ConfigVOMeta.PAGE_SIZE, ConfigVOMeta.SEARCH_FIELD, ConfigVOMeta.FUZZY_FIELD, ConfigVOMeta.SEARCH_VALUE, ConfigVOMeta.DIRTY_FIELDS, ConfigVOMeta.SORT_FIELD, ConfigVOMeta.SORT_TYPE, ConfigVOMeta.IDS })
    @SentinelResource(value = ConfigServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ConfigServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ConfigVO configVO) {
        Result result = configService.update(configVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存系统配置
     */
    @ApiOperation(value = "保存系统配置")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE, value = "配置键", required = true, dataTypeClass = String.class, example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME, value = "配置名", required = false, dataTypeClass = String.class, example = "资产页面直接更新"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE, value = "数据类型", required = false, dataTypeClass = String.class, example = "ENUM"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC, value = "类型描述", required = false, dataTypeClass = String.class, example = "org.github.foxnic.web.constants.enums.system.YesNo"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE, value = "配置值", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID, value = "是否生效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ConfigVOMeta.PROFILE_ID, value = "Profile", required = true, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = ConfigVOMeta.CATALOG_CODE, value = "分类代码", required = false, dataTypeClass = String.class, example = "system"),
		@ApiImplicitParam(name = ConfigVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ConfigVOMeta.PAGE_INDEX, ConfigVOMeta.PAGE_SIZE, ConfigVOMeta.SEARCH_FIELD, ConfigVOMeta.FUZZY_FIELD, ConfigVOMeta.SEARCH_VALUE, ConfigVOMeta.DIRTY_FIELDS, ConfigVOMeta.SORT_FIELD, ConfigVOMeta.SORT_TYPE, ConfigVOMeta.IDS })
    @SentinelResource(value = ConfigServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ConfigServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ConfigVO configVO) {
        Result result = configService.save(configVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取系统配置
     */
    @ApiOperation(value = "获取系统配置")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ConfigServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ConfigServiceProxy.GET_BY_ID)
    public Result<Config> getById(String id) {
        Result<Config> result = new Result<>();
        Config config = configService.getById(id);
        result.success(true).data(config);
        return result;
    }

    /**
     * 获取系统配置
     */
    @ApiOperation(value = "获取系统配置")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE, value = "代码", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ConfigServiceProxy.GET_BY_CODE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ConfigServiceProxy.GET_BY_CODE)
    public Result<Config> getByCode(String code) {
        Result<Config> result = new Result<>();
        Config config = configService.getByCode(code);
        result.success(true).data(config);
        return result;
    }

    /**
     * 获取系统配置
     */
    @ApiOperation(value = "获取系统配置")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "codes", value = "代码", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ConfigServiceProxy.GET_BY_CODES, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ConfigServiceProxy.GET_BY_CODES)
    public Result<List<Config>> getByCodes(List<String> codes) {
        Result<List<Config>> result = new Result<>();
        List<Config> configs = configService.getByCodes(codes);
        result.success(true).data(configs);
        return result;
    }

    /**
     * 批量获取系统配置 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取系统配置")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ConfigServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ConfigServiceProxy.GET_BY_IDS)
    public Result<List<Config>> getByIds(List<String> ids) {
        Result<List<Config>> result = new Result<>();
        List<Config> list = configService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询系统配置
     */
    @ApiOperation(value = "查询系统配置")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE, value = "配置键", required = true, dataTypeClass = String.class, example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME, value = "配置名", required = false, dataTypeClass = String.class, example = "资产页面直接更新"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE, value = "数据类型", required = false, dataTypeClass = String.class, example = "ENUM"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC, value = "类型描述", required = false, dataTypeClass = String.class, example = "org.github.foxnic.web.constants.enums.system.YesNo"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE, value = "配置值", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID, value = "是否生效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ConfigVOMeta.PROFILE_ID, value = "Profile", required = true, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = ConfigVOMeta.CATALOG_CODE, value = "分类代码", required = false, dataTypeClass = String.class, example = "system"),
		@ApiImplicitParam(name = ConfigVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ConfigVOMeta.PAGE_INDEX, ConfigVOMeta.PAGE_SIZE })
    @SentinelResource(value = ConfigServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ConfigServiceProxy.QUERY_LIST)
    public Result<List<Config>> queryList(ConfigVO sample) {
        Result<List<Config>> result = new Result<>();
        List<Config> list = configService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询系统配置
     */
    @ApiOperation(value = "查询某个Key下的所有子项")
    @ApiImplicitParams({
            @ApiImplicitParam(name = ConfigVOMeta.CODE, value = "配置键", required = true, dataTypeClass = String.class, example = "eam.assetDirectUpdateMode"),
    })
    @ApiOperationSupport(order = 5, ignoreParameters = { ConfigVOMeta.PAGE_INDEX, ConfigVOMeta.PAGE_SIZE })
    @SentinelResource(value = ConfigServiceProxy.QUERY_DESCENDANTS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ConfigServiceProxy.QUERY_DESCENDANTS)
    public Result<List<Config>> queryDescendants(String code) {
        Result<List<Config>> result = new Result<>();
        List<Config> list = configService.queryDescendants(code);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询系统配置
     */
    @ApiOperation(value = "分页查询系统配置")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ConfigVOMeta.CODE, value = "配置键", required = true, dataTypeClass = String.class, example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.NAME, value = "配置名", required = false, dataTypeClass = String.class, example = "资产页面直接更新"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE, value = "数据类型", required = false, dataTypeClass = String.class, example = "ENUM"),
		@ApiImplicitParam(name = ConfigVOMeta.TYPE_DESC, value = "类型描述", required = false, dataTypeClass = String.class, example = "org.github.foxnic.web.constants.enums.system.YesNo"),
		@ApiImplicitParam(name = ConfigVOMeta.VALUE, value = "配置值", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.VALID, value = "是否生效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = ConfigVOMeta.NOTES, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ConfigVOMeta.PROFILE_ID, value = "Profile", required = true, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = ConfigVOMeta.CATALOG_CODE, value = "分类代码", required = false, dataTypeClass = String.class, example = "system"),
		@ApiImplicitParam(name = ConfigVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "eam.assetDirectUpdateMode"),
		@ApiImplicitParam(name = ConfigVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ConfigServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ConfigServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Config>> queryPagedList(ConfigVO sample) {
        Result<PagedList<Config>> result = new Result<>();
        PagedList<Config> list = configService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询菜单节点
     */
    @ApiOperation(value = "查询配置节点")
    @ApiImplicitParams({
        @ApiImplicitParam(name = ConfigVOMeta.PROFILE_ID, value = "PROFILE_ID", required = true, dataTypeClass = String.class, example = "451739184575545344"),
        @ApiImplicitParam(name = ConfigVOMeta.PARENT_ID, value = "上级ID", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { MenuVOMeta.PAGE_INDEX, MenuVOMeta.PAGE_SIZE })
    @SentinelResource(value = ConfigServiceProxy.QUERY_NODES)
    @PostMapping(ConfigServiceProxy.QUERY_NODES)
    public Result<List<ZTreeNode>> queryNodes(ConfigVO sample) {
        Result<List<ZTreeNode>> result = new Result<>();
        List<ZTreeNode> list = null;
        configService.makeDirsIf();
        if (sample.getParentId() == null) {
             list = configService.queryRootNotes(sample.getProfileId());
        } else {
             list = configService.queryChildNodes(sample.getProfileId(),sample.getParentId());
        }
        result.success(true).data(list);
        return result;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        Config sample = new Config();
        sample.setCode(SystemConfigEnum.SYSTEM_VERSION_CACHEKEY.code());
        List<Config> list = configService.queryList(sample);
        String cacheKey = DateUtil.format(new Date(), "yyyyMMddHHmmss");
        for (Config config : list) {
            config.setValue(cacheKey);
            configService.dao().updateEntity(config, SaveMode.DIRTY_FIELDS);
        }
    }

    /**
     * 搜索分类层级
     */
    @ApiOperation(value = "搜索分类层级")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "keyword", required = true, dataTypeClass = String.class, example = "橡胶"),
            @ApiImplicitParam(name = "profileId", value = "profileId", required = true, dataTypeClass = String.class, example = "default")
    })
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ConfigServiceProxy.SEARCH)
    @PostMapping(ConfigServiceProxy.SEARCH)
    public Result<List<String>> search(String profileId, String keyword) {
        Result<List<String>> result = new Result<>();
        List<String> hierarchyList = configService.search(profileId,keyword);
        result.data(hierarchyList);
        return result;
    }

}
