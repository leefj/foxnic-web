package com.scientific.tailoring.domain.order.meta;

import com.scientific.tailoring.domain.order.MeasureFile;
import java.util.Date;



/**
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign E61E3AEB135C88D00491491CF9B34F11
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MeasureFileMeta {
	
	/**
	 * id
	*/
	public static final String ID="id";
	
	/**
	 * 订单测量ID
	*/
	public static final String MEASURE_ID="measureId";
	
	/**
	 * 文件ID
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 测量类型 , image/video/manual
	*/
	public static final String TYPE="type";
	
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
	 * 数据是否已经处理
	*/
	public static final String PROCESSED="processed";
	
	/**
	 * 处理时间
	*/
	public static final String PROCESS_TIME="processTime";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , MEASURE_ID , FILE_ID , TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PROCESSED , PROCESS_TIME };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.order.MeasureFile {
		
		/**
		 * 设置 id
		 * @param id id
		 * @return 当前对象
		*/
		public MeasureFile setId(Integer id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 订单测量ID
		 * @param measureId 订单测量ID
		 * @return 当前对象
		*/
		public MeasureFile setMeasureId(Long measureId) {
			super.change(MEASURE_ID,super.getMeasureId(),measureId);
			super.setMeasureId(measureId);
			return this;
		}
		
		/**
		 * 设置 文件ID
		 * @param fileId 文件ID
		 * @return 当前对象
		*/
		public MeasureFile setFileId(Long fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 测量类型
		 * @param type 测量类型
		 * @return 当前对象
		*/
		public MeasureFile setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MeasureFile setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MeasureFile setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MeasureFile setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MeasureFile setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MeasureFile setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MeasureFile setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MeasureFile setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public MeasureFile setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 数据是否已经处理
		 * @param processed 数据是否已经处理
		 * @return 当前对象
		*/
		public MeasureFile setProcessed(Integer processed) {
			super.change(PROCESSED,super.getProcessed(),processed);
			super.setProcessed(processed);
			return this;
		}
		
		/**
		 * 设置 处理时间
		 * @param processTime 处理时间
		 * @return 当前对象
		*/
		public MeasureFile setProcessTime(Date processTime) {
			super.change(PROCESS_TIME,super.getProcessTime(),processTime);
			super.setProcessTime(processTime);
			return this;
		}
}
}