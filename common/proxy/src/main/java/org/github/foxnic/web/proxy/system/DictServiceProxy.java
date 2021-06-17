package org.github.foxnic.web.proxy.system;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.system.Dict;
import org.github.foxnic.web.domain.system.DictVO;
import com.github.foxnic.springboot.api.proxy.APIProxy;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 数据字典  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-17 16:41:53
*/

@FeignClient(value = MicroServiceNames.SYSTEM, contextId = DictServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface DictServiceProxy {
	
	/**
	 * 基础路径 , service-system
	*/
	public static final String API_BASIC_PATH = "service-system";
	
	/**
	 * API 上下文路径 , sys-dict
	*/
	public static final String API_CONTEXT_PATH = "sys-dict";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加数据字典
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除数据字典
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 批量删除数据字典
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新数据字典
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存数据字典
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取数据字典
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询数据字典
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询数据字典
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出数据字典数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载数据字典导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入数据字典数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加数据字典
	*/
	@RequestMapping(DictServiceProxy.INSERT)
	Result<Dict> insert(DictVO dictVO);
	
	/**
	 * 删除数据字典
	*/
	@RequestMapping(DictServiceProxy.DELETE)
	Result<Dict> deleteById(String id);
	
	
	/**
	 * 批量删除数据字典
	*/
	@RequestMapping(DictServiceProxy.BATCH_DELETE)
	Result<Dict> deleteByIds(List<String> id);
	
	/**
	 * 更新数据字典
	*/
	@RequestMapping(DictServiceProxy.UPDATE)
	Result<Dict> update(DictVO dictVO);
	
	/**
	 * 更新数据字典
	*/
	@RequestMapping(DictServiceProxy.SAVE)
	Result<Dict> save(DictVO dictVO);
	
	/**
	 * 获取数据字典
	*/
	@RequestMapping(DictServiceProxy.GET_BY_ID)
	Result<Dict> getById(String id);
	
	/**
	 * 查询数据字典
	*/
	@RequestMapping(DictServiceProxy.QUERY_LIST)
	Result<List<Dict>> queryList(DictVO sample);
	
	/**
	 * 分页查询数据字典
	*/
	@RequestMapping(DictServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Dict>> queryPagedList(DictVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.system.controller.DictController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static DictServiceProxy api() {
		return APIProxy.get(DictServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}