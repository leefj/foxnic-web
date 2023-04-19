package org.github.foxnic.web.proxy.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.example.Address;
import org.github.foxnic.web.domain.example.AddressVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.domain.example.AddressSubModel;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.github.foxnic.web.domain.example.AddressPureModel;
import org.github.foxnic.web.domain.example.AddressModel;
import org.github.foxnic.web.domain.oauth.User;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <p>
 * 订单地址 控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-19 10:15:25
 */
@FeignClient(value = MicroServiceNames.EXAMPLE, contextId = AddressServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AddressServiceProxy {

    /**
     * 基础路径 , service-example
     */
    public static final String API_BASIC_PATH = "service-example";

    /**
     * API 上下文路径 , example-address
     */
    public static final String API_CONTEXT_PATH = "example-address";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加订单地址
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除订单地址
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除订单地址
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新订单地址
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存订单地址
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个订单地址
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个订单地址
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询订单地址
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询订单地址
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出订单地址数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载订单地址导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入订单地址数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * Get-示例
     * <p>方法描述</p>
     */
    public static final String NEW_API_NAME_1 = API_PREFIX + "new-api-name-1";

    /**
     * Post-示例
     * <p>方法描述</p>
     */
    public static final String NEW_API_NAME_2 = API_PREFIX + "new-api-name-2";

    /**
     * 添加订单地址
     */
    @RequestMapping(AddressServiceProxy.INSERT)
    Result insert(@RequestParam(name = "addressVO") AddressVO addressVO);

    /**
     * 删除订单地址
     */
    @RequestMapping(AddressServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除订单地址
     */
    @RequestMapping(AddressServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新订单地址
     */
    @RequestMapping(AddressServiceProxy.UPDATE)
    Result update(@RequestParam(name = "addressVO") AddressVO addressVO);

    /**
     * 更新订单地址
     */
    @RequestMapping(AddressServiceProxy.SAVE)
    Result save(@RequestParam(name = "addressVO") AddressVO addressVO);

    /**
     * 获取订单地址
     */
    @RequestMapping(AddressServiceProxy.GET_BY_ID)
    Result<Address> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个订单地址
     */
    @RequestMapping(AddressServiceProxy.GET_BY_IDS)
    Result<List<Address>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询订单地址
     */
    @RequestMapping(AddressServiceProxy.QUERY_LIST)
    Result<List<Address>> queryList(@RequestParam(name = "sample") AddressVO sample);

    /**
     * 导出 Excel
     */
    @RequestMapping(AddressServiceProxy.EXPORT_EXCEL)
    void exportExcel(@RequestParam(name = "sample") AddressVO sample, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导出 Excel 模板
     */
    @RequestMapping(AddressServiceProxy.EXPORT_EXCEL_TEMPLATE)
    void exportExcelTemplate(@RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导入 Excel
     */
    @RequestMapping(AddressServiceProxy.IMPORT_EXCEL)
    Result importExcel(@RequestParam(name = "request") MultipartHttpServletRequest request, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 分页查询订单地址
     */
    @RequestMapping(AddressServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Address>> queryPagedList(@RequestParam(name = "sample") AddressVO sample);

    /**
     * Get-示例
     * <p>方法描述</p>
     * @param name 姓名 , 所有者的姓名
     * @param memberIds 成员ID集合 , 指定成员的ID清单
     * @param ageMap 年龄表 , 成员年龄表
     * @return  Result&lt;AddressSubModel&gt; 结果
     */
    @RequestMapping(NEW_API_NAME_1)
    Result<AddressSubModel> newApiName1(@RequestParam(name = "name") String name, @RequestParam(name = "memberIds") List<String> memberIds, @RequestParam(name = "ageMap") Map<String, Integer> ageMap);

    /**
     * Post-示例
     * <p>方法描述</p>
     * @param address 地址对象 , 地址基本信息
     * @param model 地址模型 , 地址的扩展信息
     * @param userMap 账户对象Map
     * @return  Result&lt;List&lt;AddressPureModel&gt;&gt; 地址列表
     */
    @RequestMapping(NEW_API_NAME_2)
    Result<List<AddressPureModel>> newApiName2(@RequestParam(name = "address") AddressVO address, @RequestParam(name = "model") List<AddressModel> model, @RequestParam(name = "userMap") Map<String, User> userMap);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.example.controller.AddressController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AddressServiceProxy api() {
        return APIProxy.get(AddressServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
