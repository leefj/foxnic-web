package org.github.foxnic.web.proxy.dataperm;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.dataperm.RuleCondition;
import org.github.foxnic.web.domain.dataperm.RuleConditionVO;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 数据权限规则范围条件表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-26 14:45:05
 * @version
*/

@FeignClient(value = MicroServiceNames.DATA_PERM, contextId = RuleConditionServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface RuleConditionServiceProxy {

	/**
	 * 基础路径 , service-dataperm
	*/
	public static final String API_BASIC_PATH = "service-dataperm";

	/**
	 * API 上下文路径 , dp-rule-condition
	*/
	public static final String API_CONTEXT_PATH = "dp-rule-condition";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加数据权限规则范围条件
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除数据权限规则范围条件
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除数据权限规则范围条件
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新数据权限规则范围条件
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存数据权限规则范围条件
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个数据权限规则范围条件
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个数据权限规则范围条件
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询数据权限规则范围条件
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 查询节点
	 */
	public static final String QUERY_NODES = API_PREFIX + "query-nodes";

	/**
	 * 分页查询数据权限规则范围条件
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出数据权限规则范围条件数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载数据权限规则范围条件导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入数据权限规则范围条件数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加数据权限规则范围条件
	*/
	@RequestMapping(RuleConditionServiceProxy.INSERT)
	Result insert(RuleConditionVO ruleConditionVO);

	/**
	 * 删除数据权限规则范围条件
	*/
	@RequestMapping(RuleConditionServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除数据权限规则范围条件
	*/
	@RequestMapping(RuleConditionServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新数据权限规则范围条件
	*/
	@RequestMapping(RuleConditionServiceProxy.UPDATE)
	Result update(RuleConditionVO ruleConditionVO);

	/**
	 * 更新数据权限规则范围条件
	*/
	@RequestMapping(RuleConditionServiceProxy.SAVE)
	Result save(RuleConditionVO ruleConditionVO);

	/**
	 * 获取数据权限规则范围条件
	*/
	@RequestMapping(RuleConditionServiceProxy.GET_BY_ID)
	Result<RuleCondition> getById(String id);

	/**
	 * 批量删除数据权限规则范围条件
	*/
	@RequestMapping(RuleConditionServiceProxy.GET_BY_IDS)
	Result<List<RuleCondition>> getByIds(List<String> ids);
	/**
	 * 查询数据权限规则范围条件
	*/
	@RequestMapping(RuleConditionServiceProxy.QUERY_LIST)
	Result<List<RuleCondition>> queryList(RuleConditionVO sample);

	/**
	 * 分页查询数据权限规则范围条件
	*/
	@RequestMapping(RuleConditionServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<RuleCondition>> queryPagedList(RuleConditionVO sample);

	/**
	 * 查询条件节点
	 * */
	@RequestMapping(RuleConditionServiceProxy.QUERY_NODES)
	Result<List<ZTreeNode>> queryNodes(RuleConditionVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.dataperm.controller.RuleConditionController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static RuleConditionServiceProxy api() {
		return APIProxy.get(RuleConditionServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}
