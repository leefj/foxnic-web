package org.github.foxnic.web.proxy.dataperm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.dataperm.ExampleBrand;
import org.github.foxnic.web.domain.dataperm.ExampleBrandVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 商品品牌表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-02 14:49:27
*/

@FeignClient(value = MicroServiceNames.DATA_PERM, contextId = ExampleBrandServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ExampleBrandServiceProxy {

	/**
	 * 基础路径 , service-dataperm
	*/
	public static final String API_BASIC_PATH = "service-dataperm";

	/**
	 * API 上下文路径 , dp-example-brand
	*/
	public static final String API_CONTEXT_PATH = "dp-example-brand";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加商品品牌
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除商品品牌
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除商品品牌
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新商品品牌
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存商品品牌
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个商品品牌
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个商品品牌
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询商品品牌
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询商品品牌
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出商品品牌数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载商品品牌导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入商品品牌数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加商品品牌
	*/
	@RequestMapping(ExampleBrandServiceProxy.INSERT)
	Result insert(ExampleBrandVO exampleBrandVO);

	/**
	 * 删除商品品牌
	*/
	@RequestMapping(ExampleBrandServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除商品品牌
	*/
	@RequestMapping(ExampleBrandServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新商品品牌
	*/
	@RequestMapping(ExampleBrandServiceProxy.UPDATE)
	Result update(ExampleBrandVO exampleBrandVO);

	/**
	 * 更新商品品牌
	*/
	@RequestMapping(ExampleBrandServiceProxy.SAVE)
	Result save(ExampleBrandVO exampleBrandVO);

	/**
	 * 获取商品品牌
	*/
	@RequestMapping(ExampleBrandServiceProxy.GET_BY_ID)
	Result<ExampleBrand> getById(String id);

	/**
	 * 批量删除商品品牌
	*/
	@RequestMapping(ExampleBrandServiceProxy.GET_BY_IDS)
	Result<List<ExampleBrand>> getByIds(List<String> ids);
	/**
	 * 查询商品品牌
	*/
	@RequestMapping(ExampleBrandServiceProxy.QUERY_LIST)
	Result<List<ExampleBrand>> queryList(ExampleBrandVO sample);

	/**
	 * 分页查询商品品牌
	*/
	@RequestMapping(ExampleBrandServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<ExampleBrand>> queryPagedList(ExampleBrandVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.dataperm.controller.ExampleBrandController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ExampleBrandServiceProxy api() {
		return APIProxy.get(ExampleBrandServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}