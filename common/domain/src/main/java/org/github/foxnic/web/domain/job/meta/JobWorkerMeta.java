package org.github.foxnic.web.domain.job.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.job.JobWorker;
import org.github.foxnic.web.domain.job.JobExecuter;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-05 16:46:14
 * @sign F15D36AC3D61FB01BEC5A771ADFBB0FE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class JobWorkerMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobWorker,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobWorker.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobWorker,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobWorker.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 类名 , 类型: java.lang.String
	*/
	public static final String CLASS_NAME="className";
	
	/**
	 * 类名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobWorker,java.lang.String> CLASS_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobWorker.class ,CLASS_NAME, java.lang.String.class, "类名", "类名", java.lang.String.class, null);
	
	/**
	 * 有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobWorker,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobWorker.class ,VALID, java.lang.Integer.class, "有效", "有效", java.lang.Integer.class, null);
	
	/**
	 * 执行任务的Bean , 类型: org.github.foxnic.web.domain.job.JobExecuter
	*/
	public static final String EXECUTOR="executor";
	
	/**
	 * 执行任务的Bean , 类型: org.github.foxnic.web.domain.job.JobExecuter
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobWorker,org.github.foxnic.web.domain.job.JobExecuter> EXECUTOR_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobWorker.class ,EXECUTOR, org.github.foxnic.web.domain.job.JobExecuter.class, "执行任务的Bean", "执行任务的Bean", org.github.foxnic.web.domain.job.JobExecuter.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , CLASS_NAME , VALID , EXECUTOR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.job.JobWorker {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public JobWorker setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public JobWorker setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 类名
		 * @param className 类名
		 * @return 当前对象
		*/
		public JobWorker setClassName(String className) {
			super.change(CLASS_NAME,super.getClassName(),className);
			super.setClassName(className);
			return this;
		}
		
		/**
		 * 设置 有效
		 * @param valid 有效
		 * @return 当前对象
		*/
		public JobWorker setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 执行任务的Bean
		 * @param executor 执行任务的Bean
		 * @return 当前对象
		*/
		public JobWorker setExecutor(JobExecuter executor) {
			super.change(EXECUTOR,super.getExecutor(),executor);
			super.setExecutor(executor);
			return this;
		}
	}
}