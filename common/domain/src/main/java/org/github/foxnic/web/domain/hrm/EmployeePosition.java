package org.github.foxnic.web.domain.hrm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_EMPLOYEE_POSITION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-14 21:43:33
 * @sign ED18762E4C112BBA43618A0F314A38BB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hrm_employee_position")
public class EmployeePosition extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HRM_EMPLOYEE_POSITION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 员工ID：员工ID
	*/
	@ApiModelProperty(required = true,value="员工ID" , notes = "员工ID")
	private String employeeId;
	
	/**
	 * 岗位ID：岗位ID
	*/
	@ApiModelProperty(required = true,value="岗位ID" , notes = "岗位ID")
	private String positionId;
	
	/**
	 * 是否主刚：是否主刚
	*/
	@ApiModelProperty(required = false,value="是否主刚" , notes = "是否主刚")
	private Integer primary;
	
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
	public EmployeePosition setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 员工ID<br>
	 * 员工ID
	 * @return 员工ID
	*/
	public String getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * 设置 员工ID
	 * @param employeeId 员工ID
	 * @return 当前对象
	*/
	public EmployeePosition setEmployeeId(String employeeId) {
		this.employeeId=employeeId;
		return this;
	}
	
	/**
	 * 获得 岗位ID<br>
	 * 岗位ID
	 * @return 岗位ID
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 岗位ID
	 * @param positionId 岗位ID
	 * @return 当前对象
	*/
	public EmployeePosition setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 是否主刚<br>
	 * 是否主刚
	 * @return 是否主刚
	*/
	public Integer getPrimary() {
		return primary;
	}
	
	/**
	 * 设置 是否主刚
	 * @param primary 是否主刚
	 * @return 当前对象
	*/
	public EmployeePosition setPrimary(Integer primary) {
		this.primary=primary;
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
	public EmployeePosition setCreateBy(String createBy) {
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
	public EmployeePosition setCreateTime(Date createTime) {
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
	public EmployeePosition setUpdateBy(String updateBy) {
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
	public EmployeePosition setUpdateTime(Date updateTime) {
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
	public EmployeePosition setDeleted(Integer deleted) {
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
	public EmployeePosition setDeleteBy(String deleteBy) {
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
	public EmployeePosition setDeleteTime(Date deleteTime) {
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
	public EmployeePosition setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return EmployeePosition , 转换好的 EmployeePosition 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return EmployeePosition , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 EmployeePosition
	 * @param employeePositionMap 包含实体信息的 Map 对象
	 * @return EmployeePosition , 转换好的的 EmployeePosition 对象
	*/
	@Transient
	public static EmployeePosition createFrom(Map<String,Object> employeePositionMap) {
		if(employeePositionMap==null) return null;
		EmployeePosition po = EntityContext.create(EmployeePosition.class, employeePositionMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 EmployeePosition
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return EmployeePosition , 转换好的的 EmployeePosition 对象
	*/
	@Transient
	public static EmployeePosition createFrom(Object pojo) {
		if(pojo==null) return null;
		EmployeePosition po = EntityContext.create(EmployeePosition.class,pojo);
		return po;
	}

	/**
	 * 创建一个 EmployeePosition，等同于 new
	 * @return EmployeePosition 对象
	*/
	@Transient
	public static EmployeePosition create() {
		return EntityContext.create(EmployeePosition.class);
	}
}