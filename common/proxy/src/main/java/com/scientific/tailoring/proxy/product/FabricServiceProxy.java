package com.scientific.tailoring.proxy.product;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.product.FabricVO;
import org.springframework.cloud.openfeign.FeignClient;

import com.scientific.tailoring.domain.product.Fabric;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-04-08 03:23:07
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = FabricServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface FabricServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , prd-fabric
	*/
	public static final String API_CONTEXT_PATH = "prd-fabric";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加面料
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除面料
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	/**
	 * 按主键批量删除面料
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新面料
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 添加面料
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 按主键获取面料
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的面料
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的面料
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 检查 面料 是否已经存在
	 */
	public static final String CHECK_EXISTS = API_PREFIX + "check-exists";
	
	/**
	 * 添加面料
	*/
	@RequestMapping(FabricServiceProxy.INSERT)
	Result<Fabric> insert(FabricVO fabricVO);
	
	/**
	 * 按主键删除面料
	*/
	@RequestMapping(FabricServiceProxy.DELETE)
	Result<Fabric> deleteById(Integer id);
	
	/**
	 * 按主键批量删除面料
	*/
	@RequestMapping(FabricServiceProxy.BATCH_DELETE)
	Result<Fabric> deleteByIds(List<Integer> id);
	
	/**
	 * 更新面料
	*/
	@RequestMapping(FabricServiceProxy.UPDATE)
	Result<Fabric> update(FabricVO fabricVO);
	
	/**
	 * 添加面料
	*/
	@RequestMapping(FabricServiceProxy.SAVE)
	Result<Fabric> save(FabricVO fabricVO);
	
	/**
	 * 按主键获取面料
	*/
	@RequestMapping(FabricServiceProxy.GET_BY_ID)
	Result<Fabric> getById(Integer id);
	
	/**
	 * 查询全部符合条件的面料
	*/
	@RequestMapping(FabricServiceProxy.QUERY_LIST)
	Result<List<Fabric>> queryList(FabricVO sample);
	
	/**
	 * 分页查询符合条件的面料
	*/
	@RequestMapping(FabricServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Fabric>> queryPagedList(FabricVO sample);

}