package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.system.Profile;
import org.github.foxnic.web.domain.system.ProfileVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * Profile  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-06 11:20:15
*/

@FeignClient(value = MicroServiceNames.SYSTEM, contextId = ProfileServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ProfileServiceProxy {

	/**
	 * 基础路径 , service-system
	*/
	public static final String API_BASIC_PATH = "service-system";

	/**
	 * API 上下文路径 , sys-profile
	*/
	public static final String API_CONTEXT_PATH = "sys-profile";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加Profile
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除Profile
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除Profile
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新Profile
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存Profile
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个Profile
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个Profile
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询Profile
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询Profile
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出Profile数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载Profile导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入Profile数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加Profile
	*/
	@RequestMapping(ProfileServiceProxy.INSERT)
	Result insert(ProfileVO profileVO);

	/**
	 * 删除Profile
	*/
	@RequestMapping(ProfileServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除Profile
	*/
	@RequestMapping(ProfileServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新Profile
	*/
	@RequestMapping(ProfileServiceProxy.UPDATE)
	Result update(ProfileVO profileVO);

	/**
	 * 更新Profile
	*/
	@RequestMapping(ProfileServiceProxy.SAVE)
	Result save(ProfileVO profileVO);

	/**
	 * 获取Profile
	*/
	@RequestMapping(ProfileServiceProxy.GET_BY_ID)
	Result<Profile> getById(String id);

	/**
	 * 获取多个Profile
	*/
	@RequestMapping(ProfileServiceProxy.GET_BY_IDS)
	Result<List<Profile>> getByIds(List<String> ids);
	/**
	 * 查询Profile
	*/
	@RequestMapping(ProfileServiceProxy.QUERY_LIST)
	Result<List<Profile>> queryList(ProfileVO sample);

	/**
	 * 分页查询Profile
	*/
	@RequestMapping(ProfileServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Profile>> queryPagedList(ProfileVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.system.controller.ProfileController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ProfileServiceProxy api() {
		return APIProxy.get(ProfileServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}