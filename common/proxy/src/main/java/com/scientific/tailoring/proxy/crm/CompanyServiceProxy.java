package com.scientific.tailoring.proxy.crm;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.scientific.tailoring.domain.crm.CompanyVO;
import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.crm.Company;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-25 08:57:36
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = CompanyServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface CompanyServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , crm-company
	*/
	public static final String API_CONTEXT_PATH = "crm-company";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加客户公司
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除客户公司
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新客户公司
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取客户公司
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的客户公司
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 查询全部符合条件的客户公司
	 */
	public static final String QUERY_LIST_FOR_SELECT = API_PREFIX + "query-list-for-select";
	
	/**
	 * 分页查询符合条件的客户公司
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加客户公司
	*/
	@RequestMapping(CompanyServiceProxy.INSERT)
	Result<Company> insert(CompanyVO companyVO);
	
	/**
	 * 按主键删除客户公司
	*/
	@RequestMapping(CompanyServiceProxy.DELETE)
	Result<Company> deleteById(Long id);
	
	/**
	 * 更新客户公司
	*/
	@RequestMapping(CompanyServiceProxy.UPDATE)
	Result<Company> update(CompanyVO companyVO);
	
	/**
	 * 按主键获取客户公司
	*/
	@RequestMapping(CompanyServiceProxy.GET_BY_ID)
	Result<Company> getById(Long id);
	
	/**
	 * 查询全部符合条件的客户公司
	*/
	@RequestMapping(CompanyServiceProxy.QUERY_LIST)
	Result<List<Company>> queryList(CompanyVO sample);
	
	/**
	 * 分页查询符合条件的客户公司
	*/
	@RequestMapping(CompanyServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Company>> queryPagedList(CompanyVO sample);

}