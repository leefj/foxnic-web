package com.scientific.tailoring.domain.product.meta;

import com.scientific.tailoring.domain.product.VirtualLibrary;
import java.util.Date;
import com.scientific.tailoring.domain.product.Product;
import com.scientific.tailoring.domain.product.Fabric;



/**
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign 691F9E0D3053CDF554A92EA638FF2C9C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class VirtualLibraryMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 商品ID
	*/
	public static final String PRODUCT_ID="productId";
	
	/**
	 * 面料ID
	*/
	public static final String FABRIC_ID="fabricId";
	
	/**
	 * 虚拟试衣效果图ID
	*/
	public static final String EFFECT_FILE_ID="effectFileId";
	
	/**
	 * 是否有效
	*/
	public static final String VALID="valid";
	
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
	 * 商品
	*/
	public static final String PRODUCT="product";
	
	/**
	 * 面料
	*/
	public static final String FABRIC="fabric";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PRODUCT_ID , FABRIC_ID , EFFECT_FILE_ID , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PRODUCT , FABRIC };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.product.VirtualLibrary {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public VirtualLibrary setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 商品ID
		 * @param productId 商品ID
		 * @return 当前对象
		*/
		public VirtualLibrary setProductId(Long productId) {
			super.change(PRODUCT_ID,super.getProductId(),productId);
			super.setProductId(productId);
			return this;
		}
		
		/**
		 * 设置 面料ID
		 * @param fabricId 面料ID
		 * @return 当前对象
		*/
		public VirtualLibrary setFabricId(Integer fabricId) {
			super.change(FABRIC_ID,super.getFabricId(),fabricId);
			super.setFabricId(fabricId);
			return this;
		}
		
		/**
		 * 设置 虚拟试衣效果图ID
		 * @param effectFileId 虚拟试衣效果图ID
		 * @return 当前对象
		*/
		public VirtualLibrary setEffectFileId(Long effectFileId) {
			super.change(EFFECT_FILE_ID,super.getEffectFileId(),effectFileId);
			super.setEffectFileId(effectFileId);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public VirtualLibrary setValid(Boolean valid) {
			super.change(VALID,super.isValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public VirtualLibrary setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public VirtualLibrary setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public VirtualLibrary setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public VirtualLibrary setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public VirtualLibrary setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public VirtualLibrary setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public VirtualLibrary setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public VirtualLibrary setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 商品
		 * @param product 商品
		 * @return 当前对象
		*/
		public VirtualLibrary setProduct(Product product) {
			super.change(PRODUCT,super.getProduct(),product);
			super.setProduct(product);
			return this;
		}
		
		/**
		 * 设置 面料
		 * @param fabric 面料
		 * @return 当前对象
		*/
		public VirtualLibrary setFabric(Fabric fabric) {
			super.change(FABRIC,super.getFabric(),fabric);
			super.setFabric(fabric);
			return this;
		}
}
}