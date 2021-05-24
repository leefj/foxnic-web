package org.github.foxnic.web.proxy.storage;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.domain.storage.FileVO;
import com.github.foxnic.springboot.api.proxy.APIProxy;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 系统文件  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-24 05:39:02
*/

@FeignClient(value = MicroServiceNames.STORAGE, contextId = FileServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface FileServiceProxy {
	
	/**
	 * 基础路径 , service-storage
	*/
	public static final String API_BASIC_PATH = "service-storage";
	
	/**
	 * API 上下文路径 , sys-file
	*/
	public static final String API_CONTEXT_PATH = "sys-file";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加系统文件
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除系统文件
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 按主键删除系统文件
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新系统文件
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存系统文件
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 按主键获取系统文件
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的系统文件
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的系统文件
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
	 * 添加系统文件
	*/
	@RequestMapping(FileServiceProxy.INSERT)
	Result<File> insert(FileVO fileVO);
	
	/**
	 * 按主键删除系统文件
	*/
	@RequestMapping(FileServiceProxy.DELETE)
	Result<File> deleteById(String id);
	
	
	/**
	 * 按主键删除系统文件
	*/
	@RequestMapping(FileServiceProxy.BATCH_DELETE)
	Result<File> deleteByIds(List<String> id);
	
	/**
	 * 更新系统文件
	*/
	@RequestMapping(FileServiceProxy.UPDATE)
	Result<File> update(FileVO fileVO);
	
	/**
	 * 更新系统文件
	*/
	@RequestMapping(FileServiceProxy.SAVE)
	Result<File> save(FileVO fileVO);
	
	/**
	 * 按主键获取系统文件
	*/
	@RequestMapping(FileServiceProxy.GET_BY_ID)
	Result<File> getById(String id);
	
	/**
	 * 查询全部符合条件的系统文件
	*/
	@RequestMapping(FileServiceProxy.QUERY_LIST)
	Result<List<File>> queryList(FileVO sample);
	
	/**
	 * 分页查询符合条件的系统文件
	*/
	@RequestMapping(FileServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<File>> queryPagedList(FileVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.storage.controller.FileController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static FileServiceProxy api() {
		return APIProxy.get(FileServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}