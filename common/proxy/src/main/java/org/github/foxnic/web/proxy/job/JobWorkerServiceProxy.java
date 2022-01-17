package org.github.foxnic.web.proxy.job;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.job.JobWorker;
import org.github.foxnic.web.domain.job.JobWorkerVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 任务执行器  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-07 12:00:15
*/

@FeignClient(value = MicroServiceNames.JOB, contextId = JobWorkerServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface JobWorkerServiceProxy {

	/**
	 * 基础路径 , service-job
	*/
	public static final String API_BASIC_PATH = "service-job";

	/**
	 * API 上下文路径 , sys-job-worker
	*/
	public static final String API_CONTEXT_PATH = "sys-job-worker";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加任务执行器
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除任务执行器
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除任务执行器
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新任务执行器
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存任务执行器
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个任务执行器
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个任务执行器
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询任务执行器
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询任务执行器
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出任务执行器数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载任务执行器导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入任务执行器数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加任务执行器
	*/
	@RequestMapping(JobWorkerServiceProxy.INSERT)
	Result insert(JobWorkerVO jobWorkerVO);

	/**
	 * 删除任务执行器
	*/
	@RequestMapping(JobWorkerServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除任务执行器
	*/
	@RequestMapping(JobWorkerServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新任务执行器
	*/
	@RequestMapping(JobWorkerServiceProxy.UPDATE)
	Result update(JobWorkerVO jobWorkerVO);

	/**
	 * 更新任务执行器
	*/
	@RequestMapping(JobWorkerServiceProxy.SAVE)
	Result save(JobWorkerVO jobWorkerVO);

	/**
	 * 获取任务执行器
	*/
	@RequestMapping(JobWorkerServiceProxy.GET_BY_ID)
	Result<JobWorker> getById(String id);

	/**
	 * 获取多个任务执行器
	*/
	@RequestMapping(JobWorkerServiceProxy.GET_BY_IDS)
	Result<List<JobWorker>> getByIds(List<String> ids);
	/**
	 * 查询任务执行器
	*/
	@RequestMapping(JobWorkerServiceProxy.QUERY_LIST)
	Result<List<JobWorker>> queryList(JobWorkerVO sample);

	/**
	 * 分页查询任务执行器
	*/
	@RequestMapping(JobWorkerServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<JobWorker>> queryPagedList(JobWorkerVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.job.controller.JobWorkerController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static JobWorkerServiceProxy api() {
		return APIProxy.get(JobWorkerServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}