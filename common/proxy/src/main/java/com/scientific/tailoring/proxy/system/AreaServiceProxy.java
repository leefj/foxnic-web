package com.scientific.tailoring.proxy.system;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scientific.tailoring.domain.system.Area;
import com.scientific.tailoring.domain.system.AreaVO;
import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-21 11:22:08
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = AreaServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface AreaServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , sys-area
	*/
	public static final String API_CONTEXT_PATH = "sys-area";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加区域
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除区域
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	/**
	 * 更新区域
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取区域
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的区域
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 查询全部符合条件的区域
	 */
	public static final String QUERY_LIST_FOR_SELECT = API_PREFIX + "query-list-for-select";
	
	
	
	/**
	 * 分页查询符合条件的区域
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加区域
	*/
	@RequestMapping(AreaServiceProxy.INSERT)
	Result<Area> insert(AreaVO areaVO);
	
	/**
	 * 按主键删除区域
	*/
	@RequestMapping(AreaServiceProxy.DELETE)
	Result<Area> deleteById(Integer id);
	
	/**
	 * 更新区域
	*/
	@RequestMapping(AreaServiceProxy.UPDATE)
	Result<Area> update(AreaVO areaVO);
	
	/**
	 * 按主键获取区域
	*/
	@RequestMapping(AreaServiceProxy.GET_BY_ID)
	Result<Area> getById(Integer id);
	
	/**
	 * 查询全部符合条件的区域
	*/
	@RequestMapping(AreaServiceProxy.QUERY_LIST)
	Result<List<Area>> queryList(AreaVO sample);
	
	/**
	 * 分页查询符合条件的区域
	*/
	@RequestMapping(AreaServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Area>> queryPagedList(AreaVO sample);

}