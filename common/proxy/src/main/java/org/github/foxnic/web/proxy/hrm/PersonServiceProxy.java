package org.github.foxnic.web.proxy.hrm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.hrm.PersonVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 人员表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-29 17:30:24
*/

@FeignClient(value = MicroServiceNames.HRM, contextId = PersonServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface PersonServiceProxy {

	/**
	 * 基础路径 , service-hrm
	*/
	public static final String API_BASIC_PATH = "service-hrm";

	/**
	 * API 上下文路径 , hrm-person
	*/
	public static final String API_CONTEXT_PATH = "hrm-person";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加人员
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除人员
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除人员
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新人员
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存人员
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个人员
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个人员
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询人员
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询人员
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出人员数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载人员导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入人员数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加人员
	*/
	@RequestMapping(PersonServiceProxy.INSERT)
	Result insert(PersonVO personVO);

	/**
	 * 删除人员
	*/
	@RequestMapping(PersonServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除人员
	*/
	@RequestMapping(PersonServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新人员
	*/
	@RequestMapping(PersonServiceProxy.UPDATE)
	Result update(PersonVO personVO);

	/**
	 * 更新人员
	*/
	@RequestMapping(PersonServiceProxy.SAVE)
	Result save(PersonVO personVO);

	/**
	 * 获取人员
	*/
	@RequestMapping(PersonServiceProxy.GET_BY_ID)
	Result<Person> getById(String id);

	/**
	 * 批量删除人员
	*/
	@RequestMapping(PersonServiceProxy.GET_BY_IDS)
	Result<List<Person>> getByIds(List<String> ids);
	/**
	 * 查询人员
	*/
	@RequestMapping(PersonServiceProxy.QUERY_LIST)
	Result<List<Person>> queryList(PersonVO sample);

	/**
	 * 分页查询人员
	*/
	@RequestMapping(PersonServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Person>> queryPagedList(PersonVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.hrm.controller.PersonController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static PersonServiceProxy api() {
		return APIProxy.get(PersonServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}