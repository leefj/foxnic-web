package org.github.foxnic.web.proxy.pcm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 数据存储表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-28 15:45:05
*/

@FeignClient(value = MicroServiceNames.PCM, contextId = CatalogServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface CatalogServiceProxy {
	
	/**
	 * 基础路径 , service-pcm
	*/
	public static final String API_BASIC_PATH = "service-pcm";
	
	/**
	 * API 上下文路径 , pcm-catalog
	*/
	public static final String API_CONTEXT_PATH = "pcm-catalog";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加数据存储
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除数据存储
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除数据存储
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新数据存储
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存数据存储
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个数据存储
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个数据存储
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询数据存储
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询数据存储
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出数据存储数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载数据存储导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入数据存储数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加数据存储
	*/
	@RequestMapping(CatalogServiceProxy.INSERT)
	Result insert(CatalogVO catalogVO);
	
	/**
	 * 删除数据存储
	*/
	@RequestMapping(CatalogServiceProxy.DELETE)
	Result deleteById(Integer id);

	/**
	 * 批量删除数据存储
	*/
	@RequestMapping(CatalogServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<Integer> ids);

	/**
	 * 更新数据存储
	*/
	@RequestMapping(CatalogServiceProxy.UPDATE)
	Result update(CatalogVO catalogVO);
	
	/**
	 * 更新数据存储
	*/
	@RequestMapping(CatalogServiceProxy.SAVE)
	Result save(CatalogVO catalogVO);
	
	/**
	 * 获取数据存储
	*/
	@RequestMapping(CatalogServiceProxy.GET_BY_ID)
	Result<Catalog> getById(Integer id);

	/**
	 * 批量删除数据存储
	*/
	@RequestMapping(CatalogServiceProxy.GET_BY_IDS)
	Result<List<Catalog>> getByIds(List<Integer> ids);
	/**
	 * 查询数据存储
	*/
	@RequestMapping(CatalogServiceProxy.QUERY_LIST)
	Result<List<Catalog>> queryList(CatalogVO sample);
	
	/**
	 * 分页查询数据存储
	*/
	@RequestMapping(CatalogServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Catalog>> queryPagedList(CatalogVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.pcm.controller.CatalogController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static CatalogServiceProxy api() {
		return APIProxy.get(CatalogServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}