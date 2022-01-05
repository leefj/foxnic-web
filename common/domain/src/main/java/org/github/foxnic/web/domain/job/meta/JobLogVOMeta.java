package org.github.foxnic.web.domain.job.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.job.JobLogVO;
import java.util.List;
import org.github.foxnic.web.domain.job.JobLog;
import java.sql.Timestamp;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-05 16:56:10
 * @sign 02392FB833ECD2AD369321F6F79A047A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class JobLogVOMeta extends JobLogMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 组别 , 类型: java.lang.String
	*/
	public static final String JOB_ID="jobId";
	
	/**
	 * 组别 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> JOB_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,JOB_ID, java.lang.String.class, "组别", "组别", java.lang.String.class, null);
	
	/**
	 * 日志分类 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 日志分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,TYPE, java.lang.String.class, "日志分类", "日志分类", java.lang.String.class, null);
	
	/**
	 * 任务名称 , 类型: java.lang.String
	*/
	public static final String JOB_NAME="jobName";
	
	/**
	 * 任务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> JOB_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,JOB_NAME, java.lang.String.class, "任务名称", "任务名称", java.lang.String.class, null);
	
	/**
	 * 本次执行类 , 类型: java.lang.String
	*/
	public static final String CLASS_NAME="className";
	
	/**
	 * 本次执行类 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> CLASS_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,CLASS_NAME, java.lang.String.class, "本次执行类", "本次执行类", java.lang.String.class, null);
	
	/**
	 * 本次执行cron表达式 , 类型: java.lang.String
	*/
	public static final String CRON_EXPR="cronExpr";
	
	/**
	 * 本次执行cron表达式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> CRON_EXPR_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,CRON_EXPR, java.lang.String.class, "本次执行cron表达式", "本次执行cron表达式", java.lang.String.class, null);
	
	/**
	 * 本次执行参数 , 类型: java.lang.String
	*/
	public static final String PARAMETER="parameter";
	
	/**
	 * 本次执行参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> PARAMETER_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,PARAMETER, java.lang.String.class, "本次执行参数", "本次执行参数", java.lang.String.class, null);
	
	/**
	 * 是否成功执行 , 类型: java.lang.Integer
	*/
	public static final String SUCCESS="success";
	
	/**
	 * 是否成功执行 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.Integer> SUCCESS_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,SUCCESS, java.lang.Integer.class, "是否成功执行", "是否成功执行", java.lang.Integer.class, null);
	
	/**
	 * 执行结果 , 可记录大文本信息 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 执行结果 , 可记录大文本信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> RESULT_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,RESULT, java.lang.String.class, "执行结果", "可记录大文本信息", java.lang.String.class, null);
	
	/**
	 * 开始执行的时间 , 类型: java.sql.Timestamp
	*/
	public static final String BEGIN_TIME="beginTime";
	
	/**
	 * 开始执行的时间 , 类型: java.sql.Timestamp
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.sql.Timestamp> BEGIN_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,BEGIN_TIME, java.sql.Timestamp.class, "开始执行的时间", "开始执行的时间", java.sql.Timestamp.class, null);
	
	/**
	 * 结束执行的时间 , 类型: java.sql.Timestamp
	*/
	public static final String END_TIME="endTime";
	
	/**
	 * 结束执行的时间 , 类型: java.sql.Timestamp
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.sql.Timestamp> END_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,END_TIME, java.sql.Timestamp.class, "结束执行的时间", "结束执行的时间", java.sql.Timestamp.class, null);
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final String EXCEPTION="exception";
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> EXCEPTION_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,EXCEPTION, java.lang.String.class, "异常信息", "异常信息", java.lang.String.class, null);
	
	/**
	 * 日志信息 , 类型: java.lang.String
	*/
	public static final String LOG_TEXT="logText";
	
	/**
	 * 日志信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> LOG_TEXT_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,LOG_TEXT, java.lang.String.class, "日志信息", "日志信息", java.lang.String.class, null);
	
	/**
	 * 账户ID , 操作人ID , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 账户ID , 操作人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.String> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,USER_ID, java.lang.String.class, "账户ID", "操作人ID", java.lang.String.class, null);
	
	/**
	 * 是否是手动执行 , 类型: java.lang.Integer
	*/
	public static final String IS_MANUAL="isManual";
	
	/**
	 * 是否是手动执行 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.Integer> IS_MANUAL_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,IS_MANUAL, java.lang.Integer.class, "是否是手动执行", "是否是手动执行", java.lang.Integer.class, null);
	
	/**
	 * 是否为丢失补充执行 , 类型: java.lang.Integer
	*/
	public static final String IS_MISSFIRE="isMissfire";
	
	/**
	 * 是否为丢失补充执行 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobLogVO,java.lang.Integer> IS_MISSFIRE_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobLogVO.class ,IS_MISSFIRE, java.lang.Integer.class, "是否为丢失补充执行", "是否为丢失补充执行", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , JOB_ID , TYPE , JOB_NAME , CLASS_NAME , CRON_EXPR , PARAMETER , SUCCESS , RESULT , BEGIN_TIME , END_TIME , EXCEPTION , LOG_TEXT , USER_ID , IS_MANUAL , IS_MISSFIRE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.job.JobLogVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public JobLogVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public JobLogVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public JobLogVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public JobLogVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public JobLogVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public JobLogVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public JobLogVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public JobLogVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public JobLogVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
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