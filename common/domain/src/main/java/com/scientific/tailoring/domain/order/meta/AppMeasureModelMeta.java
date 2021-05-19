package com.scientific.tailoring.domain.order.meta;

import com.scientific.tailoring.domain.order.AppMeasureModel;



/**
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign E78FEE27E0807C1C620916D22AE56796
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AppMeasureModelMeta {
	
	/**
	 * 性别(描述)
	*/
	public static final String BODY_SEX_LABEL="bodySexLabel";
	
	/**
	 * body表的ID字段
	*/
	public static final String BID="bid";
	
	/**
	 * 状态标签
	*/
	public static final String STATUS_LABEL="statusLabel";
	
	/**
	 * 姓名
	*/
	public static final String BODY_NAME="bodyName";
	
	/**
	 * 部门
	*/
	public static final String BODY_DEPT="bodyDept";
	
	/**
	 * 性别
	*/
	public static final String BODY_SEX="bodySex";
	
	/**
	 * 身高
	*/
	public static final String BODY_HEIGHT="bodyHeight";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ BODY_SEX_LABEL , BID , STATUS_LABEL , BODY_NAME , BODY_DEPT , BODY_SEX , BODY_HEIGHT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.order.AppMeasureModel {
		
		/**
		 * 设置 性别(描述)
		 * @param bodySexLabel 性别(描述)
		 * @return 当前对象
		*/
		public AppMeasureModel setBodySexLabel(String bodySexLabel) {
			super.change(BODY_SEX_LABEL,super.getBodySexLabel(),bodySexLabel);
			super.setBodySexLabel(bodySexLabel);
			return this;
		}
		
		/**
		 * 设置 body表的ID字段
		 * @param bid body表的ID字段
		 * @return 当前对象
		*/
		public AppMeasureModel setBid(Long bid) {
			super.change(BID,super.getBid(),bid);
			super.setBid(bid);
			return this;
		}
		
		/**
		 * 设置 状态标签
		 * @param statusLabel 状态标签
		 * @return 当前对象
		*/
		public AppMeasureModel setStatusLabel(String statusLabel) {
			super.change(STATUS_LABEL,super.getStatusLabel(),statusLabel);
			super.setStatusLabel(statusLabel);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param bodyName 姓名
		 * @return 当前对象
		*/
		public AppMeasureModel setBodyName(String bodyName) {
			super.change(BODY_NAME,super.getBodyName(),bodyName);
			super.setBodyName(bodyName);
			return this;
		}
		
		/**
		 * 设置 部门
		 * @param bodyDept 部门
		 * @return 当前对象
		*/
		public AppMeasureModel setBodyDept(String bodyDept) {
			super.change(BODY_DEPT,super.getBodyDept(),bodyDept);
			super.setBodyDept(bodyDept);
			return this;
		}
		
		/**
		 * 设置 性别
		 * @param bodySex 性别
		 * @return 当前对象
		*/
		public AppMeasureModel setBodySex(String bodySex) {
			super.change(BODY_SEX,super.getBodySex(),bodySex);
			super.setBodySex(bodySex);
			return this;
		}
		
		/**
		 * 设置 身高
		 * @param bodyHeight 身高
		 * @return 当前对象
		*/
		public AppMeasureModel setBodyHeight(Integer bodyHeight) {
			super.change(BODY_HEIGHT,super.getBodyHeight(),bodyHeight);
			super.setBodyHeight(bodyHeight);
			return this;
		}
}
}