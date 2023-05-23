package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_CATALOG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.bpm.meta.CatalogMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程分类
 * <p>流程分类 , 数据表 bpm_catalog 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-23 14:15:40
 * @sign 0EAE15AA705C561AED85EDAE5103D8B1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_catalog")
@ApiModel(description = "流程分类 ; 流程分类 , 数据表 bpm_catalog 的PO类型")
public class Catalog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_CATALOG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "691301431835099136")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "测试")
	private String name;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "测试")
	private String notes;
	
	/**
	 * PC端图标：PC端图标
	*/
	@ApiModelProperty(required = false,value="PC端图标" , notes = "PC端图标" , example = "691320673397637120")
	private String iconFilePc;
	
	/**
	 * 移动端图标：移动端图标
	*/
	@ApiModelProperty(required = false,value="移动端图标" , notes = "移动端图标" , example = "691320618678747136")
	private String iconFileMobile;
	
	/**
	 * 序号：序号
	*/
	@ApiModelProperty(required = false,value="序号" , notes = "序号" , example = "5")
	private Integer sort;
	
	/**
	 * 生效：生效
	*/
	@ApiModelProperty(required = false,value="生效" , notes = "生效" , example = "0")
	private Integer valid;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-03-23 03:05:05")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-05-16 02:30:58")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "7")
	private Integer version;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = true,value="租户ID" , notes = "租户ID" , example = "T001")
	private String tenantId;
	
	/**
	 * 流程定义清单：流程定义清单
	*/
	@ApiModelProperty(required = false,value="流程定义清单" , notes = "流程定义清单")
	private List<ProcessDefinition> processDefinitionList;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public Catalog setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public Catalog setName(String name) {
		this.name=name;
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
	public Catalog setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 PC端图标<br>
	 * PC端图标
	 * @return PC端图标
	*/
	public String getIconFilePc() {
		return iconFilePc;
	}
	
	/**
	 * 设置 PC端图标
	 * @param iconFilePc PC端图标
	 * @return 当前对象
	*/
	public Catalog setIconFilePc(String iconFilePc) {
		this.iconFilePc=iconFilePc;
		return this;
	}
	
	/**
	 * 获得 移动端图标<br>
	 * 移动端图标
	 * @return 移动端图标
	*/
	public String getIconFileMobile() {
		return iconFileMobile;
	}
	
	/**
	 * 设置 移动端图标
	 * @param iconFileMobile 移动端图标
	 * @return 当前对象
	*/
	public Catalog setIconFileMobile(String iconFileMobile) {
		this.iconFileMobile=iconFileMobile;
		return this;
	}
	
	/**
	 * 获得 序号<br>
	 * 序号
	 * @return 序号
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 序号
	 * @param sort 序号
	 * @return 当前对象
	*/
	public Catalog setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 生效<br>
	 * 生效
	 * @return 生效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 生效
	 * @param valid 生效
	 * @return 当前对象
	*/
	public Catalog setValid(Integer valid) {
		this.valid=valid;
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
	public Catalog setCreateBy(String createBy) {
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
	public Catalog setCreateTime(Date createTime) {
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
	public Catalog setUpdateBy(String updateBy) {
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
	public Catalog setUpdateTime(Date updateTime) {
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
	public Catalog setDeleted(Integer deleted) {
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
	public Catalog setDeleted(Boolean deletedBool) {
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
	public Catalog setDeleteBy(String deleteBy) {
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
	public Catalog setDeleteTime(Date deleteTime) {
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
	public Catalog setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户ID<br>
	 * 租户ID
	 * @return 租户ID
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户ID
	 * @param tenantId 租户ID
	 * @return 当前对象
	*/
	public Catalog setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 流程定义清单<br>
	 * 流程定义清单
	 * @return 流程定义清单
	*/
	public List<ProcessDefinition> getProcessDefinitionList() {
		return processDefinitionList;
	}
	
	/**
	 * 设置 流程定义清单
	 * @param processDefinitionList 流程定义清单
	 * @return 当前对象
	*/
	public Catalog setProcessDefinitionList(List<ProcessDefinition> processDefinitionList) {
		this.processDefinitionList=processDefinitionList;
		return this;
	}
	
	/**
	 * 添加 流程定义清单
	 * @param processDefinition 流程定义清单
	 * @return 当前对象
	*/
	public Catalog addProcessDefinition(ProcessDefinition... processDefinition) {
		if(this.processDefinitionList==null) processDefinitionList=new ArrayList<>();
		this.processDefinitionList.addAll(Arrays.asList(processDefinition));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Catalog , 转换好的 Catalog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Catalog , 转换好的 PoJo 对象
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
	public Catalog clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Catalog duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.CatalogMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.CatalogMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setIconFileMobile(this.getIconFileMobile());
		inst.setValid(this.getValid());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setIconFilePc(this.getIconFilePc());
		if(all) {
			inst.setProcessDefinitionList(this.getProcessDefinitionList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Catalog clone(boolean deep) {
		return EntityContext.clone(Catalog.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Catalog
	 * @param catalogMap 包含实体信息的 Map 对象
	 * @return Catalog , 转换好的的 Catalog 对象
	*/
	@Transient
	public static Catalog createFrom(Map<String,Object> catalogMap) {
		if(catalogMap==null) return null;
		Catalog po = create();
		EntityContext.copyProperties(po,catalogMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Catalog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Catalog , 转换好的的 Catalog 对象
	*/
	@Transient
	public static Catalog createFrom(Object pojo) {
		if(pojo==null) return null;
		Catalog po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Catalog，等同于 new
	 * @return Catalog 对象
	*/
	@Transient
	public static Catalog create() {
		return new org.github.foxnic.web.domain.bpm.meta.CatalogMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(CatalogMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CatalogMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(CatalogMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CatalogMeta.VERSION)));
			this.setIconFileMobile(DataParser.parse(String.class, map.get(CatalogMeta.ICON_FILE_MOBILE)));
			this.setValid(DataParser.parse(Integer.class, map.get(CatalogMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CatalogMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CatalogMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CatalogMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CatalogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CatalogMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(CatalogMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CatalogMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CatalogMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CatalogMeta.ID)));
			this.setIconFilePc(DataParser.parse(String.class, map.get(CatalogMeta.ICON_FILE_PC)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(CatalogMeta.NOTES));
				this.setUpdateTime( (Date)map.get(CatalogMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(CatalogMeta.SORT));
				this.setVersion( (Integer)map.get(CatalogMeta.VERSION));
				this.setIconFileMobile( (String)map.get(CatalogMeta.ICON_FILE_MOBILE));
				this.setValid( (Integer)map.get(CatalogMeta.VALID));
				this.setCreateBy( (String)map.get(CatalogMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CatalogMeta.DELETED));
				this.setCreateTime( (Date)map.get(CatalogMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CatalogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CatalogMeta.DELETE_TIME));
				this.setName( (String)map.get(CatalogMeta.NAME));
				this.setTenantId( (String)map.get(CatalogMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CatalogMeta.DELETE_BY));
				this.setId( (String)map.get(CatalogMeta.ID));
				this.setIconFilePc( (String)map.get(CatalogMeta.ICON_FILE_PC));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(CatalogMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CatalogMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(CatalogMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CatalogMeta.VERSION)));
			this.setIconFileMobile(DataParser.parse(String.class, r.getValue(CatalogMeta.ICON_FILE_MOBILE)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(CatalogMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CatalogMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CatalogMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CatalogMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CatalogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CatalogMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(CatalogMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CatalogMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CatalogMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CatalogMeta.ID)));
			this.setIconFilePc(DataParser.parse(String.class, r.getValue(CatalogMeta.ICON_FILE_PC)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(CatalogMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(CatalogMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(CatalogMeta.SORT));
				this.setVersion( (Integer)r.getValue(CatalogMeta.VERSION));
				this.setIconFileMobile( (String)r.getValue(CatalogMeta.ICON_FILE_MOBILE));
				this.setValid( (Integer)r.getValue(CatalogMeta.VALID));
				this.setCreateBy( (String)r.getValue(CatalogMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CatalogMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CatalogMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CatalogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CatalogMeta.DELETE_TIME));
				this.setName( (String)r.getValue(CatalogMeta.NAME));
				this.setTenantId( (String)r.getValue(CatalogMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CatalogMeta.DELETE_BY));
				this.setId( (String)r.getValue(CatalogMeta.ID));
				this.setIconFilePc( (String)r.getValue(CatalogMeta.ICON_FILE_PC));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}