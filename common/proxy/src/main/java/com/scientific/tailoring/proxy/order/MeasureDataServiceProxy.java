package com.scientific.tailoring.proxy.order;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scientific.tailoring.domain.order.MeasureData;
import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.order.MeasureDataVO;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-24 02:45:09
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = MeasureDataServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface MeasureDataServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , odr-measure-data
	*/
	public static final String API_CONTEXT_PATH = "odr-measure-data";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加测量数据发聩
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除测量数据发聩
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新测量数据发聩
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取测量数据发聩
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的测量数据发聩
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的测量数据发聩
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加测量数据发聩
	*/
	@RequestMapping(MeasureDataServiceProxy.INSERT)
	Result<MeasureData> insert(MeasureDataVO measureDataVO);
	
	/**
	 * 按主键删除测量数据发聩
	*/
	@RequestMapping(MeasureDataServiceProxy.DELETE)
	Result<MeasureData> deleteById(Long id);
	
	/**
	 * 更新测量数据发聩
	*/
	@RequestMapping(MeasureDataServiceProxy.UPDATE)
	Result<MeasureData> update(MeasureDataVO measureDataVO);
	
	/**
	 * 按主键获取测量数据发聩
	*/
	@RequestMapping(MeasureDataServiceProxy.GET_BY_ID)
	Result<MeasureData> getById(Long id);
	
	/**
	 * 查询全部符合条件的测量数据发聩
	*/
	@RequestMapping(MeasureDataServiceProxy.QUERY_LIST)
	Result<List<MeasureData>> queryList(MeasureDataVO sample);
	
	/**
	 * 分页查询符合条件的测量数据发聩
	*/
	@RequestMapping(MeasureDataServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<MeasureData>> queryPagedList(MeasureDataVO sample);

}