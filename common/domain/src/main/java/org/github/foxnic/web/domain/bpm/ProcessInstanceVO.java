package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import org.github.foxnic.web.constants.enums.bpm.ApprovalCatalog;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.ArrayList;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.api.model.CompositeParameter;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;
import org.github.foxnic.web.domain.bpm.meta.ProcessInstanceVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程实例VO类型
 * <p>流程实例 , 数据表 bpm_process_instance 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-16 13:08:20
 * @sign C670531B153A1573AE592950BF5EA6AC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "流程实例VO类型 ; 流程实例 , 数据表 bpm_process_instance 的通用VO类型" , parent = ProcessInstance.class)
public class ProcessInstanceVO extends ProcessInstance {

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
	 * 已审批人ID清单：查询已审批人ID清单
	*/
	@ApiModelProperty(required = false,value="已审批人ID清单" , notes = "查询已审批人ID清单")
	private List<String> approvedUserIds;
	
	/**
	 * 待审批人ID清单：查询待审批人ID清单
	*/
	@ApiModelProperty(required = false,value="待审批人ID清单" , notes = "查询待审批人ID清单")
	private List<String> approvingUserIds;
	
	/**
	 * 是否我的流程：是否我的流程
	*/
	@ApiModelProperty(required = false,value="是否我的流程" , notes = "是否我的流程")
	private Boolean mine;
	
	/**
	 * 流程审批分类：流程审批分类
	*/
	@ApiModelProperty(required = false,value="流程审批分类" , notes = "流程审批分类")
	private String approvalCatalog;
	@Transient
	@EnumFor("approvalCatalog")
	private ApprovalCatalog approvalCatalogEnum;
	
