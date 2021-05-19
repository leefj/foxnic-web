package com.scientific.tailoring.domain.order.meta;

import com.scientific.tailoring.domain.order.MeasureFilesVO;
import com.scientific.tailoring.domain.order.MeasureFile;



/**
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign 77D618F67A7DF9CE22273F0BB1F0ED9E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MeasureFilesVOMeta {
	
	/**
	 * 测量ID
	*/
	public static final String MEASURE_ID="measureId";
	
	/**
	 * 文件清单
	*/
	public static final String MEASURE_FILES="measureFiles";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ MEASURE_ID , MEASURE_FILES };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.order.MeasureFilesVO {
		
		/**
		 * 设置 测量ID
		 * @param measureId 测量ID
		 * @return 当前对象
		*/
		public MeasureFilesVO setMeasureId(Long measureId) {
			super.change(MEASURE_ID,super.getMeasureId(),measureId);
			super.setMeasureId(measureId);
			return this;
		}
		
		/**
		 * 设置 文件清单
		 * @param measureFiles 文件清单
		 * @return 当前对象
		*/
		public MeasureFilesVO setMeasureFiles(MeasureFile measureFiles) {
			super.change(MEASURE_FILES,super.getMeasureFiles(),measureFiles);
			super.setMeasureFiles(measureFiles);
			return this;
		}
}
}