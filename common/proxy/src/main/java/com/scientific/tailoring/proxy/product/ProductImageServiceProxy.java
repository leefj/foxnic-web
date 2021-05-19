package com.scientific.tailoring.proxy.product;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.product.ProductImageVO;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.product.ProductImage;

/**
 * @author 李方捷
 * @since 2021-03-22 10:54:31
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = ProductImageServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface ProductImageServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , prd-product-image
	*/
	public static final String API_CONTEXT_PATH = "prd-product-image";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加商品图片
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除商品图片
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新商品图片
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取商品图片
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的商品图片
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的商品图片
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加商品图片
	*/
	@RequestMapping(ProductImageServiceProxy.INSERT)
	Result<ProductImage> insert(ProductImageVO productImageVO);
	
	/**
	 * 按主键删除商品图片
	*/
	@RequestMapping(ProductImageServiceProxy.DELETE)
	Result<ProductImage> deleteById(Long id);
	
	/**
	 * 更新商品图片
	*/
	@RequestMapping(ProductImageServiceProxy.UPDATE)
	Result<ProductImage> update(ProductImageVO productImageVO);
	
	/**
	 * 按主键获取商品图片
	*/
	@RequestMapping(ProductImageServiceProxy.GET_BY_ID)
	Result<ProductImage> getById(Long id);
	
	/**
	 * 查询全部符合条件的商品图片
	*/
	@RequestMapping(ProductImageServiceProxy.QUERY_LIST)
	Result<List<ProductImage>> queryList(ProductImageVO sample);
	
	/**
	 * 分页查询符合条件的商品图片
	*/
	@RequestMapping(ProductImageServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<ProductImage>> queryPagedList(ProductImageVO sample);

}