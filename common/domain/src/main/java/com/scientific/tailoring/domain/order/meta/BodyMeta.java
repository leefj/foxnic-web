package com.scientific.tailoring.domain.order.meta;

import com.scientific.tailoring.domain.order.Body;
import java.util.Date;



/**
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign 385BCD139BB0EC6917F4888E07BD0388
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class BodyMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 订单ID
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 被测量人姓名
	*/
	public static final String BODY_NAME="bodyName";
	
	/**
	 * 被测量人部门
	*/
	public static final String BODY_DEPT="bodyDept";
	
	/**
	 * 被测量人性别
	*/
	public static final String BODY_SEX="bodySex";
	
	/**
	 * 被测量人身高 , 单位厘米cm
	*/
	public static final String BODY_HEIGHT="bodyHeight";
	
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
	public static final String[] $PROPS={ ID , ORDER_ID , BODY_NAME , BODY_DEPT , BODY_SEX , BODY_HEIGHT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.order.Body {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public Body setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 订单ID
		 * @param orderId 订单ID
		 * @return 当前对象
		*/
		public Body setOrderId(Long orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 被测量人姓名
		 * @param bodyName 被测量人姓名
		 * @return 当前对象
		*/
		public Body setBodyName(String bodyName) {
			super.change(BODY_NAME,super.getBodyName(),bodyName);
			super.setBodyName(bodyName);
			return this;
		}
		
		/**
		 * 设置 被测量人部门
		 * @param bodyDept 被测量人部门
		 * @return 当前对象
		*/
		public Body setBodyDept(String bodyDept) {
			super.change(BODY_DEPT,super.getBodyDept(),bodyDept);
			super.setBodyDept(bodyDept);
			return this;
		}
		
		/**
		 * 设置 被测量人性别
		 * @param bodySex 被测量人性别
		 * @return 当前对象
		*/
		public Body setBodySex(String bodySex) {
			super.change(BODY_SEX,super.getBodySex(),bodySex);
			super.setBodySex(bodySex);
			return this;
		}
		
		/**
		 * 设置 被测量人身高
		 * @param bodyHeight 被测量人身高
		 * @return 当前对象
		*/
		public Body setBodyHeight(Integer bodyHeight) {
			super.change(BODY_HEIGHT,super.getBodyHeight(),bodyHeight);
			super.setBodyHeight(bodyHeight);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Body setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Body setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Body setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Body setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Body setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Body setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Body setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Body setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
}
}