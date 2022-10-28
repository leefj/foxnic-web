package org.github.foxnic.web.domain.hrm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_FAVOURITE_GROUP_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.hrm.meta.FavouriteGroupItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 常用人员分组条目
 * <p>常用人员分组条目 , 数据表 hrm_favourite_group_item 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:47:57
 * @sign 24F468F18ED212DA383A1F7746CFD991
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hrm_favourite_group_item")
@ApiModel(description = "常用人员分组条目 ; 常用人员分组条目 , 数据表 hrm_favourite_group_item 的PO类型")
public class FavouriteGroupItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HRM_FAVOURITE_GROUP_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 对象ID：对象ID
	*/
	@ApiModelProperty(required = true,value="对象ID" , notes = "对象ID")
	private String targetId;
	
	/**
	 * 对象类型：对象类型
	*/
	@ApiModelProperty(required = true,value="对象类型" , notes = "对象类型")
	private String targetType;
	
	/**
	 * 对象名称：对象名称
	*/
	@ApiModelProperty(required = false,value="对象名称" , notes = "对象名称")
	private String targetName;
	
	/**
	 * 层级路径：层级路径
	*/
	@ApiModelProperty(required = false,value="层级路径" , notes = "层级路径")
	private String groupId;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer sort;
	
	/**
	 * 所有者ID：所有者ID
	*/
	@ApiModelProperty(required = false,value="所有者ID" , notes = "所有者ID")
	private String employeeId;
	
	/**
	 * 是否临时：是否临时
	*/
	@ApiModelProperty(required = true,value="是否临时" , notes = "是否临时")
	private Integer temporary;
	
	/**
	 * 总公司ID：总公司ID
	*/
	@ApiModelProperty(required = false,value="总公司ID" , notes = "总公司ID")
	private String companyId;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = false,value="租户ID" , notes = "租户ID")
	private String tenantId;
	
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 关联的员工
	*/
	@ApiModelProperty(required = false,value="关联的员工" , notes = "")
	private Employee employee;
	
	/**
	 * 关联的部门
	*/
	@ApiModelProperty(required = false,value="关联的部门" , notes = "")
	private Employee organization;
	
	/**
	 * 关联的岗位
	*/
	@ApiModelProperty(required = false,value="关联的岗位" , notes = "")
	private Employee position;
	
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
	public FavouriteGroupItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 对象ID<br>
	 * 对象ID
	 * @return 对象ID
	*/
	public String getTargetId() {
		return targetId;
	}
	
	/**
	 * 设置 对象ID
	 * @param targetId 对象ID
	 * @return 当前对象
	*/
	public FavouriteGroupItem setTargetId(String targetId) {
		this.targetId=targetId;
		return this;
	}
	
	/**
	 * 获得 对象类型<br>
	 * 对象类型
	 * @return 对象类型
	*/
	public String getTargetType() {
		return targetType;
	}
	
	/**
	 * 设置 对象类型
	 * @param targetType 对象类型
	 * @return 当前对象
	*/
	public FavouriteGroupItem setTargetType(String targetType) {
		this.targetType=targetType;
		return this;
	}
	
	/**
	 * 获得 对象名称<br>
	 * 对象名称
	 * @return 对象名称
	*/
	public String getTargetName() {
		return targetName;
	}
	
	/**
	 * 设置 对象名称
	 * @param targetName 对象名称
	 * @return 当前对象
	*/
	public FavouriteGroupItem setTargetName(String targetName) {
		this.targetName=targetName;
		return this;
	}
	
	/**
	 * 获得 层级路径<br>
	 * 层级路径
	 * @return 层级路径
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 层级路径
	 * @param groupId 层级路径
	 * @return 当前对象
	*/
	public FavouriteGroupItem setGroupId(String groupId) {
		this.groupId=groupId;
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
	public FavouriteGroupItem setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 所有者ID<br>
	 * 所有者ID
	 * @return 所有者ID
	*/
	public String getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * 设置 所有者ID
	 * @param employeeId 所有者ID
	 * @return 当前对象
	*/
	public FavouriteGroupItem setEmployeeId(String employeeId) {
		this.employeeId=employeeId;
		return this;
	}
	
	/**
	 * 获得 是否临时<br>
	 * 是否临时
	 * @return 是否临时
	*/
	public Integer getTemporary() {
		return temporary;
	}
	
	/**
	 * 设置 是否临时
	 * @param temporary 是否临时
	 * @return 当前对象
	*/
	public FavouriteGroupItem setTemporary(Integer temporary) {
		this.temporary=temporary;
		return this;
	}
	
	/**
	 * 获得 总公司ID<br>
	 * 总公司ID
	 * @return 总公司ID
	*/
	public String getCompanyId() {
		return companyId;
	}
	
	/**
	 * 设置 总公司ID
	 * @param companyId 总公司ID
	 * @return 当前对象
	*/
	public FavouriteGroupItem setCompanyId(String companyId) {
		this.companyId=companyId;
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
	public FavouriteGroupItem setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public FavouriteGroupItem setCreateBy(String createBy) {
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
	public FavouriteGroupItem setCreateTime(Date createTime) {
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
	public FavouriteGroupItem setUpdateBy(String updateBy) {
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
	public FavouriteGroupItem setUpdateTime(Date updateTime) {
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
	public FavouriteGroupItem setDeleted(Integer deleted) {
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
	public FavouriteGroupItem setDeleted(Boolean deletedBool) {
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
	public FavouriteGroupItem setDeleteBy(String deleteBy) {
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
	public FavouriteGroupItem setDeleteTime(Date deleteTime) {
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
	public FavouriteGroupItem setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 关联的员工<br>
	 * @return 关联的员工
	*/
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * 设置 关联的员工
	 * @param employee 关联的员工
	 * @return 当前对象
	*/
	public FavouriteGroupItem setEmployee(Employee employee) {
		this.employee=employee;
		return this;
	}
	
	/**
	 * 获得 关联的部门<br>
	 * @return 关联的部门
	*/
	public Employee getOrganization() {
		return organization;
	}
	
	/**
	 * 设置 关联的部门
	 * @param organization 关联的部门
	 * @return 当前对象
	*/
	public FavouriteGroupItem setOrganization(Employee organization) {
		this.organization=organization;
		return this;
	}
	
	/**
	 * 获得 关联的岗位<br>
	 * @return 关联的岗位
	*/
	public Employee getPosition() {
		return position;
	}
	
	/**
	 * 设置 关联的岗位
	 * @param position 关联的岗位
	 * @return 当前对象
	*/
	public FavouriteGroupItem setPosition(Employee position) {
		this.position=position;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return FavouriteGroupItem , 转换好的 FavouriteGroupItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FavouriteGroupItem , 转换好的 PoJo 对象
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
	public FavouriteGroupItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public FavouriteGroupItem duplicate(boolean all) {
		org.github.foxnic.web.domain.hrm.meta.FavouriteGroupItemMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.hrm.meta.FavouriteGroupItemMeta.$$proxy$$();
		inst.setTemporary(this.getTemporary());
		inst.setTargetName(this.getTargetName());
		inst.setTargetId(this.getTargetId());
		inst.setGroupId(this.getGroupId());
		inst.setTargetType(this.getTargetType());
		inst.setEmployeeId(this.getEmployeeId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setCompanyId(this.getCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setOrganization(this.getOrganization());
			inst.setPosition(this.getPosition());
			inst.setEmployee(this.getEmployee());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public FavouriteGroupItem clone(boolean deep) {
		return EntityContext.clone(FavouriteGroupItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 FavouriteGroupItem
	 * @param favouriteGroupItemMap 包含实体信息的 Map 对象
	 * @return FavouriteGroupItem , 转换好的的 FavouriteGroupItem 对象
	*/
	@Transient
	public static FavouriteGroupItem createFrom(Map<String,Object> favouriteGroupItemMap) {
		if(favouriteGroupItemMap==null) return null;
		FavouriteGroupItem po = create();
		EntityContext.copyProperties(po,favouriteGroupItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 FavouriteGroupItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FavouriteGroupItem , 转换好的的 FavouriteGroupItem 对象
	*/
	@Transient
	public static FavouriteGroupItem createFrom(Object pojo) {
		if(pojo==null) return null;
		FavouriteGroupItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 FavouriteGroupItem，等同于 new
	 * @return FavouriteGroupItem 对象
	*/
	@Transient
	public static FavouriteGroupItem create() {
		return new org.github.foxnic.web.domain.hrm.meta.FavouriteGroupItemMeta.$$proxy$$();
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
			this.setTemporary(DataParser.parse(Integer.class, map.get(FavouriteGroupItemMeta.TEMPORARY)));
			this.setTargetName(DataParser.parse(String.class, map.get(FavouriteGroupItemMeta.TARGET_NAME)));
			this.setTargetId(DataParser.parse(String.class, map.get(FavouriteGroupItemMeta.TARGET_ID)));
			this.setGroupId(DataParser.parse(String.class, map.get(FavouriteGroupItemMeta.GROUP_ID)));
			this.setTargetType(DataParser.parse(String.class, map.get(FavouriteGroupItemMeta.TARGET_TYPE)));
			this.setEmployeeId(DataParser.parse(String.class, map.get(FavouriteGroupItemMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(FavouriteGroupItemMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(FavouriteGroupItemMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(FavouriteGroupItemMeta.VERSION)));
			this.setCompanyId(DataParser.parse(String.class, map.get(FavouriteGroupItemMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(FavouriteGroupItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(FavouriteGroupItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(FavouriteGroupItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(FavouriteGroupItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(FavouriteGroupItemMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(FavouriteGroupItemMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(FavouriteGroupItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(FavouriteGroupItemMeta.ID)));
			// others
			this.setOrganization(DataParser.parse(Employee.class, map.get(FavouriteGroupItemMeta.ORGANIZATION)));
			this.setPosition(DataParser.parse(Employee.class, map.get(FavouriteGroupItemMeta.POSITION)));
			this.setEmployee(DataParser.parse(Employee.class, map.get(FavouriteGroupItemMeta.EMPLOYEE)));
			return true;
		} else {
			try {
				this.setTemporary( (Integer)map.get(FavouriteGroupItemMeta.TEMPORARY));
				this.setTargetName( (String)map.get(FavouriteGroupItemMeta.TARGET_NAME));
				this.setTargetId( (String)map.get(FavouriteGroupItemMeta.TARGET_ID));
				this.setGroupId( (String)map.get(FavouriteGroupItemMeta.GROUP_ID));
				this.setTargetType( (String)map.get(FavouriteGroupItemMeta.TARGET_TYPE));
				this.setEmployeeId( (String)map.get(FavouriteGroupItemMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)map.get(FavouriteGroupItemMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(FavouriteGroupItemMeta.SORT));
				this.setVersion( (Integer)map.get(FavouriteGroupItemMeta.VERSION));
				this.setCompanyId( (String)map.get(FavouriteGroupItemMeta.COMPANY_ID));
				this.setCreateBy( (String)map.get(FavouriteGroupItemMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(FavouriteGroupItemMeta.DELETED));
				this.setCreateTime( (Date)map.get(FavouriteGroupItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(FavouriteGroupItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(FavouriteGroupItemMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(FavouriteGroupItemMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(FavouriteGroupItemMeta.DELETE_BY));
				this.setId( (String)map.get(FavouriteGroupItemMeta.ID));
				// others
				this.setOrganization( (Employee)map.get(FavouriteGroupItemMeta.ORGANIZATION));
				this.setPosition( (Employee)map.get(FavouriteGroupItemMeta.POSITION));
				this.setEmployee( (Employee)map.get(FavouriteGroupItemMeta.EMPLOYEE));
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
			this.setTemporary(DataParser.parse(Integer.class, r.getValue(FavouriteGroupItemMeta.TEMPORARY)));
			this.setTargetName(DataParser.parse(String.class, r.getValue(FavouriteGroupItemMeta.TARGET_NAME)));
			this.setTargetId(DataParser.parse(String.class, r.getValue(FavouriteGroupItemMeta.TARGET_ID)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(FavouriteGroupItemMeta.GROUP_ID)));
			this.setTargetType(DataParser.parse(String.class, r.getValue(FavouriteGroupItemMeta.TARGET_TYPE)));
			this.setEmployeeId(DataParser.parse(String.class, r.getValue(FavouriteGroupItemMeta.EMPLOYEE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(FavouriteGroupItemMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(FavouriteGroupItemMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(FavouriteGroupItemMeta.VERSION)));
			this.setCompanyId(DataParser.parse(String.class, r.getValue(FavouriteGroupItemMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(FavouriteGroupItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(FavouriteGroupItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(FavouriteGroupItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(FavouriteGroupItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(FavouriteGroupItemMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(FavouriteGroupItemMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(FavouriteGroupItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(FavouriteGroupItemMeta.ID)));
			return true;
		} else {
			try {
				this.setTemporary( (Integer)r.getValue(FavouriteGroupItemMeta.TEMPORARY));
				this.setTargetName( (String)r.getValue(FavouriteGroupItemMeta.TARGET_NAME));
				this.setTargetId( (String)r.getValue(FavouriteGroupItemMeta.TARGET_ID));
				this.setGroupId( (String)r.getValue(FavouriteGroupItemMeta.GROUP_ID));
				this.setTargetType( (String)r.getValue(FavouriteGroupItemMeta.TARGET_TYPE));
				this.setEmployeeId( (String)r.getValue(FavouriteGroupItemMeta.EMPLOYEE_ID));
				this.setUpdateTime( (Date)r.getValue(FavouriteGroupItemMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(FavouriteGroupItemMeta.SORT));
				this.setVersion( (Integer)r.getValue(FavouriteGroupItemMeta.VERSION));
				this.setCompanyId( (String)r.getValue(FavouriteGroupItemMeta.COMPANY_ID));
				this.setCreateBy( (String)r.getValue(FavouriteGroupItemMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(FavouriteGroupItemMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(FavouriteGroupItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(FavouriteGroupItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(FavouriteGroupItemMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(FavouriteGroupItemMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(FavouriteGroupItemMeta.DELETE_BY));
				this.setId( (String)r.getValue(FavouriteGroupItemMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}