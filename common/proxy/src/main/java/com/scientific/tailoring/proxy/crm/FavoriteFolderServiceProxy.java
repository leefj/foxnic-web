package com.scientific.tailoring.proxy.crm;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.crm.FavoriteFolderVO;
import com.scientific.tailoring.domain.crm.FavoriteFolder;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-20 03:28:27
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = FavoriteFolderServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface FavoriteFolderServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , crm-favorite-folder
	*/
	public static final String API_CONTEXT_PATH = "crm-favorite-folder";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加商品收藏分类
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除商品收藏分类
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	/**
	 * 更新商品收藏分类
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取商品收藏分类
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 查询全部符合条件的商品收藏分类
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的商品收藏分类
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加商品收藏分类
	*/
	@RequestMapping(FavoriteFolderServiceProxy.INSERT)
	Result<FavoriteFolder> insert(FavoriteFolderVO favoriteFolderVO);
	
	/**
	 * 按主键删除商品收藏分类
	*/
	@RequestMapping(FavoriteFolderServiceProxy.DELETE)
	Result<FavoriteFolder> deleteById(Long id);
	
	/**
	 * 更新商品收藏分类
	*/
	@RequestMapping(FavoriteFolderServiceProxy.UPDATE)
	Result<FavoriteFolder> update(FavoriteFolderVO favoriteFolderVO);
	
	/**
	 * 按主键获取商品收藏分类
	*/
	@RequestMapping(FavoriteFolderServiceProxy.GET_BY_ID)
	Result<FavoriteFolder> getById(Long id);
	
	/**
	 * 查询全部符合条件的商品收藏分类
	*/
	@RequestMapping(FavoriteFolderServiceProxy.QUERY_LIST)
	Result<List<FavoriteFolder>> queryList(FavoriteFolderVO sample);
	
	/**
	 * 分页查询符合条件的商品收藏分类
	*/
	@RequestMapping(FavoriteFolderServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<FavoriteFolder>> queryPagedList(FavoriteFolderVO sample);

}