package org.github.foxnic.web.proxy.notify;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.notify.SmsTemplate;
import org.github.foxnic.web.domain.notify.SmsTemplateVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 短信模版 控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:54:09
 */
@FeignClient(value = MicroServiceNames.NOTIFY, contextId = SmsTemplateServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SmsTemplateServiceProxy {

    /**
     * 基础路径 , service-notify
     */
    public static final String API_BASIC_PATH = "service-notify";

    /**
     * API 上下文路径 , sys-sms-template
     */
    public static final String API_CONTEXT_PATH = "sys-sms-template";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加短信模版
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除短信模版
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除短信模版
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新短信模版
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存短信模版
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个短信模版
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个短信模版
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询短信模版
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询短信模版
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加短信模版
     */
    @RequestMapping(SmsTemplateServiceProxy.INSERT)
    Result insert(@RequestParam(name = "smsTemplateVO") SmsTemplateVO smsTemplateVO);

    /**
     * 删除短信模版
     */
    @RequestMapping(SmsTemplateServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除短信模版
     */
    @RequestMapping(SmsTemplateServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新短信模版
     */
    @RequestMapping(SmsTemplateServiceProxy.UPDATE)
    Result update(@RequestParam(name = "smsTemplateVO") SmsTemplateVO smsTemplateVO);

    /**
     * 更新短信模版
     */
    @RequestMapping(SmsTemplateServiceProxy.SAVE)
    Result save(@RequestParam(name = "smsTemplateVO") SmsTemplateVO smsTemplateVO);

    /**
     * 获取短信模版
     */
    @RequestMapping(SmsTemplateServiceProxy.GET_BY_ID)
    Result<SmsTemplate> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个短信模版
     */
    @RequestMapping(SmsTemplateServiceProxy.GET_BY_IDS)
    Result<List<SmsTemplate>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询短信模版
     */
    @RequestMapping(SmsTemplateServiceProxy.QUERY_LIST)
    Result<List<SmsTemplate>> queryList(@RequestParam(name = "sample") SmsTemplateVO sample);

    /**
     * 分页查询短信模版
     */
    @RequestMapping(SmsTemplateServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SmsTemplate>> queryPagedList(@RequestParam(name = "sample") SmsTemplateVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.notify.controller.SmsTemplateController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SmsTemplateServiceProxy api() {
        return APIProxy.get(SmsTemplateServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
