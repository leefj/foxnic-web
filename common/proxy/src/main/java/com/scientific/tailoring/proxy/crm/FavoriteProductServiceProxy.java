package com.scientific.tailoring.proxy.crm;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.crm.FavoriteProduct;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.domain.crm.FavoriteProductVO;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-21 04:56:38
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = FavoriteProductServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface FavoriteProductServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , crm-favorite-product
	*/
	public static final String API_CONTEXT_PATH = "crm-favorite-product";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加商品收藏
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除商品收藏
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新商品收藏
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取商品收藏
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的商品收藏
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 查询全部符合条件的商品收藏
	 */
	public static final String QUERY_LIST_4_APP = API_PREFIX + "query-list-app";
	
	/**
	 * 分页查询符合条件的商品收藏
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加商品收藏
	*/
	@RequestMapping(FavoriteProductServiceProxy.INSERT)
	Result<FavoriteProduct> insert(FavoriteProductVO favoriteProductVO);
	
	/**
	 * 按主键删除商品收藏
	*/
	@RequestMapping(FavoriteProductServiceProxy.DELETE)
	Result<FavoriteProduct> deleteById(Long id);
	
	/**
	 * 更新商品收藏
	*/
	@RequestMapping(FavoriteProductServiceProxy.UPDATE)
	Result<FavoriteProduct> update(FavoriteProductVO favoriteProductVO);
	
	/**
	 * 按主键获取商品收藏
	*/
	@RequestMapping(FavoriteProductServiceProxy.GET_BY_ID)
	Result<FavoriteProduct> getById(Long id);
	
	/**
	 * 查询全部符合条件的商品收藏
	*/
	@RequestMapping(FavoriteProductServiceProxy.QUERY_LIST)
	Result<List<FavoriteProduct>> queryList(FavoriteProductVO sample);
	
	/**
	 * 分页查询符合条件的商品收藏
	*/
	@RequestMapping(FavoriteProductServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<FavoriteProduct>> queryPagedList(FavoriteProductVO sample);

}