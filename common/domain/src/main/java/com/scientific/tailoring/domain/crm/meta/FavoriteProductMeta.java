package com.scientific.tailoring.domain.crm.meta;

import com.scientific.tailoring.domain.crm.FavoriteProduct;
import java.util.Date;



/**
 * @author 李方捷
 * @since 2021-05-17 01:13:38
 * @sign 5E643C8B6A4CBEB4F7F6DE71396B7B5A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FavoriteProductMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 用户ID
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 商品ID
	*/
	public static final String PRODUCT_ID="productId";
	
	/**
	 * 材料ID
	*/
	public static final String FABRIC_ID="fabricId";
	
	/**
	 * 目录ID
	*/
	public static final String FOLDER_ID="folderId";
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 数据版本号
	*/
	public static final String VERSION="version";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , USER_ID , PRODUCT_ID , FABRIC_ID , FOLDER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.crm.FavoriteProduct {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public FavoriteProduct setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 用户ID
		 * @param userId 用户ID
		 * @return 当前对象
		*/
		public FavoriteProduct setUserId(Long userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 商品ID
		 * @param productId 商品ID
		 * @return 当前对象
		*/
		public FavoriteProduct setProductId(Long productId) {
			super.change(PRODUCT_ID,super.getProductId(),productId);
			super.setProductId(productId);
			return this;
		}
		
		/**
		 * 设置 材料ID
		 * @param fabricId 材料ID
		 * @return 当前对象
		*/
		public FavoriteProduct setFabricId(Long fabricId) {
			super.change(FABRIC_ID,super.getFabricId(),fabricId);
			super.setFabricId(fabricId);
			return this;
		}
		
		/**
		 * 设置 目录ID
		 * @param folderId 目录ID
		 * @return 当前对象
		*/
		public FavoriteProduct setFolderId(Long folderId) {
			super.change(FOLDER_ID,super.getFolderId(),folderId);
			super.setFolderId(folderId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public FavoriteProduct setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public FavoriteProduct setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public FavoriteProduct setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public FavoriteProduct setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public FavoriteProduct setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public FavoriteProduct setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public FavoriteProduct setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public FavoriteProduct setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
}
}