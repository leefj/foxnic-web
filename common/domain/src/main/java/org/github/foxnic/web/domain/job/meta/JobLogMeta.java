package org.github.foxnic.web.domain.job.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.job.JobLog;
import java.sql.Timestamp;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-05 16:56:10
 * @sign 2DC907DEF3473B159A6E778363DA3D29
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class JobLogMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 组别 , 类型: java.lang.String
	*/
	public static final String JOB_ID="jobId";
	
	/**
	 * 组别 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.String> JOB_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,JOB_ID, java.lang.String.class, "组别", "组别", java.lang.String.class, null);
	
	/**
	 * 日志分类 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 日志分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,TYPE, java.lang.String.class, "日志分类", "日志分类", java.lang.String.class, null);
	
	/**
	 * 任务名称 , 类型: java.lang.String
	*/
	public static final String JOB_NAME="jobName";
	
	/**
	 * 任务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.String> JOB_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,JOB_NAME, java.lang.String.class, "任务名称", "任务名称", java.lang.String.class, null);
	
	/**
	 * 本次执行类 , 类型: java.lang.String
	*/
	public static final String CLASS_NAME="className";
	
	/**
	 * 本次执行类 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.String> CLASS_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,CLASS_NAME, java.lang.String.class, "本次执行类", "本次执行类", java.lang.String.class, null);
	
	/**
	 * 本次执行cron表达式 , 类型: java.lang.String
	*/
	public static final String CRON_EXPR="cronExpr";
	
	/**
	 * 本次执行cron表达式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.String> CRON_EXPR_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,CRON_EXPR, java.lang.String.class, "本次执行cron表达式", "本次执行cron表达式", java.lang.String.class, null);
	
	/**
	 * 本次执行参数 , 类型: java.lang.String
	*/
	public static final String PARAMETER="parameter";
	
	/**
	 * 本次执行参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.String> PARAMETER_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,PARAMETER, java.lang.String.class, "本次执行参数", "本次执行参数", java.lang.String.class, null);
	
	/**
	 * 是否成功执行 , 类型: java.lang.Integer
	*/
	public static final String SUCCESS="success";
	
	/**
	 * 是否成功执行 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.Integer> SUCCESS_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,SUCCESS, java.lang.Integer.class, "是否成功执行", "是否成功执行", java.lang.Integer.class, null);
	
	/**
	 * 执行结果 , 可记录大文本信息 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 执行结果 , 可记录大文本信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.String> RESULT_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,RESULT, java.lang.String.class, "执行结果", "可记录大文本信息", java.lang.String.class, null);
	
	/**
	 * 开始执行的时间 , 类型: java.sql.Timestamp
	*/
	public static final String BEGIN_TIME="beginTime";
	
	/**
	 * 开始执行的时间 , 类型: java.sql.Timestamp
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.sql.Timestamp> BEGIN_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,BEGIN_TIME, java.sql.Timestamp.class, "开始执行的时间", "开始执行的时间", java.sql.Timestamp.class, null);
	
	/**
	 * 结束执行的时间 , 类型: java.sql.Timestamp
	*/
	public static final String END_TIME="endTime";
	
	/**
	 * 结束执行的时间 , 类型: java.sql.Timestamp
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.sql.Timestamp> END_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,END_TIME, java.sql.Timestamp.class, "结束执行的时间", "结束执行的时间", java.sql.Timestamp.class, null);
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final String EXCEPTION="exception";
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.String> EXCEPTION_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,EXCEPTION, java.lang.String.class, "异常信息", "异常信息", java.lang.String.class, null);
	
	/**
	 * 日志信息 , 类型: java.lang.String
	*/
	public static final String LOG_TEXT="logText";
	
	/**
	 * 日志信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.String> LOG_TEXT_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,LOG_TEXT, java.lang.String.class, "日志信息", "日志信息", java.lang.String.class, null);
	
	/**
	 * 账户ID , 操作人ID , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 账户ID , 操作人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.String> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,USER_ID, java.lang.String.class, "账户ID", "操作人ID", java.lang.String.class, null);
	
	/**
	 * 是否是手动执行 , 类型: java.lang.Integer
	*/
	public static final String IS_MANUAL="isManual";
	
	/**
	 * 是否是手动执行 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.Integer> IS_MANUAL_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,IS_MANUAL, java.lang.Integer.class, "是否是手动执行", "是否是手动执行", java.lang.Integer.class, null);
	
	/**
	 * 是否为丢失补充执行 , 类型: java.lang.Integer
	*/
	public static final String IS_MISSFIRE="isMissfire";
	
	/**
	 * 是否为丢失补充执行 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLog,java.lang.Integer> IS_MISSFIRE_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLog.class ,IS_MISSFIRE, java.lang.Integer.class, "是否为丢失补充执行", "是否为丢失补充执行", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , JOB_ID , TYPE , JOB_NAME , CLASS_NAME , CRON_EXPR , PARAMETER , SUCCESS , RESULT , BEGIN_TIME , END_TIME , EXCEPTION , LOG_TEXT , USER_ID , IS_MANUAL , IS_MISSFIRE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.job.JobLog {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public JobLog setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 组别
		 * @param jobId 组别
		 * @return 当前对象
		*/
		public JobLog setJobId(String jobId) {
			super.change(JOB_ID,super.getJobId(),jobId);
			super.setJobId(jobId);
			return this;
		}
		
		/**
		 * 设置 日志分类
		 * @param type 日志分类
		 * @return 当前对象
		*/
		public JobLog setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 任务名称
		 * @param jobName 任务名称
		 * @return 当前对象
		*/
		public JobLog setJobName(String jobName) {
			super.change(JOB_NAME,super.getJobName(),jobName);
			super.setJobName(jobName);
			return this;
		}
		
		/**
		 * 设置 本次执行类
		 * @param className 本次执行类
		 * @return 当前对象
		*/
		public JobLog setClassName(String className) {
			super.change(CLASS_NAME,super.getClassName(),className);
			super.setClassName(className);
			return this;
		}
		
		/**
		 * 设置 本次执行cron表达式
		 * @param cronExpr 本次执行cron表达式
		 * @return 当前对象
		*/
		public JobLog setCronExpr(String cronExpr) {
			super.change(CRON_EXPR,super.getCronExpr(),cronExpr);
			super.setCronExpr(cronExpr);
			return this;
		}
		
		/**
		 * 设置 本次执行参数
		 * @param parameter 本次执行参数
		 * @return 当前对象
		*/
		public JobLog setParameter(String parameter) {
			super.change(PARAMETER,super.getParameter(),parameter);
			super.setParameter(parameter);
			return this;
		}
		
		/**
		 * 设置 是否成功执行
		 * @param success 是否成功执行
		 * @return 当前对象
		*/
		public JobLog setSuccess(Integer success) {
			super.change(SUCCESS,super.getSuccess(),success);
			super.setSuccess(success);
			return this;
		}
		
		/**
		 * 设置 执行结果
		 * @param result 执行结果
		 * @return 当前对象
		*/
		public JobLog setResult(String result) {
			super.change(RESULT,super.getResult(),result);
			super.setResult(result);
			return this;
		}
		
		/**
		 * 设置 开始执行的时间
		 * @param beginTime 开始执行的时间
		 * @return 当前对象
		*/
		public JobLog setBeginTime(Timestamp beginTime) {
			super.change(BEGIN_TIME,super.getBeginTime(),beginTime);
			super.setBeginTime(beginTime);
			return this;
		}
		
		/**
		 * 设置 结束执行的时间
		 * @param endTime 结束执行的时间
		 * @return 当前对象
		*/
		public JobLog setEndTime(Timestamp endTime) {
			super.change(END_TIME,super.getEndTime(),endTime);
			super.setEndTime(endTime);
			return this;
		}
		
		/**
		 * 设置 异常信息
		 * @param exception 异常信息
		 * @return 当前对象
		*/
		public JobLog setException(String exception) {
			super.change(EXCEPTION,super.getException(),exception);
			super.setException(exception);
			return this;
		}
		
		/**
		 * 设置 日志信息
		 * @param logText 日志信息
		 * @return 当前对象
		*/
		public JobLog setLogText(String logText) {
			super.change(LOG_TEXT,super.getLogText(),logText);
			super.setLogText(logText);
			return this;
		}
		
		/**
		 * 设置 账户ID
		 * @param userId 账户ID
		 * @return 当前对象
		*/
		public JobLog setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 是否是手动执行
		 * @param isManual 是否是手动执行
		 * @return 当前对象
		*/
		public JobLog setIsManual(Integer isManual) {
			super.change(IS_MANUAL,super.getIsManual(),isManual);
			super.setIsManual(isManual);
			return this;
		}
		
		/**
		 * 设置 是否为丢失补充执行
		 * @param isMissfire 是否为丢失补充执行
		 * @return 当前对象
		*/
		public JobLog setIsMissfire(Integer isMissfire) {
			super.change(IS_MISSFIRE,super.getIsMissfire(),isMissfire);
			super.setIsMissfire(isMissfire);
			return this;
		}
	}
}