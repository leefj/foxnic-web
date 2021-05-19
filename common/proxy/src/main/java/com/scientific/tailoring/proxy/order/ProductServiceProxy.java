package com.scientific.tailoring.proxy.order;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.order.Product;
import com.scientific.tailoring.domain.order.ProductVO;

/**
 * @author 李方捷
 * @since 2021-03-25 08:57:38
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = ProductServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface ProductServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , odr-product
	*/
	public static final String API_CONTEXT_PATH = "odr-product";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加订单商品关系
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除订单商品关系
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新订单商品关系
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取订单商品关系
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的订单商品关系
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
 
	public static final String QUERY_UNUSED_LIST = API_PREFIX + "query-unused-list";
	
	
	
	/**
	 * 分页查询符合条件的订单商品关系
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加订单商品关系
	*/
	@RequestMapping(ProductServiceProxy.INSERT)
	Result<Product> insert(ProductVO productVO);
	
	/**
	 * 按主键删除订单商品关系
	*/
	@RequestMapping(ProductServiceProxy.DELETE)
	Result<Product> deleteById(Long id);
	
	/**
	 * 更新订单商品关系
	*/
	@RequestMapping(ProductServiceProxy.UPDATE)
	Result<Product> update(ProductVO productVO);
	
	/**
	 * 按主键获取订单商品关系
	*/
	@RequestMapping(ProductServiceProxy.GET_BY_ID)
	Result<Product> getById(Long id);
	
	/**
	 * 查询全部符合条件的订单商品关系
	*/
	@RequestMapping(ProductServiceProxy.QUERY_LIST)
	Result<List<Product>> queryList(ProductVO sample);
	
	/**
	 * 分页查询符合条件的订单商品关系
	*/
	@RequestMapping(ProductServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Product>> queryPagedList(ProductVO sample);

}