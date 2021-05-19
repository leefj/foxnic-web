package com.scientific.tailoring.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.SYS_DICT_ITEM;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:08:24
 * @sign 919C200E0759AF5B7F2EEF237E15E532
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_dict_item")
public class DictItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_DICT_ITEM.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private Integer id;
	
	/**
	 * 字典ID：字典ID
	*/
	@ApiModelProperty(required = true,value="字典ID" , notes = "字典ID")
	private String dictId;
	
	/**
	 * 字典代码：字典代码
	*/
	@ApiModelProperty(required = true,value="字典代码" , notes = "字典代码")
	private String dictCode;
	
	/**
	 * 代码：代码
	*/
	@ApiModelProperty(required = true,value="代码" , notes = "代码")
	private String code;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = true,value="标签" , notes = "标签")
	private String label;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = true,value="排序" , notes = "排序")
	private Integer sort;
	
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
	private Boolean deleted;
	
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
	public Integer getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public DictItem setId(Integer id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 ID
	 * @param id ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 字典ID<br>
	 * 属性说明 : 字典ID
	 * @return 字典ID
	*/
	public String getDictId() {
		return dictId;
	}
	
	/**
	 * 设置 字典ID
	 * @param dictId 字典ID
	 * @return 当前对象
	*/
	public DictItem setDictId(String dictId) {
		this.dictId=dictId;
		return this;
	}
	
	/**
	 * 添加 字典ID
	 * @param dictId 字典ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 字典代码<br>
	 * 属性说明 : 字典代码
	 * @return 字典代码
	*/
	public String getDictCode() {
		return dictCode;
	}
	
	/**
	 * 设置 字典代码
	 * @param dictCode 字典代码
	 * @return 当前对象
	*/
	public DictItem setDictCode(String dictCode) {
		this.dictCode=dictCode;
		return this;
	}
	
	/**
	 * 添加 字典代码
	 * @param dictCode 字典代码
	 * @return 当前对象
	*/
	
	/**
	 * 获得 代码<br>
	 * 属性说明 : 代码
	 * @return 代码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 代码
	 * @param code 代码
	 * @return 当前对象
	*/
	public DictItem setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 添加 代码
	 * @param code 代码
	 * @return 当前对象
	*/
	
	/**
	 * 获得 标签<br>
	 * 属性说明 : 标签
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public DictItem setLabel(String label) {
		this.label=label;
		return this;
	}
	
	/**
	 * 添加 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	
	/**
	 * 获得 排序<br>
	 * 属性说明 : 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public DictItem setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 添加 排序
	 * @param sort 排序
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
	public DictItem setCreateBy(Long createBy) {
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
	public DictItem setCreateTime(Date createTime) {
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
	public DictItem setUpdateBy(Long updateBy) {
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
	public DictItem setUpdateTime(Date updateTime) {
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
	public Boolean isDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 等价于 isDeleted 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否已删除
	 * @return 是否已删除
	*/
	public Boolean getDeleted() {
		return this.deleted;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public DictItem setDeleted(Boolean deleted) {
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
	public DictItem setDeleteBy(Long deleteBy) {
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
	public DictItem setDeleteTime(Date deleteTime) {
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
	public DictItem setVersion(Integer version) {
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
	 * @return DictItem , 转换好的 DictItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DictItem , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 DictItem
	 * @param dictItemMap 包含实体信息的 Map 对象
	 * @return DictItem , 转换好的的 DictItem 对象
	*/
	@Transient
	public static DictItem createFrom(Map<String,Object> dictItemMap) {
		if(dictItemMap==null) return null;
		DictItem po = EntityContext.create(DictItem.class, dictItemMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 DictItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DictItem , 转换好的的 DictItem 对象
	*/
	@Transient
	public static DictItem createFrom(Object pojo) {
		if(pojo==null) return null;
		DictItem po = EntityContext.create(DictItem.class,pojo);
		return po;
	}

	/**
	 * 创建一个 DictItem，等同于 new
	 * @return DictItem 对象
	*/
	@Transient
	public static DictItem create() {
		return new DictItem();
	}
}