package com.scientific.tailoring.proxy.product;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scientific.tailoring.domain.product.Product;
import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.scientific.tailoring.domain.product.ProductVO;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-19 09:11:19
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = ProductServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface ProductServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , prd-product
	*/
	public static final String API_CONTEXT_PATH = "prd-product";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加商品
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除商品
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新商品
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取商品
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 按主键获取商品(App专用)
	 */
	public static final String GET_BY_ID_4_APP = API_PREFIX + "get-by-id-app";
	
	/**
	 * 查询全部符合条件的商品
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的商品
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 分页查询符合条件的商品(App专用)
	 */
	public static final String QUERY_PAGED_LIST_4_APP = API_PREFIX + "query-paged-list-app";
	
	/**
	 * 添加商品
	*/
	@RequestMapping(ProductServiceProxy.INSERT)
	Result<Product> insert(ProductVO productVO);
	
	/**
	 * 按主键删除商品
	*/
	@RequestMapping(ProductServiceProxy.DELETE)
	Result<Product> deleteById(Long id);
	
	/**
	 * 更新商品
	*/
	@RequestMapping(ProductServiceProxy.UPDATE)
	Result<Product> update(ProductVO productVO);
	
	/**
	 * 按主键获取商品
	*/
	@RequestMapping(ProductServiceProxy.GET_BY_ID)
	Result<Product> getById(Long id);
	
	/**
	 * 查询全部符合条件的商品
	*/
	@RequestMapping(ProductServiceProxy.QUERY_LIST)
	Result<List<Product>> queryList(ProductVO sample);
	
	/**
	 * 分页查询符合条件的商品
	*/
	@RequestMapping(ProductServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Product>> queryPagedList(ProductVO sample);

}