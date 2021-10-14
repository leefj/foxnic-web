package org.github.foxnic.web.proxy.dataperm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.dataperm.ExampleShop;
import org.github.foxnic.web.domain.dataperm.ExampleShopVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 销售门店表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-14 16:24:46
*/

@FeignClient(value = MicroServiceNames.DATA_PERM, contextId = ExampleShopServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ExampleShopServiceProxy {

	/**
	 * 基础路径 , service-dataperm
	*/
	public static final String API_BASIC_PATH = "service-dataperm";

	/**
	 * API 上下文路径 , dp-example-shop
	*/
	public static final String API_CONTEXT_PATH = "dp-example-shop";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加销售门店
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除销售门店
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除销售门店
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新销售门店
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存销售门店
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个销售门店
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个销售门店
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询销售门店
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询销售门店
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出销售门店数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载销售门店导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入销售门店数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加销售门店
	*/
	@RequestMapping(ExampleShopServiceProxy.INSERT)
	Result insert(ExampleShopVO exampleShopVO);

	/**
	 * 删除销售门店
	*/
	@RequestMapping(ExampleShopServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除销售门店
	*/
	@RequestMapping(ExampleShopServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新销售门店
	*/
	@RequestMapping(ExampleShopServiceProxy.UPDATE)
	Result update(ExampleShopVO exampleShopVO);

	/**
	 * 更新销售门店
	*/
	@RequestMapping(ExampleShopServiceProxy.SAVE)
	Result save(ExampleShopVO exampleShopVO);

	/**
	 * 获取销售门店
	*/
	@RequestMapping(ExampleShopServiceProxy.GET_BY_ID)
	Result<ExampleShop> getById(String id);

	/**
	 * 批量删除销售门店
	*/
	@RequestMapping(ExampleShopServiceProxy.GET_BY_IDS)
	Result<List<ExampleShop>> getByIds(List<String> ids);
	/**
	 * 查询销售门店
	*/
	@RequestMapping(ExampleShopServiceProxy.QUERY_LIST)
	Result<List<ExampleShop>> queryList(ExampleShopVO sample);

	/**
	 * 分页查询销售门店
	*/
	@RequestMapping(ExampleShopServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<ExampleShop>> queryPagedList(ExampleShopVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.dataperm.controller.ExampleShopController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ExampleShopServiceProxy api() {
		return APIProxy.get(ExampleShopServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}