package org.github.foxnic.web.domain.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_DICT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import org.github.foxnic.web.domain.oauth.Menu;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 数据字典
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:18:40
 * @sign 5D7BBBCC1F54C8563F918409E82934F5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_dict")
public class Dict extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_DICT.$TABLE;

	/**
	 * 字典ID：字典ID
	*/
	@Id
	@ApiModelProperty(required = true,value="字典ID" , notes = "字典ID")
	private String id;

	/**
	 * 是否树形结构：是否树形结构
	*/
	@ApiModelProperty(required = true,value="是否树形结构" , notes = "是否树形结构")
	private Integer isTree;

	/**
	 * 字典名称：字典名称
	*/
	@ApiModelProperty(required = false,value="字典名称" , notes = "字典名称")
	private String name;

	/**
	 * 字典代码：字典代码
	*/
	@ApiModelProperty(required = false,value="字典代码" , notes = "字典代码")
	private String code;

	/**
	 * 所属模块：所属模块
	*/
	@ApiModelProperty(required = false,value="所属模块" , notes = "所属模块")
	private String module;

	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;

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
	 * 字典项目
	*/
	@ApiModelProperty(required = false,value="字典项目" , notes = "")
	private List<DictItem> items;

	/**
	 * 关联模块
	*/
	@ApiModelProperty(required = false,value="关联模块" , notes = "")
	private Menu moduleInfo;

	/**
	 * 获得 字典ID<br>
	 * 字典ID
	 * @return 字典ID
	*/
	public String getId() {
		return id;
	}

	/**
	 * 设置 字典ID
	 * @param id 字典ID
	 * @return 当前对象
	*/
	public Dict setId(String id) {
		this.id=id;
		return this;
	}

	/**
	 * 获得 是否树形结构<br>
	 * 是否树形结构
	 * @return 是否树形结构
	*/
	public Integer getIsTree() {
		return isTree;
	}

	/**
	 * 设置 是否树形结构
	 * @param isTree 是否树形结构
	 * @return 当前对象
	*/
	public Dict setIsTree(Integer isTree) {
		this.isTree=isTree;
		return this;
	}

	/**
	 * 获得 字典名称<br>
	 * 字典名称
	 * @return 字典名称
	*/
	public String getName() {
		return name;
	}

	/**
	 * 设置 字典名称
	 * @param name 字典名称
	 * @return 当前对象
	*/
	public Dict setName(String name) {
		this.name=name;
		return this;
	}

	/**
	 * 获得 字典代码<br>
	 * 字典代码
	 * @return 字典代码
	*/
	public String getCode() {
		return code;
	}

	/**
	 * 设置 字典代码
	 * @param code 字典代码
	 * @return 当前对象
	*/
	public Dict setCode(String code) {
		this.code=code;
		return this;
	}

	/**
	 * 获得 所属模块<br>
	 * 所属模块
	 * @return 所属模块
	*/
	public String getModule() {
		return module;
	}

	/**
	 * 设置 所属模块
	 * @param module 所属模块
	 * @return 当前对象
	*/
	public Dict setModule(String module) {
		this.module=module;
		return this;
	}

	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}

	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public Dict setNotes(String notes) {
		this.notes=notes;
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
	public Dict setCreateBy(String createBy) {
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
	public Dict setCreateTime(Date createTime) {
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
	public Dict setUpdateBy(String updateBy) {
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
	public Dict setUpdateTime(Date updateTime) {
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
	public Dict setDeleted(Integer deleted) {
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
	public Dict setDeleted(Boolean deletedBool) {
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
	public Dict setDeleteBy(String deleteBy) {
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
	public Dict setDeleteTime(Date deleteTime) {
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
	public Dict setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 获得 字典项目<br>
	 * @return 字典项目
	*/
	public List<DictItem> getItems() {
		return items;
	}

	/**
	 * 设置 字典项目
	 * @param items 字典项目
	 * @return 当前对象
	*/
	public Dict setItems(List<DictItem> items) {
		this.items=items;
		return this;
	}

	/**
	 * 添加 字典项目
	 * @param item 字典项目
	 * @return 当前对象
	*/
	public Dict addItem(DictItem... item) {
		if(this.items==null) items=new ArrayList<>();
		this.items.addAll(Arrays.asList(item));
		return this;
	}

	/**
	 * 获得 关联模块<br>
	 * @return 关联模块
	*/
	public Menu getModuleInfo() {
		return moduleInfo;
	}

	/**
	 * 设置 关联模块
	 * @param moduleInfo 关联模块
	 * @return 当前对象
	*/
	public Dict setModuleInfo(Menu moduleInfo) {
		this.moduleInfo=moduleInfo;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Dict , 转换好的 Dict 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Dict , 转换好的 PoJo 对象
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
	public Dict clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Dict duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.DictMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.DictMeta.$$proxy$$();
		inst.setIsTree(this.getIsTree());
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setModule(this.getModule());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setModuleInfo(this.getModuleInfo());
			inst.setItems(this.getItems());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Dict clone(boolean deep) {
		return EntityContext.clone(Dict.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Dict
	 * @param dictMap 包含实体信息的 Map 对象
	 * @return Dict , 转换好的的 Dict 对象
	*/
	@Transient
	public static Dict createFrom(Map<String,Object> dictMap) {
		if(dictMap==null) return null;
		Dict po = EntityContext.create(Dict.class, dictMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Dict
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Dict , 转换好的的 Dict 对象
	*/
	@Transient
	public static Dict createFrom(Object pojo) {
		if(pojo==null) return null;
		Dict po = EntityContext.create(Dict.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Dict，等同于 new
	 * @return Dict 对象
	*/
	@Transient
	public static Dict create() {
		return EntityContext.create(Dict.class);
	}
}
