package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.system.CodeExample;
import org.github.foxnic.web.domain.system.CodeExampleVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 代码生成示例  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-13 21:51:26
*/

@FeignClient(value = MicroServiceNames.SYSTEM, contextId = CodeExampleServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface CodeExampleServiceProxy {
	
	/**
	 * 基础路径 , service-system
	*/
	public static final String API_BASIC_PATH = "service-system";
	
	/**
	 * API 上下文路径 , sys-code-example
	*/
	public static final String API_CONTEXT_PATH = "sys-code-example";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加代码生成示例
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除代码生成示例
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除代码生成示例
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新代码生成示例
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存代码生成示例
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个代码生成示例
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个代码生成示例
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询代码生成示例
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询代码生成示例
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出代码生成示例数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载代码生成示例导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入代码生成示例数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加代码生成示例
	*/
	@RequestMapping(CodeExampleServiceProxy.INSERT)
	Result insert(CodeExampleVO codeExampleVO);
	
	/**
	 * 删除代码生成示例
	*/
	@RequestMapping(CodeExampleServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除代码生成示例
	*/
	@RequestMapping(CodeExampleServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新代码生成示例
	*/
	@RequestMapping(CodeExampleServiceProxy.UPDATE)
	Result update(CodeExampleVO codeExampleVO);
	
	/**
	 * 更新代码生成示例
	*/
	@RequestMapping(CodeExampleServiceProxy.SAVE)
	Result save(CodeExampleVO codeExampleVO);
	
	/**
	 * 获取代码生成示例
	*/
	@RequestMapping(CodeExampleServiceProxy.GET_BY_ID)
	Result<CodeExample> getById(String id);

	/**
	 * 批量删除代码生成示例
	*/
	@RequestMapping(CodeExampleServiceProxy.GET_BY_IDS)
	Result<List<CodeExample>> getByIds(List<String> ids);
	/**
	 * 查询代码生成示例
	*/
	@RequestMapping(CodeExampleServiceProxy.QUERY_LIST)
	Result<List<CodeExample>> queryList(CodeExampleVO sample);
	
	/**
	 * 分页查询代码生成示例
	*/
	@RequestMapping(CodeExampleServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<CodeExample>> queryPagedList(CodeExampleVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.system.controller.CodeExampleController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static CodeExampleServiceProxy api() {
		return APIProxy.get(CodeExampleServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}