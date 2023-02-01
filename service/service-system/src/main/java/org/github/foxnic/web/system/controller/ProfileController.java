package org.github.foxnic.web.system.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.ErrorDesc;
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
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.domain.system.Profile;
import org.github.foxnic.web.domain.system.ProfileVO;
import org.github.foxnic.web.domain.system.meta.ProfileVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.system.ProfileServiceProxy;
import org.github.foxnic.web.system.service.IConfigService;
import org.github.foxnic.web.system.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 *  接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-03 13:54:38
 * @version
 */
@InDoc
@Api(tags = "系统服务/系统参数")
@ApiSort(0)
@RestController("SysProfileController")
public class ProfileController extends SuperController {

    @Autowired
    private IProfileService profileService;

    @Autowired
    private IConfigService configService;

    /**
     * 添加sys_profile
     */
    @ApiOperation(value = "添加sys_profile")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ProfileVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = ProfileVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "默认"),
		@ApiImplicitParam(name = ProfileVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "默认 Profile 请勿删除"),
		@ApiImplicitParam(name = ProfileVOMeta.SORT, value = "显示顺序", required = true, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ProfileServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ProfileServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ProfileVO profileVO) {
        Result result = profileService.insert(profileVO, false);
        return result;
    }

    /**
     * 删除sys_profile
     */
    @ApiOperation(value = "删除sys_profile")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ProfileVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "default")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ProfileServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ProfileServiceProxy.DELETE)
    public Result deleteById(String id) {
        List<Config> list = configService.queryList("profile_id=?", id);
        if (!list.isEmpty()) {
            return ErrorDesc.failure().message("当前 Profile 下包含参数，不允许删除");
        }
        Result result = profileService.deleteByIdPhysical(id);
        return result;
    }

    /**
     * 批量删除sys_profile <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除sys_profile")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ProfileVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ProfileServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ProfileServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        if (ids.equals(IConfigService.DEFAULT_PROFILE_ID)) {
            return ErrorDesc.failure().message("不允许删除默认的 Profile");
        }
        for (String id : ids) {
            List<Config> list = configService.queryList("profile_id=?", id);
            if (!list.isEmpty()) {
                return ErrorDesc.failure().message("Profile 下包含参数，不允许删除");
            }
        }
        Result result = profileService.deleteByIdsPhysical(ids);
        return result;
    }

    /**
     * 更新sys_profile
     */
    @ApiOperation(value = "更新sys_profile")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ProfileVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = ProfileVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "默认"),
		@ApiImplicitParam(name = ProfileVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "默认 Profile 请勿删除"),
		@ApiImplicitParam(name = ProfileVOMeta.SORT, value = "显示顺序", required = true, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ProfileVOMeta.PAGE_INDEX, ProfileVOMeta.PAGE_SIZE, ProfileVOMeta.SEARCH_FIELD, ProfileVOMeta.FUZZY_FIELD, ProfileVOMeta.SEARCH_VALUE, ProfileVOMeta.DIRTY_FIELDS, ProfileVOMeta.SORT_FIELD, ProfileVOMeta.SORT_TYPE, ProfileVOMeta.IDS })
    @SentinelResource(value = ProfileServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ProfileServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ProfileVO profileVO) {
        Result result = profileService.update(profileVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存sys_profile
     */
    @ApiOperation(value = "保存sys_profile")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ProfileVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = ProfileVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "默认"),
		@ApiImplicitParam(name = ProfileVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "默认 Profile 请勿删除"),
		@ApiImplicitParam(name = ProfileVOMeta.SORT, value = "显示顺序", required = true, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ProfileVOMeta.PAGE_INDEX, ProfileVOMeta.PAGE_SIZE, ProfileVOMeta.SEARCH_FIELD, ProfileVOMeta.FUZZY_FIELD, ProfileVOMeta.SEARCH_VALUE, ProfileVOMeta.DIRTY_FIELDS, ProfileVOMeta.SORT_FIELD, ProfileVOMeta.SORT_TYPE, ProfileVOMeta.IDS })
    @SentinelResource(value = ProfileServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ProfileServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ProfileVO profileVO) {
        Result result = profileService.save(profileVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取sys_profile
     */
    @ApiOperation(value = "获取sys_profile")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ProfileVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ProfileServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ProfileServiceProxy.GET_BY_ID)
    public Result<Profile> getById(String id) {
        Result<Profile> result = new Result<>();
        if (IConfigService.DEFAULT_PROFILE_ID.equals(id)) {
            result.message("不允许删除默认的 Profile");
            return result;
        }
        Profile profile = profileService.getById(id);
        result.success(true).data(profile);
        return result;
    }

    /**
     * 批量获取sys_profile <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取sys_profile")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ProfileVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ProfileServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ProfileServiceProxy.GET_BY_IDS)
    public Result<List<Profile>> getByIds(List<String> ids) {
        Result<List<Profile>> result = new Result<>();
        List<Profile> list = profileService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询sys_profile
     */
    @ApiOperation(value = "查询sys_profile")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ProfileVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = ProfileVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "默认"),
		@ApiImplicitParam(name = ProfileVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "默认 Profile 请勿删除"),
		@ApiImplicitParam(name = ProfileVOMeta.SORT, value = "显示顺序", required = true, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ProfileVOMeta.PAGE_INDEX, ProfileVOMeta.PAGE_SIZE })
    @SentinelResource(value = ProfileServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ProfileServiceProxy.QUERY_LIST)
    public Result<List<Profile>> queryList(ProfileVO sample) {
        Result<List<Profile>> result = new Result<>();
        List<Profile> list = profileService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询sys_profile
     */
    @ApiOperation(value = "分页查询sys_profile")
    @ApiImplicitParams({
		@ApiImplicitParam(name = ProfileVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "default"),
		@ApiImplicitParam(name = ProfileVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "默认"),
		@ApiImplicitParam(name = ProfileVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "默认 Profile 请勿删除"),
		@ApiImplicitParam(name = ProfileVOMeta.SORT, value = "显示顺序", required = true, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ProfileServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ProfileServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Profile>> queryPagedList(ProfileVO sample) {
        Result<PagedList<Profile>> result = new Result<>();
        PagedList<Profile> list = profileService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
