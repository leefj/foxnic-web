package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.sql.meta.DBTable;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE_CAR;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Position;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Map;



/**
 * null
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-22 15:26:07
 * @sign 66CEC4EC000471F3E4D053047A2B8D18
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_code_example_car")
public class CodeExampleCar extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_CODE_EXAMPLE_CAR.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 属主ID：属主ID
	*/
	@ApiModelProperty(required = false,value="属主ID" , notes = "属主ID")
	private String exampleId;
	
	/**
	 * 车牌号：车牌号
	*/
	@ApiModelProperty(required = false,value="车牌号" , notes = "车牌号")
	private String plateNumber;
	
	/**
	 * 颜色：颜色
	*/
	@ApiModelProperty(required = false,value="颜色" , notes = "颜色")
	private String color;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
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
	 * 岗位单选：岗位单选
	*/
	@ApiModelProperty(required = false,value="岗位单选" , notes = "岗位单选")
	private String positionId;
	
	/**
	 * 组织单选：组织单选
	*/
	@ApiModelProperty(required = false,value="组织单选" , notes = "组织单选")
	private String orgId;
	
	/**
	 * 员工单选：员工单选
	*/
	@ApiModelProperty(required = false,value="员工单选" , notes = "员工单选")
	private String empId;
	
	/**
	 * 岗位多选：岗位多选
	*/
	@ApiModelProperty(required = false,value="岗位多选" , notes = "岗位多选")
	private String positionIds;
	
	/**
	 * 组织多选：组织多选
	*/
	@ApiModelProperty(required = false,value="组织多选" , notes = "组织多选")
	private String orgIds;
	
	/**
	 * 员工多选：员工多选
	*/
	@ApiModelProperty(required = false,value="员工多选" , notes = "员工多选")
	private String empIds;
	
	/**
	 * 员工下拉：员工下拉
	*/
	@ApiModelProperty(required = false,value="员工下拉" , notes = "员工下拉")
	private String selectEmpId;
	
	/**
	 * 公司单选：公司单选
	*/
	@ApiModelProperty(required = false,value="公司单选" , notes = "公司单选")
	private String comId;
	
	/**
	 * 部门多选：部门多选
	*/
	@ApiModelProperty(required = false,value="部门多选" , notes = "部门多选")
	private String deptIds;
	
	/**
	 * 限定上级：限定上级
	*/
	@ApiModelProperty(required = false,value="限定上级" , notes = "限定上级")
	private String subOrgId;
	
	/**
	 * 关联组织：关联组织
	*/
	@ApiModelProperty(required = false,value="关联组织" , notes = "关联组织")
	private Organization organization;
	
	/**
	 * 关联组织：关联组织
	*/
	@ApiModelProperty(required = false,value="关联组织" , notes = "关联组织")
	private Organization subOrganization;
	
	/**
	 * 关联公司：关联公司
	*/
	@ApiModelProperty(required = false,value="关联公司" , notes = "关联公司")
	private Organization company;
	
	/**
	 * 关联岗位：关联岗位
	*/
	@ApiModelProperty(required = false,value="关联岗位" , notes = "关联岗位")
	private Position position;
	
	/**
	 * 关联人员：关联人员
	*/
	@ApiModelProperty(required = false,value="关联人员" , notes = "关联人员")
	private Employee employee;
	
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
	public CodeExampleCar setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 属主ID<br>
	 * 属主ID
	 * @return 属主ID
	*/
	public String getExampleId() {
		return exampleId;
	}
	
	/**
	 * 设置 属主ID
	 * @param exampleId 属主ID
	 * @return 当前对象
	*/
	public CodeExampleCar setExampleId(String exampleId) {
		this.exampleId=exampleId;
		return this;
	}
	
	/**
	 * 获得 车牌号<br>
	 * 车牌号
	 * @return 车牌号
	*/
	public String getPlateNumber() {
		return plateNumber;
	}
	
	/**
	 * 设置 车牌号
	 * @param plateNumber 车牌号
	 * @return 当前对象
	*/
	public CodeExampleCar setPlateNumber(String plateNumber) {
		this.plateNumber=plateNumber;
		return this;
	}
	
	/**
	 * 获得 颜色<br>
	 * 颜色
	 * @return 颜色
	*/
	public String getColor() {
		return color;
	}
	
	/**
	 * 设置 颜色
	 * @param color 颜色
	 * @return 当前对象
	*/
	public CodeExampleCar setColor(String color) {
		this.color=color;
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
	public CodeExampleCar setVersion(Integer version) {
		this.version=version;
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
	public CodeExampleCar setCreateBy(String createBy) {
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
	public CodeExampleCar setCreateTime(Date createTime) {
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
	public CodeExampleCar setUpdateBy(String updateBy) {
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
	public CodeExampleCar setUpdateTime(Date updateTime) {
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
	public CodeExampleCar setDeleted(Integer deleted) {
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
	public CodeExampleCar setDeleteBy(String deleteBy) {
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
	public CodeExampleCar setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 岗位单选<br>
	 * 岗位单选
	 * @return 岗位单选
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 岗位单选
	 * @param positionId 岗位单选
	 * @return 当前对象
	*/
	public CodeExampleCar setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 组织单选<br>
	 * 组织单选
	 * @return 组织单选
	*/
	public String getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 组织单选
	 * @param orgId 组织单选
	 * @return 当前对象
	*/
	public CodeExampleCar setOrgId(String orgId) {
		this.orgId=orgId;
		return this;
	}
	
	/**
	 * 获得 员工单选<br>
	 * 员工单选
	 * @return 员工单选
	*/
	public String getEmpId() {
		return empId;
	}
	
	/**
	 * 设置 员工单选
	 * @param empId 员工单选
	 * @return 当前对象
	*/
	public CodeExampleCar setEmpId(String empId) {
		this.empId=empId;
		return this;
	}
	
	/**
	 * 获得 岗位多选<br>
	 * 岗位多选
	 * @return 岗位多选
	*/
	public String getPositionIds() {
		return positionIds;
	}
	
	/**
	 * 设置 岗位多选
	 * @param positionIds 岗位多选
	 * @return 当前对象
	*/
	public CodeExampleCar setPositionIds(String positionIds) {
		this.positionIds=positionIds;
		return this;
	}
	
	/**
	 * 获得 组织多选<br>
	 * 组织多选
	 * @return 组织多选
	*/
	public String getOrgIds() {
		return orgIds;
	}
	
	/**
	 * 设置 组织多选
	 * @param orgIds 组织多选
	 * @return 当前对象
	*/
	public CodeExampleCar setOrgIds(String orgIds) {
		this.orgIds=orgIds;
		return this;
	}
	
	/**
	 * 获得 员工多选<br>
	 * 员工多选
	 * @return 员工多选
	*/
	public String getEmpIds() {
		return empIds;
	}
	
	/**
	 * 设置 员工多选
	 * @param empIds 员工多选
	 * @return 当前对象
	*/
	public CodeExampleCar setEmpIds(String empIds) {
		this.empIds=empIds;
		return this;
	}
	
	/**
	 * 获得 员工下拉<br>
	 * 员工下拉
	 * @return 员工下拉
	*/
	public String getSelectEmpId() {
		return selectEmpId;
	}
	
	/**
	 * 设置 员工下拉
	 * @param selectEmpId 员工下拉
	 * @return 当前对象
	*/
	public CodeExampleCar setSelectEmpId(String selectEmpId) {
		this.selectEmpId=selectEmpId;
		return this;
	}
	
	/**
	 * 获得 公司单选<br>
	 * 公司单选
	 * @return 公司单选
	*/
	public String getComId() {
		return comId;
	}
	
	/**
	 * 设置 公司单选
	 * @param comId 公司单选
	 * @return 当前对象
	*/
	public CodeExampleCar setComId(String comId) {
		this.comId=comId;
		return this;
	}
	
	/**
	 * 获得 部门多选<br>
	 * 部门多选
	 * @return 部门多选
	*/
	public String getDeptIds() {
		return deptIds;
	}
	
	/**
	 * 设置 部门多选
	 * @param deptIds 部门多选
	 * @return 当前对象
	*/
	public CodeExampleCar setDeptIds(String deptIds) {
		this.deptIds=deptIds;
		return this;
	}
	
	/**
	 * 获得 限定上级<br>
	 * 限定上级
	 * @return 限定上级
	*/
	public String getSubOrgId() {
		return subOrgId;
	}
	
	/**
	 * 设置 限定上级
	 * @param subOrgId 限定上级
	 * @return 当前对象
	*/
	public CodeExampleCar setSubOrgId(String subOrgId) {
		this.subOrgId=subOrgId;
		return this;
	}
	
	/**
	 * 获得 关联组织<br>
	 * 关联组织
	 * @return 关联组织
	*/
	public Organization getOrganization() {
		return organization;
	}
	
	/**
	 * 设置 关联组织
	 * @param organization 关联组织
	 * @return 当前对象
	*/
	public CodeExampleCar setOrganization(Organization organization) {
		this.organization=organization;
		return this;
	}
	
	/**
	 * 获得 关联组织<br>
	 * 关联组织
	 * @return 关联组织
	*/
	public Organization getSubOrganization() {
		return subOrganization;
	}
	
	/**
	 * 设置 关联组织
	 * @param subOrganization 关联组织
	 * @return 当前对象
	*/
	public CodeExampleCar setSubOrganization(Organization subOrganization) {
		this.subOrganization=subOrganization;
		return this;
	}
	
	/**
	 * 获得 关联公司<br>
	 * 关联公司
	 * @return 关联公司
	*/
	public Organization getCompany() {
		return company;
	}
	
	/**
	 * 设置 关联公司
	 * @param company 关联公司
	 * @return 当前对象
	*/
	public CodeExampleCar setCompany(Organization company) {
		this.company=company;
		return this;
	}
	
	/**
	 * 获得 关联岗位<br>
	 * 关联岗位
	 * @return 关联岗位
	*/
	public Position getPosition() {
		return position;
	}
	
	/**
	 * 设置 关联岗位
	 * @param position 关联岗位
	 * @return 当前对象
	*/
	public CodeExampleCar setPosition(Position position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 获得 关联人员<br>
	 * 关联人员
	 * @return 关联人员
	*/
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * 设置 关联人员
	 * @param employee 关联人员
	 * @return 当前对象
	*/
	public CodeExampleCar setEmployee(Employee employee) {
		this.employee=employee;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CodeExampleCar , 转换好的 CodeExampleCar 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CodeExampleCar , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 CodeExampleCar
	 * @param codeExampleCarMap 包含实体信息的 Map 对象
	 * @return CodeExampleCar , 转换好的的 CodeExampleCar 对象
	*/
	@Transient
	public static CodeExampleCar createFrom(Map<String,Object> codeExampleCarMap) {
		if(codeExampleCarMap==null) return null;
		CodeExampleCar po = EntityContext.create(CodeExampleCar.class, codeExampleCarMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 CodeExampleCar
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CodeExampleCar , 转换好的的 CodeExampleCar 对象
	*/
	@Transient
	public static CodeExampleCar createFrom(Object pojo) {
		if(pojo==null) return null;
		CodeExampleCar po = EntityContext.create(CodeExampleCar.class,pojo);
		return po;
	}

	/**
	 * 创建一个 CodeExampleCar，等同于 new
	 * @return CodeExampleCar 对象
	*/
	@Transient
	public static CodeExampleCar create() {
		return EntityContext.create(CodeExampleCar.class);
	}
}