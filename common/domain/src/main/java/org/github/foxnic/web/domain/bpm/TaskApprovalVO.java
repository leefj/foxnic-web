package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;
import org.github.foxnic.web.domain.bpm.meta.TaskApprovalVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程任务审批结果VO类型
 * <p>流程任务审批结果 , 数据表 bpm_task_approval 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-23 16:00:10
 * @sign 8A28BAE32E4EB1BB97142E5E040A0E0E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "流程任务审批结果VO类型 ; 流程任务审批结果 , 数据表 bpm_task_approval 的通用VO类型" , parent = TaskApproval.class)
public class TaskApprovalVO extends TaskApproval {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页码
	*/
	@ApiModelProperty(required = false,value="页码" , notes = "")
	private Integer pageIndex;
	
	/**
	 * 分页大小
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "")
	private Integer pageSize;
	
	/**
	 * 搜索字段
	*/
	@ApiModelProperty(required = false,value="搜索字段" , notes = "")
	private String searchField;
	
	/**
	 * 模糊搜索字段
	*/
	@ApiModelProperty(required = false,value="模糊搜索字段" , notes = "")
	private String fuzzyField;
	
	/**
	 * 搜索的值
	*/
	@ApiModelProperty(required = false,value="搜索的值" , notes = "")
	private String searchValue;
	
	/**
	 * 已修改字段
	*/
	@ApiModelProperty(required = false,value="已修改字段" , notes = "")
	private List<String> dirtyFields;
	
	/**
	 * 排序字段
	*/
	@ApiModelProperty(required = false,value="排序字段" , notes = "")
	private String sortField;
	
	/**
	 * 排序方式
	*/
	@ApiModelProperty(required = false,value="排序方式" , notes = "")
	private String sortType;
	
	/**
	 * 数据来源：前端指定不同的来源，后端可按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端可按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
	/**
	 * 请求动作：前端指定不同的Action，后端可Action执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="请求动作" , notes = "前端指定不同的Action，后端可Action执行不同的逻辑")
	private String requestAction;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 获得 页码<br>
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public TaskApprovalVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public TaskApprovalVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 搜索字段<br>
	 * @return 搜索字段
	*/
	public String getSearchField() {
		return searchField;
	}
	
	/**
	 * 设置 搜索字段
	 * @param searchField 搜索字段
	 * @return 当前对象
	*/
	public TaskApprovalVO setSearchField(String searchField) {
		this.searchField=searchField;
		return this;
	}
	
	/**
	 * 获得 模糊搜索字段<br>
	 * @return 模糊搜索字段
	*/
	public String getFuzzyField() {
		return fuzzyField;
	}
	
	/**
	 * 设置 模糊搜索字段
	 * @param fuzzyField 模糊搜索字段
	 * @return 当前对象
	*/
	public TaskApprovalVO setFuzzyField(String fuzzyField) {
		this.fuzzyField=fuzzyField;
		return this;
	}
	
	/**
	 * 获得 搜索的值<br>
	 * @return 搜索的值
	*/
	public String getSearchValue() {
		return searchValue;
	}
	
	/**
	 * 设置 搜索的值
	 * @param searchValue 搜索的值
	 * @return 当前对象
	*/
	public TaskApprovalVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
	/**
	 * 获得 已修改字段<br>
	 * @return 已修改字段
	*/
	public List<String> getDirtyFields() {
		return dirtyFields;
	}
	
	/**
	 * 设置 已修改字段
	 * @param dirtyFields 已修改字段
	 * @return 当前对象
	*/
	public TaskApprovalVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public TaskApprovalVO addDirtyField(String... dirtyField) {
		if(this.dirtyFields==null) dirtyFields=new ArrayList<>();
		this.dirtyFields.addAll(Arrays.asList(dirtyField));
		return this;
	}
	
	/**
	 * 获得 排序字段<br>
	 * @return 排序字段
	*/
	public String getSortField() {
		return sortField;
	}
	
	/**
	 * 设置 排序字段
	 * @param sortField 排序字段
	 * @return 当前对象
	*/
	public TaskApprovalVO setSortField(String sortField) {
		this.sortField=sortField;
		return this;
	}
	
	/**
	 * 获得 排序方式<br>
	 * @return 排序方式
	*/
	public String getSortType() {
		return sortType;
	}
	
	/**
	 * 设置 排序方式
	 * @param sortType 排序方式
	 * @return 当前对象
	*/
	public TaskApprovalVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端可按来源执行不同的逻辑
	 * @return 数据来源
	*/
	public String getDataOrigin() {
		return dataOrigin;
	}
	
	/**
	 * 设置 数据来源
	 * @param dataOrigin 数据来源
	 * @return 当前对象
	*/
	public TaskApprovalVO setDataOrigin(String dataOrigin) {
		this.dataOrigin=dataOrigin;
		return this;
	}
	
	/**
	 * 获得 查询逻辑<br>
	 * 默认and，可指定 or 
	 * @return 查询逻辑
	*/
	public String getQueryLogic() {
		return queryLogic;
	}
	
