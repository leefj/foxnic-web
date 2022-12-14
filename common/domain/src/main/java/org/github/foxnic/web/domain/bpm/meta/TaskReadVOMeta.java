package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.TaskReadVO;
import java.util.List;
import org.github.foxnic.web.domain.bpm.TaskRead;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:57
 * @sign 86D0D052DFF62226053D46E1481ACD41
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskReadVOMeta extends TaskReadMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,ID, java.lang.String.class, "id", "id", java.lang.String.class, null);
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 任务ID , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> TASK_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,TASK_ID, java.lang.String.class, "任务ID", "任务ID", java.lang.String.class, null);
	
	/**
	 * 确认时间 , 已阅确认时间 , 类型: java.util.Date
	*/
	public static final String CONFIRM_TIME="confirmTime";
	
	/**
	 * 确认时间 , 已阅确认时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.util.Date> CONFIRM_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,CONFIRM_TIME, java.util.Date.class, "确认时间", "已阅确认时间", java.util.Date.class, null);
	
	/**
	 * 评论 , 类型: java.lang.String
	*/
	public static final String COMMENT="comment";
	
	/**
	 * 评论 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> COMMENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,COMMENT, java.lang.String.class, "评论", "评论", java.lang.String.class, null);
	
	/**
	 * 阅读状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 阅读状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,STATUS, java.lang.String.class, "阅读状态", "阅读状态", java.lang.String.class, null);
	
	/**
	 * 创建人 , 阅读人 , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人 , 阅读人 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,CREATE_BY, java.lang.String.class, "创建人", "阅读人", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * tenant_id , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * tenant_id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,TENANT_ID, java.lang.String.class, "tenant_id", "tenant_id", java.lang.String.class, null);
	
	/**
	 * 持续阅读时间 , 类型: java.util.Date
	*/
	public static final String LATEST_TIME="latestTime";
	
	/**
	 * 持续阅读时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,java.util.Date> LATEST_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,LATEST_TIME, java.util.Date.class, "持续阅读时间", "持续阅读时间", java.util.Date.class, null);
	
	/**
	 * 阅读人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final String READER="reader";
	
	/**
	 * 阅读人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskReadVO,org.github.foxnic.web.domain.oauth.User> READER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskReadVO.class ,READER, org.github.foxnic.web.domain.oauth.User.class, "阅读人", "阅读人", org.github.foxnic.web.domain.oauth.User.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , PROCESS_INSTANCE_ID , TASK_ID , CONFIRM_TIME , COMMENT , STATUS , CREATE_BY , CREATE_TIME , VERSION , TENANT_ID , LATEST_TIME , READER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.TaskReadVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public TaskReadVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public TaskReadVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public TaskReadVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public TaskReadVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public TaskReadVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public TaskReadVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public TaskReadVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public TaskReadVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public TaskReadVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 id
		 * @param id id
		 * @return 当前对象
		*/
		public TaskRead setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程实例ID
		 * @param processInstanceId 流程实例ID
		 * @return 当前对象
		*/
		public TaskRead setProcessInstanceId(String processInstanceId) {
			super.change(PROCESS_INSTANCE_ID,super.getProcessInstanceId(),processInstanceId);
			super.setProcessInstanceId(processInstanceId);
			return this;
		}
		
		/**
		 * 设置 任务ID
		 * @param taskId 任务ID
		 * @return 当前对象
		*/
		public TaskRead setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 确认时间
		 * @param confirmTime 确认时间
		 * @return 当前对象
		*/
		public TaskRead setConfirmTime(Date confirmTime) {
			super.change(CONFIRM_TIME,super.getConfirmTime(),confirmTime);
			super.setConfirmTime(confirmTime);
			return this;
		}
		
		/**
		 * 设置 评论
		 * @param comment 评论
		 * @return 当前对象
		*/
		public TaskRead setComment(String comment) {
			super.change(COMMENT,super.getComment(),comment);
			super.setComment(comment);
			return this;
		}
		
		/**
		 * 设置 阅读状态
		 * @param status 阅读状态
		 * @return 当前对象
		*/
		public TaskRead setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 创建人
		 * @param createBy 创建人
		 * @return 当前对象
		*/
		public TaskRead setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public TaskRead setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public TaskRead setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 tenant_id
		 * @param tenantId tenant_id
		 * @return 当前对象
		*/
		public TaskRead setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 持续阅读时间
		 * @param latestTime 持续阅读时间
		 * @return 当前对象
		*/
		public TaskRead setLatestTime(Date latestTime) {
			super.change(LATEST_TIME,super.getLatestTime(),latestTime);
			super.setLatestTime(latestTime);
			return this;
		}
		
		/**
		 * 设置 阅读人
		 * @param reader 阅读人
		 * @return 当前对象
		*/
		public TaskRead setReader(User reader) {
			super.change(READER,super.getReader(),reader);
			super.setReader(reader);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public TaskReadVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public TaskReadVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setProcessInstanceId(this.getProcessInstanceId());
			inst.setCreateBy(this.getCreateBy());
			inst.setCreateTime(this.getCreateTime());
			inst.setTenantId(this.getTenantId());
			inst.setConfirmTime(this.getConfirmTime());
			inst.setComment(this.getComment());
			inst.setId(this.getId());
			inst.setLatestTime(this.getLatestTime());
			inst.setVersion(this.getVersion());
			inst.setTaskId(this.getTaskId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setReader(this.getReader());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setPageSize(this.getPageSize());
				inst.setIds(this.getIds());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}