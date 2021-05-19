package com.scientific.tailoring.proxy.order;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scientific.tailoring.domain.order.VirtualEffect;
import com.scientific.tailoring.domain.order.VirtualEffectVO;
import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-25 08:57:39
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = VirtualEffectServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface VirtualEffectServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , odr-virtual-effect
	*/
	public static final String API_CONTEXT_PATH = "odr-virtual-effect";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加虚拟效果视频展示
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除虚拟效果视频展示
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	/**
	 * 更新虚拟效果视频展示
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取虚拟效果视频展示
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的虚拟效果视频展示
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的虚拟效果视频展示
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加虚拟效果视频展示
	*/
	@RequestMapping(VirtualEffectServiceProxy.INSERT)
	Result<VirtualEffect> insert(VirtualEffectVO virtualEffectVO);
	
	/**
	 * 按主键删除虚拟效果视频展示
	*/
	@RequestMapping(VirtualEffectServiceProxy.DELETE)
	Result<VirtualEffect> deleteById(Integer id);
	
	/**
	 * 更新虚拟效果视频展示
	*/
	@RequestMapping(VirtualEffectServiceProxy.UPDATE)
	Result<VirtualEffect> update(VirtualEffectVO virtualEffectVO);
	
	/**
	 * 按主键获取虚拟效果视频展示
	*/
	@RequestMapping(VirtualEffectServiceProxy.GET_BY_ID)
	Result<VirtualEffect> getById(Integer id);
	
	/**
	 * 查询全部符合条件的虚拟效果视频展示
	*/
	@RequestMapping(VirtualEffectServiceProxy.QUERY_LIST)
	Result<List<VirtualEffect>> queryList(VirtualEffectVO sample);
	
	/**
	 * 分页查询符合条件的虚拟效果视频展示
	*/
	@RequestMapping(VirtualEffectServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<VirtualEffect>> queryPagedList(VirtualEffectVO sample);

}