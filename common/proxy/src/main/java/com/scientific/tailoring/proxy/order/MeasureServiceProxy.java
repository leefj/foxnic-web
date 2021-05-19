package com.scientific.tailoring.proxy.order;
import java.util.List;
import com.scientific.tailoring.domain.order.MeasureVO;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;

import com.scientific.tailoring.domain.order.Measure;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-22 04:19:26
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = MeasureServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface MeasureServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , odr-measure
	*/
	public static final String API_CONTEXT_PATH = "odr-measure";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加订单测量信息
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除订单测量信息
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新订单测量信息
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取订单测量信息
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的订单测量信息
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的订单测量信息
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	
	/**
	 * 分页查询符合条件的订单测量信息
	 */
	public static final String QUERY_PAGED_LIST_4_APP = API_PREFIX + "query-paged-list-app";
	
	
	/**
	 * 查询测量类型
	 */
	public static final String QUERY_MEASURE_TYPE = API_PREFIX + "query-measure-type";
	
	
	/**
	 * 查询测量维度
	 */
	public static final String QUERY_MEASURE_DIMENSIONS = API_PREFIX + "query-measure-dimensions";

	/**
	 * 查询测量维度
	 */
	public static final String QUERY_MEASURE_DIMENSIONS_AND_DATA = API_PREFIX + "query-measure-dimensions-and-data";

	/**
	 * 导出Excel
	 */
	public static final String EXPORT_EXCEL = API_PREFIX+"export-excel";
	
	/**
	 * 导入Excel
	 */
	public static final String IMPORT_EXCEL = API_PREFIX+"import-excel";


	/**
	 * 添加订单测量信息
	*/
	@RequestMapping(MeasureServiceProxy.INSERT)
	Result<Measure> insert(MeasureVO measureVO);
	
	/**
	 * 按主键删除订单测量信息
	*/
	@RequestMapping(MeasureServiceProxy.DELETE)
	Result<Measure> deleteById(Long id);
	
	/**
	 * 更新订单测量信息
	*/
	@RequestMapping(MeasureServiceProxy.UPDATE)
	Result<Measure> update(MeasureVO measureVO);
	
	/**
	 * 按主键获取订单测量信息
	*/
	@RequestMapping(MeasureServiceProxy.GET_BY_ID)
	Result<Measure> getById(Long id);
	
	/**
	 * 查询全部符合条件的订单测量信息
	*/
	@RequestMapping(MeasureServiceProxy.QUERY_LIST)
	Result<List<Measure>> queryList(MeasureVO sample);
	
	/**
	 * 分页查询符合条件的订单测量信息
	*/
	@RequestMapping(MeasureServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Measure>> queryPagedList(MeasureVO sample);

}