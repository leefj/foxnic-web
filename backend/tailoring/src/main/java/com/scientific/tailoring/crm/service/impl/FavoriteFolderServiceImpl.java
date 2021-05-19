package com.scientific.tailoring.crm.service.impl;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import javax.annotation.Resource;

import com.scientific.tailoring.domain.crm.meta.FavoriteFolderMeta;
import com.scientific.tailoring.domain.crm.meta.FavoriteFolderModelMeta;
import com.scientific.tailoring.domain.crm.meta.FavoriteProductMeta;
import org.springframework.stereotype.Service;
import com.scientific.tailoring.domain.crm.FavoriteFolder;
import java.lang.reflect.Field;
import java.util.Map;

import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.constants.db.Tailoring.CRM_FAVORITE_PRODUCT;
import com.scientific.tailoring.crm.service.IFavoriteFolderService;

/**
 * <p>
 * 商品收藏分类表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:18
*/

@Service("CrmFavoriteFolderServiceImpl")
public class FavoriteFolderServiceImpl extends SuperService<FavoriteFolder> implements IFavoriteFolderService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 生成主键值
	 * */
	@Override
	public Object generateId(Field field) {
		return null;
	}
	
	/**
	 * 按主键删除商品收藏分类
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , FavoriteFolder对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		FavoriteFolder favoriteFolder = new FavoriteFolder();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		favoriteFolder.setId(id);
		return dao.deleteEntity(favoriteFolder);
	}
	
	/**
	 * 按主键删除商品收藏分类
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , FavoriteFolder对象
	 */
	public boolean deleteByIdLogical(Long id) {
		FavoriteFolder favoriteFolder = new FavoriteFolder();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		favoriteFolder.setId(id);
		favoriteFolder.setDeleted(true);
		return dao.updateEntity(favoriteFolder,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取商品收藏分类
	 *
	 * @param id ID
	 * @return 查询结果 , FavoriteFolder对象
	 */
	public FavoriteFolder getById(Long id) {
		FavoriteFolder sample = new FavoriteFolder();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public Map<Long, Integer> queryProductCountMap(Long userId) {
		RcdSet rs=dao.query("select folder_id,count(1) "+FavoriteFolderModelMeta.PRODUCT_COUNT+" from crm_favorite_product where user_id=? and deleted=0 group by folder_id",userId);
		return rs.getValueMap( CRM_FAVORITE_PRODUCT.FOLDER_ID,Long.class, FavoriteFolderModelMeta.PRODUCT_COUNT,Integer.class);
	}

}