package org.github.foxnic.web.domain.job.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.job.JobVO;
import java.util.List;
import org.github.foxnic.web.domain.job.Job;
import java.util.Date;
import org.github.foxnic.web.domain.job.JobWorker;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-06 16:19:13
 * @sign EA93CE36C2B9313F6C823D4451A8D228
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class JobVOMeta extends JobMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 任务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,NAME, java.lang.String.class, "任务名称", "任务名称", java.lang.String.class, null);
	
	/**
	 * 组别 , 类型: java.lang.String
	*/
	public static final String GROUP_TAG="groupTag";
	
	/**
	 * 组别 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> GROUP_TAG_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,GROUP_TAG, java.lang.String.class, "组别", "组别", java.lang.String.class, null);
	
	/**
	 * 执行类ID , 类型: java.lang.String
	*/
	public static final String WORKER_ID="workerId";
	
	/**
	 * 执行类ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> WORKER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,WORKER_ID, java.lang.String.class, "执行类ID", "执行类ID", java.lang.String.class, null);
	
	/**
	 * cron表达式 , 类型: java.lang.String
	*/
	public static final String CRON_EXPR="cronExpr";
	
	/**
	 * cron表达式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> CRON_EXPR_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,CRON_EXPR, java.lang.String.class, "cron表达式", "cron表达式", java.lang.String.class, null);
	
	/**
	 * 执行参数 , JSON对象格式 , 类型: java.lang.String
	*/
	public static final String PARAMETER="parameter";
	
	/**
	 * 执行参数 , JSON对象格式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> PARAMETER_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,PARAMETER, java.lang.String.class, "执行参数", "JSON对象格式", java.lang.String.class, null);
	
	/**
	 * 是否并发执行（0允许 , 1禁止） , 类型: java.lang.Integer
	*/
	public static final String CONCURRENT="concurrent";
	
	/**
	 * 是否并发执行（0允许 , 1禁止） , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.Integer> CONCURRENT_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,CONCURRENT, java.lang.Integer.class, "是否并发执行（0允许", "1禁止）", java.lang.Integer.class, null);
	
	/**
	 * 遗漏执行的策略 , 类型: java.lang.String
	*/
	public static final String MISFIRE_POLICY="misfirePolicy";
	
	/**
	 * 遗漏执行的策略 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> MISFIRE_POLICY_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,MISFIRE_POLICY, java.lang.String.class, "遗漏执行的策略", "遗漏执行的策略", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 执行错误次数 , 类型: java.lang.Integer
	*/
	public static final String ERRORS="errors";
	
	/**
	 * 执行错误次数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.Integer> ERRORS_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,ERRORS, java.lang.Integer.class, "执行错误次数", "执行错误次数", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 任务的执行类 , 类型: org.github.foxnic.web.domain.job.JobWorker
	*/
	public static final String WORKER="worker";
	
	/**
	 * 任务的执行类 , 类型: org.github.foxnic.web.domain.job.JobWorker
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,org.github.foxnic.web.domain.job.JobWorker> WORKER_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,WORKER, org.github.foxnic.web.domain.job.JobWorker.class, "任务的执行类", "任务的执行类", org.github.foxnic.web.domain.job.JobWorker.class, null);
	
	/**
	 * 下一次执行时间 , 下次执行时间 , 类型: java.util.Date
	*/
	public static final String NEXT_FIRE_TIME="nextFireTime";
	
	/**
	 * 下一次执行时间 , 下次执行时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.job.JobVO,java.util.Date> NEXT_FIRE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.job.JobVO.class ,NEXT_FIRE_TIME, java.util.Date.class, "下一次执行时间", "下次执行时间", java.util.Date.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , NAME , GROUP_TAG , WORKER_ID , CRON_EXPR , PARAMETER , CONCURRENT , MISFIRE_POLICY , STATUS , ERRORS , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , WORKER , NEXT_FIRE_TIME };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.job.JobVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public JobVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public JobVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public JobVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public JobVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public JobVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public JobVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public JobVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public JobVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public JobVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
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
		 * 设置 执行错误次数
		 * @param errors 执行错误次数
		 * @return 当前对象
		*/
		public Job setErrors(Integer errors) {
			super.change(ERRORS,super.getErrors(),errors);
			super.setErrors(errors);
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