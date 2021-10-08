package org.github.foxnic.web.proxy.bpm;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.bpm.RoleEmployee;
import org.github.foxnic.web.domain.bpm.RoleEmployeeVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 流程角色员工关系表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-08 20:22:21
 * @version
*/

@FeignClient(value = MicroServiceNames.BPM, contextId = RoleEmployeeServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface RoleEmployeeServiceProxy {
	
	/**
	 * 基础路径 , service-bpm
	*/
	public static final String API_BASIC_PATH = "service-bpm";
	
	/**
	 * API 上下文路径 , bpm-role-employee
	*/
	public static final String API_CONTEXT_PATH = "bpm-role-employee";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加流程角色员工关系
	 */
	public static final String INSERT = API_PREFIX + "insert";

	/**
	 * 添加流程角色员工关系
	 */
	public static final String INSERTS = API_PREFIX + "inserts";
	
	/**
	 * 删除流程角色员工关系
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除流程角色员工关系
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	
	/**
	 * 更新流程角色员工关系
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存流程角色员工关系
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个流程角色员工关系
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个流程角色员工关系
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询流程角色员工关系
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询流程角色员工关系
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出流程角色员工关系数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载流程角色员工关系导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入流程角色员工关系数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加流程角色员工关系
	*/
	@RequestMapping(RoleEmployeeServiceProxy.INSERT)
	Result insert(RoleEmployeeVO roleEmployeeVO);
	
	/**
	 * 删除流程角色员工关系
	*/
	@RequestMapping(RoleEmployeeServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除流程角色员工关系
	*/
	@RequestMapping(RoleEmployeeServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新流程角色员工关系
	*/
	@RequestMapping(RoleEmployeeServiceProxy.UPDATE)
	Result update(RoleEmployeeVO roleEmployeeVO);
	
	/**
	 * 更新流程角色员工关系
	*/
	@RequestMapping(RoleEmployeeServiceProxy.SAVE)
	Result save(RoleEmployeeVO roleEmployeeVO);
	
	/**
	 * 获取流程角色员工关系
	*/
	@RequestMapping(RoleEmployeeServiceProxy.GET_BY_ID)
	Result<RoleEmployee> getById(String id);

	/**
	 * 批量删除流程角色员工关系
	*/
	@RequestMapping(RoleEmployeeServiceProxy.GET_BY_IDS)
	Result<List<RoleEmployee>> getByIds(List<String> ids);
	/**
	 * 查询流程角色员工关系
	*/
	@RequestMapping(RoleEmployeeServiceProxy.QUERY_LIST)
	Result<List<RoleEmployee>> queryList(RoleEmployeeVO sample);
	
	/**
	 * 分页查询流程角色员工关系
	*/
	@RequestMapping(RoleEmployeeServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<RoleEmployee>> queryPagedList(RoleEmployeeVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.bpm.controller.RoleEmployeeController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static RoleEmployeeServiceProxy api() {
		return APIProxy.get(RoleEmployeeServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}