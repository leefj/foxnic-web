package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import org.github.foxnic.web.constants.enums.bpm.ApprovalCatalog;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.api.model.CompositeParameter;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;



/**
 * 流程实例
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:56
 * @sign D3D98A46718B6A44CB5BEF086B167D5A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

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
	private ApprovalCatalog approvalCatalogEnum;
	
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
		if(all) {
			inst.setBillIds(this.getBillIds());
			inst.setFormInstance(this.getFormInstance());
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setApprovalStatusName(this.getApprovalStatusName());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setUserTasks(this.getUserTasks());
			inst.setBills(this.getBills());
			inst.setTaskApprovals(this.getTaskApprovals());
			inst.setTasks(this.getTasks());
			inst.setMine(this.isMine());
			inst.setTodoTasks(this.getTodoTasks());
			inst.setProcessDefinition(this.getProcessDefinition());
			inst.setApprovingUserIds(this.getApprovingUserIds());
			inst.setDrafter(this.getDrafter());
			inst.setApprovedUserIds(this.getApprovedUserIds());
			inst.setDrafterUser(this.getDrafterUser());
			inst.setFormDefinition(this.getFormDefinition());
			inst.setApprovalCatalog(this.getApprovalCatalog());
			inst.setReaders(this.getReaders());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setIds(this.getIds());
			inst.setProcessDefinitionFile(this.getProcessDefinitionFile());
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
	 * 将 Pojo 转换成 ProcessInstanceVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessInstanceVO , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessInstanceVO createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessInstanceVO po = EntityContext.create(ProcessInstanceVO.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ProcessInstanceVO，等同于 new
	 * @return ProcessInstanceVO 对象
	*/
	@Transient
	public static ProcessInstanceVO create() {
		return EntityContext.create(ProcessInstanceVO.class);
	}
}