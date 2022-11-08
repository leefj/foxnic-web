package org.github.foxnic.web.system.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONArray;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.json.JSONUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.system.Lang;
import org.github.foxnic.web.domain.system.LangVO;
import org.github.foxnic.web.domain.system.meta.LangMeta;
import org.github.foxnic.web.domain.system.meta.LangVOMeta;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.language.Language;
import org.github.foxnic.web.language.LanguageService;
import org.github.foxnic.web.proxy.system.LangServiceProxy;
import org.github.foxnic.web.system.service.ILangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 语言条目表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-17 11:58:03
 */
@InDoc
@Api(tags = "系统服务/语言条目")
@ApiSort(0)
@RestController("SysLangController")
public class LangController extends SuperController {

    @Autowired
    private ILangService langService;

    /**
     * 添加语言条目
     */
    @ApiOperation(value = "添加语言条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE, value = "编码键", required = true, dataTypeClass = String.class, example = "01-b0ed30300c-7d2e"),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS, value = "默认", required = false, dataTypeClass = String.class, example = "批次号"),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW, value = "中文(台湾)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US, value = "英文美国", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE, value = "混淆专用", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "true"),
		@ApiImplicitParam(name = LangVOMeta.ZH_CN, value = "简体中文", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_GB, value = "英文英国", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_HK, value = "中文(香港)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_MO, value = "中文(澳门)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.KO_KR, value = "韩语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.JA_JP, value = "日语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.CONTEXT, value = "语境", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.AUTO_TRANSLATED, value = "已翻译", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = LangServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LangServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(LangVO langVO) {
        if (langVO.getValid() == null) {
            langVO.setValid(1);
        }
        Result result = langService.insert(langVO);
        return result;
    }

    /**
     * 删除语言条目
     */
    @ApiOperation(value = "删除语言条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE, value = "编码键", required = true, dataTypeClass = String.class, example = "01-b0ed30300c-7d2e")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = LangServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LangServiceProxy.DELETE)
    public Result<Lang> deleteById(String code) {
        Result<Lang> result = new Result<>();
        boolean suc = langService.deleteByIdLogical(code);
        result.success(suc);
        if (!suc)
            result.message("数据删除失败");
        return result;
    }

    /**
     * 批量删除语言条目 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除语言条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODES, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = LangServiceProxy.BATCH_DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LangServiceProxy.BATCH_DELETE)
    public Result deleteByIds(List<String> codes) {
        Result result = langService.deleteByIdsLogical(codes);
        return result;
    }

    /**
     * 更新语言条目
     */
    @ApiOperation(value = "更新语言条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE, value = "编码键", required = true, dataTypeClass = String.class, example = "01-b0ed30300c-7d2e"),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS, value = "默认", required = false, dataTypeClass = String.class, example = "批次号"),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW, value = "中文(台湾)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US, value = "英文美国", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE, value = "混淆专用", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "true"),
		@ApiImplicitParam(name = LangVOMeta.ZH_CN, value = "简体中文", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_GB, value = "英文英国", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_HK, value = "中文(香港)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_MO, value = "中文(澳门)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.KO_KR, value = "韩语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.JA_JP, value = "日语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.CONTEXT, value = "语境", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.AUTO_TRANSLATED, value = "已翻译", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { LangVOMeta.PAGE_INDEX, LangVOMeta.PAGE_SIZE, LangVOMeta.SEARCH_FIELD, LangVOMeta.SEARCH_VALUE, LangVOMeta.SORT_FIELD, LangVOMeta.SORT_TYPE, LangVOMeta.CODES })
    @SentinelResource(value = LangServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LangServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(LangVO langVO) {
        Result result = langService.update(langVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 保存语言条目
     */
    @ApiOperation(value = "保存语言条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE, value = "编码键", required = true, dataTypeClass = String.class, example = "01-b0ed30300c-7d2e"),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS, value = "默认", required = false, dataTypeClass = String.class, example = "批次号"),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW, value = "中文(台湾)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US, value = "英文美国", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE, value = "混淆专用", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "true"),
		@ApiImplicitParam(name = LangVOMeta.ZH_CN, value = "简体中文", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_GB, value = "英文英国", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_HK, value = "中文(香港)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_MO, value = "中文(澳门)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.KO_KR, value = "韩语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.JA_JP, value = "日语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.CONTEXT, value = "语境", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.AUTO_TRANSLATED, value = "已翻译", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { LangVOMeta.PAGE_INDEX, LangVOMeta.PAGE_SIZE, LangVOMeta.SEARCH_FIELD, LangVOMeta.SEARCH_VALUE, LangVOMeta.SORT_FIELD, LangVOMeta.SORT_TYPE, LangVOMeta.CODES })
    @SentinelResource(value = LangServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LangServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(LangVO langVO) {
        Result result = langService.save(langVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 获取语言条目
     */
    @ApiOperation(value = "获取语言条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE, value = "编码键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = LangServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LangServiceProxy.GET_BY_ID)
    public Result<Lang> getById(String code) {
        Result<Lang> result = new Result<>();
        Lang role = langService.getById(code);
        result.success(true).data(role);
        return result;
    }

    /**
     * 查询语言条目
     */
    @ApiOperation(value = "查询语言条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "lang", value = "语言编码", required = true, dataTypeClass = String.class, example = "zh-cn")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { LangVOMeta.PAGE_INDEX, LangVOMeta.PAGE_SIZE })
    @SentinelResource(value = LangServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LangServiceProxy.QUERY_LIST)
    public Result<JSONArray> queryList(LangVO sample) {

        Result<JSONArray> result = new Result<>();
        RequestParameter requestParameter = RequestParameter.get();
        HttpSession session = requestParameter.getSession(false);
        String lang =  sample.getLang();  // requestParameter.getString("lang");
        Language language = Language.parseByCode(lang);
        if (language == null) {
            language = langService.getUserLanguage();
        }
        session.setAttribute(LanguageService.USER_LANGUAGE, language);
        Set<String> fields = new HashSet<>();
        fields.add(FoxnicWeb.SYS_LANG.CODE.name());
        fields.add(FoxnicWeb.SYS_LANG.CONTEXT.name());
        fields.add(Language.defaults.code());
        fields.add(language.code());
        List<Lang> list = langService.queryList(sample, language);
        JSONArray data = JSONUtil.toJSONArray(list);
        Set<String> rms = new HashSet<>();
        rms.addAll(data.getJSONObject(0).keySet());
        // 保留字段
        rms.removeAll(fields);
        rms.remove(BeanNameUtil.instance().getPropertyName(language.code()));
        rms.remove(LangMeta.CONTEXT_PROP.getName());
        for (int i = 0; i < data.size(); i++) {
            for (String s : rms) {
                data.getJSONObject(i).remove(s);
            }
        }
        result.success(true).data(data);
        return result;
    }

    @ApiOperation(value = "切换当前语言")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE, value = "语言编码", required = true, dataTypeClass = String.class, example = "zh-cn")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { LangVOMeta.PAGE_INDEX, LangVOMeta.PAGE_SIZE })
    @SentinelResource(value = LangServiceProxy.SWITCH_LANGUAGE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LangServiceProxy.SWITCH_LANGUAGE)
    public Result switchLanguage(String code) {
        Language language = Language.parseByCode(code);
        if (language == Language.auto) {
            language = langService.getAutoLanguage();
        }
        if (language == null) {
            return ErrorDesc.failureMessage("无法识别语言代码:" + code);
        }
        this.getRequest().getSession().setAttribute(LanguageService.USER_LANGUAGE, language);
        return ErrorDesc.success().data(language.toJSONObject());
    }

    /**
     * 分页查询语言条目
     */
    @ApiOperation(value = "分页查询语言条目")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LangVOMeta.CODE, value = "编码键", required = true, dataTypeClass = String.class, example = "01-b0ed30300c-7d2e"),
		@ApiImplicitParam(name = LangVOMeta.DEFAULTS, value = "默认", required = false, dataTypeClass = String.class, example = "批次号"),
		@ApiImplicitParam(name = LangVOMeta.ZH_TW, value = "中文(台湾)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_US, value = "英文美国", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.CONFUSE, value = "混淆专用", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "true"),
		@ApiImplicitParam(name = LangVOMeta.ZH_CN, value = "简体中文", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.EN_GB, value = "英文英国", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_HK, value = "中文(香港)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.ZH_MO, value = "中文(澳门)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.KO_KR, value = "韩语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.JA_JP, value = "日语", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.CONTEXT, value = "语境", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LangVOMeta.AUTO_TRANSLATED, value = "已翻译", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = LangServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LangServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Lang>> queryPagedList(LangVO sample) {
        Result<PagedList<Lang>> result = new Result<>();
        PagedList<Lang> list = langService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
