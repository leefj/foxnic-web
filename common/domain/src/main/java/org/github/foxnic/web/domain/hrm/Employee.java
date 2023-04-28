package org.github.foxnic.web.domain.hrm;

import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_EMPLOYEE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.system.BusiRole;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 员工
 * <p>员工 , 数据表 hrm_employee 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-28 13:56:33
 * @sign 7580AAE6B21C4CFC8528920D8C954D35
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hrm_employee")
@ApiModel(description = "员工 ; 员工 , 数据表 hrm_employee 的PO类型" , parent = Person.class)
public class Employee extends Person {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HRM_EMPLOYEE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "483314882310049792")
	private String id;
	
	/**
	 * 工号：工号
	*/
	@ApiModelProperty(required = false,value="工号" , notes = "工号" , example = "20170826001")
	private String badge;
	
	/**
	 * 手机号：手机号
	*/
	@ApiModelProperty(required = false,value="手机号" , notes = "手机号")
	private String phone;
	
	/**
	 * 人员ID：人员ID
	*/
	@ApiModelProperty(required = false,value="人员ID" , notes = "人员ID" , example = "483314882146471936")
	private String personId;
	
	/**
	 * 公司ID：公司ID
	*/
	@ApiModelProperty(required = false,value="公司ID" , notes = "公司ID" , example = "001")
	private String companyId;
	
	/**
	 * 状态：字典代码：employee_status
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "字典代码：employee_status" , example = "active")
	private String status;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = false,value="租户ID" , notes = "租户ID" , example = "T001")
	private String tenantId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2021-08-26 04:40:47")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2021-08-26 08:59:26")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "5")
	private Integer version;
	
	/**
	 * 类型：字典代码：employee_code
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "字典代码：employee_code")
	private String type;
	
	/**
	 * 直属领导ID：员工ID
	*/
	@ApiModelProperty(required = false,value="直属领导ID" , notes = "员工ID")
	private String directLeaderId;
	
	/**
	 * 对应的人员信息：对应的人员信息
	*/
	@ApiModelProperty(required = false,value="对应的人员信息" , notes = "对应的人员信息")
	private Person person;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private Company company;
	
	/**
	 * 姓名与工号：虚拟属性
	*/
	@ApiModelProperty(required = false,value="姓名与工号" , notes = "虚拟属性")
	private String nameAndBadge;
	
	/**
	 * 岗位清单：作为员工时，所属的岗位清单
	*/
	@ApiModelProperty(required = false,value="岗位清单" , notes = "作为员工时，所属的岗位清单")
	private List<Position> positions;
	
	/**
	 * 组织清单：作为员工时，所属的组织清单
	*/
	@ApiModelProperty(required = false,value="组织清单" , notes = "作为员工时，所属的组织清单")
	private List<Organization> organizations;
	
	/**
	 * 主岗：作为员工时，所属的主岗
	*/
	@ApiModelProperty(required = false,value="主岗" , notes = "作为员工时，所属的主岗")
	private Position primaryPosition;
	
	/**
	 * 主岗部门：作为员工时，所属的主岗部门
	*/
	@ApiModelProperty(required = false,value="主岗部门" , notes = "作为员工时，所属的主岗部门")
	private Organization primaryOrganization;
	
	/**
	 * 业务角色清单：作为员工时，所属的业务角色
	*/
	@ApiModelProperty(required = false,value="业务角色清单" , notes = "作为员工时，所属的业务角色")
	private List<BusiRole> busiRoles;
	
	/**
	 * 主岗ID：只有一个
	*/
	@ApiModelProperty(required = false,value="主岗ID" , notes = "只有一个")
	private String primaryPositionId;
	
	/**
	 * 兼岗ID：多个用逗号隔开
	*/
	@ApiModelProperty(required = false,value="兼岗ID" , notes = "多个用逗号隔开")
	private List<String> vicePositionIds;
	
	/**
	 * 兼岗：作为员工时，所属的兼岗
	*/
	@ApiModelProperty(required = false,value="兼岗" , notes = "作为员工时，所属的兼岗")
	private List<Position> vicePositions;
	
	/**
	 * 扩展信息：员工扩展信息
	*/
	@ApiModelProperty(required = false,value="扩展信息" , notes = "员工扩展信息")
	private Map<String,Object> extInfo;
	
	/**
	 * 直属领导：直属领导
	*/
	@ApiModelProperty(required = false,value="直属领导" , notes = "直属领导")
	private Employee directLeader;
	
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
	public Employee setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 工号<br>
	 * 工号
	 * @return 工号
	*/
	public String getBadge() {
		return badge;
	}
	
	/**
	 * 设置 工号
	 * @param badge 工号
	 * @return 当前对象
	*/
	public Employee setBadge(String badge) {
		this.badge=badge;
		return this;
	}
	
	/**
	 * 获得 手机号<br>
	 * 手机号
	 * @return 手机号
	*/
	public String getPhone() {
		return phone;
	}
	
	/**
	 * 设置 手机号
	 * @param phone 手机号
	 * @return 当前对象
	*/
	public Employee setPhone(String phone) {
		this.phone=phone;
		return this;
	}
	
	/**
	 * 获得 人员ID<br>
	 * 人员ID
	 * @return 人员ID
	*/
	public String getPersonId() {
		return personId;
	}
	
	/**
	 * 设置 人员ID
	 * @param personId 人员ID
	 * @return 当前对象
	*/
	public Employee setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 公司ID<br>
	 * 公司ID
	 * @return 公司ID
	*/
	public String getCompanyId() {
		return companyId;
	}
	
	/**
	 * 设置 公司ID
	 * @param companyId 公司ID
	 * @return 当前对象
	*/
	public Employee setCompanyId(String companyId) {
		this.companyId=companyId;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 字典代码：employee_status
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public Employee setStatus(String status) {
		this.status=status;
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
	public Employee setTenantId(String tenantId) {
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
	public Employee setCreateBy(String createBy) {
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
	public Employee setCreateTime(Date createTime) {
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
	public Employee setUpdateBy(String updateBy) {
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
	public Employee setUpdateTime(Date updateTime) {
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
	public Employee setDeleted(Integer deleted) {
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
	public Employee setDeleted(Boolean deletedBool) {
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
	public Employee setDeleteBy(String deleteBy) {
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
	public Employee setDeleteTime(Date deleteTime) {
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
	public Employee setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 字典代码：employee_code
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public Employee setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 直属领导ID<br>
	 * 员工ID
	 * @return 直属领导ID
	*/
	public String getDirectLeaderId() {
		return directLeaderId;
	}
	
	/**
	 * 设置 直属领导ID
	 * @param directLeaderId 直属领导ID
	 * @return 当前对象
	*/
	public Employee setDirectLeaderId(String directLeaderId) {
		this.directLeaderId=directLeaderId;
		return this;
	}
	
	/**
	 * 获得 对应的人员信息<br>
	 * 对应的人员信息
	 * @return 对应的人员信息
	*/
	public Person getPerson() {
		return person;
	}
	
	/**
	 * 设置 对应的人员信息
	 * @param person 对应的人员信息
	 * @return 当前对象
	*/
	public Employee setPerson(Person person) {
		this.person=person;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public Company getCompany() {
		return company;
	}
	
	/**
	 * 设置 所属公司
	 * @param company 所属公司
	 * @return 当前对象
	*/
	public Employee setCompany(Company company) {
		this.company=company;
		return this;
	}
	
	/**
	 * 获得 姓名与工号<br>
	 * 虚拟属性
	 * @return 姓名与工号
	*/
	public String getNameAndBadge() {
		return nameAndBadge;
	}
	
	/**
	 * 设置 姓名与工号
	 * @param nameAndBadge 姓名与工号
	 * @return 当前对象
	*/
	public Employee setNameAndBadge(String nameAndBadge) {
		this.nameAndBadge=nameAndBadge;
		return this;
	}
	
	/**
	 * 获得 岗位清单<br>
	 * 作为员工时，所属的岗位清单
	 * @return 岗位清单
	*/
	public List<Position> getPositions() {
		return positions;
	}
	
	/**
	 * 设置 岗位清单
	 * @param positions 岗位清单
	 * @return 当前对象
	*/
	public Employee setPositions(List<Position> positions) {
		this.positions=positions;
		return this;
	}
	
	/**
	 * 添加 岗位清单
	 * @param position 岗位清单
	 * @return 当前对象
	*/
	public Employee addPosition(Position... position) {
		if(this.positions==null) positions=new ArrayList<>();
		this.positions.addAll(Arrays.asList(position));
		return this;
	}
	
	/**
	 * 获得 组织清单<br>
	 * 作为员工时，所属的组织清单
	 * @return 组织清单
	*/
	public List<Organization> getOrganizations() {
		return organizations;
	}
	
	/**
	 * 设置 组织清单
	 * @param organizations 组织清单
	 * @return 当前对象
	*/
	public Employee setOrganizations(List<Organization> organizations) {
		this.organizations=organizations;
		return this;
	}
	
	/**
	 * 添加 组织清单
	 * @param organization 组织清单
	 * @return 当前对象
	*/
	public Employee addOrganization(Organization... organization) {
		if(this.organizations==null) organizations=new ArrayList<>();
		this.organizations.addAll(Arrays.asList(organization));
		return this;
	}
	
	/**
	 * 获得 主岗<br>
	 * 作为员工时，所属的主岗
	 * @return 主岗
	*/
	public Position getPrimaryPosition() {
		return primaryPosition;
	}
	
	/**
	 * 设置 主岗
	 * @param primaryPosition 主岗
	 * @return 当前对象
	*/
	public Employee setPrimaryPosition(Position primaryPosition) {
		this.primaryPosition=primaryPosition;
		return this;
	}
	
	/**
	 * 获得 主岗部门<br>
	 * 作为员工时，所属的主岗部门
	 * @return 主岗部门
	*/
	public Organization getPrimaryOrganization() {
		return primaryOrganization;
	}
	
	/**
	 * 设置 主岗部门
	 * @param primaryOrganization 主岗部门
	 * @return 当前对象
	*/
	public Employee setPrimaryOrganization(Organization primaryOrganization) {
		this.primaryOrganization=primaryOrganization;
		return this;
	}
	
	/**
	 * 获得 业务角色清单<br>
	 * 作为员工时，所属的业务角色
	 * @return 业务角色清单
	*/
	public List<BusiRole> getBusiRoles() {
		return busiRoles;
	}
	
	/**
	 * 设置 业务角色清单
	 * @param busiRoles 业务角色清单
	 * @return 当前对象
	*/
	public Employee setBusiRoles(List<BusiRole> busiRoles) {
		this.busiRoles=busiRoles;
		return this;
	}
	
	/**
	 * 添加 业务角色清单
	 * @param busiRole 业务角色清单
	 * @return 当前对象
	*/
	public Employee addBusiRole(BusiRole... busiRole) {
		if(this.busiRoles==null) busiRoles=new ArrayList<>();
		this.busiRoles.addAll(Arrays.asList(busiRole));
		return this;
	}
	
	/**
	 * 获得 主岗ID<br>
	 * 只有一个
	 * @return 主岗ID
	*/
	public String getPrimaryPositionId() {
		return primaryPositionId;
	}
	
	/**
	 * 设置 主岗ID
	 * @param primaryPositionId 主岗ID
	 * @return 当前对象
	*/
	public Employee setPrimaryPositionId(String primaryPositionId) {
		this.primaryPositionId=primaryPositionId;
		return this;
	}
	
	/**
	 * 获得 兼岗ID<br>
	 * 多个用逗号隔开
	 * @return 兼岗ID
	*/
	public List<String> getVicePositionIds() {
		return vicePositionIds;
	}
	
	/**
	 * 设置 兼岗ID
	 * @param vicePositionIds 兼岗ID
	 * @return 当前对象
	*/
	public Employee setVicePositionIds(List<String> vicePositionIds) {
		this.vicePositionIds=vicePositionIds;
		return this;
	}
	
	/**
	 * 添加 兼岗ID
	 * @param vicePositionId 兼岗ID
	 * @return 当前对象
	*/
	public Employee addVicePositionId(String... vicePositionId) {
		if(this.vicePositionIds==null) vicePositionIds=new ArrayList<>();
		this.vicePositionIds.addAll(Arrays.asList(vicePositionId));
		return this;
	}
	
	/**
	 * 获得 兼岗<br>
	 * 作为员工时，所属的兼岗
	 * @return 兼岗
	*/
	public List<Position> getVicePositions() {
		return vicePositions;
	}
	
	/**
	 * 设置 兼岗
	 * @param vicePositions 兼岗
	 * @return 当前对象
	*/
	public Employee setVicePositions(List<Position> vicePositions) {
		this.vicePositions=vicePositions;
		return this;
	}
	
	/**
	 * 添加 兼岗
	 * @param vicePosition 兼岗
	 * @return 当前对象
	*/
	public Employee addVicePosition(Position... vicePosition) {
		if(this.vicePositions==null) vicePositions=new ArrayList<>();
		this.vicePositions.addAll(Arrays.asList(vicePosition));
		return this;
	}
	
	/**
	 * 获得 扩展信息<br>
	 * 员工扩展信息
	 * @return 扩展信息
	*/
	public Map<String,Object> getExtInfo() {
		return extInfo;
	}
	
	/**
	 * 设置 扩展信息
	 * @param extInfo 扩展信息
	 * @return 当前对象
	*/
	public Employee setExtInfo(Map<String,Object> extInfo) {
		this.extInfo=extInfo;
		return this;
	}
	
	/**
	 * 添加 扩展信息
	 * @param key 键
	 * @param extInfo 扩展信息
	 * @return 当前对象
	*/
	public Employee putExtInfo(String key,Object extInfo) {
		if(this.extInfo==null) this.extInfo=new HashMap<>();
		this.extInfo.put(key ,extInfo);
		return this;
	}
	
	/**
	 * 获得 直属领导<br>
	 * 直属领导
	 * @return 直属领导
	*/
	public Employee getDirectLeader() {
		return directLeader;
	}
	
	/**
	 * 设置 直属领导
	 * @param directLeader 直属领导
	 * @return 当前对象
	*/
	public Employee setDirectLeader(Employee directLeader) {
		this.directLeader=directLeader;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Employee , 转换好的 Employee 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Employee , 转换好的 PoJo 对象
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
	public Employee clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Employee duplicate(boolean all) {
		org.github.foxnic.web.domain.hrm.meta.EmployeeMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.hrm.meta.EmployeeMeta.$$proxy$$();
		inst.setDirectLeaderId(this.getDirectLeaderId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setBadge(this.getBadge());
		inst.setCompanyId(this.getCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPhone(this.getPhone());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setVicePositions(this.getVicePositions());
			inst.setSource(this.getSource());
			inst.setPrimaryPosition(this.getPrimaryPosition());
			inst.setExtInfo(this.getExtInfo());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setIdentity(this.getIdentity());
			inst.setCompany(this.getCompany());
			inst.setId(this.getId());
			inst.setSex(this.getSex());
			inst.setDirectLeader(this.getDirectLeader());
			inst.setPrimaryPositionId(this.getPrimaryPositionId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setPositions(this.getPositions());
			inst.setVersion(this.getVersion());
			inst.setVicePositionIds(this.getVicePositionIds());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setPerson(this.getPerson());
			inst.setName(this.getName());
			inst.setNameAndBadge(this.getNameAndBadge());
			inst.setOrganizations(this.getOrganizations());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setBusiRoles(this.getBusiRoles());
			inst.setPrimaryOrganization(this.getPrimaryOrganization());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Employee clone(boolean deep) {
		return EntityContext.clone(Employee.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Employee
	 * @param employeeMap 包含实体信息的 Map 对象
	 * @return Employee , 转换好的的 Employee 对象
	*/
	@Transient
	public static Employee createFrom(Map<String,Object> employeeMap) {
		if(employeeMap==null) return null;
		Employee po = create();
		EntityContext.copyProperties(po,employeeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Employee
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Employee , 转换好的的 Employee 对象
	*/
	@Transient
	public static Employee createFrom(Object pojo) {
		if(pojo==null) return null;
		Employee po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Employee，等同于 new
	 * @return Employee 对象
	*/
	@Transient
	public static Employee create() {
		return new org.github.foxnic.web.domain.hrm.meta.EmployeeMeta.$$proxy$$();
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
			this.setDirectLeaderId(DataParser.parse(String.class, map.get(EmployeeMeta.DIRECT_LEADER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(EmployeeMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(EmployeeMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(EmployeeMeta.VERSION)));
			this.setBadge(DataParser.parse(String.class, map.get(EmployeeMeta.BADGE)));
			this.setCompanyId(DataParser.parse(String.class, map.get(EmployeeMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(EmployeeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(EmployeeMeta.DELETED)));
			this.setPhone(DataParser.parse(String.class, map.get(EmployeeMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(EmployeeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(EmployeeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(EmployeeMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(EmployeeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(EmployeeMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(EmployeeMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(EmployeeMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(EmployeeMeta.STATUS)));
			// others
			this.setSource(DataParser.parse(String.class, map.get(EmployeeMeta.SOURCE)));
			this.setPrimaryPosition(DataParser.parse(Position.class, map.get(EmployeeMeta.PRIMARY_POSITION)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(EmployeeMeta.UPDATE_BY)));
			this.setIdentity(DataParser.parse(String.class, map.get(EmployeeMeta.IDENTITY)));
			this.setCompany(DataParser.parse(Company.class, map.get(EmployeeMeta.COMPANY)));
			this.setId(DataParser.parse(String.class, map.get(EmployeeMeta.ID)));
			this.setSex(DataParser.parse(String.class, map.get(EmployeeMeta.SEX)));
			this.setDirectLeader(DataParser.parse(Employee.class, map.get(EmployeeMeta.DIRECT_LEADER)));
			this.setPrimaryPositionId(DataParser.parse(String.class, map.get(EmployeeMeta.PRIMARY_POSITION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(EmployeeMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(EmployeeMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(EmployeeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(EmployeeMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(EmployeeMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(EmployeeMeta.DELETE_TIME)));
			this.setPerson(DataParser.parse(Person.class, map.get(EmployeeMeta.PERSON)));
			this.setName(DataParser.parse(String.class, map.get(EmployeeMeta.NAME)));
			this.setNameAndBadge(DataParser.parse(String.class, map.get(EmployeeMeta.NAME_AND_BADGE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(EmployeeMeta.DELETE_BY)));
			this.setPrimaryOrganization(DataParser.parse(Organization.class, map.get(EmployeeMeta.PRIMARY_ORGANIZATION)));
			return true;
		} else {
			try {
				this.setDirectLeaderId( (String)map.get(EmployeeMeta.DIRECT_LEADER_ID));
				this.setUpdateTime( (Date)map.get(EmployeeMeta.UPDATE_TIME));
				this.setType( (String)map.get(EmployeeMeta.TYPE));
				this.setVersion( (Integer)map.get(EmployeeMeta.VERSION));
				this.setBadge( (String)map.get(EmployeeMeta.BADGE));
				this.setCompanyId( (String)map.get(EmployeeMeta.COMPANY_ID));
				this.setCreateBy( (String)map.get(EmployeeMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(EmployeeMeta.DELETED));
				this.setPhone( (String)map.get(EmployeeMeta.PHONE));
				this.setCreateTime( (Date)map.get(EmployeeMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(EmployeeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(EmployeeMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(EmployeeMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(EmployeeMeta.DELETE_BY));
				this.setPersonId( (String)map.get(EmployeeMeta.PERSON_ID));
				this.setId( (String)map.get(EmployeeMeta.ID));
				this.setStatus( (String)map.get(EmployeeMeta.STATUS));
				// others
				this.setSource( (String)map.get(EmployeeMeta.SOURCE));
				this.setPrimaryPosition( (Position)map.get(EmployeeMeta.PRIMARY_POSITION));
				this.setUpdateBy( (String)map.get(EmployeeMeta.UPDATE_BY));
				this.setIdentity( (String)map.get(EmployeeMeta.IDENTITY));
				this.setCompany( (Company)map.get(EmployeeMeta.COMPANY));
				this.setId( (String)map.get(EmployeeMeta.ID));
				this.setSex( (String)map.get(EmployeeMeta.SEX));
				this.setDirectLeader( (Employee)map.get(EmployeeMeta.DIRECT_LEADER));
				this.setPrimaryPositionId( (String)map.get(EmployeeMeta.PRIMARY_POSITION_ID));
				this.setUpdateTime( (Date)map.get(EmployeeMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(EmployeeMeta.VERSION));
				this.setCreateBy( (String)map.get(EmployeeMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(EmployeeMeta.DELETED));
				this.setCreateTime( (Date)map.get(EmployeeMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(EmployeeMeta.DELETE_TIME));
				this.setPerson( (Person)map.get(EmployeeMeta.PERSON));
				this.setName( (String)map.get(EmployeeMeta.NAME));
				this.setNameAndBadge( (String)map.get(EmployeeMeta.NAME_AND_BADGE));
				this.setDeleteBy( (String)map.get(EmployeeMeta.DELETE_BY));
				this.setPrimaryOrganization( (Organization)map.get(EmployeeMeta.PRIMARY_ORGANIZATION));
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
			this.setDirectLeaderId(DataParser.parse(String.class, r.getValue(EmployeeMeta.DIRECT_LEADER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(EmployeeMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(EmployeeMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(EmployeeMeta.VERSION)));
			this.setBadge(DataParser.parse(String.class, r.getValue(EmployeeMeta.BADGE)));
			this.setCompanyId(DataParser.parse(String.class, r.getValue(EmployeeMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(EmployeeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(EmployeeMeta.DELETED)));
			this.setPhone(DataParser.parse(String.class, r.getValue(EmployeeMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(EmployeeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(EmployeeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(EmployeeMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(EmployeeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(EmployeeMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(EmployeeMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(EmployeeMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(EmployeeMeta.STATUS)));
			return true;
		} else {
			try {
				this.setDirectLeaderId( (String)r.getValue(EmployeeMeta.DIRECT_LEADER_ID));
				this.setUpdateTime( (Date)r.getValue(EmployeeMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(EmployeeMeta.TYPE));
				this.setVersion( (Integer)r.getValue(EmployeeMeta.VERSION));
				this.setBadge( (String)r.getValue(EmployeeMeta.BADGE));
				this.setCompanyId( (String)r.getValue(EmployeeMeta.COMPANY_ID));
				this.setCreateBy( (String)r.getValue(EmployeeMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(EmployeeMeta.DELETED));
				this.setPhone( (String)r.getValue(EmployeeMeta.PHONE));
				this.setCreateTime( (Date)r.getValue(EmployeeMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(EmployeeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(EmployeeMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(EmployeeMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(EmployeeMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(EmployeeMeta.PERSON_ID));
				this.setId( (String)r.getValue(EmployeeMeta.ID));
				this.setStatus( (String)r.getValue(EmployeeMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}