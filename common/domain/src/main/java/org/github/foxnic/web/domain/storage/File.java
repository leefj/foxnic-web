package org.github.foxnic.web.domain.storage;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_FILE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-25 10:06:03
 * @sign E12FAE291AE7F958C17466DD808B16D4
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
	 * 文件类型：存放文件扩展名
	*/
	@ApiModelProperty(required = false,value="文件类型" , notes = "存放文件扩展名")
	private String fileType;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private Long createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private Long updateBy;
	
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
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private Long deleteBy;
	
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
	 * 获得 ID<br>
	 * 属性说明 : ID
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
	 * 添加 ID
	 * @param id ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 文件名<br>
	 * 属性说明 : 文件名
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
	 * 添加 文件名
	 * @param fileName 文件名
	 * @return 当前对象
	*/
	
	/**
	 * 获得 存储位置<br>
	 * 属性说明 : 存储位置
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
	 * 添加 存储位置
	 * @param location 存储位置
	 * @return 当前对象
	*/
	
	/**
	 * 获得 文件大小<br>
	 * 属性说明 : 单位KB
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
	 * 添加 文件大小
	 * @param size 文件大小
	 * @return 当前对象
	*/
	
	/**
	 * 获得 文件类型<br>
	 * 属性说明 : 存放文件扩展名
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
	 * 添加 文件类型
	 * @param fileType 文件类型
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建人ID<br>
	 * 属性说明 : 创建人ID
	 * @return 创建人ID
	*/
	public Long getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public File setCreateBy(Long createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 添加 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建时间<br>
	 * 属性说明 : 创建时间
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
	 * 添加 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改人ID<br>
	 * 属性说明 : 修改人ID
	 * @return 修改人ID
	*/
	public Long getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public File setUpdateBy(Long updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 添加 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改时间<br>
	 * 属性说明 : 修改时间
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
	 * 添加 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否已删除<br>
	 * 属性说明 : 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public File setDeleted(Integer deleted) {
		this.deleted=deleted;
		return this;
	}
	
	/**
	 * 添加 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	
	/**
	 * 获得 删除人ID<br>
	 * 属性说明 : 删除人ID
	 * @return 删除人ID
	*/
	public Long getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public File setDeleteBy(Long deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 添加 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 删除时间<br>
	 * 属性说明 : 删除时间
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
	 * 添加 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 数据版本号<br>
	 * 属性说明 : 数据版本号
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
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/

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
		return new File();
	}
}