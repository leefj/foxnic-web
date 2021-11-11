package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_BUSI_ROLE_MEMBER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 业务角色成员关系
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-11 15:25:29
 * @sign 293B3392AEBA621BE52D89818B2B5BF8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_busi_role_member")
public class BusiRoleMember extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_BUSI_ROLE_MEMBER.$TABLE;
	
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
	 * 成员ID：成员ID
	*/
	@ApiModelProperty(required = false,value="成员ID" , notes = "成员ID")
	private String memberId;
	
	/**
	 * 成员类型：UnifiedUserType枚举
	*/
	@ApiModelProperty(required = false,value="成员类型" , notes = "UnifiedUserType枚举")
	private String memberType;
	
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
	 * 员工：员工
	*/
	@ApiModelProperty(required = false,value="员工" , notes = "员工")
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
	public BusiRoleMember setId(String id) {
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
	public BusiRoleMember setRoleId(String roleId) {
		this.roleId=roleId;
		return this;
	}
	
	/**
	 * 获得 成员ID<br>
	 * 成员ID
	 * @return 成员ID
	*/
	public String getMemberId() {
		return memberId;
	}
	
	/**
	 * 设置 成员ID
	 * @param memberId 成员ID
	 * @return 当前对象
	*/
	public BusiRoleMember setMemberId(String memberId) {
		this.memberId=memberId;
		return this;
	}
	
	/**
	 * 获得 成员类型<br>
	 * UnifiedUserType枚举
	 * @return 成员类型
	*/
	public String getMemberType() {
		return memberType;
	}
	
	/**
	 * 设置 成员类型
	 * @param memberType 成员类型
	 * @return 当前对象
	*/
	public BusiRoleMember setMemberType(String memberType) {
		this.memberType=memberType;
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
	public BusiRoleMember setCreateBy(String createBy) {
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
	public BusiRoleMember setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 员工<br>
	 * 员工
	 * @return 员工
	*/
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * 设置 员工
	 * @param employee 员工
	 * @return 当前对象
	*/
	public BusiRoleMember setEmployee(Employee employee) {
		this.employee=employee;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return BusiRoleMember , 转换好的 BusiRoleMember 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return BusiRoleMember , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 BusiRoleMember
	 * @param busiRoleMemberMap 包含实体信息的 Map 对象
	 * @return BusiRoleMember , 转换好的的 BusiRoleMember 对象
	*/
	@Transient
	public static BusiRoleMember createFrom(Map<String,Object> busiRoleMemberMap) {
		if(busiRoleMemberMap==null) return null;
		BusiRoleMember po = EntityContext.create(BusiRoleMember.class, busiRoleMemberMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 BusiRoleMember
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return BusiRoleMember , 转换好的的 BusiRoleMember 对象
	*/
	@Transient
	public static BusiRoleMember createFrom(Object pojo) {
		if(pojo==null) return null;
		BusiRoleMember po = EntityContext.create(BusiRoleMember.class,pojo);
		return po;
	}

	/**
	 * 创建一个 BusiRoleMember，等同于 new
	 * @return BusiRoleMember 对象
	*/
	@Transient
	public static BusiRoleMember create() {
		return EntityContext.create(BusiRoleMember.class);
	}
}