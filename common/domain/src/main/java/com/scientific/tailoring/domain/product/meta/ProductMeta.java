package com.scientific.tailoring.domain.product.meta;

import com.scientific.tailoring.domain.product.Product;
import java.util.Date;
import com.scientific.tailoring.domain.product.ProductImage;
import java.util.List;
import com.scientific.tailoring.domain.product.Fabric;
import com.scientific.tailoring.domain.product.Label;



/**
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign 5078240600574ABF86942D570EBC79A1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProductMeta {
	
	/**
	 * 商品编号
	*/
	public static final String ID="id";
	
	/**
	 * 商品名称
	*/
	public static final String NAME="name";
	
	/**
	 * 是否上架
	*/
	public static final String IS_ON_SHELF="isOnShelf";
	
	/**
	 * 商品详情
	*/
	public static final String DETAIL="detail";
	
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
	 * 商品图片清单
	*/
	public static final String IMAGES="images";
	
	/**
	 * 主图ID
	*/
	public static final String IMAGE_ID="imageId";
	
	/**
	 * 面料清单
	*/
	public static final String FABRICS="fabrics";
	
	/**
	 * 标签清单
	*/
	public static final String LABELS="labels";
	
	/**
	 * 是否收藏
	*/
	public static final String IS_FAVOR="isFavor";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , IS_ON_SHELF , DETAIL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , IMAGES , IMAGE_ID , FABRICS , LABELS , IS_FAVOR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.product.Product {
		
		/**
		 * 设置 商品编号
		 * @param id 商品编号
		 * @return 当前对象
		*/
		public Product setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 商品名称
		 * @param name 商品名称
		 * @return 当前对象
		*/
		public Product setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 是否上架
		 * @param isOnShelf 是否上架
		 * @return 当前对象
		*/
		public Product setOnShelf(Boolean isOnShelf) {
			super.change(IS_ON_SHELF,super.isOnShelf(),isOnShelf);
			super.setOnShelf(isOnShelf);
			return this;
		}
		
		/**
		 * 设置 商品详情
		 * @param detail 商品详情
		 * @return 当前对象
		*/
		public Product setDetail(String detail) {
			super.change(DETAIL,super.getDetail(),detail);
			super.setDetail(detail);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Product setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Product setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Product setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Product setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Product setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Product setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Product setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Product setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 商品图片清单
		 * @param images 商品图片清单
		 * @return 当前对象
		*/
		public Product setImages(List<ProductImage> images) {
			super.change(IMAGES,super.getImages(),images);
			super.setImages(images);
			return this;
		}
		
		/**
		 * 设置 主图ID
		 * @param imageId 主图ID
		 * @return 当前对象
		*/
		public Product setImageId(Long imageId) {
			super.change(IMAGE_ID,super.getImageId(),imageId);
			super.setImageId(imageId);
			return this;
		}
		
		/**
		 * 设置 面料清单
		 * @param fabrics 面料清单
		 * @return 当前对象
		*/
		public Product setFabrics(List<Fabric> fabrics) {
			super.change(FABRICS,super.getFabrics(),fabrics);
			super.setFabrics(fabrics);
			return this;
		}
		
		/**
		 * 设置 标签清单
		 * @param labels 标签清单
		 * @return 当前对象
		*/
		public Product setLabels(List<Label> labels) {
			super.change(LABELS,super.getLabels(),labels);
			super.setLabels(labels);
			return this;
		}
		
		/**
		 * 设置 是否收藏
		 * @param isFavor 是否收藏
		 * @return 当前对象
		*/
		public Product setFavor(Boolean isFavor) {
			super.change(IS_FAVOR,super.isFavor(),isFavor);
			super.setFavor(isFavor);
			return this;
		}
}
}