package org.github.foxnic.web.proxy.dataperm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.dataperm.Subject;
import org.github.foxnic.web.domain.dataperm.SubjectVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 数据权限主体表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-02 14:49:22
*/

@FeignClient(value = MicroServiceNames.DATA_PERM, contextId = SubjectServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface SubjectServiceProxy {

	/**
	 * 基础路径 , service-dataperm
	*/
	public static final String API_BASIC_PATH = "service-dataperm";

	/**
	 * API 上下文路径 , dp-subject
	*/
	public static final String API_CONTEXT_PATH = "dp-subject";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加数据权限主体
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除数据权限主体
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除数据权限主体
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新数据权限主体
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存数据权限主体
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个数据权限主体
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个数据权限主体
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询数据权限主体
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询数据权限主体
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出数据权限主体数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载数据权限主体导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入数据权限主体数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加数据权限主体
	*/
	@RequestMapping(SubjectServiceProxy.INSERT)
	Result insert(SubjectVO subjectVO);

	/**
	 * 删除数据权限主体
	*/
	@RequestMapping(SubjectServiceProxy.DELETE)
	Result deleteById(String code);

	/**
	 * 批量删除数据权限主体
	*/
	@RequestMapping(SubjectServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> codes);

	/**
	 * 更新数据权限主体
	*/
	@RequestMapping(SubjectServiceProxy.UPDATE)
	Result update(SubjectVO subjectVO);

	/**
	 * 更新数据权限主体
	*/
	@RequestMapping(SubjectServiceProxy.SAVE)
	Result save(SubjectVO subjectVO);

	/**
	 * 获取数据权限主体
	*/
	@RequestMapping(SubjectServiceProxy.GET_BY_ID)
	Result<Subject> getById(String code);

	/**
	 * 批量删除数据权限主体
	*/
	@RequestMapping(SubjectServiceProxy.GET_BY_IDS)
	Result<List<Subject>> getByIds(List<String> codes);
	/**
	 * 查询数据权限主体
	*/
	@RequestMapping(SubjectServiceProxy.QUERY_LIST)
	Result<List<Subject>> queryList(SubjectVO sample);

	/**
	 * 分页查询数据权限主体
	*/
	@RequestMapping(SubjectServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Subject>> queryPagedList(SubjectVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.dataperm.controller.SubjectController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static SubjectServiceProxy api() {
		return APIProxy.get(SubjectServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}