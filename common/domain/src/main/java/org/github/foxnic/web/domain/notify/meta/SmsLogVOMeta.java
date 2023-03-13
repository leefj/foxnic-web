package org.github.foxnic.web.domain.notify.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.notify.SmsLogVO;
import java.util.List;
import org.github.foxnic.web.domain.notify.SmsLog;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:31:33
 * @sign 0770D6AFCA615355EC6A35F338729FC6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SmsLogVOMeta extends SmsLogMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.Integer
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.Integer> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.Integer.class, null);
	
	/**
	 * id , 类型: java.lang.Integer
	*/
	public static final String ID="id";
	
	/**
	 * id , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.Integer> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,ID, java.lang.Integer.class, "id", "id", java.lang.Integer.class, null);
	
	/**
	 * 模版ID , 类型: java.lang.String
	*/
	public static final String TEMPLATE_ID="templateId";
	
	/**
	 * 模版ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> TEMPLATE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,TEMPLATE_ID, java.lang.String.class, "模版ID", "模版ID", java.lang.String.class, null);
	
	/**
	 * 短信通道 , 类型: java.lang.String
	*/
	public static final String CHANEL="chanel";
	
	/**
	 * 短信通道 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> CHANEL_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,CHANEL, java.lang.String.class, "短信通道", "短信通道", java.lang.String.class, null);
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,USER_ID, java.lang.String.class, "账户", "账户", java.lang.String.class, null);
	
	/**
	 * 参数 , 类型: java.lang.String
	*/
	public static final String PARAMS="params";
	
	/**
	 * 参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> PARAMS_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,PARAMS, java.lang.String.class, "参数", "参数", java.lang.String.class, null);
	
	/**
	 * 手机号 , 类型: java.lang.String
	*/
	public static final String PHONE="phone";
	
	/**
	 * 手机号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> PHONE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,PHONE, java.lang.String.class, "手机号", "手机号", java.lang.String.class, null);
	
	/**
	 * 短信内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 短信内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> CONTENT_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,CONTENT, java.lang.String.class, "短信内容", "短信内容", java.lang.String.class, null);
	
	/**
	 * 是否成功 , 类型: java.lang.Integer
	*/
	public static final String SUCCESS="success";
	
	/**
	 * 是否成功 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.Integer> SUCCESS_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,SUCCESS, java.lang.Integer.class, "是否成功", "是否成功", java.lang.Integer.class, null);
	
	/**
	 * 相应 , 类型: java.lang.String
	*/
	public static final String RESPONSE="response";
	
	/**
	 * 相应 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> RESPONSE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,RESPONSE, java.lang.String.class, "相应", "相应", java.lang.String.class, null);
	
	/**
	 * 异常 , 类型: java.lang.String
	*/
	public static final String ERROR="error";
	
	/**
	 * 异常 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> ERROR_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,ERROR, java.lang.String.class, "异常", "异常", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLogVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLogVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , TEMPLATE_ID , CHANEL , USER_ID , PARAMS , PHONE , CONTENT , SUCCESS , RESPONSE , ERROR , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.notify.SmsLogVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public SmsLogVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public SmsLogVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public SmsLogVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public SmsLogVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public SmsLogVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public SmsLogVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public SmsLogVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public SmsLogVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public SmsLogVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public SmsLogVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public SmsLogVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public SmsLogVO setIds(List<Integer> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 id
		 * @param id id
		 * @return 当前对象
		*/
		public SmsLog setId(Integer id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 模版ID
		 * @param templateId 模版ID
		 * @return 当前对象
		*/
		public SmsLog setTemplateId(String templateId) {
			super.change(TEMPLATE_ID,super.getTemplateId(),templateId);
			super.setTemplateId(templateId);
			return this;
		}
		
		/**
		 * 设置 短信通道
		 * @param chanel 短信通道
		 * @return 当前对象
		*/
		public SmsLog setChanel(String chanel) {
			super.change(CHANEL,super.getChanel(),chanel);
			super.setChanel(chanel);
			return this;
		}
		
		/**
		 * 设置 账户
		 * @param userId 账户
		 * @return 当前对象
		*/
		public SmsLog setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 参数
		 * @param params 参数
		 * @return 当前对象
		*/
		public SmsLog setParams(String params) {
			super.change(PARAMS,super.getParams(),params);
			super.setParams(params);
			return this;
		}
		
		/**
		 * 设置 手机号
		 * @param phone 手机号
		 * @return 当前对象
		*/
		public SmsLog setPhone(String phone) {
			super.change(PHONE,super.getPhone(),phone);
			super.setPhone(phone);
			return this;
		}
		
		/**
		 * 设置 短信内容
		 * @param content 短信内容
		 * @return 当前对象
		*/
		public SmsLog setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 是否成功
		 * @param success 是否成功
		 * @return 当前对象
		*/
		public SmsLog setSuccess(Integer success) {
			super.change(SUCCESS,super.getSuccess(),success);
			super.setSuccess(success);
			return this;
		}
		
		/**
		 * 设置 相应
		 * @param response 相应
		 * @return 当前对象
		*/
		public SmsLog setResponse(String response) {
			super.change(RESPONSE,super.getResponse(),response);
			super.setResponse(response);
			return this;
		}
		
		/**
		 * 设置 异常
		 * @param error 异常
		 * @return 当前对象
		*/
		public SmsLog setError(String error) {
			super.change(ERROR,super.getError(),error);
			super.setError(error);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public SmsLog setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SmsLog setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SmsLog setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SmsLog setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SmsLog setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SmsLog setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SmsLog setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SmsLog setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public SmsLog setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SmsLogVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SmsLogVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUpdateTime(this.getUpdateTime());
			inst.setTemplateId(this.getTemplateId());
			inst.setParams(this.getParams());
			inst.setError(this.getError());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setChanel(this.getChanel());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPhone(this.getPhone());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setSuccess(this.getSuccess());
			inst.setResponse(this.getResponse());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setPageSize(this.getPageSize());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}