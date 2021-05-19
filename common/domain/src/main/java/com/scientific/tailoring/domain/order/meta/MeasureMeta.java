package com.scientific.tailoring.domain.order.meta;

import com.scientific.tailoring.domain.order.Measure;
import java.util.Date;
import com.scientific.tailoring.domain.system.DictItem;



/**
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign 8A71DFA1C53E43FB4B5B813A60D1AB49
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MeasureMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 订单ID
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 被测量人员ID
	*/
	public static final String BODY_ID="bodyId";
	
	/**
	 * 测量方法
	*/
	public static final String METHOD="method";
	
	/**
	 * 测量状态
	*/
	public static final String STATUS="status";
	
	/**
	 * 视频效果 , 最终视频效果文件ID
	*/
	public static final String VIDEO_ID="videoId";
	
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
	 * 净体3D效果文件ID
	*/
	public static final String BODY_EFFECT_FILE_ID="bodyEffectFileId";
	
	/**
	 * 着装3D效果文件ID
	*/
	public static final String OUTFIT_EFFECT_FILE_ID="outfitEffectFileId";
	
	/**
	 * 状态信息
	*/
	public static final String STATUS_DICT_ITEM="statusDictItem";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ORDER_ID , BODY_ID , METHOD , STATUS , VIDEO_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , BODY_EFFECT_FILE_ID , OUTFIT_EFFECT_FILE_ID , STATUS_DICT_ITEM };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.order.Measure {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public Measure setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 订单ID
		 * @param orderId 订单ID
		 * @return 当前对象
		*/
		public Measure setOrderId(Long orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 被测量人员ID
		 * @param bodyId 被测量人员ID
		 * @return 当前对象
		*/
		public Measure setBodyId(Long bodyId) {
			super.change(BODY_ID,super.getBodyId(),bodyId);
			super.setBodyId(bodyId);
			return this;
		}
		
		/**
		 * 设置 测量方法
		 * @param method 测量方法
		 * @return 当前对象
		*/
		public Measure setMethod(String method) {
			super.change(METHOD,super.getMethod(),method);
			super.setMethod(method);
			return this;
		}
		
		/**
		 * 设置 测量状态
		 * @param status 测量状态
		 * @return 当前对象
		*/
		public Measure setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 视频效果
		 * @param videoId 视频效果
		 * @return 当前对象
		*/
		public Measure setVideoId(Long videoId) {
			super.change(VIDEO_ID,super.getVideoId(),videoId);
			super.setVideoId(videoId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Measure setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Measure setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Measure setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Measure setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Measure setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Measure setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Measure setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Measure setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 净体3D效果文件ID
		 * @param bodyEffectFileId 净体3D效果文件ID
		 * @return 当前对象
		*/
		public Measure setBodyEffectFileId(Long bodyEffectFileId) {
			super.change(BODY_EFFECT_FILE_ID,super.getBodyEffectFileId(),bodyEffectFileId);
			super.setBodyEffectFileId(bodyEffectFileId);
			return this;
		}
		
		/**
		 * 设置 着装3D效果文件ID
		 * @param outfitEffectFileId 着装3D效果文件ID
		 * @return 当前对象
		*/
		public Measure setOutfitEffectFileId(Long outfitEffectFileId) {
			super.change(OUTFIT_EFFECT_FILE_ID,super.getOutfitEffectFileId(),outfitEffectFileId);
			super.setOutfitEffectFileId(outfitEffectFileId);
			return this;
		}
		
		/**
		 * 设置 状态信息
		 * @param statusDictItem 状态信息
		 * @return 当前对象
		*/
		public Measure setStatusDictItem(DictItem statusDictItem) {
			super.change(STATUS_DICT_ITEM,super.getStatusDictItem(),statusDictItem);
			super.setStatusDictItem(statusDictItem);
			return this;
		}
}
}