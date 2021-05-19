package com.scientific.tailoring.proxy.system;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.domain.system.LangVO;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.system.Lang;

/**
 * @author 李方捷
 * @since 2021-03-31 09:59:55
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = LangServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface LangServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , sys-lang
	*/
	public static final String API_CONTEXT_PATH = "sys-lang";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加语言条目
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除语言条目
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	/**
	 * 更新语言条目
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取语言条目
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的语言条目
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的语言条目
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 检查 语言条目 是否已经存在
	 */
	public static final String CHECK_EXISTS = API_PREFIX + "check-exists";
	
	/**
	 * 添加语言条目
	*/
	@RequestMapping(LangServiceProxy.INSERT)
	Result<Lang> insert(LangVO langVO);
	
	/**
	 * 按主键删除语言条目
	*/
	@RequestMapping(LangServiceProxy.DELETE)
	Result<Lang> deleteById(String key);
	
	/**
	 * 更新语言条目
	*/
	@RequestMapping(LangServiceProxy.UPDATE)
	Result<Lang> update(LangVO langVO);
	
	/**
	 * 按主键获取语言条目
	*/
	@RequestMapping(LangServiceProxy.GET_BY_ID)
	Result<Lang> getById(String key);
	
	/**
	 * 查询全部符合条件的语言条目
	*/
	@RequestMapping(LangServiceProxy.QUERY_LIST)
	Result<List<Lang>> queryList(LangVO sample);
	
	/**
	 * 分页查询符合条件的语言条目
	*/
	@RequestMapping(LangServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Lang>> queryPagedList(LangVO sample);

}