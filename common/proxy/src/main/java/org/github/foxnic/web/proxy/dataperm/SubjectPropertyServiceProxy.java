package org.github.foxnic.web.proxy.dataperm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.dataperm.SubjectProperty;
import org.github.foxnic.web.domain.dataperm.SubjectPropertyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 数据权限主体属性表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-14 16:24:44
*/

@FeignClient(value = MicroServiceNames.DATA_PERM, contextId = SubjectPropertyServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface SubjectPropertyServiceProxy {

	/**
	 * 基础路径 , service-dataperm
	*/
	public static final String API_BASIC_PATH = "service-dataperm";

	/**
	 * API 上下文路径 , dp-subject-property
	*/
	public static final String API_CONTEXT_PATH = "dp-subject-property";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加数据权限主体属性
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除数据权限主体属性
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除数据权限主体属性
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新数据权限主体属性
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存数据权限主体属性
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个数据权限主体属性
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个数据权限主体属性
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询数据权限主体属性
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询数据权限主体属性
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出数据权限主体属性数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载数据权限主体属性导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入数据权限主体属性数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加数据权限主体属性
	*/
	@RequestMapping(SubjectPropertyServiceProxy.INSERT)
	Result insert(SubjectPropertyVO subjectPropertyVO);

	/**
	 * 删除数据权限主体属性
	*/
	@RequestMapping(SubjectPropertyServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除数据权限主体属性
	*/
	@RequestMapping(SubjectPropertyServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新数据权限主体属性
	*/
	@RequestMapping(SubjectPropertyServiceProxy.UPDATE)
	Result update(SubjectPropertyVO subjectPropertyVO);

	/**
	 * 更新数据权限主体属性
	*/
	@RequestMapping(SubjectPropertyServiceProxy.SAVE)
	Result save(SubjectPropertyVO subjectPropertyVO);

	/**
	 * 获取数据权限主体属性
	*/
	@RequestMapping(SubjectPropertyServiceProxy.GET_BY_ID)
	Result<SubjectProperty> getById(String id);

	/**
	 * 批量删除数据权限主体属性
	*/
	@RequestMapping(SubjectPropertyServiceProxy.GET_BY_IDS)
	Result<List<SubjectProperty>> getByIds(List<String> ids);
	/**
	 * 查询数据权限主体属性
	*/
	@RequestMapping(SubjectPropertyServiceProxy.QUERY_LIST)
	Result<List<SubjectProperty>> queryList(SubjectPropertyVO sample);

	/**
	 * 分页查询数据权限主体属性
	*/
	@RequestMapping(SubjectPropertyServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<SubjectProperty>> queryPagedList(SubjectPropertyVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.dataperm.controller.SubjectPropertyController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static SubjectPropertyServiceProxy api() {
		return APIProxy.get(SubjectPropertyServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}