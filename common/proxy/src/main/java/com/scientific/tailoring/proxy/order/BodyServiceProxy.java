package com.scientific.tailoring.proxy.order;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.order.Body;
import com.scientific.tailoring.domain.order.BodyVO;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;

/**
 * <p>
 * 订单测量人员表  控制器服务代理
 * </p>
 * @author 李方捷
 * @since 2021-05-12 10:21:27
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = BodyServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface BodyServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , odr-body
	*/
	public static final String API_CONTEXT_PATH = "odr-body";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加订单测量人员
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除订单测量人员
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 按主键删除订单测量人员
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新订单测量人员
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存订单测量人员
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 按主键获取订单测量人员
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的订单测量人员
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的订单测量人员
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出Excel
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";
	
	/**
	 * 导入Excel
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加订单测量人员
	*/
	@RequestMapping(BodyServiceProxy.INSERT)
	Result<Body> insert(BodyVO bodyVO);
	
	/**
	 * 按主键删除订单测量人员
	*/
	@RequestMapping(BodyServiceProxy.DELETE)
	Result<Body> deleteById(Long id);
	
	
	/**
	 * 按主键删除订单测量人员
	*/
	@RequestMapping(BodyServiceProxy.BATCH_DELETE)
	Result<Body> deleteByIds(List<Long> id);
	
	/**
	 * 更新订单测量人员
	*/
	@RequestMapping(BodyServiceProxy.UPDATE)
	Result<Body> update(BodyVO bodyVO);
	
	/**
	 * 更新订单测量人员
	*/
	@RequestMapping(BodyServiceProxy.SAVE)
	Result<Body> save(BodyVO bodyVO);
	
	/**
	 * 按主键获取订单测量人员
	*/
	@RequestMapping(BodyServiceProxy.GET_BY_ID)
	Result<Body> getById(Long id);
	
	/**
	 * 查询全部符合条件的订单测量人员
	*/
	@RequestMapping(BodyServiceProxy.QUERY_LIST)
	Result<List<Body>> queryList(BodyVO sample);
	
	/**
	 * 分页查询符合条件的订单测量人员
	*/
	@RequestMapping(BodyServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Body>> queryPagedList(BodyVO sample);

}