package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO;
import java.util.List;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionApply;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-04-12 14:02:07
 * @sign 47E2B0115C9D97C41319A9997A4D5D31
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessDefinitionApplyVOMeta extends ProcessDefinitionApplyMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final String DEFINITION_ID="definitionId";
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,DEFINITION_ID, java.lang.String.class, "流程定义ID", "流程定义ID", java.lang.String.class, null);
	
	/**
	 * 流程文件ID , 类型: java.lang.String
	*/
	public static final String DEFINITION_FILE_ID="definitionFileId";
	
	/**
	 * 流程文件ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> DEFINITION_FILE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,DEFINITION_FILE_ID, java.lang.String.class, "流程文件ID", "流程文件ID", java.lang.String.class, null);
	
	/**
	 * 应用请求报文 , 类型: java.lang.String
	*/
	public static final String REQUEST="request";
	
	/**
	 * 应用请求报文 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> REQUEST_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,REQUEST, java.lang.String.class, "应用请求报文", "应用请求报文", java.lang.String.class, null);
	
	/**
	 * 应用结果 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 应用结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> RESULT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,RESULT, java.lang.String.class, "应用结果", "应用结果", java.lang.String.class, null);
	
	/**
	 * 应用时间 , 类型: java.util.Date
	*/
	public static final String APPLY_TIME="applyTime";
	
	/**
	 * 应用时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.util.Date> APPLY_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,APPLY_TIME, java.util.Date.class, "应用时间", "应用时间", java.util.Date.class, null);
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final String EXCEPTION="exception";
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.String> EXCEPTION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,EXCEPTION, java.lang.String.class, "异常信息", "异常信息", java.lang.String.class, null);
	
	/**
	 * 是否成功 , 类型: java.lang.Integer
	*/
	public static final String SUCCESS="success";
	
	/**
	 * 是否成功 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO,java.lang.Integer> SUCCESS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO.class ,SUCCESS, java.lang.Integer.class, "是否成功", "是否成功", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , DEFINITION_ID , DEFINITION_FILE_ID , REQUEST , RESULT , APPLY_TIME , EXCEPTION , SUCCESS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.ProcessDefinitionApplyVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ProcessDefinitionApplyVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ProcessDefinitionApplyVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ProcessDefinitionApplyVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ProcessDefinitionApplyVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ProcessDefinitionApplyVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ProcessDefinitionApplyVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ProcessDefinitionApplyVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ProcessDefinitionApplyVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ProcessDefinitionApplyVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public ProcessDefinitionApply setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程定义ID
		 * @param definitionId 流程定义ID
		 * @return 当前对象
		*/
		public ProcessDefinitionApply setDefinitionId(String definitionId) {
			super.change(DEFINITION_ID,super.getDefinitionId(),definitionId);
			super.setDefinitionId(definitionId);
			return this;
		}
		
		/**
		 * 设置 流程文件ID
		 * @param definitionFileId 流程文件ID
		 * @return 当前对象
		*/
		public ProcessDefinitionApply setDefinitionFileId(String definitionFileId) {
			super.change(DEFINITION_FILE_ID,super.getDefinitionFileId(),definitionFileId);
			super.setDefinitionFileId(definitionFileId);
			return this;
		}
		
		/**
		 * 设置 应用请求报文
		 * @param request 应用请求报文
		 * @return 当前对象
		*/
		public ProcessDefinitionApply setRequest(String request) {
			super.change(REQUEST,super.getRequest(),request);
			super.setRequest(request);
			return this;
		}
		
		/**
		 * 设置 应用结果
		 * @param result 应用结果
		 * @return 当前对象
		*/
		public ProcessDefinitionApply setResult(String result) {
			super.change(RESULT,super.getResult(),result);
			super.setResult(result);
			return this;
		}
		
		/**
		 * 设置 应用时间
		 * @param applyTime 应用时间
		 * @return 当前对象
		*/
		public ProcessDefinitionApply setApplyTime(Date applyTime) {
			super.change(APPLY_TIME,super.getApplyTime(),applyTime);
			super.setApplyTime(applyTime);
			return this;
		}
		
		/**
		 * 设置 异常信息
		 * @param exception 异常信息
		 * @return 当前对象
		*/
		public ProcessDefinitionApply setException(String exception) {
			super.change(EXCEPTION,super.getException(),exception);
			super.setException(exception);
			return this;
		}
		
		/**
		 * 设置 是否成功
		 * @param success 是否成功
		 * @return 当前对象
		*/
		public ProcessDefinitionApply setSuccess(Integer success) {
			super.change(SUCCESS,super.getSuccess(),success);
			super.setSuccess(success);
			return this;
		}
	}
}