package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_DICT_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据字典条目
 * <p>数据字典条目 , 数据表 sys_dict_item 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:51
 * @sign 1EFDF7AA422B528ADC305CEDBFC401C0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_dict_item")
@ApiModel(description = "数据字典条目 ; 数据字典条目 , 数据表 sys_dict_item 的PO类型")
public class DictItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_DICT_ITEM.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "0053e1c8-0d63-11ec-ab08-00163e2e6a36")
	private String id;
	
	/**
	 * 字典ID：字典ID
	*/
	@ApiModelProperty(required = false,value="字典ID" , notes = "字典ID" , example = "30")
	private String dictId;
	
	/**
	 * 字典代码：字典代码
	*/
	@ApiModelProperty(required = true,value="字典代码" , notes = "字典代码" , example = "ops_voucher_category")
	private String dictCode;
	
	/**
	 * 上级条目ID：上级条目ID
	*/
	@ApiModelProperty(required = false,value="上级条目ID" , notes = "上级条目ID")
	private String parentId;
	
	/**
	 * 代码：代码
	*/
	@ApiModelProperty(required = false,value="代码" , notes = "代码" , example = "network")
	private String code;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签" , example = "网络")
	private String label;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = true,value="排序" , notes = "排序" , example = "9999")
	private Integer sort;
	
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * 有效：是否有效
	*/
	@ApiModelProperty(required = false,value="有效" , notes = "是否有效" , example = "1")
	private Integer valid;
	
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
	public DictItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 字典ID<br>
	 * 字典ID
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
	 * 获得 字典代码<br>
	 * 字典代码
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
	 * 获得 上级条目ID<br>
	 * 上级条目ID
	 * @return 上级条目ID
	*/
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 上级条目ID
	 * @param parentId 上级条目ID
	 * @return 当前对象
	*/
	public DictItem setParentId(String parentId) {
		this.parentId=parentId;
		return this;
	}
	
	/**
	 * 获得 代码<br>
	 * 代码
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
	 * 获得 标签<br>
	 * 标签
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
	 * 获得 排序<br>
	 * 排序
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
	public DictItem setCreateBy(String createBy) {
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
	public DictItem setCreateTime(Date createTime) {
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
	public DictItem setUpdateBy(String updateBy) {
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
	public DictItem setUpdateTime(Date updateTime) {
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
	@JsonProperty("deleted")
	public DictItem setDeleted(Integer deleted) {
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
	public DictItem setDeleted(Boolean deletedBool) {
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
	public DictItem setDeleteBy(String deleteBy) {
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
	public DictItem setDeleteTime(Date deleteTime) {
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
	public DictItem setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 有效<br>
	 * 是否有效
	 * @return 有效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 有效
	 * @param valid 有效
	 * @return 当前对象
	*/
	public DictItem setValid(Integer valid) {
		this.valid=valid;
		return this;
	}

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
	 * 克隆当前对象
	*/
	@Transient
	public DictItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DictItem duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.DictItemMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.DictItemMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setDictId(this.getDictId());
		inst.setLabel(this.getLabel());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setParentId(this.getParentId());
		inst.setValid(this.getValid());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setDictCode(this.getDictCode());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DictItem clone(boolean deep) {
		return EntityContext.clone(DictItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DictItem
	 * @param dictItemMap 包含实体信息的 Map 对象
	 * @return DictItem , 转换好的的 DictItem 对象
	*/
	@Transient
	public static DictItem createFrom(Map<String,Object> dictItemMap) {
		if(dictItemMap==null) return null;
		DictItem po = create();
		EntityContext.copyProperties(po,dictItemMap);
		po.clearModifies();
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
		DictItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DictItem，等同于 new
	 * @return DictItem 对象
	*/
	@Transient
	public static DictItem create() {
		return new org.github.foxnic.web.domain.system.meta.DictItemMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(DictItemMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DictItemMeta.UPDATE_TIME)));
			this.setDictId(DataParser.parse(String.class, map.get(DictItemMeta.DICT_ID)));
			this.setLabel(DataParser.parse(String.class, map.get(DictItemMeta.LABEL)));
			this.setSort(DataParser.parse(Integer.class, map.get(DictItemMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DictItemMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, map.get(DictItemMeta.PARENT_ID)));
			this.setValid(DataParser.parse(Integer.class, map.get(DictItemMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DictItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DictItemMeta.DELETED)));
			this.setDictCode(DataParser.parse(String.class, map.get(DictItemMeta.DICT_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DictItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DictItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DictItemMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DictItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DictItemMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(DictItemMeta.CODE));
				this.setUpdateTime( (Date)map.get(DictItemMeta.UPDATE_TIME));
				this.setDictId( (String)map.get(DictItemMeta.DICT_ID));
				this.setLabel( (String)map.get(DictItemMeta.LABEL));
				this.setSort( (Integer)map.get(DictItemMeta.SORT));
				this.setVersion( (Integer)map.get(DictItemMeta.VERSION));
				this.setParentId( (String)map.get(DictItemMeta.PARENT_ID));
				this.setValid( (Integer)map.get(DictItemMeta.VALID));
				this.setCreateBy( (String)map.get(DictItemMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DictItemMeta.DELETED));
				this.setDictCode( (String)map.get(DictItemMeta.DICT_CODE));
				this.setCreateTime( (Date)map.get(DictItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DictItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DictItemMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(DictItemMeta.DELETE_BY));
				this.setId( (String)map.get(DictItemMeta.ID));
				// others
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
			this.setCode(DataParser.parse(String.class, r.getValue(DictItemMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DictItemMeta.UPDATE_TIME)));
			this.setDictId(DataParser.parse(String.class, r.getValue(DictItemMeta.DICT_ID)));
			this.setLabel(DataParser.parse(String.class, r.getValue(DictItemMeta.LABEL)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(DictItemMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DictItemMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, r.getValue(DictItemMeta.PARENT_ID)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(DictItemMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DictItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DictItemMeta.DELETED)));
			this.setDictCode(DataParser.parse(String.class, r.getValue(DictItemMeta.DICT_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DictItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DictItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DictItemMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DictItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DictItemMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(DictItemMeta.CODE));
				this.setUpdateTime( (Date)r.getValue(DictItemMeta.UPDATE_TIME));
				this.setDictId( (String)r.getValue(DictItemMeta.DICT_ID));
				this.setLabel( (String)r.getValue(DictItemMeta.LABEL));
				this.setSort( (Integer)r.getValue(DictItemMeta.SORT));
				this.setVersion( (Integer)r.getValue(DictItemMeta.VERSION));
				this.setParentId( (String)r.getValue(DictItemMeta.PARENT_ID));
				this.setValid( (Integer)r.getValue(DictItemMeta.VALID));
				this.setCreateBy( (String)r.getValue(DictItemMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DictItemMeta.DELETED));
				this.setDictCode( (String)r.getValue(DictItemMeta.DICT_CODE));
				this.setCreateTime( (Date)r.getValue(DictItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DictItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DictItemMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(DictItemMeta.DELETE_BY));
				this.setId( (String)r.getValue(DictItemMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}