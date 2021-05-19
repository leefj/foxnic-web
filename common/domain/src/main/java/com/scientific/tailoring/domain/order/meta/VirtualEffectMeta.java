package com.scientific.tailoring.domain.order.meta;

import com.scientific.tailoring.domain.order.VirtualEffect;
import java.util.Date;



/**
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign 8028BDEF243035F0B8DB7B558AB98FD8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class VirtualEffectMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 订单ID
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 测量ID
	*/
	public static final String MEASURE_ID="measureId";
	
	/**
	 * 商品ID
	*/
	public static final String PRODUCT_ID="productId";
	
	/**
	 * 视频地址
	*/
	public static final String VIDEO_LOCATION="videoLocation";
	
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
	public static final String[] $PROPS={ ID , ORDER_ID , MEASURE_ID , PRODUCT_ID , VIDEO_LOCATION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.order.VirtualEffect {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public VirtualEffect setId(Integer id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 订单ID
		 * @param orderId 订单ID
		 * @return 当前对象
		*/
		public VirtualEffect setOrderId(Integer orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 测量ID
		 * @param measureId 测量ID
		 * @return 当前对象
		*/
		public VirtualEffect setMeasureId(Integer measureId) {
			super.change(MEASURE_ID,super.getMeasureId(),measureId);
			super.setMeasureId(measureId);
			return this;
		}
		
		/**
		 * 设置 商品ID
		 * @param productId 商品ID
		 * @return 当前对象
		*/
		public VirtualEffect setProductId(Integer productId) {
			super.change(PRODUCT_ID,super.getProductId(),productId);
			super.setProductId(productId);
			return this;
		}
		
		/**
		 * 设置 视频地址
		 * @param videoLocation 视频地址
		 * @return 当前对象
		*/
		public VirtualEffect setVideoLocation(String videoLocation) {
			super.change(VIDEO_LOCATION,super.getVideoLocation(),videoLocation);
			super.setVideoLocation(videoLocation);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public VirtualEffect setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public VirtualEffect setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public VirtualEffect setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public VirtualEffect setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public VirtualEffect setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public VirtualEffect setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public VirtualEffect setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public VirtualEffect setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
}
}