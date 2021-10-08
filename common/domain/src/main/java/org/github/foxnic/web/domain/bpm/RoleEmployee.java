package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_ROLE_EMPLOYEE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程角色员工关系
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-08 17:28:36
 * @sign 47F5B84112D70C6882027733FAAFAA72
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_role_employee")
public class RoleEmployee extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_ROLE_EMPLOYEE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 角色ID：角色ID
	*/
	@ApiModelProperty(required = false,value="角色ID" , notes = "角色ID")
	private String roleId;
	
	/**
	 * 角色名称：角色名称
	*/
	@ApiModelProperty(required = false,value="角色名称" , notes = "角色名称")
	private String employeeId;
	
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
	public RoleEmployee setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 角色ID<br>
	 * 角色ID
	 * @return 角色ID
	*/
	public String getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置 角色ID
	 * @param roleId 角色ID
	 * @return 当前对象
	*/
	public RoleEmployee setRoleId(String roleId) {
		this.roleId=roleId;
		return this;
	}
	
	/**
	 * 获得 角色名称<br>
	 * 角色名称
	 * @return 角色名称
	*/
	public String getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * 设置 角色名称
	 * @param employeeId 角色名称
	 * @return 当前对象
	*/
	public RoleEmployee setEmployeeId(String employeeId) {
		this.employeeId=employeeId;
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
	public RoleEmployee setCreateBy(String createBy) {
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
	public RoleEmployee setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RoleEmployee , 转换好的 RoleEmployee 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RoleEmployee , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 RoleEmployee
	 * @param roleEmployeeMap 包含实体信息的 Map 对象
	 * @return RoleEmployee , 转换好的的 RoleEmployee 对象
	*/
	@Transient
	public static RoleEmployee createFrom(Map<String,Object> roleEmployeeMap) {
		if(roleEmployeeMap==null) return null;
		RoleEmployee po = EntityContext.create(RoleEmployee.class, roleEmployeeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 RoleEmployee
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RoleEmployee , 转换好的的 RoleEmployee 对象
	*/
	@Transient
	public static RoleEmployee createFrom(Object pojo) {
		if(pojo==null) return null;
		RoleEmployee po = EntityContext.create(RoleEmployee.class,pojo);
		return po;
	}

	/**
	 * 创建一个 RoleEmployee，等同于 new
	 * @return RoleEmployee 对象
	*/
	@Transient
	public static RoleEmployee create() {
		return EntityContext.create(RoleEmployee.class);
	}
}