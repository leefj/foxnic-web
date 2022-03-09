package org.github.foxnic.web.proxy.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.example.News;
import org.github.foxnic.web.domain.example.NewsVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 示例新闻  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-03-09 16:03:20
*/

@FeignClient(value = MicroServiceNames.EXAMPLE, contextId = NewsServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface NewsServiceProxy {

	/**
	 * 基础路径 , service-example
	*/
	public static final String API_BASIC_PATH = "service-example";

	/**
	 * API 上下文路径 , example-news
	*/
	public static final String API_CONTEXT_PATH = "example-news";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加示例新闻
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除示例新闻
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除示例新闻
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新示例新闻
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存示例新闻
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个示例新闻
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个示例新闻
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询示例新闻
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询示例新闻
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出示例新闻数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载示例新闻导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入示例新闻数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加示例新闻
	*/
	@RequestMapping(NewsServiceProxy.INSERT)
	Result insert(NewsVO newsVO);

	/**
	 * 删除示例新闻
	*/
	@RequestMapping(NewsServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除示例新闻
	*/
	@RequestMapping(NewsServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新示例新闻
	*/
	@RequestMapping(NewsServiceProxy.UPDATE)
	Result update(NewsVO newsVO);

	/**
	 * 更新示例新闻
	*/
	@RequestMapping(NewsServiceProxy.SAVE)
	Result save(NewsVO newsVO);

	/**
	 * 获取示例新闻
	*/
	@RequestMapping(NewsServiceProxy.GET_BY_ID)
	Result<News> getById(String id);

	/**
	 * 获取多个示例新闻
	*/
	@RequestMapping(NewsServiceProxy.GET_BY_IDS)
	Result<List<News>> getByIds(List<String> ids);
	/**
	 * 查询示例新闻
	*/
	@RequestMapping(NewsServiceProxy.QUERY_LIST)
	Result<List<News>> queryList(NewsVO sample);

	/**
	 * 分页查询示例新闻
	*/
	@RequestMapping(NewsServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<News>> queryPagedList(NewsVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.example.controller.NewsController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static NewsServiceProxy api() {
		return APIProxy.get(NewsServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}