package org.github.foxnic.web.domain.storage.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.storage.File;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-16 14:19:39
 * @sign 87D295147A78F5F3CF92EFFDDF28E961
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FileMeta {
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 文件名 , 类型: java.lang.String
	*/
	public static final String FILE_NAME="fileName";
	
	/**
	 * 文件名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.String> FILE_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,FILE_NAME, java.lang.String.class, "文件名", "文件名", java.lang.String.class, null);
	
	/**
	 * 存储位置 , 类型: java.lang.String
	*/
	public static final String LOCATION="location";
	
	/**
	 * 存储位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.String> LOCATION_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,LOCATION, java.lang.String.class, "存储位置", "存储位置", java.lang.String.class, null);
	
	/**
	 * 文件大小 , 单位KB , 类型: java.lang.Long
	*/
	public static final String SIZE="size";
	
	/**
	 * 文件大小 , 单位KB , 类型: java.lang.Long
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.Long> SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,SIZE, java.lang.Long.class, "文件大小", "单位KB", java.lang.Long.class, null);
	
	/**
	 * 媒体类型 , 类型: java.lang.String
	*/
	public static final String MEDIA_TYPE="mediaType";
	
	/**
	 * 媒体类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.String> MEDIA_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,MEDIA_TYPE, java.lang.String.class, "媒体类型", "媒体类型", java.lang.String.class, null);
	
	/**
	 * 文件类型 , 存放文件扩展名 , 类型: java.lang.String
	*/
	public static final String FILE_TYPE="fileType";
	
	/**
	 * 文件类型 , 存放文件扩展名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.String> FILE_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,FILE_TYPE, java.lang.String.class, "文件类型", "存放文件扩展名", java.lang.String.class, null);
	
	/**
	 * 可直接下载的地址 , 类型: java.lang.String
	*/
	public static final String DOWNLOAD_URL="downloadUrl";
	
	/**
	 * 可直接下载的地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.String> DOWNLOAD_URL_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,DOWNLOAD_URL, java.lang.String.class, "可直接下载的地址", "可直接下载的地址", java.lang.String.class, null);
	
	/**
	 * 最后访问时间 , 类型: java.util.Date
	*/
	public static final String LATEST_VISIT_TIME="latestVisitTime";
	
	/**
	 * 最后访问时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.util.Date> LATEST_VISIT_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,LATEST_VISIT_TIME, java.util.Date.class, "最后访问时间", "最后访问时间", java.util.Date.class, null);
	
	/**
	 * 下载次数 , 类型: java.lang.Integer
	*/
	public static final String DOWNLOADS="downloads";
	
	/**
	 * 下载次数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.Integer> DOWNLOADS_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,DOWNLOADS, java.lang.Integer.class, "下载次数", "下载次数", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 是否存在与存储系统 , 类型: java.lang.Boolean
	*/
	public static final String EXISTS="exists";
	
	/**
	 * 是否存在与存储系统 , 类型: java.lang.Boolean
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.File,java.lang.Boolean> EXISTS_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.File.class ,EXISTS, java.lang.Boolean.class, "是否存在与存储系统", "", java.lang.Boolean.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , FILE_NAME , LOCATION , SIZE , MEDIA_TYPE , FILE_TYPE , DOWNLOAD_URL , LATEST_VISIT_TIME , DOWNLOADS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , EXISTS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.storage.File {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public File setId(String id) {
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
		 * 设置 媒体类型
		 * @param mediaType 媒体类型
		 * @return 当前对象
		*/
		public File setMediaType(String mediaType) {
			super.change(MEDIA_TYPE,super.getMediaType(),mediaType);
			super.setMediaType(mediaType);
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
		 * 设置 可直接下载的地址
		 * @param downloadUrl 可直接下载的地址
		 * @return 当前对象
		*/
		public File setDownloadUrl(String downloadUrl) {
			super.change(DOWNLOAD_URL,super.getDownloadUrl(),downloadUrl);
			super.setDownloadUrl(downloadUrl);
			return this;
		}
		
		/**
		 * 设置 最后访问时间
		 * @param latestVisitTime 最后访问时间
		 * @return 当前对象
		*/
		public File setLatestVisitTime(Date latestVisitTime) {
			super.change(LATEST_VISIT_TIME,super.getLatestVisitTime(),latestVisitTime);
			super.setLatestVisitTime(latestVisitTime);
			return this;
		}
		
		/**
		 * 设置 下载次数
		 * @param downloads 下载次数
		 * @return 当前对象
		*/
		public File setDownloads(Integer downloads) {
			super.change(DOWNLOADS,super.getDownloads(),downloads);
			super.setDownloads(downloads);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public File setCreateBy(String createBy) {
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
		public File setUpdateBy(String updateBy) {
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
		public File setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public File setDeleteBy(String deleteBy) {
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
		
		/**
		 * 设置 是否存在与存储系统
		 * @param exists 是否存在与存储系统
		 * @return 当前对象
		*/
		public File setExists(Boolean exists) {
			super.change(EXISTS,super.isExists(),exists);
			super.setExists(exists);
			return this;
		}
	}
}