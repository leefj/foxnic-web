package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_BUSI_ROLE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 业务角色
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-10 18:55:30
 * @sign C789DC860EE84EFC6956C3AFEBC55416
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_busi_role")
public class BusiRole extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_BUSI_ROLE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 所属组织ID：所属组织ID
	*/
	@ApiModelProperty(required = false,value="所属组织ID" , notes = "所属组织ID")
	private Integer orgId;
	
	/**
	 * 角色代码：角色代码
	*/
	@ApiModelProperty(required = false,value="角色代码" , notes = "角色代码")
	private String code;
	
	/**
	 * 角色名称：角色名称
	*/
	@ApiModelProperty(required = false,value="角色名称" , notes = "角色名称")
	private String name;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = true,value="是否有效" , notes = "是否有效")
	private Integer valid;
	
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
	 * 员工数量：员工数量
	*/
	@ApiModelProperty(required = false,value="员工数量" , notes = "员工数量")
	private Integer empCount;
	
	/**
	 * 关联员工清单：关联员工清单
	*/
	@ApiModelProperty(required = false,value="关联员工清单" , notes = "关联员工清单")
	private List<Employee> employees;
	
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
	public BusiRole setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属组织ID<br>
	 * 所属组织ID
	 * @return 所属组织ID
	*/
	public Integer getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 所属组织ID
	 * @param orgId 所属组织ID
	 * @return 当前对象
	*/
	public BusiRole setOrgId(Integer orgId) {
		this.orgId=orgId;
		return this;
	}
	
	/**
	 * 获得 角色代码<br>
	 * 角色代码
	 * @return 角色代码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 角色代码
	 * @param code 角色代码
	 * @return 当前对象
	*/
	public BusiRole setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 角色名称<br>
	 * 角色名称
	 * @return 角色名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 角色名称
	 * @param name 角色名称
	 * @return 当前对象
	*/
	public BusiRole setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 是否有效<br>
	 * 是否有效
	 * @return 是否有效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 是否有效
	 * @param valid 是否有效
	 * @return 当前对象
	*/
	public BusiRole setValid(Integer valid) {
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
	public BusiRole setCreateBy(String createBy) {
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
	public BusiRole setCreateTime(Date createTime) {
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
	public BusiRole setUpdateBy(String updateBy) {
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
	public BusiRole setUpdateTime(Date updateTime) {
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
	public BusiRole setDeleted(Integer deleted) {
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
	public BusiRole setDeleteBy(String deleteBy) {
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
	public BusiRole setDeleteTime(Date deleteTime) {
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
	public BusiRole setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 员工数量<br>
	 * 员工数量
	 * @return 员工数量
	*/
	public Integer getEmpCount() {
		return empCount;
	}
	
	/**
	 * 设置 员工数量
	 * @param empCount 员工数量
	 * @return 当前对象
	*/
	public BusiRole setEmpCount(Integer empCount) {
		this.empCount=empCount;
		return this;
	}
	
	/**
	 * 获得 关联员工清单<br>
	 * 关联员工清单
	 * @return 关联员工清单
	*/
	public List<Employee> getEmployees() {
		return employees;
	}
	
	/**
	 * 设置 关联员工清单
	 * @param employees 关联员工清单
	 * @return 当前对象
	*/
	public BusiRole setEmployees(List<Employee> employees) {
		this.employees=employees;
		return this;
	}
	
	/**
	 * 添加 关联员工清单
	 * @param employee 关联员工清单
	 * @return 当前对象
	*/
	public BusiRole addEmployee(Employee employee) {
		if(this.employees==null) employees=new ArrayList<>();
		this.employees.add(employee);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return BusiRole , 转换好的 BusiRole 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return BusiRole , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 BusiRole
	 * @param busiRoleMap 包含实体信息的 Map 对象
	 * @return BusiRole , 转换好的的 BusiRole 对象
	*/
	@Transient
	public static BusiRole createFrom(Map<String,Object> busiRoleMap) {
		if(busiRoleMap==null) return null;
		BusiRole po = EntityContext.create(BusiRole.class, busiRoleMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 BusiRole
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return BusiRole , 转换好的的 BusiRole 对象
	*/
	@Transient
	public static BusiRole createFrom(Object pojo) {
		if(pojo==null) return null;
		BusiRole po = EntityContext.create(BusiRole.class,pojo);
		return po;
	}

	/**
	 * 创建一个 BusiRole，等同于 new
	 * @return BusiRole 对象
	*/
	@Transient
	public static BusiRole create() {
		return EntityContext.create(BusiRole.class);
	}
}