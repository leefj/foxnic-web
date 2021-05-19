package com.scientific.tailoring.domain.crm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.CRM_EMPLOYEE;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import com.scientific.tailoring.domain.system.User;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:13:38
 * @sign 1B4E00AE745DFAA928C69A06D94117CE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "crm_employee")
public class Employee extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CRM_EMPLOYEE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private Long id;
	
	/**
	 * 所属部门ID：所属部门ID
	*/
	@ApiModelProperty(required = false,value="所属部门ID" , notes = "所属部门ID")
	private Long departmentId;
	
	/**
	 * 公司ID：公司ID
	*/
	@ApiModelProperty(required = false,value="公司ID" , notes = "公司ID")
	private Long companyId;
	
	/**
	 * 用户ID：用户ID
	*/
	@ApiModelProperty(required = false,value="用户ID" , notes = "用户ID")
	private Long userId;
	
	/**
	 * 员工姓名：员工姓名
	*/
	@ApiModelProperty(required = false,value="员工姓名" , notes = "员工姓名")
	private String name;
	
	/**
	 * 员工性别：员工性别
	*/
	@ApiModelProperty(required = false,value="员工性别" , notes = "员工性别")
	private String sex;
	
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
	 * 账户：当前员工对应的账户
	*/
	@ApiModelProperty(required = false,value="账户" , notes = "当前员工对应的账户")
	private User user;
	
	/**
	 * 获得 ID<br>
	 * 属性说明 : ID
	 * @return ID
	*/
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public Employee setId(Long id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 ID
	 * @param id ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 所属部门ID<br>
	 * 属性说明 : 所属部门ID
	 * @return 所属部门ID
	*/
	public Long getDepartmentId() {
		return departmentId;
	}
	
	/**
	 * 设置 所属部门ID
	 * @param departmentId 所属部门ID
	 * @return 当前对象
	*/
	public Employee setDepartmentId(Long departmentId) {
		this.departmentId=departmentId;
		return this;
	}
	
	/**
	 * 添加 所属部门ID
	 * @param departmentId 所属部门ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 公司ID<br>
	 * 属性说明 : 公司ID
	 * @return 公司ID
	*/
	public Long getCompanyId() {
		return companyId;
	}
	
	/**
	 * 设置 公司ID
	 * @param companyId 公司ID
	 * @return 当前对象
	*/
	public Employee setCompanyId(Long companyId) {
		this.companyId=companyId;
		return this;
	}
	
	/**
	 * 添加 公司ID
	 * @param companyId 公司ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 用户ID<br>
	 * 属性说明 : 用户ID
	 * @return 用户ID
	*/
	public Long getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户ID
	 * @param userId 用户ID
	 * @return 当前对象
	*/
	public Employee setUserId(Long userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 添加 用户ID
	 * @param userId 用户ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 员工姓名<br>
	 * 属性说明 : 员工姓名
	 * @return 员工姓名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 员工姓名
	 * @param name 员工姓名
	 * @return 当前对象
	*/
	public Employee setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 添加 员工姓名
	 * @param name 员工姓名
	 * @return 当前对象
	*/
	
	/**
	 * 获得 员工性别<br>
	 * 属性说明 : 员工性别
	 * @return 员工性别
	*/
	public String getSex() {
		return sex;
	}
	
	/**
	 * 设置 员工性别
	 * @param sex 员工性别
	 * @return 当前对象
	*/
	public Employee setSex(String sex) {
		this.sex=sex;
		return this;
	}
	
	/**
	 * 添加 员工性别
	 * @param sex 员工性别
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
	public Employee setCreateBy(Long createBy) {
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
	public Employee setCreateTime(Date createTime) {
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
	public Employee setUpdateBy(Long updateBy) {
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
	public Employee setUpdateTime(Date updateTime) {
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
	public Employee setDeleted(Boolean deleted) {
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
	public Employee setDeleteBy(Long deleteBy) {
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
	public Employee setDeleteTime(Date deleteTime) {
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
	public Employee setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	
	/**
	 * 获得 账户<br>
	 * 属性说明 : 当前员工对应的账户
	 * @return 账户
	*/
	public User getUser() {
		return user;
	}
	
	/**
	 * 设置 账户
	 * @param user 账户
	 * @return 当前对象
	*/
	public Employee setUser(User user) {
		this.user=user;
		return this;
	}
	
	/**
	 * 添加 账户
	 * @param user 账户
	 * @return 当前对象
	*/

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
		return new Employee();
	}
}