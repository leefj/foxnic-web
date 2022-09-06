package org.github.foxnic.web.domain.job;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_JOB;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.job.MisfirePolicy;
import javax.persistence.Transient;
import org.github.foxnic.web.constants.enums.job.Status;
import java.util.Date;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 定时任务配置
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 13:21:35
 * @sign 03DF11D6137819BF41A157DD0A8000EC
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
	 * 代码：任务代码
	*/
	@ApiModelProperty(required = false,value="代码" , notes = "任务代码")
	private String code;
	
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
	 * 执行类ID：执行类ID
	*/
	@ApiModelProperty(required = false,value="执行类ID" , notes = "执行类ID")
	private String workerId;
	
	/**
	 * cron表达式：cron表达式
	*/
	@ApiModelProperty(required = false,value="cron表达式" , notes = "cron表达式")
	private String cronExpr;
	
	/**
	 * 执行参数：JSON对象格式
	*/
	@ApiModelProperty(required = false,value="执行参数" , notes = "JSON对象格式")
	private String parameter;
	
	/**
	 * 是否并发执行（0允许：1禁止）
	*/
	@ApiModelProperty(required = true,value="是否并发执行（0允许" , notes = "1禁止）")
	private Integer concurrent;
	
	/**
	 * 遗漏执行的策略：遗漏执行的策略
	*/
	@ApiModelProperty(required = false,value="遗漏执行的策略" , notes = "遗漏执行的策略")
	private String misfirePolicy;
	@Transient
	private MisfirePolicy misfirePolicyEnum;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	@Transient
	private Status statusEnum;
	
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
	 * 任务的执行类：任务的执行类
	*/
	@ApiModelProperty(required = false,value="任务的执行类" , notes = "任务的执行类")
	private JobWorker worker;
	
	/**
	 * 下一次执行时间：下次执行时间
	*/
	@ApiModelProperty(required = false,value="下一次执行时间" , notes = "下次执行时间")
	private Date nextFireTime;
	
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
	 * 获得 代码<br>
	 * 任务代码
	 * @return 代码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 代码
	 * @param code 代码
	 * @return 当前对象
	*/
	public Job setCode(String code) {
		this.code=code;
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
	 * 获得 执行类ID<br>
	 * 执行类ID
	 * @return 执行类ID
	*/
	public String getWorkerId() {
		return workerId;
	}
	
	/**
	 * 设置 执行类ID
	 * @param workerId 执行类ID
	 * @return 当前对象
	*/
	public Job setWorkerId(String workerId) {
		this.workerId=workerId;
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
	 * 获得 遗漏执行的策略<br>
	 * 遗漏执行的策略
	 * @return 遗漏执行的策略
	*/
	public String getMisfirePolicy() {
		return misfirePolicy;
	}
	
	/**
	 * 获得 遗漏执行的策略 的投影属性<br>
	 * 等价于 getMisfirePolicy 方法，获得对应的枚举类型
	 * @return 遗漏执行的策略
	*/
	@Transient
	public MisfirePolicy getMisfirePolicyEnum() {
		if(this.misfirePolicyEnum==null) {
			this.misfirePolicyEnum = (MisfirePolicy) EnumUtil.parseByCode(MisfirePolicy.values(),misfirePolicy);
		}
		return this.misfirePolicyEnum ;
	}
	
	/**
	 * 设置 遗漏执行的策略
	 * @param misfirePolicy 遗漏执行的策略
	 * @return 当前对象
	*/
	public Job setMisfirePolicy(String misfirePolicy) {
		this.misfirePolicy=misfirePolicy;
		this.misfirePolicyEnum= (MisfirePolicy) EnumUtil.parseByCode(MisfirePolicy.values(),misfirePolicy) ;
		if(StringUtil.hasContent(misfirePolicy) && this.misfirePolicyEnum==null) {
			throw new IllegalArgumentException( misfirePolicy + " is not one of MisfirePolicy");
		}
		return this;
	}
	
	/**
	 * 设置 遗漏执行的策略的投影属性，等同于设置 遗漏执行的策略
	 * @param misfirePolicyEnum 遗漏执行的策略
	 * @return 当前对象
	*/
	@Transient
	public Job setMisfirePolicyEnum(MisfirePolicy misfirePolicyEnum) {
		if(misfirePolicyEnum==null) {
			this.setMisfirePolicy(null);
		} else {
			this.setMisfirePolicy(misfirePolicyEnum.code());
		}
		this.misfirePolicyEnum=misfirePolicyEnum;
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
	 * 获得 状态 的投影属性<br>
	 * 等价于 getStatus 方法，获得对应的枚举类型
	 * @return 状态
	*/
	@Transient
	public Status getStatusEnum() {
		if(this.statusEnum==null) {
			this.statusEnum = (Status) EnumUtil.parseByCode(Status.values(),status);
		}
		return this.statusEnum ;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public Job setStatus(String status) {
		this.status=status;
		this.statusEnum= (Status) EnumUtil.parseByCode(Status.values(),status) ;
		if(StringUtil.hasContent(status) && this.statusEnum==null) {
			throw new IllegalArgumentException( status + " is not one of Status");
		}
		return this;
	}
	
	/**
	 * 设置 状态的投影属性，等同于设置 状态
	 * @param statusEnum 状态
	 * @return 当前对象
	*/
	@Transient
	public Job setStatusEnum(Status statusEnum) {
		if(statusEnum==null) {
			this.setStatus(null);
		} else {
			this.setStatus(statusEnum.code());
		}
		this.statusEnum=statusEnum;
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
	public Job setDeleted(Integer deleted) {
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
	public Job setDeleted(Boolean deletedBool) {
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
	 * 获得 任务的执行类<br>
	 * 任务的执行类
	 * @return 任务的执行类
	*/
	public JobWorker getWorker() {
		return worker;
	}
	
	/**
	 * 设置 任务的执行类
	 * @param worker 任务的执行类
	 * @return 当前对象
	*/
	public Job setWorker(JobWorker worker) {
		this.worker=worker;
		return this;
	}
	
	/**
	 * 获得 下一次执行时间<br>
	 * 下次执行时间
	 * @return 下一次执行时间
	*/
	public Date getNextFireTime() {
		return nextFireTime;
	}
	
	/**
	 * 设置 下一次执行时间
	 * @param nextFireTime 下一次执行时间
	 * @return 当前对象
	*/
	public Job setNextFireTime(Date nextFireTime) {
		this.nextFireTime=nextFireTime;
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
	 * 克隆当前对象
	*/
	@Transient
	public Job clone() {
		return EntityContext.clone(Job.class,this);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Job clone(boolean deep) {
		return EntityContext.clone(Job.class,this,deep);
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