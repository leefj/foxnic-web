package org.github.foxnic.web.proxy.bpm;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.bpm.Role;
import org.github.foxnic.web.domain.bpm.RoleVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 流程角色表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-08 20:48:40
*/

@FeignClient(value = MicroServiceNames.BPM, contextId = RoleServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface RoleServiceProxy {

	/**
	 * 基础路径 , service-bpm
	*/
	public static final String API_BASIC_PATH = "service-bpm";

	/**
	 * API 上下文路径 , bpm-role
	*/
	public static final String API_CONTEXT_PATH = "bpm-role";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加流程角色
	 */
	public static final String INSERT = API_PREFIX + "insert";

	/**
	 * 删除流程角色
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除流程角色
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新流程角色
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存流程角色
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个流程角色
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个流程角色
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 获取多个流程角色
	 */
	public static final String GET_BY_CODES = API_PREFIX + "get-by-codes";

	/**
	 * 获得员工所属的流程角色
	 */
	public static final String GET_EMPLOYEE_ROLES = API_PREFIX + "get_employee_roles";



	/**
	 * 查询流程角色
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询流程角色
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出流程角色数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载流程角色导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入流程角色数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加流程角色
	*/
	@RequestMapping(RoleServiceProxy.INSERT)
	Result insert(RoleVO roleVO);

	/**
	 * 删除流程角色
	*/
	@RequestMapping(RoleServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除流程角色
	*/
	@RequestMapping(RoleServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	@RequestMapping(RoleServiceProxy.GET_BY_CODES)
	Result<List<Role>> getByCodes(List<String> codes);

	@RequestMapping(RoleServiceProxy.GET_EMPLOYEE_ROLES)
	Result<List<Role>> getEmployeeRoles(String employeeId);

	/**
	 * 更新流程角色
	*/
	@RequestMapping(RoleServiceProxy.UPDATE)
	Result update(RoleVO roleVO);

	/**
	 * 更新流程角色
	*/
	@RequestMapping(RoleServiceProxy.SAVE)
	Result save(RoleVO roleVO);

	/**
	 * 获取流程角色
	*/
	@RequestMapping(RoleServiceProxy.GET_BY_ID)
	Result<Role> getById(String id);

	/**
	 * 批量删除流程角色
	*/
	@RequestMapping(RoleServiceProxy.GET_BY_IDS)
	Result<List<Role>> getByIds(List<String> ids);
	/**
	 * 查询流程角色
	*/
	@RequestMapping(RoleServiceProxy.QUERY_LIST)
	Result<List<Role>> queryList(RoleVO sample);

	/**
	 * 分页查询流程角色
	*/
	@RequestMapping(RoleServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Role>> queryPagedList(RoleVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.bpm.controller.RoleController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static RoleServiceProxy api() {
		return APIProxy.get(RoleServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}
