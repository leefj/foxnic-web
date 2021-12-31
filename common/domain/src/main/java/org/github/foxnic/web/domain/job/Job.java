package org.github.foxnic.web.domain.job;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_JOB;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 定时任务配置
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-31 11:54:53
 * @sign 0FFDF26A69530FBFD534CA3ED10B04A2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_job")
public class Job extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_JOB.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 任务名称：任务名称
	*/
	@ApiModelProperty(required = false,value="任务名称" , notes = "任务名称")
	private String name;
	
	/**
	 * 组别：组别
	*/
	@ApiModelProperty(required = false,value="组别" , notes = "组别")
	private String groupTag;
	
	/**
	 * 执行类：执行类
	*/
	@ApiModelProperty(required = false,value="执行类" , notes = "执行类")
	private String className;
	
	/**
	 * cron表达式：cron表达式
	*/
	@ApiModelProperty(required = false,value="cron表达式" , notes = "cron表达式")
	private String cronExpr;
	
	/**
	 * 计划执行错误策略：计划执行错误策略
	*/
	@ApiModelProperty(required = false,value="计划执行错误策略" , notes = "计划执行错误策略")
	private String errorPolicy;
	
	/**
	 * 执行参数：JSON对象格式
	*/
	@ApiModelProperty(required = false,value="执行参数" , notes = "JSON对象格式")
	private String parameter;
	
	/**
	 * 是否并发执行（0允许：1禁止）
	*/
	@ApiModelProperty(required = false,value="是否并发执行（0允许" , notes = "1禁止）")
	private Integer concurrent;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 执行错误次数：执行错误次数
	*/
	@ApiModelProperty(required = false,value="执行错误次数" , notes = "执行错误次数")
	private Integer errors;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	public Job setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务名称<br>
	 * 任务名称
	 * @return 任务名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 任务名称
	 * @param name 任务名称
	 * @return 当前对象
	*/
	public Job setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 组别<br>
	 * 组别
	 * @return 组别
	*/
	public String getGroupTag() {
		return groupTag;
	}
	
	/**
	 * 设置 组别
	 * @param groupTag 组别
	 * @return 当前对象
	*/
	public Job setGroupTag(String groupTag) {
		this.groupTag=groupTag;
		return this;
	}
	
	/**
	 * 获得 执行类<br>
	 * 执行类
	 * @return 执行类
	*/
	public String getClassName() {
		return className;
	}
	
	/**
	 * 设置 执行类
	 * @param className 执行类
	 * @return 当前对象
	*/
	public Job setClassName(String className) {
		this.className=className;
		return this;
	}
	
	/**
	 * 获得 cron表达式<br>
	 * cron表达式
	 * @return cron表达式
	*/
	public String getCronExpr() {
		return cronExpr;
	}
	
	/**
	 * 设置 cron表达式
	 * @param cronExpr cron表达式
	 * @return 当前对象
	*/
	public Job setCronExpr(String cronExpr) {
		this.cronExpr=cronExpr;
		return this;
	}
	
	/**
	 * 获得 计划执行错误策略<br>
	 * 计划执行错误策略
	 * @return 计划执行错误策略
	*/
	public String getErrorPolicy() {
		return errorPolicy;
	}
	
	/**
	 * 设置 计划执行错误策略
	 * @param errorPolicy 计划执行错误策略
	 * @return 当前对象
	*/
	public Job setErrorPolicy(String errorPolicy) {
		this.errorPolicy=errorPolicy;
		return this;
	}
	
	/**
	 * 获得 执行参数<br>
	 * JSON对象格式
	 * @return 执行参数
	*/
	public String getParameter() {
		return parameter;
	}
	
	/**
	 * 设置 执行参数
	 * @param parameter 执行参数
	 * @return 当前对象
	*/
	public Job setParameter(String parameter) {
		this.parameter=parameter;
		return this;
	}
	
	/**
	 * 获得 是否并发执行（0允许<br>
	 * 1禁止）
	 * @return 是否并发执行（0允许
	*/
	public Integer getConcurrent() {
		return concurrent;
	}
	
	/**
	 * 设置 是否并发执行（0允许
	 * @param concurrent 是否并发执行（0允许
	 * @return 当前对象
	*/
	public Job setConcurrent(Integer concurrent) {
		this.concurrent=concurrent;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
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
	public Job setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 执行错误次数<br>
	 * 执行错误次数
	 * @return 执行错误次数
	*/
	public Integer getErrors() {
		return errors;
	}
	
	/**
	 * 设置 执行错误次数
	 * @param errors 执行错误次数
	 * @return 当前对象
	*/
	public Job setErrors(Integer errors) {
		this.errors=errors;
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
	public Job setNotes(String notes) {
		this.notes=notes;
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
	public Job setTenantId(String tenantId) {
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
	public Job setCreateBy(String createBy) {
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
	public Job setCreateTime(Date createTime) {
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
	public Job setUpdateBy(String updateBy) {
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
	public Job setUpdateTime(Date updateTime) {
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
	public Job setDeleted(Integer deleted) {
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
	public Job setDeleteBy(String deleteBy) {
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
	public Job setDeleteTime(Date deleteTime) {
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
	public Job setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Job , 转换好的 Job 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Job , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Job
	 * @param jobMap 包含实体信息的 Map 对象
	 * @return Job , 转换好的的 Job 对象
	*/
	@Transient
	public static Job createFrom(Map<String,Object> jobMap) {
		if(jobMap==null) return null;
		Job po = EntityContext.create(Job.class, jobMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Job
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Job , 转换好的的 Job 对象
	*/
	@Transient
	public static Job createFrom(Object pojo) {
		if(pojo==null) return null;
		Job po = EntityContext.create(Job.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Job，等同于 new
	 * @return Job 对象
	*/
	@Transient
	public static Job create() {
		return EntityContext.create(Job.class);
	}
}