package org.github.foxnic.web.domain.storage.meta;

import org.github.foxnic.web.domain.storage.File;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-20 05:14:07
 * @sign 21CA848A3DFF76C74C350ACD468516A4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FileMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 文件名
	*/
	public static final String FILE_NAME="fileName";
	
	/**
	 * 存储位置
	*/
	public static final String LOCATION="location";
	
	/**
	 * 文件大小 , 单位KB
	*/
	public static final String SIZE="size";
	
	/**
	 * 文件类型 , 存放文件扩展名
	*/
	public static final String FILE_TYPE="fileType";
	
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
	public static final String[] $PROPS={ ID , FILE_NAME , LOCATION , SIZE , FILE_TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.storage.File {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public File setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 文件名
		 * @param fileName 文件名
		 * @return 当前对象
		*/
		public File setFileName(String fileName) {
			super.change(FILE_NAME,super.getFileName(),fileName);
			super.setFileName(fileName);
			return this;
		}
		
		/**
		 * 设置 存储位置
		 * @param location 存储位置
		 * @return 当前对象
		*/
		public File setLocation(String location) {
			super.change(LOCATION,super.getLocation(),location);
			super.setLocation(location);
			return this;
		}
		
		/**
		 * 设置 文件大小
		 * @param size 文件大小
		 * @return 当前对象
		*/
		public File setSize(Long size) {
			super.change(SIZE,super.getSize(),size);
			super.setSize(size);
			return this;
		}
		
		/**
		 * 设置 文件类型
		 * @param fileType 文件类型
		 * @return 当前对象
		*/
		public File setFileType(String fileType) {
			super.change(FILE_TYPE,super.getFileType(),fileType);
			super.setFileType(fileType);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public File setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public File setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public File setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public File setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public File setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public File setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public File setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public File setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
}
}