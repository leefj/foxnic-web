package org.github.foxnic.web.proxy.camunda;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.UserVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 账户表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 14:17:02
 * @version
*/

@FeignClient(value = MicroServiceNames.CAMUNDA, contextId = CamundaUserServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface CamundaUserServiceProxy {

	/**
	 * 基础路径 , service-camunda
	*/
	public static final String API_BASIC_PATH = "service-camunda";

	/**
	 * API 上下文路径 , camunda-user
	*/
	public static final String API_CONTEXT_PATH = "camunda-user";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加账户
	 */
	public static final String INSERT = API_PREFIX + "insert";

	/**
	 * 删除账户
	 */
	public static final String DELETE = API_PREFIX + "delete";


	/**
	 * 批量删除账户
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";


	/**
	 * 更新账户
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存账户
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取账户
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 查询账户
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询账户
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出账户数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 导入账户数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 更改密码
	 */
	public static final String CHANGE_PASSWD = API_PREFIX + "change-passwd";

    /**
	 * 添加账户
	*/
	@RequestMapping(CamundaUserServiceProxy.INSERT)
	Result insert(UserVO userVO);

	/**
	 * 删除账户
	*/
	@RequestMapping(CamundaUserServiceProxy.DELETE)
	Result deleteById(String id);


	/**
	 * 批量删除账户
	*/
	@RequestMapping(CamundaUserServiceProxy.BATCH_DELETE)
	Result deleteByIds(List<String> id);

	/**
	 * 更新账户
	*/
	@RequestMapping(CamundaUserServiceProxy.UPDATE)
	Result update(UserVO userVO);

	/**
	 * 更新账户
	*/
	@RequestMapping(CamundaUserServiceProxy.SAVE)
	Result save(UserVO userVO);

	/**
	 * 获取账户
	*/
	@RequestMapping(CamundaUserServiceProxy.GET_BY_ID)
	Result<User> getById(String id);

	/**
	 * 查询账户
	*/
	@RequestMapping(CamundaUserServiceProxy.QUERY_LIST)
	Result<List<User>> queryList(UserVO sample);

	/**
	 * 分页查询账户
	*/
	@RequestMapping(CamundaUserServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<User>> queryPagedList(UserVO sample);

	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.bpm.BpmUserController";


	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static CamundaUserServiceProxy api() {
		return APIProxy.get(CamundaUserServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}
