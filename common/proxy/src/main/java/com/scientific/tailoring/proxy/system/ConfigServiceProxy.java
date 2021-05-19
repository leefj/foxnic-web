package com.scientific.tailoring.proxy.system;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.system.ConfigVO;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.system.Config;

/**
 * @author 李方捷
 * @since 2021-03-25 07:46:53
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = ConfigServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface ConfigServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
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
	 * 更新系统配置
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
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
	 * 添加系统配置
	*/
	@RequestMapping(ConfigServiceProxy.INSERT)
	Result<Config> insert(ConfigVO configVO);
	
	/**
	 * 按主键删除系统配置
	*/
	@RequestMapping(ConfigServiceProxy.DELETE)
	Result<Config> deleteById(String key);
	
	/**
	 * 更新系统配置
	*/
	@RequestMapping(ConfigServiceProxy.UPDATE)
	Result<Config> update(ConfigVO configVO);
	
	/**
	 * 按主键获取系统配置
	*/
	@RequestMapping(ConfigServiceProxy.GET_BY_ID)
	Result<Config> getById(String key);
	
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

}