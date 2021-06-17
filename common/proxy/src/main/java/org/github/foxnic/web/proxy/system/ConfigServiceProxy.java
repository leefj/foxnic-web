package org.github.foxnic.web.proxy.system;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.domain.system.ConfigVO;
import com.github.foxnic.springboot.api.proxy.APIProxy;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 系统配置表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-24 01:19:36
*/

@FeignClient(value = MicroServiceNames.SYSTEM, contextId = ConfigServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ConfigServiceProxy {
	
	/**
	 * 基础路径 , service-system
	*/
	public static final String API_BASIC_PATH = "service-system";
	
	/**
	 * API 上下文路径 , sys-config
	*/
	public static final String API_CONTEXT_PATH = "sys-config";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加系统配置
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除系统配置
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 按主键删除系统配置
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新系统配置
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存系统配置
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 按主键获取系统配置
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的系统配置
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的系统配置
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出Excel
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";


	/**
	 * 导出Excel
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入Excel
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加系统配置
	*/
	@RequestMapping(ConfigServiceProxy.INSERT)
	Result<Config> insert(ConfigVO configVO);
	
	/**
	 * 按主键删除系统配置
	*/
	@RequestMapping(ConfigServiceProxy.DELETE)
	Result<Config> deleteById(String code);
	
	
	/**
	 * 按主键删除系统配置
	*/
	@RequestMapping(ConfigServiceProxy.BATCH_DELETE)
	Result<Config> deleteByIds(List<String> id);
	
	/**
	 * 更新系统配置
	*/
	@RequestMapping(ConfigServiceProxy.UPDATE)
	Result<Config> update(ConfigVO configVO);
	
	/**
	 * 更新系统配置
	*/
	@RequestMapping(ConfigServiceProxy.SAVE)
	Result<Config> save(ConfigVO configVO);
	
	/**
	 * 按主键获取系统配置
	*/
	@RequestMapping(ConfigServiceProxy.GET_BY_ID)
	Result<Config> getById(String code);
 
	/**
	 * 查询全部符合条件的系统配置
	*/
	@RequestMapping(ConfigServiceProxy.QUERY_LIST)
	Result<List<Config>> queryList(ConfigVO sample);
	
	/**
	 * 分页查询符合条件的系统配置
	*/
	@RequestMapping(ConfigServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Config>> queryPagedList(ConfigVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.system.controller.ConfigController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ConfigServiceProxy api() {
		return APIProxy.get(ConfigServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}