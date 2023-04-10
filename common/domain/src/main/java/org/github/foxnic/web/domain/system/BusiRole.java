package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_BUSI_ROLE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Position;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.system.meta.BusiRoleMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 业务角色
 * <p>业务角色 , 数据表 sys_busi_role 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-10 16:27:20
 * @sign 87825961170D009F1E08F946FB545755
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_busi_role")
@ApiModel(description = "业务角色 ; 业务角色 , 数据表 sys_busi_role 的PO类型")
public class BusiRole extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_BUSI_ROLE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "498946989573017600")
	private String id;
	
	/**
	 * 所属组织ID：所属组织ID
	*/
	@ApiModelProperty(required = false,value="所属组织ID" , notes = "所属组织ID")
	private Integer orgId;
	
	/**
	 * 角色代码：角色代码
	*/
	@ApiModelProperty(required = false,value="角色代码" , notes = "角色代码" , example = "drafter")
	private String code;
	
	/**
	 * 角色名称：角色名称
	*/
	@ApiModelProperty(required = false,value="角色名称" , notes = "角色名称" , example = "起草人")
	private String name;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = true,value="是否有效" , notes = "是否有效" , example = "1")
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
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2021-10-08 07:57:15")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "2")
	private Integer version;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 成员路由：Java类型用于检索扩展成员
	*/
	@ApiModelProperty(required = false,value="成员路由" , notes = "Java类型用于检索扩展成员")
	private String memberRouter;
	
	/**
	 * 内置角色：系统内置角色
	*/
	@ApiModelProperty(required = true,value="内置角色" , notes = "系统内置角色" , example = "0")
	private Integer buildIn;
	
	/**
	 * 关联员工清单：关联员工清单
	*/
	@ApiModelProperty(required = false,value="关联员工清单" , notes = "关联员工清单")
	private List<Employee> employees;
	
	/**
	 * 关联岗位清单：关联岗位清单
	*/
	@ApiModelProperty(required = false,value="关联岗位清单" , notes = "关联岗位清单")
	private List<Position> positions;
	
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
	public BusiRole setDeleted(Integer deleted) {
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
	public BusiRole setDeleted(Boolean deletedBool) {
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
	public BusiRole setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 成员路由<br>
	 * Java类型用于检索扩展成员
	 * @return 成员路由
	*/
	public String getMemberRouter() {
		return memberRouter;
	}
	
	/**
	 * 设置 成员路由
	 * @param memberRouter 成员路由
	 * @return 当前对象
	*/
	public BusiRole setMemberRouter(String memberRouter) {
		this.memberRouter=memberRouter;
		return this;
	}
	
	/**
	 * 获得 内置角色<br>
	 * 系统内置角色
	 * @return 内置角色
	*/
	public Integer getBuildIn() {
		return buildIn;
	}
	
	/**
	 * 设置 内置角色
	 * @param buildIn 内置角色
	 * @return 当前对象
	*/
	public BusiRole setBuildIn(Integer buildIn) {
		this.buildIn=buildIn;
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
	public BusiRole addEmployee(Employee... employee) {
		if(this.employees==null) employees=new ArrayList<>();
		this.employees.addAll(Arrays.asList(employee));
		return this;
	}
	
	/**
	 * 获得 关联岗位清单<br>
	 * 关联岗位清单
	 * @return 关联岗位清单
	*/
	public List<Position> getPositions() {
		return positions;
	}
	
	/**
	 * 设置 关联岗位清单
	 * @param positions 关联岗位清单
	 * @return 当前对象
	*/
	public BusiRole setPositions(List<Position> positions) {
		this.positions=positions;
		return this;
	}
	
	/**
	 * 添加 关联岗位清单
	 * @param position 关联岗位清单
	 * @return 当前对象
	*/
	public BusiRole addPosition(Position... position) {
		if(this.positions==null) positions=new ArrayList<>();
		this.positions.addAll(Arrays.asList(position));
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
	 * 克隆当前对象
	*/
	@Transient
	public BusiRole clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public BusiRole duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.BusiRoleMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.BusiRoleMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setOrgId(this.getOrgId());
		inst.setValid(this.getValid());
		inst.setMemberRouter(this.getMemberRouter());
		inst.setBuildIn(this.getBuildIn());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setPositions(this.getPositions());
			inst.setEmployees(this.getEmployees());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public BusiRole clone(boolean deep) {
		return EntityContext.clone(BusiRole.class,this,deep);
	}

	/**
	 * 将 Map 转换成 BusiRole
	 * @param busiRoleMap 包含实体信息的 Map 对象
	 * @return BusiRole , 转换好的的 BusiRole 对象
	*/
	@Transient
	public static BusiRole createFrom(Map<String,Object> busiRoleMap) {
		if(busiRoleMap==null) return null;
		BusiRole po = create();
		EntityContext.copyProperties(po,busiRoleMap);
		po.clearModifies();
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
		BusiRole po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 BusiRole，等同于 new
	 * @return BusiRole 对象
	*/
	@Transient
	public static BusiRole create() {
		return new org.github.foxnic.web.domain.system.meta.BusiRoleMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(BusiRoleMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(BusiRoleMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(BusiRoleMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(BusiRoleMeta.VERSION)));
			this.setOrgId(DataParser.parse(Integer.class, map.get(BusiRoleMeta.ORG_ID)));
			this.setValid(DataParser.parse(Integer.class, map.get(BusiRoleMeta.VALID)));
			this.setMemberRouter(DataParser.parse(String.class, map.get(BusiRoleMeta.MEMBER_ROUTER)));
			this.setBuildIn(DataParser.parse(Integer.class, map.get(BusiRoleMeta.BUILD_IN)));
			this.setCreateBy(DataParser.parse(String.class, map.get(BusiRoleMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(BusiRoleMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(BusiRoleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(BusiRoleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(BusiRoleMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(BusiRoleMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(BusiRoleMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(BusiRoleMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(BusiRoleMeta.CODE));
				this.setNotes( (String)map.get(BusiRoleMeta.NOTES));
				this.setUpdateTime( (Date)map.get(BusiRoleMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(BusiRoleMeta.VERSION));
				this.setOrgId( (Integer)map.get(BusiRoleMeta.ORG_ID));
				this.setValid( (Integer)map.get(BusiRoleMeta.VALID));
				this.setMemberRouter( (String)map.get(BusiRoleMeta.MEMBER_ROUTER));
				this.setBuildIn( (Integer)map.get(BusiRoleMeta.BUILD_IN));
				this.setCreateBy( (String)map.get(BusiRoleMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(BusiRoleMeta.DELETED));
				this.setCreateTime( (Date)map.get(BusiRoleMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(BusiRoleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(BusiRoleMeta.DELETE_TIME));
				this.setName( (String)map.get(BusiRoleMeta.NAME));
				this.setDeleteBy( (String)map.get(BusiRoleMeta.DELETE_BY));
				this.setId( (String)map.get(BusiRoleMeta.ID));
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
			this.setCode(DataParser.parse(String.class, r.getValue(BusiRoleMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(BusiRoleMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(BusiRoleMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(BusiRoleMeta.VERSION)));
			this.setOrgId(DataParser.parse(Integer.class, r.getValue(BusiRoleMeta.ORG_ID)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(BusiRoleMeta.VALID)));
			this.setMemberRouter(DataParser.parse(String.class, r.getValue(BusiRoleMeta.MEMBER_ROUTER)));
			this.setBuildIn(DataParser.parse(Integer.class, r.getValue(BusiRoleMeta.BUILD_IN)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(BusiRoleMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(BusiRoleMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(BusiRoleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(BusiRoleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(BusiRoleMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(BusiRoleMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(BusiRoleMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(BusiRoleMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(BusiRoleMeta.CODE));
				this.setNotes( (String)r.getValue(BusiRoleMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(BusiRoleMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(BusiRoleMeta.VERSION));
				this.setOrgId( (Integer)r.getValue(BusiRoleMeta.ORG_ID));
				this.setValid( (Integer)r.getValue(BusiRoleMeta.VALID));
				this.setMemberRouter( (String)r.getValue(BusiRoleMeta.MEMBER_ROUTER));
				this.setBuildIn( (Integer)r.getValue(BusiRoleMeta.BUILD_IN));
				this.setCreateBy( (String)r.getValue(BusiRoleMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(BusiRoleMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(BusiRoleMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(BusiRoleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(BusiRoleMeta.DELETE_TIME));
				this.setName( (String)r.getValue(BusiRoleMeta.NAME));
				this.setDeleteBy( (String)r.getValue(BusiRoleMeta.DELETE_BY));
				this.setId( (String)r.getValue(BusiRoleMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}