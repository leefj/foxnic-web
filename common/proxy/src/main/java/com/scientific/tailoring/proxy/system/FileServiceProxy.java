package com.scientific.tailoring.proxy.system;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.domain.system.FileVO;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.system.File;

/**
 * @author 李方捷
 * @since 2021-03-19 02:41:52
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = FileServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface FileServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , sys-file
	*/
	public static final String API_CONTEXT_PATH = "sys-file";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加sys_file
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除sys_file
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	/**
	 * 更新sys_file
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取sys_file
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的sys_file
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的sys_file
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加sys_file
	*/
	@RequestMapping(FileServiceProxy.INSERT)
	Result<File> insert(FileVO fileVO);
	
	/**
	 * 按主键删除sys_file
	*/
	@RequestMapping(FileServiceProxy.DELETE)
	Result<File> deleteById(Integer id);
	
	/**
	 * 更新sys_file
	*/
	@RequestMapping(FileServiceProxy.UPDATE)
	Result<File> update(FileVO fileVO);
	
	/**
	 * 按主键获取sys_file
	*/
	@RequestMapping(FileServiceProxy.GET_BY_ID)
	Result<File> getById(Integer id);
	
	/**
	 * 查询全部符合条件的sys_file
	*/
	@RequestMapping(FileServiceProxy.QUERY_LIST)
	Result<List<File>> queryList(FileVO sample);
	
	/**
	 * 分页查询符合条件的sys_file
	*/
	@RequestMapping(FileServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<File>> queryPagedList(FileVO sample);

}