package com.scientific.tailoring.proxy.product;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.product.VirtualLibraryVO;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.product.VirtualLibrary;

/**
 * @author 李方捷
 * @since 2021-04-08 03:46:44
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = VirtualLibraryServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface VirtualLibraryServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , prd-virtual-library
	*/
	public static final String API_CONTEXT_PATH = "prd-virtual-library";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加虚拟试衣
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除虚拟试衣
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新虚拟试衣
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 添加虚拟试衣
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 按主键获取虚拟试衣
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的虚拟试衣
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的虚拟试衣
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 检查 虚拟试衣 是否已经存在
	 */
	public static final String CHECK_EXISTS = API_PREFIX + "check-exists";
	
	/**
	 * 添加虚拟试衣
	*/
	@RequestMapping(VirtualLibraryServiceProxy.INSERT)
	Result<VirtualLibrary> insert(VirtualLibraryVO virtualLibraryVO);
	
	/**
	 * 按主键删除虚拟试衣
	*/
	@RequestMapping(VirtualLibraryServiceProxy.DELETE)
	Result<VirtualLibrary> deleteById(Long id);
	
	/**
	 * 按主键批量删除虚拟试衣
	*/
	@RequestMapping(VirtualLibraryServiceProxy.BATCH_DELETE)
	Result<VirtualLibrary> deleteByIds(List<Long> id);
	
	/**
	 * 更新虚拟试衣
	*/
	@RequestMapping(VirtualLibraryServiceProxy.UPDATE)
	Result<VirtualLibrary> update(VirtualLibraryVO virtualLibraryVO);
	
	/**
	 * 添加虚拟试衣
	*/
	@RequestMapping(VirtualLibraryServiceProxy.SAVE)
	Result<VirtualLibrary> save(VirtualLibraryVO virtualLibraryVO);
	
	/**
	 * 按主键获取虚拟试衣
	*/
	@RequestMapping(VirtualLibraryServiceProxy.GET_BY_ID)
	Result<VirtualLibrary> getById(Long id);
	
	/**
	 * 查询全部符合条件的虚拟试衣
	*/
	@RequestMapping(VirtualLibraryServiceProxy.QUERY_LIST)
	Result<List<VirtualLibrary>> queryList(VirtualLibraryVO sample);
	
	/**
	 * 分页查询符合条件的虚拟试衣
	*/
	@RequestMapping(VirtualLibraryServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<VirtualLibrary>> queryPagedList(VirtualLibraryVO sample);

}