package com.scientific.tailoring.proxy.product;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scientific.tailoring.domain.product.ProductFabric;
import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.scientific.tailoring.domain.product.ProductFabricVO;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-22 11:00:38
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = ProductFabricServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface ProductFabricServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , prd-product-fabric
	*/
	public static final String API_CONTEXT_PATH = "prd-product-fabric";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加商品面料关系
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除商品面料关系
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 按主键批量删除面料
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新商品面料关系
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取商品面料关系
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的商品面料关系
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 查询全部符合条件的商品面料关系
	 */
	public static final String QUERY_CHOOSE_LIST = API_PREFIX + "query-choose-list";
	
	/**
	 * 分页查询符合条件的商品面料关系
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加商品面料关系
	*/
	@RequestMapping(ProductFabricServiceProxy.INSERT)
	Result<ProductFabric> insert(ProductFabricVO productFabricVO);
	
	/**
	 * 按主键删除商品面料关系
	*/
	@RequestMapping(ProductFabricServiceProxy.DELETE)
	Result<ProductFabric> deleteById(Long id);
	
	/**
	 * 更新商品面料关系
	*/
	@RequestMapping(ProductFabricServiceProxy.UPDATE)
	Result<ProductFabric> update(ProductFabricVO productFabricVO);
	
	/**
	 * 按主键获取商品面料关系
	*/
	@RequestMapping(ProductFabricServiceProxy.GET_BY_ID)
	Result<ProductFabric> getById(Long id);
	
	/**
	 * 查询全部符合条件的商品面料关系
	*/
	@RequestMapping(ProductFabricServiceProxy.QUERY_LIST)
	Result<List<ProductFabric>> queryList(ProductFabricVO sample);
	
	/**
	 * 分页查询符合条件的商品面料关系
	*/
	@RequestMapping(ProductFabricServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<ProductFabric>> queryPagedList(ProductFabricVO sample);

}