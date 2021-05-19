package com.scientific.tailoring.domain.product.meta;

import com.scientific.tailoring.domain.product.ProductFabric;
import java.util.Date;
import com.scientific.tailoring.domain.product.VirtualLibrary;



/**
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign AF04F7DAE1D711B97A6CD17C94C2262B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProductFabricMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 商品ID
	*/
	public static final String PRODUCT_ID="productId";
	
	/**
	 * 标签ID
	*/
	public static final String FABRIC_ID="fabricId";
	
	/**
	 * 效果图 , 面料+商品的效果图
	*/
	public static final String EFFECT_ID="effectId";
	
	/**
	 * 虚拟试衣ID
	*/
	public static final String VIRTUAL_ID="virtualId";
	
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
	 * 虚拟试衣信息
	*/
	public static final String VIRTUAL="virtual";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PRODUCT_ID , FABRIC_ID , EFFECT_ID , VIRTUAL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , VIRTUAL };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.product.ProductFabric {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public ProductFabric setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 商品ID
		 * @param productId 商品ID
		 * @return 当前对象
		*/
		public ProductFabric setProductId(Long productId) {
			super.change(PRODUCT_ID,super.getProductId(),productId);
			super.setProductId(productId);
			return this;
		}
		
		/**
		 * 设置 标签ID
		 * @param fabricId 标签ID
		 * @return 当前对象
		*/
		public ProductFabric setFabricId(Integer fabricId) {
			super.change(FABRIC_ID,super.getFabricId(),fabricId);
			super.setFabricId(fabricId);
			return this;
		}
		
		/**
		 * 设置 效果图
		 * @param effectId 效果图
		 * @return 当前对象
		*/
		public ProductFabric setEffectId(Integer effectId) {
			super.change(EFFECT_ID,super.getEffectId(),effectId);
			super.setEffectId(effectId);
			return this;
		}
		
		/**
		 * 设置 虚拟试衣ID
		 * @param virtualId 虚拟试衣ID
		 * @return 当前对象
		*/
		public ProductFabric setVirtualId(Long virtualId) {
			super.change(VIRTUAL_ID,super.getVirtualId(),virtualId);
			super.setVirtualId(virtualId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ProductFabric setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ProductFabric setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ProductFabric setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ProductFabric setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ProductFabric setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ProductFabric setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ProductFabric setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ProductFabric setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 虚拟试衣信息
		 * @param virtual 虚拟试衣信息
		 * @return 当前对象
		*/
		public ProductFabric setVirtual(VirtualLibrary virtual) {
			super.change(VIRTUAL,super.getVirtual(),virtual);
			super.setVirtual(virtual);
			return this;
		}
}
}