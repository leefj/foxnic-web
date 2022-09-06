package org.github.foxnic.web.domain.storage.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.storage.FileVO;
import java.util.List;
import org.github.foxnic.web.domain.storage.File;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:18:43
 * @sign F22F5F27BB2009D7E68DEC527FE71CCE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FileVOMeta extends FileMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 文件名 , 类型: java.lang.String
	*/
	public static final String FILE_NAME="fileName";
	
	/**
	 * 文件名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> FILE_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,FILE_NAME, java.lang.String.class, "文件名", "文件名", java.lang.String.class, null);
	
	/**
	 * 存储位置 , 类型: java.lang.String
	*/
	public static final String LOCATION="location";
	
	/**
	 * 存储位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> LOCATION_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,LOCATION, java.lang.String.class, "存储位置", "存储位置", java.lang.String.class, null);
	
	/**
	 * 文件大小 , 单位KB , 类型: java.lang.Long
	*/
	public static final String SIZE="size";
	
	/**
	 * 文件大小 , 单位KB , 类型: java.lang.Long
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.Long> SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,SIZE, java.lang.Long.class, "文件大小", "单位KB", java.lang.Long.class, null);
	
	/**
	 * 媒体类型 , 类型: java.lang.String
	*/
	public static final String MEDIA_TYPE="mediaType";
	
	/**
	 * 媒体类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> MEDIA_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,MEDIA_TYPE, java.lang.String.class, "媒体类型", "媒体类型", java.lang.String.class, null);
	
	/**
	 * 文件类型 , 存放文件扩展名 , 类型: java.lang.String
	*/
	public static final String FILE_TYPE="fileType";
	
	/**
	 * 文件类型 , 存放文件扩展名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> FILE_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,FILE_TYPE, java.lang.String.class, "文件类型", "存放文件扩展名", java.lang.String.class, null);
	
	/**
	 * 可直接下载的地址 , 类型: java.lang.String
	*/
	public static final String DOWNLOAD_URL="downloadUrl";
	
	/**
	 * 可直接下载的地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> DOWNLOAD_URL_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,DOWNLOAD_URL, java.lang.String.class, "可直接下载的地址", "可直接下载的地址", java.lang.String.class, null);
	
	/**
	 * 最后访问时间 , 类型: java.util.Date
	*/
	public static final String LATEST_VISIT_TIME="latestVisitTime";
	
	/**
	 * 最后访问时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.util.Date> LATEST_VISIT_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,LATEST_VISIT_TIME, java.util.Date.class, "最后访问时间", "最后访问时间", java.util.Date.class, null);
	
	/**
	 * 下载次数 , 类型: java.lang.Integer
	*/
	public static final String DOWNLOADS="downloads";
	
	/**
	 * 下载次数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.Integer> DOWNLOADS_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,DOWNLOADS, java.lang.Integer.class, "下载次数", "下载次数", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 是否存在与存储系统 , 类型: java.lang.Boolean
	*/
	public static final String EXISTS="exists";
	
	/**
	 * 是否存在与存储系统 , 类型: java.lang.Boolean
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.storage.FileVO,java.lang.Boolean> EXISTS_PROP = new BeanProperty(org.github.foxnic.web.domain.storage.FileVO.class ,EXISTS, java.lang.Boolean.class, "是否存在与存储系统", "", java.lang.Boolean.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , FILE_NAME , LOCATION , SIZE , MEDIA_TYPE , FILE_TYPE , DOWNLOAD_URL , LATEST_VISIT_TIME , DOWNLOADS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , EXISTS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.storage.FileVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public FileVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public FileVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public FileVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public FileVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public FileVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public FileVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public FileVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public FileVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public FileVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
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

		/**
		 * 克隆当前对象
		*/
		@Transient
		public FileVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public FileVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setFileName(this.getFileName());
			inst.setDownloadUrl(this.getDownloadUrl());
			inst.setMediaType(this.getMediaType());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setSize(this.getSize());
			inst.setDownloads(this.getDownloads());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setLocation(this.getLocation());
			inst.setId(this.getId());
			inst.setFileType(this.getFileType());
			inst.setLatestVisitTime(this.getLatestVisitTime());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setPageSize(this.getPageSize());
				inst.setIds(this.getIds());
				inst.setExists(this.isExists());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}