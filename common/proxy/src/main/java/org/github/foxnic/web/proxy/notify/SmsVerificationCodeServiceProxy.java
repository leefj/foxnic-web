package org.github.foxnic.web.proxy.notify;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.notify.SmsVerificationCode;
import org.github.foxnic.web.domain.notify.SmsVerificationCodeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 短信验证码 控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:31:34
 */
@FeignClient(value = MicroServiceNames.NOTIFY, contextId = SmsVerificationCodeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SmsVerificationCodeServiceProxy {

    /**
     * 基础路径 , service-notify
     */
    public static final String API_BASIC_PATH = "service-notify";

    /**
     * API 上下文路径 , sys-sms-verification-code
     */
    public static final String API_CONTEXT_PATH = "sys-sms-verification-code";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加短信验证码
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除短信验证码
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除短信验证码
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新短信验证码
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存短信验证码
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个短信验证码
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个短信验证码
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询短信验证码
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询短信验证码
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加短信验证码
     */
    @RequestMapping(SmsVerificationCodeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "smsVerificationCodeVO") SmsVerificationCodeVO smsVerificationCodeVO);

    /**
     * 删除短信验证码
     */
    @RequestMapping(SmsVerificationCodeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除短信验证码
     */
    @RequestMapping(SmsVerificationCodeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新短信验证码
     */
    @RequestMapping(SmsVerificationCodeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "smsVerificationCodeVO") SmsVerificationCodeVO smsVerificationCodeVO);

    /**
     * 更新短信验证码
     */
    @RequestMapping(SmsVerificationCodeServiceProxy.SAVE)
    Result save(@RequestParam(name = "smsVerificationCodeVO") SmsVerificationCodeVO smsVerificationCodeVO);

    /**
     * 获取短信验证码
     */
    @RequestMapping(SmsVerificationCodeServiceProxy.GET_BY_ID)
    Result<SmsVerificationCode> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个短信验证码
     */
    @RequestMapping(SmsVerificationCodeServiceProxy.GET_BY_IDS)
    Result<List<SmsVerificationCode>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询短信验证码
     */
    @RequestMapping(SmsVerificationCodeServiceProxy.QUERY_LIST)
    Result<List<SmsVerificationCode>> queryList(@RequestParam(name = "sample") SmsVerificationCodeVO sample);

    /**
     * 分页查询短信验证码
     */
    @RequestMapping(SmsVerificationCodeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SmsVerificationCode>> queryPagedList(@RequestParam(name = "sample") SmsVerificationCodeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.notify.controller.SmsVerificationCodeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SmsVerificationCodeServiceProxy api() {
        return APIProxy.get(SmsVerificationCodeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
