package org.github.foxnic.web.domain.storage;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_FILE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 系统文件
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:18:43
 * @sign 4187DD794E7BA4CB4DCB50CF5712D9D5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_file")
public class File extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_FILE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private String id;
	
	/**
	 * 文件名：文件名
	*/
	@ApiModelProperty(required = false,value="文件名" , notes = "文件名")
	private String fileName;
	
	/**
	 * 存储位置：存储位置
	*/
	@ApiModelProperty(required = false,value="存储位置" , notes = "存储位置")
	private String location;
	
	/**
	 * 文件大小：单位KB
	*/
	@ApiModelProperty(required = false,value="文件大小" , notes = "单位KB")
	private Long size;
	
	/**
	 * 媒体类型：媒体类型
	*/
	@ApiModelProperty(required = false,value="媒体类型" , notes = "媒体类型")
	private String mediaType;
	
	/**
	 * 文件类型：存放文件扩展名
	*/
	@ApiModelProperty(required = false,value="文件类型" , notes = "存放文件扩展名")
	private String fileType;
	
	/**
	 * 可直接下载的地址：可直接下载的地址
	*/
	@ApiModelProperty(required = false,value="可直接下载的地址" , notes = "可直接下载的地址")
	private String downloadUrl;
	
	/**
	 * 最后访问时间：最后访问时间
	*/
	@ApiModelProperty(required = false,value="最后访问时间" , notes = "最后访问时间")
	private Date latestVisitTime;
	
	/**
	 * 下载次数：下载次数
	*/
	@ApiModelProperty(required = true,value="下载次数" , notes = "下载次数")
	private Integer downloads;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 是否存在与存储系统
	*/
	@ApiModelProperty(required = false,value="是否存在与存储系统" , notes = "")
	private Boolean exists;
	
	/**
	 * 获得 ID<br>
	 * ID
	 * @return ID
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public File setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 文件名<br>
	 * 文件名
	 * @return 文件名
	*/
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * 设置 文件名
	 * @param fileName 文件名
	 * @return 当前对象
	*/
	public File setFileName(String fileName) {
		this.fileName=fileName;
		return this;
	}
	
	/**
	 * 获得 存储位置<br>
	 * 存储位置
	 * @return 存储位置
	*/
	public String getLocation() {
		return location;
	}
	
	/**
	 * 设置 存储位置
	 * @param location 存储位置
	 * @return 当前对象
	*/
	public File setLocation(String location) {
		this.location=location;
		return this;
	}
	
	/**
	 * 获得 文件大小<br>
	 * 单位KB
	 * @return 文件大小
	*/
	public Long getSize() {
		return size;
	}
	
	/**
	 * 设置 文件大小
	 * @param size 文件大小
	 * @return 当前对象
	*/
	public File setSize(Long size) {
		this.size=size;
		return this;
	}
	
	/**
	 * 获得 媒体类型<br>
	 * 媒体类型
	 * @return 媒体类型
	*/
	public String getMediaType() {
		return mediaType;
	}
	
	/**
	 * 设置 媒体类型
	 * @param mediaType 媒体类型
	 * @return 当前对象
	*/
	public File setMediaType(String mediaType) {
		this.mediaType=mediaType;
		return this;
	}
	
	/**
	 * 获得 文件类型<br>
	 * 存放文件扩展名
	 * @return 文件类型
	*/
	public String getFileType() {
		return fileType;
	}
	
	/**
	 * 设置 文件类型
	 * @param fileType 文件类型
	 * @return 当前对象
	*/
	public File setFileType(String fileType) {
		this.fileType=fileType;
		return this;
	}
	
	/**
	 * 获得 可直接下载的地址<br>
	 * 可直接下载的地址
	 * @return 可直接下载的地址
	*/
	public String getDownloadUrl() {
		return downloadUrl;
	}
	
	/**
	 * 设置 可直接下载的地址
	 * @param downloadUrl 可直接下载的地址
	 * @return 当前对象
	*/
	public File setDownloadUrl(String downloadUrl) {
		this.downloadUrl=downloadUrl;
		return this;
	}
	
	/**
	 * 获得 最后访问时间<br>
	 * 最后访问时间
	 * @return 最后访问时间
	*/
	public Date getLatestVisitTime() {
		return latestVisitTime;
	}
	
	/**
	 * 设置 最后访问时间
	 * @param latestVisitTime 最后访问时间
	 * @return 当前对象
	*/
	public File setLatestVisitTime(Date latestVisitTime) {
		this.latestVisitTime=latestVisitTime;
		return this;
	}
	
	/**
	 * 获得 下载次数<br>
	 * 下载次数
	 * @return 下载次数
	*/
	public Integer getDownloads() {
		return downloads;
	}
	
	/**
	 * 设置 下载次数
	 * @param downloads 下载次数
	 * @return 当前对象
	*/
	public File setDownloads(Integer downloads) {
		this.downloads=downloads;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public File setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public File setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public File setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public File setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public File setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public File setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public File setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public File setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public File setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 是否存在与存储系统<br>
	 * @return 是否存在与存储系统
	*/
	public Boolean isExists() {
		return exists;
	}
	
	/**
	 * 获得 是否存在与存储系统<br>
	 * 等价于 isExists 方法，为兼容 Swagger 需要
	 * @return 是否存在与存储系统
	*/
	public Boolean getExists() {
		return this.exists;
	}
	
	/**
	 * 设置 是否存在与存储系统
	 * @param exists 是否存在与存储系统
	 * @return 当前对象
	*/
	public File setExists(Boolean exists) {
		this.exists=exists;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return File , 转换好的 File 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return File , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public File clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public File duplicate(boolean all) {
		org.github.foxnic.web.domain.storage.meta.FileMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.storage.meta.FileMeta.$$proxy$$();
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
			inst.setExists(this.isExists());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public File clone(boolean deep) {
		return EntityContext.clone(File.class,this,deep);
	}

	/**
	 * 将 Map 转换成 File
	 * @param fileMap 包含实体信息的 Map 对象
	 * @return File , 转换好的的 File 对象
	*/
	@Transient
	public static File createFrom(Map<String,Object> fileMap) {
		if(fileMap==null) return null;
		File po = EntityContext.create(File.class, fileMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 File
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return File , 转换好的的 File 对象
	*/
	@Transient
	public static File createFrom(Object pojo) {
		if(pojo==null) return null;
		File po = EntityContext.create(File.class,pojo);
		return po;
	}

	/**
	 * 创建一个 File，等同于 new
	 * @return File 对象
	*/
	@Transient
	public static File create() {
		return EntityContext.create(File.class);
	}
}