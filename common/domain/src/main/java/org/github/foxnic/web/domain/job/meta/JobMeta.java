package org.github.foxnic.web.domain.job.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.job.Job;
import java.util.Date;
import org.github.foxnic.web.domain.job.JobWorker;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-07 13:34:40
 * @sign A32D7E1F9B00D141C817FF3ECF9F5688
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class JobMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 任务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,NAME, java.lang.String.class, "任务名称", "任务名称", java.lang.String.class, null);
	
	/**
	 * 组别 , 类型: java.lang.String
	*/
	public static final String GROUP_TAG="groupTag";
	
	/**
	 * 组别 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> GROUP_TAG_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,GROUP_TAG, java.lang.String.class, "组别", "组别", java.lang.String.class, null);
	
	/**
	 * 执行类ID , 类型: java.lang.String
	*/
	public static final String WORKER_ID="workerId";
	
	/**
	 * 执行类ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> WORKER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,WORKER_ID, java.lang.String.class, "执行类ID", "执行类ID", java.lang.String.class, null);
	
	/**
	 * cron表达式 , 类型: java.lang.String
	*/
	public static final String CRON_EXPR="cronExpr";
	
	/**
	 * cron表达式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> CRON_EXPR_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,CRON_EXPR, java.lang.String.class, "cron表达式", "cron表达式", java.lang.String.class, null);
	
	/**
	 * 执行参数 , JSON对象格式 , 类型: java.lang.String
	*/
	public static final String PARAMETER="parameter";
	
	/**
	 * 执行参数 , JSON对象格式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> PARAMETER_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,PARAMETER, java.lang.String.class, "执行参数", "JSON对象格式", java.lang.String.class, null);
	
	/**
	 * 是否并发执行（0允许 , 1禁止） , 类型: java.lang.Integer
	*/
	public static final String CONCURRENT="concurrent";
	
	/**
	 * 是否并发执行（0允许 , 1禁止） , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.Integer> CONCURRENT_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,CONCURRENT, java.lang.Integer.class, "是否并发执行（0允许", "1禁止）", java.lang.Integer.class, null);
	
	/**
	 * 遗漏执行的策略 , 类型: java.lang.String
	*/
	public static final String MISFIRE_POLICY="misfirePolicy";
	
	/**
	 * 遗漏执行的策略 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> MISFIRE_POLICY_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,MISFIRE_POLICY, java.lang.String.class, "遗漏执行的策略", "遗漏执行的策略", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 任务的执行类 , 类型: org.github.foxnic.web.domain.job.JobWorker
	*/
	public static final String WORKER="worker";
	
	/**
	 * 任务的执行类 , 类型: org.github.foxnic.web.domain.job.JobWorker
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,org.github.foxnic.web.domain.job.JobWorker> WORKER_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,WORKER, org.github.foxnic.web.domain.job.JobWorker.class, "任务的执行类", "任务的执行类", org.github.foxnic.web.domain.job.JobWorker.class, null);
	
	/**
	 * 下一次执行时间 , 下次执行时间 , 类型: java.util.Date
	*/
	public static final String NEXT_FIRE_TIME="nextFireTime";
	
	/**
	 * 下一次执行时间 , 下次执行时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.Job,java.util.Date> NEXT_FIRE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.Job.class ,NEXT_FIRE_TIME, java.util.Date.class, "下一次执行时间", "下次执行时间", java.util.Date.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , GROUP_TAG , WORKER_ID , CRON_EXPR , PARAMETER , CONCURRENT , MISFIRE_POLICY , STATUS , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , WORKER , NEXT_FIRE_TIME };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.job.Job {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Job setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务名称
		 * @param name 任务名称
		 * @return 当前对象
		*/
		public Job setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 组别
		 * @param groupTag 组别
		 * @return 当前对象
		*/
		public Job setGroupTag(String groupTag) {
			super.change(GROUP_TAG,super.getGroupTag(),groupTag);
			super.setGroupTag(groupTag);
			return this;
		}
		
		/**
		 * 设置 执行类ID
		 * @param workerId 执行类ID
		 * @return 当前对象
		*/
		public Job setWorkerId(String workerId) {
			super.change(WORKER_ID,super.getWorkerId(),workerId);
			super.setWorkerId(workerId);
			return this;
		}
		
		/**
		 * 设置 cron表达式
		 * @param cronExpr cron表达式
		 * @return 当前对象
		*/
		public Job setCronExpr(String cronExpr) {
			super.change(CRON_EXPR,super.getCronExpr(),cronExpr);
			super.setCronExpr(cronExpr);
			return this;
		}
		
		/**
		 * 设置 执行参数
		 * @param parameter 执行参数
		 * @return 当前对象
		*/
		public Job setParameter(String parameter) {
			super.change(PARAMETER,super.getParameter(),parameter);
			super.setParameter(parameter);
			return this;
		}
		
		/**
		 * 设置 是否并发执行（0允许
		 * @param concurrent 是否并发执行（0允许
		 * @return 当前对象
		*/
		public Job setConcurrent(Integer concurrent) {
			super.change(CONCURRENT,super.getConcurrent(),concurrent);
			super.setConcurrent(concurrent);
			return this;
		}
		
		/**
		 * 设置 遗漏执行的策略
		 * @param misfirePolicy 遗漏执行的策略
		 * @return 当前对象
		*/
		public Job setMisfirePolicy(String misfirePolicy) {
			super.change(MISFIRE_POLICY,super.getMisfirePolicy(),misfirePolicy);
			super.setMisfirePolicy(misfirePolicy);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public Job setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Job setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public Job setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Job setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Job setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Job setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Job setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Job setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Job setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Job setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Job setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 任务的执行类
		 * @param worker 任务的执行类
		 * @return 当前对象
		*/
		public Job setWorker(JobWorker worker) {
			super.change(WORKER,super.getWorker(),worker);
			super.setWorker(worker);
			return this;
		}
		
		/**
		 * 设置 下一次执行时间
		 * @param nextFireTime 下一次执行时间
		 * @return 当前对象
		*/
		public Job setNextFireTime(Date nextFireTime) {
			super.change(NEXT_FIRE_TIME,super.getNextFireTime(),nextFireTime);
			super.setNextFireTime(nextFireTime);
			return this;
		}
	}
}