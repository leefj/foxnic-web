package org.github.foxnic.web.domain.job;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_JOB_WORKER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 任务执行器
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-05 16:46:14
 * @sign F15D36AC3D61FB01BEC5A771ADFBB0FE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_job_worker")
public class JobWorker extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_JOB_WORKER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 类名：类名
	*/
	@ApiModelProperty(required = false,value="类名" , notes = "类名")
	private String className;
	
	/**
	 * 有效：有效
	*/
	@ApiModelProperty(required = false,value="有效" , notes = "有效")
	private Integer valid;
	
	/**
	 * 执行任务的Bean：执行任务的Bean
	*/
	@ApiModelProperty(required = false,value="执行任务的Bean" , notes = "执行任务的Bean")
	private JobExecuter executor;
	
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
	public JobWorker setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public JobWorker setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 类名<br>
	 * 类名
	 * @return 类名
	*/
	public String getClassName() {
		return className;
	}
	
	/**
	 * 设置 类名
	 * @param className 类名
	 * @return 当前对象
	*/
	public JobWorker setClassName(String className) {
		this.className=className;
		return this;
	}
	
	/**
	 * 获得 有效<br>
	 * 有效
	 * @return 有效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 有效
	 * @param valid 有效
	 * @return 当前对象
	*/
	public JobWorker setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 执行任务的Bean<br>
	 * 执行任务的Bean
	 * @return 执行任务的Bean
	*/
	public JobExecuter getExecutor() {
		return executor;
	}
	
	/**
	 * 设置 执行任务的Bean
	 * @param executor 执行任务的Bean
	 * @return 当前对象
	*/
	public JobWorker setExecutor(JobExecuter executor) {
		this.executor=executor;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return JobWorker , 转换好的 JobWorker 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return JobWorker , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 JobWorker
	 * @param jobWorkerMap 包含实体信息的 Map 对象
	 * @return JobWorker , 转换好的的 JobWorker 对象
	*/
	@Transient
	public static JobWorker createFrom(Map<String,Object> jobWorkerMap) {
		if(jobWorkerMap==null) return null;
		JobWorker po = EntityContext.create(JobWorker.class, jobWorkerMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 JobWorker
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return JobWorker , 转换好的的 JobWorker 对象
	*/
	@Transient
	public static JobWorker createFrom(Object pojo) {
		if(pojo==null) return null;
		JobWorker po = EntityContext.create(JobWorker.class,pojo);
		return po;
	}

	/**
	 * 创建一个 JobWorker，等同于 new
	 * @return JobWorker 对象
	*/
	@Transient
	public static JobWorker create() {
		return EntityContext.create(JobWorker.class);
	}
}