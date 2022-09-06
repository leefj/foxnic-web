package org.github.foxnic.web.domain.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_ROLE_USER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 角色账户关系
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 15:51:06
 * @sign D303306DC895E13F5CC0C901229C3176
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_role_user")
public class RoleUser extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_ROLE_USER.$TABLE;

	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private String id;

	/**
	 * 角色ID：角色ID
	*/
	@ApiModelProperty(required = false,value="角色ID" , notes = "角色ID")
	private String roleId;

	/**
	 * 账户ID：账户ID
	*/
	@ApiModelProperty(required = false,value="账户ID" , notes = "账户ID")
	private String userId;

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
	 * 获得 id<br>
	 * id
	 * @return id
	*/
	public String getId() {
		return id;
	}

	/**
	 * 设置 id
	 * @param id id
	 * @return 当前对象
	*/
	public RoleUser setId(String id) {
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
	public RoleUser setRoleId(String roleId) {
		this.roleId=roleId;
		return this;
	}

	/**
	 * 获得 账户ID<br>
	 * 账户ID
	 * @return 账户ID
	*/
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置 账户ID
	 * @param userId 账户ID
	 * @return 当前对象
	*/
	public RoleUser setUserId(String userId) {
		this.userId=userId;
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
	public RoleUser setCreateBy(String createBy) {
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
	public RoleUser setCreateTime(Date createTime) {
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
	public RoleUser setUpdateBy(String updateBy) {
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
	public RoleUser setUpdateTime(Date updateTime) {
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
	public RoleUser setDeleted(Integer deleted) {
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
	public RoleUser setDeleted(Boolean deletedBool) {
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
	public RoleUser setDeleteBy(String deleteBy) {
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
	public RoleUser setDeleteTime(Date deleteTime) {
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
	public RoleUser setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RoleUser , 转换好的 RoleUser 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RoleUser , 转换好的 PoJo 对象
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
	public RoleUser clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RoleUser duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.RoleUserMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.RoleUserMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setRoleId(this.getRoleId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RoleUser clone(boolean deep) {
		return EntityContext.clone(RoleUser.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RoleUser
	 * @param roleUserMap 包含实体信息的 Map 对象
	 * @return RoleUser , 转换好的的 RoleUser 对象
	*/
	@Transient
	public static RoleUser createFrom(Map<String,Object> roleUserMap) {
		if(roleUserMap==null) return null;
		RoleUser po = EntityContext.create(RoleUser.class, roleUserMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 RoleUser
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RoleUser , 转换好的的 RoleUser 对象
	*/
	@Transient
	public static RoleUser createFrom(Object pojo) {
		if(pojo==null) return null;
		RoleUser po = EntityContext.create(RoleUser.class,pojo);
		return po;
	}

	/**
	 * 创建一个 RoleUser，等同于 new
	 * @return RoleUser 对象
	*/
	@Transient
	public static RoleUser create() {
		return EntityContext.create(RoleUser.class);
	}
}
