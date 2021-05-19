package com.scientific.tailoring.proxy.system;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scientific.tailoring.domain.system.Dict;
import com.scientific.tailoring.domain.system.DictVO;
import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-22 01:32:50
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = DictServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface DictServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
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
	 * 按主键删除数据字典
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	/**
	 * 更新数据字典
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取数据字典
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的数据字典
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的数据字典
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	
	/**
	 * 查询所有字典数据，包括条目
	 */
	public static final String QUERY_ALL = API_PREFIX + "query-all";
	
	
	/**
	 * 添加数据字典
	*/
	@RequestMapping(DictServiceProxy.INSERT)
	Result<Dict> insert(DictVO dictVO);
	
	/**
	 * 按主键删除数据字典
	*/
	@RequestMapping(DictServiceProxy.DELETE)
	Result<Dict> deleteById(Integer id);
	
	/**
	 * 更新数据字典
	*/
	@RequestMapping(DictServiceProxy.UPDATE)
	Result<Dict> update(DictVO dictVO);
	
	/**
	 * 按主键获取数据字典
	*/
	@RequestMapping(DictServiceProxy.GET_BY_ID)
	Result<Dict> getById(Integer id);
	
	/**
	 * 查询全部符合条件的数据字典
	*/
	@RequestMapping(DictServiceProxy.QUERY_LIST)
	Result<List<Dict>> queryList(DictVO sample);
	
	/**
	 * 分页查询符合条件的数据字典
	*/
	@RequestMapping(DictServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Dict>> queryPagedList(DictVO sample);

}