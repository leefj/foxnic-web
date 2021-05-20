package org.github.foxnic.web.proxy.system;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.system.Lang;
import org.github.foxnic.web.domain.system.LangVO;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 语言条目表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-20 04:34:14
*/

@FeignClient(value = MicroServiceNames.SYSTEM, contextId = LangServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface LangServiceProxy {
	
	/**
	 * 基础路径 , service-system
	*/
	public static final String API_BASIC_PATH = "service-system";
	
	/**
	 * API 上下文路径 , sys-lang
	*/
	public static final String API_CONTEXT_PATH = "sys-lang";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加语言条目
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除语言条目
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 按主键删除语言条目
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新语言条目
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存语言条目
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 按主键获取语言条目
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的语言条目
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的语言条目
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
	 * 添加语言条目
	*/
	@RequestMapping(LangServiceProxy.INSERT)
	Result<Lang> insert(LangVO langVO);
	
	/**
	 * 按主键删除语言条目
	*/
	@RequestMapping(LangServiceProxy.DELETE)
	Result<Lang> deleteById(String code);
	
	
	/**
	 * 按主键删除语言条目
	*/
	@RequestMapping(LangServiceProxy.BATCH_DELETE)
	Result<Lang> deleteByIds(List<String> id);
	
	/**
	 * 更新语言条目
	*/
	@RequestMapping(LangServiceProxy.UPDATE)
	Result<Lang> update(LangVO langVO);
	
	/**
	 * 更新语言条目
	*/
	@RequestMapping(LangServiceProxy.SAVE)
	Result<Lang> save(LangVO langVO);
	
	/**
	 * 按主键获取语言条目
	*/
	@RequestMapping(LangServiceProxy.GET_BY_ID)
	Result<Lang> getById(String code);
	
	/**
	 * 查询全部符合条件的语言条目
	*/
	@RequestMapping(LangServiceProxy.QUERY_LIST)
	Result<List<Lang>> queryList(LangVO sample);
	
	/**
	 * 分页查询符合条件的语言条目
	*/
	@RequestMapping(LangServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Lang>> queryPagedList(LangVO sample);

}