	/**
	 * 是否强制删除：是否强制删除
	*/
	@ApiModelProperty(required = false,value="是否强制删除" , notes = "是否强制删除")
	private Boolean force;
	
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
	public ProcessInstanceVO setPageIndex(Integer pageIndex) {
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
	public ProcessInstanceVO setPageSize(Integer pageSize) {
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
	public ProcessInstanceVO setSearchField(String searchField) {
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
	public ProcessInstanceVO setFuzzyField(String fuzzyField) {
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
	public ProcessInstanceVO setSearchValue(String searchValue) {
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
	public ProcessInstanceVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public ProcessInstanceVO addDirtyField(String... dirtyField) {
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
	public ProcessInstanceVO setSortField(String sortField) {
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
	public ProcessInstanceVO setSortType(String sortType) {
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
	public ProcessInstanceVO setDataOrigin(String dataOrigin) {
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
	public ProcessInstanceVO setQueryLogic(String queryLogic) {
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
	public ProcessInstanceVO setRequestAction(String requestAction) {
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
	public ProcessInstanceVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public ProcessInstanceVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	
	/**
	 * 获得 已审批人ID清单<br>
	 * 查询已审批人ID清单
	 * @return 已审批人ID清单
	*/
	public List<String> getApprovedUserIds() {
		return approvedUserIds;
	}
	
	/**
	 * 设置 已审批人ID清单
	 * @param approvedUserIds 已审批人ID清单
	 * @return 当前对象
	*/
	public ProcessInstanceVO setApprovedUserIds(List<String> approvedUserIds) {
		this.approvedUserIds=approvedUserIds;
		return this;
	}
	
	/**
	 * 添加 已审批人ID清单
	 * @param approvedUserId 已审批人ID清单
	 * @return 当前对象
	*/
	public ProcessInstanceVO addApprovedUserId(String... approvedUserId) {
		if(this.approvedUserIds==null) approvedUserIds=new ArrayList<>();
		this.approvedUserIds.addAll(Arrays.asList(approvedUserId));
		return this;
	}
	
	/**
	 * 获得 待审批人ID清单<br>
	 * 查询待审批人ID清单
	 * @return 待审批人ID清单
	*/
	public List<String> getApprovingUserIds() {
		return approvingUserIds;
	}
	
	/**
	 * 设置 待审批人ID清单
	 * @param approvingUserIds 待审批人ID清单
	 * @return 当前对象
	*/
	public ProcessInstanceVO setApprovingUserIds(List<String> approvingUserIds) {
		this.approvingUserIds=approvingUserIds;
		return this;
	}
	
	/**
	 * 添加 待审批人ID清单
	 * @param approvingUserId 待审批人ID清单
	 * @return 当前对象
	*/
	public ProcessInstanceVO addApprovingUserId(String... approvingUserId) {
		if(this.approvingUserIds==null) approvingUserIds=new ArrayList<>();
		this.approvingUserIds.addAll(Arrays.asList(approvingUserId));
		return this;
	}
	
	/**
	 * 获得 是否我的流程<br>
	 * 是否我的流程
	 * @return 是否我的流程
	*/
	public Boolean isMine() {
		return mine;
	}
	
	/**
	 * 获得 是否我的流程<br>
	 * 等价于 isMine 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否我的流程
	 * @return 是否我的流程
	*/
	public Boolean getMine() {
		return this.mine;
	}
	
	/**
	 * 设置 是否我的流程
	 * @param mine 是否我的流程
	 * @return 当前对象
	*/
	public ProcessInstanceVO setMine(Boolean mine) {
		this.mine=mine;
		return this;
	}
	
	/**
	 * 获得 流程审批分类<br>
	 * 流程审批分类
	 * @return 流程审批分类
	*/
	public String getApprovalCatalog() {
		return approvalCatalog;
	}
	
	/**
	 * 获得 流程审批分类 的投影属性<br>
	 * 等价于 getApprovalCatalog 方法，获得对应的枚举类型
	 * @return 流程审批分类
	*/
	@Transient
	public ApprovalCatalog getApprovalCatalogEnum() {
		if(this.approvalCatalogEnum==null) {
			this.approvalCatalogEnum = (ApprovalCatalog) EnumUtil.parseByCode(ApprovalCatalog.values(),approvalCatalog);
		}
		return this.approvalCatalogEnum ;
	}
	
	/**
	 * 设置 流程审批分类
	 * @param approvalCatalog 流程审批分类
	 * @return 当前对象
	*/
	@JsonProperty("approvalCatalog")
	public ProcessInstanceVO setApprovalCatalog(String approvalCatalog) {
		this.approvalCatalog=approvalCatalog;
		this.approvalCatalogEnum= (ApprovalCatalog) EnumUtil.parseByCode(ApprovalCatalog.values(),approvalCatalog) ;
		if(StringUtil.hasContent(approvalCatalog) && this.approvalCatalogEnum==null) {
			throw new IllegalArgumentException( approvalCatalog + " is not one of ApprovalCatalog");
		}
		return this;
	}
	
	/**
	 * 设置 流程审批分类的投影属性，等同于设置 流程审批分类
	 * @param approvalCatalogEnum 流程审批分类
	 * @return 当前对象
	*/
	@Transient
	public ProcessInstanceVO setApprovalCatalogEnum(ApprovalCatalog approvalCatalogEnum) {
		if(approvalCatalogEnum==null) {
			this.setApprovalCatalog(null);
		} else {
			this.setApprovalCatalog(approvalCatalogEnum.code());
		}
		this.approvalCatalogEnum=approvalCatalogEnum;
		return this;
	}
	
	/**
	 * 获得 是否强制删除<br>
	 * 是否强制删除
	 * @return 是否强制删除
	*/
	public Boolean isForce() {
		return force;
	}
	
	/**
	 * 获得 是否强制删除<br>
	 * 等价于 isForce 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否强制删除
	 * @return 是否强制删除
	*/
	public Boolean getForce() {
		return this.force;
	}
	
	/**
	 * 设置 是否强制删除
	 * @param force 是否强制删除
	 * @return 当前对象
	*/
	public ProcessInstanceVO setForce(Boolean force) {
		this.force=force;
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
	 * @return ProcessInstanceVO , 转换好的 ProcessInstanceVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessInstanceVO , 转换好的 PoJo 对象
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
	public ProcessInstanceVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ProcessInstanceVO duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.ProcessInstanceVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.ProcessInstanceVOMeta.$$proxy$$();
		inst.setSyncTime(this.getSyncTime());
		inst.setNeedSync(this.getNeedSync());
		inst.setFormInstanceId(this.getFormInstanceId());
		inst.setTitle(this.getTitle());
		inst.setDrafterUserId(this.getDrafterUserId());
		inst.setCommitTime(this.getCommitTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDrafterId(this.getDrafterId());
		inst.setFormDefinitionId(this.getFormDefinitionId());
		inst.setId(this.getId());
		inst.setApprovalStatus(this.getApprovalStatus());
		inst.setProcessDefinitionId(this.getProcessDefinitionId());
		inst.setAbandonTime(this.getAbandonTime());
		inst.setDrafterType(this.getDrafterType());
		inst.setAbandonUserId(this.getAbandonUserId());
		inst.setProcessDefinitionFileId(this.getProcessDefinitionFileId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setPriority(this.getPriority());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setComment(this.getComment());
		inst.setCamundaInstanceId(this.getCamundaInstanceId());
		inst.setEndTime(this.getEndTime());
		inst.setLatestAppralTime(this.getLatestAppralTime());
		if(all) {
			inst.setBillIds(this.getBillIds());
			inst.setFormInstance(this.getFormInstance());
			inst.setAttachments(this.getAttachments());
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setApprovalStatusName(this.getApprovalStatusName());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setUserTasks(this.getUserTasks());
			inst.setBills(this.getBills());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setTaskApprovals(this.getTaskApprovals());
			inst.setTasks(this.getTasks());
			inst.setMine(this.isMine());
			inst.setTodoTasks(this.getTodoTasks());
			inst.setRequestAction(this.getRequestAction());
			inst.setProcessDefinition(this.getProcessDefinition());
			inst.setApprovingUserIds(this.getApprovingUserIds());
			inst.setDrafter(this.getDrafter());
			inst.setApprovedUserIds(this.getApprovedUserIds());
			inst.setDrafterUser(this.getDrafterUser());
			inst.setFormDefinition(this.getFormDefinition());
			inst.setAttachmentFileIds(this.getAttachmentFileIds());
			inst.setApprovalCatalog(this.getApprovalCatalog());
			inst.setReaders(this.getReaders());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setIds(this.getIds());
			inst.setProcessDefinitionFile(this.getProcessDefinitionFile());
			inst.setForce(this.isForce());
			inst.setSearchValue(this.getSearchValue());
			inst.setDrafterName(this.getDrafterName());
			inst.setErrors(this.getErrors());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessInstanceVO clone(boolean deep) {
		return EntityContext.clone(ProcessInstanceVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ProcessInstanceVO
	 * @param processInstanceMap 包含实体信息的 Map 对象
	 * @return ProcessInstanceVO , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessInstanceVO createFrom(Map<String,Object> processInstanceMap) {
		if(processInstanceMap==null) return null;
		ProcessInstanceVO vo = create();
		EntityContext.copyProperties(vo,processInstanceMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 ProcessInstanceVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessInstanceVO , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessInstanceVO createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessInstanceVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 ProcessInstanceVO，等同于 new
	 * @return ProcessInstanceVO 对象
	*/
	@Transient
	public static ProcessInstanceVO create() {
		return new org.github.foxnic.web.domain.bpm.meta.ProcessInstanceVOMeta.$$proxy$$();
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
			this.setSyncTime(DataParser.parse(Date.class, map.get(ProcessInstanceVOMeta.SYNC_TIME)));
			this.setNeedSync(DataParser.parse(Integer.class, map.get(ProcessInstanceVOMeta.NEED_SYNC)));
			this.setFormInstanceId(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.FORM_INSTANCE_ID)));
			this.setTitle(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.TITLE)));
			this.setDrafterUserId(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.DRAFTER_USER_ID)));
			this.setCommitTime(DataParser.parse(Date.class, map.get(ProcessInstanceVOMeta.COMMIT_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.UPDATE_BY)));
			this.setDrafterId(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.DRAFTER_ID)));
			this.setFormDefinitionId(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.FORM_DEFINITION_ID)));
			this.setId(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.ID)));
			this.setApprovalStatus(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.APPROVAL_STATUS)));
			this.setProcessDefinitionId(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.PROCESS_DEFINITION_ID)));
			this.setAbandonTime(DataParser.parse(Date.class, map.get(ProcessInstanceVOMeta.ABANDON_TIME)));
			this.setDrafterType(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.DRAFTER_TYPE)));
			this.setAbandonUserId(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.ABANDON_USER_ID)));
			this.setProcessDefinitionFileId(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.PROCESS_DEFINITION_FILE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProcessInstanceVOMeta.UPDATE_TIME)));
			this.setPriority(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.PRIORITY)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProcessInstanceVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProcessInstanceVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProcessInstanceVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProcessInstanceVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.DELETE_BY)));
			this.setComment(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.COMMENT)));
			this.setCamundaInstanceId(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.CAMUNDA_INSTANCE_ID)));
			this.setEndTime(DataParser.parse(Date.class, map.get(ProcessInstanceVOMeta.END_TIME)));
			this.setLatestAppralTime(DataParser.parse(Date.class, map.get(ProcessInstanceVOMeta.LATEST_APPRAL_TIME)));
			// others
			this.setFormInstance(DataParser.parse(FormInstance.class, map.get(ProcessInstanceVOMeta.FORM_INSTANCE)));
			this.setSearchField(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(ProcessInstanceVOMeta.PAGE_SIZE)));
			this.setApprovalStatusName(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.APPROVAL_STATUS_NAME)));
			this.setSortField(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.QUERY_LOGIC)));
			this.setMine(DataParser.parse(Boolean.class, map.get(ProcessInstanceVOMeta.MINE)));
			this.setRequestAction(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.REQUEST_ACTION)));
			this.setProcessDefinition(DataParser.parse(ProcessDefinition.class, map.get(ProcessInstanceVOMeta.PROCESS_DEFINITION)));
			this.setDrafter(DataParser.parse(Assignee.class, map.get(ProcessInstanceVOMeta.DRAFTER)));
			this.setDrafterUser(DataParser.parse(User.class, map.get(ProcessInstanceVOMeta.DRAFTER_USER)));
			this.setFormDefinition(DataParser.parse(FormDefinition.class, map.get(ProcessInstanceVOMeta.FORM_DEFINITION)));
			this.setApprovalCatalog(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.APPROVAL_CATALOG)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(ProcessInstanceVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.SORT_TYPE)));
			this.setProcessDefinitionFile(DataParser.parse(ProcessDefinitionFile.class, map.get(ProcessInstanceVOMeta.PROCESS_DEFINITION_FILE)));
			this.setForce(DataParser.parse(Boolean.class, map.get(ProcessInstanceVOMeta.FORCE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.SEARCH_VALUE)));
			this.setDrafterName(DataParser.parse(String.class, map.get(ProcessInstanceVOMeta.DRAFTER_NAME)));
			return true;
		} else {
			try {
				this.setSyncTime( (Date)map.get(ProcessInstanceVOMeta.SYNC_TIME));
				this.setNeedSync( (Integer)map.get(ProcessInstanceVOMeta.NEED_SYNC));
				this.setFormInstanceId( (String)map.get(ProcessInstanceVOMeta.FORM_INSTANCE_ID));
				this.setTitle( (String)map.get(ProcessInstanceVOMeta.TITLE));
				this.setDrafterUserId( (String)map.get(ProcessInstanceVOMeta.DRAFTER_USER_ID));
				this.setCommitTime( (Date)map.get(ProcessInstanceVOMeta.COMMIT_TIME));
				this.setUpdateBy( (String)map.get(ProcessInstanceVOMeta.UPDATE_BY));
				this.setDrafterId( (String)map.get(ProcessInstanceVOMeta.DRAFTER_ID));
				this.setFormDefinitionId( (String)map.get(ProcessInstanceVOMeta.FORM_DEFINITION_ID));
				this.setId( (String)map.get(ProcessInstanceVOMeta.ID));
				this.setApprovalStatus( (String)map.get(ProcessInstanceVOMeta.APPROVAL_STATUS));
				this.setProcessDefinitionId( (String)map.get(ProcessInstanceVOMeta.PROCESS_DEFINITION_ID));
				this.setAbandonTime( (Date)map.get(ProcessInstanceVOMeta.ABANDON_TIME));
				this.setDrafterType( (String)map.get(ProcessInstanceVOMeta.DRAFTER_TYPE));
				this.setAbandonUserId( (String)map.get(ProcessInstanceVOMeta.ABANDON_USER_ID));
				this.setProcessDefinitionFileId( (String)map.get(ProcessInstanceVOMeta.PROCESS_DEFINITION_FILE_ID));
				this.setUpdateTime( (Date)map.get(ProcessInstanceVOMeta.UPDATE_TIME));
				this.setPriority( (String)map.get(ProcessInstanceVOMeta.PRIORITY));
				this.setVersion( (Integer)map.get(ProcessInstanceVOMeta.VERSION));
				this.setCreateBy( (String)map.get(ProcessInstanceVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProcessInstanceVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProcessInstanceVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(ProcessInstanceVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(ProcessInstanceVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ProcessInstanceVOMeta.DELETE_BY));
				this.setComment( (String)map.get(ProcessInstanceVOMeta.COMMENT));
				this.setCamundaInstanceId( (String)map.get(ProcessInstanceVOMeta.CAMUNDA_INSTANCE_ID));
				this.setEndTime( (Date)map.get(ProcessInstanceVOMeta.END_TIME));
				this.setLatestAppralTime( (Date)map.get(ProcessInstanceVOMeta.LATEST_APPRAL_TIME));
				// others
				this.setFormInstance( (FormInstance)map.get(ProcessInstanceVOMeta.FORM_INSTANCE));
				this.setSearchField( (String)map.get(ProcessInstanceVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(ProcessInstanceVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(ProcessInstanceVOMeta.PAGE_SIZE));
				this.setApprovalStatusName( (String)map.get(ProcessInstanceVOMeta.APPROVAL_STATUS_NAME));
				this.setSortField( (String)map.get(ProcessInstanceVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(ProcessInstanceVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(ProcessInstanceVOMeta.QUERY_LOGIC));
				this.setMine( (Boolean)map.get(ProcessInstanceVOMeta.MINE));
				this.setRequestAction( (String)map.get(ProcessInstanceVOMeta.REQUEST_ACTION));
				this.setProcessDefinition( (ProcessDefinition)map.get(ProcessInstanceVOMeta.PROCESS_DEFINITION));
				this.setDrafter( (Assignee)map.get(ProcessInstanceVOMeta.DRAFTER));
				this.setDrafterUser( (User)map.get(ProcessInstanceVOMeta.DRAFTER_USER));
				this.setFormDefinition( (FormDefinition)map.get(ProcessInstanceVOMeta.FORM_DEFINITION));
				this.setApprovalCatalog( (String)map.get(ProcessInstanceVOMeta.APPROVAL_CATALOG));
				this.setPageIndex( (Integer)map.get(ProcessInstanceVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(ProcessInstanceVOMeta.SORT_TYPE));
				this.setProcessDefinitionFile( (ProcessDefinitionFile)map.get(ProcessInstanceVOMeta.PROCESS_DEFINITION_FILE));
				this.setForce( (Boolean)map.get(ProcessInstanceVOMeta.FORCE));
				this.setSearchValue( (String)map.get(ProcessInstanceVOMeta.SEARCH_VALUE));
				this.setDrafterName( (String)map.get(ProcessInstanceVOMeta.DRAFTER_NAME));
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
			this.setSyncTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceVOMeta.SYNC_TIME)));
			this.setNeedSync(DataParser.parse(Integer.class, r.getValue(ProcessInstanceVOMeta.NEED_SYNC)));
			this.setFormInstanceId(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.FORM_INSTANCE_ID)));
			this.setTitle(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.TITLE)));
			this.setDrafterUserId(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.DRAFTER_USER_ID)));
			this.setCommitTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceVOMeta.COMMIT_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.UPDATE_BY)));
			this.setDrafterId(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.DRAFTER_ID)));
			this.setFormDefinitionId(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.FORM_DEFINITION_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.ID)));
			this.setApprovalStatus(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.APPROVAL_STATUS)));
			this.setProcessDefinitionId(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.PROCESS_DEFINITION_ID)));
			this.setAbandonTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceVOMeta.ABANDON_TIME)));
			this.setDrafterType(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.DRAFTER_TYPE)));
			this.setAbandonUserId(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.ABANDON_USER_ID)));
			this.setProcessDefinitionFileId(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.PROCESS_DEFINITION_FILE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceVOMeta.UPDATE_TIME)));
			this.setPriority(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.PRIORITY)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProcessInstanceVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProcessInstanceVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.DELETE_BY)));
			this.setComment(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.COMMENT)));
			this.setCamundaInstanceId(DataParser.parse(String.class, r.getValue(ProcessInstanceVOMeta.CAMUNDA_INSTANCE_ID)));
			this.setEndTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceVOMeta.END_TIME)));
			this.setLatestAppralTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceVOMeta.LATEST_APPRAL_TIME)));
			return true;
		} else {
			try {
				this.setSyncTime( (Date)r.getValue(ProcessInstanceVOMeta.SYNC_TIME));
				this.setNeedSync( (Integer)r.getValue(ProcessInstanceVOMeta.NEED_SYNC));
				this.setFormInstanceId( (String)r.getValue(ProcessInstanceVOMeta.FORM_INSTANCE_ID));
				this.setTitle( (String)r.getValue(ProcessInstanceVOMeta.TITLE));
				this.setDrafterUserId( (String)r.getValue(ProcessInstanceVOMeta.DRAFTER_USER_ID));
				this.setCommitTime( (Date)r.getValue(ProcessInstanceVOMeta.COMMIT_TIME));
				this.setUpdateBy( (String)r.getValue(ProcessInstanceVOMeta.UPDATE_BY));
				this.setDrafterId( (String)r.getValue(ProcessInstanceVOMeta.DRAFTER_ID));
				this.setFormDefinitionId( (String)r.getValue(ProcessInstanceVOMeta.FORM_DEFINITION_ID));
				this.setId( (String)r.getValue(ProcessInstanceVOMeta.ID));
				this.setApprovalStatus( (String)r.getValue(ProcessInstanceVOMeta.APPROVAL_STATUS));
				this.setProcessDefinitionId( (String)r.getValue(ProcessInstanceVOMeta.PROCESS_DEFINITION_ID));
				this.setAbandonTime( (Date)r.getValue(ProcessInstanceVOMeta.ABANDON_TIME));
				this.setDrafterType( (String)r.getValue(ProcessInstanceVOMeta.DRAFTER_TYPE));
				this.setAbandonUserId( (String)r.getValue(ProcessInstanceVOMeta.ABANDON_USER_ID));
				this.setProcessDefinitionFileId( (String)r.getValue(ProcessInstanceVOMeta.PROCESS_DEFINITION_FILE_ID));
				this.setUpdateTime( (Date)r.getValue(ProcessInstanceVOMeta.UPDATE_TIME));
				this.setPriority( (String)r.getValue(ProcessInstanceVOMeta.PRIORITY));
				this.setVersion( (Integer)r.getValue(ProcessInstanceVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ProcessInstanceVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProcessInstanceVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProcessInstanceVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(ProcessInstanceVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(ProcessInstanceVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ProcessInstanceVOMeta.DELETE_BY));
				this.setComment( (String)r.getValue(ProcessInstanceVOMeta.COMMENT));
				this.setCamundaInstanceId( (String)r.getValue(ProcessInstanceVOMeta.CAMUNDA_INSTANCE_ID));
				this.setEndTime( (Date)r.getValue(ProcessInstanceVOMeta.END_TIME));
				this.setLatestAppralTime( (Date)r.getValue(ProcessInstanceVOMeta.LATEST_APPRAL_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}