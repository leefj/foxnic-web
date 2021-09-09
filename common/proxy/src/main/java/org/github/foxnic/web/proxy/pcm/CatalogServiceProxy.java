package org.github.foxnic.web.proxy.pcm;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogData;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import org.github.foxnic.web.domain.pcm.DataQueryVo;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 数据存储表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-28 15:45:05
 * @version 20210830
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

	/**
	 * 查询数据存储
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";


	/**
	 * 查询数据存储
	 */
	public static final String QUERY_NODES = API_PREFIX + "query-nodes";

	/**
	 * 保存层级关系
	 */
	public static final String SAVE_HIERARCHY = API_PREFIX + "save-hierarchy";

	/**
	 * 查询
	 */
	public static final String SEARCH = API_PREFIX + "search";


	/**
	 * 查询数据表
	 */
	public static final String STORAGE_TABLES = API_PREFIX + "storage-tables";

	/**
	 * 查询版本
	 */
	public static final String VERSIONS = API_PREFIX + "versions";

	/**
	 * 创建一个编辑版本
	 */
	public static final String CREATE_VERSION = API_PREFIX + "create-version";

	/**
	 * 生效一个编辑中的版本
	 */
	public static final String APPLY_VERSION = API_PREFIX + "apply-version";

	/**
	 * 查询类目下的数据
	 */
	public static final String QUERY_DATA = API_PREFIX + "query-data";

	/**
	 * 保存类目下的数据
	 */
	public static final String SAVE_DATA = API_PREFIX + "save-data";

	/**
	 * 删除类目下的数据
	 */
	public static final String DELETE_DATA = API_PREFIX + "delete-data";

	/**
	 * 保存类目下的数据
	 */
	public static final String SAVE_DATA_LIST = API_PREFIX + "save-data-list";
	
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
	 * 查询节点
	 * */
	@PostMapping(CatalogServiceProxy.QUERY_NODES)
	Result<List<ZTreeNode>> queryNodes(CatalogVO sample);
	/**
	 * 返回数据表清单
	 */
	@PostMapping(CatalogServiceProxy.STORAGE_TABLES)
	Result<List<String>> storageTables();


	/**
	 * 删除分类数据
	 */
	@PostMapping(CatalogServiceProxy.DELETE_DATA)
	Result deleteData(DataQueryVo dataQueryVo);

	/**
	 * 保存单个分类数据
	 */
	@PostMapping(CatalogServiceProxy.SAVE_DATA)
	Result saveData(CatalogData catalogData);


	/**
	 * 保存多个分类数据
	 */
	@PostMapping(CatalogServiceProxy.SAVE_DATA_LIST)
	Result saveDataList(List<CatalogData> catalogDataList);

	/**
	 * 查询分类数据
	 */
	@PostMapping(CatalogServiceProxy.QUERY_DATA)
	Result queryData(DataQueryVo dataQueryVo);

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