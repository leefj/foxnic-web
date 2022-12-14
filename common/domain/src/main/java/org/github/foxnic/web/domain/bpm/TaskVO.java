package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;



/**
 * 流程任务
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:57
 * @sign 4FCB377B347195D15E1834DD55F959F0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskVO extends Task {

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
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 处理人账户ID清单：处理人账户ID清单
	*/
	@ApiModelProperty(required = false,value="处理人账户ID清单" , notes = "处理人账户ID清单")
	private List<String> approvalUserIds;
	
	/**
	 * 是否我的任务：是否我的任务
	*/
	@ApiModelProperty(required = false,value="是否我的任务" , notes = "是否我的任务")
	private Boolean mine;
	
	/**
	 * 状态值清单：设定状态值的查询范围
	*/
	@ApiModelProperty(required = false,value="状态值清单" , notes = "设定状态值的查询范围")
	private List<String> statusRange;
	
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
	public TaskVO setPageIndex(Integer pageIndex) {
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
	public TaskVO setPageSize(Integer pageSize) {
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
	public TaskVO setSearchField(String searchField) {
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
	public TaskVO setFuzzyField(String fuzzyField) {
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
	public TaskVO setSearchValue(String searchValue) {
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
	public TaskVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public TaskVO addDirtyField(String... dirtyField) {
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
	public TaskVO setSortField(String sortField) {
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
	public TaskVO setSortType(String sortType) {
		this.sortType=sortType;
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
	public TaskVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public TaskVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	
	/**
	 * 获得 处理人账户ID清单<br>
	 * 处理人账户ID清单
	 * @return 处理人账户ID清单
	*/
	public List<String> getApprovalUserIds() {
		return approvalUserIds;
	}
	
	/**
	 * 设置 处理人账户ID清单
	 * @param approvalUserIds 处理人账户ID清单
	 * @return 当前对象
	*/
	public TaskVO setApprovalUserIds(List<String> approvalUserIds) {
		this.approvalUserIds=approvalUserIds;
		return this;
	}
	
	/**
	 * 添加 处理人账户ID清单
	 * @param approvalUserId 处理人账户ID清单
	 * @return 当前对象
	*/
	public TaskVO addApprovalUserId(String... approvalUserId) {
		if(this.approvalUserIds==null) approvalUserIds=new ArrayList<>();
		this.approvalUserIds.addAll(Arrays.asList(approvalUserId));
		return this;
	}
	
	/**
	 * 获得 是否我的任务<br>
	 * 是否我的任务
	 * @return 是否我的任务
	*/
	public Boolean isMine() {
		return mine;
	}
	
	/**
	 * 获得 是否我的任务<br>
	 * 等价于 isMine 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否我的任务
	 * @return 是否我的任务
	*/
	public Boolean getMine() {
		return this.mine;
	}
	
	/**
	 * 设置 是否我的任务
	 * @param mine 是否我的任务
	 * @return 当前对象
	*/
	public TaskVO setMine(Boolean mine) {
		this.mine=mine;
		return this;
	}
	
	/**
	 * 获得 状态值清单<br>
	 * 设定状态值的查询范围
	 * @return 状态值清单
	*/
	public List<String> getStatusRange() {
		return statusRange;
	}
	
	/**
	 * 设置 状态值清单
	 * @param statusRange 状态值清单
	 * @return 当前对象
	*/
	public TaskVO setStatusRange(List<String> statusRange) {
		this.statusRange=statusRange;
		return this;
	}
	
	/**
	 * 添加 状态值清单
	 * @param entity 状态值清单
	 * @return 当前对象
	*/
	public TaskVO addStatusRange(String... entity) {
		if(this.statusRange==null) statusRange=new ArrayList<>();
		this.statusRange.addAll(Arrays.asList(entity));
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
	 * @return TaskVO , 转换好的 TaskVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TaskVO , 转换好的 PoJo 对象
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
	public TaskVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public TaskVO duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.TaskVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.TaskVOMeta.$$proxy$$();
		inst.setNodeName(this.getNodeName());
		inst.setProcessDefinitionId(this.getProcessDefinitionId());
		inst.setProcessInstanceId(this.getProcessInstanceId());
		inst.setApprovalTime(this.getApprovalTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setCamundaTaskId(this.getCamundaTaskId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setStatusReason(this.getStatusReason());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setCamundaAssignee(this.getCamundaAssignee());
		inst.setNodeId(this.getNodeId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setMine(this.isMine());
			inst.setSearchField(this.getSearchField());
			inst.setProcessDefinition(this.getProcessDefinition());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setProcessInstance(this.getProcessInstance());
			inst.setAssignees(this.getAssignees());
			inst.setPageSize(this.getPageSize());
			inst.setStatusRange(this.getStatusRange());
			inst.setNode(this.getNode());
			inst.setAssigneeUsers(this.getAssigneeUsers());
			inst.setReaders(this.getReaders());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setApprovals(this.getApprovals());
			inst.setApprovalUserIds(this.getApprovalUserIds());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setIds(this.getIds());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TaskVO clone(boolean deep) {
		return EntityContext.clone(TaskVO.class,this,deep);
	}

	/**
	 * 将 Pojo 转换成 TaskVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TaskVO , 转换好的的 Task 对象
	*/
	@Transient
	public static TaskVO createFrom(Object pojo) {
		if(pojo==null) return null;
		TaskVO po = EntityContext.create(TaskVO.class,pojo);
		return po;
	}

	/**
	 * 创建一个 TaskVO，等同于 new
	 * @return TaskVO 对象
	*/
	@Transient
	public static TaskVO create() {
		return EntityContext.create(TaskVO.class);
	}
}