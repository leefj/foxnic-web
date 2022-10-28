package org.github.foxnic.web.domain.storage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;
import org.github.foxnic.web.domain.storage.meta.FileVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 系统文件VO类型
 * <p>系统文件 , 数据表 sys_file 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:43:10
 * @sign F22F5F27BB2009D7E68DEC527FE71CCE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "系统文件VO类型 ; 系统文件 , 数据表 sys_file 的通用VO类型" , parent = File.class)
public class FileVO extends File {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页码
	*/
	@ApiModelProperty(required = false,value="页码" , notes = "")
	private Integer pageIndex;
	
	/**
	 * 分页大小
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "")
	private Integer pageSize;
	
	/**
	 * 搜索字段
	*/
	@ApiModelProperty(required = false,value="搜索字段" , notes = "")
	private String searchField;
	
	/**
	 * 模糊搜索字段
	*/
	@ApiModelProperty(required = false,value="模糊搜索字段" , notes = "")
	private String fuzzyField;
	
	/**
	 * 搜索的值
	*/
	@ApiModelProperty(required = false,value="搜索的值" , notes = "")
	private String searchValue;
	
	/**
	 * 已修改字段
	*/
	@ApiModelProperty(required = false,value="已修改字段" , notes = "")
	private List<String> dirtyFields;
	
	/**
	 * 排序字段
	*/
	@ApiModelProperty(required = false,value="排序字段" , notes = "")
	private String sortField;
	
	/**
	 * 排序方式
	*/
	@ApiModelProperty(required = false,value="排序方式" , notes = "")
	private String sortType;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 获得 页码<br>
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public FileVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public FileVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 搜索字段<br>
	 * @return 搜索字段
	*/
	public String getSearchField() {
		return searchField;
	}
	
	/**
	 * 设置 搜索字段
	 * @param searchField 搜索字段
	 * @return 当前对象
	*/
	public FileVO setSearchField(String searchField) {
		this.searchField=searchField;
		return this;
	}
	
	/**
	 * 获得 模糊搜索字段<br>
	 * @return 模糊搜索字段
	*/
	public String getFuzzyField() {
		return fuzzyField;
	}
	
	/**
	 * 设置 模糊搜索字段
	 * @param fuzzyField 模糊搜索字段
	 * @return 当前对象
	*/
	public FileVO setFuzzyField(String fuzzyField) {
		this.fuzzyField=fuzzyField;
		return this;
	}
	
	/**
	 * 获得 搜索的值<br>
	 * @return 搜索的值
	*/
	public String getSearchValue() {
		return searchValue;
	}
	
	/**
	 * 设置 搜索的值
	 * @param searchValue 搜索的值
	 * @return 当前对象
	*/
	public FileVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
	/**
	 * 获得 已修改字段<br>
	 * @return 已修改字段
	*/
	public List<String> getDirtyFields() {
		return dirtyFields;
	}
	
	/**
	 * 设置 已修改字段
	 * @param dirtyFields 已修改字段
	 * @return 当前对象
	*/
	public FileVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public FileVO addDirtyField(String... dirtyField) {
		if(this.dirtyFields==null) dirtyFields=new ArrayList<>();
		this.dirtyFields.addAll(Arrays.asList(dirtyField));
		return this;
	}
	
	/**
	 * 获得 排序字段<br>
	 * @return 排序字段
	*/
	public String getSortField() {
		return sortField;
	}
	
	/**
	 * 设置 排序字段
	 * @param sortField 排序字段
	 * @return 当前对象
	*/
	public FileVO setSortField(String sortField) {
		this.sortField=sortField;
		return this;
	}
	
	/**
	 * 获得 排序方式<br>
	 * @return 排序方式
	*/
	public String getSortType() {
		return sortType;
	}
	
