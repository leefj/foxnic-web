package com.scientific.tailoring.proxy.order;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scientific.tailoring.domain.order.Order;
import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.order.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-22 01:32:54
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = OrderServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface OrderServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , odr-order
	*/
	public static final String API_CONTEXT_PATH = "odr-order";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加订单
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除订单
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新订单
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取订单
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的订单
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的订单
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	
	/**
	 * 分页查询符合条件的订单
	 */
	public static final String QUERY_PAGED_LIST_4_APP = API_PREFIX + "query-paged-list-app";
	
	/**
	 * 添加订单
	*/
	@RequestMapping(OrderServiceProxy.INSERT)
	Result<Order> insert(OrderVO orderVO);
	
	/**
	 * 按主键删除订单
	*/
	@RequestMapping(OrderServiceProxy.DELETE)
	Result<Order> deleteById(Long id);
	
	/**
	 * 更新订单
	*/
	@RequestMapping(OrderServiceProxy.UPDATE)
	Result<Order> update(OrderVO orderVO);
	
	/**
	 * 按主键获取订单
	*/
	@RequestMapping(OrderServiceProxy.GET_BY_ID)
	Result<Order> getById(Long id);
	
	/**
	 * 查询全部符合条件的订单
	*/
	@RequestMapping(OrderServiceProxy.QUERY_LIST)
	Result<List<Order>> queryList(OrderVO sample);
	
	/**
	 * 分页查询符合条件的订单
	*/
	@RequestMapping(OrderServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Order>> queryPagedList(OrderVO sample);

}