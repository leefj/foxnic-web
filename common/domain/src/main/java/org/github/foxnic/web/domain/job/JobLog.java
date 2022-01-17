package org.github.foxnic.web.domain.job;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_JOB_LOG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.job.LogType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 定时任务执行日志
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-07 13:39:32
 * @sign 5CB401D9B05D63D3C093561C806E9CBA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_job_log")
public class JobLog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_JOB_LOG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 组别：组别
	*/
	@ApiModelProperty(required = false,value="组别" , notes = "组别")
	private String jobId;
	
	/**
	 * 日志分类：日志分类
	*/
	@ApiModelProperty(required = false,value="日志分类" , notes = "日志分类")
	private String type;
	@Transient
	private LogType typeEnum;
	
	/**
	 * 任务名称：任务名称
	*/
	@ApiModelProperty(required = false,value="任务名称" , notes = "任务名称")
	private String jobName;
	
	/**
	 * 本次执行类：本次执行类
	*/
	@ApiModelProperty(required = false,value="本次执行类" , notes = "本次执行类")
	private String className;
	
	/**
	 * 本次执行cron表达式：本次执行cron表达式
	*/
	@ApiModelProperty(required = false,value="本次执行cron表达式" , notes = "本次执行cron表达式")
	private String cronExpr;
	
	/**
	 * 本次执行参数：本次执行参数
	*/
	@ApiModelProperty(required = false,value="本次执行参数" , notes = "本次执行参数")
	private String parameter;
	
	/**
	 * 是否成功执行：是否成功执行
	*/
	@ApiModelProperty(required = false,value="是否成功执行" , notes = "是否成功执行")
	private Integer success;
	
	/**
	 * 执行结果：可记录大文本信息
	*/
	@ApiModelProperty(required = false,value="执行结果" , notes = "可记录大文本信息")
	private String result;
	
	/**
	 * 开始执行的时间：开始执行的时间
	*/
	@ApiModelProperty(required = false,value="开始执行的时间" , notes = "开始执行的时间")
	private Timestamp beginTime;
	
	/**
	 * 结束执行的时间：结束执行的时间
	*/
	@ApiModelProperty(required = false,value="结束执行的时间" , notes = "结束执行的时间")
	private Timestamp endTime;
	
	/**
	 * 执行耗时：执行耗时
	*/
	@ApiModelProperty(required = false,value="执行耗时" , notes = "执行耗时")
	private Long cost;
	
	/**
	 * 异常信息：异常信息
	*/
	@ApiModelProperty(required = false,value="异常信息" , notes = "异常信息")
	private String exception;
	
	/**
	 * 日志信息：日志信息
	*/
	@ApiModelProperty(required = false,value="日志信息" , notes = "日志信息")
	private String logText;
	
	/**
	 * 账户ID：操作人ID
	*/
	@ApiModelProperty(required = false,value="账户ID" , notes = "操作人ID")
	private String userId;
	
	/**
	 * 是否是手动执行：是否是手动执行
	*/
	@ApiModelProperty(required = false,value="是否是手动执行" , notes = "是否是手动执行")
	private Integer isManual;
	
	/**
	 * 是否为丢失补充执行：是否为丢失补充执行
	*/
	@ApiModelProperty(required = false,value="是否为丢失补充执行" , notes = "是否为丢失补充执行")
	private Integer isMissfire;
	
	/**
	 * 是否并发执行（0允许：1禁止）
	*/
	@ApiModelProperty(required = false,value="是否并发执行（0允许" , notes = "1禁止）")
	private Integer concurrent;
	
	/**
	 * 遗漏执行的策略：遗漏执行的策略
	*/
	@ApiModelProperty(required = false,value="遗漏执行的策略" , notes = "遗漏执行的策略")
	private String misfirePolicy;
	
	/**
	 * 日志跟踪ID：日志跟踪ID
	*/
	@ApiModelProperty(required = false,value="日志跟踪ID" , notes = "日志跟踪ID")
	private String tid;
	
	/**
	 * 节点ID：job实际运行的节点ID
	*/
	@ApiModelProperty(required = false,value="节点ID" , notes = "job实际运行的节点ID")
	private String nodeId;
	
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
	public JobLog setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 组别<br>
	 * 组别
	 * @return 组别
	*/
	public String getJobId() {
		return jobId;
	}
	
	/**
	 * 设置 组别
	 * @param jobId 组别
	 * @return 当前对象
	*/
	public JobLog setJobId(String jobId) {
		this.jobId=jobId;
		return this;
	}
	
	/**
	 * 获得 日志分类<br>
	 * 日志分类
	 * @return 日志分类
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 获得 日志分类 的投影属性<br>
	 * 等价于 getType 方法，获得对应的枚举类型
	 * @return 日志分类
	*/
	@Transient
	public LogType getTypeEnum() {
		if(this.typeEnum==null) {
			this.typeEnum = (LogType) EnumUtil.parseByCode(LogType.values(),type);
		}
		return this.typeEnum ;
	}
	
	/**
	 * 设置 日志分类
	 * @param type 日志分类
	 * @return 当前对象
	*/
	public JobLog setType(String type) {
		this.type=type;
		this.typeEnum= (LogType) EnumUtil.parseByCode(LogType.values(),type) ;
		if(StringUtil.hasContent(type) && this.typeEnum==null) {
			throw new IllegalArgumentException( type + " is not one of LogType");
		}
		return this;
	}
	
	/**
	 * 设置 日志分类的投影属性，等同于设置 日志分类
	 * @param typeEnum 日志分类
	 * @return 当前对象
	*/
	@Transient
	public JobLog setTypeEnum(LogType typeEnum) {
		if(typeEnum==null) {
			this.setType(null);
		} else {
			this.setType(typeEnum.code());
		}
		this.typeEnum=typeEnum;
		return this;
	}
	
	/**
	 * 获得 任务名称<br>
	 * 任务名称
	 * @return 任务名称
	*/
	public String getJobName() {
		return jobName;
	}
	
	/**
	 * 设置 任务名称
	 * @param jobName 任务名称
	 * @return 当前对象
	*/
	public JobLog setJobName(String jobName) {
		this.jobName=jobName;
		return this;
	}
	
	/**
	 * 获得 本次执行类<br>
	 * 本次执行类
	 * @return 本次执行类
	*/
	public String getClassName() {
		return className;
	}
	
	/**
	 * 设置 本次执行类
	 * @param className 本次执行类
	 * @return 当前对象
	*/
	public JobLog setClassName(String className) {
		this.className=className;
		return this;
	}
	
	/**
	 * 获得 本次执行cron表达式<br>
	 * 本次执行cron表达式
	 * @return 本次执行cron表达式
	*/
	public String getCronExpr() {
		return cronExpr;
	}
	
	/**
	 * 设置 本次执行cron表达式
	 * @param cronExpr 本次执行cron表达式
	 * @return 当前对象
	*/
	public JobLog setCronExpr(String cronExpr) {
		this.cronExpr=cronExpr;
		return this;
	}
	
	/**
	 * 获得 本次执行参数<br>
	 * 本次执行参数
	 * @return 本次执行参数
	*/
	public String getParameter() {
		return parameter;
	}
	
	/**
	 * 设置 本次执行参数
	 * @param parameter 本次执行参数
	 * @return 当前对象
	*/
	public JobLog setParameter(String parameter) {
		this.parameter=parameter;
		return this;
	}
	
	/**
	 * 获得 是否成功执行<br>
	 * 是否成功执行
	 * @return 是否成功执行
	*/
	public Integer getSuccess() {
		return success;
	}
	
	/**
	 * 设置 是否成功执行
	 * @param success 是否成功执行
	 * @return 当前对象
	*/
	public JobLog setSuccess(Integer success) {
		this.success=success;
		return this;
	}
	
	/**
	 * 获得 执行结果<br>
	 * 可记录大文本信息
	 * @return 执行结果
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 设置 执行结果
	 * @param result 执行结果
	 * @return 当前对象
	*/
	public JobLog setResult(String result) {
		this.result=result;
		return this;
	}
	
	/**
	 * 获得 开始执行的时间<br>
	 * 开始执行的时间
	 * @return 开始执行的时间
	*/
	public Timestamp getBeginTime() {
		return beginTime;
	}
	
	/**
	 * 设置 开始执行的时间
	 * @param beginTime 开始执行的时间
	 * @return 当前对象
	*/
	public JobLog setBeginTime(Timestamp beginTime) {
		this.beginTime=beginTime;
		return this;
	}
	
	/**
	 * 获得 结束执行的时间<br>
	 * 结束执行的时间
	 * @return 结束执行的时间
	*/
	public Timestamp getEndTime() {
		return endTime;
	}
	
	/**
	 * 设置 结束执行的时间
	 * @param endTime 结束执行的时间
	 * @return 当前对象
	*/
	public JobLog setEndTime(Timestamp endTime) {
		this.endTime=endTime;
		return this;
	}
	
	/**
	 * 获得 执行耗时<br>
	 * 执行耗时
	 * @return 执行耗时
	*/
	public Long getCost() {
		return cost;
	}
	
	/**
	 * 设置 执行耗时
	 * @param cost 执行耗时
	 * @return 当前对象
	*/
	public JobLog setCost(Long cost) {
		this.cost=cost;
		return this;
	}
	
	/**
	 * 获得 异常信息<br>
	 * 异常信息
	 * @return 异常信息
	*/
	public String getException() {
		return exception;
	}
	
	/**
	 * 设置 异常信息
	 * @param exception 异常信息
	 * @return 当前对象
	*/
	public JobLog setException(String exception) {
		this.exception=exception;
		return this;
	}
	
	/**
	 * 获得 日志信息<br>
	 * 日志信息
	 * @return 日志信息
	*/
	public String getLogText() {
		return logText;
	}
	
	/**
	 * 设置 日志信息
	 * @param logText 日志信息
	 * @return 当前对象
	*/
	public JobLog setLogText(String logText) {
		this.logText=logText;
		return this;
	}
	
	/**
	 * 获得 账户ID<br>
	 * 操作人ID
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
	public JobLog setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 是否是手动执行<br>
	 * 是否是手动执行
	 * @return 是否是手动执行
	*/
	public Integer getIsManual() {
		return isManual;
	}
	
	/**
	 * 设置 是否是手动执行
	 * @param isManual 是否是手动执行
	 * @return 当前对象
	*/
	public JobLog setIsManual(Integer isManual) {
		this.isManual=isManual;
		return this;
	}
	
	/**
	 * 获得 是否为丢失补充执行<br>
	 * 是否为丢失补充执行
	 * @return 是否为丢失补充执行
	*/
	public Integer getIsMissfire() {
		return isMissfire;
	}
	
	/**
	 * 设置 是否为丢失补充执行
	 * @param isMissfire 是否为丢失补充执行
	 * @return 当前对象
	*/
	public JobLog setIsMissfire(Integer isMissfire) {
		this.isMissfire=isMissfire;
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
	public JobLog setConcurrent(Integer concurrent) {
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
	 * 设置 遗漏执行的策略
	 * @param misfirePolicy 遗漏执行的策略
	 * @return 当前对象
	*/
	public JobLog setMisfirePolicy(String misfirePolicy) {
		this.misfirePolicy=misfirePolicy;
		return this;
	}
	
	/**
	 * 获得 日志跟踪ID<br>
	 * 日志跟踪ID
	 * @return 日志跟踪ID
	*/
	public String getTid() {
		return tid;
	}
	
	/**
	 * 设置 日志跟踪ID
	 * @param tid 日志跟踪ID
	 * @return 当前对象
	*/
	public JobLog setTid(String tid) {
		this.tid=tid;
		return this;
	}
	
	/**
	 * 获得 节点ID<br>
	 * job实际运行的节点ID
	 * @return 节点ID
	*/
	public String getNodeId() {
		return nodeId;
	}
	
	/**
	 * 设置 节点ID
	 * @param nodeId 节点ID
	 * @return 当前对象
	*/
	public JobLog setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return JobLog , 转换好的 JobLog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return JobLog , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 JobLog
	 * @param jobLogMap 包含实体信息的 Map 对象
	 * @return JobLog , 转换好的的 JobLog 对象
	*/
	@Transient
	public static JobLog createFrom(Map<String,Object> jobLogMap) {
		if(jobLogMap==null) return null;
		JobLog po = EntityContext.create(JobLog.class, jobLogMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 JobLog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return JobLog , 转换好的的 JobLog 对象
	*/
	@Transient
	public static JobLog createFrom(Object pojo) {
		if(pojo==null) return null;
		JobLog po = EntityContext.create(JobLog.class,pojo);
		return po;
	}

	/**
	 * 创建一个 JobLog，等同于 new
	 * @return JobLog 对象
	*/
	@Transient
	public static JobLog create() {
		return EntityContext.create(JobLog.class);
	}
}