package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.DemoLeaveVO;
import java.util.List;
import org.github.foxnic.web.domain.bpm.DemoLeave;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.ProcessInstance;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-18 11:54:31
 * @sign F57E20F6FA5F5FC874AC35388FAA323C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DemoLeaveVOMeta extends DemoLeaveMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 请假类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 请假类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,TYPE, java.lang.String.class, "请假类型", "请假类型", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String BEGIN_TIME="beginTime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.util.Date> BEGIN_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,BEGIN_TIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String END_TIME="endTime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.util.Date> END_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,END_TIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 请假事由 , 类型: java.lang.String
	*/
	public static final String REASON="reason";
	
	/**
	 * 请假事由 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.String> REASON_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,REASON, java.lang.String.class, "请假事由", "请假事由", java.lang.String.class, null);
	
	/**
	 * 申请人 , 员工ID , 类型: java.lang.String
	*/
	public static final String APPLICANT_ID="applicantId";
	
	/**
	 * 申请人 , 员工ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.String> APPLICANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,APPLICANT_ID, java.lang.String.class, "申请人", "员工ID", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String HISTORIC_PROCESS_LIST="historicProcessList";
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,org.github.foxnic.web.domain.bpm.ProcessInstance> HISTORIC_PROCESS_LIST_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,HISTORIC_PROCESS_LIST, java.util.List.class, "历史流程清单", "历史流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String CURRENT_PROCESS_LIST="currentProcessList";
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,org.github.foxnic.web.domain.bpm.ProcessInstance> CURRENT_PROCESS_LIST_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,CURRENT_PROCESS_LIST, java.util.List.class, "在批的流程清单", "在批的流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String DEFAULT_PROCESS="defaultProcess";
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeaveVO,org.github.foxnic.web.domain.bpm.ProcessInstance> DEFAULT_PROCESS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeaveVO.class ,DEFAULT_PROCESS, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "默认流程", "优先取在批的流程", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , TYPE , BEGIN_TIME , END_TIME , REASON , APPLICANT_ID , STATUS , HISTORIC_PROCESS_LIST , CURRENT_PROCESS_LIST , DEFAULT_PROCESS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.DemoLeaveVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public DemoLeaveVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public DemoLeaveVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public DemoLeaveVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public DemoLeaveVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public DemoLeaveVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public DemoLeaveVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public DemoLeaveVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public DemoLeaveVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public DemoLeaveVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DemoLeave setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 请假类型
		 * @param type 请假类型
		 * @return 当前对象
		*/
		public DemoLeave setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param beginTime 开始时间
		 * @return 当前对象
		*/
		public DemoLeave setBeginTime(Date beginTime) {
			super.change(BEGIN_TIME,super.getBeginTime(),beginTime);
			super.setBeginTime(beginTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param endTime 结束时间
		 * @return 当前对象
		*/
		public DemoLeave setEndTime(Date endTime) {
			super.change(END_TIME,super.getEndTime(),endTime);
			super.setEndTime(endTime);
			return this;
		}
		
		/**
		 * 设置 请假事由
		 * @param reason 请假事由
		 * @return 当前对象
		*/
		public DemoLeave setReason(String reason) {
			super.change(REASON,super.getReason(),reason);
			super.setReason(reason);
			return this;
		}
		
		/**
		 * 设置 申请人
		 * @param applicantId 申请人
		 * @return 当前对象
		*/
		public DemoLeave setApplicantId(String applicantId) {
			super.change(APPLICANT_ID,super.getApplicantId(),applicantId);
			super.setApplicantId(applicantId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public DemoLeave setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 历史流程清单
		 * @param historicProcessList 历史流程清单
		 * @return 当前对象
		*/
		public DemoLeave setHistoricProcessList(List<ProcessInstance> historicProcessList) {
			super.change(HISTORIC_PROCESS_LIST,super.getHistoricProcessList(),historicProcessList);
			super.setHistoricProcessList(historicProcessList);
			return this;
		}
		
		/**
		 * 设置 在批的流程清单
		 * @param currentProcessList 在批的流程清单
		 * @return 当前对象
		*/
		public DemoLeave setCurrentProcessList(List<ProcessInstance> currentProcessList) {
			super.change(CURRENT_PROCESS_LIST,super.getCurrentProcessList(),currentProcessList);
			super.setCurrentProcessList(currentProcessList);
			return this;
		}
		
		/**
		 * 设置 默认流程
		 * @param defaultProcess 默认流程
		 * @return 当前对象
		*/
		public DemoLeave setDefaultProcess(ProcessInstance defaultProcess) {
			super.change(DEFAULT_PROCESS,super.getDefaultProcess(),defaultProcess);
			super.setDefaultProcess(defaultProcess);
			return this;
		}
	}
}