package com.scientific.tailoring.proxy.product;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.scientific.tailoring.domain.product.LabelVO;
import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;

import com.scientific.tailoring.domain.product.Label;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-19 09:11:19
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = LabelServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface LabelServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , prd-label
	*/
	public static final String API_CONTEXT_PATH = "prd-label";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加产品标签
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除产品标签
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	/**
	 * 按主键批量删除产品标签
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新产品标签
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取产品标签
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的产品标签
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的产品标签
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加产品标签
	*/
	@RequestMapping(LabelServiceProxy.INSERT)
	Result<Label> insert(LabelVO labelVO);
	
	/**
	 * 按主键删除产品标签
	*/
	@RequestMapping(LabelServiceProxy.DELETE)
	Result<Label> deleteById(Integer id);
	
	/**
	 * 更新产品标签
	*/
	@RequestMapping(LabelServiceProxy.UPDATE)
	Result<Label> update(LabelVO labelVO);
	
	/**
	 * 按主键获取产品标签
	*/
	@RequestMapping(LabelServiceProxy.GET_BY_ID)
	Result<Label> getById(Integer id);
	
	/**
	 * 查询全部符合条件的产品标签
	*/
	@RequestMapping(LabelServiceProxy.QUERY_LIST)
	Result<List<Label>> queryList(LabelVO sample);
	
	/**
	 * 分页查询符合条件的产品标签
	*/
	@RequestMapping(LabelServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Label>> queryPagedList(LabelVO sample);

}