	/**
	 * 设置 排序方式
	 * @param sortType 排序方式
	 * @return 当前对象
	*/
	public FileVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public FileVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public FileVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	@Transient
	private transient CompositeParameter $compositeParameter;
	/**
	 * 获得解析后的复合查询参数
	 */
	@Transient
	public CompositeParameter getCompositeParameter() {
		if($compositeParameter!=null) return  $compositeParameter;
		$compositeParameter=new CompositeParameter(this.getSearchValue(),BeanUtil.toMap(this));
		return  $compositeParameter;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return FileVO , 转换好的 FileVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FileVO , 转换好的 PoJo 对象
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
	public FileVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public FileVO duplicate(boolean all) {
		org.github.foxnic.web.domain.storage.meta.FileVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.storage.meta.FileVOMeta.$$proxy$$();
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
			inst.setExists(this.isExists());
			inst.setPageSize(this.getPageSize());
			inst.setIds(this.getIds());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public FileVO clone(boolean deep) {
		return EntityContext.clone(FileVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 FileVO
	 * @param fileMap 包含实体信息的 Map 对象
	 * @return FileVO , 转换好的的 File 对象
	*/
	@Transient
	public static FileVO createFrom(Map<String,Object> fileMap) {
		if(fileMap==null) return null;
		FileVO vo = create();
		EntityContext.copyProperties(vo,fileMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 FileVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FileVO , 转换好的的 File 对象
	*/
	@Transient
	public static FileVO createFrom(Object pojo) {
		if(pojo==null) return null;
		FileVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 FileVO，等同于 new
	 * @return FileVO 对象
	*/
	@Transient
	public static FileVO create() {
		return new org.github.foxnic.web.domain.storage.meta.FileVOMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setFileName(DataParser.parse(String.class, map.get(FileVOMeta.FILE_NAME)));
			this.setDownloadUrl(DataParser.parse(String.class, map.get(FileVOMeta.DOWNLOAD_URL)));
			this.setMediaType(DataParser.parse(String.class, map.get(FileVOMeta.MEDIA_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(FileVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(FileVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(FileVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(FileVOMeta.DELETED)));
			this.setSize(DataParser.parse(Long.class, map.get(FileVOMeta.SIZE)));
			this.setDownloads(DataParser.parse(Integer.class, map.get(FileVOMeta.DOWNLOADS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(FileVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(FileVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(FileVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(FileVOMeta.DELETE_BY)));
			this.setLocation(DataParser.parse(String.class, map.get(FileVOMeta.LOCATION)));
			this.setId(DataParser.parse(String.class, map.get(FileVOMeta.ID)));
			this.setFileType(DataParser.parse(String.class, map.get(FileVOMeta.FILE_TYPE)));
			this.setLatestVisitTime(DataParser.parse(Date.class, map.get(FileVOMeta.LATEST_VISIT_TIME)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(FileVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(FileVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(FileVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(FileVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(FileVOMeta.SORT_FIELD)));
			this.setExists(DataParser.parse(Boolean.class, map.get(FileVOMeta.EXISTS)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(FileVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(FileVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setFileName( (String)map.get(FileVOMeta.FILE_NAME));
				this.setDownloadUrl( (String)map.get(FileVOMeta.DOWNLOAD_URL));
				this.setMediaType( (String)map.get(FileVOMeta.MEDIA_TYPE));
				this.setUpdateTime( (Date)map.get(FileVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(FileVOMeta.VERSION));
				this.setCreateBy( (String)map.get(FileVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(FileVOMeta.DELETED));
				this.setSize( (Long)map.get(FileVOMeta.SIZE));
				this.setDownloads( (Integer)map.get(FileVOMeta.DOWNLOADS));
				this.setCreateTime( (Date)map.get(FileVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(FileVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(FileVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(FileVOMeta.DELETE_BY));
				this.setLocation( (String)map.get(FileVOMeta.LOCATION));
				this.setId( (String)map.get(FileVOMeta.ID));
				this.setFileType( (String)map.get(FileVOMeta.FILE_TYPE));
				this.setLatestVisitTime( (Date)map.get(FileVOMeta.LATEST_VISIT_TIME));
				// others
				this.setSearchField( (String)map.get(FileVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(FileVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(FileVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(FileVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(FileVOMeta.SORT_FIELD));
				this.setExists( (Boolean)map.get(FileVOMeta.EXISTS));
				this.setPageSize( (Integer)map.get(FileVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(FileVOMeta.SEARCH_VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setFileName(DataParser.parse(String.class, r.getValue(FileVOMeta.FILE_NAME)));
			this.setDownloadUrl(DataParser.parse(String.class, r.getValue(FileVOMeta.DOWNLOAD_URL)));
			this.setMediaType(DataParser.parse(String.class, r.getValue(FileVOMeta.MEDIA_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(FileVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(FileVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(FileVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(FileVOMeta.DELETED)));
			this.setSize(DataParser.parse(Long.class, r.getValue(FileVOMeta.SIZE)));
			this.setDownloads(DataParser.parse(Integer.class, r.getValue(FileVOMeta.DOWNLOADS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(FileVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(FileVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(FileVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(FileVOMeta.DELETE_BY)));
			this.setLocation(DataParser.parse(String.class, r.getValue(FileVOMeta.LOCATION)));
			this.setId(DataParser.parse(String.class, r.getValue(FileVOMeta.ID)));
			this.setFileType(DataParser.parse(String.class, r.getValue(FileVOMeta.FILE_TYPE)));
			this.setLatestVisitTime(DataParser.parse(Date.class, r.getValue(FileVOMeta.LATEST_VISIT_TIME)));
			return true;
		} else {
			try {
				this.setFileName( (String)r.getValue(FileVOMeta.FILE_NAME));
				this.setDownloadUrl( (String)r.getValue(FileVOMeta.DOWNLOAD_URL));
				this.setMediaType( (String)r.getValue(FileVOMeta.MEDIA_TYPE));
				this.setUpdateTime( (Date)r.getValue(FileVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(FileVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(FileVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(FileVOMeta.DELETED));
				this.setSize( (Long)r.getValue(FileVOMeta.SIZE));
				this.setDownloads( (Integer)r.getValue(FileVOMeta.DOWNLOADS));
				this.setCreateTime( (Date)r.getValue(FileVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(FileVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(FileVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(FileVOMeta.DELETE_BY));
				this.setLocation( (String)r.getValue(FileVOMeta.LOCATION));
				this.setId( (String)r.getValue(FileVOMeta.ID));
				this.setFileType( (String)r.getValue(FileVOMeta.FILE_TYPE));
				this.setLatestVisitTime( (Date)r.getValue(FileVOMeta.LATEST_VISIT_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}