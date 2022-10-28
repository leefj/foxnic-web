package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
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
import org.github.foxnic.web.domain.system.meta.BusiRoleMemberMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 业务角色成员关系
 * <p>业务角色成员关系 , 数据表 sys_busi_role_member 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:47
 * @sign 185405A5FF2D52B26FDC100FB36DCCC0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_busi_role_member")
@ApiModel(description = "业务角色成员关系 ; 业务角色成员关系 , 数据表 sys_busi_role_member 的PO类型")
public class BusiRoleMember extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_BUSI_ROLE_MEMBER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "27684550612090880")
	private String id;
	
	/**
	 * 角色ID：角色ID
	*/
	@ApiModelProperty(required = false,value="角色ID" , notes = "角色ID" , example = "524224688444936192")
	private String roleId;
	
	/**
	 * 成员ID：成员ID
	*/
	@ApiModelProperty(required = false,value="成员ID" , notes = "成员ID" , example = "544487545157713920")
	private String memberId;
	
	/**
	 * 成员类型：UnifiedUserType枚举
	*/
	@ApiModelProperty(required = false,value="成员类型" , notes = "UnifiedUserType枚举" , example = "employee")
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
	 * 克隆当前对象
	*/
	@Transient
	public BusiRoleMember clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public BusiRoleMember duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.BusiRoleMemberMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.BusiRoleMemberMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setCreateTime(this.getCreateTime());
		inst.setRoleId(this.getRoleId());
		inst.setId(this.getId());
		inst.setMemberType(this.getMemberType());
		inst.setMemberId(this.getMemberId());
		if(all) {
			inst.setEmployee(this.getEmployee());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public BusiRoleMember clone(boolean deep) {
		return EntityContext.clone(BusiRoleMember.class,this,deep);
	}

	/**
	 * 将 Map 转换成 BusiRoleMember
	 * @param busiRoleMemberMap 包含实体信息的 Map 对象
	 * @return BusiRoleMember , 转换好的的 BusiRoleMember 对象
	*/
	@Transient
	public static BusiRoleMember createFrom(Map<String,Object> busiRoleMemberMap) {
		if(busiRoleMemberMap==null) return null;
		BusiRoleMember po = create();
		EntityContext.copyProperties(po,busiRoleMemberMap);
		po.clearModifies();
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
		BusiRoleMember po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 BusiRoleMember，等同于 new
	 * @return BusiRoleMember 对象
	*/
	@Transient
	public static BusiRoleMember create() {
		return new org.github.foxnic.web.domain.system.meta.BusiRoleMemberMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(BusiRoleMemberMeta.CREATE_BY)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(BusiRoleMemberMeta.CREATE_TIME)));
			this.setRoleId(DataParser.parse(String.class, map.get(BusiRoleMemberMeta.ROLE_ID)));
			this.setId(DataParser.parse(String.class, map.get(BusiRoleMemberMeta.ID)));
			this.setMemberType(DataParser.parse(String.class, map.get(BusiRoleMemberMeta.MEMBER_TYPE)));
			this.setMemberId(DataParser.parse(String.class, map.get(BusiRoleMemberMeta.MEMBER_ID)));
			// others
			this.setEmployee(DataParser.parse(Employee.class, map.get(BusiRoleMemberMeta.EMPLOYEE)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(BusiRoleMemberMeta.CREATE_BY));
				this.setCreateTime( (Date)map.get(BusiRoleMemberMeta.CREATE_TIME));
				this.setRoleId( (String)map.get(BusiRoleMemberMeta.ROLE_ID));
				this.setId( (String)map.get(BusiRoleMemberMeta.ID));
				this.setMemberType( (String)map.get(BusiRoleMemberMeta.MEMBER_TYPE));
				this.setMemberId( (String)map.get(BusiRoleMemberMeta.MEMBER_ID));
				// others
				this.setEmployee( (Employee)map.get(BusiRoleMemberMeta.EMPLOYEE));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(BusiRoleMemberMeta.CREATE_BY)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(BusiRoleMemberMeta.CREATE_TIME)));
			this.setRoleId(DataParser.parse(String.class, r.getValue(BusiRoleMemberMeta.ROLE_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(BusiRoleMemberMeta.ID)));
			this.setMemberType(DataParser.parse(String.class, r.getValue(BusiRoleMemberMeta.MEMBER_TYPE)));
			this.setMemberId(DataParser.parse(String.class, r.getValue(BusiRoleMemberMeta.MEMBER_ID)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(BusiRoleMemberMeta.CREATE_BY));
				this.setCreateTime( (Date)r.getValue(BusiRoleMemberMeta.CREATE_TIME));
				this.setRoleId( (String)r.getValue(BusiRoleMemberMeta.ROLE_ID));
				this.setId( (String)r.getValue(BusiRoleMemberMeta.ID));
				this.setMemberType( (String)r.getValue(BusiRoleMemberMeta.MEMBER_TYPE));
				this.setMemberId( (String)r.getValue(BusiRoleMemberMeta.MEMBER_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}