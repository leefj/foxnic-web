package com.scientific.tailoring.proxy.order;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.order.MeasureFileVO;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.order.MeasureFile;

/**
 * @author 李方捷
 * @since 2021-03-25 08:57:39
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = MeasureFileServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface MeasureFileServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , odr-measure-file
	*/
	public static final String API_CONTEXT_PATH = "odr-measure-file";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加测量文件采集
	 */
	public static final String INSERT = API_PREFIX + "insert";

	/**
	 * 批量添加测量文件采集
	 */
	public static final String INSERT_FILES = API_PREFIX + "insert-files";
	
	/**
	 * 按主键删除测量文件采集
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新测量文件采集
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取测量文件采集
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的测量文件采集
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的测量文件采集
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加测量文件采集
	*/
	@RequestMapping(MeasureFileServiceProxy.INSERT)
	Result<MeasureFile> insert(MeasureFileVO measureFileVO);
	
	/**
	 * 按主键删除测量文件采集
	*/
	@RequestMapping(MeasureFileServiceProxy.DELETE)
	Result<MeasureFile> deleteById(Integer id);
	
	/**
	 * 更新测量文件采集
	*/
	@RequestMapping(MeasureFileServiceProxy.UPDATE)
	Result<MeasureFile> update(MeasureFileVO measureFileVO);
	
	/**
	 * 按主键获取测量文件采集
	*/
	@RequestMapping(MeasureFileServiceProxy.GET_BY_ID)
	Result<MeasureFile> getById(Integer id);
	
	/**
	 * 查询全部符合条件的测量文件采集
	*/
	@RequestMapping(MeasureFileServiceProxy.QUERY_LIST)
	Result<List<MeasureFile>> queryList(MeasureFileVO sample);
	
	/**
	 * 分页查询符合条件的测量文件采集
	*/
	@RequestMapping(MeasureFileServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<MeasureFile>> queryPagedList(MeasureFileVO sample);

}