	/**
	 * 设置 查询逻辑
	 * @param queryLogic 查询逻辑
	 * @return 当前对象
	*/
	public TaskApprovalVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
		return this;
	}
	
	/**
	 * 获得 请求动作<br>
	 * 前端指定不同的Action，后端可Action执行不同的逻辑
	 * @return 请求动作
	*/
	public String getRequestAction() {
		return requestAction;
	}
	
	/**
	 * 设置 请求动作
	 * @param requestAction 请求动作
	 * @return 当前对象
	*/
	public TaskApprovalVO setRequestAction(String requestAction) {
		this.requestAction=requestAction;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public TaskApprovalVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public TaskApprovalVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	@Transient
	private transient CompositeParameter $compositeParameter;
	/**
	 * 获得解析后的复合查询参数
	 */
	@Transient
	public CompositeParameter getCompositeParameter() {
		if($compositeParameter!=null) return  $compositeParameter;
		$compositeParameter=new CompositeParameter(this.getSearchValue(),BeanUtil.toMap(this));
		return  $compositeParameter;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return TaskApprovalVO , 转换好的 TaskApprovalVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TaskApprovalVO , 转换好的 PoJo 对象
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
	 * 克隆当前对象
	*/
	@Transient
	public TaskApprovalVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public TaskApprovalVO duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.TaskApprovalVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.TaskApprovalVOMeta.$$proxy$$();
		inst.setProcessInstanceId(this.getProcessInstanceId());
		inst.setVariables(this.getVariables());
		inst.setCamundaSuccess(this.getCamundaSuccess());
		inst.setApprovalTime(this.getApprovalTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setAssigneeId(this.getAssigneeId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setApprovalResult(this.getApprovalResult());
		inst.setApprovalComment(this.getApprovalComment());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setCamundaResult(this.getCamundaResult());
		inst.setId(this.getId());
		inst.setApprovalUserId(this.getApprovalUserId());
		inst.setAssigneeType(this.getAssigneeType());
		inst.setTaskId(this.getTaskId());
		if(all) {
			inst.setApprover(this.getApprover());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setApprovalUser(this.getApprovalUser());
			inst.setAttachment(this.getAttachment());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TaskApprovalVO clone(boolean deep) {
		return EntityContext.clone(TaskApprovalVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 TaskApprovalVO
	 * @param taskApprovalMap 包含实体信息的 Map 对象
	 * @return TaskApprovalVO , 转换好的的 TaskApproval 对象
	*/
	@Transient
	public static TaskApprovalVO createFrom(Map<String,Object> taskApprovalMap) {
		if(taskApprovalMap==null) return null;
		TaskApprovalVO vo = create();
		EntityContext.copyProperties(vo,taskApprovalMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 TaskApprovalVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TaskApprovalVO , 转换好的的 TaskApproval 对象
	*/
	@Transient
	public static TaskApprovalVO createFrom(Object pojo) {
		if(pojo==null) return null;
		TaskApprovalVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 TaskApprovalVO，等同于 new
	 * @return TaskApprovalVO 对象
	*/
	@Transient
	public static TaskApprovalVO create() {
		return new org.github.foxnic.web.domain.bpm.meta.TaskApprovalVOMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setProcessInstanceId(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.PROCESS_INSTANCE_ID)));
			this.setVariables(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.VARIABLES)));
			this.setCamundaSuccess(DataParser.parse(Integer.class, map.get(TaskApprovalVOMeta.CAMUNDA_SUCCESS)));
			this.setApprovalTime(DataParser.parse(Date.class, map.get(TaskApprovalVOMeta.APPROVAL_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(TaskApprovalVOMeta.UPDATE_TIME)));
			this.setAssigneeId(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.ASSIGNEE_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(TaskApprovalVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(TaskApprovalVOMeta.DELETED)));
			this.setApprovalResult(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.APPROVAL_RESULT)));
			this.setApprovalComment(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.APPROVAL_COMMENT)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(TaskApprovalVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(TaskApprovalVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.DELETE_BY)));
			this.setCamundaResult(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.CAMUNDA_RESULT)));
			this.setId(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.ID)));
			this.setApprovalUserId(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.APPROVAL_USER_ID)));
			this.setAssigneeType(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.ASSIGNEE_TYPE)));
			this.setTaskId(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.TASK_ID)));
			// others
			this.setApprover(DataParser.parse(Assignee.class, map.get(TaskApprovalVOMeta.APPROVER)));
			this.setSearchField(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(TaskApprovalVOMeta.PAGE_SIZE)));
			this.setApprovalUser(DataParser.parse(User.class, map.get(TaskApprovalVOMeta.APPROVAL_USER)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(TaskApprovalVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(TaskApprovalVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setProcessInstanceId( (String)map.get(TaskApprovalVOMeta.PROCESS_INSTANCE_ID));
				this.setVariables( (String)map.get(TaskApprovalVOMeta.VARIABLES));
				this.setCamundaSuccess( (Integer)map.get(TaskApprovalVOMeta.CAMUNDA_SUCCESS));
				this.setApprovalTime( (Date)map.get(TaskApprovalVOMeta.APPROVAL_TIME));
				this.setUpdateTime( (Date)map.get(TaskApprovalVOMeta.UPDATE_TIME));
				this.setAssigneeId( (String)map.get(TaskApprovalVOMeta.ASSIGNEE_ID));
				this.setVersion( (Integer)map.get(TaskApprovalVOMeta.VERSION));
				this.setCreateBy( (String)map.get(TaskApprovalVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(TaskApprovalVOMeta.DELETED));
				this.setApprovalResult( (String)map.get(TaskApprovalVOMeta.APPROVAL_RESULT));
				this.setApprovalComment( (String)map.get(TaskApprovalVOMeta.APPROVAL_COMMENT));
				this.setCreateTime( (Date)map.get(TaskApprovalVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(TaskApprovalVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(TaskApprovalVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(TaskApprovalVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(TaskApprovalVOMeta.DELETE_BY));
				this.setCamundaResult( (String)map.get(TaskApprovalVOMeta.CAMUNDA_RESULT));
				this.setId( (String)map.get(TaskApprovalVOMeta.ID));
				this.setApprovalUserId( (String)map.get(TaskApprovalVOMeta.APPROVAL_USER_ID));
				this.setAssigneeType( (String)map.get(TaskApprovalVOMeta.ASSIGNEE_TYPE));
				this.setTaskId( (String)map.get(TaskApprovalVOMeta.TASK_ID));
				// others
				this.setApprover( (Assignee)map.get(TaskApprovalVOMeta.APPROVER));
				this.setSearchField( (String)map.get(TaskApprovalVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(TaskApprovalVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(TaskApprovalVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(TaskApprovalVOMeta.PAGE_SIZE));
				this.setApprovalUser( (User)map.get(TaskApprovalVOMeta.APPROVAL_USER));
				this.setPageIndex( (Integer)map.get(TaskApprovalVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(TaskApprovalVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(TaskApprovalVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(TaskApprovalVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(TaskApprovalVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(TaskApprovalVOMeta.SEARCH_VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setProcessInstanceId(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.PROCESS_INSTANCE_ID)));
			this.setVariables(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.VARIABLES)));
			this.setCamundaSuccess(DataParser.parse(Integer.class, r.getValue(TaskApprovalVOMeta.CAMUNDA_SUCCESS)));
			this.setApprovalTime(DataParser.parse(Date.class, r.getValue(TaskApprovalVOMeta.APPROVAL_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(TaskApprovalVOMeta.UPDATE_TIME)));
			this.setAssigneeId(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.ASSIGNEE_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(TaskApprovalVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(TaskApprovalVOMeta.DELETED)));
			this.setApprovalResult(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.APPROVAL_RESULT)));
			this.setApprovalComment(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.APPROVAL_COMMENT)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(TaskApprovalVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(TaskApprovalVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.DELETE_BY)));
			this.setCamundaResult(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.CAMUNDA_RESULT)));
			this.setId(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.ID)));
			this.setApprovalUserId(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.APPROVAL_USER_ID)));
			this.setAssigneeType(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.ASSIGNEE_TYPE)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(TaskApprovalVOMeta.TASK_ID)));
			return true;
		} else {
			try {
				this.setProcessInstanceId( (String)r.getValue(TaskApprovalVOMeta.PROCESS_INSTANCE_ID));
				this.setVariables( (String)r.getValue(TaskApprovalVOMeta.VARIABLES));
				this.setCamundaSuccess( (Integer)r.getValue(TaskApprovalVOMeta.CAMUNDA_SUCCESS));
				this.setApprovalTime( (Date)r.getValue(TaskApprovalVOMeta.APPROVAL_TIME));
				this.setUpdateTime( (Date)r.getValue(TaskApprovalVOMeta.UPDATE_TIME));
				this.setAssigneeId( (String)r.getValue(TaskApprovalVOMeta.ASSIGNEE_ID));
				this.setVersion( (Integer)r.getValue(TaskApprovalVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(TaskApprovalVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(TaskApprovalVOMeta.DELETED));
				this.setApprovalResult( (String)r.getValue(TaskApprovalVOMeta.APPROVAL_RESULT));
				this.setApprovalComment( (String)r.getValue(TaskApprovalVOMeta.APPROVAL_COMMENT));
				this.setCreateTime( (Date)r.getValue(TaskApprovalVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(TaskApprovalVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(TaskApprovalVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(TaskApprovalVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(TaskApprovalVOMeta.DELETE_BY));
				this.setCamundaResult( (String)r.getValue(TaskApprovalVOMeta.CAMUNDA_RESULT));
				this.setId( (String)r.getValue(TaskApprovalVOMeta.ID));
				this.setApprovalUserId( (String)r.getValue(TaskApprovalVOMeta.APPROVAL_USER_ID));
				this.setAssigneeType( (String)r.getValue(TaskApprovalVOMeta.ASSIGNEE_TYPE));
				this.setTaskId( (String)r.getValue(TaskApprovalVOMeta.TASK_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}