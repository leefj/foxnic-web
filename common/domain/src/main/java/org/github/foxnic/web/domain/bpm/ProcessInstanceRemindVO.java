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
import org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程实例提醒VO类型
 * <p>流程实例提醒 , 数据表 bpm_process_instance_remind 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-20 17:25:36
 * @sign 59CE4356DAE7C66615715B0647A7EE65
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "流程实例提醒VO类型 ; 流程实例提醒 , 数据表 bpm_process_instance_remind 的通用VO类型" , parent = ProcessInstanceRemind.class)
public class ProcessInstanceRemindVO extends ProcessInstanceRemind {

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
	 * 接收人参数：接收人参数
	*/
	@ApiModelProperty(required = false,value="接收人参数" , notes = "接收人参数")
	private String receiverInfo;
	
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
	public ProcessInstanceRemindVO setPageIndex(Integer pageIndex) {
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
	public ProcessInstanceRemindVO setPageSize(Integer pageSize) {
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
	public ProcessInstanceRemindVO setSearchField(String searchField) {
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
	public ProcessInstanceRemindVO setFuzzyField(String fuzzyField) {
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
	public ProcessInstanceRemindVO setSearchValue(String searchValue) {
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
	public ProcessInstanceRemindVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public ProcessInstanceRemindVO addDirtyField(String... dirtyField) {
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
	public ProcessInstanceRemindVO setSortField(String sortField) {
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
	public ProcessInstanceRemindVO setSortType(String sortType) {
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
	public ProcessInstanceRemindVO setDataOrigin(String dataOrigin) {
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
	public ProcessInstanceRemindVO setQueryLogic(String queryLogic) {
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
	public ProcessInstanceRemindVO setRequestAction(String requestAction) {
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
	public ProcessInstanceRemindVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public ProcessInstanceRemindVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	
	/**
	 * 获得 接收人参数<br>
	 * 接收人参数
	 * @return 接收人参数
	*/
	public String getReceiverInfo() {
		return receiverInfo;
	}
	
	/**
	 * 设置 接收人参数
	 * @param receiverInfo 接收人参数
	 * @return 当前对象
	*/
	public ProcessInstanceRemindVO setReceiverInfo(String receiverInfo) {
		this.receiverInfo=receiverInfo;
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
	 * @return ProcessInstanceRemindVO , 转换好的 ProcessInstanceRemindVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessInstanceRemindVO , 转换好的 PoJo 对象
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
	public ProcessInstanceRemindVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ProcessInstanceRemindVO duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindVOMeta.$$proxy$$();
		inst.setProcessInstanceId(this.getProcessInstanceId());
		inst.setCompleteTime(this.getCompleteTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setRemindTermUnit(this.getRemindTermUnit());
		inst.setContent(this.getContent());
		inst.setRemindTerm(this.getRemindTerm());
		inst.setRemindTime(this.getRemindTime());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setSourceNodeId(this.getSourceNodeId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTargetNodeId(this.getTargetNodeId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setReceiverInfo(this.getReceiverInfo());
			inst.setProcessInstance(this.getProcessInstance());
			inst.setPageSize(this.getPageSize());
			inst.setTargetNode(this.getTargetNode());
			inst.setReceivers(this.getReceivers());
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
	public ProcessInstanceRemindVO clone(boolean deep) {
		return EntityContext.clone(ProcessInstanceRemindVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ProcessInstanceRemindVO
	 * @param processInstanceRemindMap 包含实体信息的 Map 对象
	 * @return ProcessInstanceRemindVO , 转换好的的 ProcessInstanceRemind 对象
	*/
	@Transient
	public static ProcessInstanceRemindVO createFrom(Map<String,Object> processInstanceRemindMap) {
		if(processInstanceRemindMap==null) return null;
		ProcessInstanceRemindVO vo = create();
		EntityContext.copyProperties(vo,processInstanceRemindMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 ProcessInstanceRemindVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessInstanceRemindVO , 转换好的的 ProcessInstanceRemind 对象
	*/
	@Transient
	public static ProcessInstanceRemindVO createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessInstanceRemindVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 ProcessInstanceRemindVO，等同于 new
	 * @return ProcessInstanceRemindVO 对象
	*/
	@Transient
	public static ProcessInstanceRemindVO create() {
		return new org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindVOMeta.$$proxy$$();
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
			this.setProcessInstanceId(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.PROCESS_INSTANCE_ID)));
			this.setCompleteTime(DataParser.parse(Date.class, map.get(ProcessInstanceRemindVOMeta.COMPLETE_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProcessInstanceRemindVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProcessInstanceRemindVOMeta.VERSION)));
			this.setRemindTermUnit(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.REMIND_TERM_UNIT)));
			this.setContent(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.CONTENT)));
			this.setRemindTerm(DataParser.parse(Integer.class, map.get(ProcessInstanceRemindVOMeta.REMIND_TERM)));
			this.setRemindTime(DataParser.parse(Date.class, map.get(ProcessInstanceRemindVOMeta.REMIND_TIME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProcessInstanceRemindVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProcessInstanceRemindVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProcessInstanceRemindVOMeta.DELETE_TIME)));
			this.setSourceNodeId(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.SOURCE_NODE_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.ID)));
			this.setTargetNodeId(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.TARGET_NODE_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.FUZZY_FIELD)));
			this.setReceiverInfo(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.RECEIVER_INFO)));
			this.setProcessInstance(DataParser.parse(ProcessInstance.class, map.get(ProcessInstanceRemindVOMeta.PROCESS_INSTANCE)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(ProcessInstanceRemindVOMeta.PAGE_SIZE)));
			this.setTargetNode(DataParser.parse(ProcessDefinitionNode.class, map.get(ProcessInstanceRemindVOMeta.TARGET_NODE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(ProcessInstanceRemindVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(ProcessInstanceRemindVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setProcessInstanceId( (String)map.get(ProcessInstanceRemindVOMeta.PROCESS_INSTANCE_ID));
				this.setCompleteTime( (Date)map.get(ProcessInstanceRemindVOMeta.COMPLETE_TIME));
				this.setUpdateTime( (Date)map.get(ProcessInstanceRemindVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(ProcessInstanceRemindVOMeta.VERSION));
				this.setRemindTermUnit( (String)map.get(ProcessInstanceRemindVOMeta.REMIND_TERM_UNIT));
				this.setContent( (String)map.get(ProcessInstanceRemindVOMeta.CONTENT));
				this.setRemindTerm( (Integer)map.get(ProcessInstanceRemindVOMeta.REMIND_TERM));
				this.setRemindTime( (Date)map.get(ProcessInstanceRemindVOMeta.REMIND_TIME));
				this.setCreateBy( (String)map.get(ProcessInstanceRemindVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProcessInstanceRemindVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProcessInstanceRemindVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ProcessInstanceRemindVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ProcessInstanceRemindVOMeta.DELETE_TIME));
				this.setSourceNodeId( (String)map.get(ProcessInstanceRemindVOMeta.SOURCE_NODE_ID));
				this.setTenantId( (String)map.get(ProcessInstanceRemindVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ProcessInstanceRemindVOMeta.DELETE_BY));
				this.setId( (String)map.get(ProcessInstanceRemindVOMeta.ID));
				this.setTargetNodeId( (String)map.get(ProcessInstanceRemindVOMeta.TARGET_NODE_ID));
				this.setStatus( (String)map.get(ProcessInstanceRemindVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(ProcessInstanceRemindVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(ProcessInstanceRemindVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(ProcessInstanceRemindVOMeta.FUZZY_FIELD));
				this.setReceiverInfo( (String)map.get(ProcessInstanceRemindVOMeta.RECEIVER_INFO));
				this.setProcessInstance( (ProcessInstance)map.get(ProcessInstanceRemindVOMeta.PROCESS_INSTANCE));
				this.setPageSize( (Integer)map.get(ProcessInstanceRemindVOMeta.PAGE_SIZE));
				this.setTargetNode( (ProcessDefinitionNode)map.get(ProcessInstanceRemindVOMeta.TARGET_NODE));
				this.setPageIndex( (Integer)map.get(ProcessInstanceRemindVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(ProcessInstanceRemindVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(ProcessInstanceRemindVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(ProcessInstanceRemindVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(ProcessInstanceRemindVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(ProcessInstanceRemindVOMeta.SEARCH_VALUE));
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
			this.setProcessInstanceId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindVOMeta.PROCESS_INSTANCE_ID)));
			this.setCompleteTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceRemindVOMeta.COMPLETE_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceRemindVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProcessInstanceRemindVOMeta.VERSION)));
			this.setRemindTermUnit(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindVOMeta.REMIND_TERM_UNIT)));
			this.setContent(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindVOMeta.CONTENT)));
			this.setRemindTerm(DataParser.parse(Integer.class, r.getValue(ProcessInstanceRemindVOMeta.REMIND_TERM)));
			this.setRemindTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceRemindVOMeta.REMIND_TIME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProcessInstanceRemindVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceRemindVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceRemindVOMeta.DELETE_TIME)));
			this.setSourceNodeId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindVOMeta.SOURCE_NODE_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindVOMeta.ID)));
			this.setTargetNodeId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindVOMeta.TARGET_NODE_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setProcessInstanceId( (String)r.getValue(ProcessInstanceRemindVOMeta.PROCESS_INSTANCE_ID));
				this.setCompleteTime( (Date)r.getValue(ProcessInstanceRemindVOMeta.COMPLETE_TIME));
				this.setUpdateTime( (Date)r.getValue(ProcessInstanceRemindVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(ProcessInstanceRemindVOMeta.VERSION));
				this.setRemindTermUnit( (String)r.getValue(ProcessInstanceRemindVOMeta.REMIND_TERM_UNIT));
				this.setContent( (String)r.getValue(ProcessInstanceRemindVOMeta.CONTENT));
				this.setRemindTerm( (Integer)r.getValue(ProcessInstanceRemindVOMeta.REMIND_TERM));
				this.setRemindTime( (Date)r.getValue(ProcessInstanceRemindVOMeta.REMIND_TIME));
				this.setCreateBy( (String)r.getValue(ProcessInstanceRemindVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProcessInstanceRemindVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProcessInstanceRemindVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ProcessInstanceRemindVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ProcessInstanceRemindVOMeta.DELETE_TIME));
				this.setSourceNodeId( (String)r.getValue(ProcessInstanceRemindVOMeta.SOURCE_NODE_ID));
				this.setTenantId( (String)r.getValue(ProcessInstanceRemindVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ProcessInstanceRemindVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(ProcessInstanceRemindVOMeta.ID));
				this.setTargetNodeId( (String)r.getValue(ProcessInstanceRemindVOMeta.TARGET_NODE_ID));
				this.setStatus( (String)r.getValue(ProcessInstanceRemindVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}