package org.github.foxnic.web.domain.hrm;

import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_EMPLOYEE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import org.github.foxnic.web.domain.system.BusiRole;
import java.util.ArrayList;
import javax.persistence.Transient;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 员工
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-27 12:57:48
 * @sign 92136229B911D012DBBA1AB4C19C7555
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hrm_employee")
public class Employee extends Person {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HRM_EMPLOYEE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private String id;
	
	/**
	 * 工号：工号
	*/
	@ApiModelProperty(required = false,value="工号" , notes = "工号")
	private String badge;
	
	/**
	 * 手机号：手机号
	*/
	@ApiModelProperty(required = false,value="手机号" , notes = "手机号")
	private String phone;
	
	/**
	 * 人员ID：人员ID
	*/
	@ApiModelProperty(required = false,value="人员ID" , notes = "人员ID")
	private String personId;
	
	/**
	 * 公司ID：公司ID
	*/
	@ApiModelProperty(required = false,value="公司ID" , notes = "公司ID")
	private String companyId;
	
	/**
	 * 状态：字典代码：employee_status
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "字典代码：employee_status")
	private String status;
	
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
	 * 副岗ID：多个用逗号隔开
	*/
	@ApiModelProperty(required = false,value="副岗ID" , notes = "多个用逗号隔开")
	private List<String> vicePositionIds;
	
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
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public Employee setDeleted(Integer deleted) {
		this.deleted=deleted;
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
	public Employee addPosition(Position position) {
		if(this.positions==null) positions=new ArrayList<>();
		this.positions.add(position);
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
	public Employee addOrganization(Organization organization) {
		if(this.organizations==null) organizations=new ArrayList<>();
		this.organizations.add(organization);
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
	public Employee addBusiRole(BusiRole busiRole) {
		if(this.busiRoles==null) busiRoles=new ArrayList<>();
		this.busiRoles.add(busiRole);
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
	 * 获得 副岗ID<br>
	 * 多个用逗号隔开
	 * @return 副岗ID
	*/
	public List<String> getVicePositionIds() {
		return vicePositionIds;
	}
	
	/**
	 * 设置 副岗ID
	 * @param vicePositionIds 副岗ID
	 * @return 当前对象
	*/
	public Employee setVicePositionIds(List<String> vicePositionIds) {
		this.vicePositionIds=vicePositionIds;
		return this;
	}
	
	/**
	 * 添加 副岗ID
	 * @param vicePositionId 副岗ID
	 * @return 当前对象
	*/
	public Employee addVicePositionId(String vicePositionId) {
		if(this.vicePositionIds==null) vicePositionIds=new ArrayList<>();
		this.vicePositionIds.add(vicePositionId);
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
	 * 将 Map 转换成 Employee
	 * @param employeeMap 包含实体信息的 Map 对象
	 * @return Employee , 转换好的的 Employee 对象
	*/
	@Transient
	public static Employee createFrom(Map<String,Object> employeeMap) {
		if(employeeMap==null) return null;
		Employee po = EntityContext.create(Employee.class, employeeMap);
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
		Employee po = EntityContext.create(Employee.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Employee，等同于 new
	 * @return Employee 对象
	*/
	@Transient
	public static Employee create() {
		return EntityContext.create(Employee.class);
	}
}